package keywords;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class Excel_Keywords 
{
	
	static HSSFWorkbook book;
	static HSSFSheet sht;
	static HSSFRow row;
	static HSSFCell cell;
	public static String filepath="src\\Resources\\";
	
	//This method connect to Excel workook and sheet
	public static void get_workbook(String filename,String sheetname)
	{
		try {
			FileInputStream fi=new FileInputStream(filepath+filename+".xls");
			System.out.println("Input file located");
			
			book=new HSSFWorkbook(fi);
			sht=book.getSheet(sheetname);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//This method return cell value from particular row number and cell number
	public static String get_cell_Data(int row, int cell)
	{
		return sht.getRow(row).getCell(cell).getStringCellValue();
	}
	
	
	//This method set New cell value using perticular row and cell number
	public static void set_cell_Data(int row, int cell,String celldata)
	{
		sht.getRow(row).getCell(cell).setCellValue(celldata);
	}
	
	
	//This method target requried sheet and return Entire sheet to method
	public static HSSFSheet get_sheet(String SheetName)
	{
		return sht=book.getSheet(SheetName);
	}
	
	//This method Save runtime data and Create output file
	public static void Save_And_Close_Workbook(String filename)
	{
		try {
			FileOutputStream fo=new FileOutputStream(filepath+filename+".xls");
			book.write(fo);
			book.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	
	
	
	

}
