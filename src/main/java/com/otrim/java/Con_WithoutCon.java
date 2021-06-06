package com.otrim.java;

public class Con_WithoutCon {

	static String s;
	static int i;
	
	Con_WithoutCon(String name, int rollno){
		
		this.s=name;
		this.i=rollno;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Con_WithoutCon c = new Con_WithoutCon("KP",1);
		System.out.println(c.s);

	}

}
