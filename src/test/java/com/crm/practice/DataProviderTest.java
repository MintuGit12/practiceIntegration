package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderTest
{
	static {
		System.setProperty("webdriver.chrome.driver","./chromedriver.exe");
	       }
	
	@Test(dataProvider = "dataProv_test")
public void companyDetails(String first,String last)//String first,String last
{
		WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.get("http://localhost:8888/");
	driver.findElement(By.name("user_name")).sendKeys("admin");
	driver.findElement(By.name("user_password")).sendKeys("admin");
	driver.findElement(By.id("submitButton")).click();
	driver.findElement(By.xpath("//a[text()='Contacts']")).click();
	driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	driver.findElement(By.name("firstname")).sendKeys(first);
	driver.findElement(By.name("lastname")).sendKeys(last);
	driver.findElement(By.xpath("//input[@class=\"crmButton small save\"]")).click();
}
	@DataProvider
	public Object[][] dataProv_test()
	{
		Object[][] arr=new Object[3][2];
		arr[0][0]="Abhay";
		arr[0][1]="Singh";
		
		arr[1][0]="Arun";
		arr[1][1]="kumar";
		
		arr[2][0]="Vijay";
		arr[2][1]="Singh";
		return arr;
		
	}
}
