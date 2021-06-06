package com.otrim.qa.pages;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.otrim.qa.util.TestBase;
import com.otrim.qa.util.TestUtil;

public class GuestLogin_HomePage extends TestBase {

	static TestUtil util = new TestUtil();
	static Logger log = LogManager.getLogger();
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	//Logo of OTrim
	@FindBy(xpath = "//header/div[1]/div[1]/div[1]/img[1]")
	public static WebElement oTrimLogo;
	
	//Long url Field or paste your link here field
	@FindBy(xpath = "//input[@placeholder='Paste your link here']")
	public static WebElement pasteYourLinkHere;
	
	//otrim button
	@FindBy(xpath = "//button[@class='btn']")
	public static WebElement trimBtn;

	//Popup authentication yes button
	@FindBy(xpath = "//button[contains(text(),'Yes')]")
	public static WebElement login_Auth_Yes_Btn;

	//Popup authentication no button
	@FindBy(xpath = "//button[contains(text(),'No')]")
	public static WebElement login_Auth_No_Btn;
	
	//copy button after click on trim button
	@FindBy(xpath = "//button[contains(text(),'Copy')]")
	public static WebElement shortenedUrl_copyBtn;

	//Rename Shortened Url 
	@FindBy(xpath="//input[@placeholder='Rename Shorten URL']")
	public static WebElement renameShortUrl;
	
	//Rename Shorten Url Save Button
	@FindBy(xpath="//input[contains(text(),'Save')]")
	public static WebElement renameShortUrl_saveBtn;
	
	// Create Your Custom URL
	@FindBy(xpath = "//div[contains(text(),'Create your custom URL')]")
	public static WebElement createYour_CustomUrl_Btn;
	
	//Create your custom Url----Long Url Field
	@FindBy(xpath = "//input[@id='urlcustom'][@placeholder='Paste Your Link Here']")
	public static WebElement createCustomUrl_LongUrl;
	
	//Create your custom Url----Create your own link field
	@FindBy(xpath = "//input[@id='customapart']")
	public static WebElement createCustomUrl_createYourLink;
	
	//Create your custom Url----Otrim button
	@FindBy(xpath = "//input[@id='submit_url_custom']")
	public static WebElement customUrl_Trim_Btn;
	
	//Add Alias Button
	@FindBy(xpath = "//button[contains(text(),'Add Alias')]")
	public static WebElement addAlias_Btn;
	
	//Alias name text field
	@FindBy(xpath = "//input[@placeholder='Enter Alias Name']")
	public static WebElement enter_AliasName;
	
	//Alias Save Button
	@FindBy(xpath = "//button[@class='button btn otrim_btn sav_btn']")
	public static WebElement aliasName_SaveBtn;
	
	//Alias Cancel button
	@FindBy(xpath = "//button[@class='button btn otrim_btn cncl_btn']")
	public static WebElement aliasName_CancelBtn;

	//copy button beside share button
	@FindBy(xpath = "//button[@title='Copy Short Url']")
	public static WebElement shortUrlcopyButton;
	
	///////////////////////////////////////////////////////////////////////////////////////
	//Share Button
	@FindBy(xpath="//button[@title='Share Short Url']")
	public static WebElement shareBtn;
	
	@FindBy(xpath="//a[@title='Share link to Facebook']")
	public static WebElement facebookBtn;
	
	@FindBy(xpath="//a[@title='Share link to Whatsapp']")
	public static WebElement whatsappBtn;
	
	@FindBy(xpath="//a[@title='Share link to Twitter']")
	public static WebElement twitterBtn;
	
	@FindBy(xpath="//a[@title='Share link to Pinterest")
	public static WebElement pintrestBtn;
	
	@FindBy(xpath="//a[@title='Share link to Linked In']")
	public static WebElement linkedInBtn;
	
	@FindBy(xpath="//span[contains(text(),'×')]")
	public static WebElement closeBtn;
/////////////////////////////////////////////////////////////////////////////////////////////
		
	// Track Button
	@FindBy(xpath = "//button[contains(text(),'Track')]")
	public static WebElement track_Btn;
/////////////////////////////////////////////////////////////////////////////////////////////
	// Edit Button
	@FindBy(xpath = "//button[@title='Edit']")
	public static WebElement edit_Btn;
	
