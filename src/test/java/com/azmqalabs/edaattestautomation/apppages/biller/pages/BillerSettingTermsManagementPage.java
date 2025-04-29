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
package com.azmqalabs.edaattestautomation.apppages.biller.pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.azmqalabs.edaattestautomation.common.Log;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.azmqalabs.edaattestautomation.apppages.GlobalConstant;
import com.azmqalabs.edaattestautomation.apppages.masterpages.BasePage;
import com.azmqalabs.edaattestautomation.common.uielement.fieldDecorator;
import com.azmqalabs.edaattestautomation.objectrepository.EdaatOR;



public class BillerSettingTermsManagementPage extends BasePage
{

	public BillerSettingTermsManagementPage(WebDriver driver,ExtentTest test)
	{
		 this.driver=driver;
		 this.test=test;
		 
		 PageFactory.initElements(new fieldDecorator(driver,test), this);
	}  
	

	@FindBy(xpath = EdaatOR.Biller_Termsmanagementsym)
	public WebElement TermsManagement;
		
	    
	    public boolean Exists(){
	    	return super.Exists(TermsManagement); 
		}
	  //Function Summary :Method to Verify grid view of termsmanagement module. 
	//Parameter Summary: N/A.
	  
		public void VerifyGridView(Log Log) {
			// TODO Auto-generated method stub
			try {
		        WebClick(EdaatOR.Biller_Settingbtn);
		        Thread.sleep(1000);
		        WebClickUsingJS(EdaatOR.Biller_Termsmanagementbtn);
		        Thread.sleep(2000);
		        verifyElementIsPresent(EdaatOR.Biller_Termsmanagementsym);		       
		        verifyElementIsPresent(EdaatOR.Biller_Termsnameinarabic);		       
	        	Thread.sleep(2000);
	        	this.takeScreenShot();
				test.log(Status.PASS,"#FUNC-Verify gridview is successful" + driver.getTitle() +" * TermsMangement PASS * " );	
				Log.ReportEvent("PASS", " Verify grid view of Terms management is Suceessfull");
			}
			catch(Exception e){
				test.log(Status.FAIL,"#FUNC-Verify gridview is Failed" + driver.getTitle() +" * TermsMangement FAIL * " );
				this.takeScreenShot();
			}				
		}
		//Function Summary   : Method to Navigate Term management section in Settings Module.
				//Parameter Summary : N/A
			public void navigateTerm() throws Exception {
				WebClickUsingJS(EdaatOR.Biller_Settings);
				Thread.sleep(2000);
				WebClickUsingJS(EdaatOR.Biller_Terms_menu);
				Thread.sleep(2000);
			}
			//Function Summary   : Method to Search Terms
			//Parameter Summary : EnglishName
	public void SearchTerm(Map<Object,Object>testdatamap) throws Exception {
				try {
					WebEdit(EdaatOR.Biller_TermTXT_Field,testdatamap.get("EnglishName").toString());
					Thread.sleep(2000);
					WebClickUsingJS(EdaatOR.Biller_Term_SearchBTN);
					Thread.sleep(2000);
					//VerifyValue1(getText("(//tr/td[contains(text(),'"+testdatamap.get("EnglishName").toString()+"')])[1]"),testdatamap.get("EnglishName").toString());
					test.log(Status.PASS,"#FUNC-Verify Nevigate to TermsManagement is successful" + driver.getTitle() +" * Nevigate to TermsManagement PASS * " );	
				}
				catch(Exception e){
					test.log(Status.FAIL,"#FUNC-Verify Nevigate to TermsManagement is Failed" + driver.getTitle() +" * Nevigate to TermsManagement is FAIL * " );
					this.takeScreenShot();
				}
					
			}
	//Function Summary   : Method to verify terms Search Functionality
			//Parameter Summary : EnglishName
			public void VerifySearchTerm(Map<Object,Object>testdatamap,Log Log) throws Exception {
				try {
					WebEdit(EdaatOR.Biller_TermTXT_Field,testdatamap.get("EnglishName").toString());
					Thread.sleep(2000);
					WebClickUsingJS(EdaatOR.Biller_Term_SearchBTN);
					this.takeScreenShot();
					if(CheckElementExists(EdaatOR.Biller_TermNoDataAvilableTxt)==true);
					{
						VerifyToaddActiveTerm(testdatamap, Log);
											
					}
					VerifyValue1(getText("(//tr/td[contains(text(),'"+testdatamap.get("EnglishName").toString()+"')])[1]"),testdatamap.get("EnglishName").toString());
					test.log(Status.PASS,"#FUNC-Verify Search Terms is successful" + driver.getTitle() +" * Verify Search Terms is PASS * " );	
				  	Log.ReportEvent("PASS", " Verify search Term is Successful");
				}
				catch(Exception e){
					test.log(Status.FAIL,"#FUNC-Verify Search Terms is FAIL" + driver.getTitle() +" * Verify Search Terms is FAIL * " );
					this.takeScreenShot();
				}
					
			}
			
