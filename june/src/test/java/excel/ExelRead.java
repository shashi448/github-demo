package excel;

import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExelRead {

	public static void main(String[] args) {
		XSSFWorkbook ExcelWorkbook;
		XSSFSheet ExcelSheet;
		XSSFCell ExcelCell;
		HSSFWorkbook excelWorkBook;
		HSSFSheet excelSheet;
		HSSFCell excelCell;

		String xssfPath = "C:\\Users\\shashi\\Desktop\\fulltime\\excel\\pc1.xlsx";
		String hssfPath = "C:\\Users\\shashi\\Desktop\\fulltime\\excel\\Moola.xls";
		String xssfSheet = "Sheet1";
		String hssfSheet = "Sheet1";

		try {
			try {
				FileInputStream fis = new FileInputStream(xssfPath);
				ExcelWorkbook = new XSSFWorkbook(fis);
				ExcelSheet = ExcelWorkbook.getSheet(xssfSheet);
				ExcelCell = ExcelSheet.getRow(2).getCell(1);
				String cellData = ExcelCell.getStringCellValue();
				System.out.println(cellData);
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				FileInputStream fp = new FileInputStream(hssfPath);
				excelWorkBook = new HSSFWorkbook(fp);
				excelSheet = excelWorkBook.getSheet(hssfSheet);
				excelCell = excelSheet.getRow(3).getCell(0);
				String cellData1 = excelCell.getStringCellValue();
				System.out.println(cellData1);
			} catch (Exception e) {
				System.out.println(e);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}