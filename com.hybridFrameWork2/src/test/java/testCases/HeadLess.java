package testCases;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.annotations.Test;

public class HeadLess {

	
	@Test
public void login(){
	
		System.setProperty("phantomjs.binary.path", new File("C:\\Users\\LENOVO\\SeleniumDrivers\\phantomjs.exe").getAbsolutePath());
		
		
	WebDriver driver = new PhantomJSDriver();
	
	driver.get("http://www.learn-automation.com");
	
	System.out.println("The title of the page is "+driver.getTitle());
	
	driver.quit();
}
}
