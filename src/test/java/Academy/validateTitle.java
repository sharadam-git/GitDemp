package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.Base;

public class validateTitle extends Base {
	public WebDriver driver;
	
	public static Logger Log=LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void openBrowser() throws IOException
	{
		driver= intializeDriver();
		Log.info("browser opened");
		driver.get(prop.getProperty("url"));
		Log.info("naviagted to home screen");
		driver.manage().window().maximize();
	}
	
	
	@Test
	public void validateText() throws IOException, InterruptedException
	{
		
		LandingPage l=new LandingPage(driver);
		l.getTitle().getText();
		Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES");
		//Assert.assertTrue(l.getNavigationbar().isDisplayed());
		Log.info("validated text message");
		
		
	}
	
	@AfterTest
	    public void closeBrowser()
	    {
	    	driver.close();
	    }
 
    
}
