/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Repository;

import Modelo.Entidades.AccidentesLaborales;
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
public final class AccidentesLaboralesRepository {

    private final String nombreClase = AccidentesLaboralesRepository.class.getName();
    private final ArrayList<AccidentesLaborales> objetos;
    private final String TABLA = "accidentes";
    private final String consultaFaltas = consultaPrincipal + TABLA;
    private final String id = "id";
    private final String fechaAccidente = "fecha_accidente";
    private final String fechaBaja = "fecha_baja";
    private final String descripcion = "descripcion";
    private final String zonaLesionada = "zona_lesionada";
    private final String lugar = "lugar";
    private final String idCentro = "id_centro";
    private final String idTrabajadorSustituto = "id_trabajador_sustituto";
    private final String ORDER = " ORDER BY " + fechaAccidente + " DESC ";

    public AccidentesLaboralesRepository() {
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
                AccidentesLaborales o = new AccidentesLaborales();
                o.setId(rs.getInt(id));

                if (rs.getDate(fechaAccidente) != null) {
                    o.setFecha_accidente(rs.getDate(fechaAccidente).toLocalDate());
                } else {
                    o.setFecha_accidente(null);
                }
                if (rs.getDate(fechaBaja) != null) {
                    o.setFecha_accidente(rs.getDate(fechaBaja).toLocalDate());
                } else {
                    o.setFecha_accidente(null);
                }
                o.setDescripcion(rs.getString(descripcion));
                o.setZona_lesionada(rs.getString(zonaLesionada));
                o.setLugar(rs.getString(lugar));
                o.setId_centro(rs.getInt(idCentro));
                o.setId_trabajador_sustituto(rs.getInt(idTrabajadorSustituto));
                objetos.add(o);
            }
            rs.close();
            conn.desconectar(conexion);
        } catch (SQLException ex) {
            Logger.getLogger(nombreClase).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<AccidentesLaborales> getCentros() {
        return objetos;
    }

    public AccidentesLaborales getById(int id) {
        AccidentesLaborales o = null;
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
        ejecutarConsulta(consultaFaltas + " WHERE " + idTrabajadorSustituto + " = '" + codigo + "'" + ORDER);
        dtm = (DefaultTableModel) tabla.getModel();
        columnas = new Object[dtm.getColumnCount()];
        dtm.setRowCount(0);
        for (int i = 0; i < objetos.size(); i++) {
            dtm.addRow(addRow(objetos.get(i)));
        }
        tabla.setModel(dtm);
    }

    private Object[] addRow(AccidentesLaborales o) {
        columnas = new Object[4];
        columnas[0] = o.getId();
        columnas[1] = o.getFecha_accidente();
        columnas[2] = o.getFecha_baja();
        columnas[3] = o.getDescripcion();
        columnas[4] = o.getZona_lesionada();
        columnas[5] = o.getLugar();
        return columnas;
    }

    public boolean insert(AccidentesLaborales o) {
        correcto = false;
        try {
            conn = new Conexion();
            conexion = conn.conectar_empresa_concreta(empresa);
            insert = "INSERT INTO " + TABLA + " (id, "
                    + fechaAccidente + ", "
                    + fechaBaja + ", "
                    + descripcion + ", "
                    + zonaLesionada + ", "
                    + lugar + ", "
                    + idCentro + ", "
                    + idTrabajadorSustituto + " "
                    + ") VALUES (NULL, ?, ?, ?, ?, ?, ?, ?)";
            ps = conexion.prepareStatement(insert);
            if (o.getFecha_accidente() != null) {
                sqlDate = java.sql.Date.valueOf(o.getFecha_accidente());
            } else {
                sqlDate = null;
            }
            ps.setDate(1, sqlDate);
            if (o.getFecha_baja() != null) {
                sqlDate = java.sql.Date.valueOf(o.getFecha_baja());
            } else {
                sqlDate = null;
            }
            ps.setDate(2, sqlDate);
            ps.setString(3, o.getDescripcion());
            ps.setString(4, o.getZona_lesionada());
            ps.setString(5, o.getLugar());
            ps.setInt(6, o.getId_centro());
            ps.setInt(7, o.getId_trabajador_sustituto());
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

    public boolean update(AccidentesLaborales o) {
        try {
            conn = new Conexion();
            conexion = conn.conectar_empresa_concreta(empresa);
            update = "UPDATE " + TABLA + " SET "
                    + fechaAccidente + "=?, "
                    + fechaBaja + "=?, "
                    + descripcion + "=?, "
                    + zonaLesionada + "=?, "
                    + lugar + "=?, "
                    + idCentro + "=?, "
                    + idTrabajadorSustituto + "=? WHERE " + id + "=?";
            ps = conexion.prepareStatement(update);
            if (o.getFecha_accidente() != null) {
                sqlDate = java.sql.Date.valueOf(o.getFecha_accidente());
            } else {
                sqlDate = null;
            }
            ps.setDate(1, sqlDate);
            if (o.getFecha_baja() != null) {
                sqlDate = java.sql.Date.valueOf(o.getFecha_baja());
            } else {
                sqlDate = null;
            }
            ps.setDate(2, sqlDate);
            ps.setString(3, o.getDescripcion());
            ps.setString(4, o.getZona_lesionada());
            ps.setString(5, o.getLugar());
            ps.setInt(6, o.getId_centro());
            ps.setInt(7, o.getId_trabajador_sustituto());
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

    public void buscarLugar(JTable tabla, String cadena) {
        DefaultTableModel dtm = (DefaultTableModel) tabla.getModel();
        for (int i = 0; i < objetos.size(); i++) {
            if (objetos.get(i).getLugar().contains(cadena)) {
                dtm.addRow(addRow(objetos.get(i)));
            } else if (objetos.get(i).getLugar().contains(cadena)) {
                dtm.addRow(addRow(objetos.get(i)));
            }
        }
        tabla.setModel(dtm);
    }

    public void buscarFechaAccidente(JTable tabla, String buscar, String codigo) {
        ejecutarConsulta(consultaFaltas + " WHERE (" + fechaAccidente + " LIKE '%" + buscar + "%' OR " + fechaAccidente + "LIKE '%" + buscar + "%' ) AND codigo_trabajador=" + codigo);
        rellenarTabla(tabla);
    }

    public void buscarFechaBaja(JTable tabla, String buscar, String codigo) {
        ejecutarConsulta(consultaFaltas + " WHERE (" + fechaBaja + " LIKE '%" + buscar + "%' OR " + fechaBaja + "LIKE '%" + buscar + "%' ) AND codigo_trabajador=" + codigo);
        rellenarTabla(tabla);
    }
}
