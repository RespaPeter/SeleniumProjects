package com.qalegend.pages;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

import com.qalegend.constants.Constants;
import com.qalegend.utilities.ExcelUtility;
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
	
	private final String _forgotPword="//a[@class='btn btn-link']";
	@FindBy(xpath=_forgotPword)
	private WebElement forgotPword;
		
	private final String _reremberMeCheckBox="//input[@type='checkbox']";
	@FindBy(xpath=_reremberMeCheckBox)
	private WebElement reremberMeCheckBox;
	
	private final String _restSubmit="//button[@class='btn btn-primary']";
	@FindBy(xpath=_restSubmit)
	WebElement resetSubmit;
	
	private final String _mssg="//div[@class='alert alert-success']";
	@FindBy(xpath=_mssg)
	WebElement mssg;
	
	@FindBy(id="email")
	WebElement _mailId;
	
	private final String _errorMsg="//span[@class='help-block']";
	@FindBy(xpath=_errorMsg)
	WebElement errorMsg;
	
	public void validLog(String uname,String pword)
	{
		page.login(user, pas, sub, uname, pword);
	}
	
	public String getElementMessage()
	{
		String msg=page.getMessage(mssg);
		return msg;
	}
	public void enterMailId(String mail)
	{
		page.enterText(_mailId, mail);
		
	}
	public void submitClick()
	{
		page.clickOnElement(resetSubmit);
	}
	
	public String getLoginPageTitle() {
		String title=page.getPageTitle(driver);
		return title;
	}
	public void clickForgotPword()
	{
		page.clickOnElement(forgotPword);
	}
	public void clickALert()
	{
		
		 page.clickOnElement(appTour);
	}
	public void clickOnRememberMeButton()
	{
		page.clickOnElement(reremberMeCheckBox);
	}
	public Boolean checkElementSelected()
	{
		Boolean st=page.isElementSelectes(reremberMeCheckBox);
		return st;

	}
	public String getErrorMsg()
	{
		String msg=page.getElementText(errorMsg);
		return msg;
	}
	
}

