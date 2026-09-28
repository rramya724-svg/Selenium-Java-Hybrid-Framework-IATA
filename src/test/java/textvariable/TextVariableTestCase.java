package textvariable;

import static org.testng.Assert.assertTrue;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import a_testbase.BaseClass;
import b_utilities.ReusableMethods;
import d_loginpage.BasePage;

public class TextVariableTestCase extends BaseClass {

	// --- Existing constants ---
	private static final String GROUP_TEXT_VARIABLE = "TextVariable";
	private static final String P2_TEXT_VARIABLE = "P2-TextVariable";
	private static final int FRAME_0 = 0;
	private static final int FRAME_1 = 1;
	private static final String ATTRIBUTE_INNER_TEXT = "innerText";
	private static final String ATTRIBUTE_CLASS = "class";
	private static final String ATTRIBUTE_ARIA_DISABLED = "aria-disabled";
	private static final String ATTRIBUTE_PLACEHOLDER = "placeholder";
	private static final String ATTRIBUTE_ID = "id";
	private static final String CONTAINS_ICE_DEL = "ice-del";
	private static final String CONTAINS_FLITE_CONTAINER_ONLY = "flite-container-only";
	private static final String CONTAINS_ELEMENT_TAG_COLOR = "element-tag-color";
	private static final String CONTAINS_ENTITY = "entity";
	private static final String CONTAINS_CKE_WIDGET_ELEMENT = "cke_widget_element";
	private static final String CONTAINS_VARIABLE = "variable";
	private static final String CONTAINS_DEFINITION = "definition";
	private static final String CONTAINS_IMG = "img";
	private static final String CONTAINS_CODES = "codes";
	private static final String INFO_TEXT_VARIABLE_NOT_ALLOWED_IN_TABLE = "Text Variable not allowed inside";
	private static final String INFO_PLEASE_DESELECT_TEXT_BEFORE_ADD_TV = "Please deselect text before adding a text variable";
	private static final String INFO_NO_TEXT_VARIABLE_SELECTED = "No text variable selected";
	private static final String INFO_PLEASE_DESELECT_IMG_BEFORE_ADD_TV = "Please deselect img before adding a text variable";
	private static final String INFO_PLEASE_KINDLY_DESELECT_TV_BEFORE_LISTING = "Please kindly deselect the text variable before proceeding to make a listing";
	private static final String INFO_ADDED_TEXT_VARIABLE = "Added - Text Variable\n"
			+ "Variable Content - All Right Reserved IATA";
	private static final String INFO_DELETED_TEXT_VARIABLE_ALL_RIGHT_RESERVED_IATA = "Deleted - Text Variable\n"
			+ "Variable Content - All Right Reserved IATA";
	private static final String INFO_MESSAGE_VARIABLE_LIST = "Text Variable List";
	private static final String INFO_MESSAGE_SEARCH_TEXT_VARIABLE = "Search Text Variable...";
	private static final String INFO_MESSAGE_CHANGE_TEXT_VARIABLE = "Change Text Variable";
	private static final String COLOR_COMMENT_HIGHLIGHTED = "rgba(249, 211, 59, 1)";
	private static final String CLASS_DISABLED = "disabled";
	private static final String HELLO_TEXT = "Hello";
	private static final String TEST1_TEXT = "Test1";

	// --- New constants for logger messages (reused across methods) ---
	private static final String STARTING_TEST_MSG = "Starting test: ";
	private static final String FINISHED_TEST_MSG = "Test finished: ";
	private static final String CALLING_LOGIN_AND_SEARCH_FILE_TEXT_VARIABLE_CLICK_EDIT_MSG = "Calling loginAndSearchFileTextVariableClickEdit method.";
	private static final String CALLING_LOGIN_AND_SEARCH_FILE_CLICK_EDIT_MSG = "Calling loginAndSearchFileClickEdit method.";
	private static final String INSTANTIATED_TEXT_VARIABLE_OBJECT_MSG = "Instantiated TextVariable object.";
	private static final String WAITING_FOR_LOADER_TO_DISAPPEAR_MSG = "Waiting for loader to disappear.";
	private static final String SWITCHING_TO_FRAME_0_MSG = "Switching to frame 0.";
	private static final String SWITCHING_TO_FRAME_1_MSG = "Switching to frame 1.";
	private static final String SWITCHING_TO_DEFAULT_CONTENT_MSG = "Switching to default content.";
	private static final String CLICKING_DS_SECTION_MSG = "Clicking DS Section.";
	private static final String CLICKING_FIRST_PARA_MSG = "Clicking first paragraph.";
	private static final String CLICKING_TEXT_VARIABLE_PLUGIN_MSG = "Clicking Text Variable plugin.";
	private static final String CLICKING_ENTITY_CHECKBOX_1_MSG = "Clicking entity checkbox 1.";
	private static final String CLICKING_VARIABLE_INSERT_BTN_MSG = "Clicking Variable Insert button.";
	private static final String CLICKING_ACCEPT_CHANGE_MSG = "Clicking Accept Change.";
	private static final String CLICKING_REJECT_CHANGE_MSG = "Clicking Reject Change.";
	private static final String CLICKING_TRACK_CHANGE_MSG = "Clicking Track Change.";
	private static final String CLICKING_UNDO_PLUGIN_MSG = "Clicking Undo plugin.";
	private static final String CLICKING_UNDO_MSG = "Clicking Undo.";
	private static final String CLICKING_COPY_BUTTON_MSG = "Clicking Copy button.";
	private static final String CLICKING_PASTE_BUTTON_MSG = "Clicking Paste button.";
	private static final String CLICKING_ON_ACCEPT_CHANGES_MSG = "Clicking on Accept Changes.";
	private static final String CLICKING_ON_REJECT_CHANGES_MSG = "Clicking on Reject Changes.";
	private static final String CLICKING_ON_ADD_COMMENT_MSG = "Clicking on Add Comment.";
	private static final String ENTERING_COMMENT_TEXT_MSG = "Entering comment text.";
	private static final String CLICKING_ON_SUBMIT_BUTTON_MSG = "Clicking on Submit button.";
	private static final String CLICKING_ON_CROSS_REF_BUTTON_MSG = "Clicking on Cross Reference button.";
	private static final String CLICKING_ELEMENTS_AND_ATTRIBUTE_TAB_MSG = "Clicking Elements and Attribute tab.";
	private static final String CLICKING_INSERT_PLUGIN_MSG = "Clicking Insert Plugin.";
	private static final String CLICKING_INSERT_INTO_ELEMENT_MSG = "Clicking Insert Into Element.";
	private static final String CLICKING_VARIABLE_QUICK_INSERT_MSG = "Clicking Variable Quick Insert.";
	private static final String CLICKING_INSERT_BUTTON_MSG = "Clicking Insert button.";
	private static final String CLICKING_IMG_INSERT_FROM_INSERT_PLUGIN_MSG = "Clicking Image Insert from Insert Plugin.";
	private static final String CLICKING_IMG_INSIDE_MSG = "Clicking img inside.";
	private static final String CLICKING_SYMBOLS_TAB_MSG = "Clicking Symbols tab.";
	private static final String CLICKING_INSERT_AFTER_ELEMENT_MSG = "Clicking Insert After Element.";
	private static final String CLICKING_VE_FIRST_PARA_MSG = "Clicking VE first paragraph.";
	private static final String CLICKING_VE_3RD_PARA_MSG = "Clicking VE 3rd paragraph.";
	private static final String CLICKING_VE_MIDDLE_PARA_MSG = "Clicking VE middle paragraph.";
	private static final String CLICKING_SECOND_PARA_CB_MSG = "Clicking second paragraph CB.";
	private static final String CLICKING_DS_2_PARA_MSG = "Clicking DS 2nd paragraph.";
	private static final String CLICKING_DS_NOTE_MSG = "Clicking DS note.";
	private static final String CLICKING_ON_TRACK_CHANGE_BUTTON_MSG = "Clicking on Track Change button.";
	private static final String RIGHT_CLICKING_FIRST_PARA_MSG = "Right clicking first paragraph.";
	private static final String RIGHT_CLICKING_ON_DS_NOTE_MSG = "Right clicking on DS note.";
	private static final String RIGHT_CLICKING_ON_DS_B_MSG = "Right clicking on DS b element.";
	private static final String DOUBLE_CLICKING_FIRST_PARA_MSG = "Double clicking first paragraph.";
	private static final String CLICKING_DS_INSERT_INTO_MSG = "Clicking DS Insert Into.";
	private static final String CLICKING_DS_INSERT_AFTER_MSG = "Clicking DS Insert After.";
	private static final String CLICKING_DS_RIGHT_CLICK_INSERT_AFTER_MSG = "Clicking DS Right Click Insert After.";
	private static final String CLICKING_DS_RIGHT_CLICK_SECTION_MSG = "Clicking DS Right Click Section.";
	private static final String CLICKING_ON_INSERT_AFTER_DS_MSG = "Clicking on Insert After DS.";
	private static final String CLICKING_RIGHT_CLICK_INSERT_AFTER_VE_MSG = "Clicking Right Click Insert After VE.";
	private static final String CLICKING_RC_POPUP_VARIABLE_ELEMENT_MSG = "Clicking RC popup variable element.";
	private static final String CLICKING_INSERT_INTO_DS_MSG = "Clicking Insert Into DS.";
	private static final String CLICKING_ADDRESS_IN_LIST_MSG = "Clicking Address in list.";
	private static final String CLICKING_FIGURE_IN_LIST_MSG = "Clicking Figure in list.";
	private static final String CLICKING_INSERT_ELEMENT_BUTTON_MSG = "Clicking Insert Element button.";
	private static final String CLICKING_INSERT_ELEMENT_BTN_MSG = "Clicking Insert Element button.";
	private static final String CLICKING_INSERT_AFTER_NOTES_MSG = "Clicking Insert After Notes.";
	private static final String CLICKING_INSERT_AFTER_NUMBERED_PARA_MSG = "Clicking Insert After Numbered Para.";
	private static final String CLICKING_NUMBER_LIST_MSG = "Clicking Number List.";
	private static final String CLICKING_ON_BOLD_BUTTON_MSG = "Clicking on Bold button.";
	private static final String CLICKING_ON_INLINE_IMAGE_VE_MSG = "Clicking on inline image VE.";
	private static final String CLICKING_ON_INLINE_IMAGE_DS_MSG = "Clicking on inline image DS.";
	private static final String CLICKING_VARIABLE_CANCEL_BTN_MSG = "Clicking Variable Cancel button.";
	private static final String CLICKING_QP_MSG = "Clicking Quick Preview.";
	private static final String CLICKING_CODE_VIEW_MSG = "Clicking Code View.";
	private static final String CLICKING_FIND_AND_REPLACE_PLUGIN_MSG = "Clicking Find and Replace plugin.";
	private static final String CLICKING_LIST_PLUGIN_MSG = "Clicking List plugin.";
	private static final String SENDING_LEFT_KEY_ITERATION_MSG = "Sending LEFT key. Iteration: {}";
	private static final String SENDING_ENTER_KEY_MSG = "Sending ENTER key.";
	private static final String SENDING_BACK_SPACE_KEY_MSG = "Sending BACK_SPACE key.";
	private static final String SENDING_DELETE_KEY_MSG = "Sending DELETE key.";
	private static final String SENDING_UP_KEY_MSG = "Sending UP key.";
	private static final String SENDING_ARROW_DOWN_KEY_MSG = "Sending ARROW_DOWN key.";
	private static final String SENDING_ARROW_UP_KEY_MSG = "Sending ARROW_UP key.";
	private static final String SENDING_ARROW_LEFT_KEY_MSG = "Sending ARROW_LEFT key.";
	private static final String SENDING_KEYS_VARIABLE_TEXT_MSG = "Sending 'variable' text.";
	private static final String SENDING_KEYS_IMG_TEXT_MSG = "Sending 'img' text.";
	private static final String SENDING_KEYS_CODES_TEXT_MSG = "Sending 'codes' text.";
	private static final String SENDING_KEYS_HELLO_TEXT_MSG = "Sending 'Hello' text.";
	private static final String SENDING_KEYS_TEST1_TEXT_MSG = "Sending 'Test1' text.";
	private static final String SENDING_KEYS_DEFINITION_TEXT_MSG = "Sending 'definition' text.";
	private static final String PERFORMING_CTRL_C_MSG = "Performing CTRL+C to copy.";
	private static final String PERFORMING_CTRL_V_MSG = "Performing CTRL+V to paste.";
	private static final String PERFORMING_CTRL_X_MSG = "Performing CTRL+X to cut.";
	private static final String PRESSING_TAB_KEY_MSG = "Pressing TAB key.";
	private static final String PRESSING_ENTER_KEY_MSG = "Pressing ENTER key.";
	private static final String GETTING_BOOTSTRAP_ALERT_TEXT_MSG = "Getting bootstrap alert text.";
	private static final String ASSERTING_TRUE_MSG = "Asserting condition is true.";
	private static final String ASSERTING_FALSE_MSG = "Asserting condition is false.";
	private static final String ASSERTING_EQUALS_MSG = "Asserting equality.";
	private static final String ASSERTING_VARIABLE_INSERTED_IN_VE_MSG = "Asserting variable inserted in VE.";
	private static final String ASSERTING_VARIABLE_INSERTED_IN_AP_MSG = "Asserting variable inserted in AP.";
	private static final String ASSERTING_VARIABLE_PRESENT_IN_FIND_PLUGIN_MSG = "Asserting variable input in Find plugin.";
	private static final String ASSERTING_VARIABLE_POPUP_DISPLAYED_MSG = "Asserting variable popup displayed.";
	private static final String ASSERTING_SEARCH_OPTION_IN_VARIABLE_POPUP_MSG = "Asserting search option in variable popup.";
	private static final String ASSERTING_NEW_SECTION_DS_MSG = "Asserting new section in DS.";
	private static final String ASSERTING_DELETED_VARIABLE_CLASS_MSG = "Asserting deleted variable class contains expected values.";
	private static final String ASSERTING_VARIABLE_PASTED_IN_VE_MSG = "Asserting variable pasted in VE.";
	private static final String ASSERTING_VARIABLE_DEFINITION_VE_MSG = "Asserting variable definition in VE.";
	private static final String ASSERTING_ELEMENT_COMMENT_POPUP_BOX_PRESENT_MSG = "Asserting comment popup box is present.";
	private static final String ASSERTING_RIGHT_CLICK_ELEMENTS_ATTRIBUTE_NOT_PRESENT_MSG = "Asserting right click elements attribute not present.";
	private static final String ASSERTING_ATTRIBUTE_NAME_CONTAINS_VARIABLE_MSG = "Asserting attribute name contains 'variable'.";
	private static final String ASSERTING_BREADCRUMB_CONTAINS_VARIABLE_MSG = "Asserting breadcrumb contains 'variable'.";
	private static final String ASSERTING_IMAGE_PLUGIN_DISABLED_MSG = "Asserting image plugin is disabled.";
	private static final String ASSERTING_SYMBOL_PLUGIN_DISABLED_MSG = "Asserting symbol plugin is disabled.";
	private static final String ASSERTING_CHANGE_TEXT_VARIABLE_OPTION_PRESENT_MSG = "Asserting Change Text Variable option present.";
	private static final String ASSERTING_DATA_CARD_PRESENT_MSG = "Asserting data card is present.";
	private static final String ASSERTING_TC_CARD_DETAILS_CONTAINS_ADDED_MSG = "Asserting TC card details contain added text variable info.";
	private static final String ASSERTING_VE_TEXT_VARIABLE_AFTER_BOLD_MSG = "Asserting VE text variable after bold is present.";
	private static final String ASSERTING_VARIABLE_LIST_POPUP_DISPLAYED_MSG = "Asserting variable list popup displayed.";
	private static final String ASSERTING_RC_POPUP_VARIABLE_ELEMENT_MSG = "Asserting RC popup variable element is present.";
	private static final String ASSERTING_NEW_INSERTED_LI_DS_PRESENT_MSG = "Asserting new inserted li in DS is present.";
	private static final String ASSERTING_NEWLY_INSERTED_FIRST_PARA_CB_MSG = "Asserting newly inserted first paragraph CB is present.";
	private static final String ASSERTING_NEW_PARA_VE_PRESENT_MSG = "Asserting new paragraph VE is present.";
	private static final String ASSERTING_TEXT_VARIABLE_PLUGIN_ENABLED_MSG = "Asserting text variable plugin is enabled.";
	private static final String INSTANTIATED_ACTIONS_OBJECT_MSG = "Instantiated Actions object.";
	private static final String INSTANTIATED_BASE_PAGE_OBJECT_MSG = "Instantiated BasePage object.";
	public static final String SENDING_HOME_KEY_MSG = "Sending Home key";
	public static final String CLICKING_FIRST_PARAGRAPH = "Clicking first paragraph.";
	public static final String CONTEXT_CLICKING_FIRST_PARAGRAPH_CB = "Context clicking first paragraph CB.";
	public static final String CLICKING_NEWLY_INSERTED_VARIABLE_VE = "Clicking newly inserted variable VE.";
	public static final String RIGHT_CLICKING_ON_VE_FIRST_PARA = "Right clicking on VE first para.";
	public static final String CLICKING_ACCEPT_CHANGE = "Clicking Accept Change.";
	public static final String RIGHT_CLICKING_ON_NEWLY_INSERTED_VARIABLE_VE = "Right clicking on newly inserted variable VE.";
	private static final String CLICKING_MIDDLE_SECTION_MSG = "Clicking middle section.";

	
	
	@Test(enabled = true, groups = { GROUP_TEXT_VARIABLE, P2_TEXT_VARIABLE })
	public void verifyVariableTextInFindPlugin() {
		logger.info(STARTING_TEST_MSG + "verifyVariableTextInFindPlugin");
		logger.debug(CALLING_LOGIN_AND_SEARCH_FILE_TEXT_VARIABLE_CLICK_EDIT_MSG);
		ReusableMethods.loginAndSearchFileTextVariableClickEdit();
		logger.debug(INSTANTIATED_TEXT_VARIABLE_OBJECT_MSG);
		TextVariablePageObjects tv = new TextVariablePageObjects(getDriver());
		logger.debug(WAITING_FOR_LOADER_TO_DISAPPEAR_MSG);
		tv.waitForLoaderToDisappear();
		logger.debug(CLICKING_DS_SECTION_MSG);
		tv.clickDSSection();
		logger.debug(CLICKING_FIRST_PARA_MSG);
		tv.clickfirstparaElement();
		logger.debug(CLICKING_TEXT_VARIABLE_PLUGIN_MSG);
		tv.clickTextVariablePlugin();
		logger.debug(CLICKING_ENTITY_CHECKBOX_1_MSG);
		tv.clickEntityCheckbox1();
		logger.debug(CLICKING_VARIABLE_INSERT_BTN_MSG);
		tv.clickVariableInsertBtn();
		logger.debug(SWITCHING_TO_FRAME_0_MSG);
		getDriver().switchTo().frame(FRAME_0);
		logger.debug(ASSERTING_VARIABLE_INSERTED_IN_VE_MSG);
		Assert.assertTrue(tv.isNewlyInsertedVariableVE());
		logger.debug(SWITCHING_TO_DEFAULT_CONTENT_MSG);
		getDriver().switchTo().defaultContent();
		logger.debug(ASSERTING_VARIABLE_INSERTED_IN_AP_MSG);
		Assert.assertTrue(tv.isNewlyInsertedVariableAP());
		logger.debug(CLICKING_FIND_AND_REPLACE_PLUGIN_MSG);
		tv.clickFindAndReplacePlugin();
		logger.debug(ASSERTING_VARIABLE_PRESENT_IN_FIND_PLUGIN_MSG);
		Assert.assertTrue(tv.isVariableInputInFindPlugin());
		logger.info(FINISHED_TEST_MSG + "verifyVariableTextInFindPlugin");
	}

	@Test(enabled = true, groups = { GROUP_TEXT_VARIABLE, P2_TEXT_VARIABLE })
	public void verifyVariableTextInTable() {
		logger.info(STARTING_TEST_MSG + "verifyVariableTextInTable");
		logger.debug(CALLING_LOGIN_AND_SEARCH_FILE_TEXT_VARIABLE_CLICK_EDIT_MSG);
		ReusableMethods.loginAndSearchFileTextVariableClickEdit();
		logger.debug("Inserting table via ReusableMethods.");
		ReusableMethods.insertTableCB();
		logger.debug(INSTANTIATED_ACTIONS_OBJECT_MSG);
		Actions action = new Actions(getDriver());
		logger.debug(SENDING_ARROW_LEFT_KEY_MSG);
		action.sendKeys(Keys.ARROW_LEFT).perform();
		logger.debug(INSTANTIATED_TEXT_VARIABLE_OBJECT_MSG);
		TextVariablePageObjects tv = new TextVariablePageObjects(getDriver());
		logger.debug(CLICKING_TEXT_VARIABLE_PLUGIN_MSG);
		tv.clickTextVariablePlugin();
		logger.debug(GETTING_BOOTSTRAP_ALERT_TEXT_MSG);
		boolean flag = tv.getBootstrapAlert().getAttribute(ATTRIBUTE_INNER_TEXT)
				.contains(INFO_TEXT_VARIABLE_NOT_ALLOWED_IN_TABLE);
		logger.debug(ASSERTING_TRUE_MSG);
		assertTrue(flag);
		logger.info(FINISHED_TEST_MSG + "verifyVariableTextInTable");
	}

