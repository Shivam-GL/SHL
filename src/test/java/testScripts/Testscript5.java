package testScripts;

import org.testng.annotations.Test;

import utilities.Constants;
import utilities.ReadExcel;
import utilities.WriteExcel;

public class Testscript5 {
	private WriteExcel write;
	private ReadExcel read;
	String sheetName = "FirstSheet";
	@Test
	public void test1() {
		// creating excel file
		write=new WriteExcel(Constants.EXCELPATH2);
		//entering data in excel
		write.createExcel();
		//reading excel
		write.enterExcelData(Constants.EXCELPATH2,sheetName, 0,0, "Name");
		write.enterExcelData(Constants.EXCELPATH2,sheetName, 0,1, "Company");
		write.enterExcelData(Constants.EXCELPATH2,sheetName, 1,0, "Shivam");
		write.enterExcelData(Constants.EXCELPATH2,sheetName, 1,1, "GlobalLogic");
		read=new ReadExcel();
		System.out.println(read.readData(Constants.EXCELPATH2,sheetName, 0,0)+" "+read.readData(Constants.EXCELPATH2,sheetName, 1,0));
		System.out.println(read.readData(Constants.EXCELPATH2,sheetName, 0,1)+" "+read.readData(Constants.EXCELPATH2,sheetName, 1,1));
	}
}
