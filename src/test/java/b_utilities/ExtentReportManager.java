package b_utilities;

import a_testbase.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat; // Import SimpleDateFormat
import java.util.Base64;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class ExtentReportManager extends BaseClass implements ITestListener, ISuiteListener {
    private ExtentSparkReporter sparkReporter;
    private ExtentReports extent;
    private static final ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    private HSSFWorkbook workbook;
    private HSSFSheet sheet;

    private Map<String, Object[]> testNgResults;
    private static final String DATE_TIME_PATTERN = "MM/dd/yyyy hh:mm:ss";
    // Made dateFormat an instance variable to address thread-safety and SonarQube's "uncovered code" issue
    private final DateFormat dateFormat = new SimpleDateFormat(DATE_TIME_PATTERN); 
    private int retryCount = 0;
    private static final int MAX_RETRY_COUNT = 1;

    // --- Constants for duplicated literals ---
    private static final String USER_DIR = "user.dir";
    private static final String ZEPHYR_STATUS_PASS = "Pass";
    private static final String ZEPHYR_STATUS_FAIL = "Fail";
    private static final String ZEPHYR_STATUS_SKIP = "Skip";
    private static final String TEST_CASE_PASSED_LOG = "<b>TEST CASE:- %s PASSED</b>";
    private static final String TEST_CASE_FAILED_LOG = "<b>TEST CASE:- %s FAILED</b>";
    private static final String TEST_CASE_SKIPPED_LOG = "<b>TEST CASE:- %s SKIPPED</b>";
    private static final String TIME_UNIT_MINUTES_SEPARATOR = " Minutes, ";
    private static final String TIME_UNIT_SECONDS_SUFFIX = " Seconds";
    private static final String SCREENSHOTS_DIR = "screenshots";
    private static final String REPORTS_DIR = "Extent Report";
    private static final String REPORT_EXCEL_NAME = "Excel Report.xls";
    private static final String EXCEL_SHEET_PREFIX = "TestNG Result Summary-";
    private static final String EXCEL_REPORT_GENERATED_MSG = "Excel report generated successfully at .\\reports\\Excel Report.xls";
    private static final String EXCEL_REPORT_WRITE_ERROR_MSG = "Error while writing Excel report: {}";
    private static final String WORKBOOK_CLOSE_ERROR_MSG = "Error closing workbook: {}";
    private static final String EXTENT_REPORT_GENERATED_MSG = "Extent Report generated successfully.";
    private static final String EXTENT_REPORT_GENERATION_ERROR_MSG = "Error while generating the Extent Report: {}";
    private static final String TESTER_INFO = "INOD Testing Team";
    private static final String ORGANIZATION_INFO = "Innodata";
    private static final String TITLE_INFO = "ICHM";
    private static final String FILE_NAME_INFO = "11.1\u200BTransmit Flight and Shipment Information to Down-line Stations & Authorities";
    private static final String ENVIRONMENT_UAT = "UAT Environment";
    private static final String ENVIRONMENT_SANDBOX = "Sandbox Environment";
    private static final String APP_URL_UAT = "https://ia-portal-uat.innodata.com/login";
    private static final String APP_URL_SANDBOX = "https://ia-portal-nv-sandbox.innodata.com/login";
    private static final String DEFAULT_ENVIRONMENT = "Unknown";
    private static final String SCREENSHOT_FAILURE_LABEL = "<b><font color='red'>Screenshot of failure</font></b>";
    private static final String SCREENSHOT_FILE_NOT_FOUND_MSG = "Screenshot file not found: {}";
    private static final String FAILED_SCREENSHOT_ATTACH_ERROR_MSG = "Failed to attach screenshot to report: {}";
    private static final String EXTENT_TEST_NULL_WARN = "ExtentTest is null for test: {}";
    private static final String CONFIG_PROPERTIES = "config.properties";
    private static final String TEST_CYCLE_KEY_PROPERTY = "testCycleKey";
    private static final String DEFAULT_TEST_CYCLE_KEY = "DEFAULT-CYCLE-KEY";


    @Override
    public synchronized void onTestStart(ITestResult result) {
      /**  Method method = result.getMethod().getConstructorOrMethod().getMethod();*/
        ExtentTest currentTest = extent.createTest(result.getMethod().getMethodName());
        extentTest.set(currentTest);

    }

   /** public synchronized boolean retry(ITestResult result) {
        if (retryCount < MAX_RETRY_COUNT) {
            retryCount++;
            return true;
        }
        return false;
    }*/ 
    
    public synchronized boolean retry() {
        if (retryCount < MAX_RETRY_COUNT) {
            retryCount++;
            return true;
        }
        return false;
    }

    public ExtentSparkReporter getSparkReporter() {
        return sparkReporter;
    }

    public void setSparkReporter(ExtentSparkReporter sparkReporter) {
        this.sparkReporter = sparkReporter;
    }

    public ExtentReports getExtent() {
        return extent;
    }

    public void setExtent(ExtentReports extent) {
        this.extent = extent;
    }

    public static ThreadLocal<ExtentTest> getExtentTest() {
        return extentTest;
    }
    @Override
    public synchronized void onStart(ITestContext testContext) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("config");
        String suiteName = testContext.getSuite().getName();
        testContext.getClass().getName();
        System.currentTimeMillis();
        workbook = new HSSFWorkbook();
        String timeStamp = new SimpleDateFormat("dd.MM.yy").format(new Date());
        sheet = workbook.createSheet(EXCEL_SHEET_PREFIX + timeStamp);
        testNgResults = new LinkedHashMap<>();
        String reportName = REPORTS_DIR + ".html";
        String appURL = resourceBundle.getString("appURL");
        String testingEnvironment = DEFAULT_ENVIRONMENT;
        if (APP_URL_UAT.equals(appURL)) {
            testingEnvironment = ENVIRONMENT_UAT;
        } else if (APP_URL_SANDBOX.equals(appURL)) {
            testingEnvironment = ENVIRONMENT_SANDBOX;
        }
        sparkReporter = new ExtentSparkReporter(System.getProperty(USER_DIR) + "\\reports\\"+ reportName);
        sparkReporter.config().setDocumentTitle(suiteName);
        sparkReporter.config().setReportName(suiteName + " Report");
        sparkReporter.config().setTheme(Theme.STANDARD);
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Tester", TESTER_INFO);
        extent.setSystemInfo("Organization", ORGANIZATION_INFO);
        extent.setSystemInfo("Testing Environment", testingEnvironment);
        extent.setSystemInfo("Title", TITLE_INFO);
        extent.setSystemInfo("File Name", FILE_NAME_INFO);
    }

    @Override
    public synchronized void onTestSuccess(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        String logText = String.format(TEST_CASE_PASSED_LOG, methodName.toUpperCase());
        Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
        if (extentTest.get() != null) {
            extentTest.get().pass(m);
        }
        String group = String.join(" ", result.getMethod().getGroups());
        long executionTime = result.getEndMillis() - result.getStartMillis();
        long minutes = (executionTime / 1000) / 60;
        long seconds = (executionTime / 1000) % 60;
        testNgResults.put(methodName, new Object[]{
            methodName, group, ZEPHYR_STATUS_PASS, dateFormat.format(new Date(result.getStartMillis())),
            dateFormat.format(new Date(result.getEndMillis())),
            minutes + TIME_UNIT_MINUTES_SEPARATOR + seconds + TIME_UNIT_SECONDS_SUFFIX
        });
    }


    @SuppressWarnings("unused")
	private String getZephyrTestCycleKey() {
        Properties prop = new Properties();
        try (FileInputStream input = new FileInputStream(CONFIG_PROPERTIES)) {
            prop.load(input);
            return prop.getProperty(TEST_CYCLE_KEY_PROPERTY, DEFAULT_TEST_CYCLE_KEY);
        } catch (IOException e) {
            logger.error("Failed to load {}: {}", CONFIG_PROPERTIES, e.getMessage(), e);
            return DEFAULT_TEST_CYCLE_KEY;
        }
    }

    @Override
    public synchronized void onTestFailure(ITestResult result) {
        String methodName = result.getMethod().getMethodName();

        if (extentTest.get() == null) {
            logger.info(EXTENT_TEST_NULL_WARN, result.getName());
            return;
        }
        String logText = String.format(TEST_CASE_FAILED_LOG, methodName.toUpperCase());
        Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
        extentTest.get().fail(m);

        if (result.getThrowable() != null) {
            extentTest.get().fail(result.getThrowable());
        }
        String[] groups = result.getMethod().getGroups();
        String group = String.join(" ", groups);
        long executionTime = result.getEndMillis() - result.getStartMillis();
        long minutes = (executionTime / 1000) / 60;
        long seconds = (executionTime / 1000) % 60;
        testNgResults.put(methodName, new Object[]{
            methodName, group, ZEPHYR_STATUS_FAIL, dateFormat.format(new Date(result.getStartMillis())),
            dateFormat.format(new Date(result.getEndMillis())),
            minutes + TIME_UNIT_MINUTES_SEPARATOR + seconds + TIME_UNIT_SECONDS_SUFFIX
        });
        try {
            String screenshotPath = captureScreen(result.getName());
            String base64Screenshot = convertImageToBase64(screenshotPath);
            extentTest.get().fail(SCREENSHOT_FAILURE_LABEL, MediaEntityBuilder
                    .createScreenCaptureFromBase64String("data:image/png;base64," + base64Screenshot).build());
        } catch (IOException e1) {
            logger.error(FAILED_SCREENSHOT_ATTACH_ERROR_MSG, e1.getMessage(), e1);
        }
    }

    @Override
    public synchronized void onTestSkipped(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        if (extentTest.get() == null) {
            logger.info(EXTENT_TEST_NULL_WARN, result.getName());
            return;
        }
        String logText = String.format(TEST_CASE_SKIPPED_LOG, methodName.toUpperCase());
        Markup m = MarkupHelper.createLabel(logText, ExtentColor.ORANGE);
        extentTest.get().skip(m);
        String group = String.join(" ", result.getMethod().getGroups());
        long executionTime = result.getEndMillis() - result.getStartMillis();
        long minutes = (executionTime / 1000) / 60;
        long seconds = (executionTime / 1000) % 60;
        testNgResults.put(methodName, new Object[]{
            methodName, group, ZEPHYR_STATUS_SKIP, dateFormat.format(new Date(result.getStartMillis())),
            dateFormat.format(new Date(result.getEndMillis())),
            minutes + TIME_UNIT_MINUTES_SEPARATOR + seconds + TIME_UNIT_SECONDS_SUFFIX
        });
    }

    /**
     * Creates the header row for the Excel sheet.
     * @param sheet The HSSFSheet to create the header in.
     */
    private void createExcelHeader(HSSFSheet sheet) {
        Row headerRow = sheet.createRow(0);
        CellStyle headerCellStyle = sheet.getWorkbook().createCellStyle();
        HSSFFont font = sheet.getWorkbook().createFont();
        font.setColor(IndexedColors.WHITE.getIndex());
        headerCellStyle.setFont(font);
        headerCellStyle.setFillForegroundColor(IndexedColors.DARK_BLUE.getIndex());
        headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        String[] headers = {"Testcase Name", "Sprint Name", "Final Status", "Start Time", "End Time", "Total Execution Time"};
        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
            cell.setCellStyle(headerCellStyle);
        }
    }

    /**
     * Sets the value of a cell based on the object type.
     * This helper method reduces the cognitive complexity of writeExcelResults.
     * @param cell The Excel cell to set the value for.
     * @param obj The object whose value is to be set.
     */
    private void setCellValue(Cell cell, Object obj) {
        if (obj instanceof Date date) {
            cell.setCellValue(date);
        } else if (obj instanceof Boolean bool) {
            cell.setCellValue(bool);
        } else if (obj instanceof String str) {
            cell.setCellValue(str);
        } else if (obj instanceof Double dbl) {
            cell.setCellValue(dbl);
        } else if (obj instanceof Long lng) {
            cell.setCellValue(lng);
        } else if (obj instanceof Integer integer) {
            cell.setCellValue(integer);
        } else {
            cell.setCellValue(obj != null ? obj.toString() : "");
        }
    }

    /**
     * Writes test results to the Excel sheet.
     * @param rownum The starting row number for writing data.
     */
    private void writeExcelResults(int rownum) {
        for (Map.Entry<String, Object[]> entry : testNgResults.entrySet()) {
            Row row = sheet.createRow(rownum++);
            int cellnum = 0;
            Object[] objArr = entry.getValue();
            for (Object obj : objArr) {
                Cell cell = row.createCell(cellnum++);
                setCellValue(cell, obj);
            }
        }
    }

    /**
     * Auto-sizes columns in the Excel sheet based on content.
     */
    private void autoSizeExcelColumns() {
        if (sheet.getRow(0) != null) {
            for (int i = 0; i < sheet.getRow(0).getLastCellNum(); i++) {
                sheet.autoSizeColumn(i);
            }
        }
    }

    /**
     * Handles the saving and closing of the Excel workbook.
     * @throws IOException If an I/O error occurs during workbook operations.
     */
    private void saveAndCloseExcelWorkbook() throws IOException {
        try (FileOutputStream out = new FileOutputStream(System.getProperty(USER_DIR) + "\\reports\\" + REPORT_EXCEL_NAME)) {
            workbook.write(out);
            logger.info(EXCEL_REPORT_GENERATED_MSG);
        } catch (IOException e) {
            logger.error(EXCEL_REPORT_WRITE_ERROR_MSG, e.getMessage(), e);
            throw e;
        } finally {
            try {
                if (workbook != null) {
                    workbook.close();
                }
            } catch (IOException e) {
                logger.error(WORKBOOK_CLOSE_ERROR_MSG, e.getMessage(), e);
            }
        }
    }

    /**
     * Flushes the ExtentReports instance.
     */
    private void flushExtentReports() {
        try {
            extent.flush();
            logger.info(EXTENT_REPORT_GENERATED_MSG);
        } catch (Exception e) {
            logger.error(EXTENT_REPORT_GENERATION_ERROR_MSG, e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public synchronized void onFinish(ITestContext context) {
        createExcelHeader(sheet);
        writeExcelResults(1);
        autoSizeExcelColumns();
        try {
            saveAndCloseExcelWorkbook();
        } catch (IOException e) {
            logger.error("Failed to save and close Excel workbook: {}", e.getMessage(), e);
        }
        flushExtentReports();
    }

    @Override
    public synchronized void onFinish(ISuite suite) {
        // This method is part of the ISuiteListener interface.
        // It is intentionally left empty as suite-level reporting specific to this listener
        // might not be required, or is handled by other components or listeners.
        // No action is performed here.
    }

    public String captureScreen(String tname) throws IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
        Date dt = new Date();
        String timeStamp = sdf.format(dt);

        String screenshotsDirectory = System.getProperty(USER_DIR) + File.separator + SCREENSHOTS_DIR;
        File screenshotsFolder = new File(screenshotsDirectory);
        if (!screenshotsFolder.exists()) {
            screenshotsFolder.mkdirs();
        }

        File screenshot = ((TakesScreenshot) BaseClass.getDriver()).getScreenshotAs(OutputType.FILE);
        String destination = screenshotsDirectory + File.separator + tname + "_" + timeStamp + ".png";

        try {
            FileHandler.copy(screenshot, new File(destination));
        } catch (IOException e) {
            logger.error("Failed to copy screenshot file to destination '{}': {}", destination, e.getMessage(), e);
        }

        return destination;
    }

    public String convertImageToBase64(String imagePath) throws IOException {
        File screenshotFile = new File(imagePath);
        if (!screenshotFile.exists()) {
            logger.error(SCREENSHOT_FILE_NOT_FOUND_MSG, imagePath);
            return "";
        }
        try (InputStream in = new FileInputStream(screenshotFile)) {
            byte[] imageBytes = IOUtils.toByteArray(in);
            return Base64.getEncoder().encodeToString(imageBytes);
        }
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        logger.debug("TearDown executed for: {}", result.getMethod().getMethodName());
        extentTest.remove();
    }
}
