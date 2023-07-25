package pages;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.asserts.SoftAssert;

import context.WebDriverContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CommonActions {

public 	AppiumDriver driver;
protected FluentWait<AppiumDriver> waiter;

protected SoftAssert softAssert;
	public CommonActions(AppiumDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
		int waitTimeout= 5;
		waiter = new FluentWait<>(driver).ignoring(NoSuchElementException.class, WebDriverException.class)
				.withTimeout(Duration.ofSeconds(waitTimeout)).pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class).ignoring(TimeoutException.class);
		softAssert = new SoftAssert();
		
	}
	
	
	public void ClickElement(WebElement element) {
		WaitUntilVisible(element);
		element.click();
	}
	
	public WebElement WaitUntilVisible(WebElement element) {
		try {
			this.waiter.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			doSoftAssertFailure("WaitUntilVisible -> Element did not become visible");
		}

		return element;
	}
	
	
	public WebElement WaitUntilPresent(WebElement element, By locator) {	
		try {
			this.waiter.until(ExpectedConditions.presenceOfElementLocated(locator));
		} catch (Exception e) {
			doSoftAssertFailure("WaitUntilVisible -> Element did not become visible");
		}

		return element;
	}
	
	public void doSoftAssertFailure(String msg) {
		softAssert.assertTrue(false, msg);
	
	}
	
	public void SetTextBox(WebElement element, String textToAdd, By locator) {

		    WaitUntilPresent(element, locator);
			element.sendKeys(textToAdd);
		

	}
	
	public static String getScreenshotPath(String testCaseName) throws IOException {
		
	    File source =WebDriverContext.getDriver().getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"/reports/"+testCaseName+".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
		
	}
}
