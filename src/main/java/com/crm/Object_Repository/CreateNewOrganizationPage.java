package com.crm.Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CreateNewOrganizationPage {
	@FindBy(name="accountname")
	private WebElement accountNameTxtBox;
	
	@FindBy(xpath = "//input[@class='detailedViewTextBox' and @value and @size='27']")
	private WebElement websiteTxtBox;
	
	@FindBy(id = "phone")
	private WebElement phoneNoTxtBox;
	
	@FindBy(xpath = "(//input[@class='crmbutton small save'])[2]")
	private WebElement saveButton;
	
	public CreateNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getAccountNameTxtBox() {
		return accountNameTxtBox;
	}

	public WebElement getWebsiteTxtBox() {
		return websiteTxtBox;
	}

	public WebElement getPhoneNoTxtBox() {
		return phoneNoTxtBox;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	//businessLogic
public void accountNameTxtBoxFillValue(String val)
{
	accountNameTxtBox.sendKeys(val);
}
public void websiteTxtBoxFillValue(String val)
{
	websiteTxtBox.sendKeys(val);
}
public void setPhoneNoTxtBox(String val)
{
	phoneNoTxtBox.sendKeys(val);
}
}
