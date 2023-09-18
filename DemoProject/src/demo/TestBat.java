package demo;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestBat {
	public WebDriver driver;
	
  @Test(priority=0)
  public void CallBrowser() {
	  System.out.println("Hello world!");
	  
		//Chrome Browser
		System.setProperty("webdriver.chrome.driver","D:\\Selenium Final All\\chromedriver.exe");
		driver = new ChromeDriver();
	    driver.get("http://www.google.com");
	    driver.manage().window().maximize();
	    driver.quit();
  }
}
