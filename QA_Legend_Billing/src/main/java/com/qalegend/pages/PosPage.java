package com.qalegend.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qalegend.utilities.TestHelper;

public class PosPage extends TestHelper{

	public WebDriver driver;
	public PosPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//i[@class='fa fa-th-large']")
	WebElement posTab;
	
	@FindBy(xpath="(//div//h3[@class='box-title'][1])")
	WebElement posTitle;
	
	@FindBy(xpath = "//i[@class='fa fa-keyboard-o hover-q text-muted']")
	WebElement keyBor;
	
	@FindBy(id="select_location_id")
	WebElement location;
	
	@FindBy(xpath="(//span[@class='input-group-addon'][2])")
	WebElement loc;
	
	@FindBy(xpath = "//input[@class='select2-search__field']")
	WebElement price;
	public void elementWait()
	{
		
		wait.waitForElementTOBeClickables(driver,"//input[@class='select2-search__field']" );
	}
	
	public void selectPrice()
	{
		page.dropDownSelectByIndex(price, 1);
	}
	public void locationMouseHover()
	{
		page.mouseHoverWebElement(driver, loc);
	}
	public void selectLocation()
	{
		page.dropDownSelectByIndex(location, 1);
	}
	public void mouseHoverKey()
	{
		page.mouseHoverWebElement(driver, keyBor);
	}
	
	public String posTitle()
	{
		String s=page.getElementText(posTitle);
		return s;
	}
	public void clickPos()
	{
		page.clickOnElement(posTab);
	}
}
