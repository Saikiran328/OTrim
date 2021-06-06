package com.otrim.qa.HandlingWindowAuthenticaton_UsingDevTools;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v89.network.Network;
import org.openqa.selenium.devtools.v89.network.model.Headers;

public class HandlingWindowAuthenticaton_UsingDevTools {

	private static final String username="admin";
	private static final String password="admin";
	
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\User\\Downloads\\Workplace\\OtrimMaven\\Drivers\\chromedriver.exe");
		//WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		Thread.sleep(5000);
		
		//This devtools is applicable only for Chrome and Edge browser only
		DevTools devtools = ((ChromeDriver)driver).getDevTools();
		devtools.createSession();
		//If you get any error at enable change JavaSE version to 1.8
		devtools.send(Network.enable(Optional.empty(),Optional.empty(),Optional.empty()));
		
		//Send Authentication header
		Map<String,Object> headers = new HashMap<>();
		String basicAuth = "Basic " + new String(new Base64().encode(String.format("%s:%s", username,password).getBytes()));
		headers.put("Authorization", basicAuth);
		devtools.send(Network.setExtraHTTPHeaders(new Headers(headers)));
			
		driver.get("https://the-internet.herokuapp.com/basic_auth");
		
		//Or we can write the below line with out devtools
		//Here only one limitation is there -- If username contains "@" it is not applicable
		
		//driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		

	}

}
