package com.otrim.qa.OpenInTheExistingBrowser;

import java.util.Map;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RunTestOnExsistingBrowser {

	public static void main(String[] args) {
	
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		Capabilities cap = driver.getCapabilities();
		
		Map<String, Object> myCap = cap.asMap();
		
		System.out.println(myCap);

	}

}
