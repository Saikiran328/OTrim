package com.otrim.Cookies;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Coockies {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteCookieNamed("");
		driver.get("https://flipkart.com");

		//Adding Own Cookie
		Cookie cookie = new Cookie("MyFlipkartCookie","123");
		driver.manage().addCookie(cookie);
//		
//		//Get the Cookies
//		Set<Cookie> cookies = driver.manage().getCookies();
//		
//		for(Cookie cook : cookies ) {
//			System.out.println(cook);
//		}
		
		//If you want to get a particular cookie
		Cookie Cookiename = driver.manage().getCookieNamed("MyFlipkartCookie");
		System.out.println(Cookiename);
	}

}
