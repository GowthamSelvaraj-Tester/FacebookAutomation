package utility;

public class ResourceUtility 
	{
		public static String getFolderPath()
		{
			return GlobalVariable.basepath+ConfigReaders.getProperty("testDataPath");
		}
	}
