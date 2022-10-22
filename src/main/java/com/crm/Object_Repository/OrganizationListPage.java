package com.crm.Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationListPage {
@FindBy(xpath = "//img[@title='Create Organization...']")
private WebElement create_Organization;

public OrganizationListPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

public WebElement getCreate_Organization() {
	return create_Organization;
}

//business Logic
public void clickCreateOrganisation()
{
	create_Organization.click();
}
}
