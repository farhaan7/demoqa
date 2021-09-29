package Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.ParentBase;

public class Frames extends ParentBase
{

	
	@FindBy(xpath="//h5[text()=\"Alerts, Frame & Windows\"]")
	WebElement frameq;
	
	@FindBy(xpath="//span[normalize-space()='Frames']")
	WebElement framemenu;
	
	@FindBy(xpath="//h1[normalize-space()='This is a sample page']")
	WebElement frame11;
	
	@FindBy(xpath="//h1[normalize-space()='This is a sample page']")
	WebElement frame22;
	
	
	
	public Frames() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	
	public void actionOnFrames()
	{	
		//scroll();
		//frameq.click();
		scroll();
		framemenu.click();
		driver.switchTo().frame("frame1");
		System.out.println(frame11.getText());
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame2");
		System.out.println(frame22.getText());
		driver.switchTo().defaultContent();
		
	
	}
		
}
