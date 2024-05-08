package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ReuseMethods 
	{
		public WebDriver driver;
		
		public void entertext(WebElement elementname, String value)
			{
				elementname.sendKeys(value);
			}
		
		public void click(WebElement elementname)
			{
				elementname.click();
			}
		
		public ReuseMethods(WebDriver driver)
			{	
				this.driver = driver;
				PageFactory.initElements(driver,this);
			}
	
		public static void main(String[] args)
			{
				// TODO Auto-generated method stub
			}	

}
