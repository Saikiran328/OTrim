package com.otrim.qa.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.otrim.qa.util.TestBase;
import com.otrim.qa.util.TestUtil;

public class LoginPage extends TestBase {

	static TestUtil util = new TestUtil();
	static Logger log = LogManager.getLogger();

	// Page Factory -OR

	@FindBy(xpath = "//a[contains(text(),'Guest Login')]")
	public static WebElement guestLoginBtn;

	@FindBy(xpath = "//input[contains(@placeholder,'User Name')]")
	public static WebElement username;

	@FindBy(xpath = "//input[contains(@placeholder,'Your Password')]")
	public static WebElement password;

	@FindBy(xpath = "//button[contains(text(),'Login')]")
	public static WebElement loginBtn;

	@FindBy(xpath = "//header/div[1]/div[1]/div[1]/img[1]")
	public static WebElement oTrimLogo;

	@FindBy(xpath = "//h3[@id='exampleModalLabel']")
	public static WebElement guestLogin_Header;
	public static String actual_guestLogin_Header_Text;
	public static String expected_guestLogin_Header_Text = "Guest Login";

	@FindBy(xpath = "//a[contains(text(),'Forgot Password')]")
	public static WebElement forgotPassword;

	public static String actual_forgotPassword_Text;
	public static String expected_forgotPassword_Text = "Forgot Password";
	public static Boolean forgotPassword_displayed;

	public static String otrimLogo = "//header/div[1]/div[1]/div[1]/img[1]";
	public static String expected_HomePageUrl = "https://otrimuiuat.onpassive.com/users";
	public static String actual_HomePageUrl;

	public static String expected_GuestLogin_HomePage_Title = "TrimURL - Shorten, Share and Track URLs for Better Campaign Management";
	public static String actual_GuestLogin_HomePage_Title;

	public static String expected_LandingPageTitle = "Free Custom URL Shortener by ONPASSIVE | Trim URL";
	public static String actual_LandingPageTitle;

	public static String expected_LandingPage_Url ="https://otrimuiuat.onpassive.com/";
	public static String actual_LandingPage_Url;

	public static String guestLogin_EyeButton = "//app-common-header/div[@id='lgfModal']/div[1]/div[1]/div[2]/app-login-comp[1]/form[1]/div[1]/div[2]/a[1]/img[1]";

	public static Boolean landingPage_otrimLogo;
	public static Boolean check_loginBtn_display;
	public static Boolean check_loginBtn_enable;

	// Initializing page factory objects---by using constructor--constructor name
	// should be class name
	// "PageFactory.initElements" is the method to initialize the page factory
	// objects
	// "driver" from TestBase class
	// "this" means current class page factory objects

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

//--------------------------------------------------------------------------------------------------------
	
	
	
	
	
	
	// 1
	public void guestLoginBtn() throws InterruptedException {

		guestLoginBtn.click();
		System.out.println("Clicked On Guest Login Button");
		log.info("Clicked On Guest Login Button");
		Thread.sleep(2000);
	}

	// 2
	public void check_GuestLogin_Header() {

		actual_guestLogin_Header_Text = guestLogin_Header.getText();
		System.out.println("GuestLogin Page Header Is:" + actual_guestLogin_Header_Text);
		log.info("GuestLogin Page Header Is:" + actual_guestLogin_Header_Text);

		Assert.assertEquals(actual_guestLogin_Header_Text, expected_guestLogin_Header_Text,
				"Actual And Expected Not Same");
		System.out.println("Actual And Expected Header Of The GuestLogin Page Is Same:" + "--"
				+ actual_guestLogin_Header_Text + "--" + expected_guestLogin_Header_Text);
		log.info("Actual And Expected Header Of The GuestLogin Page Is Same:" + "--" + actual_guestLogin_Header_Text
				+ "--" + expected_guestLogin_Header_Text);

	}

	// 3
	public void eyeBtn_UI() throws Exception {
		util.eyeButton_UI(guestLogin_EyeButton);
	}

	public void eyeBtn_Functionality() throws Exception {
		util.eyeButton(guestLogin_EyeButton);
	}

