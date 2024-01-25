package Demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class AppManagement {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		// Gather DesiredCapabilities

		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability("devicename", "Test");
		dc.setCapability("platformname", "android");
		dc.setCapability("platformversion", "10");
		dc.setCapability("automationName", "uiautomator2");

		//	dc.setCapability("appPackage", "io.appium.android.apis");
		//	dc.setCapability("appActivity", "io.appium.android.apis.ApiDemos");

		URL url=URI.create("http://127.0.0.1:4723").toURL();	
		AndroidDriver driver=new AndroidDriver(url,dc);
		Thread.sleep(2000);

		String packageName="io.appium.android.apis";

		driver.terminateApp(packageName);

		// remove app
/*	    driver.removeApp(packageName);

		if(!driver.isAppInstalled(packageName))
		{
			// Install application
			driver.installApp("C:\\Users\\pavan\\Desktop\\New folder\\Appium\\APKFiles\\ApiDemos-debug.apk");
			System.out.println("app sucessfully installed");
		}

		else
			System.out.println("app already installed");
		// Activate the given application
		driver.activateApp(packageName);      */




		Thread.sleep(2000);
		// close session
		driver.quit();

	}

}
