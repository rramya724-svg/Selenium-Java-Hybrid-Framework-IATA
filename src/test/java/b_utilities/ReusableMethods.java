package b_utilities;

import java.time.Duration;
import java.util.ResourceBundle;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import a_testbase.BaseClass;
import d_loginpage.HomePage;

public class ReusableMethods extends BaseClass {
	
	private static ResourceBundle rb;
	private static final String CONFIG_BUNDLE_NAME = "config";
	private static final String USERNAME_PROPERTY = "username";
	private static final String PASSWORD_PROPERTY = "password";
	private static final String FILE_NAME_TRANSMIT_FLIGHT = "Transmit Flight and Shipment";
	private static final String FILE_NAME_AUTOMATION_TESTING = "AUTOMATION_TESTING";
	private static final String LOG_WARN_ERROR_OCCURRED = "An error occurred: {}";

	// --- New Constants for duplicated literals ---
	private static final String PLEASE_WAIT_DISAPPEARED_LOG = "'Please Wait' has disappeared. Proceeding.";
	private static final String PLEASE_WAIT_NOT_FOUND_WARN = "No 'Please Wait' element found or already disappeared.";
	private static final String THREAD_NAME_RETRY_PREFIX = "RetryMultipleFailedTestcases-";
	private static final String THREAD_NAME_RETRY_1 = THREAD_NAME_RETRY_PREFIX + "1";
	private static final String THREAD_NAME_RETRY_2 = THREAD_NAME_RETRY_PREFIX + "2";
	private static final String THREAD_NAME_RETRY_3 = THREAD_NAME_RETRY_PREFIX + "3";
	private static final String THREAD_NAME_RETRY_4 = THREAD_NAME_RETRY_PREFIX + "4";

	private static final Duration PAGE_LOAD_TIMEOUT = Duration.ofSeconds(600);
	private static final Duration WAIT_30_SECONDS = Duration.ofSeconds(30);
	private static final int FRAME_INDEX_1 = 1; // For insertTableCB


