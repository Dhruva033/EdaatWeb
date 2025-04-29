/**
*
* Test Script Name                   : N/A
* Objective                          : Verify User List Functionality
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
import org.openqa.selenium.Keys;
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



public class BillerUserMngUserListPage extends BasePage
{

	public BillerUserMngUserListPage(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;

		PageFactory.initElements(new fieldDecorator(driver,test), this);
	}  


	@FindBy(xpath = EdaatOR.Biller_Client)
	public WebElement Client;


	public boolean Exists(){
		return super.Exists(Client); 
	}


	//Function Summary   : Method to Navigate User Management and UserList Page
	//Parameter Summary : N/A
	public void navigateUserlistPage(Log Log) throws Exception {
		WebClickUsingJS(EdaatOR.Biller_Menu_UserManagement);
		Thread.sleep(2000);
		WebClickUsingJS(EdaatOR.Biller_Menu_UserList);
		Thread.sleep(2000);
    	Log.ReportEvent("PASS", " Verify User List Page is Displayed");

	}

	//Function Summary   : Method to Click on "AddUser" Button
	//Parameter Summary  :N/A
	public void ClickOnAddUserBtn() {
		WebClick(EdaatOR.Biller_UserList_AddUserBt);
	}
	//Function Summary   : Method to Enter UserName in "Name" Text Field
	//Parameter Summary  :pname
	public void EnterUserNameBox(String pname) {
		WebEdit(EdaatOR.Biller_UserListAdd_NameInput, pname);
	}
	//Function Summary   : Method to Enter Email in "Email" Text Field
	//Parameter Summary  :lstname
	public void EnterEmailIdBox(String lstname) {
		WebEdit(EdaatOR.Biller_UserListAdd_EmailInput, lstname);
	}
	//Function Summary   : Method to Enter number in "PhoneNumber" Text Field
	//Parameter Summary  :lstname
	public void EnterPhoneNmBox(String lstname) {
		WebEdit(EdaatOR.Biller_UserListAdd_PhoneInput, lstname);
	}
	//Function Summary   : Method to Select "Group" Checkbox
	//Parameter Summary  : N/A
	public void ClickOnGrouChekbox() {
		WebClickUsingJS(EdaatOR.Biller_UserListAdd_GroupCheckBox);
		WebClickUsingJS(EdaatOR.Biller_UserListAdd_GroupCheckBox2);
	}
	//Function Summary   : Method to Click on "Add" Button
	//Parameter Summary  : N/A
	public void ClickOnUserAddBtn() {
		WebClick(EdaatOR.Biller_UserListAdd_AddUserBtPop);
	}

	//Function Summary   : Method to name in "Name" TextField
	//Parameter Summary  :lstname
	public void EnterSearchUserName(String lstname) {
		WebEdit(EdaatOR.Biller_UserListSearch_NameBt, lstname);
	}
	//Function Summary   : Method to Email in "Email" TextField
	//Parameter Summary  :lstname
	public void EnterSearchEmalID(String lstname) {
		WebEdit(EdaatOR.Biller_UserListSearch_EmailBt, lstname);
	}
	//Function Summary   : Method to Click on "Search" Button
	//Parameter Summary  : N/A
	public void ClickOnUselistSearchBtn() {
		WebClick(EdaatOR.Biller_UserListSearch_SaerchBt);
	}

	public void ClickOnDiscountDeleteBtn() {
		WebClick(EdaatOR.Biller_Discount_DeleteBtn);
	}

	public void ClickOnDiscountConfYesBtn() {
		WebClick(EdaatOR.Biller_Discount_YesConfBtn);
	}

	public void ClickOnUserDeleteBtn() {
		WebClick(EdaatOR.Biller_UserList_DeleteBtn);
	}

	public void ClickOnUserConfYesBtn() {
		WebClick(EdaatOR.Biller_UserList_YesConfBtn );
	}

	
	

	//Function Summary   : Method to Add New User
	//Parameter Summary : UserName,EmailID,PhoneNum
	public void AddUser(Map<Object,Object>testdatamap) throws Exception {
		ClickOnAddUserBtn();
		Thread.sleep(1500);
		EnterUserNameBox(testdatamap.get("UserName").toString());
		Thread.sleep(500);
		EnterEmailIdBox(testdatamap.get("EmailID").toString());
		Thread.sleep(200);
		EnterPhoneNmBox(testdatamap.get("PhoneNum").toString());
		ClickOnGrouChekbox();
		Thread.sleep(2000);
		ClickOnUserAddBtn();
	Thread.sleep(3000);	
	}

	//Function Summary   : Method to Search Users
	//Parameter Summary  :UserName,EmailID
	public void SearchUser(Map<Object,Object>testdatamap) throws Exception {
		EnterSearchUserName(testdatamap.get("UserName").toString());
		EnterSearchEmalID(testdatamap.get("EmailID").toString());
		ClickOnUselistSearchBtn();
		Thread.sleep(1500);
	}

	public void DeleteUser(Map<Object,Object>testdatamap) throws Exception {
		ClickOnUserDeleteBtn();
		Thread.sleep(1500);
		VerifyValue1(getText(EdaatOR. Biller_UserList_ConfirmDeletePop), testdatamap.get("DeleteUser").toString());
			Thread.sleep(1500);
			ClickOnUserConfYesBtn();
		Thread.sleep(1500);

	}

	//Function Summary   : Method to Delete Users
	//Parameter Summary  :UserName	
	public void verifyDeleteUser(Map<Object,Object> testdatamap,Log Log) throws Exception {
		try {
			AddUser(testdatamap);
			Thread.sleep(3500);
			SearchUser(testdatamap);
			DeleteUser(testdatamap);
			Thread.sleep(1500);
			SearchUser(testdatamap);
			Thread.sleep(3500);
			verifyElementIsPresent(EdaatOR.Biller_Product_NoData);
			WebClickUsingJS(EdaatOR.Biller_UserList_IsDeletChekckbox);
			SearchUser(testdatamap);
			Thread.sleep(3500);
			VerifyValue1(getText(EdaatOR.Biller_UserList_UserName), testdatamap.get("UserName").toString());
			Thread.sleep(3500);
			verifyElementIsNotPresent(EdaatOR.Biller_Product_NoData, "Data is exists");
			Thread.sleep(1500);
			test.log(Status.PASS,"#FUNC-Delete User from userlist and IsDelete User check box" + driver.getTitle() +" * User Management PASS * " );	
        	Log.ReportEvent("PASS", " Verify User Is Deleted Successfully and Verify Deleted Users checkbox");

		}
		catch(Exception e){
			test.log(Status.FAIL,"#FUNC-Delete User from userlist and IsDelete User check box" + driver.getTitle() +" * User Management  FAIL * " );
			this.takeScreenShot();
		}
	}


	//Function Summary   : Method to Add New User
	//Parameter Summary : UserName
	public void verifyAddUser(Map<Object,Object> testdatamap,Log Log) throws Exception {
		try {
			AddUser(testdatamap);
			waitForPageToLoad();
			SearchUser(testdatamap);
			VerifyValue1(getText(EdaatOR.Biller_UserList_UserName), testdatamap.get("UserName").toString());
			verifyElementIsPresent(EdaatOR.Biller_Userlisttoggledisable);
			verifyElementIsNotPresent(EdaatOR.Biller_Product_NoData, "Data is exists");
			test.log(Status.PASS,"#FUNC-Add User from userlist" + driver.getTitle() +" * User Management PASS * " );	
        	Log.ReportEvent("PASS", " Verify to add new user account");

		}
		catch(Exception e){
			test.log(Status.FAIL,"#FUNC-Add User from userlist" + driver.getTitle() +" * User Management  FAIL * " );
			this.takeScreenShot();
		}
	}
	
	//Function Summary   : Method to Search User
	//Parameter Summary : UserName
	public void verifySearchUser(Map<Object,Object> testdatamap,Log Log) throws Exception {
		try {
			SearchUser(testdatamap);
			if(CheckElementExists(EdaatOR.Biller_Product_NoData)==true) {
			AddUser(testdatamap);
			waitForPageToLoad();
			SearchUser(testdatamap);
			}
			VerifyValue1(getText(EdaatOR.Biller_UserList_UserName), testdatamap.get("UserName").toString());
			verifyElementIsNotPresent(EdaatOR.Biller_Product_NoData, "Data is exists");
			WebClick(EdaatOR.Biller_UserList_UserName);
			switchToWindow();
			Thread.sleep(1000);
			VerifyValue1(WebGetTextAttribute(EdaatOR.Biller_UserListAdd_NameInput), testdatamap.get("UserName").toString());
//			VerifyValue1(getText(EdaatOR.Biller_UserListAdd_EmailInput), testdatamap.get("EmailID").toString());
			
			test.log(Status.PASS,"#FUNC-Search User from userlist and User is clickable" + driver.getTitle() +" * User list Management PASS * " );	
        	Log.ReportEvent("PASS", " Verify Search functionality");

		}
		catch(Exception e){
			test.log(Status.FAIL,"#FUNC-Search User from userlist and User is clickable" + driver.getTitle() +" * User List Management  FAIL * " );
			this.takeScreenShot();
		}
	}
public void ClickOnEditUser(String UserName ) {
		
		WebClick("//a/span[text()='"+UserName+"']/ancestor::tr//td[6]");
	}
	public void ClickOnSaveBtn() {
		
		WebClick(EdaatOR.Biller_UserList_savebtn);
	}
	public void EnterUpdatedPhoneNmBox(String UpdatePhoneNum) {
		
		WebClearandEdit(EdaatOR.Biller_UserListAdd_PhoneInput, UpdatePhoneNum);
	}
	public void UpdateDetails(Map<Object, Object> testdatamap) throws InterruptedException {
		
		EnterUserNameBox(testdatamap.get("UserNameUpdate").toString());
		Thread.sleep(1000);
		EnterUpdatedPhoneNmBox(testdatamap.get("UpdatePhoneNum").toString());
		Thread.sleep(1000);
		ClickOnSaveBtn();
	}
	

	public void verifyEditUser(Map<Object, Object> testdatamap,Log Log){
		try {
			AddUser(testdatamap);
			Thread.sleep(1000);
			SearchUser(testdatamap);
			ClickOnEditUser(testdatamap.get("UserName").toString());
			switchToWindow();
			UpdateDetails(testdatamap);
			EnterSearchUserName(testdatamap.get("UserNameUpdate").toString());
			EnterSearchEmalID(testdatamap.get("EmailID").toString());
			ClickOnUselistSearchBtn();
			Thread.sleep(1500);
			VerifyValue1(getText("//a/span[text()='"+testdatamap.get("UserNameUpdate").toString()+"']"),testdatamap.get("UserNameUpdate").toString());
			this.takeScreenShot();
		test.log(Status.PASS,"#FUNC-Edit User userlist is successfull" + driver.getTitle() +" * User list Management Edit PASS * " );
    	Log.ReportEvent("PASS", " Verify Edit user");

		}
		catch (Exception e) {
			
		test.log(Status.FAIL,"#FUNC-Edit User userlist is successfull" + driver.getTitle() +" * User list Management FAIL * " );
		this.takeScreenShot();
		}	
	}
	//Function Summary  : Method verify AddUserErrorvalidation
	//Parameter Summary : GroupClick,UserName,EmailID,PhoneNum

public void AddUserErrorvalidation(Map<Object,Object>testdatamap) throws Exception {
		String Group = testdatamap.get("GroupClick").toString();
		ClickOnAddUserBtn();
		Thread.sleep(1500);
		EnterUserNameBox(testdatamap.get("UserName").toString());
		Thread.sleep(500);
		EnterEmailIdBox(testdatamap.get("EmailID").toString());
		Thread.sleep(200);
		EnterPhoneNmBox(testdatamap.get("PhoneNum").toString());
		if(Group.equalsIgnoreCase("Yes"))
		{
			WebClickUsingJS(EdaatOR.Admin_UserListAdd_GroupCheckBox);
		}
		Thread.sleep(1500);
		ClickOnUserAddBtn();
		Thread.sleep(1000);
		this.takeScreenShot();

	}
//Function Summary  : Method to verifyAddUserErrorMsg

	//Parameter Summary : Expected

	public void verifyAddUserErrorMsg(Map<Object, Object> testdatamap) throws Exception {
		try
		{
		AddUserErrorvalidation(testdatamap);
		if(ExistsCheck(EdaatOR.Biller_UserList_NameErrorMsg))
		{
			VerifyValue1(testdatamap.get("Expected").toString(),getText(EdaatOR.Biller_UserList_NameErrorMsg));
			test.log(Status.PASS, "#FUNC-UserListUserName ErrorMessage Exists" + driver.getTitle() + " * UserListUserName ErrorMessage Exists * ");
		}
		else if (ExistsCheck(EdaatOR.Biller_UserList_PhonenoErrorMsg)&&ExistsCheck(EdaatOR.Biller_UserList_NameErrorMsg)&&ExistsCheck(EdaatOR.Biller_UserList_EmailErrorMsg))
		{
			VerifyValue(testdatamap.get("Expected").toString(),EdaatOR.Biller_UserList_PhonenoErrorMsg);
			test.log(Status.PASS, "#FUNC-UserListPhone ErrorMessage Exists" + driver.getTitle() + " * UserListEmail ErrorMessage Exists * ");
		}		
		else if (ExistsCheck(EdaatOR.Biller_UserList_EmailErrorMsg)) {
			VerifyValue(testdatamap.get("Expected").toString(),EdaatOR.Biller_UserList_EmailErrorMsg);
			test.log(Status.PASS, "#FUNC-UserListEmail ErrorMessage Exists" + driver.getTitle() + " * UserListEmail ErrorMessage Exists * ");			
		}
		else if (ExistsCheck(EdaatOR.Biller_UserList_EmailExistsErrorMsg))
		{	
			driver.findElement(By.xpath(EdaatOR.Biller_UserListAdd_EmailInput)).sendKeys(Keys.PAGE_UP);
			VerifyValue(testdatamap.get("Expected").toString(),EdaatOR.Biller_UserList_EmailExistsErrorMsg);
			this.takeScreenShot();
			Thread.sleep(1000);
			test.log(Status.PASS, "#FUNC-UserList Emailalreadyinuse ErrorMessage Exists" + driver.getTitle() + " * UserListEmailalreadyinuse ErrorMessage Exists * ");
		}

		else if (ExistsCheck(EdaatOR.Biller_UserList_GroupErrorMsg))
		{
			VerifyValue(testdatamap.get("Expected").toString(),EdaatOR.Biller_UserList_GroupErrorMsg);
			test.log(Status.PASS, "#FUNC-UserListGroup ErrorMessage Exists" + driver.getTitle() + " * UserListGroup ErrorMessage Exists * ");
		}
		else
		{
			test.log(Status.FAIL, "#FUNC-Element Not Exists" + driver.getTitle() + " * Element Not Exists * ");
		}
		}

		catch (Exception e) {
			test.log(Status.FAIL,"#FUNC-UserList Add User" + driver.getTitle() +" * UserList Add User FAIL * " );
			this.takeScreenShot();

		}

	}
	
}


