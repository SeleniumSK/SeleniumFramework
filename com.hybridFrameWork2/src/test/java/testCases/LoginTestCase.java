package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import dataProviderFactory.BrowserFactory;
import dataProviderFactory.DataProviderFactory;
import pages.LoginPage;

public class LoginTestCase extends BaseClass{
	
	
	
	@Test
	public void login()
	{
		logger= report.startTest("Login to HRM");
		LoginPage page = PageFactory.initElements(driver, LoginPage.class);
		page.verifyLogin();
		logger= report.startTest("Login to HRM");
		page.loginApp(DataProviderFactory.getExcel().getData("login", 1, 0), 
				DataProviderFactory.getExcel().getData("login", 1, 1));
		logger.log(LogStatus.INFO, "Login Successful");
	}

}
