package com.otrim.TestNGReport;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

//In TestNG by default report was generated with default values
//If you want to change the output of the report with some detail information
//TestNG provide an option to edit the emailable-report by using Reporter.log() method

public class EditTestNGReport {

		@Test
		public void cutomizeEmailableReport_TestNGReport() throws IOException {
			
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			Reporter.log("Navigated to chrome browser");
			driver.manage().window().maximize();
			Reporter.log("Chrome browser maximized");
			driver.get("http://tutorialsninja.com/demo/index.php?route=account/login");
			Reporter.log("Navigated to URL");
			driver.findElement(By.id("input-email")).sendKeys("arun.selenium@gmail.com");
			Reporter.log("User Email Entered");
			driver.findElement(By.id("input-password")).sendKeys("Second@123");
			Reporter.log("User Password Entered");
			driver.findElement(By.xpath("//input[@value='Login']")).click();
			Reporter.log("Clicked on Login Button");
			Assert.assertTrue(driver.findElement(By.xpath("//a[.='Edit your account information']")).isDisplayed());
			Reporter.log("Assert condition verified");
			
			//Below code is useful to take the screenshot
			File src1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			//screenshots//screenshot.png in the run time it will create a folder name as screenshots and file name is screenshot.png
			FileUtils.copyFile(src1, new File("screenshots//screenshot.png"));
			
			//If you want to show the screenshot as href you have to add the below code
			//When i click on screenshot if you want open the screenshot in a new window add target=_blank
			Reporter.log("<a target=\"_blank\" href=\"C:\\Users\\User\\Downloads\\Workplace\\OtrimMaven\\Screenshots\\screenshot.png\">Screenshot</a>");
			
			//If you want to show the image in the emailable report add below code
			
			Reporter.log("<img src=\"C:\\Users\\User\\Downloads\\Workplace\\OtrimMaven\\Screenshots\\screenshot.png\"/>");
			
			driver.close();

		}

}
