package com.qalegend.pages;

import java.io.IOException;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

import com.qalegend.constants.Constants;
import com.qalegend.utilities.ExcelUtility;
import com.qalegend.utilities.TestHelper;
import com.qalegend.utilities.WaitUtility;

public class UserManagment extends TestHelper {
	private static final Enum Xpath = null;
	public WebDriver driver;
	public UserManagment(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	private final String _mgmentUser="//span[text()='User Management']";
	@FindBy(xpath=_mgmentUser)
	private WebElement mgmentUser;
	
	private final String _userTab="//a[@href='https://qalegend.com/billing/public/users']";
	@FindBy(xpath=_userTab)
	private WebElement userTab;
	
	private final String _addUser="//a[@href='https://qalegend.com/billing/public/users/create']";
	@FindBy(xpath=_addUser)
	private WebElement addUser;
	
	private final String _showUser="//select[@name='users_table_length']";
	@FindBy(xpath=_showUser)
	private WebElement showUser;
	
	private final String _numshowUser="users_table_info";
	@FindBy(id=_numshowUser)
	private WebElement numshowUser;
	
	private final String _numUser="users_table_info";
	@FindBy(id=_numUser)
	private WebElement numsUser;
	
	private final String _searchUser="//input[@class='form-control input-sm']";
	@FindBy(xpath=_searchUser)
	private WebElement searchUser;

	private final String _table="users_table";
	@FindBy(id=_table)
	private WebElement table;
	
	private final String _tabletr="//table[@class='table table-bordered table-striped dataTable no-footer']";
	@FindBy(xpath=_tabletr)
	private WebElement tabletr;
	
	/*private final String _tabletr="//table/tbody/tr";
	@FindBy(xpath=_tabletr)
	private WebElement tabletr;*/
	
	
	
	public String getnumberShowUser()
	{
		page.ScrollToBottomOfThePage(driver);
		String s=page.getElementText(numsUser);
		return s;
	}
	
	public void userMgClick()
	{
		
		page.clickOnElement(mgmentUser);
	}

	public void userTabClick()
	{
		page.clickOnElement(userTab);
	}

	public boolean elementCheck()
	{
		boolean status=page.isElementDisplayed(userTab);
		return status;
	}
	public String userPageTitle()
	{
		String s=page.getPageTitle(driver);
		return s;
	}
	public void addUser()
	{
		page.clickOnElement(addUser);
	}
	
	public void showUserClick()
	{
		page.clickOnElement(showUser);
	}
	
	public void selectShowUser()
	{
		page.clickOnElement(showUser);
		page.dropDownSelectByvisibleText(showUser, "25");
	}
	public void pageWait()
	{
		//wait.setPageLoadWait(driver);
		wait.setHardWait();
		
		//wait.waitForElementTOBeClickables(driver,"//select[@name='users_table_length']" );

	}
	
	public void pageDown()
	{
		page.ScrollToBottomOfThePage(driver);
		wait.setHardWait();
		
		//wait.waitForElementToBeVisible(driver, "//*[@id=\\\"users_table\\\"]/tbody/tr[25]", Xpath);
	}
	public void searchUser(String search)
	{
		page.enterText(searchUser, search);
	}
	
	public int getRowSize()
	{
		
	List<WebElement> li=tabletr.findElements(By.tagName("tr"));
	int s=li.size();
	return s;
		
	}
}
