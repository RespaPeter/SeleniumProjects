package com.qalegend.utilities;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public String getPageTitle(WebDriver driver)
	{
		String title=driver.getTitle();
		return title;
	}
 
	public void javaScriptValue(WebElement element,String text,WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		 js.executeScript("arguments[0].value='text';", element);
		
	}
	public void javaScriptClick(WebElement element,WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		 js.executeScript("arguments[0].click();", element);
		
	}
	public String getCurrentUrl(WebDriver driver)
	{
		String url=driver.getCurrentUrl();
		return url;
	}
	public String getPageSource(WebDriver driver)
	{
		String pageSource=driver.getPageSource();
		return pageSource;
	}
	public String getErrorMessageText(WebElement element)
	{
		String errorMessage=element.getText();
		return errorMessage;
	}
	public void pageRefresh(WebDriver driver)
	{
		driver.navigate().refresh();
	}
	public void pageForward(WebDriver driver)
	{
		driver.navigate().forward();
	}
	public void pageBackward(WebDriver driver)
	{
		driver.navigate().back();
	}
	public String getWindowHandleId(WebDriver driver)
	{
		String handleId=driver.getWindowHandle();
		return handleId;
	}
	public Set<String> getWindowHandles(WebDriver driver)
	{
		Set<String> handles=driver.getWindowHandles();
		return handles;
	}
	public void clickOnElement(WebElement element)
	{
		element.click();
	}
	public void submitElement(WebElement element)
	{
		element.submit();
	}
	public void enterText(WebElement element,String text)
	{
		element.sendKeys(text);
	}
	public void simpleAlert(WebDriver driver)
	{
		Alert alert=driver.switchTo().alert();
		alert.accept();
	}
	
	public void confirmationAlert(WebDriver driver)
	{
		Alert alert=driver.switchTo().alert();
		alert.accept();
	}
	
	public void promptAlert(WebDriver driver,String text)
	{
		Alert alert=driver.switchTo().alert();
		alert.sendKeys(text);
		alert.accept();
		
	}
	public void rightClick(WebDriver driver,WebElement target)
	{
		Actions action=new Actions(driver);
		action.contextClick(target).build().perform();
	}
	public void doubleClick(WebDriver driver,WebElement target)
	{
		Actions action=new Actions(driver);
		action.doubleClick(target).build().perform();
	}
	public void mouseOver(WebDriver driver,WebElement target)
	{
		Actions action=new Actions(driver);
		action.moveToElement(target).build().perform();
	}
	public String getElementText(WebElement element)
	{
		String text=element.getText();
		return text;
	}
	public void DragandDrop(WebDriver driver,WebElement source,WebElement destination)
	{
		Actions action=new Actions(driver);
		action.dragAndDrop(source, destination).build().perform();
	}
	public void DragandDropByOffset(WebDriver driver,WebElement source,int x,int y)
	{
		Actions action=new Actions(driver);
		action.dragAndDropBy(source,x,y).build().perform();
	}
	public void reSize(WebDriver driver,WebElement source,int x,int y)
	{
		Actions action=new Actions(driver);
		action.clickAndHold().dragAndDropBy(source, x, y).build().perform();
		action.release(source).build().perform();
	}
	public void mouseOverByOffsetAndWebElement(WebDriver driver,WebElement target,int x,int y)
	{
		Actions action=new Actions(driver);
		action.moveToElement(target, x, y).build().perform();
	}
	public void mouseOverByOffset(WebDriver driver,int x,int y)
	{
		Actions action=new Actions(driver);
		action.moveByOffset( x, y).build().perform();
	}
	public void dropDownSelectByIndex(WebElement target,int index)
	{
		Select select=new Select(target);
		select.selectByIndex(index);
	}
	public void dropDownSelectByIndex(WebElement target,String attributeValue)
	{
		Select select=new Select(target);
		select.selectByValue(attributeValue);
	}
	public void dropDownSelectByvisibleText(WebElement target,String text)
	{
		Select select=new Select(target);
		select.selectByVisibleText(text);
	}
	public List<WebElement> getAlldropDownOptions(WebElement target,String text)
	{
		Select select=new Select(target);
		List<WebElement> dropDownOptions=select.getOptions();
		return dropDownOptions;
	}
	public List<WebElement> getAllSelectedOptions(WebElement target,String text)
	{
		Select select=new Select(target);
		List<WebElement> selectedOptions=select.getAllSelectedOptions();
		return selectedOptions;
		
	}
	public String getFirstSelectedOption(WebElement target)
	{
		Select select=new Select(target);
		String text=select.getFirstSelectedOption().getText();
		return text;
		
	}
	
	public Boolean isElementSelectes(WebElement element)
	{
		boolean value=element.isSelected();
		return value;
		
	}
	public Boolean isElementDisplayed(WebElement element)
	{
		boolean value=element.isSelected();
		return value;
		
	}
  
}
