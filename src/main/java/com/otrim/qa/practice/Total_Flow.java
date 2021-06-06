package com.otrim.qa.practice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Total_Flow {
	// Classes
	static WebDriver driver;
	static Actions actions;

	// WebElement paths
	static WebElement alert_Ok_Btn;
	static WebElement login_ShortenUrl;
	static WebElement login_Rename_ShortenUrl;

	// WebElement String Paths
	static String guest_Login_Btn = "//a[contains(text(),'Guest Login')]";
	static String guest_Login_UserName = "//input[contains(@placeholder,'User Name')]";
	static String guest_Login_Password = "//input[contains(@placeholder,'Your Password')]";
	static String eye_Btn = "//img[contains(@class,'ng-star-inserted')]";
	static String login_Button = "//button[contains(text(),'Login')]";
	static String alert_Button = "//button[contains(text(),'OK')]";

	// Trim Functions WebElements
	static String pasteYourLinkhere = "//input[@placeholder='Paste your link here']";
	static String login_OTrim_Btn = "//button[contains(text(),'OTrim')]";
	static String login_Auth_Yes_Btn = "//button[contains(text(),'Yes')]";
	static String login_Auth_No_Btn = "//button[contains(text(),'No')]";
	static String login_ShortenURl_Copy_Btn = "//button[@class='clip-copy']";
	static String login_ShortenUrl_Text = "//input[@placeholder='Shorten URL']";
	static String login_Rename_ShortenUrl_Text = "//input[@placeholder='Rename Shorten URL'][@class='ng-valid ng-touched ng-dirty']";
	static String login_Rename_ShortenUrl_Save_Btn = "//button[contains(text(),'Save')]";
	// Create Your Custom Url functions
	static String login_CreateYour_CustomUrl_Btn = "//div[contains(text(),'Create your custom URL')]";
	static String login_PasteYour_LinkHere_TextBox = "//input[@id='urlcustom'][@placeholder='Paste Your Link Here']";
	static String login_CreateYourLink_TextBox = "//input[@id='customapart']";
	static String login_Trim_Btn = "//input[@id='submit_url_custom']";
	static String login_Close_Btn = "//button[@type='button'][@class='close'][@aria-label='aria-label']";

	// Add Alias Button
	static String login_AddAlias_Btn = "//button[contains(text(),'Add Alias')]";
	static String login_Enter_AliasName = "//input[@placeholder='Enter Alias Name']";
	static String login_Enter_AliasName_SaveBtn = "//button[@class='button btn otrim_btn sav_btn']";
	static String login_Enter_AliasName_CancelBtn = "//button[@class='button btn otrim_btn cncl_btn']";

	// Copy Button
	static String login_Copy_Btn = "//button[@data-clipboard-action='copy'][@class='clip-copy']";
	// Track Button
	static String login_Track_Btn = "//button[contains(text(),'Track')]";
	// Edit Button
	static String login_Edit_Btn = "//a[@title='Edit'][@class='edit_del_main']";
	static String login_Edit_TextBox = "//textarea[@id='main_url10']";
	static String login_Save_Btn = "//button[contains(text(),'Save')]";
	// Delete Button
	static String login_Delete_Btn = "//img[@class='delete'][@data-toggle='modal']";
	static String login_Delete_Cancel_Btn = "//button[contains(text(),'Cancel')]";

	// View More in Track Section

	static String login_Track_ViewMore = "//body/app-root[1]/div[1]/app-login-home[1]/section[4]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[5]/div[1]/div[1]/div[1]/div[2]/a[1]";

	// Credentials
	static String userName = "saikiran";
	static String userPassword = "saikiran";
	static String URL = "https://www.google.com/search?q=Images&rlz=1C1CHZN_enIN934IN934&sxsrf=ALeKk02JOgaZPnmRrpqcl6cPBU3pOP9KDQ:1611223137738&tbm=isch&source=iu&ictx=1&fir=ez-ubljHwN9MSM%252CLlgDpz1LoiuznM%252C_&vet=1&usg=AI4_-kRvnEptmkntnYnWaQ_-ArHOM71HVw&sa=X&ved=2ahUKEwighJ324azuAhWGV30KHSM8ApMQ9QF6BAgmEAE#imgrc=ez-ubljHwN9MSM";
	static String copied_ShortenUrl_TextBox_Text;

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static void openBrowser() throws Exception {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://trimurldemo.onpassive.com/");
		Thread.sleep(3000);
	}

	public static void guestLogin() throws Exception {
		driver.findElement(By.xpath(guest_Login_Btn)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(guest_Login_UserName)).sendKeys(userName);
		driver.findElement(By.xpath(guest_Login_Password)).sendKeys(userPassword);
	}

	public static void eyeButton() throws Exception {
		WebElement eyeButton = driver.findElement(By.xpath(eye_Btn));
		actions = new Actions(driver);
		actions.clickAndHold(eyeButton).perform();
		Thread.sleep(2000);
		actions.release().perform();
	}

	public static void guestLoginBtn() throws Exception {
		driver.findElement(By.xpath(login_Button)).click();
		Thread.sleep(3000);
	}

	public static void trimFunctioanlity() throws InterruptedException, AWTException {
		driver.findElement(By.xpath(pasteYourLinkhere)).sendKeys(URL);
		driver.findElement(By.xpath(login_OTrim_Btn)).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath(login_Auth_No_Btn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(login_Copy_Btn)).click();
		Thread.sleep(4000);
		robotclass();
		// alertButton();
	}

	public static void robotclass() throws AWTException, InterruptedException {

		Robot robot = new Robot();

		// Copy the content
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_C);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_C);

		System.out.println("okok");

		// Open new Tab in the Chrome
		driver.switchTo().newWindow(WindowType.TAB);

		Thread.sleep(4000);

		// It selects the text ctrl+a
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_A);

		// To click on delete button
		robot.keyPress(KeyEvent.VK_DELETE);
		robot.keyRelease(KeyEvent.VK_DELETE);
		Thread.sleep(2000);

		// To paste the content ctrl+v
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);

		// Click on Enter Button
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(10000);

		switchToPreviousTab();

	}

	public static void alertButton() {
		alert_Ok_Btn = driver.findElement(By.xpath(alert_Button));
		alert_Ok_Btn.click();
	}

	public static void edit_Functionality() throws InterruptedException {
		driver.findElement(By.xpath(login_Edit_Btn)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(login_Edit_TextBox)).clear();
		driver.findElement(By.xpath(login_Edit_TextBox)).sendKeys(
				"https://www.google.com/search?q=images&rlz=1C1CHZN_enIN934IN934&oq=images&aqs=chrome.0.69i59j35i39j0i395i433j0i395l2j69i60j69i61j69i60.1022j1j7&sourceid=chrome&ie=UTF-8");
		Thread.sleep(3000);
		driver.findElement(By.xpath(login_Save_Btn)).click();
		Thread.sleep(3000);
	}

	public static void scrollInToView(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public static void createYouCustomUrl() throws InterruptedException {
		driver.findElement(By.xpath(login_CreateYour_CustomUrl_Btn)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(login_PasteYour_LinkHere_TextBox)).sendKeys(
				"https://www.google.com/search?q=images&rlz=1C1CHZN_enIN934IN934&oq=images&aqs=chrome.0.69i59j0i433j0i395i433j0i395l2j69i60j69i61j69i60.990j1j7&sourceid=chrome&ie=UTF-8");
		driver.findElement(By.xpath(login_CreateYourLink_TextBox)).sendKeys("Saikiran");
		driver.findElement(By.xpath(login_Trim_Btn)).click();
	}

	public static void addAliasName() throws InterruptedException {
		driver.findElement(By.xpath(login_AddAlias_Btn)).click();
		Thread.sleep(2000);
		WebElement aliasName = driver.findElement(By.xpath(login_Enter_AliasName));
		String name = aliasName.getText();
		if (name.equalsIgnoreCase("saikiran")) {

		} else {
			driver.findElement(By.xpath(login_Enter_AliasName)).clear();
			driver.findElement(By.xpath(login_Enter_AliasName)).sendKeys("Saikiran1");
			Thread.sleep(2000);
			driver.findElement(By.xpath(login_Enter_AliasName_SaveBtn)).click();
			Thread.sleep(3000);
		}

	}

	public static void delete_Functionality() throws InterruptedException {

		driver.findElement(By.xpath(login_Delete_Btn)).click();
		System.out.println("clicked");
		Thread.sleep(2000);
		driver.findElement(By.xpath(login_Delete_Cancel_Btn)).click();
		Thread.sleep(2000);
	}

	public static void scrollIntoView() throws InterruptedException {
		WebElement moveToElement = driver.findElement(By.xpath(login_CreateYour_CustomUrl_Btn));
		scrollInToView(moveToElement, driver);

		Thread.sleep(5000);
	}

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

	public static void switchToNextTab() {
		ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tab.get(1));
	}

	public static void closeAndSwitchToNextTab() {
		driver.close();
		ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tab.get(1));
	}

	public static void switchToPreviousTab() {
		ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tab.get(0));
	}

	public static void closeTabAndReturn() {
		driver.close();
		ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tab.get(0));
	}

	public static void switchToPreviousTabAndClose() {
		ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tab.get(1));
		driver.close();
	}

	public static void tearDown() {
		driver.close();
	}

	public static void main(String[] args) throws Exception {

		openBrowser();

		guestLogin();

		guestLoginBtn();

		scrollIntoView();

		track_Functionality();

	}

}
