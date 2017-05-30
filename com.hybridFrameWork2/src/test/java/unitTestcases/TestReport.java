package unitTestcases;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestReport {
	
	@Test
	public void testReport(){
	ExtentReports report = new ExtentReports(System.getProperty("user.dir")+"/Reports/firstReport.html");
	
	ExtentTest logger = report.startTest("Login", "This test case will login with valid credentials");
	
	logger.log(LogStatus.INFO, "Started App");
	
	
	logger.log(LogStatus.INFO, "loggedin App");
	
	
	logger.log(LogStatus.INFO, "Logout App");
	
	
	report.endTest(logger);
	
	report.flush();
	}
}
