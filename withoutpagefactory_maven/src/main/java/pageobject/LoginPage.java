package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.testng.annotations.Test;

public class LoginPage {
  WebDriver driver;
  public void loginDetails()
  {
	  WebElement user=driver.findElement(By.name("UserName"));
	 // driver.navigate().refresh();
	  user.sendKeys("abc");
	  WebElement pass=driver.findElement(By.name("Password"));
	  pass.sendKeys("password");
	  WebElement login=driver.findElement(By.name("Login"));
	  login.click();
  }
  public LoginPage(WebDriver driver)
  {
	this.driver=driver;  
  }
}
