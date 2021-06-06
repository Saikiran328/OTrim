package com.qa.BarCode.QRCode;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BarCode {

	public static void main(String[] args) throws IOException, NotFoundException {
WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("D:\\Softwaretools\\Selenium\\BarCode.html");
		String barCode=driver.findElement(By.tagName("img")).getAttribute("src");
		System.out.println(barCode);
		
		URL urlOfImage = new URL(barCode);
		BufferedImage bufferedImage = ImageIO.read(urlOfImage);
		
		LuminanceSource luminanceSource = new BufferedImageLuminanceSource(bufferedImage);
		BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(luminanceSource));
		
		Result result = new MultiFormatReader().decode(binaryBitmap);
		String textInBarCode = result.getText();
		
		System.out.println(textInBarCode);
	}

}
