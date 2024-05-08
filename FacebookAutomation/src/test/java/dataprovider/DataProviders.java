package dataprovider;

import org.testng.annotations.DataProvider;

public class DataProviders 
	{
		
		@DataProvider(name="validlogindata")
		public static Object[][] validlogindata()
			{
				String email = "nivipriya1001@gmail.com";
				String password = "Lotica@123";
;
				return new Object[][] {{email,password}};
			}
		@DataProvider(name="invalidemaildata")
		public static Object[][] invalidemaildata()
			{
				String email = "zombi3@gmail.com";
				String password = "Test@123";
				return new Object[][] {{email,password}};
			}
		
		@DataProvider(name="invalidpassworddata")
		public static Object[][] invalidpassworddata()
		{
			String email = "abc@gmail.com";
			String password = "Test@123";
			return new Object[][] {{email,password}};
		}
		
		public static void main(String[] args) 
			{
				// TODO Auto-generated method stub
			}

}
