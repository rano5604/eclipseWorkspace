package evision;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BaseClass {
	
	public WebDriver driver;
	public Properties prop;
	public FileInputStream fis;
	
	@BeforeTest
	 public void setUp() {
	  //Create object of FirefoxProfile in built class to access Its properties.
	  FirefoxProfile fprofile = new FirefoxProfile();
	  
	  //Set Location to store files after downloading.
	  fprofile.setPreference("browser.download.dir", "D:\\seleniumdownloads");
	  fprofile.setPreference("browser.download.folderList", 2);
	  
	  //Set Preference to not show file download confirmation dialogue using MIME types Of different file extension types.
	  fprofile.setPreference("browser.helperApps.neverAsk.saveToDisk", 
	    "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;"//MIME types Of MS Excel File.
	    + "application/pdf;" //MIME types Of PDF File.
	    + "application/vnd.openxmlformats-officedocument.wordprocessingml.document;" //MIME types Of MS doc File.
	    + "text/plain;" //MIME types Of text File.
	    + "text/csv"); //MIME types Of CSV File.
	  fprofile.setPreference( "browser.download.manager.showWhenStarting", false );
	  fprofile.setPreference( "pdfjs.disabled", true );
	  
	  //Pass fprofile parameter In webdriver to use preferences to download file.
	  driver = new FirefoxDriver(fprofile);  
	 } 
	
	// Choose browser and go to the URL
	@Test(priority = 0)
	public void getBrowser() throws IOException {
	  prop = new Properties();
	 // fis=new FileInputStream("C:\\android\\Evision\\src\\evisionData.properties");
	  fis=new FileInputStream("C:\\android\\Evision\\src\\evisionData.properties");
	  
	  
	  prop.load(fis);
	  driver.get(prop.getProperty("URL"));
	  driver.manage().window().maximize();
}
	
	// Print Method
		public void print(String str){
			System.out.println(str);
		}
		
		// Find Element by id
		public WebElement findElementById(String id) {
			return driver.findElement(By.id(id));
		}
		
		// Find Element by className
		public WebElement findElementByClassName(String className) {
			return driver.findElement(By.className(className));
		}
		
		// Find Element by Name
		public WebElement findElementByName(String name) {
			return driver.findElement(By.name(name));
		}
			
		// Find Element by cssSelector
		public WebElement findElementByCssSelector(String cssSelector) {
			return driver.findElement(By.cssSelector(cssSelector));
		}
		
		// Find Element by link text
		public WebElement findElementByLinkText(String linkText) {
			return driver.findElement(By.linkText(linkText));
		}
		
		// Find Element by partialLinkText
		public WebElement findElementByPartialLinkText(String partialLinkText) {
			return driver.findElement(By.partialLinkText(partialLinkText));
		}
		
		// Find Element by tagName
		public WebElement findElementByTagName(String tagName) {
			return driver.findElement(By.tagName(tagName));
		}
		
		// Find Element by tagName
		public WebElement findElementByXpath(String xpath) {
			return driver.findElement(By.xpath(xpath));
		}
		
		public WebDriverWait driverWait(int waitTime) {
			return new WebDriverWait(driver, waitTime); 
		}

		// Find Element
		public WebElement findElement(Properties prop, String path) {
			
			String objectPath = prop.getProperty(path);
			String type = prop.getProperty(path + "Type");
			
			if(type.equals("xpath")){
				return findElementByXpath(objectPath);	
			}else if(type.equals("id")){
				return findElementById(objectPath);
			}else if(type.equals("className")){
				return findElementByClassName(objectPath);
			}else if(type.equals("cssSelector")){
				return findElementByCssSelector(objectPath);
			}else if(type.equals("linkText")){
				return findElementByLinkText(objectPath);
			}else if(type.equals("partialLinkTex")){
				return findElementByPartialLinkText(objectPath);
			}else if(type.equals("tagName")){
				return findElementByTagName(objectPath);
			}else{
				return findElementById(objectPath);
			}
		}
}
