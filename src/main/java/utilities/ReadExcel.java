package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;




public class ReadExcel {
	File file;
	FileInputStream fileInputStream;
	XSSFWorkbook workbook;
	XSSFRow row;
	XSSFCell cell;
    XSSFSheet sheet;
    
	public int no_of_rows;
	
	//getting number of rows in excel sheet
	public int count_row() {
		return (sheet.getLastRowNum()-sheet.getFirstRowNum());	
	}
	
	//getting url from excel

	
	//getting browser from excel
	public String readData(String excelPath,String sheetName,int rowIndex,int colIndex) {
		String browser = null;
		try {
		file=new File(excelPath);
		fileInputStream=new FileInputStream(file);
		workbook=new XSSFWorkbook(fileInputStream);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rowIndex);
		cell=row.getCell(colIndex);
		browser=cell.getStringCellValue();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return browser;		
}
	
}
