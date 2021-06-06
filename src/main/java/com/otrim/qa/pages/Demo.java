package com.otrim.qa.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo {
	
	Logger log = LogManager.getLogger();
	
	//----------------------------------------------
	public static WebDriver driver;
	public ExtentReports extent;
	public ExtentHtmlReporter htmlReporter;
	public ExtentTest test;
	
	public String titleOfThepage="Free Custom URL Shortener by ONPASSIVE | Trim URL";
	
	public void setExtent() {
		htmlReporter = new ExtentHtmlReporter("C:\\Users\\User\\Downloads\\Workplace\\OtrimMaven\\ExtentReports\\MyReport.html");
		htmlReporter.config().setDocumentTitle("Automation Report");//Title of the Report
		htmlReporter.config().setReportName("Functional Testing");//Name of the Report
		htmlReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("HostName","LocalHost");
		extent.setSystemInfo("OS","Windows10");
		extent.setSystemInfo("Tester Name","Saikiran");
		extent.setSystemInfo("Browser","Chrome");
	}
	@AfterTest
	
//	public void getResult(ITestResult result) throws IOException {
//		if (result.getStatus() == ITestResult.FAILURE) {
//			String screenShotPath = GetScreenShot.capture(Base.driver, "screenShotName", result);
//			test.log(Status.FAIL, MarkupHelper.createLabel(result.getTestName() + " Test case FAILED due to below issues:",
//					ExtentColor.RED));
//			test.fail(result.getThrowable());
//			test.fail("Snapshot below: " + test.addScreenCaptureFromPath(screenShotPath));
//		} else if (result.getStatus() == ITestResult.SUCCESS) {
//			test.log(Status.PASS, MarkupHelper.createLabel(result.getTestName() + " Test Case PASSED", ExtentColor.GREEN));
//		} else {
//			test.log(Status.SKIP,
//					MarkupHelper.createLabel(result.getTestName()+ " Test Case SKIPPED", ExtentColor.ORANGE));
//			test.skip(result.getThrowable());
//		}
//		extent.flush();
//	}
	
	
	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		System.out.println("Chrome Browser Opened");
		log.info("Chrome Browser Opened");
		driver.manage().window().maximize();
		System.out.println("Chrome Window Maximize");
		log.info("Chrome Window Maximize");
		driver.get("https://otrimuiuat.onpassive.com/");
		System.out.println("URL Entered In The Chrome Browser");
		log.info("URL Entered In The Chrome Browser");
	}
	
	@Test
	public void titleTest() {
		test= extent.createTest("Checking Title Of The Page");
		String title= driver.getTitle();
		log.info("Title Of The Page Is:"+title);
		System.out.println("Title Of The Page Is:"+title);
	}

}
