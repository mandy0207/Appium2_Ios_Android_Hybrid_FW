package test.base;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import context.WebDriverContext;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

public class IosBaseTest {

	public IOSDriver driver;
	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException {
		
		XCUITestOptions options = new XCUITestOptions ();
		options.setDeviceName("iPhone 14 Pro");
		options.setApp("/Users/mandytaak/Desktop/UIKitCatalog.app");
		options.setPlatformVersion("16.4");
		options.setPlatformName("IOS");
		
		//AppiumDriver -> WebDriverAgent -> Ios App
		options.setWdaLaunchTimeout(Duration.ofSeconds(20));
		
		driver = new IOSDriver(new URL("http://127.0.0.1:4723"),options);
		WebDriverContext.setDriver(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		
	}
	
	@AfterClass
	public void TearDown() {
		driver.quit();
	}
	
	
}
