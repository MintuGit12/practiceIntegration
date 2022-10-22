package com.crm.Object_Repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OrganizationInformationPage {
@FindBy(xpath = "//span[@class='dvHeaderText']")
private WebElement headerOfPage;

public OrganizationInformationPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

public WebElement getHeaderOfPage() {
	return headerOfPage;
}
//business logic
public void validationOfPage(WebDriver driver,String val)
{
	String val1 = driver.findElement(By.id("mouseArea_Organization Name")).getText();
	char[] c=val1.toCharArray();
	String st="";
	for(int i=0;i<c.length;i++)
	{
if(c[i]!=' ')
	st=st+c[i];
	}
	Assert.assertEquals(val, st);
	/*if(headerOfPage.getText().contains(val))
	{
		System.out.println("Organization test passed");
	}
	else
		System.out.println("Organization test failed");*/
}
}
