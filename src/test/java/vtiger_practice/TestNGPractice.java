package vtiger_practice;

import org.testng.annotations.Test;

public class TestNGPractice {

	@Test(priority =1)
	public void createCustomer()
	{
		System.out.println("customer created");
	}
	
	@Test(priority =-2) //lowest priority executed first
	public void modifyCustomer()
	{
		System.out.println("customer modified");
	}
	
	@Test       //zero is the default priority
	public void deleteCustomer()
	{
		System.out.println("customer deleted");
	}
}
