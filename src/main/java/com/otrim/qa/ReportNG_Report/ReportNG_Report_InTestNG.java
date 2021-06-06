package com.otrim.qa.ReportNG_Report;

import java.io.File;
import java.io.IOException;

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

public class ReportNG_Report_InTestNG {

	
		//If you are using TestNG to execute the test scripts --TestNG will generate a default report 
		//Default TestNG report shown in the test-output folder
		//If you observe the test-output folder you will have only 4 folders inside
		
		//Steps to be done -- Ponit---1
		//If you want the ReportNG report we need to add a dependency called ReportNG from Maven Repository
		//Dependency have to add  find the ReportNG with org.uncommons -- select latest dependency and add in to pom.xml
		
		//Steps to be done -- Point--2
		//Create a TestNG.xml file in the project
		/*Steps: For which class you want to create a TestNG.xml -- Right on the Package -- search for TestNG -- click on convert to TestNG
		If option is not visible -- follow the steps -- Click on Help - Go to Eclipse MarketPlace -- Search for TestNg for eclipse -- Click on install*/
		
		//Steps to done -- point 3
		//open the url -- https://drive.google.com/file/d/1rTn8Y7HmWRLfkfLt5I7gEa1N3YrIi-b-/view
		//Copy the code -- open testng.xml file -- add the <listners> tag after the <suite> tag
		
		
		@Test
		public void reportNG_report() throws IOException {
			
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			Reporter.log("Navigated to chrome browser"+"\nline");
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
			
			driver.close();
			
			//In the html folder - index.html below code displayed as text to convert to href need to add below line
			System.setProperty("org.uncommons.reportng.escape-output","false");
			
			//If you want to show the screenshot as href you have to add the below code
			//When i click on screenshot if you want open the screenshot in a new window add target=_blank
			Reporter.log("<a target=\"_blank\" href=\"C:\\Users\\User\\Downloads\\Workplace\\OtrimMaven\\Screenshots\\screenshot.png\">Screenshot</a>");
			
			//If you want to show the image in the emailable report add below code
			//Reporter.log("<img src=\"C:\\Users\\User\\Downloads\\Workplace\\OtrimMaven\\Screenshots\\screenshot.png\"/>");
			
			
		}

	}

