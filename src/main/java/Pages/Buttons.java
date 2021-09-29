package Pages;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import Base.ParentBase;

public class Buttons extends ParentBase
{		
	@FindBy(xpath="//div[@class='category-cards']//div[1]//div[1]//div[1]")
	WebElement elements;
	
	@FindBy(xpath="//li//span[normalize-space()='Buttons']")
	WebElement buttn;
	

	@FindBy(xpath="//button[@id='doubleClickBtn']")
	WebElement doublec;
	
	@FindBy(xpath="//button[@id=\"rightClickBtn\"]")
	WebElement rightc;
	
	@FindBy(xpath="//button[normalize-space()='Click Me']") //id changes its dynamic
	WebElement clickme;
	
	@FindBy(xpath="//p[@id='doubleClickMessage']")
	WebElement doublemsg;
	
	@FindBy(xpath="//p[@id='rightClickMessage']")
	WebElement rightmsg;
	
	@FindBy(xpath="//p[@id='dynamicClickMessage']")
	WebElement clickmsg;
	
	public Buttons() throws IOException {
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	public void doubleclick()
	{	
		//elements.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		buttn.click();
		logger6.log(Status.PASS, "Clicked on button menu");
		Actions act = new Actions(driver);
		act.doubleClick(doublec).perform();
		logger6.log(Status.PASS, "Double click done");
		act.contextClick(rightc).perform();
		logger6.log(Status.PASS, "Right click performed");
		clickme.click();
		logger6.log(Status.PASS, "single click done");
	}
	
	public boolean confirmAction()
	{
		return doublemsg.isDisplayed();
			
	}
	
	public boolean confirmAction1()
	{
		
		return rightmsg.isDisplayed();	
	}
	
	public boolean confirmAction2()
	{
		return clickmsg.isDisplayed();
		
	}
	
	
}
