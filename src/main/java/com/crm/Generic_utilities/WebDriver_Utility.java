package com.crm.Generic_utilities;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriver_Utility {
	
	
	/**
	 * method to maximize the browser
	 * @param driver
	 */
	public void toMaximizeBrowser(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 * to handle implicit wait
	 * @param driver
	 */
public void waitForPageToLoad(WebDriver driver)
{
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
}
/**
 * to handle explicit condition
 * @param driver
 * @param ele
 */
public void waitForElementToBeClickable(WebDriver driver,WebElement ele)
{
	WebDriverWait wait=new WebDriverWait(driver, 20);
	wait.until(ExpectedConditions.elementToBeClickable(ele));
}
/**
 * title to be visible
 * @param driver
 * @param title
 */
public void waitForTitleToBeVisible(WebDriver driver,WebElement element)
{
	WebDriverWait wait=new WebDriverWait(driver, 20);
	wait.until(ExpectedConditions.elementToBeSelected(element));
}
public void customWaitForElement(WebElement ele)
{	int i=0;
	while(i<50)
	{
		try {
		ele.isDisplayed();
		break;
		}
		catch(Exception e)
		{
			i++;
		}
	}
	
}
/**
 * to handle alert is present 
 * @param driver
 */
public void waitToAlertToBePresent(WebDriver driver)
{
	WebDriverWait wait=new WebDriverWait(driver, 20);
	wait.until(ExpectedConditions.alertIsPresent());
}
/**
 * 
 * @param ele
 * @param i
 */
public void handleListBox(WebElement ele,int i)
{
	Select s=new Select(ele);
	s.selectByIndex(i);
}
/**
 * 
 * @param ele
 * @param text
 */
public void handleListBox(WebElement ele,String text)
{
	Select s=new Select(ele);
	s.selectByVisibleText(text);
}
/**
 * 
 * @param driver
 * @param target
 */
public void handleMouseOvering(WebDriver driver,WebElement target)
{
	Actions a=new Actions(driver);
	a.moveToElement(target).perform();;
}
/**
 * 
 * @param target
 * @param driver
 */
public void handleMouseRightClick(WebElement target,WebDriver driver)
{
	Actions a=new Actions(driver);
	a.contextClick(target).perform();;
}
/**
 * 
 * @param driver
 * @return
 */
public List<WebElement> forGettingAllFrames(WebDriver driver)
{
	List<WebElement> all = driver.findElements(By.tagName("iframe"));
	return all;
}
/**
 * switch to frame by index
 * @param driver
 * @param index
 */
public void switchToFrame(WebDriver driver,int index)
{
	driver.switchTo().frame(index);
}
/**
 * switch to frame by attribute
 * @param driver
 * @param attribute
 */
public void switchToFrame(WebDriver driver,String attribute)
{
	driver.switchTo().frame(attribute);
}
/**
 * 
 * @param driver
 */
public void returnToParentFrame(WebDriver driver)
{
	driver.switchTo().parentFrame();
}
/**
 * 
 * @param driver
 */
public void returnToDefaultFrame(WebDriver driver)
{
	driver.switchTo().defaultContent();
	
}
/**
 * used to switch to any window based on title
 * @param driver
 * @param name
 */
public void handleChildWindow(WebDriver driver,String name)
{
	Set<String> all = driver.getWindowHandles();
	Iterator<String> it = all.iterator();
	while(it.hasNext())
	{
		String ele = it.next();
		String title = driver.switchTo().window(ele).getTitle();
		if(title.contains(name))
		{
			break;
		}
	}
}
/**
 * This method is used to accept the alert popup
 * @param driver
 */
public void switchToAlertAndAccept(WebDriver driver)
{
	driver.switchTo().alert().accept();
}
/**
 * This method is used to dismiss the alert popup
 * @param driver
 */
public void switchToAlertAndDismiss(WebDriver driver)
{
	driver.switchTo().alert().dismiss();
}
/**
 * This method is used to get text the alert popup
 * @param driver
 */
public void switchToAlertAndGetText(WebDriver driver)
{
	driver.switchTo().alert().getText();
}

}
