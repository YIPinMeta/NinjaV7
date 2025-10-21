package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage extends BasePage
{
	public AccountPage(WebDriver driver)//BUT this constructor appears for every page class,let give it it's own basePage
	{
		super(driver); //gathers the driver from the other parent (BasePage)
	}
	
	
	
	@FindBy (xpath="//h1[normalize-space()='My Account']") // Sid's is "//h2[normalize-space()='My Account']" on his LoginPage
	WebElement confirmationText_MyAccount;
	
	@FindBy(xpath="//li[@class='list-inline-item']//i[@class='fa-solid fa-caret-down']")
	WebElement dropDown_MyAccount;
	
	@FindBy (xpath="//a[@class='dropdown-item'][normalize-space()='Logout']")
	WebElement link_Logout;

	public WebElement getMyAccountConfirmation()
	{
		return confirmationText_MyAccount;//.isDisplayed(); -if we used this the data type would be Boolean, but w/o it, it is WebElement
	}
	
	public void clickMyAccountDropDown() {
		dropDown_MyAccount.click();
	}
	
	public void clickLogout() {
		link_Logout.click();
	}
	


}
