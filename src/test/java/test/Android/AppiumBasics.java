package test.Android;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import pageObjects_Android.HomePage;
import pages.AndroidActions;
import test.base.AndroidBaseTest;


public class AppiumBasics extends AndroidBaseTest{



	@Test
	public void WifiSettingsTest() throws MalformedURLException {
	
		HomePage hp = new HomePage(driver);
		hp.ClickPrefDep();
		driver.findElement(AppiumBy.id("android:id/checkbox")).click();
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		String wifiText= driver.findElement(By.id("android:id/alertTitle")).getText();
		AssertJUnit.assertEquals(wifiText, "WiFi settings");
		driver.findElement(By.id("android:id/edit")).sendKeys("mandy");
		driver.findElement(By.id("android:id/button1")).click();
		Assert.assertTrue(false);

	}
}
