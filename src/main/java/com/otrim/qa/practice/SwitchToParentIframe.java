package com.otrim.qa.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SwitchToParentIframe {
static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://quackit.com/html/tags/html_iframe_tag.cfm");
		Thread.sleep(5000);
		WebElement parentFrame=driver.findElement(By.cssSelector("iframe[src$='editorCode4']"));
		driver.switchTo().frame(parentFrame);
		WebElement childFrame = driver.findElement(By.cssSelector("iframe[src$='/html/tags/html_iframe_tag_example.cfm']"));
		driver.switchTo().frame(childFrame);
		
		String childFrameText=driver.findElement(By.xpath("/html/body/p[1]")).getText();
		System.out.println(childFrameText);
	
		driver.switchTo().parentFrame();
		System.out.println("Switched to Parent Frame");
	}

}
