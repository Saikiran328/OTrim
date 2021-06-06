package com.otrim.qa.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v89.security.Security;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IngnoreSSLCertificate {

	WebDriver driver;
	DevTools devTools;
	
	@Test
	public void test() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		devTools=((ChromeDriver)driver).getDevTools();
		driver.get("https://expired.badssl.com/"); 	
		Thread.sleep(5000);
		
		devTools.send(Security.enable());
		devTools.send(Security.setIgnoreCertificateErrors(true));
		driver.get("https://expired.badssl.com/"); 	
		
	
	}
	
}
