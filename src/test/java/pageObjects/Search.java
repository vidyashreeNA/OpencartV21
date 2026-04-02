package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Search extends Basepage {
	public Search (WebDriver driver) 
	{
		super(driver);
	} 
	
	@FindBy(xpath="//a[normalize-space()='Desktops']")	
	WebElement searchitem;
	@FindBy(xpath="//a[normalize-space()='Mac (1)']")
    WebElement searchmac;
	
	@FindBy(xpath="//span[normalize-space()='Add to Cart']")
	WebElement addcart;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")	//my account page heading
	WebElement msgsuccess;
	
	public void clicksearch()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()",searchitem);
	}
	public void clickSearchitem()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()",searchmac);
	}
	public void clickadd()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()",addcart);
	}
	public boolean isMycartexists()
	{
		try {
			return(msgsuccess.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	
}
