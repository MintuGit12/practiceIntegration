
	package com.crm.Generic_utilities;


	import java.io.File;
	import java.io.ObjectInputFilter.Status;

	import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.support.events.EventFiringWebDriver;
	import org.testng.Assert;
	import org.testng.ITestContext;
	import org.testng.ITestListener;
	import org.testng.ITestResult;

	import com.relevantcodes.extentreports.ExtentReports;
	import com.relevantcodes.extentreports.ExtentTest;
	import com.relevantcodes.extentreports.LogStatus;

	public class ListenerImplementationGrid implements ITestListener {
	public ExtentReports report;
	public ExtentTest test;
	static WebDriver sDriver;

	public static void listenerImplementationGrid(WebDriver driver)
	{
		sDriver=driver;
	}
		public void onTestStart(ITestResult result) {
			test=report.startTest(result.getMethod().getMethodName()+" test is getting started");
		
		}

		public void onTestSuccess(ITestResult result) {
			test=report.startTest(result.getMethod().getMethodName()+" method is passed congratulations");
		
		}

		public void onTestFailure(ITestResult result) {
		
			test.log(LogStatus.FAIL, result.getMethod().getMethodName()+" execution got failed");
			
			String res = result.getMethod().getMethodName();
			
			TakesScreenshot ts=(TakesScreenshot)sDriver;
			File src=ts.getScreenshotAs(OutputType.FILE);
			try
			{
				File dest=new File("./screenshot/"+res+".png");
				String path = dest.getAbsolutePath();
				Thread.sleep(3000);
				FileUtils.copyFile(src, dest);
				
				Thread.sleep(3000);
				test.log(LogStatus.FAIL,test.addScreenCapture(path+" test is getting failed"));
				
		}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}

		public void onTestSkipped(ITestResult result) {
	test.log(LogStatus.SKIP,result.getMethod().getMethodName()+" is skipped....something is wrong ");
			test.log(LogStatus.SKIP,result.getThrowable());
		}

		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
			// TODO Auto-generated method stub
			
		}

		public void onStart(ITestContext context) {
			report=new ExtentReports(System.getProperty("user.dir")+"/Extent_Report/MyOwnReport.html",true);
			report.addSystemInfo("Host Name", "localhost");
			report.addSystemInfo("platformName", "windows");
			report.addSystemInfo("status", "Senior Test Engg");
			report.addSystemInfo("user name", "Purusottam Kumar Singh");
			report.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
			
		}

		public void onFinish(ITestContext context) {
			report.flush();
		
			
		}
		

	}


