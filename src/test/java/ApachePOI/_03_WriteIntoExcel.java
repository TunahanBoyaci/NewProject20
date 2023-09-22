package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class _03_WriteIntoExcel {
    public static void main(String[] args) throws IOException {

        String path = "src/test/java/ApachePOI/recources/WriteIntoAnExcel.xlsx";

        FileInputStream fileInputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet = workbook.getSheet("Sheet1");

        int rowCount = sheet.getPhysicalNumberOfRows();

        Row row0 = sheet.createRow(rowCount);
        for (int i = 0; i < 10; i++) {
            Cell cell0 = row0.createCell(i);
            cell0.setCellValue("Hello 8");
        }

        FileOutputStream fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);
        fileOutputStream.close();
        fileInputStream.close();
    }
}
