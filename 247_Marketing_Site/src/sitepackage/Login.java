package sitepackage;

import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login extends BaseClass {

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
	public void successfulLogin() throws InterruptedException, IOException {

		Properties loginProp = loadConfiguration("login");
		Properties configProp = loadConfiguration("config");
		username = loginProp.getProperty("username");
		password = loginProp.getProperty("password");
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

		print("Going to Sign-in with Marketing Site!");

		Thread.sleep(10000);
		
		driver.findElement(By.xpath("//*[@id='lnkTopLoginRequired']")).click();
		
		Thread.sleep(10000);
		driver.switchTo().frame(driver.findElement(By.className("fancybox-iframe")));
		//driver.switchTo().activeElement();
		
		print("Going to login into the system");
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@id='UserName']")).sendKeys(username);
		Thread.sleep(5000);
		print("Going to provide the user phone number.");
		print(username);
		
		driver.findElement(By.xpath("//*[@id='Password']")).sendKeys(password);
		print("Going to provide the password");
		print(password);
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='btnLogin']")).click();
		print("Going to Click the login");
		
		Thread.sleep(3000);
		// Verify welcome link is present after login
		boolean WelcomeLink = driver.findElement(By.xpath("//*[@id='lnkWelcome']")).isDisplayed();
		if(WelcomeLink) {
			print("Successfully Login to the application!");
		}
		else {
			print("Unsuccessful Login!");
		}
		
	
	}
}


