/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author DisenoWeb
 */
public class UtilidadesPantalla {
    
    public static SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yy");
    
    public static void resolucionPantalla(JFrame aThis) {
        aThis.setLocationRelativeTo(null);
        int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
        if (ancho < 1367 || alto < 769) {
            aThis.setExtendedState(JFrame.MAXIMIZED_HORIZ);
            aThis.setExtendedState(JFrame.MAXIMIZED_VERT);
        } else {
            
        }
    }
    
    public static URL obtenerUrlAyuda() {
        URL hsURL = null;
        try {
            File fichero = new File("lib" + File.separator + "help" + File.separator + "help.hs");
            hsURL = fichero.toURI().toURL();
        } catch (MalformedURLException ex) {
            Logger.getLogger(UtilidadesPantalla.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hsURL;
    }
    
    public static void centrarTablas(JTable aThis) {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        aThis.setDefaultRenderer(String.class, centerRenderer);
        aThis.setDefaultRenderer(Integer.class, centerRenderer);
        aThis.setDefaultRenderer(Object.class, centerRenderer);
    }
    
    public static void rellenarComboTiposContrato(JComboBox cbx) {
        cbx.addItem("Selecciona uno");
        cbx.addItem(100);
        cbx.addItem(109);
        cbx.addItem(130);
        cbx.addItem(139);
        cbx.addItem(150);
        cbx.addItem(189);
        cbx.addItem(200);
        cbx.addItem(209);
        cbx.addItem(230);
        cbx.addItem(239);
        cbx.addItem(250);
        cbx.addItem(289);
        cbx.addItem(300);
        cbx.addItem(309);
        cbx.addItem(330);
        cbx.addItem(339);
        cbx.addItem(350);
        cbx.addItem(389);
        cbx.addItem(401);
        cbx.addItem(402);
        cbx.addItem(403);
        cbx.addItem(408);
        cbx.addItem(410);
        cbx.addItem(418);
        cbx.addItem(420);
        cbx.addItem(501);
        cbx.addItem(502);
        cbx.addItem(508);
        cbx.addItem(510);
        cbx.addItem(518);
        cbx.addItem(520);
        cbx.addItem(521);
        cbx.addItem(530);
        cbx.addItem(540);
        cbx.addItem(541);
        cbx.addItem(550);
        cbx.addItem(552); 
    }
    
    public static boolean comprobarTelefono(String source) {
        Pattern fijos = Pattern.compile("^[89]\\d{8}$");
        Matcher fijoss = fijos.matcher(source);
        if (fijoss.find()) {
            return true;
        }
        return false;
    }
    
    public static boolean comprobarMovil(String source) {
        Pattern moviles = Pattern.compile("^[67]\\d{8}$");
        Matcher moviless = moviles.matcher(source);
        if (moviless.find()) {
            return true;
        }
        return false;
    }
    
    public static boolean comprobarEmail(String source) {
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(source);
        System.out.println(matcher.matches());
        return matcher.matches();
    }
    
    public static int getIdSelected(JTable tabla) {
        return (Integer) (tabla.getValueAt(tabla.getSelectedRow(), 0));
    }
    
    public static Date sumarRestarDiasFecha(Date fecha, int dias) {
        
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha); // Configuramos la fecha que se recibe
        calendar.add(Calendar.DAY_OF_YEAR, dias);  // numero de días a añadir, o restar en caso de días<0
        java.util.Date fechaFinal = calendar.getTime(); // Devuelve el objeto Date con los nuevos días añadidos
        return new java.sql.Date(fechaFinal.getTime());
    }
    
    public static LocalDate convertToLocalDateViaInstant(java.util.Date dateToConvert)throws NullPointerException{
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate().plusDays(1);
    }
}
