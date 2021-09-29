package TestCases;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;

import Base.ParentBase;
import Pages.Alerts;
import Pages.Buttons;
import Pages.CheckBox;
import Pages.Forms;
import Pages.Frames;
import Pages.Modaldialog;
import Pages.NestedFrame;
import Pages.RadioButton;
import Pages.TextBox;
import Pages.WebTables;
import Utilities.Screenshotutility;
import Utilities.TestUtil;

public class Testcases extends ParentBase
{	
	TextBox text;
	Forms ff;
	RadioButton rb;
	CheckBox cb;
	WebTables wt;
	Buttons b;
	


	

	public Testcases() throws IOException {
		super();
		
	}
	
	@BeforeSuite
	public void extent() throws IOException
	{	
		
		
		launchbrowser();
		logger();
		text  = new TextBox();
		ff = new Forms();
		rb = new RadioButton();
		cb = new CheckBox();
		wt = new WebTables();
		b = new Buttons();
	}
	
	@Test(priority=1)
	public void verifyTitle()
	{
		//ExtentTest logger = extent.createTest("verifyTitle");
		
		String Title = text.validateTitle();
		Assert.assertEquals(Title, "ToolsQA");
	
		
		//logger1.log(Status.FAIL, "test failed");
		//logger1.fail("test case failed");
	}
		

	@Test(priority=2)
	public void fillforms() throws Throwable
	{
		
			text.fillForm(prop.getProperty("fname"),prop.getProperty("email"),prop.getProperty("cadd"),
					prop.getProperty("padd"));
		//logger2.fail("test case failed");
	}
	
	@Test(priority=3)
	public void clickOnRadio() throws InterruptedException
	{
		
		rb.rad();
		//logger3.log(Status.FAIL, " not clicked on radio");
		
	}
	
	
	
	
	
	@Test(priority=4)
	public void tickall() throws InterruptedException
	{
		
		cb.checkmark();
		//logger4.log(Status.FAIL, " not clicked on checkbox");
		//logger4.fail("test case failed");

	}
	
	@Test(priority=5)
	public void fill() throws InterruptedException
	{	
	
		Thread.sleep(2000);

		wt.fillform();
		Assert.assertTrue(wt.tableMeRecord());
		//logger5.fail("test case failed");
	}
	
	@Test(priority=6)
	public void buttonsMethod()
	{
		
		b.doubleclick();
		Assert.assertTrue(b.confirmAction());
		Assert.assertTrue(b.confirmAction1());
		Assert.assertTrue(b.confirmAction2());

		//logger6.log(Status.PASS, "Double click done sir");
		logger6.fail("test case failed");
		
		
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
			
				
				logger13.fail("Testcase name :"+ result.getName());
				logger13.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());

			    }
		  	  }
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}		
	}
}
}