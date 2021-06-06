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

public class QRCode {

	public static void main(String[] args) throws IOException, NotFoundException {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
//		driver.get("https://www.the-qrcode-generator.com/");
//		driver.findElement(By.xpath("//textarea[@id='input_5']")).sendKeys("Saikiran");
		
		driver.get("D:\\Softwaretools\\Selenium\\QRForm.html");
		String qrCode=driver.findElement(By.tagName("img")).getAttribute("src");
		System.out.println(qrCode);
		
		URL urlOfImage = new URL(qrCode);
		BufferedImage bufferedImage = ImageIO.read(urlOfImage);
		
		LuminanceSource luminanceSource = new BufferedImageLuminanceSource(bufferedImage);
		BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(luminanceSource));
		
		Result result = new MultiFormatReader().decode(binaryBitmap);
		String textInQrCode = result.getText();
		
		System.out.println(textInQrCode);
	}

}
