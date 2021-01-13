/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas.Listado;

import static Modelo.Repository.UtilidadesRepository.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author DisenoWeb
 */
public class Listado {

    public Connection iniciarConexion() {
        Utilidades.Utilidades.conn = new Utilidades.Conexion();
        conexion = Utilidades.Utilidades.conn.conectar_empresa_concreta(Utilidades.Utilidades.empresa);
        return conexion;
    }

    public void ListarTrabajador(String codigo) {
        try {
            //JasperReport reporte = (JasperReport) JRLoader.loadObject(reportFile("Tersum_FichaPersonal.jasper"));
            HashMap<String, Object> parametros = new HashMap<>();
            parametros.put("codigo", codigo);
            JasperPrint jasperPrint = JasperFillManager.fillReport(
                    ".\\lib\\plantillasjasper\\Tersum_FichaTrabajador.jasper",
                    //reporte,
                    parametros,
                    iniciarConexion());
            JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);
            jasperViewer.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(Listado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ListarCliente(String codigo) {
        try {
            //JasperReport reporte = (JasperReport) JRLoader.loadObject(reportFile("Tersum_FichaPersonal.jasper"));
            HashMap<String, Object> parametros = new HashMap<>();
            parametros.put("codigo", codigo);
            JasperPrint jasperPrint = JasperFillManager.fillReport(
                    ".\\lib\\plantillasjasper\\Tersum_FichaCliente.jasper",
                    //reporte,
                    parametros,
                    iniciarConexion());
            JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);
            jasperViewer.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(Listado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ListarCentro(String codigo) {
        try {
            //JasperReport reporte = (JasperReport) JRLoader.loadObject(reportFile("Tersum_FichaPersonal.jasper"));
            HashMap<String, Object> parametros = new HashMap<>();
            parametros.put("codigo", codigo);
            JasperPrint jasperPrint = JasperFillManager.fillReport(
                    ".\\lib\\plantillasjasper\\Tersum_FichaCentro.jasper",
                    //reporte,
                    parametros,
                    iniciarConexion());
            JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);
            jasperViewer.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(Listado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void ListarTrabajadores() {
        try {
            //JasperReport reporte = (JasperReport) JRLoader.loadObject(reportFile("Tersum_FichaPersonal.jasper"));
            //HashMap<String, Object> parametros = new HashMap<>();
            //parametros.put("codigo_trabajador", codigo);
            JasperPrint jasperPrint = JasperFillManager.fillReport(
                    ".\\lib\\plantillasjasper\\Trabajadores_datos.jasper",
                    //reporte,
                    null,
                    iniciarConexion());
            JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);
            jasperViewer.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(Listado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private InputStream reportFile(String file) {
        return new ByteArrayInputStream((".\\lib\\plantillasjasper\\" + file).getBytes());
    }

}
