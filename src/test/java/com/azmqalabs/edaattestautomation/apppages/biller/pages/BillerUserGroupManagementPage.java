/**
*
* Test Script Name                   : N/A
* Objective                          : Verify Group Management Functionality.
* Version                            : 1.0
* Author                             : Kathirvelu M
* Created Date                       : 01/06/2023
* Last Updated on                    : N/A
* Updated By                         : Obalanayak m s
* Pre-Conditions                     : N/A
* Manual Testcase Name               : N/A
* Epic Details                       : N/A
* User Story Details                 : N/A
* Defects affecting this test script : None
* Work Arounds/Known Issues          : None
**/
package com.azmqalabs.edaattestautomation.apppages.biller.pages;

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

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.azmqalabs.edaattestautomation.apppages.GlobalConstant;
import com.azmqalabs.edaattestautomation.apppages.masterpages.BasePage;
import com.azmqalabs.edaattestautomation.common.Log;
import com.azmqalabs.edaattestautomation.common.uielement.fieldDecorator;
import com.azmqalabs.edaattestautomation.objectrepository.EdaatOR;



public class BillerUserGroupManagementPage extends BasePage
{

	public BillerUserGroupManagementPage(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;

		PageFactory.initElements(new fieldDecorator(driver,test), this);
	}  


	@FindBy(xpath = EdaatOR.Biller_GroupMgm_Header)
	public WebElement Header;


	public boolean Exists(){
		return super.Exists(Header); 
	}


	//Function Summary   : Method to Navigate GroupManagement
	//Parameter Summary : N/A
	public void naviagteGroupManagement(Log Log) {
		WebClick(EdaatOR.Biller_UserManagement);
		WebClick(EdaatOR.Biller_GropManagment);
		waitForPageToLoad();
    	Log.ReportEvent("PASS", " Navigate to Group Management Page");

	}

	//Function Summary   : Method to Enter Group Name in "Group Name" Text field
	//Parameter Summary : pname

	public void EnterSearchGroupName(String pname) {
		WebEdit(EdaatOR.Biller_GroupMgm_SearchGrpName, pname);
	}

	//Function Summary   : Method to Enter Group Code in "Group Code" Text field
	//Parameter Summary : pname
	public void EnterSearchGroupCode(String lstname) {
		WebEdit(EdaatOR.Biller_GroupMgm_SearchCode, lstname);
	}

	//Function Summary   : Method to Click on "Search" Button
	//Parameter Summary : pname
	public void ClickOnGrouSearchBtn() {
		WebClick(EdaatOR.Biller_GroupMgm_SearchButton);
	}
	//Function Summary   : Method to Click on Add Button
	//Parameter Summary :N/A
	public void ClickOnAddBtn() {
		WebClick(EdaatOR.Biller_GroupMgm_AddGrpBtn);
	}

	//Function Summary   : Method to Enter Group Name In Arabic
	//Parameter Summary : pname
	public void EnterAddGroupArabic(String pname) {
		WebEdit(EdaatOR.Biller_AddGroupMgm_ArabicName, pname);
	}
	//Function Summary   : Method to Enter Group Name In English
	//Parameter Summary : lstname
	public void EnterAddGroupEng(String lstname) {
		WebEdit(EdaatOR.Biller_AddGroupMgm_Name, lstname);
	}

	//Function Summary   : Method to Enter Group Description
	//Parameter Summary : lstname
	public void EnterAddGroupDescription(String lstname) {
		WebEdit(EdaatOR.Biller_AddGroupMgm_Description, lstname);
	}
	//Function Summary   : Method to Enter Group Code
	//Parameter Summary : lstname
	public void EnterAddGroupCode(String lstname) {
		WebEdit(EdaatOR.Biller_AddGroupMgm_GroupCode, lstname);
	}

	//Function Summary   : Method to Click on "Add" Button
	//Parameter Summary : N/A
	public void ClickOnGroupAddBtn() {
		WebClick(EdaatOR.Biller_AddGroupMgm_AddBtn);
	}

	//Function Summary   : Method to Add New Group
	//Parameter Summary : ArabicName,GroupCode,EngName

