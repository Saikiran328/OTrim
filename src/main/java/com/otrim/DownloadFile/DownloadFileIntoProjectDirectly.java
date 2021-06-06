package com.otrim.DownloadFile;

import java.io.File;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DownloadFileIntoProjectDirectly {

	public static void main(String[] args) throws InterruptedException {
		
		
		ChromeOptions options = new ChromeOptions();
		
		//you want to download a file into project directly use below code
		
		//This statement says download file in the project location
		String downloadFilePathLocation = System.getProperty("user.dir");
		
		HashMap<String, Object> chromeprefs = new HashMap<String, Object>();
		chromeprefs.put("profile.default_content_settings.popups", 0);
		chromeprefs.put("download.default_directory", downloadFilePathLocation);
		options.setExperimentalOption("prefs", chromeprefs);
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("http://omayo.blogspot.com/p/page7.html");
		driver.findElement(By.linkText("ZIP file")).click();
		
		
		//Below code will check file is downloaded in the specified path or not
		
		File downloadedFile = new File(downloadFilePathLocation+"//DownloadDemo-master.zip");
		Thread.sleep(5000);
		Assert.assertTrue(downloadedFile.exists());
		System.out.println("File Exists");
		
		//Below statement delete the file from the specified location
		downloadedFile.delete();
		System.out.println("File Deleted");
		
		driver.close();
	
		

	}

}
