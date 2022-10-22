package practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipkartIphone {
	static {
		System.setProperty("webdriver.chrome.driver","./chromedriver.exe");
	       }
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
driver.get("https://www.flipkart.com/");
driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
driver.findElement(By.name("q")).sendKeys("iphone",Keys.ENTER);
List<WebElement> all1 = driver.findElements(By.xpath("//div[contains(text(),'APPLE iPhone')]"));
List<WebElement> all2 = driver.findElements(By.xpath("//div[contains(text(),'APPLE iPhone')]/../../div[2]/div[1]/div[1]/div[1]"));

for(int i=0;i<all2.size();i++)
{
	System.out.println(all1.get(i).getText()+"----->>>>>"+all2.get(i).getText());
}
	}

}
