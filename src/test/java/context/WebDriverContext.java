package context;



import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class WebDriverContext {
	/** The driver instance. */
	private static InheritableThreadLocal<AppiumDriver> driverinstance = new InheritableThreadLocal<>();

	/**
	 * Gets the driver.
	 *
	 * @return the driver
	 */
	public static AppiumDriver getDriver() {
		if (driverinstance.get() == null)
			throw new IllegalStateException(
					"WebDriver has not been set, Please set WebDriver instance by WebDriverContext.setDriver...");
		else
			return (AppiumDriver) driverinstance.get();
	}

	/**
	 * Removes the driver.
	 */
	public static void removeDriver() {
		driverinstance.remove();
	}

	/**
	 * Sets the driver.
	 *
	 * @param driver the new driver
	 */
	public static void setDriver(AppiumDriver driver) {
		driverinstance.set(driver);
	}
}
