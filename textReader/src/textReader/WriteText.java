package textReader;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class WriteText {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		Connection conn = DatabaseConnection.getConnection("text_db", "root", "Sonu#2000");
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select * from stu_data");
		Student stu = new Student();
		while(rs.next()) {
			stu.setName(rs.getString(1));
			stu.setAge(Integer.parseInt(rs.getString(2)));
			stu.setAddress(rs.getString(3));
			stu.setPhoneNo(rs.getString(4));
		}
		System.out.println(stu);
		File file = new File("StudentInfo.txt");
		FileWriter flw = new FileWriter("StudentInfo.txt");
		if(file.createNewFile()) {
			System.out.println("New file has been created!!");
			
			flw.write(stu.toString());
			
		}
		else {
			System.out.println("details inserted to the file sucessfully!!");
			flw.write(stu.toString());
		}
		flw.close();
		
	}

}
