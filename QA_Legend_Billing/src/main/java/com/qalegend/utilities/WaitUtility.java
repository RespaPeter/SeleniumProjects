package com.qalegend.utilities;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;
import com.qalegend.utilities.WaitUtility.LocatorType;

public class WaitUtility {
	public static final long EXPLICIT_WAIT=20000;
	public static final long IMPLICIT_WAIT=20;
	public static final long HARD_WAIT=20000;
	public static final long PAGE_LOAD_WAIT=20;
	public static final long FLUENT_WAIT=20;
	public static final long POLLING_TIME=5;
	
	public void setHardWait()
	{
		try
		{
			Thread.sleep(HARD_WAIT);
		}
		catch (InterruptedException e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
	
	public static void setImplicitWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(EXPLICIT_WAIT));
				
	}
	public static void setPageLoadWait(WebDriver driver)
	{
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_WAIT));
	}
	public enum LocatorType
	{
		Id,Name,Xpath,ClassName,CssSelector,TagName,LinkText,PartialLinkText;
	}
	public void waitForElementToBeVisible(WebDriver driver,String target,Enum locatorType)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(EXPLICIT_WAIT));
		if(locatorType.equals(LocatorType.Id))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(target)));
		}
		else if(locatorType.equals(LocatorType.ClassName))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(target)));
		}
		else if(locatorType.equals(LocatorType.CssSelector))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(target)));
		}
		else if(locatorType.equals(LocatorType.TagName))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(target)));
		}
		else if(locatorType.equals(LocatorType.LinkText))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(target)));
		}
		else if(locatorType.equals(LocatorType.PartialLinkText))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(target)));
		}
		else if(locatorType.equals(LocatorType.Name))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(target)));
		}
		else if(locatorType.equals(LocatorType.Xpath))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(target)));
		}
		else
		{
			throw new RuntimeException("Invalid Locator");
		}
	}
		public void waitForElementToBeClickable(WebDriver driver,String target,Enum locatorType)
		{
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(EXPLICIT_WAIT));
			if(locatorType.equals(LocatorType.Id))
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(target)));
			}
			else
			{
				throw new RuntimeException("Invalid Locator");
			}
			
		}
  
		public void setFluentWait(WebDriver driver,WebElement element)
		{
			Wait<WebDriver> waitfluent = new FluentWait<WebDriver>(driver)
				       .withTimeout(Duration.ofSeconds(30L))//max timeout
				       .pollingEvery(Duration.ofSeconds(5L))//poling interval
				       .ignoring(NoSuchElementException.class);

				   WebElement elemnt = waitfluent.until(new Function<WebDriver, WebElement>() {
				     public WebElement apply(WebDriver driver) 
				     {
			       return driver.findElement(By.id("element"));
				     }
				   }
				   );
		}
}
