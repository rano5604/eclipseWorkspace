package evision;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Login extends BaseClass {
	
	public String actualHomePageTitle;
	public String expectedHomePageTitle;
	public String username;
	public String password;
	
	//Before Login Verify Home page title
	 @Test(priority = 1)
	 public void beforeLoginVerifyHomePageTitle() {
		  print("Before login verify page title: ");
		  actualHomePageTitle = driver.getTitle();
		  driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
		  print(actualHomePageTitle);
	 }
	 
	//Login with valid Username and Password
	 @Test(priority = 2)
	 	public void logIn() {
		 
		 username = prop.getProperty("username");
		 password = prop.getProperty("password");
		
		// Provide data into the Username field
		findElementByCssSelector("input#ctl00_ContentPlaceHolder1_UsernameTextBox").sendKeys(username);
		
		// Provide data into the Password field
		findElementByCssSelector("input[title=\"Password\"]").sendKeys(password);
		
		// Click on Login button
		findElementByCssSelector("input#ctl00_ContentPlaceHolder1_SubmitButton").click();
		
	 }
	 
	 //After Login Verify Home page title
	 @Test(priority = 3)
	 	public void afterLoginVerifyHomePageTitle() {
		 print("After login verify page title: ");
		 expectedHomePageTitle = "..E=Vision";
		 actualHomePageTitle = driver.getTitle();
		 print(actualHomePageTitle);
		 driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		 Assert.assertEquals(actualHomePageTitle, expectedHomePageTitle);
	 }
	 
}
