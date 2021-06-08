package Resources;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

	static ExtentReports extent;
	
	public static ExtentReports getReportObject()
	{
		String path=System.getProperty("user.dir")+"\\Reports\\"+"index.html";
		ExtentSparkReporter reporte=new ExtentSparkReporter(path);
		reporte.config().setReportName("Web Automation Result Report");
		reporte.config().setDocumentTitle("Test Results");
		
		extent=new ExtentReports();
		extent.attachReporter(reporte);
		extent.setSystemInfo("Tester","Geeta");
		return extent;
	}
}
