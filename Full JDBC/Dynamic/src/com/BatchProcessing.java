package com;

import java.sql.DriverManager;
import java.sql.*;
import java.util.Scanner;

public class BatchProcessing {
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
		
		System.out.println("Enter count:");
		int count=sc.nextInt();
		PreparedStatement ps=c.prepareStatement("insert into emp_table values(?,?,?,?,?)");
		
		for(int i=1;i<=count;i++)
		{
			System.out.println("Enter id:");
			int id=sc.nextInt();
			
			System.out.println("Enter Employee Name:");
			String name=sc.next();
			
			System.out.println("Enter Job:");
			String job=sc.next();
			
			System.out.println("Enter Salary:");
			double salary=sc.nextDouble();
			
			System.out.println("Enter Location:");
			String location=sc.next();
			
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3,job);
			ps.setDouble(4, salary);
			ps.setString(5,location);
			
			ps.addBatch();
		}
		ps.executeBatch();
		
		}catch(SQLException | ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}

}
