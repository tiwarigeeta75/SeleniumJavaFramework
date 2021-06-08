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

public class ValidateTitle extends Base {

	public static Logger log=LogManager.getLogger(ValidateTitle.class.getName());
	public WebDriver driver;
	
	
	@BeforeTest
	public void initialze() throws Exception
	{
		driver=initializeDriver();
		driver.get(property.getProperty("url"));
		log.info("Entry to Validate Test class");
	}
	@Test
	public void validateTitle()
	{
		
		LandingPage lp=new LandingPage(driver);
		Assert.assertEquals("Featured course title matches",lp.getTite().getText(),"FEATURED COURSE");	
		log.info("Successfully validated Featured course text");
	}
	@AfterTest
	public void teardown()
	{
		System.out.println("Exit validate Title class");
		driver.close();
		
	}
}