			//Function Summary   : Method to Add and DeActivate Terms
			//Parameter Summary : EnglishName,ArabicName,ArabicText,EnglishText
		public void AddTermAndDeActivate(Map<Object,Object>testdatamap,Log Log) {
				
				try {
					navigateTerm();
					WebClick(EdaatOR.Biller_AddTerm_Btn);
					Thread.sleep(1000);
					WebEdit(EdaatOR.Biller_TermName_Arabic,testdatamap.get("ArabicName").toString());
					Thread.sleep(1000);
					WebEdit(EdaatOR.Biller_TermName_ENG,testdatamap.get("EnglishName").toString());
					Thread.sleep(1000);
					WebEdit(EdaatOR.Biller_TermText_Arabic,testdatamap.get("ArabicText").toString());
					Thread.sleep(1000);
					WebEdit(EdaatOR.Biller_TermText_Eng,testdatamap.get("EnglishText").toString());
					Thread.sleep(1000);
					WebClick(EdaatOR.Biller_TermToggle);
					Thread.sleep(1000);
					WebClick(EdaatOR.Biller_TermSave_BTN);
					Thread.sleep(1000);
					SearchTerm(testdatamap);
					Thread.sleep(1000);
					VerifyValue1(getText("//td[text()='"+testdatamap.get("EnglishName").toString()+"']"),testdatamap.get("EnglishName").toString());
					Thread.sleep(2000);
					WebClick(EdaatOR.Biller_TermStatusToggle);
					Thread.sleep(1000);
					this.takeScreenShot();
					WebClick(EdaatOR.Biller_TermConfirmBTN);
					Thread.sleep(1000);
					
					

					test.log(Status.PASS,"#FUNC-Search Product Template" + driver.getTitle() +" * Product Management PASS * " );	
					Log.ReportEvent("PASS", " Verify Terms Management Add Term and Deactivate functionality Is Suceessfull");
				}
				catch(Exception e){
					test.log(Status.FAIL,"#FUNC-Search Product Template" + driver.getTitle() +" * Product Management FAIL * " );
					this.takeScreenShot();
				}
}
//Function Summary :Method to Navigate "TermsManagement" Page
		//Parameter Summary: N/A
		public void navigatetoTermsManagement(Log Log) throws InterruptedException {	
	        try {
	        	WebClick(EdaatOR.Biller_Settingbtn);
		        Thread.sleep(1000);
		        WebClick(EdaatOR.Biller_Termsmanagementbtn);
		        Thread.sleep(2000);
	        	this.takeScreenShot();
				test.log(Status.PASS,"#FUNC-Verify Nevigate to TermsManagement is successful" + driver.getTitle() +" * Nevigate to TermsManagement PASS * " );	
				Log.ReportEvent("PASS", " Verify navigate to termsmanagement is Successful");
	        }
			catch(Exception e){
				test.log(Status.FAIL,"#FUNC-Verify Nevigate to TermsManagement is Failed" + driver.getTitle() +" * Nevigate to TermsManagement is FAIL * " );
				this.takeScreenShot();
			}
			
		}
		
		//Function Summary :Method to Search Term in TermsManagement" Page
		//Parameter Summary:EnglishName
	/*	private void SearchTerm(Map<Object, Object> testdatamap) {
			try {
				  WebEdit(EdaatOR.Biller_searchtxtfield, testdatamap.get("EnglishName").toString());
			      WebClick(EdaatOR.Biller_Searchbtn);
				this.takeScreenShot();
				test.log(Status.PASS,"#FUNC- Search Term  is successful" + driver.getTitle() +" * Search Term PASS * " );	
			}
			catch(Exception e){
				test.log(Status.FAIL,"#FUNC-Search Term is Failed" + driver.getTitle() +" * Search Term is FAIL * " );
				this.takeScreenShot();
			}
		}*/

