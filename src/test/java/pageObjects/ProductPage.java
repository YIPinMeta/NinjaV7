package pageObjects;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends BasePage
{
	
		
	public ProductPage(WebDriver driver) {
		super(driver);
		
	}

	//Locators
	@FindBy(xpath="//input[@id='input-option-225']")
	WebElement btn_dateInput;
	
	@FindBy(xpath="//button[@id='button-cart']")
	WebElement btn_AddToCart;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement SuccessMsg;
	
	@FindBy(xpath="//div//button//i[@class='fa-solid fa-heart']")
	WebElement btn_Wishlist;
	
	//Action Methods

		public void setDeliveryDate() throws InterruptedException
		{
			LocalDate currentDate = LocalDate.now(); //A class that gives the current date - @39:00
			
			
			LocalDate deliveryDate = currentDate.plusDays(5);
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");//A class that formats dates
			
			String formattedDeliveryDate = deliveryDate.format(formatter);
			Thread.sleep(500);
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", btn_dateInput);
			Thread.sleep(500); //not sure why but for whatever reason a wait may always need to be added if the page doesn't scroll
			btn_dateInput.sendKeys(formattedDeliveryDate); 
		}
		
		public void AddToCart()
		{
			btn_AddToCart.click();
		}
		
		public String verify_SuccessMsg()
		{
			return SuccessMsg.getText();
		}
		
		public void ClickWishlist()
		{
			btn_Wishlist.click();
		}
		
		
	}



