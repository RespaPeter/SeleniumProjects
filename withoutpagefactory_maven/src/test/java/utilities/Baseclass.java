package utilities;



import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class Baseclass {
	public WebDriver driver;
	
  
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.http.factory", "jdk-http-client");
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\PRAGAL\\OneDrive\\Desktop\\chromedriver\\chromedriver.exe");
	  driver =new ChromeDriver();
	  driver.get("https://demosite.executeautomation.com/Login.html");
	  driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}