		//Function Summary : Method to add and active Term 
		//Parameter Summary: ArebicName,EnglishName,ArebicTermName,EnglishTermName
		public void VerifyToaddActiveTerm(Map<Object, Object> testdatamap,Log Log) {
			 try {
			        WebClickUsingJS(EdaatOR.Biller_AddTermbtn);
                    this.takeScreenShot();
			        WebEdit(EdaatOR.Biller_Arebicname, testdatamap.get("ArebicName").toString());
			        WebEdit(EdaatOR.Biller_Englishname, testdatamap.get("EnglishName").toString());
			        WebEdit(EdaatOR.Biller_Termarebicname, testdatamap.get("ArebicTermName").toString());
			        WebEdit(EdaatOR.Biller_TermEnglishname, testdatamap.get("EnglishTermName").toString());
			        WebClickUsingJS(EdaatOR.Biller_TermpopupActivebtn);
			        WebClick(EdaatOR.Biller_Termpopupsavebtn);
			        SearchTerm(testdatamap);
			        VerifyValue1(getText("(//tr/td[contains(text(),'"+testdatamap.get("EnglishName").toString()+"')])[1]"),testdatamap.get("EnglishName").toString());
					this.takeScreenShot();
					test.log(Status.PASS,"#FUNC-Verify Nevigate to TermsManagement is successful" + driver.getTitle() +" * Nevigate to TermsManagement PASS * " );	
					Log.ReportEvent("PASS", " Verify add term and Activate is Successful");
			 }
				catch(Exception e){
					test.log(Status.FAIL,"#FUNC-Verify Nevigate to TermsManagement is Failed" + driver.getTitle() +" * Nevigate to TermsManagement is FAIL * " );
					this.takeScreenShot();
			
		}
	
	}
	
