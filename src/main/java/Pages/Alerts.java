package Pages;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.ParentBase;

public class Alerts extends ParentBase
{
	
	@FindBy(xpath="//h5[text()=\"Alerts, Frame & Windows\"]")
	WebElement alertq;
	
	@FindBy(xpath="//span[normalize-space()='Alerts']")
	WebElement alertmenu;
	
	@FindBy(xpath="//button[@id=\"alertButton\"]")
	WebElement alert2;
	
	@FindBy(xpath="//button[@id=\"timerAlertButton\"]")
	WebElement alert3;
	
	@FindBy(xpath="//button[@id=\"confirmButton\"]")
	WebElement alert4;
	
	@FindBy(xpath="//button[@id=\"promtButton\"]")
	WebElement alert5;

	public Alerts() throws IOException {
		
		
		PageFactory.initElements(driver, this);
	}
	
	public void actiononAlerts() throws InterruptedException
	{
		scroll();
		alertq.click();
		scroll();
		alertmenu.click();
		alert2.click();
		
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		alert3.click();
		Thread.sleep(6000);
		driver.switchTo().alert();
		Thread.sleep(6000);
		System.out.println(alert.getText());
		alert.accept();
		Thread.sleep(5000);
		
		alert4.click();
		driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		Thread.sleep(3000);
		alert5.click();
		driver.switchTo().alert().sendKeys("farhaan");
		alert.accept();
		Thread.sleep(3000);
		
	}

}
