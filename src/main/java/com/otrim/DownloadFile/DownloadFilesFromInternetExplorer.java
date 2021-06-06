package com.otrim.DownloadFile;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Set;

import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.HostConfiguration;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpState;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DownloadFilesFromInternetExplorer {

	public static void main(String[] args) throws HttpException, IOException {
		
		//It should work for only Internet explorer above 7v and min windows 7 is required
		//we need to do some setting in the browser 
		//1.Open internet browser - Click on setting - click on Internet options
		//2.Go to security tab - Click on internet --uncheck the "Enable protected Mode"
		//3.Go to security tab - Click on Local Intranet --uncheck the "Enable protected Mode"
		//4.Go to security tab - Click on Trusted Sites --uncheck the "Enable protected Mode"
		//5.Go to security tab - Click on Restricted sites --uncheck the "Enable protected Mode"
		//6.Click on Advanced tab - search for "Enable enhanced protected mode" -- uncheck the option
		//7.Click on OK button
		//8.Set the browser Zoom level to 100%
		//9.If you are using windows 10 - Right click on screen - click on Display setting  - "Change the size of text,apps,and other items" to 100% 
		//10.search for Registry Editor in windows
		//11.follow the link for configuration in Registry Editor -https://github.com/SeleniumHQ/selenium/wiki/InternetExplorerDriver#required-configuration
		//12.Add commons-io dependency in pom.xml
		//13.need apache-commons-httpclient jar -- https://trimurl.ga/YLjwfEr --- click on download jar file
		//14.Add the jar file in to your project
		
		//If you get any error in run time --java.lang.NoClassDefFoundError: org/apache/commons/logging/LogFactory like that
		//open mvn repository - search for commons-logging maven dependency - click on Apache commons logging - select latest version -copy the dependency- Add in the pom.xml
		
		
		WebDriverManager.iedriver().setup();
		WebDriver driver = new InternetExplorerDriver();
		driver.manage().window().maximize();
		driver.get("http://omayo.blogspot.com/p/page7.html");
		
		//Instead manual click on zip file -- internet explorer will take care to click on particular webelement
		//for that we need to add the code -- go to https://trimurl.ga/YLjwfEr -- click on 7th point click here button -- copy the code and paste in your class
		WebElement downloadLink = driver.findElement(By.linkText("ZIP file"));
		
		String fileToDownloadAbsoluteLocation = downloadLink.getAttribute("href");
		URL fileToDownload = new URL(fileToDownloadAbsoluteLocation);
		String hostURL = fileToDownload.getHost();
		int port = fileToDownload.getPort();
		
		HttpClient hClient = new HttpClient();
		hClient.getParams().setCookiePolicy(CookiePolicy.RFC_2965);
		HostConfiguration hostConfig = new HostConfiguration();
		hostConfig.setHost(hostURL,port);
		Set<org.openqa.selenium.Cookie> cookies = driver.manage().getCookies();
		HttpState cookieState = new HttpState();
		for (org.openqa.selenium.Cookie seleniumCookie : cookies) {
            Cookie httpClientCookie = new Cookie(seleniumCookie.getDomain(), seleniumCookie.getName(), seleniumCookie.getValue(), seleniumCookie.getPath(), seleniumCookie.getExpiry(), seleniumCookie.isSecure());
            cookieState.addCookie(httpClientCookie);
        }
		HttpMethod getFileRequest = new GetMethod(fileToDownloadAbsoluteLocation);
		boolean followRedirects = true;
		getFileRequest.setFollowRedirects(followRedirects);
		hClient.executeMethod(getFileRequest);
		String downloadPath = System.getProperty("user.dir")+"\\downloads";
		File downloadedFile = new File(downloadPath+"\\DownloadDemo-master.zip");
		FileUtils.copyInputStreamToFile(getFileRequest.getResponseBodyAsStream(),downloadedFile);
		getFileRequest.releaseConnection();
		
		Assert.assertTrue(downloadedFile.exists());
		System.out.println("File Exists");

		// Below statement delete the file from the specified location
		downloadedFile.delete();
		System.out.println("File Deleted");

	}

}
