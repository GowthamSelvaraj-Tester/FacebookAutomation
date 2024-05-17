package testbase;

import org.testng.annotations.Test;

import base.Base;
import utility.ConfigReaders;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestBase extends Base {
  @Test
  public void f() {
  }
  @BeforeSuite
  public void launchbrowser() throws IOException 
  	{
	  initializedriver(ConfigReaders.getProperty("appUrl"));
  	}

  @AfterSuite
  public void browserteardown() 
  	{
	  	closebrowser(driver);
  	}	
}
