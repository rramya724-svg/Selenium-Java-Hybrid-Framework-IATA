package b_utilities;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;

public class DataProviders {
    private static final String SHEET_NAME = "Sheet1";
    private static final String EXCEL_PATH = ".\\testData\\Opencart_LoginData.xlsx";
    public static final ExcelReader excel = new ExcelReader(
            System.getProperty("user.dir") + "\\testData\\Opencart_LoginData.xlsx");

    @DataProvider(name = "LoginData")
    public String[][] getData() throws IOException {
        ExcelUtility xlutil = new ExcelUtility(EXCEL_PATH);
        int totalrows = xlutil.getRowCount(SHEET_NAME);
        int totalcols = xlutil.getCellCount(SHEET_NAME, 1);
        String[][] logindata = new String[totalrows][totalcols];

        for (int i = 1; i <= totalrows; i++) {
            for (int j = 0; j < totalcols; j++) {
                logindata[i - 1][j] = xlutil.getCellData(SHEET_NAME, i, j);
            }
        }
        return logindata;
    }

    @DataProvider(name = "dp")
    public Object[][] getData(Method m) {
        int rows = excel.getRowCount(SHEET_NAME);
        int cols = excel.getColumnCount(SHEET_NAME);
        Object[][] data = new Object[rows - 1][1];
        Map<String, String> table;
        for (int rowNum = 2; rowNum <= rows; rowNum++) {
            table = new HashMap<>();
            for (int colNum = 0; colNum < cols; colNum++) {
                table.put(excel.getCellData(SHEET_NAME, colNum, 1), excel.getCellData(SHEET_NAME, colNum, rowNum));
            }
            data[rowNum - 2][0] = table; // Assign table once per row
        }
        return data;
    }
}