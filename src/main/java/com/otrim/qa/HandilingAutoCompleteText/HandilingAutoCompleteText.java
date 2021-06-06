package com.otrim.qa.HandilingAutoCompleteText;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandilingAutoCompleteText {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/autoComplete.html");

		WebElement textField = driver.findElement(By.id("tags"));

		textField.sendKeys("a");

		Thread.sleep(2000);

		Actions actions = new Actions(driver);

		actions.sendKeys(textField, Keys.DOWN).sendKeys(Keys.ENTER).build().perform();
	}

}