	@FindBy(xpath="//input[@name='urledited']")
	public static WebElement edit_LongUrl;
	
	@FindBy(xpath="//input[@name='editedNewtrimUrl']")
	public static WebElement edit_ShortUrl;

	//Save button in Edit Section
	@FindBy(xpath = "//button[contains(text(),'Save')]")
	public static WebElement save_Btn;
	//////////////////////////////////////////////////////////////////////////////////////////	
	//Delete Button
	@FindBy(xpath="//button[@title='delete']")
	public static WebElement delete_Btn;

	//After Click on Delete button it will as for ok or cancel
	@FindBy(xpath="//button[contains(text(),'Cancel')]")
	public static WebElement cancelBtn;
	
	//After Click on Delete button it will as for ok or cancel
	@FindBy(xpath="//button[@class='swal2-confirm swal2-styled']")
	public static WebElement okBtn;
		
	
	@FindBy(xpath = "//p[contains(text(),'Branding links can drive more significant click-th')]")
	public static WebElement moveToElement;

	@FindBy(css = "div.wrapper app-login-home.ng-star-inserted:nth-child(2) header.cmn_header div.container div.row div.col-md-6:nth-child(2) div.w-100.ng-star-inserted div.user_info.pull-right > a:nth-child(2)")
	public static WebElement logoutBtn;
		
	static String login_Track_Btn = "//button[contains(text(),'Track')]";
	// View More in Track Section
	@FindBy(xpath = "//body/app-root[1]/div[1]/app-login-home[1]/section[4]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[5]/div[1]/div[1]/div[1]/div[2]/a[1]")
	public static WebElement track_ViewMore_Btn;
	
	public static String otrimLogo = "//header/div[1]/div[1]/div[1]/img[1]";
	public static String expected_HomePageUrl = "https://otrimuiuat.onpassive.com/users";
	public static String actual_HomePageUrl;

	public static String expected_GuestLogin_HomePage_Title = "TrimURL - Shorten, Share and Track URLs for Better Campaign Management";
	public static String actual_GuestLogin_HomePage_Title;

	public static Boolean landingPage_otrimLogo;
	public static String shortUrl;

	public static String fileInput_path = "D:\\LoginUrls.xlsx";

	public GuestLogin_HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	
	

//1	
	public void GuestLogin_HomePage_OtrimLogo() throws InterruptedException {

		landingPage_otrimLogo = oTrimLogo.isDisplayed();
		System.out.println("OTrim Logo Is Displayed:" + landingPage_otrimLogo);
		log.info("OTrim Logo Is Displayed:" + landingPage_otrimLogo);
		Thread.sleep(2000);
		util.heightAndWidth(otrimLogo);
	}

//2
	public void GuestLogin_HomePage_Title_Url() {

		actual_HomePageUrl = driver.getCurrentUrl();
		System.out.println("Current Page URL Is:" + actual_HomePageUrl);
		log.info("Current Page Title Is:" + actual_HomePageUrl);

		Assert.assertEquals(actual_HomePageUrl, expected_HomePageUrl, "Actual And Expected URL's Are Not Same");
		System.out.println(
				"Actual And Expected URL's Are Same:" + "--" + actual_HomePageUrl + "--" + expected_HomePageUrl);
		log.info("Actual And Expected URL's Are Same:" + "--" + actual_HomePageUrl + "--" + expected_HomePageUrl);

		actual_GuestLogin_HomePage_Title = driver.getTitle();
		System.out.println("Current Page Title Is:" + actual_GuestLogin_HomePage_Title);
		log.info("Current Page Title Is:" + actual_GuestLogin_HomePage_Title);

		Assert.assertEquals(actual_GuestLogin_HomePage_Title, expected_GuestLogin_HomePage_Title,
				"Actual And Expected Titles Are Not Same");
		System.out.println("Actual And Expected Titles Are Same:" + "--" + actual_GuestLogin_HomePage_Title + "--"
				+ expected_GuestLogin_HomePage_Title);
		log.info("Actual And Expected Titles Are Same:" + "--" + actual_GuestLogin_HomePage_Title + "--"
				+ expected_GuestLogin_HomePage_Title);
	}

//3
	public void otrimFunctionality() throws IOException, InterruptedException, AWTException {
		Map<String, Object> excelData = util.readExcel(fileInput_path, "LoginTrimUrls");
		XSSFSheet s = (XSSFSheet) excelData.get("sheet");
		for (int i = 0; i <= (int) excelData.get("rowCount"); i++) {
			String data = s.getRow(i).getCell(0).getStringCellValue();
			// System.out.println(data);
			pasteYourLinkHere.sendKeys(data);
			trimBtn.click();
			Thread.sleep(1000);
			login_Auth_No_Btn.click();
			Thread.sleep(1000);
			alert_Ok();
			shortenedUrl_copyBtn.click();
			util.openNewTab();
			driver.navigate().refresh();
		}
	}

