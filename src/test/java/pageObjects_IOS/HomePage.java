package pageObjects_IOS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import pages.IosActions;

public class HomePage extends IosActions{

	public IOSDriver driver;
	
	public HomePage(IOSDriver driver) {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	By textEntryloc=AppiumBy.iOSClassChain("**/XCUIElementTypeCell");
	 
	@iOSXCUITFindBy(accessibility="Alert Views")
	private WebElement alertViews;
	
	@iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeStaticText[`label == 'Text Entry'`]")
	private WebElement textEntry;
	
	@iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeCell")
	private WebElement textEntryBox;
	
	@iOSXCUITFindBy(accessibility="OK")
	private WebElement Okbtn;
	
	@iOSXCUITFindBy(iOSNsPredicate= "label == 'Confirm / Cancel' AND  value ENDSWITH[c] 'Cancel'")
	private WebElement confirmCancel;
	
	@iOSXCUITFindBy(iOSNsPredicate= "label == 'Confirm'")
	private WebElement confirmBtn;
	
	
	
	public void BasicTest() {

		ClickElement(alertViews);
		ClickElement(textEntry);
		SetTextBox(textEntryBox,"Hello",textEntryloc);
		ClickElement(Okbtn);
		ClickElement(confirmCancel);
		ClickElement(confirmBtn);
	}
}
