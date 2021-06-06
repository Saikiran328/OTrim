package com.otrim.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.otrim.qa.util.TestBase;
import com.otrim.qa.util.TestUtil;

public class SignUpPage extends TestBase {
	
	
	TestUtil util = new TestUtil();
	
	static WebElement element;
	public static Actions actions;
	public static String guestSignUp_Text;
	public static String mandatoryFeilds_Text;
	public static String star_Symbol;
	public static Boolean isDisplayed;
	public static String passwordHint_Text;
	public static String createAccount_Text;
	
		@FindBy(xpath="//a[contains(text(),'Guest Signup')]")
	public static WebElement guestSignUpBtn;
	
	@FindBy(xpath="//input[contains(@placeholder,'Your Name')]")
	public static WebElement yourname;
	
	@FindBy(xpath="//input[contains(@placeholder,'Your Business Email')]")
	public static WebElement businessemail;
	
	@FindBy(xpath="//input[contains(@placeholder,'Your Password')]")
	public static WebElement yourPassword;
				
	@FindBy(xpath="//button[contains(text(),'Create Account')]")
	public static WebElement createAccount;
		
	@FindBy(xpath = "//button[contains(@class,'close')]")
	public static WebElement closeBtn;
	
	@FindBy(xpath="//h3[@id='exampleModalLabel']")
	static WebElement guestSignUp_UI;
	
	@FindBy(xpath="//span[contains(text(),'*')]")
	static WebElement starSymbol;
	
	@FindBy(xpath="//app-common-header/div[@id='lgfModal']/div[1]/div[1]/div[2]/app-register-comp[1]/form[1]/div[3]/a[1]/img[1]")
	static WebElement eye_IsVisible;
	
	@FindBy(xpath="//span[contains(text(),'Password Hint')]")
	static WebElement password_Hint;
	
		
	@FindBy(xpath="//app-common-header/div[@id='lgfModal']/div[1]/div[1]/div[2]/app-register-comp[1]/form[1]/p[1]")
	static WebElement mandatoryFields;
	
	public static String SignUp_eyeButton="//img[contains(@class,'ng-star-inserted')]";
	public static String passwordHint="//span[contains(text(),'Password Hint')]";
	

	
	public SignUpPage() {
	PageFactory.initElements(driver, this);
	}
	
//	@DataProvider
//	public Object[][] getSignUpData() {
//		Object data[][]=TestUtil.guestSignUpData("SignUp");//SignUp is the name of the sheet
//		return data;
//	}
//	@Test(dataProvider="getSignUpData",priority=3)
//	public void signUp(String yourName, String businessEmail, String your_Password) throws Exception {
//		if (!yourName.equals("") && !businessEmail.equals("") && !your_Password.equals("")) {
//			// Name
//			yourname.sendKeys(yourName);
//			System.out.println("UserName Entered With:"+yourName);
//			// Business Email
//			businessemail.sendKeys(businessEmail);
//			System.out.println("BusinessEmail Entered With:"+businessEmail);
//			// Password
//			yourPassword.sendKeys(your_Password);
//			System.out.println("YourPassword Entered With:"+your_Password);
//			Thread.sleep(3000);
//			// EyeButton
//			util.eyeButton(SignUp_eyeButton);
//			Thread.sleep(2000);
//			// Passwor Hint MouseOver
//			util.mouseHover(passwordHint);
//			// Create Account button
//			createAccount.click();
//			// Alert OK Button
//			util.alert_OK();
//		}
//	}
	
	public void signUp(String yourName, String businessEmail, String your_Password) throws Exception {
		if (!yourName.equals("") && !businessEmail.equals("") && !your_Password.equals("")) {
			guestSignUpBtn.click();
			// Name
			yourname.sendKeys(yourName);
			System.out.println("UserName Entered With:"+yourName);
			// Business Email
			businessemail.sendKeys(businessEmail);
			System.out.println("BusinessEmail Entered With:"+businessEmail);
			// Password
			yourPassword.sendKeys(your_Password);
			System.out.println("YourPassword Entered With:"+your_Password);
			Thread.sleep(3000);
			// EyeButton
			util.eyeButton(SignUp_eyeButton);
			Thread.sleep(2000);
			// Passwor Hint MouseOver
			util.mouseHover(passwordHint);
			// Create Account button
			createAccount.click();
			// Alert OK Button
			util.alert_OK();
		}
	}
	
	public void checking_GuestSignUP_UI() throws InterruptedException {
		guestSignUpBtn.click();
		Thread.sleep(2000);
		guestSignUp_Text=guestSignUp_UI.getText();
		System.out.println("Guest Signup UI verified"+guestSignUp_Text);
		
		mandatoryFeilds_Text=mandatoryFields.getText();
		star_Symbol=starSymbol.getText();
		System.out.println(mandatoryFeilds_Text+star_Symbol);
		
		isDisplayed=eye_IsVisible.isDisplayed();
		System.out.println(isDisplayed);
		
		passwordHint_Text=password_Hint.getText();
		System.out.println(passwordHint_Text);
		
		createAccount_Text=createAccount.getText();
		isDisplayed=createAccount.isDisplayed();
		System.out.println(createAccount_Text +" button is displayed--and button is enabled:"+isDisplayed);
		
		
	}

	public void closeBrowser() {
		driver.quit();
	}
	
}
