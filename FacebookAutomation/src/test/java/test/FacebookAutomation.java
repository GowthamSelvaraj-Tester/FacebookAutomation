package test;

import org.testng.annotations.Test;

import dataprovider.DataProviders;
import pages.LoginPageElements;
import utilities.ReuseMethods;
import utilities.TestBase;
import org.testng.annotations.BeforeTest;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

@SuppressWarnings("unused")
public class FacebookAutomation 
	{
		public static WebDriver driver;
		
		TestBase test = new TestBase();
		
		ReuseMethods reuse = new ReuseMethods(driver);
		
	
		@BeforeTest
		public void beforeSuite() 
			{
				driver = TestBase.driver;
			}
	
		@Test(priority=0,dataProvider="invalidemaildata",dataProviderClass= DataProviders.class)
		public void invalidemail(String email, String password) 
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
				
				String actualresult = elements.errormessage.getText();
				
				String expectedresult = "The email or mobile number you entered isn't connected to an account. Find your account and log in.";
				
				assertTrue(actualresult.matches(expectedresult));
			}
		
		@Test(priority=1,dataProvider="invalidpassworddata", dataProviderClass= DataProviders.class )
		public void invalidpassword(String email, String password) 
		{
			//Import LoginPage to get the webelements
			LoginPageElements elements = new LoginPageElements(driver);
			
			//Explicit Wait time
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
			
			//condition to locate the email field
			wait.until(ExpectedConditions.elementToBeClickable(elements.loginbutton));
			
			reuse.clear(elements.emailfield);
			reuse.entertext(elements.emailfield,email);
			reuse.clear(elements.passwordfield);
			reuse.entertext(elements.passwordfield, password);
			reuse.click(elements.loginbutton);
			
			String actualresult = elements.errormessage.getText();
			
			String expectedresult = "The password that you've entered is incorrect";
			
			assertTrue(actualresult.matches(expectedresult));
		}
		
		@Test(priority=2,dataProvider="validlogindata", dataProviderClass= DataProviders.class )
		public void validlogin (String email, String password) 
		{
			//Import LoginPage to get the webelements
			LoginPageElements elements = new LoginPageElements(driver);
			
			//Explicit Wait time
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
			
			//condition to locate the email field
			wait.until(ExpectedConditions.elementToBeClickable(elements.loginbutton));
			
			reuse.clear(elements.emailfield);
			reuse.entertext(elements.emailfield,email);
			reuse.clear(elements.passwordfield);
			reuse.entertext(elements.passwordfield, password);
			reuse.click(elements.loginbutton);
			
			wait.until(ExpectedConditions.visibilityOf(elements.homepage));
			
			assertTrue(elements.homepage.isDisplayed());
		}
		
		
		@AfterTest()
		public void afterSuite() 
			{
				driver.quit();
			}

}
