package vtiger_practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Assertions2 {
	@Test
	public void sampleTest() {

	int a=1;//expected
	int b=2;//actual
	
	System.out.println("step 1");
	System.out.println("step 2");

	Assert.assertEquals(a, b);//pass//fail
	
	System.out.println("step 3");
	System.out.println("step 4");

	System.out.println("Execution and validation completed");
}
}