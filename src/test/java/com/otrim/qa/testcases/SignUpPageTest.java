package com.otrim.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.otrim.qa.pages.SignUpPage;
import com.otrim.qa.util.TestUtil;

public class SignUpPageTest extends SignUpPage {
	SignUpPage signUpPage;
	//public static String Guest_SignUp_TestData= "D:\\TestData.xlsx";
	public static String Guest_SignUp_TestData= "D:\\ExcelData\\Guest_SignUP_TestData.xlsx";
	public SignUpPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		intialization();
		signUpPage = new SignUpPage();

	}

	@DataProvider
	public Object[][] getSignUpData() {
		Object data[][] = TestUtil.readExcelData(Guest_SignUp_TestData,"Sheet1");// SignUp is the name of the sheet
		return data;
	}

	@Test(dataProvider = "getSignUpData", priority = 2)
	public void signUpValidation(String Name, String Email, String Password) throws Exception {
	signUpPage.signUp(Name, Email, Password);
	}

	@Test(priority =1)
	public void UI() throws InterruptedException {
		signUpPage.checking_GuestSignUP_UI();
	}

	@AfterMethod
	public void tearDown() {
		signUpPage.closeBrowser();
	}
}
