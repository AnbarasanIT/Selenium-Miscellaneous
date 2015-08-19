package com.anbj.test.java;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

/**
 * 
 * @author Anbarasan J
 * @version 1.0 :8/13/2014
 *
 */

public class ReadWriteExcelSheet {
	
	/**
	 * <p>Method which is used for reading a data from the Excel sheets</p>
	 * @param location
	 * @param sheetname
	 * @return
	 */
	public static String[][] getXLData(String location, String sheetname)
	{
		Workbook w = null;
		try {
			w = Workbook.getWorkbook(new File(location));
		
			} catch (BiffException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		Sheet s = w.getSheet(sheetname);
		String a[][] = new String[10][10];
			try
				{
				int columns=s.getColumns();
				int rows=s.getRows();
				for (int j=0;j<s.getColumns();j++)
					{
					for (int i=0;i<s.getRows();i++)
					 {
						a[j][i] = s.getCell(j, i).getContents();
						System.out.println(j+" and "+i+" "+a[j][i]);
					 }
				    }
				
			}
		catch(Exception e)
		{
		e.printStackTrace();
		}
		return a;
	}
	/**
	 * <p>Method which is used for Write a data to the Excel sheets</p>
	 * @param location
	 * @param text
	 * @param sheetName
 */
	public static void writeExcelSheets(String location ,String text,String sheetName) 
	{ 
		try
		{
			FileOutputStream f = new FileOutputStream(location,true);
			WritableWorkbook book = Workbook.createWorkbook(f); 
			WritableSheet sheet = book.createSheet(sheetName, 0);
			Label l = new Label(0, 0, text);
			sheet.addCell(l);
			book.write(); 
			book.close(); 
		}
		catch (Exception e)
			{
			e.printStackTrace();
			}
		}
	

	public static void main(String a[]){
		//getXLData("C:/ExcelSheets/ObjectLocator.xls","Login");
		writeExcelSheets("C:/ExcelSheets/","userName","NewSheet");

}
	}


