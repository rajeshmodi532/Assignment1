package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLutils {
	
	static FileInputStream fi;
	static FileOutputStream fo;
	static XSSFWorkbook wb;
	static Sheet sh;
	static Cell cell;

//	This method useful to get Last row of Excel
	public static int getRow(String SheetName) throws Exception {
		
		fi = new FileInputStream(".\\testinputs\\assign-1.xlsx");
		wb =new XSSFWorkbook(fi);
		sh=wb.getSheet(SheetName);
		return  sh.getLastRowNum();
	}
//	This method used to get the data from Excel sheet from required Cell
	public static String getData(String SheetName,int rowNum,int col) throws Exception{
		fi=new FileInputStream(".\\testinputs\\assign-1.xlsx");
		wb= new XSSFWorkbook(fi);
		Sheet ws=wb.getSheet(SheetName);
		Row row=ws.getRow(rowNum);
		
		String data;
//		This condition checks the date type
		if (row.getCell(col).getCellType()==Cell.CELL_TYPE_NUMERIC) {
			 int tempdata=(int) row.getCell(col).getNumericCellValue();
			 data=String.valueOf(tempdata);
		}else{			
			data=row.getCell(col).getStringCellValue();
		}
		return data;
	}
//	Writing the data into Excel sheet
	public static void setData(String SheetName,int rowNum,int col, String data) throws Exception{		
		fi = new FileInputStream("E:\\selenium workspace\\assignment1\\testinputs\\assign-1.xlsx");
		wb =new XSSFWorkbook(fi);
		wb.getSheet(SheetName).getRow(rowNum).createCell(col).setCellValue(data);
		fo=new FileOutputStream("E:\\selenium workspace\\assignment1\\testinputs\\assign-1.xlsx");
		wb.write(fo);
		fo.close();	
	
	}

}
