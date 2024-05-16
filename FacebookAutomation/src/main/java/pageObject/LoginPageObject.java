package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utility.ConfigReaders;

public class LoginPageObject 
	{
		public LoginPageObject(WebDriver driver)
			{
				PageFactory.initElements( new AjaxElementLocatorFactory(driver,Integer.parseInt(ConfigReaders.getProperty("webDriverWaitTime"))),this);
			}
		
		@FindBy(name="email")
		private WebElement emailfield;
		
		@FindBy(name="pass")
		public WebElement passwordfield;
		
		@FindBy(name="login")
		public WebElement loginbutton;
		
		public void enteremail(String email)
			{
				this.emailfield.clear();
				this.emailfield.sendKeys(email);
			}
		
		public void enterpassword(String password)
			{
				this.passwordfield.clear();
				this.passwordfield.sendKeys(password);
			}
		public void clickbutton()
			{
				this.loginbutton.click();
			}
		
	}
