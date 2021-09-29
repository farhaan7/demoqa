package Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;

import Base.ParentBase;

public class Forms  extends ParentBase

{
	@FindBy(xpath="//h5[contains(text(),'Forms')]")
	WebElement form;

	@FindBy(xpath="//span[normalize-space()='Practice Form']")
	WebElement formbutton;
	
	@FindBy(xpath="//input[@id='firstName']")
	WebElement fnam;
	
	@FindBy(xpath="//input[@id='lastName']")
	WebElement lnam;
	
	@FindBy(xpath="//input[@id='userEmail']")
	WebElement email1;
	
	@FindBy(xpath="//label[normalize-space()='Male']")
	WebElement gender;
	
	@FindBy(xpath="//input[@id='userNumber']")
	WebElement contact1;
	
	@FindBy(xpath="//input[@id='dateOfBirthInput']")
	WebElement calendar;
	
	@FindBy(xpath="//select[@class='react-datepicker__month-select']")
	WebElement calendar1;
	
	
	@FindBy(xpath="//select[@class='react-datepicker__year-select']")
	WebElement calendar2;

	
	@FindBy(xpath="//div[@aria-label='Choose Wednesday, April 3rd, 1996']")
	WebElement date;
	
	@FindBy(xpath="//div[@class='subjects-auto-complete__value-container subjects-auto-complete__value-container--is-multi css-1hwfws3']")
	WebElement subject;
	
	@FindBy(xpath="//label[normalize-space()='Sports']")
	WebElement hobbies;
	
	@FindBy(xpath="")
	WebElement pictures;
	
	@FindBy(xpath="//textarea[@id='currentAddress']")
	WebElement c_add;
	
	@FindBy(xpath="//div[contains(text(),'Select State')]") //dropdown
	WebElement dropdown;
	
	@FindBy(xpath="//div[contains(text(),'NCR')]")
	WebElement ddval;
	

	@FindBy(xpath="//div[@id='city']") //dropdown
	WebElement dropdown1;
	
	@FindBy(xpath="//button[normalize-space()='Submit']") //dropdown
	WebElement click1;
	
	@FindBy(xpath="//div[contains(text(),'Thanks for submitting the form')]")
	WebElement confirm;
	

	
	public Forms() throws IOException {
		PageFactory.initElements(driver, this);
		
	}
		
	public void form_bharo_jaldi(String firstname,String lastname,String email,String contact,String address) throws InterruptedException
	{
			
		form.click();
		clickOn(driver, formbutton, 10);
		fnam.sendKeys(firstname);
		//logger.log(Status.PASS, "first ");
		lnam.sendKeys(lastname);
		//logger.log(Status.PASS, "single click done");
		email1.sendKeys(email);
		//logger.log(Status.PASS, "single click done");
		gender.click();
		//logger.log(Status.PASS, "single click done");
		contact1.sendKeys(contact);
	//logger.log(Status.PASS, "single click done");
		
		calendar.click();
		Select ss=new Select(calendar1);
		
		ss.selectByVisibleText("April");
		
		Select s2 = new Select(calendar2);
		s2.selectByVisibleText("1996");
	
		date.click();
		
	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
	
		//subject.sendKeys("English");
		
		hobbies.click();
		
		//pictures.click();
		
		c_add.sendKeys(address);
		
		//js.executeScript("window.scrollBy(0,350)", "");
	
		dropdown.click();
		ddval.click();
	
		//dropdown.sendKeys("NCR");
		//Select drop2 = new Select(dropdown1);
		//dropdown1.sendKeys("Delhi");
		
		click1.click();
	}
	
	public Boolean confirmform()
	{
		return confirm.isDisplayed();
	}

}
