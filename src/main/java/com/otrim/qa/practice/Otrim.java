package com.otrim.qa.practice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.KeyDownAction;


public class Otrim {

	static Actions actions;
	
	static WebDriver driver;
	
	static WebElement logOut;
	
	static WebElement alert_Ok_Btn;
	static String url = "https://www.amazon.in/b?node=3474656031&pf_rd_r=ZG7ESSXPF3KG9CNY0E4Z&pf_rd_p=04dbb183-1ce3-4ef7-a7ef-b5f64b54e0c5";
	

	public static void openBrowser() throws Exception {
		
		System.setProperty("webdriver.chrome.driver","D:\\Softwaretools\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://trimurldemo.onpassive.com/");
		Thread.sleep(3000);
	}
	
	public static void signUp() throws Exception {
		driver.findElement(By.xpath("//a[contains(text(),'Guest Signup')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[contains(@placeholder,'Your Name')]")).sendKeys("Saikiran");
		driver.findElement(By.xpath("//input[contains(@placeholder,'Your Business Email')]")).sendKeys("saikiran.sikhakolli@gmail.com");
		driver.findElement(By.xpath("//input[contains(@placeholder,'Your Password')]")).sendKeys("saikiran");
		Thread.sleep(3000);
	}
	
	public static void  eyeButton() throws Exception {
		WebElement eyeButton1 = driver.findElement(By.xpath("//img[contains(@class,'ng-star-inserted')]"));
		actions = new Actions(driver);
		actions.clickAndHold(eyeButton1).perform();
		Thread.sleep(2000);
		actions.release().perform();
	}
	
	public static void createAccount() throws Exception {
		driver.findElement(By.xpath("//button[contains(text(),'Create Account')]")).click();
		Thread.sleep(3000);
	}
	
	public static void alertButton() {
		alert_Ok_Btn= driver.findElement(By.xpath("//button[contains(text(),'OK')]"));
		alert_Ok_Btn.click();
	}
	
	public static void guestLogin() throws Exception {
		driver.findElement(By.xpath("//a[contains(text(),'Guest Login')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[contains(@placeholder,'User Name')]")).sendKeys("saikiran");
		driver.findElement(By.xpath("//input[contains(@placeholder,'Your Password')]")).sendKeys("saikiran");
	}
	
	public static void guestLoginBtn() throws Exception {
		
		driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
		Thread.sleep(3000);
	}
	
	public static void browserRefresh() throws Exception {
		driver.navigate().refresh();
		Thread.sleep(2000);
	}
	
	public static void closeBtn() {
		driver.findElement(By.xpath("//button[contains(@class,'close')]")).click();
	}
	
	public static void fortgotPassword() throws Exception {
		driver.findElement(By.xpath("//a[contains(text(),'Forgot Password')]")).click();
		driver.findElement(By.xpath("//input[contains(@type,'email')]")).sendKeys("saikiran.sikhakolli@gmail.com");
		driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
		Thread.sleep(3000);
		
		
		String mainwindow=driver.getWindowHandle();
		//handle new opens windows
		
		Thread.sleep(3000);
		Set<String> s=driver.getWindowHandles();
		Iterator<String> i=s.iterator();
		while(i.hasNext())
		{
		String chaildwindow=i.next();
		if(!mainwindow.equalsIgnoreCase(chaildwindow))
		{
		//switch to child window
		driver.switchTo().window(chaildwindow);
		
		WebElement btn=driver.findElement(By.xpath("//button[contains(text(),'OK')]"));
		btn.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[contains(@placeholder,'Verification OTP')]")).sendKeys("1234");
		}
		}
	}
	
