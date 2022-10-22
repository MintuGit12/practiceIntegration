package com.crm.Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignListPage {
@FindBy(xpath = "//img[@title='Create Campaign...']")
private WebElement createCampaign;

public CampaignListPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

public WebElement getCreateCampaign() {
	return createCampaign;
}

}
