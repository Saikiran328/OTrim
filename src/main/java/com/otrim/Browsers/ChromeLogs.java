package com.otrim.Browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeLogs {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.logfile","C:\\Users\\User\\Downloads\\Workplace\\OtrimMaven\\ChromeLogs\\ChromeLog.txt");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://facebook.com");
	}

}
