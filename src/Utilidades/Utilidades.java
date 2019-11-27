/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import Modelo.Contrato;
import Modelo.Falta;
import Modelo.Historial;
import Modelo.Incidencia;
import Modelo.Nominas;
import Modelo.Permiso;
import Modelo.Usuario;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Vistas.Principal.Login_vista;
import Vistas.Principal.Principal_vista;
import Vistas.Principal.Configuracion.Usuarios_vista;
import Vistas.Archivos.Trabajadores.Incidencias_vista;
import java.sql.Statement;

/**
 * Esta clase contiene todos los métodos/funciones que se van a utilizar en el programa, se intenta que todos los métodos/funciones sean lo mas generales posibles para poder utilizarlos entre las diferentes clases y objetos creados de dichas clases.
 *
 * @author Ismael Valle Martínez
 */
public class Utilidades {

    public static Conexion conn;
    public static SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yy");
    public static ArrayList<Permiso> lista_de_permisos = new ArrayList<Permiso>();
    public static ArrayList<Contrato> lista_de_contratos = new ArrayList<Contrato>();
    public static ArrayList<Usuario> lista_de_usuarios = new ArrayList<Usuario>();
    public static ArrayList<Incidencia> lista_de_incidencias = new ArrayList<Incidencia>();
    public static ArrayList<Falta> lista_de_faltas = new ArrayList<Falta>();
    public static ArrayList<Nominas> lista_de_nominas = new ArrayList<Nominas>();
    public static ArrayList<Historial> lista_de_horas_trabajadas = new ArrayList<Historial>();
    public static Usuario usuario = null;
    public static String empresa;

    public void cerrar_ventana_actual(Frame ventana) {
        ventana.dispose();
    }

    public void abrir_nueva_ventana(Frame ventana) {
        ventana.setVisible(true);
    }

