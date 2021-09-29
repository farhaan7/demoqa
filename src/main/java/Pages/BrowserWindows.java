package Pages;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.ParentBase;

public class BrowserWindows extends ParentBase
{
	@FindBy(xpath="//h5[text()=\"Alerts, Frame & Windows\"]")
	WebElement alertq;
	
	@FindBy(xpath="//span[normalize-space()='Browser Windows']")
	WebElement windowsmenu;
	
	@FindBy(xpath="//button[normalize-space()='New Tab']")
	WebElement ab1c;
	
	@FindBy(xpath="//button[normalize-space()='New Window']")
	WebElement abc1;
	
	@FindBy(xpath="//button[normalize-space()='New Window Message']")
	WebElement abc2;
	
	@FindBy(xpath="")
	WebElement abc3;
	@FindBy(xpath="")
	WebElement abc4;
	public BrowserWindows() throws IOException {
		PageFactory.initElements(driver, this);
		
	}
	
	
		public void handles() throws Exception
		{	
			//scroll();
			//alertq.click();
			windowsmenu.click();
			ab1c.click();
			Thread.sleep(5000);
			Set <String> s= driver.getWindowHandles();
			Iterator<String> i = s.iterator();
			String parent = i.next();	
			System.out.println(parent);
			String child = i.next();
			System.out.println(child);
			driver.switchTo().window(child);
			driver.close();
			Thread.sleep(3000);
			driver.switchTo().window(parent);
		}
	}
	

