package textReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ReadText {

	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, SQLException {
		File file = new File("studentinfo.txt");
		Scanner sc = new Scanner(file);
		Student stu = new Student();
		while(sc.hasNext()) {
			String[] details = sc.nextLine().split(":");
			switch(details[0]) {
			case "Name":
				stu.setName(details[1]);
				break;
			case "Age":
				stu.setAge(Integer.parseInt(details[1]));
				break;
			case "Address":
				stu.setAddress(details[1]);
				break;
			case "phoneNo":
				stu.setPhoneNo(details[1]);
				break;
			default:
				break;
			}
			
	}		
		
		Connection conn = DatabaseConnection.getConnection("text_db","root","Sonu#2000");
		//saving data to sqldatabase
		Statement st = conn.createStatement();
		   int m = st.executeUpdate("insert into stu_data values('"+stu.getName()+"',"+stu.getAge()+",'"+stu.getAddress()+"','"+stu.getPhoneNo()+"')");
		st.close();
		conn.close();
		System.out.println(""+stu.toString());
	}
	
}
