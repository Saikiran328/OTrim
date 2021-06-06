package com.otrim.qa.GetHtmlCode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class GetHtmlCode_For_WebElement {

	public static void main(String[] args) {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://facebook.com");
		
		//If you want the html code for a particular code 
		//Use below code
		WebElement loginButton = driver.findElement(By.name("login"));
		String outerhtmlofLoginButton = loginButton.getAttribute("outerHTML");
		System.out.println(outerhtmlofLoginButton);
		
		

	}

}
