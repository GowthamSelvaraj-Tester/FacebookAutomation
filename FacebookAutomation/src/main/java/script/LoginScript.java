package script;

import org.openqa.selenium.WebDriver;

import modules.LoginPageModule;

public class LoginScript  {

	WebDriver driver;
	private LoginPageModule module;
	
	public LoginScript(WebDriver driver) {
		this.driver = driver;
		module = new LoginPageModule(driver);
	}
}
