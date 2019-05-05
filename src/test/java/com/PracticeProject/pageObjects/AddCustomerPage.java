package com.PracticeProject.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddCustomerPage 
{
	WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver)
	{
		this.ldriver =rdriver;
	}
	
	//get webelement of the Add new customer link  webpage
	//findout webelement and functions 
	public void ClickAddNewCustomer()
	{
		ldriver.findElement(By.linkText("New Customer")).click();
	}
	
	//get webelement of the to enter customer name
	public void GetCustomerName(String cname)
	{
		ldriver.findElement(By.xpath("//input[@name='name']")).sendKeys(cname);
	}
	
	//to select gender
	public void  CustGennder(String cgender)
	{
		ldriver.findElement(By.xpath("//tr[5]//td[2]")).click();
		
	}
	//to enter dateof birth
	public void CustDOB(String mm,String dd,String yy)
	{
		ldriver.findElement(By.xpath("//input[@id='dob']")).sendKeys(mm);
		ldriver.findElement(By.xpath("//input[@id='dob']")).sendKeys(dd);
		ldriver.findElement(By.xpath("//input[@id='dob']")).sendKeys(yy);
		
	}
	//to enter address
	public void CustAdrss(String addr)
	{
		ldriver.findElement(By.xpath("//textarea[@name='addr']")).sendKeys(addr);
		
	}
	
	//to enter city
	public void CustCity(String ccity)
	{
		ldriver.findElement(By.xpath("//input[@name='city']")).sendKeys(ccity);
		
	}
	
	//to enter city
	public void CustState(String cstate)
	{
		ldriver.findElement(By.xpath("//input[@name='state']")).sendKeys(cstate);
		
	}
	//to enter pin
	public void CustPin(String cpinno)
	{
		ldriver.findElement(By.xpath("//input[@name='pinno']")).sendKeys(String.valueOf(cpinno));
		
	}	
	//to enter mobilenum
	public void CustMobno(String telphno)
	{
		ldriver.findElement(By.xpath("//input[@name='telephoneno']")).sendKeys(telphno);
		
	}	
	// to enter email		
	public void CustEmailid(String email)
	{
		ldriver.findElement(By.xpath("//input[@name='emailid']")).sendKeys(email);
	}	
	// to enter email		
	public void EnterPwd(String cpwd)
	{
		ldriver.findElement(By.xpath("//input[@name='password']")).sendKeys(cpwd);
	}
	
	// to get submitbtn		
	public void SubminBtn()
	{
		ldriver.findElement(By.xpath("//input[@value='Submit']")).click();
		
	}
	
	}
