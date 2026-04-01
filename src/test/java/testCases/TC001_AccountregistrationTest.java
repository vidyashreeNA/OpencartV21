package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.Baseclass;
import pageObjects.AccountRegistrationPage;
import pageObjects.Homepage;

public class TC001_AccountregistrationTest extends Baseclass {
	@Test(groups={"Regression","Master"})
	public void verify_account_registration()
   {
	 logger.info("*** Starting Firstcase ****"); 
	try {
	  Homepage hp=new Homepage(driver);
		hp.clickMyAccount();
		 logger.info("clicked on Account"); 

		hp.clickRegister();
		 logger.info("clicked on Register"); 

		
	AccountRegistrationPage regpage=new AccountRegistrationPage(driver)	;
	logger.info("Providing customer details"); 
		regpage.setFirstName(randomString().toUpperCase());
		regpage.setLastName(randomString().toUpperCase());
		regpage.setEmail(randomString()+"@gmail.com");// or you hard code
		regpage.setTelephone(randomNumber());
		
		String password=randomAlphaNumeric();
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		
		regpage.setprivacyPolicy();
		regpage.clickContinue();
		
		logger.info("Validating expected message"); 
		String Cofmsg=regpage.getConfirmationMsg();
		if(Cofmsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Test failed..");
			logger.debug("Debug logs..");
			Assert.assertTrue(false);
		}
	}
	catch(Exception e)
	{
		
		Assert.fail();
	}
	logger.info("*** Finished Firstcase ****"); 
   }
	
}
