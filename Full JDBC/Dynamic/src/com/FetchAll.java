package com;

import java.sql.*;
import java.util.Scanner;
public class FetchAll {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		System.out.println("Enter starting salary:");
		double start=sc.nextDouble();
		System.out.println("Enter Ending salary:");
		double end=sc.nextDouble();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
			
			// create statement
			PreparedStatement ps= c.prepareStatement("select * from emp_table where salary between ? and ?");
			
			ps.setDouble(1, start);
			ps.setDouble(2, end);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				System.out.println("ID :"+rs.getInt("eid"));
				System.out.println("Name :"+rs.getString("ename"));
				System.out.println("Job :"+rs.getString("job"));
				System.out.println("Salary :"+rs.getDouble("salary"));
				System.out.println("Location :"+rs.getString("location"));
				System.out.println("***********************************************");
			}
			
		}
		catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
	}

}
