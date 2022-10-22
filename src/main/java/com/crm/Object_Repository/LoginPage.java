package com.crm.Object_Repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
//declaration
	@FindBy(name="user_name")
	private WebElement usernameTextBox;
	
	@FindBy(name="user_password")
	private WebElement passwordTextBox;
	
	@FindBy(id="submitButton")
	private WebElement submitButton;
	
	//initialization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getUsernameTextBox() {
		return usernameTextBox;
	}

	public void setUsernameTextBox(WebElement usernameTextBox) {
		this.usernameTextBox = usernameTextBox;
	}

	public WebElement getPasswordTextBox() {
		return passwordTextBox;
	}

	public void setPasswordTextBox(WebElement passwordTextBox) {
		this.passwordTextBox = passwordTextBox;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}

	public void setSubmitButton(WebElement submitButton) {
		this.submitButton = submitButton;
	}
	
//business logic
	public void login(String un,String pwd)
	{
		usernameTextBox.sendKeys(un);
		passwordTextBox.sendKeys(pwd);
		submitButton.click();
	}
}
