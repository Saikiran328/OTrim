package com.otrim.qa.OpenInTheExistingBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenInTheExsistingBrowser {

	public static void main(String[] args) {
	
		//I want run the script in already opened browser----normal selenium process is for each time of script execute it will open a new browser window
		//https://chromedevtools.github.io/devtools-protocol/
		//1.Goto chrome.exe file path
		//2.Go to environment variables and the chrome.exe file path in the path section
		//3.Create a folder with any name 
		//3.Open cmd prompt enter chrome.exe --remote-debugging-port=9222(u can give any 4 digit port)  --user-data-dir=D:\Chrome
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions opt = new ChromeOptions();
		opt.setExperimentalOption("debuggerAddress","localhost:61078");
		WebDriver driver = new ChromeDriver(opt);
		driver.get("https://facebook.com");
		

	}

}
