package Demo;

import java.net.MalformedURLException;

import java.net.URI;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class AutomateDialer {

	
	public static void main (String[] arg) throws MalformedURLException, InterruptedException
	{
		// Gather desired capbilities
		
		DesiredCapabilities dc=new DesiredCapabilities();
		
		dc.setCapability("deviceName", "appiumTest");
		dc.setCapability("platformname", "android");
		dc.setCapability("automationName", "uiautomator2");
		dc.setCapability("platformversion", "11");
		
		dc.setCapability("appPackage", "com.android.dialer");
		dc.setCapability("appActivity", "com.android.dialer.main.impl.MainActivity");
		
		URL url=URI.create("http://127.0.0.1:4723/").toURL();
		
		AndroidDriver driver=new AndroidDriver(url,dc);
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		System.out.println("Application Started");
		
		// click dial pad
		driver.findElement(By.id("com.android.dialer:id/fab")).click();
		
		// 08237133282
		driver.findElement(By.id("com.android.dialer:id/zero")).click();
		driver.findElement(By.id("com.android.dialer:id/eight")).click();
		driver.findElement(By.id("com.android.dialer:id/two")).click();
		driver.findElement(By.id("com.android.dialer:id/three")).click();		
		driver.findElement(By.id("com.android.dialer:id/seven")).click();
		driver.findElement(By.id("com.android.dialer:id/one")).click();
		driver.findElement(By.id("com.android.dialer:id/three")).click();
		driver.findElement(By.id("com.android.dialer:id/three")).click();
		driver.findElement(By.id("com.android.dialer:id/two")).click();
		driver.findElement(By.id("com.android.dialer:id/eight")).click();
		driver.findElement(By.id("com.android.dialer:id/two")).click();
		
		// click in call button
		driver.findElement(By.id("com.android.dialer:id/dialpad_floating_action_button")).click();
		
		Thread.sleep(8000);
		
		driver.findElement(By.id("com.android.dialer:id/incall_end_call")).click();
		
		driver.quit();
		
	}
}
