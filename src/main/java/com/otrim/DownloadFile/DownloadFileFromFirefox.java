package com.otrim.DownloadFile;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DownloadFileFromFirefox {

	public static void main(String[] args) throws InterruptedException {

		// When we use the firefox browser some times its ask for openwith, savefile
		// prompt was showing to avoid that use below code

		// To avoid that prompt we have to specify 3 preferences--below is the code
		FirefoxOptions options = new FirefoxOptions();

		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("browser.download.folderList", 2);

		String downloadFilePathLocation = System.getProperty("user.dir") + "\\downloads";
		profile.setPreference("browser.download.dir", downloadFilePathLocation);

		// you have to specify the file type u r downloading--for this we use mime types
		// https://developer.mozilla.org/en-US/docs/Web/HTTP/Basics_of_HTTP/MIME_types/Common_types
		// if you to decalre multiple type files use ","
		// seperated------application/zip,application/pdf

		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/zip");
		options.setProfile(profile);

		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver(options);
		driver.manage().window().maximize();
		driver.get("http://omayo.blogspot.com/p/page7.html");
		driver.findElement(By.linkText("ZIP file")).click();

		// Below code will check file is downloaded in the specified path or not

		File downloadedFile = new File(downloadFilePathLocation + "//DownloadDemo-master.zip");
		Thread.sleep(5000);
		Assert.assertTrue(downloadedFile.exists());
		System.out.println("File Exists");

		// Below statement delete the file from the specified location
		downloadedFile.delete();
		System.out.println("File Deleted");

		driver.close();

	}

}
