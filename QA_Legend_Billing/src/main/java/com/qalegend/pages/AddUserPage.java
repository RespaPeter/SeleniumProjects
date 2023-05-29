package com.qalegend.pages;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qalegend.utilities.TestHelper;

public class AddUserPage extends TestHelper {
	public WebDriver driver;
	public AddUserPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	private final String _surName="surname";
	@FindBy(id=_surName)
	private WebElement surName;
	
	private final String _fName="first_name";
	@FindBy(id=_fName)
	private WebElement fName;
	
	private final String _lName="last_name";
	@FindBy(id=_lName)
	private WebElement lName;
	
	private final String _mail="email";
	@FindBy(id=_mail)
	private WebElement mail;
	
	private final String _role="select2-role-container";
	@FindBy(id=_role)
	private WebElement role;
	
	private final String _uName="username";
	@FindBy(id=_uName)
	private WebElement uName;
	
	private final String _passWordVari="password";
	@FindBy(id=_passWordVari)
	private WebElement passWordVari;
	
	private final String _selDrop="//select[@class='form-control select2 select2-hidden-accessible'][1]";
	@FindBy(xpath=_selDrop)
	private WebElement selDrop;
	
	private final String _confirmPass="confirm_password";
	@FindBy(id=_confirmPass)
	private WebElement confirmPass;
	
	private final String _salePer="cmmsn_percent";
	@FindBy(id=_salePer)
	private WebElement salePer;
	
	private final String _checkBox="//div[@class='icheckbox_square-blue'][1]";
	@FindBy(xpath=_checkBox)
	private WebElement checkBox;
	
	private final String _selectContact="//input[@class='select2-search__field']";
	@FindBy(xpath=_selectContact)
	private WebElement selectContact;
	
	private final String _options="//select[@name='selected_contact_ids[]']";
	@FindBy(xpath=_options)
	private WebElement options;
	
	
	private final String _button="submit_user_button";
	@FindBy(id=_button)
	private WebElement button;
	
	private final String _msg="//*[contains(text(),'User added successfully')]";
	@FindBy(xpath=_msg)
	private WebElement msg;
	
	private final String _existingMail="email-error";
	@FindBy(id=_existingMail)
	private WebElement existingMail;
	

	public void enterUserDetails(String prefix,String firstName,String lastName,String email,String userName,String passWord,String confirm,String commission)
	{
		page.enterText(surName, prefix);
		page.enterText(fName, firstName);
		page.enterText(lName, lastName);
		page.enterText(mail, email);
		page.enterText(uName, userName);
		page.enterText(passWordVari, passWord);
		page.enterText(confirmPass, confirm);
		page.enterText(salePer, commission);
		
		
	}
	
	public void selectRole()
	{
		page.clickOnElement(role);
		//page.dropDownSelectByvisibleText(selectDrop, "Specialist");
		page.dropDownSelectByIndex(selDrop, 2);
		page.clickOnElement(role);
	}
	
	
	public void elementWait()
	{
		
		wait.waitForElementTOBeClickables(driver,"//span[@class='select2-selection__rendered']" );
	}
	
	public void selectCheckBox()
	{
		page.clickOnElement(checkBox);
	}
	
	public void enterSelectContact() {
		page.clickOnElement(selectContact);
		page.dropDownSelectByIndex(options, 2);
		page.clickOnElement(selectContact);
		wait.setHardWait();
	}
	
	public void submitButtonClick()
	{
		page.clickOnElement(button);
	}
	
	public String getErrorMail()
	{
		String mailMsg=page.getElementText(existingMail);
		return mailMsg;
	}

	public String getMessage() {
		// TODO Auto-generated method stub
		String s=page.getMessage(msg);
		return s;
		
	}
	
}
