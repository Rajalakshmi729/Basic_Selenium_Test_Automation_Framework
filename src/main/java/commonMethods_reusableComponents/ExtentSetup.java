package commonMethods_reusableComponents;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.ObjectsRepo;

public class ExtentSetup extends ObjectsRepo {

	
	public static ExtentReports setupExtentReport() { 
	// report name, report tile, theme of report,
	// below get the current location of the project
		//String reportPath = System.getProperty("user.dir")+"/target/ExecutionReport.html";
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
		Date date = new Date();
		String actualDate = format.format(date);
		String reportPath = System.getProperty("user.dir")+"/Reports/ExecutionReport_"+actualDate+".html";
		
	ExtentSparkReporter sparkReport = new ExtentSparkReporter(reportPath);
	//1. we have created object of the extent report class
	 extent = new ExtentReports();
	//2. The below line basically indicates that we have to attach particular report to this attachReporter
	// thats why we create ExtentSpartReporter and we are attaching.
	extent.attachReporter(sparkReport);
	
	sparkReport.config().setDocumentTitle("Document Title");
	sparkReport.config().setTheme(Theme.DARK);
	sparkReport.config().setReportName("ReportName");
	
	return extent;
	
	}
	
	
}
