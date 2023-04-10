package excelReader;
//
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadXcelFile {

	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		
		FileInputStream fis = new FileInputStream(new File("PersonalData.xlsx"));
		//creating Workbook 
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		List<XcelContent> contentList = new ArrayList<XcelContent>();
		
		//creating sheet 
		XSSFSheet sheet = wb.getSheetAt(0);
		Iterator<Row> itr = sheet.iterator();
		List<XcelContent> fullData = new ArrayList<XcelContent>();
		 try {
		while(itr.hasNext()) {
			Row rw = itr.next();
		 Iterator<Cell> cellItr = rw.cellIterator();
		 List<String> datalist = new ArrayList<String>();
		 while(cellItr.hasNext()) {
			 Cell cell = cellItr.next();
			 
				switch(cell.getCellType()) {
				 
				 case Cell.CELL_TYPE_NUMERIC:
					datalist.add(Double.toString(cell.getNumericCellValue()));
//					 System.out.print(cell.getNumericCellValue()+"\t\t\t");
					 break;
				 case Cell.CELL_TYPE_STRING:
					 datalist.add(cell.getStringCellValue());
//					 System.out.print(cell.getStringCellValue()+"\t\t\t");
					 break;
					  
				 default:
						 break;
				 }
			 }

		 XcelContent content= new XcelContent(datalist.get(0),datalist.get(1),datalist.get(2),datalist.get(3));
		 fullData.add(content);
			 System.out.println("");
		 }
		} catch (Exception e) {
			e.printStackTrace();
		}
		 System.out.println(new SaveXcelData().saveData(fullData));
		 
		}
		
	}

