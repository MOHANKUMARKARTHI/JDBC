                                 //EXECUTE();

package com;

import java.sql.*;

public class ExecuteMethod1 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
			
			// create statement
			Statement s = c.createStatement();
			boolean b= s.execute("update emp_table set ename='siva',location='india'  where eid=1");
			if(!b)
			{
				int affected =s.getUpdateCount();
				System.out.println("No of affected = "+affected);
			}
			
			System.out.println("data updated");
		}
		catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
	}

}
