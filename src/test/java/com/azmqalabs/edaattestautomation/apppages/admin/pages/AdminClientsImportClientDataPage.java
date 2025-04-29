/**
*
* Test Script Name                   : N/A
* Test Data Sheet                    : N/A
* Objective                          : Verify the Import Client Data Functionality.                                    
* Version                            : 1.0
* Author                             : Kathirvelu Mohan
* Created Date                       : 23/05/2023
* Last Updated on                    : N/A
* Updated By                         : Basavaraj Mudnur
* Pre-Conditions                     : N/A
* Epic Details                       : N/A
* User Story Details                 : N/A
**/
package com.azmqalabs.edaattestautomation.apppages.admin.pages;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.Alert;
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



public class AdminClientsImportClientDataPage extends BasePage
{

	public AdminClientsImportClientDataPage(WebDriver driver,ExtentTest test)
	{
		 this.driver=driver;
		 this.test=test;
		 
		 PageFactory.initElements(new fieldDecorator(driver,test), this);
	}  
	

	@FindBy(xpath = EdaatOR.Admin_ImportClientdatasym)
	public WebElement ImportClientsData;
		
	    
	    public boolean Exists(){
	    	return super.Exists(ImportClientsData); 
		}
	    //Function summary:Method to navigate import client data.
		//Function Parameters:N/A.
	    public void navigateImportClientdata()
	    {	    	
	    	WebClick(EdaatOR.Admin_ImportClientdatabtm);
	    	WebClick(EdaatOR.Admin_ImportClientdata);   	
	    	
	    }
	  //Function summary:Method to verify the client type in import client data.
	  //Function Parameters:Corporate,Individual.

		public void VerifyClienttype(Map<Object, Object> testdatamap,Log Log) {
			// TODO Auto-generated method stub
			try{
				navigateImportClientdata();
				WebClick(EdaatOR.Admin_ImportCorporateradiobtn);
				VerifyValue1(getText(EdaatOR.Admin_ImportCorporateradioImg),testdatamap.get("Corporate").toString());
				this.takeScreenShot();
				Thread.sleep(2000);
				WebClick(EdaatOR.Admin_ImportIndividualradiobtn);
				VerifyValue1(getText(EdaatOR.Admin_ImportIndividualradioImg),testdatamap.get("Individual").toString());
				this.takeScreenShot();
				
	            test.log(Status.PASS,"Import Client data type" + driver.getTitle() +" * Import Client data type is PASS * " );   	
	        	Log.ReportEvent("PASS", " Verify View Individual Client Invoice is Suceessfull");

			}catch(Exception e){
                test.log(Status.FAIL,"Import Client data type" + driver.getTitle() +" * Import Client data type is FAIL * " );
                this.takeScreenShot();
        }
   }
    	public void UploadClientBulkData(Map<Object, Object> testdatamap) throws IOException, InterruptedException		
   	    {			
   	        String client=testdatamap.get("Customertype").toString();		
   	      	if(client.equalsIgnoreCase("Individual")) {			
   	      	WebClick(EdaatOR.Admin_ImportIndividualradiobtn);
			WebClickUsingJS(EdaatOR.Admin_ImportAttachExelFileBTN);
			Thread.sleep(2000);
			File classpathRoot = new File(System.getProperty("user.dir"));
	        File app = new File(classpathRoot.getAbsolutePath() + "//SeleniumGrid//attachment//UploadBulkData.exe");
	        String sFilename = app.toString();
	        Runtime.getRuntime().exec(sFilename);
	        System.out.println(sFilename);
	        Thread.sleep(2000);
	        WebClickUsingJS(EdaatOR.Admin_ClientProcessButton);
	        Thread.sleep(2000);
	        WebClickUsingJS(EdaatOR.Admin_ClientConfirmUploadButton);
	        Thread.sleep(5000);
	        SerachIndividualClient(testdatamap);
			}
			else{
				CorporateClientBulkData(testdatamap);
				Thread.sleep(3000);
				SerachCorporateClient(testdatamap);
			}
		}
		
			
		public void CorporateClientBulkData(Map<Object, Object> testdatamap) throws IOException, InterruptedException
		{
			WebClick(EdaatOR.Admin_ImportCorporateradiobtn);
			WebClickUsingJS(EdaatOR.Admin_ImportAttachExelFileBTN);
			Thread.sleep(2000);
			File classpathRoot = new File(System.getProperty("user.dir"));
	        File app = new File(classpathRoot.getAbsolutePath() + "//SeleniumGrid//attachment//UploadCorporateClientBulkData.exe");
	        String sFilename = app.toString();
	        Runtime.getRuntime().exec(sFilename);
	        System.out.println(sFilename);
	        Thread.sleep(2000);
	        WebClickUsingJS(EdaatOR.Admin_ClientProcessButton);
	        Thread.sleep(2000);
	        WebClickUsingJS(EdaatOR.Admin_ClientConfirmUploadButton);
		}
		