	// 4
	public void check_ForgotPassword() {

		forgotPassword_displayed = forgotPassword.isDisplayed();
		System.out.println("ForgotPassword Is Displayed:" + forgotPassword_displayed);
		log.info("ForgotPassword Is Displayed:" + forgotPassword_displayed);

		actual_forgotPassword_Text = forgotPassword.getText();
		System.out.println("Forgot Password Text Is:" + actual_forgotPassword_Text);
		log.info("Forgot Password Text Is:" + actual_forgotPassword_Text);

		Assert.assertEquals(actual_forgotPassword_Text, expected_forgotPassword_Text, "Actual And Expected Not Same");
		System.out.println("Actual And Expected Text Of The Password Is Same:" + "--" + actual_forgotPassword_Text
				+ "--" + expected_forgotPassword_Text);
		log.info("Actual And Expected Header Of The GuestLogin Page Is Same:" + "--" + actual_forgotPassword_Text + "--"
				+ expected_forgotPassword_Text);
	}

	// 5
	public void check_loginBtn() {

		check_loginBtn_display = loginBtn.isDisplayed();
		System.out.println("Login Button Is Displayed:" + check_loginBtn_display);
		log.info("Login Button Is Displayed:" + check_loginBtn_display);

		check_loginBtn_enable = loginBtn.isEnabled();
		System.out.println("Login Button Is Enabled:" + check_loginBtn_enable);
		log.info("Login Button Is Enabled:" + check_loginBtn_enable);
	}
	

	//6
	public void login(String userName, String YourPassword) throws Exception {

		guestLoginBtn();
		
		username.sendKeys(userName);
		System.out.println("Entered Valid Uesr Name");
		log.info("Entered Valid Uesr Name");

		password.sendKeys(YourPassword);
		System.out.println("Entered Valid Password");
		log.info("Entered Valid password");

		util.eyeButton(guestLogin_EyeButton);
	
		loginBtn.click();
		System.out.println("Clicked On LoginButton");
		log.info("Clicked On LoginButton");
	
}
	
//	//7
//	public void homePage_OtrimLogo() throws InterruptedException {
//		
//		landingPage_otrimLogo= oTrimLogo.isDisplayed();
//		System.out.println("OTrim Logo Is Displayed:" + landingPage_otrimLogo);
//		log.info("OTrim Logo Is Displayed:" + landingPage_otrimLogo);
//		Thread.sleep(2000);
//		
//		util.heightAndWidth(otrimLogo);
//	}
//	
//	//8
//	public void GuestLogin_HomePage_Title_Url() {
//		
//		actual_HomePageUrl=driver.getCurrentUrl();
//			System.out.println("Current Page URL Is:"+actual_HomePageUrl);
//			log.info("Current Page Title Is:"+actual_HomePageUrl);
//			
//			Assert.assertEquals(actual_HomePageUrl, expected_HomePageUrl,"Actual And Expected URL's Are Not Same");
//			System.out.println("Actual And Expected URL's Are Same:"+"--"+actual_HomePageUrl+"--"+expected_HomePageUrl);
//			log.info("Actual And Expected URL's Are Same:"+"--"+actual_HomePageUrl+"--"+expected_HomePageUrl);
//			
//			actual_GuestLogin_HomePage_Title=driver.getTitle();
//			System.out.println("Current Page Title Is:"+actual_GuestLogin_HomePage_Title);
//			log.info("Current Page Title Is:"+actual_GuestLogin_HomePage_Title);
//			
//			Assert.assertEquals(actual_GuestLogin_HomePage_Title, expected_GuestLogin_HomePage_Title,"Actual And Expected Titles Are Not Same");
//			System.out.println("Actual And Expected Titles Are Same:"+"--"+actual_GuestLogin_HomePage_Title+"--"+expected_GuestLogin_HomePage_Title);
//			log.info("Actual And Expected Titles Are Same:"+"--"+actual_GuestLogin_HomePage_Title+"--"+expected_GuestLogin_HomePage_Title);
//		}
		
}
