package excelReader;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class SaveXcelData {

	public String saveData(List<XcelContent> listContent) throws ClassNotFoundException, SQLException {
		Connection conn = DriverConnection.getConnection("test", "root", "Sonu#2000"); 
		PreparedStatement stmt = conn.prepareStatement("insert into person_table values(?,?,?,?)");
		long t1 = System.currentTimeMillis();
		long t2 = 0,count=0;
		for(XcelContent content:listContent) {
			
			stmt.setString(1, content.getName());
			stmt.setString(2, content.getAddharCardNo());
			stmt.setString(3, content.getPanCardNo());
			stmt.setString(4, content.getVotarCardNo());
			stmt.addBatch();
			count++;
			if(count==50) {
				stmt.executeBatch();
				count=0;
			}
			
			t2 = System.currentTimeMillis();
		}
		
		System.out.println("total time : "+(t2-t1));
		stmt.close();
		conn.close();
		return "Data inserted sucessfully!!";
	}
	
}
