package a_testbase;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ResourceBundle;
import java.util.concurrent.Semaphore;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ThreadGuard;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import java.nio.file.Files;
import java.nio.file.Path;

public class BaseClass {

    private static final ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();
    public static final Logger logger = LogManager.getLogger(BaseClass.class);
    private static ResourceBundle rb;
    private static final Semaphore SEMAPHORE = new Semaphore(4); // Limit parallel threads, renamed to conventional constant name

    private static final String EXCLUDE_SWITCHES_KEY = "excludeSwitches";
    private static final String ENABLE_AUTOMATION_SWITCH = "enable-automation";
    private static final String HEADLESS_ARGUMENT = "--headless=new"; // For Chrome
    private static final String BROWSER_CHROME = "chrome";
    private static final String BROWSER_EDGE = "edge";
    private static final String BROWSER_FIREFOX = "firefox";
    private static final String HEADLESS_FIREFOX_ARGUMENT = "-headless";
    private static final String CONFIG_BUNDLE_NAME = "config"; // Constant for resource bundle name
    private static final String APP_URL_KEY = "appURL"; // Constant for app URL key
    private static final String HEADLESS_KEY = "isHeadless";
    private static final String REPORTS_DIR_PATH = ".\\reports\\"; // Constant for reports directory
    private static final String SCREENSHOTS_DIR_PATH = ".\\screenshots\\"; // Constant for screenshots directory
    private static final String REPORT_HTML_PREFIX = "Test-ExtentReport-"; // Constant for HTML report prefix
    private static final String REPORT_HTML_SUFFIX = ".html"; // Constant for HTML report suffix
    private static final String REPORT_EXCEL_PREFIX = "ExcelReport"; // Constant for Excel report prefix
    private static final String REPORT_EXCEL_SUFFIX = ".xls"; // Constant for Excel report suffix
    private static final String PNG_SUFFIX = ".png"; // Constant for PNG file suffix

    public static ResourceBundle getResourceBundle() {
        return rb;
    }

    public static WebDriver getDriver() {
        return threadLocalDriver.get();
    }

    @BeforeClass(alwaysRun = true)
    public static void initialize() {
        if (rb == null) {
            rb = ResourceBundle.getBundle(CONFIG_BUNDLE_NAME);
        }
    }

    @BeforeMethod(alwaysRun = true)
    public void logThreadDetails() {
        logger.info("Thread Name: {}", Thread.currentThread().getName());
        /**logger.info("Thread ID: {}", Thread.currentThread().getId());*/
    }

    @BeforeMethod(alwaysRun = true)
    public void setup(@Optional(BROWSER_CHROME) String browser) {
        try {
            SEMAPHORE.acquire();

            if (rb == null) {
                initialize();
            }

            boolean isHeadless = Boolean.parseBoolean(
                    rb.getString(HEADLESS_KEY)
            );

            WebDriver driver = createDriverInstance(browser, isHeadless);
            threadLocalDriver.set(ThreadGuard.protect(driver));

            deleteCookiesSafely(driver);

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            driver.manage().window().maximize();
            
            navigateToAppUrl(driver);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            logger.error("Setup interrupted: {}", e.getMessage(), e);
        } catch (SessionNotCreatedException e) {
            logger.error("Session not created: {}", e.getMessage(), e);
            SEMAPHORE.release();
            throw e;
        } catch (Exception e) {
            logger.error("Unexpected error during setup: {}", e.getMessage(), e);
            SEMAPHORE.release();
            throw e;
        }
    }

    private void deleteCookiesSafely(WebDriver driver) {
        try {
            driver.manage().deleteAllCookies();
        } catch (WebDriverException e) {
            logger.warn("Error while deleting cookies: {}", e.getMessage());
        }
    }

    private static void navigateToAppUrl(WebDriver driver) {
        try {
            driver.navigate().to(rb.getString(APP_URL_KEY));
        } catch (WebDriverException e) {
            logger.error("Navigation to app URL failed: {}", e.getMessage(), e);
            throw new ApplicationNavigationException("Failed to navigate to application URL", e);
        }
    }
    
