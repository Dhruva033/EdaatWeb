/**
*
* Test Script Name                   : N/A
* Objective                          : Admin Settings Discounts Management functionality
* Version                            : 1.0
* Author                             : Kathirvelu Mohan
* Created Date                       : 23/05/2023
* Last Updated on                    : N/A
* Updated By                         : Dhruva Kumar S
* Pre-Conditions                     : N/A
* Epic Details                       : N/A
* User Story Details                 : N/A
**/
package com.azmqalabs.edaattestautomation.apppages.admin.pages;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import com.azmqalabs.edaattestautomation.common.Log;
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
import com.azmqalabs.edaattestautomation.common.uielement.fieldDecorator;
import com.azmqalabs.edaattestautomation.objectrepository.EdaatOR;



public class AdminSettingsDiscountPage extends BasePage
{

	public AdminSettingsDiscountPage(WebDriver driver,ExtentTest test)
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

//Function summary:Navigate to Discount Management
//Function Parameters:NA
	public void navigateDisCountPage(Log Log) throws Exception {
		Thread.sleep(3000);
		WebClickUsingJS(EdaatOR.Admin_Settings);
		Thread.sleep(2000);
		WebClickUsingJS(EdaatOR.Admin_Menu_Discount);
		Thread.sleep(2000);
    	Log.ReportEvent("PASS", " Verify to navigate Discount Page is Suceessful");

	}
	//Function Summary : Method to ClickOnDiscountBtn
	//Parameter Summary: N/A

