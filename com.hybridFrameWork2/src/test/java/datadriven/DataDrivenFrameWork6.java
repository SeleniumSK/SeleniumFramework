package datadriven;


import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dataProvider.ExcelDataProvider;

public class DataDrivenFrameWork6 {
	
	WebDriver driver;
	
	ExcelDataProvider excel;
	
	ArrayList<String>results;
	@BeforeClass
	public void beforeStart()
	{
		results = new ArrayList();
		excel= new ExcelDataProvider();
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
	}
	
	@Test(dataProvider="data")
	public void login(String userName, String Password)
	{
		
		driver.get("http://opensource.demo.orangehrmlive.com/");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(userName);
		
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(Password);
		
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		
		boolean status = false;
		
		try {
			status = driver.findElement(By.xpath("//a[@id='welcome']")).isDisplayed();
			results.add("Pass");
		} catch (Exception e) {
			results.add("Fail");
			
		}
		
		
		Assert.assertTrue(status);
		
		
		driver.findElement(By.xpath("//a[text()='Welcome Admin']")).click();
		
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		
	}
	
	@AfterClass
	public void tearDown()
	{
		
		driver.quit();
		
		
		excel.StartWriteExcel();
		
		int rowCount = excel.getRow("login");
		
		for(int i= 1; i<rowCount;i++)
		{
			excel.writeData("login", i, 2, results.get(i-1));
		}
		
		excel.closeExcel();
	}
	
	
	@DataProvider(name="data")
	public Object [] [] dataGenerator()
	{
		
		System.out.println("Test Data getting ready");
		
		int excelRow = excel.getRow("login");
		Object [][] data = new Object[excelRow-1][2];
		
		for(int i= 1; i<excelRow;i++)
		{
			data[i-1][0]=excel.getData("login", i, 0);
			data[i-1][1]=excel.getData("login", i, 1);
		}
		
		
		
		
		System.out.println("Test Data is ready");
		
		
		
		return data;
		
		
		
		
		
	}

}
