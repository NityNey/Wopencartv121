package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{
	
	

	@Test(groups = {"Sanity","Master"})
    public void verify_login() {
		
		logger.info("..starting....TC002_LoginTest....");
				
		try {
		//home page	
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		
		//login page
		LoginPage lp = new LoginPage(driver);
		lp.setEmailAddress(p.getProperty("email"));
		lp.setPass(p.getProperty("password"));
		lp.clickbtn();
		
		
		//myaccount page
		
		MyAccountPage mcc = new MyAccountPage(driver);
		Boolean targetpage = mcc.isMyAccountPageExist();
		Assert.assertEquals(targetpage, true, "login failed");
		//Assert.assertTrue(targetpage);
		
		}
		
		catch(Exception e) {
			Assert.fail();
		}
		
		logger.info("..finished..TC002_LoginTest....");

	}

}
