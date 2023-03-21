package pkg1;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentReport {
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;

	 
	@BeforeSuite
	public void setUp() {
	htmlReporter= new ExtentHtmlReporter("multipleClassesextentReport6.html");
	extent = new ExtentReports();
	extent.attachReporter(htmlReporter);
 	//extent.setSystemInfo("OS", "Mac Sierra");
	//extent.setSystemInfo("Host Name", "xxxx");
	extent.setSystemInfo("Environment", "QA");
	extent.setSystemInfo("User Name", "Siva");
	htmlReporter.config().setTheme(Theme.DARK);//Default Theme of Report
	}
	
	@AfterSuite
	public void tearDown() {
	extent.flush();
	}


}
