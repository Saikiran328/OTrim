package com.otrim.qa.AutoIt;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingWindowAuthentication {

	public static void main(String[] args) throws IOException, InterruptedException {
	
		//To handle Windows based Authentication pop-up we can handle by using AutoIt.
		
		/*1.Need to install AutoIT in to your system download from link-- https://www.autoitscript.com/site/autoit/downloads/
		2.For Installation steps follow link -- https://www.softwaretestinghelp.com/autoit-tutorial-to-download-write-autoit-script/
		3.Go to C driver program files(x86) - Search for AutoIt3 folder - click on AutoIt folder - Click on SciTE folder - Double click on SciTE.exe
		4.Observe AutoIt editor window
		5.type the comonads in the editor -- save the file in any loaction you want
		6.Right click on file -- serach for Compile Script (*64) click on the option you will .exe file*/
		
		//WebDriverManager.firefoxdriver().setup();
		//WebDriver driver = new FirefoxDriver();
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		
		Thread.sleep(5000);
		
		Runtime.getRuntime().exec("C:\\Users\\User\\Downloads\\Workplace\\OtrimMaven\\AutoIt\\HandlingWindowAuthentication.exe");
				
		
		driver.get("https://the-internet.herokuapp.com/basic_auth");

	}

}