		public void VerifyImportClientData(Map<Object, Object> testdatamap,Log Log) {
				// TODO Auto-generated method stub
			try{
				navigateImportClientdata();
				this.takeScreenShot();
				UploadClientBulkData(testdatamap);
			    Thread.sleep(5000);
			    waitForPageToLoad();
				Thread.sleep(2000);
		        test.log(Status.PASS,"Import Client data type" + driver.getTitle() +" * Import Client data type is PASS * " );   	
	        	Log.ReportEvent("PASS", " Verify Import Client Data is Sucessful");

			}catch(Exception e){
	                test.log(Status.FAIL,"Import Client data type" + driver.getTitle() +" * Import Client data type is FAIL * " );
	                this.takeScreenShot();
	        }
			
		}
		
		  //Function summary:Method to verify to Download the Bulk sheet.
		  //Function Parameters:Individual,Individual,Corporate.
		public void VerifyDownloadBulkSheet(Map<Object, Object> testdatamap,Log Log) {
			try{				
				navigateImportClientdata();
				Thread.sleep(1000);	
				this.takeScreenShot();
				WebClick(EdaatOR.Admin_ImportIndividualradiobtn);
				VerifyValue1(getText(EdaatOR.Admin_ImportIndividualradioImg),testdatamap.get("Individual").toString());
				WebClick(EdaatOR.Admin_ImportIndividualradioImg);
				Thread.sleep(1000);		
				this.takeScreenShot();
				WebClick(EdaatOR.Admin_ImportCorporateradiobtn);
				VerifyValue1(getText(EdaatOR.Admin_ImportCorporateradioImg),testdatamap.get("Corporate").toString());
				WebClick(EdaatOR.Admin_ImportCorporateradioImg);
				Thread.sleep(1000);		
				this.takeScreenShot();
				Thread.sleep(1000);		
	            test.log(Status.PASS,"Verify to download the bulk sheet" + driver.getTitle() +" * Download the bulk sheet is PASS * " );   	
	        	Log.ReportEvent("PASS", " Verify Import Client Data is Sucessful");

			}
			catch(Exception e){
                test.log(Status.FAIL,"Verify to download the bulk sheet" + driver.getTitle() +" * Download the bulk sheet is FAIL * " );
                this.takeScreenShot();
        }
		}
		public void SerachIndividualClient(Map<Object, Object> testdatamap) throws InterruptedException, IOException
		{
			WebClickUsingJS(EdaatOR.Admin_Add_Individualclient);
			WebEdit(EdaatOR.Admin_Individualclient_Name,testdatamap.get("ClientName").toString());
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_Individualclient_IdNumber,testdatamap.get("NationalD").toString());
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_Individualclient_CustomerRefNumber,testdatamap.get("CRNumber").toString());
			Thread.sleep(1000);
			scrollDowntillend(driver);
			WebClickUsingJS(EdaatOR.Admin_Individualclient_Search);
			Thread.sleep(2000);
			this.takeScreenShot();
			VerifyValue1(getText("//td[text()='"+testdatamap.get("NationalD").toString()+"']"),testdatamap.get("NationalD").toString());
		}
		public void SerachCorporateClient(Map<Object, Object> testdatamap) throws InterruptedException, IOException
		{
			WebClickUsingJS(EdaatOR.Admin_Add_Companyclient);
			WebEdit(EdaatOR.Admin_CorporateclientName,testdatamap.get("ClientName").toString());
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_Corporateclient_Rno,testdatamap.get("CRNumber").toString());
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_Individualclient_CustomerRefNumber,testdatamap.get("ReferenceNumber").toString());
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Admin_Individualclient_Search);
			this.takeScreenShot();
			VerifyValue1(getText("//td[text()='"+testdatamap.get("CRNumber").toString()+"']"),testdatamap.get("CRNumber").toString());
		}
		
		//Function Summary  : method to verify Error messages in Import client data page
		//Parameter Summary : ExpectedResult		
	
		public void VerifyImportClientDataErrMsg(String ExpectedResult) {
			try {
				navigateImportClientdata();
				Thread.sleep(1000);
				WebClick(EdaatOR.Admin_ClientProcessButton);
				this.takeScreenShot();
				if(ExistsCheck(EdaatOR.Admin_ClientUploadButtonErrMsg)){	
				VerifyValue1(ExpectedResult, getText(EdaatOR.Admin_ClientUploadButtonErrMsg));			
				test.log(Status.PASS, "Import client data ErrorMessage Exists" + driver.getTitle() + " * Error Message Exists * ");
			    }
				else {
					test.log(Status.FAIL, "No error Exists" + driver.getTitle() + " * No error Exists * ");
				     }
			}
			catch(Exception e) {
				throw new NoSuchElementException("Import client data "+ "Page - Not Loaded");
			}
			
		}
  }
	
	
    

