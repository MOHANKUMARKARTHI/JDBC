package com;

import java.sql.*;
import java.util.Scanner;

public class Dynamic_insert {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		System.out.println("Enter emp id");
		int id = sc.nextInt();
		
		System.out.println("Enter emp name");
		String name = sc.next();
		
		System.out.println("Enter your job");
		String job = sc.next();
		
		System.out.println("Enter your salary");
		Double sal = sc.nextDouble();
		
		System.out.println("Enter your location");
		String loc = sc.next();
		
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
			
			// create statement
			PreparedStatement ps= c.prepareStatement("insert into emp_table values(?,?,?,?,?)");
			
			ps.setInt(1,id);
			ps.setString(2,name);
			ps.setString(3,job);
			ps.setDouble(4,sal);
			ps.setString(5,loc);
			
			ps.executeUpdate();
			System.out.println("Data Saved");
		}
		catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
	}

}
