/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Repository;

import Modelo.Entidades.Cliente;
import Modelo.Entidades.Sede;
import Modelo.Entidades.SedeCliente;
import Modelo.Entidades.SedeUsuario;
import Modelo.Entidades.Usuario;
import static Modelo.Repository.UtilidadesRepository.*;
import Utilidades.Conexion;
import Utilidades.Utilidades;
import static Utilidades.Utilidades.DOS;
import static Utilidades.Utilidades.UNO;
import static Utilidades.Utilidades.conn;
import static Utilidades.Utilidades.empresa;
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
public class SedesRepository {

    private final String nombreClase = SedesRepository.class.getName();
    private final ClienteRepository repoCliente;
    private final UsuarioRepository repoUsuario;
    private final ArrayList<SedeUsuario> sedesUsuario;
    private final ArrayList<SedeCliente> sedesCliente;
    private final ArrayList<Sede> sedes;
    private final String TABLA = "sedes";
    private final String consulta = consultaPrincipal + TABLA;
    private final String id = "id";
    private final String cod = "codigo";
    private final String ciudad = "ciudad";
    private final String idCliente = "id_cliente";
    private final String idUsuario = "id_usuario";
    private final String idSede = "id_sede";
    private final String codSede = "codigo_sede";
    private final String ORDER = " ORDER BY " + ciudad + " ASC ";

    public SedesRepository() {
        this.sedes = new ArrayList<>();
        this.sedesCliente = new ArrayList<>();
        this.sedesUsuario = new ArrayList<>();
        repoCliente = new ClienteRepository();
        repoUsuario = new UsuarioRepository();
        ejecutarConsultaUsuarios(consultaPrincipal + "sedeusuario");
        ejecutarConsultaClientes(consultaPrincipal + "sedecliente");
        ejecutarConsulta(consulta);
    }

