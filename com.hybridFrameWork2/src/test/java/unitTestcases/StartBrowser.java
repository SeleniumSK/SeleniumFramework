package unitTestcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import dataProvider.ConfigDataProvider;
import dataProvider.ExcelDataProvider;
import dataProviderFactory.BrowserFactory;
import dataProviderFactory.DataProviderFactory;

public class StartBrowser {
	
	@Test(enabled=false)
	public void testBrowser()
	{
		
	WebDriver driver =	BrowserFactory.startBrowser("Chrome");
		driver.get("http://www.learn-automation.com");
		BrowserFactory.closeBrowser(driver);
		
	}
	
	@Test(enabled=true)
	public void testConfigFile()
	{
		
		String Path = DataProviderFactory.getConfig().getValue("ChromePath");
		
		System.out.println(Path);
		
	}
	@Test(enabled=true)
	public void testExcelData()
	{
		
		
		
		String Data = DataProviderFactory.getExcel().getData("login", 1, 1);
		System.out.println(Data);
	}

}
