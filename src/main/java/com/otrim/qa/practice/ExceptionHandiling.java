package com.otrim.qa.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExceptionHandiling {

	static WebDriver driver;
	
	public static void main(String[] args) {
		
		//NoSuchElement Exception
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
		driver.get("https://www.google.com");
		
		try {
			driver.findElement(By.name("fake")).click();
		}catch(Exception e){
			System.out.println("No Eelement found");
			throw(e);
		}

		System.out.println("I am outside of the try catch block");
	}

}
