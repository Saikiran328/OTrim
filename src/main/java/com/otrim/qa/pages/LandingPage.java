package com.otrim.qa.pages;

import java.awt.AWTException;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.otrim.qa.util.TestBase;
import com.otrim.qa.util.TestUtil;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class LandingPage extends TestBase {

	static // Object Created for TestUtil.java class
	TestUtil util = new TestUtil();
	static Logger log = LogManager.getLogger();
	// Static Elements
	public static String otrimLogo = "//header/div[1]/div[1]/div[1]/img[1]";

	public static String reasons = "//body/app-root[1]/div[1]/app-common-home[1]/app-otrim-features[1]/section[2]/div[1]/div[1]/ul[1]/li[";
	public static String reasons1 = "]";

	public static String worthyLinks_Images = "div.wrapper app-common-home.ng-star-inserted:nth-child(2) section.slider div.container div.fadeOut.owl-carousel.owl-theme.owl-loaded.owl-drag div.owl-stage-outer div.owl-stage div.owl-item.active:nth-child(";
	public static String worthyLinks_Images1 = ") div.item div.row div.col-lg-5 > img.img-fluid";

	public static String worthyLinks_Header_name = "div.wrapper app-common-home.ng-star-inserted:nth-child(2) section.slider div.container div.fadeOut.owl-carousel.owl-theme.owl-loaded.owl-drag div.owl-stage-outer div.owl-stage div.owl-item.active:nth-child(";
	public static String worthyLinks_Header_name1 = ") div.item > h1.page_heading";

	public static String worthyLinks_Text = "div.wrapper app-common-home.ng-star-inserted:nth-child(2) section.slider div.container div.fadeOut.owl-carousel.owl-theme.owl-loaded.owl-drag div.owl-stage-outer div.owl-stage div.owl-item.active:nth-child(";
	public static String worthyLinks_Text1 = ") div.item div.row div.col-lg-7.my-auto > p.sub_para";

	public static String footerLinks_FirstRow = "div.wrapper app-common-home.ng-star-inserted:nth-child(2) div.container div.row div.col-lg-6:nth-child(1) div.row div.col-lg-6.col-md-6:nth-child(1) ul:nth-child(1) li:nth-child(";
	public static String footerLinks_FirstRow1 = ") > a:nth-child(1)";

	public static String footerLinks_SecondRow = "div.wrapper app-common-home.ng-star-inserted:nth-child(2) div.container div.row div.col-lg-6:nth-child(1) div.row div.col-lg-6.col-md-6:nth-child(2) ul:nth-child(1) li:nth-child(";
	public static String footerLinks_SecondRow1 = ") > a:nth-child(1)";

	public static String footerLinks_ThirdRow = "div.wrapper app-common-home.ng-star-inserted:nth-child(2) div.container div.row div.col-lg-6:nth-child(2) div.pull-right ul.social_icons:nth-child(2) li:nth-child(";
	public static String footerLinks_ThirdRow1 = ") a:nth-child(1) > img:nth-child(1)";

	public static String stayConnectedWithUs_Links = "div.wrapper app-common-home.ng-star-inserted:nth-child(2) div.container div.row div.col-lg-6:nth-child(2) div.pull-right ul.social_icons:nth-child(2) li:nth-child(";
	public static String stayConnectedWithUs_Links1 = ") > a:nth-child(1)";

	public static String carousel = "//span[contains(text(),'›')]";
	public static String login_Copy_Btn = "//button[@data-clipboard-action='copy'][@class='clip-copy']";

	public static String pasteYourLinkHere = "//input[@placeholder='Paste your link here']";

	public static String analyticsviewoflinks_Text = "O Trim URL provides amazing analytics view of past links accessed from various channels, regions, browsers, mobiles etc. This gives a definite insights of the post capable of gathering broad audience.";
	public static String audienceAttention_Text = "It is important to shorten your URL links because it is easier for an audience to trust and click a shorter link(provided it is shared from a credible source) compared to a longer link.";
	public static String socialMedia_Text = "A shortened link is easier for your readers to click, copy, and share in their own post, which can help your content gain organic exposure on social networks.";
	public static String businessandIndividuallinksmakeover_Text = "O Trim URL is for both business and Individual who want to make an wonderful impact of their work in international rich market.";

	// Constants
	public static WebElement worthyLink_Images;
	public static WebElement oTrimLogo;
	public static Screenshot screenshot;
	public static WebElement worthyLink_Headers;
	public static String worthyLink_header_Text;
	public static WebElement worthyLink_Text;
	public static String text;
	public static File srcfile;
	public static Boolean isDisplayed;
	public static String socialLinks;
	public static String href_Value = "href";
	public static String excel_data;
	public static Boolean displayed;

	public static WebElement footer;
	public static WebElement footer1;
	public static WebElement footer2;

	public static String footer_Text;
	public static String footer_Text1;
	public static String footer_Text2;

	public static Actions action;
	// public static JavascriptExecutor js;

	public static BufferedImage actualImage;
	public static BufferedImage expectedImage;
	public static ImageDiffer imageDiffer;
	public static ImageDiff diff;

	public static String build_Your_Brand;
	public static String build_Your_Brand_Text = "Build Your Brand with Each Click";

	public static String guest_Login_Btn;
	public static String guest_Login_Btn_Text = "GUEST LOGIN";

	public static String guest_SignUp_Btn;
	public static String guest_SignUP_Btn_Text = "GUEST SIGNUP";

	public static String otrim_Btn;
	public static String otrim_Btn_Text = "OTrim";

	public static String expected_LandingPageTitle = "Free Custom URL Shortener by ONPASSIVE | Trim URL";
	public static String actual_LandingPageTitle;

	public static String expected_LandingPage_Url = "https://otrimuiuat.onpassive.com/";
	public static String actual_LandingPage_Url;

	public static String trim_Url_Worthy_Link;
	public static String trim_Url_Worthy_Link_Text = "TRIM URL for click worthy links";

	public static String analytics = "Analytics view of links";
	public static String audience = "Audience Attention";
	public static String social = "Social Media";
	public static String business = "Business and Individual links makeover";

	// Paths
	public static String expectedImage_Path = "C:\\Users\\User\\Downloads\\Workplace\\OtrimMaven\\Images\\OTrimLogo1.png";
	public static String newFile_ImagePath = "C:\\Users\\User\\Downloads\\Workplace\\OtrimMaven\\Images\\";
	public static String deleteFilePath = "C:\\Users\\User\\Downloads\\Workplace\\OtrimMaven\\Images\\OTrimLogo1.png";
	public static String fileInput_path = "D:\\LongUrls.xlsx";

	// Landing Page Web elements using page factory model

	// O-Trim Image
	@FindBy(xpath = "//header/div[1]/div[1]/div[1]/img[1]")
	public static WebElement landinPage_OTrimLogo;

	// Build Your Brand with Each Click
	@FindBy(xpath = "//h1[contains(text(),'Build Your Brand with Each Click')]")
	public static WebElement buildYourBand;

	// Guest Login
	@FindBy(xpath = "//a[contains(text(),'Guest Login')]")
	public static WebElement guestLoginBtn;

	// Guest Login
	@FindBy(xpath = "//a[contains(text(),'Guest Signup')]")
	public static WebElement guestSignUpBtn;

	@FindBy(xpath = "//button[contains(text(),'OTrim')]")
	public static WebElement oTrim_Btn;

	@FindBy(xpath = "//h3[contains(text(),'TRIM URL for click worthy links')]")
	public static WebElement TRIM_URL_for_click_worthy_links;
	
	
	@FindBy(xpath = "//h3[contains(text(),'10 Reasons to use trim URL')]")
	public static WebElement ReasonsTouse;
	
	//h3[contains(text(),'10 Reasons to use trim URL')]

	public LandingPage() {
		PageFactory.initElements(driver, this);
	}

//-----------------------------------------------------------------------------------------------------------------

	public void otrimLogoIsDisplayed() throws InterruptedException {
		displayed = landinPage_OTrimLogo.isDisplayed();
		System.out.println("OTrim Logo Is Displayed:" + displayed);
		log.info("OTrim Logo Is Displayed:" + displayed);
		Thread.sleep(2000);
		util.heightAndWidth(otrimLogo);
	}

	public void landingpageTitleAndUrl() {

		actual_LandingPageTitle = driver.getTitle();
		System.out.println("Title Of The Landing Page Is:" + actual_LandingPageTitle);
		log.info("Title Of The Landing Page Is:" + actual_LandingPageTitle);

		Assert.assertEquals(actual_LandingPageTitle, expected_LandingPageTitle, "Actual And Expected Not Same");
		System.out.println("Actual And Expected Title Of The Landing Page Is Same :" + "--" + actual_LandingPageTitle
				+ "--" + expected_LandingPageTitle);
		log.info("Actual And Expected Title Of The Landing Page Is Same :" + "--" + actual_LandingPageTitle + "--"
				+ expected_LandingPageTitle);

		actual_LandingPage_Url = driver.getCurrentUrl();
		System.out.println("URL Of The Landing Page Is:" + actual_LandingPage_Url);
		log.info("URL Of The Landing Page Is:" + actual_LandingPage_Url);

		Assert.assertEquals(actual_LandingPage_Url, expected_LandingPage_Url, "Actual And Expected Not Same");
		System.out.println("Actual And Expected URL Of The Landing Page Is Same :" + "--" + actual_LandingPage_Url
				+ "--" + expected_LandingPage_Url);
		log.info("Actual And Expected URL Of The Landing Page Is Same :" + "--" + actual_LandingPage_Url + "--"
				+ expected_LandingPage_Url);

	}

	public void checking_Headings() {
		// Guest Login
		guest_Login_Btn = guestLoginBtn.getText();
		System.out.println(guest_Login_Btn);
		Assert.assertEquals(guest_Login_Btn, guest_Login_Btn_Text, "Not Equal");
		System.out.println("Equal");
		guestLoginBtn.isEnabled();
		System.out.println("Guest Login Button Is Displayed");

		// Guest Signup
		guest_SignUp_Btn = guestSignUpBtn.getText();
		Assert.assertEquals(guest_SignUp_Btn, guest_SignUP_Btn_Text);
		System.out.println("Equal");
		guestLoginBtn.isDisplayed();
		System.out.println("Guest SignUp Button Is Displayed");

		// OTrim Button
		otrim_Btn = oTrim_Btn.getText();
		Assert.assertEquals(otrim_Btn, otrim_Btn_Text);
		System.out.println("Equal");
		guestLoginBtn.isDisplayed();
		System.out.println("OTrim Button Is Displayed");

		// Build your brand with each click
		build_Your_Brand = buildYourBand.getText();
		Assert.assertEquals(build_Your_Brand, build_Your_Brand_Text, "Not Equal");
		System.out.println("Equal");
		buildYourBand.isDisplayed();
		System.out.println("Build Your Brand with Each Click Is Displayed");

		// Trim Url for Click Worthy Link
		trim_Url_Worthy_Link = TRIM_URL_for_click_worthy_links.getText();
		Assert.assertEquals(trim_Url_Worthy_Link, trim_Url_Worthy_Link_Text, "Not Equal");
		System.out.println("Equal");
		TRIM_URL_for_click_worthy_links.isDisplayed();
		System.out.println("TRIM URL for click worthy links Is Displayed");
	}


	public void otrimFunctionality() throws IOException, InterruptedException, AWTException {
		Map<String, Object> excelData = util.readExcel(fileInput_path,"Sheet1");
		XSSFSheet s = (XSSFSheet) excelData.get("sheet");
		for (int i = 0; i <= (int) excelData.get("rowCount"); i++) {
			String data = s.getRow(i).getCell(0).getStringCellValue();
			System.out.println(data);
			Thread.sleep(3000);
			
			driver.findElement(By.xpath(pasteYourLinkHere)).sendKeys(data);
			oTrim_Btn.click();
			// driver.findElement(By.xpath("//button[contains(text(),'OTrim')]")).click();
			util.alert_OK();
			Thread.sleep(5000);
			driver.findElement(By.xpath(login_Copy_Btn)).click();
			util.openNewTab();
			driver.navigate().refresh();
		}
	}

	public void reasonsToUseTrimUrl() throws InterruptedException, IOException {
		for (int i = 1; i <= 10; i++) {
			action = new Actions(driver);
			action.moveToElement(driver.findElement(By.xpath(reasons + i + reasons1)));
			action.build().perform();
		}
	}

	public void scrollInToView_worthyLinks() {
		util.scrollInToView(TRIM_URL_for_click_worthy_links, driver);
	}
	
	public void scrollInToView_ReasonsToTrim() {
		util.scrollInToView(ReasonsTouse, driver);
	}
	
	

	@SuppressWarnings("static-access")
	public void worthyLinks_Headings() throws InterruptedException, IOException {

		for (int i = 1; i <= 4; i++) {
			// It says particular element is displayed on the page or not
			worthyLink_Images = driver.findElement(By.cssSelector(worthyLinks_Images + i + worthyLinks_Images1));
			Thread.sleep(1000);
			isDisplayed = worthyLink_Images.isDisplayed();
			System.out.println("Worthy link is displayed:" + isDisplayed);
			Thread.sleep(3000);
			// Draw a border to the WebElement
			util.drawBorder(worthyLink_Images, driver);

			// Worthy Links Headers
			worthyLink_Headers = driver
					.findElement(By.cssSelector(worthyLinks_Header_name + i + worthyLinks_Header_name1));
			worthyLink_header_Text = worthyLink_Headers.getText();

			// Worthy Links Text
			worthyLink_Text = driver.findElement(By.cssSelector(worthyLinks_Text + i + worthyLinks_Text1));
			text = worthyLink_Text.getText();

			// It took Screenshot of Each page
			srcfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			System.out.println("Screenshot Taken");
			FileUtils.copyFile(srcfile, new File(newFile_ImagePath + worthyLink_header_Text + ".png"));
			System.out.println("Taken Screenshot saved in to Specified location");

			// It is to check the Headers Text of the Worthy links
			if (worthyLink_header_Text.equals(analytics) & text.equals(analyticsviewoflinks_Text)) {
				System.out.println("Analytics view of links Analytics view of links Text");

			} else if (worthyLink_header_Text.equals(audience) & text.equals(audienceAttention_Text)) {
				System.out.println("Verified Audience Attention Header and AudienceAttention_Text");

			} else if (worthyLink_header_Text.equals(social) & text.equals(socialMedia_Text)) {
				System.out.println("Social Media Social Media Text");

			} else if (worthyLink_header_Text.equals(business) & text.equals(businessandIndividuallinksmakeover_Text)) {
				System.out.println("Business and Individual links makeover Business and Individual links makeover");
			}

			// It clicks the arrow in the worthy links section
			Thread.sleep(4000);
			driver.findElement(By.xpath(carousel)).click();
			System.out.println("Clicked");
			System.out.println("------------------------------------------------------");
		}
	}

//Footer links for AboutUs,Product,contact us

	public void footerLinks() throws InterruptedException {
//	//Footer links for AboutUs,Product,contact us
		for (int i = 1; i <= 3; i++) {
			footer = driver.findElement(By.cssSelector(footerLinks_FirstRow + i + footerLinks_FirstRow1));
			footer.click();
			Thread.sleep(5000);
			footer_Text = footer.getText();
			System.out.println("Clicked on:" + footer_Text);
			util.switchToPreviousTab();
		}
//Footer links for Term Of Use,Privacy Policy,Refund policy
		for (int j = 1; j <= 3; j++) {
			util.switchToPreviousTab();
			footer1 = driver.findElement(By.cssSelector(footerLinks_SecondRow + j + footerLinks_SecondRow1));
			footer1.click();
			Thread.sleep(5000);
			footer_Text1 = footer1.getText();
			System.out.println("Clicked on:" + footer_Text1);
			util.switchToPreviousTab();
		}
		// Footer links for Facebook, Instagram,Twitter,Youtube,LinkedIn
		for (int z = 1; z <= 5; z++) {
			footer2 = driver.findElement(By.cssSelector(footerLinks_ThirdRow + z + footerLinks_ThirdRow1));
			footer2.click();
			Thread.sleep(2000);
			socialLinks = driver.findElement(By.cssSelector(stayConnectedWithUs_Links + z + stayConnectedWithUs_Links1))
					.getAttribute(href_Value);
			System.out.println("Clicked on:" + socialLinks);
			util.switchToPreviousTab();
		}
	}

//It takes the screenshot
	@SuppressWarnings("static-access")
	public void screenShot() throws IOException {
		util.drawBorder(landinPage_OTrimLogo, driver);
		System.out.println("Image captured with Red border");
		WebElement OTrimLogo = driver.findElement(By.xpath(otrimLogo));
		// WebElement OTrimLogo = driver.findElement(By.xpath(screenshot));
		File logoFile = OTrimLogo.getScreenshotAs(OutputType.FILE);
		System.out.println("Screenshot Taken");
		File DestFolder = new File(newFile_ImagePath + "OTRIMLOGO.png");
		System.out.println("Captured file saved in the specified path");
		FileUtils.copyFile(logoFile, DestFolder);
		util.heightAndWidth(otrimLogo);

	}

//It takes screenshot and also compare the two images whether it is same or not: By using Ashot api
	@SuppressWarnings("static-access")
	public void compareOTrimImages() throws IOException, InterruptedException {

		// Expected image already taken and saved in the Images Folder By using
		// screenShot() function
		expectedImage = ImageIO.read(new File(expectedImage_Path));
		util.drawBorder(landinPage_OTrimLogo, driver);
		oTrimLogo = driver.findElement(By.cssSelector(otrimLogo));// 1 String
		Thread.sleep(3000);
		// It will take the screenshot of the O-Trim Image
		screenshot = new AShot().takeScreenshot(driver, oTrimLogo);
		Thread.sleep(3000);
		System.out.println("Image captured");
		util.heightAndWidth(otrimLogo);
		ImageIO.write(screenshot.getImage(), "png", new File(newFile_ImagePath));
		System.out.println("Image downloaded in the specified path");
		// Get the screenshot image
		actualImage = screenshot.getImage();
		System.out.println("Image was get");
		Thread.sleep(3000);
		// Below code will compare the two images
		imageDiffer = new ImageDiffer();
		diff = imageDiffer.makeDiff(expectedImage, actualImage);
		Assert.assertTrue(diff.hasDiff(), "Images are different");
		System.out.println("Images are same");
	}

}