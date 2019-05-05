package com.PracticeProject.testCases;
import org.apache.commons.lang3.RandomStringUtils;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.PracticeProject.utilities.ReadConfig;

public class BaseClass 
{
	ReadConfig readconfig = new ReadConfig();
	
	public String BaseURL = readconfig.getApplicationURL(); 
	public String Username = readconfig.getUsername();
	public String Password = readconfig.getPassword();
	
	public static WebDriver driver;
	public static Logger logger;

	@Parameters("browser")
	
	@BeforeClass
	public void setup(String br) throws InterruptedException
	{
		//System.setProperty("webdriver.chrome.driver","D:\\Selenium_Workspace\\PracticeProject1\\Drivers\\chromedriver.exe");
		// getproperty() to get user directory /home directiry ---> D:\\Selenium_Workspace\\PracticeProject1
		
		//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "\\Drivers\\chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "\\Drivers\\chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe");
		
		
		logger = logger.getLogger("BaseClass");
		PropertyConfigurator.configure("Log4j.properties");
		
		// launch the desired diff browser
		
		if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
			//driver = new ChromeDriver(); // it is working local machine not for jenkins
			
			// below code for fix timed out issue and chrome browser launching in jenkins 
			
			ChromeOptions options = new ChromeOptions();
		    options.addArguments("--disable-features=VizDisplayCompositor");
		    driver = new ChromeDriver(options);
		    
		 // below code for fix timed out issue and chrome browser launching in jenkins
		}
		
		else if (br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",readconfig.getFireFox());
			driver = new FirefoxDriver();
		}
		else if (br.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver",readconfig.getIEPath());
			driver = new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(BaseURL);
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.close();
	}
	// this user defined method which need to call if any failed test is found .this is will capture screenshot
	//this need to call in test case where fail condition is checked 
	
	public void captureScreen(WebDriver driver,String testcaseName) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + testcaseName + ".png");
		FileUtils.copyFile(source,target);
		System.out.println("Screenshot taken");
	}
	public String randomstring()
	{
		// to get below method need to add dependency in pom xml -->Apache Commons Lang » 3.0
		String generatestring = RandomStringUtils.randomAlphabetic(8);
		return generatestring;
	}

}
