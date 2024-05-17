package utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility 
	{
			private XSSFWorkbook excelworkBook;
			private XSSFSheet excelSheet;
			private XSSFCell cell;
			private XSSFRow row;
			
			public void setExcelFile(String sheetPath, String sheetName) throws Exception
				{
					try
						{
							FileInputStream inputexcel = new FileInputStream (sheetPath);
							excelworkBook = new XSSFWorkbook(inputexcel);
							excelSheet = excelworkBook.getSheet(sheetName);
						}
					catch(Exception e)
						{
							e.printStackTrace();
						}
				}
			
			private int getTestCaseRow(String testCaseName, int testCaseColumn) throws Exception
				{
					int row = 0;
					try
						{
							int rowCount = excelSheet.getLastRowNum();
							for(row = 0; row < rowCount; row++)
								{
									if(getCellData(row, testCaseColumn).equalsIgnoreCase(testCaseName))
											{
												break;
											}	
								}
						}
					catch (Exception e)
						{
							e.printStackTrace();
						}
					return row;
				}

			public String getCellData(int rowNumb, int colNumb) throws Exception
				{
					try
						{
							cell = excelSheet.getRow(rowNumb).getCell(colNumb);
							if(cell.getCellType() == CellType.NUMERIC) 
								{
							    	cell.setCellType(CellType.STRING);
								}
							String cellData = cell.getStringCellValue();
							System.out.println(cellData);
							return cellData;
						}
					catch(Exception e)
						{
							e.printStackTrace();
							return " ";
						}
				}
			
			public void setCellData(String result,int rowNumb, int colNumb, String excelFilePath) throws Exception
				{
					try
						{
							row = excelSheet.getRow(rowNumb);
							cell = row.getCell(colNumb);
							
							if(cell == null)
								{
									cell = row.createCell(colNumb);
									cell.setCellValue(result);
								}
							else 
								{
									cell.setCellValue(result);
								}
							
							FileOutputStream output = new FileOutputStream(excelFilePath);
							excelworkBook.write(output);
							output.flush();
							output.close();
						}
					catch(Exception e)
						{
							e.printStackTrace();
						}
				}
			
			public Map getdata(String testCaseName, String sheetPath, String sheetName) throws Exception
				{
					Map dataMap= new HashMap<String, String>();
					try
						{
							setExcelFile(sheetPath,sheetName);
							int dataRow = getTestCaseRow(testCaseName.trim(),0);
							int columnCount = excelSheet.getRow(dataRow).getLastCellNum();
							for(int i=0; i < columnCount ; i++)
								{
									String cellData = null;
									cell = excelSheet.getRow(dataRow).getCell(i);
									if(cell!=null && cell.getCellType() == CellType.NUMERIC)
										{
											cell.setCellType(CellType.STRING);
										}
									if(cell!=null)
										{
											cellData = cell.getStringCellValue();
										}
									dataMap.put(excelSheet.getRow(0).getCell(i).getStringCellValue(),cellData);
								
								}
							
						}
					catch(Exception e)
						{
							e.printStackTrace();
						}
					
					return dataMap;
					
				}
	}
