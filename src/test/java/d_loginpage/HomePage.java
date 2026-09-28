package d_loginpage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    private static final String JS_CLICK_SCRIPT = "arguments[0].click();";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='email']")
    WebElement username;

    @FindBy(xpath = "//input[@name='password']")
    WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;

    @FindBy(xpath = "//button[contains(@class,'btn btn-default')]")
    WebElement sltProject;

    @FindBy(xpath = "//a[contains(text(),'IATAPOC')]|//a[contains(text(),'IATAPOC')]")
    WebElement project;

    @FindBy(xpath = "//span[contains(text(),'Authoring File List')]")
    WebElement fileList;

    @FindBy(xpath = "(//input[@class='form-control dt-filter-input'])[3]")
    WebElement fileName;

    @FindBy(xpath = "(//input[@class='form-control dt-filter-input'])[1]")
    WebElement titleCode;

    @FindBy(xpath = "(//a[@data-order-id='85'])[2]")
    WebElement btnEditFile;

    @FindBy(id = "btn-reset-file")
    WebElement reset;

    @FindBy(xpath = "//button[text()='confirm']")
    WebElement confirm;

    @FindBy(xpath = "(//li[@name='p'])[1]")
    WebElement firstPara;

    @FindBy(xpath = "//*[contains(text(),'Document Structure')]")
    WebElement ds;

    @FindBy(xpath = "//div[@title='Table']//table//tr[\" + i + \"]/td[\" + j + \"]")
    WebElement tableBoxElement;

    @FindBy(xpath = "//div[@title='Table']//table//tr[\" + row + \"]/td[\" + column + \"]")
    WebElement tableBoxColumn;

    @FindBy(xpath = "//span[@class='select2-selection select2-selection--single']")
    WebElement titleName;

    @FindBy(xpath = "//li[text()='100']")
    WebElement listedHundred;

    @FindBy(xpath = "//*[@id='tab-li-pdf']/a/span[2]")
    WebElement printPreview;

    @FindBy(xpath = "//input[@placeholder=' Title Name']")
    WebElement inputTitleName;

    @FindBy(xpath = "//a[contains(text(),'Next')]")
    WebElement nextList;

    @FindBy(xpath = "//a[@title='Insert Table']|//a[@title='Table']")
    WebElement insertTableIcon;

    @FindBy(xpath = "(//span[text()='heading'])[1]")
    WebElement dsSection;
    
    @FindBy(xpath = "(//a[@data-order-id='5'])[2]|(//a[@data-order-id='1955'])[2]")
    WebElement btnEditFileXPath1;

    @FindBy(xpath = "(//a[@data-order-id='4'])[2]|(//a[@data-order-id='2091'])[2]")
    WebElement btnEditFileXPath2;

    @FindBy(xpath = "(//a[@data-order-id='6'])[2]|(//a[@data-order-id='1956'])[2]")
    WebElement btnEditFileXPath3;

    @FindBy(xpath = "(//a[@data-order-id='7'])[2]|(//a[@data-order-id='1955'])[2]")
    WebElement btnEditFileXPath4;

    @FindBy(xpath = "(//a[@data-order-id='2082'])[2]|(//a[@data-order-id='9'])[2]")
    WebElement btnEditFileXPath5;

    @FindBy(xpath = "(//a[@data-order-id='5'])[2]|(//a[@data-order-id='1956'])[2]")
    WebElement textVariableFileXPath1;

    @FindBy(xpath = "(//a[@data-order-id='4'])[2]|(//a[@data-order-id='1955'])[2]")
    WebElement textVariableFileXPath2;
    @FindBy(xpath = "(//a[@data-order-id='6'])[2]|(//a[@data-order-id='1956'])[2]")
    WebElement textVariableFileXPath3;

    @FindBy(xpath = "(//a[@data-order-id='7'])[2]|(//a[@data-order-id='1955'])[2]")
    WebElement textVariableFileXPath4;

    @FindBy(xpath = "(//a[@data-order-id='271'])[2]")
    WebElement btnEditFileXPathNewFile;
    @FindBy(xpath = "//div[normalize-space(text())='Please wait...']")
    WebElement pleaseWait;
    
    @FindBy(xpath = "//div[text()='Loading IAPP Editor Data...']")
    WebElement loader;

    public void inputUsername(String userName) {
        username.sendKeys(userName);
    }

    public void inputTitleCode(String titleCodeValue) {
        titleCode.sendKeys(titleCodeValue);
    }

    public WebElement dsVisible() {
        return ds;
    }

    public void inputPassword(String passwordValue) {
        password.sendKeys(passwordValue);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void clickSelectProject() {
        sltProject.click();
    }

    public void clickProject() {
        project.click();
    }

    public void clickFileList() {
        fileList.click();
    }

    public void inputFileName(String fileNameValue) {
        fileName.sendKeys(fileNameValue);
    }

    public void clickEditFileButton() {
        btnEditFile.click();
    }

    public void clickResetButton() {
        reset.click();
    }

    public void clickConfirmButton() {
        confirm.click();
    }

    public void clickDocumentStructure() {
        ds.click();
    }

    public WebElement getBtnEditFileEdit() {
        return btnEditFile;
    }

    private void clickElementWithJs(WebElement element) {
        if (mywait.until(ExpectedConditions.elementToBeClickable(element)).isDisplayed()) {
            js.executeScript(JS_CLICK_SCRIPT, element);
        }
    }

    public void jseResetBtn() {
        clickElementWithJs(reset);
    }

    public void jseConfirmBtn() {
        clickElementWithJs(confirm);
    }

    public void jseEditFileButtonXPath1() {
    	 WebDriverWait wait = new WebDriverWait(getDriver, Duration.ofSeconds(30));
    	    wait.until(ExpectedConditions.visibilityOf(btnEditFileXPath1));
    	    wait.until(ExpectedConditions.elementToBeClickable(btnEditFileXPath1));
    	    btnEditFileXPath1.click();
    }

    public void jseEditFileButtonXPath2() {
    	 WebDriverWait wait = new WebDriverWait(getDriver, Duration.ofSeconds(30));
 	    wait.until(ExpectedConditions.visibilityOf(btnEditFileXPath2));
 	    wait.until(ExpectedConditions.elementToBeClickable(btnEditFileXPath2));
 	    btnEditFileXPath2.click();
    /**	clickWithActions(btnEditFileXPath2);*/
    }
    
    public Boolean isDisplayedInputTitleName() {   	
		return isElementDisplayed(inputTitleName);
	}

    public void jseEditFileButtonXPath3() {
    	 WebDriverWait wait = new WebDriverWait(getDriver, Duration.ofSeconds(30));
 	    wait.until(ExpectedConditions.visibilityOf(btnEditFileXPath3));
 	    wait.until(ExpectedConditions.elementToBeClickable(btnEditFileXPath3));
 	    btnEditFileXPath3.click();
    /**	clickWithActions(btnEditFileXPath3);*/
    }

    public void jseEditFileButtonXPath4() {
    	 WebDriverWait wait = new WebDriverWait(getDriver, Duration.ofSeconds(30));
 	    wait.until(ExpectedConditions.visibilityOf(btnEditFileXPath4));
 	    wait.until(ExpectedConditions.elementToBeClickable(btnEditFileXPath4));
 	    btnEditFileXPath4.click();
  /** 	clickWithActions(btnEditFileXPath4);*/
    }

    public void jseEditFileButtonXPath5() {
    	clickWithActions(btnEditFileXPath5);
    }

    public void jseEditFileButtonXPathNewFile() {
    	clickWithActions(btnEditFileXPathNewFile);
    }

    public void jseEditTextVariableFileXPath1() {
    	clickWithActions(textVariableFileXPath1);
    }

    public void jseEditTextVariableFileXPath2() {
    	clickWithActions(textVariableFileXPath2);
    }
    public void jseEditTextVariableFileXPath3() {
    	clickWithActions(textVariableFileXPath3);
    }

    public void jseEditTextVariableFileXPath4() {
    	clickWithActions(textVariableFileXPath4);
    }
    @Override
    public void waitForPageToLoad() {
        mywait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete';"));
    }

    public void clickDSSection() {
        mywait.until(ExpectedConditions.elementToBeClickable(dsSection)).isDisplayed();
        dsSection.click();
    }

    public WebElement getDsSection() {
        return dsSection;
    }

    public void clickfirstpara() {
        mywait.until(ExpectedConditions.elementToBeClickable(firstPara));
        clickElement(firstPara);
    }

    public WebElement getfirstpara() {
        return firstPara;
    }

    public void clickInsertTableIcon() {
        clickElement(insertTableIcon);
    }

    public WebElement gettableBoxElement() {
        return tableBoxElement;
    }

    public void clicktableBoxColumn() {
        clickElement(tableBoxColumn);
    }

    public void clickTitleName() {
        clickElement(titleName);
    }

    public void clickListedHundered() {
        clickElement(listedHundred);
    }

    public WebElement getInputTitleName() {
        return inputTitleName;
    }

    public Boolean isRequestedInputTitleName() {
        return isElementDisplayed(inputTitleName);
    }

    public Boolean isDisplayedPrintPreview() {
        return isElementDisplayed(printPreview);
    }

    public void clickNextList() {
        clickElement(nextList);
    }

    public void clickPrintPreview() {
        clickElement(printPreview);
    }

    public boolean isPleaseWait() {
        return isElementDisplayed(pleaseWait);
    }

    public WebElement getPleaseWait() {
        return pleaseWait;
    }
    public void waitForLoaderToDisappear() {
        waitForElementToBeInVisible(loader);
    }
}