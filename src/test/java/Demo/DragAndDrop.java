package Demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;


import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.AbstractOptionCombinedWithPosition;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;


public class DragAndDrop {

	public static void main(String[] args) throws MalformedURLException, InterruptedException 
	{
		// Gather desired Capabilities
		
		DesiredCapabilities dc=new DesiredCapabilities();
		
		dc.setCapability("devicename", "Virtual");
		dc.setCapability("platfornName", "android");
		dc.setCapability("platformversion", "11");
		dc.setCapability("automationName", "uiautomator2");
		
		dc.setCapability("appPackage", "io.appium.android.apis");
		dc.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
		
		URL url=URI.create("http://127.0.0.1:4723/").toURL();
		
		AndroidDriver driver=new AndroidDriver(url,dc);
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		System.out.println("Application Started");
		
		//click on view
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]")).click();
		
		//click on drag and drop
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Drag and Drop\"]")).click();
		
		// click on source button
		WebElement source=driver.findElement(By.xpath("//android.view.View[@resource-id=\"io.appium.android.apis:id/drag_dot_1\"]"));
		
		WebElement target=driver.findElement(By.xpath("//android.view.View[@resource-id=\"io.appium.android.apis:id/drag_dot_2\"]"));
		
	 // By using touch action class
		TouchAction action=new TouchAction(driver);
		
	//	action.longPress(LongPressOptions().withElement(element(source))).moveTo(element(target)).release().perform();
		  
		
		
		Thread.sleep(5000);
		driver.quit();//CLOSE SESSION

	}

	

}
