package Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.ParentBase;

public class Modaldialog extends ParentBase
{
	
	@FindBy(xpath="//h5[text()=\"Alerts, Frame & Windows\"]")
	WebElement alertq;
	
	@FindBy(xpath="//span[normalize-space()='Modal Dialogs']")
	WebElement modalmenu;
	
	@FindBy(xpath="//button[normalize-space()='Small modal']")
	WebElement smallmodal;
	
	
	@FindBy(xpath="//button[normalize-space()='Close']")
	WebElement smallmodalclose;
	
	@FindBy(xpath="//button[normalize-space()='Large modal']")
	WebElement largemodal;
	
	
	@FindBy(xpath="//button[normalize-space()='Close']")
	WebElement largemodalclose;
	
	
	public Modaldialog() throws IOException
	{
		PageFactory.initElements(driver, this);
	}
	
	public void actionOnModals() throws InterruptedException
	{
		//scroll();
		//alertq.click();
		scroll();
		scroll();
		modalmenu.click();
		smallmodal.click();
		Thread.sleep(2000);
		smallmodalclose.click();
		Thread.sleep(2000);
		largemodal.click();
		Thread.sleep(2000);
		largemodalclose.click();
		Thread.sleep(2000);
	}

}
