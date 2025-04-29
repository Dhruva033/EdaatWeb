/**
* Test Script Name  				 : N/A
* Objective                          :Verify to download the bulk sheet.
* Version      						 : 1.0
* Author       						 : Arun Kumar MS
* Created Date 			      		 : 11/08/2023
* Last Updated on					 : N/A
* Updated By   			 			 : Basavaraj Mudnur
* Pre-Conditions					 : N/A
* Manual Test case Name				 : N/A
* Epic Details						 : N/A
* User Story Details				 : N/A
**/
package com.azmqalabs.edaattestautomation.apppages.biller.pages;

import java.io.File;
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
import com.azmqalabs.edaattestautomation.common.uielement.fieldDecorator;
import com.azmqalabs.edaattestautomation.objectrepository.EdaatOR;
import com.azmqalabs.edaattestautomation.common.Log;



public class BillerImportClientdataPage extends BasePage
{

	public BillerImportClientdataPage(WebDriver driver,ExtentTest test)
	{
		 this.driver=driver;
		 this.test=test;
		 
		 PageFactory.initElements(new fieldDecorator(driver,test), this);
	}  
	

	@FindBy(xpath = EdaatOR.Biller_importclientsym)
	public WebElement ImportClientsData;
		
	    
	    public boolean Exists(){
	    	return super.Exists(ImportClientsData); 
		}
	  //Function Summary : Method to Select Individual Client radio Button. 
	  	//Parameter Summary: N/A.
	    public void ClickOnIndividualRadBtn()
	    {
	    	WebClick(EdaatOR.Biller_IndivRdnBtn);
	    }
	  //Function Summary : Method to Select corporate Client radio Button. 
	  	//Parameter Summary: N/A.
	    public void ClickOnCoporateRadBtn()
	    {
	    	WebClick(EdaatOR.Biller_CarpoRdnBtn);
	    }
	    //Function Summary : Method to Select Individual Client radio Button. 
	  	//Parameter Summary: N/A.
	    public void ClickOnDownloadIndividual()
	    {
	    	WebClick(EdaatOR.Biller_IndDownimg);
	    }
	  //Function Summary : Method to Select corporate Client radio Button. 
	  	//Parameter Summary: N/A.
	    public void ClickOnDownloadCorporate()
	    {
	    	WebClick(EdaatOR.Biller_CorpDownimg);
	    }
	    //Function Summary : Method to Select corporate/Individual Client radio Button. 
		//Parameter Summary: Customertype.
	    public void Selectradiobtn1(Map<Object, Object> testdatamap) throws InterruptedException
	    {
	    	String client=testdatamap.get("Customertype").toString();
			if(client.equalsIgnoreCase("Corporates")) {
				ClickOnCoporateRadBtn();
				Thread.sleep(3000);
				ClickOnDownloadCorporate();				
				
			}
			else{
				ClickOnIndividualRadBtn();
				Thread.sleep(3000);
				ClickOnDownloadIndividual();
			}
	    }
	    
