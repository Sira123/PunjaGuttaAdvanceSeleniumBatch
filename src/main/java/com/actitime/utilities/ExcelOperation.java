package com.actitime.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelOperation {
	public static String readData(String SheetName,int rownum,int cellnum) throws EncryptedDocumentException, InvalidFormatException, IOException 
	{
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//testdata/userdata.xlsx");
	Workbook w1 = WorkbookFactory.create(fis);
	String s=w1.getSheet(SheetName).getRow(rownum).getCell(cellnum).getStringCellValue();
	return s;
	}
public static void writeData(String SheetName,int rownum,int cellnum,String data) throws EncryptedDocumentException, InvalidFormatException, IOException {
	FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//testdata/userdata.xlsx");
	Workbook w1 = WorkbookFactory.create(fis);
	w1.getSheet(SheetName).getRow(rownum).createCell(cellnum).setCellValue(data);
	FileOutputStream fos=new FileOutputStream(System.getProperty("user.dir")+"//testdata/userdata.xlsx");
	w1.write(fos);
}

}
