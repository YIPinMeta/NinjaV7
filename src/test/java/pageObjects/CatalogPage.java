package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CatalogPage extends BasePage
{
	
	
	public CatalogPage(WebDriver driver) {
		super(driver);
		
	}


	@FindBy(xpath="//div[@class='description']//a[contains(text(),'HP LP3065')]")
	WebElement Link_HpLaptop;
	
	
	public void locateLaptop() throws InterruptedException
	{
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",Link_HpLaptop);
		Thread.sleep(500);
		Link_HpLaptop.click();
	}

	
	
	}
