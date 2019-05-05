// It is listener file which includes onTestSuccess/OnTestFailure/Onskipped
//Utilityfile Listener+ExtentReport.java file
// Listener class used to generate extent reports
//It has some compilation issue so use ReportingListener.java file 
/*
package com.PracticeProject.utilities;

import java.io.File;
//import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
//import com.aventstack.extentreports.reporter.ExtentXReporter;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Reporting extends TestListenerAdapter
{ 
	public ExtentHtmlReporter htmlReporter;//build a new report using the html template
	public ExtentReports extent; // specify the location & configuration part
	public ExtentTest logger; // what and all data need to populate/pass/fail/skip/pie chart
		
	//in below method ITestContext to share data among all TC 
	public void onStart(ITestContext testContext)
	{
		//timestamp
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//timestamp
		String repName = "Test Report-" + timeStamp +".html";
		//specify location
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+ repName);
		//xml locate/ need to load
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+ "/extent-config.xml");
		
		//path to store the report
		////initialize ExtentReports and attach the HtmlReporter
		//extent = new ExtentReports("htmlReporter",true);
		extent= new ExtentReports(repName);
		//extent.attchRepoter(repName);
		extent.addSystemInfo("Host Name ","LocalHost");//computer name
		extent.addSystemInfo("Environment ","Stage");//
		extent.addSystemInfo("User name ","Jyoti");	
		
		htmlReporter.config().setDocumentTitle("Practice Project 1"); // title of report
		htmlReporter.config().setReportName("Functional Test Automation Report"); // name of the report
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);//location of chart
		htmlReporter.config().setTheme(Theme.DARK);
		
	}
	
	public void onTestSuccess(ITestResult tr)
	{
		logger= extent.startTest(tr.getName());// create new entry in the report
		logger.log(LogStatus.PASS,(Throwable) MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN));
	}
	
	public void onTestFailure(ITestResult tr)
	{
		logger= extent.startTest(tr.getName());// create new entry in the report
		
		logger.log(LogStatus.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED));
		logger.log(LogStatus.FAIL, tr.getThrowable());
		//logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED));
						 
		String screenshotpath = System.getProperty("user.dir")+ "\\Screenshots\\" + tr.getName()+".png";
		 
		File f = new File(screenshotpath);
		
		if(f.exists())
		{
			try
			{
				logger.log(LogStatus.FAIL, "screenshot" + logger.addScreenCapture(screenshotpath));
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	
	}
	
	public void onTestSkipped(ITestResult tr)
	{
		logger= extent.startTest(tr.getName());// create new entry in the report
		logger.log(LogStatus.SKIP,(Throwable) MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
	}
	public void onFinish(ITestResult tr)
	{
		extent.flush();
	}
}
*/