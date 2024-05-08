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
		
		@FindBy(xpath="//div[@class='_9ay7']")
		public WebElement errormessage;
		
		@FindBy(xpath="//div[@class='x9f619 x1n2onr6 x1ja2u2z']")
		public WebElement homepage;
	
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
