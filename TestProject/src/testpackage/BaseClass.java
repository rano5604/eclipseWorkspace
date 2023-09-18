package testpackage;

import java.awt.print.Printable;
import java.io.File;
import java.util.List;

import org.junit.validator.PublicClassValidator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.steadystate.css.parser.selectors.AndConditionImpl;

public class BaseClass {

	public WebDriver driver;

	@Test
	public void f() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:\\Selenium Final All\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://bestrentnj.com");
		Thread.sleep(10000);

		java.util.List<WebElement> links = driver.findElements(By.cssSelector("[href*=Communities]"));

		System.out.println(links.size());

		for(int i=0;i<links.size();i++)
		{	
			try {
				String url = links[i];
				if(url.)
			}
			
			// if(links.get(i).getAttribute("href").contains("abc")) {

			/*	System.out.println("Only community links: "+links.get(i).getAttribute("href"));
		driver.navigate().to(links.get(i).getAttribute("href"));
		Thread.sleep(2000); */


		}
	}

}
