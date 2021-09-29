package Pages;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import Base.ParentBase;



public class WebTables extends ParentBase
{
	@FindBy(xpath="//span[text()='Web Tables']")
	WebElement table;
	@FindBy(xpath="//div[@class='category-cards']//div[1]//div[1]//div[1]")
	WebElement element;
	
	@FindBy(xpath="//button[@id='addNewRecordButton']")
	WebElement addbutton;
	
	@FindBy(xpath="//input[@id='firstName']")
	WebElement newform;
	
	//input[@id='lastName']
	
	@FindBy(xpath="//input[@id='lastName']")
	WebElement lastname;
	@FindBy(xpath="//input[@id='userEmail']")
	WebElement email;
	@FindBy(xpath="//input[@id='age']")
	WebElement age;
	@FindBy(xpath="//input[@id='salary']")
	WebElement salary;
	@FindBy(xpath="//input[@id='department']")
	WebElement department;
	@FindBy(xpath="//button[@id='submit']")
	WebElement submit;
	
	@FindBy(xpath="//div[contains(text(),'farhaan')]")
	WebElement checkkar;
	
	
	public WebTables() throws IOException {
		PageFactory.initElements(driver, this);
	}

	
	public void fillform() throws InterruptedException
	{	//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0,350)", "");
		//clickOn(driver, element, 20);
		//js.executeScript("window.scrollBy(0,350)", "");
		clickOn(driver, table, 20);
		logger5.log(Status.PASS, "webtable opened");
		addbutton.click();
		newform.sendKeys("farhaan");
		logger5.log(Status.PASS, "firstName entered");
		Thread.sleep(3000);
		lastname.sendKeys("kapde");
		logger5.log(Status.PASS, "lasttName entered");
		email.sendKeys("email@gmail.com");
		logger5.log(Status.PASS, "email entered");
		age.sendKeys("25");
		logger5.log(Status.PASS, "age entered");
		salary.sendKeys("500000");
		logger5.log(Status.PASS, "salary entered");
		department.sendKeys("Quality assurance");
		logger5.log(Status.PASS, "Department entered");
		submit.click();
		logger5.log(Status.PASS, "Clicked on Submit Button");
		
		Thread.sleep(3000);
		
	}
	
	public Boolean tableMeRecord()
	{
		return checkkar.isDisplayed();
	}
}
