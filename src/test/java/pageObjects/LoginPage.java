package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Basepage {
	public LoginPage (WebDriver driver) 
	{
		super(driver);
	}

	
	//locators	
	@FindBy(xpath="//input[@id='input-email']")	
	WebElement txtemailaddress;

	@FindBy(xpath="//input[@id='input-password']")	
	WebElement txtpasswrd;

	@FindBy(xpath="//input[@value='Login']")	
	WebElement btnLogin;
	
	
	public void setEmailaddress(String email)
	{
		txtemailaddress.sendKeys(email);
	}
	public void setpasswordL(String passwo)
	{
		txtpasswrd.sendKeys(passwo);
	}
	
	public void clickLogin( )
	{
		btnLogin.click();
	}
}
