package testUtilities;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class UtilLoadingTestData {
    private static final String DATA_PATH = "src/test/resources/TestData.xlsx";

    /**
     * loads the data for the test from the excel file
     */
    public static ArrayList<Object[]> loadingData(int numberOfSheet) throws IOException {
        ArrayList<Object[]> arrayTestData = new ArrayList<Object[]>();
        InputStream in = new FileInputStream(DATA_PATH);
        XSSFWorkbook wb = new XSSFWorkbook(in);
        Sheet sheet = wb.getSheetAt(numberOfSheet);
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
                        testData[iteration] = Integer.valueOf((int) cell.getNumericCellValue());
                        break;
                    case Cell.CELL_TYPE_STRING:
                        testData[iteration] = cell.getStringCellValue();
                        break;
                }
                iteration++;
            }
            arrayTestData.add(testData);
        }
        return arrayTestData;
    }
}