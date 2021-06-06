package com.otrim.qa.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicCalender {

	static WebDriver driver;
	
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		driver.get("https://www.abhibus.com/");
		
		driver.findElement(By.xpath("//input[@id='datepicker1']")).click();
		
		List<WebElement> dates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
		
		int total_nodes =dates.size();
		
		for(int i=0;i<total_nodes;i++) {
			
			String date = dates.get(i).getText();
			
			if(date.equalsIgnoreCase("25")) {
				dates.get(i).click();
				break;
			}
		}
	}

}
