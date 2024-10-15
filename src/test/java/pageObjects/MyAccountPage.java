package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {
	
	//constructor
	
	public MyAccountPage (WebDriver driver) 
	{
		super(driver);
	}
	
	
	//locator
	
	@FindBy(xpath="	//h2[normalize-space()='My Account']")//my account page heading
	
	WebElement msgheading;
	
	 @FindBy(xpath= "//div[@class='list-group']//a[text()='Logout']")// added in step 6
	WebElement lnklogout;
	 

	//action
	
	public boolean isMyAccountPageExist() {
		
		try {
			return(msgheading.isDisplayed());
		}
		
		catch(Exception e) {
			return(false);	
			
		}
	}

	
	public void clicklogout() {
		
		lnklogout.click();
	}
	//we don't do any validation on the page object class so we will create a logintest page in testcases
}
