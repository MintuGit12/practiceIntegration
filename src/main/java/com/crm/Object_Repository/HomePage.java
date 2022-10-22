package com.crm.Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.Generic_utilities.WebDriver_Utility;

public class HomePage {

	//declaration
	@FindBy(linkText = "Organizations")
	private WebElement organization_link;
	
	@FindBy(partialLinkText = "Products")
	private WebElement product_link;
	
	@FindBy(linkText = "More")
	private WebElement more_dropdown;
	
	@FindBy(name = "Campaigns")
	private WebElement campaign_link;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administrator_dropdown;
	
	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement signout_link;
	
	//initialization of the elements
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//getters and setters

	public WebElement getOrganization_link() {
		return organization_link;
	}

	public WebElement getProduct_link() {
		return product_link;
	}

	public WebElement getMore_dropdown() {
		return more_dropdown;
	}

	public WebElement getCampaign_link() {
		return campaign_link;
	}

	public WebElement getAdministrator_dropdown() {
		return administrator_dropdown;
	}

	public WebElement getSignout_link() {
		return signout_link;
	}
	//business logic
	public void clickToOrganization()
	{
		organization_link.click();
	}
	public void clickToProducts()
	{
		product_link.click();
	}
	public void clickToCampaign(WebDriver driver)
	{
		WebDriver_Utility wlib=new WebDriver_Utility();
		wlib.handleMouseOvering(driver,more_dropdown);
		campaign_link.click();
	}
	public void clickToSignOut(WebDriver driver)
	{
		WebDriver_Utility wlib=new WebDriver_Utility();
		wlib.handleMouseOvering(driver,administrator_dropdown);
		signout_link.click();
	}
}
