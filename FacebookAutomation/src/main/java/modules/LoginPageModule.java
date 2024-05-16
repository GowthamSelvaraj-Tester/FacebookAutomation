package modules;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import io.qameta.allure.Step;
import pageObject.LoginPageObject;
import utility.ConfigReaders;

public class LoginPageModule 
	{
		private LoginPageObject loginPageObject;
		
		public LoginPageModule(WebDriver driver)
			{
				loginPageObject = new LoginPageObject(driver);
			}
		
		@Step("Login into Facebook")
		public void login(Map <String, String> testMapData)
		{
			loginPageObject.enteremail(testMapData.get(ConfigReaders.getProperty("emailID")));
			loginPageObject.enterpassword(testMapData.get(ConfigReaders.getProperty("password")));
			loginPageObject.clickbutton();
		}
		
		
	}
