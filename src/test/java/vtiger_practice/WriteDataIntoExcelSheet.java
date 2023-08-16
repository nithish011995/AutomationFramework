package vtiger_practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

//only for interview puropse means in real time we will write directlyin excel sheet

public class WriteDataIntoExcelSheet {
	public static void main(String[] args) throws Throwable {
		
		//step1:Load the document in java readable format
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		//2:create the workbook for the file loaded
		 Workbook wb = WorkbookFactory.create(fis);
		 
		 //3:create sheet
		 Sheet sh = wb.createSheet("Trail");
		 
		 //4:create row
		 Row rw = sh.createRow(4);
		 
		 //5:create cell
		 Cell cl = rw.createCell(3);
		 
		 //6:set the value into the cell
		 cl.setCellValue("kabaddi");
		 
		 //7: open the file in java write format
		 FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
		 
		 //8: call the write method
		 wb.write(fos);
		 System.out.println("data added");
		 
		 //9:close the workbook
		 wb.close();
		 System.out.println("workbook closed");
	
	
	
	
	}
}
