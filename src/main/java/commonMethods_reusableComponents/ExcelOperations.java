package commonMethods_reusableComponents;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
org.apache.poi.ss.usermodel.Sheet

public class ExcelOperations {
	
	// below line throws error becos it is in default constructor, default constructor cannot handle 
	// this exception which is throwing from getPropertyValueByKey method so we will move the below line inside the method.
	//String filePath = System.getProperty("user.dir")+PropertiesOperations.getPropertyValueByKey("testDataLocation");
	String filePath;
	Sheet sh;
	
	//Note: It is better to define inside the constructor than inside method
	// becos when we create object the value for the variable filepath we will be created.
	
	// 2 .option let us create constructor and put the line inside it.
	
	
	// if more than one sheet we can parameterize it.
	public ExcelOperations(String sheetName){
		// File Location 
		filePath = System.getProperty("user.dir")+PropertiesOperations.getPropertyValueByKey("testDataLocation");
		// Creating Object for file
		File testDataFile = new File(filePath);
		
		Workbook wb = WorkbookFactory.create(testDataFile);
		sh = wb.getSheet(sheetName);

	}
	
	//Note: we are reading data from excel and storing in hash map 
	// get test data from test data sheet in hash map based on row number
	public HashMap<String, String> getTestDataInMap(int rowNum) throws EncryptedDocumentException, IOException {
	// 1 option	String filePath = System.getProperty("user.dir")+PropertiesOperations.getPropertyValueByKey("testDataLocation");
		
		// Location - Where is excel file
		// open file - Workbook
		// 2003 .xls --> HSSFWorkbook
		// 2007 .xlsx --> XSSFWorkbook
			
		sh.getRow(0).getCell(1).toString();
		// read data row by row and put in map
		HashMap<String, String> hm = new HashMap<String, String>();
		// row 0 is going to be constant as we going to get the column name.
		for (int i=0; i<sh.getRow(0).getLastCellNum(); i++) {
			sh.getRow(rowNum).getCell(i).setCellType(CellType.STRING);
			hm.put(sh.getRow(0).getCell(i).toString(), sh.getRow(rowNum).getCell(i).toString());
		}
			
		
		
		return hm;
	}
//	public static void main(String[] args) throws Exception{
		
	//	ExcelOperations e = new ExcelOperations();
		//System.out.println(e.getTestDataInMap(2));
		
	//}
	
	// get RowCount
	public int getRowCount() {
		return sh.getLastRowNum();
	}
	
	// get 	column count
	public int getColCount() {
		// instead of storing return values in variables we can simply return it.
		return sh.getRow(0).getLastCellNum();
	}

}
