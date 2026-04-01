package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends Basepage{	

	//constructor
	public Homepage (WebDriver driver) // constructor of home page and receives the driver from the test
	{
		super(driver); //invoking the parent class constructor by using super keyword and pass the driver to base page
	}
	
//locators	
@FindBy(xpath="//span[normalize-space()='My Account']")	
WebElement lnkmyaccount;

@FindBy(xpath="//a[normalize-space()='Register']")	
WebElement lnkRegister;

@FindBy(xpath="//a[normalize-space()='Login']")	
WebElement lnkLogin;

//action methods
public void clickMyAccount()
{
	lnkmyaccount.click();
}

public void clickRegister()
{
	lnkRegister.click();
}

public void clickLogin()
{
	lnkLogin.click();
}
}
