/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Repository;

import static Modelo.Repository.UtilidadesRepository.*;
import Modelo.Entidades.CentroTrabajador;
import Utilidades.Conexion;
import Utilidades.Utilidades;
import static Utilidades.Utilidades.conn;
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

    public CentroTrabajadoresRepository() {
        CentroTrabajadoresRepository.centroTrabajadores = new ArrayList<>();
        ejecutarConsulta(consultaTrabajadores);
    }

    public CentroTrabajador getByCodigos(String codigo_trabajador, String codigo_centro) {
        CentroTrabajador ct = null;
        for (int i = 0; i < centroTrabajadores.size(); i++) {
            String trabajador = centroTrabajadores.get(i).getCodigo_trabajador();
            String centro = centroTrabajadores.get(i).getCodigo_centro();
            if (trabajador.equals(codigo_trabajador) && centro.equals(codigo_centro)) {
                ct = centroTrabajadores.get(i);
            }
        }
        return ct;
    }

    private void ejecutarConsulta(String consulta) {
        try {
            centroTrabajadores.clear();
            Utilidades.conn = new Conexion();
            conexion = conn.conectar_empresa_concreta(Utilidades.empresa);
            ps = conexion.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                CentroTrabajador centroTrabajador = new CentroTrabajador();
                centroTrabajador.setId(rs.getInt(id));
                centroTrabajador.setCodigo_centro(rs.getString(codigoCentro));
                centroTrabajador.setCodigo_trabajador(rs.getString(codigoTrabajadores));
                centroTrabajadores.add(centroTrabajador);
            }
            conn.desconectar(conexion);
        } catch (SQLException ex) {
            Logger.getLogger(nombreClase).log(Level.SEVERE, null, ex);
        }
    }

    public void insertarTrabajadorCentro(String codigoCentro, String codigoTrabajador) {
        String consultaEspecial = "INSERT INTO centrostrabajadores (" + this.codigoCentro + ", " + this.codigoTrabajadores + ") \n"
                + "VALUES (" + codigoCentro + ", " + codigoTrabajador + ");";
        ejecutarConsulta(consultaEspecial);
    }

}
