package sitepackage;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class NewTest {
  @Test
  public void f() {
	  
	  System.setProperty("webdriver.chrome.driver", "D:\\Selenium Final All\\chromedriver.exe");
	  	
	  	WebDriver driver = new ChromeDriver();
	  	
		driver.get("http://toolsqa.wpengine.com/");
	  
			List<WebElement> links=driver.findElements(By.tagName("a"));
			  ArrayList<String> targets = new ArrayList<String>();
			  //collect targets locations
			  for (WebElement link : links) {
				  System.out.println(link.getAttribute("href"));
			      targets.add(link.getAttribute("href"));
			  }
			  for (String target : targets) {
				  if((target.contains("contacts"))) {
					  System.out.println("Only xyz links: "+target);
			  }else {
				System.out.println("Failed");
			}
  }
			  }
}
