package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.Base;

public class HomePage extends Base {
	public WebDriver driver;
	public static Logger Log=LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void openBrowser() throws IOException
	{
		driver= intializeDriver();
		Log.info("naviagted to home screen");
		
	}
	
	
	@Test(dataProvider="getData")
	public void basePageNavigate(String username, String password) throws Exception
	{
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		
		LandingPage l=new LandingPage(driver);
		l.getLogin().click();
		LoginPage lg=new LoginPage(driver);
		lg.getUsername().sendKeys(username);
		Thread.sleep(3000);
		lg.getPassword().sendKeys(password);
		lg.clkLogin().click();
		
		
		
		
		
	}
    @DataProvider
    public Object[][] getData()
    {
      // row stands for many different data types test should be
      // col stands for how many values per each test 
      Object[][] data=new Object[2][2];
      data[0][0]="sharadbhat47gmail.com";
      data[0][1]="12345";
   
      
      data[1][0]="nonrestricted";
      data[1][1]="34566";
      //data[1][2]="restricted";
      return data;
      
      
    } 
    @AfterTest
    public void closeBrowser()
    {
    	driver.close();
    }
   
}
