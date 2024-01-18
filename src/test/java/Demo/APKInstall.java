package Demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;

public class APKInstall {

	public static void main(String[] args) throws MalformedURLException, InterruptedException 
	{
		// Gather Desired Capabilities
		DesiredCapabilities dc=new DesiredCapabilities();
		
		dc.setCapability("deviceName", "codestudio");
		dc.setCapability("platformname", "Android");
		dc.setCapability("automationName", "UiAutomator2");
		dc.setCapability("app", "C:\\Users\\pavan\\Downloads\\APKFiles-1\\resources\\General-Store.apk");
		dc.setCapability("platformversion", "10");
		
		URL url=URI.create("http://127.0.0.1:4723/").toURL();
		
		AndroidDriver driver=new AndroidDriver(url,dc);
		
		Thread.sleep(6000);
		System.out.println("application started");
		driver.quit();
		

	}

}
