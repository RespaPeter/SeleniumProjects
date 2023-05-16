package com.qalegend.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qalegend.utilities.TestHelper;

public class ProfitPage extends TestHelper {
	public WebDriver driver;
	public ProfitPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//i[@class='fa fa-money fa-lg']")
	WebElement profitElement;
	
	@FindBy(xpath="//button[@class='btn btn-default']")
	WebElement message;
	
	@FindBy(id="myModalLabel")
	WebElement title;
	@FindBy(xpath="//button[@class='close']")
	WebElement closeButton;
	
	public String getTitle()
	{
		String s=page.getElementText(title);
		return s;
	}

	public void clickElement()
	{
		page.clickOnElement(profitElement);
	}
	public void alertBoxtClose()
	{
		page.clickOnElement(message);
		
	}
	public void elementWait()
	{
		
		wait.waitForElementTOBeClickables(driver,"//button[@class='btn btn-default']" );
	}
	
	public void buttonClose()
	{
		page.clickOnElement(closeButton);
	}
}
