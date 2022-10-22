package com.crm.Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInformationPage {
@FindBy(xpath = "//span[@class='lvtHeaderText']")
private WebElement productInformationHeader;

@FindBy(name = "Delete")
private WebElement deleteButton;

public ProductInformationPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}


public WebElement getProductInformationHeader() {
	return productInformationHeader;
}


public WebElement getDeleteButton() {
	return deleteButton;
}


//business logic
public void validationOfPage(String value)
{
	if(productInformationHeader.getText().contains(value))
		System.out.println("Product test passed");
	else 
		System.out.println("Product test failed");
}
}
