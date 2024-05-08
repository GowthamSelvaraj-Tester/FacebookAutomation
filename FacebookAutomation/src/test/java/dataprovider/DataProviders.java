package dataprovider;

import org.testng.annotations.DataProvider;

import excel.LoginDetails;

public class DataProviders 
	{
		
		@DataProvider(name="logindata")
		public static Object[][] providelogindata()
			{
				String email = LoginDetails.email;
				String password = LoginDetails.password;
				return new Object[][] {{email,password}};
			}
		
		public static void main(String[] args) 
			{
				// TODO Auto-generated method stub
			}

}