	@Test(enabled = true, groups = { GROUP_TEXT_VARIABLE, P2_TEXT_VARIABLE })
	public void verifyPlaceCursorBeforeVariableAndDelete() {
		logger.info(STARTING_TEST_MSG + "verifyPlaceCursorBeforeVariableAndDelete");
		logger.debug(CALLING_LOGIN_AND_SEARCH_FILE_TEXT_VARIABLE_CLICK_EDIT_MSG);
		ReusableMethods.loginAndSearchFileTextVariableClickEdit();
		logger.debug(INSTANTIATED_TEXT_VARIABLE_OBJECT_MSG);
		TextVariablePageObjects tv = new TextVariablePageObjects(getDriver());
		logger.debug(WAITING_FOR_LOADER_TO_DISAPPEAR_MSG);
		tv.waitForLoaderToDisappear();
		logger.debug(CLICKING_DS_SECTION_MSG);
		tv.clickDSSection();
		logger.debug(CLICKING_FIRST_PARA_MSG);
		tv.clickfirstparaElement();
		logger.debug(CLICKING_TEXT_VARIABLE_PLUGIN_MSG);
		tv.clickTextVariablePlugin();
		logger.debug(CLICKING_ENTITY_CHECKBOX_1_MSG);
		tv.clickEntityCheckbox1();
		logger.debug(CLICKING_VARIABLE_INSERT_BTN_MSG);
		tv.clickVariableInsertBtn();
		logger.debug(CLICKING_ACCEPT_CHANGE_MSG);
		tv.clickAcceptChange();
		logger.debug(SWITCHING_TO_FRAME_0_MSG);
		getDriver().switchTo().frame(FRAME_0);
		logger.debug(ASSERTING_VARIABLE_INSERTED_IN_VE_MSG);
		Assert.assertTrue(tv.isNewlyInsertedVariableVE());
		logger.debug(INSTANTIATED_ACTIONS_OBJECT_MSG);
		Actions action = new Actions(getDriver());
		logger.debug(SENDING_DELETE_KEY_MSG);
		action.sendKeys(Keys.DELETE).perform();
		logger.debug(ASSERTING_DELETED_VARIABLE_CLASS_MSG);
		Assert.assertTrue(tv.getDeletedInsertedVariableVE().getAttribute(ATTRIBUTE_CLASS)
				.contains(CONTAINS_ICE_DEL + " " + CONTAINS_FLITE_CONTAINER_ONLY));
		logger.info(FINISHED_TEST_MSG + "verifyPlaceCursorBeforeVariableAndDelete");
	}

	@Test(enabled = true, groups = { GROUP_TEXT_VARIABLE, P2_TEXT_VARIABLE })
	public void verifyInsertVariableInText() {
		logger.info(STARTING_TEST_MSG + "verifyInsertVariableInText");
		logger.debug(CALLING_LOGIN_AND_SEARCH_FILE_TEXT_VARIABLE_CLICK_EDIT_MSG);
		ReusableMethods.loginAndSearchFileTextVariableClickEdit();
		logger.debug(INSTANTIATED_TEXT_VARIABLE_OBJECT_MSG);
		TextVariablePageObjects tv = new TextVariablePageObjects(getDriver());
		logger.debug(SWITCHING_TO_FRAME_0_MSG);
		getDriver().switchTo().frame(FRAME_0);
		logger.debug(CLICKING_VE_FIRST_PARA_MSG);
		tv.clickVEFirstPara();
		logger.debug(SWITCHING_TO_DEFAULT_CONTENT_MSG);
		getDriver().switchTo().defaultContent();
		logger.debug(CLICKING_TEXT_VARIABLE_PLUGIN_MSG);
		tv.clickTextVariablePlugin();
		logger.debug(CLICKING_ENTITY_CHECKBOX_1_MSG);
		tv.clickEntityCheckbox1();
		logger.debug(CLICKING_VARIABLE_INSERT_BTN_MSG);
		tv.clickVariableInsertBtn();
		logger.debug(SWITCHING_TO_FRAME_0_MSG);
		getDriver().switchTo().frame(FRAME_0);
		logger.debug(ASSERTING_VARIABLE_INSERTED_IN_VE_MSG);
		Assert.assertTrue(tv.isNewlyInsertedVariableVE());
		logger.debug(SWITCHING_TO_DEFAULT_CONTENT_MSG);
		getDriver().switchTo().defaultContent();
		logger.debug(INSTANTIATED_ACTIONS_OBJECT_MSG);
		Actions action = new Actions(getDriver());
		logger.debug(SENDING_KEYS_HELLO_TEXT_MSG);
		action.sendKeys(HELLO_TEXT).perform();
		logger.debug(CLICKING_TRACK_CHANGE_MSG);
		tv.clickTrackChange();
		logger.debug(ASSERTING_TRUE_MSG);
		Assert.assertTrue(tv.isElementPresentCardNumberOne());
		logger.info(FINISHED_TEST_MSG + "verifyInsertVariableInText");
	}

	@Test(enabled = true, groups = { GROUP_TEXT_VARIABLE, P2_TEXT_VARIABLE })
	public void verifySelectCompleteParaWithtextVariableAndBackspace() {
		logger.info(STARTING_TEST_MSG + "verifySelectCompleteParaWithtextVariableAndBackspace");
		logger.debug(CALLING_LOGIN_AND_SEARCH_FILE_TEXT_VARIABLE_CLICK_EDIT_MSG);
		ReusableMethods.loginAndSearchFileTextVariableClickEdit();
		logger.debug(INSTANTIATED_TEXT_VARIABLE_OBJECT_MSG);
		TextVariablePageObjects tv = new TextVariablePageObjects(getDriver());
		logger.debug(SWITCHING_TO_FRAME_0_MSG);
		getDriver().switchTo().frame(FRAME_0);
		logger.debug(CLICKING_VE_FIRST_PARA_MSG);
		tv.clickVEFirstPara();
		logger.debug(SWITCHING_TO_DEFAULT_CONTENT_MSG);
		getDriver().switchTo().defaultContent();
		logger.debug(CLICKING_TEXT_VARIABLE_PLUGIN_MSG);
		tv.clickTextVariablePlugin();
		logger.debug(CLICKING_ENTITY_CHECKBOX_1_MSG);
		tv.clickEntityCheckbox1();
		logger.debug(CLICKING_VARIABLE_INSERT_BTN_MSG);
		tv.clickVariableInsertBtn();
		logger.debug(SWITCHING_TO_FRAME_0_MSG);
		getDriver().switchTo().frame(FRAME_0);
		logger.debug(ASSERTING_FALSE_MSG);
		Assert.assertFalse(tv.isNewlyInsertedVariableVE());
		logger.debug(SWITCHING_TO_DEFAULT_CONTENT_MSG);
		getDriver().switchTo().defaultContent();
		logger.info(FINISHED_TEST_MSG + "verifySelectCompleteParaWithtextVariableAndBackspace");
	}

	@Test(enabled = true, groups = { GROUP_TEXT_VARIABLE, P2_TEXT_VARIABLE })
	public void verifyChangetextVariableToListAndCheckInfo() {
		logger.info(STARTING_TEST_MSG + "verifyChangetextVariableToListAndCheckInfo");
		logger.debug(CALLING_LOGIN_AND_SEARCH_FILE_TEXT_VARIABLE_CLICK_EDIT_MSG);
		ReusableMethods.loginAndSearchFileTextVariableClickEdit();
		logger.debug(INSTANTIATED_TEXT_VARIABLE_OBJECT_MSG);
		TextVariablePageObjects tv = new TextVariablePageObjects(getDriver());
		logger.debug(SWITCHING_TO_FRAME_0_MSG);
		getDriver().switchTo().frame(FRAME_0);
		logger.debug(CLICKING_VE_FIRST_PARA_MSG);
		tv.clickVEFirstPara();
		logger.debug(SWITCHING_TO_DEFAULT_CONTENT_MSG);
		getDriver().switchTo().defaultContent();
		logger.debug(CLICKING_TEXT_VARIABLE_PLUGIN_MSG);
		tv.clickTextVariablePlugin();
		logger.debug(CLICKING_ENTITY_CHECKBOX_1_MSG);
		tv.clickEntityCheckbox1();
		logger.debug(CLICKING_VARIABLE_INSERT_BTN_MSG);
		tv.clickVariableInsertBtn();
		logger.debug(SWITCHING_TO_FRAME_0_MSG);
		getDriver().switchTo().frame(FRAME_0);
		logger.debug(ASSERTING_VARIABLE_INSERTED_IN_VE_MSG);
		Assert.assertTrue(tv.isNewlyInsertedVariableVE());
		logger.debug(SWITCHING_TO_DEFAULT_CONTENT_MSG);
		getDriver().switchTo().defaultContent();
		logger.debug(CLICKING_LIST_PLUGIN_MSG);
		tv.clickListPlugin();
		logger.debug(GETTING_BOOTSTRAP_ALERT_TEXT_MSG);
		boolean flag = tv.getBootstrapAlert().getAttribute(ATTRIBUTE_INNER_TEXT)
				.contains(INFO_PLEASE_KINDLY_DESELECT_TV_BEFORE_LISTING);
		logger.debug(ASSERTING_TRUE_MSG);
		assertTrue(flag);
		logger.info(FINISHED_TEST_MSG + "verifyChangetextVariableToListAndCheckInfo");
	}

	@Test(enabled = true, groups = { GROUP_TEXT_VARIABLE, P2_TEXT_VARIABLE })
	public void verifytextVariablePopupAndSpelling() {
		logger.info(STARTING_TEST_MSG + "verifytextVariablePopupAndSpelling");
		logger.debug(CALLING_LOGIN_AND_SEARCH_FILE_TEXT_VARIABLE_CLICK_EDIT_MSG);
		ReusableMethods.loginAndSearchFileTextVariableClickEdit();
		logger.debug(INSTANTIATED_TEXT_VARIABLE_OBJECT_MSG);
		TextVariablePageObjects tv = new TextVariablePageObjects(getDriver());
		logger.debug(WAITING_FOR_LOADER_TO_DISAPPEAR_MSG);
		tv.waitForLoaderToDisappear();
		logger.debug(SWITCHING_TO_FRAME_0_MSG);
		getDriver().switchTo().frame(FRAME_0);
		logger.debug(CLICKING_VE_FIRST_PARA_MSG);
		tv.clickVEFirstPara();
		logger.debug(SWITCHING_TO_DEFAULT_CONTENT_MSG);
		getDriver().switchTo().defaultContent();
		logger.debug(CLICKING_TEXT_VARIABLE_PLUGIN_MSG);
		tv.clickTextVariablePlugin();
		logger.debug(ASSERTING_VARIABLE_POPUP_DISPLAYED_MSG);
		Assert.assertTrue(tv.isVariablePopup());
		boolean flag = tv.getVariablePopup().getAttribute(ATTRIBUTE_INNER_TEXT).contains(INFO_MESSAGE_VARIABLE_LIST);
		logger.debug(ASSERTING_TRUE_MSG);
		assertTrue(flag);
		logger.info(FINISHED_TEST_MSG + "verifytextVariablePopupAndSpelling");
	}

	@Test(enabled = true, groups = { GROUP_TEXT_VARIABLE, P2_TEXT_VARIABLE })
	public void verifyCheckSearchOptionsInVariablePopup() {
		logger.info(STARTING_TEST_MSG + "verifyCheckSearchOptionsInVariablePopup");
		logger.debug(CALLING_LOGIN_AND_SEARCH_FILE_TEXT_VARIABLE_CLICK_EDIT_MSG);
		ReusableMethods.loginAndSearchFileTextVariableClickEdit();
		logger.debug(INSTANTIATED_TEXT_VARIABLE_OBJECT_MSG);
		TextVariablePageObjects tv = new TextVariablePageObjects(getDriver());
		logger.debug(WAITING_FOR_LOADER_TO_DISAPPEAR_MSG);
		tv.waitForLoaderToDisappear();
		logger.debug(SWITCHING_TO_FRAME_0_MSG);
		getDriver().switchTo().frame(FRAME_0);
		logger.debug(CLICKING_VE_FIRST_PARA_MSG);
		tv.clickVEFirstPara();
		logger.debug(SWITCHING_TO_DEFAULT_CONTENT_MSG);
		getDriver().switchTo().defaultContent();
		logger.debug(CLICKING_TEXT_VARIABLE_PLUGIN_MSG);
		tv.clickTextVariablePlugin();
		logger.debug(CLICKING_ENTITY_CHECKBOX_1_MSG);
		tv.clickEntityCheckbox1();
		logger.debug(CLICKING_VARIABLE_INSERT_BTN_MSG);
		tv.clickVariableInsertBtn();
		logger.debug(SWITCHING_TO_FRAME_0_MSG);
		getDriver().switchTo().frame(FRAME_0);
		logger.debug(ASSERTING_VARIABLE_INSERTED_IN_VE_MSG);
		Assert.assertTrue(tv.isNewlyInsertedVariableVE());
		logger.debug(SWITCHING_TO_DEFAULT_CONTENT_MSG);
		getDriver().switchTo().defaultContent();
		logger.debug(CLICKING_FIRST_PARA_MSG);
		tv.clickfirstparaElement();
		logger.debug(CLICKING_TEXT_VARIABLE_PLUGIN_MSG);
		tv.clickTextVariablePlugin();
		logger.debug(ASSERTING_SEARCH_OPTION_IN_VARIABLE_POPUP_MSG);
		Assert.assertTrue(tv.isSearchOptionInVariablePopup());
		logger.info(FINISHED_TEST_MSG + "verifyCheckSearchOptionsInVariablePopup");
	}

	@Test(enabled = true, groups = { GROUP_TEXT_VARIABLE, P2_TEXT_VARIABLE })
	public void verifyClikingOnInsertBtnByNotSeletingVariableCheckInfo() {
		logger.info(STARTING_TEST_MSG + "verifyClikingOnInsertBtnByNotSeletingVariableCheckInfo");
		logger.debug(CALLING_LOGIN_AND_SEARCH_FILE_TEXT_VARIABLE_CLICK_EDIT_MSG);
		ReusableMethods.loginAndSearchFileTextVariableClickEdit();
		logger.debug(INSTANTIATED_TEXT_VARIABLE_OBJECT_MSG);
		TextVariablePageObjects tv = new TextVariablePageObjects(getDriver());
		logger.debug(WAITING_FOR_LOADER_TO_DISAPPEAR_MSG);
		tv.waitForLoaderToDisappear();
		logger.debug(SWITCHING_TO_FRAME_0_MSG);
		getDriver().switchTo().frame(FRAME_0);
		logger.debug(CLICKING_VE_FIRST_PARA_MSG);
		tv.clickVEFirstPara();
		logger.debug(SWITCHING_TO_DEFAULT_CONTENT_MSG);
		getDriver().switchTo().defaultContent();
		logger.debug(CLICKING_TEXT_VARIABLE_PLUGIN_MSG);
		tv.clickTextVariablePlugin();
		logger.debug(CLICKING_VARIABLE_INSERT_BTN_MSG);
		tv.clickVariableInsertBtn();
		logger.debug(GETTING_BOOTSTRAP_ALERT_TEXT_MSG);
		boolean flag = tv.getBootstrapAlert().getAttribute(ATTRIBUTE_INNER_TEXT)
				.contains(INFO_NO_TEXT_VARIABLE_SELECTED);
		logger.debug(ASSERTING_TRUE_MSG);
		assertTrue(flag);
		logger.info(FINISHED_TEST_MSG + "verifyClikingOnInsertBtnByNotSeletingVariableCheckInfo");
	}

	@Test(enabled = true, groups = { GROUP_TEXT_VARIABLE, P2_TEXT_VARIABLE })
	public void verifyRightClickInsertIntotextVariableAndCheckPopupVisible() {
		logger.info(STARTING_TEST_MSG + "verifyRightClickInsertIntotextVariableAndCheckPopupVisible");
		logger.debug(CALLING_LOGIN_AND_SEARCH_FILE_TEXT_VARIABLE_CLICK_EDIT_MSG);
		ReusableMethods.loginAndSearchFileTextVariableClickEdit();
		logger.debug(INSTANTIATED_TEXT_VARIABLE_OBJECT_MSG);
		TextVariablePageObjects tv = new TextVariablePageObjects(getDriver());
		logger.debug(WAITING_FOR_LOADER_TO_DISAPPEAR_MSG);
		tv.waitForLoaderToDisappear();
		logger.debug(CLICKING_DS_SECTION_MSG);
		tv.clickDSSection();
		logger.debug(CLICKING_FIRST_PARA_MSG);
		tv.clickfirstparaElement();
		logger.debug(INSTANTIATED_ACTIONS_OBJECT_MSG);
		Actions action = new Actions(getDriver());
		WebElement getFirstParaDS = tv.getFirstParaCB();
		logger.debug("Context clicking on first paragraph DS.");
		action.contextClick(getFirstParaDS).perform();
		logger.debug(CLICKING_DS_INSERT_INTO_MSG);
		tv.clickDSInsertInto();
		logger.debug(SENDING_KEYS_VARIABLE_TEXT_MSG);
		action.sendKeys(CONTAINS_VARIABLE).perform();
		logger.debug(PRESSING_TAB_KEY_MSG);
		action.sendKeys(Keys.TAB).perform();
		logger.debug(PRESSING_ENTER_KEY_MSG);
		action.sendKeys(Keys.ENTER).perform();
		logger.debug(CLICKING_TEXT_VARIABLE_PLUGIN_MSG);
		tv.clickTextVariablePlugin();
		logger.debug(ASSERTING_VARIABLE_POPUP_DISPLAYED_MSG);
		Assert.assertTrue(tv.isVariablePopup());
		logger.info(FINISHED_TEST_MSG + "verifyRightClickInsertIntotextVariableAndCheckPopupVisible");
	}

	@Test(enabled = true, groups = { GROUP_TEXT_VARIABLE, P2_TEXT_VARIABLE })
	public void verifySelectedTextAndInsertVariableCheckInfo() {
		logger.info(STARTING_TEST_MSG + "verifySelectedTextAndInsertVariableCheckInfo");
		logger.debug(CALLING_LOGIN_AND_SEARCH_FILE_TEXT_VARIABLE_CLICK_EDIT_MSG);
		ReusableMethods.loginAndSearchFileTextVariableClickEdit();
		logger.debug(INSTANTIATED_TEXT_VARIABLE_OBJECT_MSG);
		TextVariablePageObjects tv = new TextVariablePageObjects(getDriver());
		logger.debug(WAITING_FOR_LOADER_TO_DISAPPEAR_MSG);
		tv.waitForLoaderToDisappear();
		logger.debug(SWITCHING_TO_FRAME_0_MSG);
		getDriver().switchTo().frame(FRAME_0);
		logger.debug(DOUBLE_CLICKING_FIRST_PARA_MSG);
		tv.doubleClickFirstParaVE();
		logger.debug(SWITCHING_TO_DEFAULT_CONTENT_MSG);
		getDriver().switchTo().defaultContent();
		logger.debug(CLICKING_TEXT_VARIABLE_PLUGIN_MSG);
		tv.clickTextVariablePlugin();
		logger.debug(GETTING_BOOTSTRAP_ALERT_TEXT_MSG);
		boolean flag = tv.getBootstrapAlert().getAttribute(ATTRIBUTE_INNER_TEXT)
				.contains(INFO_PLEASE_DESELECT_TEXT_BEFORE_ADD_TV);
		logger.debug(ASSERTING_TRUE_MSG);
		assertTrue(flag);
		logger.info(FINISHED_TEST_MSG + "verifySelectedTextAndInsertVariableCheckInfo");
	}

	@Test(enabled = true, groups = { GROUP_TEXT_VARIABLE, P2_TEXT_VARIABLE })
	public void verifyinsertVariableInNewSectionHeadingCheckCursor() {
		logger.info(STARTING_TEST_MSG + "verifyinsertVariableInNewSectionHeadingCheckCursor");
		logger.debug(CALLING_LOGIN_AND_SEARCH_FILE_TEXT_VARIABLE_CLICK_EDIT_MSG);
		ReusableMethods.loginAndSearchFileTextVariableClickEdit();
		logger.debug(INSTANTIATED_TEXT_VARIABLE_OBJECT_MSG);
		TextVariablePageObjects tv = new TextVariablePageObjects(getDriver());
		logger.debug(WAITING_FOR_LOADER_TO_DISAPPEAR_MSG);
		tv.waitForLoaderToDisappear();
		logger.debug(INSTANTIATED_ACTIONS_OBJECT_MSG);
		Actions action = new Actions(getDriver());
		logger.debug(CLICKING_MIDDLE_SECTION_MSG);
		tv.clickMiddleSection();
		WebElement getMiddleSection = tv.getMiddleSection();
		logger.debug("Moving to middle section and context clicking.");
		action.moveToElement(getMiddleSection).contextClick(getMiddleSection).perform();
		logger.debug(CLICKING_DS_RIGHT_CLICK_INSERT_AFTER_MSG);
		tv.clickDSRightClickInsertAfter();
		logger.debug(CLICKING_DS_RIGHT_CLICK_SECTION_MSG);
		tv.clickDSRightClickSection();
		boolean flag2 = tv.isNewSectionDS();
		logger.debug(ASSERTING_NEW_SECTION_DS_MSG);
		Assert.assertTrue(flag2);
		logger.debug(SENDING_KEYS_HELLO_TEXT_MSG);
		action.sendKeys(HELLO_TEXT).perform();
		logger.debug(CLICKING_TEXT_VARIABLE_PLUGIN_MSG);
		tv.clickTextVariablePlugin();
		logger.debug(CLICKING_ENTITY_CHECKBOX_1_MSG);
		tv.clickEntityCheckbox1();
		logger.debug(CLICKING_VARIABLE_INSERT_BTN_MSG);
		tv.clickVariableInsertBtn();
		logger.debug(SWITCHING_TO_FRAME_0_MSG);
		getDriver().switchTo().frame(FRAME_0);
		logger.debug(ASSERTING_VARIABLE_INSERTED_IN_VE_MSG);
		Assert.assertTrue(tv.isNewlyInsertedVariableVE());
		logger.info(FINISHED_TEST_MSG + "verifyinsertVariableInNewSectionHeadingCheckCursor");
	}


