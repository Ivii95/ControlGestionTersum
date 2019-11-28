/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Repository;

import Modelo.Entidades.Falta;
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
public final class FaltaRepository {

    private final String nombreClase = FaltaRepository.class.getName();
    private final ArrayList<Falta> faltas;
    private final String TABLA = "faltas";
    private final String consultaFaltas = consultaPrincipal + TABLA;
    private final String id = "id";
    private final String cod = "codigo";
    private final String codTrabajador = "codigo_trabajador_faltas";
    private final String fechaInicio = "fecha_inicio";
    private final String fechaFin = "fecha_fin";
    private final String motivo = "motivo";
    private final String ORDER=" ORDER BY "+fechaInicio+" DESC ";
    public FaltaRepository() {
        this.faltas = new ArrayList<>();
    }

    /**
     *
     * @param consulta
     */
    public void ejecutarConsulta(String consulta) {
        faltas.clear();
        conn = new Conexion();
        conexion = conn.conectar_empresa_concreta(empresa);
        try {
            ps = conexion.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                Falta falta = new Falta();
                falta.setId(rs.getInt(id));
                falta.setCodigo(rs.getString(cod));
                falta.setCodigo_trabajador(rs.getString(codTrabajador));
                falta.setFecha_inicio(rs.getDate(fechaInicio));
                falta.setFecha_fin(rs.getDate(fechaFin));
                falta.setMotivo(rs.getString(motivo));
                faltas.add(falta);
            }
            conn.desconectar(conexion);
        } catch (SQLException ex) {
            Logger.getLogger(nombreClase).log(Level.SEVERE, null, ex);
        }
    }

    public boolean ifCodigoExist(String codigo) {
        for (int i = 0; i < faltas.size(); i++) {
            if (faltas.get(i).getCodigo().equals(codigo)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Falta> getCentros() {
        return faltas;
    }

    public Falta getById(int id) {
        Falta o = null;
        for (int i = 0; i < faltas.size(); i++) {
            if (faltas.get(i).getId() == id) {
                o = faltas.get(i);
            }
        }
        return o;
    }

    public void rellenarTabla(JTable tabla) {
        dtm = (DefaultTableModel) tabla.getModel();
        columnas = new Object[dtm.getColumnCount()];
        dtm.setRowCount(0);
        for (int i = 0; i < faltas.size(); i++) {
            dtm.addRow(addRow(faltas.get(i)));
        }
        tabla.setModel(dtm);
    }

    public void rellenarTablaDefault(JTable tabla) {
        ejecutarConsulta(consultaFaltas+ORDER);
        dtm = (DefaultTableModel) tabla.getModel();
        columnas = new Object[dtm.getColumnCount()];
        dtm.setRowCount(0);
        for (int i = 0; i < faltas.size(); i++) {
            dtm.addRow(addRow(faltas.get(i)));
        }
        tabla.setModel(dtm);
    }

    public void rellenarTablaByTrabajador(JTable tabla, String codigo) {
        ejecutarConsulta(consultaFaltas + "WHERE " + codTrabajador + " = '" + codigo + "'"+ORDER);
        dtm = (DefaultTableModel) tabla.getModel();
        columnas = new Object[dtm.getColumnCount()];
        dtm.setRowCount(0);
        for (int i = 0; i < faltas.size(); i++) {
            dtm.addRow(addRow(faltas.get(i)));
        }
        tabla.setModel(dtm);
    }

    private Object[] addRow(Falta o) {
        columnas = new Object[3];
        columnas[0] = o.getId();
        columnas[1] = o.getCodigo();
        columnas[2] = o.getFecha_inicio();
        columnas[3] = o.getFecha_fin();
        return columnas;
    }

    public boolean insert(Falta o) {
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
            sqlDate = new java.sql.Date(o.getFecha_inicio().getTime());
            ps.setDate(3, sqlDate);
            if (o.getFecha_fin() != null) {
                sqlDate = new java.sql.Date(o.getFecha_fin().getTime());
            } else {
                sqlDate = null;
            }
            ps.setDate(4, sqlDate);
            ps.setString(5, o.getMotivo());
            conn.desconectar(conexion);
            faltas.add(o);
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
            conn.desconectar(conexion);
            faltas.remove(getById(id));
            correcto = true;
        } catch (SQLException ex) {
            correcto = false;
            Logger.getLogger(nombreClase).log(Level.SEVERE, null, ex);
        }
        return correcto;
    }

    public boolean update(Falta o) {
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
            sqlDate = new java.sql.Date(o.getFecha_inicio().getTime());
            ps.setDate(3, sqlDate);
            if (o.getFecha_fin() != null) {
                sqlDate = new java.sql.Date(o.getFecha_fin().getTime());
            } else {
                sqlDate = null;
            }
            ps.setDate(4, sqlDate);
            ps.setString(5, o.getMotivo());
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
        for (int i = 0; i < faltas.size(); i++) {
            if (faltas.get(i).getCodigo().contains(cadena)) {
                dtm.addRow(addRow(faltas.get(i)));
            } else if (faltas.get(i).getMotivo().contains(cadena)) {
                dtm.addRow(addRow(faltas.get(i)));
            }
        }
        tabla.setModel(dtm);
    }

    public void buscarFecha(JTable tabla, String buscar, String codigo) {
        ejecutarConsulta(consultaFaltas + " WHERE (" + fechaInicio + " LIKE '%" + buscar + "%' OR " + fechaFin + "LIKE '%" + buscar + "%' ) AND codigo_trabajador=" + codigo);
        rellenarTabla(tabla);
    }
}
