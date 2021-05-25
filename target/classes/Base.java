package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base 
{
  public  WebDriver driver;
  public Properties prop=new Properties();
  public WebDriver intializeDriver() throws IOException
  {
	  
	 // FileInputStream fis=new FileInputStream("D:\\Automation\\Workspace1\\E2EProject\\src\\main\\java\\resources\\data.properties");
	  FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
	  prop.load(fis);
	  String browserName=prop.getProperty("browser");
	  
	  if(browserName.equals("chrome"))
	  {
		 // System.setProperty("webdriver.chrome.driver", "D:\\Automation\\Workspace1\\E2EProject\\src\\main\\java\\Academy\\Browsers\\chromedriver.exe");
		  System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\Academy\\Browsers\\chromedriver.exe");
		  driver= new ChromeDriver();
		  
	  }
	  else if(browserName.equals("firefox"))
	  {
		  
	  }
	 
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	 
	return driver;
	
  }
   public void getScreenShotPath(String testCaseName, WebDriver driver) throws IOException
   {
	   TakesScreenshot ts= (TakesScreenshot) driver;
	   File source=ts.getScreenshotAs(OutputType.FILE);
	   String destinationfile=System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
	   FileUtils.copyFile(source, new File(destinationfile));
   }
  

}

