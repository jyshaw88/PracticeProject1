package com.PracticeProject.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage 
{
	WebDriver ldriver;
	public LoginPage(WebDriver rdriver)
	{
		this.ldriver = rdriver;
	}
	//get webelement of the login webpage
	public WebElement getUserID()
	{
		WebElement UserTextbox = ldriver.findElement(By.name("uid"));
		return UserTextbox;
	}
	
	public WebElement getPassword()
	{
		WebElement PasswordTextbox = ldriver.findElement(By.name("password"));
		return PasswordTextbox;
	}
	
	public WebElement getLoginButton()
	{
		WebElement LoginButton = ldriver.findElement(By.name("btnLogin"));
		return LoginButton;
	}
	public WebElement getLogoutLink()
	{
		WebElement Logout = ldriver.findElement(By.linkText("Log out"));
		return Logout;
	}
	
}
