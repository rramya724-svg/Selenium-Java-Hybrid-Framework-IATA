package textvariable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import d_loginpage.BasePage;

public class TextVariablePageObjects extends BasePage {

	public TextVariablePageObjects(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[@title='Insert Text Variable']")
	WebElement textVariablePlugin;
	@FindBy(xpath = "(//input[@class='entity-checkbox'])[1]")
	WebElement entityCheckbox1;
	@FindBy(xpath = "//button[@id='modal-entity-insert-btn']")
	WebElement variableInsertBtn;
	@FindBy(xpath = "//button[@id='modal-entity-cancel-btn']|//button[@id='modal-entity-close-btn']")
	WebElement variableCancelBtn;
	@FindBy(xpath = "//span[@data-element='variable']|//span[contains(@class,'entity ice-ins')]")
	WebElement newlyInsertedVariableVE;
	@FindBy(xpath = "(//span[@data-element='variable'])[2]")
	WebElement newlyPastedVariableVE;
	@FindBy(xpath = "//span[@data-element='variable']|//span[contains(@class,'entity ice-ins')]")
	WebElement deletedInsertedVariableVE;
	@FindBy(xpath = "//button[contains(.,'variable')]")
	WebElement newlyInsertedVariableAP;
	@FindBy(xpath = "(//a[@title='Find'])[1]")
	WebElement findAndReplacePlugin;
	@FindBy(xpath = "(//span[normalize-space(text())='X']/following::input)[1]")
	WebElement variableInputInFindPlugin;
	@FindBy(xpath = "//div[@class='bootstrap-growl alert alert-danger alert-dismissible']|//div[contains(@class,'bootstrap-growl')]")
	WebElement bootstrapAlert;
	@FindBy(xpath = "//a[@title='Accept Change']")
	WebElement acceptChange;
	@FindBy(xpath = "(//div[@data-element='p'])[2]")
	WebElement veFirstPara;
	@FindBy(xpath = "//li[@id='tab-li-table-properties-panel']/following-sibling::li[1]")
	WebElement trackChange;
	@FindBy(xpath = "//span[text()='1']")
	WebElement cardNumberOne;
	@FindBy(xpath = "(//h2[@id='11']//button)[1]")
	WebElement middleSection;
	@FindBy(xpath = "//button[text()='Insert After']")
	WebElement dsRightclickInsertAfter;
	@FindBy(xpath = "//a[contains(@class,'insert-after') and text()='section']")
	WebElement dsRightclickSection;
	@FindBy(xpath = "(//h2[@id='40']//button)[1] |(//h2[@id='41']//button)[1] |(//h2[@id='52']//button)[1] |//h2[@id='11']|//h2[@id='55']")
	WebElement newSectionDS;
	@FindBy(xpath = "(//span[text()='p'])[2]")
	WebElement firstParaCB;
	@FindBy(xpath = "//button[text()='Insert After']")
	WebElement dsInsertAfter;
	@FindBy(xpath = "(//input[@name='media-object'])[1]|//li[contains(.,'ichm-en-9.4.1.1.jpg')]|(//div[@class='media-image']//input)[1]")
	WebElement imgInsertFromInsertPlugin;
	@FindBy(xpath = "//button[contains(@class,'insert-btn btn')]|//button[@type='primary']")
	WebElement insertButtonElement;
	@FindBy(xpath = "//a[@title='Insert']|//a[contains(.,'Insert Element')]")
	WebElement insertPlugin;
	@FindBy(xpath = "//input[@id='insert-before']")
	WebElement insertBeforeElement;
	@FindBy(xpath = "//input[@id='insert-after']")
	WebElement insertAfterElement;
	@FindBy(xpath = "//input[@id='insert-into']")
	WebElement insertIntoElement;
	@FindBy(xpath = "//input[id='content-variable']|//li[@title='variable']|//li[@data-into-name='variable']")
	WebElement variableQuickInsert;
	@FindBy(xpath = "//a[@title='Numbered List']")
	WebElement listPlugin;
	@FindBy(xpath = "//h5[normalize-space(text())='Text Variable List']|//div[@class='modal-header ui-draggable-handle']/following-sibling::div[1]")
	WebElement variablePopup;
	@FindBy(xpath = "//input[@placeholder='Search Text Variable...']|//input[@class='form-control mb-3']")
	WebElement searchOptionInVariablePopup;
	@FindBy(xpath = "//button[text()='Insert Into']")
	WebElement dsInsertInto;
	@FindBy(xpath = "//li[@class='contentBlockListItem selectedContentBlock']")
	WebElement newlyInsertedDSCodeID;
	@FindBy(xpath = "(//span[text()='p'])[3]")
	WebElement newlyInsertedFirstParaCB;
	@FindBy(xpath = "//a[@title='Undo (Ctrl+Z)']")
	WebElement undoPlugin;
	@FindBy(xpath = "//div[@inno_ref='6']")
	WebElement veMiddlePara;
	@FindBy(xpath = "//span[@data-flite-cid='2']")
	WebElement dataFliteCid2;
	@FindBy(xpath = "(//button[@class='btn btn-primary'])[2]")
	WebElement insertElementBtn;
	@FindBy(xpath = "//a[contains(.,'Paste (Ctrl+V)')]")
	WebElement pasteButton;
	@FindBy(xpath = "//a[@title='Copy (Ctrl+C)']")
	WebElement copyButton;
	@FindBy(xpath = "//li[normalize-space(text())='figure']")
	WebElement figureInList;
	@FindBy(xpath = "//li[normalize-space(text())='address']")
	WebElement addressInList;
	@FindBy(xpath = "//button[contains(.,'party-info')]")
	WebElement partyInfoDS;
	@FindBy(xpath = "//button[contains(.,'address-details')]")
	WebElement addressDetails;
	@FindBy(xpath = "//div[contains(@class,'bootstrap-growl alert')]")
	WebElement bootstrapGrowl;
	@FindBy(xpath = "(//span[text()='p'])[2]")
	WebElement secondParaCB;
	@FindBy(xpath = "//span[@data-element='variable']|//span[contains(@class,'entity ice-ins')]//definition")
	WebElement newlyInsertedVariableVEDefinition;
	@FindBy(xpath = "//a[@title='Accept Change']")
	WebElement acceptChanges;
	@FindBy(xpath = "//a[@title='Reject Change']")
	WebElement rejectChanges;
	@FindBy(xpath = "//div[@class='ice-ins flite-container-only element-tag-color']")
	WebElement newParaVE;
	@FindBy(xpath = "//div[@class='bootstrap-growl alert alert-danger alert-dismissible']|//div[contains(@class,'bootstrap-growl')]")
	WebElement alertMsg;
	@FindBy(xpath = "//a[text()='variable']|//li[text()='variable']")
	WebElement rcPopupVariableElement;
	@FindBy(xpath = "//a[@aria-label='Element and attributes']")
	WebElement rightClickElementsAttribute;
	@FindBy(xpath = "//li[@id='tab-li-attribute-panel']//a[1]")
	WebElement elementsAndAttributeTab;
	@FindBy(xpath = "//div[@class='elementSearchDropdown px-3 pb-2 dropdown']/button")
	WebElement elementAttributeName;
	@FindBy(xpath = "//div[@class='breadcumbItem selectedItem']")
	WebElement breadcrumbVariable;
	@FindBy(xpath = "//a[@title='Insert Image']")
	WebElement imagePluginTB;
	@FindBy(xpath = "//a[@title='Insert Symbol/Character']")
	WebElement symbolPluginTB;
	@FindBy(xpath = "//div[@aria-label='Change Text Variable']")
	WebElement changeTextVariableOptionRC;
	@FindBy(xpath = "//div[@class='tchange-box removed']")
	WebElement dataCardRemoved;
	@FindBy(xpath = "//div[@class='tchange-description']//p[1]")
	WebElement tcCardDescription;
	@FindBy(xpath = "//div[@class='tchange-box added']|//div[contains(@class,'tchange-box added tchange-inactive')]|//div[contains(@class,'tchange-box')]")
	WebElement dataCard;
	@FindBy(xpath = "(//li[@name='p'])[1]")
	WebElement firstPara;
	@FindBy(xpath = "//a[@title='Bold (Ctrl+B)']")
	WebElement bold;
	@FindBy(xpath = "//a[@aria-label='Insert After']")
	WebElement rightClickInsertAfter;
	@FindBy(xpath = "//a[.='Insert IntoCtrl+Enter']|//label[text()='Insert Into']|//span[text()='Insert Into']")
	WebElement insertInto;
	@FindBy(xpath = "//a[.='Insert BeforeCtrl+Shift+Enter']")
	WebElement rightClickInsertBefore;
	@FindBy(xpath = "//button[text()='Insert Element']")
	WebElement insertElement;
	@FindBy(xpath = "//span[@inno_ref='40']|//div[@inno_ref='5']/span")
	WebElement veBold;
	@FindBy(xpath = "//div[@inno_ref='5']/span[2]/span")
	WebElement veTextVariableAfterBold;
	@FindBy(xpath = "//li[@id='40']|//li[@id='41']|//li[@id='55']|(//li[@id='55'])[1]")
	WebElement dsB;
	@FindBy(xpath = "//button[text()='Insert After']")
	WebElement insertAfterDS;
	@FindBy(xpath = "//button[text()='Insert Into']")
	WebElement insertIntoDS;
	@FindBy(xpath = "//a[text()='variable']|//li[text()='variable']")
	WebElement rcPopupVariableElementDuplicate;
	@FindBy(xpath = "//div[@id='entity-list-container']")
	WebElement textVariableListPopup;
	@FindBy(xpath = "//h2[@value='56']/following-sibling::div")
	WebElement dsNote;
	@FindBy(xpath = "//div[@class='ice-ins flite-container-only not-allowed']")
	WebElement redTagPara;
	@FindBy(xpath = "//div[@inno_ref='6'] | (//div[@data-element='p']/following-sibling::div)[3]")
	WebElement ve3rdPara;
	@FindBy(xpath = "(//span[@data-element='variable'])[2]|(//span[contains(@class,'entity ice-ins')])[2]")
	WebElement pastedTextVariableVE;
	@FindBy(xpath = "//a[@title='Insert Cross Reference']|//a[contains(.,'Insert Link')]")
	WebElement crossreferenceButton;
	@FindBy(xpath = "(//span[text()='p'])[2]|(//li[@name='p'])[2]")
	WebElement ds2Para;
	@FindBy(xpath = "(//div[@data-element='p'])[2]|//div[@inno_ref='4']")
	WebElement ve2Para;
	@FindBy(xpath = "//a[@title='Numbered List']")
	WebElement numberList;
	@FindBy(xpath = "//h2[@value='58']/button")
	WebElement newLiDS;
	@FindBy(xpath = "//h2[@value='59']/button|//h2[@value='60']/button")
	WebElement newInsertedLiDS;
	@FindBy(xpath = "//img[@data-element='inline-img']")
	WebElement inlineImageVE;
	@FindBy(xpath = "(//div[@data-element='p'])[3]|//div[@inno_ref='5']")
	WebElement firstParagraph;
	@FindBy(xpath = "//li[@name='inline-img'][1]")
	WebElement inlineImageDS;
	@FindBy(xpath = "//li[text()='numbered-para']")
	WebElement insertAfterNumberedPara;
	@FindBy(xpath = "//li[text()='notes']|//li[normalize-space(text())='notes']")
	WebElement insertAfterNotes;
	@FindBy(xpath = "(//button[text()='Insert Element'])[1]")
	WebElement insertElementButton;
	@FindBy(xpath = "//div[@data-element='numbered-para']/div[@data-element='p']")
	WebElement numParaPElement;
	@FindBy(xpath = "//div[text()='Loading IAPP Editor Data...']")
	WebElement loader;

	public void clickNumParaPElement() {
		clickElement(numParaPElement);
	}

	public void clickInsertAfterNotes() {
		clickElement(insertAfterNotes);
	}

	public void clickInsertElementButton() {
		clickElement(insertElementButton);
	}

	public void clickInsertAfterNumberedPara() {
		clickElement(insertAfterNumberedPara);
	}

	public void rightClickFirstPara() {
		Actions action = new Actions(getDriver);
		action.click(veFirstPara).perform();
		action.contextClick(veFirstPara).perform();
	}

	public void clickOnInlineImageDS() {
		clickElement(inlineImageDS);
	}

	public void clickFirstParagraph() {
		clickElement(firstParagraph);
	}

	public void doubleClickFirstParaVE() {
		doubleClickElement(firstParagraph);
	}

	public void clickUndoPlugin() {
		clickElement(undoPlugin);
	}

	public boolean isNewlyInsertedFirstParaCB() {
		return isElementDisplayed(newlyInsertedFirstParaCB);
	}

	public boolean isNewlyInsertedDSCodeID() {
		return isElementDisplayed(newlyInsertedDSCodeID);
	}

	public WebElement getSearchOptionInVariablePopup() {
		return searchOptionInVariablePopup;
	}

	public void clickSearchOptionInVariablePopup() {
		clickElement(searchOptionInVariablePopup);
	}

	public void clickDSInsertInto() {
		clickElement(dsInsertInto);
	}

	public boolean isSearchOptionInVariablePopup() {
		return isElementDisplayed(searchOptionInVariablePopup);
	}

	public WebElement getVariablePopup() {
		return variablePopup;
	}

	public boolean isVariablePopup() {
		return isElementDisplayed(variablePopup);
	}

	public void clickListPlugin() {
		clickElement(listPlugin);
	}

	public void clickVariableQuickInsert() {
		clickElement(variableQuickInsert);
	}

	public void clickInsertBeforeElement() {
		clickElement(insertBeforeElement);
	}

	public void clickInsertIntoElement() {
		clickElement(insertIntoElement);
	}

	public void clickInsertPlugin() {
		clickElement(insertPlugin);
	}

	public void clickInsertButton() {
		clickElement(insertButtonElement);
	}

	public void clickImgInsertFromInsertPlugin() {
		clickElement(imgInsertFromInsertPlugin);
	}

	public void dsInsertAfter() {
		dsInsertAfter.click();
	}

	public WebElement getFirstParaCB() {
		return firstParaCB;
	}

	public void clickTextVariablePlugin() {
		clickElement(textVariablePlugin);
	}

	public void clickEntityCheckbox1() {
		clickElement(entityCheckbox1);
	}

	public void clickVariableInsertBtn() {
		clickElement(variableInsertBtn);
	}

	public void clickVariableCancelBtn() {
		clickElement(variableCancelBtn);
	}

	public boolean isNewlyInsertedVariableVE() {
		return isElementDisplayed(newlyInsertedVariableVE);
	}

	public boolean isNewlyPastedVariableVE() {
		return isElementDisplayed(newlyPastedVariableVE);
	}

	public boolean isDeletedInsertedVariableVE() {
		return isElementDisplayed(deletedInsertedVariableVE);
	}

	public WebElement getDeletedInsertedVariableVE() {
		return deletedInsertedVariableVE;
	}

	public boolean isNewlyInsertedVariableAP() {
		return isElementDisplayed(newlyInsertedVariableAP);
	}

	public void clickFindAndReplacePlugin() {
		clickElement(findAndReplacePlugin);
	}

	public boolean isVariableInputInFindPlugin() {
		return isElementDisplayed(variableInputInFindPlugin);
	}

	public WebElement getBootstrapAlert() {
		return bootstrapAlert;
	}

	public void clickAcceptChange() {
		clickElement(acceptChange);
	}

	public void clickVEFirstPara() {
		mywait.until(ExpectedConditions.elementToBeClickable(veFirstPara));
		clickElement(veFirstPara);
	}

	public void doubleClickVEFirstPara() {
		clickElement(veFirstPara);
		doubleClickElement(veFirstPara);
	}

	public void clickTrackChange() {
		clickElement(trackChange);
	}

	public boolean isElementPresentCardNumberOne() {
		return isElementDisplayed(cardNumberOne);
	}

	public void clickMiddleSection() {
		mywait.until(ExpectedConditions.elementToBeClickable(middleSection));
		clickElement(middleSection);
	}

	public WebElement getMiddleSection() {
		mywait.until(ExpectedConditions.elementToBeClickable(middleSection));
		return middleSection;
	}

	public void clickDSRightClickInsertAfter() {
		mywait.until(ExpectedConditions.elementToBeClickable(dsRightclickInsertAfter));
		clickElement(dsRightclickInsertAfter);
		mywait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("prgress")));
	}

	public void clickDSRightClickSection() {
		clickElement(dsRightclickSection);
	}

	public boolean isNewSectionDS() {
		return isElementDisplayed(newSectionDS);
	}

	public WebElement getNewlyInsertedVariableVe() {
		return newlyInsertedVariableVE;
	}

	public void clickNewlyInsertedVariableVe() {
		mywait.until(ExpectedConditions.elementToBeClickable(newlyInsertedVariableVE));
		clickElement(newlyInsertedVariableVE);
	}

	public void clickVeMiddlePara() {
		mywait.until(ExpectedConditions.elementToBeClickable(veMiddlePara));
		clickElement(veMiddlePara);
	}

	public void clickSecondParaCb() {
		mywait.until(ExpectedConditions.elementToBeClickable(secondParaCB));
		clickElement(secondParaCB);
	}

	public boolean isDataFliteCid2() {
		return isElementDisplayed(dataFliteCid2);
	}

	public boolean isNewlyInsertedVariableVeDefinition() {
		mywait.until(ExpectedConditions.elementToBeClickable(newlyInsertedVariableVEDefinition));
		return isElementDisplayed(newlyInsertedVariableVEDefinition);
	}

	public void clickCopyButton() {
		clickElement(copyButton);
	}

	public void clickPasteButton() {
		clickElement(pasteButton);
	}

	public void clickAddressInList() {
		clickElement(addressInList);
	}

	public void clickPartyInfoDs() {
		clickElement(partyInfoDS);
	}

	public void clickAddressDetailsDs() {
		clickElement(addressDetails);
	}

	public void clickFigureInList() {
		clickElement(figureInList);
	}

	public void insertElementBtn() {
		clickElement(insertElementBtn);
	}

	public WebElement getVeFirstPara() {
		mywait.until(ExpectedConditions.elementToBeClickable(veFirstPara));
		return veFirstPara;
	}

	public WebElement getBootstrapGrowl() {
		mywait.until(ExpectedConditions.elementToBeClickable(bootstrapGrowl));
		return bootstrapGrowl;
	}

	public WebElement getTextVariablePlugin() {
		return textVariablePlugin;
	}

	public void clickOnInlineImageVe() {
		clickElement(inlineImageVE);
	}

	public boolean isNewInsertedLiDsPresent() {
		return isElementDisplayed(newInsertedLiDS);
	}

	public void clickOnNewLiDs() {
		clickElement(newLiDS);
	}

	public void clickNumberList() {
		clickElement(numberList);
	}

	public void clickVe2Para() {
		clickElement(ve2Para);
	}

	public void clickDs2Para() {
		clickElement(ds2Para);
	}

	public boolean isAlertMsgPresent() {
		return isElementDisplayed(alertMsg);
	}

	public void clickOnCrossRefButton() {
		clickElement(crossreferenceButton);
	}

	public WebElement getCrossreferenceButton() {
		return crossreferenceButton;
	}

	public boolean isPastedTextVariableVe() {
		return isElementDisplayed(pastedTextVariableVE);
	}

	public void clickVe3rdPara() {
		clickElement(ve3rdPara);
	}

	public boolean isRedTagPara() {
		return isElementDisplayed(redTagPara);
	}

	public boolean isRcPopupVariableElement() {
		return isElementDisplayed(rcPopupVariableElement);
	}

	public boolean isInsertIntoDs() {
		return isElementDisplayed(insertIntoDS);
	}

	public void clickInsertIntoDs() {
		clickElement(insertIntoDS);
	}

	public void clickDsNote() {
		clickElement(dsNote);
	}

	public void rightClickOnDsNote() {
		rightClickElement(dsNote);
	}

	public boolean isTextVariableListPopup() {
		return isElementDisplayed(textVariableListPopup);
	}

	public void clickRcPopupVariableElement() {
		clickElement(rcPopupVariableElement);
	}

	public void clickOnInsertAfterDs() {
		clickElement(insertAfterDS);
	}

	public void rightClickOnDsB() {
		rightClickElement(dsB);
	}

	public WebElement getDsB() {
		return dsB;
	}

	public boolean isVeTextVariableAfterBold() {
		return isElementDisplayed(veTextVariableAfterBold);
	}

	public WebElement getVeBold() {
		return veBold;
	}

	public void clickOnVeBold() {
		clickElement(veBold);
	}

	public void clickRightClickInsertAfter() {
		clickElement(rightClickInsertAfter);
	}

	public void clickInsertElement() {
		mywait.until(ExpectedConditions.elementToBeClickable(insertElement));
		clickElement(insertElement);
	}

	public WebElement getFirstPara() {
		return firstPara;
	}

	public void clickOnFirstPara() {
		clickElement(firstPara);
	}

	public void clickOnBoldButton() {
		clickElement(bold);
	}

	public void doubleClickFirstPara() {
		clickElement(firstParagraph);
		doubleClickElement(firstParagraph);
	}

	public void clickOnTrackChangeButton() {
		clickElement(trackChange);
	}

	public boolean isDataCardPresentInTc() {
		return isElementDisplayed(dataCardRemoved);
	}

	public boolean isElementPresentDataCard() {
		return isElementDisplayed(dataCard);
	}

	public WebElement getTcCardDetails() {
		return tcCardDescription;
	}

	public WebElement getSymbolPluginTb() {
		return symbolPluginTB;
	}

	public WebElement getImagePluginTb() {
		return imagePluginTB;
	}

	public WebElement getBreadcrumbVariable() {
		return breadcrumbVariable;
	}

	public WebElement getElementAttributeName() {
		return elementAttributeName;
	}

	public void clickElementsAndAttributeTab() {
		clickElement(elementsAndAttributeTab);
	}

	public boolean isRightClickElementsAttributePresent() {
		return isElementDisplayed(rightClickElementsAttribute);
	}

	public void newlyInsertedVariableVe() {
		clickElement(newlyInsertedVariableVE);
	}

	public String getInfoMsg() {
		return alertMsg.getText();
	}

	public boolean isNewParaVePresent() {
		return isElementDisplayed(newParaVE);
	}

	public WebElement getNewParaVe() {
		return newParaVE;
	}

	public void clickOnAcceptChanges() {
		clickElement(acceptChanges);
	}

	public void clickOnRejectChanges() {
		clickElement(rejectChanges);
	}

	public WebElement getChangeTextVariableOpitionRC() {

		return changeTextVariableRC;
	}

	private static final String BACKGROUND_COLOR = "background-color";

	@FindBy(xpath = "//button[@id='rightScollBtn']")
	WebElement scrollRightBtn;
	@FindBy(xpath = "//a[@aria-label='Change Text Variable']")
	WebElement changeTextVariableRC;
	@FindBy(xpath = "//a[contains(.,'Add Comment')]")
	WebElement addComment;
	@FindBy(xpath = "//div[@class='comment-input-wrapper']/textarea")
	WebElement commentPopupTextArea;
	@FindBy(xpath = "(//div[contains(@class,'comment-box unresolved')])[1]")
	WebElement commentCard;
	@FindBy(xpath = "//button[text()='Submit']")
	WebElement commentSubmit;
	@FindBy(xpath = "//div[@class='comment-generator']")
	WebElement commentPopup;
	@FindBy(xpath = "//annotation[contains(@class,'lance-annotation')]")
	WebElement veCommentedText;
	@FindBy(xpath = "(//span[text()='heading'])[1]")
	WebElement dsSection;
	@FindBy(xpath = "//div[@data-element='address-details']/div")
	WebElement addressDetailsParaVE;
	@FindBy(xpath = "//div[@class='tchange-description']//p[1]")
	WebElement dataInformationTc;
	@FindBy(xpath = "//a[contains(@class,'cke_button cke_button__undo')]")
	WebElement undo;
	@FindBy(xpath = "//li[@class='contentBlockListItem selectedContentBlock']")
	WebElement selectedCB;
	@FindBy(xpath = "//a[@title='Reject Change']")
	WebElement rejectChange;
	@FindBy(xpath = "//button[text()='Img']")
	WebElement imgInside;
	@FindBy(xpath = "//a[.='Insert AfterEnter']")
	WebElement veRightClickInsertAfter;
	@FindBy(xpath = "(//div[@data-element='heading'])[1]|//div[text()='11.1']/following-sibling::div")
	WebElement sectionHeadingVE;
	@FindBy(xpath = "//*[@id='quick-preview-tab']/span[2]")
	WebElement quickPreview;
	@FindBy(xpath = "//ul[@id='tab-list']/li/a/span[2][contains(text(),' Code View ')]")
	WebElement codeView;
	@FindBy(xpath = "//span[@class='jconfirm-title']")
	WebElement contentValidation;
	@FindBy(xpath = "(//input[@class='media-checkbox media-object'])[1]")
	WebElement firstImgInsertPopup;
	@FindBy(xpath = "//button[@id='symbols-tab']")
	WebElement symbolsTab;
	@FindBy(xpath = "//img[@data-flite-marked='1']")
	WebElement imgNewVE;

	public void clickInsertAfterElement() {
		clickElement(insertAfterElement);
	}

	public void clickSymbolsTab() {
		clickElement(symbolsTab);
	}

	public boolean isDisplayedFirstImgInsertPopup() {
		return isElementDisplayed(firstImgInsertPopup);
	}

	public WebElement getFirstImgInsertPopup() {
		return firstImgInsertPopup;
	}

	public WebElement getImgNewVe() {
		return imgNewVE;
	}

	public boolean contentValidationCv() {
		return isElementDisplayed(contentValidation);
	}

	public void clickCodeView() {
		clickElement(codeView);
	}

	public void clickQP() {
		clickByJS(quickPreview);
	}

	public void clickSectionHeadingVE() {
		clickElement(sectionHeadingVE);
	}

	public WebElement getVERightClickInsertAfter() {
		mywait.until(ExpectedConditions.elementToBeClickable(veRightClickInsertAfter));
		return veRightClickInsertAfter;
	}

	public void clickImgInside() {
		mywait.until(ExpectedConditions.elementToBeClickable(imgInside));
		sleepFor(3000);
		clickElement(imgInside);
	}

	public void clickRejectChange() {
		clickElement(rejectChange);
	}

	public WebElement getSelectedCB() {
		mywait.until(ExpectedConditions.elementToBeClickable(selectedCB));
		return selectedCB;
	}

	public void clickUndo() {
		clickElement(undo);
	}

	public void clickFirstPara() {
		clickElement(firstPara);
	}

	public WebElement getDataInformationTc() {
		return dataInformationTc;
	}

	public void clickOnAddressDetailsParaVE() {
		clickElement(addressDetailsParaVE);
	}

	public void clickfirstparaElement() {
		mywait.until(ExpectedConditions.elementToBeClickable(firstPara));
		clickElement(firstPara);
	}

	public void clickDSSection() {
		mywait.until(ExpectedConditions.elementToBeClickable(dsSection)).isDisplayed();
		clickElement(dsSection);
	}

	public void waitForLoaderToDisappear() {
		mywait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("prgress")));
	}

	public void clickOnAddComment() {
		clickElement(scrollRightBtn);
		clickElement(addComment);
	}

	public void enterCommentText() {
		sendKeysWithActions(commentPopupTextArea, "Hello");
	}

	public void clickOnSubmitButton() {
		clickElement(commentSubmit);
	}

	public boolean isElementCommentPopupBoxPresent() {
		return isElementDisplayed(commentPopup);
	}

	public String getCommentedTextHighlighted() {
		return veCommentedText.getCssValue(BACKGROUND_COLOR);
	}

	public void clickRightClickInsertAfterVE() {
		mywait.until(ExpectedConditions.elementToBeClickable(rightClickInsertAfter));
		clickElement(rightClickInsertAfter);
	}

	public void clickOnFootnotePlugin() {
		clickElement(footnote);
	}

	@FindBy(xpath = "//a[@title='Insert Footnote']")
	WebElement footnote;
	@FindBy(xpath = "(//span[@class='cke_voice_label']/following-sibling::iframe)[2]")
	WebElement newFootNoteBox;
	@FindBy(xpath = "//a[@title='OK']")
	WebElement footnoteOkBtn;
	@FindBy(xpath = "(//div[contains(@class,'cite cke_widget_editable')])[1]|(//div[@data-element='footnote'])[1]")
	WebElement bottomFootnote;
	@FindBy(xpath = "//a[@title='Italic (Ctrl+I)']")
	WebElement italic;
	@FindBy(xpath = "//a[.='Element and attributesCtrl+Space']")
	WebElement rightClickChangeElement;

	public void clickOnNewFootNoteBox() {
		clickElement(newFootNoteBox);
	}

	public void clickOnFootnoteOkBtn() {
		clickElement(footnoteOkBtn);
	}

	public WebElement getBottomFootnote() {
		return bottomFootnote;
	}

	public WebElement getItalic() {
		return italic;
	}

	public void clickrightClickChangeElement() {
		clickElement(rightClickChangeElement);
	}
	
	public void clickCeTextField() {
		clickElement(ceTextField);
	}
	
	@FindBy(xpath = "//input[@class='select2-search__field']")
	WebElement ceTextField;
	
	public void enterValueInFootnote() {
		Actions a = new Actions(getDriver);
		a.sendKeys("This is footnote").perform();
	}
	
	@FindBy(xpath = "(//td[@class='td-element'])[1]|(//table[@data-element='table']//td)[1]")
	WebElement insertedTblFirstCell;
	public void clickInsertedTblFirstCell() {
	    clickElement(insertedTblFirstCell);
	}

}
