package vtiger_practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertions3 {
	@Test
	public void sampleTest() {
		SoftAssert sa=new SoftAssert();
	int a=1;//expected
	int b=2;//actual
	
	System.out.println("step 1");
	sa.assertEquals(false, true);//fail
	System.out.println("step 2");

	Assert.assertEquals(a, b);//pass//fail
	
	System.out.println("step 3");
	System.out.println("step 4");
	sa.assertTrue(false);//fail

	System.out.println("Execution and validation completed");
	sa.assertAll();//logging all the failures
}
}
