package com.nareshit.selenium_maven.testNG;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadDatFromExcelFile {

	public FileInputStream fi;
	public XSSFWorkbook w;
	public XSSFSheet s;
	public XSSFRow r;
	public XSSFCell c;

	@Test
	public void f() throws Exception {
		fi = new FileInputStream("D:\\Workspaces\\Adv_Selenium_6_APR_6PM\\selenium_maven\\testdata\\login.xlsx");
		w = new XSSFWorkbook(fi);
		s = w.getSheet("Sheet1");
		r = s.getRow(3);
		c = r.getCell(0);
		System.out.println(c.getStringCellValue());
	}
}
