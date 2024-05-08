package test;

import org.testng.annotations.Test;

import dataprovider.DataProviders;
import pages.LoginPageElements;
import utilities.ReuseMethods;
import utilities.TestBase;

import org.testng.annotations.BeforeSuite;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;

public class FacebookAutomation 
	{
		public static WebDriver driver;
		
		TestBase test = new TestBase();
		
		ReuseMethods reuse = new ReuseMethods(driver);
		
	
		@BeforeSuite
		public void beforeSuite() 
			{
				driver = TestBase.driver;
			}
	
		@Test(dataProvider="logindata",dataProviderClass= DataProviders.class)
		public void loginPage(String email, String password) 
			{
				//Import LoginPage to get the webelements
				LoginPageElements elements = new LoginPageElements(driver);
				
				//Explicit Wait time
				WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
				
				//condition to locate the email field
				wait.until(ExpectedConditions.elementToBeClickable(elements.loginbutton));
				
				reuse.entertext(elements.emailfield,email);
				reuse.entertext(elements.passwordfield, password);
				reuse.click(elements.loginbutton);
			}
  
		@AfterSuite
		public void afterSuite() 
			{
			
			}

}
