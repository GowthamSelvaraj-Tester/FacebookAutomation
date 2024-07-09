package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject  {
	
	WebDriver driver;

	public LoginPageObject(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="email")
	public WebElement emailfield;
		
	@FindBy(id="pass")
	public WebElement passwordfield;
		
	@FindBy(xpath="//*[contains(text(),'Log in')]")
	public WebElement loginbutton;	
}
