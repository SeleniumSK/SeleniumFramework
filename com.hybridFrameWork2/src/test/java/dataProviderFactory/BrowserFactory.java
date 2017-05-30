package dataProviderFactory;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import dataProvider.ConfigDataProvider;

public class BrowserFactory {
	
	
	public static WebDriver startBrowser(String BrowserName)
	{
		WebDriver driver = null;
		if(BrowserName.equalsIgnoreCase("firefox"))
		{
			DesiredCapabilities cap = new DesiredCapabilities();
			
			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			
			ConfigDataProvider config = new ConfigDataProvider();
			
			config.getValue("FireFoxPath");
			
			driver = new FirefoxDriver();
			
		}else if(BrowserName.equalsIgnoreCase("Chrome"))
		{
			ChromeOptions options = new ChromeOptions();
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("credentials_enable_service", false);
			map.put("password_manager_enabled", false);
			map.put("profile.default_content_settings.popups", 0);
			
			options.setExperimentalOption("prefs", map );
			
			DesiredCapabilities cap = new DesiredCapabilities();
			
			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			
			cap.setCapability(ChromeOptions.CAPABILITY, options);
			ConfigDataProvider config = new ConfigDataProvider();
			
			config.getValue("ChromePath");
			driver = new ChromeDriver(cap);
			
		}
		return driver;
	}
	
	public static void closeBrowser(WebDriver ldriver)
	{
		
		ldriver.close();
	}

}
