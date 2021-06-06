package com.otrim.qa.practice;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;
//import io.github.bonigarcia.wdm.WebDriverManager;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;


public class Automate_Captcha {

	static WebDriver driver;
	public static void main(String[] args) throws IOException, InterruptedException, TesseractException {
		
	//System.setProperty("webdriver.chrome.driver","C:\\Users\\User\\Downloads\\chromedriver-88\\chromedriver.exe");
		
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.irctc.co.in/nget/train-search");
						
		Thread.sleep(5000);
					
		driver.findElement(By.xpath("//a[contains(text(),'LOGIN')]")).click();
		
		Thread.sleep(10000);
		
		File src = driver.findElement(By.cssSelector("img[src$='banner']")).getScreenshotAs(OutputType.FILE);
		
		//String path = System.getProperty("user.dir")+"/Screenshots/captcha.png";
		
		FileHandler.copy(src, new File("C:\\Users\\User\\Downloads\\Workplace\\OtrimMaven\\Screenshots\\captcha.png"));
				
		Thread.sleep(5000);
		
		ITesseract image= new Tesseract();
		System.out.println("Executed");
		String imageText=image.doOCR(new File("C:\\Users\\User\\Downloads\\Workplace\\OtrimMaven\\Screenshots\\captcha.png"));
		
		System.out.println(imageText);
		
		//Download any language from this link https://github.com/tesseract-ocr/tessdata like:eng.traineddata
		//https://github.com/tesseract-ocr/tessdata/blob/c2b2e0df86272ce11be323f23f96cf656565ed41/eng.traineddata
		
			}

}
