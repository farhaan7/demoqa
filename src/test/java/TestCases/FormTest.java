package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Base.ParentBase;
import Pages.Forms;
import Utilities.Screenshotutility;
import Utilities.TestUtil;

public class FormTest extends ParentBase
{
	Forms ff;
	ExtentSparkReporter htmlReporter = new ExtentSparkReporter("./Reports/formlogger.html");
	ExtentReports extent = new ExtentReports();
	ExtentTest logger,failedlogger;

	
	public void formlogger()
	{
		htmlReporter.config().setReportName("form's testcases");
		extent.attachReporter(htmlReporter);
		
		logger=extent.createTest("form Verification Test");
		
		failedlogger=extent.createTest("Failed test cases");	
	}
	
	
	
	public FormTest() throws IOException {
		super();
		
	}
	
	
	@BeforeSuite
	public void setup() throws IOException
	{	
		formlogger();
		launchbrowser();
		ff= new Forms();

	}


	@DataProvider
	public Object[][] getTestData(){
		Object data[][] = TestUtil.getTestData("sheet1");
		return data;
	}
	
	
	
	
	
	@Test(dataProvider="getTestData")
	public void calendar(String firstname,String lastname,String email,String contact,String address) throws InterruptedException
	{	
		scroll();
		ff.form_bharo_jaldi(firstname, lastname, email, contact, address);
		
		Assert.assertTrue(ff.confirmform(),"");
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
			
				
				failedlogger.fail("Testcase name :"+ result.getName());
				failedlogger.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());

			    }
		  	  }
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
}
		}
}