	public void ClickOnDiscountBtn() {
		WebClick(EdaatOR.Admin_AddDiscount);
	}
	//Function Summary : Method to EnterDiscEnglishBox
	//Parameter Summary: pname
	public void EnterDiscEnglishBox(String pname) {
	WebEdit(EdaatOR.Admin_DiscountNameEn, pname);
	}
	//Function Summary : Method to EnterDiscArabicBox
	//Parameter Summary: lstname
	public void EnterDiscArabicBox(String lstname) {
		WebEdit(EdaatOR.Admin_DiscountNameAr, lstname);
	}
	//Function Summary : Method to EnterDiscPercentBox
	//Parameter Summary: lstname
	public void EnterDiscPercentBox(String lstname) {
		WebEdit(EdaatOR.Admin_DiscPercentage, lstname);
	}
    //Function Summary : Method to ClickOnDiscountAddBtn
	//Parameter Summary: N/A
	public void ClickOnDiscountAddBtn() {
		WebClick(EdaatOR.Admin_AddDiscountBtn);
	}
 //Function Summary : Method to EnterDiscNameBox
	//Parameter Summary: lstname
	public void EnterDiscNameBox(String lstname) {
		WebEdit(EdaatOR.Admin_SearchDiscountName, lstname);
	}
	//Function Summary : Method to ClickOnDiscountSearchBtn
	//Parameter Summary: N/A
	public void ClickOnDiscountSearchBtn() {
		WebClick(EdaatOR.Admin_SearchDiscountBtn);
	}
    //Function Summary : Method to ClickOnDiscountDeleteBtn
	//Parameter Summary: N/A
	public void ClickOnDiscountDeleteBtn() {
		WebClick(EdaatOR.Admin_Discount_DeleteBtn);
	//	WebClick(EdaatOR.Biller_Discount_DeleteBtn);
	}
	//Function Summary : Method to ClickOnDiscountConfYesBtn
	//Parameter Summary: N/A
	public void ClickOnDiscountConfYesBtn() {
		//WebClick(EdaatOR.Biller_Discount_YesConfBtn);
    	WebClick(EdaatOR.Admin_Discount_YesConfBtn);

	}

//Function Summary  : Method to Add  Discount
//Parameter Summary : DiscountEngName,DiscountArabicName,DiscountPercentage
	public void AddDiscount(Map<Object,Object>testdatamap) throws Exception {
		ClickOnDiscountBtn();
		Thread.sleep(1500);
		EnterDiscEnglishBox(testdatamap.get("DiscountEngName").toString());
		Thread.sleep(500);
		EnterDiscArabicBox(testdatamap.get("DiscountArabicName").toString());
		Thread.sleep(200);
		EnterDiscPercentBox(testdatamap.get("DiscountPercentage").toString());
		Thread.sleep(200);
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
	    VerifyValue1(getText(EdaatOR.Admin_Tamplate_ConfirmDeletePop), testdatamap.get("DeleteDiscount").toString());
		//VerifyValue1(getText(EdaatOR.Biller_Tamplate_ConfirmDeletePop), testdatamap.get("DeleteDiscount").toString());
		ClickOnDiscountConfYesBtn();
		Thread.sleep(1500);

	}
    //Function Summary : Method to verifyDeleteDiscount
	//Parameter Summary: N/A
	public void verifyDeleteDiscount(Map<Object,Object> testdatamap,Log Log) throws Exception {
		try {
			searchDiscount(testdatamap);
			if(CheckElementExists(EdaatOR.Admin_Product_NoData)==true) {
				AddDiscount(testdatamap);
				searchDiscount(testdatamap);
	        	Log.ReportEvent("PASS", "Verify Delete discount Suceessfull");

			}

			DeleteDiscount(testdatamap);
			//verifyElementIsPresent(EdaatOR.Biller_Product_NoData);
			verifyElementIsPresent(EdaatOR.Admin_Product_NoData);
	        Thread.sleep(2000);
			this.takeScreenShot();
			test.log(Status.PASS,"Delete Invoice Template" + driver.getTitle() +" * Delete Discount PASS * " );	
		}
		catch(Exception e){
			test.log(Status.FAIL,"Delete Discount" + driver.getTitle() +" * Delete Discount FAIL * " );
			this.takeScreenShot();
		}
	}
//Function summary:verify Add Deactivate Discount
//Function Parameters:ActivationMsg and DeactivationMsg.
	public void verifyAddDeactivateDiscount(Map<Object,Object> testdatamap,Log Log) throws Exception {
		try {
			AddDiscount(testdatamap);
			searchDiscount(testdatamap);
			Thread.sleep(1500);
			WebClickUsingJS(EdaatOR.Admin_DiscountStatusToggle);
			ValidateTwoValue(getText(EdaatOR.Admin_confirmationMsg), testdatamap.get("ActivationMsg").toString());
			WebClickUsingJS(EdaatOR.Admin_Activate);
			Thread.sleep(1500);
			WebClickUsingJS(EdaatOR.Admin_DiscountStatusToggle);
				ValidateTwoValue(getText(EdaatOR.Admin_confirmationMsg), testdatamap.get("DeactivationMsg").toString());
	        	WebClickUsingJS(EdaatOR.Admin_Activate);
			test.log(Status.PASS,"Add Deactivate Discount" + driver.getTitle() +" * Add Deactivate Discount PASS * " );	
			Log.ReportEvent("PASS", "Verify  status toggel is Suceessful");

		}
	    	catch(Exception e){
			test.log(Status.FAIL,"Add Deactivate Discount" + driver.getTitle() +" * Add Deactivate Discount Fail * " );
			this.takeScreenShot();
		}
	}
	//Function summary:verify Status Toggle
	//Function Parameters:NA
	public void StatusToggle(Map<Object,Object> testdatamap,Log Log) throws Exception
	{
		verifyAddDeactivateDiscount(testdatamap,Log);
	}
	
	//Function Summary  : Method to search discount in discount Management.
    //Parameter Summary : N/A.

	public void SearchDiscount(Map<Object, Object> testdatamap,Log Log) throws Exception {
		// TODO Auto-generated method stub
		try {
			AddDiscount(testdatamap);
			searchDiscount(testdatamap);
			verifyElementIsPresent("//td[text()='"+testdatamap.get("DiscountEngName").toString()+"']");
			this.takeScreenShot();
			test.log(Status.PASS,"Search Discount" + driver.getTitle() +" * Search Discount PASS * " );	
        	Log.ReportEvent("PASS", "Verify Add and Deactivate discount is Suceessful");

		}
	    	catch(Exception e){
			test.log(Status.FAIL,"Search Discount" + driver.getTitle() +" * Search Discount Fail * " );
			this.takeScreenShot();
		}
	}
	
