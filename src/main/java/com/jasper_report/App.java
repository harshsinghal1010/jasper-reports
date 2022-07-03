package com.jasper_report;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jasper_report.models.Student;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.base.JRBaseTextField;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       
        try {
        	String filePath = "D:\\java workspace\\jasper-report\\src\\main\\resources\\FirstReport.jrxml";
        	
        	// how to set parameter
        	Map<String, Object> param = new HashMap<String, Object>();
        	param.put("studentName", "Harsh Singhal");
        	
        	// how to set fields
        	Student std = new Student(1L, "Harsh", "Agrawal", "parsi maholla", "Indore");
        	Student std1 = new Student(2L, "Pawan", "Sankhle", "Goyal Hospital", "Mhow");
        	Student std2 = new Student(3L, "Anurag", "Chandra", "MR3", "Indore");
        	Student std3 = new Student(4L, "Arun", "Anna", "white field", "Bangalore");
        	
        	List<Student> list  = new ArrayList<Student>();
        	list.add(std);
        	list.add(std1);
        	list.add(std2);
        	list.add(std3);
        	JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(list);
        	
        	// how to compile
        	JasperReport report = JasperCompileManager.compileReport(filePath);
        	
        	// if we want to perform some action using key
        	
        	JRBaseTextField field = (JRBaseTextField) report.getTitle().getElementByKey("name");
        	field.setForecolor(Color.ORANGE);
        
        	// how to fill report
        	JasperPrint print =  JasperFillManager.fillReport(report, param , dataSource);
        	
        	// export it to pdf
        	String exportPdfFileName = "D:\\java workspace\\jasper-report\\src\\main\\resources\\generate\\report.pdf";
        	JasperExportManager.exportReportToPdfFile(print, exportPdfFileName);
        	
        	System.out.println("Report created....");
        	
        	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.err.println("Exception - " + e.getMessage());
		}
    }
}
