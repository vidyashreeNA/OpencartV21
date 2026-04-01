package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.Baseclass;
import pageObjects.Homepage;
import pageObjects.LoginPage;
import pageObjects.Myaccountpage;

public class TC002_LoginTest extends Baseclass {
	

		@Test(groups={"Sanity","Master"})
		public void verify_Login()
	   {
		 logger.info("*** Starting Firstcase ****"); 
		 
		 try {
			  Homepage hp=new Homepage(driver);
				hp.clickMyAccount();
				 logger.info("clicked on Account");
				 hp.clickLogin();
				 logger.info("clicked on Login"); 
					
					LoginPage lp=new LoginPage(driver)	;
					logger.info("Providing customer details"); 
					lp.setEmailaddress(p.getProperty("email"));// these are not coming from java code so double quotes req
					lp.setpasswordL(p.getProperty("password"));	 
				    lp.clickLogin();
				    
				    Myaccountpage macc= new Myaccountpage(driver);
				    boolean targetpage=macc.isMyaccountexists();
				    
				    
					Assert.assertTrue(targetpage);
					
					
				}
				catch(Exception e)
				{
					
					Assert.fail();
				}
				logger.info("*** Finished Firstcase ****"); 
			   }
				
			
				    
		 
}

