package Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import Base.ParentBase;
import groovyjarjarantlr4.v4.parse.ANTLRParser.element_return;

public class RadioButton extends ParentBase
{
//	WebElement element = TextBox.element;
	
	@FindBy(xpath="//div[@class='category-cards']//div[1]//div[1]//div[1]")
	WebElement elements;
	
	@FindBy(xpath="//span[contains(text(),'Radio Button')]")
	WebElement radiomenu;
	
	@FindBy(xpath="//label[@for='impressiveRadio']")
	WebElement radio;

	public RadioButton() throws IOException {
		PageFactory.initElements(driver, this);
		
	}
	
	public void rad() throws InterruptedException
	{
		//clickOn(driver, elements, 20);
		radiomenu.click();
		logger3.log(Status.PASS, "clicked on radiomenu");
		radio.click();
		logger3.log(Status.PASS, "radio button selected");
		
	}

}
