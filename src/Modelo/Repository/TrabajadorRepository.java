/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Repository;

import Modelo.Entidades.Centro;
import Modelo.Entidades.Sede;
import static Modelo.Repository.UtilidadesRepository.*;
import Modelo.Entidades.Trabajador;
import Utilidades.Conexion;
import Utilidades.Utilidades;
import static Utilidades.Utilidades.conn;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DisenoWeb
 */
public class TrabajadorRepository {

    private final String nombreClase = TrabajadorRepository.class.getName();
    private final ArrayList<Trabajador> trabajadores;
    private final String TABLA = "trabajadores";
    private final String consulta = consultaPrincipal + TABLA;
    private final String ORDER = " ORDER BY apellido1 ";

    public TrabajadorRepository() {
        trabajadores = new ArrayList<>();
    }

    public void insertFromLista(Trabajador trabajador) {
        trabajadores.add(trabajador);
    }

    public void deleteFromLista(Trabajador trabajador) {
        trabajadores.remove(trabajador);
    }

    public ArrayList<Trabajador> getTrabajadores() {
        return trabajadores;
    }

    /**
     *
     * @param id
     * @return
     */
    public Trabajador getById(int id) {
        Trabajador t = null;
        for (int i = 0; i < trabajadores.size(); i++) {
            if (trabajadores.get(i).getId() == id) {
                t = trabajadores.get(i);
            }
        }
        return t;
    }

    /**
     *
     * @param codigo
     * @return
     */
    public Trabajador getByCodigo(String codigo) {
        Trabajador t = null;
        for (int i = 0; i < trabajadores.size(); i++) {
            if (trabajadores.get(i).getCodigo().equals(codigo)) {
                t = trabajadores.get(i);
            }
        }
        return t;
    }

    /**
     *
     * @param nombre
     * @return
     */
    public Trabajador getByNombre(String nombre) {
        Trabajador t = null;
        for (int i = 0; i < trabajadores.size(); i++) {
            if (trabajadores.get(i).getNombre().equals(nombre)) {
                t = trabajadores.get(i);
            }
        }
        return t;
    }

    public boolean ifCodigoExist(String codigo) {
        for (int i = 0; i < trabajadores.size(); i++) {
            if (trabajadores.get(i).getCodigo().equals(codigo)) {
                return true;
            }
        }
        return false;
    }

    public void rellenarListaDefault() {
        ejecutarConsulta(consulta + ORDER);
    }

