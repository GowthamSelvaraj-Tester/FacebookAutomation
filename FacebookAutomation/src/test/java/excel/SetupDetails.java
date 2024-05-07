package excel;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class SetupDetails 
	{
		public static Properties prop;
		public static String currentdirectory;
		public static String filepath;
		public static String cellValue;
		public static String url;
		public static String browsers;
		public static String Chrome;
		public static String FireFox;
		public static String Edge;

		static
			{
				try
					{
						currentdirectory 			= System.getProperty("user.dir");
						filepath 					= currentdirectory+"//Credentials.xlsx";
						File file 					= new File (filepath);
						FileInputStream input 		= new FileInputStream(file);
						@SuppressWarnings("resource")
						XSSFWorkbook wb 			= new XSSFWorkbook(input);
						XSSFSheet sheet 			= wb.getSheet("Setupdetails");
						Iterator<Row>rowIterator 	= sheet.rowIterator();
						int columnnumber 			=2;
						List<String>cellValues 		= new ArrayList<>();
					
						while(rowIterator.hasNext())
							{
								Row row 	= rowIterator.next();
								Cell cell 	= row.getCell(columnnumber);
								cellValue 	= cell!=null? cell.getStringCellValue():null;
								cellValues.add(cellValue!=null? cellValue.toString():"");
							}
						
						url 	 = cellValues.get(1);
						browsers = cellValues.get(2);
					}
				catch (Exception e) 
					{
					// TODO: handle exception
					}
			}
		
		static 
			{
				try 
					{
						File file 				 = new File ("D:\\FacebookAutomation\\FacebookAutomation\\FacebookAutomation\\Details");
						FileInputStream readfile = new FileInputStream(file);
						prop = new Properties();
						prop.load(readfile);
						
						Chrome 		= prop.getProperty("Chromedriver");
						FireFox 	= prop.getProperty("Firefoxdriver");
						Edge		= prop.getProperty("EdgeDriver");
					}
				catch (Exception e) 
					{
						// TODO: handle exception
					}
			}
		
				public static void main(String[] args) 
					{
						System.out.println(Chrome);
					}
	}
