package excelReader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DriverConnection {

	public static Connection getConnection(String db,String userName,String Pass)throws SQLException, ClassNotFoundException{
		//first set class name
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+db,userName,Pass);
		System.out.println("connection established!!");
		return conn;
		
	}
}
