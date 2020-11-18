/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites_aeropuerto.reports;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import org.springframework.stereotype.Service;

/**
 *
 * @author Andres
 */
@Service
public class ConeccionReporte {

    public String Connecion(String reporte) {
        String jasperString = "";

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://107.180.0.205:3306/BD_PF_Grupo5", "BD_PF_Grupo5_U", "FPQRW-.V4JdFy(+");
            File miDir = new File(".");
            HashMap map = new HashMap();//sustituir por null en 46
            map.put("Parametro", new Date());

            JasperReport reporte2 = (JasperReport) JRLoader.loadObject(new File(miDir.getCanonicalPath() + "\\src\\main\\java\\org\\una\\tramites_aeropuerto\\reports\\report1.jasper"));
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte2, null, conexion);
            byte[] byteJaspearReport;
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream outputStream = new ObjectOutputStream(baos);
            outputStream.writeObject(jasperPrint);
            byteJaspearReport = baos.toByteArray();
            jasperString = Base64.getEncoder().encodeToString(byteJaspearReport);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConeccionReporte.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConeccionReporte.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConeccionReporte.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(ConeccionReporte.class.getName()).log(Level.SEVERE, null, ex);
        }

        return jasperString;

    }

}
