package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo {
	 static
		{
			System.setProperty("webdriver.chrome.driver","./chromedriver.exe");
		}
	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("./common_data.property.txt");
		Properties p=new Properties();
		p.load(fis);
		String url=p.getProperty("url");
		String un = p.getProperty("un");
		String pw=p.getProperty("pw");
		WebDriverManager.chromedriver().setup();
WebDriver driver=new ChromeDriver();
driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
driver.get(url);
driver.findElement(By.name("user_name")).sendKeys(un);
driver.findElement(By.name("user_password")).sendKeys(pw);
driver.findElement(By.id("submitButton")).click();
driver.findElement(By.linkText("Organizations")).click();
driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
Random r=new Random();
FileInputStream fin=new FileInputStream("./Book1.xlsx");
Workbook book = WorkbookFactory.create(fin);
Row row = book.getSheet("organisation").getRow(1);
 String acc = row.getCell(0).getStringCellValue();
driver.findElement(By.name("accountname")).sendKeys(acc+r.nextInt());
String det = row.getCell(1).getStringCellValue();
driver.findElement(By.xpath("(//input[@class='detailedViewTextBox'])[3]")).sendKeys(det);
/*String num = row.getCell(2).getStringCellValue();
driver.findElement(By.id("phone")).sendKeys(num);
String tiker = row.getCell(3).getStringCellValue();
driver.findElement(By.name("tickersymbol")).sendKeys(tiker);
String faxno = row.getCell(4).getStringCellValue();
driver.findElement(By.id("fax")).sendKeys(faxno);
//driver.findElement(By.name("account_name")).sendKeys("account");
String otherno = row.getCell(5).getStringCellValue();
driver.findElement(By.id("otherphone")).sendKeys(otherno);*/
driver.findElement(By.xpath("(//input[@class='crmbutton small save'])[2]")).click();
WebElement ele = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
if(ele.getText().contains("TestYantra"))
	System.out.println("test passed");
else
	System.out.println("test failed");
//driver.close();
	}

}
