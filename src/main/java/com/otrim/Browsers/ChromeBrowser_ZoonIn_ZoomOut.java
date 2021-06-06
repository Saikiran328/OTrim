package com.otrim.Browsers;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeBrowser_ZoonIn_ZoomOut {

	static WebDriver driver;
	static String ZoomLevelIncrease = "150%";
	static String ZoomLevelDecrease = "75%";
	static String ZommLevelNormal ="100%";
	public static void main(String[] args) throws InterruptedException, AWTException {
		
		WebDriverManager.chromedriver().setup();
		
		driver =  new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		robotClass_ZoomInZoomOut();
		//ZoomInZoomOut();

	}

	public static void ZoomInZoomOut() throws InterruptedException {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom='"+ZoomLevelIncrease+"'");
		System.out.println("Zoom level is set to:" + ZoomLevelIncrease);
		Thread.sleep(5000);
		
		js.executeScript("document.body.style.zoom='"+ZoomLevelDecrease+"'");
		System.out.println("Zoom level is set to:" + ZoomLevelDecrease);
		Thread.sleep(5000);
		
		js.executeScript("document.body.style.zoom='"+ZommLevelNormal+"'");
		System.out.println("Zoom level is set to:"+ ZommLevelNormal);
		Thread.sleep(5000);
	}
	
	public static void robotClass_ZoomInZoomOut() throws AWTException, InterruptedException {
		
		Robot r = new Robot();
		
		for(int i=0;i<3;i++) {
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_ADD);
		r.keyRelease(KeyEvent.VK_ADD);
		r.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(3000);
		}
		
		for(int i=0 ;i<3;i++) {
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_SUBTRACT);
			r.keyRelease(KeyEvent.VK_SUBTRACT);
			r.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(3000);
		}
	}
}
