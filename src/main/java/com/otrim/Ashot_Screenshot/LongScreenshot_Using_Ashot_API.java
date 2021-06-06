package com.otrim.Ashot_Screenshot;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class LongScreenshot_Using_Ashot_API {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.w3schools.com/");
		
		Screenshot ScreenShot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(10)).takeScreenshot(driver);
		System.out.println("Screenshot taken");
		
		try {
			ImageIO.write(ScreenShot.getImage(),"png",new File("C:\\Users\\User\\Downloads\\Workplace\\OtrimMaven\\Screenshots\\FullScreenshot.png"));
			System.out.println("Screenshot saved in the location");
		}catch (IOException e) {
			
		}
		driver.close();
	}

}
