package com.automation.utilties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {

	XSSFWorkbook wb;
	

	public ExcelDataProvider()
	
	{        
		 
		File f = new File("C:/AutomationPractice/Framework/TestData/Data.xlsx");
		

		try {
			FileInputStream fstream = new FileInputStream(f);

				 wb = new XSSFWorkbook(fstream);
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to read excel file" +e.getMessage());
		}

		
	}

	public String getStringData(int sheetIndex, int row, int col) {
		 
		return  wb.getSheetAt(sheetIndex).getRow(row).getCell(col).getStringCellValue();
		 
	}

	public String getStringData(String sheetName, int row, int col) {
	
		return  wb.getSheet(sheetName).getRow(row).getCell(col).getStringCellValue();
	}

	public double getNumericData(String sheetName, int row, int col) {
		return wb.getSheet(sheetName).getRow(row).getCell(col).getNumericCellValue();
	}
}
