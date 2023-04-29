package com.nareshit.selenium_maven.testNG;

import org.testng.annotations.Test;
import com.nareshit.selenium_maven.java.Excel_API;

public class ReadExcelDataByExcel_API {
	@Test
	public void f() throws Exception {
		Excel_API e = new Excel_API("D:\\Workspaces\\Adv_Selenium_6_APR_6PM\\selenium_maven\\testdata\\login.xlsx");
		System.out.println("-----Reading data from excel file by using column num-----");
		System.out.println(e.getCellData("Sheet1", 0, 6));
		System.out.println(e.getCellData("Sheet1", 1, 6));
		System.out.println(e.getCellData("Sheet1", 2, 6));
		System.out.println("-----Reading data from excel file by using column name-----");
		System.out.println(e.getCellData("Sheet1", "Username", 2));
		System.out.println(e.getCellData("Sheet1", "Password", 2));
		System.out.println(e.getCellData("Sheet1", "Results", 2));
		System.out.println("------writting cell data by using col index------");
		System.out.println(e.setCellData("Sheet1", 2, 1, "SKIPPED"));
		System.out.println("------writting cell data by using col name------");
		System.out.println(e.setCellData("Sheet1", "Results", 5, "SUCCESS"));
		System.out.println("No.of rows in excel:" + e.getRows("Sheet1"));
		System.out.println("No.of columns in excel:" + e.getColumns("Sheet1"));
	}
}
