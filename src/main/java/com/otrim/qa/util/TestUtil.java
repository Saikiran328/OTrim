package com.otrim.qa.util;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import com.otrim.qa.pages.LandingPage;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class TestUtil extends TestBase {

	LandingPage landingpage = new LandingPage();
	static Logger log = LogManager.getLogger();

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_TIMEOUT = 10;
	public static Workbook book;
	public static Sheet sheet;
	public static String Guest_TESTDATA_SHEET_PATH = "D:\\TestData.xlsx";
	public static String Login_TESTDATA_SHEET_PATH = "D:\\TestData.xlsx";
	public static String Long_URLs_TESTDATA_SHEET_PATH = "D:\\TestData.xlsx";
	// public static String fileInputStream_path="D:\\OcademyLogin.xlsx";
	public static WebElement alert_Ok_Btn;
	public static WebElement height_Width;
	public static int otrim_Logo_height;
	public static int otrim_Logo_width;
	public static Screenshot screenshot;
	public static String data = "";
	public static Actions actions;

	public static BufferedImage actualImage;
	public static BufferedImage expectedImage;
	public static ImageDiffer imageDiffer;
	public static ImageDiff diff;
	public static WebElement oTrimLogo;
	public static WebElement eyeButton;
	public static Boolean check_eyeBtn_display;
	public static Boolean check_eyeBtn_enable;
	public static Robot robot;
	
	// Paths
	public static String expectedImage_Path = "C:\\Users\\User\\Downloads\\Workplace\\OtrimMaven\\Images\\OTrimLogo1.png";
	public static String newFile_ImagePath = "C:\\Users\\User\\Downloads\\Workplace\\OtrimMaven\\Images\\";
	public static String deleteFilePath = "C:\\Users\\User\\Downloads\\Workplace\\OtrimMaven\\Images\\OTrimLogo1.png";
	
	
	public static String alert_Button = "//button[contains(text(),'OK')]";
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static Object[][] readExcelData(String filePath,String sheetName) {

		FileInputStream file = null;
		try {
			file = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			book = WorkbookFactory.create(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
				data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
			}
		}
		return data;
	}

	// ----------------------------------------------------------------------------

//	public static Object[][] guestLoginData(String sheetName) {
//
//		FileInputStream file = null;
//		try {
//			file = new FileInputStream(Login_TESTDATA_SHEET_PATH);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//
//		try {
//			book = WorkbookFactory.create(file);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//		sheet = book.getSheet(sheetName);
//		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
//		for (int i = 0; i < sheet.getLastRowNum(); i++) {
//			for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
//				data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
//			}
//
//		}
//		return data;
//	}

	// ----------------------------------------------------------------------------

	public void scrollInToView(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	// ----------------------------------------------------------------------------
	public static void drawBorder(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}

	// ----------------------------------------------------------------------------
	public void switchToPreviousTab() {
		ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tab.get(0));
	}

	// -------------------------------------------------------------------------------------
	public void deleteFile(String delete_Filepath) {
		try {
			if ((new File(delete_Filepath)).delete()) {
				System.out.println("Pass");
			} else {
				System.out.println("Failed");
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	// ----------------------------------------------------------------------------
	
	// It will get the height and width of the OTrimLogo
	public void heightAndWidth(String path) {

		height_Width = driver.findElement(By.xpath(path));
				
		otrim_Logo_height=height_Width.getRect().getDimension().getHeight();
		System.out.println("Height Of The OTrim-Logo Is:" +otrim_Logo_height);
		log.info("Height Of The OTrim-Logo Is:" +otrim_Logo_height);
		
		otrim_Logo_width=height_Width.getRect().getDimension().getWidth();
		System.out.println("Width Of The OTrim-Logo Is:"+ otrim_Logo_width);
		log.info("Width Of The OTrim-Logo Is:"+ otrim_Logo_width);
	}

	public static void compareOTrimImages(WebElement border_otrimLogo, String otrim_logo)
			throws IOException, InterruptedException {

		// Expected image already taken and saved in the Images Folder By using
		// screenShot() function
		expectedImage = ImageIO.read(new File(expectedImage_Path));

		drawBorder(border_otrimLogo, driver);

		oTrimLogo = driver.findElement(By.cssSelector(otrim_logo));// 1 String
		Thread.sleep(3000);

		// It will take the screenshot of the O-Trim Image
		screenshot = new AShot().takeScreenshot(driver, oTrimLogo);
		Thread.sleep(3000);
		System.out.println("Image captured");

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


	public Map<String, Object> readExcel(String fileInputStream_path,String sheetName) throws IOException, InterruptedException {
		FileInputStream fis1 = new FileInputStream(fileInputStream_path);
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(fis1);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		// This step will give you the row count in the Excel
		int rowCount = sheet.getLastRowNum();
		System.out.println("Total Rows :" + rowCount);
		Map<String, Object> data = new HashMap<>();
		data.put("sheet", sheet);
		data.put("rowCount", rowCount);
		return data;
	}
	

	
	
	public void alert_OK() {
		alert_Ok_Btn = driver.findElement(By.xpath(alert_Button));
		alert_Ok_Btn.click();
	}
	
	public void eyeButton(String eyePath) throws Exception {
		eyeButton = driver.findElement(By.xpath(eyePath));
	
		actions = new Actions(driver);
		actions.clickAndHold(eyeButton).perform();
		System.out.println("ClickAndHolded For 2 seconds");
		log.info("ClickAndHolded For 2 seconds");
		Thread.sleep(2000);
		
		actions.release().perform();
		System.out.println("ClickAndHold Released");
		log.info("ClickAndHold Released");
	}
	
	public void eyeButton_UI(String eyepath) {
	eyeButton = driver.findElement(By.xpath(eyepath));
		
		check_eyeBtn_display=eyeButton.isDisplayed();
		System.out.println("GuestLogin Eye Button Is Displayed:" + check_eyeBtn_display);
		log.info("GuestLogin Eye Button Is Displayed:" + check_eyeBtn_display);
		
		check_eyeBtn_enable=eyeButton.isDisplayed();
		System.out.println("GuestLogin Eye Button Is Enabled:" + check_eyeBtn_enable);
		log.info("GuestLogin Eye Button Is Enabled:" + check_eyeBtn_enable);
	}
	
	public void mouseHover(String password_hint) throws Exception {
		actions.moveToElement(driver.findElement(By.xpath(password_hint))).build().perform();
		Thread.sleep(2000);
	}

	public void openNewTab() throws AWTException, InterruptedException {

		robot = new Robot();

		// Copy the content
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_C);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_C);

		System.out.println("ShortUrl Copied");

		// Open new Tab in the Chrome
		driver.switchTo().newWindow(WindowType.TAB);
		
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
		Thread.sleep(5000);
		switchToPreviousTab();

	}

}
