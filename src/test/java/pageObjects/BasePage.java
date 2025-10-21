package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;

public class BasePage { //a page holding objects used in ALL test cases in one place; I.E WebDriver method and Close Driver
//Constuctor
	WebDriver driver;
	public BasePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this); //Have chat gpt explain this method
	}
	
	
	
	//@Test (priority=3)
		@AfterClass
		void closeApp()
		{
		driver.quit();
		}

	//Locator
	//Action Methods
}
