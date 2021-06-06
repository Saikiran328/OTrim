package com.otrim.qa.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.otrim.qa.pages.LoginPage;
import com.otrim.qa.util.TestBase;
import com.otrim.qa.util.TestUtil;
import com.sun.tools.sjavac.Log;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	static Logger log = LogManager.getLogger();
	public static String GuestLogin_TestData= "D:\\ExcelData\\GuestLogin_TestData.xlsx";
	public LoginPageTest() {
	super();
	}
	
	@DataProvider
	public Object[][] guestLoginData() {
		Object data[][] = TestUtil.readExcelData(GuestLogin_TestData,"UATUSERS");// GuestLogin is the name of the sheet
		return data;
	}
	
	@BeforeClass
	public void setUp() {
		//intialization();
		loginPage = new LoginPage();
	}
	
	
	@Test(dataProvider ="guestLoginData",priority=2)
	public void guestLogin_Validation(String Name,String Password) throws Exception {
		//landingPage_UI_Check();
		loginPage.login(Name,Password);
		Thread.sleep(5000);
	}
	
	//@Test(priority=1)
	public void landingPage_UI_Check() throws Exception {
		loginPage.guestLoginBtn();
		log.info("guestLoginBtn executed successfully");
		loginPage.check_GuestLogin_Header();
		log.info("check_GuestLogin_Header executed successfully");
		loginPage.eyeBtn_UI();
		log.info("eyeBtn_UI executed successfully");
		loginPage.check_ForgotPassword();
		log.info("check_ForgotPassword executed successfully");
		loginPage.check_loginBtn();
		log.info("check_loginBtn executed successfully");
		
	}
	
}