    private WebDriver createDriverInstance(String browser, boolean isHeadless) {
        WebDriver driver;
        switch (browser.toLowerCase()) {
        case BROWSER_CHROME:
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setExperimentalOption(
                    EXCLUDE_SWITCHES_KEY,
                    new String[]{ENABLE_AUTOMATION_SWITCH}
            );

            if (isHeadless) {
                chromeOptions.addArguments("--headless=new");
                chromeOptions.addArguments("--no-sandbox");
                chromeOptions.addArguments("--disable-dev-shm-usage");
            }

            driver = new ChromeDriver(chromeOptions);
            break;

        case BROWSER_EDGE:
            EdgeOptions edgeOptions = new EdgeOptions();
            edgeOptions.setExperimentalOption(EXCLUDE_SWITCHES_KEY, new String[]{ENABLE_AUTOMATION_SWITCH});
            driver = new EdgeDriver(edgeOptions);
            break;

        case BROWSER_FIREFOX:
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            if (isHeadless) firefoxOptions.addArguments(HEADLESS_FIREFOX_ARGUMENT);
            driver = new FirefoxDriver(firefoxOptions);
            break;

        default:
            logger.warn("Unsupported browser name: {}. Defaulting to Chrome.", browser);
            ChromeOptions defaultOptions = new ChromeOptions();
            defaultOptions.setExperimentalOption(EXCLUDE_SWITCHES_KEY, new String[]{ENABLE_AUTOMATION_SWITCH});
            if (isHeadless) {
                defaultOptions.addArguments(HEADLESS_ARGUMENT);
                defaultOptions.addArguments("--no-sandbox");
                defaultOptions.addArguments("--disable-dev-shm-usage");
            }
            driver = new ChromeDriver(defaultOptions);
            break;
        }
        return driver;
    }

    @BeforeSuite(alwaysRun = true)
    public synchronized void initializeSuite() {
        deleteOldReports(REPORTS_DIR_PATH, REPORT_HTML_PREFIX, REPORT_HTML_SUFFIX);
        deleteOldReports(REPORTS_DIR_PATH, REPORT_EXCEL_PREFIX, REPORT_EXCEL_SUFFIX);
        deleteOldScreenshots(SCREENSHOTS_DIR_PATH);
    }

    private void deleteOldReports(String directoryPath, String prefix, String suffix) {
        File dir = new File(directoryPath);
        if (!dir.exists() || !dir.isDirectory()) {
            logger.debug("Directory does not exist or is not a directory: {}", directoryPath);
            return;
        }

        File[] oldReports = dir.listFiles((d, name) -> name.startsWith(prefix) && name.endsWith(suffix));
        
        if (oldReports != null) {
            for (File report : oldReports) {
                try {
                    Files.delete(report.toPath());
                    logger.info("Deleted report: {}", report.getName());
                } catch (IOException e) {
                    logger.error("Failed to delete report: {} due to: {}", report.getName(), e.getMessage(), e);
                }
            }
        }
    }

    private void deleteOldScreenshots(String directoryPath) {
        File dir = new File(directoryPath);
        if (!dir.exists() || !dir.isDirectory()) {
            logger.debug("Directory does not exist or is not a directory: {}", directoryPath);
            return;
        }

        File[] screenshots = dir.listFiles((d, name) -> name.endsWith(PNG_SUFFIX));
        
        if (screenshots != null) {
            for (File screenshot : screenshots) {
                try {
                    Path path = screenshot.toPath();
                    Files.delete(path);
                    logger.info("Deleted screenshot: {}", screenshot.getName());
                } catch (IOException e) {
                    logger.error("Failed to delete screenshot: {} - {}", screenshot.getName(), e.getMessage(), e);
                }
            }
        }
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
        WebDriver driver = threadLocalDriver.get();
        if (driver != null) {
            try {
                driver.quit();
                logger.info("Browser closed for test: {}", result.getName());
            } catch (Exception e) {
                logger.error("Exception while quitting WebDriver for test {}: {}", result.getName(), e.getMessage(), e);
            } finally {
                SEMAPHORE.release();
                threadLocalDriver.remove();
            }
        } else {
            SEMAPHORE.release();
            threadLocalDriver.remove();
        }
    }
}