	@Test(enabled = true, groups = { GROUP_TEXT_VARIABLE, P2_TEXT_VARIABLE })
	public void verifyVariableTextInSelectedContent() {
		logger.info(STARTING_TEST_MSG + "verifyVariableTextInSelectedContent");
		logger.debug(CALLING_LOGIN_AND_SEARCH_FILE_TEXT_VARIABLE_CLICK_EDIT_MSG);
		ReusableMethods.loginAndSearchFileTextVariableClickEdit();
		logger.debug(INSTANTIATED_TEXT_VARIABLE_OBJECT_MSG);
		TextVariablePageObjects tv = new TextVariablePageObjects(getDriver());
		logger.debug(WAITING_FOR_LOADER_TO_DISAPPEAR_MSG);
		tv.waitForLoaderToDisappear();
		logger.debug(SWITCHING_TO_FRAME_0_MSG);
		getDriver().switchTo().frame(FRAME_0);
		logger.debug(CLICKING_FIRST_PARAGRAPH);
		tv.clickFirstParagraph();
		logger.debug(DOUBLE_CLICKING_FIRST_PARA_MSG);
		tv.doubleClickFirstParaVE();
		logger.debug(SWITCHING_TO_DEFAULT_CONTENT_MSG);
		getDriver().switchTo().defaultContent();
		logger.debug(CLICKING_TEXT_VARIABLE_PLUGIN_MSG);
		tv.clickTextVariablePlugin();
		logger.debug(GETTING_BOOTSTRAP_ALERT_TEXT_MSG);
		boolean flag = tv.getBootstrapAlert().getAttribute(ATTRIBUTE_INNER_TEXT)
				.contains(INFO_PLEASE_DESELECT_TEXT_BEFORE_ADD_TV);
		logger.debug(ASSERTING_TRUE_MSG);
		assertTrue(flag);
		logger.info(FINISHED_TEST_MSG + "verifyVariableTextInSelectedContent");
	}

	@Test(enabled = true, groups = { GROUP_TEXT_VARIABLE, P2_TEXT_VARIABLE })
	public void verifyVariableSearchOptionHistory() {
		logger.info(STARTING_TEST_MSG + "verifyVariableSearchOptionHistory");
		logger.debug(CALLING_LOGIN_AND_SEARCH_FILE_TEXT_VARIABLE_CLICK_EDIT_MSG);
		ReusableMethods.loginAndSearchFileTextVariableClickEdit();
		logger.debug(INSTANTIATED_TEXT_VARIABLE_OBJECT_MSG);
		TextVariablePageObjects tv = new TextVariablePageObjects(getDriver());
		logger.debug(WAITING_FOR_LOADER_TO_DISAPPEAR_MSG);
		tv.waitForLoaderToDisappear();
		logger.debug(CLICKING_DS_SECTION_MSG);
		tv.clickDSSection();
		logger.debug(CLICKING_FIRST_PARA_MSG);
		tv.clickfirstparaElement();
		logger.debug(CLICKING_TEXT_VARIABLE_PLUGIN_MSG);
		tv.clickTextVariablePlugin();
		logger.debug(ASSERTING_SEARCH_OPTION_IN_VARIABLE_POPUP_MSG);
		Assert.assertTrue(tv.isSearchOptionInVariablePopup());
		logger.debug("Clicking search option in variable popup.");
		tv.clickSearchOptionInVariablePopup();
		logger.debug(INSTANTIATED_ACTIONS_OBJECT_MSG);
		Actions action = new Actions(getDriver());
		logger.debug(SENDING_KEYS_TEST1_TEXT_MSG);
		action.sendKeys(TEST1_TEXT).perform();
		logger.debug(CLICKING_VARIABLE_CANCEL_BTN_MSG);
		tv.clickVariableCancelBtn();
		logger.debug(CLICKING_TEXT_VARIABLE_PLUGIN_MSG);
		tv.clickTextVariablePlugin();
		logger.debug(ASSERTING_SEARCH_OPTION_IN_VARIABLE_POPUP_MSG);
		Assert.assertTrue(tv.isSearchOptionInVariablePopup());
		boolean flag = tv.getSearchOptionInVariablePopup().getAttribute(ATTRIBUTE_PLACEHOLDER)
				.contains(INFO_MESSAGE_SEARCH_TEXT_VARIABLE);
		logger.debug(ASSERTING_TRUE_MSG);
		assertTrue(flag);
		logger.info(FINISHED_TEST_MSG + "verifyVariableSearchOptionHistory");
	}

	@Test(enabled = true, groups = { GROUP_TEXT_VARIABLE, P2_TEXT_VARIABLE })
	public void verifyVariableTextInImage() {
		logger.info(STARTING_TEST_MSG + "verifyVariableTextInImage");
		logger.debug(CALLING_LOGIN_AND_SEARCH_FILE_TEXT_VARIABLE_CLICK_EDIT_MSG);
		ReusableMethods.loginAndSearchFileTextVariableClickEdit();
		logger.debug(INSTANTIATED_TEXT_VARIABLE_OBJECT_MSG);
		TextVariablePageObjects tv = new TextVariablePageObjects(getDriver());
		logger.debug(WAITING_FOR_LOADER_TO_DISAPPEAR_MSG);
		tv.waitForLoaderToDisappear();
		logger.debug(CLICKING_DS_SECTION_MSG);
		tv.clickDSSection();
		logger.debug(CLICKING_FIRST_PARA_MSG);
		tv.clickfirstparaElement();
		WebElement getfirstparaCB = tv.getFirstParaCB();
		logger.debug(INSTANTIATED_ACTIONS_OBJECT_MSG);
		Actions action = new Actions(getDriver());
		logger.debug(CONTEXT_CLICKING_FIRST_PARAGRAPH_CB);
		action.contextClick(getfirstparaCB).perform();
		logger.debug(CLICKING_DS_INSERT_AFTER_MSG);
		tv.dsInsertAfter();
		logger.debug(SENDING_KEYS_IMG_TEXT_MSG);
		action.sendKeys(CONTAINS_IMG).perform();
		logger.debug(PRESSING_TAB_KEY_MSG);
		action.sendKeys(Keys.TAB).perform();
		logger.debug(PRESSING_ENTER_KEY_MSG);
		action.sendKeys(Keys.ENTER).perform();
		logger.debug(CLICKING_IMG_INSERT_FROM_INSERT_PLUGIN_MSG);
		tv.clickImgInsertFromInsertPlugin();
		logger.debug(CLICKING_INSERT_BUTTON_MSG);
		tv.clickInsertButton();
		logger.debug(CLICKING_TEXT_VARIABLE_PLUGIN_MSG);
		tv.clickTextVariablePlugin();
		logger.debug(GETTING_BOOTSTRAP_ALERT_TEXT_MSG);
		boolean flag = tv.getBootstrapAlert().getAttribute(ATTRIBUTE_INNER_TEXT)
				.contains(INFO_PLEASE_DESELECT_IMG_BEFORE_ADD_TV);
		logger.debug(ASSERTING_TRUE_MSG);
		assertTrue(flag);
		logger.info(FINISHED_TEST_MSG + "verifyVariableTextInImage");
	}

	@Test(enabled = true, groups = { GROUP_TEXT_VARIABLE, P2_TEXT_VARIABLE })
	public void verifyVariableTextInNewParaCheckTC() {
		logger.info(STARTING_TEST_MSG + "verifyVariableTextInNewParaCheckTC");
		logger.debug(CALLING_LOGIN_AND_SEARCH_FILE_TEXT_VARIABLE_CLICK_EDIT_MSG);
		ReusableMethods.loginAndSearchFileTextVariableClickEdit();
		logger.debug(INSTANTIATED_TEXT_VARIABLE_OBJECT_MSG);
		TextVariablePageObjects tv = new TextVariablePageObjects(getDriver());
		logger.debug(WAITING_FOR_LOADER_TO_DISAPPEAR_MSG);
		tv.waitForLoaderToDisappear();
		logger.debug(CLICKING_DS_SECTION_MSG);
		tv.clickDSSection();
		logger.debug(CLICKING_FIRST_PARA_MSG);
		tv.clickfirstparaElement();
		logger.debug(INSTANTIATED_ACTIONS_OBJECT_MSG);
		Actions action = new Actions(getDriver());
		logger.debug(SENDING_ENTER_KEY_MSG);
		action.sendKeys(Keys.ENTER).perform();
		logger.debug(CLICKING_ACCEPT_CHANGE_MSG);
		tv.clickAcceptChange();
		logger.debug(SENDING_KEYS_HELLO_TEXT_MSG);
		action.sendKeys(HELLO_TEXT).perform();
		logger.debug(CLICKING_ACCEPT_CHANGE_MSG);
		tv.clickAcceptChange();
		logger.debug(CLICKING_TEXT_VARIABLE_PLUGIN_MSG);
		tv.clickTextVariablePlugin();
		logger.debug(CLICKING_ENTITY_CHECKBOX_1_MSG);
		tv.clickEntityCheckbox1();
		logger.debug(CLICKING_VARIABLE_INSERT_BTN_MSG);
		tv.clickVariableInsertBtn();
		logger.debug(SWITCHING_TO_FRAME_0_MSG);
		getDriver().switchTo().frame(FRAME_0);
		logger.debug(ASSERTING_VARIABLE_INSERTED_IN_VE_MSG);
		Assert.assertTrue(tv.isNewlyInsertedVariableVE());
		logger.debug(SWITCHING_TO_DEFAULT_CONTENT_MSG);
		getDriver().switchTo().defaultContent();
		logger.debug(CLICKING_TRACK_CHANGE_MSG);
		tv.clickTrackChange();
		logger.debug(ASSERTING_TRUE_MSG);
		Assert.assertTrue(tv.isElementPresentCardNumberOne());
		logger.info(FINISHED_TEST_MSG + "verifyVariableTextInNewParaCheckTC");
	}

	@Test(enabled = true, groups = { GROUP_TEXT_VARIABLE, P2_TEXT_VARIABLE })
	public void verifyVariableTextInParaFromQuickInsert() {
		logger.info(STARTING_TEST_MSG + "verifyVariableTextInParaFromQuickInsert");
		logger.debug(CALLING_LOGIN_AND_SEARCH_FILE_TEXT_VARIABLE_CLICK_EDIT_MSG);
		ReusableMethods.loginAndSearchFileTextVariableClickEdit();
		logger.debug(INSTANTIATED_TEXT_VARIABLE_OBJECT_MSG);
		TextVariablePageObjects tv = new TextVariablePageObjects(getDriver());
		logger.debug(WAITING_FOR_LOADER_TO_DISAPPEAR_MSG);
		tv.waitForLoaderToDisappear();
		logger.debug(CLICKING_DS_SECTION_MSG);
		tv.clickDSSection();
		logger.debug(CLICKING_FIRST_PARA_MSG);
		tv.clickfirstparaElement();
		logger.debug(CLICKING_INSERT_PLUGIN_MSG);
		tv.clickInsertPlugin();
		logger.debug(CLICKING_INSERT_INTO_ELEMENT_MSG);
		tv.clickInsertIntoElement();
		logger.debug(CLICKING_VARIABLE_QUICK_INSERT_MSG);
		tv.clickVariableQuickInsert();
		logger.debug(CLICKING_INSERT_BUTTON_MSG);
		tv.clickInsertButton();
		logger.debug(CLICKING_ENTITY_CHECKBOX_1_MSG);
		tv.clickEntityCheckbox1();
		logger.debug(CLICKING_VARIABLE_INSERT_BTN_MSG);
		tv.clickVariableInsertBtn();
		logger.debug(SWITCHING_TO_FRAME_0_MSG);
		getDriver().switchTo().frame(FRAME_0);
		logger.debug(ASSERTING_VARIABLE_INSERTED_IN_VE_MSG);
		Assert.assertTrue(tv.isNewlyInsertedVariableVE());
		logger.debug(SWITCHING_TO_DEFAULT_CONTENT_MSG);
		getDriver().switchTo().defaultContent();
		logger.debug(CLICKING_TRACK_CHANGE_MSG);
		tv.clickTrackChange();
		logger.debug(ASSERTING_TRUE_MSG);
		Assert.assertTrue(tv.isElementPresentCardNumberOne());
		logger.info(FINISHED_TEST_MSG + "verifyVariableTextInParaFromQuickInsert");
	}

	@Test(enabled = true, groups = { GROUP_TEXT_VARIABLE, P2_TEXT_VARIABLE })
	public void verifyVariableTextinCodeIDElement() {
		logger.info(STARTING_TEST_MSG + "verifyVariableTextinCodeIDElement");
		logger.debug(CALLING_LOGIN_AND_SEARCH_FILE_TEXT_VARIABLE_CLICK_EDIT_MSG);
		ReusableMethods.loginAndSearchFileTextVariableClickEdit();
		logger.debug(INSTANTIATED_TEXT_VARIABLE_OBJECT_MSG);
		TextVariablePageObjects tv = new TextVariablePageObjects(getDriver());
		logger.debug(WAITING_FOR_LOADER_TO_DISAPPEAR_MSG);
		tv.waitForLoaderToDisappear();
		logger.debug(CLICKING_DS_SECTION_MSG);
		tv.clickDSSection();
		logger.debug(CLICKING_FIRST_PARA_MSG);
		tv.clickfirstparaElement();
		WebElement getfirstparaCB = tv.getFirstParaCB();
		logger.debug(INSTANTIATED_ACTIONS_OBJECT_MSG);
		Actions action = new Actions(getDriver());
		logger.debug(CONTEXT_CLICKING_FIRST_PARAGRAPH_CB);
		action.contextClick(getfirstparaCB).perform();
		logger.debug(CLICKING_DS_INSERT_AFTER_MSG);
		tv.dsInsertAfter();
		logger.debug(SENDING_KEYS_CODES_TEXT_MSG);
		action.sendKeys(CONTAINS_CODES).perform();
		logger.debug(PRESSING_TAB_KEY_MSG);
		action.sendKeys(Keys.TAB).perform();
		logger.debug(PRESSING_ENTER_KEY_MSG);
		action.sendKeys(Keys.ENTER).perform();
		logger.debug(ASSERTING_TRUE_MSG);
		Assert.assertTrue(tv.isNewlyInsertedDSCodeID());
		logger.debug(CLICKING_TEXT_VARIABLE_PLUGIN_MSG);
		tv.clickTextVariablePlugin();
		logger.debug(CLICKING_ENTITY_CHECKBOX_1_MSG);
		tv.clickEntityCheckbox1();
		logger.debug(CLICKING_VARIABLE_INSERT_BTN_MSG);
		tv.clickVariableInsertBtn();
		logger.debug(SWITCHING_TO_FRAME_0_MSG);
		getDriver().switchTo().frame(FRAME_0);
		logger.debug(ASSERTING_VARIABLE_INSERTED_IN_VE_MSG);
		Assert.assertTrue(tv.isNewlyInsertedVariableVE());
		logger.debug(SWITCHING_TO_DEFAULT_CONTENT_MSG);
		getDriver().switchTo().defaultContent();
		logger.info(FINISHED_TEST_MSG + "verifyVariableTextinCodeIDElement");
	}

	@Test(enabled = true, groups = { GROUP_TEXT_VARIABLE, P2_TEXT_VARIABLE })
	public void verifyAddingTextinCodeIDElement() {
		logger.info(STARTING_TEST_MSG + "verifyAddingTextinCodeIDElement");
		logger.debug(CALLING_LOGIN_AND_SEARCH_FILE_TEXT_VARIABLE_CLICK_EDIT_MSG);
		ReusableMethods.loginAndSearchFileTextVariableClickEdit();
		logger.debug(INSTANTIATED_TEXT_VARIABLE_OBJECT_MSG);
		TextVariablePageObjects tv = new TextVariablePageObjects(getDriver());
		logger.debug(WAITING_FOR_LOADER_TO_DISAPPEAR_MSG);
		tv.waitForLoaderToDisappear();
		logger.debug(CLICKING_DS_SECTION_MSG);
		tv.clickDSSection();
		logger.debug(CLICKING_FIRST_PARA_MSG);
		tv.clickfirstparaElement();
		WebElement getfirstparaCB = tv.getFirstParaCB();
		logger.debug(INSTANTIATED_ACTIONS_OBJECT_MSG);
		Actions action = new Actions(getDriver());
		logger.debug(CONTEXT_CLICKING_FIRST_PARAGRAPH_CB);
		action.contextClick(getfirstparaCB).perform();
		logger.debug(CLICKING_DS_INSERT_AFTER_MSG);
		tv.dsInsertAfter();
		logger.debug(SENDING_KEYS_CODES_TEXT_MSG);
		action.sendKeys(CONTAINS_CODES).perform();
		logger.debug(PRESSING_TAB_KEY_MSG);
		action.sendKeys(Keys.TAB).perform();
		logger.debug(PRESSING_ENTER_KEY_MSG);
		action.sendKeys(Keys.ENTER).perform();
		logger.debug(ASSERTING_TRUE_MSG);
		Assert.assertTrue(tv.isNewlyInsertedDSCodeID());
		logger.debug(SENDING_KEYS_CODES_TEXT_MSG);
		action.sendKeys(CONTAINS_CODES).perform();
		logger.debug(ASSERTING_TRUE_MSG);
		Assert.assertTrue(tv.isNewlyInsertedDSCodeID());
		logger.info(FINISHED_TEST_MSG + "verifyAddingTextinCodeIDElement");
	}

	@Test(enabled = true, groups = { GROUP_TEXT_VARIABLE, P2_TEXT_VARIABLE })
	public void verifyInsertVaribleAndHitEnterAndUndo() {
		logger.info(STARTING_TEST_MSG + "verifyInsertVaribleAndHitEnterAndUndo");
		logger.debug(CALLING_LOGIN_AND_SEARCH_FILE_TEXT_VARIABLE_CLICK_EDIT_MSG);
		ReusableMethods.loginAndSearchFileTextVariableClickEdit();
		logger.debug(INSTANTIATED_TEXT_VARIABLE_OBJECT_MSG);
		TextVariablePageObjects tv = new TextVariablePageObjects(getDriver());
		logger.debug(WAITING_FOR_LOADER_TO_DISAPPEAR_MSG);
		tv.waitForLoaderToDisappear();
		logger.debug(CLICKING_DS_SECTION_MSG);
		tv.clickDSSection();
		logger.debug(CLICKING_FIRST_PARA_MSG);
		tv.clickfirstparaElement();
		logger.debug(CLICKING_TEXT_VARIABLE_PLUGIN_MSG);
		tv.clickTextVariablePlugin();
		logger.debug(CLICKING_ENTITY_CHECKBOX_1_MSG);
		tv.clickEntityCheckbox1();
		logger.debug(CLICKING_VARIABLE_INSERT_BTN_MSG);
		tv.clickVariableInsertBtn();
		logger.debug(CLICKING_ACCEPT_CHANGE_MSG);
		tv.clickAcceptChange();
		logger.debug(SWITCHING_TO_FRAME_0_MSG);
		getDriver().switchTo().frame(FRAME_0);
		logger.debug(ASSERTING_VARIABLE_INSERTED_IN_VE_MSG);
		Assert.assertTrue(tv.isNewlyInsertedVariableVE());
		logger.debug(SWITCHING_TO_DEFAULT_CONTENT_MSG);
		getDriver().switchTo().defaultContent();
		logger.debug(INSTANTIATED_ACTIONS_OBJECT_MSG);
		Actions action = new Actions(getDriver());
		logger.debug(SENDING_ENTER_KEY_MSG);
		action.sendKeys(Keys.ENTER).perform();
		logger.debug(ASSERTING_TRUE_MSG);
		Assert.assertTrue(tv.isNewlyInsertedFirstParaCB());
		logger.debug(CLICKING_UNDO_PLUGIN_MSG);
		tv.clickUndoPlugin();
		logger.debug(ASSERTING_TRUE_MSG);
		Assert.assertTrue(tv.isNewlyInsertedFirstParaCB());
		logger.info(FINISHED_TEST_MSG + "verifyInsertVaribleAndHitEnterAndUndo");
	}

	@Test(enabled = true, groups = { GROUP_TEXT_VARIABLE, P2_TEXT_VARIABLE })
	public void verifyInsertTextVaraibleDeleteBackspace() {
		logger.info(STARTING_TEST_MSG + "verifyInsertTextVaraibleDeleteBackspace");
		logger.debug(CALLING_LOGIN_AND_SEARCH_FILE_TEXT_VARIABLE_CLICK_EDIT_MSG);
		ReusableMethods.loginAndSearchFileTextVariableClickEdit();
		logger.debug(INSTANTIATED_TEXT_VARIABLE_OBJECT_MSG);
		TextVariablePageObjects tv = new TextVariablePageObjects(getDriver());
		logger.debug(WAITING_FOR_LOADER_TO_DISAPPEAR_MSG);
		tv.waitForLoaderToDisappear();
		logger.debug(CLICKING_DS_SECTION_MSG);
		tv.clickDSSection();
		logger.debug(CLICKING_FIRST_PARA_MSG);
		tv.clickfirstparaElement();
		logger.debug(CLICKING_TEXT_VARIABLE_PLUGIN_MSG);
		tv.clickTextVariablePlugin();
		logger.debug(CLICKING_ENTITY_CHECKBOX_1_MSG);
		tv.clickEntityCheckbox1();
		logger.debug(CLICKING_VARIABLE_INSERT_BTN_MSG);
		tv.clickVariableInsertBtn();
		logger.debug(CLICKING_ACCEPT_CHANGE_MSG);
		tv.clickAcceptChange();
		logger.debug(SWITCHING_TO_FRAME_0_MSG);
		getDriver().switchTo().frame(FRAME_0);
		logger.debug(ASSERTING_VARIABLE_INSERTED_IN_VE_MSG);
		Assert.assertTrue(tv.isNewlyInsertedVariableVE());
		logger.debug(CLICKING_NEWLY_INSERTED_VARIABLE_VE);
		tv.clickNewlyInsertedVariableVe();
		logger.debug(SWITCHING_TO_DEFAULT_CONTENT_MSG);
		getDriver().switchTo().defaultContent();
		logger.debug(INSTANTIATED_ACTIONS_OBJECT_MSG);
		Actions action = new Actions(getDriver());
		logger.debug(SENDING_BACK_SPACE_KEY_MSG);
		action.sendKeys(Keys.BACK_SPACE).perform();
		logger.debug(SWITCHING_TO_FRAME_0_MSG);
		getDriver().switchTo().frame(FRAME_0);
		boolean flag = tv.getNewlyInsertedVariableVe().getAttribute(ATTRIBUTE_CLASS)
				.contains(CONTAINS_ENTITY + " " + CONTAINS_CKE_WIDGET_ELEMENT + " " + CONTAINS_ICE_DEL + " "
						+ CONTAINS_FLITE_CONTAINER_ONLY + " " + CONTAINS_ELEMENT_TAG_COLOR);
		logger.debug(ASSERTING_TRUE_MSG);
		Assert.assertTrue(flag);
		logger.debug(SWITCHING_TO_DEFAULT_CONTENT_MSG);
		getDriver().switchTo().defaultContent();
		logger.debug(CLICKING_TRACK_CHANGE_MSG);
		tv.clickTrackChange();
		WebElement dataInformationTC = tv.getDataInformationTc();
		String attribute = dataInformationTC.getAttribute(ATTRIBUTE_INNER_TEXT);
		logger.info(attribute);
		logger.debug(ASSERTING_EQUALS_MSG);
		Assert.assertEquals(attribute, INFO_DELETED_TEXT_VARIABLE_ALL_RIGHT_RESERVED_IATA);
		logger.info(FINISHED_TEST_MSG + "verifyInsertTextVaraibleDeleteBackspace");
	}

