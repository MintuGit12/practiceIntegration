package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Sample2
{
	@Test
	public void createCustomerTest()
	{
		System.out.println("customer detail created");
		//Assert.fail();
	}
	@Test(dependsOnMethods = "createCustomerTest")
	public void modifyCustomerTest()
	{
		System.out.println("customer detail modified");
	}
	@Test(dependsOnMethods = "createCustomerTest")
	public void deleteCustomerTest()
	{
		System.out.println("customer detail deleted");
	}
}
