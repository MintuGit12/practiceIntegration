package com.crm.organization;
import com.crm.Object_Repository.CreateNewOrganizationPage;
import com.crm.Object_Repository.HomePage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.Generic_utilities.BaseClass;
import com.crm.Generic_utilities.Excel_Utility;
import com.crm.Generic_utilities.File_Utility;
import com.crm.Generic_utilities.Java_Utility;
import com.crm.Generic_utilities.WebDriver_Utility;
import com.crm.Object_Repository.HomePage;
import com.crm.Object_Repository.LoginPage;
import com.crm.Object_Repository.OrganizationInformationPage;
import com.crm.Object_Repository.OrganizationListPage;

import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(com.crm.Generic_utilities.ListenerImplementationClass.class)
public class CreateOrganizationTest extends BaseClass
{
//Integration of the maven git project and 2nd push and new pulling should be done
	//,retryAnalyzer = com.crm.Generic_utilities.RetryAnalyser.class //in group
	@Test(groups = "regressionTest")
public void createOrganizationTest() throws IOException, InterruptedException
{
System.out.println("lets see the integration");

		File_Utility flib=new File_Utility();
		Java_Utility jlib=new Java_Utility();
		WebDriver_Utility wlib=new WebDriver_Utility();
		Excel_Utility elib=new Excel_Utility();

	wlib.toMaximizeBrowser(driver);
	wlib.waitForPageToLoad(driver);

	OrganizationListPage org=new OrganizationListPage(driver);
	HomePage home=new HomePage(driver);
	home.clickToOrganization();
	org.clickCreateOrganisation();
	//Assert.fail();
System.out.println("finally updated and done now trying for the jenkins task");
	int ranNum = jlib.getRanDomNum();

	String val = elib.getExcelData("organisation", 1, 0);
	val=val+ranNum;
	CreateNewOrganizationPage cnew=new CreateNewOrganizationPage(driver);
	cnew.accountNameTxtBoxFillValue(val);
		
	String det=elib.getExcelData("organisation", 1, 1);
	cnew.websiteTxtBoxFillValue(det);

	 String num = elib.getExcelData("organisation", 1, 2);
	 cnew.setPhoneNoTxtBox(num);

	 cnew.getSaveButton().click();
	 OrganizationInformationPage oi=new OrganizationInformationPage(driver);
	 oi.validationOfPage(driver,val);

}
}
