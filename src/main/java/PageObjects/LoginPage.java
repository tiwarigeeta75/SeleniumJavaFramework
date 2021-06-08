package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	By userId=By.xpath(".//input[contains(@id,'user_email')]");
	By password=By.xpath(".//input[contains(@id,'user_password')]");
	By login=By.xpath(".//input[contains(@value,'Log In')]");
	
	
	public WebElement getuserId()
	{
		return driver.findElement(userId);
	}
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	public WebElement getLoginButton()
	{
		return driver.findElement(login);
	}
	
}
