package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends BasePage{
	
public CheckoutPage(WebDriver driver) {
		super(driver);
		
	}

@FindBy(xpath="//a[@title='Checkout']//i[@class='fa-solid fa-share']") //Checkout's actually on all pages
WebElement Link_Checkout;

@FindBy(xpath="//strong[normalize-space()='login page']")
WebElement Link_ToLogin;

@FindBy(xpath="//select[@id='input-shipping-address']")
WebElement Drpdwn_Add;

@FindBy(id="button-shipping-methods")
WebElement Btn_AddOpt;

@FindBy(id="button-shipping-method")
WebElement Btn_ShipCont;

@FindBy(id="button-payment-methods")
WebElement Btn_PayOpt;

@FindBy(xpath="//button[@id='button-payment-method']")
WebElement Btn_PayCont;

@FindBy(xpath="//div[@class='text-end']//button[contains(text(),'Confirm')]")
WebElement Btn_Confirm;

@FindBy(xpath="//h1[normalize-space()='Your order has been placed!']")
WebElement OrderPlacedMsg;

public void scrollToCheckout() throws InterruptedException
{
((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",Link_Checkout); //Scroll to that variable we just made

Thread.sleep(500);

Link_Checkout.click();
}
 public void goToLogin()
 {
	 Link_ToLogin.click();
 }
 
 public void completeCheckout() throws InterruptedException
 {
	 new Select(Drpdwn_Add).selectByIndex(1);
	 Btn_AddOpt.click();
	 Btn_ShipCont.click();
	 Btn_PayOpt.click();
	 Btn_PayCont.click();
	// Btn_Confirm.click();
	 ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",Btn_Confirm); 
		Thread.sleep(500);
		scroll(Btn_Confirm); //we wrapped the confirm button in to a scroll action, Line 74
		Thread.sleep(500); //Btn_Confirm finds confirm,This Thread pauses the test temporarily
	((JavascriptExecutor)driver).executeScript("arguments[0].click(true);",Btn_Confirm);
	//The pause allows the  JS Executor to click during the pause
 }
	
private void scroll(WebElement element) {// This private is only for scrolls mentioned in the class/page, Line 68
	((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",element);
}

 public WebElement Confirm_OrderPlacedMsg() 
	 {
	 
	 return OrderPlacedMsg;
 }

}
