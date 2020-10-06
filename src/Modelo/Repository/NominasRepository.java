/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Repository;

import Modelo.Entidades.Nominas;
import java.util.ArrayList;
import static Modelo.Repository.UtilidadesRepository.*;
import static Utilidades.Utilidades.conn;
import static Utilidades.Utilidades.empresa;
import Utilidades.Conexion;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DisenoWeb
 */
public final class NominasRepository {

    private final String nombreClase = NominasRepository.class.getName();
    private final ArrayList<Nominas> nominas;

    private final String TABLA = "nominas";
    private final String consultaNominas = consultaPrincipal + TABLA;
    private final String id = "id";
    private final String codTrabajador = "codigo_trabajador";
    private final String fechaInicio = "fecha_inicio";
    private final String fechaFin = "fecha_fin";
    private final String importe = "importe";
    private final String activo = "activo";
    private final String ORDER = " ORDER BY " + fechaInicio + " DESC ";

    public NominasRepository() {
        this.nominas = new ArrayList<>();
        ejecutarConsulta(consultaNominas);
    }

    /**
     *
     * @param consulta
     */
    public void ejecutarConsulta(String consulta) {
        nominas.clear();
        conn = new Conexion();
        conexion = conn.conectar_empresa_concreta(empresa);
        try {
            ps = conexion.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                Nominas o = new Nominas();
                o.setId(rs.getInt(id));
                o.setCodigo_trabajador(rs.getInt(codTrabajador));
                o.setFecha_inicio(rs.getDate(fechaInicio).toLocalDate());
                o.setFecha_fin(rs.getDate(fechaFin).toLocalDate());
                o.setImporte(rs.getDouble(importe));
                o.setActivo(rs.getBoolean(activo));
                nominas.add(o);
            }
            conn.desconectar(conexion);
        } catch (SQLException ex) {
            Logger.getLogger(nombreClase).log(Level.SEVERE, null, ex);
        }
    }

    public boolean ifIdExist(int id) {
        for (int i = 0; i < nominas.size(); i++) {
            if (nominas.get(i).getId() == id) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Nominas> getCentros() {
        return nominas;
    }

    public Nominas getById(int id) {
        Nominas o = null;
        for (int i = 0; i < nominas.size(); i++) {
            if (nominas.get(i).getId() == id) {
                o = nominas.get(i);
            }
        }
        return o;
    }

    public void rellenarTabla(JTable tabla) {
        dtm = (DefaultTableModel) tabla.getModel();
        columnas = new Object[dtm.getColumnCount()];
        dtm.setRowCount(0);
        for (int i = 0; i < nominas.size(); i++) {
            dtm.addRow(addRow(nominas.get(i)));
        }
        tabla.setModel(dtm);
    }

    public void rellenarTablaDefault(JTable tabla) {
        ejecutarConsulta(consultaNominas + ORDER);
        dtm = (DefaultTableModel) tabla.getModel();
        columnas = new Object[dtm.getColumnCount()];
        dtm.setRowCount(0);
        for (int i = 0; i < nominas.size(); i++) {
            dtm.addRow(addRow(nominas.get(i)));
        }
        tabla.setModel(dtm);
    }

    public void rellenarTablaByTrabajador(JTable tabla, String codigo) {
        ejecutarConsulta(consultaNominas + " WHERE " + codTrabajador + " = '" + codigo + "'" + ORDER);
        dtm = (DefaultTableModel) tabla.getModel();
        columnas = new Object[dtm.getColumnCount()];
        dtm.setRowCount(0);
        for (int i = 0; i < nominas.size(); i++) {
            dtm.addRow(addRow(nominas.get(i)));
        }
        tabla.setModel(dtm);
    }

    private Object[] addRow(Nominas o) {
        columnas = new Object[4];
        columnas[0] = o.getId();
        columnas[1] = o.getCodigo_trabajador();
        columnas[2] = o.getFecha_inicio();
        columnas[3] = o.getImporte();
        return columnas;
    }

    public boolean insert(Nominas o) {
        correcto = false;
        try {
            conn = new Conexion();
            conexion = conn.conectar_empresa_concreta(empresa);
            insert = "INSERT INTO " + TABLA + " (id, "
                    + codTrabajador + ", "
                    + fechaInicio + ", "
                    + fechaFin + ", "
                    + importe + ", "
                    + activo + " "
                    + ") VALUES (NULL, ?, ?, ?, ?, ?, ?)";
            ps = conexion.prepareStatement(insert);
            ps.setInt(1, o.getCodigo_trabajador());
            if (o.getFecha_inicio() != null) {
                sqlDate = java.sql.Date.valueOf(o.getFecha_inicio());
            } else {
                sqlDate = null;
            }
            ps.setDate(2, sqlDate);
            if (o.getFecha_fin() != null) {
                sqlDate =  java.sql.Date.valueOf(o.getFecha_fin());
            } else {
                sqlDate = null;
            }
            ps.setDate(3, sqlDate);
            ps.setDouble(4, o.getImporte());
            ps.setBoolean(5, o.isActivo());
            ps.executeUpdate();
            ps.close();
            conn.desconectar(conexion);
            nominas.add(o);
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
            nominas.remove(getById(id));
            correcto = true;
        } catch (SQLException ex) {
            correcto = false;
            Logger.getLogger(nombreClase).log(Level.SEVERE, null, ex);
        }
        return correcto;
    }

    public boolean update(Nominas o) {
        try {
            conn = new Conexion();
            conexion = conn.conectar_empresa_concreta(empresa);
            update = "UPDATE " + TABLA + " SET "
                    + codTrabajador + "=?,"
                    + fechaInicio + "=?,"
                    + fechaFin + "=?,"
                    + importe + "=?,"
                    + activo + "=? WHERE " + id + "=?";
            ps = conexion.prepareStatement(update);
            ps.setInt(1, o.getCodigo_trabajador());

            if (o.getFecha_inicio() != null) {
                sqlDate = java.sql.Date.valueOf(o.getFecha_inicio());
            } else {
                sqlDate = null;
            }
            ps.setDate(2, sqlDate);

            if (o.getFecha_fin() != null) {
                sqlDate = java.sql.Date.valueOf(o.getFecha_fin());
            } else {
                sqlDate = null;
            }
            ps.setDate(3, sqlDate);

            ps.setDouble(4, o.getImporte());
            ps.setBoolean(5, o.isActivo());
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

    /*public void buscar(JTable tabla, String cadena) {
        DefaultTableModel dtm = (DefaultTableModel) tabla.getModel();
        for (int i = 0; i < nominas.size(); i++) {
            if (nominas.get(i).getImporte().contains(cadena)) {
                dtm.addRow(addRow(nominas.get(i)));
            } else if (nominas.get(i).getCodigo_trabajador()) {
                dtm.addRow(addRow(nominas.get(i)));
            }
        }
        tabla.setModel(dtm);
    }*/
    public void buscarFecha(JTable tabla, String buscar, String codigo) {
        ejecutarConsulta(consultaNominas + " WHERE (" + fechaInicio + " LIKE '%" + buscar + "%' OR " + fechaFin + "LIKE '%" + buscar + "%' ) AND codigo_trabajador=" + codigo + ORDER);
        rellenarTabla(tabla);
    }
}