	public static void logOut() throws Exception {
		logOut = driver.findElement(By.xpath("//i[contains(@class,'fa fa-sign-out')]"));
		logOut.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),'Guest Login')]")).click();
		Thread.sleep(3000);
	}
	
	public static void outsideClick() throws AWTException {
//		Robot robot = new Robot();
//		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK); 
//		 robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		 Actions actions = new Actions(driver);
		 actions.moveToElement(driver.findElement(By.xpath("//body/div[3]"))).build().perform();
		 actions.click();
	}
	public static void main(String[] args) throws Exception {
		
		openBrowser();
//		//Signup Features
//		signUp();
//		eyeButton();
//		createAccount();
//		alertButton();
//		closeBtn();
		
		//Guest Login
		
//		browserRefresh();
//		guestLogin();
//		eyeButton();
//		guestLoginBtn();
//		
		
		//Forgot Paasword
		driver.findElement(By.xpath("//a[contains(text(),'Guest Login')]")).click();
		Thread.sleep(2000);
		fortgotPassword();
		
		
		
		
		
		
		
		
		
//		//User Name   Your Password		
//			
//		
//		WebElement login_eyeButton= driver.findElement(By.xpath("//img[contains(@class,'ng-star-inserted')]"));
//		actions = new Actions(driver);
//		actions.clickAndHold(login_eyeButton).perform();
//		Thread.sleep(2000);
//		actions.release().perform();
//		
//		
//		
//		Thread.sleep(2000);
//		
//		alert_Ok_Btn= driver.findElement(By.xpath("//button[contains(text(),'OK')]"));
//		alert_Ok_Btn.click();

		
		//Xpaths	
		//app-common-header/div[@id='lgfModal']/div[1]/div[1]/div[2]/app-login-comp[1]/form[1]/div[1]/div[1]/input[1]
		//app-common-header/div[@id='lgfModal']/div[1]/div[1]/div[2]/app-login-comp[1]/form[1]/div[1]/div[2]/div[1]/input[1]
		//app-common-header/div[@id='lgfModal']/div[1]/div[1]/div[2]/app-login-comp[1]/form[1]/div[1]/div[2]/div[1]/i[1]
		//driver.findElement(By.xpath("//app-common-header/div[@id='lgfModal']/div[1]/div[1]/div[2]/app-register-comp[1]/form[1]/div[1]/input[1]")).sendKeys("saikiran");
		//driver.findElement(By.xpath("//app-common-header/div[@id='lgfModal']/div[1]/div[1]/div[2]/app-register-comp[1]/form[1]/div[2]/input[1]")).sendKeys("saikiran.sikhakolli@gmail.com");
		//driver.findElement(By.xpath("//app-common-header/div[@id='lgfModal']/div[1]/div[1]/div[2]/app-register-comp[1]/form[1]/div[3]/div[1]/input[1]")).sendKeys("saikiran");
		
			
			
			//Scroll into View
//			WebElement moveToElement = driver.findElement(By.xpath("//h1[contains(text(),'Build Your Brand with Each Click')]"));
//			scrollInToView(moveToElement, driver);
			
//			
//			Thread.sleep(3000);
//			
//			driver.findElement(By.xpath("//input[@id='url']")).sendKeys(url);
//			
//			driver.findElement(By.xpath("//button[@id='submit_url']")).click();
//			
//			Thread.sleep(3000);
//		
//			//Click on Ok in popup
//			WebElement e = driver.findElement(By.xpath("//button[contains(text(),'OK')]"));         
//			e.click();
//			
//			Thread.sleep(3000);
//			WebElement clickToCopy = driver.findElement(By.xpath("//button[@id='clickMe']"));
//			clickToCopy.click();
//			
//			WebElement Shorturl = driver.findElement(By.xpath("//body/div[2]/div[2]/div[1]/div[1]/div[2]/input[1]"));
//			String url1 = Shorturl.getAttribute("value");
//			System.out.println(url1);
//					
//			Thread.sleep(3000);
//					
//			((JavascriptExecutor) driver).executeScript("window.open()");
//					
//			String mainwindow=driver.getWindowHandle();
//			//handle new opens windows
//			
//			Thread.sleep(3000);
//			Set<String> s=driver.getWindowHandles();
//			Iterator<String> i=s.iterator();
//			while(i.hasNext())
//			{
//			String chaildwindow=i.next();
//			if(!mainwindow.equalsIgnoreCase(chaildwindow))
//			{
//			//switch to child window
//			driver.switchTo().window(chaildwindow);
//				
//			 driver.get(url1);
//			}
//			}
				
		}


	private static void setUp() {
		// TODO Auto-generated method stub
		
	}
		
//		public static void scrollInToView(WebElement element, WebDriver driver) {
//			JavascriptExecutor js = ((JavascriptExecutor) driver);
//			js.executeScript("arguments[0].scrollIntoView(true);", element);
//		}
//	

}




