package vtiger_practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG4 {
	@Test
	public void createCustomer()
	{
		Assert.fail();//purposefully fail the script
		System.out.println("customer created");
	}
	
	@Test(dependsOnMethods = "createCustomer")
	public void modifyCustomer()
	{
		System.out.println("customer modified");
	}
	
	@Test()
	public void deleteCustomer()
	{
		System.out.println("customer deleted");
	}
}
