package com.qalegend.testscript;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qalegend.utilities.TestHelper;
import com.qalegend.utilities.WaitUtility;

public class User extends TestHelper {
	public WebDriver driver;
	public User(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	

	@FindBy(xpath="//span[text()='User Management']")
	WebElement useMgm;
	
	@FindBy(xpath="//a[@href='https://qalegend.com/billing/public/users']")
	WebElement usertab;
	
	@FindBy(xpath="//section[@class='content-header']")
	WebElement userHeader;
	
	@FindBy(xpath="//a[@href='https://qalegend.com/billing/public/users/create']")
	WebElement addUser;
	
	@FindBy(xpath="//select[@name='users_table_length']")
	WebElement show;
	
	@FindBy(xpath="//div[@class='dt-button-background']")
	WebElement action;
	
	public void clickAction()
	{
		page.clickOnElement(action);
	}
	
	public void selectDropdown()
	{
		page.clickOnElement(show);
		page.dropDownSelectByvisibleText(show, "All");
	}
	
	public void elementClick()
	{
		page.clickOnElement(addUser);
	}
	
	public String elementText()
	{
		String s=page.getElementText(userHeader);
		return s;
	}
	
	public void javaClick()
	{
		page.javaScriptClick(useMgm, driver);
	}
	
	public void javaClickUser()
	{
		page.javaScriptClick(usertab, driver);
	}
	public void elementWait()
	{
		
		wait.waitForElementTOBeClickables(driver,"//select[@name='users_table_length']" );
	}
	
}
