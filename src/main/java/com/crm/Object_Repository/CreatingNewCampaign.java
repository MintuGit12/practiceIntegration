package com.crm.Object_Repository;

import javax.xml.xpath.XPath;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewCampaign {
@FindBy(name = "campaignname")
private WebElement campaignNameTxtBox;

@FindBy(xpath = "//img[@title='Select']")
private WebElement productWindow;

@FindBy(xpath = "//input[@class='crmButton small save']")
private WebElement saveButton;

public CreatingNewCampaign(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

public WebElement getCampaignNameTxtBox() {
	return campaignNameTxtBox;
}

public WebElement getProductWindow() {
	return productWindow;
}

public WebElement getSaveButton() {
	return saveButton;
}
public void setCampaignNameTxtBox(String val)
{
	campaignNameTxtBox.sendKeys(val);
}

}
