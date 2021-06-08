package Resources;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
//import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class Base {

	public WebDriver driver=null;
	public Properties property;
	public WebDriver initializeDriver() throws Exception
	{
	    property=new Properties();
		FileInputStream file=new FileInputStream("C:\\Automation Learning\\SelenimFramworkDesigning\\E2EProject\\src\\main\\java\\Resources\\data.properties");
		property.load(file);
		String browser=property.getProperty("browser");
		
		System.out.println(browser);
		
		if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C://chromedriver.exe");
			driver= new ChromeDriver();
		}
		else if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.gecko.driver","C://geckodriver.exe");
			driver= new FirefoxDriver();
		}
		else if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.ie.driver","C://IEDriverServer.exe");
			driver= new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		return driver;
	}
	public String getScreenShotPath(String testcaseName,WebDriver driver) throws IOException
	{
		
		File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destination=System.getProperty("user.dir")+"\\Reports\\"+testcaseName+".png";
		FileUtils.copyFile(source,new File(destination));
		return destination;
	}
}