			  //Function Summary : Method to add and active Term 
				//Parameter Summary: ArebicName,EnglishName,ArebicTermName,EnglishTermName
				public void VerifyToviewActiveTerm(Map<Object, Object> testdatamap,Log Log) {
					 try {
					        WebClick(EdaatOR.Biller_AddTermbtn);
					        WebEdit(EdaatOR.Biller_Arebicname, testdatamap.get("ArebicName").toString());
					        WebEdit(EdaatOR.Biller_Englishname, testdatamap.get("EnglishName").toString());
					        WebEdit(EdaatOR.Biller_Termarebicname, testdatamap.get("ArebicTermName").toString());
					        WebEdit(EdaatOR.Biller_TermEnglishname, testdatamap.get("EnglishTermName").toString());
					        WebClickUsingJS(EdaatOR.Biller_TermpopupActivebtn);
					        WebClick(EdaatOR.Biller_Termpopupsavebtn);
					        SearchTerm(testdatamap);
					        VerifyValue1(getText("(//tr/td[contains(text(),'"+testdatamap.get("EnglishName").toString()+"')])[1]"),testdatamap.get("EnglishName").toString());
							WebClickUsingJS(EdaatOR.Biller_TermsManagement_Editbtn);
					        VerifyValue1(WebGetText(EdaatOR.Biller_TermsManagement_updatetxt),testdatamap.get("ViewText").toString());

					        this.takeScreenShot();
							
							test.log(Status.PASS,"#FUNC-Verify Nevigate to TermsManagement is successful" + driver.getTitle() +" * Nevigate to TermsManagement PASS * " );	
							Log.ReportEvent("PASS", " Verify  view term details button is Successful");
					 }
						catch(Exception e){
							test.log(Status.FAIL,"#FUNC-Verify Nevigate to TermsManagement is Failed" + driver.getTitle() +" * Nevigate to TermsManagement is FAIL * " );
							this.takeScreenShot();
					
				}
				}	//Function Summary : Method to verify Delete Term Button
						//Parameter Summary:NA.
						public void DeleteTermButton(Map<Object, Object> testdatamap,Log Log) throws Exception
						{
							navigatetoTermsManagement(Log);
							VerifyToaddActiveTerm(testdatamap, Log);
							WebClickUsingJS(EdaatOR.Biller_Setting_termMgm_deleteBtn);
					        Thread.sleep(2000);
							//if(CheckElementExists(EdaatOR.Biller_Setting_termMgm_deletebtn_verify)==true)
							//{
						        Thread.sleep(2000);
								WebClickUsingJS(EdaatOR.Biller_Setting_termMgm_deleteyes);
							//}
					        Thread.sleep(2000);
							WebClickUsingJS(EdaatOR.Biller_Terms_menu);
					        Thread.sleep(2000);
					        SearchTerm(testdatamap);
					        verifyElementIsPresent(EdaatOR.Biller_Setting_termMgm_after_delete);
							test.log(Status.PASS,"#FUNC-Verify Delete Term is successful" + driver.getTitle() +" *Delete Term is successful PASS * " );
				        	Log.ReportEvent("INFO", " Verify delete term button");	 
							
						}
						//Function Summary : Method to Add Term
						//Parameter Summary:ArabicName,EnglishName,ArabicText,EnglishText
						public void AddTerm(Map<Object,Object>testdatamap) {
							
							try {
								navigateTerm();
								WebClick(EdaatOR.Biller_AddTerm_Btn);
								Thread.sleep(1000);
								WebEdit(EdaatOR.Biller_TermName_Arabic,testdatamap.get("ArabicName").toString());
								Thread.sleep(1000);
								WebEdit(EdaatOR.Biller_TermName_ENG,testdatamap.get("EnglishName").toString());
								Thread.sleep(1000);
								WebEdit(EdaatOR.Biller_TermText_Arabic,testdatamap.get("ArabicText").toString());
								Thread.sleep(1000);
								WebEdit(EdaatOR.Biller_TermText_Eng,testdatamap.get("EnglishText").toString());
								Thread.sleep(1000);
								WebClick(EdaatOR.Biller_TermToggle);
								Thread.sleep(1000);
								WebClick(EdaatOR.Biller_TermSave_BTN);
								Thread.sleep(1000);
								this.takeScreenShot();
								test.log(Status.PASS,"#FUNC-Add terms " + driver.getTitle() +" * Add Terms PASS * " );	

							}
							catch(Exception e){
								test.log(Status.FAIL,"#FUNC-Add Terms " + driver.getTitle() +" * Add Terms FAIL * " );
								this.takeScreenShot();
							}
			}
						//Function Summary : Method to Verify AddTerm Error Msg
						//Parameter Summary:ArabicName,EnglishName,ArabicText,EnglishText
                          public void AddTermErrorMessageValidation(Map<Object,Object>testdatamap) {
                        	  AddTerm(testdatamap);
                        	  String Expected=testdatamap.get("ExpectedResult").toString();
							try {
								if(ExistsCheck(EdaatOR.Biller_Settings_TermArabicNameError)) {
									VerifyValue(Expected,EdaatOR.Biller_Settings_TermArabicNameError);
									test.log(Status.PASS, "#FUNC-Terms Management Term ArabicName Error Message Exists" + driver.getTitle() + " * Terms Management Term ArabicName Error Message Exists * ");	    	
							     }
								else if(ExistsCheck(EdaatOR.Biller_Settings_TermEngNameError)){
									VerifyValue(Expected,EdaatOR.Biller_Settings_TermEngNameError);
									test.log(Status.PASS, "#FUNC-Terms Management Term EnglishName Error Message Exists" + driver.getTitle() + " * Terms Management Term EnglishName Error Message Exists * ");
								}
								else if(ExistsCheck(EdaatOR.Biller_Settings_TermTextArabicError)){
									VerifyValue(Expected,EdaatOR.Biller_Settings_TermTextArabicError);
									test.log(Status.PASS, "#FUNC-Terms Management Term ArabicText Error Message Exists" + driver.getTitle() + " * Terms Management Term ArabicText Error Message Exists * ");
								}
								
								else {

									test.log(Status.FAIL, "#FUNC-Element Not Exists" + driver.getTitle() + " * Element Not Exists * ");
									  }
							}
							catch(Exception e){
								test.log(Status.FAIL,"#FUNC- Add Terms " + driver.getTitle() +" *  Add Terms FAIL * " );
								this.takeScreenShot();
							}
}
}