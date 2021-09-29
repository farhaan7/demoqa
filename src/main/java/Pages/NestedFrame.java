package Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.ParentBase;

public class NestedFrame extends ParentBase
{	
	

	@FindBy(xpath="//h5[text()=\"Alerts, Frame & Windows\"]")
	WebElement frameq;

	
	@FindBy(xpath="//span[normalize-space()='Nested Frames']")
	WebElement iframemenu;
	@FindBy(xpath="//iframe[@id='frame1']")
	WebElement parentframe;
	
	@FindBy(xpath="//body[text()='Parent frame']")
	WebElement parentframetext;
	
	@FindBy(xpath="//iframe[@srcdoc='<p>Child Iframe</p>']")
	WebElement childframe;
	
	@FindBy(xpath="//p[normalize-space()='Child Iframe']")
	WebElement childframetext;
	
	public NestedFrame() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	public void actionOnIFrames() throws InterruptedException
	{
		//scroll();
		//frameq.click();
		scroll();
		iframemenu.click();
		scroll();
		Thread.sleep(2000);
		driver.switchTo().frame(parentframe);
		System.out.println(parentframetext.getText());
		driver.switchTo().frame(childframe);
		System.out.println(childframetext.getText());
		driver.switchTo().defaultContent();
		
	}

}
