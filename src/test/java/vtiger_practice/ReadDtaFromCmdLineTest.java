package vtiger_practice;

import org.testng.annotations.Test;

public class ReadDtaFromCmdLineTest {

	@Test
	public void read()
	{
		String un = System.getProperty("username");
		System.out.println(un);
		String pwd = System.getProperty("password");
		System.out.println(pwd);
	}
}
