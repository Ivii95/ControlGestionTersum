/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Repository;

import Modelo.Incidencia;
import static Modelo.Repository.UtilidadesRepository.*;
import Modelo.Trabajador;
import Utilidades.Conexion;
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
public final class IncidenciaRepository {

    private final String nombreClase = IncidenciaRepository.class.getName();
    private final ArrayList<Incidencia> incidencias;
    private final String TABLA = "incidencias";
    private final String consultaIncidencia = consultaPrincipal + TABLA;
    private final String id = "id";
    private final String cod = "codigo";
    private final String codTrabajador = "codigo_trabajador_faltas";
    private final String fechaInicio = "fecha_inicio";
    private final String fechaFin = "fecha_fin";
    private final String descripcion = "descripcion";
    private final String extras = "extras";

    public IncidenciaRepository() {
        this.incidencias = new ArrayList<>();
        ejecutarConsulta(consultaIncidencia);
    }

    /**
     *
     * @param consulta
     */
    public void ejecutarConsulta(String consulta) {
        incidencias.clear();
        conn = new Conexion();
        conexion = conn.conectar_empresa_concreta(empresa);
        try {
            ps = conexion.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                Incidencia o = new Incidencia();
                o.setId(rs.getInt(id));
                o.setCodigo(rs.getString(cod));
                o.setCodigo_trabajador(rs.getString(codTrabajador));
                o.setFecha_inicio(rs.getDate(fechaInicio));
                o.setFecha_fin(rs.getDate(fechaFin));
                o.setDescripcion(rs.getString(descripcion));
                o.setExtras(rs.getInt(extras));
                incidencias.add(o);
            }
            conn.desconectar(conexion);
        } catch (SQLException ex) {
            Logger.getLogger(nombreClase).log(Level.SEVERE, null, ex);
        }
    }

    public boolean ifCodigoExist(String codigo) {
        for (int i = 0; i < incidencias.size(); i++) {
            if (incidencias.get(i).getCodigo().equals(codigo)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Incidencia> getCentros() {
        return incidencias;
    }

    public Incidencia getById(int id) {
        Incidencia o = null;
        for (int i = 0; i < incidencias.size(); i++) {
            if (incidencias.get(i).getId() == id) {
                o = incidencias.get(i);
            }
        }
        return o;
    }

    public void rellenarTabla(JTable tabla) {
        dtm = (DefaultTableModel) tabla.getModel();
        columnas = new Object[dtm.getColumnCount()];
        dtm.setRowCount(0);
        for (int i = 0; i < incidencias.size(); i++) {
            dtm.addRow(addRow(incidencias.get(i)));
        }
        tabla.setModel(dtm);
    }

    public void rellenarTablaDefault(JTable tabla) {
        ejecutarConsulta(consultaIncidencia);
        dtm = (DefaultTableModel) tabla.getModel();
        columnas = new Object[dtm.getColumnCount()];
        dtm.setRowCount(0);
        for (int i = 0; i < incidencias.size(); i++) {
            dtm.addRow(addRow(incidencias.get(i)));
        }
        tabla.setModel(dtm);
    }

    public void rellenarTablaByTrabajador(JTable tabla, String codigo) {
        ejecutarConsulta(consultaIncidencia + "WHERE " + codTrabajador + "=" + codigo);
        dtm = (DefaultTableModel) tabla.getModel();
        columnas = new Object[dtm.getColumnCount()];
        dtm.setRowCount(0);
        for (int i = 0; i < incidencias.size(); i++) {
            dtm.addRow(addRow(incidencias.get(i)));
        }
        tabla.setModel(dtm);
    }

    private Object[] addRow(Incidencia o) {
        columnas = new Object[3];
        columnas[0] = o.getId();
        columnas[1] = o.getCodigo();
        columnas[2] = o.getFecha_inicio();
        columnas[3] = o.getFecha_fin();
        return columnas;
    }

    public boolean insert(Incidencia o) {
        correcto = false;
        try {
            conn = new Conexion();
            conexion = conn.conectar_empresa_concreta(empresa);
            insert = "INSERT INTO " + TABLA + " (id, "
                    + cod + ", "
                    + codTrabajador + ", "
                    + fechaInicio + ", "
                    + fechaFin + ", "
                    + extras + ", "
                    + descripcion + " "
                    + ") VALUES (NULL, ?, ?, ?, ?, ?, ?)";
            ps = conexion.prepareStatement(insert);
            ps.setString(1, o.getCodigo());
            ps.setString(2, o.getCodigo_trabajador());
            sqlDate = new java.sql.Date(o.getFecha_inicio().getTime());
            ps.setDate(3, sqlDate);
            if (o.getFecha_fin() != null) {
                sqlDate = new java.sql.Date(o.getFecha_fin().getTime());
            } else {
                sqlDate = null;
            }
            ps.setDate(4, sqlDate);
            ps.setInt(5, o.getExtras());
            ps.setString(6, o.getDescripcion());
            ps.close();
            conn.desconectar(conexion);
            incidencias.add(o);
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
            ps.close();
            conn.desconectar(conexion);
            incidencias.remove(getById(id));
            correcto = true;
        } catch (SQLException ex) {
            correcto = false;
            Logger.getLogger(nombreClase).log(Level.SEVERE, null, ex);
        }
        return correcto;
    }

    public boolean update(Incidencia o) {
        try {
            conn = new Conexion();
            conexion = conn.conectar_empresa_concreta(empresa);
            update = "UPDATE " + TABLA + " SET "
                    + cod + "=?, "
                    + codTrabajador + "=?, "
                    + fechaInicio + "=?, "
                    + fechaFin + "=?,"
                    + extras + "=?,"
                    + descripcion + "=? WHERE " + id + "=?";
            ps = conexion.prepareStatement(update);
            ps.setString(1, o.getCodigo());
            ps.setString(2, o.getCodigo_trabajador());
            sqlDate = new java.sql.Date(o.getFecha_inicio().getTime());
            ps.setDate(3, sqlDate);
            if (o.getFecha_fin() != null) {
                sqlDate = new java.sql.Date(o.getFecha_fin().getTime());
            } else {
                sqlDate = null;
            }
            ps.setDate(4, sqlDate);
            ps.setInt(5, o.getExtras());
            ps.setString(5, o.getDescripcion());
            //PARAMETRO QUE VA AL WHERE QUE SIEMPRE ES EL ID
            ps.setInt(6, o.getId());
            conn.desconectar(conexion);
            ejecutarConsulta(consultaPrincipal);
            correcto = true;
        } catch (SQLException ex) {
            correcto = false;
            Logger.getLogger(nombreClase).log(Level.SEVERE, null, ex);
        }
        return correcto;
    }

    public void buscar(JTable tabla, String cadena) {
        DefaultTableModel dtm = (DefaultTableModel) tabla.getModel();
        for (int i = 0; i < incidencias.size(); i++) {
            if (incidencias.get(i).getCodigo().contains(cadena)) {
                dtm.addRow(addRow(incidencias.get(i)));
            } else if (incidencias.get(i).getDescripcion().contains(cadena)) {
                dtm.addRow(addRow(incidencias.get(i)));
            }
        }
        tabla.setModel(dtm);
    }

    public void buscarFecha(JTable tabla, String buscar, String codigo) {
        ejecutarConsulta(consultaIncidencia + " WHERE (" + fechaInicio + " LIKE '%" + buscar + "%' OR " + fechaFin + "LIKE '%" + buscar + "%' ) AND codigo_trabajador=" + codigo);
        rellenarTabla(tabla);
    }
}
