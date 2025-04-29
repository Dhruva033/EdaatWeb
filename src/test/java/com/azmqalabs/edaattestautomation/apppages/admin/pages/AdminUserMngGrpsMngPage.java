/**
 *
 * Test Script Name                   : N/A
 * Objective                          : Verify Group Management Functionality.
 * Version                            : 1.0
 * Author                             : Kathirvelu M
 * Created Date                       : 01/06/2023
 * Last Updated on                    : N/A
 * Updated By                         : Dhruva Kumar S
 * Pre-Conditions                     : N/A
 * Epic Details                       : N/A
 * User Story Details                 : N/A
 **/
package com.azmqalabs.edaattestautomation.apppages.admin.pages;

import java.awt.Checkbox;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.azmqalabs.edaattestautomation.apppages.GlobalConstant;
import com.azmqalabs.edaattestautomation.apppages.masterpages.BasePage;
import com.azmqalabs.edaattestautomation.common.Log;
import com.azmqalabs.edaattestautomation.common.uielement.fieldDecorator;
import com.azmqalabs.edaattestautomation.objectrepository.EdaatOR;



public class AdminUserMngGrpsMngPage extends BasePage
{

	public AdminUserMngGrpsMngPage(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;

		PageFactory.initElements(new fieldDecorator(driver,test), this);
	}  


	@FindBy(xpath = EdaatOR.Admin_GroupMgm_Header)
	public WebElement Header;


	public boolean Exists(){
		return super.Exists(Header); 
	}


