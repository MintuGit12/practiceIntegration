package com.crm.Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewProduct {
@FindBy(xpath = "//input[@name='productname']")
private WebElement productNameTxtBox;

@FindBy(xpath = "//input[@class='crmbutton small save']")
private WebElement saveButton;

public CreatingNewProduct(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

public WebElement getProductNameTxtBox() {
	return productNameTxtBox;
}

public WebElement getSaveButton() {
	return saveButton;
}
//busi ness logic 
public void setProductNameTxtBox(String val)
{
	productNameTxtBox.sendKeys(val);
}
}
