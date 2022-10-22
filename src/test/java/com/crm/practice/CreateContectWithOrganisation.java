package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.crm.Generic_utilities.BaseClass;
import com.crm.Generic_utilities.Excel_Utility;
import com.crm.Generic_utilities.File_Utility;
import com.crm.Generic_utilities.Java_Utility;
import com.crm.Generic_utilities.WebDriver_Utility;

public class CreateContectWithOrganisation extends BaseClass{
	@Test
public void createContectWithOrganisationTest()throws IOException
{
		File_Utility flib=new File_Utility();
		Excel_Utility elib=new Excel_Utility();
		Java_Utility jlib=new Java_Utility();
		WebDriver_Utility wlib=new WebDriver_Utility();

	wlib.waitForPageToLoad(driver);
	wlib.toMaximizeBrowser(driver);

	driver.findElement(By.partialLinkText("Contacts")).click();
	driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();

	String data = elib.getExcelData("conWithOrg", 0, 0);
	driver.findElement(By.name("lastname")).sendKeys(data);
	driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[1]")).click();
	//Thread.sleep(3000);
	
	String parent = driver.getWindowHandle();
	wlib.handleChildWindow(driver, "Organizations");
	driver.findElement(By.partialLinkText("TestYantra")).click();

	driver.switchTo().window(parent);
	driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
	String text=driver.findElement(By.xpath("//span[contains(text(),'"+data+"')]")).getText();
if(text.contains(data))
	System.out.println("Testcase passed");
else
	System.out.println("failed");
WebElement ele2=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
wlib.handleMouseOvering(driver, ele2);

	}
}
