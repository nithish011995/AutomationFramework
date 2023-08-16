package vtiger.GenericUtilities;

import java.util.Date;
import java.util.Random;

/**
 * This class consists of all generic methods related to java
 * @author Nithish R
 * 
 */
public class JavaUtilty {
/**
 * This method will generate a random number for every execution
 * @return Random value
 */
	public int getRandomNumber() {
		Random r = new Random();
		int ran = r.nextInt(1000);
		return ran;
		
	}
/**
 * This method will generate the system date
 * @return
 */
public String getSystemDate(){
	Date d=new Date();
	String date = d.toString();
	return date;
	
}

public String getSystemDateFormat() {
	Date d=new Date();
	String[] date = d.toString().split(" ");
	String currentDate = date[2];
	String month = date[1];
	String year = date[5];
	String time = date[2].replace(":", "-");
	
	String dateInFormat=currentDate+"_"+month+"_"+year+"_"+time;
	return dateInFormat;

}
}