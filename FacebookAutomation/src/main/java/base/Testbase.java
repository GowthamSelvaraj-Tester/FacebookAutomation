package base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import utility.ConfigReaders;
import utility.GlobalVariable;

public class Testbase 
	{
		public WebDriver driver;
		
		public WebDriver intiializedriver(String url) throws IOException
		{
			String browser = ConfigReaders.getProperty("browsers");
			
			if(browser.matches("Chrome")) 
				{
			    	System.getProperty(ConfigReaders.getProperty("Chromedriver"),GlobalVariable.basepath+ConfigReaders.getProperty("chromedriverlocation"));
			    	ChromeOptions option = new ChromeOptions();
					option.addArguments("--disable-infobars");
					option.addArguments("--incognito");
			    	driver = new ChromeDriver(option);
			    }
			else if(browser.matches("Firefox"))
				{
					System.getProperty(ConfigReaders.getProperty("Firefoxdriver"),GlobalVariable.basepath+ConfigReaders.getProperty("firefoxdriverlocation"));
					FirefoxOptions option = new FirefoxOptions();
					option.addArguments("--disable-infobars");
					option.addArguments("--incognito");
					driver = new FirefoxDriver(option);
				}
			else if(browser.matches("Edge"))
				{
					System.getProperty(ConfigReaders.getProperty("Edgedriver"),GlobalVariable.basepath+ConfigReaders.getProperty("edgedriverlocation"));
					EdgeOptions option = new EdgeOptions();
					option.addArguments("--disable-infobars");
					option.addArguments("--incognito");
					driver = new EdgeDriver(option);
				}
			else
				{
					System.getProperty(ConfigReaders.getProperty("Chromedriver"),GlobalVariable.basepath+ConfigReaders.getProperty("chromedriverlocation"));
					ChromeOptions option = new ChromeOptions();
					option.addArguments("--disable-infobars");
					option.addArguments("--incognito");
					driver = new ChromeDriver(option);	
				}
			
			return driver;
			
			
		}
	}
