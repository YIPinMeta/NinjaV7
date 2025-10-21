package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{ //To use Methods from a previous class we use Extends,Implement is for interface (59:42)
//HomePage is now Child of BasePage once "extends" is mentioned
	//Constructor
	
	public HomePage(WebDriver driver)//BUT this constructor appears for every page class,let give it it's own basePage
	{
		super(driver); //gathers the driver from the other parent (BasePage)
	}
	//Locators -Here we compact the xpaths
	@FindBy(xpath="//i[@class='fa-solid fa-user']") //driver.findElement(By.xpath("//i[@class='fa-solid fa-user']")).click(); //Clicks 'My Account'
	WebElement link_MyAccount; //SCN: This method seems to create variables for reusable xpaths/locators for a neater program
	@FindBy(xpath="//a[normalize-space()='Login']") //driver.findElement(By.xpath("//a[normalize-space()='Login']")).click(); //Click 'Login'
	WebElement link_Login;
	
	// below this point are my own added in @FindBys
	@FindBy(xpath="//a[normalize-space()='Laptops & Notebooks']")
	WebElement link_LapAndNote;
	
	@FindBy(xpath="//a[normalize-space()='Show All Laptops & Notebooks']")
	WebElement link_ShowAll;
	
	@FindBy(xpath="//a[normalize-space()='Affiliate']")
	WebElement link_Affiliate;
	
	//Action Methods - Here we are able to assign commands/ actions to our compacted xpaths  
	
	public void clickMyAccount()
	{
		link_MyAccount.click();
	}                      //Now that we've assigned compacted xpaths an action we can use them
	
	public void  goToLogin()
	{
		link_Login.click();
	}
	
	public void clickLapAndNote()
	{
		link_LapAndNote.click();
	}
	
	public void goToLapAndNoteCatalog()
	{
		link_ShowAll.click();
	}
	
	public void clickAffilate() throws InterruptedException
	{
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", link_Affiliate);
		 
		 Thread.sleep(500);
		 
		 link_Affiliate.click();
	}
}
