package pageObjects;

	
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;

	public class AccountRegistrationPage extends Basepage {

		
		public AccountRegistrationPage (WebDriver driver)
		{
			super(driver);
		}
		
	@FindBy(xpath="//input[@id='input-firstname']")	
	WebElement txtFirstname;

	@FindBy(xpath="//input[@id='input-lastname']")	
	WebElement txtLastname;
	
	@FindBy(xpath="//input[@id='input-email']")	
	WebElement txtEmail;

	@FindBy(xpath="//input[@id='input-telephone']")	
	WebElement txtTelephone;
	
	@FindBy(xpath="//input[@id='input-password']")	
	WebElement txtPassword;

	@FindBy(xpath="//input[@id='input-confirm']")	
	WebElement txtConfirmPassword;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement CheckAgree;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btnContinue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	public void setFirstName(String fname)// fname will be get from testcase
	{
		txtFirstname.sendKeys(fname);// send the fname
	}

	public void setLastName(String lname)
	{
		txtLastname.sendKeys(lname);
	}
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	public void setTelephone(String telephone)
	{
		txtTelephone.sendKeys(telephone);
	}
	public void setPassword(String passwrd)
	{
		txtPassword.sendKeys(passwrd);
	}
	public void setConfirmPassword(String passwrd) // confirm password is same as password so same name
	{
		txtConfirmPassword.sendKeys(passwrd);
	}
	public void setprivacyPolicy( )
	{
		CheckAgree.click();
	}
	public void clickContinue( )
	{
		btnContinue.click();
	}
	
	// we should not validate in page object class
	public String getConfirmationMsg()
	{
		try {
			return(msgConfirmation.getText());//capture the text value from locator and return the text
		}catch (Exception e) {
			return(e.getMessage());// if not captured it throws exception 
		}
	}
	
}