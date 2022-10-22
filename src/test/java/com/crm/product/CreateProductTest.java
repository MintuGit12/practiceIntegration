package com.crm.product;
import com.crm.Object_Repository.CreatingNewProduct;
import com.crm.Object_Repository.HomePage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.Generic_utilities.BaseClass;
import com.crm.Generic_utilities.Excel_Utility;
import com.crm.Generic_utilities.File_Utility;
import com.crm.Generic_utilities.Java_Utility;
import com.crm.Generic_utilities.WebDriver_Utility;
import com.crm.Object_Repository.HomePage;
import com.crm.Object_Repository.LoginPage;
import com.crm.Object_Repository.ProductInformationPage;
import com.crm.Object_Repository.ProductListPage;

@Listeners(com.crm.Generic_utilities.ListenerImplementationClass.class)
public class CreateProductTest extends BaseClass {
	@Test(groups = {"smokeTest"})
public void createProductTest() throws IOException
{
	File_Utility flib=new File_Utility();
	Java_Utility jlib=new Java_Utility();
	WebDriver_Utility wlib=new WebDriver_Utility();
	Excel_Utility elib=new Excel_Utility();
	
wlib.waitForPageToLoad(driver);
wlib.toMaximizeBrowser(driver);


HomePage home=new HomePage(driver);
home.clickToProducts();
ProductListPage plist=new ProductListPage(driver);
plist.getCreateProductLink().click();
//Assert.fail();


String value = elib.getExcelData("product", 0, 0);
CreatingNewProduct cprod=new CreatingNewProduct(driver);
cprod.setProductNameTxtBox(value);
cprod.getSaveButton().click();

ProductInformationPage pifor=new ProductInformationPage(driver);
pifor.validationOfPage(value);
}


}
