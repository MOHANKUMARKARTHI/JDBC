
                             //EXECUTE();

package com;
import java.sql.*;
public class ExecuteMethod2 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
			
			// create statement
			Statement s = c.createStatement();
			boolean b= s.execute("select * from emp_table");
			if(b)
			{
				ResultSet rs =s.getResultSet();
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
		}
		catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
	}

}
