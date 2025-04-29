/**
 *
 * Test Script Name                   : N/A
 * Objective                          : Not approved billers management functionality.
 * Version                            : 1.0
 * Author                             : Kathirvelu M
 * Created Date                       : 23/05/2023
 * Last Updated on                    : N/A
 * Updated By                         : Dhruva Kumar S
 * Pre-Conditions                     : N/A
 * Epic Details                       : N/A
 * User Story Details                 : N/A
 **/
package com.azmqalabs.edaattestautomation.apppages.admin.pages;

import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.internal.TestMethodWithDataProviderMethodWorker;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.azmqalabs.edaattestautomation.apppages.GlobalConstant;
import com.azmqalabs.edaattestautomation.apppages.masterpages.BasePage;
import com.azmqalabs.edaattestautomation.common.Log;
import com.azmqalabs.edaattestautomation.common.uielement.fieldDecorator;
import com.azmqalabs.edaattestautomation.objectrepository.EdaatOR;
import com.azmqalabs.edaattestautomation.testscripts.admin.AdminNotApprovedMgmCloseBiller;
import com.azmqalabs.edaattestautomation.testscripts.admin.AdminSystemMngBillerMgmtVerifyNewCheckboxViewedAfterAdminCheckSubbillerCheckbox;
import com.google.inject.Key;

public class AdminNotApprovedBillerManagement extends BasePage {

	public AdminNotApprovedBillerManagement(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

		PageFactory.initElements(new fieldDecorator(driver, test), this);
	}

	@FindBy(xpath = EdaatOR.Admin_SystemMgm_SearchItem)
	public WebElement Client;

	public boolean Exists() {
		return super.Exists(Client);
	}
	//Function Summary   : Method to enter biller name  
	//Parameter Summary : searchItem
	public void enterOnSearchItem(String searchItem) {
		WebEdit(EdaatOR.Admin_SystemMgm_SearchItem, searchItem);
	}

	//Function Summary   : Method to click on "Search" button.
	//Parameter Summary : N/A
	public void clickOnSearchBtn() {

		WebClick(EdaatOR.Admin_SystemMgm_Searchbtn);
	}

