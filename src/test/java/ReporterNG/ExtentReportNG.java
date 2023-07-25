package ReporterNG;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {

	static ExtentReports extent;
	public static ExtentReports getReportObject() {
		
		String path=System.getProperty("user.dir")+"/reports/index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Hybrid Automation FW Report");
		reporter.config().setDocumentTitle("Test Results");
		
		extent =new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Maninder Singh");
		return extent;
		
		
	}
}
