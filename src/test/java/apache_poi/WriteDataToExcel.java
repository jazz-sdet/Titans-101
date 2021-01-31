package apache_poi;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteDataToExcel {

    @Test
    public void writeTest() throws IOException {

        File file = new File("src/test/resources/TestExcelFine.xlsx");
        FileInputStream fileInputStream = new FileInputStream(file);

        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheetAt(0);
        Row newRow = sheet.createRow(3);
        Cell newCell = newRow.createCell(0);
        newCell.setCellType(CellType.STRING);
        newCell.setCellValue("Zhazgul");

        FileOutputStream fileOutputStream = new FileOutputStream(file);
        workbook.write(fileOutputStream);
    }

    @Test
    public void writeTest2() throws IOException {

      XSSFWorkbook workbook=new XSSFWorkbook(
              new FileInputStream(new File("src/test/resources/TestExcelFine.xlsx")));

      XSSFSheet sheet = workbook.getSheet("Sheet1");
      Row row = sheet.getRow(1);
      Cell cell= row.getCell(0);
      cell.setCellValue("Jerry");

      FileOutputStream fileOutputStream=
              new FileOutputStream(new File("src/test/resources/TestExcelFine.xlsx"));
      workbook.write(fileOutputStream);
      workbook.close();

    }
}