	//4
	public void scrollIntoView_CreateCustomUrl() {
		scrollInToView(createYour_CustomUrl_Btn, driver);
	}
	
	//5
	public void createYouCustomUrl(String longUrl,String customName) throws InterruptedException {
		createYour_CustomUrl_Btn.click();
		Thread.sleep(1000);
		createCustomUrl_LongUrl.sendKeys(longUrl);
		createCustomUrl_createYourLink.sendKeys(customName);
		customUrl_Trim_Btn.click();
		alert_Ok();
	}
	
	//6
	public void addAliasName() throws InterruptedException {
		
		addAlias_Btn.click();
		enter_AliasName.sendKeys("saikiran");
		
		aliasName_SaveBtn.click();
		Thread.sleep(1000);
		alert_Ok();
		addAlias_Btn.click();
		enter_AliasName.sendKeys("sikhakolli");
		aliasName_CancelBtn.click(); 
		
	}
	
	//7
	public static void track_Functionality() throws InterruptedException {
		driver.findElement(By.xpath(login_Track_Btn)).click();
		Thread.sleep(3000);
		for (int i = 1; i <= 6; i++) {
//			WebElement s = driver.findElement(By.xpath(
//					"//body[1]/app-root[1]/div[1]/app-login-home[1]/section[4]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[5]/div[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[2]/td["+ i + "]"));
//			String string = s.getText();
//			System.out.println(string);
		}
		// This will gave the Column count
		int columCount = driver.findElements(By.xpath(
				"//body[1]/app-root[1]/div[1]/app-login-home[1]/section[4]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[5]/div[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/*"))
				.size();
		System.out.println(columCount);

		System.out.println("/////////////////////////////////");
		List<String> names = new ArrayList<String>();
		List<WebElement> columnNames = driver.findElements(By.xpath(
				"//body[1]/app-root[1]/div[1]/app-login-home[1]/section[4]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[5]/div[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr/*"));
		for (WebElement namesElement : columnNames) {
			names.add(namesElement.getText());
		}
		for (String name : names) {
			System.out.println(name);
		}
		System.out.println("Count" + columnNames.size());
	}

	public void editFinctionality_LongUrl() throws InterruptedException, AWTException {
		edit_Btn.click();
		Thread.sleep(1000);
		edit_LongUrl.clear();
		edit_LongUrl.sendKeys("");
		save_Btn.click();
		Thread.sleep(1000);
		alert_Ok();
		Thread.sleep(1000);
		shortenedUrl_copyBtn.click();
		util.openNewTab();
	}
	
	public void editFinctionality_ShortUrl() throws InterruptedException, AWTException {
		edit_Btn.click();
		Thread.sleep(1000);
		edit_ShortUrl.clear();
		edit_ShortUrl.sendKeys("");
		save_Btn.click();
		Thread.sleep(1000);
		alert_Ok();
		Thread.sleep(1000);
		shortenedUrl_copyBtn.click();
		util.openNewTab();
	}
	


	public void share() {
		shareBtn.click();
		util.switchToPreviousTab();
		facebookBtn.click();
		util.switchToPreviousTab();
		whatsappBtn.click();
		util.switchToPreviousTab();
		twitterBtn.click();
		util.switchToPreviousTab();
		pintrestBtn.click();
		util.switchToPreviousTab();
		linkedInBtn.click();
		util.switchToPreviousTab();
	}
	
	public void delete() {
		delete_Btn.click();
		cancelBtn.click();
		okBtn.click();
	}

	public void alert_Ok() {
		util.alert_OK();
	}
	
	public void logout() {
		logoutBtn.click();
	}



	public void scrollInToView(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

}
