package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {
	
	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups = "Datadriven")
	 public void verify_loginDDT(String email, String pwd, String exp ) throws InterruptedException {
			
			logger.info("..starting....TC003_LoginDDT....");
					
			try {
			//home page	
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();
			
			
			//login page
			LoginPage lp = new LoginPage(driver);
			lp.setEmailAddress(email);
			lp.setPass(pwd);
			lp.clickbtn();
			
			
			//my account page
			
			// data is valid - login success - test pass - logout
			                //   login fail - test fail 
			// invalid data - login success - test fail -logout
			               //login failed - test pass
			
			MyAccountPage mcc = new MyAccountPage(driver);
			Boolean targetpage = mcc.isMyAccountPageExist();
			
			if (exp.equalsIgnoreCase("valid")) 
			{
				
				if (targetpage==true)
				{
					Assert.assertTrue(true);
					mcc.clicklogout();
				}
				
				else {
					Assert.assertTrue(false);
				}
			}
			
			
			if (exp.equalsIgnoreCase("Invalid")) 
			{
				
				if (targetpage==true)
				{
					mcc.clicklogout();
					Assert.assertTrue(false);
				}
				
				else 
				{
					Assert.assertTrue(true);
				}
			}
			

			}catch(Exception e) 
			{
				Assert.fail();
			}
			
			Thread.sleep(300);
			logger.info("..Finished....TC003_LoginDDT....");

  }
			
	 
}