    public String actualizarHoraUltimaSesionUsuario(int id, DateFormat fechaHora) {
        Date ultima_sesion = new Date();
        PreparedStatement ps = null;
        conn = new Conexion();
        String sql_actualizar_ultima_sesion = "UPDATE usuarios SET ultima_sesion=? WHERE id=?";
        Connection conexion = conn.conectar_db_empresas();
        if (conexion != null) {
            try {
                ps = conexion.prepareStatement(sql_actualizar_ultima_sesion);
                ps.setString(1, fechaHora.format(ultima_sesion)); //entramos en el parametro NUMERO 1 que es la ultima sesion ; la ultima hora y minutos y segundos en este mismo momento.
                ps.setInt(2, id);
                ps.execute();
                conn.desconectar(conexion);
            } catch (SQLException ex) {
                Logger.getLogger(Login_vista.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return fechaHora.format(ultima_sesion);
    }

    public boolean loguearse(String nombre_usuario, String password_usuario, JComboBox<String> combo_empresas) {
        conn = new Conexion();
        int id_usuario = -1;
        int id_empresa = -1;
        String nombre = null;
        String password = null;
        int id_rol = -1;
        Date ultima_sesion = null;
        DateFormat formatoFechaHora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fechaHora = "0";
        password_usuario = encriptaEnMD5(password_usuario);
        empresa = combo_empresas.getItemAt(combo_empresas.getSelectedIndex());
        String consulta_empresa = "SELECT id FROM empresas WHERE nombre=?";
        String consulta = "SELECT * FROM usuarios WHERE nombre=?";
        boolean tiene_permiso_de_acceso = false;

        if (!nombre_usuario.equals("") && !password_usuario.equals("")) {
            PreparedStatement ps = null;
            ResultSet rs = null;
            ResultSet rs2 = null;
            Connection conexion = conn.conectar_db_empresas();

            if (conexion != null) {
                try {
                    ps = conexion.prepareStatement(consulta);
                    ps.setString(1, nombre_usuario);
                    rs = ps.executeQuery();
                    if (rs.next()) { //SI ENTRA SIGNIFICA QUE EL USUARIO EXISTE Y PASAREMOS A COMPROBAR SI LA CONTRASEÑA INTRODUCIDA ES IGUAL QUE LA DEL USUARIO REGISTRADO EN LA BBDD
                        password = rs.getString("password");
                        if (!password.equals(password_usuario)) {
                            JOptionPane.showMessageDialog(null, "Contraseña introducida incorrecta.");
                        } else {//SI ENTRA SIGNIFICA QUE EL USUARIO TIENE USUARIO Y CONTRASEÑA VALIDOS Y PASAREMOS A COMPROBAR SI TIENE PERMISOS PARA ENTRAR EN LA EMPRESA SELECCIONADA
                            ps = conexion.prepareStatement(consulta_empresa);
                            ps.setString(1, empresa);
                            rs2 = ps.executeQuery();

                            if (rs2.next()) { //SI ENTRA SIGNIFICA QUE LA EMPRESA ELEGIDA EN EL COMBO EXISTE Y SACA EL ID
                                id_empresa = rs2.getInt("id");
                                id_usuario = rs.getInt("id");
                                nombre = rs.getString("nombre");
                                id_rol = rs.getInt("id_rol");

                                tiene_permiso_de_acceso = consultarPermisos(id_usuario, id_empresa, ps, rs, conexion, tiene_permiso_de_acceso);

                                if (tiene_permiso_de_acceso) {
                                    fechaHora = actualizarHoraUltimaSesionUsuario(id_usuario, formatoFechaHora);
                                    usuario = new Usuario();
                                    usuario.setId(id_usuario);
                                    usuario.setNombre(nombre);
                                    usuario.setPassword(password);
                                    usuario.setId_rol(id_rol);
                                    usuario.setUltima_sesion(fechaHora);
                                    conn.desconectar(conexion);
                                    Principal_vista principal = new Principal_vista(); //ventana Principal
                                    abrir_nueva_ventana(principal);
                                    return true;
                                } else {
                                    JOptionPane.showMessageDialog(null, "No tienes permiso para acceder a la empresa seleccionada.");
                                    return false;
                                }

                            } else {
                                JOptionPane.showMessageDialog(null, "LA EMPRESA ELEGIDA EN EL COMBO NO EXISTE EN LA BBDD.");
                                return false;
                            }

                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario introducido incorrecto.");
                        return false;
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(Login_vista.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {

            JOptionPane.showMessageDialog(null, "Usuario y Contraseña no deben estar vacíos.");
            return false;
        }
        return false;
    }

    public void elegirImagenEmpresaCombo(JComboBox<String> combo_empresas, JLabel imagen) {
        String path;
        URL url;
        ImageIcon icon;
        switch (combo_empresas.getItemAt(combo_empresas.getSelectedIndex())) {
            case "Tersum":
                path = "/img/logo-tersum.png";
                url = this.getClass().getResource(path);
                icon = new ImageIcon(url);
                imagen.setIcon(icon);
                break;
            case "Aurum":
                path = "/img/logo-aurum.png";
                url = this.getClass().getResource(path);
                icon = new ImageIcon(url);
                imagen.setIcon(icon);
                break;
            case "Cleaning Consultores":
                path = "/img/logo-cleaning.png";
                url = this.getClass().getResource(path);
                icon = new ImageIcon(url);
                imagen.setIcon(icon);
                break;

        }
    }

    public boolean consultarPermisos(int id_usuario, int id_empresa, PreparedStatement ps, ResultSet rs, Connection conexion, boolean tiene_permiso_de_acceso) {
        String consulta = "SELECT id,id_permiso,activo FROM permisos_usuarios WHERE id_usuario=? and id_empresa=?";
        boolean activo;
        try {
            ps = conexion.prepareStatement(consulta);
            ps.setInt(1, id_usuario);
            ps.setInt(2, id_empresa);
            rs = ps.executeQuery();

            while (rs.next()) {

                if (rs.getInt("id_permiso") == 1 && rs.getBoolean("activo")) { // EL ID=1 SIGNIFICA QUE TIENE EL PERMISO DE ACCESO_EMPRESA Y EL ACTIVO SIGNIFICA QUE EL PERMISO ESTA ACTIVO, ES DECIR PUEDE ACCEDER A LA EMPRESA
                    tiene_permiso_de_acceso = true;
                }
                activo = rs.getBoolean("activo");
                Permiso permiso = new Permiso(rs.getInt("id"), rs.getInt("id_permiso"), id_empresa, id_usuario, activo);
                lista_de_permisos.add(permiso);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tiene_permiso_de_acceso;
    }

    public void rellenarTabla(JTable tabla, String nombre_tabla, String clausula) {
        String consulta = "SELECT * FROM " + nombre_tabla + " " + clausula;
        DefaultTableModel dtm = (DefaultTableModel) tabla.getModel();
        Object[] columnas = new Object[dtm.getColumnCount()];
        Connection conexion;
        conn = new Conexion();
        PreparedStatement ps;
        ResultSet rs;
        if (nombre_tabla.equals("usuarios") || nombre_tabla.equals("permisos")) {
            conexion = conn.conectar_db_empresas();
        } else {
            conexion = conn.conectar_empresa_concreta(this.empresa);
        }
        if (conexion != null) {
            switch (nombre_tabla) {
                case "contratos":
                    lista_de_contratos.clear();
                    consulta = consulta + " ORDER BY codigo_trabajador";
                    try {
                        ps = conexion.prepareStatement(consulta);
                        rs = ps.executeQuery();
                        dtm.setRowCount(0);
                        while (rs.next()) {

                            columnas[0] = rs.getInt("id");
                            columnas[1] = rs.getInt("codigo_tipo_contrato");
                            columnas[2] = rs.getInt("codigo_trabajador");
                            columnas[3] = formato.format(rs.getDate("fechainicio"));
                            columnas[4] = formato.format(rs.getDate("fechafin"));
                            if (rs.getBoolean("situacion")) {
                                columnas[5] = "Alta";
                            } else {
                                columnas[5] = "Baja";
                            }

                            dtm.addRow(columnas);//AQUI AÑADIMOS LAS DIFERENTES FILAS A LA TABLA.

                        }
                        rellenarLista(nombre_tabla, ""); //METODO PARA RELLENAR LA LISTA DE CONTRATOS EN ESTE CASO
                        tabla.setModel(dtm);
                        conn.desconectar(conexion);
                    } catch (SQLException ex) {
                        Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;

                case "incidencias":
                    lista_de_incidencias.clear();
                    try {
                        ps = conexion.prepareStatement(consulta);
                        rs = ps.executeQuery();
                        dtm.setRowCount(0);

                        while (rs.next()) {
                            columnas[0] = rs.getInt("id");
                            columnas[1] = rs.getString("codigo");
                            columnas[2] = rs.getDate("fecha_inicio");
                            columnas[3] = rs.getInt("extras");
                            dtm.addRow(columnas);
                        }
                        rellenarLista(nombre_tabla, "");
                        tabla.setModel(dtm);
                        conn.desconectar(conexion);

                    } catch (SQLException ex) {
                    }

                    break;

                case "usuarios":
                    consulta = consulta + " ORDER BY nombre";
                    try {
                        ps = conexion.prepareStatement(consulta);
                        rs = ps.executeQuery();
                        dtm.setRowCount(0);
                        while (rs.next()) {
                            columnas[0] = rs.getInt("id");
                            columnas[1] = rs.getString("nombre");
                            String nombre_rol = sacarNombreRol(rs.getInt("id_rol"));
                            columnas[2] = nombre_rol;
                            dtm.addRow(columnas);//AQUI AÑADIMOS LAS DIFERENTES FILAS A LA TABLA.
                            rellenarLista(nombre_tabla, "");
                        }
                        tabla.setModel(dtm);
                        conn.desconectar(conexion);
                    } catch (SQLException ex) {
                        Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case "":
                    break;
            }

        }

    }

    public void addBbdd(String tabla, Object o) throws SQLException {
        String insert = "";
        Connection conexion;
        conn = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        java.sql.Date sqlDate = null;
        if (tabla.equals("usuarios") || tabla.equals("permisos")) {
            conexion = conn.conectar_db_empresas();
        } else {
            conexion = conn.conectar_empresa_concreta(this.empresa);
        }

        if (conexion != null) {

            switch (tabla) {

                case "contratos":
                    Contrato contrato = (Contrato) o;
                    insert = "INSERT INTO contratos (id,codigo_tipo_contrato,codigo_trabajador,fechainicio,fechafin,horas,situacion,asegurado)"
                            + " VALUES(NULL, ?, ?, ?, ?, ?, ?, ?)";
                    ps = conexion.prepareStatement(insert);
                    ps.setInt(1, contrato.getCodigo_tipo_contrato());
                    ps.setInt(2, contrato.getCodigo_trabajador());
                    java.sql.Date fechainicio = new java.sql.Date(contrato.getFechainicio().getTime());
                    ps.setDate(3, fechainicio);
                    java.sql.Date fechafin = new java.sql.Date(contrato.getFechafin().getTime());
                    ps.setDate(4, fechafin);
                    ps.setDouble(5, contrato.getHoras());
                    ps.setBoolean(6, contrato.isSituacion());
                    ps.setBoolean(7, contrato.isAsegurado());
                    break;
                case "faltas":
                    Falta falta = (Falta) o;
                    insert = "INSERT INTO faltas (id,codigo, codigo_trabajador_faltas, fecha_inicio, fecha_fin, motivo) VALUES (NULL,?, ?, ?, ?, ?)";
                    ps = conexion.prepareStatement(insert);
                    ps.setString(1, falta.getCodigo());
                    ps.setString(2, falta.getCodigo_trabajador());
                    sqlDate = new java.sql.Date(falta.getFecha_inicio().getTime());
                    ps.setDate(3, sqlDate);
                    if (falta.getFecha_fin() != null) {
                        sqlDate = new java.sql.Date(falta.getFecha_fin().getTime());
                    } else {
                        sqlDate = null;
                    }
                    ps.setDate(4, sqlDate);
                    ps.setString(5, falta.getMotivo());
                    break;

                case "incidencias":
                    Incidencia incidencia = (Incidencia) o;
                    insert = "INSERT INTO incidencias (id,codigo,codigo_trabajador, descripcion, fecha_inicio,fecha_fin,extras) VALUES (NULL, ?, ?, ?, ?, ?, ?)";
                    ps = conexion.prepareStatement(insert);
                    ps.setString(1, incidencia.getCodigo());
                    ps.setString(2, incidencia.getCodigo_trabajador());
                    ps.setString(3, incidencia.getDescripcion());
                    sqlDate = new java.sql.Date(incidencia.getFecha_inicio().getTime());
                    ps.setDate(4, sqlDate);
                    sqlDate = new java.sql.Date(incidencia.getFecha_fin().getTime());
                    ps.setDate(5, sqlDate);
                    ps.setInt(6, incidencia.getExtras());
                    break;
                case "vacaciones":
                /*Vacaciones vacaciones = (Vacaciones) o;
                    insert = "INSERT INTO vacaciones (id,codigo_trabajador,fecha_inicio,fecha_fin)"
                            + " VALUES(NULL, ?, ?, ?)";
                    ps = conexion.prepareStatement(insert);
                    ps.setInt(1, vacaciones.getCodigo_trabajador());
                    fechainicio = new java.sql.Date(vacaciones.getFechainicio().getTime());
                    ps.setDate(2, fechainicio);
                    fechafin = new java.sql.Date(vacaciones.getFechafin().getTime());
                    ps.setDate(3, fechafin);
                    break;*/

                case "nominas":
                    Nominas nominas = (Nominas) o;
                    insert = "INSERT INTO nominas (id,codigo_trabajador,fecha_inicio,fecha_fin,importe,activo)"
                            + " VALUES(NULL, ?, ?, ?, ?, ?)";
                    ps = conexion.prepareStatement(insert);
                    ps.setInt(1, nominas.getCodigo_trabajador());
                    fechainicio = new java.sql.Date(nominas.getFecha_inicio().getTime());
                    ps.setDate(2, fechainicio);
                    if (nominas.getFecha_fin() == null) {
                        fechafin = null;
                    } else {
                        fechafin = new java.sql.Date(nominas.getFecha_fin().getTime());
                    }

                    ps.setDate(3, fechafin);
                    ps.setDouble(4, nominas.getImporte());
                    ps.setBoolean(5, nominas.isActivo());
                    break;

                case "horastrabajadas":
                /*Historial horastrabajadas = (Historial) o;
                    insert = "INSERT INTO horastrabajadas (id, codigo_trabajador, dia, hora_inicio, hora_fin, codigo_cliente, codigo_centro, fila, columna, horas_totales) "
                            + "VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    ps = conexion.prepareStatement(insert);
                    ps.setInt(1, horastrabajadas.getCodigo_trabajador());
                    ps.setString(2, horastrabajadas.getDia());
                    ps.setString(3, horastrabajadas.getHora_inicio());
                    ps.setString(4, horastrabajadas.getHora_fin());
                    ps.setString(5, horastrabajadas.getCif());
                    ps.setInt(6, horastrabajadas.getCodigo_centro());
                    ps.setInt(7, horastrabajadas.getFila());
                    ps.setInt(8, horastrabajadas.getColumna());
                    ps.setInt(9, horastrabajadas.getHoras_totales());
                    break;*/

                case "usuarios":
                    Usuario usuario = (Usuario) o;
                    insert = "INSERT INTO usuarios (id,nombre,password,id_rol,ultima_sesion)"
                            + " VALUES(NULL, ?, ?, ?, NULL)";
                    ps = conexion.prepareStatement(insert);
                    ps.setString(1, usuario.getNombre());
                    ps.setString(2, usuario.getPassword());
                    ps.setInt(3, usuario.getId_rol());
                    break;

                case "otro":
                    break;

            }
            try {
                ps.executeUpdate();//AQUI SE EJECUTA LA ACTUALIZACION DE LA BBDD
                conn.desconectar(conexion);
            } catch (SQLException ex) {
                Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void deleteBbdd(String tabla, String id) throws SQLException {
        String delete = "";
        Connection conexion;
        conn = new Conexion();
        PreparedStatement ps = null;
        if (tabla.equals("usuarios") || tabla.equals("permisos")) {
            conexion = conn.conectar_db_empresas();
        } else {

            conexion = conn.conectar_empresa_concreta(this.empresa);
        }
        if (conexion != null) {
            switch (tabla) {

                case "contratos":
                    delete = "DELETE FROM contratos WHERE id=?";
                    ps = conexion.prepareStatement(delete);
                    ps.setString(1, id);
                    break;

                case "usuarios":
                    delete = "DELETE FROM usuarios WHERE id=?";
                    ps = conexion.prepareStatement(delete);
                    ps.setString(1, id);
                    break;

                case "permisos":
                    delete = "DELETE FROM permisos_usuarios WHERE id_usuario=?";
                    ps = conexion.prepareStatement(delete);
                    ps.setString(1, id);
                    break;

                case "vacaciones":
                    delete = "DELETE FROM vacaciones where id=?";
                    ps = conexion.prepareStatement(delete);
                    ps.setString(1, id);
                    break;

            }
            try {
                ps.executeUpdate();//AQUI SE EJECUTA LA ACTUALIZACION DE LA BBDD
                conn.desconectar(conexion);
            } catch (SQLException ex) {
                Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void updatebbdd(String tabla, Object o, int id) throws SQLException {
        String update = "";
        PreparedStatement ps = null;
        Connection conexion;
        conn = new Conexion();
        java.sql.Date sqlDate = null;
        if (tabla.equals("usuarios") || tabla.equals("permisos")) {
            conexion = conn.conectar_db_empresas();
        } else {

            conexion = conn.conectar_empresa_concreta(this.empresa);
        }

        if (conexion != null) {

            switch (tabla) {

                case "contratos":
                    Contrato contrato = (Contrato) o;
                    update = "UPDATE contratos SET codigo_tipo_contrato=?, codigo_trabajador=?, fechainicio=?, fechafin=?, horas=?, situacion=?, asegurado=? WHERE id=?";
                    ps = conexion.prepareStatement(update);
                    ps.setInt(1, contrato.getCodigo_tipo_contrato());
                    ps.setInt(2, contrato.getCodigo_trabajador());
                    java.sql.Date fechainicio = new java.sql.Date(contrato.getFechainicio().getTime());
                    ps.setDate(3, fechainicio);
                    java.sql.Date fechafin = new java.sql.Date(contrato.getFechafin().getTime());
                    ps.setDate(4, fechafin);
                    ps.setDouble(5, contrato.getHoras());
                    ps.setBoolean(6, contrato.isSituacion());
                    ps.setBoolean(7, contrato.isAsegurado());
                    ps.setInt(8, id);
                    break;

                case "usuarios":
                    Usuario usuario = (Usuario) o;
                    if (usuario.getNombre() != null) { //SI EL USUARIO ES DIFERENTE DE NULL ES DECIR QUE NO ESTE VACIO SIGNIFICA QUE LO QUE VAMOS A UPDATEAR VA A SER EL NOMBRE DE USUARIO
                        update = "UPDATE usuarios SET nombre=? WHERE id=?";
                        ps = conexion.prepareStatement(update);
                        ps.setString(1, usuario.getNombre());
                    } else if (usuario.getPassword() != null) { //
                        update = "UPDATE usuarios SET password=? WHERE id=?";
                        ps = conexion.prepareStatement(update);
                        ps.setString(1, usuario.getPassword());
                    } else {
                        update = "UPDATE usuarios SET id_rol=? WHERE id=?";
                        ps = conexion.prepareStatement(update);
                        ps.setInt(1, usuario.getId_rol());
                    }
                    ps.setInt(2, id);
                    break;

                case "vacaciones":
                    /*Vacaciones vacaciones = (Vacaciones) o;
                    update = "UPDATE vacaciones SET codigo_trabajador=?, fecha_inicio=?, fecha_fin=? where id=?";
                    ps = conexion.prepareStatement(update);
                    ps.setInt(1, vacaciones.getCodigo_trabajador());
                    fechainicio = new java.sql.Date(vacaciones.getFechainicio().getTime());
                    ps.setDate(2, fechainicio);
                    fechafin = new java.sql.Date(vacaciones.getFechafin().getTime());
                    ps.setDate(3, fechafin);
                    ps.setInt(4, id);*/
                    break;

                case "nominas":
                    Nominas nominas = (Nominas) o;
                    update = "UPDATE nominas SET codigo_trabajador=?, fecha_inicio=?, fecha_fin=?, importe=?, activo=? where id=?";
                    ps = conexion.prepareStatement(update);
                    ps.setInt(1, nominas.getCodigo_trabajador());
                    fechainicio = new java.sql.Date(nominas.getFecha_inicio().getTime());
                    ps.setDate(2, fechainicio);
                    fechafin = new java.sql.Date(nominas.getFecha_fin().getTime());
                    ps.setDate(3, fechafin);
                    ps.setDouble(4, nominas.getImporte());
                    ps.setBoolean(5, nominas.isActivo());
                    ps.setInt(6, id);
                    break;

            }
            try {
                ps.executeUpdate();//AQUI SE EJECUTA LA ACTUALIZACION DE LA BBDD
                conn.desconectar(conexion);
            } catch (SQLException ex) {
                Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public boolean validarCampoNumerico(KeyEvent evt) {

        char validar = evt.getKeyChar();
        if (Character.isLetter(validar)) {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Solo se aceptan numeros.");
            return true;
        }
        return false;
    }

    public boolean comprobarCampoNumerico(KeyEvent evt) {
        char validar = evt.getKeyChar();
        if (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE || Character.isDigit(validar)) {
            return true;
        }
        return false;
    }

    public boolean validarCampoTexto(KeyEvent evt) {
        char validar = evt.getKeyChar();
        if (Character.isDigit(validar)) {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Solo se aceptan letras.");
            return true;
        }
        return false;
    }

    public boolean validarCampoDecimal(KeyEvent evt) {
        char validar = evt.getKeyChar();
        String cadena = String.valueOf(validar);
        if (cadena.equals(",")) {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "No se aceptan comas, para representar decimales utilice el punto.");
            return true;
        }
        return false;
    }

    public void buscaryRellenarTabla(KeyEvent evt, String cadena, JTable tabla, String nombre_tabla) {
        DefaultTableModel dtm = (DefaultTableModel) tabla.getModel();
        Object[] datos = new Object[dtm.getColumnCount()];
        switch (nombre_tabla) {
            /*case "contratos":
                if (comprobarCampoNumerico(evt)) {

                    for (int j = 0; j < lista_de_contratos.size(); j++) {
                        if (String.valueOf(lista_de_contratos.get(j).getCodigo_tipo_contrato()).contains(cadena)) {
                            datos[0] = lista_de_contratos.get(j).getId();
                            datos[1] = lista_de_contratos.get(j).getCodigo_tipo_contrato();
                            datos[2] = lista_de_contratos.get(j).getCodigo_trabajador();
                            datos[3] = formato.format(lista_de_contratos.get(j).getFechainicio());
                            datos[4] = formato.format(lista_de_contratos.get(j).getFechafin());
                            if (lista_de_contratos.get(j).isSituacion()) {
                                datos[5] = "Alta";
                            } else {
                                datos[5] = "Baja";
                            }
                            dtm.addRow(datos);
                        }
                    }

                } else {

                    if (cadena.indexOf(" ") > 0) {//SI ENTRA AQUI SIGNIFICA QUE HAY APELLIDOS EN EL BUSCADOR
                        String[] partes = cadena.split(" ");
                        nombre = partes[0]; // nombre
                        //AQUI HAY QUE COMPROBAR CUANTAS PARTES TRAE LA CADENA PORQUE NO SABEMOS SI SOLO TRAE EL NOMBRE O TAMBIEN EL APELLIDO1 O LOS DOS APELLIDOS
                        if (partes.length > 2) {
                            apellido1 = partes[1]; // apellido 1 
                            apellido2 = partes[2];//apellido 2
                            for (int i = 0; i < lista_de_trabajadores.size(); i++) {
                                if (lista_de_trabajadores.get(i).getNombre().contains(nombre) && lista_de_trabajadores.get(i).getApellido1().contains(apellido1) && lista_de_trabajadores.get(i).getApellido2().contains(apellido2)) {
                                    for (int j = 0; j < lista_de_contratos.size(); j++) {
                                        //if (lista_de_trabajadores.get(i).getCodigo() == lista_de_contratos.get(j).getCodigo_trabajador()) {
                                        datos[0] = lista_de_contratos.get(j).getId();
                                        datos[1] = lista_de_contratos.get(j).getCodigo_tipo_contrato();
                                        datos[2] = lista_de_contratos.get(j).getCodigo_trabajador();
                                        datos[3] = formato.format(lista_de_contratos.get(j).getFechainicio());
                                        datos[4] = formato.format(lista_de_contratos.get(j).getFechafin());
                                        if (lista_de_contratos.get(j).isSituacion()) {
                                            datos[5] = "Alta";
                                        } else {
                                            datos[5] = "Baja";
                                        }
                                        dtm.addRow(datos);
                                        //}
                                    }
                                }
                            }
                        } else if (partes.length > 1) {
                            apellido1 = partes[1]; // apellido 1 
                            for (int i = 0; i < lista_de_trabajadores.size(); i++) {
                                if (lista_de_trabajadores.get(i).getNombre().contains(nombre) && lista_de_trabajadores.get(i).getApellido1().contains(apellido1)) {
                                    for (int j = 0; j < lista_de_contratos.size(); j++) {
                                        //if (lista_de_trabajadores.get(i).getCodigo() == lista_de_contratos.get(j).getCodigo_trabajador()) {
                                        datos[0] = lista_de_contratos.get(j).getId();
                                        datos[1] = lista_de_contratos.get(j).getCodigo_tipo_contrato();
                                        datos[2] = lista_de_contratos.get(j).getCodigo_trabajador();
                                        datos[3] = formato.format(lista_de_contratos.get(j).getFechainicio());
                                        datos[4] = formato.format(lista_de_contratos.get(j).getFechafin());
                                        if (lista_de_contratos.get(j).isSituacion()) {
                                            datos[5] = "Alta";
                                        } else {
                                            datos[5] = "Baja";
                                        }
                                        dtm.addRow(datos);
                                        //}
                                    }
                                    //} else if (lista_de_trabajadores.get(i).getApellido1().contains(nombre) && lista_de_trabajadores.get(i).getApellido2().contains(apellido1)) {
                                    for (int j = 0; j < lista_de_contratos.size(); j++) {
                                        //if (lista_de_trabajadores.get(i).getCodigo() == lista_de_contratos.get(j).getCodigo_trabajador()) {
                                        datos[0] = lista_de_contratos.get(j).getId();
                                        datos[1] = lista_de_contratos.get(j).getCodigo_tipo_contrato();
                                        datos[2] = lista_de_contratos.get(j).getCodigo_trabajador();
                                        datos[3] = formato.format(lista_de_contratos.get(j).getFechainicio());
                                        datos[4] = formato.format(lista_de_contratos.get(j).getFechafin());
                                        if (lista_de_contratos.get(j).isSituacion()) {
                                            datos[5] = "Alta";
                                        } else {
                                            datos[5] = "Baja";
                                        }
                                        dtm.addRow(datos);
                                    }
                                }
                            }
                        }
                    }
                }
                else {//SI NO, ES QUE NO HAY APELLIDOS EN EL BUSCADOR
                        for (int i = 0; i < lista_de_trabajadores.size(); i++) {
                            if (lista_de_trabajadores.get(i).getNombre().contains(cadena) || lista_de_trabajadores.get(i).getApellido1().contains(cadena) || lista_de_trabajadores.get(i).getApellido2().contains(cadena)) {
                                for (int j = 0; j < lista_de_contratos.size(); j++) {
                                    if (lista_de_trabajadores.get(i).getCodigo() == lista_de_contratos.get(j).getCodigo_trabajador()) {
                                        datos[0] = lista_de_contratos.get(j).getId();
                                        datos[1] = lista_de_contratos.get(j).getCodigo_tipo_contrato();
                                        datos[2] = lista_de_contratos.get(j).getCodigo_trabajador();
                                        datos[3] = formato.format(lista_de_contratos.get(j).getFechainicio());
                                        datos[4] = formato.format(lista_de_contratos.get(j).getFechafin());
                                        if (lista_de_contratos.get(j).isSituacion()) {
                                            datos[5] = "Alta";
                                        } else {
                                            datos[5] = "Baja";
                                        }
                                        dtm.addRow(datos);
                                    }
                                }

                            }
                        }
                    }
        }

        tabla.setModel(dtm);
        break;*/
            case "faltas":
                for (int i = 0; i < lista_de_faltas.size(); i++) {
                    if (lista_de_faltas.get(i).getMotivo().contains(cadena)) {
                        datos[0] = lista_de_faltas.get(i).getId();
                        datos[1] = lista_de_faltas.get(i).getCodigo();
                        datos[2] = lista_de_faltas.get(i).getMotivo();
                        dtm.addRow(datos);
                    }
                }
                tabla.setModel(dtm);
                break;
        }

    }

    public void rellenarLista(String nombrelista, String sentencia) {
        String consulta = "SELECT * FROM " + nombrelista + " " + sentencia;
        Connection conexion;
        conn = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;

        if (nombrelista.equals("usuarios") || nombrelista.equals("permisos")) {
            conexion = conn.conectar_db_empresas();
        } else {

            conexion = conn.conectar_empresa_concreta(this.empresa);
        }
        switch (nombrelista) {

            case "contratos":

                try {
                    ps = conexion.prepareStatement(consulta);
                    rs = ps.executeQuery();

                    while (rs.next()) {
                        Contrato contrato = new Contrato();
                        contrato.setId(rs.getInt("id"));
                        contrato.setCodigo_tipo_contrato(rs.getInt("codigo_tipo_contrato"));
                        contrato.setCodigo_trabajador(rs.getInt("codigo_trabajador"));
                        contrato.setFechainicio(rs.getDate("fechainicio"));
                        contrato.setFechafin(rs.getDate("fechafin"));
                        contrato.setHoras(rs.getDouble("horas"));
                        contrato.setSituacion(rs.getBoolean("situacion"));
                        contrato.setAsegurado(rs.getBoolean("asegurado"));

                        lista_de_contratos.add(contrato);
                    }

                    conn.desconectar(conexion);

                } catch (SQLException ex) {
                    Logger.getLogger(Utilidades.class
                            .getName()).log(Level.SEVERE, null, ex);
                }

                break;

            case "vacaciones":
                /*consulta = consulta + " ORDER BY codigo_trabajador";

                try {
                    ps = conexion.prepareStatement(consulta);
                    rs = ps.executeQuery();

                    while (rs.next()) {
                        Vacaciones vacaciones = new Vacaciones();
                        vacaciones.setId(rs.getInt("id"));
                        vacaciones.setCodigo_trabajador(rs.getInt("codigo_trabajador"));
                        vacaciones.setFechainicio(rs.getDate("fecha_inicio"));
                        vacaciones.setFechafin(rs.getDate("fecha_fin"));

                        this.lista_de_vacaciones.add(vacaciones);
                    }

                    conn.desconectar(conexion);

                } catch (SQLException ex) {
                    Logger.getLogger(Utilidades.class
                            .getName()).log(Level.SEVERE, null, ex);
                }*/
                break;
            case "nominas":
                consulta = consulta + " ORDER BY codigo_trabajador";

                try {
                    ps = conexion.prepareStatement(consulta);
                    rs = ps.executeQuery();

                    while (rs.next()) {
                        Nominas nominas = new Nominas();
                        nominas.setId(rs.getInt("id"));
                        nominas.setCodigo_trabajador(rs.getInt("codigo_trabajador"));
                        nominas.setFecha_inicio(rs.getDate("fecha_inicio"));
                        nominas.setFecha_fin(rs.getDate("fecha_fin"));
                        nominas.setImporte(rs.getDouble("importe"));
                        nominas.setActivo(rs.getBoolean("activo"));
                        lista_de_nominas.add(nominas);
                    }

                    conn.desconectar(conexion);

                } catch (SQLException ex) {
                    Logger.getLogger(Utilidades.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case "usuarios":
                try {
                    ps = conexion.prepareStatement(consulta);
                    rs = ps.executeQuery();

                    while (rs.next()) {
                        Usuario usuario = new Usuario();
                        usuario.setId(rs.getInt("id"));
                        usuario.setNombre(rs.getString("nombre"));
                        usuario.setId_rol(rs.getInt("id_rol"));

                        lista_de_usuarios.add(usuario);
                    }

                    conn.desconectar(conexion);

                } catch (SQLException ex) {
                    Logger.getLogger(Utilidades.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case "horastrabajadas":
                /*try {
                    ps = conexion.prepareStatement(consulta);
                    rs = ps.executeQuery();

                    while (rs.next()) {

                        Historial horastrabajadas = new Historial();
                        horastrabajadas.setId(rs.getInt("id"));
                        horastrabajadas.setCodigo_trabajador(rs.getInt("codigo_trabajador"));
                        horastrabajadas.setDia(rs.getString("dia"));
                        horastrabajadas.setHora_inicio(rs.getString("hora_inicio"));
                        horastrabajadas.setHora_fin(rs.getString("hora_fin"));
                        horastrabajadas.setCif(rs.getString("cif"));
                        horastrabajadas.setCodigo_centro(rs.getInt("codigo_centro"));
                        horastrabajadas.setFila(rs.getInt("fila"));
                        horastrabajadas.setColumna(rs.getInt("columna"));
                        horastrabajadas.setHoras_totales(rs.getInt("horas_totales"));
                        lista_de_horas_trabajadas.add(horastrabajadas);
                    }

                    conn.desconectar(conexion);

                } catch (SQLException ex) {
                    Logger.getLogger(Utilidades.class
                            .getName()).log(Level.SEVERE, null, ex);
                }*/
                break;
        }
    }

    private static final char[] CONSTS_HEX = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String encriptaEnMD5(String stringAEncriptar) {
        try {
            MessageDigest msgd = MessageDigest.getInstance("MD5");
            byte[] bytes = msgd.digest(stringAEncriptar.getBytes());
            StringBuilder strbCadenaMD5 = new StringBuilder(2 * bytes.length);
            for (int i = 0; i < bytes.length; i++) {
                int bajo = (int) (bytes[i] & 0x0f);
                int alto = (int) ((bytes[i] & 0xf0) >> 4);
                strbCadenaMD5.append(CONSTS_HEX[alto]);
                strbCadenaMD5.append(CONSTS_HEX[bajo]);
            }
            return strbCadenaMD5.toString();
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    public boolean addPermisos(String nombre, String nombre_rol) throws SQLException {
        conn = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conexion = conn.conectar_db_empresas();
        int id_empresa = -1;
        int id_usuario = -1;

        String consulta = "SELECT id FROM empresas WHERE nombre=?";
        ps = conexion.prepareStatement(consulta);
        ps.setString(1, this.empresa);
        rs = ps.executeQuery();

        if (rs.next()) {
            id_empresa = rs.getInt("id");
        }
        consulta = "SELECT * FROM usuarios where nombre=?";
        ps = conexion.prepareStatement(consulta);
        ps.setString(1, nombre);
        rs = ps.executeQuery();

        if (rs.next()) {
            id_usuario = rs.getInt("id");
        }

        if (id_empresa != -1 || id_usuario != -1) {
            String consulta_count = "SELECT COUNT(*) FROM lista_permisos";
            int num_permisos = -1;
            ps = conexion.prepareStatement(consulta_count);
            rs = ps.executeQuery();
            if (rs.next()) {
                num_permisos = rs.getInt("count(*)");
            }

            for (int i = 1; i <= num_permisos; i++) {
                String insert = "INSERT INTO permisos_usuarios (id, id_permiso, id_empresa, id_usuario,activo) VALUES (NULL,?,?,?,?)";
                ps = conexion.prepareStatement(insert);
                ps.setInt(1, i);
                ps.setInt(2, id_empresa);
                ps.setInt(3, id_usuario);
                if (nombre_rol.equals("administrador")) {
                    ps.setBoolean(4, true);
                } else if (nombre_rol.equals("encargado") && i == 1) { //AQUI LO QUE HACEMOS ES AÑADIRLE EL PERMISO DE ACCESO (TRUE) A LOS NUEVOS USUARIOS QUE SON ENCARGADOS
                    ps.setBoolean(4, true);
                } else {
                    ps.setBoolean(4, false);
                }

                ps.executeUpdate();
            }

            return true;
        }
        return false;
    }

    public int sacarIdRol(String nombre_rol) {
        String consulta = "SELECT id FROM roles WHERE nombre=?";
        Conexion conn = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conexion = conn.conectar_db_empresas();
        if (conexion != null) {
            try {
                ps = conexion.prepareStatement(consulta);
                ps.setString(1, nombre_rol);
                rs = ps.executeQuery();

                if (rs.next()) {
                    return rs.getInt("id");

                }

            } catch (SQLException ex) {
                Logger.getLogger(Usuarios_vista.class
                        .getName()).log(Level.SEVERE, null, ex);
            }

        }
        return -1;
    }

    private String sacarNombreRol(int aInt) {
        String consulta = "SELECT nombre FROM roles WHERE id=?";
        Conexion conn = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conexion = conn.conectar_db_empresas();
        if (conexion != null) {
            try {
                ps = conexion.prepareStatement(consulta);
                ps.setInt(1, aInt);
                rs = ps.executeQuery();

                if (rs.next()) {
                    return rs.getString("nombre");

                }

            } catch (SQLException ex) {
                Logger.getLogger(Usuarios_vista.class
                        .getName()).log(Level.SEVERE, null, ex);
            }

        }
        return "";
    }

    public void updatePermisos(int id_usuario, String nombre_rol) {
        try {
            conn = new Conexion();
            PreparedStatement ps = null;
            ResultSet rs = null;
            Connection conexion = conn.conectar_db_empresas();
            String consulta_count = "SELECT COUNT(*) FROM lista_permisos";
            String update = "UPDATE permisos_usuarios SET activo = ? WHERE id_permiso = ? AND id_usuario=?";
            int num_permisos = -1;
            ps = conexion.prepareStatement(consulta_count);
            rs = ps.executeQuery();
            if (rs.next()) {
                num_permisos = rs.getInt("count(*)");
            }
            for (int i = 1; i <= num_permisos; i++) {
                ps = conexion.prepareStatement(update);

                if (nombre_rol.equals("administrador")) {
                    ps.setBoolean(1, true);
                } else if (nombre_rol.equals("encargado") && i == 1) { //AQUI LO QUE HACEMOS ES ACTUALIZARLE EL PERMISO DE ACCESO (TRUE) A LOS NUEVOS USUARIOS QUE SON ENCARGADOS
                    ps.setBoolean(1, true);
                } else {
                    ps.setBoolean(1, false);
                }
                ps.setInt(2, i);
                ps.setInt(3, id_usuario);
                ps.executeUpdate();

            }

        } catch (SQLException ex) {
            Logger.getLogger(Utilidades.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String comprobarNombrePermiso(Permiso permiso) {
        try {
            conn = new Conexion();
            PreparedStatement ps = null;
            ResultSet rs = null;
            Connection conexion = conn.conectar_db_empresas();
            String consulta = "SELECT * FROM lista_permisos WHERE id=?";
            ps = conexion.prepareStatement(consulta);
            ps.setInt(1, permiso.getId_permiso());
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("nombre");

            }
        } catch (SQLException ex) {
            Logger.getLogger(Utilidades.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        return "";
    }

    public String rellenarTipoContrato(int codigo_tipo_contrato) {
        try {
            conn = new Conexion();
            PreparedStatement ps = null;
            ResultSet rs = null;
            Connection conexion = conn.conectar_empresa_concreta(this.empresa);

            String consulta = "SELECT * FROM tipos_de_contrato WHERE codigo=?";
            ps = conexion.prepareStatement(consulta);
            ps.setInt(1, codigo_tipo_contrato);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("denominacion");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Utilidades.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        return "";
    }

    public void rellenarTablaDatosIndividuales(JTable tabla, String nombre_tabla, int id_trabajador) {

        String consulta = "SELECT * FROM " + nombre_tabla;

        DefaultTableModel dtm = (DefaultTableModel) tabla.getModel();
        Object[] datos = new Object[dtm.getColumnCount()];
        Connection conexion;
        conn = new Conexion();
        PreparedStatement ps;
        ResultSet rs;

        if (nombre_tabla.equals("usuarios") || nombre_tabla.equals("permisos")) {
            conexion = conn.conectar_db_empresas();
        } else {

            conexion = conn.conectar_empresa_concreta(this.empresa);
        }
        if (conexion != null) {
            switch (nombre_tabla) {
                case "vacaciones":
                    /*lista_de_vacaciones.clear();
                    consulta = consulta + " WHERE codigo_trabajador=" + id_trabajador + " ORDER BY fecha_inicio";
                    try {
                        ps = conexion.prepareStatement(consulta);
                        rs = ps.executeQuery();
                        dtm.setRowCount(0);
                        while (rs.next()) {
                            datos[0] = rs.getInt("id");
                            datos[1] = rs.getInt("codigo_trabajador");
                            datos[2] = formato.format(rs.getDate("fecha_inicio"));
                            datos[3] = formato.format(rs.getDate("fecha_fin"));

                            dtm.addRow(datos);//AQUI AÑADIMOS LAS DIFERENTES FILAS A LA TABLA.

                        }

                        rellenarLista(nombre_tabla, ""); //METODO PARA RELLENAR LA LISTA DE CONTRATOS EN ESTE CASO
                        tabla.setModel(dtm);
                        conn.desconectar(conexion);

                    } catch (SQLException ex) {
                        Logger.getLogger(Utilidades.class
                                .getName()).log(Level.SEVERE, null, ex);
                    }*/
                    break;

                case "nominas":
                    lista_de_nominas.clear();
                    consulta = consulta + " WHERE codigo_trabajador=" + id_trabajador;
                    try {
                        ps = conexion.prepareStatement(consulta);
                        rs = ps.executeQuery();
                        dtm.setRowCount(0);
                        while (rs.next()) {
                            datos[0] = rs.getInt("id");
                            datos[1] = rs.getInt("codigo_trabajador");
                            datos[2] = formato.format(rs.getDate("fecha_inicio"));
                            if (rs.getDate("fecha_fin") == null) {
                                datos[3] = "Sin fecha";
                            } else {
                                datos[3] = formato.format(rs.getDate("fecha_fin"));
                            }
                            datos[4] = rs.getDouble("importe");
                            dtm.addRow(datos);//AQUI AÑADIMOS LAS DIFERENTES FILAS A LA TABLA.
                        }
                        rellenarLista(nombre_tabla, ""); //METODO PARA RELLENAR LA LISTA DE CONTRATOS EN ESTE CASO
                        tabla.setModel(dtm);
                        conn.desconectar(conexion);

                    } catch (SQLException ex) {
                        Logger.getLogger(Utilidades.class
                                .getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
            }

        }

    }

    /* public boolean comprobarVacacionesRepetidas(int id_vacacion, int codigo_trabajador_seleccionado, Date fechainicio, Date fechafin) {
        Vacaciones vacaciones = new Vacaciones();
        if (id_vacacion == -1) { //SIGNIFICA QUE LO QUE SE VA A HACER ES AÑADIR
            for (int i = 0; i < lista_de_vacaciones.size(); i++) {
                vacaciones = lista_de_vacaciones.get(i);
                if (codigo_trabajador_seleccionado == vacaciones.getCodigo_trabajador()) {
                    if (fechainicio.compareTo(vacaciones.getFechainicio()) >= 0 && fechainicio.compareTo(vacaciones.getFechafin()) <= 0) {
                        JOptionPane.showMessageDialog(null, "La fecha de inicio escogida está repetida.");
                        return true;
                    }
                    if (fechafin.compareTo(vacaciones.getFechainicio()) >= 0 && fechafin.compareTo(vacaciones.getFechafin()) <= 0) {
                        JOptionPane.showMessageDialog(null, "La fecha de fin escogida está repetida.");
                        return true;
                    }
                    if (fechainicio.compareTo(vacaciones.getFechainicio()) <= 0 && fechafin.compareTo(vacaciones.getFechafin()) >= 0) {
                        JOptionPane.showMessageDialog(null, "Las fechas elegidas no se pueden escoger porque están repetidas o contienen las fechas de otras vacaciones.");
                        return true;
                    }
                }
            }
            return false;
        } else { //SIGNIFICA QUE LO QUE SE VA A HACER ES MODIFICAR UNAS VACACIONES EN CONCRETO Y EL METODO SE COMPORTA DE UNA MANERA DIFERENTE
            for (int i = 0; i < lista_de_vacaciones.size(); i++) {
                vacaciones = lista_de_vacaciones.get(i);
                if (codigo_trabajador_seleccionado == vacaciones.getCodigo_trabajador() && id_vacacion != vacaciones.getId()) { // EL CAMBIO ES AQUÍ, YA QUE CUANDO COMPRUEBO NO ES POR ID DE TRABAJADOR SI NO POR ID DE VACACION
                    if (fechainicio.compareTo(vacaciones.getFechainicio()) >= 0 && fechainicio.compareTo(vacaciones.getFechafin()) <= 0) {
                        JOptionPane.showMessageDialog(null, "La fecha de inicio escogida está repetida.");
                        return true;
                    }
                    if (fechafin.compareTo(vacaciones.getFechainicio()) >= 0 && fechafin.compareTo(vacaciones.getFechafin()) <= 0) {
                        JOptionPane.showMessageDialog(null, "La fecha de fin escogida está repetida.");
                        return true;
                    }
                    if (fechainicio.compareTo(vacaciones.getFechainicio()) <= 0 && fechafin.compareTo(vacaciones.getFechafin()) >= 0) {
                        JOptionPane.showMessageDialog(null, "Las fechas elegidas no se pueden escoger porque están repetidas o contienen las fechas de otras vacaciones.");
                        return true;
                    }
                }
            }
            return false;
        }
    }*/
    /**
     *
     * @param id_trabajador
     * @return
     */
    public boolean comprobarFechaUltimaNomina(int id_trabajador) {
        Nominas nominas = new Nominas();
        for (int i = 0; i < lista_de_nominas.size(); i++) {
            nominas = lista_de_nominas.get(i);
            if (nominas.getCodigo_trabajador() == id_trabajador) {
                if (nominas.isActivo() && nominas.getFecha_fin() == null) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @author ismael
     * @param id_trabajador
     */
    public void actualizarUltimaFechaActiva(int id_trabajador) {
        try {
            Date fechaHoy = new Date();
            fechaHoy = formato.parse(formato.format(fechaHoy));
            Nominas nominas = new Nominas();
            for (int i = 0; i < lista_de_nominas.size(); i++) {
                nominas = lista_de_nominas.get(i);
                if (nominas.getCodigo_trabajador() == id_trabajador) {
                    if (nominas.isActivo() && nominas.getFecha_fin() == null) {
                        try {
                            nominas.setActivo(false);
                            nominas.setFecha_fin(fechaHoy);
                            updatebbdd("nominas", nominas, nominas.getId());

                        } catch (SQLException ex) {
                            Logger.getLogger(Utilidades.class
                                    .getName()).log(Level.SEVERE, null, ex);

                        }
                    }
                }
            }
        } catch (ParseException ex) {
            Logger.getLogger(Utilidades.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    public boolean comprobarFechasRepetidas(String tabla, Object o) {
        switch (tabla) {
            case "vacaciones":
            /*Vacaciones vacaciones = (Vacaciones) o;
                Vacaciones vacacion_de_la_tabla = new Vacaciones();
                if (vacaciones.getId() == -1) { //SIGNIFICA QUE LO QUE SE VA A HACER ES AÑADIR
                    for (int i = 0; i < lista_de_vacaciones.size(); i++) {
                        vacaciones = lista_de_vacaciones.get(i);
                        if (vacaciones.getCodigo_trabajador() == vacacion_de_la_tabla.getCodigo_trabajador()) {
                            if (vacaciones.getFechainicio().compareTo(vacacion_de_la_tabla.getFechainicio()) >= 0 && vacaciones.getFechainicio().compareTo(vacacion_de_la_tabla.getFechafin()) <= 0) {
                                JOptionPane.showMessageDialog(null, "La fecha de inicio escogida está repetida.");
                                return true;
                            }
                            if (vacaciones.getFechafin().compareTo(vacacion_de_la_tabla.getFechainicio()) >= 0 && vacaciones.getFechafin().compareTo(vacacion_de_la_tabla.getFechafin()) <= 0) {
                                JOptionPane.showMessageDialog(null, "La fecha de fin escogida está repetida.");
                                return true;
                            }
                            if (vacaciones.getFechainicio().compareTo(vacacion_de_la_tabla.getFechainicio()) <= 0 && vacaciones.getFechafin().compareTo(vacacion_de_la_tabla.getFechafin()) >= 0) {
                                JOptionPane.showMessageDialog(null, "Las fechas elegidas no se pueden escoger porque están repetidas o contienen las fechas de otras vacaciones.");
                                return true;
                            }
                        }
                    }
                    return false;
                } else { //SIGNIFICA QUE LO QUE SE VA A HACER ES MODIFICAR UNAS VACACIONES EN CONCRETO Y EL METODO SE COMPORTA DE UNA MANERA DIFERENTE
                    for (int i = 0; i < lista_de_vacaciones.size(); i++) {
                        vacaciones = lista_de_vacaciones.get(i);
                        if (vacaciones.getCodigo_trabajador() == vacacion_de_la_tabla.getCodigo_trabajador() && vacaciones.getId() != vacacion_de_la_tabla.getId()) { // EL CAMBIO ES AQUÍ, YA QUE CUANDO COMPRUEBO NO ES POR ID DE TRABAJADOR SI NO POR ID DE VACACION
                            if (vacaciones.getFechainicio().compareTo(vacacion_de_la_tabla.getFechainicio()) >= 0 && vacaciones.getFechainicio().compareTo(vacacion_de_la_tabla.getFechafin()) <= 0) {
                                JOptionPane.showMessageDialog(null, "La fecha de inicio escogida está repetida.");
                                return true;
                            }
                            if (vacaciones.getFechafin().compareTo(vacacion_de_la_tabla.getFechainicio()) >= 0 && vacaciones.getFechafin().compareTo(vacacion_de_la_tabla.getFechafin()) <= 0) {
                                JOptionPane.showMessageDialog(null, "La fecha de fin escogida está repetida.");
                                return true;
                            }
                            if (vacaciones.getFechainicio().compareTo(vacacion_de_la_tabla.getFechainicio()) <= 0 && vacaciones.getFechafin().compareTo(vacacion_de_la_tabla.getFechafin()) >= 0) {
                                JOptionPane.showMessageDialog(null, "Las fechas elegidas no se pueden escoger porque están repetidas o contienen las fechas de otras vacaciones.");
                                return true;
                            }
                        }
                    }
                    return false;
                }*/

            case "nominas":
                Nominas nominas = (Nominas) o;
                Nominas nomina_de_la_lista = new Nominas();
                if (nominas.getId() == -1) { //SIGNIFICA QUE LO QUE SE VA A HACER ES AÑADIR
                    for (int i = 0; i < lista_de_nominas.size(); i++) {
                        nomina_de_la_lista = lista_de_nominas.get(i);
                        if (nominas.getCodigo_trabajador() == nomina_de_la_lista.getCodigo_trabajador()) {
                            if (nominas.getFecha_inicio().compareTo(nomina_de_la_lista.getFecha_inicio()) >= 0 && nominas.getFecha_inicio().compareTo(nomina_de_la_lista.getFecha_fin()) <= 0) {
                                JOptionPane.showMessageDialog(null, "La fecha de inicio escogida está repetida.");
                                return true;
                            }
                            if (nominas.getFecha_fin().compareTo(nomina_de_la_lista.getFecha_inicio()) >= 0 && nominas.getFecha_fin().compareTo(nomina_de_la_lista.getFecha_fin()) <= 0) {
                                JOptionPane.showMessageDialog(null, "La fecha de fin escogida está repetida.");
                                return true;
                            }
                            if (nominas.getFecha_inicio().compareTo(nomina_de_la_lista.getFecha_inicio()) <= 0 && nominas.getFecha_fin().compareTo(nomina_de_la_lista.getFecha_fin()) >= 0) {
                                JOptionPane.showMessageDialog(null, "Las fechas elegidas no se pueden escoger porque están repetidas o contienen las fechas de otras vacaciones.");
                                return true;
                            }
                        }
                    }
                    return false;
                } else { //SIGNIFICA QUE LO QUE SE VA A HACER ES MODIFICAR UNAS VACACIONES EN CONCRETO Y EL METODO SE COMPORTA DE UNA MANERA DIFERENTE

                    for (int i = 0; i < lista_de_nominas.size(); i++) {
                        nomina_de_la_lista = lista_de_nominas.get(i);
                        JOptionPane.showMessageDialog(null, "Nomina que viene por parametro:" + nominas.getId()
                                + "\nNomina que viene por lista:" + nomina_de_la_lista.getId());
                        if (nominas.getCodigo_trabajador() == nomina_de_la_lista.getCodigo_trabajador() && nominas.getId() != nomina_de_la_lista.getId()) { // EL CAMBIO ES AQUÍ, YA QUE CUANDO COMPRUEBO NO ES POR ID DE TRABAJADOR SI NO POR ID DE VACACION
                            JOptionPane.showMessageDialog(null, "Nomina que viene por parametro:" + nominas.toString()
                                    + "\nNomina que viene por lista:" + nomina_de_la_lista.toString());
                            if (nominas.getFecha_inicio().compareTo(nomina_de_la_lista.getFecha_inicio()) >= 0 && nominas.getFecha_inicio().compareTo(nomina_de_la_lista.getFecha_fin()) <= 0) {
                                JOptionPane.showMessageDialog(null, "La fecha de inicio escogida está repetida.");
                                return true;
                            }
                            if (nominas.getFecha_fin().compareTo(nomina_de_la_lista.getFecha_inicio()) >= 0 && nominas.getFecha_fin().compareTo(nomina_de_la_lista.getFecha_fin()) <= 0) {
                                JOptionPane.showMessageDialog(null, "La fecha de fin escogida está repetida.");
                                return true;
                            }
                            if (nominas.getFecha_inicio().compareTo(nomina_de_la_lista.getFecha_inicio()) <= 0 && nominas.getFecha_fin().compareTo(nomina_de_la_lista.getFecha_fin()) >= 0) {
                                JOptionPane.showMessageDialog(null, "Las fechas elegidas no se pueden escoger porque están repetidas o contienen las fechas de otras vacaciones.");
                                return true;
                            }
                        }
                    }
                    return false;
                }
        }
        return false;

    }

    /*public void rellenarTablaHorarios(JTable tabla, int codigo_trabajador) {
        String consulta = "SELECT * FROM horastrabajadas WHERE codigo_trabajador=" + codigo_trabajador;
        DefaultTableModel dtm = (DefaultTableModel) tabla.getModel();
        Connection conexion;
        conn = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        conexion = conn.conectar_empresa_concreta(this.empresa);
        Cliente cliente = new Cliente();
        Centro centro = new Centro();
        if (conexion != null) {
            lista_de_horas_trabajadas.clear();
            try {

                ps = conexion.prepareStatement(consulta);
                rs = ps.executeQuery();
                while (rs.next()) {

                    for (int i = 0; i < dtm.getColumnCount(); i++) {
                        if (tabla.getColumnName(i).equals(rs.getString("dia"))) {
                            for (int j = 0; j < dtm.getRowCount(); j++) {
                                if (dtm.getValueAt(j, 0).equals(rs.getString("hora_inicio"))) {
                                    cliente = getClienteByNombre(rs.getString("nombre"));
                                    //centro = getCentroByNombre(rs.getString("nombre"));
                                    int horas = rs.getInt("horas_totales");
                                    while (horas != -1) {
                                        tabla.setValueAt(cliente.getCif() + "/" + centro.getCodigo() + " " + centro.getNombre(), j + horas, i);//Aqui añadimos las horas correspondientes
                                        horas--;
                                    }
                                }
                            }
                        }
                    }
                }
                rellenarLista("horastrabajadas", ""); //METODO PARA RELLENAR LA LISTA DE TRABAJADORES EN ESTE CASO
                tabla.setModel(dtm);
                conn.desconectar(conexion);

            } catch (SQLException ex) {
                Logger.getLogger(Utilidades.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
    }*/
    public void borrarColumnaHorario(JTable tabla, int codigo_trabajador, String dia) {
        try {
            String consulta = "DELETE FROM horastrabajadas WHERE codigo_trabajador=" + codigo_trabajador + " && dia=" + "'" + dia + "'";
            DefaultTableModel dtm = (DefaultTableModel) tabla.getModel();
            for (int i = 0; i < dtm.getColumnCount(); i++) {
                if (tabla.getColumnName(i).equals(dia)) {
                    for (int j = 0; j < dtm.getRowCount(); j++) {
                        tabla.setValueAt(null, j, i);//Aqui borramos las horas correspondientes
                    }
                }
            }
            conn = new Conexion();
            Connection conexion = conn.conectar_empresa_concreta(this.empresa);
            Statement stmt = conexion.prepareStatement(consulta);
            int x = stmt.executeUpdate(consulta);

        } catch (SQLException ex) {
            Logger.getLogger(Utilidades.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static boolean isInteger(String numero) {
        try {
            Integer.parseInt(numero);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void rellenarTablaBusquedaFecha(JTable tabla, String nombreTabla, String buscar, String codigo) {
        String consulta = "SELECT * from " + nombreTabla;
        DefaultTableModel dtm = (DefaultTableModel) tabla.getModel();
        Object[] datos = new Object[dtm.getColumnCount()];
        conn = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conexion = conn.conectar_empresa_concreta("tersum");

        try {

            dtm.setRowCount(0);
            if (nombreTabla.equals("incidencias")) {
                consulta = consulta + " WHERE fecha LIKE '%" + buscar + "%' AND codigo_trabajador=" + codigo;
                ps = conexion.prepareStatement(consulta);
                rs = ps.executeQuery();
                while (rs.next()) {
                    datos[0] = rs.getInt("id");
                    datos[1] = rs.getInt("codigo");
                    datos[2] = rs.getDate("fecha");
                    datos[3] = rs.getInt("extras");
                    dtm.addRow(datos);
                }
            } else if (nombreTabla.equals("faltas")) {
                consulta = consulta + " WHERE (fecha_inicio LIKE '%" + buscar + "%' OR fecha_fin LIKE '%" + buscar + "%' ) AND codigo_trabajador=" + codigo;
                ps = conexion.prepareStatement(consulta);
                rs = ps.executeQuery();
                while (rs.next()) {
                    datos[0] = rs.getInt("id");
                    datos[1] = rs.getInt("codigo");
                    datos[2] = rs.getDate("fecha_inicio");
                    datos[3] = rs.getDate("fecha_fin");
                    dtm.addRow(datos);
                }
            }

            tabla.setModel(dtm);
            conn.desconectar(conexion);

        } catch (SQLException ex) {
            Logger.getLogger(Incidencias_vista.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {

        }
    }
}
