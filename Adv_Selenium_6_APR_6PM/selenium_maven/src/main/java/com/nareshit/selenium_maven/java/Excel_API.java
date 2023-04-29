package com.nareshit.selenium_maven.java;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_API {

	public FileInputStream fi = null;
	public FileOutputStream fo = null;
	public XSSFWorkbook w = null;
	public XSSFSheet s = null;
	public XSSFRow r = null;
	public XSSFCell c = null;
	String filepath;

	public Excel_API(String file) throws Exception {
		this.filepath = file;
		fi = new FileInputStream(filepath);
		w = new XSSFWorkbook(fi);
	}

	// Reading cell data from excel by using column index.
	public String getCellData(String sheetname, int colnum, int rownum) {
		try {
			s = w.getSheet(sheetname);
			r = s.getRow(rownum);
			c = r.getCell(colnum);
			if (c.getCellTypeEnum() == CellType.STRING) {
				return c.getStringCellValue();
			} else if (c.getCellTypeEnum() == CellType.NUMERIC || c.getCellTypeEnum() == CellType.FORMULA) {
				return String.valueOf(c.getNumericCellValue());
			} else if (c.getCellTypeEnum() == CellType.BLANK) {
				return " ";
			} else {
				return String.valueOf(c.getBooleanCellValue());
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "No matching value";
		}
	}

	// Reading cell data from excel by using column name.
	public String getCellData(String sheetname, String colname, int rownum) {
		try {
			int colnum = -1;
			s = w.getSheet(sheetname);
			r = s.getRow(0);
			for (int i = 0; i < r.getLastCellNum(); i++) {
				if (r.getCell(i).getStringCellValue().equalsIgnoreCase(colname)) {
					colnum = i;
				}
			}
			r = s.getRow(rownum);
			c = r.getCell(colnum);
			if (c.getCellTypeEnum() == CellType.STRING) {
				return c.getStringCellValue();
			} else if (c.getCellTypeEnum() == CellType.NUMERIC || c.getCellTypeEnum() == CellType.FORMULA) {
				return String.valueOf(c.getNumericCellValue());
			} else if (c.getCellTypeEnum() == CellType.BLANK) {
				return " ";
			} else {
				return String.valueOf(c.getBooleanCellValue());
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "no matching value";
		}
	}

	// Writing cell data to excel file using column index.
	public boolean setCellData(String sheetname, int colnum, int rownum, String value) throws Exception {
		try {
			s = w.getSheet(sheetname);
			r = s.getRow(rownum);
			c = r.getCell(colnum);
			if (r == null)
				r = s.createRow(rownum);
			if (c == null)
				c = r.createCell(colnum);
			c.setCellValue(value);
			fo = new FileOutputStream(filepath);
			w.write(fo);
			fo.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	// Writing cell data to excel file using column name.
	public boolean setCellData(String sheetname, String colname, int rownum, String value) throws Exception {
		try {
			int column = -1;
			s = w.getSheet(sheetname);
			r = s.getRow(0);
			for (int i = 0; i < r.getLastCellNum(); i++) {
				if (r.getCell(i).getStringCellValue().equalsIgnoreCase(colname)) {
					column = i;
				}
			}
			r = s.getRow(rownum);
			if (r == null)
				s.createRow(rownum);
			c = r.getCell(column);
			if (c == null)
				c = r.createCell(column);
			c.setCellValue(value);
			fo = new FileOutputStream(filepath);
			w.write(fo);
			fo.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// Identify no.of rows and no.of columns in excel file.
	public int getRows(String sheetname) {
		s = w.getSheet(sheetname);
		int rowcount = s.getLastRowNum() - s.getFirstRowNum();
		return rowcount;
	}

	public int getColumns(String sheetname) {
		s = w.getSheet(sheetname);
		r = s.getRow(0);
		int colcount = r.getLastCellNum();
		return colcount;
	}

}
