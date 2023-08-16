package vtiger_practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.formula.WorkbookEvaluator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelSheet {
public static void main(String[] args) throws Throwable {
	
	//step1:Load the document in java readable format
	FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
	
	//2:create the workbook for the file loaded
	 Workbook wb = WorkbookFactory.create(fis);
	 
	 //3:navigate to required sheet
	 Sheet sh = wb.getSheet("Contacts");

	 //4:navigate to required row
	 Row rw = sh.getRow(1);
	 
	 //5:navigate to required cell
	Cell ce = rw.getCell(2);
	
	//capture the value inside the cell
	String value = ce.getStringCellValue();
	System.out.println(value);
	
	 
	 
	
}
}
