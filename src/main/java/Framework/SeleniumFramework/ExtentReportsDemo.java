package Framework.SeleniumFramework;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsDemo {
	
	
	
	@BeforeTest
	public static ExtentReports getReportObject() {
	String path =	System.getProperty("user.dir")+"\\reports\\index.html";
	ExtentSparkReporter reporter = new  ExtentSparkReporter(path);
	
	reporter.config().setReportName("Web Automation Resukt");
	reporter.config().setDocumentTitle("Test Result");
	
	ExtentReports  extent = new ExtentReports();
	
	extent.attachReporter(reporter);
	
	extent.setSystemInfo("Tester", "Shubham Satpute");
	
	return extent;
	}
	

}
