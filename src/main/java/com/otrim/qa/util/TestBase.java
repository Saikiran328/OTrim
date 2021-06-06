package com.otrim.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\otrim\\qa\\config\\config.properties");
			prop.load(fis);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@SuppressWarnings("deprecation")
	public static void intialization() {
		String browserName= prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			//System.setProperty("webdriver.chrome.driver","D:\\Softwaretools\\chromedriver_win32\\chromedriver.exe");
			driver= new ChromeDriver();
		}else if(browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			//System.setProperty("webdriver.gecko.driver","F:\\Softwaretools\\geckodriver-v0.28.0-win32\\geckodriver.exe");
			driver= new FirefoxDriver();
	}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	
	}
	

	
}
