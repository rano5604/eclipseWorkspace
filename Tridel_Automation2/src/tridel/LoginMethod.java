package tridel;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

public class LoginMethod extends BaseClass {

	public String username;
	public String password;
	public String InvalidUsername;
	public String InvalidPassword;
	public String SpecialCharacters;
	public String browserType;
	public String getURL;
	public Integer getNumber;
	public String getString;
	public Integer getRandomNumber;
	public String actualTitle;
	public String expectedTitle = "Ionic App";
	public String signInValidationMessage;
	public String actualSignInValidationMessage;


	@Test(priority = 1)
	public void successfulLogin() throws Throwable {

		print("-----------Start successfulLogin-----------");
		
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

		//result as "Passed" or "Failed"
		if (actualTitle.contentEquals(expectedTitle)) {
			System.out.println("Page Title is: " + actualTitle);
		} else {
			System.out.println("Wrong Title Shows!");
		}

		// Going to click on Skip View button
		print("Going To Click Skip Button");
		clickAction(loginProp,"skipVideoButton");

		print("Going to Sign-in to the Tridel Site!");

		Thread.sleep(5000);
		enterValue(loginProp, "signInUserNameTextInput", username);
		enterValue(loginProp, "signInUserPasswordTextInput", password);

		print("Going to click on Get Started button");
		clickAction(loginProp,"signInBtnButton");
		Thread.sleep(5000);

		// Verify welcome link is present after login
		boolean WelcomeLink = findElement(loginProp, "navbarLogo").isDisplayed();
		if(WelcomeLink) {
			print("Successfully Login to the application!");
		}
		else {
			print("Unsuccessful Login!");
		}
		
		print("-----------End successfulLogin-----------");
	}
	
	
	@Test(priority = 2)
	public void successfulLogin(String fileName) throws Throwable {

		print("-----------Start successfulLogin-----------");
		
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

		//result as "Passed" or "Failed"
		if (actualTitle.contentEquals(expectedTitle)) {
			System.out.println("Page Title is: " + actualTitle);
		} else {
			System.out.println("Wrong Title Shows!");
		}

		// Going to click on Skip View button
		print("Going To Click Skip Button");
		clickAction(loginProp,"skipVideoButton");

		print("Going to Sign-in to the Tridel Site!");

		Thread.sleep(5000);
		enterValue(loginProp, "signInUserNameTextInput", username);
		enterValue(loginProp, "signInUserPasswordTextInput", password);

		print("Going to click on Get Started button");
		clickAction(loginProp,"signInBtnButton");
		Thread.sleep(5000);

		// Verify welcome link is present after login
		boolean WelcomeLink = findElement(loginProp, "navbarLogo").isDisplayed();
		if(WelcomeLink) {
			print("Successfully Login to the application!");
		}
		else {
			print("Unsuccessful Login!");
		}
		
		print("-----------End successfulLogin-----------");
	}
	


