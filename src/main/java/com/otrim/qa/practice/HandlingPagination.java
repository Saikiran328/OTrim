package com.otrim.qa.practice;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingPagination {

	static WebDriver driver;
	public static void paginationUsingForLoop() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://datatables.net/examples/advanced_init/dt_events.html");

		driver.manage().deleteAllCookies();
	
		int paginationSize = driver.findElements(By.cssSelector("#example_paginate>span>a")).size();

		List<String> names = new ArrayList<String>();

		for (int i = 1; i <= paginationSize; i++) {

//			String paginationSelector = "#example_paginate>span>a:nth-child(" + i + ")";
//
//			driver.findElement(By.cssSelector(paginationSelector)).click();
			
			driver.findElement(By.cssSelector("#example_paginate>span>a:nth-child("+i+")")).click();

			List<WebElement> nameElements = driver.findElements(By.xpath("#example>tbody>tr>td:nth-child(1)"));

			for (WebElement namesElement : nameElements) {
				names.add(namesElement.getText());
			}
		}
		for (String name : names) {
			System.out.println(name);
		}
		int totalNames = names.size();
		System.out.println("Total Number Of Names :" + totalNames);
		String displayedCount = driver.findElement(By.id("example_info")).getText().split(" ")[5];
		System.out.println("Total Number Of Displayed Names Count :" + displayedCount);
		Assert.assertEquals(displayedCount, String.valueOf(totalNames));
			
	}
		
	public static void main(String[] args) {
		paginationUsingForLoop();

	}

}
