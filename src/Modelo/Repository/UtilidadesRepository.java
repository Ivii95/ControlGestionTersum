/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DisenoWeb
 */
public class UtilidadesRepository {

    public static PreparedStatement ps = null;
    public static ResultSet rs = null;
    public static DefaultTableModel dtm;
    public static Object[] columnas;
    public static Connection conexion;
    public static final String consultaPrincipal = "SELECT * FROM ";
    public static java.sql.Date sqlDate = null;
    public static boolean correcto;
    public static String insert, delete, update;

}
