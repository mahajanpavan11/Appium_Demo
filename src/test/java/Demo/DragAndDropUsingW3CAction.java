package Demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Interaction;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class DragAndDropUsingW3CAction 
{
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

	// find centre of source and target webelement
		
		Point sourceElementCenter=getCenter(source);
		Point targetElementCenter=getCenter(target);
	
	// PointerInput class to create a sequence of actions
	// that move the pointer to the centre of the element
	// press down on the element, and then release the element
		
		PointerInput finger1=new PointerInput(PointerInput.Kind.TOUCH,"finger1");
		
	// sequence object, which is a list of action that will be
		
		Sequence sequence=new Sequence(finger1,1);
		
	// move finger to starting position
		sequence.addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), sourceElementCenter));
	
	//finger coming down to contact with screen
		sequence.addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		
		
		sequence.addAction(new Pause(finger1,Duration.ofMillis(588)));
		
	// move finger to the end position
		sequence.addAction(finger1.createPointerMove(Duration.ofMillis(588),PointerInput.Origin.viewport(), targetElementCenter));
		
	// move finger up
		sequence.addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		
	// perform sequence of action 
	// driver.perform(Collection.singletonList(sequence));
		
		driver.perform(Arrays.asList(sequence));
		Thread.sleep(4000);
		
		driver.quit();
		
}
	
	private static Point getCenter(WebElement element)
	{
		// get location of the element
		Point location=element.getLocation();
		
		// get dimension (height & width of the element)
		Dimension size=element.getSize();
		
		// center point
		Point centre=new Point (location.x+size.width/2,location.y+size.height/2);
		
		return centre;
		
	}
}
