package Vtiger;

import java.io.FileInputStream;

import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReaddataFromExelSheet {

	public static void main(String[] args) throws Throwable {
		//Load the file in java readable Format
		FileInputStream fis = new FileInputStream("C:\\Users\\pulap\\eclipse-workspace\\Vtiger\\src\\test\\resources\\TestData.xlsx");
		
		//Create a workBook for the file Loaded
		Workbook wb =WorkbookFactory.create(fis);
		
		String value=wb.getSheet("Organizations").getRow(1).getCell(2).getStringCellValue();
		System.out.println(value);
	}

}
