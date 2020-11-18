/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites_aeropuerto.reports;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andres
 */
public class ConeccionReporte {

    public void Connecion(String reporte) {

        try {
        
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://107.180.0.205:3306/BD_PF_Grupo5", "BD_PF_Grupo5_U", "FPQRW-.V4JdFy(+");
            File miDir = new File(".");
            URL url = new URL(miDir.getCanonicalPath()+"\\src\\main\\java\\org\\una\\tramites_aeropuerto\\reports\\report1.jasper");

            //String Recurso = ConeccionReporte.class.getProtectionDomain().getCodeSource().getLocation());
//            URL url = ConeccionReporte.class.getProtectionDomain().getCodeSource().getLocation();
//            System.out.println(url);
//JasperReport reporte = (JasperReport) JRLoader.loadObject();
//JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, null, conexion);
//JRExporter exporter = new JRPdfExporter();
//exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
//exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File(“reportePDF.pdf”));
//exporter.exportReport();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConeccionReporte.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConeccionReporte.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConeccionReporte.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
