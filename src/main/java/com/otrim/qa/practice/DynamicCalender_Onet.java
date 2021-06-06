package com.otrim.qa.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicCalender_Onet {
	static WebDriver driver;
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		driver.get("https://onet1uidev.onpassive.com/");
		
		driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]")).click();
		
		driver.findElement(By.xpath("//input[@id='mat-input-0']")).click();
		
		System.out.println("clicked on calendar");
		

	List<WebElement> dates=driver.findElements(By.xpath("//table[@class='mat-calendar-table']/tbody/tr[2]/td"));
		
		int total_nodes =dates.size();
		
		for(int i=0;i<total_nodes;i++) {
			
			String date = dates.get(i).getText();
			
			if(date.equalsIgnoreCase("12")) {
				dates.get(i).click();
				break;
			}
		}
	}

}
