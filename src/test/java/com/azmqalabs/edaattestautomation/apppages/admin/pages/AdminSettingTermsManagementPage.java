/**
* Test Script Name  				 : N/A
* Objective                          : Verify the TermsManagement Functionality.
* Version      						 : 1.0
* Author       						 : Arun Kumar MS
* Created Date 			      		 : 11/08/2023
* Last Updated on					 : N/A
* Updated By   			 			 : 
* Pre-Conditions					 : N/A
* Epic Details						 : N/A
* User Story Details				 : N/A
**/
package com.azmqalabs.edaattestautomation.apppages.admin.pages;

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



public class AdminSettingTermsManagementPage extends BasePage
{

	public AdminSettingTermsManagementPage(WebDriver driver,ExtentTest test)
	{
		 this.driver=driver;
		 this.test=test;
		 
		 PageFactory.initElements(new fieldDecorator(driver,test), this);
	}  
	

	@FindBy(xpath = EdaatOR.Admin_Termsmanagementsym)
	public WebElement TermsManagement;
		
	    
	    public boolean Exists(){
	    	return super.Exists(TermsManagement); 
		}
	 
	  
		
		//Function Summary   : Method to Navigate Term management section in Settings Module.
		//Parameter Summary : N/A
			public void navigateTerm(Log Log) throws Exception {
				WebClickUsingJS(EdaatOR.Admin_SettingsMenu);
				Thread.sleep(2000);
				WebClickUsingJS(EdaatOR.Admin_Terms_menu);
				Thread.sleep(2000);
	        	Log.ReportEvent("PASS", "Verify naviagted Sucessfull to Admin Reports Page");

			}
				//Function Summary   : Method to Delete Terms
			//Parameter Summary : N/A
			public void  VerifyDeleteTerms(Map<Object,Object>testdatamap,Log Log)
			{
				try{
					navigateTerm(Log);
					this.takeScreenShot();
					AddTermAndDeActivate(testdatamap,Log);
				    WebClick(EdaatOR.Admin_Terms_Delete_Button);
					Thread.sleep(2000);
					this.takeScreenShot();
					WebClickUsingJS(EdaatOR.Admin_Terms_DeleteconfirmBTN);
					Thread.sleep(2000);
					SearchTerm(testdatamap);
					this.takeScreenShot();
					Thread.sleep(2000);
					verifyElementIsPresent(EdaatOR.Admin_Terms_NoDataText);
					test.log(Status.PASS,"Verify Delete Term Button" + driver.getTitle() +" * Verify to Delete Term Button is PASS * " );
					Log.ReportEvent("PASS", " Verify to Delete Term Button is Suceessful");
	
				}
					catch(Exception e){
					test.log(Status.FAIL,"Verify Send Email toggel FAIL" + driver.getTitle() +" * Verify to Delete Term Button is FAIL * " );
					this.takeScreenShot();	
					}				
}
	//Function Summary   : Method to Search Terms
		//Parameter Summary : EnglishName
		public void SearchTerm(Map<Object,Object>testdatamap) throws Exception {
			try {
				WebEdit(EdaatOR.Admin_TermTXT_Field,testdatamap.get("EnglishName").toString());
				Thread.sleep(2000);
				WebClickUsingJS(EdaatOR.Admin_Term_SearchBTN);
				this.takeScreenShot();
				Thread.sleep(2000);
				test.log(Status.PASS,"Verify Nevigate to TermsManagement is successful" + driver.getTitle() +" * Nevigate to TermsManagement PASS * " );	
				}
				catch(Exception e){
					test.log(Status.FAIL,"Verify Nevigate to TermsManagement is Failed" + driver.getTitle() +" * Nevigate to TermsManagement is FAIL * " );
					this.takeScreenShot();
							}					
			}
			//Function Summary   : Method to Add and DeActivate Terms
			//Parameter Summary : EnglishName,ArabicName,ArabicText,EnglishText
		public void AddTermAndDeActivate(Map<Object,Object>testdatamap,Log Log) {
				
				try {
					WebClick(EdaatOR.Admin_AddTerm_Btn);
					Thread.sleep(1000);
					WebEdit(EdaatOR.Admin_TermName_Arabic,testdatamap.get("ArabicName").toString());
					Thread.sleep(1000);
					WebEdit(EdaatOR.Admin_TermName_ENG,testdatamap.get("EnglishName").toString());
					Thread.sleep(1000);
					WebEdit(EdaatOR.Admin_TermText_Arabic,testdatamap.get("ArabicText").toString());
					Thread.sleep(1000);
					WebEdit(EdaatOR.Admin_TermText_Eng,testdatamap.get("EnglishText").toString());
					this.takeScreenShot();
					Thread.sleep(1000);
					WebClickUsingJS(EdaatOR.Admin_TermToggle);
					Thread.sleep(1000);
					this.takeScreenShot();
					Thread.sleep(1000);
					WebClick(EdaatOR.Admin_TermSave_BTN);
					Thread.sleep(1000);
					SearchTerm(testdatamap);
					Thread.sleep(1000);
					this.takeScreenShot();
					VerifyValue1(getText("//td[text()='"+testdatamap.get("EnglishName").toString()+"']"),testdatamap.get("EnglishName").toString());
					Thread.sleep(2000);
					WebClickUsingJS(EdaatOR.Admin_TermStatusToggle);
					Thread.sleep(1000);
					WebClick(EdaatOR.Admin_TermConfirmBTN);
					Thread.sleep(1000);
				test.log(Status.PASS,"Search Product Template" + driver.getTitle() +" * Product Management PASS * " );	
	        	Log.ReportEvent("PASS", " Verify Terms Management Add Term and Deactivate functionality Is Suceessfull");

				}
				catch(Exception e){
					test.log(Status.FAIL,"Search Product Template" + driver.getTitle() +" * Product Management FAIL * " );
					this.takeScreenShot();
				}		
		}
			//Function Summary : Method to view term details button
		//Parameter Summary: ArabicName,EnglishName,ArabicText,EnglishText
		public void VerifyToviewActiveTerm(Map<Object, Object> testdatamap,Log Log) {
			 try {
					WebClick(EdaatOR.Admin_AddTerm_Btn);
					Thread.sleep(1000);
					WebEdit(EdaatOR.Admin_TermName_Arabic,testdatamap.get("ArabicName").toString());
					Thread.sleep(1000);
					WebEdit(EdaatOR.Admin_TermName_ENG,testdatamap.get("EnglishName").toString());
					Thread.sleep(1000);
					WebEdit(EdaatOR.Admin_TermText_Arabic,testdatamap.get("ArabicText").toString());
					Thread.sleep(1000);
					WebEdit(EdaatOR.Admin_TermText_Eng,testdatamap.get("EnglishText").toString());
					Thread.sleep(1000);
					WebClick(EdaatOR.Admin_TermToggle);
					Thread.sleep(1000);
					WebClick(EdaatOR.Admin_TermSave_BTN);
					Thread.sleep(1000);
					SearchTerm(testdatamap);
					Thread.sleep(1000);
			        VerifyValue1(getText("(//tr/td[contains(text(),'"+testdatamap.get("EnglishName").toString()+"')])[1]"),testdatamap.get("EnglishName").toString());
					WebClickUsingJS(EdaatOR.Admin_TermsManagement_Editbtn);
			        VerifyValue1(WebGetText(EdaatOR.Admin_TermsManagement_updatetxt),testdatamap.get("ViewText").toString());
			        this.takeScreenShot();
					test.log(Status.PASS,"view term details button" + driver.getTitle() +" * Verify view term details button is PASS * " );	
		        	Log.ReportEvent("PASS", "Verify  view term details button is Successful");
	
			 }
				catch(Exception e){
					test.log(Status.FAIL,"view term details button" + driver.getTitle() +" * Verify view term details button is FAIL * " );
					this.takeScreenShot();
			
		}
		}

