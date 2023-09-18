package tridel;

import org.testng.annotations.Test;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class NavigateToSpecificURL extends BaseClass{

	public String browserType;
	public String URL;

	@Test(priority = 0)
	public void pageLinks () throws Throwable {

		Properties configProp = loadConfiguration("config");
		browserType = configProp.getProperty("browserType");
		URL = "http://tridelbeta.247salescenter.com/vdcapp/www/";


		driver = BaseClass.open(browserType);

		// launch browser and go to the URL
		driver.get(URL);
		driver.manage().window().maximize();

		print("Navigate to the page");
		Thread.sleep(10000);

		List<WebElement> linksize = driver.findElements(By.cssSelector("[href*=vdcapp]"));
		int linksCount = linksize.size();
		System.out.println("Total no of links Available: "+linksCount);

		String[] links = new String[linksCount];
		for(int i=0;i<linksCount;i++) {
			String url = linksize.get(i).getAttribute("href");
			links[i] = url;
		}
		// navigate to each Link on the webpage
		String baseUrl = "http://tridelbeta.247salescenter.com";
		for(int i=0;i< linksCount;i++)
		{ 
			try {
				String url = links[i];
				if(url.contains("http")) {
					//continue;
				}else {
					url = baseUrl + url;
				}

				Boolean result = url.contains("vdcapp");
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