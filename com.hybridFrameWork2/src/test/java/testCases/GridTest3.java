package testCases;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class GridTest3 {
	
	
	//testing on the cloud using browser stack - with windows and IE
	@Test
	public void test1() throws MalformedURLException
	
	{
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName(BrowserType.IE);
		
		cap.setPlatform(Platform.WINDOWS);
		cap.setCapability("browser_version", "10");
	    cap.setCapability("browserstack.debug", "true");
		URL url = new URL("https://soumyakaza1:cpxAoyNAxxMTFN6QrAtF@hub-cloud.browserstack.com/wd/hub");
		
		WebDriver driver = new RemoteWebDriver(url, cap);
		
		driver.get("http://www.learn-automation.com/");
		
		driver.quit();
	}

}