	@Test(priority = 0)
	public void unSuccessfulLogin() throws Throwable {
		
		print("-----------Start unSuccessfulLogin-----------");
		Properties loginProp = loadConfiguration("login");
		Properties configProp = loadConfiguration("config");
		username = loginProp.getProperty("username");
		password = loginProp.getProperty("password");
		InvalidUsername = loginProp.getProperty("InvalidUsername");
		InvalidPassword = loginProp.getProperty("InvalidPassword");
		SpecialCharacters = loginProp.getProperty("SpecialCharacters");
		browserType = configProp.getProperty("browserType");
		getURL = configProp.getProperty("getURL");
		actualSignInValidationMessage =  loginProp.getProperty("actualSignInValidationMessage");


		driver = BaseClass.open(browserType);

		// launch browser and go to the URL
		driver.get(getURL);
		driver.manage().window().maximize();

		// Verify home page title
		actualTitle = driver.getTitle();

		//result as "Passed" or "Failed"
		if (actualTitle.contentEquals(expectedTitle)) {
			System.out.println("Page Title is: " + actualTitle);
		} else {
			System.out.println("Wrong Title Shows!");
		}

		// Going to click on Skip View button
		print("Going To Click Skip Button");
		clickAction(loginProp,"skipVideoButton");
		Thread.sleep(5000);
		
		print("-----------Test Start-----------");
		// blank username and password
		print("Going to Sign-in with blank username and password!");
		//enterValue(loginProp, "signInUserNameTextInput", username);
		//enterValue(loginProp, "signInUserPasswordTextInput", password);
		print("Going to click on Get Started button");
		clickAction(loginProp,"signInBtnButton");
		Thread.sleep(5000);
		signInValidationMessage = driver.findElement(By.xpath("//div[@class='logo-row']")).getText();
		print(signInValidationMessage);
		if(signInValidationMessage.equals(actualSignInValidationMessage)) {
			print("Passed: the validation message matched: "+actualSignInValidationMessage);
		}else {
			print("Failed: validation message does not matach!");
		}
		Thread.sleep(5000);
		
		print("-----------Test Start-----------");
		// blank username
		print("Going to Sign-in with blank username!");
		//enterValue(loginProp, "signInUserNameTextInput", username);
		enterValue(loginProp, "signInUserPasswordTextInput", password);
		print("Going to click on Get Started button");
		clickAction(loginProp,"signInBtnButton");
		Thread.sleep(5000);
		signInValidationMessage = driver.findElement(By.xpath("//div[@class='logo-row']")).getText();
		print(signInValidationMessage);
		if(signInValidationMessage.equals(actualSignInValidationMessage)) {
			print("Passed: the validation message matched: "+actualSignInValidationMessage);
		}else {
			print("Failed: validation message does not matach!");
		}
		Thread.sleep(5000);
		
		/*
		print("-----------Test Start-----------");
		// blank password
		print("Going to Sign-in with blank password!");
		enterValue(loginProp, "signInUserNameTextInput", username);
		//enterValue(loginProp, "signInUserPasswordTextInput", password");
		print("Going to click on Get Started button");
		clickAction(loginProp,"signInBtnButton");
		Thread.sleep(5000);
		signInValidationMessage = driver.findElement(By.xpath("//div[@class='logo-row']")).getText();
		print(signInValidationMessage);
		if(signInValidationMessage.equals(actualSignInValidationMessage)) {
			print("Passed: the validation message matched: "+actualSignInValidationMessage);
		}else {
			print("Failed: validation message does not matach!");
		}
		Thread.sleep(5000);
		*/

		print("-----------Test Start-----------");
		// Invalid username
		print("Going to Sign-in with Invalid username!");
		enterValue(loginProp, "signInUserNameTextInput", InvalidUsername);
		enterValue(loginProp, "signInUserPasswordTextInput", password);

		print("Going to click on Get Started button");
		clickAction(loginProp,"signInBtnButton");

		if(signInValidationMessage.equals(actualSignInValidationMessage)) {
			print("Passed: the validation message matched: "+actualSignInValidationMessage);
		}else {
			print("Failed: validation message does not matach!");
			Thread.sleep(5000);

			print("-----------Test Start-----------");
			// Invalid password
			print("Going to Sign-in with Invalid password!");
			enterValue(loginProp, "signInUserNameTextInput", username);
			enterValue(loginProp, "signInUserPasswordTextInput", InvalidPassword);

			print("Going to click on Get Started button");
			clickAction(loginProp,"signInBtnButton");
			if(signInValidationMessage.equals(actualSignInValidationMessage)) {
				print("Passed: the validation message matched: "+actualSignInValidationMessage);
			}else {
				print("Failed: validation message does not matach!");
				Thread.sleep(5000);

				print("-----------Test Start-----------");
				// Invalid username and password
				print("Going to Sign-in with Invalid username and password!");
				enterValue(loginProp, "signInUserNameTextInput", InvalidUsername);
				enterValue(loginProp, "signInUserPasswordTextInput", InvalidPassword);

				print("Going to click on Get Started button");
				clickAction(loginProp,"signInBtnButton");
				if(signInValidationMessage.equals(actualSignInValidationMessage)) {
					print("Passed: the validation message matched: "+actualSignInValidationMessage);
				}else {
					print("Failed: validation message does not matach!");
					Thread.sleep(5000);

					print("-----------Test Start-----------");
					// Special character in username and password
					print("Going to Sign-in with Special character in username and password!");
					enterValue(loginProp, "signInUserNameTextInput", SpecialCharacters);
					enterValue(loginProp, "signInUserPasswordTextInput", SpecialCharacters);

					print("Going to click on Get Started button");
					clickAction(loginProp,"signInBtnButton");
					if(signInValidationMessage.equals(actualSignInValidationMessage)) {
						print("Passed: the validation message matched: "+actualSignInValidationMessage);
					}else {
						print("Failed: validation message does not matach!");
						Thread.sleep(5000);

						// Verify welcome link is present after login
						boolean WelcomeLink = findElement(loginProp, "navbarLogo").isDisplayed();
						if(WelcomeLink) {
							print("Successfully Login to the application!");
						}
						else {
							print("Unsuccessful Login!");
						}
					}
				}
			}
		}
		
		print("-----------End UnSuccessfulLogin-----------");
	}
}

