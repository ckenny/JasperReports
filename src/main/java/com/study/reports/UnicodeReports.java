package com.study.reports;

import net.sf.jasperreports.engine.*;
import org.apache.commons.collections.map.HashedMap;

import java.util.Date;

/**
 * Created by kcharan on 4/11/2017.
 */
public class UnicodeReports {

    public static void main(String[] args) {
        try {

            long start = System.currentTimeMillis();
            String sourceLocation = UnicodeReports.class.getResource("").getFile();

            JasperReport jasperReport = JasperCompileManager.compileReport(UnicodeReports.class.getResource("UnicodeReport.jrxml").getFile());

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, new HashedMap(), new JREmptyDataSource());

            JasperExportManager.exportReportToPdfFile(jasperPrint, sourceLocation + "output_"+new Date().getTime()+".pdf");
            JasperExportManager.exportReportToHtmlFile(jasperPrint, sourceLocation + "output_"+new Date().getTime()+".html");

            System.err.println("PDF creation time : " + (System.currentTimeMillis() - start));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
