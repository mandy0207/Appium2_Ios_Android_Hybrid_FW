package test.base;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import Configurations.Constants;
import Exceptions.NoAppFoundException;
import context.WebDriverContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import util.TestProperties;

public class AndroidBaseTest {
	public AndroidDriver driver;
	AppiumDriverLocalService service;

	@BeforeClass
	public void ConfigureAppium() throws IOException {
		// Code to start appium server
//		service = new AppiumServiceBuilder()
//				.withAppiumJS(
//						new File("C:\\Users\\msingh\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
//				.withIPAddress("127.0.0.1").usingPort(4723).build();

		// service.start();
		String platformName = TestProperties.GetProperties().getProperty("platformName");
		String deviceName = TestProperties.GetProperties().getProperty("deviceName");
		String testApp =  TestProperties.GetProperties().getProperty("TestApp");
		System.out.println(testApp);
	    if(TestProperties.GetProperties().getProperty(testApp).equals("ApiDemos-debug.apk")) {
	    	UiAutomator2Options options = new UiAutomator2Options();
			options.setPlatformName(platformName);
			options.setDeviceName(deviceName);
			options.setApp(Constants.API_DEMO_app);
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
			WebDriverContext.setDriver(driver);
			
			
	    }
	    else if(TestProperties.GetProperties().getProperty(testApp).equals("General-Store.apk")) {
	    	UiAutomator2Options options = new UiAutomator2Options();
			options.setPlatformName(platformName);
			options.setDeviceName(deviceName);
			options.setChromedriverExecutable("/Users/mandytaak/eclipse-workspace/Appium2_FW_Android_TestNG/src/test/java/resources/chromedriver.exe");
			options.setApp(Constants.General_Store_app);
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
			WebDriverContext.setDriver(driver);
			
	    }
	    else if(TestProperties.GetProperties().getProperty(testApp).equals("Chrome")){
	    	UiAutomator2Options options = new UiAutomator2Options();
			options.setPlatformName(platformName);
			options.setDeviceName(deviceName);
			options.setChromedriverExecutable("/Users/mandytaak/eclipse-workspace/Appium2_FW_Android_TestNG/src/test/java/resources/chromedriver.exe");
			options.setCapability("browserName","Chrome");
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
			//WebDriverContext.setDriver(driver);

	    }
	    else {
	    	throw new NoAppFoundException();
	    }
	    
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	}

	@AfterClass
	public void TearDown() {
		 driver.quit();
		// service.stop();
	}
	
	
	
	
	
	

}
