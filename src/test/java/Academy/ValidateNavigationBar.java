package Academy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

import PageObjects.LandingPage;

import Resources.Base;
import junit.framework.Assert;

public class ValidateNavigationBar extends Base {

	public static Logger log=LogManager.getLogger(ValidateNavigationBar.class.getName());
	public WebDriver driver;
	
	@BeforeTest
	public void initialze() throws Exception
	{
		driver=initializeDriver();
		driver.get(property.getProperty("url"));
		log.info("Entry to validate navigation Bar class");
	}
	@Test
	public void validateNavigation() throws Exception
	{
		LandingPage lp=new LandingPage(driver);
		Assert.assertTrue(lp.getContact().isDisplayed());
		log.info("Navigation bar is present");
	}
	@AfterTest
	public void teardown()
	{
		System.out.println("Exit validate Navigation bar class");
		driver.close();
		
	}
}