	@Test(enabled = true, groups = { GROUP_TEXT_VARIABLE, P2_TEXT_VARIABLE })
	public void verifyInsertTextVaraibleEnterKey() {
		logger.info(STARTING_TEST_MSG + "verifyInsertTextVaraibleEnterKey");
		logger.debug(CALLING_LOGIN_AND_SEARCH_FILE_TEXT_VARIABLE_CLICK_EDIT_MSG);
		ReusableMethods.loginAndSearchFileTextVariableClickEdit();
		logger.debug(INSTANTIATED_TEXT_VARIABLE_OBJECT_MSG);
		TextVariablePageObjects tv = new TextVariablePageObjects(getDriver());
		logger.debug(WAITING_FOR_LOADER_TO_DISAPPEAR_MSG);
		tv.waitForLoaderToDisappear();
		logger.debug(CLICKING_DS_SECTION_MSG);
		tv.clickDSSection();
		logger.debug(CLICKING_FIRST_PARA_MSG);
		tv.clickfirstparaElement();
		logger.debug(INSTANTIATED_ACTIONS_OBJECT_MSG);
		Actions action = new Actions(getDriver());
		logger.debug(SENDING_ENTER_KEY_MSG);
		action.sendKeys(Keys.ENTER).perform();
		logger.debug(CLICKING_TEXT_VARIABLE_PLUGIN_MSG);
		tv.clickTextVariablePlugin();
		logger.debug(CLICKING_ENTITY_CHECKBOX_1_MSG);
		tv.clickEntityCheckbox1();
		logger.debug(CLICKING_VARIABLE_INSERT_BTN_MSG);
		tv.clickVariableInsertBtn();
		logger.debug(CLICKING_ACCEPT_CHANGE_MSG);
		tv.clickAcceptChange();
		logger.debug(SWITCHING_TO_FRAME_0_MSG);
		getDriver().switchTo().frame(FRAME_0);
		logger.debug(ASSERTING_VARIABLE_INSERTED_IN_VE_MSG);
		Assert.assertTrue(tv.isNewlyInsertedVariableVE());
		logger.debug(CLICKING_NEWLY_INSERTED_VARIABLE_VE);
		tv.clickNewlyInsertedVariableVe();
		logger.debug(SWITCHING_TO_DEFAULT_CONTENT_MSG);
		getDriver().switchTo().defaultContent();
		logger.debug(SENDING_ENTER_KEY_MSG);
		action.sendKeys(Keys.ENTER).perform();
		boolean flag3 = tv.getSelectedCB().getAttribute(ATTRIBUTE_ID).contains("57");
		logger.debug(ASSERTING_TRUE_MSG);
		Assert.assertTrue(flag3);
		logger.info(FINISHED_TEST_MSG + "verifyInsertTextVaraibleEnterKey");
	}

	@Test(enabled = true, groups = { GROUP_TEXT_VARIABLE, P2_TEXT_VARIABLE })
	public void verifyInsertTextVaraibleMidParaRejectChange() {
		logger.info(STARTING_TEST_MSG + "verifyInsertTextVaraibleMidParaRejectChange");
		logger.debug(CALLING_LOGIN_AND_SEARCH_FILE_TEXT_VARIABLE_CLICK_EDIT_MSG);
		ReusableMethods.loginAndSearchFileTextVariableClickEdit();
		logger.debug(INSTANTIATED_TEXT_VARIABLE_OBJECT_MSG);
		TextVariablePageObjects tv = new TextVariablePageObjects(getDriver());
		logger.debug(WAITING_FOR_LOADER_TO_DISAPPEAR_MSG);
		tv.waitForLoaderToDisappear();
		logger.debug(SWITCHING_TO_FRAME_0_MSG);
		getDriver().switchTo().frame(FRAME_0);
		logger.debug(CLICKING_VE_FIRST_PARA_MSG);
		tv.clickVEFirstPara();
		logger.debug(SWITCHING_TO_DEFAULT_CONTENT_MSG);
		getDriver().switchTo().defaultContent();
		logger.debug(CLICKING_TEXT_VARIABLE_PLUGIN_MSG);
		tv.clickTextVariablePlugin();
		logger.debug(CLICKING_ENTITY_CHECKBOX_1_MSG);
		tv.clickEntityCheckbox1();
		logger.debug(CLICKING_VARIABLE_INSERT_BTN_MSG);
		tv.clickVariableInsertBtn();
		logger.debug(CLICKING_REJECT_CHANGE_MSG);
		tv.clickRejectChange();
		boolean flag3 = tv.getSelectedCB().getAttribute(ATTRIBUTE_ID).contains("4");
		logger.debug(ASSERTING_TRUE_MSG);
		Assert.assertTrue(flag3);
		logger.info(FINISHED_TEST_MSG + "verifyInsertTextVaraibleMidParaRejectChange");
	}

	@Test(enabled = true, groups = { GROUP_TEXT_VARIABLE, P2_TEXT_VARIABLE })
	public void verifyInsertTextVaraibleAddcontentPara() {
		logger.info(STARTING_TEST_MSG + "verifyInsertTextVaraibleAddcontentPara");
		logger.debug(CALLING_LOGIN_AND_SEARCH_FILE_TEXT_VARIABLE_CLICK_EDIT_MSG);
		ReusableMethods.loginAndSearchFileTextVariableClickEdit();
		logger.debug(INSTANTIATED_TEXT_VARIABLE_OBJECT_MSG);
		TextVariablePageObjects tv = new TextVariablePageObjects(getDriver());
		logger.debug(WAITING_FOR_LOADER_TO_DISAPPEAR_MSG);
		tv.waitForLoaderToDisappear();
		logger.debug(CLICKING_DS_SECTION_MSG);
		tv.clickDSSection();
		logger.debug(CLICKING_FIRST_PARA_MSG);
		tv.clickfirstparaElement();
		logger.debug(INSTANTIATED_ACTIONS_OBJECT_MSG);
		Actions action = new Actions(getDriver());
		logger.debug(SENDING_ENTER_KEY_MSG);
		action.sendKeys(Keys.ENTER).perform();
		logger.debug(SENDING_KEYS_HELLO_TEXT_MSG);
		action.sendKeys(HELLO_TEXT).perform();
		logger.debug(CLICKING_TEXT_VARIABLE_PLUGIN_MSG);
		tv.clickTextVariablePlugin();
		logger.debug(CLICKING_ENTITY_CHECKBOX_1_MSG);
		tv.clickEntityCheckbox1();
		logger.debug(CLICKING_VARIABLE_INSERT_BTN_MSG);
		tv.clickVariableInsertBtn();
		logger.debug(CLICKING_ACCEPT_CHANGE_MSG);
		tv.clickAcceptChange();
		logger.debug(SWITCHING_TO_FRAME_0_MSG);
		getDriver().switchTo().frame(FRAME_0);
		logger.debug(ASSERTING_VARIABLE_INSERTED_IN_VE_MSG);
		Assert.assertTrue(tv.isNewlyInsertedVariableVE());
		logger.info(FINISHED_TEST_MSG + "verifyInsertTextVaraibleAddcontentPara");
	}

	@Test(enabled = true, groups = { GROUP_TEXT_VARIABLE, P2_TEXT_VARIABLE })
	public void verifyInsertTextVaraibleRejectchangeUndo() {
		logger.info(STARTING_TEST_MSG + "verifyInsertTextVaraibleRejectchangeUndo");
		logger.debug(CALLING_LOGIN_AND_SEARCH_FILE_TEXT_VARIABLE_CLICK_EDIT_MSG);
		ReusableMethods.loginAndSearchFileTextVariableClickEdit();
		logger.debug(INSTANTIATED_TEXT_VARIABLE_OBJECT_MSG);
		TextVariablePageObjects tv = new TextVariablePageObjects(getDriver());
		logger.debug(WAITING_FOR_LOADER_TO_DISAPPEAR_MSG);
		tv.waitForLoaderToDisappear();
		logger.debug(SWITCHING_TO_FRAME_0_MSG);
		getDriver().switchTo().frame(FRAME_0);
		logger.debug(CLICKING_VE_FIRST_PARA_MSG);
		tv.clickVEFirstPara();
		logger.debug(SWITCHING_TO_DEFAULT_CONTENT_MSG);
		getDriver().switchTo().defaultContent();
		logger.debug(CLICKING_TEXT_VARIABLE_PLUGIN_MSG);
		tv.clickTextVariablePlugin();
		logger.debug(CLICKING_ENTITY_CHECKBOX_1_MSG);
		tv.clickEntityCheckbox1();
		logger.debug(CLICKING_VARIABLE_INSERT_BTN_MSG);
		tv.clickVariableInsertBtn();
		logger.debug(CLICKING_REJECT_CHANGE_MSG);
		tv.clickRejectChange();
		logger.debug(CLICKING_UNDO_MSG);
		tv.clickUndo();
		logger.debug(SWITCHING_TO_FRAME_0_MSG);
		getDriver().switchTo().frame(FRAME_0);
		logger.debug(ASSERTING_VARIABLE_INSERTED_IN_VE_MSG);
		Assert.assertTrue(tv.isNewlyInsertedVariableVE());
		logger.debug(SWITCHING_TO_DEFAULT_CONTENT_MSG);
		getDriver().switchTo().defaultContent();
		logger.info(FINISHED_TEST_MSG + "verifyInsertTextVaraibleRejectchangeUndo");
	}

	@Test(enabled = true, groups = { GROUP_TEXT_VARIABLE, P2_TEXT_VARIABLE })
	public void verifyInsertTextVaraibleRightclick() {
		logger.info(STARTING_TEST_MSG + "verifyInsertTextVaraibleRightclick");
		logger.debug(CALLING_LOGIN_AND_SEARCH_FILE_TEXT_VARIABLE_CLICK_EDIT_MSG);
		ReusableMethods.loginAndSearchFileTextVariableClickEdit();
		logger.debug(INSTANTIATED_TEXT_VARIABLE_OBJECT_MSG);
		TextVariablePageObjects tv = new TextVariablePageObjects(getDriver());
		logger.debug(WAITING_FOR_LOADER_TO_DISAPPEAR_MSG);
		tv.waitForLoaderToDisappear();
		logger.debug(SWITCHING_TO_FRAME_0_MSG);
		getDriver().switchTo().frame(FRAME_0);
		logger.debug(CLICKING_VE_FIRST_PARA_MSG);
		tv.clickVEFirstPara();
		logger.debug(SWITCHING_TO_DEFAULT_CONTENT_MSG);
		getDriver().switchTo().defaultContent();
		logger.debug(CLICKING_TEXT_VARIABLE_PLUGIN_MSG);
		tv.clickTextVariablePlugin();
		logger.debug(CLICKING_ENTITY_CHECKBOX_1_MSG);
		tv.clickEntityCheckbox1();
		logger.debug(CLICKING_VARIABLE_INSERT_BTN_MSG);
		tv.clickVariableInsertBtn();
		logger.debug(SWITCHING_TO_FRAME_0_MSG);
		getDriver().switchTo().frame(FRAME_0);
		logger.debug(CLICKING_NEWLY_INSERTED_VARIABLE_VE);
		tv.clickNewlyInsertedVariableVe();
		WebElement newlyInsertedVariableVE = tv.getNewlyInsertedVariableVe();
		logger.debug(INSTANTIATED_ACTIONS_OBJECT_MSG);
		Actions action = new Actions(getDriver());
		logger.debug("Context clicking on newly inserted variable VE.");
		action.contextClick(newlyInsertedVariableVE).perform();
		logger.debug(SWITCHING_TO_DEFAULT_CONTENT_MSG);
		getDriver().switchTo().defaultContent();
		logger.debug(SWITCHING_TO_FRAME_1_MSG);
		getDriver().switchTo().frame(FRAME_1);
		boolean flag = tv.getVERightClickInsertAfter().getAttribute(ATTRIBUTE_ARIA_DISABLED).contains("true");
		logger.debug(ASSERTING_TRUE_MSG);
		Assert.assertTrue(flag);
		logger.info(FINISHED_TEST_MSG + "verifyInsertTextVaraibleRightclick");
	}

	@Test(enabled = true, groups = { GROUP_TEXT_VARIABLE, P2_TEXT_VARIABLE })
	public void verifyInsertTextVaraibleSectionheadingUndo() {
		logger.info(STARTING_TEST_MSG + "verifyInsertTextVaraibleSectionheadingUndo");
		logger.debug(CALLING_LOGIN_AND_SEARCH_FILE_TEXT_VARIABLE_CLICK_EDIT_MSG);
		ReusableMethods.loginAndSearchFileTextVariableClickEdit();
		logger.debug(INSTANTIATED_TEXT_VARIABLE_OBJECT_MSG);
		TextVariablePageObjects tv = new TextVariablePageObjects(getDriver());
		logger.debug(WAITING_FOR_LOADER_TO_DISAPPEAR_MSG);
		tv.waitForLoaderToDisappear();
		logger.debug(SWITCHING_TO_FRAME_0_MSG);
		getDriver().switchTo().frame(FRAME_0);
		logger.debug("Clicking section heading VE.");
		tv.clickSectionHeadingVE();
		logger.debug(SWITCHING_TO_DEFAULT_CONTENT_MSG);
		getDriver().switchTo().defaultContent();
		logger.debug(CLICKING_TEXT_VARIABLE_PLUGIN_MSG);
		tv.clickTextVariablePlugin();
		logger.debug(CLICKING_ENTITY_CHECKBOX_1_MSG);
		tv.clickEntityCheckbox1();
		logger.debug(CLICKING_VARIABLE_INSERT_BTN_MSG);
		tv.clickVariableInsertBtn();
		logger.debug(CLICKING_ACCEPT_CHANGE_MSG);
		tv.clickAcceptChange();
		logger.debug(CLICKING_UNDO_MSG);
		tv.clickUndo();
		logger.debug(CLICKING_UNDO_MSG);
		tv.clickUndo();
		logger.debug(SWITCHING_TO_FRAME_0_MSG);
		getDriver().switchTo().frame(FRAME_0);
		logger.debug(ASSERTING_VARIABLE_INSERTED_IN_VE_MSG);
		Assert.assertTrue(tv.isNewlyInsertedVariableVE());
		logger.debug(SWITCHING_TO_DEFAULT_CONTENT_MSG);
		getDriver().switchTo().defaultContent();
		logger.info(FINISHED_TEST_MSG + "verifyInsertTextVaraibleSectionheadingUndo");
	}

	@Test(enabled = true, groups = { GROUP_TEXT_VARIABLE, P2_TEXT_VARIABLE })
	public void verifyInsertTextVaraibleMultipleInline() {
		logger.info(STARTING_TEST_MSG + "verifyInsertTextVaraibleMultipleInline");
		logger.debug(CALLING_LOGIN_AND_SEARCH_FILE_TEXT_VARIABLE_CLICK_EDIT_MSG);
		ReusableMethods.loginAndSearchFileTextVariableClickEdit();
		logger.debug(INSTANTIATED_TEXT_VARIABLE_OBJECT_MSG);
		TextVariablePageObjects tv = new TextVariablePageObjects(getDriver());
		logger.debug(SWITCHING_TO_FRAME_0_MSG);
		getDriver().switchTo().frame(FRAME_0);
		logger.debug(CLICKING_VE_FIRST_PARA_MSG);
		tv.clickVEFirstPara();
		logger.debug(SWITCHING_TO_DEFAULT_CONTENT_MSG);
		getDriver().switchTo().defaultContent();
		logger.debug(CLICKING_TEXT_VARIABLE_PLUGIN_MSG);
		tv.clickTextVariablePlugin();
		logger.debug(CLICKING_ENTITY_CHECKBOX_1_MSG);
		tv.clickEntityCheckbox1();
		logger.debug(CLICKING_VARIABLE_INSERT_BTN_MSG);
		tv.clickVariableInsertBtn();
		logger.debug(CLICKING_ACCEPT_CHANGE_MSG);
		tv.clickAcceptChange();
		logger.debug(SWITCHING_TO_FRAME_0_MSG);
		getDriver().switchTo().frame(FRAME_0);
		logger.debug(CLICKING_NEWLY_INSERTED_VARIABLE_VE);
		tv.clickNewlyInsertedVariableVe();
		logger.debug(SWITCHING_TO_DEFAULT_CONTENT_MSG);
		getDriver().switchTo().defaultContent();
		logger.debug(CLICKING_ON_BOLD_BUTTON_MSG);
		tv.clickOnBoldButton();
		boolean flag = tv.getItalic().getAttribute(ATTRIBUTE_ARIA_DISABLED).contains("false");
		logger.debug(ASSERTING_TRUE_MSG);
		Assert.assertTrue(flag);
		logger.info(FINISHED_TEST_MSG + "verifyInsertTextVaraibleMultipleInline");
	}

	@Test(enabled = true, groups = { GROUP_TEXT_VARIABLE, P2_TEXT_VARIABLE })
	public void verifyInsertTextVaraibleCVQP() {
		logger.info(STARTING_TEST_MSG + "verifyInsertTextVaraibleCVQP");
		logger.debug(CALLING_LOGIN_AND_SEARCH_FILE_TEXT_VARIABLE_CLICK_EDIT_MSG);
		ReusableMethods.loginAndSearchFileTextVariableClickEdit();
		logger.debug(INSTANTIATED_TEXT_VARIABLE_OBJECT_MSG);
		TextVariablePageObjects tv = new TextVariablePageObjects(getDriver());
		logger.debug(WAITING_FOR_LOADER_TO_DISAPPEAR_MSG);
		tv.waitForLoaderToDisappear();
		logger.debug(SWITCHING_TO_FRAME_0_MSG);
		getDriver().switchTo().frame(FRAME_0);
		logger.debug(CLICKING_VE_FIRST_PARA_MSG);
		tv.clickVEFirstPara();
		logger.debug(SWITCHING_TO_DEFAULT_CONTENT_MSG);
		getDriver().switchTo().defaultContent();
		logger.debug(CLICKING_TEXT_VARIABLE_PLUGIN_MSG);
		tv.clickTextVariablePlugin();
		logger.debug(CLICKING_ENTITY_CHECKBOX_1_MSG);
		tv.clickEntityCheckbox1();
		logger.debug(CLICKING_VARIABLE_INSERT_BTN_MSG);
		tv.clickVariableInsertBtn();
		logger.debug(CLICKING_ACCEPT_CHANGE_MSG);
		tv.clickAcceptChange();
		logger.debug(SWITCHING_TO_FRAME_0_MSG);
		getDriver().switchTo().frame(FRAME_0);
		tv.isNewlyInsertedVariableVE();
		logger.debug(SWITCHING_TO_DEFAULT_CONTENT_MSG);
		getDriver().switchTo().defaultContent();
		logger.debug(CLICKING_QP_MSG);
		tv.clickQP();
		logger.debug(SWITCHING_TO_FRAME_0_MSG);
		getDriver().switchTo().frame(FRAME_0);
		tv.isNewlyInsertedVariableVE();
		logger.debug(SWITCHING_TO_DEFAULT_CONTENT_MSG);
		getDriver().switchTo().defaultContent();
		logger.debug(CLICKING_CODE_VIEW_MSG);
		tv.clickCodeView();
		boolean contentValidationCV = tv.contentValidationCv();
		logger.debug(ASSERTING_FALSE_MSG);
		Assert.assertFalse(contentValidationCV);
		logger.info(FINISHED_TEST_MSG + "verifyInsertTextVaraibleCVQP");
	}


