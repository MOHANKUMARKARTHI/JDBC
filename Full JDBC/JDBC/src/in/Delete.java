package in;

import java.sql.*;

public class Delete {
	public static void main(String[] args) {

		try {
			// 1.load or register Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			
			//2.establish connection
			Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
			
			
			//3.create statement
			Statement s =c.createStatement();
			
			//4.executeupdate
			s.executeUpdate("delete from emp_table where eid=2");
			System.out.println("deleted");
		}
			
			catch(Exception e) {
				e.printStackTrace();
			}
		
		}

}

