package com.PracticeProject.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.PracticeProject.pageObjects.LoginPage;

public class TC_loginTest_001 extends BaseClass 
{
	@Test
	public void loginTest() throws IOException, InterruptedException
	{
		
		logger.info("URL is opened ");
		
		LoginPage lp = new LoginPage(driver);
		lp.getUserID().sendKeys(Username);
		logger.info("entered username");
		
		lp.getPassword().sendKeys(Password);
		logger.info("entered Passowrd");
		
		lp.getLoginButton().click();
		Thread.sleep(3000);
		
		String actualTitle = driver.getTitle();
		//System.out.println("website title"+actualTitle);
		String ExpectedTitle = "Guru99 Bank Manager HomePage";//this actual result to true
		//String ExpectedTitle = "Guru99 Bank Manager HomePage123"; // intense to make test result fail
		
		if(actualTitle.equals(ExpectedTitle))
		{
			Assert.assertTrue(true);
			logger.info("login test passed");
		}
		else 
		{
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("login test failed");
		}
	}
	

}
