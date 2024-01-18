package Demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class ScrollOnMobileWebPageSwitching {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {


		DesiredCapabilities dc=new DesiredCapabilities();

		dc.setCapability("devicename", "Virtual");
		dc.setCapability("platformName", "android");
		dc.setCapability("automationName", "uiautomator2");
		dc.setCapability("platformversion", "11");

		dc.setCapability("appPackage", "io.appium.android.apis");
		dc.setCapability("appActivity", "io.appium.android.apis.ApiDemos");

		URL url=URI.create("http://127.0.0.1:4723/").toURL();

		AndroidDriver driver=new AndroidDriver(url,dc);

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		System.out.println("Application Started");

		// click on view button
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]")).click();

		//scroll on web page
		String MobElementToScroll = "Switches";

		WebElement SwitchElement = driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true))" +
						".scrollIntoView(new UiSelector().text(\"" + MobElementToScroll + "\"))"));

		SwitchElement.click();


		WebElement monitoredSwitch = driver.findElement(By.id("io.appium.android.apis:id/monitored_switch"));

		if(monitoredSwitch.isSelected()==true)
		{
			System.out.println("Monitoried Switch is ON");
		}
		else
		{
			System.out.println("Monitoried Switch is OFF. Doing Switch On");
			monitoredSwitch.click();
		}


		Thread.sleep(5000);
		driver.quit();//CLOSE SESSION



	}

}
