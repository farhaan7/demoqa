package Pages;

import java.io.IOException;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

import Base.ParentBase;

public class TextBox extends ParentBase
{	@FindBy(xpath="//h5[contains(text(),'Forms')]")
WebElement form;

@FindBy(xpath="//span[normalize-space()='Practice Form']")
WebElement formbutton;

@FindBy(xpath="//input[@id='dateOfBirthInput']")
WebElement calendar;
@FindBy(xpath="//select[@class='react-datepicker__month-select']")
WebElement calendar1;
//select.bytext("April")
@FindBy(xpath="//select[@class='react-datepicker__year-select']")
WebElement calendar2;
//selectbyvisibletext(1996)
@FindBy(xpath="//div[@aria-label='Choose Wednesday, April 3rd, 1996']")
WebElement date;


	
	
	@FindBy(xpath="//div[@class='category-cards']//div[1]//div[1]//div[1]")
	public static
	WebElement element;
	
	@FindBy(xpath="//span[text()='Text Box']")
	WebElement box;
	
	@FindBy(id="userName")
	WebElement fullname;
	
	@FindBy(xpath="//input[@id=\"userEmail\"]")
	WebElement Email;
	
	@FindBy(xpath="//textarea[@id=\"currentAddress\"]")
	WebElement caddress;
	
	@FindBy(xpath="//textarea[@id='permanentAddress']")
	WebElement paddress;
	
	@FindBy(xpath="//button[@id='submit']")
	WebElement submit;

	
	
	public TextBox() throws IOException
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateTitle()
	{
	return driver.getTitle();
	}
	
	
	public void automatecalendar() throws InterruptedException
	{
		form.click();
		Thread.sleep(2000);
		formbutton.click();
		calendar.click();
		Select ss=new Select(calendar1);
		ss.selectByVisibleText("April");
		Thread.sleep(2000);
		Select s2 = new Select(calendar2);
		s2.selectByVisibleText("1996");
		Thread.sleep(2000);
		date.click();
		Thread.sleep(5000);
		
	}
	
	
	
	

	
	public String fillForm(String fname,String email,String cadd,String padd) throws Throwable
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		clickOn(driver, element, 20);
		box.click();
		fullname.sendKeys(fname);
		logger2.log(Status.PASS, "Name Entered successfully");
		Email.sendKeys(email);
		logger2.log(Status.PASS, "email address Entered successfully");
		caddress.sendKeys(cadd);
		logger2.log(Status.PASS, "current address Entered successfully");
		paddress.sendKeys(padd);
		logger2.log(Status.PASS, "Permanent address Entered successfully");
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,350)", "");
		//clickOn(driver, submit, 10);
		submit.click();
		logger2.log(Status.PASS, "Form submitted successfully");
		Thread.sleep(3000);
		

		return driver.getCurrentUrl();
		
		
		
	}
	
	
	
	
	
}
