/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas.Listado;

import static Modelo.Repository.UtilidadesRepository.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRPdfExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;
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

    public void Prueba() {
        JasperPrint jasperPrintWindow = null;
        try {
            jasperPrintWindow = JasperFillManager.fillReport(
                    "C:\\Users\\Ivan9\\JaspersoftWorkspace\\Reportes\\Trabajadores.jasper", null,
                    iniciarConexion());
        } catch (JRException ex) {
            Logger.getLogger(Listado.class.getName()).log(Level.SEVERE, null, ex);
        }
        JasperViewer jasperViewer = new JasperViewer(jasperPrintWindow);
        jasperViewer.setVisible(true);
    }

    public void pruebaParametro() {
        try {
            //Crear el mapa de parametros
            Map<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("variable", new String("Este es un String para pasar por parametro"));
            InputStream reportStream = new FileInputStream("reporte.jrxml");
            //Iniciar reporte
            JasperReport report = JasperCompileManager.compileReport(reportStream);
            JasperPrint jasperPrint = new JasperPrint();
            //Llenar el reporte donde se le pasa en el tercer argumento el mapa ya creado
            JasperFillManager.fillReportToFile(report, "reporte.jrprint", (Map<String, Object>) parameters, new JREmptyDataSource());
            reportStream.close();

            //Generar PDF
            List listJasper = new ArrayList();
            listJasper.add(JRLoader.loadObjectFromFile("reporte.jrprint"));
            JRPdfExporter exp = new JRPdfExporter();
            exp.setParameter(JRExporterParameter.JASPER_PRINT_LIST, listJasper);
            exp.setParameter(JRPdfExporterParameter.IS_CREATING_BATCH_MODE_BOOKMARKS, Boolean.TRUE);
            exp.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, "reporte.pdf");
            exp.exportReport();
        } catch (IOException ex) {
            Logger.getLogger(Listado.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(Listado.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
