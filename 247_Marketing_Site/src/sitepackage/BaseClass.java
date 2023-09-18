package sitepackage;

import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.util.Random;

public class BaseClass {
	public WebDriver driver;
	public Properties prop;
	public FileInputStream fis;

	public static WebDriver open(String browserType) {

		if (browserType.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:\\Selenium Final All\\geckodriver.exe");
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability("marionette", true);
			return new FirefoxDriver();
		} else if (browserType.equalsIgnoreCase("IE")) {
			File file = new File("D:\\Selenium Final All\\MicrosoftWebDriver.exe");
			System.setProperty("webdriver.edge.driver", file.getAbsolutePath());
			DesiredCapabilities capabilities = DesiredCapabilities.edge();
			// new EdgeDriver(capabilities);

			// System.setProperty("webdriver.edge.driver", "D:\\Selenium Final
			// All\\MicrosoftWebDriver.exe");
			return new EdgeDriver(capabilities);
		} else {
			System.setProperty("webdriver.chrome.driver", "D:\\Selenium Final All\\chromedriver.exe");
			
			ChromeOptions options = new ChromeOptions(); 
			options.addArguments("disable-infobars"); 
			//WebDriver driver = new ChromeDriver(options);
			
			return new ChromeDriver(options);
		}

	}

	public Properties loadConfiguration(String fileName) throws IOException {
		// load configuration
		Properties prop = new Properties();

		// Windows
		FileInputStream fis = new FileInputStream(
				"D:\\EclipseWorkspace\\247_Marketing_Site\\src\\configs\\" + fileName);

		// Mac
		// FileInputStream fis1 = new
		// FileInputStream("//Users//mostakim//Documents//sourcetree//Connect_automation_scripts//ConnectAndroidAutomation//src//configs//"
		// + fileName);
		prop.load(fis);
		return prop;
	}

	public void writeConfig(String fileName, String key, String value) throws IOException {
		// load configuration
		Properties wprop = new Properties();
		OutputStream output = null;

		// Windows
		output = new FileOutputStream("D:\\EclipseWorkspace\\247_Marketing_Site\\src\\configs" + fileName);

		// Mac
		// output = new
		// FileOutputStream("//Users//mostakim//Documents//sourcetree//Connect_automation_scripts//ConnectAndroidAutomation//src//configs//"
		// + fileName);

		wprop.setProperty(key, value);
		wprop.store(output, null);
	}

	// Print Method
	public void print(String str) {
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

		if (type.equals("xpath")) {
			return findElementByXpath(objectPath);
		} else if (type.equals("id")) {
			return findElementById(objectPath);
		} else if (type.equals("className")) {
			return findElementByClassName(objectPath);
		} else if (type.equals("cssSelector")) {
			return findElementByCssSelector(objectPath);
		} else if (type.equals("linkText")) {
			return findElementByLinkText(objectPath);
		} else if (type.equals("partialLinkTex")) {
			return findElementByPartialLinkText(objectPath);
		} else if (type.equals("tagName")) {
			return findElementByTagName(objectPath);
		} else {
			return findElementById(objectPath);
		}

	}

	// ---------------- Common Function-----------------

	// ------- Generate random Number -------------
	public static Integer getRandomNumber() {
		int min = 000000;
		int max = 999999999;

		int randomNumber = (int) (Math.random() * (max - min));

		return randomNumber;
	}

	// -------------- Generate Random String-----------
	static final String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

	public static String getRandomString(int len) {
		Random rnd = new Random();

		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(AB.charAt(rnd.nextInt(AB.length())));
		return sb.toString();
	}

	// ------- Generate random Number -------------
	public static Integer getRandomNumberInRange(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		int randomNumber = (int) (Math.random() * (max - min));

		return randomNumber;
	}

}

/*
 * @AfterClass public void teardown() { driver.quit(); }
 * 
 */

/*
 * 
 * // Choose browser and go to the URL
 * 
 * @Test(priority = 0) public void getData() throws IOException { prop = new
 * Properties(); fis=new FileInputStream(
 * "D:\\EclipseWorkspace\\FirstTestNGProject\\src\\getData.properties");
 * prop.load(fis); }
 * 
 * /*
 * 
 * /* File Download in Firefox
 * 
 * @Test public void fileDownload() { //Create object of FirefoxProfile in built
 * class to access Its properties. FirefoxProfile fprofile = new
 * FirefoxProfile();
 * 
 * //Set Location to store files after downloading.
 * fprofile.setPreference("browser.download.dir", "D:\\seleniumdownloads");
 * fprofile.setPreference("browser.download.folderList", 2);
 * 
 * //Set Preference to not show file download confirmation dialogue using MIME
 * types Of different file extension types.
 * fprofile.setPreference("browser.helperApps.neverAsk.saveToDisk",
 * "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;"//MIME
 * types Of MS Excel File. + "application/pdf;" //MIME types Of PDF File. +
 * "application/vnd.openxmlformats-officedocument.wordprocessingml.document;"
 * //MIME types Of MS doc File. + "text/plain;" //MIME types Of text File. +
 * "text/csv"); //MIME types Of CSV File. fprofile.setPreference(
 * "browser.download.manager.showWhenStarting", false ); fprofile.setPreference(
 * "pdfjs.disabled", true );
 * 
 * //Pass fprofile parameter In webdriver to use preferences to download file.
 * driver = new FirefoxDriver(fprofile); }
 */
