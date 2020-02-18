package com.actitime.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class GenerateReport extends TestListenerAdapter {
ExtentHtmlReporter reporter;
	
	ExtentReports extent;
	
	ExtentTest test;
	
	public void onStart(ITestContext rv1)
	{
	  String date=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	  //setting the name of the report
	  String repName="Test-Reports"+date+".html";
	  //setting the location of the report 
	  reporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"//test-output//"+repName);
	//set report title
	reporter.config().setDocumentTitle("VTiger Execution Report");
	//set report name
	reporter.config().setReportName("Build number 1 result");
	//set theme
	 reporter.config().setTheme(Theme.DARK);
	 extent=new ExtentReports();
	//to enter user details in the report, we should give control of report to ExtentReport Class
	 //we can give the control using attachReporter()
    extent.attachReporter(reporter);	  
 	extent.setSystemInfo("QA","Sira");
 	extent.setSystemInfo("Environment","Test Environment");
 	extent.setSystemInfo("Application name","VTiger");
 	extent.setSystemInfo("Platform", "Windows 10");
 	extent.setSystemInfo("Browser","chrome");
	  System.out.println("Batch Execution started.........");
	  BaseClass.log.info("Batch execution started.....");
	}
	
	public void onFinish(ITestContext rv1)
	{
		System.out.println("Batch Execution Finished!!!");
		extent.flush();
		BaseClass.log.info(".....Batch execution finished........");
	}
	
	public void onTestStart(ITestResult rv1)
	{
		System.out.println("Test Script Execution started....");
		BaseClass.log.info("TestScript execution started.....");
	}
	
	
	public void onTestSuccess(ITestResult rv1)
	{
		System.out.println("Test Scripts is Pass..congrats");
		//retrive the method name from the object and pass the method name inside the report'
		test=extent.createTest(rv1.getName());
	test.log(Status.PASS,MarkupHelper.createLabel("The Test is SUCCESS!!!",ExtentColor.GREEN));	
	BaseClass.log.info("Test Script is passed Congrats.......");
	}
	public void onTestFailure(ITestResult rv1) {
		test=extent.createTest(rv1.getName());
		test.log(Status.FAIL,MarkupHelper.createLabel("Test is Failed",ExtentColor.RED));
		EventFiringWebDriver efw=new EventFiringWebDriver(BaseClass.driver);
		File f1=efw.getScreenshotAs(OutputType.FILE);
		String date=new SimpleDateFormat("yyyymmddhhmmss").format(new Date());
		String path=System.getProperty("user.dir")+"//screenshots//"+date+".jpg";
		File f2=new File(path);
		try {
			FileUtils.copyFile(f1, f2);
			System.out.println("screenshot captured success");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("screenshot capture fail");
			e.printStackTrace();
		}
		System.out.println("Test Script failed");
	}
	public void onTestSkipped(ITestResult rv1) 
	{
		test=extent.createTest(rv1.getName());
		test.log(Status.SKIP,MarkupHelper.createLabel("This test is skipped",ExtentColor.ORANGE));
		System.out.println("Test Script skipped");
	}
}
