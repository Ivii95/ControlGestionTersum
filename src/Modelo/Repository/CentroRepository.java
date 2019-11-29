/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Repository;

import Modelo.Entidades.Centro;
import java.util.ArrayList;
import static Modelo.Repository.UtilidadesRepository.*;
import Utilidades.Conexion;
import static Utilidades.Utilidades.conn;
import static Utilidades.Utilidades.empresa;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DisenoWeb
 */
public final class CentroRepository {

    private final ArrayList<Centro> centros;
    private final String TABLA = "centros";
    private final String consultaCentros = consultaPrincipal + TABLA;
    private final String id = "id";
    private final String cod = "codigo";
    private final String codCliente = "codigo_cliente";
    private final String nombre = "nombre";
    private final String direccion = "direccion";
    private final String poblacion = "poblacion";
    private final String telefono = "telefono";
    private final String contacto = "contacto";
    private final String email = "email";
    private final String horasNecesariosSemana = "horas_semana";
    private final String facturacionMes = "facturacion_mes";
    private final String ORDER = " ORDER BY " + nombre + " ASC ";

    public CentroRepository() {
        this.centros = new ArrayList<>();
        //ejecutarConsulta(consultaCentros);
    }

    /**
     *
     * @param consulta
     */
    public void ejecutarConsulta(String consulta) {
        centros.clear();
        conn = new Conexion();
        conexion = conn.conectar_empresa_concreta(empresa);
        try {
            ps = conexion.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                Centro centro = new Centro();
                centro.setId(rs.getInt(id));
                centro.setCodigo(rs.getString(cod));
                centro.setCodigo_cliente(rs.getString(codCliente));
                centro.setNombre(rs.getString(nombre));
                centro.setDireccion(rs.getString(direccion));
                centro.setPoblacion(rs.getString(poblacion));
                centro.setTelefono(rs.getInt(telefono));
                centro.setContacto(rs.getString(contacto));
                centro.setEmail(rs.getString(email));
                centro.setHoras_semana(rs.getInt(horasNecesariosSemana));
                centro.setFacturacion_mes(rs.getFloat(facturacionMes));
                centros.add(centro);
            }
            conn.desconectar(conexion);
        } catch (SQLException ex) {
            Logger.getLogger(CentroRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param codigo_cliente
     * @return
     */
    public float getFacturacionTotal(String codigo_cliente) {
        float facturacion = 0;
        for (int i = 0; i < centros.size(); i++) {
            if (centros.get(i).getCodigo_cliente().equals(codigo_cliente)) {
                facturacion = facturacion + centros.get(i).getFacturacion_mes();
            }
        }
        return facturacion;
    }

    /**
     *
     * @param codigo
     * @return
     */
    public boolean ifCodigoExist(String codigo) {
        for (int i = 0; i < centros.size(); i++) {
            if (centros.get(i).getCodigo().equals(codigo)) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @return ArrayList
     */
    public ArrayList<Centro> getCentros() {
        return centros;
    }

    /**
     *
     * @param id
     * @return
     */
    public Centro getById(int id) {
        Centro o = null;
        for (int i = 0; i < centros.size(); i++) {
            if (centros.get(i).getId() == id) {
                o = centros.get(i);
            }
        }
        return o;
    }

    public void rellenarTabla(JTable tabla) {
        dtm = (DefaultTableModel) tabla.getModel();
        columnas = new Object[dtm.getColumnCount()];
        dtm.setRowCount(0);
        for (int i = 0; i < centros.size(); i++) {
            dtm.addRow(addRow(centros.get(i)));
        }
        tabla.setModel(dtm);
    }

    /**
     *
     * @param tabla
     */
    public void rellenarTablaDefault(JTable tabla) {
        ejecutarConsulta(consultaCentros + " ORDER BY " + nombre);
        dtm = (DefaultTableModel) tabla.getModel();
        columnas = new Object[dtm.getColumnCount()];
        dtm.setRowCount(0);
        for (int i = 0; i < centros.size(); i++) {
            dtm.addRow(addRow(centros.get(i)));
        }
        tabla.setModel(dtm);
    }
    public void rellenarTablaCentrosByTrabajador(JTable tabla ,String codigo_trabajador){
        String consultaEspecial=consultaCentros+" WHERE codigo=( SELECT codigo_centro FROM centrostrabajadores WHERE codigo_trabajadores = '"+codigo_trabajador+"' ) "+ORDER;
        ejecutarConsulta(consultaEspecial);
        dtm = (DefaultTableModel) tabla.getModel();
        columnas = new Object[dtm.getColumnCount()];
        dtm.setRowCount(0);
        for (int i = 0; i < centros.size(); i++) {
            dtm.addRow(addRow(centros.get(i)));
        }
        tabla.setModel(dtm);
    }
    public void rellenarCombo(JComboBox combo) {
        ejecutarConsulta(consultaCentros + " ORDER BY " + nombre);
        combo.addItem("Sin centro");
        for (int i = 0; i < centros.size(); i++) {
            combo.addItem(centros.get(i).getNombre());
        }
    }

    public JComboBox rellenarComboByCodigoCliente(JComboBox combo, String cod_cliente) {
        ejecutarConsulta(consultaCentros + " WHERE " + codCliente + "=" + cod_cliente + " ORDER BY " + nombre);
        combo.addItem("Selecciona uno");
        for (int i = 0; i < centros.size(); i++) {
            if (centros.get(i).getCodigo_cliente().equals(cod_cliente)) {
                combo.addItem(centros.get(i).getNombre());
            }
        }
        return combo;
    }

    /**
     *
     * @param o
     * @return
     */
    private Object[] addRow(Centro o) {
        columnas = new Object[3];
        columnas[0] = o.getId();
        columnas[1] = o.getCodigo();
        columnas[2] = o.getNombre();
        return columnas;
    }

    /**
     *
     * @param centro
     * @return
     */
    public boolean insert(Centro centro) {
        correcto = false;
        try {
            conn = new Conexion();
            conexion = conn.conectar_empresa_concreta(empresa);
            insert = "INSERT INTO " + TABLA + " (id, "
                    + cod + ", "
                    + codCliente + ", "
                    + nombre + ", "
                    + direccion + ", "
                    + poblacion + ", "
                    + telefono + ", "
                    + contacto + ", "
                    + email + ", "
                    + horasNecesariosSemana + ", "
                    + facturacionMes + " "
                    + ") VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            ps = conexion.prepareStatement(insert);
            ps.setString(1, centro.getCodigo());
            ps.setString(2, centro.getCodigo_cliente());
            ps.setString(3, centro.getNombre());
            ps.setString(4, centro.getDireccion());
            ps.setString(5, centro.getPoblacion());
            ps.setInt(6, centro.getTelefono());
            ps.setString(7, centro.getContacto());
            ps.setString(8, centro.getEmail());
            ps.setInt(9, centro.getHoras_semana());
            ps.setFloat(10, centro.getFacturacion_mes());
            conn.desconectar(conexion);
            centros.add(centro);
            correcto = true;
        } catch (SQLException ex) {
            correcto = false;
            Logger.getLogger(TrabajadorRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return correcto;
    }

    /**
     *
     * @param id
     * @return
     */
    public boolean delete(int id) {
        correcto = false;
        try {
            conn = new Conexion();
            conexion = conn.conectar_empresa_concreta(empresa);
            delete = "DELETE FROM " + TABLA + " WHERE id=?";
            ps = conexion.prepareStatement(delete);
            ps.setInt(1, id);
            conn.desconectar(conexion);
            centros.remove(getById(id));
            correcto = true;
        } catch (SQLException ex) {
            correcto = false;
            Logger.getLogger(TrabajadorRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return correcto;
    }

    /**
     *
     * @param o
     * @return
     */
    public boolean update(Centro o) {
        try {
            conn = new Conexion();
            conexion = conn.conectar_empresa_concreta(empresa);
            update = "UPDATE " + TABLA + " SET "
                    + cod + "=?, "
                    + codCliente + "=?, "
                    + nombre + "=?, "
                    + direccion + "=?,"
                    + poblacion + "=?,"
                    + telefono + "=?,"
                    + contacto + "=?,"
                    + email + "=?, "
                    + horasNecesariosSemana + "=?, "
                    + facturacionMes + "=? WHERE " + id + "=?";
            ps = conexion.prepareStatement(update);
            ps.setString(1, o.getCodigo());
            ps.setString(2, o.getCodigo_cliente());
            ps.setString(3, o.getNombre());
            ps.setString(4, o.getDireccion());
            ps.setString(5, o.getPoblacion());
            ps.setInt(6, o.getTelefono());
            ps.setString(7, o.getContacto());
            ps.setString(8, o.getEmail());
            ps.setInt(9, o.getHoras_semana());
            ps.setFloat(10, o.getFacturacion_mes());
            //PARAMETRO QUE VA AL WHERE QUE SIEMPRE ES EL ID
            ps.setInt(11, o.getId());
            conn.desconectar(conexion);
            ejecutarConsulta(consultaPrincipal);
            correcto = true;
        } catch (SQLException ex) {
            correcto = false;
            Logger.getLogger(TrabajadorRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return correcto;
    }

    public void buscar(JTable tabla, String cadena) {
        DefaultTableModel dtm = (DefaultTableModel) tabla.getModel();
        for (int i = 0; i < centros.size(); i++) {
            if (centros.get(i).getCodigo().contains(cadena)) {
                dtm.addRow(addRow(centros.get(i)));
            } else if (centros.get(i).getNombre().contains(cadena)) {
                dtm.addRow(addRow(centros.get(i)));
            }
        }
        tabla.setModel(dtm);
    }
}
