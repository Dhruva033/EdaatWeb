/**
* Test Script Name                   : N/A
* Objective                          : Verify UserList Functionality Under UserManagement 
* Version                            : 1.0
* Author                             : Kathirvelu M
* Created Date                       : 
* Last Updated on                    : N/A
* Updated By                         : Basavaraj Mudnur
* Pre-Conditions                     : 1)Admin Login Credentials 
* Epic Details                       : N/A
* User Story Details                 : N/A
**/
package com.azmqalabs.edaattestautomation.apppages.admin.pages;

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
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.azmqalabs.edaattestautomation.apppages.GlobalConstant;
import com.azmqalabs.edaattestautomation.apppages.masterpages.BasePage;
import com.azmqalabs.edaattestautomation.common.Log;
import com.azmqalabs.edaattestautomation.common.uielement.fieldDecorator;
import com.azmqalabs.edaattestautomation.objectrepository.EdaatOR;



public class AdminUserMngUserListPage extends BasePage
{

	public AdminUserMngUserListPage(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;

		PageFactory.initElements(new fieldDecorator(driver,test), this);
	}  


	@FindBy(xpath = EdaatOR.Admin_Usermanagement_Userlist)
	public WebElement UserList;
	

	public boolean Exists(){
		return super.Exists(UserList);
	}

