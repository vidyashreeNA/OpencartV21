package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Basepage { // reusable for all pages
	
WebDriver driver;

//constructor this is the parent of all child page objects	
	
public Basepage (WebDriver driver)
	{
		this.driver=driver;   // this driver will store the driver sent by child classes
		PageFactory.initElements(driver, this);  // initialize all findby elements and also connect webelement to the driver
	}

}
