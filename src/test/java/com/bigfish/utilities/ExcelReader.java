package com.bigfish.utilities;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelReader {
	
	public ExcelReader() {
	}
	
	public ArrayList<String> ReadExcelData(int colNo, String excelFile) throws IOException {
		String systemPath = PropertiesOperation.getRadicalValueBykey("SystemPath");
			FileInputStream Ex_File = new FileInputStream(""+systemPath+"//BigFishAuto//src//test//resources//documents//"+excelFile+"");
			XSSFWorkbook wb = new XSSFWorkbook(Ex_File);
			XSSFSheet s = wb.getSheet("Sheet1");
			Iterator<Row>  rowIterator = s.iterator();
			rowIterator.next();
			ArrayList<String> List  = new ArrayList<String>();
			while(rowIterator.hasNext())
			{
				List.add(rowIterator.next().getCell(colNo).getStringCellValue());
			}
		
		return List;
		
	}

}