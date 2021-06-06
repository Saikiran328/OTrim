package com.otrim.qa.testcases;
import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.otrim.qa.pages.LandingPage;

public class LandingPageTest extends LandingPage {

	static LandingPage landingPage;
	
	public LandingPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		intialization();
		landingPage = new LandingPage();
	}
	
	@Test
	public void OtrimLogo_Test() throws IOException, InterruptedException, AWTException {
		
		//It gives boolean value true/false : If Logo is displayed it gives "true" :If Logo is not displayed it gives "false"
		landingPage.otrimLogoIsDisplayed();
		Thread.sleep(3000);
		landingPage.screenShot();
		landingPage.checking_Headings();
		landingPage.otrimFunctionality();
		landingPage.scrollInToView_ReasonsToTrim();
		landingPage.reasonsToUseTrimUrl();
		landingPage.scrollInToView_worthyLinks();
		landingPage.worthyLinks_Headings();
		landingPage.footerLinks();
		
	}

}
