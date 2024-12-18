package com;

import java.sql.*;
public class CloseTheConnection {
	public static void main(String[] args) {
		Connection c = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 c = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
			
			// create statement
			Statement s=c.createStatement();
			
			s.executeUpdate("update emp_table set ename='varun',salary=56000 where eid=3");
			System.out.println("data updated");

		}
		catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}finally {
			try
			{
				if(c!=null)
				{
					c.close();
				}
			
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
	
}

	


