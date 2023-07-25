package pages;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;


import com.google.common.collect.ImmutableMap;


import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class IosActions extends CommonActions {
	public IOSDriver driver;
	
	
	public IosActions(IOSDriver driver) {
		super(driver);
		this.driver = driver;
	
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	

	
	

	
	
	
	public void LongPress(WebElement element) {
		((JavascriptExecutor) driver).executeScript("mobile: touchAndHold", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) element).getId(), "duration", 5000));
	}
	
	public void Scrollup(WebElement element) {
		Map<String, Object> scrollObject = new HashMap<String, Object>();
		scrollObject.put("direction", "down");
		scrollObject.put("element",((RemoteWebElement) element).getId());
		
		
		driver.executeScript("mobile:scroll", scrollObject);
	}
}
