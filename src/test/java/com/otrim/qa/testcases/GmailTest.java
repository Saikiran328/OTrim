package com.otrim.qa.testcases;

import com.otrim.qa.practice.GMail;

public class GmailTest extends GMail {

	public static void main(String[] args) {
		
		GMail g= new GMail();
		
		String gmailDetials=g.fetchGmail("sai kiran");
		System.out.println(gmailDetials);
		String[] arr1=gmailDetials.split(":");
		String OTP=arr1[1].replaceAll("[^0-9]", "").subSequence(0, 4).toString();
		System.out.println(OTP);

	}

}
