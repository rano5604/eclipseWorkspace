package appium;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class BaseClass {
	
	
  @Test
  public void config() throws InterruptedException, IOException {
		
	  	DesiredCapabilities cap = new DesiredCapabilities();
	  	cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android device");
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "10000");
	  	
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		Thread.sleep(10000);
		System.out.println("I am here!");
		driver.get("https://condonow.com");
		Thread.sleep(20000);
		String title = driver.getTitle();
		System.out.println(title);
		driver.findElement(By.className("toogle")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("lnkLoginNew")).click();
		System.out.println("Done");
	
		}
}
