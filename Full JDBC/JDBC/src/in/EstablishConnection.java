package in;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EstablishConnection {
	public static void main(String[] args) throws SQLException {
		
		
		try {
			// 1.load or register Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			
			//2.establish connection
			Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
			
			
			//3.create statement
			Statement s =c.createStatement();
			
			// 4.executeQuery
			s.executeUpdate("insert into emp_table values(2,'Partha','Dev',230000,'chennai')");
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
