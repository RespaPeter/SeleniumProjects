package com.qalegend.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qalegend.utilities.TestHelper;

public class SignOutTabPage extends TestHelper {
	public WebDriver driver;
	public SignOutTabPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	private final String _tab="//a[@class='dropdown-toggle']";
	@FindBy(xpath=_tab)
	private WebElement tab;
	
	
	private final String _window="//li[@class='user-header']";
	@FindBy(xpath=_window)
	private WebElement window;
	
	private final String _signoutButton="//div[@class='pull-right']";
	@FindBy(xpath=_signoutButton)
	private WebElement signoutButton;
	
	private final String _profileButton="//div[@class='pull-left']";
	@FindBy(xpath=_profileButton)
	private WebElement profileButton;
	
	private final String _currentpwordText="current_password";
	@FindBy(id=_currentpwordText)
	private WebElement currentpwordText;
	
	private final String _newPassVar="new_password";
	@FindBy(id=_newPassVar)
	private WebElement newPassVar;
	
	private final String _confirPassVar="confirm_password";
	@FindBy(id=_confirPassVar)
	private WebElement confirPassVar;
	
	private final String _updateButton="//*[@id=\"edit_password_form\"]/div/div/div/div[2]/button";
	@FindBy(xpath=_updateButton)
	private WebElement updateButton;
	
	private final String _pref="surname";
	@FindBy(id=_pref)
	private WebElement pref;
	
	private final String _fName="first_name";
	@FindBy(id=_fName)
	private WebElement fName;
	
	private final String _passUpdMsg="//*[contains(text(),'Password updated successfully')]";
	@FindBy(xpath=_passUpdMsg)
	private WebElement passUpdMsg;
	
	private final String _lName="last_name";
	@FindBy(id=_lName)
	private WebElement lName;
	
	private final String _mail="email";
	@FindBy(id=_mail)
	private WebElement mail;
	
	private final String _selectlang="//span[@class='select2-selection__rendered']";
	@FindBy(xpath=_selectlang)
	private WebElement selectlang;
	
	private final String _langu="//select[@class='form-control select2 select2-hidden-accessible']";
	@FindBy(xpath=_langu)
	private WebElement langu;
	
	private final String _update="//*[@id=\"edit_user_profile_form\"]/div[2]/div/button";
	@FindBy(xpath=_update)
	private WebElement update;
	
	private final String _upmsg="//*[contains(text(),'Profile updated successfully')]";
	@FindBy(xpath=_upmsg)
	private WebElement upmsg;
	
	public void tabClick()
	{
		page.clickOnElement(tab);
	}
	public String getWindowTitle()
	{
		String s=page.getElementText(window);
		return s;
	}
	public void signOutButtonClick()
	{
		page.clickOnElement(signoutButton);
	}
	public String getPageTitle()
	{
		String title=page.getPageTitle(driver);
		return title;
	}
	public void profileButtonClick()
	{
		page.clickOnElement(profileButton);
	}
	public void enterDetailsforUpdate(String prefix,String firstName,String lastName,String email)
	{
		page.clickOnElement(pref);
		page.enterText(pref, prefix);
		page.clickOnElement(fName);
		page.enterText(fName, firstName);
		page.clickOnElement(lName);
		page.enterText(lName, lastName);
		page.clickOnElement(mail);
		page.enterText(mail, email);
		
	}
	public void changePassword(String current,String newPass,String confPass)
	{
		page.enterText(currentpwordText, current);
		page.enterText(newPassVar, newPass);
		page.enterText(confirPassVar, confPass);
		page.clickOnElement(updateButton);
	}
	
	public void selectLanguage()
	{
		page.clickOnElement(selectlang);
		page.dropDownSelectByIndex(langu, 0);
	}
	
	public String passwordUpdateMessage()
	{
		String passMsg=page.getElementText(passUpdMsg);
		return passMsg;
	}
	public void ClickUpdateButton()
	{
		page.clickOnElement(update);
	}
	public String getMessage() {
		// TODO Auto-generated method stub
		String s=page.getElementText(upmsg);
		return s;
		
	}
}
