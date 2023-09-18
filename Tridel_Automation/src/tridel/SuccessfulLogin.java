package tridel;

import org.junit.Test;
import java.util.Properties;

public class SuccessfulLogin extends BaseClass {

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

	// @Test(priority = 0)
	// public void successfulLogin() throws Throwable {
	
	@Test
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
		Thread.sleep(10000);

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
	
}

