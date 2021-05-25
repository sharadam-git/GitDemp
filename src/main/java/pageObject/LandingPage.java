package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	
	By signin=By.cssSelector("a[href*='sign_in']");
	
	By title=By.cssSelector(".text-center>h2");
	By navigationbar=By.xpath("//*[@id=\"homepage\"]/header/div[2]/div/nav/ul");


	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}


	public WebElement getLogin()
	{
	return driver.findElement(signin);
	}	
	public WebElement getTitle()
	{
	return driver.findElement(title);
	}
	public WebElement getNavigationbar()
	{
	return driver.findElement(navigationbar);
	}


	


}