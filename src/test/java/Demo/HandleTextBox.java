package Demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class HandleTextBox {

	public static  void main(String[] args) throws MalformedURLException, InterruptedException
	{
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

		//click on controls
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Controls\"]")).click();

		// click on light theme
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"1. Light Theme\"]")).click();

		// enter text in textbox
		driver.findElement(By.id("io.appium.android.apis:id/edit")).sendKeys("pavan mahajan");

		// checkbox
		driver.findElement(By.id("io.appium.android.apis:id/check1")).click();

		// radio button
		driver.findElement(By.id("io.appium.android.apis:id/radio1")).click();

		/*click on view button
		driver.findElements(By.id("android:id/text1")).get(11).click();
		//click on controls
		driver.findElements(By.id("android:id/text1")).get(4).click();
		//click on light theme
		driver.findElements(By.id("android:id/text1")).get(0).click();
		//enter text in textbox
		//io.appium.android.apis:id/edit
		driver.findElement(By.id("io.appium.android.apis:id/edit")).sendKeys("prachi gupta");
		//checkbox
		//io.appium.android.apis:id/check1
		driver.findElement(By.id("io.appium.android.apis:id/check1")).click();
		//radio button
		driver.findElement(By.id("io.appium.android.apis:id/radio2")).click(); */




		Thread.sleep(4000);

		driver.quit();
	}
}
