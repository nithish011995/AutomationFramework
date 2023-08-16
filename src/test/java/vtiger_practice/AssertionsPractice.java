package vtiger_practice;

import org.testng.annotations.Test;
//in this prg even condtiton fails the script will run so for validation 
//we should go to assertion instead of if else condtion
public class AssertionsPractice {

	@Test
	public void sampleTest()
	{
		int a=1;
		int b=2;
		if(a==b)
		{
			System.out.println("pass");
		}
		else {
			System.out.println("fail");
		}
	}
	
}
