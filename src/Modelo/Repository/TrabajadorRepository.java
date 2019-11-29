/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Repository;

import static Modelo.Repository.UtilidadesRepository.*;
import Modelo.Entidades.Trabajador;
import Utilidades.Conexion;
import Utilidades.Utilidades;
import static Utilidades.Utilidades.conn;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DisenoWeb
 */
public class TrabajadorRepository {

    private final String nombreClase = TrabajadorRepository.class.getName();
    private static ArrayList<Trabajador> trabajadores;
    private final String TABLA = "trabajadores";
    private final String consultaTrabajadores = consultaPrincipal + TABLA + " ORDER BY apellido1 ";

    private final String ORDER = " ORDER BY apellido1 ASC ";

    public TrabajadorRepository() {
        TrabajadorRepository.trabajadores = new ArrayList<>();
        ejecutarConsulta(consultaTrabajadores);
    }

    public ArrayList<Trabajador> getTrabajadores() {
        return trabajadores;
    }

    public Trabajador getById(int id) {
        Trabajador t = null;
        for (int i = 0; i < trabajadores.size(); i++) {
            if (trabajadores.get(i).getId() == id) {
                t = trabajadores.get(i);
            }
        }
        return t;
    }

    public Trabajador getByNombre(String nombre) {
        Trabajador t = null;
        for (int i = 0; i < trabajadores.size(); i++) {
            if (trabajadores.get(i).getNombre().equals(nombre)) {
                t = trabajadores.get(i);
            }
        }
        return t;
    }

