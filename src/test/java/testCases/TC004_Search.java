package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.Baseclass;
import pageObjects.Search;

public class TC004_Search extends Baseclass {
	@Test
	public void verify_Serach()
	{
		try {
	logger.info("*** TC004 started ****");
	Search searchpage= new Search(driver);
	searchpage.clicksearch();
	searchpage.clickSearchitem();
	searchpage.clickadd();
	
	boolean cartExists = searchpage.isMycartexists();
    Assert.assertTrue(cartExists, "Cart success message");
}
catch(Exception e)
{
	
	logger.error("Exception occurred: ", e);
    Assert.fail("Test failed due to exception: " + e.getMessage());
}
logger.info("*** Finished Firstcase ****"); 
}

}