	//Function Summary  : Method to navigateUserlistPage
	//Parameter Summary : N/A
	public void navigateUserlistPage(Log Log) throws Exception {		
		try {
			WebClickUsingJS(EdaatOR. Admin_Menu_UserManagement);
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Admin_Menu_UserList);
			if(CheckElementExists(EdaatOR.Admin_Usermanagement_Userlist)) {
				Log.ReportEvent("PASS", "User List Page is Loaded Successfully");			
			} else {
				Log.ReportEvent("FAIL", "User List Page is Not Loaded Successfully");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}			
		} catch (Exception e) {
			Log.ReportEvent("FAIL", "User List Page is Not Loaded Successfully");
			this.takeScreenShot();
			e.printStackTrace();
			driver.quit();	
			Assert.fail();
		
		}
	}
	//Function Summary  : Method to EnterUserNameBox
	//Parameter Summary : N/A
	public void ClickOnAddUserBtn() throws Exception {
		WebClick(EdaatOR.Admin_UserList_AddUserBt);
	}
	//Function Summary  : Method to EnterUserNameBox
	//Parameter Summary : pname
	public void EnterUserNameBox(String pname) throws Exception {
		WebEdit(EdaatOR.Admin_UserListAdd_NameInput,pname);
	}
	//Function Summary  : Method to EnterEmailIdBox
	//Parameter Summary : Email
	public void EnterEmailIdBox(String Email) throws Exception  {
		WebEdit(EdaatOR.Admin_UserListAdd_EmailInput, Email);
	}
	//Function Summary  : Method to EnterPhoneNmBox
	//Parameter Summary : phone
	public void EnterPhoneNmBox(String phone) throws Exception  {
		WebEdit(EdaatOR.Admin_UserListAdd_PhoneInput,phone);
	}
	//Function Summary  : Method to ClickOnGrouChekbox
	//Parameter Summary : N/A
	public void ClickOnGrouChekbox() {
		WebClickUsingJS(EdaatOR.Admin_UserListAdd_GroupCheckBox);
	}
	//Function Summary  : Method to ClickOnUserAddBtn
	//Parameter Summary : N/A
	public void ClickOnUserAddBtn()  throws Exception {
		WebClick(EdaatOR.Admin_UserListAdd_AddUserBtPop);
	}

	//Function Summary  : Method to EnterSearchUserName
	//Parameter Summary : lstname
	public void EnterSearchUserName(String lstname) throws Exception  {
		WebEdit(EdaatOR.Admin_UserListSearch_NameBt, lstname);
	}
	//Function Summary  : Method to EnterSearchEmalID
	//Parameter Summary : lstname
	public void EnterSearchEmalID(String lstname) throws Exception  {
		WebEdit(EdaatOR.Admin_UserListSearch_EmailBt, lstname);
	}
	//Function Summary  : Method to ClickOnUselistSearchBtn
	//Parameter Summary : N/A
	public void ClickOnUselistSearchBtn() throws Exception {
		WebClick(EdaatOR.Admin_UserListSearch_SaerchBt);
		Thread.sleep(1000);
	}
	//Function Summary  : Method to ClickOnDiscountDeleteBtn
	//Parameter Summary : N/A
	public void ClickOnDiscountDeleteBtn()  throws Exception {
		WebClick(EdaatOR.Admin_UserList_DeleteBtn);
	}
	//Function Summary  : Method to ClickOnDiscountConfYesBtn
	//Parameter Summary : N/A
	public void ClickOnDiscountConfYesBtn()  throws Exception {
		WebClick(EdaatOR.Admin_UserList_YesConfBtn);
	}
		
	//Function Summary  : Method verify AddUser
	//Parameter Summary : UserName,EmailID,PhoneNum
	public void AddUser(Map<Object,Object>testdatamap,Log Log) throws Exception {
		try {
			ClickOnAddUserBtn();
			Thread.sleep(1500);
			EnterUserNameBox(testdatamap.get("UserName").toString());
			Thread.sleep(500);
			EnterEmailIdBox(testdatamap.get("EmailID").toString());
			Thread.sleep(200);
			EnterPhoneNmBox(testdatamap.get("PhoneNum").toString());
			ClickOnGrouChekbox();
			Thread.sleep(1500);
			ClickOnUserAddBtn();
			Thread.sleep(1000);
			if (CheckElementExists(EdaatOR.Admin_UserList_EmailErrorMsg) || 
				CheckElementExists(EdaatOR.Admin_UserList_NameErrorMsg) ||
				CheckElementExists(EdaatOR.Admin_UserList_EmailExistsErrorMsg) ||
				CheckElementExists(EdaatOR.Admin_UserList_PhonenoErrorMsg)) {	
	        Log.ReportEvent("FAIL", "Add User Functionality is UnSuccessful");
	        this.takeScreenShot();
	        driver.quit();
	        Assert.fail();
			} else {	
		    Log.ReportEvent("PASS", "Add User Functionality is Successful");
			}
		} catch (Exception e) {
	        Log.ReportEvent("FAIL", "Add User Functionality is UnSuccessful");
	        this.takeScreenShot();
	        e.printStackTrace();
	        driver.quit();
	        Assert.fail();
			
		}
	
		
	}
	//Function Summary  : Method SearchUser
	//Parameter Summary : UserName,EmailID
	public void SearchUser(Map<Object,Object>testdatamap) throws Exception {
		try {
			EnterSearchUserName(testdatamap.get("UserName").toString());
			EnterSearchEmalID(testdatamap.get("EmailID").toString());
			ClickOnUselistSearchBtn();
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		
	}
	public void DeleteUser(Map<Object,Object>testdatamap) throws Exception {
		ClickOnDiscountDeleteBtn();
		Thread.sleep(1500);
		VerifyValue1(getText(EdaatOR.Admin_UserList_ConfirmDeletePop), testdatamap.get("DeleteDiscount").toString());
		ClickOnDiscountConfYesBtn();
		Thread.sleep(1500);

	}

	public void verifyDeleteUser(Map<Object,Object> testdatamap,Log Log) throws Exception {
		try {
			AddUser(testdatamap,Log);
			SearchUser(testdatamap);
			DeleteUser(testdatamap);
			verifyElementIsPresent(EdaatOR.Admin_Product_NoData);
			test.log(Status.PASS,"Delete User from userlist" + driver.getTitle() +" * User Management PASS * " );
		    this.takeScreenShot();
		}
		catch(Exception e){
			test.log(Status.FAIL,"Delete User from userlist" + driver.getTitle() +" * User Management  FAIL * " );
		    this.takeScreenShot();
			
		}
	}
	//Function Summary  : Method verifySearchUser
	//Parameter Summary : N/A
	public void verifySearchUser(Map<Object,Object> testdatamap,Log Log) throws Exception {
		try {
			Thread.sleep(2000);
			SearchUser(testdatamap);
			Thread.sleep(2000);
			if(CheckElementExists(EdaatOR.Admin_Product_NoData)) {
			AddUser(testdatamap,Log);
			SearchUser(testdatamap);
			VerifyValue1(getText(EdaatOR.Admin_UserList_UserEmail), testdatamap.get("EmailID").toString());
        	Log.ReportEvent("PASS", "Search Functionality is Successful");
			}
			else if (getText(EdaatOR.Admin_UserList_UserEmail).equals(testdatamap.get("EmailID").toString())) {
			Log.ReportEvent("PASS", "Search Functionality is Successful");	
			} 
		    else {
			Log.ReportEvent("FAIL", "Search Functionality is UnSuccessful");
			this.takeScreenShot();
		    driver.quit();
			Assert.fail();
			}
		}
		catch(Exception e){
			Log.ReportEvent("FAIL", "Search Functionality is UnSuccessful");
			this.takeScreenShot();	
			driver.quit();
			Assert.fail();
		}
	}
	public void SearchUserCheckbox(Map<Object,Object> testdatamap,Log Log) throws Exception
	{
		try {
		EnterSearchUserName(testdatamap.get("UserName").toString());
		EnterSearchEmalID(testdatamap.get("EmailID").toString());
		WebClick(EdaatOR.Admin_UserList_dltcheck);
		ClickOnUselistSearchBtn();		
		Thread.sleep(2000);
		if (CheckElementExists(EdaatOR.Admin_UsserList_NoData)) {
			Log.ReportEvent("FAIL", "Deleted Users Checkbox Functionality is UnSuccessful");	
			this.takeScreenShot();
			driver.quit();
			Assert.fail();
		} else {
			VerifyValue1(getText(EdaatOR.Admin_UserList_dltVerify),testdatamap.get("EmailID").toString() );
			Log.ReportEvent("PASS", "Deleted Users Checkbox Functionality is Successful");				
		}
		}
		catch(Exception e){
			Log.ReportEvent("FAIL", "Deleted Users Checkbox Functionality is UnSuccessful");	
		    this.takeScreenShot();
		    driver.quit();
		    Assert.fail();
	}
	
	}
	//Function Summary  : Method verify Edit Users Details
	//Parameter Summary : ChangeUserName,ChangePhoneNum,EmailID,UserName
	public void verifyUsersListEdit(Map<Object, Object> testdatamap,Log Log) {
		try {
			SearchUser(testdatamap);
			Thread.sleep(2000);
			if(CheckElementExists(EdaatOR.Admin_Product_NoData)) {
				AddUser(testdatamap,Log);
				Thread.sleep(1000);		
				SearchUser(testdatamap);
				Thread.sleep(1000);			
				WebClick(EdaatOR.Admin_UserMgm_UsersList_Editbtn);
				switchToWindow();
				Thread.sleep(1000);
				WebClear(EdaatOR.Admin_UserListAdd_NameInput);
				WebEdit(EdaatOR.Admin_UserListAdd_NameInput,testdatamap.get("ChangeUserName").toString());
				Thread.sleep(500);
				WebClear(EdaatOR.Admin_UserListAdd_PhoneInput);
				WebEdit(EdaatOR.Admin_UserListAdd_PhoneInput,testdatamap.get("ChangePhoneNum").toString());
				Thread.sleep(1000);			
				WebClick(EdaatOR.Admin_UserMgm_UsersList_Savechange);
				if (CheckElementExists(EdaatOR.Admin_UserList_NameErrorMsg)||
					CheckElementExists(EdaatOR.Admin_UserList_PhonenoErrorMsg)) {
	        	Log.ReportEvent("FAIL", "Edit User Functionality is UnSuccessfull");	
	        	this.takeScreenShot();
	        	Assert.fail();
				}
				else {
					EnterSearchUserName(testdatamap.get("ChangeUserName").toString());
					EnterSearchEmalID(testdatamap.get("EmailID").toString());
					ClickOnUselistSearchBtn();	
					VerifyValue1(getText(EdaatOR.Admin_UserList_UserName), testdatamap.get("ChangeUserName").toString());
					Log.ReportEvent("PASS", " Edit User Functionality is Successfull");	
				}	
			}
			else if(getText(EdaatOR.Admin_UserList_UserEmail).equals(testdatamap.get("EmailID").toString())) {
				WebClick(EdaatOR.Admin_UserMgm_UsersList_Editbtn);
				switchToWindow();
				Thread.sleep(1000);
				WebClear(EdaatOR.Admin_UserListAdd_NameInput);
				WebEdit(EdaatOR.Admin_UserListAdd_NameInput,testdatamap.get("ChangeUserName").toString());
				Thread.sleep(500);
				WebClear(EdaatOR.Admin_UserListAdd_PhoneInput);
				WebEdit(EdaatOR.Admin_UserListAdd_PhoneInput,testdatamap.get("ChangePhoneNum").toString());
				Thread.sleep(1000);			
				WebClick(EdaatOR.Admin_UserMgm_UsersList_Savechange);
				if (CheckElementExists(EdaatOR.Admin_UserList_NameErrorMsg)||
					CheckElementExists(EdaatOR.Admin_UserList_PhonenoErrorMsg)) {
	        	Log.ReportEvent("FAIL", "Edit User Functionality is UnSuccessfull");	
	        	this.takeScreenShot();
	        	 driver.quit();
	        	Assert.fail();
				}
				else {
					EnterSearchUserName(testdatamap.get("ChangeUserName").toString());
					EnterSearchEmalID(testdatamap.get("EmailID").toString());
					ClickOnUselistSearchBtn();	
					VerifyValue1(getText(EdaatOR.Admin_UserList_UserName), testdatamap.get("ChangeUserName").toString());
					Log.ReportEvent("PASS", "Edit User Functionality is Successfull");	
				}			
			}
			else {
				Log.ReportEvent("FAIL", "Edit User Functionality is UnSuccessfull");	
				this.takeScreenShot();
				 driver.quit();
	        	Assert.fail();
			}		
		}
		catch(Exception e){
			Log.ReportEvent("FAIL", "Edit User Functionality is UnSuccessfull");	
			this.takeScreenShot();
			e.printStackTrace();
			 driver.quit();
        	Assert.fail();    	
		}
	}
	//Function Summary  : Method verify Delete User
	//Parameter Summary : UserName,EmailID
	public void verifyUsersDelete(Map<Object, Object> testdatamap,Log Log) {
	try {
		SearchUser(testdatamap);
		Thread.sleep(2000);
		if(CheckElementExists(EdaatOR.Admin_Product_NoData)) {
			AddUser(testdatamap,Log);
			Thread.sleep(500);
			SearchUser(testdatamap);		
			WebClick(EdaatOR.Admin_UserMgm_UsersList_Deletebtn);
			Thread.sleep(1000);		
			WebClick(EdaatOR.Admin_UserMgm_UsersList_YesDeletebtn);
			EnterSearchUserName(testdatamap.get("UserName").toString());
			EnterSearchEmalID(testdatamap.get("EmailID").toString());
			WebClick(EdaatOR.Admin_UserMgm_UsersList_DeletedCheckbox);
			ClickOnUselistSearchBtn();
			VerifyValue1(getText(EdaatOR.Admin_UserList_UserEmail), testdatamap.get("EmailID").toString());
	    	Log.ReportEvent("PASS", "Delete user Functionality is Successful");
		}
		else if (getText(EdaatOR.Admin_UserList_UserEmail).equals(testdatamap.get("EmailID").toString())) {
			WebClick(EdaatOR.Admin_UserMgm_UsersList_Deletebtn);
			Thread.sleep(1000);		
			WebClick(EdaatOR.Admin_UserMgm_UsersList_YesDeletebtn);
			EnterSearchUserName(testdatamap.get("UserName").toString());
			EnterSearchEmalID(testdatamap.get("EmailID").toString());
			WebClick(EdaatOR.Admin_UserMgm_UsersList_DeletedCheckbox);
			ClickOnUselistSearchBtn();
			VerifyValue1(getText(EdaatOR.Admin_UserList_UserEmail), testdatamap.get("EmailID").toString());
	    	Log.ReportEvent("PASS", "Delete User Functionality is Successful");	
		}
		else {
	    	Log.ReportEvent("FAIL", "Delete User Functionality is UnSuccessful");	
	    	 this.takeScreenShot();
	    	 driver.quit();
	    	 Assert.fail();
		}
	}
	catch(Exception e){
	 Log.ReportEvent("FAIL", "Delete User Functionality is UnSuccessful");	
   	 this.takeScreenShot();
   	 e.printStackTrace();
   	 driver.quit();
   	 Assert.fail();
   	 
	}
	}
	//Function Summary  : Method to Verify Status toggle under user list management.
	//Parameter Summary : N/A
	public void Verifystatustoggle(Map<Object,Object> testdatamap,Log Log) throws Exception
	{
		try {
			Thread.sleep(2000);
			SearchUser(testdatamap);
			Thread.sleep(2000);
			if(CheckElementExists(EdaatOR.Admin_Product_NoData)) {
				AddUser(testdatamap,Log);
				Thread.sleep(1000);
				SearchUser(testdatamap);
				Thread.sleep(5000);
				verifyElementIsPresent(EdaatOR.Admin_UserList_statustg);
		    	Log.ReportEvent("PASS", "Status Toggle Functionality is Successful");	
			}
			else if(getText(EdaatOR.Admin_UserList_UserEmail).equals(testdatamap.get("EmailID").toString())){
				verifyElementIsPresent(EdaatOR.Admin_UserList_statustg);
		    	Log.ReportEvent("PASS", "Status Toggle Functionality is Successful");			
			}
			else {
		    	Log.ReportEvent("FAIL", "Status Toggle Functionality is UnSuccessful");	
				this.takeScreenShot();
				 driver.quit();
				Assert.fail();
			}    
		}
		catch(Exception e)
		{
			Log.ReportEvent("FAIL", "Status Toggle Functionality is UnSuccessful");
			this.takeScreenShot();
			e.printStackTrace();
			 driver.quit();
			Assert.fail();			
		}
	}
	
	public void AddUserAndVerify(Map<Object,Object> testdatamap,Log Log) throws Exception {
		try {
			AddUser(testdatamap,Log);
			Thread.sleep(1000);
			SearchUser(testdatamap);
			if(getText(EdaatOR.Admin_UserList_UserEmail).equals(testdatamap.get("EmailID").toString())  && 
			!getText(EdaatOR.Admin_UserList_UserEmail).isEmpty()) {
			VerifyValue1(getText(EdaatOR.Admin_UserList_UserEmail), testdatamap.get("EmailID").toString());
        	Log.ReportEvent("PASS", "Add User Functionality is Successful");	
			}
			else {		
	        Log.ReportEvent("FAIL", "Add User Functionality is UnSuccessful");	
	        this.takeScreenShot();
	        driver.quit();
	        Assert.fail();
			}
		}
		catch(Exception e){
			Log.ReportEvent("FAIL", "Add User Functionality is UnSuccessful");	
	        this.takeScreenShot();
	        driver.quit();
			Assert.fail();
		}
	}
	//Function Summary  : Method to verifyUsernameClikable
	//Parameter Summary : ActivationMsg
	public void verifyUsernameClikable(Map<Object,Object> testdatamap,Log Log) throws Exception {
		try {
			Thread.sleep(2000);
			SearchUser(testdatamap);
			Thread.sleep(2000);
			if(CheckElementExists(EdaatOR.Admin_Product_NoData)) {
				AddUser(testdatamap,Log);
				SearchUser(testdatamap);
				Thread.sleep(2000);		
				WebClick(EdaatOR.Admin_UserList_UserNameClick);
				Thread.sleep(3000);	
				switchToWindow();
				if (CheckElementExists(EdaatOR.Admin_UserList_ViewUserInfoNameTxt)) {
					Log.ReportEvent("PASS", "Username Clickable Functionality is Successful");
						
					} else {

					Log.ReportEvent("FAIL", "Username Clickable Functionality is UnSuccessful");
		    	    this.takeScreenShot();
		    	    driver.quit();
		    	    Assert.fail();
					}	
			}
			else {	
				WebClick(EdaatOR.Admin_UserList_UserNameClick);
				Thread.sleep(3000);	
				switchToWindow();
				if (CheckElementExists(EdaatOR.Admin_UserList_ViewUserInfoNameTxt)) {
					switchToParentWindow();
					Log.ReportEvent("PASS", "Username Clickable Functionality is Successful");
						
					} else {

					Log.ReportEvent("FAIL", "Username Clickable Functionality is UnSuccessful");
		    	    this.takeScreenShot();
		    	    driver.quit();
		    	    Assert.fail();
					}			
			}
		}
		catch(Exception e){
			Log.ReportEvent("FAIL", "Username Clickable Functionality is UnSuccessful");
    	    this.takeScreenShot();
    	    e.printStackTrace();
    	    driver.quit();
    	    Assert.fail();
		}
	
	}
	
	//Function Summary  : Method to verifyAddUserErrorMsg
	//Parameter Summary : Expected
	public void verifyAddUserErrorMsg(Map<Object, Object> testdatamap,Log Log) throws Exception {
		try
		{
			String Group = testdatamap.get("GroupClick").toString();
			String Expected = testdatamap.get("Expected").toString(); 
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
		if(getText(EdaatOR.Admin_UserList_NameErrorMessg).equals(Expected))
		{		
			Log.ReportEvent("PASS", "Verify Error Message for User Name is Successful");
		}
		else if (getText(EdaatOR.Admin_UserList_PhonenoErrorMsg).equals(Expected)
				&&getText(EdaatOR.Admin_UserList_NameErrorMsg).equals(Expected)
				&&getText(EdaatOR.Admin_UserList_EmailErrorMsg).equals(Expected) 
				&&getText(EdaatOR.Admin_UserList_GroupErrorMsg).equals("This field is required"))
		{
			Log.ReportEvent("PASS", "Verify Error Message for All the Required Fields is Successful");
		}		
		else if (getText(EdaatOR.Admin_UserList_EmailErrorMsg).equals(Expected)) {
			Log.ReportEvent("PASS", "Verify Error Message for Email is Successful");
		}
		else if (getText(EdaatOR.Admin_UserList_EmailExistsErrorMsg).equals(Expected))
		{	
			driver.findElement(By.xpath(EdaatOR.Admin_UserListAdd_EmailInput)).sendKeys(Keys.PAGE_UP);
			Log.ReportEvent("PASS", "Verify Error Message for Existing Email is Successful");
			Thread.sleep(1000);
		}
		else if (getText(EdaatOR.Admin_UserList_GroupErrorMsg).equals(Expected))
		{
			Log.ReportEvent("PASS", "Verify Error Message for Groups is Successful");
		}
		else
		{
			Log.ReportEvent("FAIL", "Verify Add User Error Message is Unsuccessful");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();
		}
		}
		catch (Exception e) {
			Log.ReportEvent("FAIL", "Verify Add User Error Message is Unsuccessful");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();		
		}
	}
	
}