    /**
     *
     * @param consulta
     */
    private void ejecutarConsulta(String consulta) {
        try {
            trabajadores.clear();
            Utilidades.conn = new Conexion();
            conexion = conn.conectar_empresa_concreta(Utilidades.empresa);
            ps = conexion.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                Trabajador trabajador = new Trabajador();
                trabajador.setId(rs.getInt("id"));
                trabajador.setCodigo(rs.getString("codigo"));
                trabajador.setCodigo_tipo_contrato(rs.getInt("codigo_tipo_contrato"));
                trabajador.setCodigo_sede(rs.getString("codigo_sede"));
                trabajador.setApellido1(rs.getString("apellido1"));
                trabajador.setApellido2(rs.getString("apellido2"));
                trabajador.setNombre(rs.getString("nombre"));
                trabajador.setDNI(rs.getString("DNI"));
                trabajador.setDireccion(rs.getString("direccion"));
                trabajador.setPoblacion(rs.getString("poblacion"));
                if (rs.getDate("fechanacimiento") != null) {
                    trabajador.setFechanacimiento(rs.getDate("fechanacimiento").toLocalDate());
                } else {
                    trabajador.setFechanacimiento(null);
                }
                trabajador.setCategoria(rs.getString("categoria"));
                if (rs.getDate("antiguedad") != null) {
                    trabajador.setAntiguedad(rs.getDate("antiguedad").toLocalDate());
                } else {
                    trabajador.setAntiguedad(null);
                }
                trabajador.setTelefono(rs.getInt("telefono"));
                trabajador.setEmail(rs.getString("email"));
                if (rs.getDate("fecha_alta") != null) {
                    trabajador.setFecha_alta(rs.getDate("fecha_alta").toLocalDate());
                } else {
                    trabajador.setFecha_alta(null);
                }
                if (rs.getDate("fecha_baja") != null) {
                    trabajador.setFecha_baja(rs.getDate("fecha_baja").toLocalDate());
                } else {
                    trabajador.setFecha_baja(null);
                }
                trabajador.setHoras_semana_alta(rs.getString("horas_semana_alta"));
                trabajador.setHoras_semana_reales(rs.getString("horas_semana_reales"));
                trabajador.setCoste_mes(rs.getFloat("coste_mes"));
                trabajador.setSeguridad_social(rs.getString("seguridad_social"));
                trabajador.setIban(rs.getString("iban"));
                trabajadores.add(trabajador);
            }
            conn.desconectar(conexion);
        } catch (SQLException ex) {
            Logger.getLogger(nombreClase).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param tabla
     * @param centro
     */
    public void rellenarTablaPorCodigoCentro(JTable tabla, Centro centro) {
        String consultaEspecial = "SELECT t.* \n"
                + "FROM trabajadores t \n"
                + "WHERE t.codigo IN(\n"
                + "	SELECT ct.codigo_trabajadores \n"
                + "    FROM centrostrabajadores ct \n"
                + "    WHERE ct.codigo_centro=" + centro.getCodigo() + "\n"
                + ");";
        ejecutarConsulta(consultaEspecial); //METODO PARA RELLENAR LA LISTA DE TRABAJADORES EN ESTE CASO
        dtm = (DefaultTableModel) tabla.getModel();
        columnas = new Object[dtm.getColumnCount()];
        dtm.setRowCount(0);
        for (int i = 0; i < trabajadores.size(); i++) {
            dtm.addRow(addRow(trabajadores.get(i)));
        }
        tabla.setModel(dtm);
    }
    /**
     * Rellena una tablacon los datos d elos trabajadores que no estan contratados
     * @param tabla
     * @param centro 
     */
    public void rellenarTablaTrabajadoresNoContratados(JTable tabla, Centro centro) {

        String consultaEspecial = "SELECT t.* "
                + "FROM trabajadores t "
                + "WHERE t.codigo NOT IN("
                + "SELECT ct.codigo_trabajadores "
                + "FROM centrostrabajadores ct "
                + "WHERE ct.codigo_centro='" + centro.getCodigo() + "')";
        ejecutarConsulta(consultaEspecial); //METODO PARA RELLENAR LA LISTA DE TRABAJADORES
        dtm = (DefaultTableModel) tabla.getModel();
        columnas = new Object[dtm.getColumnCount()];
        dtm.setRowCount(0);
        for (int i = 0; i < trabajadores.size(); i++) {
            dtm.addRow(addRow(trabajadores.get(i)));
        }
        tabla.setModel(dtm);
    }
    /**
     * Rellena una tabla con todos los trabajadores diponibles en una fecha determinada
     * @param tabla
     * @param fecha 
     */
    public void rellenarTablaTrabajadoresDisponibles(JTable tabla,LocalDate fecha) {

        String consultaEspecial = "SELECT * FROM `trabajadores` WHERE `codigo` NOT IN (SELECT `codigo_trabajador_vacaciones` FROM vacaciones WHERE `fecha_fin` >= \""+fecha.getYear()+"-"+fecha.getMonth()+"-"+fecha.getDayOfMonth()+"\");";
        ejecutarConsulta(consultaEspecial); //METODO PARA RELLENAR LA LISTA DE TRABAJADORES
        dtm = (DefaultTableModel) tabla.getModel();
        columnas = new Object[dtm.getColumnCount()];
        dtm.setRowCount(0);
        for (int i = 0; i < trabajadores.size(); i++) {
            dtm.addRow(addRow(trabajadores.get(i)));
        }
        tabla.setModel(dtm);
    }

    public void rellenarTablaTrabajadoresSinCentro(JTable tabla) {
        String consultaEspecial = "SELECT t.* \n" //
                + "FROM trabajadores t \n"
                + "WHERE t.codigo NOT IN (\n"
                + "	SELECT ct.codigo_trabajadores \n"
                + "    FROM centrostrabajadores ct \n"
                + ");";
        ejecutarConsulta(consultaEspecial); //METODO PARA RELLENAR LA LISTA DE TRABAJADORES EN ESTE CASO
        dtm = (DefaultTableModel) tabla.getModel();
        columnas = new Object[dtm.getColumnCount()];
        dtm.setRowCount(0);
        for (int i = 0; i < trabajadores.size(); i++) {
            dtm.addRow(addRow(trabajadores.get(i)));
        }
        tabla.setModel(dtm);
    }

    public void rellenarTablaDefault(JTable tabla) {
        ejecutarConsulta(consulta); //METODO PARA RELLENAR LA LISTA DE TRABAJADORES EN ESTE CASO
        dtm = (DefaultTableModel) tabla.getModel();
        columnas = new Object[dtm.getColumnCount()];
        dtm.setRowCount(0);
        for (int i = 0; i < trabajadores.size(); i++) {
            dtm.addRow(addRow(trabajadores.get(i)));
        }
        tabla.setModel(dtm);
    }

    private Object[] addRow(Trabajador t) {
        columnas = new Object[4];
        columnas[0] = t.getId();
        columnas[1] = t.getCodigo();
        columnas[2] = t.getNombre();
        String apellidos = t.getApellido1() + " " + t.getApellido2();
        columnas[3] = apellidos;
        return columnas;
    }

    public void rellenarTabla(JTable tabla) {
        dtm = (DefaultTableModel) tabla.getModel();
        columnas = new Object[dtm.getColumnCount()];
        dtm.setRowCount(0);
        for (int i = 0; i < trabajadores.size(); i++) {
            dtm.addRow(addRow(trabajadores.get(i)));
        }
        tabla.setModel(dtm);
    }

    public void rellenarTablaPorSedes(JTable tabla, ArrayList<Sede> sedes) {
        dtm = (DefaultTableModel) tabla.getModel();
        dtm.setRowCount(0);
        columnas = new Object[dtm.getColumnCount()];
        for (int j = 0; j < sedes.size(); j++) {
            ejecutarConsulta("SELECT t.* FROM trabajadores t WHERE codigo IN"
                    + "(SELECT ct.codigo_trabajadores FROM centrostrabajadores ct WHERE codigo_centro IN"
                    + "(SELECT centros.codigo FROM centros WHERE codigo_cliente IN"
                    + "(SELECT c.codigo FROM clientes c WHERE c.id IN "
                    + "(SELECT s.id_cliente FROM sedecliente s WHERE id_sede=" + sedes.get(j).getId() + "))))");
            for (int i = 0; i < trabajadores.size(); i++) {
                dtm.addRow(addRow(trabajadores.get(i)));
            }
        }
        tabla.setModel(dtm);
    }

    /**
     *
     * @param codigoTrabajador
     * @return
     */
    public Object[] buscarTrabajadoresPorCentrosDeUnCodigoTrabajador(String codigoTrabajador) {
        String consultaEspecial
                = "SELECT trabajadores.* \n"
                + "FROM trabajadores\n"
                + "WHERE trabajadores.codigo IN(\n"
                + "    SELECT ct.codigo_trabajadores \n"
                + "    FROM centrostrabajadores ct \n"
                + "    WHERE ct.codigo_centro=(\n"
                + "    	SELECT ct.codigo_centro \n"
                + "        FROM centrostrabajadores ct \n"
                + "        WHERE ct.codigo_trabajadores=" + codigoTrabajador + "));";
        ejecutarConsulta(consultaEspecial);
        Object[] datos = new Object[trabajadores.size()];
        for (int i = 0; i < trabajadores.size(); i++) {
            if (!trabajadores.get(i).getCodigo().equals(codigoTrabajador)) {
                datos[i] = trabajadores.get(i).getNombre();
            }
        }
        return datos;
    }

    /**
     *
     * @param trabajador
     * @return
     */
    public boolean insert(Trabajador trabajador) {
        correcto = false;
        try {
            Utilidades.conn = new Conexion();
            conexion = conn.conectar_empresa_concreta(Utilidades.empresa);
            insert = "INSERT INTO trabajadores (id,"
                    + "codigo,"
                    + "codigo_tipo_contrato,"
                    + "codigo_sede,"
                    + "apellido1,"
                    + "apellido2,"
                    + "nombre,"
                    + "DNI,"
                    + "direccion,"
                    + "poblacion,"
                    + "fechanacimiento,"
                    + "categoria,"
                    + "antiguedad,"
                    + "telefono,"
                    + "email,"
                    + "fecha_alta,"
                    + "fecha_baja,"
                    + "horas_semana_alta,"
                    + "horas_semana_reales,"
                    + "coste_mes,"
                    + "seguridad_social,"
                    + "iban) "
                    + "VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            ps = conexion.prepareStatement(insert);
            ps.setString(1, trabajador.getCodigo());
            ps.setInt(2, trabajador.getCodigo_tipo_contrato());
            ps.setString(3, trabajador.getCodigo_sede());
            ps.setString(4, trabajador.getApellido1());
            ps.setString(5, trabajador.getApellido2());
            ps.setString(6, trabajador.getNombre());
            ps.setString(7, trabajador.getDNI());
            ps.setString(8, trabajador.getDireccion());
            ps.setString(9, trabajador.getPoblacion());
            if (trabajador.getFechanacimiento() != null) {
                sqlDate = java.sql.Date.valueOf(trabajador.getFechanacimiento());
            }
            ps.setDate(10, sqlDate);
            ps.setString(11, trabajador.getCategoria());
            if (trabajador.getAntiguedad() != null) {
                sqlDate = java.sql.Date.valueOf(trabajador.getAntiguedad());
            }
            ps.setDate(12, sqlDate);
            ps.setInt(13, trabajador.getTelefono());
            ps.setString(14, trabajador.getEmail());
            if (trabajador.getFecha_alta() != null) {
                sqlDate = java.sql.Date.valueOf(trabajador.getFecha_alta());
            }
            ps.setDate(15, sqlDate);
            if (trabajador.getFecha_baja() == null) {
                sqlDate = null;
            } else {
                sqlDate = java.sql.Date.valueOf(trabajador.getFecha_baja());
            }
            ps.setDate(16, sqlDate);
            ps.setString(17, trabajador.getHoras_semana_alta());
            ps.setString(18, trabajador.getHoras_semana_reales());
            ps.setFloat(19, trabajador.getCoste_mes());
            ps.setString(20, trabajador.getSeguridad_social());
            ps.setString(21, trabajador.getIban());
            ps.executeUpdate();
            conn.desconectar(conexion);
            trabajadores.add(0, trabajador);
            correcto = true;
        } catch (SQLException ex) {
            correcto = false;
            Logger.getLogger(nombreClase).log(Level.SEVERE, null, ex);
        }
        return correcto;
    }

    public boolean delete(int id, int codigo) {
        correcto = false;
        try {
            Utilidades.conn = new Conexion();
            conexion = Utilidades.conn.conectar_empresa_concreta(Utilidades.empresa);
            delete = "DELETE FROM centrostrabajadores WHERE codigo_trabajadores=?";
            ps = conexion.prepareStatement(delete);
            ps.setInt(1, codigo);
            ps.executeUpdate();
            delete = "DELETE FROM trabajadores WHERE id=?";
            ps = conexion.prepareStatement(delete);
            ps.setInt(1, id);
            ps.executeUpdate();
            conn.desconectar(conexion);
            trabajadores.remove(getById(id));
            correcto = true;
        } catch (SQLException ex) {
            correcto = false;
            Logger.getLogger(nombreClase).log(Level.SEVERE, null, ex);
        }
        return correcto;
    }
    /**
     *
     * @param id
     * @return
     */
    
    public boolean update(Trabajador trabajador) {
        try {
            Utilidades.conn = new Conexion();
            conexion = conn.conectar_empresa_concreta(Utilidades.empresa);
            update = "UPDATE trabajadores SET codigo=?, codigo_tipo_contrato=?,codigo_sede=?, apellido1=?, apellido2=?,nombre=?,DNI=?,direccion=?,poblacion=?,"
                    + "fechanacimiento=?, categoria=?, antiguedad=?, telefono=?, email=?, fecha_alta=?, fecha_baja=?,"
                    + "horas_semana_alta=?, horas_semana_reales=?, coste_mes=?, seguridad_social=?,iban=? WHERE id=?";
            ps = conexion.prepareStatement(update);
            ps.setString(1, trabajador.getCodigo());
            ps.setInt(2, trabajador.getCodigo_tipo_contrato());
            ps.setString(3, trabajador.getCodigo_sede());
            ps.setString(4, trabajador.getApellido1());
            ps.setString(5, trabajador.getApellido2());
            ps.setString(6, trabajador.getNombre());
            ps.setString(7, trabajador.getDNI());
            ps.setString(8, trabajador.getDireccion());
            ps.setString(9, trabajador.getPoblacion());
            if (trabajador.getFechanacimiento() != null) {
                sqlDate = java.sql.Date.valueOf(trabajador.getFechanacimiento());
            }
            ps.setDate(10, sqlDate);
            ps.setString(11, trabajador.getCategoria());
            if (trabajador.getAntiguedad() != null) {
                sqlDate = java.sql.Date.valueOf(trabajador.getAntiguedad());
            }
            ps.setDate(12, sqlDate);
            ps.setInt(13, trabajador.getTelefono());
            ps.setString(14, trabajador.getEmail());
            if (trabajador.getFecha_alta() != null) {
                sqlDate = java.sql.Date.valueOf(trabajador.getFecha_alta());
            }
            ps.setDate(15, sqlDate);
            if (trabajador.getFecha_baja() == null) {
                sqlDate = null;
            } else {
                sqlDate = java.sql.Date.valueOf(trabajador.getFecha_baja());
            }
            ps.setDate(16, sqlDate);
            ps.setString(17, trabajador.getHoras_semana_alta());
            ps.setString(18, trabajador.getHoras_semana_reales());
            ps.setFloat(19, trabajador.getCoste_mes());
            ps.setString(20, trabajador.getSeguridad_social());
            ps.setString(21, trabajador.getIban());
            //PARAMETRO QUE VA AL WHERE QUE SIEMPRE ES EL ID
            ps.setInt(22, trabajador.getId());
            ps.executeUpdate();
            conn.desconectar(conexion);

            ejecutarConsulta(consulta);
        } catch (SQLException ex) {
            correcto = false;
            Logger.getLogger(nombreClase).log(Level.SEVERE, null, ex);
        }
        return correcto;
    }

    /**
     *
     * @param codigoCentro
     */
    public void buscarTrabajadoresPorCodigoCentro(String codigoCentro) {
        String consultaEspecial = "SELECT t.* \n"
                + "FROM trabajadores t \n"
                + "WHERE t.codigo IN(\n"
                + "	SELECT ct.codigo_trabajadores \n"
                + "    FROM centrostrabajadores ct \n"
                + "    WHERE ct.codigo_centro=" + codigoCentro + "\n"
                + ");";
        ejecutarConsulta(consultaEspecial);
    }

    /**
     *
     * @param tabla
     * @param cadena
     */
    public void buscar(JTable tabla, String cadena) {
        DefaultTableModel dtm = (DefaultTableModel) tabla.getModel();
        String nombre;
        String apellido1;
        String apellido2;
        //if (!cadena.equals("")) {
        if (Utilidades.isInteger(cadena)) {
            for (int i = 0; i < trabajadores.size(); i++) {
                if (trabajadores.get(i).getCodigo().equals(cadena)) {
                    dtm.addRow(addRow(trabajadores.get(i)));
                }
            }
        }
        if (cadena.indexOf(" ") > 0) {//SI ENTRA AQUI SIGNIFICA QUE HAY APELLIDOS EN EL BUSCADOR PERO NO SABEMOS SI TRAE LOS DOS APELLIDOS O 1
            String[] partes = cadena.split(" ");
            nombre = partes[0]; // nombre
            //AQUI HAY QUE COMPROBAR CUANTAS PARTES TRAE LA CADENA PORQUE NO SABEMOS SI SOLO TRAE EL NOMBRE O TAMBIEN EL APELLIDO1 O LOS DOS APELLIDOS
            if (partes.length > 2) {
                apellido1 = partes[1]; // apellido 1 
                apellido2 = partes[2];//apellido 2
                for (int i = 0; i < trabajadores.size(); i++) {
                    if (trabajadores.get(i).getNombre().contains(nombre) && trabajadores.get(i).getApellido1().contains(apellido1) && trabajadores.get(i).getApellido2().contains(apellido2)) {
                        dtm.addRow(addRow(trabajadores.get(i)));
                    }
                }
            } else if (partes.length > 1) {
                apellido1 = partes[1]; // apellido 1 
                for (int i = 0; i < trabajadores.size(); i++) {
                    if (trabajadores.get(i).getNombre().contains(nombre) && trabajadores.get(i).getApellido1().contains(apellido1)) {
                        dtm.addRow(addRow(trabajadores.get(i)));
                    } else if (trabajadores.get(i).getApellido1().contains(nombre) && trabajadores.get(i).getApellido2().contains(apellido1)) {
                        dtm.addRow(addRow(trabajadores.get(i)));
                    }
                }
            }
        } else {//SI NO, ES QUE NO HAY APELLIDOS EN EL BUSCADOR
            for (int i = 0; i < trabajadores.size(); i++) {
                if (trabajadores.get(i).getNombre().contains(cadena) || trabajadores.get(i).getApellido1().contains(cadena) || trabajadores.get(i).getApellido2().contains(cadena)) {
                    dtm.addRow(addRow(trabajadores.get(i)));
                }
            }
        }
        //}
        tabla.setModel(dtm);
    }
}
