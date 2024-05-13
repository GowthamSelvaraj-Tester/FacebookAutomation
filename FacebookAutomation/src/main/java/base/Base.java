package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import excel.SetupDetails;

@SuppressWarnings("unused")
public class Base extends SetupDetails

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
									
									Object launchChromeBrowser = browserinstance(Chrome,currentdirectory+"//chromedriver//chromedriver.exe");
									driver = new ChromeDriver();
									launch(driver);
									break;
									
								case "Firefox":
									Object launchfirefoxbrowser = browserinstance(Firefox, currentdirectory+"//geckodriver//geckodriver.exe");
									driver = new FirefoxDriver();
									launch(driver);
									break;
								
								case "Edge":
									Object launchedgebrowser = browserinstance(Edge, currentdirectory+"//edgedriver//msedgedriver.exe");
									driver = new FirefoxDriver();
									launch(driver);
									break;
									
								default:
									Object defaultbrowser = browserinstance(Chrome,currentdirectory+"//chromedriver//chromedriver.exe");
									driver = new ChromeDriver();
									launch(driver);
									break;
							}
					}
				catch (Exception e)
					{
						System.out.println(e);
					}
			}
		
		public static Object[][]browserinstance(String instance,String driverlocation )
			{
				System.getProperty(instance, driverlocation);
				return new Object[][] {{instance,driverlocation}};
			}
		
		public static void launch(WebDriver driver)
			{
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				driver.get(url);
			}

		public static void main(String[] args) 
			{
				// TODO Auto-generated method stub
			}
	}