    private void ejecutarConsultaUsuarios(String consulta) {
        sedes.clear();
        conn = new Conexion();
        conexion = conn.conectar_empresa_concreta(empresa);
        try {
            ps = conexion.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                SedeUsuario sede = new SedeUsuario();
                sede.setId(rs.getInt(id));
                sede.setCodigo_sede(rs.getInt(codSede));
                sede.setId_usuario(rs.getInt(idUsuario));
                sedesUsuario.add(sede);
            }
            conn.desconectar(conexion);
        } catch (SQLException ex) {
            Logger.getLogger(CentroRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void ejecutarConsultaClientes(String consulta) {
        sedes.clear();
        conn = new Conexion();
        conexion = conn.conectar_empresa_concreta(empresa);
        try {
            ps = conexion.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                SedeCliente sede = new SedeCliente();
                sede.setId(rs.getInt(id));
                sede.setId_cliente(rs.getInt(idCliente));
                sede.setId_sede(rs.getInt(idSede));
                sedesCliente.add(sede);
            }
            conn.desconectar(conexion);
        } catch (SQLException ex) {
            Logger.getLogger(CentroRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void ejecutarConsulta(String consulta) {
        sedes.clear();
        conn = new Conexion();
        conexion = conn.conectar_empresa_concreta(empresa);
        try {
            ps = conexion.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                Sede sede = new Sede();
                sede.setId(rs.getInt(id));
                sede.setCodigo(rs.getInt(cod));
                sede.setCiudad(rs.getString(ciudad));
                ArrayList<Usuario> usuarios = new ArrayList<>();
                for (int i = 0; i < sedesUsuario.size(); i++) {
                    if (sedesUsuario.get(i).getCodigo_sede() == sede.getCodigo()) {
                        usuarios.add(repoUsuario.getById(sedesUsuario.get(i).getId_usuario()));
                    }
                }
                sede.setUsuarios(usuarios);
                ArrayList<Cliente> clientes = new ArrayList<>();
                for (int i = 0; i < sedesCliente.size(); i++) {
                    if (sedesCliente.get(i).getId_sede() == sede.getId()) {
                        clientes.add(repoCliente.getById(sedesCliente.get(i).getId()));
                    }
                }
                sede.setClientes(clientes);
                sedes.add(sede);
            }
            conn.desconectar(conexion);
        } catch (SQLException ex) {
            Logger.getLogger(CentroRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean ifIdExist(int id) {
        for (int i = 0; i < sedes.size(); i++) {
            if (sedes.get(i).getId() == id) {
                return true;
            }
        }
        return false;
    }

    public boolean ifCodigoExist(int codigo) {
        for (int i = 0; i < sedes.size(); i++) {
            if (sedes.get(i).getCodigo() == codigo) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Sede> getLista() {
        return sedes;
    }

    public ArrayList<Cliente> getListaCliente(int id) {
        for (int i = 0; i < sedes.size(); i++) {
            if (sedes.get(i).getId() == id) {
                return sedes.get(i).getClientes();
            }
        }
        return null;
    }

    public ArrayList<Usuario> getListaUsuarios(int id) {
        for (int i = 0; i < sedes.size(); i++) {
            if (sedes.get(i).getId() == id) {
                return sedes.get(i).getUsuarios();
            }
        }
        return null;
    }

    public ArrayList<Sede> getSedesByUsuario(int id) {
        ArrayList<Sede> sedeByUsuario = new ArrayList<>();
        for (int i = 0; i < sedes.size(); i++) {
            ArrayList<Usuario> usuarios = sedes.get(i).getUsuarios();
            for (int j = 0; j < usuarios.size(); j++) {
                if (usuarios.get(j).getId() == id) {
                    sedeByUsuario.add(sedes.get(i));
                }
            }
        }
        return sedeByUsuario;
    }

    public Sede getSedeById(int id) {
        Sede t = null;
        for (int i = 0; i < sedes.size(); i++) {
            if (sedes.get(i).getId() == id) {
                t = sedes.get(i);
            }
        }
        return t;
    }

    private Object[] addRow(Sede o) {
        columnas = new Object[4];
        columnas[0] = o.getId();
        columnas[1] = o.getCodigo();
        columnas[2] = o.getCiudad();
        return columnas;
    }

    public void rellenarTabla(JTable tabla) {
        dtm = (DefaultTableModel) tabla.getModel();
        columnas = new Object[dtm.getColumnCount()];
        dtm.setRowCount(0);
        for (int i = 0; i < sedes.size(); i++) {
            dtm.addRow(addRow(sedes.get(i)));
        }
        tabla.setModel(dtm);
    }

    public void rellenarTablaSedesDefault(JTable tabla) {
        ejecutarConsulta(consulta); //METODO PARA RELLENAR LA LISTA DE TRABAJADORES EN ESTE CASO
        dtm = (DefaultTableModel) tabla.getModel();
        columnas = new Object[dtm.getColumnCount()];
        dtm.setRowCount(0);
        for (int i = 0; i < sedes.size(); i++) {
            dtm.addRow(addRow(sedes.get(i)));

            tabla.setModel(dtm);
        }
    }

    public boolean insert(Sede get) {
        correcto = false;
        try {
            conn = new Conexion();
            conexion = conn.conectar_empresa_concreta(Utilidades.empresa);
            System.out.println("Intentado");
            insert = "INSERT INTO " + TABLA + "(id,codigo,ciudad) "
                    + "VALUES (NULL, ?, ?);";
            ps = conexion.prepareStatement(insert);
            ps.setInt(1, get.getCodigo());
            ps.setString(2, get.getCiudad());
            ps.executeUpdate();
            conn.desconectar(conexion);
            correcto = true;
        } catch (SQLException ex) {
            correcto = false;
            Logger.getLogger(nombreClase).log(Level.SEVERE, null, ex);
        }
        return correcto;
    }

    public boolean update(Sede get) {
        try {
            conn = new Conexion();
            conexion = conn.conectar_empresa_concreta(Utilidades.empresa);
            update = "UPDATE " + TABLA + " SET codigo=?, ciudad=? WHERE id=?";
            ps = conexion.prepareStatement(update);
            ps.setInt(1, get.getCodigo());
            ps.setString(2, get.getCiudad());
            //PARAMETRO QUE VA AL WHERE QUE SIEMPRE ES EL ID
            ps.setInt(3, get.getId());
            ps.executeUpdate();
            ejecutarConsulta(consulta);
            conn.desconectar(conexion);
            correcto = true;
        } catch (SQLException ex) {
            correcto = false;
            Logger.getLogger(nombreClase).log(Level.SEVERE, null, ex);
        }
        return correcto;
    }

    public boolean deleteSede(int id) {
        correcto = false;
        try {
            conn = new Conexion();
            conexion = conn.conectar_empresa_concreta(Utilidades.empresa);
            delete = "DELETE FROM " + TABLA + " WHERE id=?";
            ps = conexion.prepareStatement(delete);
            ps.setInt(1, id);
            ps.executeUpdate();
            conn.desconectar(conexion);
            correcto = true;
        } catch (SQLException ex) {
            correcto = false;
            Logger.getLogger(nombreClase).log(Level.SEVERE, null, ex);
        }
        return correcto;
    }

    public void buscar(JTable tabla, String cadena) {
        DefaultTableModel dtm = (DefaultTableModel) tabla.getModel();
        for (int i = 0; i < sedes.size(); i++) {
            if (cadena.contains(sedes.get(i).getId() + "")) {
                dtm.addRow(addRow(sedes.get(i)));
            } else if (cadena.contains(sedes.get(i).getCodigo() + "")) {
                dtm.addRow(addRow(sedes.get(i)));
            } else if (cadena.contains(sedes.get(i).getCiudad() + "")) {
                dtm.addRow(addRow(sedes.get(i)));
            }
        }
        tabla.setModel(dtm);
    }
}
