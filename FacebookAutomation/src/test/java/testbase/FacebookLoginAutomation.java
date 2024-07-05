package testbase;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.Base;
import listener.Listener;
import script.LoginScript;
import utility.ConfigReaders;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.AfterSuite;
@Listeners({Listener.class})
public class FacebookLoginAutomation extends Base {

	private Base webDriverutil;
	protected WebDriver driver;
	
	public WebDriver getDriver() {
		return driver;
	}
	@BeforeSuite
	public void launchbrowser() throws IOException  {
		webDriverutil = new Base();
		driver = webDriverutil.initializedriver(ConfigReaders.getProperty("URL"));
  	}
    
    @Test
    public void TC001_loginPageValidation() {
    	try {
    		LoginScript script = new LoginScript(driver);
    		script.TC001_loginPageValidation();
    	} catch(Exception e) {
    		Listener.extentTest.get().log(Status.FAIL,"Exception occured when executing the Invalid Email TestCase:" + e.getMessage());
			Assert.fail("Test case failed due to an exception: " + e.getMessage());
    	}
    }

  @AfterSuite
  public void browserteardown() 
  	{
	  	closebrowser(driver);
  	}	
}
