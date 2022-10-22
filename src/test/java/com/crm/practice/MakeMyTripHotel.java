package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MakeMyTripHotel {
	static {
		System.setProperty("webdriver.chrome.driver","./chromedriver.exe");
	}
	public static void main(String[] args) throws IOException, InterruptedException {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the place you want to go :");
		String place = sc.next();
		System.out.println("enter the month want to travel and return :");
		String go = sc.next();
		String ret = sc.next();
		System.out.println("enter the start and end date of booking:");
		int start=sc.nextInt();
		int end=sc.nextInt();
		System.out.println("Enter the number of adult and children want to travel:");
		int adult=sc.nextInt();
		int child=sc.nextInt();
		FileInputStream fis=new FileInputStream("./mmt.property.txt");
		Properties p=new Properties();
		p.load(fis);
		String url = p.getProperty("url");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
		driver.findElement(By.xpath("//span[text()='Hotels' and @class='chNavText darkGreyText']")).click();
		driver.findElement(By.id("city")).click();
		driver.findElement(By.xpath("//input[@placeholder='Enter city/ Hotel/ Area/ Building']")).sendKeys(""+place);
		Thread.sleep(3000);
		List<WebElement> all = driver.findElements(By.xpath("//div[@class='spaceBetween makeFlex hrtlCenter']"));
		for(WebElement ele:all)
		{
			System.out.println(ele.getText());
		}
		//Thread.sleep(2000);
		all.get(0).click();
		driver.findElement(By.xpath("(//div[contains(text(),'"+go+"')]/ancestor::div[@class='DayPicker-Months']/descendant::div[text()='"+start+"'])[2]")).click();
		driver.findElement(By.xpath("(//div[contains(text(),'"+ret+"')]/ancestor::div[@class='DayPicker-Months']/descendant::div[text()='"+end+"'])[2]")).click();
		//driver.findElement(By.id("guest")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//ul[@data-cy='adultCount']/li[text()='"+adult+"']")).click();
		driver.findElement(By.xpath("(//li[text()='"+child+"'])[2]")).click();
		//Thread.sleep(2000);
		//int ele = driver.findElement(By.xpath("//button[text()='APPLY']")).getLocation().getY();
		WebElement s1 = driver.findElement(By.xpath("(//select[@class='ageSelectBox'])[1]"));
		Select s=new Select(s1);
		Thread.sleep(2000);
		s.selectByIndex(4);
		WebElement s2 = driver.findElement(By.xpath("(//select[@class='ageSelectBox'])[2]"));
		Select ss=new Select(s2);
		Thread.sleep(2000);
		ss.selectByIndex(4);
		Thread.sleep(2000);
		JavascriptExecutor j=(JavascriptExecutor)driver;
		j.executeScript("window.scrollBy(0,300)");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='APPLY']")).click();
		driver.findElement(By.id("hsw_search_button")).click();
	}

}
