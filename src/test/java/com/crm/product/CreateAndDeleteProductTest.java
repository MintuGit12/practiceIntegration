package com.crm.product;
import com.crm.Object_Repository.CreatingNewProduct;
import com.crm.Object_Repository.HomePage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
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
public class CreateAndDeleteProductTest extends BaseClass {
	@Test(groups = {"regressionTest"})
public void createAndDeleteProductTest() throws EncryptedDocumentException, IOException
{
	File_Utility flib=new File_Utility();
	Excel_Utility elib=new Excel_Utility();
	Java_Utility jlib=new Java_Utility();
	WebDriver_Utility wlib=new WebDriver_Utility();
	

wlib.toMaximizeBrowser(driver);
wlib.waitForPageToLoad(driver);

HomePage home=new HomePage(driver);
home.clickToProducts();
ProductListPage plist=new ProductListPage(driver);
plist.getCreateProductLink().click();
//Assert.fail();


String value = elib.getExcelData("product", 0, 0);
CreatingNewProduct cprod=new CreatingNewProduct(driver);
cprod.setProductNameTxtBox(value);
cprod.getSaveButton().click();

ProductInformationPage pinf=new ProductInformationPage(driver);
pinf.validationOfPage(value);

pinf.getDeleteButton().click();
wlib.waitToAlertToBePresent(driver);
wlib.switchToAlertAndAccept(driver);

}
	
}
