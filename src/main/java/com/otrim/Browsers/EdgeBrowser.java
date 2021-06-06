package com.otrim.Browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.opera.OperaDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EdgeBrowser {

	public static void main(String[] args) {
		
		//Need download the edge driver from -- https://developer.microsoft.com/en-us/microsoft-edge/tools/webdriver/
	    //We need to understnad one point here browser version and driver version should be same other you will get seesion not created error
		
//		//Way-1
//		System.setProperty("webdriver.edge.driver","D:\\Softwaretools\\edgedriver_win64\\msedgedriver.exe");
//		WebDriver driver = new EdgeDriver();
//		driver.get("https://www.google.com");

		//Every time checking the versions and downloading the new driver version is not possible
		//To overcome this we need a dependency called webdrivermanager --- copy dependency from the link-- https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager
		//Add the dependency in the pom.xml
		
		
		//If you get any error update the webdrivermanager dependency to latest version
		//Way--2
//		WebDriverManager.edgedriver().setup();
//		WebDriver driver1 = new EdgeDriver();
//		driver1.get("https://www.google.com");
		
	
	}

}
