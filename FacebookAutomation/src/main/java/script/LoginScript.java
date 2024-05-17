package script;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import modules.LoginPageModule;
import utility.ConfigReaders;
import utility.ExcelUtility;
import utility.GlobalVariable;
import utility.ResourceUtility;

public class LoginScript 
	{
		private WebDriver driver;
		private LoginPageModule loginPageModule;
		private String excelSheetPath = ResourceUtility.getFolderPath();
	
		
		public LoginScript(WebDriver driver)
			{
				this.driver = driver;
				loginPageModule = new LoginPageModule(driver);
			}
		
		public void logintest(String testCaseName)
			{
				try 
					{
						Map <String, String> testDataMap = new ExcelUtility().getdata( testCaseName,excelSheetPath,ConfigReaders.getProperty("testDataSheetName"));
						loginPageModule.login(testDataMap);
						System.out.println(testDataMap);
					}
				catch(Exception e)
					{
						
					}
			}
	}
