package vtiger_practice;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGPractice2 {

	@Test
	public void createCustomer()
	{
		Assert.fail();//purposefully fail the script
		System.out.println("customer created");
	}
	
	@Test(priority =-2) 
	public void modifyCustomer()
	{
		System.out.println("customer modified");
	}
	
	@Test(enabled=false)//to disabled the script
	public void deleteCustomer()
	{
		System.out.println("customer deleted");
	}
}
