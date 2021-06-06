package com.otrim.qa.AutoIt;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UploadingFile {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		//Some of the WebElements not worked in the chrome driver even though provided correct webelement
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		
		driver.get("http://demo.automationtesting.in/Register.html");
		
		Thread.sleep(5000);
		
		/*Some times you are providing the valid path of the WebElement but you will get an error called
		 invalid argument because webdriver can not find that element at that time you can use javascriptexecutor---
		 In seleniun if use .click() method internally it will convert to javascript only */
		
		WebElement browseButton = driver.findElement(By.xpath("//*[@id='imagesrc']"));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",browseButton);
		
		/*Now we have to right the code to upload a file using AutoIt
		 * In Selenium we can find a n element by using inspect element but in AutoIt we have Au3Info_*64 is there to find the Element name and class
		 * If you click on Au3Info it will open one window -- In tha window you can find Finder Tool option
		 * */
		Runtime.getRuntime().exec("C:\\Users\\User\\Downloads\\Workplace\\OtrimMaven\\AutoIt\\UploadingFile.exe"+" "+"C:\\Users\\User\\Downloads\\21.jpg");
		
		//driver.close();

	}

}
