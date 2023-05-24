package com.inetbanking.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {
  
	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static int getRowCount(String path, String sheetName) throws IOException {
		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		workbook.close();
		fis.close();
		return rowCount;
	}
	
	public static int getCellCount(String path, String sheetName, int rowNum) throws IOException {
		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		int cellCount = row.getLastCellNum();
		workbook.close();
		fis.close();
		return cellCount;
	}
	
	public static String getCellData(String path, String sheetName, int rowNum, int colNum) throws IOException {
	
		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		cell = row.getCell(colNum);
		
		DataFormatter dataFormatter = new DataFormatter();
		String data = "";
		data = dataFormatter.formatCellValue(cell);
		
		workbook.close();
		fis.close();
		return data;
	}
//	
//	public void setCellData(String sheetName, int rowNum, int colNum, String data) throws IOException {
//		
//		fis = new FileInputStream(path);
//		workbook = new XSSFWorkbook(fis);
//		sheet = workbook.getSheet(sheetName);
//		row = sheet.getRow(rowNum);
//		cell = row.createCell(colNum);
//		cell.setCellValue(data);
//		fos = new FileOutputStream(path);
//		workbook.write(fos);
//		workbook.close();
//		fis.close();
//		fos.close();
//	}	
//	
//	public void fillGreenColor(String sheetName, int rowNum, int colNum) throws IOException {
//		fis = new FileInputStream(path);
//		workbook = new XSSFWorkbook(fis);
//		sheet = workbook.getSheet(sheetName);
//		row = sheet.getRow(rowNum);
//		cell = row.getCell(colNum);
//		style = workbook.createCellStyle();
//		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
//		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
//		cell.setCellStyle(style);
//		workbook.write(fos);
//		workbook.close();
//		fis.close();
//		fos.close();
//	}
	
}
