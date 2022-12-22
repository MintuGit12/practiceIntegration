package com.crm.product;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import com.crm.Generic_utilities.BaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GridProgram{
@Test
public void gridTest() throws MalformedURLException
{String browser = System.getProperty("browser");
	URL url=new URL("http://192.168.5.1:4444/wd/hub");
	
	DesiredCapabilities dc=new DesiredCapabilities();
	dc.setBrowserName(browser);
	dc.setPlatform(Platform.WINDOWS);
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new RemoteWebDriver(url,dc);
	driver.get("https://www.facebook.com/");
	driver.findElement(By.id("email")).sendKeys("admin");
	driver.findElement(By.id("pass")).sendKeys("admin");
	driver.findElement(By.name("login")).click();
	driver.close();
}
}
