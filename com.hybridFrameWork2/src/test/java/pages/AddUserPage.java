package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class AddUserPage {
	
	WebDriver driver;
	public AddUserPage(WebDriver ldriver)
	{
		this.driver = ldriver;
		
	}
	
	
	@FindBy(id= "menu_pim_viewPimModule")WebElement pimTab;
	
	@FindBy(id="btnAdd")WebElement addButton;
	
	@FindBy(id="firstName")WebElement firstName;
	
	@FindBy(id="lastName")WebElement lastName;
	
	@FindBy(id="btnSave")WebElement saveButton;
	
	@FindBy(id="chkLogin")WebElement CheckboxLoginDetails;
	
	@FindBy(id="user_name")WebElement userName;
	
	@FindBy(id="user_password")WebElement password;
	
	@FindBy(id="re_password")WebElement confirmpassword;
	
	@FindBy(id="menu_pim_viewEmployeeList")WebElement employeeList;
	
	@FindBy(id="resultTable")WebElement results;
	
	
	@FindBy(id="status")WebElement status;
	
	
	@FindBy(id="empPic")WebElement picture;
	
	@FindBy(id="empsearch_employee_name_empName")WebElement empName;
	
	@FindBy(id="searchBtn")WebElement searchButton;
	
	public void addUser(String fname, String lname, String uname, String pass )
	{
		
		pimTab.click();
		
		addButton.click();
		
		firstName.sendKeys(fname);
		
		lastName.sendKeys(lname);
		
		CheckboxLoginDetails.click();
		
		userName.sendKeys(uname);
		
		password.sendKeys(pass);
		
		confirmpassword.sendKeys(pass);
		
		status.click();
		
		saveButton.click();
	}
	
	public void verifyAddUser()
	{
		Assert.assertTrue(picture.isDisplayed());
		
		}

	
	public void searchUser(String eName)
	{
		pimTab.click();
		
		empName.sendKeys(eName);
		
		searchButton.click();
		List<WebElement> results = driver.findElements(By.xpath("//*[@id='resultTable']/tbody"));
		
					
			Assert.assertTrue(results.contains(eName));
		}
	
}
