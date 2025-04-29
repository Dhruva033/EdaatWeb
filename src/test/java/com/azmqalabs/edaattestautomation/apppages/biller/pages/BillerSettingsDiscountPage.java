/**
* Test Script Name  				 : N/A
* Objective     					 : Verify Discount Management Functionality.
* Version      						 : 1.0
* Author       						 : Arun kumar MS
* Created Date 			      		 : 24/05/2023
* Last Updated on					 : N/A
* Updated By   			 			 : 
* Pre-Conditions					 : N/A
* Manual Test case Name				 : N/A
* Epic Details						 : N/A
* User Story Details				 : N/A
* Defects affecting this test script : N/A
* WorkArounds/Known Issues			 : N/A
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



public class BillerSettingsDiscountPage extends BasePage
{

	public BillerSettingsDiscountPage(WebDriver driver,ExtentTest test)
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

	//Function Summary : Navigate to "Discount Management" Page
	//Parameter Summary: N/A
	public void navigateDisCountPage(Log Log) throws Exception {
		WebClickUsingJS(EdaatOR.Biller_Settings);
		Thread.sleep(2000);
		WebClickUsingJS(EdaatOR.Biller_Menu_Discount);
		Thread.sleep(2000);
    	Log.ReportEvent("PASS", " Verify Add and Search Invoice Template is Suceessfull");

	}

	//Function Summary : Method to click on"Add Discount"button in "Discount Management"Page
	//Parameter Summary: N/A
	public void ClickOnDiscountBtn() {
		WebClick(EdaatOR.Biller_Discount_AddBtn);
	}

	//Function Summary : Method to enter discount name in "Discount Name in English"textfield in "Add Discount"popup
	//Parameter Summary: pname
	public void EnterDiscEnglishBox(String pname) {
		WebEdit(EdaatOR.Biller_Discount_EngInp, pname);
	}

	//Function Summary : Method to enter discount name in"Discount Name in Arabic"textfield in "Add Discount"popup
	//Parameter Summary: lstname
	public void EnterDiscArabicBox(String lstname) {
		WebEdit(EdaatOR.Biller_Discount_AtrabInp, lstname);
	}

	//Function Summary : Method to enter percentage in"percentage"textfield in "Add Discount"popup
	//Parameter Summary: lstname
	public void EnterDiscPercentBox(String lstname) {
		WebEdit(EdaatOR.Biller_Discount_Percent, lstname);
	}

	//Function Summary : Method to click on "Add Discount"button "Add Discount"popup 
	//Parameter Summary: N/A
	public void ClickOnDiscountAddBtn() {
		WebClick(EdaatOR.Biller_Discount_AddDiscBtn);
	}

	//Function Summary : Method to enter Discount Name in "Discount Name"textfield 
	//Parameter Summary: lstname
	public void EnterDiscNameBox(String lstname) {
		WebEdit(EdaatOR.Biller_Discount_DiscName, lstname);
	}

	//Function Summary : Method to click on "Search"button in "Discount Management" Page 
	//Parameter Summary: N/A
	public void ClickOnDiscountSearchBtn() {
		WebClick(EdaatOR.Biller_Discount_SearchBtn);
	}

	//Function Summary : Method to click on "delete"icon in Discount Management gridview 
	//Parameter Summary: N/A
	public void ClickOnDiscountDeleteBtn() {
		WebClick(EdaatOR.Biller_Discount_DeleteBtn);
	}
	//Function Summary : Method to click on "Yes,Delete"button in "Are you sure to delete this discount?"popup 
	//Parameter Summary: N/A
	public void ClickOnDiscountConfYesBtn() {
		WebClick(EdaatOR.Biller_Discount_YesConfBtn);
	}

	//Function Summary : Method to Create Discount
	//Parameter Summary: DiscountEngName,DiscountArabicName,DiscountPercentage
	public void AddDiscount(Map<Object,Object>testdatamap) throws Exception {
		ClickOnDiscountBtn();
		Thread.sleep(1500);
		EnterDiscEnglishBox(testdatamap.get("DiscountEngName").toString());
		Thread.sleep(500);
		EnterDiscArabicBox(testdatamap.get("DiscountArabicName").toString());
		Thread.sleep(200);
		EnterDiscPercentBox(testdatamap.get("DiscountPercentage").toString());
		ClickOnDiscountAddBtn();
		Thread.sleep(1500);
	}

	//Function Summary : Method to Search "Discount" in "Discount Management"Page
	//Parameter Summary: DiscountEngName
	public void searchDiscount(Map<Object,Object>testdatamap) throws Exception {
		EnterDiscNameBox(testdatamap.get("DiscountEngName").toString());
		ClickOnDiscountSearchBtn();
		Thread.sleep(1500);
	}

	//Function Summary : Method to delete the "Discount" in "Discount Management" Page
	//Parameter Summary: DeleteDiscount
	public void DeleteDiscount(Map<Object,Object>testdatamap) throws Exception {
		ClickOnDiscountDeleteBtn();
		Thread.sleep(1500);
		VerifyValue1(getText(EdaatOR.Biller_Tamplate_ConfirmDeletePop), testdatamap.get("DeleteDiscount").toString());
		ClickOnDiscountConfYesBtn();
		Thread.sleep(1500);

	}

	//Function Summary : Navigate to "Discount Management" Page
	//Parameter Summary: N/A
	public void verifyDeleteDiscount(Map<Object,Object> testdatamap,Log Log) throws Exception {
		try {
			searchDiscount(testdatamap);
			if(CheckElementExists(EdaatOR.Biller_Product_NoData)==true) {
				AddDiscount(testdatamap);
				searchDiscount(testdatamap);
			}

			DeleteDiscount(testdatamap);
			verifyElementIsPresent(EdaatOR.Biller_Product_NoData);
			test.log(Status.PASS,"#FUNC-Delete Invoice Template" + driver.getTitle() +" * Delete Discount PASS * " );	
        	Log.ReportEvent("PASS", " Verify Delete discount Suceessfull");

		}
		catch(Exception e){
			test.log(Status.FAIL,"#FUNC-Delete Discount" + driver.getTitle() +" * Delete Discount FAIL * " );
			this.takeScreenShot();
		}
	}
	//Function Summary : Navigate to Search Discount.
	//Parameter Summary: N/A.
	public void SearchDiscount(Map<Object, Object> testdatamap,Log Log) throws Exception {
		// TODO Auto-generated method stub
		navigateDisCountPage(Log);
		AddDiscount(testdatamap);
		searchDiscount(testdatamap);
		Thread.sleep(1500);
		verifyElementIsPresent(EdaatOR.Biller_Discount_Name);
    	Log.ReportEvent("PASS", " Verify Delete discount Suceessfull");

		
	}
	//Function Summary   : Method to ClickonBillersettings
	//Parameter Summary  : N/A
		public void ClickonBillersettings() {
		WebClickUsingJS(EdaatOR.Biller_Settings);
		waitForPageToLoad();
		}
	 public void ClickonDiscountsManagement() {
		 
			WebClickUsingJS(EdaatOR.Biller_settings_Discount);
			waitForPageToLoad();
		}
	  	//Function Summary   : Method to  NavigateDiscountManagement
		//Parameter Summary  : N/A
		public void NavigateDiscountManagement(Log Log)
		{
			ClickonBillersettings();
			ClickonDiscountsManagement();
        	Log.ReportEvent("PASS", " Verify Discount Management Page is dispayed Suceessfull");

		}
		//Function Summary   : Method to  AddDiscount
		//Parameter Summary  : DiscountEnglish,DiscountArabic,Percentage
		/*public void AddDiscount(Map<Object, Object> testdatamap) {
			
			try {
				WebClick(EdaatOR.Biller_settings_Discount_addbtn);
				Thread.sleep(1000);
				WebEdit(EdaatOR.Biller_settings_Discount_engefield, testdatamap.get("DiscountEnglish").toString());
				Thread.sleep(1000);
				WebEdit(EdaatOR.Biller_settings_Discount_arabicefield, testdatamap.get("DiscountArabic").toString());
				Thread.sleep(1000);
				WebEdit(EdaatOR.Biller_settings_Discount_perefield, testdatamap.get("Percentage").toString());
				WebClick(EdaatOR.Biller_settings_Discount_adddiscbtn);
				this.takeScreenShot();
			}
			catch (Exception e) {
				e.printStackTrace();
				this.takeScreenShot();
			}
			
		}*/
		//Function Summary : Method to Add and Activate Discount
	//Parameter Summary: Active
	public void ActivateDiscount(Map<Object,Object> testdatamap,Log Log) {
		try {
			AddDiscount(testdatamap);
			searchDiscount(testdatamap);
			WebClickUsingJS(EdaatOR.Biller_IndividualToggle);
			Thread.sleep(1000);
			VerifyValue1(getText(EdaatOR.Biller_ConfirmationPopupMessage), testdatamap.get("Active").toString());
			Thread.sleep(1000);
			WebClick(EdaatOR.Biller_YesBtn);
			test.log(Status.PASS,"#FUNC-Activate Discount" + driver.getTitle() +" * Activate Discount PASS * " );
        	Log.ReportEvent("PASS", " Verify to add discount and activate Suceessfull");

		}
		catch(Exception e){
			test.log(Status.FAIL,"#FUNC-Activate Discount" + driver.getTitle() +" * Activate Discount FAIL * " );
			this.takeScreenShot();
		}
		
	}
		
		//Function Summary   : Method to  EnterDiscountSearchitem
		//Parameter Summary  : DiscountEnglish
		public void EnterDiscountSearchitem(String DiscountEnglish) throws InterruptedException {
			WebEdit(EdaatOR.Biller_settings_Discount_srch,DiscountEnglish);
			Thread.sleep(1000);
			WebClick(EdaatOR.Biller_settings_Discount_srchbtn);
		}
		//Function Summary   : Method to   VerifyDiscoutStatusToggel
		//Parameter Summary  : DiscountEnglish
		public void VerifyDiscoutStatusToggel(Map<Object, Object> testdatamap,Log Log)
		{
			try {
				AddDiscount(testdatamap);
				Thread.sleep(2000);
				EnterDiscountSearchitem(testdatamap.get("DiscountEngName").toString());
				if(CheckElementExists(EdaatOR.Biller_settings_Discount_togelexists)==true)
				{
				WebClick("//tbody//td[text()='"+testdatamap.get("DiscountEngName").toString()+"']/..//td[3]//span");
				Thread.sleep(1000);
				VerifyValue1(getText(EdaatOR.Biller_settings_Discount_Confacti),testdatamap.get("Active").toString());
				WebClick(EdaatOR.Biller_settings_Discount_confyesbtn);
				Thread.sleep(800);
				WebClick("//tbody//td[text()='"+testdatamap.get("DiscountEngName").toString()+"']/..//td[3]//span");
				Thread.sleep(1000);
				VerifyValue1(getText(EdaatOR.Biller_settings_Discount_Cancelacti),testdatamap.get("Inactive").toString());
				Thread.sleep(1000);
				WebClick(EdaatOR.Biller_settings_Discount_confyesbtn);
				this.takeScreenShot();
				test.log(Status.PASS,"#FUNC-Verify Status Toggel" + driver.getTitle() +" * Discount management Status Toggel PASS * " );
	        	Log.ReportEvent("PASS", " Verify Verify status toggel functionality is Suceessfull");

				}
				else
				{
				test.log(Status.FAIL,"#FUNC-Verify Status Toggel" + driver.getTitle() +" * Discount management Status Toggel Fail * " );
				}
			}
			catch (Exception e) {
				
			test.log(Status.FAIL,"#FUNC-Verify Status Toggel" + driver.getTitle() +" * Discount management Status Toggel Fail * " );
				
			}
		}
			//Function Summary : To add discount.
	//Parameter Summary: DiscountEngName,DiscountArabicName and DiscountPercentage.
	public void AddDiscountDeactivate(Map<Object,Object> testdatamap,Log Log) throws InterruptedException
	{
		try {
		       ClickOnDiscountBtn();
		       Thread.sleep(1500);
		       EnterDiscEnglishBox(testdatamap.get("DiscountEngName").toString());
		       Thread.sleep(500);
	           EnterDiscArabicBox(testdatamap.get("DiscountArabicName").toString());
		       Thread.sleep(200);
		       EnterDiscPercentBox(testdatamap.get("DiscountPercentage").toString());
		       Thread.sleep(1500);
		       WebClickUsingJS(EdaatOR.Biller_Discount_toggle);
		       Thread.sleep(1500);
		       ClickOnDiscountAddBtn();
		       DeactivateDiscount(testdatamap);
	        	Log.ReportEvent("PASS", " Verify to add discount is successfull");

		    }
		catch(Exception e){
			test.log(Status.FAIL,"#FUNC-AddDiscountDeactivate" + driver.getTitle() +" * AddDiscountDeactivate FAIL * " );
			this.takeScreenShot();
		}
	
	}
	//Function Summary : To search and verify discount.
	//Parameter Summary: DiscountEngName.
	public void DeactivateDiscount(Map<Object,Object> testdatamap) throws Exception 
	{   
		searchDiscount(testdatamap);
		verifyElementIsPresent(EdaatOR.Biller_Discount_Verify,testdatamap.get("DiscountEngName").toString());
		test.log(Status.PASS,"#FUNC-search Discount" + driver.getTitle() +" * search Discount PASS * " );
		this.takeScreenShot();
		DeactiveToggle(); 
	}
	//Function Summary : To deactivate discount.
	//Parameter Summary: N/A.
	public void DeactiveToggle() 
	{
	  try {
		     WebClick(EdaatOR.Biller_Discount_Deactivatetgl);
	         Thread.sleep(1500);
		     if(CheckElementExists(EdaatOR.Biller_Discount_Deact_confirm)==true)
		     {
			    WebClickUsingJS(EdaatOR.Biller_Discount_Canyes);
		        Thread.sleep(1500);
		        test.log(Status.PASS,"#FUNC-DeactiveToggle" + driver.getTitle() +" * DeactiveToggle PASS * " );
			    this.takeScreenShot();
		      }
	      }
		catch(Exception e){
			test.log(Status.FAIL,"#FUNC-DeactiveToggle" + driver.getTitle() +" * DeactiveToggle FAIL * " );
			this.takeScreenShot();
		}
	}
	//Function Summary : Method to Validate Add Discount Functionality Error Messages
	//Parameter Summary: ExpectedResult
	public void AddDiscountErrorMessageValidation(Map<Object,Object>testdatamap) throws IOException, Exception {
		AddDiscount(testdatamap);
		String Expected=testdatamap.get("ExpectedResult").toString();
		try {
			    if(ExistsCheck(EdaatOR.Biller_Settings_DiscEngNameError)) {
				VerifyValue(Expected,EdaatOR.Biller_Settings_DiscEngNameError);
				test.log(Status.PASS, "#FUNC-Discount Management Discount EnglishName Error Message Exists" + driver.getTitle() + " * Discount Management Discount EnglishName Error Message Exists * ");	    	
		     }
			else if(ExistsCheck(EdaatOR.Biller_Settings_DiscArabicNameError)){
				VerifyValue(Expected,EdaatOR.Biller_Settings_DiscArabicNameError);
				test.log(Status.PASS, "#FUNC-Discount Management Discount ArabicName Error Message Exists" + driver.getTitle() + " * Discount Management Discount ArabicName Error Message Exists * ");
			}
			else if(ExistsCheck(EdaatOR.Biller_Settings_DiscountPercentageError)){
				VerifyValue(Expected,EdaatOR.Biller_Settings_DiscountPercentageError);
				test.log(Status.PASS, "#FUNC-Discount Management Discount Percentage Error Message Exists" + driver.getTitle() + " * Discount Management Discount Percentage Error Message Exists * ");
			}
			else if(ExistsCheck(EdaatOR.Biller_Settings_DiscArabicNameError)){
				VerifyValue(Expected,EdaatOR.Biller_Settings_DiscArabicNameError);
				test.log(Status.PASS, "#FUNC-Discount Management Discount ArabicName Error Message Exists" + driver.getTitle() + " * Discount Management Discount ArabicName Error Message Exists * ");
			}
	
        	else {

				test.log(Status.FAIL, "#FUNC-Element Not Exists" + driver.getTitle() + " * Element Not Exists * ");
			  }
		}


		catch(Exception e){
			test.log(Status.FAIL,"#FUNC-Verify Error Messages for Add Discount" + driver.getTitle() +" * Error Messages for Add Discount FAIL * " );
			this.takeScreenShot();
		}
	}
	


}
