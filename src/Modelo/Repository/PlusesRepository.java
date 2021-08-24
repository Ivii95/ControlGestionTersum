/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Repository;

import Modelo.Entidades.Pluses;
import static Modelo.Repository.UtilidadesRepository.*;
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
public final class PlusesRepository {

    private final String nombreClase = PlusesRepository.class.getName();
    private final ArrayList<Pluses> pluses;

    private final String TABLA = "pluses";
    private final String consultaPluses = consultaPrincipal + TABLA;
    private final String id = "id";
    private final String cod = "codigo";
    private final String codTrabajador = "codigo_trabajador_incidencia";
    private final String fechaInicio = "fecha_inicio";
    private final String fechaFin = "fecha_fin";
    private final String descripcion = "descripcion";
    private final String horas = "horas";
    private final String precio = "precio";

    private final String ORDER = " ORDER BY " + fechaInicio + " DESC ";

    public PlusesRepository() {
        this.pluses = new ArrayList<>();
        ejecutarConsulta(consultaPluses);
    }

    /**
     *
     * @param consulta
     */
    public void ejecutarConsulta(String consulta) {
        pluses.clear();
        conn = new Conexion();
        conexion = conn.conectar_empresa_concreta(empresa);
        try {
            ps = conexion.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                Pluses o = new Pluses();
                o.setId(rs.getInt(id));
                o.setCodigo(rs.getString(cod));
                o.setCodigo_trabajador(rs.getString(codTrabajador));
                if (rs.getDate(fechaInicio) != null) {
                    o.setFecha_inicio(rs.getDate(fechaInicio).toLocalDate());
                } else {
                    o.setFecha_inicio(null);
                }
                if (rs.getDate(fechaFin) != null) {
                    o.setFecha_fin(rs.getDate(fechaFin).toLocalDate());
                } else {
                    o.setFecha_fin(null);
                }
                o.setDescripcion(rs.getString(descripcion));
                o.setHoras(rs.getInt(horas));
                o.setPrecio(rs.getInt(precio));
                pluses.add(o);
            }
            conn.desconectar(conexion);
        } catch (SQLException ex) {
            Logger.getLogger(nombreClase).log(Level.SEVERE, null, ex);
        }
    }

    public boolean ifCodigoExist(String codigo) {
        for (int i = 0; i < pluses.size(); i++) {
            if (pluses.get(i).getCodigo().equals(codigo)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Pluses> getCentros() {
        return pluses;
    }

    public Pluses getById(int id) {
        Pluses o = null;
        for (int i = 0; i < pluses.size(); i++) {
            if (pluses.get(i).getId() == id) {
                o = pluses.get(i);
            }
        }
        return o;
    }

    public void rellenarTabla(JTable tabla) {
        dtm = (DefaultTableModel) tabla.getModel();
        columnas = new Object[dtm.getColumnCount()];
        dtm.setRowCount(0);
        for (int i = 0; i < pluses.size(); i++) {
            dtm.addRow(addRow(pluses.get(i)));
        }
        tabla.setModel(dtm);
    }

    public void rellenarTablaDefault(JTable tabla) {
        ejecutarConsulta(consultaPluses + ORDER);
        dtm = (DefaultTableModel) tabla.getModel();
        columnas = new Object[dtm.getColumnCount()];
        dtm.setRowCount(0);
        for (int i = 0; i < pluses.size(); i++) {
            dtm.addRow(addRow(pluses.get(i)));
        }
        tabla.setModel(dtm);
    }

    public void rellenarTablaByTrabajador(JTable tabla, String codigo) {
        ejecutarConsulta(consultaPluses + " WHERE " + codTrabajador + " = '" + codigo + "'" + ORDER);
        dtm = (DefaultTableModel) tabla.getModel();
        columnas = new Object[dtm.getColumnCount()];
        dtm.setRowCount(0);
        for (int i = 0; i < pluses.size(); i++) {
            dtm.addRow(addRow(pluses.get(i)));
        }
        tabla.setModel(dtm);
    }

    public void rellenarTablaByIncidenciasDeUnCentro(JTable tabla, String codigo) {
        ejecutarConsulta("SELECT i.* FROM pluses i WHERE i.codigo_trabajador_incidencia IN(\n"
                + "    SELECT ct.codigo_trabajadores FROM centrostrabajadores ct WHERE ct.codigo_centro=" + codigo + ");");
        dtm = (DefaultTableModel) tabla.getModel();
        columnas = new Object[dtm.getColumnCount()];
        dtm.setRowCount(0);
        for (int i = 0; i < pluses.size(); i++) {
            dtm.addRow(addRow(pluses.get(i)));
        }
        tabla.setModel(dtm);
    }

    private Object[] addRow(Pluses o) {
        columnas = new Object[4];
        columnas[0] = o.getId();
        columnas[1] = o.getCodigo();
        columnas[2] = o.getFecha_inicio();
        columnas[3] = o.getTotal();
        return columnas;
    }

    public boolean insert(Pluses o) {
        correcto = false;
        try {
            conn = new Conexion();
            conexion = conn.conectar_empresa_concreta(empresa);
            insert = "INSERT INTO " + TABLA + " (id, "
                    + cod + ", "
                    + codTrabajador + ", "
                    + descripcion + ", "
                    + fechaInicio + ", "
                    + fechaFin + ", "
                    + horas + ", "
                    + precio + " "
                    + ") VALUES (NULL, ?, ?, ?, ?, ?, ?, ?)";
            ps = conexion.prepareStatement(insert);
            ps.setString(1, o.getCodigo());
            ps.setString(2, o.getCodigo_trabajador());
            ps.setString(3, o.getDescripcion());
            if (o.getFecha_inicio() != null) {
                sqlDate = java.sql.Date.valueOf(o.getFecha_inicio());
            } else {
                sqlDate = null;
            }
            System.out.println(sqlDate);
            ps.setDate(4, sqlDate);
            
            if (o.getFecha_fin() != null) {
                sqlDate = java.sql.Date.valueOf(o.getFecha_fin());
                Utilidades.UtilidadesPantalla.sumarRestarDiasFecha(sqlDate, 1);
            } else {
                sqlDate = null;
            }
            ps.setDate(5, sqlDate);
            ps.setInt(6, o.getHoras());
            ps.setInt(7, o.getPrecio());
            ps.executeUpdate();
            ps.close();
            conn.desconectar(conexion);
            pluses.add(o);
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
            ps.close();
            conn.desconectar(conexion);
            pluses.remove(getById(id));
            correcto = true;
        } catch (SQLException ex) {
            correcto = false;
            Logger.getLogger(nombreClase).log(Level.SEVERE, null, ex);
        }
        return correcto;
    }

    public boolean update(Pluses o) {
        try {
            conn = new Conexion();
            conexion = conn.conectar_empresa_concreta(empresa);
            update = "UPDATE " + TABLA + " SET "
                    + cod + "=?, "
                    + codTrabajador + "=?,"
                    + descripcion + "=?,"
                    + fechaInicio + "=?,"
                    + fechaFin + "=?,"
                    + horas + "=?,"
                    + precio + "=? WHERE " + id + "=?";
            ps = conexion.prepareStatement(update);
            ps.setString(1, o.getCodigo());
            ps.setString(2, o.getCodigo_trabajador());
            ps.setString(3, o.getDescripcion());
            if (o.getFecha_inicio() != null) {
                sqlDate = java.sql.Date.valueOf(o.getFecha_inicio());
            } else {
                sqlDate = null;
            }
            ps.setDate(4, sqlDate);
            if (o.getFecha_fin() != null) {
                sqlDate = java.sql.Date.valueOf(o.getFecha_fin());
            } else {
                sqlDate = null;
            }
            ps.setDate(5, sqlDate);
            ps.setInt(6, o.getHoras());
            ps.setInt(7, o.getPrecio());
            //PARAMETRO QUE VA AL WHERE QUE SIEMPRE ES EL ID
            ps.setInt(8, o.getId());
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
        for (int i = 0; i < pluses.size(); i++) {
            if (pluses.get(i).getCodigo().contains(cadena)) {
                dtm.addRow(addRow(pluses.get(i)));
            } else if (pluses.get(i).getDescripcion().contains(cadena)) {
                dtm.addRow(addRow(pluses.get(i)));
            }
        }
        tabla.setModel(dtm);
    }

    public void buscarFecha(JTable tabla, String buscar, String codigo) {
        ejecutarConsulta(consultaPluses + " WHERE (" + fechaInicio + " LIKE '%" + buscar + "%' OR " + fechaFin + "LIKE '%" + buscar + "%' ) AND codigo_trabajador=" + codigo + ORDER);
        rellenarTabla(tabla);
    }

}
