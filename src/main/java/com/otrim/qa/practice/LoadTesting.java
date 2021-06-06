package com.otrim.qa.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;

import com.otrim.qa.util.TestUtil;

public class LoadTesting {
	static WebDriver driver;
//static String data;
//static String data1;
	static int i;

//	@Test
	public static void Test() throws IOException, InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:\\Softwaretools\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://stagingui01.onpassive.com/home");
		Thread.sleep(1000);

		FileInputStream file = new FileInputStream("D:\\OcademyLogin.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet sheet = wb.getSheetAt(0);
		int rowCount = sheet.getLastRowNum();
		System.out.println(rowCount);

		for (i = 0; i <= rowCount; i++) {
			String data = sheet.getRow(i).getCell(0).getStringCellValue();
			System.out.println(data);
			driver.findElement(By.xpath("//li[@id='login-nav']")).click();
			Thread.sleep(1000);

			driver.findElement(By.xpath("//input[@placeholder='Email'][@formcontrolname='email']")).sendKeys(data);
			driver.findElement(By.xpath("//input[@placeholder='Password'][@formcontrolname='password']"))
					.sendKeys("onpassive123");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
			Thread.sleep(1000);
			Actions actions = new Actions(driver);
			actions.moveToElement(driver.findElement(By.cssSelector(
					"div.wrapper:nth-child(1) app-mylearning.ng-star-inserted:nth-child(2) div.container-fluid nav.px-0.navbar.navbar-expand-lg.navbar-light div.collapse.navbar-collapse ul.navbar-nav.customnavcls ul.nav.navbar-nav.navbar-right.customcls li.nav-item.user-dropdown-cls.ng-star-inserted:nth-child(6) span.showuserdrop.ng-star-inserted > button.mat-focus-indicator.dropbtn.user.mr-3.mat-mini-fab.mat-button-base.mat-primary")))
					.build().perform();
			Thread.sleep(1000);
			WebElement mylearning = driver.findElement(By.xpath("//a[contains(text(),'My Learning')]"));
			mylearning.click();
			Thread.sleep(1000);
			WebElement course = driver.findElement(By.xpath("//h5[contains(text(),'new Anuglar version Updated')]"));
			course.click();
			Thread.sleep(1000);
			WebElement playBtn = driver.findElement(By.cssSelector(
					"div.wrapper:nth-child(1) app-studentcourses.ng-star-inserted:nth-child(2) div.videomain:nth-child(2) div.combitnationdiv div.videoleft vg-player.ng-star-inserted vg-controls:nth-child(4) > vg-play-pause:nth-child(1)"));
			playBtn.click();

		}
		
	}
	
	public static void main(String[] args) throws IOException, InterruptedException {
		Test();
	}
}
