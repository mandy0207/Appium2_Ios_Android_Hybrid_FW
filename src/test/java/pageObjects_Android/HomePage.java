package pageObjects_Android;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import pages.AndroidActions;

public class HomePage extends AndroidActions {

	
	AndroidDriver driver;

	public HomePage(AndroidDriver driver) {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
		

	}
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='3. Preference dependencies']")
	private WebElement prefDep;
	
	@AndroidFindBy(accessibility = "Preference")
	private WebElement preference;
	
	@AndroidFindBy(accessibility = "Views")
	private WebElement views;
	
	
	@AndroidFindBy(accessibility = "Gallery")
	private WebElement gallery;
	
	@AndroidFindBy(accessibility = "1. Photos")
	private WebElement photos;
	
	@AndroidFindBy(accessibility = "Drag and Drop")
	private WebElement dragDrop;
	
	
	
	
	
	
	
	public void ClickPrefDep() {
//		ClickElement(preference);
//		ClickElement(prefDep);
		preference.click();
		prefDep.click();
		
	}

	
	
}
