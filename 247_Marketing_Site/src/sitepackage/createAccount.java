package sitepackage;


import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class createAccount extends BaseClass {

	public String username;
	public String password;
	public String browserType;
	public String getURL;
	public Integer getNumber;
	public String getString;
	public Integer getRandomNumber;
	WebDriver driver;
	public String actualTitle;
	public String expectedTitle = "Beaver Homes and Cottages - Home";

	@Test(priority = 0)
	public void homePage() throws InterruptedException, IOException {

		Properties createAccountProp = loadConfiguration("createAccount");
		Properties configProp = loadConfiguration("config");
		username = configProp.getProperty("username");
		password = configProp.getProperty("password");
		browserType = configProp.getProperty("browserType");
		getURL = configProp.getProperty("getURL");

		driver = BaseClass.open(browserType);

		// launch browser and go to the URL
		driver.get(getURL);
		driver.manage().window().maximize();

		// Verify home page title

		actualTitle = driver.getTitle();
		/*
		 * compare the actual title of the page with the expected one and print the
		 * result as "Passed" or "Failed"
		 */
		if (actualTitle.contentEquals(expectedTitle)) {
			System.out.println("Test Title is: " + actualTitle);
		} else {
			System.out.println("Wrong Title Shows!");
		}

		

		Thread.sleep(10000);
		
		//Click to the Sign In link
		driver.findElement(By.xpath("//*[@id='lnkTopLoginRequired']")).click();
		print("Going to click on Sign In link");
		
		// navigate to iFrame
		Thread.sleep(10000);
		driver.switchTo().frame(driver.findElement(By.className("fancybox-iframe")));
		
		print("Going to login into the system");
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@id='UserName']")).sendKeys(username);
		Thread.sleep(10000);
		print("Going to provide the user phone number.");
		print(username);
		
		driver.findElement(By.xpath("//*[@id='Password']")).sendKeys(password);
		print("Going to provide the password");
		print(password);
		
		driver.findElement(By.xpath("//*[@id='btnLogin']")).click();
		print("Going to Click the login");
		
		//Close the iFrame window
		//driver.findElement(By.className("fa-times")).click();
		
	}
}



