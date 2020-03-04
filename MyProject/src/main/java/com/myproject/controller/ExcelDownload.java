package com.myproject.controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.myproject.model.Destination;

public class ExcelDownload {

@SuppressWarnings({ "resource", "rawtypes" })
public static ByteArrayInputStream destinationListToExcel(List<Destination> dest){
	
	
	
		String[] COLUMNs = { "Country Name", "City Name" };

		XSSFWorkbook workbook = new XSSFWorkbook(); 
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		
		try {
			Sheet sheet = (Sheet) workbook.createSheet("Destinations");

			Font headerFont = workbook.createFont();
			headerFont.setBold(true);
			headerFont.setColor(IndexedColors.BLUE.getIndex());

			CellStyle headerCellStyle = workbook.createCellStyle();
			headerCellStyle.setFont(headerFont);
			headerCellStyle.setWrapText(true);

			// Row for Header
			Row headerRow =  ((org.apache.poi.ss.usermodel.Sheet) sheet).createRow(0);
			((XSSFSheet) sheet).addMergedRegion(new CellRangeAddress(0,0,2,4));
			// Header
			for (int col = 0; col < COLUMNs.length; col++) {
				Cell cell = headerRow.createCell(col);
				cell.setCellValue(COLUMNs[col]);
				cell.setCellStyle(headerCellStyle);
				((XSSFSheet) sheet).autoSizeColumn(col);
			}

			int rowIdx = 1;

			
			for (Destination req : dest) {
				Row row = ((XSSFSheet) sheet).createRow(rowIdx++);

				row.createCell(0).setCellValue(req.getCountryName());
				row.createCell(1).setCellValue(req.getCityName());
				
				
			}

			workbook.write(out);
			return new ByteArrayInputStream(out.toByteArray());
		}
		catch(Exception e) {
			return null;
		}		
	}
}
