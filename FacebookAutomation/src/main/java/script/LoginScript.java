package script;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import listener.Listener;
import modules.LoginPageModule;

public class LoginScript  {

	WebDriver driver;
	private LoginPageModule module;
	
	public LoginScript(WebDriver driver) {
		this.driver = driver;
		module = new LoginPageModule(driver);
	}
	
	public void TC001_loginPageValidation() {
		try {
			module.checkEmail();
			module.checkPassword();
			module.checkButton();
		}catch(Exception e) {
			Listener.extentTest.get().log(Status.FAIL, "Exception Occured while executing TestCase:" + e.getMessage());
			Assert.fail("Login Page UI Validation",e);
		}
	}
}
