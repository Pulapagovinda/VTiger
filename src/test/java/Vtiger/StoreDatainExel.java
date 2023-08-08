package Vtiger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class StoreDatainExel {

	public static void main(String[] args) throws Throwable {
		//Load the file in java readable Format
		FileInputStream fis = new FileInputStream("C:\\Users\\pulap\\eclipse-workspace\\Vtiger\\src\\test\\resources\\TestData.xlsx");
		
		//Create a workBook for the file Loaded
		Workbook wb =WorkbookFactory.create(fis);
		
		//Create Sheet
		Sheet sh=wb.getSheet("Trail");
		
		//Create Row
		Row rw=sh.createRow(3);
		
		//Create Cell
		Cell ce=rw.createCell(3);
		
		//set the value into cell
		ce.setCellValue("Ant Man");
		
		FileOutputStream fos=new FileOutputStream("C:\\\\Users\\\\pulap\\\\eclipse-workspace\\\\Vtiger\\\\src\\\\test\\\\resources\\\\TestData.xlsx");
	
		//call the write method
		   wb.write(fos);
		   
	    //close the work book
		   wb.close();
		   
		   	System.out.println("WorkBook Closed");
	
	}

}
