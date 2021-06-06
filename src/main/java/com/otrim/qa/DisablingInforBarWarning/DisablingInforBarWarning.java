package com.otrim.qa.DisablingInforBarWarning;

import java.util.Collections;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DisablingInforBarWarning {

	public static void main(String[] args) {
		
		//we can disable -- Chrome is being controlled by automated test software using chromeoptions
		
		ChromeOptions options = new ChromeOptions();
		//Use this below line to disable the Disabling Infobar warning message
		options.setExperimentalOption("excludeSwitches", Collections.singleton("enable-automation"));
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.google.com");
		

	}

}