	//Function Summary   : Method to search biller 
	//Parameter Summary :  Search
	public void searchNotApprovedBillerMgm(String CompanyName,Log Log) throws Exception {
		try {
			enterOnSearchItem(CompanyName);
			clickOnSearchBtn();
			Thread.sleep(3000);
			if (getText("//td[text()='"+CompanyName+"']").equals(CompanyName)) {
				Log.ReportEvent("PASS", "Billers Under Activation Search Functionality is Successful");	
			} else {
				Log.ReportEvent("FAIL", "Billers Under Activation Search Functionality is UnSuccessful");	
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		} catch (Exception e) {
			Log.ReportEvent("FAIL", "Billers Under Activation Search Functionality is UnSuccessful");	
			this.takeScreenShot();
			e.printStackTrace();
			driver.quit();
			Assert.fail();
		}
		
	}

	//Function Summary   : Method to click on biller activation(edit) link
	//Parameter Summary  : N/A
	public void clickOnActivateLink() {
		WebClick(EdaatOR.Admin_SystemMgm_BillerActivateBtn);
	}

	//Function Summary   : Method to enter corporate name in Arabic and English 
	//Parameter Summary  : ArabicName and EnglishName.
	public void enterOnBillerActiName(Map<Object, Object> testdatamap) {
		WebEdit(EdaatOR.Admin_SystemMgm_BillerAliasName,testdatamap.get("ArabicName").toString() );
		WebEdit(EdaatOR.Admin_SystemMgm_BillerAliasEnName, testdatamap.get("EnglishName").toString());
	}

	//Function Summary   : Method to click on  "super biller" checkbox
	//Paramaeter Summary : N/A
	public void clickOnIsbiller() {
		WebClickUsingJS(EdaatOR.Admin_SystemMgm_IsBiller);
	}

	//Function Summary   : Method to click on "yes"
	//Parameter Summary : N/A
	public void clickOnIsbillerYesbtn() {
		WebClickUsingJS(EdaatOR.Admin_SystemMgm_IsBillerYesBtn);
	}

	//Function Summary  : Method to click on save button
	//Parameter Summary : NA
	public void clickOnSave() {
		WebClick(EdaatOR.Admin_SystemMgm_SavesBtn);
	}

	//Function Summary  : Method click on yes button
	//Parameter Summary : NA
	public void clickOnSaveYeBtn() {
		WebClick(EdaatOR.Admin_SystemMgm_SaveYesBtn);
	}

	//Function Summary  : Method click on Close button
	//Parameter Summary : NA
	public void clickOnClose() {
		WebClick(EdaatOR.Admin_SystemMgm_ApprovalCloseBtn);
	}

	//Function Summary   : Method to  clickOnIsTrackerBiiller
	//Parameter Summary  : N/A	
	public void clickOnIsTrackerBiiller() {
		WebClickUsingJS(EdaatOR.Admin_NotAppmMgm_IsTrackerBiller);
	}
	//Function Summary   : Method to  clickOnIsTrackBillerYesbtn
	//Parameter Summary  : N/A
	public void clickOnIsTrackBillerYesbtn() {
		WebClickUsingJS(EdaatOR.Admin_NotAppmMgm_IsTrackerBillerYesbtn);
	}
	//Function Summary   : Method to  selectTrackerCheckBox
	//Parameter Summary  : N/A	
	public void selectTrackerCheckBox() throws Exception {
		clickOnIsTrackerBiiller();
		Thread.sleep(800);
		clickOnIsTrackBillerYesbtn();
		Thread.sleep(800);
	}

	//Function Summary   : Method to enter Biller code
	//Parameter Summary : Benifi
	public void enterTempBillerCode(String Benifi) {
		WebEdit(EdaatOR.Admin_SystemMgm_BillerCode,Benifi);
	}
	//Function Summary   : Method to enter beneficiary name 
	//Parameter Summary : Benifi
	public void enterTempBenificaryName(String Benifi) {
		WebEdit(EdaatOR.Admin_SystemMgm_BillerTemBenificary,Benifi);
	}
	//Function Summary   : Method to enter Duration  
	//Parameter Summary : Benifi
	public void enterDuration(String Benifi) {
		WebEdit(EdaatOR.Admin_SystemMgm_BillerTransferDura,Benifi);
	}

	public void selectSuperTrackerBiller(String Benifi) {
		WebSelectByVisibleText(EdaatOR.Admin_TrackerBillerMangm_SelectNewSuper,Benifi);
	}

	//Function Summary   : Method to select biller category    
	//Parameter Summary   : Benifi 
	public void selectCategoryID(String Benifi) {
		WebSelectByVisibleText(EdaatOR.Admin_SystemMgm_BillerCategoryID,Benifi);
	}
	//Function Summary  : to click on reject button
	//Parameter Summary : NA	
	public void clickOnRejectedLink() throws Exception {
		scrollDowntillend(driver);
		WebClick(EdaatOR.Admin_RejectButton);
		Thread.sleep(1000);
		VerifyValue("Are you sure to reject the biller account information?", EdaatOR.Admin_RejectConfiMessage);
		WebClickUsingJS(EdaatOR.Admin_RejectYesButton);
	}

	//Function Summary   : Method to enter beneficiary details and save. 
	//Parameter Summary : BenificaryName,BillerCode,Duration,BenificaryCategory,PaymentMethod
	public void EnterBilleDetails(Map<Object, Object> testdatamap){
		try{
			enterTempBenificaryName(testdatamap.get("BenificaryName").toString());
			enterTempBillerCode(testdatamap.get("BillerCode").toString());
			enterDuration(testdatamap.get("Duretion").toString());
			enterOnBillerActiName(testdatamap);
			selectCategoryID(testdatamap.get("BenificaryCategory").toString());
			scrollDowntillend(driver);
			SelectThePaymentMethod(testdatamap.get("PaymentMethod").toString());
			Thread.sleep(1000);
			clickOnIsbiller();
			Thread.sleep(1000);
			clickOnIsbillerYesbtn();
			Thread.sleep(1000);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	//Function Summary   : Method to Select The Payment Method 
	//Parameter Summary  : paymentMethod
	public void SelectThePaymentMethod(String paymentMethod) {
		try {

			if (paymentMethod.equalsIgnoreCase("sadad")) {

				WebClickUsingJS(EdaatOR.Systemmgmt_NonApproved_SadadBtn);
			}
			else if (paymentMethod.equalsIgnoreCase("mada")) {

				WebClickUsingJS(EdaatOR.Systemmgmt_NonApproved_MadaBtn);
			}
			else if (paymentMethod.equalsIgnoreCase("visa")) {

				WebClickUsingJS(EdaatOR.Systemmgmt_NonApproved_VisaBtn);
			}
			else if (paymentMethod.equalsIgnoreCase("All")) {
				WebClickUsingJS(EdaatOR.Systemmgmt_NonApproved_MasterCardBtn);
				WebClickUsingJS(EdaatOR.Systemmgmt_NonApproved_SadadBtn);
				WebClickUsingJS(EdaatOR.Systemmgmt_NonApproved_MadaBtn);
				WebClickUsingJS(EdaatOR.Systemmgmt_NonApproved_VisaBtn);
				WebClickUsingJS(EdaatOR.Systemmgmt_NonApproved_ApplePayBtn);
			}
			else {
				WebClickUsingJS(EdaatOR.Systemmgmt_NonApproved_MasterCardBtn);
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

	}
	//Function Summary   : Method to  EnterTrackerBillerDetails
	//Parameter Summary  : BenificaryName,BillerCode,Duretion,BenificaryCategory,SuperBillerName
	public void EnterTrackerBillerDetails(Map<Object, Object> testdatamap){
		try{
			enterTempBenificaryName(testdatamap.get("BenificaryName").toString());
			enterTempBillerCode(testdatamap.get("BillerCode").toString());
			enterDuration(testdatamap.get("Duretion").toString());
			enterOnBillerActiName(testdatamap);
			selectCategoryID(testdatamap.get("BenificaryCategory").toString());
			SelectThePaymentMethod(testdatamap.get("PaymentMethod").toString());
			scrollDowntillend(driver);
			selectTrackerCheckBox();
			Thread.sleep(1000);
			selectSuperTrackerBiller(testdatamap.get("SuperBillerName").toString());

		}catch(Exception e){
			e.printStackTrace();
		}
	}


	//Function Summary   : Method to click on Approval button
	//Parameter Summary : N/A
	public void clickOnApproval() throws InterruptedException {

		WebClick(EdaatOR.Admin_SystemMgm_ApprovalBtn);
		Thread.sleep(1000);
		WebClick(EdaatOR.Admin_SystemMgm_ApprovalYesBtn);
		Thread.sleep(1000);
		waitForPageToLoad();
	}


	//Function Summary   : Method to save and approve the biller activation
	//Parameter Summary  : CompanyName	
	public void VerifyToSaveTheBilerAccountByMaker(Map<Object, Object> testdatamap,Log Log) throws Exception {
		
		try {
			searchNotApprovedBillerMgm(testdatamap.get("CompanyName").toString(),Log);
			clickOnActivateLink();
			EnterBilleDetails(testdatamap);
			clickOnSave();
			Thread.sleep(1000);
			clickOnSaveYeBtn();
			if (CheckElementExists(EdaatOR.Admin_NotApproveBillerMangm_Benif_Error) || 
					CheckElementExists(EdaatOR.Admin_NotApproveBillerMangm_Code_Error) ||
					CheckElementExists(EdaatOR.Admin_NotApproveBillerMangm_trns_Error) || 
					CheckElementExists(EdaatOR.Admin_NotApproveBillerMangm_BillerArabic_Error) ||
					CheckElementExists(EdaatOR.Admin_NotApproveBillerMangm_BillerEng_Error) ||
					CheckElementExists(EdaatOR.Admin_NotApproveBillerMangm_BilCtg_Error) ||
					CheckElementExists(EdaatOR.Admin_NotApproveBillerMangm_Alerrt_Error)) {
				  	Log.ReportEvent("FAIL","Save the Activation Info by Maker Functionality is UnSuccessful");	
				  	this.takeScreenShot();
				  	driver.quit();
					Assert.fail();

			} else {
				searchNotApprovedBillerMgm(testdatamap.get("CompanyName").toString(),Log);	
				clickOnActivateLink();
				verifyElementIsPresent(EdaatOR.Admin_SystemMgm_ApprovalBtn);
			 	Log.ReportEvent("PASS","Save the Activation Info by Maker Functionality is Successful");
			}	
		} catch (Exception e) {
		  	Log.ReportEvent("FAIL","Save the Activation Info by Maker Functionality is UnSuccessful");	
		  	this.takeScreenShot();
			e.printStackTrace();
			driver.quit();
			Assert.fail();
		}
	}


	//Function Summary   : Method to VerifyClosedBillerForDeactivate
	//Parameter Summary  : CompanyName
	public void VerifyClosedBillerForDeactivate(Map<Object, Object> testdatamap,Log Log) throws Exception {

	     try {
			enterOnSearchItem(testdatamap.get("CompanyName").toString());
			clickOnSearchBtn();
			waitForPageToLoad();
			Thread.sleep(3000);
			if (getText("//td[text()='"+testdatamap.get("CompanyName").toString()+"']").equals(testdatamap.get("CompanyName").toString())) {
				Log.ReportEvent("PASS", "Billers Under Activation Search Functionality is Successful");	
				clickOnActivateLink();
				Thread.sleep(1000);
				clickOnClose();
				Thread.sleep(1000);
				if (CheckElementExists(EdaatOR.Admin_NoAppBillerMangm_Header)) {	
					AdminNotApprovedMgmCloseBiller.record=true;
					Log.ReportEvent("PASS", "Click on Close Button Without Doing any Action by Maker Functionality is Successful");	
				} else {
					Log.ReportEvent("FAIL", "Click on Close Button Without Doing any Action by Maker Functionality is UnSuccessful");	
					this.takeScreenShot();
					driver.quit();
					Assert.fail();
				}	
			} 
			else if (CheckElementExists(EdaatOR.Admin_SystemMgm_RecordNotFound)) {
				AdminNotApprovedMgmCloseBiller.record=false;
			}
			else {
				Log.ReportEvent("FAIL", "Billers Under Activation Search Functionality is UnSuccessful");	
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		} catch (Exception e) {
			Log.ReportEvent("FAIL", "Click on Close Button Without Doing any Action by Maker Functionality is UnSuccessful");	
			this.takeScreenShot();
			e.printStackTrace();
			driver.quit();
			Assert.fail();
		}

	}
	//Function Summary   : Method to VerifyBillerInavlidActivated
	//Parameter Summary  : CompanyName
	public void VerifyBillerInavlidActivated(Map<Object, Object> testdatamap,Log Log) throws Exception {
		try {
			searchNotApprovedBillerMgm(testdatamap.get("CompanyName").toString(),Log);
			clickOnActivateLink();
			EnterBilleDetails(testdatamap);
			clickOnSave();
			Thread.sleep(1000);
			clickOnSaveYeBtn();
			if (getText(EdaatOR.Admin_SystemMgm_ErrorMeesage).equals("Biller code is already in use")) {
				VerifyValue1(EdaatOR.Admin_SystemMgm_ErrorMeesage,"Biller code is already in use");
				Log.ReportEvent("PASS", "Enter Invalid Activation Info for Deactivated Biller by Maker Functionality is Successful");		
			} else {
				Log.ReportEvent("FAIL", "Enter Invalid Activation Info for Deactivated Biller by Maker Functionality is UnSuccessful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		} catch (Exception e) {
			Log.ReportEvent("FAIL", "Enter Invalid Activation Info for Deactivated Biller by Maker Functionality is UnSuccessful");
			this.takeScreenShot();
			e.printStackTrace();
			driver.quit();
			Assert.fail();
		}
		
	}

	//Function Summary   : Method to click on save button
	//Parameter Summary : N/A
	public void SaveBillerDetails(Log Log) throws Exception {
		try {
			clickOnSave();
			Thread.sleep(1000);
			clickOnSaveYeBtn();
			if (CheckElementExists(EdaatOR.Admin_NotApproveBillerMangm_Benif_Error) || 
					CheckElementExists(EdaatOR.Admin_NotApproveBillerMangm_Code_Error) ||
					CheckElementExists(EdaatOR.Admin_NotApproveBillerMangm_trns_Error) || 
					CheckElementExists(EdaatOR.Admin_NotApproveBillerMangm_BillerArabic_Error) ||
					CheckElementExists(EdaatOR.Admin_NotApproveBillerMangm_BillerEng_Error) ||
					CheckElementExists(EdaatOR.Admin_NotApproveBillerMangm_BilCtg_Error) ||
					CheckElementExists(EdaatOR.Admin_NotApproveBillerMangm_Alerrt_Error)) {
				  	Log.ReportEvent("FAIL","Save Biller Details by Maker Functionality is UnSuccessful");	
				  	this.takeScreenShot();
				  	driver.quit();
					Assert.fail();

			} else {
			 	Log.ReportEvent("PASS","Save Biller Details by Maker Functionality is Successful");	
			}
		} catch (Exception e) {
			Log.ReportEvent("FAIL","Save Biller Details by Maker Functionality is UnSuccessful");	
			this.takeScreenShot();
			e.printStackTrace();
			driver.quit();
			Assert.fail();
		}

	}
	//Function Summary  :verify biller approval rejected
	//Parameter Summary : CompanyName.
	public void VerifyBillerApprovalIsRejected(Map<Object, Object> testdatamap,Log Log) throws Exception {
		try {
			searchNotApprovedBillerMgm(testdatamap.get("CompanyName").toString(),Log);
			clickOnActivateLink();
			EnterBilleDetails(testdatamap);
			SaveBillerDetails(Log);
			searchNotApprovedBillerMgm(testdatamap.get("CompanyName").toString(),Log);
			clickOnActivateLink();
			scrollDowntillend(driver);
			WebClick(EdaatOR.Admin_RejectButton);
			Thread.sleep(1000);
			if (getText(EdaatOR.Admin_RejectConfiMessage).equals("Are you sure to reject the biller account information?")) {
				VerifyValue1( EdaatOR.Admin_RejectConfiMessage,"Are you sure to reject the biller account information?");
				WebClickUsingJS(EdaatOR.Admin_RejectYesButton);
				searchNotApprovedBillerMgm(testdatamap.get("CompanyName").toString(),Log);
				Log.ReportEvent("PASS", "Reject the Biller Activation Account by Checker Functionality is Successful");
			} else {
				Log.ReportEvent("FAIL", "Reject the Biller Activation Account by Checker Functionality is UnSuccessful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		} catch (Exception e) {
			Log.ReportEvent("FAIL", "Reject the Biller Activation Account by Checker Functionality is UnSuccessful");
			this.takeScreenShot();
			e.printStackTrace();
			driver.quit();
			Assert.fail();
		}		
	}	
	//Function Summary  : to search biller in not approved billers management click on edit and close
	//Parameter Summary : CompanyName	
	public void VerifyBillerApprovalIsClosed(Map<Object, Object> testdatamap,Log Log) throws Exception {
		try {
			clickOnActivateLink();
			clickOnClose();
			if (CheckElementExists(EdaatOR.Admin_NoAppBillerMangm_Header)) {				
				Log.ReportEvent("PASS", "Click on Close Button Without Doing any Action by Checker Functionality is Successful");
			} else {
				Log.ReportEvent("FAIL", "Click on Close Button Without Doing any Action by Checker Functionality is UnSuccessful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}			
		} catch (Exception e) {
			Log.ReportEvent("FAIL", "Click on Close Button Without Doing any Action by Checker Functionality is UnSuccessful");
			this.takeScreenShot();
			e.printStackTrace();
			driver.quit();
			Assert.fail();
		}
		
	}

	public void VerifyBillersUnderActivationGridView(Map<Object, Object> testdatamap,Log Log) throws Exception {
		try {
			enterOnSearchItem(testdatamap.get("CompanyName").toString());
			clickOnSearchBtn();
			waitForPageToLoad();
			Thread.sleep(3000);
			if(CheckElementExists(EdaatOR.Admin_SystemMgm_RecordNotFound)) {
				AdminNotApprovedMgmCloseBiller.record=false;
			}
			else if (getText(EdaatOR.Admin_SystemMgm_CorpName).equals(testdatamap.get("CompanyName").toString())){			
				VerifyValue1(EdaatOR.Admin_SystemMgm_CorpName,testdatamap.get("CompanyName").toString());
				VerifyValue1( EdaatOR.Admin_SystemMgm_CorpType,"Corporate");
				VerifyValue1(EdaatOR.Admin_SystemMgm_EmailConf,"No");
				verifyElementIsPresent(EdaatOR.Admin_SystemMgm_RecordUnclickable);
				verifyElementIsPresent(EdaatOR.Admin_SystemMgm_EyeIcon_view);	
				AdminNotApprovedMgmCloseBiller.record=true;
				Log.ReportEvent("PASS","Grid View Details Functionality is Successful");
			}
			else {		
				Log.ReportEvent("FAIL","Grid View Details Functionality is UnSuccessful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		} catch (Exception e) {
			Log.ReportEvent("FAIL","Grid View Details Functionality is UnSuccessful");
			this.takeScreenShot();
			e.printStackTrace();
			driver.quit();
			Assert.fail();
		}

		
	}

	//Function Summary   : Method to ApproveBiller
	//Parameter Summary  : CompanyName

	public void ApproveBiller(Map<Object, Object> testdatamap,Log Log) throws Exception {
		
		try {
			searchNotApprovedBillerMgm(testdatamap.get("CompanyName").toString(),Log);
			clickOnActivateLink();
			EnterBilleDetails(testdatamap);
			SaveBillerDetails(Log);
			searchNotApprovedBillerMgm(testdatamap.get("CompanyName").toString(),Log);
			clickOnActivateLink();
			WebClick(EdaatOR.Admin_SystemMgm_ApprovalBtn);
			Thread.sleep(1000);
			if (CheckElementExists(EdaatOR.Admin_SystemMgm_ApprovalBtn_ConfirmAct)) {
				WebClick(EdaatOR.Admin_SystemMgm_ApprovalYesBtn);
				Thread.sleep(1000);
				waitForPageToLoad();
				Log.ReportEvent("PASS", "Biller has been Approved by Checker Functionality is Successful");
				
			} else {
				Log.ReportEvent("FAIL", "Biller has been Approved by Checker Functionality is UnSuccessful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		} catch (Exception e) {			
			Log.ReportEvent("FAIL", "Biller has been Approved by Checker Functionality is UnSuccessful");
			this.takeScreenShot();
			e.printStackTrace();
			driver.quit();
			Assert.fail();
		}
	}


	public void verifyApproveBillerChecker(Map<Object, Object> testdatamap,Log Log) throws Exception {
		searchNotApprovedBillerMgm(testdatamap.get("CompanyName").toString(),Log);
		verifyElementIsNotPresent(EdaatOR.Admin_SystemMgm_RecordUnclickable, "Slid Bar is activated");
		verifyElementIsPresent(EdaatOR.Admin_ApproveMgn_ToggleBtn);
		WebClickUsingJS(EdaatOR.Admin_ApproveMgn_ToggleBtn);
		Thread.sleep(500);

		VerifyValue1(getText(EdaatOR.Admin_Compan_ActivePop), testdatamap.get("InActive").toString());
		WebClickUsingJS(EdaatOR.Admin_Compan_ActiveConfbtn);
		Thread.sleep(2000);

		WebClickUsingJS(EdaatOR.Admin_ApproveMgn_ToggleBtn);
		Thread.sleep(500);

		VerifyValue1(getText(EdaatOR.Admin_Compan_ActivePop), testdatamap.get("Active").toString());
		WebClickUsingJS(EdaatOR.Admin_Compan_ActiveConfbtn);

	}


	public void VerifyApprovedGridViewAndUpdate(Map<Object, Object> testdatamap,Log Log) throws Exception {
		VerifyValue(testdatamap.get("CompanyName").toString(), EdaatOR.Admin_ApprovedMgm_BillerName);
		VerifyValue(testdatamap.get("BillerCode").toString(), EdaatOR.Admin_ApprovedMgm_BillerID);
		VerifyValue("Corporate", EdaatOR.Admin_ApprovedMgm_BillerType);
		VerifyValue("No", EdaatOR.Admin_ApprovedMgm_EmailConf);
		verifyElementIsPresent(EdaatOR.Admin_SystemMgm_BillerActivateBtn);
		verifyElementIsPresent(EdaatOR.Admin_ApprovedMgm_EyeIcon);	
		WebClick(EdaatOR.Admin_SystemMgm_BillerActivateBtn);
		Thread.sleep(1000);
		enterTempBenificaryName(testdatamap.get("UpdatedBillerName").toString());
		WebEdit(EdaatOR.Admin_SystemMgm_BillerAliasName,testdatamap.get("UpdatedArabicName").toString() );
		WebEdit(EdaatOR.Admin_SystemMgm_BillerAliasEnName, testdatamap.get("UpdatedEnglishName").toString());
		SaveBillerDetails(Log);
		WebClick(EdaatOR.Admin_SystemMgm_BillerActivateBtn);
		Thread.sleep(1000);
		VerifyValue1(testdatamap.get("UpdatedBillerName").toString(), WebGetTextAttribute(EdaatOR.Admin_SystemMgm_BillerTemBenificary));
		VerifyValue1(testdatamap.get("UpdatedArabicName").toString(), WebGetTextAttribute(EdaatOR.Admin_SystemMgm_BillerAliasName));
		VerifyValue1(testdatamap.get("UpdatedEnglishName").toString(), WebGetTextAttribute(EdaatOR.Admin_SystemMgm_BillerAliasEnName));

	}


	//Function Summary   : Method to CreateTrackerBill
	//Parameter Summary  : N/A
	public void CreateTrackerBill(Map<Object, Object> testdatamap,Log Log) throws Exception {
		try {
			searchNotApprovedBillerMgm(testdatamap.get("CompanyName").toString(),Log);
			clickOnActivateLink();
			EnterTrackerBillerDetails(testdatamap);
			SaveBillerDetails(Log);
			searchNotApprovedBillerMgm(testdatamap.get("CompanyName").toString(),Log);
			clickOnActivateLink();
			WebClick(EdaatOR.Admin_SystemMgm_ApprovalBtn);
			Thread.sleep(1000);
			if (CheckElementExists(EdaatOR.Admin_SystemMgm_ApprovalBtn_ConfirmAct)) {
				WebClick(EdaatOR.Admin_SystemMgm_ApprovalYesBtn);
				Thread.sleep(1000);
				waitForPageToLoad();
				Log.ReportEvent("PASS", "Biller has been Approved by Checker as Tracked Biller Functionality is Successful");
				
			} else {
				Log.ReportEvent("FAIL", "Biller has been Approved by Checker as Tracked Biller Functionality is UnSuccessful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		} catch (Exception e) {
			Log.ReportEvent("FAIL", "Biller has been Approved by Checker as Tracked Biller Functionality is UnSuccessful");
			this.takeScreenShot();
			e.printStackTrace();
			driver.quit();
			Assert.fail();
		
		}
		
	}
	//Function Summary   : Method to ApproveBillerErrorMsg
	//Parameter Summary  : CompanyName		
	public void ApproveBillerErrorMsg(Map<Object, Object> testdatamap,Log Log) throws Exception {
		try {
			String Expected = testdatamap.get("Expected").toString();
			searchNotApprovedBillerMgm(testdatamap.get("CompanyName").toString(),Log);
			clickOnActivateLink();
			enterTempBenificaryName(testdatamap.get("BenificaryName").toString());
			enterTempBillerCode(testdatamap.get("BillerCode").toString());
			enterDuration(testdatamap.get("Duretion").toString());
			enterOnBillerActiName(testdatamap);
			selectCategoryID(testdatamap.get("BenificaryCategory").toString());
			SelectThePaymentMethod(testdatamap.get("PaymentMethod").toString());
			scrollDowntillend(driver);
			Thread.sleep(1000);
			selectTrackerCheckBox();
			Thread.sleep(1000);
			selectSuperTrackerBiller(testdatamap.get("SuperBillerName").toString());
			Thread.sleep(1000);			
			clickOnSave();
			Thread.sleep(1000);
			clickOnSaveYeBtn();
			if(getText(EdaatOR.Admin_SystemMgm_Biller_BenificaryError).equals(Expected)&&getText(EdaatOR.Admin_SystemMgm_Biller_idError).equals(Expected)
			&&getText(EdaatOR.Admin_SystemMgm_Biller_Durationerror).equals(Expected) &&getText(EdaatOR.Admin_SystemMgm_Biller_CrpArbError).equals(Expected)&&
			getText(EdaatOR.Admin_SystemMgm_Biller_CrpEngError).equals(Expected)
			&&getText(EdaatOR.Admin_SystemMgm_Biller_BillerCatgError).equals(Expected))
			{
				Log.ReportEvent("PASS", "Verify the Error Message for all the Required Fields is Successful");
			}	
			else if(getText(EdaatOR.Admin_SystemMgm_Biller_SuperBillerErrormsg).equals(Expected))
			{
				Log.ReportEvent("PASS", "Verify the Error Message for Super Biller is Successful");
			}
			else {			
				Log.ReportEvent("FAIL", "Verify the Error Message to Save the Activation Info by Maker is UnSuccessful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}		
		}
		catch (Exception e) {
			Log.ReportEvent("FAIL", "Verify the Error Message to Save the Activation Info by Maker is UnSuccessful");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();
		}

	}

	//Function Summary   : Method to AssignAllThePaymentMethod
	//Parameter Summary  : CompanyName
	public void verifyAssignAllThePaymentMethods(Map<Object, Object> testdatamap, Log Log) throws Exception {	
		try {
			searchNotApprovedBillerMgm(testdatamap.get("CompanyName").toString(),Log);
			clickOnActivateLink();
			EnterBilleDetails(testdatamap);
			SaveBillerDetails(Log);
			searchNotApprovedBillerMgm(testdatamap.get("CompanyName").toString(),Log);
			Thread.sleep(2000);
			clickOnActivateLink();
			verifyElementIsPresent(EdaatOR.Admin_SystemMgm_ApprovalBtn);
			clickOnApproval();
			Thread.sleep(2000);
			enterOnSearchItem(testdatamap.get("CompanyName").toString());
			clickOnSearchBtn();
			waitForPageToLoad();
			Thread.sleep(3000);
			if (getText("//td[text()='"+testdatamap.get("CompanyName").toString()+"']").equals(testdatamap.get("CompanyName").toString())) {
				Log.ReportEvent("PASS", "Admin is Able to Assign all the Payment Methods Functionality is Successful");	
			} else {
				Log.ReportEvent("FAIL", "Admin is Able to Assign all the Payment Methods Functionality is UnSuccessful");	
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		} catch (Exception e) {
			Log.ReportEvent("FAIL", "Admin is Able to Assign all the Payment Methods Functionality is UnSuccessful");	
			this.takeScreenShot();
			e.printStackTrace();
			driver.quit();
			Assert.fail();
		}
		
	}

	//Function Summary   : Method to verifyToAssignSamePaymentMethodForMoreThanOneBiller
	//Parameter Summary  : CompanyName
	public void verifyToAssignSamePaymentMethodForMoreThanOneBiller(Map<Object, Object> testdatamap, Log Log) throws Exception {
		try {
			searchNotApprovedBillerMgm(testdatamap.get("CompanyName").toString(),Log);
			clickOnActivateLink();
			EnterBilleDetails(testdatamap);
			SaveBillerDetails(Log);
			searchNotApprovedBillerMgm(testdatamap.get("CompanyName").toString(),Log);
			Thread.sleep(2000);
			clickOnActivateLink();
			verifyElementIsPresent(EdaatOR.Admin_SystemMgm_ApprovalBtn);
			clickOnApproval();
			Thread.sleep(2000);
			enterOnSearchItem(testdatamap.get("CompanyName").toString());
			clickOnSearchBtn();
			waitForPageToLoad();
			Thread.sleep(3000);
			if (getText("//td[text()='"+testdatamap.get("CompanyName").toString()+"']").equals(testdatamap.get("CompanyName").toString())) {
				Log.ReportEvent("PASS", "Add the Same Payment Method for More than One Biller Functionality is Successful");
			} 
			else {
				Log.ReportEvent("FAIL", "Add the Same Payment Method for More than One Biller Functionality is UnSuccessful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		} catch (Exception e) {	
			Log.ReportEvent("FAIL", "Add the Same Payment Method for More than One Biller Functionality is UnSuccessful");
			this.takeScreenShot();
			e.printStackTrace();
			driver.quit();
			Assert.fail();
		}
		
	}

	//Function Summary   : Method to verify Add Minimum Invoice Amount Check box. 	
		public void verifyAddMinimumInvoiceAmountCheckbox(Log Log){
			try{
				clickOnActivateLink();
				Thread.sleep(1000);	
				WebElement element=driver.findElement(By.xpath(EdaatOR.Admin_BillerUnderActivationCorporateName));
				scrollToElement(driver, element);
				if(CheckElementExists(EdaatOR.Admin_SystemMgm_AddMinimumInvoiceAmountCheckbox))
				{
					Thread.sleep(1000);
					Log.ReportEvent("PASS", "Add Minimum Invoice Amount Checkbox is Present Functionality is UnSuccessful");
				}
				else {
					Log.ReportEvent("FAIL", "Add Minimum Invoice Amount Checkbox is Present Functionality is UnSuccessful");
					this.takeScreenShot();
					driver.quit();
					Assert.fail();
				}
			}catch(Exception e){
				Log.ReportEvent("FAIL", "Add Minimum Invoice Amount Checkbox is Present Functionality is UnSuccessful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();			}
		}
	//Function Summary   : Method to verifyTheNewCheckboxViewedAfterCheckTheSubBillerCheckBox
	//Parameter Summary  : CompanyName,BenificaryName,BillerCode,Duretion,BenificaryCategory
	public void verifyTheNewCheckboxViewedAfterCheckTheSubBillerCheckBox(Map<Object, Object> testdatamap,Log Log) throws Exception {
		try {	
			enterOnSearchItem(testdatamap.get("CompanyName").toString());
			clickOnSearchBtn();
			waitForPageToLoad();
			Thread.sleep(3000);
			if(CheckElementExists(EdaatOR.Admin_SystemMgm_RecordNotFound)) {
				AdminSystemMngBillerMgmtVerifyNewCheckboxViewedAfterAdminCheckSubbillerCheckbox.record=false;
			}
			else if (getText("//td[text()='"+testdatamap.get("CompanyName").toString()+"']").equals(testdatamap.get("CompanyName").toString())) {
				Log.ReportEvent("PASS", "Billers Under Activation Search Functionality is Successful");	
				clickOnActivateLink();
				enterTempBenificaryName(testdatamap.get("BenificaryName").toString());
				enterTempBillerCode(testdatamap.get("BillerCode").toString());
				enterDuration(testdatamap.get("Duretion").toString());
				enterOnBillerActiName(testdatamap);
				selectCategoryID(testdatamap.get("BenificaryCategory").toString());
				WebClickUsingJS(EdaatOR.Admin_SystemMng_notApprovedBiller_SubBillerCheckBox);
				Thread.sleep(2000);
				if(CheckElementExists(EdaatOR.Admin_SystemMng_notApprovedBiller_SubBillerCheckBox_Label)) {
					verifyElementIsPresent(EdaatOR.Admin_SystemMgm_TransferRemarkCheckbox_Label);	
					Thread.sleep(2000);
					AdminSystemMngBillerMgmtVerifyNewCheckboxViewedAfterAdminCheckSubbillerCheckbox.record=true;					
					Log.ReportEvent("PASS", "New Checkbox Viewed After Admin Check the Sub Biller Checkbox Functionality is Successful");	
				
				}
				else {				
					Log.ReportEvent("FAIL", "New Checkbox Viewed After Admin Check the Sub Biller Checkbox Functionality is UnSuccessful");		
					this.takeScreenShot();
					driver.quit();
					Assert.fail();
				}
			} 
			else {
				Log.ReportEvent("FAIL", "New Checkbox Viewed After Admin Check the Sub Biller Checkbox Functionality is UnSuccessful");	
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}

		} catch (Exception e) {
			Log.ReportEvent("FAIL", "New Checkbox Viewed After Admin Check the Sub Biller Checkbox Functionality is UnSuccessful");		
			this.takeScreenShot();
			e.printStackTrace();
			driver.quit();
			Assert.fail();
			
		}	
	}
	//Function Summary   : Method to verify Available Payment Methods Is Displayed 	
	public void verifyAvailablePaymentMethodsIsDisplayed(Log Log){
		try{
			clickOnActivateLink();
			Thread.sleep(500);
			WebElement element=driver.findElement(By.xpath(EdaatOR.Admin_BillerMang_AvailablePaymentMethods));
			scrollToElement(driver, element);	
			if (CheckElementExists(EdaatOR.Admin_BillerMang_AvailablePaymentMethods)) {
				verifyElementIsPresent(EdaatOR.Admin_BillerMang_AvailablePaymentMethods);
				Thread.sleep(500);
				verifyElementIsPresent(EdaatOR.Admin_BillerMang_AvailPayMeth_PaidOutsideEDAAT);
				Thread.sleep(500);
				verifyElementIsPresent(EdaatOR.Admin_BillerMang_AvailPayMeth_Sadad);
				Thread.sleep(500);
				verifyElementIsPresent(EdaatOR.Admin_BillerMang_AvailPayMeth_Mada);
				Thread.sleep(500);
				verifyElementIsPresent(EdaatOR.Admin_BillerMang_AvailPayMeth_Visa);
				Thread.sleep(500);
				verifyElementIsPresent(EdaatOR.Admin_BillerMang_AvailPayMeth_MasterCard);
				Thread.sleep(500);
				verifyElementIsPresent(EdaatOR.Admin_BillerMang_AvailPayMeth_ApplePay);
				Log.ReportEvent("PASS", "New Added Section Available Payment Method in Biller Activation Page Functionality is Successful");
			} else {
				Log.ReportEvent("FAIL", "New Added Section Available Payment Method in Biller Activation Page Functionality is UnSuccessful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();	
			}
		}catch(Exception e){
			Log.ReportEvent("FAIL", "New Added Section Available Payment Method in Biller Activation Page Functionality is UnSuccessful");
			this.takeScreenShot();
			e.printStackTrace();
			driver.quit();
			Assert.fail();
		}
	}
	
	//Function Summary   : Method to verify Available Payment Methods Is Displayed 	
		public void verifyAvailablePaymentMethodsIsDisplayedWithCheckboxes(Log Log){
			try{
				boolean poeIsCheckbox = driver.findElement(By.xpath(EdaatOR.Admin_BillerMang_AvailPayMeth_PaidOutsideEDAAT_checkbox)).getAttribute("type").contains("checkbox");
				boolean SadadIsCheckbox = driver.findElement(By.xpath(EdaatOR.Admin_BillerMang_AvailPayMeth_Sadad_Checkbox)).getAttribute("type").contains("checkbox");
				boolean MadaIsCheckbox = driver.findElement(By.xpath(EdaatOR.Admin_BillerMang_AvailPayMeth_Mada_checkbox)).getAttribute("type").contains("checkbox");
				boolean VisaIsCheckbox = driver.findElement(By.xpath(EdaatOR.Admin_BillerMang_AvailPayMeth_Visa_checkbox)).getAttribute("type").contains("checkbox");
				boolean MasterCheckbox = driver.findElement(By.xpath(EdaatOR.Admin_BillerMang_AvailPayMeth_MasterCard_checbox)).getAttribute("type").contains("checkbox");
				boolean ApplePayIsCheckbox = driver.findElement(By.xpath(EdaatOR.Admin_BillerMang_AvailPayMeth_ApplePay_checkbox)).getAttribute("type").contains("checkbox");					
				if (poeIsCheckbox && SadadIsCheckbox && MadaIsCheckbox && VisaIsCheckbox && MasterCheckbox  && ApplePayIsCheckbox) {
					Log.ReportEvent("PASS", "Available Payment Methods List are Checkbox Functionality is Successful");
				} else {
					Log.ReportEvent("FAIL", "Available Payment Methods List are Checkbox Functionality is UnSuccessful");
					this.takeScreenShot();
					driver.quit();
					Assert.fail();	
				}
			}catch(Exception e){
				Log.ReportEvent("FAIL", "Available Payment Methods List are Checkbox Functionality is UnSuccessful");
				this.takeScreenShot();
				e.printStackTrace();
				driver.quit();
				Assert.fail();
			}
		}
	//Function Summary   : Method to Select The Payment Method
	//Parameter Summary  : paymentMethod

	public void VerifySelectedPaymentType(String paymentMethod,Log Log)
	{
		try {
			WebElement paymentFieldSadad = driver.findElement(By.xpath(EdaatOR.Systemmgmt_NonApproved_SadadBtn));
			WebElement paymentFieldMada = driver.findElement(By.xpath(EdaatOR.Systemmgmt_NonApproved_MadaBtn));
			WebElement paymentFieldVisa = driver.findElement(By.xpath(EdaatOR.Systemmgmt_NonApproved_VisaBtn));
			WebElement paymentFieldMasterard = driver.findElement(By.xpath(EdaatOR.Systemmgmt_NonApproved_MasterCardBtn));
			WebElement paymentFieldApplePay = driver.findElement(By.xpath(EdaatOR.Systemmgmt_NonApproved_ApplePayBtn));

			if (paymentMethod.equalsIgnoreCase("sadad")) {

				paymentFieldSadad.isSelected();

			}
			else if (paymentMethod.equalsIgnoreCase("mada")) {

				paymentFieldMada.isSelected();
			}
			else if (paymentMethod.equalsIgnoreCase("visa")) {

				paymentFieldVisa.isSelected();
			}
			else if (paymentMethod.equalsIgnoreCase("All")) {
				paymentFieldSadad.isSelected();
				paymentFieldMada.isSelected();
				paymentFieldVisa.isSelected();
				paymentFieldMasterard.isSelected();
				paymentFieldApplePay.isSelected();
			}
			else {

				WebClickUsingJS(EdaatOR.Systemmgmt_NonApproved_MasterCardBtn);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}
	//Function Summary   : Method to searchforapprbiller
		//Parameter Summary  : CompanyName
		public void searchforapprbiller(Map<Object, Object> testdatamap,Log Log) throws InterruptedException 
		{
			try {
			enterOnSearchItem(testdatamap.get("CompanyName").toString());
			clickOnSearchBtn();
			waitForPageToLoad();
			Thread.sleep(3000);
			if (getText("//td[text()='"+testdatamap.get("CompanyName").toString()+"']").equals(testdatamap.get("CompanyName").toString())) {
				Log.ReportEvent("PASS", "Approved Billers Search Functionality is Successful");	
			} else {
				Log.ReportEvent("FAIL", "Approved Billers Search Functionality is UnSuccessful");	
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		} catch (Exception e) {
			Log.ReportEvent("FAIL", "Approved Billers Search Functionality is UnSuccessful");	
			this.takeScreenShot();
			e.printStackTrace();
			driver.quit();
			Assert.fail();
		}
		}
	//Function Summary   : Method to verifyTheNewCheckboxAddMinimumInvoiceAmountIsNotMandatory
	//Parameter Summary  : CompanyName
	public void verifyTheNewCheckboxAddMinimumInvoiceAmountIsNotMandatory(Map<Object, Object> testdatamap,Log Log) throws Exception {
		try {	
			searchNotApprovedBillerMgm(testdatamap.get("CompanyName").toString(),Log);
			clickOnActivateLink();
			EnterBilleDetails(testdatamap);
			WebElement checkbox = driver.findElement(By.xpath(EdaatOR.Admin_SystemMgm_NotApproval_AddMinimum_Invoice_Checkbox));
			if(!checkbox.isSelected())
			{
				SaveBillerDetails(Log);
				searchNotApprovedBillerMgm(testdatamap.get("CompanyName").toString(),Log);
				Thread.sleep(2000);
				clickOnActivateLink();
				verifyElementIsPresent(EdaatOR.Admin_SystemMgm_ApprovalBtn);
				clickOnApproval();
				Thread.sleep(2000);
				searchforapprbiller(testdatamap,Log);
				Thread.sleep(2000);
				verifyElementIsNotPresent(EdaatOR.Admin_SystemMgm_RecordUnclickable, "Slid Bar is activated");
				Log.ReportEvent("PASS", "New Checkbox Add Minimum Invoice Amount is not Mandatory Functionality is Successful");			
			}
			else {
				Log.ReportEvent("FAIL", "New Checkbox Add Minimum Invoice Amount is not Mandatory Functionality is UnSuccessful");			
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}

		} catch (Exception e) {
			Log.ReportEvent("FAIL", "New Checkbox Add Minimum Invoice Amount is not Mandatory Functionality is UnSuccessful");			
			this.takeScreenShot();
			e.printStackTrace();
			driver.quit();
			Assert.fail();
		}	
	}

	//Function Summary   : Method to VerifyAdminAbleToAssignNewPaymentType
	//Parameter Summary  : CompanyName,BenificaryName,BillerCode,Duretion,ArabicName,EnglishName,BenificaryCategory,PaymentMethod,CompanyName,PaymentMethod
	public void VerifyAdminAbleToAssignNewPaymentType(Map<Object, Object> testdatamap,Log Log)
	{
		try {
			searchNotApprovedBillerMgm(testdatamap.get("CompanyName").toString(),Log);
			clickOnActivateLink();
			enterTempBenificaryName(testdatamap.get("BenificaryName").toString());
			enterTempBillerCode(testdatamap.get("BillerCode").toString());
			enterDuration(testdatamap.get("Duretion").toString());
			enterOnBillerActiName(testdatamap);
			WebEdit(EdaatOR.Admin_SystemMgm_BillerAliasName,testdatamap.get("ArabicName").toString() );
			WebEdit(EdaatOR.Admin_SystemMgm_BillerAliasEnName, testdatamap.get("EnglishName").toString());
			selectCategoryID(testdatamap.get("BenificaryCategory").toString());
			Thread.sleep(1000);
			SelectThePaymentMethod(testdatamap.get("PaymentMethod").toString());
			SaveBillerDetails(Log);						
			searchNotApprovedBillerMgm(testdatamap.get("CompanyName").toString(),Log);					
			clickOnActivateLink();
			VerifySelectedPaymentType(testdatamap.get("PaymentMethod").toString(),Log);
			verifyElementIsPresent(EdaatOR.Admin_SystemMgm_ApprovalBtn);
			WebClick(EdaatOR.Admin_SystemMgm_ApprovalBtn);
			if (CheckElementExists(EdaatOR.Admin_SystemMgm_ApprovalBtn_ConfirmAct)) {
				WebClick(EdaatOR.Admin_SystemMgm_ApprovalYesBtn);
				Thread.sleep(1000);
				waitForPageToLoad();
				Log.ReportEvent("PASS", "Admin is Able to Assign New Payment Method Functionality is Successful");
				
			} else {
				Log.ReportEvent("FAIL", "Admin is Able to Assign New Payment Method Functionality is UnSuccessful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		}
		catch (Exception e) {
			Log.ReportEvent("FAIL", "Admin is Able to Assign New Payment Method Functionality is UnSuccessful");
			this.takeScreenShot();
			e.printStackTrace();
			driver.quit();
			Assert.fail();
		}
	}

	//Function Summary   : Method to verify Available Payment Methods Is Displayed 	
	public void verifyDefaultPaymentIsSelectedAndDisabled(Log Log){
		try{
			clickOnActivateLink();				
			Thread.sleep(500);
			WebElement element=driver.findElement(By.xpath(EdaatOR.Admin_BillerMang_AvailablePaymentMethods));
			scrollToElement(driver, element);
			String isSelected=driver.findElement(By.xpath(EdaatOR.Admin_BillerMang_AvailPayMeth_PaidOutsideEDAAT_checkbox)).getAttribute("defaultChecked");
			String isDisabled=driver.findElement(By.xpath(EdaatOR.Admin_BillerMang_AvailPayMeth_PaidOutsideEDAAT_checkbox)).getAttribute("disabled");
			if(Boolean.valueOf(isSelected) && Boolean.valueOf(isDisabled))
			{
				Log.ReportEvent("PASS", "Default Payment is Selected and Disabled Functionality is Successful");
			}
			else {		
				Log.ReportEvent("FAIL", "Default Payment is Selected and Disabled Functionality is UnSuccessful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}

		}catch(Exception e){
			Log.ReportEvent("FAIL", "Default Payment is Selected and Disabled Functionality is UnSuccessful");
			this.takeScreenShot();
			e.printStackTrace();
			driver.quit();
			Assert.fail();
		}
	}
	//Function Summary   : Method to verify subBiller Checkbox is Unchecked 
	//Parameter Summary : BenificaryName,BillerCode,Duration,BenificaryCategory,checkboxStatus
	public void verifySubBillerCheckBox(Map<Object, Object> testdatamap,Log Log){
		try{
			searchNotApprovedBillerMgm(testdatamap.get("CompanyName").toString(),Log);
			clickOnActivateLink();
			enterTempBenificaryName(testdatamap.get("BenificaryName").toString());
			enterTempBillerCode(testdatamap.get("BillerCode").toString());
			enterDuration(testdatamap.get("Duretion").toString());
			enterOnBillerActiName(testdatamap);
			selectCategoryID(testdatamap.get("BenificaryCategory").toString());
			scrollDowntillend(driver);
			Thread.sleep(1000);
			String isChecked = driver.findElement(By.xpath(EdaatOR.Admin_SystemMgm_SubBiller_Checkbox)).getAttribute("defaultChecked");
			if(!Boolean.valueOf(isChecked))
			{
				Log.ReportEvent("PASS", "New Checkbox Default Value is Unchecked Functionality is Successful");	
			}
			else{
				Log.ReportEvent("FAIL", "New Checkbox Default Value is Unchecked Functionality is UnSuccessful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		}catch(Exception e){
			Log.ReportEvent("FAIL", "New Checkbox Default Value is Unchecked Functionality is UnSuccessful");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();
		}
	}
	//Function Summary   : Method to verify Add Minimum Invoice Amount CheckBox is Checked/Unchecked
	//Parameter Summary  : CompanyName
	public void verifyAddMinimumInvoiceAmountCheckBox (Map<Object, Object> testdatamap,Log Log){
		try{
			searchNotApprovedBillerMgm(testdatamap.get("CompanyName").toString(), Log);
			clickOnActivateLink();
			Thread.sleep(4000);
			scrollDowntillend(driver);			
			WebClick(EdaatOR.Admin_Systemmgmt_MinimumInvoiceAmount);
			if(CheckElementExists(EdaatOR.Admin_Systemmgmt_MinimumInvoiceAmount_textfield))
			{
				Thread.sleep(2000);
				WebClick(EdaatOR.Admin_Systemmgmt_MinimumInvoiceAmount);
				Thread.sleep(2000);
				if(!CheckElementExists(EdaatOR.Admin_Systemmgmt_MinimumInvoiceAmount_textfield)) {
					Log.ReportEvent("PASS", "Add Minimum Invoice Amount CheckBox is Checked/UnChecked Functionality is Successful");
				}
				else {				
					Log.ReportEvent("FAIL", "Add Minimum Invoice Amount CheckBox is Checked/UnChecked Functionality is UnSuccessful");
					this.takeScreenShot();
					driver.quit();
					Assert.fail();	
				}
			}
			else
			{
				Log.ReportEvent("FAIL", "Add Minimum Invoice Amount CheckBox is Checked/UnChecked Functionality is UnSuccessful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();	
			}
		}
	catch(Exception e){
			Log.ReportEvent("FAIL", "Add Minimum Invoice Amount CheckBox is Checked/UnChecked Functionality is UnSuccessful");
			this.takeScreenShot();
			e.printStackTrace();
			driver.quit();
			Assert.fail();		
			}
	}
}
