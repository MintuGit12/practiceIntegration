package com.crm.Object_Repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CampaignInformation {
@FindBy(xpath = "//span[@class='dvHeaderText']")
private WebElement campaingInformationHeader;

public CampaignInformation(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

public WebElement getCampaingInformationHeader() {
	return campaingInformationHeader;
}

//business logic
public void validationOfPage(WebDriver driver,String val)
{
	String val1 = driver.findElement(By.id("mouseArea_Campaign Name")).getText();
	System.out.println(val1);
	char[] c=val1.toCharArray();
	String st="";
	for(int i=0;i<c.length;i++)
	{
if(c[i]!=' ')
	st=st+c[i];
	}
	Assert.assertEquals(val, st);
	/*if(campaingInformationHeader.getText().contains(value))
		System.out.println("Campaign test passed");
	else
		System.out.println("Campaign test failed");*/
}
}