	public void addGroup(Map<Object, Object> testdatamap,Log Log) throws Exception {
		try {
			ClickOnAddBtn();
			waitForPageToLoad();
			Thread.sleep(1000);
			EnterAddGroupArabic(testdatamap.get("ArabicName").toString());
			EnterAddGroupEng(testdatamap.get("EngName").toString());
			EnterAddGroupDescription(testdatamap.get("Description").toString());
			EnterAddGroupCode(testdatamap.get("GroupCode").toString());
			ClickOnGroupAddBtn();
			waitForPageToLoad();
			searchGroupByName(testdatamap.get("ArabicName").toString());
			ClickOnGrouSearchBtn();
			VerifyValue1(getText(EdaatOR.Biller_SearchGroupMgm_GrpName), testdatamap.get("EngName").toString());
			VerifyValue1(getText(EdaatOR.Biller_SearchGroupMgm_Code), testdatamap.get("GroupCode").toString());
			waitForPageToLoad();
        	Log.ReportEvent("PASS", " Verify to add new group");

		}
		catch(Exception e){
			test.log(Status.FAIL,"#FUNC-Add Group is Failed" + driver.getTitle() +" * User Group Management  FAIL * " );
			this.takeScreenShot();
		}	   
	}
	
	//Function Summary   : Method to View Users Under The Group
	//Parameter Summary  : UserPopupName
	public void ViewUsers(Map<Object, Object> testdatamap,Log Log) throws Exception {
		try {
			
			WebClick(EdaatOR.Biller_GroupMgm_UsersBtn);
			Thread.sleep(20000);
			 VerifyValue1(getText(EdaatOR.Biller_GroupMgm_Userspopup), testdatamap.get("UserPopupName").toString());
			 test.log(Status.PASS,"#FUNC-addGrop is successful" + driver.getTitle() +" * User Group Management PASS * " );	
	        	Log.ReportEvent("PASS", " Verify to view the users under this group ");

			 WebClick(EdaatOR.Userlist_close);
		}
		catch(Exception e){
			test.log(Status.FAIL,"#FUNC-Add Group is Failed" + driver.getTitle() +" * User Group Management  FAIL * " );
			this.takeScreenShot();
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
	//Parameter Summary : ArabicName,GroupCode
	public void searchGroup(Map<Object, Object> testdatamap,Log Log) throws Exception {
		try {
	        searchGroupByName(testdatamap.get("ArabicName").toString());
			searchGroupByCode(testdatamap.get("GroupCode").toString());
			ClickOnGrouSearchBtn();
	//		VerifyValue1(getText(EdaatOR.Biller_SearchGroupMgm_GrpName), testdatamap.get("ArabicName").toString());
			VerifyValue1(getText(EdaatOR.Biller_SearchGroupMgm_Code), testdatamap.get("GroupCode").toString());
			test.log(Status.PASS,"#FUNC-Search Group is successful" + driver.getTitle() +" * User Group Management PASS * " );	
        	Log.ReportEvent("PASS", " Verify to Search new group");

		}
		catch(Exception e){
			test.log(Status.FAIL,"#FUNC-Search Group is Failed" + driver.getTitle() +" * User Group Management  FAIL * " );
			this.takeScreenShot();
		}

	}
	//Function Summary   : Method to Delete Group
	//Parameter Summary : GroupCode
	public void deleteGroup(Map<Object, Object> testdatamap,Log Log) throws Exception {
		try {
			searchGroupByCode(testdatamap.get("GroupCode").toString());
			Thread.sleep(1500);
			ClickOnGrouSearchBtn();
			WebClick(EdaatOR.Biller_SearchGroupMgm_DeleteBtn);
			Thread.sleep(500);
			WebClick(EdaatOR.Biller_SearchGroupMgm_YesDeleteBtn);
			Thread.sleep(1000);
			searchGroupByCode(testdatamap.get("GroupCode").toString());
			ClickOnGrouSearchBtn();
			verifyElementIsPresent(EdaatOR.Biller_SearchGroupMgm_Nodata, "Record got deleted");
			test.log(Status.PASS,"#FUNC-Delete Group is successful" + driver.getTitle() +" * User Group Management PASS * " );	
        	Log.ReportEvent("PASS", " Verify to Deiete new group");

		}
		catch(Exception e){
			test.log(Status.FAIL,"#FUNC-Delete Group is Failed" + driver.getTitle() +" * User Group Management  FAIL * " );
			this.takeScreenShot();
		}

	}
	
	//Function Summary   : Method to Update and View Group Permission
	//Parameter Summary  : GroupPermission,GroupCode
	public void updateAndViewGroupPermission(Map<Object, Object> testdatamap,Log Log) throws Exception {
		try {
			searchGroupByCode(testdatamap.get("GroupCode").toString());
			ClickOnGrouSearchBtn();
			WebClick(EdaatOR.Biller_SearchGroupMgm_EditIcon);
			Thread.sleep(3000);
			VerifyValue1(getText(EdaatOR.Biller_SearchGroupMgm_PermissuionPOp), testdatamap.get("GroupPermission").toString());
			Thread.sleep(3000);
			WebClickUsingJS(EdaatOR.Biller_EditGroup_Receivable);
			Thread.sleep(1000);
			WebClick(EdaatOR.Biller_EditGroup_UpdateBtn);
			Thread.sleep(1000);
			searchGroupByCode(testdatamap.get("GroupCode").toString());
			ClickOnGrouSearchBtn();
			WebClick(EdaatOR.Biller_SearchGroupMgm_EditIcon);
			Thread.sleep(2000);
			if(IsSelected(EdaatOR.Biller_EditGroup_Receivable)==true) {
				test.log(Status.PASS,"Receivable Check box is permission selected " );
	            Log.ReportEvent("PASS", " Verify to view group permission and Verify to edit group permission");

			}
			else {
				test.log(Status.FAIL,"Receivable Check box is permission not selected " );
			}
			test.log(Status.PASS,"#FUNC-update Group is successful" + driver.getTitle() +" * User Group Management PASS * " );	
		}
		catch(Exception e){
			test.log(Status.FAIL,"#FUNC-update Group is Failed" + driver.getTitle() +" * User Group Management  FAIL * " );
			this.takeScreenShot();
		}

	}


	public void verifyViewGroupUnderUserList(Map<Object, Object> testdatamap) throws Exception {
		boolean listGr=false;
		try {
			List<WebElement> glist=driver.findElements(By.xpath(EdaatOR.Biller_Userlist_groups));
			for(int i=0;i<glist.size();i++) {
				int g=i+1;
				String grList=glist.get(i).getText();
				if(grList.contains(testdatamap.get("ArabicName").toString())) {
					test.log(Status.PASS,"Group Name is available in the userlist " );
					listGr=true;
					break;
				}
			}
			if(listGr==false) {
				test.log(Status.FAIL,"Group Name is not available in the userlist " );
			}
		}
		catch(Exception e){
			test.log(Status.FAIL,"#FUNC-View Group is Failed" + driver.getTitle() +" * User Group Management  FAIL * " );
			this.takeScreenShot();
		}

	}

	//Function Summary   : Method to Add New Group
	//Parameter Summary : ArabicName,GroupCode,EngName,Description
	public void addGroupUI(Map<Object, Object> testdatamap) throws Exception {
		try {
			ClickOnAddBtn();
			waitForPageToLoad();
			Thread.sleep(1000);
			EnterAddGroupArabic(testdatamap.get("ArabicName").toString());
			Thread.sleep(300);
			EnterAddGroupEng(testdatamap.get("EngName").toString());
			Thread.sleep(300);
			EnterAddGroupDescription(testdatamap.get("Description").toString());
			Thread.sleep(300);
			EnterAddGroupCode(testdatamap.get("GroupCode").toString());
			Thread.sleep(300);
			ClickOnGroupAddBtn();
			
		}
		catch(Exception e){
			test.log(Status.FAIL,"#FUNC-Add Group is Failed" + driver.getTitle() +" * User Group Management  FAIL * " );
			this.takeScreenShot();
		}	   
	}
	    //Function Summary   : Method to Verify AddGroupErrorMsg
	   //Parameter Summary  : Expected
		public void AddGroupErrorMsgValidation(Map<Object, Object> testdatamap) {
			try
			{
				addGroupUI(testdatamap);
				if(ExistsCheck(EdaatOR.Biller_GrpMgm_GrpCodeError))
				{
					VerifyValue1(getText(EdaatOR.Biller_GrpMgm_GrpCodeError), testdatamap.get("Expected").toString());
					test.log(Status.PASS, "#FUNC-GroupMng EnterGroupCode ErrorMessage Exists" + driver.getTitle() + " * EnterGroupCode ErrorMessage Exists * ");
				}
				else if (ExistsCheck(EdaatOR.Biller_GrpMgm_GrpNameEngError)) {
				    VerifyValue1(getText(EdaatOR.Biller_GrpMgm_GrpNameEngError), testdatamap.get("Expected").toString());
					test.log(Status.PASS, "#FUNC-GroupMng EnterEngGroupName ErrorMessage Exists" + driver.getTitle() + " * EnterEngGroupName ErrorMessage Exists * ");
				}
				else if (ExistsCheck(EdaatOR.Biller_GrpMgm_GrpNameArbError)) {
				    VerifyValue1(getText(EdaatOR.Biller_GrpMgm_GrpNameArbError), testdatamap.get("Expected").toString());
					test.log(Status.PASS, "#FUNC-GroupMng EnterArbGroupName ErrorMessage Exists" + driver.getTitle() + " * EnterArbGroupName ErrorMessage Exists * ");
				}
				else if (ExistsCheck(EdaatOR.Biller_GrpMgm_GrpNameEngErrorMsg)) {
					VerifyValue1(getText(EdaatOR.Biller_GrpMgm_GrpNameEngErrorMsg), testdatamap.get("Expected").toString());
					test.log(Status.PASS, "#FUNC-GroupMng EngGroupName ErrorMessage Exists" + driver.getTitle() + " * EngGroupName ErrorMessage Exists * ");
				}
	            else if (ExistsCheck(EdaatOR.Biller_GrpMgm_GrpNameArbErrorMsg)) {
					VerifyValue1(getText(EdaatOR.Biller_GrpMgm_GrpNameArbErrorMsg), testdatamap.get("Expected").toString());
					test.log(Status.PASS, "#FUNC-GroupMng ArbGroupName ErrorMessage Exists" + driver.getTitle() + " * ArbGroupName ErrorMessage Exists * ");
				}
	            else if (ExistsCheck(EdaatOR.Biller_GrpMgm_GrpCodeErrorMsg)) {
					VerifyValue1(getText(EdaatOR.Biller_GrpMgm_GrpCodeErrorMsg), testdatamap.get("Expected").toString());
					test.log(Status.PASS, "#FUNC-GroupMng GroupCode ErrorMessage Exists" + driver.getTitle() + " * GroupCode ErrorMessage Exists * ");
				}
	            else {
	            	test.log(Status.FAIL, "#FUNC-Element Not Exists" + driver.getTitle() + " * Element Not Exists * ");
	            }
			}
			catch (Exception e) {
				test.log(Status.FAIL,"#FUNC-Group Management Add Group" + driver.getTitle() +" * Group Management Add Group FAIL * " );
				this.takeScreenShot();
			}	
		}
		
		//Function Summary   : Method to Verify that the Custom reconciliation report appears in the  Group Permission
		//Parameter Summary  : GroupCode,
		public void VerifyCustomReconciliationReportAppearsIntheGroupPermission(Map<Object, Object> testdatamap,Log Log) throws Exception {
			try {
				Thread.sleep(1000);
				addGroupUI(testdatamap);
				Thread.sleep(1000);
				searchGroupByCode(testdatamap.get("GroupCode").toString());
				Thread.sleep(300);
				ClickOnGrouSearchBtn();
				Thread.sleep(1000);
				WebClick(EdaatOR.Biller_SearchGroupMgm_EditIcon);
				Thread.sleep(1000);
				WebClickUsingJS(EdaatOR.Biller_Usermng_GrpPermission_Reports);
				Thread.sleep(1000);
				WebClick(EdaatOR.Biller_Usermng_GrpPermission_RecievableReports);
				Thread.sleep(1000);
				verifyElementIsPresent(EdaatOR.Biller_Usermng_CustomReconciliationReport_GrpPermission);
				test.log(Status.PASS,"#FUNC-Verify that the Custom reconciliation report appears in the  Group Permission is successful" + driver.getTitle() +" * PASS * " );	
			}
			catch(Exception e){
				test.log(Status.FAIL,"#FUNC-Verify that the Custom reconciliation report appears in the  Group Permission is Failed" + driver.getTitle() +" *FAIL * " );
				this.takeScreenShot();
			}

		}
	
}
