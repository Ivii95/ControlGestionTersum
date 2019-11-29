/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Repository;

import static Modelo.Repository.UtilidadesRepository.*;
import Modelo.Entidades.CentroTrabajador;
import Modelo.Entidades.Trabajador;
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
    private static ArrayList<CentroTrabajador> centroTrabajdores;
    private final String TABLA = "centrostrabajadores";
    private final String consultaTrabajadores = consultaPrincipal + TABLA;
    
    public CentroTrabajadoresRepository() {
        CentroTrabajadoresRepository.centroTrabajdores = new ArrayList<>();
        ejecutarConsulta(consultaTrabajadores);
    }

    private void ejecutarConsulta(String consulta) {
        try {
            centroTrabajdores.clear();
            Utilidades.conn = new Conexion();
            conexion = conn.conectar_empresa_concreta(Utilidades.empresa);
            ps = conexion.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                CentroTrabajador centroTrabajador = new CentroTrabajador();
                centroTrabajador.setId(rs.getInt("id"));
                centroTrabajador.setCodigo_centro(rs.getString("codigo_centro"));
                centroTrabajador.setCodigo_trabajador(rs.getString("codigo_trabajador"));
                
                centroTrabajdores.add(centroTrabajador);
            }
            conn.desconectar(conexion);
        } catch (SQLException ex) {
            Logger.getLogger(nombreClase).log(Level.SEVERE, null, ex);
        }
    }
    
    public void insertarTrabajadorCentro (String codigoCentro, String codigoTrabajador){
         String consultaEspecial = "INSERT INTO centrostrabajadores (codigo_centro, codigo_trabajadores) \n"
                                 + "VALUES ("+ codigoCentro +", "+ codigoTrabajador +");";
         ejecutarConsulta(consultaEspecial);
    }
    
}
