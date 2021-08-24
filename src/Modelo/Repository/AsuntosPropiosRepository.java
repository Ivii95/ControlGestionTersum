/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Repository;

import Modelo.Entidades.AsuntosPropios;
import java.util.ArrayList;
import static Modelo.Repository.UtilidadesRepository.*;
import Utilidades.Conexion;
import static Utilidades.Utilidades.conn;
import static Utilidades.Utilidades.empresa;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DisenoWeb
 */
public final class AsuntosPropiosRepository {

    private final String nombreClase = AsuntosPropiosRepository.class.getName();
    private final ArrayList<AsuntosPropios> objetos;
    private final String TABLA = "asuntos_propios";
    private final String consultaFaltas = consultaPrincipal + TABLA;
    private final String id = "id";
    private final String cod = "codigo";
    private final String codTrabajador = "codigo_trabajador_ap";
    private final String codTrabajadorSustituto = "codigo_trabajador_sustituto";
    private final String dia = "dia";
    private final String motivo = "motivo";
    private final String ORDER = " ORDER BY " + dia + " DESC ";

    public AsuntosPropiosRepository() {
        this.objetos = new ArrayList<>();
        ejecutarConsulta(consultaFaltas);
    }

    /**
     *
     * @param consulta
     */
    public void ejecutarConsulta(String consulta) {
        objetos.clear();
        conn = new Conexion();
        conexion = conn.conectar_empresa_concreta(empresa);
        try {
            ps = conexion.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                AsuntosPropios falta = new AsuntosPropios();
                falta.setId(rs.getInt(id));
                falta.setCodigo(rs.getString(cod));
                falta.setCodigo_trabajador(rs.getString(codTrabajador));
                falta.setCodigo_trabajador_sustituto(rs.getString(codTrabajadorSustituto));
                if (rs.getDate(dia) != null) {
                    falta.setDia(rs.getDate(dia).toLocalDate());
                } else {
                    falta.setDia(null);
                }
                falta.setMotivo(rs.getString(motivo));
                objetos.add(falta);
            }
            rs.close();
            conn.desconectar(conexion);
        } catch (SQLException ex) {
            Logger.getLogger(nombreClase).log(Level.SEVERE, null, ex);
        }
    }

    public boolean ifCodigoExist(String codigo) {
        for (int i = 0; i < objetos.size(); i++) {
            if (objetos.get(i).getCodigo().equals(codigo)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<AsuntosPropios> getCentros() {
        return objetos;
    }

    public AsuntosPropios getById(int id) {
        AsuntosPropios o = null;
        for (int i = 0; i < objetos.size(); i++) {
            if (objetos.get(i).getId() == id) {
                o = objetos.get(i);
            }
        }
        return o;
    }

    public void rellenarTabla(JTable tabla) {
        dtm = (DefaultTableModel) tabla.getModel();
        columnas = new Object[dtm.getColumnCount()];
        dtm.setRowCount(0);
        for (int i = 0; i < objetos.size(); i++) {
            dtm.addRow(addRow(objetos.get(i)));
        }
        tabla.setModel(dtm);
    }

    public void rellenarTablaDefault(JTable tabla) {
        ejecutarConsulta(consultaFaltas + ORDER);
        dtm = (DefaultTableModel) tabla.getModel();
        columnas = new Object[dtm.getColumnCount()];
        dtm.setRowCount(0);
        for (int i = 0; i < objetos.size(); i++) {
            dtm.addRow(addRow(objetos.get(i)));
        }
        tabla.setModel(dtm);
    }

    public void rellenarTablaByTrabajador(JTable tabla, String codigo) {
        ejecutarConsulta(consultaFaltas + " WHERE " + codTrabajador + " = '" + codigo + "'" + ORDER);
        dtm = (DefaultTableModel) tabla.getModel();
        columnas = new Object[dtm.getColumnCount()];
        dtm.setRowCount(0);
        for (int i = 0; i < objetos.size(); i++) {
            dtm.addRow(addRow(objetos.get(i)));
        }
        tabla.setModel(dtm);
    }

    public void rellenarTablaByAPDeUnCentro(JTable tabla, String codigo) {
        ejecutarConsulta("SELECT i.* FROM faltas i WHERE i.codigo_trabajador_ap IN(\n"
                + "    SELECT ct.codigo_trabajadores FROM centrostrabajadores ct WHERE ct.codigo_centro=" + codigo + ");");
        dtm = (DefaultTableModel) tabla.getModel();
        columnas = new Object[dtm.getColumnCount()];
        dtm.setRowCount(0);
        for (int i = 0; i < objetos.size(); i++) {
            dtm.addRow(addRow(objetos.get(i)));
        }
        tabla.setModel(dtm);
    }

    private Object[] addRow(AsuntosPropios o) {
        columnas = new Object[4];
        columnas[0] = o.getId();
        columnas[1] = o.getCodigo();
        columnas[2] = o.getCodigo_trabajador_sustituto();
        columnas[3] = o.getDia();
        return columnas;
    }

    public boolean insert(AsuntosPropios o) {
        correcto = false;
        try {
            conn = new Conexion();
            conexion = conn.conectar_empresa_concreta(empresa);
            insert = "INSERT INTO " + TABLA + " (id, "
                    + cod + ", "
                    + codTrabajador + ", "
                    + codTrabajadorSustituto + ", "
                    + dia + ", "
                    + motivo + " "
                    + ") VALUES (NULL, ?, ?, ?, ?, ?)";
            ps = conexion.prepareStatement(insert);
            ps.setString(1, o.getCodigo());
            ps.setString(2, o.getCodigo_trabajador());
            if (o.getCodigo_trabajador_sustituto() != null) {
                ps.setString(3, o.getCodigo_trabajador_sustituto());
            } else {
                ps.setString(3, null);
            }
            if (o.getDia() != null) {
                sqlDate = java.sql.Date.valueOf(o.getDia());
            } else {
                sqlDate = null;
            }
            ps.setDate(4, sqlDate);
            ps.setString(5, o.getMotivo());
            ps.executeUpdate();
            conn.desconectar(conexion);
            objetos.add(o);
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
            conn = new Conexion();
            conexion = conn.conectar_empresa_concreta(empresa);
            delete = "DELETE FROM " + TABLA + " WHERE id=?";
            ps = conexion.prepareStatement(delete);
            ps.setInt(1, id);
            ps.executeUpdate();
            conn.desconectar(conexion);
            objetos.remove(getById(id));
            correcto = true;
        } catch (SQLException ex) {
            correcto = false;
            Logger.getLogger(nombreClase).log(Level.SEVERE, null, ex);
        }
        return correcto;
    }

    public boolean update(AsuntosPropios o) {
        try {
            conn = new Conexion();
            conexion = conn.conectar_empresa_concreta(empresa);
            update = "UPDATE " + TABLA + " SET "
                    + cod + "=?, "
                    + codTrabajador + "=?, "
                    + codTrabajadorSustituto + "=?, "
                    + dia + "=?, "
                    + motivo + "=? WHERE " + id + "=?";
            ps = conexion.prepareStatement(update);
            ps.setString(1, o.getCodigo());
            ps.setString(2, o.getCodigo_trabajador());
            if (o.getCodigo_trabajador_sustituto() != null) {
                ps.setString(3, o.getCodigo_trabajador_sustituto());
            } else {
                ps.setString(3, null);
            }
            sqlDate = java.sql.Date.valueOf(o.getDia());
            if (o.getDia() != null) {
                sqlDate = java.sql.Date.valueOf(o.getDia());
            } else {
                sqlDate = null;
            }
            ps.setDate(4, sqlDate);
            ps.setString(5, o.getMotivo());
            //PARAMETRO QUE VA AL WHERE QUE SIEMPRE ES EL ID
            ps.setInt(6, o.getId());
            ps.executeUpdate();
            conn.desconectar(conexion);
            //ejecutarConsulta(consultaPrincipal);
            correcto = true;
        } catch (SQLException ex) {
            correcto = false;
            Logger.getLogger(nombreClase).log(Level.SEVERE, null, ex);
        }
        return correcto;
    }

    public void buscar(JTable tabla, String cadena) {
        DefaultTableModel dtm = (DefaultTableModel) tabla.getModel();
        for (int i = 0; i < objetos.size(); i++) {
            if (objetos.get(i).getCodigo().contains(cadena)) {
                dtm.addRow(addRow(objetos.get(i)));
            } else if (objetos.get(i).getMotivo().contains(cadena)) {
                dtm.addRow(addRow(objetos.get(i)));
            }
        }
        tabla.setModel(dtm);
    }

    public void buscarFecha(JTable tabla, String buscar, String codigo) {
        ejecutarConsulta(consultaFaltas + " WHERE (" + dia + " LIKE '%" + buscar + "%' OR " + dia + "LIKE '%" + buscar + "%' ) AND codigo_trabajador=" + codigo);
        rellenarTabla(tabla);
    }
}
