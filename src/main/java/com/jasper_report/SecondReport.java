package com.jasper_report;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jasper_report.models.Employee;
import com.jasper_report.models.Student;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.base.JRBaseTextField;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class SecondReport {

	  public static void main( String[] args )
	    {
	       
	        try {
	        	String filePath = "D:\\java workspace\\jasper-report\\src\\main\\resources\\SecondReport.jrxml";
	        	
	        	// how to set parameter
	        	Map<String, Object> param = new HashMap<String, Object>();
	        	param.put("empName", "Harsh Singhal");
	        	
	        	// how to set fields
	        	Employee std = new Employee(1L, "Harsh", "parsi maholla", "7878787878");
	        	Employee std1 = new Employee(2L, "Pawan", "Goyal Hospital", "3323323223");
	        	Employee std2 = new Employee(3L, "Anurag", "MR3", "32e21233223");
	        	Employee std3 = new Employee(4L, "Arun",  "white field", "3434434334");
	        	
	        	List<Employee> list  = new ArrayList<Employee>();
	        	list.add(std);
	        	list.add(std1);
	        	list.add(std2);
	        	list.add(std3);
	        	JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(list);
	        	
	        	// how to compile
	        	JasperReport report = JasperCompileManager.compileReport(filePath);
	        	
//	        	// if we want to perform some action using key
//	        	
//	        	JRBaseTextField field = (JRBaseTextField) report.getTitle().getElementByKey("name");
//	        	field.setForecolor(Color.ORANGE);
	        
	        	// how to fill report
	        	JasperPrint print =  JasperFillManager.fillReport(report, param , dataSource);
	        	
	        	// export it to pdf
	        	String exportPdfFileName = "D:\\java workspace\\jasper-report\\src\\main\\resources\\generate\\report2.pdf";
	        	JasperExportManager.exportReportToPdfFile(print, exportPdfFileName);
	        	
	        	System.out.println("Report created....");
	        	
	        	
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				System.err.println("Exception - " + e.getMessage());
			}
	    }

}
