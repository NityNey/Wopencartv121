package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AcountRegistraionPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
	

	
   
	@Test(groups = {"Regression", "Master"})
    public void verify_account_registration() {
		
		logger.info("........test started.....");
		
		try {
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		
		logger.info("...clicked on my account page");
		
		hp.clicRegister();
		logger.info("...clicked on my registered page");

		AcountRegistraionPage arp = new AcountRegistraionPage(driver);
		arp.setFirstName("test2");
		//		arp.setFirstName(randomString().toUpperCase()); to pass data randomly and in upper case

		arp.setLastName("test3");
		arp.setEmail(randomString()+ "@gmail.com");
		arp.setTelephone("123234389");
		
		
		// Used the generated alphanumeric password
		String password = randomeAlphaNumberic();
		
		arp.setPassword(password);
		arp.setconfrimpassword(password);
		
		arp.clickcheckobx();
		arp.clickContinue();
		
		logger.info("...validated message...");

		String conf= arp.msgConfirmation();
		Assert.assertEquals(conf, "Your Account Has Been Created!");
		}
		
		catch(Exception e) {
			
			logger.error("test failed");
			logger.debug("Debug logs");
			Assert.fail();
		}
	}
	
	
}
