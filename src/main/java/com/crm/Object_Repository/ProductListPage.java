package com.crm.Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductListPage {
@FindBy(xpath = "//img[@title='Create Product...']")
private WebElement createProductLink;

public ProductListPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

public WebElement getCreateProductLink() {
	return createProductLink;
}

}
