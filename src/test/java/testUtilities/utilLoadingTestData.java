package testUtilities;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class utilLoadingTestData {
    public static ArrayList<Object[]> loadingData() throws IOException {
        ArrayList<Object[]> arrayTestData = new ArrayList<Object[]>();
        InputStream in = new FileInputStream("src/testData/DataExel.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(in);
        Sheet sheet = wb.getSheetAt(0);
        Iterator<org.apache.poi.ss.usermodel.Row> it = sheet.iterator();
        while (it.hasNext()) {
            org.apache.poi.ss.usermodel.Row row = it.next();
            Iterator<Cell> cells = row.cellIterator();
            int iteration = 0;
            Object[] testData = new Object[3];
            while (cells.hasNext()) {
                Cell cell = cells.next();
                int cellType = cell.getCellType();
                switch (cellType) {
                    case Cell.CELL_TYPE_NUMERIC:
                        testData[iteration] = Integer.valueOf((int)cell.getNumericCellValue());
                        break;
                    case Cell.CELL_TYPE_STRING:
                        testData[iteration] = cell.getStringCellValue();
                        break;
                }
                arrayTestData.add(testData);
                iteration++;
            }
        }
    return arrayTestData;
    }
}