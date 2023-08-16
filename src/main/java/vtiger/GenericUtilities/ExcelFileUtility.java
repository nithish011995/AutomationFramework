package vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Iterator;

import javax.imageio.stream.FileImageInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class consists of generic methods related to excel file
 * @author Nithish
 *
 */

public class ExcelFileUtility {
	/**
	 * This method will read data from excel sheet based on sheet name, row no 
	 * and cell no given by caller
	 * @param sheetName
	 * @param rowNo
	 * @param celNo
	 * @return value
	 * @throws Throwable
	 */
	
	public String getDataFromExcel(String sheetName,int rowNo,int celNo) throws Throwable {
	FileInputStream fis=new FileInputStream(IConstants.excelFilePath);
	Workbook wb = WorkbookFactory.create(fis);
	String value = wb.getSheet(sheetName).getRow(rowNo).getCell(celNo).getStringCellValue();
	wb.close();
	return value;
	
	}
	/**
	 * This method will write data into the excel sheet
	 * @param sheetName
	 * @param rowNo
	 * @param celNo
	 * @param data
	 * @throws Throwable
	 */
	
	public void writeDataFromExcel(String sheetName,int rowNo,int celNo,String data) throws Throwable {
		FileInputStream fis=new FileInputStream(IConstants.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.createSheet(sheetName);
		Row rw = sh.createRow(rowNo);
		Cell cl = rw.createCell(celNo);
		cl.setCellValue(data);
		
		FileOutputStream fos = new FileOutputStream(IConstants.excelFilePath);
		wb.write(fos);//action so no return
		wb.close();
	}
	
	/**
	 * This method will read the data inside a sheet in data providers
	 * @param sheetName
	 * @return 
	 * @throws Throwable
	 */
	
	public Object[][] readMultipleData(String sheetName) throws Throwable
	{
		FileInputStream fis=new FileInputStream(IConstants.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int lastRow = sh.getLastRowNum();//capture no of rows
		int lastcell = sh.getRow(0).getLastCellNum();// capture no of cell
		
		Object[][] data=new Object[lastRow][lastcell];
		
		for(int i=0;i<lastRow;i++)//for row navigation
		{
			for(int j=0;j<lastcell;j++)//for cell navigation
			{
				data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		return data;
	}
}
