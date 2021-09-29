package Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


import Pages.TextBox;
import groovyjarjarantlr4.v4.parse.ANTLRParser.action_return;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ParentBase 
{
	public static WebDriver driver;
	public static Properties prop;
	public WebElement element = TextBox.element;
	//double click :
	
	//scroll:
	public static JavascriptExecutor js = (JavascriptExecutor) driver;
	//Declare extent report:
	public static ExtentSparkReporter htmlReporter = new ExtentSparkReporter("./Reports/extent.html");
//	htmlReporter.config().setReportName("farhaan test");
	public static ExtentReports extent = new ExtentReports();
	
	public static ExtentTest logger1,logger2,logger3,logger4,logger5,logger6,logger13;
	
	
	

	
	
	public ParentBase() throws IOException
	{
		try {
			prop= new Properties();
			FileInputStream input = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Utilities\\config.properties");
			prop.load(input);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
			
		}catch(IOException e) {
			e.printStackTrace();
		}

	}
	public static void launchbrowser()
	{
		String browsername=prop.getProperty("browser");
		if(browsername.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		}
		else if(browsername.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://demoqa.com/");


		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	public void logger()
	{
		htmlReporter.config().setReportName("farhaan's testcases");
		extent.attachReporter(htmlReporter);
		logger1=extent.createTest("verifytitle");
		logger2=extent.createTest("form Verification Test");
		logger3=extent.createTest("clickOnRadio");
		logger4=extent.createTest("Checkbox Tickall");
		logger5=extent.createTest("Add record in table");
		logger6=extent.createTest("Double click");
		logger13=extent.createTest("Failed test cases");
	}
	
		
	
	
	public static void scroll()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
	}
	public static void clickOn(WebDriver driver, WebElement locator,int timeout)
	{
		
		new WebDriverWait(driver,timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(locator));
		locator.click();
	}
	public WebElement getElement() {
		return element;
	}
	public void setElement(WebElement element) {
		this.element = element;
	}
	
}
