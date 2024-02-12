package Demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class BrowserAutomation {

	public static void main(String[] args) throws MalformedURLException, InterruptedException 
	{
		// Gather DesiredCapabilities

		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability("devicename", "Test");
		dc.setCapability("platformname", "android");
		dc.setCapability("platformversion", "10");
		dc.setCapability("automationName", "uiautomator2");
		dc.setCapability("browserName", "Chrome");
		dc.setCapability("chromedriverExcutable","C:\\Users\\pavan\\Desktop\\Rest\\AppiumDemo\\Driver\\chromedriver_win32\\chromedriver.exe");

		
		URL url=URI.create("http://127.0.0.1:4723").toURL();	
		AndroidDriver driver=new AndroidDriver(url,dc);

		// Open URL
		driver.get("https://www.google.com/");
		
		// Find search box web element
		WebElement search=driver.findElement(By.name("q"));
		
		search.sendKeys("Flipkart");
		search.sendKeys(Keys.RETURN);
		
		Thread.sleep(4000);
		driver.quit();
		
	}

}
