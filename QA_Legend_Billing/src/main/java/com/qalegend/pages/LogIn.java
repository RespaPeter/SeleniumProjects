package com.qalegend.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qalegend.utilities.TestHelper;

public class LogIn extends TestHelper{

	public WebDriver driver;
	public LogIn(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(id="username")
	WebElement user;
	
	@FindBy(id="password")
	WebElement pas;
	@FindBy(xpath="//button[@class='btn btn-primary']")
	WebElement sub;
	private final String _appTour="//button[@class='btn btn-default btn-sm']";
	@FindBy(xpath = _appTour)
	private WebElement appTour;
	
	public void validLog(String uname,String pword)
	{
		page.login(user, pas, sub, uname, pword);
	}
	public void clickALert()
	{
		
		 page.clickOnElement(appTour);
	}
	
}
