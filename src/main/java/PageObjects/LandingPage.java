package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	//
	public WebDriver driver;
	By signIn=By.xpath(".//a[contains(@href,'https://rahulshettyacademy.com/sign_in/')]");
	By title=By.xpath(".//h2[contains(text(),'Featured Courses')]");
	By contact=By.xpath(".//a[(text()='Contact')]");
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public WebElement getLogin()
	{
		return driver.findElement(signIn);
	}
	public WebElement getTite()
	{
		return driver.findElement(title);
	}
	public WebElement getContact()
	{
		return driver.findElement(contact);
	}
	
}

