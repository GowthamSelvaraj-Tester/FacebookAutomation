package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageElements 
	{
		public WebDriver driver;
		
		@FindBy(id="email")
		public WebElement emailfield;
		
		@FindBy(id="pass")
		public WebElement passwordfield;
		
		@FindBy(name="login")
		public WebElement loginbutton;
		
		public LoginPageElements(WebDriver driver)
			{
				this.driver= driver;
				PageFactory.initElements(driver,this);
			}
		
		public static void main(String[] args) 
			{
				// TODO Auto-generated method stub
			}
	}
