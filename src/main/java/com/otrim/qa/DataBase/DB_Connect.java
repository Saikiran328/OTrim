package com.otrim.qa.DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB_Connect {
	
	//static String insert="insert into otrim.username values('dinesh','reddy')";
	public static void db() throws ClassNotFoundException, SQLException {
		
//		Class.forName("com.mysql.jdbc.Driver");
//		System.out.println("Driver Loaded");
		
		
		
		// Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/otrim","root","root");
		Connection con = DriverManager.getConnection("jdbc:mysql://65.0.23.226:3306/trimurldb","trimurlusr","Kb#tYq3L*8gNp");
		System.out.println("Connected To Mysql DB");
		
		Statement smt = con.createStatement();
		String insert="insert into otrim.username values('kp','paturi')";
		String delete ="delete from otrim.username where username ='kp'";
		smt.executeUpdate(delete);
		System.out.println("delete quiery executed");
		smt.executeUpdate(insert);
		System.out.println("Insert Quiery Executed");
		
		
		
		
//	ResultSet rs =smt.executeQuery("SELECT * FROM otrim.username");
//	while(rs.next()) {
//		String firstName =rs.getString("username");
//		System.out.println(firstName);
//			
//		if(firstName.equalsIgnoreCase("Saikiran")) {
//			System.out.println("equal");
//		}else {
//		System.out.println("Not Equal");
//			}
//				
//			
//		}
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		db();
	}

}
