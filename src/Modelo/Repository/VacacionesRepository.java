/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Repository;

import Modelo.Entidades.Vacaciones;
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
public final class VacacionesRepository {

    private final String nombreClase = VacacionesRepository.class.getName();
    private final ArrayList<Vacaciones> objetos;
    private final String TABLA = "vacaciones";
    private final String consultaFaltas = consultaPrincipal + TABLA;
    private final String id = "id";
    private final String cod = "codigo";
    private final String codTrabajador = "codigo_trabajador_vacaciones";
    private final String fechaInicio = "fecha_inicio";
    private final String fechaFin = "fecha_fin";
    private final String motivo = "motivo";
    private final String ORDER = " ORDER BY " + fechaInicio + " DESC ";

    public VacacionesRepository() {
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
                Vacaciones falta = new Vacaciones();
                falta.setId(rs.getInt(id));
                falta.setCodigo(rs.getString(cod));
                falta.setCodigo_trabajador(rs.getString(codTrabajador));
                if (rs.getDate(fechaInicio) != null) {
                    falta.setFecha_inicio(rs.getDate(fechaInicio).toLocalDate());
                } else {
                    falta.setFecha_inicio(null);
                }
                if (rs.getDate(fechaFin) != null) {
                    falta.setFecha_fin(rs.getDate(fechaFin).toLocalDate());
                } else {
                    falta.setFecha_fin(null);
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

    public ArrayList<Vacaciones> getCentros() {
        return objetos;
    }

    public Vacaciones getById(int id) {
        Vacaciones o = null;
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

    public void rellenarTablaByVacacionesDeUnCentro(JTable tabla, String codigo) {
        ejecutarConsulta("SELECT i.* FROM faltas i WHERE i.codigo_trabajador_vacaciones IN(\n"
                + "    SELECT ct.codigo_trabajadores FROM centrostrabajadores ct WHERE ct.codigo_centro=" + codigo + ");");
        dtm = (DefaultTableModel) tabla.getModel();
        columnas = new Object[dtm.getColumnCount()];
        dtm.setRowCount(0);
        for (int i = 0; i < objetos.size(); i++) {
            dtm.addRow(addRow(objetos.get(i)));
        }
        tabla.setModel(dtm);
    }

    private Object[] addRow(Vacaciones o) {
        columnas = new Object[4];
        columnas[0] = o.getId();
        columnas[1] = o.getCodigo();
        columnas[2] = o.getFecha_inicio();
        columnas[3] = o.getFecha_fin();
        return columnas;
    }

    public boolean insert(Vacaciones o) {
        correcto = false;
        try {
            conn = new Conexion();
            conexion = conn.conectar_empresa_concreta(empresa);
            insert = "INSERT INTO " + TABLA + " (id, "
                    + cod + ", "
                    + codTrabajador + ", "
                    + fechaInicio + ", "
                    + fechaFin + ", "
                    + motivo + " "
                    + ") VALUES (NULL, ?, ?, ?, ?, ?)";
            ps = conexion.prepareStatement(insert);
            ps.setString(1, o.getCodigo());
            ps.setString(2, o.getCodigo_trabajador());
            if (o.getFecha_inicio() != null) {
                sqlDate = java.sql.Date.valueOf(o.getFecha_inicio());
            }
            sqlDate = java.sql.Date.valueOf(o.getFecha_inicio());
            ps.setDate(3, sqlDate);
            if (o.getFecha_fin() != null) {
                sqlDate = java.sql.Date.valueOf(o.getFecha_fin());
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

    public boolean update(Vacaciones o) {
        try {
            conn = new Conexion();
            conexion = conn.conectar_empresa_concreta(empresa);
            update = "UPDATE " + TABLA + " SET "
                    + cod + "=?, "
                    + codTrabajador + "=?, "
                    + fechaInicio + "=?, "
                    + fechaFin + "=?,"
                    + motivo + "=? WHERE " + id + "=?";
            ps = conexion.prepareStatement(update);
            ps.setString(1, o.getCodigo());
            ps.setString(2, o.getCodigo_trabajador());
            sqlDate = java.sql.Date.valueOf(o.getFecha_inicio());
            if (o.getFecha_inicio() != null) {
                sqlDate = java.sql.Date.valueOf(o.getFecha_inicio());
            } else {
                sqlDate = null;
            }
            ps.setDate(3, sqlDate);
            if (o.getFecha_fin() != null) {
                sqlDate = java.sql.Date.valueOf(o.getFecha_fin());
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
        ejecutarConsulta(consultaFaltas + " WHERE (" + fechaInicio + " LIKE '%" + buscar + "%' OR " + fechaFin + "LIKE '%" + buscar + "%' ) AND codigo_trabajador=" + codigo);
        rellenarTabla(tabla);
    }
}
