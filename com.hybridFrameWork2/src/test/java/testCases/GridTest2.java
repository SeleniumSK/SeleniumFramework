package testCases;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class GridTest2 {
	
	
	//testing on the cloud using browser stack - with mac and firefox
	@Test
	public void test1() throws MalformedURLException
	
	{
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName(BrowserType.FIREFOX);
		
		cap.setPlatform(Platform.MAC);
		cap.setCapability("browser_version", "53");
	    cap.setCapability("browserstack.debug", "true");
		URL url = new URL("https://soumyakaza1:cpxAoyNAxxMTFN6QrAtF@hub-cloud.browserstack.com/wd/hub");
		
		WebDriver driver = new RemoteWebDriver(url, cap);
		
		driver.get("http://www.amazon.com/");
		
		driver.quit();
	}

}
