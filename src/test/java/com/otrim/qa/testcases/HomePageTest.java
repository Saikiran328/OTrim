package com.otrim.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.otrim.qa.pages.GuestLogin_HomePage;
import com.otrim.qa.util.TestUtil;


public class HomePageTest extends GuestLogin_HomePage {
	GuestLogin_HomePage homePage;
	public static String createYourCustomLink= "D:\\ExcelData\\CreateYourCustomURL_TestData.xlsx";
	public HomePageTest() {
		super();
	}
	
//	@BeforeClass
//	public void setUp() throws Exception {
//		intialization();
//		//Thread.sleep(5000);
//		homePage = new GuestLogin_HomePage();
//		
//	}
	
	
	@DataProvider
	public Object[][] editURL() {
		Object data[][] = TestUtil.readExcelData(createYourCustomLink,"LongUrls");// GuestLogin is the name of the sheet
		return data;
	}
	
	@BeforeMethod
	public void setUp() throws Exception {
		homePage = new GuestLogin_HomePage();
		
	}
		
	@Test
		public void longUrlTest() throws Exception {
			
			homePage.GuestLogin_HomePage_OtrimLogo();
			homePage.GuestLogin_HomePage_Title_Url();
			homePage.otrimFunctionality();
			
		}
	
	
	
//	@Test(dataProvider = "editURL")
//	public void createYourCustomUrl(String longurl,String customName) throws InterruptedException {
//		homePage.createYouCustomUrl(longurl,customName);
//	}
		
//		@AfterMethod
//		public void tearDown() {
//			driver.quit();
//		}

	}
