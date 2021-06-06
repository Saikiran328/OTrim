package com.otrim.qa.ScreenRecording;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenRecordingTheScript {

	public static void main(String[] args) throws Exception {
		
		//If you want to record the screen when execute the scripts
		//1.Add the monte dependency in to pom.xml -- https://mvnrepository.com/artifact/com.github.stephenc.monte/monte-screen-recorder/0.7.7.0 --com.github.stephenc.monte » monte-screen-recorder » 
		//2.Download the screenrecorder code from this link --- https://drive.google.com/file/d/1d_ecCGWEhWb911iD_aAd2vHS1L-4YBIp/view
		//3.Copy the downloaded file and paste in the releated package

		ScreenRecorderUtil.startRecord("main");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://facebook.com");
		
		//If you want the html code for a particular code 
		//Use below code
		WebElement loginButton = driver.findElement(By.name("login"));
		String outerhtmlofLoginButton = loginButton.getAttribute("outerHTML");
		System.out.println(outerhtmlofLoginButton);
		
		ScreenRecorderUtil.stopRecord();
		
	}

}
