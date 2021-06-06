package com.otrim.qa.practice;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;

public class KeyBoard {

	static int otp;
	static int reEnter_otp;
	static Scanner scanner;
	static WebDriver driver;
	
	public static void keyBoard() {
		
		scanner = new Scanner(System.in);
		System.out.println("Please Enter OTP:");
		otp=scanner.nextInt();
		//System.out.println("Entered Otp is:"+otp);
		
		System.out.println("Please Re-Enter OTP:");
		reEnter_otp=scanner.nextInt();
		//System.out.println("Entered Otp is:"+reEnter_otp);
		
		if(otp==reEnter_otp){
			System.out.println("Entered Otp is Equal:"+reEnter_otp);
			
		}else{
			System.out.println("Entered Otp is wrong try again:");
			keyBoard();
		}
		
		System.out.println("Done");
	}
	
//	public static void verify() {
//		if(otp==reEnter_otp){
//			System.out.println("Entered Otp is Equal");
//		}else{
//			System.out.println("Entered Otp is wrong try again:");
//			keyBoard();
//		}
//	}
		
	public static void main(String[] args) {
		 keyBoard();
		
	}
}