	//Function Summary   : Method to Navigate GroupManagement
	//Parameter Summary : N/A
	public void naviagteGroupManagement(Log Log) {
		try {
			WebClick(EdaatOR.Admin_UserManagement);
			WebClick(EdaatOR.Admin_GropManagment);
			if(CheckElementExists(EdaatOR.Admin_GroupMgm_Header)) {
				Log.ReportEvent("PASS", "Groups Management Page is Loaded Successfully");			
			} else {				
				Log.ReportEvent("FAIL", "Groups Management Page is not Loaded Successfully");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		} catch (Exception e) {	
			Log.ReportEvent("FAIL", "Groups Management Page is not Loaded Successfully");
			this.takeScreenShot();
			e.printStackTrace();
			driver.quit();
			Assert.fail();
		}
	}

	//Function Summary   : Method to Enter Group Name in "Group Name" Text field
	//Parameter Summary : pname

	public void EnterSearchGroupName(String pname) {
		WebEdit(EdaatOR.Admin_GroupMgm_SearchGrpName, pname);
	}

	//Function Summary   : Method to Enter Group Code in "Group Code" Text field
	//Parameter Summary  : pname
	public void EnterSearchGroupCode(String lstname) {
		WebEdit(EdaatOR.Admin_GroupMgm_SearchCode, lstname);
	}

	//Function Summary   : Method to ClickOnGrouSearchBtn
	//Parameter Summary  : N/A
	public void ClickOnGrouSearchBtn() {
		WebClick(EdaatOR.Admin_GroupMgm_SearchButton);
	}
	//Function Summary   : Method to Click on Add Button
	//Parameter Summary  :N/A
	public void ClickOnAddBtn() {
		WebClick(EdaatOR.Admin_GroupMgm_AddGrpBtn);
	}

	//Function Summary   : Method to Enter Group Name In Arabic
	//Parameter Summary  : pname
	public void EnterAddGroupArabic(String pname) {
		WebEdit(EdaatOR.Admin_AddGroupMgm_ArabicName, pname);
	}
	//Function Summary   : Method to Enter Group Name In English
	//Parameter Summary  : lstname
	public void EnterAddGroupEng(String lstname) {
		WebEdit(EdaatOR.Admin_AddGroupMgm_Name, lstname);
	}

	//Function Summary   : Method to Enter Group Description
	//Parameter Summary : lstname
	public void EnterAddGroupDescription(String lstname) {
		WebEdit(EdaatOR.Admin_AddGroupMgm_Description, lstname);
	}
	//Function Summary   : Method to ClickOnTwoFactorAuthentication
	//Parameter Summary  : N/A
	public void ClickOnTwoFactorAuthentication() {
		WebClickUsingJS(EdaatOR.Admin_SearchGroupMgm_SubjectTwoAuthenticateCheck);	
	}

	//Function Summary   : Method to ClickOnSendSmsCheckBox
	//Parameter Summary  : N/A
	public void ClickOnSendSmsCheckBox() {
		WebClickUsingJS(EdaatOR.Admin_SearchGroupMgm_SendSMSValue);	
	}

	//Function Summary   : Method to ClickOnSendEmailCheckBox
	//Parameter Summary  : N/A
	public void ClickOnSendEmailCheckBox() {
		WebClickUsingJS(EdaatOR.Admin_SearchGroupMgm_SendEmailValue);	
	}

	//Function Summary  : Method to EnterHour
	//Parameter Summary : hour
	public void EnterHour(String hour) {
		WebEdit(EdaatOR.Admin_AddGroupMgm_Hour, hour);
	}
	//Function Summary   : Method to Enter Group Code
	//Parameter Summary  : lstname
	public void EnterAddGroupCode(String lstname) {
		WebEdit(EdaatOR.Admin_AddGroupMgm_GroupCode, lstname);
	}

	//Function Summary   : Method to Click on "Add" Button
	//Parameter Summary  : N/A
	public void ClickOnGroupAddBtn() {
		WebClick(EdaatOR.Admin_AddGroupMgm_AddBtn);
	}

	//Function Summary   : Method to Add New Group
	//Parameter Summary : ArabicName,GroupCode,EngName
	public void addGroup(Map<Object, Object> testdatamap,Log Log) throws Exception {
		try {
			ClickOnAddBtn();
			Thread.sleep(2000);
			EnterAddGroupArabic(testdatamap.get("ArabicName").toString());
			EnterAddGroupEng(testdatamap.get("EngName").toString());
			EnterAddGroupDescription(testdatamap.get("Description").toString());
			EnterAddGroupCode(testdatamap.get("GroupCode").toString());
			Thread.sleep(2000);
			ClickOnGroupAddBtn();
			if (CheckElementExists(EdaatOR.Admin_GrpMgm_GrpNameEngError) 
					|| CheckElementExists(EdaatOR.Admin_GrpMgm_GrpNameArbError) || CheckElementExists(EdaatOR.Admin_GrpMgm_GrpNameEngErrorMsg) ||
					CheckElementExists(EdaatOR.Admin_GrpMgm_GrpNameArbErrorMsg) || CheckElementExists(EdaatOR.Admin_GrpMgm_GrpCodeErrorMsg) || 
					CheckElementExists(EdaatOR.Admin_GrpMgm_GrpCodeError)) {
				Log.ReportEvent("FAIL", "Add Group Functionality is UnSuccessful");	
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
			else {
				searchGroupByName(testdatamap.get("ArabicName").toString());
				searchGroupByCode(testdatamap.get("GroupCode").toString());
				ClickOnGrouSearchBtn();	
				VerifyValue1(getText(EdaatOR.Admin_SearchGroupMgm_Code), testdatamap.get("GroupCode").toString());
				Log.ReportEvent("PASS", "Add Group Functionality is Successful");	
			}
		}
		catch(Exception e){
			Log.ReportEvent("FAIL", "Add Group Functionality is UnSuccessful");	
			this.takeScreenShot();
			driver.quit();
			Assert.fail();			}	   
	}

	//Function Summary   : Method to verifyOtpRuleIsOnlyValidForAdmin
	//Parameter Summary  : N/A
	public void verifyOtpRuleIsOnlyValidForAdmin(Log Log) {
		try {
			ClickOnAddBtn();
			Thread.sleep(2000);	
			if (CheckElementExists(EdaatOR.Admin_AddGroupMgm_TwoFactorAuthentication)) {
				ClickOnTwoFactorAuthentication();
				verifyElementIsPresent(EdaatOR.Admin_AddGroupMgm_Hour);
				verifyElementIsPresent(EdaatOR.Admin_SearchGroupMgm_SendSMSValue);
				verifyElementIsPresent(EdaatOR.Admin_SearchGroupMgm_SendEmailValue);
				Log.ReportEvent("PASS", "Otp Rule Is Only Valid For Admin Functionality is Successful");
			} else {
				Log.ReportEvent("FAIL", "Otp Rule Is Only Valid For Admin Functionality is UnSuccessful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		} catch (Exception e) {
			Log.ReportEvent("FAIL", "Otp Rule Is Only Valid For Admin Functionality is UnSuccessful");
			this.takeScreenShot();
			e.printStackTrace();
			driver.quit();
			Assert.fail();
		}
	}

	//Function Summary   : Method to View Users Under The Group
	//Parameter Summary  : UserPopupName
	public void ViewUsersUnderGroup(Map<Object, Object> testdatamap,Log Log) throws Exception {
		try {
			searchGroup(testdatamap, Log);
			WebClick(EdaatOR.Admin_GroupMgm_ViewUser);
			Thread.sleep(2000);
			if (getText(EdaatOR.Admin_GroupMgm_Userspopup).equals(testdatamap.get("UserPopupName").toString())) {
				VerifyValue1(getText(EdaatOR.Admin_GroupMgm_Userspopup), testdatamap.get("UserPopupName").toString());
				Thread.sleep(2000);
				WebClick(EdaatOR.Userlist_close);
				Log.ReportEvent("PASS", "View Users Under Group Functionality is Successful");
			} else {
				Log.ReportEvent("FAIL", "View Users Under Group Functionality is UnSuccessful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		}
		catch(Exception e){
			Log.ReportEvent("FAIL", "View Users Under Group Functionality is UnSuccessful");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();
		}

	}


	//Function Summary   : Method to Search Group by Group Name
	//Parameter Summary : searchName

	public void searchGroupByName(String searchName) throws Exception {
		if(!searchName.equalsIgnoreCase("")) {
			EnterSearchGroupName(searchName);
		}
	}

	//Function Summary   :Method to Search Group by Group Code
	//Parameter Summary : GroupCode
	public void searchGroupByCode(String GroupCode) throws Exception {
		if(!GroupCode.equalsIgnoreCase("")) {
			EnterSearchGroupCode(GroupCode);
		}
	}
	//Function Summary   :Method to Search Group 
	//Parameter Summary : ArabicName,GroupCode,Description,EngName
	public void searchGroup(Map<Object, Object> testdatamap,Log Log) throws Exception {
		try {
			searchGroupByName(testdatamap.get("ArabicName").toString());
			searchGroupByCode(testdatamap.get("GroupCode").toString());
			ClickOnGrouSearchBtn();
			if(CheckElementExists(EdaatOR.Admin_SearchGroupMgm_Nodata))
			{
				ClickOnAddBtn();
				waitForPageToLoad();
				Thread.sleep(1000);
				EnterAddGroupArabic(testdatamap.get("ArabicName").toString());
				EnterAddGroupEng(testdatamap.get("EngName").toString());
				EnterAddGroupDescription(testdatamap.get("Description").toString());
				EnterAddGroupCode(testdatamap.get("GroupCode").toString());
				Thread.sleep(1000);
				Thread.sleep(1000);
				ClickOnGroupAddBtn();
				Thread.sleep(1000);
				if (CheckElementExists(EdaatOR.Admin_GrpMgm_GrpNameEngError) 
						|| CheckElementExists(EdaatOR.Admin_GrpMgm_GrpNameArbError) || CheckElementExists(EdaatOR.Admin_GrpMgm_GrpNameEngErrorMsg) ||
						CheckElementExists(EdaatOR.Admin_GrpMgm_GrpNameArbErrorMsg) || CheckElementExists(EdaatOR.Admin_GrpMgm_GrpCodeErrorMsg) || 
						CheckElementExists(EdaatOR.Admin_GrpMgm_GrpCodeError)) {
					Log.ReportEvent("FAIL", "Add Group Functionality is UnSuccessful");	
					this.takeScreenShot();
					driver.quit();
					Assert.fail();
				}
				else {
					searchGroupByName(testdatamap.get("ArabicName").toString());
					searchGroupByCode(testdatamap.get("GroupCode").toString());
					ClickOnGrouSearchBtn();	
					VerifyValue1(getText(EdaatOR.Admin_SearchGroupMgm_Code), testdatamap.get("GroupCode").toString());
					Log.ReportEvent("PASS", "Search Group Functionality is Successful");	
				}
			}
			else if (getText(EdaatOR.Admin_SearchGroupMgm_Code).equals(testdatamap.get("GroupCode").toString())) {
				VerifyValue1(getText(EdaatOR.Admin_SearchGroupMgm_Code), testdatamap.get("GroupCode").toString());
				Log.ReportEvent("PASS", "Search Group Functionality is Successful");			
			}
			else {
				Log.ReportEvent("FAIL", "Search Group Functionality is UnSuccessful");			
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		}
		catch(Exception e){	
			Log.ReportEvent("FAIL", "Search Group Functionality is UnSuccessful");			
			this.takeScreenShot();
			e.printStackTrace();
			driver.quit();
			Assert.fail();
		}

	}
	//Function Summary   : Method to ClickOnCloseBtn
	//Parameter Summary  : EngName
	public void ClickOnGroupName(String EngName) {

		WebClick("//a[text()='"+EngName+"']");	
	}
	//Function Summary   : Method to ClickOnCloseBtn
	//Parameter Summary  : N/A
	public void ClickOnCloseBtn() {

		WebClick(EdaatOR.Admin_Usermng_viewClose);
	}
	//Function Summary   : Method to VerifyGroupNameClick
	//Parameter Summary  : N/A
	public void VerifyGroupNameClick(Map<Object, Object> testdatamap,Log Log) throws Exception {
		try
		{
			searchGroup(testdatamap, Log);
			ClickOnGroupName(testdatamap.get("EngName").toString());
			Thread.sleep(5000);	
			if (CheckElementExists(EdaatOR.Admin_Usermng_viewgrp)) {
				verifyElementIsPresent(EdaatOR.Admin_Usermng_viewgrp);	
				Log.ReportEvent("PASS", "Group Name is Clickable Functionality is Successful");
			} else {
				Log.ReportEvent("FAIL", "Group Name is Clickable Functionality is UnSuccessful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		}
		catch (Exception e) {
			Log.ReportEvent("FAIL", "Group Name is Clickable Functionality is UnSuccessful");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();
		}
	}	
	//Function Summary   : Method to Verify Delete Group Functionality.
	//Parameter Summary  : ArabicName and GroupCode.
	public void VerifyDeleteGroupFunctionality(Map<Object, Object> testdatamap,Log Log)
	{
		try {
			addGroup(testdatamap,Log);
			WebClick(EdaatOR.Admin_SearchGroupMgm_DeleteBtn);
			Thread.sleep(1000);
			WebClick(EdaatOR.Admin_SearchGroupMgm_YesDeleteBtn);
			Thread.sleep(1000);
			WebClick(EdaatOR.Admin_GropManagment);
			Thread.sleep(1000);
			searchGroupByName(testdatamap.get("ArabicName").toString());
			Thread.sleep(1000);
			searchGroupByCode(testdatamap.get("GroupCode").toString());
			Thread.sleep(1000);
			ClickOnGrouSearchBtn();
			Thread.sleep(1000);
			if(CheckElementExists(EdaatOR.Admin_Usermng_Verifygroup))
			{
				Log.ReportEvent("PASS", "Delete Group Functionality is Successful");
				Thread.sleep(1000);
			}
			else {
				Log.ReportEvent("FAIL", "Delete Group Functionality is UnSuccessful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();	
			}
		}
		catch(Exception e){
			Log.ReportEvent("FAIL", "Delete Group Functionality is UnSuccessful");
			this.takeScreenShot();
			e.printStackTrace();
			driver.quit();
			Assert.fail();
		}

	}
	//Function Summary   : Method to Edit Group Permission
	//Parameter Summary  : ArabicName,GroupCode,ViewDistributionPermission,ViewReceivablesPermission
	public void EditGroupPermission(Map<Object, Object> testdatamap,Log Log) {
		try {
			searchGroupByName(testdatamap.get("ArabicName").toString());
			searchGroupByCode(testdatamap.get("GroupCode").toString());
			ClickOnGrouSearchBtn();
			Thread.sleep(2000);
			Thread.sleep(1000);
			if(CheckElementExists(EdaatOR.Admin_Usermng_nodata))
			{
				addGroup(testdatamap,Log);  
				waitForPageToLoad();
				WebClick(EdaatOR.Admin_GrpMgm_GrpPermissionbtn);
				Thread.sleep(2000);
				WebClickUsingJS(EdaatOR.Admin_GrpMgm_DistributionPermission);
				Thread.sleep(1000);
				WebClickUsingJS(EdaatOR.Admin_GrpMgm_ReceivablesPermission);
				Thread.sleep(1000);
				WebClick(EdaatOR.Admin_GrpMgm_SavePermission);
				Thread.sleep(1000);
				Log.ReportEvent("PASS", "Edit Group Permission Functionality is Successful");
			}
			else if (getText(EdaatOR.Admin_SearchGroupMgm_Code).equals(testdatamap.get("GroupCode").toString())) {
				VerifyValue1(getText(EdaatOR.Admin_SearchGroupMgm_Code), testdatamap.get("GroupCode").toString());
				WebClick(EdaatOR.Admin_GrpMgm_GrpPermissionbtn);
				Thread.sleep(2000);
				WebClickUsingJS(EdaatOR.Admin_GrpMgm_DistributionPermission);
				Thread.sleep(1000);
				WebClickUsingJS(EdaatOR.Admin_GrpMgm_ReceivablesPermission);
				Thread.sleep(1000);
				WebClick(EdaatOR.Admin_GrpMgm_SavePermission);
				Thread.sleep(1000);	
				Log.ReportEvent("PASS", "Edit Group Permission Functionality is Successful");	
			}
			else {
				Log.ReportEvent("FAIL", "Edit Group Permission Functionality is UnSuccessful");	
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		}
		catch (Exception e) {
			Log.ReportEvent("FAIL", "Edit Group Permission Functionality is UnSuccessful");	
			this.takeScreenShot();
			e.printStackTrace();
			driver.quit();
			Assert.fail();
		}
	}
	//Function Summary   : Method to view eye Icon button is Clickable.
	//Parameter Summary  : ArabicName,GroupCode.
	public void Viewpermision(Map<Object, Object> testdatamap,Log Log) {
		try {
			searchGroupByName(testdatamap.get("ArabicName").toString());
			searchGroupByCode(testdatamap.get("GroupCode").toString());
			ClickOnGrouSearchBtn();
			if(CheckElementExists(EdaatOR.Admin_SearchGroupMgm_Nodata))
			{
				ClickOnAddBtn();
				waitForPageToLoad();
				Thread.sleep(1000);
				EnterAddGroupArabic(testdatamap.get("ArabicName").toString());
				EnterAddGroupEng(testdatamap.get("EngName").toString());
				EnterAddGroupDescription(testdatamap.get("Description").toString());
				EnterAddGroupCode(testdatamap.get("GroupCode").toString());
				Thread.sleep(1000);
				Thread.sleep(1000);
				ClickOnGroupAddBtn();
				Thread.sleep(1000);
				if (CheckElementExists(EdaatOR.Admin_GrpMgm_GrpNameEngError) 
						|| CheckElementExists(EdaatOR.Admin_GrpMgm_GrpNameArbError) || CheckElementExists(EdaatOR.Admin_GrpMgm_GrpNameEngErrorMsg) ||
						CheckElementExists(EdaatOR.Admin_GrpMgm_GrpNameArbErrorMsg) || CheckElementExists(EdaatOR.Admin_GrpMgm_GrpCodeErrorMsg) || 
						CheckElementExists(EdaatOR.Admin_GrpMgm_GrpCodeError)) {
					Log.ReportEvent("FAIL", "Add Group Functionality is UnSuccessful");	
					this.takeScreenShot();
					driver.quit();
					Assert.fail();
				}
				else {
					searchGroupByName(testdatamap.get("ArabicName").toString());
					searchGroupByCode(testdatamap.get("GroupCode").toString());
					ClickOnGrouSearchBtn();	
					VerifyValue1(getText(EdaatOR.Admin_SearchGroupMgm_Code), testdatamap.get("GroupCode").toString());
					WebClick(EdaatOR.Admin_Usermng_eyebtn);
					Thread.sleep(3000);
					VerifyValue1(getText(EdaatOR.Admin_Usermng_viewpermision), testdatamap.get("ViewPermision").toString());
					Log.ReportEvent("PASS", "View Group permissions Functionality is Successful");	
				}
			}
			else if (getText(EdaatOR.Admin_SearchGroupMgm_Code).equals(testdatamap.get("GroupCode").toString())) {
				VerifyValue1(getText(EdaatOR.Admin_SearchGroupMgm_Code), testdatamap.get("GroupCode").toString());
				WebClick(EdaatOR.Admin_Usermng_eyebtn);
				Thread.sleep(3000);
				VerifyValue1(getText(EdaatOR.Admin_Usermng_viewpermision), testdatamap.get("ViewPermision").toString());
				Log.ReportEvent("PASS", "View Group Permissions Functionality is Successful");			
			}
			else {
				Log.ReportEvent("FAIL", "View Group Permissions Functionality is UnSuccessful");			
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		}
		catch(Exception e){
			Log.ReportEvent("FAIL", "View Group Permissions Functionality is UnSuccessful");			
			this.takeScreenShot();
			e.printStackTrace();
			driver.quit();
			Assert.fail();
		}

	}
	//Function Summary   : Method to Verify AddGroupErrorMsg
	//Parameter Summary  : Expected
	public void AddGroupErrorMsg(Map<Object, Object> testdatamap,Log Log) {

		try
		{
			ClickOnAddBtn();
			String Expected = testdatamap.get("Expected").toString();
			Thread.sleep(2000);
			EnterAddGroupArabic(testdatamap.get("ArabicName").toString());
			EnterAddGroupEng(testdatamap.get("EngName").toString());
			EnterAddGroupDescription(testdatamap.get("Description").toString());
			EnterAddGroupCode(testdatamap.get("GroupCode").toString());
			Thread.sleep(2000);
			ClickOnGroupAddBtn();
			if(getText(EdaatOR.Admin_GrpMgm_GrpCodeError).equals(Expected))
			{
				Log.ReportEvent("PASS", "Verify Error Message for Group Code is Successful");
			}
			else if (getText(EdaatOR.Admin_GrpMgm_GrpNameEngInvErrorMsg).equals(Expected)) {
				Log.ReportEvent("PASS", "Verify Error Message for Invalid Group Name(in English) is Successful");
			}
			else if (getText(EdaatOR.Admin_GrpMgm_GrpNameArbInvErrorMsg).equals(Expected)) {
				Log.ReportEvent("PASS", "Verify Error Message for Invalid Group Name(in Arabic) is Successful");
			}
			else if (getText(EdaatOR.Admin_GrpMgm_GrpNameEngError).equals(Expected)) {
				Log.ReportEvent("PASS", "Verify Error Message for Group Name(in English) is Successful");
			}
			else if (getText(EdaatOR.Admin_GrpMgm_GrpNameArbError).equals(Expected)) {
				Log.ReportEvent("PASS", "Verify Error Message for Group Name(in Arabic) is Successful");
			}		
			else if (getText(EdaatOR.Admin_GrpMgm_GrpNameEngErrorMsg).equals(Expected)) {
				Log.ReportEvent("PASS", "Verify Error Message for Existing Group Name(in English) is Successful");
			}
			else if (getText(EdaatOR.Admin_GrpMgm_GrpNameArbErrorMsg).equals(Expected)) {
				Log.ReportEvent("PASS", "Verify Error Message for Existing Group Name(in Arabic) is Successful");
			}
			else if (getText(EdaatOR.Admin_GrpMgm_GrpCodeErrorMsg).equals(Expected)) {
				Log.ReportEvent("PASS", "Verify Error Message for Existing Group Code is Successful");
			}
			else {
				Log.ReportEvent("FAIL", "Verify Add Group Error Message is Unsuccessful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();            
			}
		}
		catch (Exception e) {
			Log.ReportEvent("FAIL", "Verify Add Group Error Message is Unsuccessful");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();    
		}	
	}

	//Function Summary   : Method to addGroupTwoFactorAuthenticationEnabled
	//Parameter Summary  : ArabicName,GroupCode,hour,EngName,Description
	public void addGroupTwoFactorAuthenticationEnabled(Map<Object, Object> testdatamap,Log Log) throws Exception {
		try {
			ClickOnAddBtn();
			waitForPageToLoad();
			Thread.sleep(1000);
			EnterAddGroupArabic(testdatamap.get("ArabicName").toString());
			EnterAddGroupEng(testdatamap.get("EngName").toString());
			EnterAddGroupDescription(testdatamap.get("Description").toString());
			EnterAddGroupCode(testdatamap.get("GroupCode").toString());
			ClickOnTwoFactorAuthentication();
			EnterHour(testdatamap.get("hour").toString());
			ClickOnSendSmsCheckBox();
			ClickOnSendEmailCheckBox();
			Thread.sleep(2000);
			ClickOnGroupAddBtn();
			if (CheckElementExists(EdaatOR.Admin_GrpMgm_GrpNameEngError) 
					|| CheckElementExists(EdaatOR.Admin_GrpMgm_GrpNameArbError) || CheckElementExists(EdaatOR.Admin_GrpMgm_GrpNameEngErrorMsg) ||
					CheckElementExists(EdaatOR.Admin_GrpMgm_GrpNameArbErrorMsg) || CheckElementExists(EdaatOR.Admin_GrpMgm_GrpCodeErrorMsg) || 
					CheckElementExists(EdaatOR.Admin_GrpMgm_GrpCodeError)) {
				Log.ReportEvent("FAIL", "Add Group Functionality with 2-Factor Authentication Enabled is UnSuccessful");	
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
			else {
				searchGroupByName(testdatamap.get("ArabicName").toString());
				searchGroupByCode(testdatamap.get("GroupCode").toString());
				ClickOnGrouSearchBtn();	
				VerifyValue1(getText(EdaatOR.Admin_SearchGroupMgm_Code), testdatamap.get("GroupCode").toString());
				Log.ReportEvent("PASS", "Add Group Functionality with 2-Factor Authentication Enabled is Successful");	
			}
		}
		catch(Exception e){
			Log.ReportEvent("FAIL", "Add Group Functionality with 2-Factor Authentication Enabled is UnSuccessful");	
			this.takeScreenShot();
			e.printStackTrace();
			driver.quit();
			Assert.fail();
		}	   
	}

	//Function Summary   : Method to View Two Factor Authentication
	//Parameter Summary  : N/A
	public void ViewTwoFactorAuthentication(Map<Object, Object> testdatamap,Log Log) throws Exception {
		try
		{
			searchGroupByName(testdatamap.get("ArabicName").toString());
			searchGroupByCode(testdatamap.get("GroupCode").toString());
			ClickOnGrouSearchBtn();
			Thread.sleep(3000);
			if(CheckElementExists(EdaatOR.Admin_Usermng_nodata))
			{
				addGroup(testdatamap,Log);
				ClickOnGroupName(testdatamap.get("EngName").toString());
				Thread.sleep(3000);			
				verifyElementIsPresent(EdaatOR.Admin_Usermng_Viewtwofactauth);
				Log.ReportEvent("PASS","2-Factor Authentication Checkbox Available in Add/View Group Page Functionaity is Successful");
			}
			else if (getText(EdaatOR.Admin_SearchGroupMgm_Code).equals(testdatamap.get("GroupCode").toString())) {
				ClickOnGroupName(testdatamap.get("EngName").toString());
				Thread.sleep(3000);			
				verifyElementIsPresent(EdaatOR.Admin_Usermng_Viewtwofactauth);
				Log.ReportEvent("PASS","2-Factor Authentication Checkbox Available in Add/View Group Page Functionaity is Successful");
			}
			else {			
				Log.ReportEvent("FAIL","2-Factor Authentication Checkbox Available in Add/View Group Page Functionaity is UnSuccessful");
				this.takeScreenShot();	
				driver.quit();
				Assert.fail();
			}
		}
		catch (Exception e) {
			Log.ReportEvent("FAIL","2-Factor Authentication Checkbox Available in Add/View Group Page Functionaity is UnSuccessful");
			this.takeScreenShot();	
			e.printStackTrace();
			driver.quit();
			Assert.fail();
		}
	}

	//Function Summary   : Method to Verify the type checkbox have two values SMS,Email or both of them
	//Parameter Summary  : N/A.
	public void VerifySubjectToTwoFactorAuthenticationCheckbox(Log Log)
	{
		try {
			ClickOnAddBtn();
			Thread.sleep(1000);
			if (CheckElementExists(EdaatOR.Admin_AddGroupMgm_TwoFactorAuthentication)) {
				WebClickUsingJS(EdaatOR.Admin_SearchGroupMgm_SubjectTwoAuthenticateCheck);
				Thread.sleep(2000);
				verifyElementIsPresent(EdaatOR.Admin_SearchGroupMgm_SendSMSValue);
				Thread.sleep(1000);
				verifyElementIsPresent(EdaatOR.Admin_SearchGroupMgm_SendEmailValue);
				Log.ReportEvent("PASS", "The Type Checkbox have Two Values SMS,Email or Both of them Functionality is Successful");

			} else {
				Log.ReportEvent("FAIL", "The Type Checkbox have Two Values SMS,Email or Both of them Functionality is UnSuccessful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}	
		}

		catch (Exception e) {
			Log.ReportEvent("FAIL", "The Type Checkbox have Two Values SMS,Email or Both of them Functionality is UnSuccessful");
			this.takeScreenShot();
			e.printStackTrace();
			driver.quit();
			Assert.fail();
		}
	}

	//Function Summary   : Method to verifyEditGroupTwoFactorAuthentication
	//Parameter Summary  : ArabicName,GroupCode,EditHour
	public void verifyEditGroupTwoFactorAuthentication(Map<Object, Object> testdatamap, Log Log) {
		try {
			searchGroupByName(testdatamap.get("ArabicName").toString());
			searchGroupByCode(testdatamap.get("GroupCode").toString());
			ClickOnGrouSearchBtn();
			Thread.sleep(3000);
			if(CheckElementExists(EdaatOR.Admin_Usermng_nodata))
			{
				addGroupTwoFactorAuthenticationEnabled(testdatamap,Log);
				waitForPageToLoad();
				WebClickUsingJS(EdaatOR.Admin_GrpMgm_GrpEditbtn);
				Thread.sleep(2000);
				ClickOnSendSmsCheckBox();
				EnterHour(testdatamap.get("EditHour").toString());
				WebClick(EdaatOR.Admin_GrpMgm_SaveChangesbtn);
				Thread.sleep(1000);
				searchGroupByName(testdatamap.get("ArabicName").toString());
				searchGroupByCode(testdatamap.get("GroupCode").toString());
				ClickOnGrouSearchBtn();
				Thread.sleep(2000);
				WebClickUsingJS(EdaatOR.Admin_GrpMgm_GrpEditbtn);
				Thread.sleep(3000);	
				VerifyValue1(WebGetTextAttribute(EdaatOR.Admin_AddGroupMgm_Hour),testdatamap.get("EditHour").toString());	
				Log.ReportEvent("PASS", "Admin can Edit the 2-Factor Authentication Section/Setting any Time Functionality is Successful");
			}
			else if (getText(EdaatOR.Admin_SearchGroupMgm_Code).equals(testdatamap.get("GroupCode").toString())) {		
				WebClickUsingJS(EdaatOR.Admin_GrpMgm_GrpEditbtn);
				Thread.sleep(2000);
				ClickOnSendSmsCheckBox();
				EnterHour(testdatamap.get("EditHour").toString());
				WebClick(EdaatOR.Admin_GrpMgm_SaveChangesbtn);
				Thread.sleep(1000);
				searchGroupByName(testdatamap.get("ArabicName").toString());
				searchGroupByCode(testdatamap.get("GroupCode").toString());
				ClickOnGrouSearchBtn();
				Thread.sleep(2000);
				WebClickUsingJS(EdaatOR.Admin_GrpMgm_GrpEditbtn);
				Thread.sleep(3000);	
				VerifyValue1(WebGetTextAttribute(EdaatOR.Admin_AddGroupMgm_Hour),testdatamap.get("EditHour").toString());	
				Log.ReportEvent("PASS", "Admin can Edit the 2-Factor Authentication Section/Setting any Time Functionality is Successful");
			}
			else {
				Log.ReportEvent("FAIL", "Admin can Edit the 2-Factor Authentication Section/Setting any Time Functionality is Unsuccessful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}	    
		}
		catch (Exception e) {
			Log.ReportEvent("FAIL", "Admin can Edit the 2-Factor Authentication Section/Setting any Time Functionality is Unsuccessful");
			this.takeScreenShot();
			e.printStackTrace();
			driver.quit();
			Assert.fail();
		}

	}
	//Function Summary   : Method to verify Two Factor Authentication Valid For Hour Textfield
	//Parameter Summary  : Hour
	public void verifyTwoFactorAuthenticationValidForHourTextfield(Map<Object, Object> testdatamap,Log Log) throws Exception {
		try
		{
			ClickOnAddBtn();
			waitForPageToLoad();				
			Thread.sleep(500);		
			if (CheckElementExists(EdaatOR.Admin_Usermng_Viewtwofactauth)) {
				WebClick(EdaatOR.Admin_Usermng_Viewtwofactauth);
				Thread.sleep(1000);		
				VerifyValue1(getAttributeValue(EdaatOR.Admin_Usermng_AddGroup_EnterHours, "value"), "10");
				Thread.sleep(500);
				WebEdit(EdaatOR.Admin_Usermng_AddGroup_EnterHours,testdatamap.get("Hours").toString());
				Thread.sleep(500);
				Log.ReportEvent("PASS", "The Time Field is a Textbox with Min 1 and Max 120 and the Default Value is 10 Functionality is Successful");
			} else {
				Log.ReportEvent("FAIL", "The Time Field is a Textbox with Min 1 and Max 120 and the Default Value is 10 Functionality is UnSuccessful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}				   
		}
		catch (Exception e) {
			Log.ReportEvent("FAIL", "The Time Field is a Textbox with Min 1 and Max 120 and the Default Value is 10 Functionality is UnSuccessful");
			this.takeScreenShot();
			e.printStackTrace();
			driver.quit();
			Assert.fail();
		}
	}
	//Function Summary   : Method to View Two Factor Authentication Clicking on Group Name
	//Parameter Summary  : ArabicName,GroupCode,EngName
	public void ViewTwoFactorAuthenticationClickingOnGroupName(Map<Object, Object> testdatamap,Log Log) throws Exception {
		try
		{
			searchGroupByName(testdatamap.get("ArabicName").toString());
			searchGroupByCode(testdatamap.get("GroupCode").toString());
			ClickOnGrouSearchBtn();
			Thread.sleep(3000);
			if(CheckElementExists(EdaatOR.Admin_Usermng_nodata))
			{
				addGroup(testdatamap,Log);
				waitForPageToLoad();
				ClickOnGroupName(testdatamap.get("EngName").toString());
				Thread.sleep(3000);				
				verifyElementIsPresent(EdaatOR.Admin_Usermng_Viewtwofactauth);
				VerifyObjectDisabled(EdaatOR.Admin_Usermng_AddGroupViewtwofactauthcheckbox);
				Thread.sleep(2000);				
				ClickOnCloseBtn();
				Log.ReportEvent("PASS", "View the 2 Factor Authentication Part when Clicking on Group Name Functionality is Successful");
			}
			else if (getText(EdaatOR.Admin_SearchGroupMgm_Code).equals(testdatamap.get("GroupCode").toString())) {
				ClickOnGroupName(testdatamap.get("EngName").toString());
				Thread.sleep(3000);				
				verifyElementIsPresent(EdaatOR.Admin_Usermng_Viewtwofactauth);
				VerifyObjectDisabled(EdaatOR.Admin_Usermng_AddGroupViewtwofactauthcheckbox);
				Thread.sleep(2000);				
				ClickOnCloseBtn();
				Log.ReportEvent("PASS", "View the 2 Factor Authentication Part when Clicking on Group Name Functionality is Successful");				
			}
			else {
				Log.ReportEvent("FAIL", "View the 2 Factor Authentication Part when Clicking on Group Name Functionality is UnSuccessful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		}
		catch (Exception e) {
			Log.ReportEvent("FAIL", "View the 2 Factor Authentication Part when Clicking on Group Name Functionality is UnSuccessful");
			this.takeScreenShot();
			e.printStackTrace();
			driver.quit();
			Assert.fail();
		}
	}	

	//Function Summary   : Method to Select two factor authentication view result
	//Parameter Summary  : N/A
	public void selectTwoFactorAuthenticationViewResult(Map<Object, Object> testdatamap,Log Log) throws Exception {
		try
		{
			ClickOnAddBtn();
			waitForPageToLoad();				
			Thread.sleep(500);	
			if (CheckElementExists(EdaatOR.Admin_Usermng_Viewtwofactauth)) {
				verifyElementIsPresent(EdaatOR.Admin_Usermng_Viewtwofactauth);
				Thread.sleep(500);
				WebClick(EdaatOR.Admin_Usermng_Viewtwofactauth);
				Thread.sleep(500);
				verifyElementIsPresent(EdaatOR.Admin_Usermng_AddGroup_SendSMS);
				verifyElementIsPresent(EdaatOR.Admin_Usermng_AddGroup_SendEmail);            
				WebEdit(EdaatOR.Admin_Usermng_AddGroup_EnterHours,testdatamap.get("Hours").toString());
				Thread.sleep(500);
				WebClick(EdaatOR.Admin_Usermng_AddGroup_SendSMS);
				Thread.sleep(500);
				WebClick(EdaatOR.Admin_Usermng_AddGroup_SendEmail);						
				Thread.sleep(500);
				Log.ReportEvent("PASS", "2-Factor Authentication Checkbox is Selected the User Should Fill the Time in Hours & the Type [Email or SMS] Fuctionality is Successful");
			} else {

				Log.ReportEvent("FAIL", "2-Factor Authentication Checkbox is Selected the User Should Fill the Time in Hours & the Type [Email or SMS] Fuctionality is UnSuccessful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		}
		catch (Exception e) {
			Log.ReportEvent("FAIL", "2-Factor Authentication Checkbox is Selected the User Should Fill the Time in Hours & the Type [Email or SMS] Fuctionality is UnSuccessful");
			this.takeScreenShot();
			e.printStackTrace();
			driver.quit();
			Assert.fail();
		}
	}		
}
