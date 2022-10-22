package practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.crm.Generic_utilities.BaseClass;
import com.crm.Generic_utilities.Excel_Utility;
import com.crm.Generic_utilities.File_Utility;
import com.crm.Generic_utilities.Java_Utility;
import com.crm.Generic_utilities.WebDriver_Utility;
import com.crm.Object_Repository.CampaignInformation;
import com.crm.Object_Repository.CampaignListPage;
import com.crm.Object_Repository.CreateNewOrganizationPage;
import com.crm.Object_Repository.CreatingNewCampaign;
import com.crm.Object_Repository.CreatingNewProduct;
import com.crm.Object_Repository.HomePage;
import com.crm.Object_Repository.LoginPage;
import com.crm.Object_Repository.OrganizationInformationPage;
import com.crm.Object_Repository.OrganizationListPage;
import com.crm.Object_Repository.ProductInformationPage;
import com.crm.Object_Repository.ProductListPage;

public class AllAtOnceVTiger extends BaseClass {
	@Test
public void allAutomationVTiger() throws InterruptedException, IOException
{
	Java_Utility jlib=new Java_Utility();
	WebDriver_Utility wlib=new WebDriver_Utility();
	Excel_Utility elib=new Excel_Utility();
	File_Utility flib=new File_Utility();

wlib.toMaximizeBrowser(driver);
wlib.waitForPageToLoad(driver);

//creating organization
OrganizationListPage org=new OrganizationListPage(driver);
HomePage home=new HomePage(driver);
home.clickToOrganization();
org.clickCreateOrganisation();


int ranNum = jlib.getRanDomNum();

String val = elib.getExcelData("organisation", 1, 0);
val=val+ranNum;
CreateNewOrganizationPage cnew=new CreateNewOrganizationPage(driver);
cnew.getAccountNameTxtBox().sendKeys(val);

String det=elib.getExcelData("organisation", 1, 1);
cnew.getWebsiteTxtBox().sendKeys(det);
 String num = elib.getExcelData("organisation", 1, 2);
 cnew.getPhoneNoTxtBox().sendKeys(num);

 cnew.getSaveButton().click();
 OrganizationInformationPage oi=new OrganizationInformationPage(driver);
 oi.validationOfPage(driver,val);
 //creating product
	home.clickToProducts();
	ProductListPage plist=new ProductListPage(driver);
	plist.getCreateProductLink().click();


	String value = elib.getExcelData("product", 0, 0);
	CreatingNewProduct cprod=new CreatingNewProduct(driver);
	cprod.getProductNameTxtBox().sendKeys(value);
	cprod.getSaveButton().click();
	
	ProductInformationPage pifor=new ProductInformationPage(driver);
	pifor.validationOfPage(value);
	//creating campaign with product
    home.clickToCampaign(driver);
	CampaignListPage campList=new CampaignListPage(driver);
	campList.getCreateCampaign().click();

	String value1 = elib.getExcelData("campaign", 0, 0);
	CreatingNewCampaign createCamp=new CreatingNewCampaign(driver);
	createCamp.getCampaignNameTxtBox().sendKeys(value1);
	createCamp.getProductWindow().click();
	
	Thread.sleep(5000);
	String parent = driver.getWindowHandle();
	wlib.handleChildWindow(driver, "Product");
	driver.findElement(By.partialLinkText("Qspiders")).click();
	driver.switchTo().window(parent);
	
	createCamp.getSaveButton().click();
	CampaignInformation campInfor=new CampaignInformation(driver);
	WebElement ele = campInfor.getCampaingInformationHeader();
	wlib.customWaitForElement(ele);
	campInfor.validationOfPage(driver,value1);

}


}
