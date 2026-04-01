package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class Myaccountpage extends Basepage {
		public Myaccountpage (WebDriver driver) 
		{
			super(driver);
		}
@FindBy(xpath="//h2[text()='My Account']")	//my account page heading
WebElement msgHeading;

@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Logout']")//added in step 6	
WebElement lnkLogout;


public boolean isMyaccountexists()
{
	try {
		return(msgHeading.isDisplayed());
	}
	catch(Exception e)
	{
		return false;
	}
}

public void clickLogout()
{
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].click()",lnkLogout);
}
}
