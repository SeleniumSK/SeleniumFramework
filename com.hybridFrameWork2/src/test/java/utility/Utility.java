package utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class Utility {
	
	
	public static void highlightWebElement(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
		
		 
		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		js.executeScript("arguments[0].setAttribute('style', 'border: solid 2px white');", element);
	}

	
		public static WebElement CheckElementByXpath(WebDriver driver, String xpath, int time)
		
		{
			
			
			getElement(driver, xpath, time);
			
			WebElement element = driver.findElement(By.xpath(xpath));
			
			highlightWebElement( driver, element);
			
			return element;
			
			
		}
		
		public static void getElement(WebDriver driver, String xpath, int time)

		{
			FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
			
			wait.withTimeout(time, TimeUnit.SECONDS);
			
			wait.ignoring(Throwable.class);
			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
			
		}
}
