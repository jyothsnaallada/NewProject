package pkg1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataRetriver {
	static HashMap<String, String> map = new HashMap<String, String>();
	public static HashMap<String, String> dataRetrieve(String sheetName, String scenarioId) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		//This HashMap is declared to capture the complete excel sheet information

		HashMap<String ,  HashMap<String , String>> sheetMap = new HashMap<String ,  HashMap<String , String>>();
		HashMap<String, String> finalDataMap;
		//Properties_Util config = new Properties_Util();
		try {
			//Create an object of File class to open xlsx file
			File myfile = new File("C:\\Users\\arjyo\\OneDrive\\Desktop\\Yuvan party 12-Mar-2023.xlsx");
			//Create an object of FileInputStream class to read excel file
			FileInputStream inputStream = new FileInputStream(myfile);               

			//Creating workbook instance that refers to .xls file
			Workbook wb=new XSSFWorkbook(inputStream);              

			//You can also pass the sheet name instead of sheet number

			//Sheet sheet = wb.getSheetAt(0);

			//Sheet sheet = wb.getSheet("SampleTestData");

			org.apache.poi.ss.usermodel.Sheet sheet = wb.getSheet(sheetName);

			 

			int totalrows = sheet.getLastRowNum();

			//Here i am printing total number of rows that sheet is having

			System.out.println("Printing Total Rows: "+totalrows);

			 

			//This HashMap is used to fetch the header/Headings of the sheet information

			HashMap<String , String> header = new HashMap<String , String>();
			for(int i=0;i<=totalrows;i++)
			{
			Row row = sheet.getRow(i);
			//This HashMap is used to fetch each row complete columns information
			HashMap<String , String> rowMap = new HashMap<String , String>();
			//if condition is used to fetch the complete headers information and storing it in sheetMap Map
			if(i==0){
			int headerCount = 0;
			Iterator<org.apache.poi.ss.usermodel.Cell> celIt = row.cellIterator();
			//Here i am increasing the cell i.e. not row
			while(null != celIt && celIt.hasNext()){                                        
			//Adding extra code
			//This will move the cursor to the next column
			org.apache.poi.ss.usermodel.Cell ce = celIt.next();  
			DataFormatter formatter = new DataFormatter();
			String cellValue=formatter.formatCellValue(ce);
			header.put(headerCount+"", cellValue);
			//header.put(headerCount+"", celIt.next().getStringCellValue());

			headerCount++;

			}

			//putting the header information into sheetMap Map, i.e. header columns

			sheetMap.put("Sheet_header", header);

			System.out.println("PRINTING SHEETMAP IN IF CONDITION: = "+sheetMap);

			}

			 

			//Below i am storing the each complete column values by taking each header heading help

			else {

			int headerCount = 0;

			Iterator<org.apache.poi.ss.usermodel.Cell> celIt = row.cellIterator();                                

			//Here i am increasing the cell i.e. not row

			while(null != celIt && celIt.hasNext()){

			//This will move the cursor to the next column

			org.apache.poi.ss.usermodel.Cell ce = celIt.next();  

			DataFormatter formatter = new DataFormatter();

			String cellValue=formatter.formatCellValue(ce);

			//ce.setCellType(ce.CELL_TYPE_STRING);                                         

			//Here i am capturing the each column information with the help of header

			rowMap.put(header.get(headerCount+""), cellValue);

			//System.out.println("rowMap = "+rowMap);

			headerCount++;

			}

			 

			//Capturing all the rows information and putting into single headers i.e. by using HashMap i.e. rowMap.get(header.get(0+"")

			//is containing the sheet headers information; rowMap is containing the remaining rows and columns information

			sheetMap.put(rowMap.get(header.get(0+"")), rowMap);
  //sheet map returns entrire excel sheet rows and coloums values//
			System.out.println("PRINTING SHEETMAP IN ELSE CONDITION: = "+sheetMap);

			}

			 

			}

			 

			} catch (FileNotFoundException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

			}

			//System.out.println("FINAL SHEET MAP : = "+sheetMap);

			 

			//this is the additional step added to store the specific scenario column names and values into another map

			//indvScenarioData(sheetMap.get(scenarioId))

			finalDataMap = (HashMap<String, String>) sheetMap.get(scenarioId);

			System.out.println(finalDataMap);

			 

			return finalDataMap;

			 

			//return sheetMap;

			 

			}

		
	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {

		// TODO Auto-generated method stub



		ExcelDataRetriver obj = new ExcelDataRetriver();

		map = obj.dataRetrieve("SampleTestData", "12");

		System.out.println(map);





	}



}


