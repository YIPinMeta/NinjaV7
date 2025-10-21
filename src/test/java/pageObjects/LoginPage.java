package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{
	//Constructor
	public LoginPage(WebDriver driver)//BUT this constructor appears for every page class,let give it it's own basePage
	{
		super(driver); //gathers the driver from the other parent (BasePage)
	}
	//Locator
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txt_Email;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txt_Password;
	
	@FindBy(xpath="//button[normalize-space()='Login']")
	WebElement btn_Login;
	
	//Action Methods
	public void setEmail(String email)
	{
		txt_Email.sendKeys(email);
	}
	
	public void setPwd(String pwd)
	{
		txt_Password.sendKeys(pwd);
	}
	
	public void clickLogin()
	{
		btn_Login.click();
	}

}
