package com.otrim.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.otrim.qa.practice.GMail;
import com.otrim.qa.util.TestBase;



public class ForgotPassword extends TestBase {

	@FindBy(xpath="//a[contains(text(),'Guest Login')]")
	WebElement guestLoginBtn;
	
	@FindBy(xpath="//a[contains(text(),'Forgot Password')]")
	WebElement forgotPassword;
	
	@FindBy(xpath="//input[contains(@type,'email')]")
	WebElement email;
	
	@FindBy(xpath="//button[contains(text(),'Submit')]")
	WebElement submit;
	
	@FindBy(css="body.modal-open.swal2-shown.swal2-height-auto:nth-child(2) div.swal2-container.swal2-center.swal2-backdrop-show:nth-child(11) div.swal2-popup.swal2-modal.swal2-icon-success.swal2-show div.swal2-actions > button.swal2-confirm.swal2-styled")
	WebElement okBtn;
	
	@FindBy(xpath="//input[contains(@placeholder,'Verification OTP')]")
	WebElement verificationOTPFeild;
		
	@FindBy(xpath="//a[@class='password_eye']")
	WebElement verificationOTPFeild_OkBtn;
	
	
	public ForgotPassword() {
		PageFactory.initElements(driver, this);
		}
	
	public void forgotPassword() throws Exception{
		guestLoginBtn.click();
		Thread.sleep(2000);
		forgotPassword.click();
		Thread.sleep(2000);
		email.sendKeys("sikhakollisaikiran31@gmail.com");
		Thread.sleep(2000);
		submit.click();
		Thread.sleep(5000);
		//okBtn.click();
		//Thread.sleep(2000);
				
	}
	
	//Here we created class in class
	public class forgotEmail extends GMail {
		
		public void forgot() throws Exception {
			forgotEmail fe=new forgotEmail();
			String gmailDetails=fe.fetchGmail("OTP for Guest");//here we can give subject of the Email
			
			String[] arr1=gmailDetails.split(":");
			String OTP=arr1[1].replaceAll("[^0-9]", "").subSequence(0, 4).toString();
			System.out.println("OTP is:"+OTP);
			
			driver.findElement(By.xpath("//input[contains(@placeholder,'Verification OTP')]")).sendKeys(OTP);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[@class='password_eye']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
			Thread.sleep(2000);
			okBtn.click();
			
		}
		
	}
	
	
	public void closeBrowser() {
	driver.quit();
}

		 
	}
	

