package com.otrim.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.otrim.qa.pages.ForgotPassword;


public class ForgotPasswordTest extends ForgotPassword {

	forgotEmail forgotemail;
	ForgotPassword forgotPassword;
	public ForgotPasswordTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		intialization();
		forgotPassword = new ForgotPassword();
		
	}
	
	

	@Test
	public void signUpValidation() throws Exception {
		forgotPassword.forgotPassword();
		forgotemail= new forgotEmail();
		forgotemail.forgot();
		
	}
	
	@AfterMethod
	public void tearDown() {
		forgotPassword.closeBrowser();
	}
}
