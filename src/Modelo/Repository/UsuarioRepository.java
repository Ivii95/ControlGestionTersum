/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Repository;

import Modelo.Entidades.Usuario;
import static Modelo.Repository.UtilidadesRepository.columnas;
import static Modelo.Repository.UtilidadesRepository.conexion;
import static Modelo.Repository.UtilidadesRepository.consultaPrincipal;
import static Modelo.Repository.UtilidadesRepository.correcto;
import static Modelo.Repository.UtilidadesRepository.rs;
import static Modelo.Repository.UtilidadesRepository.insert;
import static Modelo.Repository.UtilidadesRepository.delete;
import static Modelo.Repository.UtilidadesRepository.dtm;
import static Modelo.Repository.UtilidadesRepository.ps;
import static Modelo.Repository.UtilidadesRepository.update;
import Utilidades.Conexion;
import static Utilidades.Utilidades.DOS;
import static Utilidades.Utilidades.UNO;
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
public class UsuarioRepository {

    private final String nombreClase = UsuarioRepository.class.getName();
    private final ArrayList<Usuario> usuarios;
    private final String TABLA = "usuarios";
    private final String consulta = consultaPrincipal + TABLA;
    private final String id = "id";
    private final String nombre = "nombre";
    private final String password = "id_rol";
    private final String ultimaSesion = "ultima_sesion";
    private final String idRol = "id_rol";
    private final String ORDER = " ORDER BY " + nombre + " ASC ";

    public UsuarioRepository() {
        usuarios = new ArrayList<>();
        ejecutarConsulta(consulta);
    }

    private void ejecutarConsulta(String consulta) {
        usuarios.clear();
        conn = new Conexion();
        conexion = conn.conectar_db_empresas();
        try {
            ps = conexion.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                Usuario usu = new Usuario();
                usu.setId(rs.getInt(id));
                usu.setPassword(rs.getString(password));
                usu.setNombre(rs.getString(nombre));
                if (rs.getInt(idRol) == 1) {
                    usu.setId_rol(Utilidades.Utilidades.UNO);
                } else if (rs.getInt(idRol) == 2) {
                    usu.setId_rol(Utilidades.Utilidades.DOS);
                }
                usu.setUltima_sesion(rs.getString(ultimaSesion));
                usuarios.add(usu);
            }
            conn.desconectar(conexion);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void rellenarTablaDefault(JTable tabla) {
        ejecutarConsulta(consulta); //METODO PARA RELLENAR LA LISTA DE TRABAJADORES EN ESTE CASO
        dtm = (DefaultTableModel) tabla.getModel();
        columnas = new Object[dtm.getColumnCount()];
        dtm.setRowCount(0);
        for (int i = 0; i < usuarios.size(); i++) {
            dtm.addRow(addRow(usuarios.get(i)));
        }
        tabla.setModel(dtm);
    }

    public ArrayList<Usuario> getLista() {
        return usuarios;
    }

    public Usuario getById(int id) {
        Usuario t = null;
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getId() == id) {
                t = usuarios.get(i);
            }
        }
        return t;
    }

    public boolean ifIdExist(int id) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getId() == id) {
                return true;
            }
        }
        return false;
    }

    public boolean insert(Usuario get) {
        correcto = false;
        try {
            conn = new Conexion();
            conexion = conn.conectar_db_empresas();
            insert = "INSERT INTO " + TABLA + " (id,nombre,password,id_rol,ultima_sesion) "
                    + "VALUES (NULL, ?, ?, ?, ?)";
            ps = conexion.prepareStatement(insert);
            ps.setInt(1, get.getId());
            ps.setString(2, get.getNombre());
            ps.setString(3, get.getPassword());
            if (get.getId_rol().equals(UNO)) {
                ps.setInt(4, 1);
            } else if (get.getId_rol().equals(DOS)) {
                ps.setInt(4, 2);
            }
            ps.setString(5, get.getUltima_sesion());
            ps.executeUpdate();
            conn.desconectar(conexion);
            usuarios.add(0, get);
            correcto = true;
        } catch (SQLException ex) {
            correcto = false;
            Logger.getLogger(nombreClase).log(Level.SEVERE, null, ex);
        }
        return correcto;
    }

    public boolean update(Usuario get) {
        try {
            conn = new Conexion();
            conexion = conn.conectar_db_empresas();
            update = "UPDATE " + TABLA + " SET nombre=?, id_rol=? WHERE id=?";
            ps = conexion.prepareStatement(update);
            ps.setString(1, get.getNombre());
            if (get.getId_rol().equals(UNO)) {
                ps.setInt(2, 1);
            } else if (get.getId_rol().equals(DOS)) {
                ps.setInt(2, 2);
            }
            //PARAMETRO QUE VA AL WHERE QUE SIEMPRE ES EL ID
            ps.setInt(3, get.getId());
            conn.desconectar(conexion);
            ejecutarConsulta(consulta);
        } catch (SQLException ex) {
            correcto = false;
            Logger.getLogger(nombreClase).log(Level.SEVERE, null, ex);
        }
        return correcto;
    }

    public boolean delete(int id) {
        correcto = false;
        try {
            conn = new Conexion();
            conexion = conn.conectar_db_empresas();
            delete = "DELETE FROM " + TABLA + " WHERE id=?";
            ps = conexion.prepareStatement(delete);
            ps.setInt(1, id);
            conn.desconectar(conexion);
            usuarios.remove(getById(id));
            correcto = true;
        } catch (SQLException ex) {
            correcto = false;
            Logger.getLogger(nombreClase).log(Level.SEVERE, null, ex);
        }
        return correcto;
    }

    public void buscar(JTable tabla, String cadena) {
        DefaultTableModel dtm = (DefaultTableModel) tabla.getModel();
        for (int i = 0; i < usuarios.size(); i++) {
            if (cadena.contains(usuarios.get(i).getId() + "")) {
                dtm.addRow(addRow(usuarios.get(i)));
            } else if (cadena.contains(usuarios.get(i).getNombre())) {
                dtm.addRow(addRow(usuarios.get(i)));
            } else if (cadena.contains(usuarios.get(i).getId_rol() + "")) {
                dtm.addRow(addRow(usuarios.get(i)));
            } else if (cadena.contains(usuarios.get(i).getUltima_sesion())) {
                dtm.addRow(addRow(usuarios.get(i)));
            }
        }
        tabla.setModel(dtm);
    }

    private Object[] addRow(Usuario o) {
        columnas = new Object[4];
        columnas[0] = o.getId();
        columnas[1] = o.getNombre();
        columnas[2] = o.getId_rol();
        columnas[3] = o.getUltima_sesion();
        return columnas;
    }

}
