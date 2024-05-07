package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import excel.SetupDetails;

public class TestBase extends SetupDetails
	{
	
		public static WebDriver driver;
		
		static
			{
				try
					{
						String currentdirectory = System.getProperty("user.dir");
	
						String browser = browsers;
											
						switch(browser)
						{
							case "Chrome":
								System.setProperty(Chrome, currentdirectory+"//chromedriver//chromedriver.exe");
								driver = new ChromeDriver();
								driver.manage().window().maximize();
								driver.manage().deleteAllCookies();
								driver.get(url);
								break;
							
							case "Firefox":
								System.setProperty(FireFox, currentdirectory+"//geckodriver//geckodriver.exe");
								driver = new FirefoxDriver();
								driver.manage().window().maximize();
								driver.manage().deleteAllCookies();
								driver.get(url);
								break;
							
							case "Edge":
								System.setProperty(Edge,	currentdirectory+"//edgedriver//msedgedriver.exe");
								driver = new EdgeDriver();
								driver.manage().window().maximize();
								driver.manage().deleteAllCookies();
								driver.get(url);
								break;
							
							default:
								System.setProperty(Chrome, 	currentdirectory+"//chromedriver//chromedriver.exe");
								driver = new ChromeDriver();
								driver.manage().window().maximize();
								driver.manage().deleteAllCookies();
								driver.get(url);
								break;
							
						}
						
					}
				catch (Exception e)
					{
						// TODO: handle exception
					}
			}

		public static void main(String[] args) 
			{
		// TODO Auto-generated method stub

			}
	}