	//Function Summary  : Method to Add and DeActivate Discount
	//Parameter Summary : ActivationMsg
	public void VerifyAddDiscountActivate(Map<Object,Object> testdatamap,Log Log) throws Exception {
		try {
			AddDiscount(testdatamap);
			Thread.sleep(1500);
			searchDiscount(testdatamap);
			Thread.sleep(1500);
			WebClickUsingJS(EdaatOR.Admin_DiscountStatusToggle);
			VerifyValue1(getText(EdaatOR.Admin_confirmationMsg), testdatamap.get("ActivationMsg").toString());
			WebClickUsingJS(EdaatOR.Admin_Activate);
			Thread.sleep(1500);
		    test.log(Status.PASS,"Add Activate Discount" + driver.getTitle() +" * Add Activate Discount PASS * " );	
        	Log.ReportEvent("PASS", "Verify Add and Ativate discount is Suceessful");

		}
	    	catch(Exception e){
			test.log(Status.FAIL,"Add Activate Discount" + driver.getTitle() +" * Add Activate Discount Fail * " );
			this.takeScreenShot();
		}
	}
	
	//Function Summary  : method to verify Error messages in Add discount page
	//Parameter Summary : ExpectedResult, ArabicName, Percentage
	public void VerifyAddDiscountErrorMsg(String ArabicName,String Percentage,String EnglishName, String ExpectedResult,Log Log) throws InterruptedException{
		{
			try {
				navigateDisCountPage(Log) ;
				Thread.sleep(500);
				WebClick(EdaatOR.Admin_AddDiscount);
				Thread.sleep(500);
				WebEdit(EdaatOR.Admin_DiscountNameEn, EnglishName);
				WebEdit(EdaatOR.Admin_DiscountNameAr, ArabicName);
				WebEdit(EdaatOR.Admin_DiscPercentage, Percentage);
				WebClick(EdaatOR.Admin_AddDiscountBtn);
				Thread.sleep(500);
				this.takeScreenShot();
				if (ExistsCheck(EdaatOR.Admin_MandatoryErrorMsg)){	
				
						VerifyValue1(ExpectedResult, getText(EdaatOR.Admin_InvoiceTemplateArNameErrMsg));
						Thread.sleep(500);
						VerifyValue1(ExpectedResult, getText(EdaatOR.Admin_InvoiceTemplateEnNameErrMsg));
						Thread.sleep(500);
						VerifyValue1(ExpectedResult, getText(EdaatOR.Admin_PercentageReqErrorMsg));
						test.log(Status.PASS, "Add Discount ErrorMessage Exists" + driver.getTitle() + " *Discount Error Message Exists * ");
									}
				else if (ExistsCheck(EdaatOR.Admin_InvoiceTemplateArNameErrMsg)) {
					VerifyValue1(ExpectedResult, getText(EdaatOR.Admin_InvoiceTemplateArNameErrMsg));
					test.log(Status.PASS, "Discount  Arabic name ErrorMessage Exists" + driver.getTitle() + " *Discount Arabic name ErrorMessage Exists * ");
				}
				else if (ExistsCheck(EdaatOR.Admin_PercentageReqErrorMsg)) {
					VerifyValue1(ExpectedResult, getText(EdaatOR.Admin_PercentageReqErrorMsg));
					test.log(Status.PASS, "Percentage ErrorMessage Exists" + driver.getTitle() + " *Percentage ErrorMessage Exists * ");
				}
				else {
					test.log(Status.FAIL, "No error Exists" + driver.getTitle() + " * No error Exists * ");
				}

			} catch (Exception e) {
				throw new NoSuchElementException("Add Discount "+ "Page - Not Loaded");
			}

		}
	}
}
