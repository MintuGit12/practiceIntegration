package practice;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionEx {
/*@Test(dataProvider = "dataProEx1")
public void m1(String coun,String cap)
{
	System.out.println("assertion ex ");
	System.out.println("assertion ex with data provider");
	Assert.assertEquals("coun", "cap");
	System.out.println("assertion ex completed");
	System.out.println("will not run 1");
	System.out.println("will not run 2");

}*/
@Test(dataProvider = "dataProEx1")
public void m2(String coun,String cap)
{
	System.out.println("Softassertion ex ");
	System.out.println("Softassertion ex with data provider");
	SoftAssert s=new SoftAssert();
	s.assertEquals("cap", "cap");
	System.out.println("Softassertion ex completed");
	System.out.println("Soft will run 1");
	s.assertAll();
	System.out.println("Soft will run 2");

}
@DataProvider
public Object[][] dataProEx1()
{
Object[][] ob= {{"India","Delhi"}};
return ob;	
}
}
