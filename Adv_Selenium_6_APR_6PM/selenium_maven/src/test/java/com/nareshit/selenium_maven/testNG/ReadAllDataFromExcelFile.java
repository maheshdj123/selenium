package com.nareshit.selenium_maven.testNG;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadAllDataFromExcelFile {

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
		int rowcount = s.getLastRowNum() - s.getFirstRowNum();
		System.out.println(rowcount);
		for (int i = 1; i <= rowcount; i++) {//1,2,3,4,5,6
			r = s.getRow(i);
			for (int j = 0; j < r.getLastCellNum(); j++) {//0,1
				System.out.println(r.getCell(j).getStringCellValue());
			}
			System.out.println();
		}
	}
}