	@Test(enabled = true, groups = { GROUP_TEXT_VARIABLE, P2_TEXT_VARIABLE })
	public void verifyFootnoteBottomAddTextVaraiable() {
		logger.info(STARTING_TEST_MSG + "verifyFootnoteBottomAddTextVaraiable");
		logger.debug(CALLING_LOGIN_AND_SEARCH_FILE_CLICK_EDIT_MSG);
		ReusableMethods.loginAndSearchFileClickEdit();
		logger.debug(INSTANTIATED_TEXT_VARIABLE_OBJECT_MSG);
		TextVariablePageObjects tv = new TextVariablePageObjects(getDriver());
		logger.debug(SWITCHING_TO_FRAME_0_MSG);
		getDriver().switchTo().frame(FRAME_0);
		logger.debug("Clicking VE first para.");
		tv.clickVEFirstPara();
		logger.debug(SWITCHING_TO_DEFAULT_CONTENT_MSG);
		getDriver().switchTo().defaultContent();
		logger.debug("Clicking on Footnote plugin.");
		tv.clickOnFootnotePlugin();
		logger.debug("Clicking on new footnote box.");
		tv.clickOnNewFootNoteBox();
		logger.debug("Entering value in footnote.");
		tv.enterValueInFootnote();
		logger.debug("Clicking on footnote OK button.");
		tv.clickOnFootnoteOkBtn();
		logger.debug(INSTANTIATED_ACTIONS_OBJECT_MSG);
		Actions a = new Actions(getDriver());
		logger.debug(SWITCHING_TO_FRAME_0_MSG);
		getDriver().switchTo().frame(FRAME_0);
		WebElement bottomFootnote = tv.getBottomFootnote();
		logger.debug("Clicking bottom footnote.");
		a.click(bottomFootnote).perform();
		logger.debug(SWITCHING_TO_DEFAULT_CONTENT_MSG);
		getDriver().switchTo().defaultContent();
		logger.debug(CLICKING_TEXT_VARIABLE_PLUGIN_MSG);
		tv.clickTextVariablePlugin();
		logger.debug(CLICKING_ENTITY_CHECKBOX_1_MSG);
		tv.clickEntityCheckbox1();
		logger.debug(CLICKING_VARIABLE_INSERT_BTN_MSG);
		tv.clickVariableInsertBtn();
		logger.debug(CLICKING_ACCEPT_CHANGE_MSG);
		tv.clickAcceptChange();
		logger.debug(SWITCHING_TO_FRAME_0_MSG);
		getDriver().switchTo().frame(FRAME_0);
		tv.isNewlyInsertedVariableVE();
		logger.debug(SWITCHING_TO_DEFAULT_CONTENT_MSG);
		getDriver().switchTo().defaultContent();
		logger.debug(INSTANTIATED_ACTIONS_OBJECT_MSG);
		Actions action = new Actions(getDriver());
		logger.debug(SENDING_BACK_SPACE_KEY_MSG);
		action.sendKeys(Keys.BACK_SPACE).perform();
		logger.debug(SWITCHING_TO_FRAME_0_MSG);
		getDriver().switchTo().frame(FRAME_0);
		boolean flag1 = tv.getNewlyInsertedVariableVe().getAttribute(ATTRIBUTE_CLASS)
				.contains(CONTAINS_ENTITY + " " + CONTAINS_CKE_WIDGET_ELEMENT + " " + CONTAINS_ICE_DEL + " "
						+ CONTAINS_FLITE_CONTAINER_ONLY + " " + CONTAINS_ELEMENT_TAG_COLOR);
		logger.debug(ASSERTING_TRUE_MSG);
		Assert.assertTrue(flag1);
		logger.debug(SWITCHING_TO_DEFAULT_CONTENT_MSG);
		getDriver().switchTo().defaultContent();
		logger.debug(CLICKING_TRACK_CHANGE_MSG);
		tv.clickTrackChange();
		WebElement dataInformationTC = tv.getDataInformationTc();
		String attribute = dataInformationTC.getAttribute(ATTRIBUTE_INNER_TEXT);
		logger.info(attribute);
		logger.debug(ASSERTING_EQUALS_MSG);
		Assert.assertEquals(attribute, INFO_DELETED_TEXT_VARIABLE_ALL_RIGHT_RESERVED_IATA);
		logger.info(FINISHED_TEST_MSG + "verifyFootnoteBottomAddTextVaraiable");
	}

	

	@Test(enabled = true, groups = { GROUP_TEXT_VARIABLE, P2_TEXT_VARIABLE })
	public void verifyInsertTextVaraibleCopyPasteShortcutkey() {
		logger.info(STARTING_TEST_MSG + "verifyInsertTextVaraibleCopyPasteShortcutkey");
		logger.debug(CALLING_LOGIN_AND_SEARCH_FILE_TEXT_VARIABLE_CLICK_EDIT_MSG);
		ReusableMethods.loginAndSearchFileTextVariableClickEdit();
		logger.debug(INSTANTIATED_TEXT_VARIABLE_OBJECT_MSG);
		TextVariablePageObjects tv = new TextVariablePageObjects(getDriver());
		logger.debug(WAITING_FOR_LOADER_TO_DISAPPEAR_MSG);
		tv.waitForLoaderToDisappear();
		logger.debug(CLICKING_DS_SECTION_MSG);
		tv.clickDSSection();
		logger.debug(CLICKING_FIRST_PARA_MSG);
		tv.clickfirstparaElement();
		logger.debug(CLICKING_TEXT_VARIABLE_PLUGIN_MSG);
		tv.clickTextVariablePlugin();
		logger.debug(CLICKING_ENTITY_CHECKBOX_1_MSG);
		tv.clickEntityCheckbox1();
		logger.debug(CLICKING_VARIABLE_INSERT_BTN_MSG);
		tv.clickVariableInsertBtn();
		logger.debug(CLICKING_ACCEPT_CHANGE_MSG);
		tv.clickAcceptChange();
		logger.debug(SWITCHING_TO_FRAME_0_MSG);
		getDriver().switchTo().frame(FRAME_0);
		logger.debug(ASSERTING_VARIABLE_INSERTED_IN_VE_MSG);
		Assert.assertTrue(tv.isNewlyInsertedVariableVE());
		logger.debug(CLICKING_NEWLY_INSERTED_VARIABLE_VE);
		tv.clickNewlyInsertedVariableVe();
		logger.debug(SWITCHING_TO_DEFAULT_CONTENT_MSG);
		getDriver().switchTo().defaultContent();
		logger.debug(INSTANTIATED_ACTIONS_OBJECT_MSG);
		Actions action = new Actions(getDriver());
		logger.debug(PERFORMING_CTRL_X_MSG);
		action.keyDown(Keys.CONTROL).sendKeys("x").keyUp(Keys.CONTROL).perform();
		logger.debug(SWITCHING_TO_FRAME_0_MSG);
		getDriver().switchTo().frame(FRAME_0);
		logger.debug(CLICKING_VE_MIDDLE_PARA_MSG);
		tv.clickVeMiddlePara();
		logger.debug(SWITCHING_TO_DEFAULT_CONTENT_MSG);
		getDriver().switchTo().defaultContent();
		logger.debug(PERFORMING_CTRL_V_MSG);
		action.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
		logger.debug(SWITCHING_TO_FRAME_0_MSG);
		getDriver().switchTo().frame(FRAME_0);
		boolean flag = tv.isNewlyPastedVariableVE();
		logger.debug(ASSERTING_TRUE_MSG);
		Assert.assertTrue(flag);
		logger.info(FINISHED_TEST_MSG + "verifyInsertTextVaraibleCopyPasteShortcutkey");
	}

	@Test(enabled = true, groups = { GROUP_TEXT_VARIABLE, P2_TEXT_VARIABLE })
	public void verifyInsertTextVaraibleCopyPasteToolbar() {
		logger.info(STARTING_TEST_MSG + "verifyInsertTextVaraibleCopyPasteToolbar");
		logger.debug(CALLING_LOGIN_AND_SEARCH_FILE_TEXT_VARIABLE_CLICK_EDIT_MSG);
		ReusableMethods.loginAndSearchFileTextVariableClickEdit();
		logger.debug(INSTANTIATED_TEXT_VARIABLE_OBJECT_MSG);
		TextVariablePageObjects tv = new TextVariablePageObjects(getDriver());
		logger.debug(WAITING_FOR_LOADER_TO_DISAPPEAR_MSG);
		tv.waitForLoaderToDisappear();
		logger.debug(CLICKING_DS_SECTION_MSG);
		tv.clickDSSection();
		logger.debug(CLICKING_FIRST_PARA_MSG);
		tv.clickfirstparaElement();
		logger.debug(CLICKING_TEXT_VARIABLE_PLUGIN_MSG);
		tv.clickTextVariablePlugin();
		logger.debug(CLICKING_ENTITY_CHECKBOX_1_MSG);
		tv.clickEntityCheckbox1();
		logger.debug(CLICKING_VARIABLE_INSERT_BTN_MSG);
		tv.clickVariableInsertBtn();
		logger.debug(CLICKING_ACCEPT_CHANGE_MSG);
		tv.clickAcceptChange();
		logger.debug(SWITCHING_TO_FRAME_0_MSG);
		getDriver().switchTo().frame(FRAME_0);
		logger.debug(ASSERTING_VARIABLE_INSERTED_IN_VE_MSG);
		Assert.assertTrue(tv.isNewlyInsertedVariableVE());
		logger.debug(CLICKING_NEWLY_INSERTED_VARIABLE_VE);
		tv.clickNewlyInsertedVariableVe();
		logger.debug(SWITCHING_TO_DEFAULT_CONTENT_MSG);
		getDriver().switchTo().defaultContent();
		logger.debug(CLICKING_COPY_BUTTON_MSG);
		tv.clickCopyButton();
		logger.debug(SWITCHING_TO_FRAME_0_MSG);
		getDriver().switchTo().frame(FRAME_0);
		logger.debug(CLICKING_VE_MIDDLE_PARA_MSG);
		tv.clickVeMiddlePara();
		logger.debug(SWITCHING_TO_DEFAULT_CONTENT_MSG);
		getDriver().switchTo().defaultContent();
		logger.debug(CLICKING_PASTE_BUTTON_MSG);
		tv.clickPasteButton();
		logger.debug(SWITCHING_TO_FRAME_0_MSG);
		getDriver().switchTo().frame(FRAME_0);
		boolean flag = tv.isDataFliteCid2();
		logger.debug(ASSERTING_TRUE_MSG);
		Assert.assertTrue(flag);
		logger.debug(SWITCHING_TO_DEFAULT_CONTENT_MSG);
		getDriver().switchTo().defaultContent();
		logger.info(FINISHED_TEST_MSG + "verifyInsertTextVaraibleCopyPasteToolbar");
	}

	@Test(enabled = true, groups = { GROUP_TEXT_VARIABLE, P2_TEXT_VARIABLE })
	public void verifyInsertTextVaraibleParaTodefinition() {
		logger.info(STARTING_TEST_MSG + "verifyInsertTextVaraibleParaTodefinition");
		logger.debug(CALLING_LOGIN_AND_SEARCH_FILE_TEXT_VARIABLE_CLICK_EDIT_MSG);
		ReusableMethods.loginAndSearchFileTextVariableClickEdit();
		logger.debug(INSTANTIATED_TEXT_VARIABLE_OBJECT_MSG);
		TextVariablePageObjects tv = new TextVariablePageObjects(getDriver());
		logger.debug(WAITING_FOR_LOADER_TO_DISAPPEAR_MSG);
		tv.waitForLoaderToDisappear();
		logger.debug(CLICKING_DS_SECTION_MSG);
		tv.clickDSSection();
		logger.debug(SWITCHING_TO_FRAME_0_MSG);
		getDriver().switchTo().frame(FRAME_0);
		logger.debug(CLICKING_VE_FIRST_PARA_MSG);
		tv.clickVEFirstPara();
		logger.debug(SWITCHING_TO_DEFAULT_CONTENT_MSG);
		getDriver().switchTo().defaultContent();
		logger.debug(CLICKING_TEXT_VARIABLE_PLUGIN_MSG);
		tv.clickTextVariablePlugin();
		logger.debug(CLICKING_ENTITY_CHECKBOX_1_MSG);
		tv.clickEntityCheckbox1();
		logger.debug(CLICKING_VARIABLE_INSERT_BTN_MSG);
		tv.clickVariableInsertBtn();
		logger.debug(CLICKING_ACCEPT_CHANGE_MSG);
		tv.clickAcceptChange();
		logger.debug(SWITCHING_TO_FRAME_0_MSG);
		getDriver().switchTo().frame(FRAME_0);
		WebElement element = tv.getVeFirstPara();
		logger.debug(INSTANTIATED_ACTIONS_OBJECT_MSG);
		Actions action = new Actions(getDriver());
		logger.debug("Context clicking element.");
		action.contextClick(element).perform();
		logger.debug(SWITCHING_TO_DEFAULT_CONTENT_MSG);
		getDriver().switchTo().defaultContent();
		logger.debug(SWITCHING_TO_FRAME_1_MSG);
		getDriver().switchTo().frame(FRAME_1);
		logger.debug("Clicking right click change element.");
		tv.clickrightClickChangeElement();
		logger.debug(SWITCHING_TO_DEFAULT_CONTENT_MSG);
		getDriver().switchTo().defaultContent();
		logger.debug("Clicking CE text field.");
		tv.clickCeTextField();
		logger.debug(SENDING_KEYS_DEFINITION_TEXT_MSG);
		action.sendKeys(CONTAINS_DEFINITION).perform();
		logger.debug(PRESSING_ENTER_KEY_MSG);
		action.sendKeys(Keys.ENTER).perform();
		action.sendKeys(Keys.ENTER).perform();
		logger.debug(SWITCHING_TO_FRAME_0_MSG);
		getDriver().switchTo().frame(FRAME_0);
		logger.debug(ASSERTING_VARIABLE_DEFINITION_VE_MSG);
		Assert.assertFalse(tv.isNewlyInsertedVariableVeDefinition());
		logger.debug(SWITCHING_TO_DEFAULT_CONTENT_MSG);
		getDriver().switchTo().defaultContent();
		logger.info(FINISHED_TEST_MSG + "verifyInsertTextVaraibleParaTodefinition");
	}


	@Test(enabled = true, groups = { GROUP_TEXT_VARIABLE, P2_TEXT_VARIABLE })
	public void verifyInsertAddressandTextVaraibleinPartyinfo() {
		logger.info(STARTING_TEST_MSG + "verifyInsertAddressandTextVaraibleinPartyinfo");
		logger.debug(CALLING_LOGIN_AND_SEARCH_FILE_CLICK_EDIT_MSG);
		ReusableMethods.loginAndSearchFileClickEdit();
		logger.debug(INSTANTIATED_TEXT_VARIABLE_OBJECT_MSG);
		TextVariablePageObjects tv = new TextVariablePageObjects(getDriver());
		logger.debug(WAITING_FOR_LOADER_TO_DISAPPEAR_MSG);
		tv.waitForLoaderToDisappear();
		logger.debug(SWITCHING_TO_FRAME_0_MSG);
		getDriver().switchTo().frame(FRAME_0);
		logger.debug(INSTANTIATED_BASE_PAGE_OBJECT_MSG);
		BasePage bp = new BasePage(getDriver());
		logger.debug(RIGHT_CLICKING_ON_VE_FIRST_PARA);
		bp.rightClickElement(tv.getVeFirstPara());
		logger.debug(SWITCHING_TO_DEFAULT_CONTENT_MSG);
		getDriver().switchTo().defaultContent();
		logger.debug(SWITCHING_TO_FRAME_1_MSG);
		getDriver().switchTo().frame(FRAME_1);
		logger.debug(CLICKING_RIGHT_CLICK_INSERT_AFTER_VE_MSG);
		tv.clickRightClickInsertAfter();
		logger.debug(SWITCHING_TO_DEFAULT_CONTENT_MSG);
		getDriver().switchTo().defaultContent();
		logger.debug(CLICKING_ADDRESS_IN_LIST_MSG);
		tv.clickAddressInList();
		logger.debug(CLICKING_INSERT_ELEMENT_BUTTON_MSG);
		tv.insertElementBtn();
		logger.debug(CLICKING_TEXT_VARIABLE_PLUGIN_MSG);
		tv.clickTextVariablePlugin();
		logger.debug(CLICKING_ENTITY_CHECKBOX_1_MSG);
		tv.clickEntityCheckbox1();
		logger.debug(CLICKING_VARIABLE_INSERT_BTN_MSG);
		tv.clickVariableInsertBtn();
		logger.debug(CLICKING_ACCEPT_CHANGE_MSG);
		tv.clickAcceptChange();
		logger.debug(SWITCHING_TO_FRAME_0_MSG);
		getDriver().switchTo().frame(FRAME_0);
		logger.debug(ASSERTING_VARIABLE_INSERTED_IN_VE_MSG);
		Assert.assertTrue(tv.isNewlyInsertedVariableVE());
		logger.debug(SWITCHING_TO_DEFAULT_CONTENT_MSG);
		getDriver().switchTo().defaultContent();
		logger.info(FINISHED_TEST_MSG + "verifyInsertAddressandTextVaraibleinPartyinfo");
	}

	@Test(enabled = true, groups = { GROUP_TEXT_VARIABLE, P2_TEXT_VARIABLE })
	public void verifyInsertAddressandTextVaraibleinAddressdetails() {
		logger.info(STARTING_TEST_MSG + "verifyInsertAddressandTextVaraibleinAddressdetails");
		logger.debug(CALLING_LOGIN_AND_SEARCH_FILE_CLICK_EDIT_MSG);
		ReusableMethods.loginAndSearchFileClickEdit();
		logger.debug(INSTANTIATED_TEXT_VARIABLE_OBJECT_MSG);
		TextVariablePageObjects tv = new TextVariablePageObjects(getDriver());
		logger.debug(SWITCHING_TO_FRAME_0_MSG);
		getDriver().switchTo().frame(FRAME_0);
		logger.debug(WAITING_FOR_LOADER_TO_DISAPPEAR_MSG);
		tv.waitForLoaderToDisappear();
		logger.debug(RIGHT_CLICKING_ON_VE_FIRST_PARA);
		tv.rightClickElement(tv.getVeFirstPara());
		logger.debug(SWITCHING_TO_DEFAULT_CONTENT_MSG);
		getDriver().switchTo().defaultContent();
		logger.debug(SWITCHING_TO_FRAME_1_MSG);
		getDriver().switchTo().frame(FRAME_1);
		logger.debug(CLICKING_RIGHT_CLICK_INSERT_AFTER_VE_MSG);
		tv.clickRightClickInsertAfterVE();
		logger.debug(SWITCHING_TO_DEFAULT_CONTENT_MSG);
		getDriver().switchTo().defaultContent();
		logger.debug(CLICKING_ADDRESS_IN_LIST_MSG);
		tv.clickAddressInList();
		logger.debug(CLICKING_INSERT_ELEMENT_BUTTON_MSG);
		tv.insertElementBtn();
		logger.debug(SWITCHING_TO_FRAME_0_MSG);
		getDriver().switchTo().frame(0);
		logger.debug("Clicking on address details para VE.");
		tv.clickOnAddressDetailsParaVE();
		logger.debug(SWITCHING_TO_DEFAULT_CONTENT_MSG);
		getDriver().switchTo().defaultContent();
		logger.debug(CLICKING_TEXT_VARIABLE_PLUGIN_MSG);
		tv.clickTextVariablePlugin();
		logger.debug(CLICKING_ENTITY_CHECKBOX_1_MSG);
		tv.clickEntityCheckbox1();
		logger.debug(CLICKING_VARIABLE_INSERT_BTN_MSG);
		tv.clickVariableInsertBtn();
		logger.debug(CLICKING_ACCEPT_CHANGE_MSG);
		tv.clickAcceptChange();
		logger.debug(SWITCHING_TO_FRAME_0_MSG);
		getDriver().switchTo().frame(FRAME_0);
		logger.debug(ASSERTING_VARIABLE_INSERTED_IN_VE_MSG);
		Assert.assertTrue(tv.isNewlyInsertedVariableVE());
		logger.debug(SWITCHING_TO_DEFAULT_CONTENT_MSG);
		getDriver().switchTo().defaultContent();
		logger.info(FINISHED_TEST_MSG + "verifyInsertAddressandTextVaraibleinAddressdetails");
	}

	@Test(enabled = true, groups = { GROUP_TEXT_VARIABLE, P2_TEXT_VARIABLE })
	public void verifyInsertfigureheadingandTextVaraible() {
		logger.info(STARTING_TEST_MSG + "verifyInsertfigureheadingandTextVaraible");
		logger.debug(CALLING_LOGIN_AND_SEARCH_FILE_CLICK_EDIT_MSG);
		ReusableMethods.loginAndSearchFileClickEdit();
		logger.debug(INSTANTIATED_TEXT_VARIABLE_OBJECT_MSG);
		TextVariablePageObjects tv = new TextVariablePageObjects(getDriver());
		logger.debug(WAITING_FOR_LOADER_TO_DISAPPEAR_MSG);
		tv.waitForLoaderToDisappear();
		logger.debug(INSTANTIATED_ACTIONS_OBJECT_MSG);
		Actions action = new Actions(getDriver());
		logger.debug(SWITCHING_TO_FRAME_0_MSG);
		getDriver().switchTo().frame(FRAME_0);
		logger.debug(INSTANTIATED_BASE_PAGE_OBJECT_MSG);
		BasePage bp = new BasePage(getDriver());
		logger.debug(RIGHT_CLICKING_ON_VE_FIRST_PARA);
		bp.rightClickElement(tv.getVeFirstPara());
		logger.debug(SWITCHING_TO_DEFAULT_CONTENT_MSG);
		getDriver().switchTo().defaultContent();
		logger.debug(SWITCHING_TO_FRAME_1_MSG);
		getDriver().switchTo().frame(FRAME_1);
		logger.debug(CLICKING_RIGHT_CLICK_INSERT_AFTER_VE_MSG);
		tv.clickRightClickInsertAfter();
		logger.debug(SWITCHING_TO_DEFAULT_CONTENT_MSG);
		getDriver().switchTo().defaultContent();
		logger.debug(CLICKING_FIGURE_IN_LIST_MSG);
		tv.clickFigureInList();
		logger.debug(CLICKING_INSERT_ELEMENT_BUTTON_MSG);
		tv.insertElementBtn();
		logger.debug(CLICKING_IMG_INSERT_FROM_INSERT_PLUGIN_MSG);
		tv.clickImgInsertFromInsertPlugin();
		logger.debug(CLICKING_INSERT_BUTTON_MSG);
		tv.clickInsertButton();
		logger.debug(SENDING_UP_KEY_MSG);
		action.sendKeys(Keys.UP).perform();
		logger.debug(CLICKING_TEXT_VARIABLE_PLUGIN_MSG);
		tv.clickTextVariablePlugin();
		logger.debug(CLICKING_ENTITY_CHECKBOX_1_MSG);
		tv.clickEntityCheckbox1();
		logger.debug(CLICKING_VARIABLE_INSERT_BTN_MSG);
		tv.clickVariableInsertBtn();
		logger.debug(CLICKING_ACCEPT_CHANGE_MSG);
		tv.clickAcceptChange();
		logger.debug(SWITCHING_TO_FRAME_0_MSG);
		getDriver().switchTo().frame(FRAME_0);
		logger.debug(ASSERTING_VARIABLE_INSERTED_IN_VE_MSG);
		Assert.assertTrue(tv.isNewlyInsertedVariableVE());
		logger.debug(SWITCHING_TO_DEFAULT_CONTENT_MSG);
		getDriver().switchTo().defaultContent();
		logger.info(FINISHED_TEST_MSG + "verifyInsertfigureheadingandTextVaraible");
	}

