package Demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class HandleDropDown {

	public static void main(String[] args) throws MalformedURLException, InterruptedException 
	{
	   // Gather DesiredCapabilities

		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability("devicename", "Test");
		dc.setCapability("platformname", "android");
		dc.setCapability("platformversion", "10");
		dc.setCapability("automationName", "uiautomator2");
		
		dc.setCapability("appPackage", "io.appium.android.apis");
		dc.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
		
		URL url=URI.create("http://127.0.0.1:4723").toURL();	
		AndroidDriver driver=new AndroidDriver(url,dc);
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		System.out.println("Application started");
		
		
		// click on view
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]")).click();
		
		// click on controls
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Controls\"]")).click();
		
		//click on light theme
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"1. Light Theme\"]")).click();
		
		// click on mercury
		driver.findElement(By.id("io.appium.android.apis:id/spinner1")).click();
		
		// click on mars
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"Mars\"]")).click();
		
		
		System.out.println("close application");
        Thread.sleep(4000);
		// close application
		driver.quit();
		
		
	}

}
