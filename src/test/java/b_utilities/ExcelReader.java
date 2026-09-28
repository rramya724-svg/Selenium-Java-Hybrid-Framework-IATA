package b_utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import org.apache.poi.common.usermodel.HyperlinkType;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFCreationHelper;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFHyperlink;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader extends a_testbase.BaseClass {

    private final String path;
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private XSSFRow row;
    private XSSFCell cell;

    public ExcelReader(String path) {
        this.path = path;
        try (FileInputStream fis = new FileInputStream(path)) {
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheetAt(0);
        } catch (IOException e) {
            logger.error("Failed to load Excel file at path: {}", path, e);
        }
    }

    public int getRowCount(String sheetName) {
        int index = workbook.getSheetIndex(sheetName);
        if (index == -1) {
            return 0;
        }
        sheet = workbook.getSheetAt(index);
        return sheet.getLastRowNum() + 1;
    }

    public int getColumnCount(String sheetName) {
        if (!isSheetExist(sheetName)) {
            return -1;
        }
        sheet = workbook.getSheet(sheetName);
        row = sheet.getRow(0);
        return (row == null) ? -1 : row.getLastCellNum();
    }

    private int findColumnNumber(String sheetName, String colName) {
        int index = workbook.getSheetIndex(sheetName);
        if (index == -1) {
            return -1;
        }
        sheet = workbook.getSheetAt(index);
        row = sheet.getRow(0);
        if (row == null) {
            return -1;
        }
        for (int i = 0; i < row.getLastCellNum(); i++) {
            if (row.getCell(i).getStringCellValue().trim().equals(colName.trim())) {
                return i;
            }
        }
        return -1;
    }

    private String formatCellData(XSSFCell cell) {
        if (cell == null) {
            return "";
        }
        if (cell.getCellType() == CellType.STRING) {
            return cell.getStringCellValue();
        } else if (cell.getCellType() == CellType.NUMERIC || cell.getCellType() == CellType.FORMULA) {
            if (DateUtil.isCellDateFormatted(cell)) {
                double d = cell.getNumericCellValue();
                Calendar cal = Calendar.getInstance();
                cal.setTime(DateUtil.getJavaDate(d));
                String year = String.valueOf(cal.get(Calendar.YEAR)).substring(2);
                return cal.get(Calendar.DAY_OF_MONTH) + "/" + (cal.get(Calendar.MONTH) + 1) + "/" + year;
            }
            return String.valueOf(cell.getNumericCellValue());
        } else if (cell.getCellType() == CellType.BLANK) {
            return "";
        } else {
            return String.valueOf(cell.getBooleanCellValue());
        }
    }

    public String getCellData(String sheetName, String colName, int rowNum) {
        try {
            if (rowNum <= 0) {
                return "";
            }
            int colNum = findColumnNumber(sheetName, colName);
            if (colNum == -1) {
                return "";
            }
            sheet = workbook.getSheet(sheetName);
            row = sheet.getRow(rowNum - 1);
            if (row == null) {
                return "";
            }
            cell = row.getCell(colNum);
            return formatCellData(cell);
        } catch (Exception e) {
            logger.error("Error accessing row {} or column {} in XLS file: {}", rowNum, colName, e.getMessage(), e);
            return "row " + rowNum + " or column " + colName + " does not exist in xls";
        }
    }

    public String getCellData(String sheetName, int colNum, int rowNum) {
        try {
            if (rowNum <= 0 || colNum < 0) {
                return "";
            }
            int index = workbook.getSheetIndex(sheetName);
            if (index == -1) {
                return "";
            }
            sheet = workbook.getSheetAt(index);
            row = sheet.getRow(rowNum - 1);
            if (row == null) {
                return "";
            }
            cell = row.getCell(colNum);
            return formatCellData(cell);
        } catch (Exception e) {
            logger.error("Error accessing row {} or column {} in XLS file: {}", rowNum, colNum, e.getMessage(), e);
            return "row " + rowNum + " or column " + colNum + " does not exist in xls";
        }
    }

    public boolean setCellData(String sheetName, String colName, int rowNum, String data) {
        try (FileInputStream fis = new FileInputStream(path); FileOutputStream fileOut = new FileOutputStream(path)) {
            workbook = new XSSFWorkbook(fis);
            if (rowNum <= 0) {
                return false;
            }
            int index = workbook.getSheetIndex(sheetName);
            if (index == -1) {
                return false;
            }
            sheet = workbook.getSheetAt(index);
            row = sheet.getRow(0);
            int colNum = -1;
            if (row != null) {
                for (int i = 0; i < row.getLastCellNum(); i++) {
                    if (row.getCell(i).getStringCellValue().trim().equals(colName)) {
                        colNum = i;
                        break;
                    }
                }
            }
            if (colNum == -1) {
                return false;
            }
            sheet.autoSizeColumn(colNum);
            row = sheet.getRow(rowNum - 1);
            if (row == null) {
                row = sheet.createRow(rowNum - 1);
            }
            cell = row.getCell(colNum);
            if (cell == null) {
                cell = row.createCell(colNum);
            }
            cell.setCellValue(data);
            workbook.write(fileOut);
            return true;
        } catch (IOException e) {
            logger.error("Error in setCellData: {}", e.getMessage(), e);
            return false;
        }
    }

    public boolean setCellData(String sheetName, String colName, int rowNum, String data, String url) {
        try (FileInputStream fis = new FileInputStream(path); FileOutputStream fileOut = new FileOutputStream(path)) {
            workbook = new XSSFWorkbook(fis);
            if (rowNum <= 0) {
                return false;
            }
            int index = workbook.getSheetIndex(sheetName);
            if (index == -1) {
                return false;
            }
            sheet = workbook.getSheetAt(index);
            row = sheet.getRow(0);
            int colNum = -1;
            if (row != null) {
                for (int i = 0; i < row.getLastCellNum(); i++) {
                    if (row.getCell(i).getStringCellValue().trim().equalsIgnoreCase(colName)) {
                        colNum = i;
                        break;
                    }
                }
            }
            if (colNum == -1) {
                return false;
            }
            sheet.autoSizeColumn(colNum);
            row = sheet.getRow(rowNum - 1);
            if (row == null) {
                row = sheet.createRow(rowNum - 1);
            }
            cell = row.getCell(colNum);
            if (cell == null) {
                cell = row.createCell(colNum);
            }
            cell.setCellValue(data);
            XSSFCreationHelper createHelper = workbook.getCreationHelper();
            CellStyle hlinkStyle = workbook.createCellStyle();
            XSSFFont hlinkFont = workbook.createFont();
            hlinkFont.setUnderline(Font.U_SINGLE);
            hlinkFont.setColor(IndexedColors.BLUE.getIndex());
            hlinkStyle.setFont(hlinkFont);
            XSSFHyperlink link = createHelper.createHyperlink(HyperlinkType.FILE);
            link.setAddress(url);
            cell.setHyperlink(link);
            cell.setCellStyle(hlinkStyle);
            workbook.write(fileOut);
            return true;
        } catch (IOException e) {
            logger.error("Error in setCellData with hyperlink: {}", e.getMessage(), e);
            return false;
        }
    }

    public boolean addSheet(String sheetName) {
        try (FileOutputStream fileOut = new FileOutputStream(path)) {
            workbook.createSheet(sheetName);
            workbook.write(fileOut);
            return true;
        } catch (IOException e) {
            logger.error("Error in addSheet: {}", e.getMessage(), e);
            return false;
        }
    }

    public boolean removeSheet(String sheetName) {
        int index = workbook.getSheetIndex(sheetName);
        if (index == -1) {
            return false;
        }
        try (FileOutputStream fileOut = new FileOutputStream(path)) {
            workbook.removeSheetAt(index);
            workbook.write(fileOut);
            return true;
        } catch (IOException e) {
            logger.error("Error in removeSheet: {}", e.getMessage(), e);
            return false;
        }
    }

    public boolean addColumn(String sheetName, String colName) {
        try (FileInputStream fis = new FileInputStream(path); FileOutputStream fileOut = new FileOutputStream(path)) {
            workbook = new XSSFWorkbook(fis);
            int index = workbook.getSheetIndex(sheetName);
            if (index == -1) {
                return false;
            }
            sheet = workbook.getSheetAt(index);
            XSSFCellStyle style = workbook.createCellStyle();
            style.setFillForegroundColor(IndexedColors.GREY_40_PERCENT.getIndex());
            style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            row = sheet.getRow(0);
            if (row == null) {
                row = sheet.createRow(0);
            }
            cell = row.createCell(row.getLastCellNum() == -1 ? 0 : row.getLastCellNum());
            cell.setCellValue(colName);
            cell.setCellStyle(style);
            workbook.write(fileOut);
            return true;
        } catch (IOException e) {
            logger.error("Error in addColumn: {}", e.getMessage(), e);
            return false;
        }
    }

    public boolean removeColumn(String sheetName, int colNum) {
        try (FileInputStream fis = new FileInputStream(path); FileOutputStream fileOut = new FileOutputStream(path)) {
            workbook = new XSSFWorkbook(fis);
            if (!isSheetExist(sheetName)) {
                return false;
            }
            sheet = workbook.getSheet(sheetName);
            XSSFCellStyle style = workbook.createCellStyle();
            style.setFillForegroundColor(IndexedColors.GREY_40_PERCENT.getIndex());
            style.setFillPattern(FillPatternType.NO_FILL);
            for (int i = 0; i < getRowCount(sheetName); i++) {
                row = sheet.getRow(i);
                if (row != null) {
                    cell = row.getCell(colNum);
                    if (cell != null) {
                        cell.setCellStyle(style);
                        row.removeCell(cell);
                    }
                }
            }
            workbook.write(fileOut);
            return true;
        } catch (IOException e) {
            logger.error("Error in removeColumn: {}", e.getMessage(), e);
            return false;
        }
    }

    public boolean isSheetExist(String sheetName) {
        int index = workbook.getSheetIndex(sheetName);
        if (index == -1) {
            index = workbook.getSheetIndex(sheetName.toUpperCase());
            return index != -1;
        }
        return true;
    }

    public boolean addHyperLink(String sheetName, String screenShotColName, String testCaseName, int index, String url,
            String message) {
        url = url.replace('\\', '/');
        if (!isSheetExist(sheetName)) {
            return false;
        }
        sheet = workbook.getSheet(sheetName);
        for (int i = 2; i <= getRowCount(sheetName); i++) {
            if (getCellData(sheetName, 0, i).equalsIgnoreCase(testCaseName)) {
                setCellData(sheetName, screenShotColName, i + index, message, url);
                return true;
            }
        }
        return false;
    }

    public int getCellRowNum(String sheetName, String colName, String cellValue) {
        for (int i = 2; i <= getRowCount(sheetName); i++) {
            if (getCellData(sheetName, colName, i).equalsIgnoreCase(cellValue)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] arg) {
        ExcelReader datatable = new ExcelReader(
                "C:\\CM3.0\\app\\test\\Framework\\AutomationBvt\\src\\config\\xlfiles\\Controller.xlsx");
        for (int col = 0; col < datatable.getColumnCount("TC5"); col++) {
            String cellData = datatable.getCellData("TC5", col, 1);
            logger.info("Column {}: {}", col, cellData);
        }
    }
}