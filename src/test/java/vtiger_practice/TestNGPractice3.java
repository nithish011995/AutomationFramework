package vtiger_practice;

import org.testng.annotations.Test;

public class TestNGPractice3 {

	@Test(invocationCount = 3,priority =1)//1st priority will exexute then invocation
	public void createCustomer()
	{
		System.out.println("customer created");
	}
	
	@Test//if there is no priority then execution done by order os ascii value
	public void modifyCustomer()
	{
		System.out.println("customer modified");
	}
	
	@Test      
	public void deleteCustomer()
	{
		System.out.println("customer deleted");
	}
}
