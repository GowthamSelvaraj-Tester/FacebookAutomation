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

@SuppressWarnings("resource")
public class LoginDetails 
	{
		public static Properties prop;
		public static String currentdirectory;
		public static String filepath;
		public static String cellValue;
		public static String email;
		public static String password;
		
		static
			{
				try
					{
						currentdirectory = System.getProperty("user.dir");
						filepath = currentdirectory+"//Credentials.xlsx";
						File file = new File(filepath);
						FileInputStream input = new FileInputStream(file);
						XSSFWorkbook wb = new XSSFWorkbook(input);
						XSSFSheet sheet = wb.getSheet("LoginDetails");
						Iterator<Row> rowIterator = sheet.rowIterator();
						int columnnumber =2;
						List <String> cellValues = new ArrayList<>();
						
						while(rowIterator.hasNext())
							{
								Row row = rowIterator.next();
								Cell cell = row.getCell(columnnumber);
								cellValue = cell!=null? cell.getStringCellValue():null;
								cellValues.add(cellValue!=null? cellValue.toString():"");
							}
						email = cellValues.get(1);
						password = cellValues.get(2);
					}
				catch(Exception e)
					{
					
					}
			}

		public static void main(String[] args)
			{
				// TODO Auto-generated method stub
			}
	}
