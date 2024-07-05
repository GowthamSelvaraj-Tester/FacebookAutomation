package modules;

import java.util.Map;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import actions.Action;
import listener.Listener;
import pageObject.LoginPageObject;
import utility.ConfigReaders;
import utility.ResourceUtility;
import utility.ExcelUtility;
import utility.MessageReaders;

public class LoginPageModule {
	WebDriver driver;
	
	private LoginPageObject element;
	private Action reuse;
	
	public LoginPageModule(WebDriver driver) {
		this.driver = driver;
		this.element = new LoginPageObject(driver);
		this.reuse = new Action(driver);
	}
	
	private String sheetpath = ResourceUtility.getFolderPath();
	private String sheetName = ConfigReaders.getProperty("testDataSheetName");
	
	public Map<String,String> getdata(String testCaseName) throws Exception{
		return new ExcelUtility().getdata(testCaseName,sheetpath, sheetName);
	}
	
	public void checkEmail() {
		try {
			Assert.assertTrue(element.emailfield.isDisplayed(),"Email field is not displayed");
			Listener.extentTest.get().log(Status.PASS,"Email field is displayed");
			
			String expectedPlaceholder = MessageReaders.getProperty("emailplaceholder");
			String actualPlaceholder   = element.emailfield.getAttribute("placeholder");
			
			Assert.assertEquals(actualPlaceholder, expectedPlaceholder,"Placeholder text's doesn't match");
		}catch(NoSuchElementException e) {
			Listener.extentTest.get().log(Status.FAIL,"NoSuchElementException:" + e.getMessage());
			Assert.fail("NoSuchElementException", e);
		}catch(AssertionError e) {
			Listener.extentTest.get().log(Status.FAIL,"AssertionError:" + e.getMessage());
			Assert.fail("AssertionError", e);
		}catch(Exception e) {
			Listener.extentTest.get().log(Status.FAIL,"Exception:" + e.getMessage());
			Assert.fail("Exception", e);
		}
	}
	
	public void checkPassword() {
		try {
			Assert.assertTrue(element.passwordfield.isDisplayed(),"Password field is not displayed");
			Listener.extentTest.get().log(Status.PASS,"Password field is displayed");
			
			String expectedPlaceholder = MessageReaders.getProperty("passwordplaceholder");
			String actualPlaceholder   = element.passwordfield.getAttribute("placeholder");
			
			Assert.assertEquals(actualPlaceholder,expectedPlaceholder,"Placeholder text's doesn't match");
		}catch(NoSuchElementException e) {
			Listener.extentTest.get().log(Status.FAIL,"NoSuchElementException:" + e.getMessage());
			Assert.fail("NoSuchElementException", e);
		}catch(AssertionError e) {
			Listener.extentTest.get().log(Status.FAIL,"AssertionError:" + e.getMessage());
			Assert.fail("AssertionError", e);
		}catch(Exception e) {
			Listener.extentTest.get().log(Status.FAIL,"Exception:" + e.getMessage());
			Assert.fail("Exception", e);
		}
	}
	
	public void checkButton() {
		try {
			Assert.assertTrue(element.loginbutton.isDisplayed(),"Login Button is not displayed");
			Listener.extentTest.get().log(Status.PASS,"Login Button is displayed");
			
			String expectedButtontext = MessageReaders.getProperty("passwordplaceholder");
			String actualButtontext   = element.passwordfield.getText();
			
			Assert.assertEquals(actualButtontext,expectedButtontext,"Button text's doesn't match");
		}catch(NoSuchElementException e) {
			Listener.extentTest.get().log(Status.FAIL,"NoSuchElementException:" + e.getMessage());
			Assert.fail("NoSuchElementException", e);
		}catch(AssertionError e) {
			Listener.extentTest.get().log(Status.FAIL,"AssertionError:" + e.getMessage());
			Assert.fail("AssertionError", e);
		}catch(Exception e) {
			Listener.extentTest.get().log(Status.FAIL,"Exception:" + e.getMessage());
			Assert.fail("Exception", e);
		}
	}
	
	public void enterEmail(Map<String,String> testDataMap) {
		try {
			String email = testDataMap.get(ConfigReaders.getProperty("emailID"));
			Listener.extentTest.get().log(Status.INFO,"Entering Email:" + email);
			reuse.entertext(element.emailfield, email);
		}catch(Exception e) {
			Listener.extentTest.get().log(Status.FAIL,"Exception Occured:"+ e.getMessage());
		}
	}
	
	public void enterPassword(Map<String,String> testDataMap) {
		try {
			String password = testDataMap.get(ConfigReaders.getProperty("password"));
			Listener.extentTest.get().log(Status.INFO,"Entering Password:" +password);
			reuse.entertext(element.passwordfield, password);
		} catch(Exception e) {
			Listener.extentTest.get().log(Status.FAIL,"Exception Occured:" + e.getMessage());
		}
	}
	
	public void clickLogin() {
		try {
			reuse.click(element.loginbutton);
			Listener.extentTest.get().log(Status.INFO,"Login Button Clicked");
		}catch(Exception e) {
			Listener.extentTest.get().log(Status.FAIL,"Exception Occured:" + e.getMessage());
		}
	}
}
