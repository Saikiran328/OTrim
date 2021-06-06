package com.otrim.qa.practice;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicGoogleSearch {

	public static WebDriver driver;
	
	public static void main(String[] args) throws Exception {

		
		System.setProperty("webdriver.chrome.driver","D:\\Softwaretools\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.google.com/");
										
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
		//This is the xpath of google search feild
		driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("java");
		
		List<WebElement> list =driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='sbl1']"));
				
		System.out.println(list.size());
	
		for(int i=0;i<list.size();i++) {
		System.out.println(list.get(i).getText());
		Thread.sleep(1000);
		}
			
		for(int j=0;j<list.size();j++) {
			if(list.get(j).getText().contains("java")) {
			   list.get(j).click();
			}
		}
	}

}
