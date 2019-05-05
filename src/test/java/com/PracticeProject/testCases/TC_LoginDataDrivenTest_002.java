package com.PracticeProject.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.PracticeProject.pageObjects.LoginPage;
import com.PracticeProject.utilities.XLUtils;

//This test case has already POM page. so no need to find element again
//this test case will validate login by taking xls data(set of data)
//this tc need to mention in Testng.xml file to run

public class TC_LoginDataDrivenTest_002 extends BaseClass
{
	//here we need to write LoginDataDrivenTest()-->perform login with multiple set of data
	//and dataprovider() --->provide the data (from xls sheet) to test method
	//below method just work as POM model
	
	@Test(dataProvider="LoginData")
	public void LoginDataDrivenTest(String username,String pwd) throws Exception
	{
		LoginPage lp = new LoginPage(driver);
		
		lp.getUserID().sendKeys(username);
		logger.info("username provided");
		
		lp.getPassword().sendKeys(pwd);
		logger.info("pwd provided");
		
		lp.getLoginButton().click();
		
		Thread.sleep(3000);
		if(isAlertPresent()== true)
		{
			driver.switchTo().alert().accept(); // close alert
			driver.switchTo().defaultContent(); // focus to main page
			Assert.assertTrue(false); // failure case
			logger.warn("login failed");
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("login passed");
			
			lp.getLogoutLink().click();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent(); //focus on login page 
			
		}
	}

	// user defined method to verify alert present on failure login
	public boolean isAlertPresent()
	{
		try
		{
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
	}
	
	
	
	//this below method will read the data from xls and store in 2 dimensional array
	//then it will return to actual tc--> TC_LoginDataDrivenTest- should not hard the data thats==why use 2d array
	
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException
	{
		String xlssheetpath = System.getProperty("user.dir") + "/src/test/java/com/PracticeProject/testData/LoginData.xlsx";
		//we need to read the data from xls sheet
		int rownum = XLUtils.getRowCount(xlssheetpath,"Sheet1");
		int colcount = XLUtils.getCellCount(xlssheetpath, "Sheet1",1);
		
		String logindata[][]= new String [rownum][colcount];
		//read the data from xls and store in 2d array 
		//in 2d array index is always less than 1from xls index
		for(int i =1;i<=rownum;i++) // as index 0 --has username heading
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j] = XLUtils.getCellData(xlssheetpath,"Sheet1",i,j); //index[1,0]
			}
		}
		
		return logindata;
		
				
	}
}





