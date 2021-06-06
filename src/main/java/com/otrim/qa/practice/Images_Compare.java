package com.otrim.qa.practice;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class Images_Compare {

	
	static WebDriver driver;
	static String WorthyLinks_Header_name="div.wrapper app-common-home.ng-star-inserted:nth-child(2) section.slider div.container div.fadeOut.owl-carousel.owl-theme.owl-loaded.owl-drag div.owl-stage-outer div.owl-stage div.owl-item.active:nth-child(";
	static String WorthyLinks_Text="div.wrapper app-common-home.ng-star-inserted:nth-child(2) section.slider div.container div.fadeOut.owl-carousel.owl-theme.owl-loaded.owl-drag div.owl-stage-outer div.owl-stage div.owl-item.active:nth-child(";
	static String WorthyLinks_Text1=") div.item div.row div.col-lg-7.my-auto > p.sub_para";
	static String WorthyLinks="div.wrapper app-common-home.ng-star-inserted:nth-child(2) section.slider div.container div.fadeOut.owl-carousel.owl-theme.owl-loaded.owl-drag div.owl-stage-outer div.owl-stage div.owl-item.active:nth-child(";
	static WebElement webElement_OTrimLogo;
	static WebElement webElement_10Reasons;
	static WebElement webElement_WorthyLinks;
	static Screenshot screenshot;
	static String Analyticsviewoflinks_Text= "O Trim URL provides amazing analytics view of past links accessed from various channels, regions, browsers, mobiles etc. This gives a definite insights of the post capable of gathering broad audience.";
	static String AudienceAttention_Text="It is important to shorten your URL links because it is easier for an audience to trust and click a shorter link(provided it is shared from a credible source) compared to a longer link.";
	static String SocialMedia_Text="A shortened link is easier for your readers to click, copy, and share in their own post, which can help your content gain organic exposure on social networks.";
	static String BusinessandIndividuallinksmakeover_Text="O Trim URL is for both business and Individual who want to make an wonderful impact of their work in international rich market.";
	
	public static void openBrowser() throws Exception {
		
		System.setProperty("webdriver.chrome.driver","D:\\Softwaretools\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://trimurldemo.onpassive.com/");
		Thread.sleep(4000);
	}
	
	
		
	public static void getImages() throws IOException, InterruptedException {
		
		//OTrim Logo
		webElement_OTrimLogo=driver.findElement(By.cssSelector("div.wrapper app-common-home.ng-star-inserted:nth-child(2) header.cmn_header div.container div.row div.col-md-6.logo:nth-child(1) > img:nth-child(1)"));
		webElement_OTrimLogo.isDisplayed();
		Thread.sleep(3000);
		System.out.println("OTrim Logo is displayed");
		screenshot= new AShot().takeScreenshot(driver,webElement_OTrimLogo);
		Thread.sleep(3000);
		System.out.println("Image captured");
		ImageIO.write(screenshot.getImage(),"png",new File("C:\\Users\\User\\Downloads\\Workplace\\OtrimMaven\\Images\\OTrimLogo.png\\"));
		System.out.println("Image downloaded in the specified path");
		
		
		//10 Reasons
		webElement_10Reasons=driver.findElement(By.cssSelector("div.wrapper app-common-home.ng-star-inserted:nth-child(2) app-otrim-features:nth-child(4) section.features div.container div.col-lg-6.offset-lg-3 > img.img-fluid"));
		webElement_10Reasons.isDisplayed();
		System.out.println("10Reasons Logo is displayed");
		screenshot= new AShot().takeScreenshot(driver,webElement_10Reasons);
		System.out.println("Image captured");
		Thread.sleep(5000);
		ImageIO.write(screenshot.getImage(),"png",new File("C:\\Users\\User\\Downloads\\Workplace\\OtrimMaven\\Images\\10Reasons.png\\"));
		System.out.println("Image downloaded in the specified path");
			
	}
	
	


	public static void compareOTrimImages() throws IOException, InterruptedException {
		//BufferedImage expectedImage=ImageIO.read(new File("C:\\Users\\User\\Downloads\\Workplace\\OtrimMaven\\Images\\ExpectedLogo.png"));
		BufferedImage expectedImage=ImageIO.read(new File("C:\\Users\\User\\Downloads\\Workplace\\OtrimMaven\\Images\\OTrimLogo.png"));
		webElement_OTrimLogo=driver.findElement(By.cssSelector("div.wrapper app-common-home.ng-star-inserted:nth-child(2) header.cmn_header div.container div.row div.col-md-6.logo:nth-child(1) > img:nth-child(1)"));
		Thread.sleep(3000);
		screenshot= new AShot().takeScreenshot(driver,webElement_OTrimLogo);
		Thread.sleep(3000);
		System.out.println("Image captured");
		BufferedImage actualImage=screenshot.getImage();
		System.out.println("Image was get");
		Thread.sleep(3000);
		ImageDiffer imageDiffer=new ImageDiffer();
		ImageDiff diff=imageDiffer.makeDiff(expectedImage, actualImage);
		Assert.assertFalse(diff.hasDiff(),"Images are same");
		System.out.println("Images are same");
	}
	
	
	
	
	public static void scrollInToView_worthyLinks() {
		WebElement moveToElement = driver.findElement(By.xpath("//h3[contains(text(),'TRIM URL for click worthy links')]"));
		scrollInToView(moveToElement, driver);
		System.out.println("Scrolled To Click Worhty Links");
	}
	
	
	
	
	public static void scrollInToView(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	
		
	public static void drawBorder(WebElement element,WebDriver driver) {
		
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		
		js.executeScript("arguments[0].style.border='3px solid red'", element);
			
	}
		
	public static void urlTrimming() {
		
	}
	
	
	@SuppressWarnings({ "unlikely-arg-type", "unlikely-arg-type" })
	public static void worthyLinks_Headings() throws InterruptedException, IOException {
		for(int i=1;i<=4;i++) {
			
			//It says particular element is displayed on the page or not
			WebElement webElement_WorthyLinks=driver.findElement(By.cssSelector(WorthyLinks+i+") div.item div.row div.col-lg-5 > img.img-fluid"));
			webElement_WorthyLinks.isDisplayed();
			System.out.println("Worthy link is displayed");
			Thread.sleep(3000);
			
			//To Highlight the Particular Element on the page
			System.out.println(webElement_WorthyLinks);
			WebElement Worthylink_Images=webElement_WorthyLinks;
			drawBorder(Worthylink_Images, driver);
			
			//Worthy Links Header
			WebElement worthyLink_Headers = driver.findElement(By.cssSelector(WorthyLinks_Header_name+i+") div.item > h1.page_heading"));
			String worthyLink_header_Name=worthyLink_Headers.getText();
			
			//Worthy Links Text
			WebElement worthyLink_Text=driver.findElement(By.cssSelector(WorthyLinks_Text+i+WorthyLinks_Text1));
			String text=worthyLink_Text.getText();
			
			//It took Screenshot of Each page
			File srcfile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			System.out.println("Screenshot Taken");
			FileUtils.copyFile(srcfile, new File("C:\\Users\\User\\Downloads\\Workplace\\OtrimMaven\\Images\\"+worthyLink_header_Name+".png"));
			System.out.println("Taken Screenshot saved in to Specified location");
			
			//It is to check the Headers Text of the Worthy links
			if(worthyLink_header_Name.equals("Analytics view of links") & text.equals(Analyticsviewoflinks_Text)) {
				System.out.println("Analytics view of links Analytics view of links Text");
									
			}else if(worthyLink_header_Name.equals("Audience Attention") & text.equals(AudienceAttention_Text)) {
				System.out.println("Audience Attention Audience Attention Text");
				
			}else if(worthyLink_header_Name.equals("Social Media")& text.equals(SocialMedia_Text)) {
				System.out.println("Social Media Social Media Text");
				
			}else if(worthyLink_header_Name.equals("Business and Individual links makeover") & text.equals(BusinessandIndividuallinksmakeover_Text)) {
				System.out.println("Business and Individual links makeover Business and Individual links makeover");
			}
			
			//It clicks the arrow in the worthy links section
			Thread.sleep(4000);	
			driver.findElement(By.xpath("//span[contains(text(),'›')]")).click();
			System.out.println("Clicked");
			}
	}
	
	
	public static void screenshot() throws IOException, InterruptedException {
					
			File srcfile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcfile, new File("C:\\Users\\User\\Downloads\\Workplace\\OtrimMaven\\Images\\.png"));
			Thread.sleep(2000);
			driver.findElement(By.xpath("//span[contains(text(),'›')]")).click();
			Thread.sleep(3000);
			System.out.println("Clicked");
		}
	
	
	
	
	
	
	
	
	public static void main(String[] args) throws Exception {
		
		openBrowser();
		
		scrollInToView_worthyLinks();
		
		worthyLinks_Headings();
		
	}
	
	
}