	public static void file1() {
		HomePage lp = new HomePage(getDriver());
		ResourceBundle rb = ResourceBundle.getBundle(CONFIG_BUNDLE_NAME);
		lp.inputUsername(rb.getString(USERNAME_PROPERTY));
		performEnterKeyAction();
		lp.inputPassword(rb.getString(PASSWORD_PROPERTY));
		lp.clickLoginButton();
		getDriver().manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT);
		lp.clickSelectProject();
		lp.clickProject();
		lp.clickFileList();
		lp.inputFileName(FILE_NAME_TRANSMIT_FLIGHT);
		performEnterKeyAction();
		lp.waitForLoaderToDisappear();
		lp.jseEditFileButtonXPath1();
		Set<String> allWindowHandles = getDriver().getWindowHandles();
		String lastWindowHandle = allWindowHandles.toArray()[allWindowHandles.size() - 1].toString();
		getDriver().switchTo().window(lastWindowHandle);
		lp.jseResetBtn();
		lp.jseConfirmBtn();
		handlePleaseWaitLoader(lp); // Extracted method
		waitForDsVisibility(lp); // Extracted method
	}

	private static void performEnterKeyAction() {
		try {
			Actions act = new Actions(getDriver());
			act.sendKeys(Keys.ENTER).build().perform();
		} catch (Exception e) {
			logger.error("Error performing ENTER key after file name input: {}", e.getMessage(), e);
		}
	}

	public static void file2() {
		HomePage lp = new HomePage(getDriver());
		rb = ResourceBundle.getBundle(CONFIG_BUNDLE_NAME);
		lp.inputUsername(rb.getString(USERNAME_PROPERTY));
		Actions act = new Actions(getDriver());
		act.sendKeys(Keys.ENTER).build().perform();
		lp.inputPassword(rb.getString(PASSWORD_PROPERTY));
		lp.clickLoginButton();
		getDriver().manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT);
		lp.clickSelectProject();
		lp.clickProject();
		lp.clickFileList();
		lp.inputFileName(FILE_NAME_TRANSMIT_FLIGHT);
		act.sendKeys(Keys.ENTER).build().perform();
		 lp.waitForLoaderToDisappear();
		lp.jseEditFileButtonXPath2();
		Set<String> allWindowHandles = getDriver().getWindowHandles();
		String lastWindowHandle = allWindowHandles.toArray()[allWindowHandles.size() - 1].toString();
		getDriver().switchTo().window(lastWindowHandle);
		lp.jseResetBtn();
		lp.jseConfirmBtn();
		handlePleaseWaitLoader(lp); // Extracted method
		waitForDsVisibility(lp); // Extracted method
	}

	public static void file3() {
		HomePage lp = new HomePage(getDriver());
		rb = ResourceBundle.getBundle(CONFIG_BUNDLE_NAME);
		lp.inputUsername(rb.getString(USERNAME_PROPERTY));
		Actions act = new Actions(getDriver());
		act.sendKeys(Keys.ENTER).build().perform();
		lp.inputPassword(rb.getString(PASSWORD_PROPERTY));
		lp.clickLoginButton();
		getDriver().manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT);
		lp.clickSelectProject();
		lp.clickProject();
		lp.clickFileList();
		lp.inputFileName(FILE_NAME_TRANSMIT_FLIGHT);
		act.sendKeys(Keys.ENTER).build().perform();
		 lp.waitForLoaderToDisappear();
		lp.jseEditFileButtonXPath3();
		Set<String> allWindowHandles = getDriver().getWindowHandles();
		String lastWindowHandle = allWindowHandles.toArray()[allWindowHandles.size() - 1].toString();
		getDriver().switchTo().window(lastWindowHandle);
		lp.jseResetBtn();
		lp.jseConfirmBtn();
		handlePleaseWaitLoader(lp); // Extracted method
		waitForDsVisibility(lp); // Extracted method
	}

	public static void file4() {
		HomePage lp = new HomePage(getDriver());
		rb = ResourceBundle.getBundle(CONFIG_BUNDLE_NAME);
		lp.inputUsername(rb.getString(USERNAME_PROPERTY));
		Actions act = new Actions(getDriver());
		act.sendKeys(Keys.ENTER).build().perform();
		lp.inputPassword(rb.getString(PASSWORD_PROPERTY));
		lp.clickLoginButton();
		getDriver().manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT);
		lp.clickSelectProject();
		lp.clickProject();
		lp.clickFileList();
		lp.inputFileName(FILE_NAME_TRANSMIT_FLIGHT);
		act.sendKeys(Keys.ENTER).build().perform();
		 lp.waitForLoaderToDisappear();
		lp.jseEditFileButtonXPath4();
		Set<String> allWindowHandles = getDriver().getWindowHandles();
		String lastWindowHandle = allWindowHandles.toArray()[allWindowHandles.size() - 1].toString();
		getDriver().switchTo().window(lastWindowHandle);
		lp.jseResetBtn();
		lp.jseConfirmBtn();
		handlePleaseWaitLoader(lp); // Extracted method
		waitForDsVisibility(lp); // Extracted method
	}

	public static void file5() {
		HomePage lp = new HomePage(getDriver());
		rb = ResourceBundle.getBundle(CONFIG_BUNDLE_NAME);
		lp.inputUsername(rb.getString(USERNAME_PROPERTY));
		Actions act = new Actions(getDriver());
		act.sendKeys(Keys.ENTER).build().perform();
		lp.inputPassword(rb.getString(PASSWORD_PROPERTY));
		lp.clickLoginButton();
		getDriver().manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT);
		lp.clickSelectProject();
		lp.clickProject();
		lp.clickFileList();
		lp.inputTitleCode(FILE_NAME_AUTOMATION_TESTING);
		lp.inputFileName("27.1 - General");
		act.sendKeys(Keys.ENTER).build().perform();		
		 lp.waitForLoaderToDisappear();
		lp.jseEditFileButtonXPath5();
		Set<String> allWindowHandles = getDriver().getWindowHandles();
		String lastWindowHandle = allWindowHandles.toArray()[allWindowHandles.size() - 1].toString();
		getDriver().switchTo().window(lastWindowHandle);
		lp.jseResetBtn();
		lp.jseConfirmBtn();	 
		waitForDsVisibility(lp); // Re-used extracted method
	}

	/**
	 * Handles the "Please Wait" loader/spinner.
	 * Waits for the element to disappear if it's displayed.
	 *
	 * @param lp The HomePage object containing the "Please Wait" WebElement.
	 */
	private static void handlePleaseWaitLoader(HomePage lp) {
	    try {
	        WebElement pleaseWaitLocator = lp.getPleaseWait();
	        if (pleaseWaitLocator.isDisplayed()) {
	            WebDriverWait wait = new WebDriverWait(getDriver(), WAIT_30_SECONDS);
	            wait.until(ExpectedConditions.invisibilityOf(pleaseWaitLocator));
	            logger.info(PLEASE_WAIT_DISAPPEARED_LOG); // Using constant
	        }
	    } catch (Exception e) {
	        logger.warn(PLEASE_WAIT_NOT_FOUND_WARN); // Using constant
	    }
	}

	/**
	 * Waits for the Dynamic Section (DS) to become visible.
	 * Refreshes the page and retries if the element is not visible within the timeout.
	 *
	 * @param lp The HomePage object containing the DS WebElement.
	 */
	private static void waitForDsVisibility(HomePage lp) {
	    WebDriverWait wait1 = new WebDriverWait(getDriver(), WAIT_30_SECONDS);
	    while (true) {
	        try {
	            WebElement dsVisible = lp.dsVisible();
	            wait1.until(ExpectedConditions.visibilityOf(dsVisible));
	            break;
	        } catch (Exception e) {
	            getDriver().navigate().refresh();
	        }
	    }
	}

	public static void loginAndSearchFileClickEdit() {
		try {
			String threadName = Thread.currentThread().getName();
			if (threadName.contains(THREAD_NAME_RETRY_1)) {
				file1();
			} else if (threadName.contains(THREAD_NAME_RETRY_2)) {
				file2();
			} else if (threadName.contains(THREAD_NAME_RETRY_3)) {
				file3();
			} else if (threadName.contains(THREAD_NAME_RETRY_4)) {
				file4();
			} else {
				file1(); // Default case
			}
		} catch (Exception e) {
			logger.warn(LOG_WARN_ERROR_OCCURRED, e.getMessage(), e);
		}
	}

	public static void loginAndSearchFileAutoseq() {
		try {
	        String threadName = Thread.currentThread().getName();
	        if (threadName.contains(THREAD_NAME_RETRY_1)) { // This was THREAD_NAME_RETRY_1 earlier, now consistent with new constants.
	            logger.debug("Thread matched {}, executing file5()", THREAD_NAME_RETRY_1);
	            file5();
	        } else {
	            logger.debug("Thread did not match, executing file5() by default");
	            file5();
	        }
	    } catch (Exception e) {
	        logger.warn(LOG_WARN_ERROR_OCCURRED, e.getMessage(), e);
	    }
	}

	public static synchronized void insertTableCB() {
		HomePage lp = new HomePage(getDriver());
		lp.clickDSSection();
		lp.clickfirstpara();
		 
		lp.clickInsertTableIcon();
		int column = 0;
		int row = 0;
		getDriver().switchTo().frame(FRAME_INDEX_1); // Using constant
		for (int i = 1; i <= 3; i++) {
			row = i;
			for (int j = 1; j <= 3; j++) {
				column = j;
				WebElement tableColumn = lp.gettableBoxElement();
				Actions a = new Actions(getDriver());
				a.moveToElement(tableColumn).perform();
			}
		}
		WebElement tableColumnToClick = getDriver()
				.findElement(By.xpath("//div[@title='Table']//table//tr[" + row + "]/td[" + column + "]"));
		tableColumnToClick.click();
		getDriver().switchTo().defaultContent();
	}

	public static synchronized  void loginAndSearchFileClickEditOnNewFile() {
		HomePage lp = new HomePage(getDriver());
		rb = ResourceBundle.getBundle(CONFIG_BUNDLE_NAME);
		lp.inputUsername(rb.getString(USERNAME_PROPERTY));
		lp.inputPassword(rb.getString(PASSWORD_PROPERTY));
		lp.clickLoginButton();
		getDriver().manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT);
		lp.clickSelectProject();
		lp.clickProject();
		lp.clickFileList();
		lp.inputFileName(FILE_NAME_TRANSMIT_FLIGHT);
		Actions act = new Actions(getDriver());
		act.sendKeys(Keys.ENTER).build().perform();
		 lp.waitForLoaderToDisappear();
		lp.jseEditFileButtonXPath1();
		Set<String> allWindowHandles = getDriver().getWindowHandles();
		String lastWindowHandle = allWindowHandles.toArray()[allWindowHandles.size() - 1].toString();
		getDriver().switchTo().window(lastWindowHandle);
		lp.jseResetBtn();
		lp.jseConfirmBtn();
		 
		waitForDsVisibility(lp); // Re-used extracted method
	}

	public static synchronized  void loginAndSearchFileClickEditOnExistingNewFile() {
		HomePage lp = new HomePage(getDriver());
		rb = ResourceBundle.getBundle(CONFIG_BUNDLE_NAME);
		lp.inputUsername(rb.getString(USERNAME_PROPERTY));
		Actions act = new Actions(getDriver());
		act.sendKeys(Keys.ENTER).build().perform();
		lp.inputPassword(rb.getString(PASSWORD_PROPERTY));
		lp.clickLoginButton();
		getDriver().manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT);
		lp.clickSelectProject();
		lp.clickProject();
		lp.clickFileList();
		lp.inputFileName(FILE_NAME_TRANSMIT_FLIGHT);
		act.sendKeys(Keys.ENTER).build().perform();
		 lp.waitForLoaderToDisappear();
		lp.jseEditFileButtonXPathNewFile();
		Set<String> allWindowHandles = getDriver().getWindowHandles();
		String lastWindowHandle = allWindowHandles.toArray()[allWindowHandles.size() - 1].toString();
		getDriver().switchTo().window(lastWindowHandle);
		lp.jseResetBtn();
		lp.jseConfirmBtn();
		 
		waitForDsVisibility(lp); // Re-used extracted method
	}

