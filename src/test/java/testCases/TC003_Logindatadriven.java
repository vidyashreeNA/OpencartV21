package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.Baseclass;
import pageObjects.Homepage;
import pageObjects.LoginPage;
import pageObjects.Myaccountpage;
import utilities.Dataprovider;


public class TC003_Logindatadriven extends Baseclass{
	
	@Test(dataProvider="LoginData",dataProviderClass=Dataprovider.class,groups="Datadriven")//which we specified in dataprovider class and dataprovider in same class means dataproviderclass is not required
	public void verify_Logindatadriven(String email,String pwd, String exp)
	{
		logger.info("*** TC003 started ****");
		try
		{
		
		 Homepage hp=new Homepage(driver);
			hp.clickMyAccount();
			hp.clickLogin();
			
			LoginPage lp=new LoginPage(driver)	; 
			lp.setEmailaddress(email);
			lp.setpasswordL(pwd);	 
		    lp.clickLogin();
		
		    
		    Myaccountpage macc= new Myaccountpage(driver);
		    boolean targetpage=macc.isMyaccountexists();
		    
		    /*Data is valid--login sucess-test pass  -logout
			  Data is valid--login failed--test fail
			
			 Data is Invalid--login sucess-test fail   -logout
			  Data is Invalid--login failed--test pass
			 */	
		    
		   if(exp.equalsIgnoreCase("Valid")) 
		   {
			   if (targetpage==true)
			   {
				   macc.clickLogout(); // because to take next one
				   Assert.assertTrue(true);// keep logout first because after assertion no condition will execute
			   }
			   else
			   {
				   Assert.assertTrue(false);
			   }
		   }
		   if(exp.equalsIgnoreCase("Invalid")) 
		   {
			   if (targetpage==true)
			   {
				   macc.clickLogout(); 
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
		finally {
			logger.info("*** TC003 finished ****");

		}
    }
}
