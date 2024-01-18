package Demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class AutomateCalculator {
              // appPakage & appActivity by using command prompt [dumpsys window displays | grep -e 'mCurrentFocus']
	     //	 com.google.android.calculator/com.android.calculator2.Calculator


	public static void main(String[] args) throws MalformedURLException, InterruptedException 
	{
		// TODO Auto-generated method stub

		//Gather Desired capabilities
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("deviceName","codestudio");
		capabilities.setCapability("platformname", "Android");     
		capabilities.setCapability("automationName","uiautomator2");
		capabilities.setCapability("platformversion", "10");

		capabilities.setCapability("appPackage","com.google.android.calculator");
		capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

		URL url = URI.create("http://127.0.0.1:4723/").toURL();

		AndroidDriver driver = new AndroidDriver(url, capabilities);
		Thread.sleep(5000);
		System.out.println("Application Started");


		//click on number 8
		WebElement num8 =  driver.findElement(By.id("com.google.android.calculator:id/digit_8"));
		num8.click(); //perform click action on number 8

		//click on plus sign
		WebElement plus =  driver.findElement(By.id("com.google.android.calculator:id/op_add"));
		plus.click(); //perform click action on number 8

		//click on number 2
		WebElement num2 =  driver.findElement(By.id("com.google.android.calculator:id/digit_2"));
		num2.click(); //perform click action on number 8

		//click on equal sign
		WebElement equal =  driver.findElement(By.id("com.google.android.calculator:id/eq"));
		equal.click(); //perform click action on number 8

		//click on result sign
		WebElement result =  driver.findElement(By.id("com.google.android.calculator:id/result_container"));
		String resultString = result.getText();

		if(resultString.equals("10"))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("fail");
		}

		//CLOSE SESSION
		driver.quit();

	}


}
