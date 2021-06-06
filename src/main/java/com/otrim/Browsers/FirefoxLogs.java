package com.otrim.Browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirefoxLogs {

	public static void main(String[] args) {
	
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"C:\\Users\\User\\Downloads\\Workplace\\OtrimMaven\\FirefoxLogs\\FirefoxLogs.txt");
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("https://facebook.com");
	}

}
