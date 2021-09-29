package TestCases;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Base.ParentBase;
import Pages.Alerts;
import Pages.BrowserWindows;
import Pages.Frames;
import Pages.Modaldialog;
import Pages.NestedFrame;
import Utilities.Screenshotutility;

public class AlertsFramesWindows extends ParentBase
{	
	Alerts aa;
	Frames fra;
	Modaldialog md;
	NestedFrame nf;
	BrowserWindows bw;
	
	ExtentSparkReporter htmlReporter = new ExtentSparkReporter("./Reports/alertslogger.html");
	ExtentReports extent = new ExtentReports();
	ExtentTest loggerA,loggerB,loggerC,loggerD,loggerE,loggerfail;
	
	public void alertslogger()
	{
		htmlReporter.config().setReportName("Alerts testcase Report");
		extent.attachReporter(htmlReporter);
		
		
		loggerA=extent.createTest("Alert action");
		loggerB=extent.createTest("Frame handle");
		loggerC=extent.createTest("modal dialog");
		loggerD=extent.createTest("nested frame test");
		loggerE=extent.createTest("Window handle");
		loggerfail=extent.createTest("Failed test cases");
			
	}

	
	public AlertsFramesWindows() throws IOException {
		super();
	}
	
	@BeforeSuite
	public void extent() throws IOException
	{	
		
		alertslogger();
		launchbrowser();
		nf = new NestedFrame();
		md = new Modaldialog();
		aa= new Alerts();
		fra = new Frames();
		bw = new BrowserWindows();	
		}
	
	
		@Test(priority=1)
		public void alertaction() throws InterruptedException
		{
			aa.actiononAlerts();
		}
		
		@Test(priority=2)
		public void frameHandle() throws InterruptedException
		{
			fra.actionOnFrames();
			Thread.sleep(5000);
		}
		
		@Test(priority=3)
		public void modalDialogTest() throws InterruptedException
		{
			md.actionOnModals();
		}
	
		@Test(priority=4)
		public void nestedFrameTest() throws InterruptedException
		{
			nf.actionOnIFrames();
			Thread.sleep(3000);
		}
		
		@Test(priority=5)
		public void windowHandle() throws Exception
		{
			bw.handles();
		}
		
		@AfterSuite
		public void flush()
		{
			extent.flush();
			
			driver.quit();
		}
		
		
		@AfterMethod
		public void teardown(ITestResult result)
		{
					
			if(result.getStatus()==ITestResult.FAILURE)
			{
			  try {
					
					if(ITestResult.FAILURE==result.getStatus())
					{
					String temp=Screenshotutility.getScreenshot(driver);
				
					
					loggerfail.fail("Testcase name :"+ result.getName());
					loggerfail.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());

				    }
			  	  }
					catch(Exception e)
					{
						System.out.println(e.getMessage());
					}
			}
	}
	
}