//	public static synchronized  void loginAndSearchFileClickViewProject() {
//		HomePage lp = new HomePage(getDriver());
//		rb = ResourceBundle.getBundle(CONFIG_BUNDLE_NAME);
//		lp.inputUsername(rb.getString(USERNAME_PROPERTY));
//		Actions act = new Actions(getDriver());
//		act.sendKeys(Keys.ENTER).build().perform();
//		lp.inputPassword(rb.getString(PASSWORD_PROPERTY));
//		lp.clickLoginButton();
//		getDriver().manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT);
//		lp.clickSelectProject();
//		lp.clickProject();
//		SectionReseqPageObjects sr = new SectionReseqPageObjects(getDriver());
//		sr.clickCurrentProject();
//		sr.clickAuthoringAssignments();
//		sr.clickAuthoring();
//		sr.clickFilterNewTitle();
//		sr.clickFilterNewTitle();
//		act.sendKeys(FILE_NAME_AUTOMATION_TESTING).build().perform();
//		act.sendKeys(Keys.ENTER).build().perform();
//		act .pause(Duration.ofSeconds(2)).perform();
//		sr.clickViewProject();
//	}

//	public static synchronized void loginAndSearchFileClickViewProjectIATA() {
//		HomePage lp = new HomePage(getDriver());
//		rb = ResourceBundle.getBundle(CONFIG_BUNDLE_NAME);
//		lp.inputUsername(rb.getString(USERNAME_PROPERTY));
//		Actions act = new Actions(getDriver());
//		act.sendKeys(Keys.ENTER).build().perform();
//		lp.inputPassword(rb.getString(PASSWORD_PROPERTY));
//		lp.clickLoginButton();
//		getDriver().manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT);
//		lp.clickSelectProject();
//		lp.clickProject();
//		SectionReseqPageObjects sr = new SectionReseqPageObjects(getDriver());
//		sr.clickCurrentProject();
//		sr.clickAuthoringAssignments();
//		sr.clickAuthoring();
//		sr.clickFilterNewTitle();
//		act.sendKeys("IATAPOC").build().perform();		
//		act.sendKeys(Keys.ENTER).build().perform();
//		act .pause(Duration.ofSeconds(2)).perform();
//		sr.clickViewProject();
//	}

	public static void textVaiableFile1() {

		HomePage lp = new HomePage(getDriver());
		rb = ResourceBundle.getBundle(CONFIG_BUNDLE_NAME);
		lp.inputUsername(rb.getString(USERNAME_PROPERTY));
		Actions act = new Actions(getDriver());
		act.sendKeys(Keys.ENTER).build().perform();
		lp.inputPassword(rb.getString(PASSWORD_PROPERTY));
		lp.clickLoginButton();
		getDriver().manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT);
		lp.clickSelectProject();
		lp.clickProject();
		lp.clickFileList();
		lp.inputFileName(FILE_NAME_TRANSMIT_FLIGHT);
		act.sendKeys(Keys.ENTER).build().perform();	 
		lp.jseEditTextVariableFileXPath1();
		Set<String> allWindowHandles = getDriver().getWindowHandles();
		String lastWindowHandle = allWindowHandles.toArray()[allWindowHandles.size() - 1].toString();
		getDriver().switchTo().window(lastWindowHandle);
		lp.jseResetBtn();
		lp.jseConfirmBtn();		
		handlePleaseWaitLoader(lp); // Extracted method
		waitForDsVisibility(lp); // Re-used extracted method
	}

	public static void textVaiableFile2() {
		HomePage lp = new HomePage(getDriver());
		rb = ResourceBundle.getBundle(CONFIG_BUNDLE_NAME);
		lp.inputUsername(rb.getString(USERNAME_PROPERTY));
		Actions act = new Actions(getDriver());
		act.sendKeys(Keys.ENTER).build().perform();
		lp.inputPassword(rb.getString(PASSWORD_PROPERTY));
		lp.clickLoginButton();
		getDriver().manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT);
		lp.clickSelectProject();
		lp.clickProject();
		lp.clickFileList();
		lp.inputFileName(FILE_NAME_TRANSMIT_FLIGHT);
		act.sendKeys(Keys.ENTER).build().perform();	
		 lp.waitForLoaderToDisappear();
		lp.jseEditTextVariableFileXPath2();
		Set<String> allWindowHandles = getDriver().getWindowHandles();
		String lastWindowHandle = allWindowHandles.toArray()[allWindowHandles.size() - 1].toString();
		getDriver().switchTo().window(lastWindowHandle);
		lp.jseResetBtn();
		lp.jseConfirmBtn();
		handlePleaseWaitLoader(lp); // Extracted method
		waitForDsVisibility(lp); // Re-used extracted method
	}
	public static void textVaiableFile3() {
		HomePage lp = new HomePage(getDriver());
		rb = ResourceBundle.getBundle(CONFIG_BUNDLE_NAME);
		lp.inputUsername(rb.getString(USERNAME_PROPERTY));
		Actions act = new Actions(getDriver());
		act.sendKeys(Keys.ENTER).build().perform();
		lp.inputPassword(rb.getString(PASSWORD_PROPERTY));
		lp.clickLoginButton();
		getDriver().manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT);
		lp.clickSelectProject();
		lp.clickProject();
		lp.clickFileList();
		lp.inputFileName(FILE_NAME_TRANSMIT_FLIGHT);
		act.sendKeys(Keys.ENTER).build().perform();		
		 lp.waitForLoaderToDisappear();
		lp.jseEditTextVariableFileXPath3();
		Set<String> allWindowHandles = getDriver().getWindowHandles();
		String lastWindowHandle = allWindowHandles.toArray()[allWindowHandles.size() - 1].toString();
		getDriver().switchTo().window(lastWindowHandle);
		lp.jseResetBtn();
		lp.jseConfirmBtn();
		handlePleaseWaitLoader(lp); // Extracted method
		waitForDsVisibility(lp); // Re-used extracted method
	}
	public static void textVaiableFile4() {
		HomePage lp = new HomePage(getDriver());
		rb = ResourceBundle.getBundle(CONFIG_BUNDLE_NAME);
		lp.inputUsername(rb.getString(USERNAME_PROPERTY));
		Actions act = new Actions(getDriver());
		act.sendKeys(Keys.ENTER).build().perform();
		lp.inputPassword(rb.getString(PASSWORD_PROPERTY));
		lp.clickLoginButton();
		getDriver().manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT);
		lp.clickSelectProject();
		lp.clickProject();
		lp.clickFileList();
		lp.inputFileName(FILE_NAME_TRANSMIT_FLIGHT);
		act.sendKeys(Keys.ENTER).build().perform();	
		 lp.waitForLoaderToDisappear();
		lp.jseEditTextVariableFileXPath4();
		Set<String> allWindowHandles = getDriver().getWindowHandles();
		String lastWindowHandle = allWindowHandles.toArray()[allWindowHandles.size() - 1].toString();
		getDriver().switchTo().window(lastWindowHandle);
		lp.jseResetBtn();
		lp.jseConfirmBtn();
		handlePleaseWaitLoader(lp); // Extracted method
		waitForDsVisibility(lp); // Re-used extracted method
	}

	public static void loginAndSearchFileTextVariableClickEdit() {
		try {
			String threadName = Thread.currentThread().getName();
			if (threadName.contains(THREAD_NAME_RETRY_1)) {
				textVaiableFile1();
			} else if (threadName.contains(THREAD_NAME_RETRY_2)) {
				textVaiableFile2();
			} else if (threadName.contains(THREAD_NAME_RETRY_3)) {
				textVaiableFile3();
			} else if (threadName.contains(THREAD_NAME_RETRY_4)) {
				textVaiableFile4();
			} else {
				textVaiableFile1(); // Default case
			}
		} catch (Exception e) {
			logger.warn(LOG_WARN_ERROR_OCCURRED, e.getMessage(), e);
		}
	}
}
