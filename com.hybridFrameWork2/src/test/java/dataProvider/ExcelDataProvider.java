package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	XSSFWorkbook wb;
	File src;
	FileOutputStream fout;

	public ExcelDataProvider() {

		src = new File(System.getProperty("user.dir") + "/DataFiles/dataSheet.xlsx");

		try {
			FileInputStream fis = new FileInputStream(src);

			wb = new XSSFWorkbook(fis);

			System.out.println("Excel sheet is loaded properly and ready to use");

		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
			System.out.println("Exception while loading the file");
		}

	}

	public String getData(String Sheet, int row, int column) {

		return wb.getSheet(Sheet).getRow(row).getCell(column).getStringCellValue();

	}

	public int getRow(String Sheet) {

		return wb.getSheet(Sheet).getPhysicalNumberOfRows();
	}

	public void writeData(String Sheet, int row, int column, String value) {

		wb.getSheet(Sheet).getRow(row).createCell(column).setCellValue(value);

	}

	public void StartWriteExcel() {

		src = new File(System.getProperty("user.dir") + "/DataFiles/dataSheet.xlsx");

		try {
			fout = new FileOutputStream(src);

		} catch (IOException e) {

			e.getMessage();

		}

	}

	public void closeExcel() {

		try {
			wb.write(fout);
			wb.close();
		
		} catch (IOException e) {

			System.out.println("unable to write the sheet");
		}
	}

}