    public boolean ifCodigoExist(String codigo) {
        for (int i = 0; i < trabajadores.size(); i++) {
            if (trabajadores.get(i).getCodigo().equals(codigo)) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param consulta
     */
    private void ejecutarConsulta(String consulta) {
        try {
            trabajadores.clear();
            Utilidades.conn = new Conexion();
            conexion = conn.conectar_empresa_concreta(Utilidades.empresa);
            ps = conexion.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                Trabajador trabajador = new Trabajador();
                trabajador.setId(rs.getInt("id"));
                trabajador.setCodigo(rs.getString("codigo"));
                trabajador.setCodigo_tipo_contrato(rs.getInt("codigo_tipo_contrato"));
                trabajador.setApellido1(rs.getString("apellido1"));
                trabajador.setApellido2(rs.getString("apellido2"));
                trabajador.setNombre(rs.getString("nombre"));
                trabajador.setDireccion(rs.getString("direccion"));
                trabajador.setPoblacion(rs.getString("poblacion"));
                trabajador.setFechanacimiento(rs.getDate("fechanacimiento"));
                trabajador.setAntiguedad(rs.getDate("antiguedad"));
                trabajador.setTelefono(rs.getInt("telefono"));
                trabajador.setEmail(rs.getString("email"));
                trabajador.setFecha_alta(rs.getDate("fecha_alta"));
                trabajador.setFecha_alta(rs.getDate("fecha_baja"));
                trabajador.setHoras_semana_alta(rs.getInt("horas_semana_alta"));
                trabajador.setHoras_semana_reales(rs.getInt("horas_semana_reales"));
                trabajador.setCoste_mes(rs.getFloat("coste_mes"));
                trabajadores.add(trabajador);
            }
            conn.desconectar(conexion);
        } catch (SQLException ex) {
            Logger.getLogger(nombreClase).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param tabla
     * @param codigoCentro
     */
    public void rellenarTablaPorCodigoCentro(JTable tabla, String codigoCentro) {
        String consultaEspecial = "SELECT t.* \n"
                + "FROM trabajadores t \n"
                + "WHERE t.codigo IN(\n"
                + "	SELECT ct.codigo_trabajadores \n"
                + "    FROM centrostrabajadores ct \n"
                + "    WHERE ct.codigo_centro=" + codigoCentro + "\n"
                + ");";
        ejecutarConsulta(consultaEspecial); //METODO PARA RELLENAR LA LISTA DE TRABAJADORES EN ESTE CASO
        dtm = (DefaultTableModel) tabla.getModel();
        columnas = new Object[dtm.getColumnCount()];
        dtm.setRowCount(0);
        for (int i = 0; i < trabajadores.size(); i++) {
            dtm.addRow(addRow(trabajadores.get(i)));
        }
        tabla.setModel(dtm);
    }

    public void rellenarTrabajadoresNoContratados(JTable tabla, String codigoCentro) {
        String consultaEspecial = "SELECT t.* \n" //
                + "FROM trabajadores t \n"
                + "WHERE t.codigo NOT IN (\n"
                + "	SELECT ct.codigo_trabajadores \n"
                + "    FROM centrostrabajadores ct \n"
                + "    WHERE ct.codigo_centro='" + codigoCentro + "\n"
                + "');";
        ejecutarConsulta(consultaEspecial); //METODO PARA RELLENAR LA LISTA DE TRABAJADORES EN ESTE CASO
        dtm = (DefaultTableModel) tabla.getModel();
        columnas = new Object[dtm.getColumnCount()];
        dtm.setRowCount(0);
        for (int i = 0; i < trabajadores.size(); i++) {
            dtm.addRow(addRow(trabajadores.get(i)));
        }
        tabla.setModel(dtm);
    }
    
    public void filtrarTrabajadoresSinCentro(JTable tabla){
        String consultaEspecial = "SELECT t.* \n" //
                + "FROM trabajadores t \n"
                + "WHERE t.codigo NOT IN (\n"
                + "	SELECT ct.codigo_trabajadores \n"
                + "    FROM centrostrabajadores ct \n"
                + ");";
        ejecutarConsulta(consultaEspecial); //METODO PARA RELLENAR LA LISTA DE TRABAJADORES EN ESTE CASO
        dtm = (DefaultTableModel) tabla.getModel();
        columnas = new Object[dtm.getColumnCount()];
        dtm.setRowCount(0);
        for (int i = 0; i < trabajadores.size(); i++) {
            dtm.addRow(addRow(trabajadores.get(i)));
        }
        tabla.setModel(dtm);
    }

    private Object[] addRow(Trabajador t) {
        columnas = new Object[4];
        columnas[0] = t.getId();
        columnas[1] = t.getCodigo();
        columnas[2] = t.getNombre();
        String apellidos = t.getApellido1() + " " + t.getApellido2();
        columnas[3] = apellidos;
        return columnas;
    }

    public void rellenarTabla(JTable tabla) {
        dtm = (DefaultTableModel) tabla.getModel();
        columnas = new Object[dtm.getColumnCount()];
        dtm.setRowCount(0);
        for (int i = 0; i < trabajadores.size(); i++) {
            dtm.addRow(addRow(trabajadores.get(i)));
        }
        tabla.setModel(dtm);
    }

    public void rellenarTablaDefault(JTable tabla) {
        ejecutarConsulta(consultaTrabajadores); //METODO PARA RELLENAR LA LISTA DE TRABAJADORES EN ESTE CASO
        dtm = (DefaultTableModel) tabla.getModel();
        columnas = new Object[dtm.getColumnCount()];
        dtm.setRowCount(0);
        for (int i = 0; i < trabajadores.size(); i++) {
            dtm.addRow(addRow(trabajadores.get(i)));
        }
        tabla.setModel(dtm);
    }

    /**
     *
     * @param codigoTrabajador
     * @return
     */
    public Object[] buscarTrabajadoresPorCentrosDeUnCodigoTrabajador(String codigoTrabajador) {
        String consultaEspecial
                = "SELECT trabajadores.* \n"
                + "FROM trabajadores\n"
                + "WHERE trabajadores.codigo IN(\n"
                + "    SELECT ct.codigo_trabajadores \n"
                + "    FROM centrostrabajadores ct \n"
                + "    WHERE ct.codigo_centro=(\n"
                + "    	SELECT ct.codigo_centro \n"
                + "        FROM centrostrabajadores ct \n"
                + "        WHERE ct.codigo_trabajadores=" + codigoTrabajador + "))";
        ejecutarConsulta(consultaEspecial);
        Object[] datos = new Object[trabajadores.size()];
        for (int i = 0; i < trabajadores.size(); i++) {
            if (!trabajadores.get(i).getCodigo().equals(codigoTrabajador)) {
                datos[i] = trabajadores.get(i).getNombre();
            }
        }
        return datos;
    }

    /**
     *
     * @param trabajador
     * @return
     */
    public boolean insert(Trabajador trabajador) {
        correcto = false;
        try {
            Utilidades.conn = new Conexion();
            conexion = conn.conectar_empresa_concreta(Utilidades.empresa);
            insert = "INSERT INTO trabajadores (id,codigo,codigo_tipo_contrato,apellido1,apellido2,nombre,direccion,poblacion,"
                    + "fechanacimiento,categoria,antiguedad,telefono,email,fecha_alta,fecha_baja,horas_semana_alta,horas_semana_reales,coste_mes) "
                    + "VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            ps = conexion.prepareStatement(insert);
            ps.setString(1, trabajador.getCodigo());
            ps.setInt(2, trabajador.getCodigo_tipo_contrato());
            ps.setString(4, trabajador.getApellido1());
            ps.setString(5, trabajador.getApellido2());
            ps.setString(6, trabajador.getNombre());
            ps.setString(7, trabajador.getDireccion());
            ps.setString(8, trabajador.getPoblacion());
            sqlDate = new java.sql.Date(trabajador.getFechanacimiento().getTime());
            ps.setDate(9, sqlDate);
            ps.setString(10, trabajador.getCategoria());
            sqlDate = new java.sql.Date(trabajador.getAntiguedad().getTime());
            ps.setDate(11, sqlDate);
            ps.setInt(12, trabajador.getTelefono());
            ps.setString(13, trabajador.getEmail());
            sqlDate = new java.sql.Date(trabajador.getFecha_alta().getTime());
            ps.setDate(14, sqlDate);
            if (trabajador.getFecha_baja() == null) {
                sqlDate = null;
            } else {
                sqlDate = new java.sql.Date(trabajador.getFecha_baja().getTime());
            }
            ps.setDate(15, sqlDate);
            ps.setInt(16, trabajador.getHoras_semana_alta());
            ps.setInt(17, trabajador.getHoras_semana_reales());
            ps.setFloat(18, trabajador.getCoste_mes());
            conn.desconectar(conexion);
            trabajadores.add(0, trabajador);
            correcto = true;
        } catch (SQLException ex) {
            correcto = false;
            Logger.getLogger(nombreClase).log(Level.SEVERE, null, ex);
        }
        return correcto;
    }

    public boolean delete(int id) {
        correcto = false;
        try {
            Utilidades.conn = new Conexion();
            conexion = conn.conectar_empresa_concreta(Utilidades.empresa);
            delete = "DELETE FROM trabajadores WHERE id=?";
            ps = conexion.prepareStatement(delete);
            ps.setInt(1, id);
            conn.desconectar(conexion);
            trabajadores.remove(getById(id));
            correcto = true;
        } catch (SQLException ex) {
            correcto = false;
            Logger.getLogger(nombreClase).log(Level.SEVERE, null, ex);
        }
        return correcto;
    }

    public boolean update(Trabajador trabajador) {
        try {
            Utilidades.conn = new Conexion();
            conexion = conn.conectar_empresa_concreta(Utilidades.empresa);
            update = "UPDATE trabajadores SET codigo=?, codigo_tipo_contrato=?, apellido1=?, apellido2=?,nombre=?,direccion=?,poblacion=?,"
                    + "fechanacimiento=?, categoria=?, antiguedad=?, telefono=?, email=?, fecha_alta=?, fecha_baja=?,"
                    + "horas_semana_alta=?, horas_semana_reales=?, coste_mes=? WHERE id=?";
            ps = conexion.prepareStatement(update);
            ps.setString(1, trabajador.getCodigo());
            ps.setInt(2, trabajador.getCodigo_tipo_contrato());
            ps.setString(4, trabajador.getApellido1());
            ps.setString(5, trabajador.getApellido2());
            ps.setString(6, trabajador.getNombre());
            ps.setString(7, trabajador.getDireccion());
            ps.setString(8, trabajador.getPoblacion());
            sqlDate = new java.sql.Date(trabajador.getFechanacimiento().getTime());
            ps.setDate(9, sqlDate);
            ps.setString(10, trabajador.getCategoria());
            sqlDate = new java.sql.Date(trabajador.getAntiguedad().getTime());
            ps.setDate(11, sqlDate);
            ps.setInt(12, trabajador.getTelefono());
            ps.setString(13, trabajador.getEmail());
            sqlDate = new java.sql.Date(trabajador.getFecha_alta().getTime());
            ps.setDate(14, sqlDate);
            if (trabajador.getFecha_baja() == null) {
                sqlDate = null;
            } else {
                sqlDate = new java.sql.Date(trabajador.getFecha_baja().getTime());
            }
            ps.setDate(15, sqlDate);
            ps.setInt(16, trabajador.getHoras_semana_alta());
            ps.setInt(17, trabajador.getHoras_semana_reales());
            ps.setFloat(18, trabajador.getCoste_mes());
            //PARAMETRO QUE VA AL WHERE QUE SIEMPRE ES EL ID
            ps.setInt(19, trabajador.getId());
            conn.desconectar(conexion);
            ejecutarConsulta(consultaTrabajadores);
        } catch (SQLException ex) {
            correcto = false;
            Logger.getLogger(nombreClase).log(Level.SEVERE, null, ex);
        }
        return correcto;
    }

    /**
     *
     * @param codigoCentro
     */
    public void buscarTrabajadoresPorCodigoCentro(String codigoCentro) {
        String consultaEspecial = "SELECT t.* \n"
                + "FROM trabajadores t \n"
                + "WHERE t.codigo IN(\n"
                + "	SELECT ct.codigo_trabajadores \n"
                + "    FROM centrostrabajadores ct \n"
                + "    WHERE ct.codigo_centro=" + codigoCentro + "\n"
                + ");";
        ejecutarConsulta(consultaEspecial);
    }

    /**
     *
     * @param tabla
     * @param cadena
     */
    public void buscar(JTable tabla, String cadena) {
        DefaultTableModel dtm = (DefaultTableModel) tabla.getModel();
        String nombre;
        String apellido1;
        String apellido2;
        if (!cadena.equals("")) {
            if (Utilidades.isInteger(cadena)) {
                for (int i = 0; i < trabajadores.size(); i++) {
                    if (trabajadores.get(i).getCodigo().equals(cadena)) {
                        dtm.addRow(addRow(trabajadores.get(i)));
                    }
                }
            }
            if (cadena.indexOf(" ") > 0) {//SI ENTRA AQUI SIGNIFICA QUE HAY APELLIDOS EN EL BUSCADOR PERO NO SABEMOS SI TRAE LOS DOS APELLIDOS O 1
                String[] partes = cadena.split(" ");
                nombre = partes[0]; // nombre
                //AQUI HAY QUE COMPROBAR CUANTAS PARTES TRAE LA CADENA PORQUE NO SABEMOS SI SOLO TRAE EL NOMBRE O TAMBIEN EL APELLIDO1 O LOS DOS APELLIDOS
                if (partes.length > 2) {
                    apellido1 = partes[1]; // apellido 1 
                    apellido2 = partes[2];//apellido 2
                    for (int i = 0; i < trabajadores.size(); i++) {
                        if (trabajadores.get(i).getNombre().contains(nombre) && trabajadores.get(i).getApellido1().contains(apellido1) && trabajadores.get(i).getApellido2().contains(apellido2)) {
                            dtm.addRow(addRow(trabajadores.get(i)));
                        }
                    }
                } else if (partes.length > 1) {
                    apellido1 = partes[1]; // apellido 1 
                    for (int i = 0; i < trabajadores.size(); i++) {
                        if (trabajadores.get(i).getNombre().contains(nombre) && trabajadores.get(i).getApellido1().contains(apellido1)) {
                            dtm.addRow(addRow(trabajadores.get(i)));
                        } else if (trabajadores.get(i).getApellido1().contains(nombre) && trabajadores.get(i).getApellido2().contains(apellido1)) {
                            dtm.addRow(addRow(trabajadores.get(i)));
                        }
                    }
                }
            } else {//SI NO, ES QUE NO HAY APELLIDOS EN EL BUSCADOR
                for (int i = 0; i < trabajadores.size(); i++) {
                    if (trabajadores.get(i).getNombre().contains(cadena) || trabajadores.get(i).getApellido1().contains(cadena) || trabajadores.get(i).getApellido2().contains(cadena)) {
                        dtm.addRow(addRow(trabajadores.get(i)));
                    }
                }
            }
        }
        tabla.setModel(dtm);
    }

}
