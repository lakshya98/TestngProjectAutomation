package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;

public class excelData {
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	public  excelData(String workbookpath,String sheetpath) {
		try {
			workbook = new XSSFWorkbook(workbookpath);
			sheet = workbook.getSheet(sheetpath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static int getRowCount() {
		int rowCount = 0;
		try {

		rowCount = sheet.getPhysicalNumberOfRows();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return rowCount;
	}
	
	public static int getColCount() {
		int colCount=0;
		try {
		colCount = sheet.getRow(0).getPhysicalNumberOfCells();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return colCount;
	}
	
	public static String getRowDataString(int row,int col) { 
		String rowData = null;
		try {
		rowData = sheet.getRow(row).getCell(col).getStringCellValue();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return rowData;
	}
	
	public static Double getRowDataNumeric(int row,int col) {
		Double colData = null;
		try {
		colData = sheet.getRow(row).getCell(col).getNumericCellValue();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return colData;
	}
}
