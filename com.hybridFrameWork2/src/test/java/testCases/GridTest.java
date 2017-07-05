package testCases;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class GridTest {
	
	@Test
	public void test1() throws MalformedURLException
	
	{
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName(BrowserType.CHROME);
		
		URL url = new URL("http://192.168.1.7:4444/wd/hub");
		
		WebDriver driver = new RemoteWebDriver(url, cap);
		
		driver.get("http://www.learn-automation.com/");
		
		driver.quit();
	}

}
