package com.crm.product;

import java.io.File;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.crm.Generic_utilities.BaseClass;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class GenerateExtentReport{
ExtentReports report;
ExtentTest test;
@BeforeTest
public void startReport()
{
	report=new ExtentReports(System.getProperty("user.dir")+"/test-output/MyOwnReport.html",true);
	report.addSystemInfo("Host Name", "localhost");
	report.addSystemInfo("Enviroment", "QA");
	report.addSystemInfo("user name", "pks");
	report.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
}
@Test
public void demoReportPass()
{
	test=report.startTest("demoReportPass");
	Assert.assertTrue(true);
	test.log(LogStatus.PASS, "Assert pass as condition is true");
}
@Test
public void demoReportFail()
{
	test=report.startTest("demoReportFail");
	Assert.assertTrue(false);
	test.log(LogStatus.FAIL, "Assert pass as condition is false");
}
@AfterMethod
public void getResult(ITestResult res)
{
	if(res.getStatus()==ITestResult.FAILURE)
		test.log(LogStatus.FAIL,res.getThrowable());
	report.endTest(test);
}
@AfterTest
public void endReport()
{
	report.flush();
}
}
