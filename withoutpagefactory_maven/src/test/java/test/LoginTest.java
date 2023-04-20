package test;

import org.testng.annotations.Test;

import pageobject.LoginPage;
import utilities.Baseclass;

public class LoginTest extends Baseclass {
  @Test
  public void login() {
	  LoginPage l=new LoginPage(driver);
	  l.loginDetails();
	  
  }
}