	    public void Selectradiobtn(Map<Object, Object> testdatamap) throws InterruptedException
	    {
	    	String client=testdatamap.get("Customertype").toString();
			if(client.equalsIgnoreCase("Corporates")) {
				ClickOnCoporateRadBtn();
				Thread.sleep(3000);			
				
			}
			else{
				ClickOnIndividualRadBtn();
				Thread.sleep(3000);
			}
	    }
	  //Function Summary : Method to download Import client data. 
	//Parameter Summary: N/A.
	    public void downloadImportClientdata(Map<Object, Object> testdatamap,Log Log)
        {
            try {

                WebClickUsingJS(EdaatOR.Biller_Clientbtn);
                Thread.sleep(1000);
                WebClickUsingJS(EdaatOR.Biller_ImportClientbtn);
                Thread.sleep(2000);
                verifyElementIsPresent(EdaatOR.Biller_importclientsym);
                Selectradiobtn1(testdatamap);
                Thread.sleep(3000);
                this.takeScreenShot();    

                test.log(Status.PASS,"#FUNC-Search ImportClientdata is successful" + driver.getTitle() +" * Clients PASS * " );    
               	Log.ReportEvent("PASS", " Verify To download import client data is Suceessfull");

            }
            catch(Exception e){
                test.log(Status.FAIL,"#FUNC-Search ImportClientdata is Failed" + driver.getTitle() +" * Clients FAIL * " );
                this.takeScreenShot();
            }        
                 }
	  //Function Summary : Method to ClickOnClientsLink
		//Parameter Summary: N/A
		 public void ClickOnClientsLink() {
		   WebClickUsingJS(EdaatOR.Biller_Clients_link);
		    waitForPageToLoad();
		 }
		//Function Summary : Method to ClickOnImportClientsLink
		//Parameter Summary: N/A
		 public void ClickOnImportClientsLink() {
			WebClickUsingJS(EdaatOR.Biller_ImportClientsData_Link);
			waitForPageToLoad();
				
			}
		//Function Summary : Method to NavigateClientsImportClientsData
		//Parameter Summary: N/A
		public void NavigateClientsImportClientsData(Log Log) 
		{
				ClickOnClientsLink();
				ClickOnImportClientsLink();
				Log.ReportEvent("PASS", " Navigate to Import Clients Data");
				
		}
		//Function Summary : Method to SelectTypeofCustomer
		//Parameter Summary: TypeCorporate,TypeIndividual
		public void SelectTypeofCustomer(Map<Object, Object> testdatamap,Log Log) {
			try
			{
			WebClick(EdaatOR.Biller_Corporate_type_select);
			Thread.sleep(2000);
			VerifyValue1(getText(EdaatOR.Biller_Corporate_type_verify),testdatamap.get("TypeCorporate").toString());
			Thread.sleep(2000);
			this.takeScreenShot();
			WebClick(EdaatOR.Biller_Individual_type_select);
			Thread.sleep(2000);
			VerifyValue1(getText(EdaatOR.Biller_Individual_type_verify),testdatamap.get("TypeIndividual").toString());
			Thread.sleep(1000);
			this.takeScreenShot();
			test.log(Status.PASS,"#FUNC- Verify to select the type of the customer" + driver.getTitle() +" * select the type of the customer PASS * " );
        	Log.ReportEvent("PASS", " Verify to select the type of the customer is Suceessful");
			}
		catch(Exception e){
			test.log(Status.FAIL,"#FUNC- Verify to select the type of the customer" + driver.getTitle() +" * select the type of the customer FAIL * " );
			this.takeScreenShot();
			}
		}
		
		//Function Summary : Method to Import Clients Bulk Data
		//Parameter Summary:	
		public void ImportBulkData(Map<Object, Object> testdatamap,Log Log)
	    {
	    	try {
            
                UploadClientBulkData(testdatamap);
		        Thread.sleep(5000);
		        waitForPageToLoad();
		        Thread.sleep(3000);
		    	this.takeScreenShot();	
		    	
				test.log(Status.PASS,"#FUNC-Search ImportClientdata is successful" + driver.getTitle() +" * Clients PASS * " );	
				Log.ReportEvent("PASS", " Verify to Import Clients Bulk Data is Suceessful");
			}
			catch(Exception e){
				test.log(Status.FAIL,"#FUNC-Search ImportClientdata is Failed" + driver.getTitle() +" * Clients FAIL * " );
				this.takeScreenShot();
			}    	
	    }	
	//Function Summary : Method to Import Clients Bulk Data
	   //Parameter Summary:Customertype,Individual
		public void UploadClientBulkData(Map<Object, Object> testdatamap) throws IOException, InterruptedException
		{
			String client=testdatamap.get("Customertype").toString();
			if(client.equalsIgnoreCase("Individual")) {	
				
			WebClick(EdaatOR.Biller_IndivRdnBtn);
			Thread.sleep(1000);
			WebClickUsingActions(EdaatOR.Biller_import_AttachFile);
			Thread.sleep(3000);
			File classpathRoot = new File(System.getProperty("user.dir"));
	        File app = new File(classpathRoot.getAbsolutePath() + "//SeleniumGrid//attachment//UploadBulkData.exe");
	        String sFilename = app.toString();
	        Runtime.getRuntime().exec(sFilename);
	        System.out.println(sFilename);
	        Thread.sleep(3000);
	        WebClickUsingJS(EdaatOR.Biller_ClientProcessButton);
	        Thread.sleep(2000);
	        WebClickUsingJS(EdaatOR.Biller_ClientConfirmUploadButton);
	        Thread.sleep(10000);
	        SerachIndividualClient(testdatamap);
			}
			else if(client.equalsIgnoreCase("Corporate")){
				CorporateClientBulkData(testdatamap);
				Thread.sleep(3000);
				CorporateClientsearch(testdatamap);
			}
		}
		
