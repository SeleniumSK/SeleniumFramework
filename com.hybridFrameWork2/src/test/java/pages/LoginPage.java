package pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage {
	
	WebDriver driver;
	public LoginPage(WebDriver ldriver)
	{
		this.driver = ldriver;
		
	}
	
	@FindBy(id = "txtUsername") WebElement username;
	@FindBy(id = "txtPassword") WebElement password;
	@FindBy(id = "btnLogin") WebElement login;
	
	public void verifyLogin()
	{
		
		 Assert.assertTrue(login.isDisplayed());
	}
	
	
	public void loginApp(String userId, String pass)
	{
		
		 username.sendKeys(userId);
		 password.sendKeys(pass);
		 login.click();
	}
	

}
