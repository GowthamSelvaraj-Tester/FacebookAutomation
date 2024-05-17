package testbase;

import org.testng.annotations.Test;

import io.qameta.allure.Story;
import script.LoginScript;


public class TestRunners extends TestBase
	{
		
		@Story("Login into Facebook")
		@Test(priority=0)
		public void TC002_invalidpassword() 
			{
		String testCaseName = new Object(){}.getClass().getEnclosingMethod().getName();
		LoginScript loginScript = new LoginScript(driver);
	    loginScript.logintest(testCaseName);
			}
	   
	    @Story("Login into Facebook")
	    @Test(priority=1)
	    public void TC003_validlogin()
	    	{
	    		String testCaseName = new Object(){}.getClass().getEnclosingMethod().getName();
	    		LoginScript loginScript = new LoginScript(driver);
	    		loginScript.logintest(testCaseName);
	    	}
	    
	}

