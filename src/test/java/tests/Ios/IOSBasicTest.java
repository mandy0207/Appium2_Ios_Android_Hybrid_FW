package tests.Ios;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import pageObjects_IOS.HomePage;
import test.base.IosBaseTest;

public class IOSBasicTest extends IosBaseTest {

	@Test
	public void BasicTest() {
		
		HomePage hp = new HomePage(driver);
		hp.BasicTest();
	}
}
