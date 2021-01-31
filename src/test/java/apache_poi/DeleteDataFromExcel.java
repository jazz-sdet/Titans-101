package apache_poi;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import java.io.*;
public class DeleteDataFromExcel {


    @Test
    public void deleteTest() throws IOException {
        File file = new File("src/test/resources/TestExcelFine.xlsx");
        FileInputStream fileInputStream = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet=workbook.getSheetAt(0);
        Row row = sheet.getRow(3);
        Cell cell=row.getCell(0);
        row.removeCell(cell);

        FileOutputStream fileOutputStream= new FileOutputStream(file);
        workbook.write(fileOutputStream);

        fileInputStream.close();
        fileOutputStream.close();
        workbook.close();

    }
}
