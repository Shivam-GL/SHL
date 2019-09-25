package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcel {
	private FileInputStream fis;
	private FileOutputStream fileOutputStream;
	private XSSFWorkbook workbook;
	private XSSFRow row;
	private XSSFSheet sheet;
	private String filename;
	private File file;
	public WriteExcel(String excelPath) {
		filename = excelPath;
		workbook = new XSSFWorkbook();
		sheet = workbook.createSheet("FirstSheet"); 

	}

	//entering data in excel
	public void createExcel() {

		try {

			fileOutputStream = new FileOutputStream(filename);
			workbook.write(fileOutputStream);
			fileOutputStream.close();

		} 
		catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void enterExcelData(String excelPath,String sheetName,int rowIndex,int colIndex,String data) {
		try {	
			file=new File(excelPath);
			fis=new FileInputStream(file);
			workbook=new XSSFWorkbook(fis);
			XSSFSheet sheet1 = workbook.getSheet(sheetName);
			if(sheet1.getRow(rowIndex)==null) {
				sheet1.createRow(rowIndex).createCell(colIndex).setCellValue(data);
			}
			else {
				sheet1.getRow(rowIndex).createCell(colIndex).setCellValue(data);
			}
			fileOutputStream = new FileOutputStream(excelPath);
			workbook.write(fileOutputStream);
			fileOutputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	} 
}
