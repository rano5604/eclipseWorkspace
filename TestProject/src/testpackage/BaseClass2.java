package testpackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BaseClass2 {

	@Test
	public static void loading_test () throws InterruptedException {

		System.out.println("Loading test start");

		System.setProperty("webdriver.chrome.driver", "D:\\Selenium Final All\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://bestrentnj.com/all-nj-apartments");
		Thread.sleep(10000);

		List<WebElement> linksize = driver.findElements(By.cssSelector("[href*=Communities]"));
		int linksCount = linksize.size();
		System.out.println("Total no of links Available: "+linksCount);

		String[] links = new String[linksCount];
		for(int i=0;i<linksCount;i++) {
			String url = linksize.get(i).getAttribute("href");
			links[i] = url;
		}
		// navigate to each Link on the webpage
		String baseUrl = "https://bestrentnj.com";
		for(int i=0;i< linksCount;i++)
		{ 
			try {
				String url = links[i];
				if(url.contains("http")) {
					//continue;
				}else {
					url = baseUrl + url;
				}

				Boolean result = url.contains("Communities");
				System.out.println(url);
				System.out.println(result);
				if(result) {
					driver.navigate().to(url);
					Thread.sleep(2000);
				}
			}catch (Exception error) {
				System.out.println("Got error at " + i + error.getMessage());
				System.out.println(error.getStackTrace());
				//break;
			}
		}
	}




}