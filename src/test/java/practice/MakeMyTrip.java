package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MakeMyTrip {
	static {
		System.setProperty("webdriver.chrome.driver","./chromedriver.exe");
	}
	public static void main(String[] args) throws IOException, InterruptedException {
	Scanner sc=new Scanner(System.in);
	System.out.println("enter the departure and arrivel month you want to travel ");
	String go = sc.next();
	String come = sc.next();
		FileInputStream fis=new FileInputStream("./mmt.property.txt");
Properties p=new Properties();
p.load(fis);
String url = p.getProperty("url");
FileInputStream fin=new FileInputStream("./mmtExcel.xlsx");
Workbook wb = WorkbookFactory.create(fin);
Sheet sheet = wb.getSheet("Sheet1");
Row row = sheet.getRow(1);
String from = row.getCell(0).getStringCellValue();
String to = row.getCell(1).getStringCellValue();
System.out.println(from+"  "+to);
double arr = row.getCell(2).getNumericCellValue();
int ar=(int)arr;
 double dep = row.getCell(3).getNumericCellValue();
 int de=(int)dep;
 System.out.println(de+"....>>>"+ar);
WebDriver driver=new ChromeDriver();
driver.get(url);
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
 WebElement ele = driver.findElement(By.id("fromCity"));
ele.sendKeys(""+from);
Thread.sleep(2000);
List<WebElement> all = driver.findElements(By.xpath("//div/p[@class='font14 appendBottom5 blackText']"));
all.get(0).click();
Thread.sleep(1000);
//driver.findElement(By.xpath("//input[@class='react-autosuggest__input react-autosuggest__input--open']")).sendKeys("new");
 driver.findElement(By.xpath("//input[@id='toCity']")).click();
 driver.findElement(By.xpath("//input[@aria-controls='react-autowhatever-1' and  @placeholder='To']")).sendKeys(""+to);
 Thread.sleep(2000);
List<WebElement> all1 = driver.findElements(By.xpath("//div[@class='calc60']"));
Thread.sleep(1000);
all1.get(1).click();
driver.findElement(By.xpath("(//span[@class='lbl_input latoBold appendBottom10'])[1]")).click();
Thread.sleep(2000);
driver.findElement(By.xpath("//p[contains(text(),'2')]")).click();
Thread.sleep(2000);
driver.findElement(By.xpath("//div[contains(text(),'"+go+"')]/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+de+"']")).click();
Thread.sleep(2000);
driver.findElement(By.xpath("//span[contains(text(),'RETURN')]")).click();
Thread.sleep(2000);
driver.findElement(By.xpath("//div[contains(text(),'"+come+"')]/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+ar+"']")).click();
Thread.sleep(2000);
driver.findElement(By.xpath("//span[text()='Travellers & CLASS']")).click();
driver.findElement(By.xpath("//li[@data-cy='adults-2']")).click();
driver.findElement(By.xpath("//li[@data-cy='children-2']")).click();
driver.findElement(By.xpath("//button[text()='APPLY']")).click();
Thread.sleep(2000);
driver.findElement(By.xpath("//a[text()='Search']")).click();
Thread.sleep(4000);
driver.close();
	}

}
