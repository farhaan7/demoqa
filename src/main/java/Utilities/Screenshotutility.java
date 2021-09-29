package Utilities;

import java.io.File;
import java.io.IOException;
import java.sql.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.helpers.AbsoluteTimeDateFormat;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Base.ParentBase;

public class Screenshotutility extends ParentBase
{
	
	public Screenshotutility() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public static String getScreenshot( WebDriver driver)
	{	
		//AbsoluteTimeDateFormat dateName = new AbsoluteTimeDateFormat();
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"/Screenshot/"+System.currentTimeMillis()+".png";
		
		File destination = new File(path);
		
		try
		{
			FileUtils.copyFile(src, destination);
		}catch(IOException e)
		{
			System.out.println("Capture screenshot "+e.getMessage());
		}
		return path;
		
	}
}
