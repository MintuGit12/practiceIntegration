package com.crm.Generic_utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class Excel_Utility {
	/**
	 * This method is used to fetch data from excel sheet
	 * @param path
	 * @param sheet
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
public String getExcelData(String sheet,int row,int cell) throws EncryptedDocumentException, IOException
{
	FileInputStream fis=new FileInputStream(iPathConstant.EXCELFILE_PATH);
	Workbook wb = WorkbookFactory.create(fis);
	/*Sheet s = wb.getSheet(sheet);
	Cell c = s.getRow(row).getCell(cell);
	String val = c.getStringCellValue();
	return val;*/
	DataFormatter format=new DataFormatter();
	String data = format.formatCellValue(wb.getSheet(sheet).getRow(row).getCell(cell));
	return data;
}
}
