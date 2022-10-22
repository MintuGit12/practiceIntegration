package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderEx {
@Test(dataProvider = "dataProvider")
	public void location(String src,String dest)
	{
	System.out.println("location is from :"+src+"to :"+dest);
	}
	@DataProvider
	public Object[][] dataProvider()
	{
		Object[][] obj=new Object[5][2];
		obj[0][0]="Banglore";
		obj[0][1]="Mysore";
		obj[1][0]="Pune";
		obj[1][1]="West Bengal";
		obj[2][0]="Bihar";
		obj[2][1]="UP";
		obj[3][0]="Rajsthan";
		obj[3][1]="UK";
		obj[4][0]="USA";
		obj[4][1]="China";
		return obj;
	}
}
/*package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderEx1 {
@Test(dataProvider ="dataProEx")
	public void test1(String index,String value)
	{
System.out.println(index+" is the capital "+value);		
	}
	@DataProvider
public Object[][] dataProEx() throws IOException
{
		Scanner sc=new Scanner(System.in);
		FileInputStream fis=new FileInputStream("./common_data.property");
		Properties p=new Properties();
		p.load(fis);
	Object[][] ob= new Object[4][2];
	for(int i=0;i<ob.length;i++)
	{
		System.out.println("enter the key ");
		String key=sc.next();
		ob[i][0]=i;
		ob[i][1]=p.getProperty(key);
	}
	return ob;
}
}
*/