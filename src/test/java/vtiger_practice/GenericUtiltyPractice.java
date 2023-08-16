package vtiger_practice;

import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.JavaUtilty;
import vtiger.GenericUtilities.PropertyFileUtility;

public class GenericUtiltyPractice {
public static void main(String[] args) throws Throwable {
	
	JavaUtilty jUtil=new JavaUtilty();
	int value = jUtil.getRandomNumber();
	System.out.println(value);
	
	System.out.println(jUtil.getSystemDate());

	System.out.println(jUtil.getSystemDateFormat());
	PropertyFileUtility pUtil = new PropertyFileUtility();
	System.out.println(pUtil.getDataFromPrpertyFile("browser"));
	System.out.println(pUtil.getDataFromPrpertyFile("url"));
	System.out.println(pUtil.getDataFromPrpertyFile("username"));
	//or
	//String value1 = pUtil.getDataFromPrpertyFile("username");
	//System.out.println(value1);
	System.out.println(pUtil.getDataFromPrpertyFile("password"));
	
	ExcelFileUtility eUtil = new ExcelFileUtility();
	String data = eUtil.getDataFromExcel("Organization", 1, 2);
	System.out.println(data);
	
	eUtil.writeDataFromExcel("sample", 3, 4, "nithi");
	System.out.println("data added");
}
}

