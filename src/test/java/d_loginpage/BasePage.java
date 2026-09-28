package d_loginpage;

import java.time.Duration;
import java.util.Set;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasePage {

	public final WebDriver getDriver;
	public final WebDriverWait mywait;
	public final JavascriptExecutor js;
	public final Actions action;
	private static final Logger logger = LoggerFactory.getLogger(BasePage.class);

	public BasePage(WebDriver driver) {
		this.getDriver = driver;
		mywait = new WebDriverWait(getDriver, Duration.ofSeconds(60));
		js = (JavascriptExecutor) getDriver;
		action = new Actions(getDriver);
		PageFactory.initElements(getDriver, this);
	}

	public void clickElement(WebElement element) {
		mywait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}

	public void enterText(WebElement element, String text) {
		mywait.until(ExpectedConditions.visibilityOf(element));
		element.clear();
		element.sendKeys(text);
	}

	public boolean isElementDisplayed(WebElement element) {
		try {
			return mywait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public static void sleepFor(int milliSeconds) {
		try {
			Thread.sleep(milliSeconds);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			logger.warn("Thread was interrupted during sleep: {}", e.getMessage(), e);
		}
	}

	public void selectDropdownOptionByVisibleText(WebElement dropdownElement, String optionText) {
		Select dropdown = new Select(dropdownElement);
		dropdown.selectByVisibleText(optionText);
	}

	public void waitForElementToBeVisible(WebElement element) {
		mywait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitForElementToHaveText(WebElement element, String expectedText) {
		mywait.until(ExpectedConditions.textToBePresentInElement(element, expectedText));
	}

	public void waitForPageToLoad() {
		mywait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState")
				.equals("complete"));
	}

	public void clickWithActions(WebElement element) {
		action.click(element).perform();
	}

	public void sendKeysWithActions(WebElement element, String text) {
		action.sendKeys(element, text).perform();
	}

	public void rightClickElement(WebElement element) {
		action.click(element).perform();
		action.contextClick(element).perform();
	}

	public void doubleClickElement(WebElement element) {
		action.doubleClick(element).perform();
	}

	public void actionBackspace() {
		action.sendKeys(Keys.BACK_SPACE).perform();
	}

	public void actionDelete() {
		action.sendKeys(Keys.DELETE).perform();
	}

	public void hoverOverElement(WebElement element) {
		action.moveToElement(element).perform();
	}

	public WebElement fluentWaitForElement(Function<WebDriver, WebElement> condition) {
		FluentWait<WebDriver> fluentWait = new FluentWait<>(getDriver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofMillis(500)).ignoring(Exception.class);

		return fluentWait.until(condition);
	}

	public void clickByJS(WebElement element) {
		if (mywait.until(ExpectedConditions.elementToBeClickable(element)).isDisplayed()) {
			js.executeScript("arguments[0].click();", element);
		}
	}

	public void waitForElementToBeSelect(WebElement element) {
		mywait.until(ExpectedConditions.elementToBeSelected(element));
	}

	public void waitForElementToBeHighlighted(WebElement element) {
		mywait.until(ExpectedConditions.visibilityOf(element));
	}

	public static WebElement getElement(WebElement element) {
		return element;
	}

	public void actionEnter() {
		action.sendKeys(Keys.ENTER).perform();
	}

	public void actionSelectText() {
		action.keyDown(Keys.SHIFT);
		for (int i = 0; i < 7; i++) {
			action.sendKeys(Keys.ARROW_LEFT).perform();
		}
		action.keyUp(Keys.SHIFT).perform();
	}

	public void actionSelectAllText() {
		action.keyDown(Keys.CONTROL).perform();
		action.sendKeys("a").perform();
		action.keyUp(Keys.CONTROL).perform();

	}

	public boolean isElementEnabled(WebElement element) {
		try {
			return mywait.until(ExpectedConditions.visibilityOf(element)).isEnabled();
		} catch (Exception e) {
			return false;
		}
	}

	public static void mouseoverAction(WebDriver driver) {
		try {

			WebElement ele = driver.findElement((By) driver);
			Actions action = new Actions(driver);
			action.moveToElement(ele).build().perform();
		} catch (Exception e) {
			logger.warn("Issue in Mouse hover action");
		}
	}

	@SuppressWarnings("unused")

	public void switchToWindow() {
		boolean flag = false;
		try {
			String currentWindowHandle = getDriver.getWindowHandle();

			Set<String> windowhandles = getDriver.getWindowHandles();
			for (String newWindow : windowhandles) {
				if (!currentWindowHandle.equals(newWindow)) {
					getDriver.switchTo().window(newWindow);
					flag = true;
				}
			}
			flag = true;
			getDriver.manage().window().maximize();
		} catch (Exception e) {
			logger.error("Error during window maximize operation: {}", e.getMessage(), e);
		}
	}

	public void pageLoad() {
		getDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(600));

	}

	public void isElementVisible(WebElement element) {
		mywait.until(ExpectedConditions.visibilityOf(element));
	}

	public void elementClick(WebElement element) {
		mywait.until(ExpectedConditions.elementToBeClickable(element));
		logger.info("Click Element");
		element.click();
	}

	public boolean waitForElementToBeInVisible(WebElement element) {
		try {
			return mywait.until(ExpectedConditions.invisibilityOf(element));
		} catch (Exception e) {
			return false;
		}
	}

	public boolean waitForTextToBePresentInElement(WebElement element, String text) {
		try {
			return mywait.until(ExpectedConditions.textToBePresentInElement(element, text));
		} catch (Exception e) {
			return false;
		}
	}

}