	@Test(enabled = true, groups = { GROUP_TEXT_VARIABLE, P2_TEXT_VARIABLE })
	public void verifyInsertTextVaraibleinParaEnterKey() {
		logger.info(STARTING_TEST_MSG + "verifyInsertTextVaraibleinParaEnterKey");
		logger.debug(CALLING_LOGIN_AND_SEARCH_FILE_TEXT_VARIABLE_CLICK_EDIT_MSG);
		ReusableMethods.loginAndSearchFileTextVariableClickEdit();
		logger.debug(INSTANTIATED_TEXT_VARIABLE_OBJECT_MSG);
		TextVariablePageObjects tv = new TextVariablePageObjects(getDriver());
		logger.debug(WAITING_FOR_LOADER_TO_DISAPPEAR_MSG);
		tv.waitForLoaderToDisappear();
		logger.debug(CLICKING_DS_SECTION_MSG);
		tv.clickDSSection();
		logger.debug(CLICKING_FIRST_PARA_MSG);
		tv.clickfirstparaElement();
		logger.debug(INSTANTIATED_ACTIONS_OBJECT_MSG);
		Actions action = new Actions(getDriver());
		logger.debug(CLICKING_TEXT_VARIABLE_PLUGIN_MSG);
		tv.clickTextVariablePlugin();
		logger.debug(CLICKING_ENTITY_CHECKBOX_1_MSG);
		tv.clickEntityCheckbox1();
		logger.debug(CLICKING_VARIABLE_INSERT_BTN_MSG);
		tv.clickVariableInsertBtn();
		logger.debug(CLICKING_ACCEPT_CHANGE_MSG);
		tv.clickAcceptChange();
		logger.debug(SWITCHING_TO_FRAME_0_MSG);
		getDriver().switchTo().frame(FRAME_0);
		logger.debug(ASSERTING_VARIABLE_INSERTED_IN_VE_MSG);
		Assert.assertTrue(tv.isNewlyInsertedVariableVE());
		logger.debug(CLICKING_NEWLY_INSERTED_VARIABLE_VE);
		tv.clickNewlyInsertedVariableVe();
		logger.debug(SWITCHING_TO_DEFAULT_CONTENT_MSG);
		getDriver().switchTo().defaultContent();
		logger.debug(SENDING_ENTER_KEY_MSG);
		action.sendKeys(Keys.ENTER).perform();
		logger.debug(CLICKING_TEXT_VARIABLE_PLUGIN_MSG);
		tv.clickTextVariablePlugin();
		logger.debug(CLICKING_ENTITY_CHECKBOX_1_MSG);
		tv.clickEntityCheckbox1();
		logger.debug(CLICKING_VARIABLE_INSERT_BTN_MSG);
		tv.clickVariableInsertBtn();
		logger.debug(SWITCHING_TO_FRAME_0_MSG);
		getDriver().switchTo().frame(FRAME_0);
		boolean flag = tv.isDataFliteCid2();
		logger.debug(ASSERTING_TRUE_MSG);
		Assert.assertTrue(flag);
		logger.debug(SWITCHING_TO_DEFAULT_CONTENT_MSG);
		getDriver().switchTo().defaultContent();
		logger.info(FINISHED_TEST_MSG + "verifyInsertTextVaraibleinParaEnterKey");
	}

	@Test(enabled = true, groups = { GROUP_TEXT_VARIABLE, P2_TEXT_VARIABLE })
	public void verifyInsertTextVaraibleinParaPressLeft() {
		logger.info(STARTING_TEST_MSG + "verifyInsertTextVaraibleinParaPressLeft");
		logger.debug(CALLING_LOGIN_AND_SEARCH_FILE_TEXT_VARIABLE_CLICK_EDIT_MSG);
		ReusableMethods.loginAndSearchFileTextVariableClickEdit();
		logger.debug(INSTANTIATED_TEXT_VARIABLE_OBJECT_MSG);
		TextVariablePageObjects tv = new TextVariablePageObjects(getDriver());
		logger.debug(WAITING_FOR_LOADER_TO_DISAPPEAR_MSG);
		tv.waitForLoaderToDisappear();
		logger.debug(CLICKING_DS_SECTION_MSG);
		tv.clickDSSection();
		logger.debug(SWITCHING_TO_FRAME_0_MSG);
		getDriver().switchTo().frame(FRAME_0);
		logger.debug(CLICKING_VE_FIRST_PARA_MSG);
		tv.clickVEFirstPara();
		logger.debug(SWITCHING_TO_DEFAULT_CONTENT_MSG);
		getDriver().switchTo().defaultContent();
		logger.debug(CLICKING_TEXT_VARIABLE_PLUGIN_MSG);
		tv.clickTextVariablePlugin();
		logger.debug(CLICKING_ENTITY_CHECKBOX_1_MSG);
		tv.clickEntityCheckbox1();
		logger.debug(CLICKING_VARIABLE_INSERT_BTN_MSG);
		tv.clickVariableInsertBtn();
		logger.debug(CLICKING_ACCEPT_CHANGE_MSG);
		tv.clickAcceptChange();
		logger.debug(SWITCHING_TO_FRAME_0_MSG);
		getDriver().switchTo().frame(FRAME_0);
		logger.debug(ASSERTING_VARIABLE_INSERTED_IN_VE_MSG);
		Assert.assertTrue(tv.isNewlyInsertedVariableVE());
		logger.debug(CLICKING_NEWLY_INSERTED_VARIABLE_VE);
		tv.clickNewlyInsertedVariableVe();
		logger.debug(SWITCHING_TO_DEFAULT_CONTENT_MSG);
		getDriver().switchTo().defaultContent();
		logger.debug(INSTANTIATED_ACTIONS_OBJECT_MSG);
		Actions action = new Actions(getDriver());
		logger.debug(CLICKING_SECOND_PARA_CB_MSG);
		tv.clickSecondParaCb();
		for (int i = 0; i < 250; i++) {
			logger.debug(SENDING_LEFT_KEY_ITERATION_MSG, i + 1);
			action.sendKeys(Keys.LEFT).perform();
		}
		boolean flag = tv.getSelectedCB().getAttribute(ATTRIBUTE_ID).contains("3");
		logger.debug(ASSERTING_TRUE_MSG);
		Assert.assertTrue(flag);
		logger.info(FINISHED_TEST_MSG + "verifyInsertTextVaraibleinParaPressLeft");
	}

	@Test(enabled = true, groups = { GROUP_TEXT_VARIABLE, P2_TEXT_VARIABLE })
	public void verifyImgandInsertextvaraibleInfo() {
		logger.info(STARTING_TEST_MSG + "verifyImgandInsertextvaraibleInfo");
		logger.debug(CALLING_LOGIN_AND_SEARCH_FILE_TEXT_VARIABLE_CLICK_EDIT_MSG);
		ReusableMethods.loginAndSearchFileTextVariableClickEdit();
		logger.debug(INSTANTIATED_TEXT_VARIABLE_OBJECT_MSG);
		TextVariablePageObjects tv = new TextVariablePageObjects(getDriver());
		logger.debug(WAITING_FOR_LOADER_TO_DISAPPEAR_MSG);
		tv.waitForLoaderToDisappear();
		logger.debug(CLICKING_FIRST_PARA_MSG);
		tv.clickfirstparaElement();
		logger.debug(CLICKING_INSERT_PLUGIN_MSG);
		tv.clickInsertPlugin();
		logger.debug(CLICKING_IMG_INSIDE_MSG);
		tv.clickImgInside();
		WebElement img = tv.getFirstImgInsertPopup();
		if (tv.isDisplayedFirstImgInsertPopup()) {
			logger.debug(INSTANTIATED_ACTIONS_OBJECT_MSG);
			Actions action = new Actions(getDriver());
			logger.debug("Clicking image.");
			action.click(img).perform();
		} else {
			logger.debug(CLICKING_SYMBOLS_TAB_MSG);
			tv.clickSymbolsTab();
			logger.debug(CLICKING_IMG_INSIDE_MSG);
			tv.clickImgInside();
			logger.debug(INSTANTIATED_ACTIONS_OBJECT_MSG);
			Actions action = new Actions(getDriver());
			logger.debug("Clicking image.");
			action.click(img).perform();
		}
		logger.debug(CLICKING_INSERT_AFTER_ELEMENT_MSG);
		tv.clickInsertAfterElement();
		logger.debug(CLICKING_INSERT_BUTTON_MSG);
		tv.clickInsertButton();
		logger.debug(CLICKING_TEXT_VARIABLE_PLUGIN_MSG);
		tv.clickTextVariablePlugin();
		boolean flag = tv.getBootstrapGrowl().isDisplayed();
		logger.debug(ASSERTING_TRUE_MSG);
		Assert.assertTrue(flag);
		logger.info(FINISHED_TEST_MSG + "verifyImgandInsertextvaraibleInfo");
	}

	@Test(enabled = true, groups = { GROUP_TEXT_VARIABLE, P2_TEXT_VARIABLE })
	public void verifyInsertTextVaraibleUndo() {
		logger.info(STARTING_TEST_MSG + "verifyInsertTextVaraibleUndo");
		logger.debug(CALLING_LOGIN_AND_SEARCH_FILE_TEXT_VARIABLE_CLICK_EDIT_MSG);
		ReusableMethods.loginAndSearchFileTextVariableClickEdit();
		logger.debug(INSTANTIATED_TEXT_VARIABLE_OBJECT_MSG);
		TextVariablePageObjects tv = new TextVariablePageObjects(getDriver());
		logger.debug(SWITCHING_TO_FRAME_0_MSG);
		getDriver().switchTo().frame(FRAME_0);
		logger.debug(CLICKING_VE_FIRST_PARA_MSG);
		tv.clickVEFirstPara();
		logger.debug(SWITCHING_TO_DEFAULT_CONTENT_MSG);
		getDriver().switchTo().defaultContent();
		logger.debug(CLICKING_TEXT_VARIABLE_PLUGIN_MSG);
		tv.clickTextVariablePlugin();
		logger.debug(CLICKING_ENTITY_CHECKBOX_1_MSG);
		tv.clickEntityCheckbox1();
		logger.debug(CLICKING_VARIABLE_INSERT_BTN_MSG);
		tv.clickVariableInsertBtn();
		logger.debug(CLICKING_UNDO_MSG);
		tv.clickUndo();
		logger.debug(SWITCHING_TO_FRAME_0_MSG);
		getDriver().switchTo().frame(FRAME_0);
		logger.debug(ASSERTING_FALSE_MSG);
		Assert.assertFalse(tv.isNewlyInsertedVariableVE());
		logger.debug(SWITCHING_TO_DEFAULT_CONTENT_MSG);
		getDriver().switchTo().defaultContent();
		logger.info(FINISHED_TEST_MSG + "verifyInsertTextVaraibleUndo");
	}

	@Test(enabled = true, groups = { GROUP_TEXT_VARIABLE, P2_TEXT_VARIABLE })
	public void verifyInserttextVariableinNewParaRejectChanges() {
		logger.info(STARTING_TEST_MSG + "verifyInserttextVariableinNewParaRejectChanges");
		logger.debug(CALLING_LOGIN_AND_SEARCH_FILE_TEXT_VARIABLE_CLICK_EDIT_MSG);
		ReusableMethods.loginAndSearchFileTextVariableClickEdit();
		logger.debug(INSTANTIATED_TEXT_VARIABLE_OBJECT_MSG);
		TextVariablePageObjects tv = new TextVariablePageObjects(getDriver());
		logger.debug(WAITING_FOR_LOADER_TO_DISAPPEAR_MSG);
		tv.waitForLoaderToDisappear();
		logger.debug(CLICKING_DS_SECTION_MSG);
		tv.clickDSSection();
		logger.debug(CLICKING_FIRST_PARA_MSG);
		tv.clickfirstparaElement();
		logger.debug(INSTANTIATED_ACTIONS_OBJECT_MSG);
		Actions action = new Actions(getDriver());
		logger.debug(SENDING_ENTER_KEY_MSG);
		action.sendKeys(Keys.ENTER).perform();
		logger.debug(CLICKING_TEXT_VARIABLE_PLUGIN_MSG);
		tv.clickTextVariablePlugin();
		logger.debug(CLICKING_ENTITY_CHECKBOX_1_MSG);
		tv.clickEntityCheckbox1();
		logger.debug(CLICKING_VARIABLE_INSERT_BTN_MSG);
		tv.clickVariableInsertBtn();
		logger.debug(SWITCHING_TO_FRAME_0_MSG);
		getDriver().switchTo().frame(FRAME_0);
		logger.debug(ASSERTING_VARIABLE_INSERTED_IN_VE_MSG);
		Assert.assertTrue(tv.isNewlyInsertedVariableVE());
		logger.debug(SWITCHING_TO_DEFAULT_CONTENT_MSG);
		getDriver().switchTo().defaultContent();
		logger.debug(CLICKING_ON_REJECT_CHANGES_MSG);
		tv.clickOnRejectChanges();
		logger.debug(SWITCHING_TO_FRAME_0_MSG);
		getDriver().switchTo().frame(FRAME_0);
		logger.debug(ASSERTING_NEW_PARA_VE_PRESENT_MSG);
		Assert.assertTrue(tv.isNewParaVePresent());
		logger.info(FINISHED_TEST_MSG + "verifyInserttextVariableinNewParaRejectChanges");
	}

	@Test(enabled = true, groups = { GROUP_TEXT_VARIABLE, P2_TEXT_VARIABLE })
	public void verifyInsertCommentTotextVariable() {
		logger.info(STARTING_TEST_MSG + "verifyInsertCommentTotextVariable");
		logger.debug(CALLING_LOGIN_AND_SEARCH_FILE_TEXT_VARIABLE_CLICK_EDIT_MSG);
		ReusableMethods.loginAndSearchFileTextVariableClickEdit();
		logger.debug(INSTANTIATED_TEXT_VARIABLE_OBJECT_MSG);
		TextVariablePageObjects tv = new TextVariablePageObjects(getDriver());
		logger.debug(WAITING_FOR_LOADER_TO_DISAPPEAR_MSG);
		tv.waitForLoaderToDisappear();
		logger.debug(CLICKING_DS_SECTION_MSG);
		tv.clickDSSection();
		logger.debug(CLICKING_FIRST_PARA_MSG);
		tv.clickfirstparaElement();
		logger.debug(CLICKING_TEXT_VARIABLE_PLUGIN_MSG);
		tv.clickTextVariablePlugin();
		logger.debug(CLICKING_ENTITY_CHECKBOX_1_MSG);
		tv.clickEntityCheckbox1();
		logger.debug(CLICKING_VARIABLE_INSERT_BTN_MSG);
		tv.clickVariableInsertBtn();
		logger.debug(CLICKING_ON_ACCEPT_CHANGES_MSG);
		tv.clickOnAcceptChanges();
		logger.debug(SWITCHING_TO_FRAME_0_MSG);
		getDriver().switchTo().frame(FRAME_0);
		logger.debug(ASSERTING_VARIABLE_INSERTED_IN_VE_MSG);
		Assert.assertTrue(tv.isNewlyInsertedVariableVE());
		logger.debug(SWITCHING_TO_DEFAULT_CONTENT_MSG);
		getDriver().switchTo().defaultContent();
		logger.debug(CLICKING_ON_ADD_COMMENT_MSG);
		tv.clickOnAddComment();
		boolean cmpopup = tv.isElementCommentPopupBoxPresent();
		logger.debug(ASSERTING_ELEMENT_COMMENT_POPUP_BOX_PRESENT_MSG);
		Assert.assertTrue(cmpopup);
		logger.debug(ENTERING_COMMENT_TEXT_MSG);
		tv.enterCommentText();
		logger.debug(CLICKING_ON_SUBMIT_BUTTON_MSG);
		tv.clickOnSubmitButton();
		logger.debug(SWITCHING_TO_FRAME_0_MSG);
		getDriver().switchTo().frame(FRAME_0);
		String backColor = tv.getCommentedTextHighlighted();
		logger.info(backColor);
		logger.debug(ASSERTING_EQUALS_MSG);
		Assert.assertEquals(backColor, COLOR_COMMENT_HIGHLIGHTED);
		logger.info(FINISHED_TEST_MSG + "verifyInsertCommentTotextVariable");
	}

	@Test(enabled = true, groups = { GROUP_TEXT_VARIABLE, P2_TEXT_VARIABLE })
	public void verifyInserttextVariableTableCheckMgs() {
		logger.info(STARTING_TEST_MSG + "verifyInserttextVariableTableCheckMgs");
		logger.debug(CALLING_LOGIN_AND_SEARCH_FILE_TEXT_VARIABLE_CLICK_EDIT_MSG);
		ReusableMethods.loginAndSearchFileTextVariableClickEdit();
		logger.debug(INSTANTIATED_TEXT_VARIABLE_OBJECT_MSG);
		TextVariablePageObjects tv = new TextVariablePageObjects(getDriver());
		logger.debug("Inserting table via ReusableMethods.");
		ReusableMethods.insertTableCB();
		logger.debug(CLICKING_ACCEPT_CHANGE);
		tv.clickAcceptChange();
		logger.debug(SWITCHING_TO_FRAME_0_MSG);
		getDriver().switchTo().frame(FRAME_0);
		logger.debug("Clicking inserted table first cell.");
		tv.clickInsertedTblFirstCell();
		logger.debug(INSTANTIATED_ACTIONS_OBJECT_MSG);
		Actions action = new Actions(getDriver());
		logger.debug(SENDING_ARROW_LEFT_KEY_MSG);
		action.sendKeys(Keys.ARROW_LEFT).perform();
		logger.debug(SWITCHING_TO_DEFAULT_CONTENT_MSG);
		getDriver().switchTo().defaultContent();
		logger.debug(CLICKING_TEXT_VARIABLE_PLUGIN_MSG);
		tv.clickTextVariablePlugin();
		boolean flag = tv.isTextVariableListPopup();
		logger.debug(ASSERTING_TRUE_MSG);
		Assert.assertTrue(flag);
		logger.info(FINISHED_TEST_MSG + "verifyInserttextVariableTableCheckMgs");
	}


	@Test(enabled = true, groups = { GROUP_TEXT_VARIABLE, P2_TEXT_VARIABLE })
	public void verifyElemntsAndAttributeOptionOnRCtextVariable() {
		logger.info(STARTING_TEST_MSG + "verifyElemntsAndAttributeOptionOnRCtextVariable");
		logger.debug(CALLING_LOGIN_AND_SEARCH_FILE_TEXT_VARIABLE_CLICK_EDIT_MSG);
		ReusableMethods.loginAndSearchFileTextVariableClickEdit();
		logger.debug(INSTANTIATED_TEXT_VARIABLE_OBJECT_MSG);
		TextVariablePageObjects tv = new TextVariablePageObjects(getDriver());
		logger.debug(WAITING_FOR_LOADER_TO_DISAPPEAR_MSG);
		tv.waitForLoaderToDisappear();
		logger.debug(CLICKING_DS_SECTION_MSG);
		tv.clickDSSection();
		logger.debug(CLICKING_FIRST_PARA_MSG);
		tv.clickfirstparaElement();
		logger.debug(CLICKING_TEXT_VARIABLE_PLUGIN_MSG);
		tv.clickTextVariablePlugin();
		logger.debug(CLICKING_ENTITY_CHECKBOX_1_MSG);
		tv.clickEntityCheckbox1();
		logger.debug(CLICKING_VARIABLE_INSERT_BTN_MSG);
		tv.clickVariableInsertBtn();
		logger.debug(CLICKING_ON_ACCEPT_CHANGES_MSG);
		tv.clickOnAcceptChanges();
		logger.debug(SWITCHING_TO_FRAME_0_MSG);
		getDriver().switchTo().frame(FRAME_0);
		tv.newlyInsertedVariableVe();
		logger.debug(INSTANTIATED_BASE_PAGE_OBJECT_MSG);
		BasePage bp = new BasePage(getDriver());
		logger.debug(RIGHT_CLICKING_ON_NEWLY_INSERTED_VARIABLE_VE);
		bp.rightClickElement(tv.getNewlyInsertedVariableVe());
		logger.debug(SWITCHING_TO_DEFAULT_CONTENT_MSG);
		getDriver().switchTo().defaultContent();
		logger.debug(SWITCHING_TO_FRAME_1_MSG);
		getDriver().switchTo().frame(FRAME_1);
		boolean flag = tv.isRightClickElementsAttributePresent();
		logger.debug(ASSERTING_RIGHT_CLICK_ELEMENTS_ATTRIBUTE_NOT_PRESENT_MSG);
		Assert.assertFalse(flag);
		logger.info(FINISHED_TEST_MSG + "verifyElemntsAndAttributeOptionOnRCtextVariable");
	}

	@Test(enabled = true, groups = { GROUP_TEXT_VARIABLE, P2_TEXT_VARIABLE })
	public void verifyinserttextVariableCheckAttributeName() {
		logger.info(STARTING_TEST_MSG + "verifyinserttextVariableCheckAttributeName");
		logger.debug(CALLING_LOGIN_AND_SEARCH_FILE_TEXT_VARIABLE_CLICK_EDIT_MSG);
		ReusableMethods.loginAndSearchFileTextVariableClickEdit();
		logger.debug(INSTANTIATED_TEXT_VARIABLE_OBJECT_MSG);
		TextVariablePageObjects tv = new TextVariablePageObjects(getDriver());
		logger.debug(WAITING_FOR_LOADER_TO_DISAPPEAR_MSG);
		tv.waitForLoaderToDisappear();
		logger.debug(CLICKING_DS_SECTION_MSG);
		tv.clickDSSection();
		logger.debug(CLICKING_FIRST_PARA_MSG);
		tv.clickfirstparaElement();
		logger.debug(CLICKING_TEXT_VARIABLE_PLUGIN_MSG);
		tv.clickTextVariablePlugin();
		logger.debug(CLICKING_ENTITY_CHECKBOX_1_MSG);
		tv.clickEntityCheckbox1();
		logger.debug(CLICKING_VARIABLE_INSERT_BTN_MSG);
		tv.clickVariableInsertBtn();
		logger.debug(CLICKING_ON_ACCEPT_CHANGES_MSG);
		tv.clickOnAcceptChanges();
		logger.debug(CLICKING_ELEMENTS_AND_ATTRIBUTE_TAB_MSG);
		tv.clickElementsAndAttributeTab();
		logger.debug(ASSERTING_ATTRIBUTE_NAME_CONTAINS_VARIABLE_MSG);
		Assert.assertTrue(tv.getElementAttributeName().getText().contains(CONTAINS_VARIABLE));
		logger.info(FINISHED_TEST_MSG + "verifyinserttextVariableCheckAttributeName");
	}

