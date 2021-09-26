package com.otrim.ExtentReports;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportsFive {

	@Test
	public void extentTest() {
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("index.html");
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("MyReport");
		spark.config().setReportName("Extent Reports Demo");
		extent.attachReporter(spark);
		
		ExtentTest test =extent.createTest("Login Test").assignAuthor("Saikiran").assignCategory("Smoke").assignCategory("Regression").assignDevice("Chrome v.84");//Create a test node in the report
		test.pass("Login Test Started Successfully"); //Create a test step node in the report
		test.info("URL is loaded");
		test.info("Values Entered");
		test.pass("Login Test Completed Successfully");
		
		
		ExtentTest test1 =extent.createTest("HomePage Test").assignAuthor("Saikiran").assignCategory("Smoke").assignAuthor("Sandeep").assignDevice("firefox v.80"); //Create a test node in the report
		test1.pass("HomePage Test Started Successfully"); //Create a test step node in the report
		test1.info("URL is loaded");
		test1.info("Values Entered");
		test1.pass("HomePage Test Completed Successfully");
		
		extent.flush(); //Unless you call this method, your report will not be written with logs

	}
}
