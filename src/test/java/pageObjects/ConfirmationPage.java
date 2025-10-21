package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage extends BasePage {
		
	
	public ConfirmationPage(WebDriver driver) {
		super(driver);
		
	}

	@FindBy (xpath="//h1[normalize-space()='Your order has been placed!']")
	WebElement ConfirmationMsg;
	
	public boolean Confirmation()
	{
		return ConfirmationMsg.isDisplayed();
	}
}
