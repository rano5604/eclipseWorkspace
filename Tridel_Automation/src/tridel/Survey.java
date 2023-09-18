package tridel;

import org.testng.annotations.Test;

import java.util.Properties;

public class Survey extends SuccessfulLogin {

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
	public void surveyForm() throws Throwable {
		
		//Login to the application
		successfulLogin("Survey");
		//successfulLogin();
		Thread.sleep(5000);


		print("-----------Start Survey Form Submission-----------");
		
		Properties surveyProp = loadConfiguration("survey");
		
		// Going to click on Skip View button
		print("Going To Click on a Unit");
		clickAction(surveyProp,"selectUnit");

		Thread.sleep(5000);
		
		// Going to select Pets checkbox
		print("Going to select Yes checkbox");
		clickAction(surveyProp,"petsCheck");
		
		// Going to select from drop-down list
		print("Going to select No from drop-down list");
		clickAction(surveyProp,"loveCookies");
		Thread.sleep(2000);
		clickAction(surveyProp,"selectNo");
		Thread.sleep(2000);
		
		// Going to select Sports checkbox
		print("Going to select Sports checkbox");
		clickAction(surveyProp,"sportsCheck1");
		Thread.sleep(2000);
		clickAction(surveyProp,"sportsCheck2");
		Thread.sleep(2000);
		
		// Going to select Kids Radio button
		print("Going to select Kids Radio button");
		clickAction(surveyProp,"kidsRadio");
		Thread.sleep(2000);
		
		// Going to select grandparents Radio button
		print("Going to select grandparents Radio button");
		clickAction(surveyProp,"grandparentRadio");
		Thread.sleep(2000);
		
		// Going to click on Submit button
		clickAction(surveyProp,"submitButton");
		print("Going to click on Submit button");
		Thread.sleep(3000);
		print("-----------End successfulLogin-----------");
		driver.quit();
	}

}

