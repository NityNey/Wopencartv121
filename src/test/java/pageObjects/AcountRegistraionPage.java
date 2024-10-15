package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AcountRegistraionPage extends BasePage{
	
	//constructor
	
		public AcountRegistraionPage (WebDriver driver) {
			
			super (driver);
		}
	
		//locator
		
		@FindBy(xpath="//input[@id='input-firstname']")
		WebElement txtName;
		
		@FindBy(xpath= "//input[@id='input-lastname']")
		WebElement txtLastName;
		
		@FindBy(xpath= "//input[@id='input-email']")
		WebElement txtEmail;
		
		@FindBy(xpath="//input[@id='input-telephone']")
		WebElement txtTelephone;
		
		
		@FindBy(xpath= "//input[@id='input-password']")
		WebElement txtPassword;
		
		@FindBy(xpath= "//input[@id='input-confirm']")
		WebElement txtConfirmPassword;
		
		
		@FindBy(xpath= "//input[@name='agree']")
		WebElement chkCheckbox;
		
		
		@FindBy(xpath= "//input[@value='Continue']")
		WebElement btnContinue;
		
		
		@FindBy(xpath= "//h1[normalize-space()='Your Account Has Been Created!']")
		WebElement msgConfirmation;
		
		
		
		//Action
		public void setFirstName(String fName) {
			
			txtName.sendKeys(fName);
		}
		
       public void setLastName(String lName) {
			
    	   txtLastName.sendKeys(lName);
		}


      public void setEmail(String email) {
	
    	  txtEmail.sendKeys(email);
     }


    public void setTelephone(String telephone) {
	
	txtTelephone.sendKeys(telephone);
}


     public void setPassword(String password) {
	
	txtPassword.sendKeys(password);
}


     public void setconfrimpassword(String confirmpassword) {
	
	 txtConfirmPassword.sendKeys(confirmpassword);
     }


      public void clickcheckobx() {
	
	   chkCheckbox.click();
        }

       public void clickContinue() {
	
	    btnContinue.click();
       }
		

/*
 if click method don't work then we can use an alternate way
 
 //sol2

//btnContinue.submit();

//sol3
//Actions act=new Actions(driver);
//act.moveToElement(btnContinue).click().perform();

//sol4
//JavascriptExecutor js=(JavascriptExecutor)driver;
//js.executeScript("arguments[0].click();", btnContinue);

//Sol 5
//btnContinue.sendKeys(Keys.RETURN);

//Sol6
//WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
//mywait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();

 */
		
		
		

	public String msgConfirmation() {
		
		try {
			
		return (msgConfirmation.getText());
		}
		
		catch(Exception e) {
			
			return(e.getMessage());
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
