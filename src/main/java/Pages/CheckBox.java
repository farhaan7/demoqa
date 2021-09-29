package Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import Base.ParentBase;


public class CheckBox extends ParentBase
{
	@FindBy(xpath="//div[@class='category-cards']//div[1]//div[1]//div[1]")
	WebElement elements;
	
	//WebElement element = TextBox.element;
	
	@FindBy(xpath="//span[contains(text(),'Check Box')]")
	WebElement check;
	
	@FindBy(xpath="//button[@title='Expand all']")
	WebElement expand;
	
	
	
	@FindBy(xpath="//label[@for='tree-node-notes']//span[@class='rct-checkbox']//*[name()='svg']")
	WebElement notes;
	
	@FindBy(xpath="//label[@for='tree-node-angular']//span[@class='rct-checkbox']//*[local-name()='svg']")
	WebElement angular;
	
	@FindBy(xpath="//label[@for='tree-node-public']//span[@class='rct-checkbox']//*[local-name()='svg']")
	WebElement publics;
	
//	Actions actions = new Actions(driver);
//	WebElement elementLocator = driver.findElement(By.id("ID"));
//	actions.contextClick(elementLocator).perform();
	
	
	
	public CheckBox() throws IOException
	{
		PageFactory.initElements(driver, this);
	}
	
	public void checkmark() throws InterruptedException
	{
	
		//clickOn(driver, elements, 20);
	//	Thread.sleep(2000);
		check.click();
		expand.click();
		logger4.log(Status.PASS, "checkbox menu expanded");
		clickOn(driver, notes, 20);
		logger4.log(Status.PASS, "Notes option selected in checkbox");
		clickOn(driver, angular, 20);
		logger4.log(Status.PASS, "Angular option selected in checkbox");
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0,350)", "");
		scroll();
		clickOn(driver, publics, 20);
		//logger4.log(Status.PASS, "Publics option selected in checkbox");
		
	}
	
}
