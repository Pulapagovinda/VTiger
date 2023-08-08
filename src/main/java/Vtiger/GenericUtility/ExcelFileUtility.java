package Vtiger.GenericUtility;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * This class consist of all Generic Methods Related to java
 * @author pulapa Govinda
 *
 */
public class ExcelFileUtility

{
/**
 * This method will read data from excel sheet based on sheetname, row, cell,
 * @param key
 * @param row
 * @param cell
 * @return
 * @throws Throwable
 */
	public String getDatafromExelFile(String key,int row,int cell) throws Throwable
	{
      FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		Workbook wb =WorkbookFactory.create(fis);
		String value=wb.getSheet(key).getRow(row).getCell(cell).getStringCellValue();
		
		return value;
		
	}
	/**
	 * This method will write data into excel file
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @throws Throwable
	 */
	public void writeDatafromExelFile(String sheetName,int rowNo, int cellNo ,String Data ) throws Throwable
	{
		   FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
			
			Workbook wb =WorkbookFactory.create(fis);
			
			Sheet sh=wb.createSheet(sheetName);
			
			Row rw=sh.createRow(rowNo);
			
			Cell ce=rw.createCell(cellNo);
			
			ce.setCellValue(Data);
			
			FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
			
			wb.write(fos);
			
			wb.close();
	}

}
