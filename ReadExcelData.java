package Utility;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;
public class ReadExcelData {
	@Test
	public static String[][] readData(String excelFileName) throws IOException {
		XSSFWorkbook book = new XSSFWorkbook("./testData/"+excelFileName+".xlsx");       //open the Excel sheet
		XSSFSheet sheet= book.getSheetAt(0);          //get to the sheet where data is available
		int rowCount=sheet.getLastRowNum();           //row count
		System.out.println("Row Count: "+ rowCount);  
		XSSFRow headerrow=sheet.getRow(0);            //column count
		short colCount=headerrow.getLastCellNum();
		System.out.println("Column Count: "+ colCount);
		
		//for storing and sending data to dataprovider, creating 2d array
		String[][] data = new String[rowCount][colCount];
		
		for (int i = 1; i <= rowCount; i++) {
			
			XSSFRow eachRow=sheet.getRow(i);  
			for (int j = 0; j < colCount; j++) {
				XSSFCell eachCell=eachRow.getCell(j);
				String value= eachCell.getStringCellValue();
				System.out.println(value+"\t");
				data[i-1][j]=value;
				}
			System.out.println();		
			}
		book.close();
		return data;
		}}
