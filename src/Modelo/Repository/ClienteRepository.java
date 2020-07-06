/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Repository;

import static Modelo.Repository.UtilidadesRepository.*;
import Modelo.Entidades.Cliente;
import Modelo.Entidades.Sede;
import Utilidades.Conexion;
import Utilidades.Utilidades;
import static Utilidades.Utilidades.conn;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DisenoWeb
 */
public class ClienteRepository {

    private final ArrayList<Cliente> clientes;
    private final String TABLA = "clientes";
    private final String consultaClientes = consultaPrincipal + TABLA;
    private final String id = "id";
    private final String cod = "codigo";
    private final String cif = "cif";
    private final String nombreFiscal = "nombre_fiscal";
    private final String nombreComercial = "nombre_comercial";
    private final String contacto = "contacto";
    private final String telefono = "telefono";
    private final String fax = "fax";
    private final String movil = "movil";
    private final String email = "email";
    private final String fechaAlta = "fecha_alta";
    private final String fechaBaja = "fecha_baja";
    private final String ORDER = " ORDER BY " + nombreComercial + " ASC ";

    public ClienteRepository() {
        this.clientes = new ArrayList<>();
        ejecutarConsulta(consultaClientes);
    }

    private void ejecutarConsulta(String consulta) {
        clientes.clear();
        Utilidades.conn = new Conexion();
        conexion = conn.conectar_empresa_concreta(Utilidades.empresa);
        try {
            ps = conexion.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt(id));
                cliente.setCodigo(rs.getString(cod));
                cliente.setCif(rs.getString(cif));
                cliente.setNombre_fiscal(rs.getString(nombreFiscal));
                cliente.setNombre_comercial(rs.getString(nombreComercial));
                cliente.setContacto(rs.getString(contacto));
                cliente.setTelefono(rs.getInt(telefono));
                cliente.setFax(rs.getInt(fax));
                cliente.setMovil(rs.getInt(movil));
                cliente.setEmail(rs.getString(email));
                cliente.setFecha_alta(rs.getDate(fechaAlta));
                cliente.setFecha_baja(rs.getDate(fechaBaja));
                clientes.add(cliente);
            }
            conn.desconectar(conexion);
        } catch (SQLException ex) {
            Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Cliente> getLista() {
        return clientes;
    }

    /**
     *
     * @param id
     * @return
     */
    public Cliente getById(int id) {
        Cliente o = null;
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getId() == id) {
                o = clientes.get(i);
            }
        }
        return o;
    }

    public Cliente getByNombre(String nombre) {
        Cliente o = null;
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getNombre_comercial().equals(nombre)) {
                o = clientes.get(i);
            }
        }
        return o;
    }

    /**
     *
     * @param o
     * @return
     */
    private Object[] addRow(Cliente o) {
        columnas = new Object[4];
        columnas[0] = o.getId();
        columnas[1] = o.getCif();
        columnas[2] = o.getCodigo();
        columnas[3] = o.getNombre_comercial();
        return columnas;
    }

    /**
     *
     * @param tabla
     */
    public void rellenarTablaDefault(JTable tabla) {
        ejecutarConsulta(consultaClientes);
        dtm = (DefaultTableModel) tabla.getModel();
        columnas = new Object[dtm.getColumnCount()];
        dtm.setRowCount(0);
        for (int i = 0; i < clientes.size(); i++) {
            dtm.addRow(addRow(clientes.get(i)));
        }
        tabla.setModel(dtm);
    }

    public void rellenarTablaPorSedes(JTable tabla, ArrayList<Sede> sedes) {
        dtm = (DefaultTableModel) tabla.getModel();
        dtm.setRowCount(0);
        columnas = new Object[dtm.getColumnCount()];
        for (int j = 0; j < sedes.size(); j++) {
            ejecutarConsulta("SELECT * FROM clientes c WHERE c.id IN ( SELECT s.id_cliente FROM sedecliente s WHERE id_sede=" + sedes.get(j).getId() + ")");
            for (int i = 0; i < clientes.size(); i++) {
                dtm.addRow(addRow(clientes.get(i)));
            }
        }
        tabla.setModel(dtm);
    }

    public void rellenarTabla(JTable tabla) {
        dtm = (DefaultTableModel) tabla.getModel();
        columnas = new Object[dtm.getColumnCount()];
        dtm.setRowCount(0);
        for (int i = 0; i < clientes.size(); i++) {
            dtm.addRow(addRow(clientes.get(i)));
        }
        tabla.setModel(dtm);
    }

    public JComboBox rellenarCombo(JComboBox combo) {
        combo.removeAllItems();
        for (int i = 0; i < clientes.size(); i++) {
            combo.addItem(clientes.get(i).getNombre_comercial());
        }
        return combo;
    }

    public boolean ifCodigoExist(String codigo) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getCodigo().equals(codigo)) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param o
     * @return
     */
    public boolean insert(Cliente o) {
        correcto = false;
        try {
            Utilidades.conn = new Conexion();
            conexion = conn.conectar_empresa_concreta(Utilidades.empresa);
            insert = "INSERT INTO " + TABLA + " (id, "
                    + cod + ", "
                    + cif + ", "
                    + nombreFiscal + ", "
                    + nombreComercial + ", "
                    + contacto + ", "
                    + telefono + ", "
                    + fax + ", "
                    + movil + ", "
                    + email + ", "
                    + fechaAlta + ", "
                    + fechaBaja + " "
                    + ") VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            ps = conexion.prepareStatement(insert);
            ps.setString(1, o.getCodigo());
            ps.setString(2, o.getCif());
            ps.setString(3, o.getNombre_fiscal());
            ps.setString(4, o.getNombre_comercial());
            ps.setString(5, o.getContacto());
            ps.setInt(6, o.getTelefono());
            ps.setInt(7, o.getFax());
            ps.setInt(8, o.getMovil());
            ps.setString(9, o.getEmail());
            if (o.getFecha_alta() != null) {
                sqlDate = new java.sql.Date(o.getFecha_alta().getTime());
            }
            ps.setDate(10, sqlDate);
            if (o.getFecha_baja() != null) {
                sqlDate = new java.sql.Date(o.getFecha_baja().getTime());
            }

            ps.setDate(11, sqlDate);
            ps.executeUpdate();
            conn.desconectar(conexion);
            clientes.add(0, o);
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
            Utilidades.conn = new Conexion();
            conexion = conn.conectar_empresa_concreta(Utilidades.empresa);
            delete = "DELETE FROM " + TABLA + " WHERE id=?";
            ps = conexion.prepareStatement(delete);
            ps.setInt(1, id);   
            ps.executeUpdate();
            conn.desconectar(conexion);
            clientes.remove(getById(id));
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
    public boolean update(Cliente o) {
        try {
            Utilidades.conn = new Conexion();
            conexion = conn.conectar_empresa_concreta(Utilidades.empresa);
            update = "UPDATE " + TABLA + " SET "
                    + cod + "=?, "
                    + cif + "=?, "
                    + nombreFiscal + "=?, "
                    + nombreComercial + "=?, "
                    + contacto + "=?, "
                    + telefono + "=?, "
                    + fax + "=?, "
                    + movil + "=?, "
                    + email + "=?, "
                    + fechaAlta + "=?, "
                    + fechaBaja + "=?"
                    + " WHERE " + id + "=?";
            ps = conexion.prepareStatement(update);
            ps.setString(1, o.getCodigo());
            ps.setString(2, o.getCif());
            ps.setString(3, o.getNombre_fiscal());
            ps.setString(4, o.getNombre_comercial());
            ps.setString(5, o.getContacto());
            ps.setInt(6, o.getTelefono());
            ps.setInt(7, o.getFax());
            ps.setInt(8, o.getMovil());
            ps.setString(9, o.getEmail());
            sqlDate = new java.sql.Date(o.getFecha_alta().getTime());
            ps.setDate(10, sqlDate);
            if (o.getFecha_baja() != null) {
                sqlDate = new java.sql.Date(o.getFecha_baja().getTime());
            } else {
                sqlDate = null;
            }
            ps.setDate(11, sqlDate);
            ps.setInt(12, o.getId());
            conn.desconectar(conexion);
        } catch (SQLException ex) {
            correcto = false;
            Logger.getLogger(TrabajadorRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        ejecutarConsulta(consultaClientes);
        return correcto;
    }

    /**
     *
     * @param tabla
     * @param cadena
     */
    public void buscar(JTable tabla, String cadena) {
        DefaultTableModel dtm = (DefaultTableModel) tabla.getModel();
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getNombre_comercial().contains(cadena) || clientes.get(i).getCif().contains(cadena)) {
                dtm.addRow(addRow(clientes.get(i)));
            } else if (Utilidades.isInteger(cadena)) {
                if (clientes.get(i).getCodigo().equals(Integer.parseInt(cadena))) {
                    dtm.addRow(addRow(clientes.get(i)));
                }
            }
        }
        tabla.setModel(dtm);
    }
}
