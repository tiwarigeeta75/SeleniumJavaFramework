package Academy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.LandingPage;
import PageObjects.LoginPage;
import Resources.Base;

public class HomePage extends Base {

	public static Logger log=LogManager.getLogger(HomePage.class.getName());
	public WebDriver driver;
	
	@BeforeTest
	public void initialze() throws Exception
	{
		driver=initializeDriver();
		
		log.info("Entry to homepage class");
	}
	@Test(dataProvider = "getData")
	public void basePageNavigation(String uname, String passwd, String text) throws Exception
	{
		driver.get(property.getProperty("url"));
		LandingPage lp=new LandingPage(driver);
		lp.getLogin().click();
		
		LoginPage loginPage=new LoginPage(driver);
		loginPage.getuserId().sendKeys(uname);
		loginPage.getPassword().sendKeys(passwd);
	    log.info(text);
		loginPage.getLoginButton().click();
		
	}
	@DataProvider
	public Object[][] getData()
	{
		//row stands for how many different data
		//columns stands for How many value each set
		Object[][] data=new Object[2][3];
		
		data[0][0]="nonrestricteduser@qw.com";
		data[0][1]="123456";
	    data[0][2]="Non Restricted user";
		
		data[1][0]="restricteduser@qw.com";
		data[1][1]="456789";
		data[1][2]="Restricted user";
	
		return data;
		
	}
	@AfterTest
	public void teardown()
	{
		System.out.println("Exit Home page class");
		driver.close();
	}
}
