package com.qalegend.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qalegend.utilities.TestHelper;

public class LoginPage extends TestHelper {
	public WebDriver driver;
	
	
public LoginPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	
}
private final String _userNameField="username";
@FindBy(id=_userNameField)
private WebElement userNameField;
private final String _passwordField="password";
@FindBy(id=_passwordField)
private WebElement passwordField;
private final String _loginButton="//button[@class='btn btn-primary']";
@FindBy(xpath=_loginButton)
private WebElement loginButton;
private final String _reremberMeCheckBox="//input[@type='checkbox']";
@FindBy(xpath=_reremberMeCheckBox)
private WebElement reremberMeCheckBox;

private final String _errorMessage="//strong[text()='These credentials do not match our records.']";
@FindBy(xpath = _errorMessage)
private WebElement errorMessage;

public String getLoginPageTitle()
{
	String title=page.getPageTitle(driver);
	return title;
}
public void enterUserName(String userName)
{
	page.enterText(userNameField, userName);
}

public void enterUserPassword(String userName)
{
	page.enterText(passwordField, userName);
}

public void loginButtonClick()
{
	page.submitElement(loginButton);
}
public String currentUrl()
{
	String url=page.getCurrentUrl(driver);
	return url;
}
public void clickOnRememberMeButton()
{
	page.clickOnElement(reremberMeCheckBox);
}
public String getErrorMessage()
{
	String msg=page.getErrorMessageText(errorMessage);
	return msg;
}
public Boolean checkElementSelected()
{
	Boolean st=page.isElementSelectes(reremberMeCheckBox);
	return st;
}
public void pageWait()
{
	wait.setPageLoadWait(driver);
}
}
