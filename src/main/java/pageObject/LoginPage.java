package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	WebDriver driver;
	
	By username=By.id("user_email");
	By password =By.id("user_password");
	By clklogin=By.name("commit");
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	public WebElement getUsername()
	{
		return driver.findElement(username);
	}
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	public WebElement clkLogin()
	{
		return driver.findElement(clklogin);
	}

}
