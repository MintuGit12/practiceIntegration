package com.crm.Generic_utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;
import com.crm.Object_Repository.HomePage;
import com.crm.Object_Repository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
public WebDriver driver;
public static WebDriver sDriver;
static {
	System.setProperty("webdriver.chrome.driver","./chromedriver.exe");
	System.setProperty("webdriver.gecko.driver","./geckodriver.exe");
	System.setProperty("webdriver.edge.driver","./msedgedriver.exe");
}
	@BeforeSuite
public void BS()
{
	//System.out.println("database connection");
}
	@BeforeTest
public void BT()
{
	//System.out.println("run in parellel mode");
}
	@Parameters("browser")
	@BeforeClass(groups = {"smokeTest","regressionTest"})
	//public void BC(String browser) throws IOException//for cross browser tessting
public void BC() throws IOException
{
		 File_Utility flib=new File_Utility();
			String browser=flib.getPropertyKeyValue("browser");
if(browser.equalsIgnoreCase("chrome"))
{
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
}
else if(browser.equalsIgnoreCase("firefox"))
{
	WebDriverManager.firefoxdriver().setup();
	driver=new FirefoxDriver();
}
else if(browser.equalsIgnoreCase("edge"))
{
	//WebDriverManager.edgedriver().setup();
	driver=new EdgeDriver();
}
else
{
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
}
sDriver=driver;
}
	@BeforeMethod(groups = {"smokeTest","regressionTest"})
public void BM() throws IOException
{
		File_Utility flib=new File_Utility();
		String url = flib.getPropertyKeyValue("url");
		String un = flib.getPropertyKeyValue("un");
		String pw = flib.getPropertyKeyValue("pw");
		driver.get(url);
		LoginPage login=new LoginPage(driver);
		login.login(un,pw);
}
	
	@AfterMethod(groups = {"smokeTest","regressionTest"})
public void AM()
{
		HomePage home=new HomePage(driver);
		home.clickToSignOut(driver);
}
	@AfterClass(groups = {"smokeTest","regressionTest"})
public void AC()
{
	driver.close();
}
	@AfterTest
public void AT()
{
	//System.out.println("executed successfully");
}
	@AfterSuite
public void AS()
{
	//System.out.println("close db connection");
}
}
