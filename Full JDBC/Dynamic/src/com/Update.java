package com;

import java.sql.*;
import java.util.Scanner;

public class Update {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		System.out.println("Enter the name");
		String name = sc.next();
		
		System.out.println("Enter the location");
		String loc =sc.next();
		
		System.out.println("Enter the eid");
		int id=sc.nextInt();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
			
			// create statement
			PreparedStatement ps= c.prepareStatement("update emp_table set ename=?,location=? where eid=?");
			ps.setString(1,name);
			ps.setString(2,loc);
			ps.setInt(3,id);
			
			ps.executeUpdate();
			System.out.println("data updated");
		}
		catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
	}

}
