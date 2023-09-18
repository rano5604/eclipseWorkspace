package evision;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestScenarios extends Login {
	
	public String actualBusinessReviewButtonText;
	
	//Verify Test Scenarios
	 @Test(priority = 4)
	 	public void TestSteps() throws InterruptedException, AWTException {
		 
		 WebDriverWait wait = driverWait(300);
		 WebElement actualBusinessReviewButton = driver.findElement(By.xpath("//*[@id='Cont819_Login']/div/div/div/table/tbody/tr/td/div/div/div"));
		 wait.until(ExpectedConditions.elementToBeClickable(actualBusinessReviewButton));
		
		  //WebElement actualExecutiveDashboardButton = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[2]/div[2]/div[3]/div/div/table/tbody/tr/td[2]/table/tbody/tr[1]/td/a/span")));
		  actualBusinessReviewButtonText = actualBusinessReviewButton.getText();
		  print("Verify Business Review button is: "+actualBusinessReviewButtonText);
		  Assert.assertEquals(actualBusinessReviewButtonText, "Business Review", "Business Review button is: "+actualBusinessReviewButtonText);
		  				  
		  // Click on the Business Review button.
		  findElementByXpath("//*[@id='Cont898_Login']/div/div/div/table/tbody/tr/td/div/div/div").click();
		  print("Click on Business Review button.");
		  
		  WebElement OrganizationSelectionSection = driver.findElement(By.xpath("//*[@id='Cont669_EBusinessReview_5FOverview']/div/div/div/table/tbody/tr/td/div/div/div"));
		  wait.until(ExpectedConditions.visibilityOf(OrganizationSelectionSection));
		  
		  if(OrganizationSelectionSection.isDisplayed()==true){
			  print("Organization Selection section is present.");
		  }
		  else{
			  print("Organization Selection section is not present.");
		  }
		  
		  // Select united states from organization selection section
		  
		  WebElement OrganizationSelection = driver.findElement(By.xpath("//*[@id='Cont586_EBusinessReview_5FOverview']/div/div[1]"));
		  OrganizationSelection.click();
		  print("Click on Organization Selection section");
		  Thread.sleep(1000);
		
		//  driver.switchTo().alert().accept();
		//  Alert alert = (Alert) driver.switchTo().alert();
		//  driver.findElement(By.xpath("//*[@id='2_1_1_2501318_54b8e0985b3ebb13708b9f82e2903f81_LI']/label/span")).click();
		
		  //findElementById("2_1_1_893300_54b8e0985b3ebb13708b9f82e2903f81_X").getAttribute("value");		  
		//  driver.findElement(By.xpath("//input[@id='2_1_1_893300_54b8e0985b3ebb13708b9f82e2903f81_X' AND @class='arcHpCbox']")).click();
		  
		 /* 
		  String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
		  String subWindowHandler = null;

		  Set<String> handles = driver.getWindowHandles(); // get all window handles
		  java.util.Iterator<String> iterator = handles.iterator();
		  while (iterator.hasNext()){
		      subWindowHandler = iterator.next();
		  }
		  driver.switchTo().window(subWindowHandler); 
		  // switch to popup window
		                                              
		  // perform operations on popup
		  driver.findElement(By.xpath("//input[@id='2_1_1_893300_54b8e0985b3ebb13708b9f82e2903f81_X' AND @class='arcHpCbox']")).click();

		  driver.switchTo().window(parentWindowHandler); 
		  */
 
		 // WebElement CheckBoxValue = findElementByCssSelector("#2_1_1_893300_54b8e0985b3ebb13708b9f82e2903f81_LI > label.arcSelectable");
		 // CheckBoxValue.getAttribute("value");
		//  CheckBoxValue.click();
		  
		 /* WebElement CheckBoxValue = findElementById("2_1_1_714578_54b8e0985b3ebb13708b9f82e2903f81_X");
		  CheckBoxValue.getAttribute("value");
		  CheckBoxValue.click();
		  CheckBoxValue.getAttribute("value");
		  print("Click on Organization Selection section");
		  driver.findElement(By.id("idOfTheElement")).click();*/
		 /* Robot robot = new Robot();
		  Actions builder = new Actions(driver)*/;
		  
		  java.util.List<WebElement> selectElements= driver.findElements(By.cssSelector("input.arcHpCbox[type='checkbox']"));
		  selectElements.get(1).click();
		  
		/*  org.openqa.selenium.interactions.Action mouseHoverCountry = builder.moveToElement(selectElements.get(1)).build();
		  mouseHoverCountry.perform();
		  
		  robot.keyPress(KeyEvent.VK_ENTER);*/
		  Thread.sleep(20000);
		  
	//	  selectUnitedState.click();
		  print("Select United State from Drop-down list.");
		  
		  print("Going to click on Noram Financial");
		  java.util.List<WebElement> selectNoramFinancial= driver.findElements(By.xpath("//*[contains(text(),'NorAm Financials')]"));
		  selectNoramFinancial.get(0).click();
		  
		  //Select Noram Financial and ensure page load
		//  WebElement NoramFinancial = driver.findElement(By.xpath("//div[@id='Cont206_Evision_5FRevenue']/div/div/div/table/tbody/tr/td/div/div/div"));
		//div[@id='Cont206_Evision_5FRevenue']/div/div/div/table/tbody/tr/td/div/div/div
		//div[@id='Cont206_Evision_5FRevenue']/div/div/div/table/tbody/tr/td/div/div/div
		//*[@id='Cont854_Evision_5FKey_5FResult_5FIndicators']/div/div/div/table/tbody/tr/td/div/div/div
		/*  org.openqa.selenium.interactions.Action mouseHoverNorAm = builder.moveToElement(NoramFinancial).build();
		  mouseHoverNorAm.perform();
		  NoramFinancial.click();*/
		// wait.until(ExpectedConditions.visibilityOf(NoramFinancial));
		//Verify that we in the first field
		//  NoramFinancial.click();
		  
		 /*org.openqa.selenium.interactions.Action mouseHoverNorAm = builder.moveToElement(NoramFinancial).build();
		 mouseHoverNorAm.perform();
		 robot.keyPress(KeyEvent.VK_ENTER);*/
		 /* 
		  if(driver.switchTo().activeElement().equals(NoramFinancial))
		      System.out.println("NoramFinancial element is in a focus");
		  else
		      //Add Assertion here - stop execution
		      System.out.println("ASSERTION - NoramFinancial element not in the focus");
		  NoramFinancial.click();*/
		  print("Click on Noram Financial");
		  Thread.sleep(90000);
		  
		  //Click account payable
		//  java.util.List<WebElement> selectaccountPayable= driver.findElements(By.xpath("//*[contains(text(),'Accounts Payable')]"));
		  WebElement accountPayable = driver.findElement(By.xpath("//div[@id='Cont2951_Evision_5FKey_5FResult_5FIndicators']/div/div/div/table/tbody/tr/td/div/div/div"));
		  wait.until(ExpectedConditions.visibilityOf(accountPayable));
		  accountPayable.click();
		 
		  
		 // selectaccountPayable.get(0).click();
		  Thread.sleep(10000);
		  print("Click on account payable");
		  
		  WebElement accountPayableSection = driver.findElement(By.xpath("//*[contains(text(),'Daily AP Analytics')]"));
		  wait.until(ExpectedConditions.visibilityOf(accountPayableSection));
		  Thread.sleep(5000);
		  print("Verify account Payable Section");
		  
		  //Click Labor
		//  WebElement laborElement = driver.findElement(By.xpath("//*[contains(text(),'Labor')]"));
		  
		  WebElement laborElement = driver.findElement(By.xpath("//div[@id='Cont2952_Evision_5FKey_5FResult_5FIndicators']/div/div/div/table/tbody/tr/td/div/div/div"));
		  wait.until(ExpectedConditions.visibilityOf(laborElement));
		  laborElement.click();
		  Thread.sleep(10000);
		  print("Click on labor");
		  
		  //wait for labor section
		  WebElement laborSection = driver.findElement(By.xpath("//*[contains(text(),'Hourly Labor')]"));
		  wait.until(ExpectedConditions.visibilityOf(laborSection));
		  print("Verify labor Section");
		  Thread.sleep(10000);
		  	
		  //Click  pdf for labor
		  WebElement laborPdfLink = driver.findElement(By.xpath("//div[@id='Cont1399_Evision_5FKey_5FResult_5FIndicators']/div/div/div/table/tbody/tr/td/div/div/div"));
		  laborPdfLink.click();
		  Thread.sleep(10000);
		  
		  //Select type of analysis dropbox and select true north P&L view
		//  WebElement TypeAnalysisList = driver.findElement(By.xpath("//*[@id='Cont732_Evision_5FKey_5FResult_5FIndicators']/div/div[1]"));
		 // WebElement TypeAnalysisList = driver.findElement(By.className("arcMenuItem"));
		  /*Select drpTypeAnalysis = new Select(driver.findElement(By.xpath("//div[@id='Cont732_Evision_5FKey_5FResult_5FIndicators']/div/div/div/div")));
		  drpTypeAnalysis.selectByVisibleText("True North P&L View");*/
		  
		  //Select type of analysis dropbox and select true north P&L view
		  print("Click on analysis dropbox");
		  driver.findElement(By.xpath("//div[@id='Cont732_Evision_5FKey_5FResult_5FIndicators']/div/div/div/div")).click();
		  Thread.sleep(1000);
		  print("Select true north P&L view");
		  driver.findElement(By.xpath("//div[@id='Cont732_Evision_5FKey_5FResult_5FIndicators']/div/div[2]/div/ul/li[5]/div")).click();
		  Thread.sleep(4000);
		  
		  driver.quit();
		  print("Close Driver!");
	 	}
	 
}