	@Test(enabled = true, groups = { GROUP_TEXT_VARIABLE, P2_TEXT_VARIABLE })
	public void verifyinserttextVariableCheckBreadcrumbName() {
		logger.info(STARTING_TEST_MSG + "verifyinserttextVariableCheckBreadcrumbName");
		logger.debug(CALLING_LOGIN_AND_SEARCH_FILE_TEXT_VARIABLE_CLICK_EDIT_MSG);
		ReusableMethods.loginAndSearchFileTextVariableClickEdit();
		logger.debug(INSTANTIATED_TEXT_VARIABLE_OBJECT_MSG);
		TextVariablePageObjects tv = new TextVariablePageObjects(getDriver());
		logger.debug(WAITING_FOR_LOADER_TO_DISAPPEAR_MSG);
		tv.waitForLoaderToDisappear();
		logger.debug(CLICKING_DS_SECTION_MSG);
		tv.clickDSSection();
		logger.debug(CLICKING_FIRST_PARA_MSG);
		tv.clickfirstparaElement();
		logger.debug(CLICKING_TEXT_VARIABLE_PLUGIN_MSG);
		tv.clickTextVariablePlugin();
		logger.debug(CLICKING_ENTITY_CHECKBOX_1_MSG);
		tv.clickEntityCheckbox1();
		logger.debug(CLICKING_VARIABLE_INSERT_BTN_MSG);
		tv.clickVariableInsertBtn();
		logger.debug(CLICKING_ON_ACCEPT_CHANGES_MSG);
		tv.clickOnAcceptChanges();
		logger.debug(ASSERTING_BREADCRUMB_CONTAINS_VARIABLE_MSG);
		Assert.assertTrue(tv.getBreadcrumbVariable().getText().contains(CONTAINS_VARIABLE));
		logger.info(FINISHED_TEST_MSG + "verifyinserttextVariableCheckBreadcrumbName");
	}

	@Test(enabled = true, groups = { GROUP_TEXT_VARIABLE, P2_TEXT_VARIABLE })
	public void verifyinserttextVariableCheckImgSymbolPlugin() {
		logger.info(STARTING_TEST_MSG + "verifyinserttextVariableCheckImgSymbolPlugin");
		logger.debug(CALLING_LOGIN_AND_SEARCH_FILE_TEXT_VARIABLE_CLICK_EDIT_MSG);
		ReusableMethods.loginAndSearchFileTextVariableClickEdit();
		logger.debug(INSTANTIATED_TEXT_VARIABLE_OBJECT_MSG);
		TextVariablePageObjects tv = new TextVariablePageObjects(getDriver());
		logger.debug(WAITING_FOR_LOADER_TO_DISAPPEAR_MSG);
		tv.waitForLoaderToDisappear();
		logger.debug(CLICKING_DS_SECTION_MSG);
		tv.clickDSSection();
		logger.debug(CLICKING_FIRST_PARA_MSG);
		tv.clickfirstparaElement();
		logger.debug(CLICKING_TEXT_VARIABLE_PLUGIN_MSG);
		tv.clickTextVariablePlugin();
		logger.debug(CLICKING_ENTITY_CHECKBOX_1_MSG);
		tv.clickEntityCheckbox1();
		logger.debug(CLICKING_VARIABLE_INSERT_BTN_MSG);
		tv.clickVariableInsertBtn();
		logger.debug(CLICKING_ON_ACCEPT_CHANGES_MSG);
		tv.clickOnAcceptChanges();
		logger.debug(SWITCHING_TO_FRAME_0_MSG);
		getDriver().switchTo().frame(FRAME_0);
		tv.newlyInsertedVariableVe();
		logger.debug(SWITCHING_TO_DEFAULT_CONTENT_MSG);
		getDriver().switchTo().defaultContent();
		logger.debug(ASSERTING_IMAGE_PLUGIN_DISABLED_MSG);
		Assert.assertTrue(tv.getImagePluginTb().getAttribute(ATTRIBUTE_CLASS).endsWith(CLASS_DISABLED));
		logger.debug(ASSERTING_SYMBOL_PLUGIN_DISABLED_MSG);
		Assert.assertTrue(tv.getSymbolPluginTb().getAttribute(ATTRIBUTE_CLASS).endsWith(CLASS_DISABLED));
		logger.info(FINISHED_TEST_MSG + "verifyinserttextVariableCheckImgSymbolPlugin");
	}

	@Test(enabled = true, groups = { GROUP_TEXT_VARIABLE, P2_TEXT_VARIABLE })
	public void verifyinserttextVariableCheckRCChangeEntityOption() {
		logger.info(STARTING_TEST_MSG + "verifyinserttextVariableCheckRCChangeEntityOption");
		logger.debug(CALLING_LOGIN_AND_SEARCH_FILE_TEXT_VARIABLE_CLICK_EDIT_MSG);
		ReusableMethods.loginAndSearchFileTextVariableClickEdit();
		logger.debug(INSTANTIATED_TEXT_VARIABLE_OBJECT_MSG);
		TextVariablePageObjects tv = new TextVariablePageObjects(getDriver());
		logger.debug(WAITING_FOR_LOADER_TO_DISAPPEAR_MSG);
		tv.waitForLoaderToDisappear();
		logger.debug(CLICKING_DS_SECTION_MSG);
		tv.clickDSSection();
		logger.debug(CLICKING_FIRST_PARA_MSG);
		tv.clickfirstparaElement();
		logger.debug(CLICKING_TEXT_VARIABLE_PLUGIN_MSG);
		tv.clickTextVariablePlugin();
		logger.debug(CLICKING_ENTITY_CHECKBOX_1_MSG);
		tv.clickEntityCheckbox1();
		logger.debug(CLICKING_VARIABLE_INSERT_BTN_MSG);
		tv.clickVariableInsertBtn();
		logger.debug(CLICKING_ON_ACCEPT_CHANGES_MSG);
		tv.clickOnAcceptChanges();
		logger.debug(SWITCHING_TO_FRAME_0_MSG);
		getDriver().switchTo().frame(FRAME_0);
		tv.newlyInsertedVariableVe();
		logger.debug(INSTANTIATED_BASE_PAGE_OBJECT_MSG);
		BasePage bp = new BasePage(getDriver());
		logger.debug(RIGHT_CLICKING_ON_NEWLY_INSERTED_VARIABLE_VE);
		bp.rightClickElement(tv.getNewlyInsertedVariableVe());
		logger.debug(SWITCHING_TO_DEFAULT_CONTENT_MSG);
		getDriver().switchTo().defaultContent();
		logger.debug(SWITCHING_TO_FRAME_1_MSG);
		getDriver().switchTo().frame(FRAME_1);
		logger.debug(ASSERTING_CHANGE_TEXT_VARIABLE_OPTION_PRESENT_MSG);
		Assert.assertTrue(tv.getChangeTextVariableOpitionRC().getAttribute("aria-label")
				.contains(INFO_MESSAGE_CHANGE_TEXT_VARIABLE));
		logger.info(FINISHED_TEST_MSG + "verifyinserttextVariableCheckRCChangeEntityOption");
	}

	@Test(enabled = true, groups = { GROUP_TEXT_VARIABLE, P2_TEXT_VARIABLE })
	public void verifyinserttextVariableCheckTCcard() {
		logger.info(STARTING_TEST_MSG + "verifyinserttextVariableCheckTCcard");
		logger.debug(CALLING_LOGIN_AND_SEARCH_FILE_TEXT_VARIABLE_CLICK_EDIT_MSG);
		ReusableMethods.loginAndSearchFileTextVariableClickEdit();
		logger.debug(INSTANTIATED_TEXT_VARIABLE_OBJECT_MSG);
		TextVariablePageObjects tv = new TextVariablePageObjects(getDriver());
		logger.debug(WAITING_FOR_LOADER_TO_DISAPPEAR_MSG);
		tv.waitForLoaderToDisappear();
		logger.debug(CLICKING_DS_SECTION_MSG);
		tv.clickDSSection();
		logger.debug(CLICKING_FIRST_PARA_MSG);
		tv.clickfirstparaElement();
		logger.debug(CLICKING_TEXT_VARIABLE_PLUGIN_MSG);
		tv.clickTextVariablePlugin();
		logger.debug(CLICKING_ENTITY_CHECKBOX_1_MSG);
		tv.clickEntityCheckbox1();
		logger.debug(CLICKING_VARIABLE_INSERT_BTN_MSG);
		tv.clickVariableInsertBtn();
		logger.debug(CLICKING_ON_TRACK_CHANGE_BUTTON_MSG);
		tv.clickOnTrackChangeButton();
		boolean flag = tv.isElementPresentDataCard();
		logger.debug(ASSERTING_DATA_CARD_PRESENT_MSG);
		Assert.assertTrue(flag);
		logger.debug(ASSERTING_TC_CARD_DETAILS_CONTAINS_ADDED_MSG);
		Assert.assertTrue(tv.getTcCardDetails().getAttribute(ATTRIBUTE_INNER_TEXT).contains(INFO_ADDED_TEXT_VARIABLE));
		logger.info(FINISHED_TEST_MSG + "verifyinserttextVariableCheckTCcard");
	}

	@Test(enabled = true, groups = { GROUP_TEXT_VARIABLE, P2_TEXT_VARIABLE })
	public void verifyinserttextVariableAfterInlineStyle() {
		logger.info(STARTING_TEST_MSG + "verifyinserttextVariableAfterInlineStyle");
		logger.debug(CALLING_LOGIN_AND_SEARCH_FILE_TEXT_VARIABLE_CLICK_EDIT_MSG);
		ReusableMethods.loginAndSearchFileTextVariableClickEdit();
		logger.debug(INSTANTIATED_TEXT_VARIABLE_OBJECT_MSG);
		TextVariablePageObjects tv = new TextVariablePageObjects(getDriver());
		logger.debug(WAITING_FOR_LOADER_TO_DISAPPEAR_MSG);
		tv.waitForLoaderToDisappear();
		logger.debug(CLICKING_DS_SECTION_MSG);
		tv.clickDSSection();
		logger.debug(CLICKING_FIRST_PARA_MSG);
		tv.clickfirstparaElement();
		logger.debug(SWITCHING_TO_FRAME_0_MSG);
		getDriver().switchTo().frame(FRAME_0);
		logger.debug(DOUBLE_CLICKING_FIRST_PARA_MSG);
		tv.doubleClickFirstPara();
		logger.debug(SWITCHING_TO_DEFAULT_CONTENT_MSG);
		getDriver().switchTo().defaultContent();
		logger.debug(CLICKING_ON_BOLD_BUTTON_MSG);
		tv.clickOnBoldButton();
		logger.debug(CLICKING_ACCEPT_CHANGE_MSG);
		tv.clickAcceptChange();
		logger.debug(SWITCHING_TO_FRAME_0_MSG);
		getDriver().switchTo().frame(FRAME_0);
		logger.debug("Clicking on VE bold.");
		tv.clickOnVeBold();
		logger.debug(INSTANTIATED_BASE_PAGE_OBJECT_MSG);
		BasePage bp = new BasePage(getDriver());
		logger.debug("Right clicking on VE bold.");
		bp.rightClickElement(tv.getVeBold());
		logger.debug(SWITCHING_TO_DEFAULT_CONTENT_MSG);
		getDriver().switchTo().defaultContent();
		logger.debug(SWITCHING_TO_FRAME_1_MSG);
		getDriver().switchTo().frame(FRAME_1);
		logger.debug(CLICKING_RIGHT_CLICK_INSERT_AFTER_VE_MSG);
		tv.clickRightClickInsertAfter();
		logger.debug(SWITCHING_TO_DEFAULT_CONTENT_MSG);
		getDriver().switchTo().defaultContent();
		logger.debug(CLICKING_RC_POPUP_VARIABLE_ELEMENT_MSG);
		tv.clickRcPopupVariableElement();
		logger.debug(CLICKING_INSERT_ELEMENT_BTN_MSG);
		tv.clickInsertElement();
		logger.debug(CLICKING_ENTITY_CHECKBOX_1_MSG);
		tv.clickEntityCheckbox1();
		logger.debug(CLICKING_VARIABLE_INSERT_BTN_MSG);
		tv.clickVariableInsertBtn();
		logger.debug(CLICKING_ON_ACCEPT_CHANGES_MSG);
		tv.clickOnAcceptChanges();
		logger.debug(SWITCHING_TO_FRAME_0_MSG);
		getDriver().switchTo().frame(FRAME_0);
		boolean flag = tv.isVeTextVariableAfterBold();
		logger.debug(ASSERTING_VE_TEXT_VARIABLE_AFTER_BOLD_MSG);
		Assert.assertTrue(flag);
		logger.info(FINISHED_TEST_MSG + "verifyinserttextVariableAfterInlineStyle");
	}

	@Test(enabled = true, groups = { GROUP_TEXT_VARIABLE, P2_TEXT_VARIABLE })
	public void verifyinserttextVariableAfterInlineStyleFromDS() {
		logger.info(STARTING_TEST_MSG + "verifyinserttextVariableAfterInlineStyleFromDS");
		logger.debug(CALLING_LOGIN_AND_SEARCH_FILE_TEXT_VARIABLE_CLICK_EDIT_MSG);
		ReusableMethods.loginAndSearchFileTextVariableClickEdit();
		logger.debug(INSTANTIATED_TEXT_VARIABLE_OBJECT_MSG);
		TextVariablePageObjects tv = new TextVariablePageObjects(getDriver());
		logger.debug(WAITING_FOR_LOADER_TO_DISAPPEAR_MSG);
		tv.waitForLoaderToDisappear();
		logger.debug(CLICKING_DS_SECTION_MSG);
		tv.clickDSSection();
		logger.debug(CLICKING_FIRST_PARA_MSG);
		tv.clickfirstparaElement();
		logger.debug(SWITCHING_TO_FRAME_0_MSG);
		getDriver().switchTo().frame(FRAME_0);
		logger.debug(DOUBLE_CLICKING_FIRST_PARA_MSG);
		tv.doubleClickFirstPara();
		logger.debug(SWITCHING_TO_DEFAULT_CONTENT_MSG);
		getDriver().switchTo().defaultContent();
		logger.debug(CLICKING_ON_BOLD_BUTTON_MSG);
		tv.clickOnBoldButton();
		logger.debug(CLICKING_ACCEPT_CHANGE_MSG);
		tv.clickAcceptChange();
		logger.debug(RIGHT_CLICKING_ON_DS_B_MSG);
		tv.rightClickOnDsB();
		logger.debug(CLICKING_ON_INSERT_AFTER_DS_MSG);
		tv.clickOnInsertAfterDs();
		logger.debug(SWITCHING_TO_DEFAULT_CONTENT_MSG);
		getDriver().switchTo().defaultContent();
		logger.debug(INSTANTIATED_ACTIONS_OBJECT_MSG);
		Actions action = new Actions(getDriver());
		logger.debug(SENDING_KEYS_VARIABLE_TEXT_MSG);
		action.sendKeys(CONTAINS_VARIABLE).perform();
		logger.debug(CLICKING_RC_POPUP_VARIABLE_ELEMENT_MSG);
		tv.clickRcPopupVariableElement();
		boolean flag = tv.isTextVariableListPopup();
		logger.debug(ASSERTING_VARIABLE_LIST_POPUP_DISPLAYED_MSG);
		Assert.assertTrue(flag);
		logger.info(FINISHED_TEST_MSG + "verifyinserttextVariableAfterInlineStyleFromDS");
	}

	@Test(enabled = true, groups = { GROUP_TEXT_VARIABLE, P2_TEXT_VARIABLE })
	public void verifyinserttextVariableIntoNotesFromDs() {
		logger.info(STARTING_TEST_MSG + "verifyinserttextVariableIntoNotesFromDs");
		logger.debug(CALLING_LOGIN_AND_SEARCH_FILE_TEXT_VARIABLE_CLICK_EDIT_MSG);
		ReusableMethods.loginAndSearchFileTextVariableClickEdit();
		logger.debug(INSTANTIATED_TEXT_VARIABLE_OBJECT_MSG);
		TextVariablePageObjects tv = new TextVariablePageObjects(getDriver());
		logger.debug(WAITING_FOR_LOADER_TO_DISAPPEAR_MSG);
		tv.waitForLoaderToDisappear();
		logger.debug(SWITCHING_TO_FRAME_0_MSG);
		getDriver().switchTo().frame(FRAME_0);
		logger.debug(CLICKING_VE_FIRST_PARA_MSG);
		tv.clickVEFirstPara();
		logger.debug(RIGHT_CLICKING_FIRST_PARA_MSG);
		tv.rightClickFirstPara();
		logger.debug(SWITCHING_TO_DEFAULT_CONTENT_MSG);
		getDriver().switchTo().defaultContent();
		logger.debug(SWITCHING_TO_FRAME_1_MSG);
		getDriver().switchTo().frame(FRAME_1);
		logger.debug(CLICKING_RIGHT_CLICK_INSERT_AFTER_VE_MSG);
		tv.clickRightClickInsertAfter();
		logger.debug(SWITCHING_TO_DEFAULT_CONTENT_MSG);
		getDriver().switchTo().defaultContent();
		logger.debug(CLICKING_INSERT_AFTER_NOTES_MSG);
		tv.clickInsertAfterNotes();
		logger.debug(CLICKING_INSERT_ELEMENT_BUTTON_MSG);
		tv.clickInsertElementButton();
		logger.debug(CLICKING_ON_ACCEPT_CHANGES_MSG);
		tv.clickOnAcceptChanges();
		logger.debug(CLICKING_ON_ACCEPT_CHANGES_MSG);
		tv.clickOnAcceptChanges();
		logger.debug(CLICKING_ON_ACCEPT_CHANGES_MSG);
		tv.clickOnAcceptChanges();
		logger.debug(CLICKING_DS_NOTE_MSG);
		tv.clickDsNote();
		logger.debug(RIGHT_CLICKING_ON_DS_NOTE_MSG);
		tv.rightClickOnDsNote();
		logger.debug(CLICKING_INSERT_INTO_DS_MSG);
		tv.clickInsertIntoDs();
		logger.debug(INSTANTIATED_ACTIONS_OBJECT_MSG);
		Actions action = new Actions(getDriver());
		logger.debug(SENDING_KEYS_VARIABLE_TEXT_MSG);
		action.sendKeys(CONTAINS_VARIABLE).perform();
		boolean flag = tv.isRcPopupVariableElement();
		logger.debug(ASSERTING_RC_POPUP_VARIABLE_ELEMENT_MSG);
		Assert.assertTrue(flag);
		logger.info(FINISHED_TEST_MSG + "verifyinserttextVariableIntoNotesFromDs");
	}

