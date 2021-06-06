package com.otrim.qa.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Excel {
	
	static WebDriver driver;
	static WebElement alert_Ok_Btn;
	static String trimFeild="//body/app-root[1]/div[1]/app-common-home[1]/section[1]/div[1]/div[1]/div[1]/div[1]/input[1]";
	
		public static void main(String[] args) throws InterruptedException, IOException{
		System.setProperty("webdriver.chrome.driver","D:\\Softwaretools\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://trimurldemo.onpassive.com/");
		
		//FileInputStream fis1 = new FileInputStream("D:\\GuestSignUp_TestData.xlsx");
		FileInputStream fis1 = new FileInputStream("D:\\LongUrls.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis1);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		//This step will give you the row count in the Excel
		int rowCount=sheet.getLastRowNum();
		System.out.println("Total Rows :" + rowCount);
		for(int i=0;i<=rowCount;i++) {
		String data = sheet.getRow(i).getCell(0).getStringCellValue();
			
			driver.findElement(By.xpath("//body/app-root[1]/div[1]/app-common-home[1]/section[1]/div[1]/div[1]/div[1]/div[1]/input[1]")).sendKeys(data);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[contains(text(),'OTrim')]")).click();
			Thread.sleep(3000);			
			WebElement alert_Ok_Btn= driver.findElement(By.xpath("//button[contains(text(),'OK')]"));
			alert_Ok_Btn.click();
			driver.navigate().refresh();
			System.out.println(data);
		}
		
	}
		
}

	





//Iterator<Row> rowIterator= sheet.iterator();
//String name="";
//
//while(rowIterator.hasNext()) {
//	Row row=rowIterator.next();
//	Iterator<Cell> cellIterator = row.cellIterator();
//	
//	while(cellIterator.hasNext()) {
//		Cell cell=cellIterator.next();
//		name =cell.getStringCellValue();
//		System.out.println(name);
//	}
//	
//	System.out.println("");
//}