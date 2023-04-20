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
	private final String _calculator="btnCalculator";
	@FindBy(id=_calculator)
	private WebElement calculator;
	private final String _appTour="//button[@class='btn btn-default btn-sm']";
	@FindBy(xpath = _appTour)
	private WebElement appTour;
	
	private final String _pos="//i[@class='fa fa-th-large']";
	@FindBy(xpath = _pos)
	private WebElement pos;
	
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
	
	
}