	@Test(enabled = true, groups = { GROUP_TEXT_VARIABLE, P2_TEXT_VARIABLE })
	public void verifyinserttextVariableInNumparaHitEnter() {
		logger.info(STARTING_TEST_MSG + "verifyinserttextVariableInNumparaHitEnter");
		logger.debug(CALLING_LOGIN_AND_SEARCH_FILE_TEXT_VARIABLE_CLICK_EDIT_MSG);
		ReusableMethods.loginAndSearchFileTextVariableClickEdit();
		logger.debug(INSTANTIATED_TEXT_VARIABLE_OBJECT_MSG);
		TextVariablePageObjects tv = new TextVariablePageObjects(getDriver());
		logger.debug(WAITING_FOR_LOADER_TO_DISAPPEAR_MSG);
		tv.waitForLoaderToDisappear();
		logger.debug(SWITCHING_TO_FRAME_0_MSG);
		getDriver().switchTo().frame(FRAME_0);
		logger.debug(CLICKING_VE_FIRST_PARA_MSG);
		tv.clickVEFirstPara();
		logger.debug(RIGHT_CLICKING_FIRST_PARA_MSG);
		tv.rightClickFirstPara();
		logger.debug(SWITCHING_TO_DEFAULT_CONTENT_MSG);
		getDriver().switchTo().defaultContent();
		logger.debug(SWITCHING_TO_FRAME_1_MSG);
		getDriver().switchTo().frame(FRAME_1);
		logger.debug(CLICKING_RIGHT_CLICK_INSERT_AFTER_VE_MSG);
		tv.clickRightClickInsertAfter();
		logger.debug(SWITCHING_TO_DEFAULT_CONTENT_MSG);
		getDriver().switchTo().defaultContent();
		logger.debug(CLICKING_INSERT_AFTER_NUMBERED_PARA_MSG);
		tv.clickInsertAfterNumberedPara();
		logger.debug(CLICKING_INSERT_ELEMENT_BUTTON_MSG);
		tv.clickInsertElementButton();
		logger.debug(CLICKING_ON_ACCEPT_CHANGES_MSG);
		tv.clickOnAcceptChanges();
		logger.debug(CLICKING_ON_ACCEPT_CHANGES_MSG);
		tv.clickOnAcceptChanges();
		logger.debug(CLICKING_ON_ACCEPT_CHANGES_MSG);
		tv.clickOnAcceptChanges();
		logger.debug(INSTANTIATED_ACTIONS_OBJECT_MSG);
		Actions action = new Actions(getDriver());
		logger.debug(SENDING_ARROW_DOWN_KEY_MSG);
		action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_LEFT).perform();
		logger.debug(CLICKING_TEXT_VARIABLE_PLUGIN_MSG);
		tv.clickTextVariablePlugin();
		logger.debug(CLICKING_ENTITY_CHECKBOX_1_MSG);
		tv.clickEntityCheckbox1();
		logger.debug(CLICKING_VARIABLE_INSERT_BTN_MSG);
		tv.clickVariableInsertBtn();
		logger.debug(CLICKING_ON_ACCEPT_CHANGES_MSG);
		tv.clickOnAcceptChanges();
		logger.debug(SWITCHING_TO_FRAME_0_MSG);
		getDriver().switchTo().frame(FRAME_0);
		logger.debug(ASSERTING_VARIABLE_INSERTED_IN_VE_MSG);
		Assert.assertTrue(tv.isNewlyInsertedVariableVE());
		logger.info(FINISHED_TEST_MSG + "verifyinserttextVariableInNumparaHitEnter");
	}

	@Test(enabled = true, groups = { GROUP_TEXT_VARIABLE, P2_TEXT_VARIABLE })
	public void verifyCopyAndPastetextVariable() {
		logger.info(STARTING_TEST_MSG + "verifyCopyAndPastetextVariable");
		logger.debug(CALLING_LOGIN_AND_SEARCH_FILE_TEXT_VARIABLE_CLICK_EDIT_MSG);
		ReusableMethods.loginAndSearchFileTextVariableClickEdit();
		logger.debug(INSTANTIATED_TEXT_VARIABLE_OBJECT_MSG);
		TextVariablePageObjects tv = new TextVariablePageObjects(getDriver());
		logger.debug(WAITING_FOR_LOADER_TO_DISAPPEAR_MSG);
		tv.waitForLoaderToDisappear();
		logger.debug(CLICKING_DS_SECTION_MSG);
		tv.clickDSSection();
		logger.debug(CLICKING_FIRST_PARA_MSG);
		tv.clickfirstparaElement();
		logger.debug(CLICKING_TEXT_VARIABLE_PLUGIN_MSG);
		tv.clickTextVariablePlugin();
		logger.debug(CLICKING_ENTITY_CHECKBOX_1_MSG);
		tv.clickEntityCheckbox1();
		logger.debug(CLICKING_VARIABLE_INSERT_BTN_MSG);
		tv.clickVariableInsertBtn();
		logger.debug(CLICKING_ON_ACCEPT_CHANGES_MSG);
		tv.clickOnAcceptChanges();
		logger.debug(SWITCHING_TO_FRAME_0_MSG);
		getDriver().switchTo().frame(FRAME_0);
		tv.newlyInsertedVariableVe();
		logger.debug(INSTANTIATED_ACTIONS_OBJECT_MSG);
		Actions action = new Actions(getDriver());
		logger.debug(PERFORMING_CTRL_C_MSG);
		action.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
		logger.debug(CLICKING_VE_3RD_PARA_MSG);
		tv.clickVe3rdPara();
		logger.debug(PERFORMING_CTRL_V_MSG);
		action.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
		logger.debug(SWITCHING_TO_FRAME_0_MSG);
		getDriver().switchTo().frame(FRAME_0);
		logger.debug(ASSERTING_VARIABLE_PASTED_IN_VE_MSG);
		Assert.assertTrue(tv.isPastedTextVariableVe());
		logger.info(FINISHED_TEST_MSG + "verifyCopyAndPastetextVariable");
	}

	@Test(enabled = true, groups = { GROUP_TEXT_VARIABLE, P2_TEXT_VARIABLE })
	public void verifyInsertLinkButtonOnTextVariable() {
		logger.info(STARTING_TEST_MSG + "verifyInsertLinkButtonOnTextVariable");
		logger.debug(CALLING_LOGIN_AND_SEARCH_FILE_TEXT_VARIABLE_CLICK_EDIT_MSG);
		ReusableMethods.loginAndSearchFileTextVariableClickEdit();
		logger.debug(INSTANTIATED_TEXT_VARIABLE_OBJECT_MSG);
		TextVariablePageObjects tv = new TextVariablePageObjects(getDriver());
		logger.debug(WAITING_FOR_LOADER_TO_DISAPPEAR_MSG);
		tv.waitForLoaderToDisappear();
		logger.debug(CLICKING_DS_SECTION_MSG);
		tv.clickDSSection();
		logger.debug(CLICKING_FIRST_PARA_MSG);
		tv.clickfirstparaElement();
		logger.debug(CLICKING_TEXT_VARIABLE_PLUGIN_MSG);
		tv.clickTextVariablePlugin();
		logger.debug(CLICKING_ENTITY_CHECKBOX_1_MSG);
		tv.clickEntityCheckbox1();
		logger.debug(CLICKING_VARIABLE_INSERT_BTN_MSG);
		tv.clickVariableInsertBtn();
		logger.debug(CLICKING_ON_ACCEPT_CHANGES_MSG);
		tv.clickOnAcceptChanges();
		logger.debug(SWITCHING_TO_FRAME_0_MSG);
		getDriver().switchTo().frame(FRAME_0);
		tv.newlyInsertedVariableVe();
		logger.debug(SWITCHING_TO_DEFAULT_CONTENT_MSG);
		getDriver().switchTo().defaultContent();
		logger.debug(CLICKING_ON_CROSS_REF_BUTTON_MSG);
		tv.clickOnCrossRefButton();
		logger.debug("Asserting cross reference button is disabled.");
		Assert.assertTrue(tv.getCrossreferenceButton().getAttribute(ATTRIBUTE_ARIA_DISABLED).contains("true"));
		logger.info(FINISHED_TEST_MSG + "verifyInsertLinkButtonOnTextVariable");
	}

	@Test(enabled = true, groups = { GROUP_TEXT_VARIABLE, P2_TEXT_VARIABLE })
	public void verifyAddCommentToTVandHitBackspaceKey() {
		logger.info(STARTING_TEST_MSG + "verifyAddCommentToTVandHitBackspaceKey");
		logger.debug(CALLING_LOGIN_AND_SEARCH_FILE_TEXT_VARIABLE_CLICK_EDIT_MSG);
		ReusableMethods.loginAndSearchFileTextVariableClickEdit();
		logger.debug(INSTANTIATED_TEXT_VARIABLE_OBJECT_MSG);
		TextVariablePageObjects tv = new TextVariablePageObjects(getDriver());
		logger.debug(WAITING_FOR_LOADER_TO_DISAPPEAR_MSG);
		tv.waitForLoaderToDisappear();
		logger.debug(CLICKING_DS_SECTION_MSG);
		tv.clickDSSection();
		logger.debug(CLICKING_FIRST_PARA_MSG);
		tv.clickfirstparaElement();
		logger.debug(CLICKING_TEXT_VARIABLE_PLUGIN_MSG);
		tv.clickTextVariablePlugin();
		logger.debug(CLICKING_ENTITY_CHECKBOX_1_MSG);
		tv.clickEntityCheckbox1();
		logger.debug(CLICKING_VARIABLE_INSERT_BTN_MSG);
		tv.clickVariableInsertBtn();
		logger.debug(CLICKING_ON_ACCEPT_CHANGES_MSG);
		tv.clickOnAcceptChanges();
		logger.debug(SWITCHING_TO_DEFAULT_CONTENT_MSG);
		getDriver().switchTo().defaultContent();
		logger.debug(CLICKING_ON_ADD_COMMENT_MSG);
		tv.clickOnAddComment();
		logger.debug(ENTERING_COMMENT_TEXT_MSG);
		tv.enterCommentText();
		logger.debug(CLICKING_ON_SUBMIT_BUTTON_MSG);
		tv.clickOnSubmitButton();
		logger.debug(SWITCHING_TO_FRAME_0_MSG);
		getDriver().switchTo().frame(FRAME_0);
		tv.newlyInsertedVariableVe();
		logger.debug(SWITCHING_TO_DEFAULT_CONTENT_MSG);
		getDriver().switchTo().defaultContent();
		logger.debug(CLICKING_DS_2_PARA_MSG);
		tv.clickDs2Para();
		logger.debug(SWITCHING_TO_FRAME_0_MSG);
		getDriver().switchTo().frame(FRAME_0);
		logger.debug(INSTANTIATED_ACTIONS_OBJECT_MSG);
		Actions action = new Actions(getDriver());
		logger.debug(SENDING_HOME_KEY_MSG);
		action.sendKeys(Keys.HOME).sendKeys(Keys.ARROW_UP).perform();
		for (int i = 0; i < 4; i++) {
			logger.debug(SENDING_BACK_SPACE_KEY_MSG);
			action.sendKeys(Keys.BACK_SPACE).build().perform();
		}
		logger.debug(ASSERTING_TRUE_MSG);
		Assert.assertTrue(tv.getNewlyInsertedVariableVe().getAttribute(ATTRIBUTE_CLASS).contains(CONTAINS_ICE_DEL));
		logger.info(FINISHED_TEST_MSG + "verifyAddCommentToTVandHitBackspaceKey");
	}

	@Test(enabled = true, groups = { GROUP_TEXT_VARIABLE, P2_TEXT_VARIABLE })
	public void verifyAddTvInLiandHitEnter() {
		logger.info(STARTING_TEST_MSG + "verifyAddTvInLiandHitEnter");
		logger.debug(CALLING_LOGIN_AND_SEARCH_FILE_TEXT_VARIABLE_CLICK_EDIT_MSG);
		ReusableMethods.loginAndSearchFileTextVariableClickEdit();
		logger.debug(INSTANTIATED_TEXT_VARIABLE_OBJECT_MSG);
		TextVariablePageObjects tv = new TextVariablePageObjects(getDriver());
		logger.debug(WAITING_FOR_LOADER_TO_DISAPPEAR_MSG);
		tv.waitForLoaderToDisappear();
		logger.debug(CLICKING_DS_SECTION_MSG);
		tv.clickDSSection();
		logger.debug(CLICKING_FIRST_PARA_MSG);
		tv.clickfirstparaElement();
		logger.debug(INSTANTIATED_ACTIONS_OBJECT_MSG);
		Actions action = new Actions(getDriver());
		logger.debug(SENDING_ENTER_KEY_MSG);
		action.sendKeys(Keys.ENTER).perform();
		logger.debug(CLICKING_NUMBER_LIST_MSG);
		tv.clickNumberList();
		logger.debug(CLICKING_TEXT_VARIABLE_PLUGIN_MSG);
		tv.clickTextVariablePlugin();
		logger.debug(CLICKING_ENTITY_CHECKBOX_1_MSG);
		tv.clickEntityCheckbox1();
		logger.debug(CLICKING_VARIABLE_INSERT_BTN_MSG);
		tv.clickVariableInsertBtn();
		logger.debug(CLICKING_ON_ACCEPT_CHANGES_MSG);
		tv.clickOnAcceptChanges();
		logger.debug(SENDING_ENTER_KEY_MSG);
		action.sendKeys(Keys.ENTER).perform();
		boolean flag = tv.isNewInsertedLiDsPresent();
		logger.debug(ASSERTING_NEW_INSERTED_LI_DS_PRESENT_MSG);
		Assert.assertTrue(flag);
		logger.info(FINISHED_TEST_MSG + "verifyAddTvInLiandHitEnter");
	}

	@Test(enabled = true, groups = { GROUP_TEXT_VARIABLE, P2_TEXT_VARIABLE })
	public void verifyAddTvInNewParaAndHitEnter() {
		logger.info(STARTING_TEST_MSG + "verifyAddTvInNewParaAndHitEnter");
		logger.debug(CALLING_LOGIN_AND_SEARCH_FILE_TEXT_VARIABLE_CLICK_EDIT_MSG);
		ReusableMethods.loginAndSearchFileTextVariableClickEdit();
		logger.debug(INSTANTIATED_TEXT_VARIABLE_OBJECT_MSG);
		TextVariablePageObjects tv = new TextVariablePageObjects(getDriver());
		logger.debug(WAITING_FOR_LOADER_TO_DISAPPEAR_MSG);
		tv.waitForLoaderToDisappear();
		logger.debug(CLICKING_DS_SECTION_MSG);
		tv.clickDSSection();
		logger.debug(CLICKING_FIRST_PARA_MSG);
		tv.clickfirstparaElement();
		logger.debug(INSTANTIATED_ACTIONS_OBJECT_MSG);
		Actions action = new Actions(getDriver());
		logger.debug(SENDING_ENTER_KEY_MSG);
		action.sendKeys(Keys.ENTER).perform();
		logger.debug(CLICKING_TEXT_VARIABLE_PLUGIN_MSG);
		tv.clickTextVariablePlugin();
		logger.debug(CLICKING_ENTITY_CHECKBOX_1_MSG);
		tv.clickEntityCheckbox1();
		logger.debug(CLICKING_VARIABLE_INSERT_BTN_MSG);
		tv.clickVariableInsertBtn();
		logger.debug(CLICKING_ON_ACCEPT_CHANGES_MSG);
		tv.clickOnAcceptChanges();
		logger.debug(SENDING_ENTER_KEY_MSG);
		action.sendKeys(Keys.ENTER).perform();
		boolean flag = tv.isNewlyInsertedFirstParaCB();
		logger.debug(ASSERTING_NEWLY_INSERTED_FIRST_PARA_CB_MSG);
		Assert.assertTrue(flag);
		logger.info(FINISHED_TEST_MSG + "verifyAddTvInNewParaAndHitEnter");
	}

	@Test(enabled = true, groups = { GROUP_TEXT_VARIABLE, P2_TEXT_VARIABLE })
	public void verifyAddTvInPlaceCursorHitEnter() {
		logger.info(STARTING_TEST_MSG + "verifyAddTvInPlaceCursorHitEnter");
		logger.debug(CALLING_LOGIN_AND_SEARCH_FILE_TEXT_VARIABLE_CLICK_EDIT_MSG);
		ReusableMethods.loginAndSearchFileTextVariableClickEdit();
		logger.debug(INSTANTIATED_TEXT_VARIABLE_OBJECT_MSG);
		TextVariablePageObjects tv = new TextVariablePageObjects(getDriver());
		logger.debug(WAITING_FOR_LOADER_TO_DISAPPEAR_MSG);
		tv.waitForLoaderToDisappear();
		logger.debug(CLICKING_DS_SECTION_MSG);
		tv.clickDSSection();
		logger.debug(CLICKING_FIRST_PARA_MSG);
		tv.clickfirstparaElement();
		logger.debug(INSTANTIATED_ACTIONS_OBJECT_MSG);
		Actions action = new Actions(getDriver());
		logger.debug(SENDING_ENTER_KEY_MSG);
		action.sendKeys(Keys.ENTER).perform();
		logger.debug(CLICKING_TEXT_VARIABLE_PLUGIN_MSG);
		tv.clickTextVariablePlugin();
		logger.debug(CLICKING_ENTITY_CHECKBOX_1_MSG);
		tv.clickEntityCheckbox1();
		logger.debug(CLICKING_VARIABLE_INSERT_BTN_MSG);
		tv.clickVariableInsertBtn();
		logger.debug(CLICKING_ON_ACCEPT_CHANGES_MSG);
		tv.clickOnAcceptChanges();
		logger.debug(SENDING_ARROW_DOWN_KEY_MSG);
		action.sendKeys(Keys.ARROW_DOWN).perform();
		logger.debug(SENDING_ARROW_UP_KEY_MSG);
		action.sendKeys(Keys.ARROW_UP).perform();
		logger.debug(SENDING_ENTER_KEY_MSG);
		action.sendKeys(Keys.ENTER).perform();
		boolean flag = tv.isNewlyInsertedFirstParaCB();
		logger.debug(ASSERTING_NEWLY_INSERTED_FIRST_PARA_CB_MSG);
		Assert.assertTrue(flag);
		logger.info(FINISHED_TEST_MSG + "verifyAddTvInPlaceCursorHitEnter");
	}

	@Test(enabled = true, groups = { GROUP_TEXT_VARIABLE, P2_TEXT_VARIABLE })
	public void verifyinserttextVariableCheckRightClick() {
		logger.info(STARTING_TEST_MSG + "verifyinserttextVariableCheckRightClick");
		logger.debug(CALLING_LOGIN_AND_SEARCH_FILE_TEXT_VARIABLE_CLICK_EDIT_MSG);
		ReusableMethods.loginAndSearchFileTextVariableClickEdit();
		logger.debug(INSTANTIATED_TEXT_VARIABLE_OBJECT_MSG);
		TextVariablePageObjects tv = new TextVariablePageObjects(getDriver());
		logger.debug(WAITING_FOR_LOADER_TO_DISAPPEAR_MSG);
		tv.waitForLoaderToDisappear();
		logger.debug(CLICKING_DS_SECTION_MSG);
		tv.clickDSSection();
		logger.debug(CLICKING_FIRST_PARA_MSG);
		tv.clickfirstparaElement();
		logger.debug(CLICKING_TEXT_VARIABLE_PLUGIN_MSG);
		tv.clickTextVariablePlugin();
		logger.debug(CLICKING_ENTITY_CHECKBOX_1_MSG);
		tv.clickEntityCheckbox1();
		logger.debug(CLICKING_VARIABLE_INSERT_BTN_MSG);
		tv.clickVariableInsertBtn();
		logger.debug(CLICKING_ON_ACCEPT_CHANGES_MSG);
		tv.clickOnAcceptChanges();
		logger.debug(SWITCHING_TO_FRAME_0_MSG);
		getDriver().switchTo().frame(FRAME_0);
		tv.newlyInsertedVariableVe();
		logger.debug(INSTANTIATED_BASE_PAGE_OBJECT_MSG);
		BasePage bp = new BasePage(getDriver());
		logger.debug(RIGHT_CLICKING_ON_NEWLY_INSERTED_VARIABLE_VE);
		bp.rightClickElement(tv.getNewlyInsertedVariableVe());
		logger.info(FINISHED_TEST_MSG + "verifyinserttextVariableCheckRightClick");
	}

	@Test(enabled = true, groups = { GROUP_TEXT_VARIABLE, P2_TEXT_VARIABLE })
	public void verifytextVariablePluginForImage() {
		logger.info(STARTING_TEST_MSG + "verifytextVariablePluginForImage");
		logger.debug(CALLING_LOGIN_AND_SEARCH_FILE_TEXT_VARIABLE_CLICK_EDIT_MSG);
		ReusableMethods.loginAndSearchFileTextVariableClickEdit();
		logger.debug(INSTANTIATED_TEXT_VARIABLE_OBJECT_MSG);
		TextVariablePageObjects tv = new TextVariablePageObjects(getDriver());
		logger.debug(WAITING_FOR_LOADER_TO_DISAPPEAR_MSG);
		tv.waitForLoaderToDisappear();
		logger.debug(SWITCHING_TO_FRAME_0_MSG);
		getDriver().switchTo().frame(FRAME_0);
		logger.debug(CLICKING_ON_INLINE_IMAGE_VE_MSG);
		tv.clickOnInlineImageVe();
		logger.debug(SWITCHING_TO_DEFAULT_CONTENT_MSG);
		getDriver().switchTo().defaultContent();
		logger.debug(CLICKING_ON_INLINE_IMAGE_DS_MSG);
		tv.clickOnInlineImageDS();
		logger.debug(ASSERTING_TEXT_VARIABLE_PLUGIN_ENABLED_MSG);
		Assert.assertFalse(tv.getTextVariablePlugin().getAttribute(ATTRIBUTE_CLASS).endsWith(CLASS_DISABLED));
		logger.info(FINISHED_TEST_MSG + "verifytextVariablePluginForImage");
	}

	@Test(enabled = true, groups = { GROUP_TEXT_VARIABLE, P2_TEXT_VARIABLE })
	public void verifytextVariablePopupUsingInsertPlugin() {
		logger.info(STARTING_TEST_MSG + "verifytextVariablePopupUsingInsertPlugin");
		logger.debug(CALLING_LOGIN_AND_SEARCH_FILE_TEXT_VARIABLE_CLICK_EDIT_MSG);
		ReusableMethods.loginAndSearchFileTextVariableClickEdit();
		logger.debug(INSTANTIATED_TEXT_VARIABLE_OBJECT_MSG);
		TextVariablePageObjects tv = new TextVariablePageObjects(getDriver());
		logger.debug(WAITING_FOR_LOADER_TO_DISAPPEAR_MSG);
		tv.waitForLoaderToDisappear();
		logger.debug(CLICKING_DS_SECTION_MSG);
		tv.clickDSSection();
		logger.debug(CLICKING_FIRST_PARA_MSG);
		tv.clickfirstparaElement();
		logger.debug(CLICKING_INSERT_PLUGIN_MSG);
		tv.clickInsertPlugin();
		logger.debug(CLICKING_INSERT_INTO_ELEMENT_MSG);
		tv.clickInsertIntoElement();
		logger.debug(CLICKING_VARIABLE_QUICK_INSERT_MSG);
		tv.clickVariableQuickInsert();
		logger.debug(CLICKING_INSERT_BUTTON_MSG);
		tv.clickInsertButton();
		logger.debug(ASSERTING_VARIABLE_POPUP_DISPLAYED_MSG);
		Assert.assertTrue(tv.isVariablePopup());
		logger.info(FINISHED_TEST_MSG + "verifytextVariablePopupUsingInsertPlugin");
	}

	@Test(enabled = true, groups = { GROUP_TEXT_VARIABLE, P2_TEXT_VARIABLE })
	public void verifyChangetextVariableAndCheckTC() {
		logger.info(STARTING_TEST_MSG + "verifyChangetextVariableAndCheckTC");
		logger.debug(CALLING_LOGIN_AND_SEARCH_FILE_TEXT_VARIABLE_CLICK_EDIT_MSG);
		ReusableMethods.loginAndSearchFileTextVariableClickEdit();
		logger.debug(INSTANTIATED_TEXT_VARIABLE_OBJECT_MSG);
		TextVariablePageObjects tv = new TextVariablePageObjects(getDriver());
		logger.debug(WAITING_FOR_LOADER_TO_DISAPPEAR_MSG);
		tv.waitForLoaderToDisappear();
		logger.debug(CLICKING_DS_SECTION_MSG);
		tv.clickDSSection();
		logger.debug(CLICKING_FIRST_PARA_MSG);
		tv.clickfirstparaElement();
		logger.debug(CLICKING_INSERT_PLUGIN_MSG);
		tv.clickInsertPlugin();
		logger.debug(CLICKING_INSERT_INTO_ELEMENT_MSG);
		tv.clickInsertIntoElement();
		logger.debug(CLICKING_VARIABLE_QUICK_INSERT_MSG);
		tv.clickVariableQuickInsert();
		logger.debug(CLICKING_INSERT_BUTTON_MSG);
		tv.clickInsertButton();
		logger.info(FINISHED_TEST_MSG + "verifyChangetextVariableAndCheckTC");
	}

}