				//Function Summary   : Method to Verify Search Term
		//Parameter Summary : EnglishName,ArabicName,ArabicText,EnglishText
		public void SettingsTermsManagementSearchTerm(Map<Object,Object>testdatamap,Log Log)
		{
			try
			{
			navigateTerm(Log);
			WebClick(EdaatOR.Admin_AddTerm_Btn);
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_TermName_Arabic,testdatamap.get("ArabicName").toString());
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_TermName_ENG,testdatamap.get("EnglishName").toString());
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_TermText_Arabic,testdatamap.get("ArabicText").toString());
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_TermText_Eng,testdatamap.get("EnglishText").toString());
			Thread.sleep(1000);
			WebClick(EdaatOR.Admin_TermToggle);
			Thread.sleep(1000);
			WebClick(EdaatOR.Admin_TermSave_BTN);
			Thread.sleep(1000);
			SearchTerm(testdatamap);
			Thread.sleep(1000);
			this.takeScreenShot();
			VerifyValue1(getText("//td[text()='"+testdatamap.get("EnglishName").toString()+"']"),testdatamap.get("EnglishName").toString());
			test.log(Status.PASS,"Settings Terms Management Search Term" + driver.getTitle() +" SearchTerm is PASS * " );	
        	Log.ReportEvent("PASS", "Verify search term functionality is Suceessful");

			}
			catch(Exception e){
				test.log(Status.FAIL,"Settings Terms Management Search Term" + driver.getTitle() +" SearchTerm is PASS * " );	
				this.takeScreenShot();
			}		
		}
		//Function Summary   : Method to Add and Activate Terms
		//Parameter Summary : EnglishName,ArabicName,ArabicText,EnglishText
		public void VerifyTermsMgnActive(Map<Object, Object> testdatamap,Log Log) {
			// TODO Auto-generated method stub
			try {
				WebClick(EdaatOR.Admin_AddTerm_Btn);
				Thread.sleep(1000);
				WebEdit(EdaatOR.Admin_TermName_Arabic,testdatamap.get("ArabicName").toString());
				Thread.sleep(1000);
				WebEdit(EdaatOR.Admin_TermName_ENG,testdatamap.get("EnglishName").toString());
				Thread.sleep(1000);
				WebEdit(EdaatOR.Admin_TermText_Arabic,testdatamap.get("ArabicText").toString());
				Thread.sleep(1000);
				WebEdit(EdaatOR.Admin_TermText_Eng,testdatamap.get("EnglishText").toString());
				Thread.sleep(1000);				
				WebClick(EdaatOR.Admin_TermSave_BTN);
				Thread.sleep(1000);
				SearchTerm(testdatamap);				
				Thread.sleep(1000);			
				VerifyValue1(getText("//td[text()='"+testdatamap.get("EnglishName").toString()+"']"),testdatamap.get("EnglishName").toString());
				Thread.sleep(1000);
				WebClickUsingJS(EdaatOR.Admin_TermStatusToggle);
				Thread.sleep(1000);
				verifyElementIsPresent(EdaatOR.Admin_TermMngConformActive);
				Thread.sleep(1000);
				WebClick(EdaatOR.Admin_TermConfirmBTN);
				Thread.sleep(1000);
			test.log(Status.PASS,"Terms Management Active" + driver.getTitle() +" * Terms Management PASS * " );	
        	Log.ReportEvent("PASS", " Verify Super biller report is succesfull");

			}
			catch(Exception e){
				test.log(Status.FAIL,"Terms Management Active" + driver.getTitle() +" * Terms Management FAIL * " );
				this.takeScreenShot();
			}	
			
		}
	
			
				//Function Summary :Method to Verify grid view of terms management module. 
				//Parameter Summary: N/A.
				public void VerifyGridView(Log Log) {
					try {
						navigateTerm(Log);
				        Thread.sleep(1000);
				        verifyElementIsPresent(EdaatOR.Admin_TermsNameEng);		       
				        verifyElementIsPresent(EdaatOR.Admin_TermsNameAr);		       
			        	Thread.sleep(2000);
			        	this.takeScreenShot();
						test.log(Status.PASS,"Verify gridview is successful" + driver.getTitle() +" * TermsMangement PASS * " );	
			        	Log.ReportEvent("PASS", " Verify grid view of Terms management is Suceessfull");

					}
					catch(Exception e){
						test.log(Status.FAIL,"Verify gridview is Failed" + driver.getTitle() +" * TermsMangement FAIL * " );
						this.takeScreenShot();
					}				
		
			}	
			public void AddTerm(Map<Object,Object>testdatamap) throws InterruptedException {
				WebClick(EdaatOR.Admin_AddTerm_Btn);
				Thread.sleep(500);
				WebEdit(EdaatOR.Admin_TermName_Arabic,testdatamap.get("ArabicName").toString());
				Thread.sleep(500);
				WebEdit(EdaatOR.Admin_TermName_ENG,testdatamap.get("EnglishName").toString());
				Thread.sleep(500);
				WebEdit(EdaatOR.Admin_TermText_Arabic,testdatamap.get("ArabicText").toString());
				Thread.sleep(500);
				WebEdit(EdaatOR.Admin_TermText_Eng,testdatamap.get("EnglishText").toString());
				this.takeScreenShot();
				Thread.sleep(500);
				WebClick(EdaatOR.Admin_TermSave_BTN);
			}	
				
				
				//Function Summary  : method to verify Error messages in term management page
				//Parameter Summary : ExpectedResult
				public void VerifyAddTermErrorMsg(Map<Object,Object>testdatamap,Log Log) throws InterruptedException{
					{
						try {
							navigateTerm(Log);
							Thread.sleep(500);
							AddTerm(testdatamap);
							this.takeScreenShot();
							if (ExistsCheck(EdaatOR.Admin_MandatoryErrorMsg)){	

								VerifyValue1(testdatamap.get("ExpectedResult").toString(), getText(EdaatOR.Admin_ArNameErrorMsg));
								Thread.sleep(500);
								VerifyValue1(testdatamap.get("ExpectedResult").toString(), getText(EdaatOR.Admin_EnNameErrorMsg));
								Thread.sleep(500);
								VerifyValue1(testdatamap.get("ExpectedResult").toString(), getText(EdaatOR.Admin_ArDescErrorMsg));
								test.log(Status.PASS, "Add term ErrorMessage Exists" + driver.getTitle() + " *term Error Message Exists * ");
							}
							else if (ExistsCheck(EdaatOR.Admin_ArNameErrorMsg)) {
								VerifyValue1(testdatamap.get("ExpectedResult").toString(), getText(EdaatOR.Admin_ArNameErrorMsg));
								test.log(Status.PASS, "term name in Ar ErrorMessage Exists" + driver.getTitle() + " *term name ErrorMessage Exists * ");
							}

							else {
								test.log(Status.FAIL, "No error Exists" + driver.getTitle() + " * No error Exists * ");
							}

						} catch (Exception e) {
							throw new NoSuchElementException("Add term "+ "Page - Not Loaded");
						}

					}
				}							

				
}