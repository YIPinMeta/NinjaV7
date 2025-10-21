package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AffiliatePage extends BasePage{
	
	
	public AffiliatePage(WebDriver driver) {
		super(driver);
	
	}

	@FindBy(id="input-company")
	WebElement field_company;
	
	@FindBy(id="input-website")
	WebElement field_website;
	
	@FindBy(id="input-tax")
	WebElement field_tax;
	
	@FindBy(id="input-payment-paypal")
	WebElement option_paypal;
	
	@FindBy(css="#input-paypal")
	WebElement field_paypal;
	
	@FindBy(xpath="//button[normalize-space()='Continue']")
	WebElement btn_Continue;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement confirmationMsg;
	
	
	
	public void completeForm () throws InterruptedException
	{
		field_company.clear();
		field_company.sendKeys("Cloudberry");
		
		field_website.clear();
		field_website.sendKeys("cloudberry.services");
		
		field_tax.clear();
		field_tax.sendKeys("123456");
		
		option_paypal.click();
		
		field_paypal.clear();
		field_paypal.sendKeys("K.anderson030419@gmail.com");
		
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",btn_Continue);// (true) is case sensitive
		
		Thread.sleep(500);
		
		btn_Continue.click();
	}
	
	public WebElement Confirm()
	{
		return confirmationMsg;//.isDisplayed(); -if we used this the data type would be Boolean, but w/o it, it is WebElement
	}
	
}
