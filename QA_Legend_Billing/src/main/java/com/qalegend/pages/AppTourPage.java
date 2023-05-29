package com.qalegend.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qalegend.utilities.TestHelper;

public class AppTourPage extends TestHelper {
	public WebDriver driver;
	public AppTourPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	private final String _appTourEnd="//button[@class='btn btn-default btn-sm']";
	@FindBy(xpath = _appTourEnd)
	private WebElement appTourEnd;
	
	private final String _appTourTab="start_tour";
	@FindBy(id=_appTourTab)
	private WebElement appTourTab;
	
	private final String _appTourMsg="step-0";
	@FindBy(id=_appTourMsg)
	private WebElement appTourMsg;
	
	public void clickALert()
	{
		
		 page.clickOnElement(appTourEnd);
	}
	

	public void applicationTourTab()
	{
		page.clickOnElement(appTourEnd);
	}
	public void elementWait()
	{
		wait.setHardWait();
		//wait.waitForElementTOBeClickables(driver,"//button[@class='btn btn-default btn-sm']");
	}
	public void windowWait()
	{
		wait.setPageLoadWait(driver);
	}
}
