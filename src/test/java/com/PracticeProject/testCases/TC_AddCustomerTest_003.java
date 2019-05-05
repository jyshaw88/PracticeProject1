package com.PracticeProject.testCases;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.PracticeProject.pageObjects.AddCustomerPage;
import com.PracticeProject.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass
{
	@Test
	public void addNewCustomer() throws  InterruptedException,IOException 
	{
		//to add new customer we need to login first then we can add
		LoginPage lp = new LoginPage(driver);
		lp.getUserID().sendKeys(Username);
		logger.info("username is provided");
		
		lp.getPassword().sendKeys(Password);
		logger.info("pwd is provided");
		
		lp.getLoginButton().click();
		
		Thread.sleep(3000); // to see the progress
		
		//here we do addcustomer object and function calling
		
		AddCustomerPage addcust = new AddCustomerPage(driver);
		
		//operate all addpage functions to  
		addcust.ClickAddNewCustomer();
		
		logger.info("providing customer details..");
		
		addcust.GetCustomerName("Jyoti");
		addcust.CustGennder("female");
		addcust.CustDOB("10","5","1999");
		Thread.sleep(3000);
		
		addcust.CustAdrss("BEML");
		addcust.CustCity("BLR");
		addcust.CustState("KA");
		addcust.CustPin("560066");
		addcust.CustMobno("9888888888");
		Thread.sleep(3000);
		String Custemail = randomstring()+"@gmail.com";
		addcust.CustEmailid(Custemail);
		addcust.EnterPwd("abcdef");
		addcust.SubminBtn();
		
		Thread.sleep(3000);
		
		//to validate the data if successfull
		logger.info("validation started..");
		boolean res =driver.getPageSource().contains("Customer Registered Successfully!!!");
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed..");
		}
		else
		{
			logger.info("test case failed..");
			captureScreen(driver,"AddCustomerTest"); // not const tc name 
			Assert.assertTrue(false);
		}
		
		
	}
	
}
