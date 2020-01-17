/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Repository;

import Modelo.Entidades.Centro;
import static Modelo.Repository.UtilidadesRepository.*;
import Modelo.Entidades.CentroTrabajador;
import Modelo.Entidades.Trabajador;
import Utilidades.Conexion;
import Utilidades.Utilidades;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Programacion
 */
public class CentroTrabajadoresRepository {

    private final String nombreClase = CentroTrabajadoresRepository.class.getName();
    private static ArrayList<CentroTrabajador> centroTrabajadores;
    private final String TABLA = "centrostrabajadores";
    private final String consultaTrabajadores = consultaPrincipal + TABLA;
    private final String id = "id";
    private final String codigoTrabajadores = "codigo_trabajadores";
    private final String codigoCentro = "codigo_centro";
    private CentroRepository repoCentro = new CentroRepository();
    private TrabajadorRepository repoTrabajadores = new TrabajadorRepository();

    //El repositorio CentroTrabajadores guardara el id el trabajador y el centro a la misma vez.
    //Asi es mas facil acceder a todos los datos.
    public CentroTrabajadoresRepository() {
        repoTrabajadores = new TrabajadorRepository();
        repoTrabajadores.rellenarListaDefault();
        repoCentro = new CentroRepository();
        repoCentro.rellenarListaDefault();
        centroTrabajadores = new ArrayList<CentroTrabajador>();
    }

    /**
     * Devuelve un centroTrabajador donde coincidan el trabajador y el centro
     * pasados por parametro.
     *
     * @param trabajador
     * @param centro
     * @return un objeto CentroTrabajador.
     */
    public CentroTrabajador getByCodigos(Trabajador trabajador, Centro centro) {
        CentroTrabajador ct = null;
        for (int i = 0; i < centroTrabajadores.size(); i++) {
            if (trabajador.getCodigo().equals(trabajador.getCodigo())
                    && centro.getCodigo().equals(centro.getCodigo())) {
                ct = centroTrabajadores.get(i);
            }
        }
        return ct;
    }

    /**
     * Rellena la lista con todas las tuplas de la base de datos
     */
    public void rellenarListaDefault() {
        ejecutarConsulta(consultaTrabajadores);
    }

    /**
     * Rellena la lista con las tuplas de la base de datos donde el trabajador
     * sea el pasado por parametro
     *
     * @param trabajador
     */
    public void rellenarListaByTrabajador(Trabajador trabajador) {
        ejecutarConsulta(consultaTrabajadores + " WHERE " + codigoTrabajadores + " = " + trabajador.getCodigo());
    }

    /**
     * Rellenar la lista con las tuplas de la base de datos donde el centro sea
     * el pasado por parametro
     *
     * @param centro
     */
    public void rellenarListaByCentro(Centro centro) {
        ejecutarConsulta(consultaTrabajadores + " WHERE " + codigoCentro + " = " + centro.getCodigo());
    }

    /**
     *
     * @param id
     * @return
     */
    public CentroTrabajador getById(int id) {
        CentroTrabajador o = null;
        for (int i = 0; i < centroTrabajadores.size(); i++) {
            if (centroTrabajadores.get(i).getId() == id) {
                o = centroTrabajadores.get(i);
            }
        }
        return o;
    }

    /**
     *
     * @param codigo_trabajador
     * @return
     */
    public CentroTrabajador getByCodigoTrabajador(String codigo_trabajador) {
        CentroTrabajador o = null;
        for (int i = 0; i < centroTrabajadores.size(); i++) {
            if (centroTrabajadores.get(i).getTrabajador().getCodigo().equals(codigo_trabajador)) {
                o = centroTrabajadores.get(i);
            }
        }
        return o;
    }

    /**
     * Retorna la lista del repositorio
     *
     * @return
     */
    public ArrayList<CentroTrabajador> getCentrosTrabajadores() {
        return centroTrabajadores;
    }

    private void ejecutarConsulta(String consulta) {
        try {
            centroTrabajadores.clear();
            Utilidades.conn = new Conexion();
            conexion = Utilidades.conn.conectar_empresa_concreta(Utilidades.empresa);
            ps = conexion.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                CentroTrabajador centroTrabajador = new CentroTrabajador();
                centroTrabajador.setId(rs.getInt(id));
                //Obtenemos el centro y el trabajador de sus repositorios a traves de su codigo.
                centroTrabajador.setCentro(repoCentro.getByCodigo(rs.getString(codigoCentro)));
                centroTrabajador.setTrabajador(repoTrabajadores.getByCodigo(rs.getString(codigoTrabajadores)));
                centroTrabajadores.add(centroTrabajador);
            }
            Utilidades.conn.desconectar(conexion);
        } catch (SQLException ex) {
            Logger.getLogger(nombreClase).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param centroTrabajador
     * @return boolean exito
     */
    public boolean insert(CentroTrabajador centroTrabajador) {
        insert = "INSERT INTO centrostrabajadores ("
                + this.id + ", "
                + this.codigoCentro + ", "
                + this.codigoTrabajadores + ") \n"
                + "VALUES (NULL, ?, ?);";
        correcto = false;
        try {
            Utilidades.conn = new Conexion();
            conexion = Utilidades.conn.conectar_empresa_concreta(Utilidades.empresa);
            ps = conexion.prepareStatement(insert);
            ps.setString(1, centroTrabajador.getCentro().getCodigo());
            ps.setString(2, centroTrabajador.getTrabajador().getCodigo());
            ps.executeUpdate();
            Utilidades.conn.desconectar(conexion);
            //centroTrabajadores.add(centroTrabajador);
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
     * @return boolean exito
     */
    public boolean delete(int id) {
        correcto = false;
        try {
            Utilidades.conn = new Conexion();
            conexion = Utilidades.conn.conectar_empresa_concreta(Utilidades.empresa);
            delete = "DELETE FROM " + TABLA + " WHERE id=?";
            ps = conexion.prepareStatement(delete);
            ps.setInt(1, id);
            ps.executeUpdate();
            Utilidades.conn.desconectar(conexion);
            //centroTrabajadores.remove(getById(id));
            correcto = true;
        } catch (SQLException ex) {
            correcto = false;
            Logger.getLogger(nombreClase).log(Level.SEVERE, null, ex);
        }
        return correcto;
    }

    public boolean deleteTrabajador(String codigo_trabajador) {
        correcto = false;
        try {
            Utilidades.conn = new Conexion();
            conexion = Utilidades.conn.conectar_empresa_concreta(Utilidades.empresa);
            delete = "DELETE FROM " + TABLA + " WHERE " + codigoTrabajadores + " = ? ";
            ps = conexion.prepareStatement(delete);
            ps.setString(1, codigo_trabajador);
            ps.executeUpdate();
            Utilidades.conn.desconectar(conexion);
            //centroTrabajadores.remove(getByCodigoTrabajador(codigo_trabajador));
            correcto = true;
        } catch (SQLException ex) {
            correcto = false;
            Logger.getLogger(nombreClase).log(Level.SEVERE, null, ex);
        }
        return correcto;
    }

}