		//Function Summary : Method to Import Corporate Clients Bulk Data
	   //Parameter Summary:N/A
		public void CorporateClientBulkData(Map<Object, Object> testdatamap) throws IOException, InterruptedException
		{
			WebClick(EdaatOR.Biller_CarpoRdnBtn);
			WebClickUsingJS(EdaatOR.Biller_import_AttachFile);
			Thread.sleep(2000);
			File classpathRoot = new File(System.getProperty("user.dir"));
	        File app = new File(classpathRoot.getAbsolutePath() + "//SeleniumGrid//attachment//UploadCorporateClientBulkData.exe");
	        String sFilename = app.toString();
	        Runtime.getRuntime().exec(sFilename);
	        System.out.println(sFilename);
	        Thread.sleep(2000);
	        WebClickUsingJS(EdaatOR.Biller_ClientProcessButton);
	        Thread.sleep(2000);
	        WebClickUsingJS(EdaatOR.Biller_ClientConfirmUploadButton);
		}

		//Function Summary : Method to Search Individual Clients
	   //Parameter Summary:ClientName,NationalD,CRNumber
		public void SerachIndividualClient(Map<Object, Object> testdatamap) throws InterruptedException, IOException
		{
			WebClickUsingJS(EdaatOR.Admin_Add_Individualclient);
			Thread.sleep(2000);
			WebEdit(EdaatOR.Biller_Individualclient_Cname,testdatamap.get("ClientName").toString());
			Thread.sleep(1000);
			WebEdit(EdaatOR.Biller_Individualclient_IdNumber,testdatamap.get("NationalD").toString());
			Thread.sleep(1000);
			WebEdit(EdaatOR.Biller_Individualclient_CustomerRefNumber,testdatamap.get("CRNumber").toString());
			Thread.sleep(1000);
			scrollDowntillend(driver);
			WebClickUsingJS(EdaatOR.Biller_Individualclient_Search);
			Thread.sleep(2000);
			this.takeScreenShot();
			VerifyValue1(getText("//td[text()='"+testdatamap.get("NationalD").toString()+"']"),testdatamap.get("NationalD").toString());
		}
	public void CorporateClientsearch(Map<Object, Object> testdatamap) throws InterruptedException, IOException
		{
			WebClickUsingJS(EdaatOR.Biller_Add_Companyclient);
        	Thread.sleep(2000);
        	WebEdit(EdaatOR.Biller_Corporateclient_Name,testdatamap.get("ClientName").toString());
			Thread.sleep(1000);
			WebEdit(EdaatOR.Biller_Corporateclient_Rno,testdatamap.get("CRNumber").toString());
			Thread.sleep(1000);
			WebEdit(EdaatOR.Biller_Corpoclient_CustomerRefNumber,testdatamap.get("ReferenceNumber").toString());
			Thread.sleep(1000);
        	WebClick(EdaatOR.Biller_Individualclient_Search);
        
			VerifyValue1(getText("//td[text()='"+testdatamap.get("CRNumber").toString()+"']"),testdatamap.get("CRNumber").toString());
		}

