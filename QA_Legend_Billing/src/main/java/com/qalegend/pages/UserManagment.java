package com.qalegend.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qalegend.utilities.TestHelper;
import com.qalegend.utilities.WaitUtility;

public class UserManagment extends TestHelper {
	public WebDriver driver;
	public UserManagment(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	private final String _mgmentUser="//span[text()='User Management']";
	@FindBy(xpath=_mgmentUser)
	private WebElement mgmentUser;
	
	@FindBy(xpath="(//ul[@class='treeview-menu'])[0]")
	WebElement menuList;
	/*
	@FindBy(xpath="//ul[@class='treeview-menu menu-open']")
	WebElement menu;
	*/
	
	@FindBy(xpath="(//i[@class='fa fa-angle-left pull-right'])[1]")
	WebElement elem;
	
	public void userMgClick()
	{
		page.clickOnElement(mgmentUser);
	}

	public boolean elementDisplayed()
	{
		boolean status=page.isElementDisplayed(menuList);
		return status;
	}
	public void elementWait()
	{
		
		WaitUtility.setImplicitWait(driver);
	}

	
}
