package com.otrim.qa.practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.otrim.qa.util.TestUtil;

public class Excel_TestNG {
	
	WebDriver driver;
		
	@BeforeMethod
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver","D:\\Softwaretools\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://trimurldemo.onpassive.com/");
		Thread.sleep(3000);
	}
	
	@DataProvider
	public Object[][] getSignUpData() {
		Object data[][]=TestUtil.readExcelData("","SignUp"); //SignUp is the name of the sheet
		return data;
	}
	
//	@DataProvider
//	public Object[][] getLoginData() {
//		Object data[][]=TestUtil.guestSignUpData("GuestLogin");//GuestLogin is the name of the sheet
//		return data;
//	}
	
	@Test(dataProvider = "getSignUpData")
	public void signUpTest(String yourName,String businessEmail,String yourPassword ) throws Exception {
		driver.findElement(By.xpath("//a[contains(text(),'Guest Signup')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[contains(@placeholder,'Your Name')]")).sendKeys(yourName);
		driver.findElement(By.xpath("//input[contains(@placeholder,'Your Business Email')]")).sendKeys(businessEmail);
		driver.findElement(By.xpath("//input[contains(@placeholder,'Your Password')]")).sendKeys(yourPassword);
	}
//	
//	@Test(dataProvider = "getLoginData",priority = 1)
//	public void loginTest(String userName,String yourPassword ) throws Exception {
//		
//		driver.findElement(By.xpath("//a[contains(text(),'Guest Login')]")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//input[contains(@placeholder,'User Name')]")).sendKeys(userName);
//		driver.findElement(By.xpath("//input[contains(@placeholder,'Your Password')]")).sendKeys(yourPassword);
//		Thread.sleep(3000);
//		}

	@Test()
	public void longUrltest() throws InterruptedException, IOException {
			
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
	}
	

