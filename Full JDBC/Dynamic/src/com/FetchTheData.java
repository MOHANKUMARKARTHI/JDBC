package com;

import java.sql.*;

public class FetchTheData {
	public static void main(String[] args) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
			
			// create statement
			Statement s= c.createStatement();
			
			ResultSet rs=s.executeQuery("select * from emp_table");
			
			while(rs.next())
			{
				System.out.println("Name :"+rs.getString("ename"));
				System.out.println("Job :"+rs.getString("job"));
			}
		}
		catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
	}

}
