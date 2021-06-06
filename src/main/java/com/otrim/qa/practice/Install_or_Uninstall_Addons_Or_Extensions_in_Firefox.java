package com.otrim.qa.practice;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Install_or_Uninstall_Addons_Or_Extensions_in_Firefox {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.firefoxdriver().setup();
		WebDriver driver= new FirefoxDriver();
		driver.manage().window().maximize();
		
		//Goto firefox - Go to extension page - Select extension - "right click on Add to Firefox" button - Click on  "Save Link As"
		Path seleniumIde_Install = Paths.get("D:\\Firefox_Extesions\\selenium_ide-3.17.0-fx.xpi");
		String extensionID=((FirefoxDriver)driver).installExtension(seleniumIde_Install);
		System.out.println(extensionID);
		System.out.println("seleniumIde installed successfully");
		Thread.sleep(5000);
		((FirefoxDriver)driver).uninstallExtension(extensionID); //or
		
		//This you will get from the console - once u install a plug it will generate the code
	//	((FirefoxDriver)driver).uninstallExtension("{a6fd85ed-e919-4a43-a5af-8da18bda539f}");
		
		System.out.println("seleniumIde Uninstalled successfully");
		

	}

}
