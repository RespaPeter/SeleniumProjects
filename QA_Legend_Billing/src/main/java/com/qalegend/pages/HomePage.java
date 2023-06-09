package com.qalegend.pages;



import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qalegend.utilities.TestHelper;

public class HomePage extends TestHelper {
	public WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	private final String _calculator="//i[@class='fa fa-calculator fa-lg']";
	@FindBy(xpath=_calculator)
	private WebElement calculator;
	private final String _appTour="//button[@class='btn btn-default btn-sm']";
	@FindBy(xpath = _appTour)
	private WebElement appTour;
	
	private final String _pos="//i[@class='fa fa-th-large']";
	@FindBy(xpath = _pos)
	private WebElement pos;
	
	
	
	private final String _userMgmt="//a[@href='https://qalegend.com/billing/public/users']";
	@FindBy(xpath=_userMgmt)
	private WebElement userMgmt;
	
	@FindBy(xpath="//h3[@class='popover-title']")
	WebElement cal;
	
	@FindBy(xpath="//section[@class='content-header']")
	WebElement header;
	
	public String elementText()
	{
		String s=page.getElementText(header);
		return s;
	}
	
	public void clickALert()
	{
		
		 page.clickOnElement(appTour);
	}
	
	  
	public void clickElement()
	{
		page.clickOnElement(calculator);
	}
	
	public void posClick()
	{
		page.clickOnElement(pos);
	}
	
		
	public boolean elementDisplayed()
	{
		boolean status=page.isElementDisplayed(userMgmt);
		return status;
		
	}
	public String elementTexte()
	{
		String value=page.getElementText(cal);
		return value;
	}
}