		//Function Summary : ImportClientData Page fields error validation
	   //Parameter Summary:ClientName,NationalD,CRNumber
	public void importClientdataErrormeaasgaeValidation(Map<Object,Object> testdatamap) {
		this.takeScreenShot();
		String Expected=testdatamap.get("ExpectedResult").toString();
		String ClientType = testdatamap.get("ClientType").toString();
		try {
			if(ClientType.equalsIgnoreCase("Individual")) {
				WebClick(EdaatOR.Biller_Individual_type_select);
				Thread.sleep(2000);
		        WebClickUsingJS(EdaatOR.Biller_ClientProcessButton);
				this.takeScreenShot();

		        if (ExistsCheck(EdaatOR.BillerImportClientdataError)) {
				VerifyValue(Expected,EdaatOR.BillerImportClientdataError);
				test.log(Status.PASS, "#FUNC-Attachfile ErrorMessage Exists" + driver.getTitle() + " * Attachfile ErrorMessage Exists * ");
		                }
		        else {

					test.log(Status.FAIL, "#FUNC-Element Not Exists" + driver.getTitle() + " * Element Not Exists * ");
		        }
		       }
			else if (ClientType.equalsIgnoreCase("Corporate") ) {
				this.takeScreenShot();
				WebClick(EdaatOR.Biller_Corporate_type_select);
				Thread.sleep(2000);
				WebClickUsingJS(EdaatOR.Biller_ClientProcessButton);
				if(ExistsCheck(EdaatOR.BillerImportClientdataError)) {
				VerifyValue(Expected,EdaatOR.BillerImportClientdataError);
				test.log(Status.PASS, "#FUNC-Attachfile ErrorMessage Exists" + driver.getTitle() + " *Attachfile ErrorMessage Exists * ");
				this.takeScreenShot();

				}
				else {

					test.log(Status.FAIL, "#FUNC-Element Not Exists" + driver.getTitle() + " * Element Not Exists * ");
		        }
			}
			
			else if (ClientType.equalsIgnoreCase("Individual1")){
					WebClick(EdaatOR.Biller_IndivRdnBtn);
					Thread.sleep(1000);
					WebClickUsingActions(EdaatOR.Biller_import_AttachFile);
					Thread.sleep(3000);
					File classpathRoot = new File(System.getProperty("user.dir"));
					File app = new File(classpathRoot.getAbsolutePath() + "//SeleniumGrid//attachment//ImageUpload.exe");
					String sFilename = app.toString();
					Runtime.getRuntime().exec(sFilename);
					System.out.println(sFilename);
					Thread.sleep(3000);
					WebClickUsingJS(EdaatOR.Biller_ClientProcessButton);
					Thread.sleep(2000);
					WebClickUsingJS(EdaatOR.Biller_ClientConfirmUploadButton);
					Thread.sleep(10000);
				if(ExistsCheck(EdaatOR.BillerImportClientdataError))
				{
					VerifyValue(Expected,EdaatOR.BillerImportClientdataError);
					test.log(Status.PASS, "#FUNC-Wrong upload ErrorMessage Exists" + driver.getTitle() + " *Wrong upload ErrorMessage Exists * ");
					this.takeScreenShot();
				}
				else
				{
					test.log(Status.FAIL, "#FUNC-Element Not Exists" + driver.getTitle() + " * Element Not Exists * ");

				}
			}
			else if(ClientType.equalsIgnoreCase("Corporate1")){
				WebClick(EdaatOR.Biller_CarpoRdnBtn);
				WebClickUsingJS(EdaatOR.Biller_import_AttachFile);
				Thread.sleep(2000);
				File classpathRoot = new File(System.getProperty("user.dir"));
		        File app = new File(classpathRoot.getAbsolutePath() + "//SeleniumGrid//attachment//ImageUpload.exe");
		        String sFilename = app.toString();
		        Runtime.getRuntime().exec(sFilename);
		        System.out.println(sFilename);
		        Thread.sleep(2000);
		        WebClickUsingJS(EdaatOR.Biller_ClientProcessButton);
		        Thread.sleep(2000);
		        WebClickUsingJS(EdaatOR.Biller_ClientConfirmUploadButton);
		        if(ExistsCheck(EdaatOR.BillerImportClientdataError))
				{
					VerifyValue(Expected,EdaatOR.BillerImportClientdataError);
					test.log(Status.PASS, "#FUNC-Wrong upload ErrorMessage Exists" + driver.getTitle() + " *Wrong upload ErrorMessage Exists * ");
					this.takeScreenShot();
				}
				else
				{
					test.log(Status.FAIL, "#FUNC-Element Not Exists" + driver.getTitle() + " * Element Not Exists * ");

				}
		
				}
				
			}
				
		
		catch (Exception e) {
			throw new NoSuchElementException("Biller Home Page - Not Loaded");
		}
	}

}



