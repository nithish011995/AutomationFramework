package vtiger_practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGDataProvider {
//@Test(dataProvider ="methodname")
	@Test(dataProvider ="getData")
	public void addToCartTest(String name,int price,String model)
	{
		System.out.println("Phone name is "+name+ "price is " +price+ " model name is"+model);
	}
	
	@DataProvider
	//synatx:public Object[][] methodname
	public Object[][] getData()
	{							//row column
		Object[][] data =new Object[3][3];//total count or limitations
		
		data[0][0]="Iphone";	//1st set of Data
		data[0][1]=20000;
		data[0][2]="S13";
		
		data[1][0]="Samsung";	//1st set of Data
		data[1][1]=15000;
		data[1][2]="S13";
		
		data[2][0]="Vivo";	//3rd set of Data
		data[2][1]=10000;
		data[2][2]="Y21";
		return data;
		
	}
}
