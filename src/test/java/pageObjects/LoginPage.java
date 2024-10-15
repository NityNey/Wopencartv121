package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	//constructor
	
	public LoginPage(WebDriver driver) {
		
		super (driver);
	}

	
	
	//LOCATORS
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmail;
	
	@FindBy(xpath= "//input[@id='input-password']")
	WebElement txtPassword;
	
	@FindBy(xpath= "//input[@value='Login']")
	WebElement btnlogin;
	
	
	//ACtion
	
	public void setEmailAddress(String email) {
		
		txtEmail.sendKeys(email);
	}
	
   public void setPass(String pass) {
		
	   txtPassword.sendKeys(pass);
	}


  public void clickbtn() {

	  btnlogin.click();
 }
	
}
