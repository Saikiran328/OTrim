package com.otrim.Browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OperaBrowser {

	public static void main(String[] args) {
		
		//Download opera driver from --- https://github.com/operasoftware/operachromiumdriver/releases
		//Check the opera browser version if it is 70v u can download 70v opera driver only
	
		WebDriver driver = new OperaDriver();
		driver.get("https://www.google.com");
				
		
//		WebDriverManager.operadriver().setup();
//		WebDriver driver1 = new OperaDriver();
//		driver1.get("https://www.google.com");

	}

}
