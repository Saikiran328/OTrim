package com.otrim.qa.practice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4JDemo {

	public static void main(String[] args) {
		
		Logger log = LogManager.getLogger();
		System.out.println("\n Hello World....! \n");
		log.info("This is my project");

	}

}