//public static void worthyLinks_Text() throws InterruptedException, IOException {
//
//for(int i=1;i<=4;i++) {
//					
//webElement_WorthyLinks=driver.findElement(By.cssSelector(WorthyLinks+i+") div.item div.row div.col-lg-5 > img.img-fluid"));
//webElement_WorthyLinks.isDisplayed();
//System.out.println("Worthy link is displayed");
//Thread.sleep(3000);
//screenshot();
//System.out.println("Screenshot Taken");
//				
//if(driver.findElement(By.xpath("//h1[contains(text(),'Analytics view of links')]")).getText().equals("Analytics view of links") & driver.findElement(By.xpath("//p[contains(text(),'O Trim URL provides amazing analytics view of past')]")).getText().equals(Analyticsviewoflinks_Text)) {
//System.out.println("Analytics view of links & Analyticsviewoflinks_Text Success");
//
//}else if(driver.findElement(By.xpath("//h1[contains(text(),'Audience Attention')]")).getText().equals("Audience Attention") & driver.findElement(By.xpath("//p[contains(text(),'It is important to shorten your URL')]")).getText().equals(AudienceAttention_Text)) {
//System.out.println("Audience Attention & AudienceAttention_Text Success");
//
//}else if(driver.findElement(By.xpath("//h1[contains(text(),'Social Media')]")).getText().equals("Social Media") & driver.findElement(By.xpath("//p[contains(text(),'A shortened link is easier')]")).getText().equals(SocialMedia_Text)) {
//System.out.println("Social Media & SocialMedia_Text Success");
//
//}else if(driver.findElement(By.xpath("//h1[contains(text(),'Business and Individual links makeover')]")).getText().equals("Business and Individual links makeover") & driver.findElement(By.xpath("//p[contains(text(),'O Trim URL is for both business')]")).getText().equals(BusinessandIndividuallinksmakeover_Text)) {
//System.out.println("Business and Individual links makeover & BusinessandIndividuallinksmakeover_Text Success");
//}
//
////screenshot();
////System.out.println("Screenshot Taken");
//Thread.sleep(4000);	
//driver.findElement(By.xpath("//span[contains(text(),'›')]")).click();
//Thread.sleep(3000);
//System.out.println("Clicked");
//}
//
//}
//

//public static void getImage() throws IOException, InterruptedException {
//webElement=driver.findElement(By.cssSelector("div.wrapper app-common-home.ng-star-inserted:nth-child(2) header.cmn_header div.container div.row div.col-md-6.logo:nth-child(1) > img:nth-child(1)"));
//webElement.isDisplayed();
//Thread.sleep(3000);
//System.out.println("Image was displayed");
//Thread.sleep(3000);
//screenshot= new AShot().takeScreenshot(driver,webElement);
//System.out.println("Image captured");
//Thread.sleep(5000);
//ImageIO.write(screenshot.getImage(),"png",new File("C:\\Users\\User\\Downloads\\Workplace\\OtrimMaven\\Images\\OTrimLogo.png"));
//System.out.println("Image downloaded in the specified path");
//}

