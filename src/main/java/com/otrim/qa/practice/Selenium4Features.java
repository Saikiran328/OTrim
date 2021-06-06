package com.otrim.qa.practice;

import java.io.File;
import java.io.IOException;
//import java.util.Optional;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
//import org.openqa.selenium.devtools.v84.network.Network;
import org.openqa.selenium.devtools.v89.security.Security;
//import org.openqa.selenium.firefox.FirefoxDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

//Relative locators (or) Friendly Locators in selenium 4 1.below(); 2.toLeftOf();  3.toRightOf();  4.above();  5.near();
//Add depenency of Webdriver manager and add dependency of selenium java alpha version it is the selenium 4 feature and guava dependency

public class Selenium4Features {

	static WebDriver driver;
	

	public static void setUp() {
		//WebDriverManager.firefoxdriver().setup();
		//driver = new FirefoxDriver();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		}
	
	
	public void tearDown() {
		if(driver !=null) {
			driver.quit();
		}
	}
	
	public static void testBrowserWindow() {
		driver.get("https://trimurldemo.onpassive.com/");
		driver.switchTo().newWindow(WindowType.TAB); //it will open new tab in the browser 
		driver.get("https://trimurldemo.onpassive.com/");
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://trimurldemo.onpassive.com/");
	}

	public static void screenShot() throws IOException {
		
		WebElement OTrimLogo = driver.findElement(By.cssSelector("div.wrapper app-common-home.ng-star-inserted:nth-child(2) header.cmn_header div.container div.row div.col-md-6.logo:nth-child(1) > img:nth-child(1)"));
		
		File logoFile = OTrimLogo.getScreenshotAs(OutputType.FILE);
		
		File DestFolder= new File("C:\\Users\\User\\Downloads\\Workplace\\OtrimMaven\\Images\\OTrimLoge.png");
		
		FileUtils.copyFile(logoFile, DestFolder);
	}
	
	
	
	public static void DimensionsAndCo_ordinates() throws IOException {
		
		WebElement OTrimLogo = driver.findElement(By.cssSelector("div.wrapper app-common-home.ng-star-inserted:nth-child(2) header.cmn_header div.container div.row div.col-md-6.logo:nth-child(1) > img:nth-child(1)"));
		
		//It will get the height and width of the OTrimLogo
		System.out.println("Height"+":"+ OTrimLogo.getRect().getDimension().getHeight());
		System.out.println("Width"+ ":"+ OTrimLogo.getRect().getDimension().getWidth());
		
		//It will get the X and Y CO-Ordinates of the OTrimLogo
		System.out.println("X-Cordinate"+":"+ OTrimLogo.getRect().getX());
		System.out.println("Y-Cordinate"+":"+ OTrimLogo.getRect().getY());
	}
	
	public static void ignoreSSLCertificate() throws InterruptedException {
		DevTools devTools=((ChromeDriver)driver).getDevTools();
		driver.get("https://expired.badssl.com/"); 	
		Thread.sleep(5000);
		devTools.send(Security.enable());
		devTools.send(Security.setIgnoreCertificateErrors(true));
		driver.get("https://expired.badssl.com/"); 	
	}
	
	public static void fullScreenMode() throws InterruptedException {
		
		setUp();
		driver.manage().window().fullscreen();
		Thread.sleep(5000);
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://www.google.com");
	}
	
	public static void parentFrame() throws InterruptedException {
		setUp();
		driver.get("https://quackit.com/html/tags/html_iframe_tag.cfm");
		Thread.sleep(5000);
		WebElement parentFrame=driver.findElement(By.cssSelector("iframe[src$='editorCode4']"));
		driver.switchTo().frame(parentFrame);
		WebElement childFrame = driver.findElement(By.cssSelector("iframe[src$='/html/tags/html_iframe_tag_example.cfm']"));
		driver.switchTo().frame(childFrame);
		String childFrameText=childFrame.getText();
		System.out.println(childFrameText);
	}
	
	
	public static void main(String[] args) throws IOException, InterruptedException {
		fullScreenMode();
	}

}
