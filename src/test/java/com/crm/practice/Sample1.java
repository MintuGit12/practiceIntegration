package practice;

import org.testng.annotations.Test;

@Test
public class Sample1 {
	@Test(priority = 1,invocationCount = 3)
	public void createCustomer()
	{
		System.out.println("customer detail created");
	}
	@Test(priority = -1,dependsOnMethods = "createCustomer")
	public void modifyCustomer()
	{
		System.out.println("customer detail modified");
	}
	@Test(priority = 0 ,dependsOnMethods = "createCustomer")
	public void deleteCustomer()
	{
		System.out.println("customer detail deleted");
	}
}
