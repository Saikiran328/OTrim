package com.otrim.qa.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.otrim.qa.util.TestUtil;

public class SignUp_Excel{
	
	TestUtil util = new TestUtil();
	WebDriver driver;
	static WebElement element;
	public static Actions actions;
	
	public static String eyeButton="//img[contains(@class,'ng-star-inserted')]";
	
	@FindBy(xpath="//a[contains(text(),'Guest Signup')]")
	WebElement guestSignUpBtn;
	
	@FindBy(xpath="//input[contains(@placeholder,'Your Name')]")
	WebElement yourname;
	
	@FindBy(xpath="//input[contains(@placeholder,'Your Business Email')]")
	WebElement businessemail;
	
	@FindBy(xpath="//input[contains(@placeholder,'Your Password')]")
	WebElement yourpassword;

	@FindBy(xpath="//span[contains(text(),'Password Hint')]")
	WebElement passwordHint;
		
	@FindBy(xpath="//button[contains(text(),'Create Account')]")
	WebElement createAccount;
		
	@FindBy(xpath = "//button[contains(text(),'OK')]")
	WebElement okBtn;
	
	@FindBy(xpath = "//button[contains(@class,'close')]")
	WebElement closeBtn;
	
	public SignUp_Excel() {
	PageFactory.initElements(driver,this);
	}
	
	@DataProvider
	public Object[][] getSignUpData() {
		Object data[][]=TestUtil.readExcelData("","SignUp");//SignUp is the name of the sheet
		return data;
	}
	
	@BeforeMethod
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver","D:\\Softwaretools\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://trimurldemo.onpassive.com/");
		Thread.sleep(3000);
	}
	
	@Test(dataProvider="getSignUpData")
	public void signUpTest(String yourName,String businessEmail,String yourPassword ) throws Exception {
		driver.findElement(By.xpath("//a[contains(text(),'Guest Signup')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[contains(@placeholder,'Your Name')]")).sendKeys(yourName);
		driver.findElement(By.xpath("//input[contains(@placeholder,'Your Business Email')]")).sendKeys(businessEmail);
		driver.findElement(By.xpath("//input[contains(@placeholder,'Your Password')]")).sendKeys(yourPassword);
		util.eyeButton(eyeButton);
		Thread.sleep(2000);
		mouseHover();
	}
	
//	@Test(dataProvider = "getLoginData",priority = 1)
//	public void loginTest(String userName,String yourPassword ) throws Exception {
//		
//		driver.findElement(By.xpath("//a[contains(text(),'Guest Login')]")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//input[contains(@placeholder,'User Name')]")).sendKeys(userName);
//		
//		driver.findElement(By.xpath("//input[contains(@placeholder,'Your Password')]")).sendKeys(yourPassword);
//		Thread.sleep(3000);
//		}

//	@AfterMethod
//	public void tearDown() {
//		driver.close();
//	}

	public void mouseHover() throws Exception {
		actions.moveToElement(passwordHint).build().perform();
		Thread.sleep(2000);
	}
	
	}
	

