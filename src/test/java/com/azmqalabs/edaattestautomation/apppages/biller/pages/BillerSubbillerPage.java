/**
* Test Script Name  				 : N/A
* Objective                          : Verify IndividualClient Functionality.
* Version      						 : 1.0
* Author       						 : Kathirvelu Mohan
* Created Date 			      		 : 15/08/2023
* Last Updated on					 : N/A
* Updated By   			 			 : Arun kumar M S
* Pre-Conditions					 : N/A
* Epic Details						 : N/A
* User Story Details				 : N/A
**/
package com.azmqalabs.edaattestautomation.apppages.biller.pages;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
import com.azmqalabs.edaattestautomation.common.uielement.fieldDecorator;
import com.azmqalabs.edaattestautomation.objectrepository.EdaatOR;
import com.azmqalabs.edaattestautomation.common.Log;


public class BillerSubbillerPage extends BasePage
{

	public BillerSubbillerPage(WebDriver driver,ExtentTest test)
	{
		 this.driver=driver;
		 this.test=test;
		 
		 PageFactory.initElements(new fieldDecorator(driver,test), this);
	}  
	

	@FindBy(xpath = EdaatOR.Biller_Client)
	public WebElement Client;
	private boolean existsElement;
		
	    
	    public boolean Exists(){
	    	return super.Exists(Client); 
		}
		
 	//Function Summary   : Method to activate and deactivate individual sub biller.	
	//Parameter Summary   : NationalID.	
	public void ActivateDeactivate(Map<Object,Object> testdatamap,Log Log){
	    try{
	    	WebClickUsingJS(EdaatOR.Biller_IndividualSubBillerPage);
	    	Thread.sleep(1000);	
	    	if(CheckElementExists(EdaatOR.Biller_IndividualToggle)==true) {
	    		WebEdit(EdaatOR.Biller_Individual_NationalID,testdatamap.get("NationalID").toString());        			
				Thread.sleep(2000);
	    		WebClickUsingJS(EdaatOR.Biller_Individual_searchBtn);
				Thread.sleep(2000);
				WebClickUsingJS(EdaatOR.Biller_IndividualToggle);
				Thread.sleep(2000);
				VerifyValue1(getText(EdaatOR.Biller_ConfirmationPopupMessage), testdatamap.get("Active").toString());
				Thread.sleep(2000);
				WebClick(EdaatOR.Biller_YesBtn);
				Thread.sleep(2000);
				WebClickUsingJS(EdaatOR.Biller_IndividualToggle);
				Thread.sleep(2000);
				VerifyValue1(getText(EdaatOR.Biller_ConfirmationPopupMessage), testdatamap.get("InActive").toString());				Thread.sleep(1000);
				WebClick(EdaatOR.Biller_YesBtn);
				this.takeScreenShot();
				test.log(Status.PASS,"#FUNC-Individual sub biller Deactivate/Activate Done" + driver.getTitle() +" * Individual sub biller Deactivate/Activate Done PASS * " );
				Log.ReportEvent("PASS", " Verify Activate Deactivate Individual Sub biller is Suceessful");
	    	}
	    	else {
	    		test.log(Status.FAIL,"#FUNC-Individual sub biller Deactivate/Activate Not Done" + driver.getTitle() +" * Individual sub biller Deactivate/Activate Not Done FAIL  * " );
	    }
	    }
	    	catch(Exception e){
	    	test.log(Status.FAIL," #FUNC-Individual sub biller Deactivate/Activate Not Done " + driver.getTitle() +" * Individual sub biller Deactivate/Activate Not Done FAIL * " );
	        this.takeScreenShot();
	    }
	}
	    //Function Summary : Method to add Individual Subbiller. 
		//Parameter Summary: BillerName,National ID,IBanNumber,BeneficaryName,FixedValueAmount,Percentage Value,MobileNumber,Email.
	    public boolean AddSubBiller(Map<Object, Object> testdatamap,Log Log){
		//	boolean existsElement = false;
			try{
				WebClickUsingJS(EdaatOR.Biller_Sub_Individualclient);
	        	Thread.sleep(2000);
	        	WebClickUsingJS(EdaatOR.Biller_Sub_IndividualsubBiller);
	        	Thread.sleep(2000);
				WebClick(EdaatOR.Biller_AddSubBilleer);
				Thread.sleep(3000);
				WebEdit(EdaatOR.Biller_SubBillerName,testdatamap.get("BillerName").toString());
				Thread.sleep(3000);
				WebEdit(EdaatOR.Biller_Subbiller_NId,testdatamap.get("National ID").toString());
				Thread.sleep(3000);
				WebEdit(EdaatOR.Biller_SubBiller_IBAN,testdatamap.get("IBanNumber").toString());
				Thread.sleep(3000);
				WebEdit(EdaatOR.Biller_SubBiller_Benificary,testdatamap.get("BeneficaryName").toString());
				Thread.sleep(3000);
				EnterBillerIBANAttmnt();
				Thread.sleep(3000);
				WebClickUsingJS(EdaatOR.Biller_SubBiller_Invoice_Total_AMT_ChkBox);
				Thread.sleep(3000);
				WebClickUsingJS(EdaatOR.Biller_SubBiller_FixedValue_ChkBox);
				Thread.sleep(3000);
				WebEdit(EdaatOR.Biller_SubBiller_FixedValue_Amt,testdatamap.get("FixedValueAmount").toString());
				WebClickUsingJS(EdaatOR.Biller_SubBiller_Percentage_ChkBox);
				Thread.sleep(3000);
				WebEdit(EdaatOR.Biller_SubBiller_Percentage_Val,testdatamap.get("Percentage Value").toString());
				Thread.sleep(3000);
				WebClickUsingJS(EdaatOR.Biller_SubBiller_Trans_Fee_Deduct_ChxBox);
				Thread.sleep(3000);
				WebEdit(EdaatOR.Biller_SubBiller_MOB,testdatamap.get("MobileNumber").toString());
				Thread.sleep(3000);
				WebEdit(EdaatOR.Biller_SubBiller_Email,testdatamap.get("Email").toString());
				Thread.sleep(3000);
				WebClick(EdaatOR.Biller_SubBillerAddButton);
				Thread.sleep(3000);

	           	
	        }catch(Exception e){
	       test.log(Status.FAIL,"#FUNC-Add Individual client" + driver.getTitle() +" * Add Individual client PASS * " );
	            this.takeScreenShot();
	        }
	        return existsElement;
	    }			

	    //Function Summary : Method to Edit the Subbiller. 
		//Parameter Summary: BillerName,National ID.
	
	public boolean SubbillerSearch(Map<Object, Object> testdatamap,Log Log){
	//	boolean existsElement = false;
		try{
			    AddSubBiller(testdatamap,Log);			    
	        	WebEdit(EdaatOR.Biller_Individualclient_Name,testdatamap.get("BillerName").toString());
				Thread.sleep(2000);
				WebEdit(EdaatOR.Biller_Subbiller_NId,testdatamap.get("National ID").toString());
				Thread.sleep(2000);
				WebClickUsingJS(EdaatOR.Biller_Subbiller_Search);
				this.takeScreenShot();
            	existsElement=ExistsCheck("//td[text()='+National ID+']");
				Thread.sleep(2000);
				Log.ReportEvent("PASS", " Verify SubBiller Search");
				
           	
				
        }catch(Exception e){
//       test.log(Status.FAIL,"#FUNC-Add Individual client" + driver.getTitle() +" * Add Individual client PASS * " );
            this.takeScreenShot();
        }
        return existsElement;
    }
	
	  //Function Summary : Method to Edit the Subbiller. 
	//Parameter Summary: FixedValueAmount,Percentage Value.

	public boolean EditSubBiller(Map<Object, Object> testdatamap,Log Log){
		boolean existsElement = false;
		try{
			    SubbillerSearch(testdatamap,Log);
			    Thread.sleep(2000);		
				WebClick(EdaatOR.Biller_SubBiller_Edit);
				Thread.sleep(2000);			
				//WebClickUsingJS(EdaatOR.Biller_SubBiller_Invoice_Total_AMT_ChkBox);
				//Thread.sleep(2000);
				//WebClickUsingJS(EdaatOR.Biller_SubBiller_FixedValue_ChkBox);
				//Thread.sleep(2000);
				WebEdit(EdaatOR.Biller_SubBiller_FixedValue_Amt,testdatamap.get("FixedValueAmount").toString());
				//WebClickUsingJS(EdaatOR.Biller_SubBiller_Percentage_ChkBox);
				//Thread.sleep(3000);
				WebEdit(EdaatOR.Biller_SubBiller_Percentage_Val,testdatamap.get("Percentage Value").toString());
				WebClickUsingJS(EdaatOR.Biller_SubBiller_Trans_Fee_Deduct_ChxBox);
				Thread.sleep(2000);
				this.takeScreenShot();
				WebClick(EdaatOR.Biller_SubBiller_Save);
				Thread.sleep(2000);
			 	Log.ReportEvent("PASS", " Verify SubBiller Edit");

        }catch(Exception e){
     test.log(Status.FAIL,"#FUNC-Add Individual client" + driver.getTitle() +" * Add Individual client PASS * " );
            this.takeScreenShot();
        }
        return existsElement;
	}
	public void EnterBillerIBANAttmnt() throws Exception {
		WebClickUsingActions(EdaatOR.Biller_IBANAttmnt_eField);
		getAutoItImagePathFile();

	}
			
	  //Function Summary : Method to Verify Individual Subbiller. 
		//Parameter Summary: BillerName.

	public void VerifyIndividualClient(Map<Object, Object> testdatamap,Log Log) throws IOException {
		// TODO Auto-generated method stub
		SubbillerSearch(testdatamap,Log);
		VerifyValue1(getText("//td/a[contains(text(),'"+testdatamap.get("BillerName").toString()+"')]"),testdatamap.get("BillerName").toString());
		
	}
	public void ClickOnCorporateSubBiller() {
		WebClickUsingJS(EdaatOR.Biller_subbiller);
		waitForPageToLoad();
	}


	public void ClickOnSubbiller() {
		WebClickUsingJS(EdaatOR.Biller_subbiller_Corp);
		waitForPageToLoad();
	}
	public void NavigateCorporateSubBiller(Log Log){
		ClickOnSubbiller();
		ClickOnCorporateSubBiller();
	 	Log.ReportEvent("PASS", " Verify Corporate Subbiller page is dispayed Suceessfull");
	}
	public void ClickOnAddSubbiller() throws InterruptedException
	{
		WebClick(EdaatOR.Biller_subbiller_Corpaddbtn);
		Thread.sleep(1000);
	}
	public void EnterGeneralinfo(Map<Object, Object> testdatamap) throws InterruptedException, IOException
	{
		WebEdit(EdaatOR.Biller_subbiller_Corpname, testdatamap.get("BillerName").toString());
		Thread.sleep(2000);
		WebEdit(EdaatOR.Biller_subbiller_Corpcrnum, testdatamap.get("CRNumber").toString());
		Thread.sleep(2000);
        EnterCRattach();
        Thread.sleep(2000);
        EnterIBANImg();
		WebEdit(EdaatOR.Biller_subbiller_Corpiban, testdatamap.get("IBANNumber").toString());
		Thread.sleep(2000);
		WebEdit(EdaatOR.Biller_subbiller_Corpbenfname, testdatamap.get("BeneficiaryName").toString());
		Thread.sleep(2000);
		WebEdit(EdaatOR.Biller_subbiller_Corptaxnum, testdatamap.get("Taxnumber").toString());
		this.takeScreenShot();
	}
	public void EnterIBANImg() throws InterruptedException, IOException
	{
		WebClickUsingActions(EdaatOR.Biller_subbiller_Ibanclick);
		getAutoITFile();
		this.takeScreenShot();
	}
	public void getAutoITFile() throws InterruptedException, IOException
	{
		File classpathRoot = new File(System.getProperty("user.dir"));
		Thread.sleep(2000);
		File app = new File(classpathRoot.getAbsolutePath() + "//SeleniumGrid//attachment//ImageUpload.exe");
		String sFilename = app.toString();
		Thread.sleep(2000);
		Runtime.getRuntime().exec(sFilename);
		Thread.sleep(2000);
	}
	public void EnterCRattach() throws InterruptedException, IOException {
		WebClickUsingActions(EdaatOR.Biller_subbiller_crattach);
		getAutoITFile();
	}
	public void EnterOperationalFeesInfo(Map<Object, Object> testdatamap) throws InterruptedException
	{
		WebClick(EdaatOR.Biller_subbiller_Corpfees);
		Thread.sleep(1000);
		WebClick(EdaatOR.Biller_subbiller_Corpfixedvalue);
		Thread.sleep(1000);
		WebClearandEdit(EdaatOR.Biller_subbiller_Corpfixedefield,testdatamap.get("FixedValue").toString());
		WebClick(EdaatOR.Biller_subbiller_Corpperc);
		Thread.sleep(1000);
		WebClearandEdit(EdaatOR.Biller_subbiller_Corpperefield,testdatamap.get("Percentage").toString());
		scrollDowntillend(driver);
		this.takeScreenShot();
	}
	public void EnterNationalAddressinfo(Map<Object, Object> testdatamap) throws InterruptedException {
		
		WebClick(EdaatOR.Biller_subbiller_corpcity);
		Thread.sleep(1000);
		WebClickUsingActions("//li[text()='"+testdatamap.get("City").toString()+"']");
		Thread.sleep(2000);
		WebEdit(EdaatOR.Biller_subbiller_Corpdistname,testdatamap.get("DistrictName").toString());
		Thread.sleep(2000);
		WebEdit(EdaatOR.Biller_subbiller_Corpstreetefield,testdatamap.get("StreetName").toString());
		Thread.sleep(2000);
		WebEdit(EdaatOR.Biller_subbiller_Corpzipcode,testdatamap.get("ZipCode").toString());
		Thread.sleep(2000);
		WebEdit(EdaatOR.Biller_subbiller_Corpbuildno,testdatamap.get("BuildingNo").toString());
		this.takeScreenShot();
		driver.findElement(By.xpath(EdaatOR.Biller_SubBillerAddButton)).sendKeys(Keys.PAGE_DOWN);
	}
	public void EnterContactInfo(Map<Object, Object> testdatamap) throws InterruptedException {
		WebEdit(EdaatOR.Biller_subbiller_Corpempname,testdatamap.get("EmployeeName").toString());
		Thread.sleep(1000);
		WebEdit(EdaatOR.Biller_subbiller_Corpempemail,testdatamap.get("EmployeeEmail").toString());
		Thread.sleep(1000);
		WebEdit(EdaatOR.Biller_subbiller_Corpempmobile,testdatamap.get("EmployeeMobileNumber").toString());
		Thread.sleep(1000);
		this.takeScreenShot();
		
	}
	public void ClickOnAddBtn() {
		
		WebClick(EdaatOR.Biller_subbiller_Corpadd);
		
	}
	  //Function Summary:Method to search subbiller.
	  //Function Parameters:BillerName.
	public void EnterSearchitem(Map<Object, Object> testdatamap) throws InterruptedException {
		
		WebEdit(EdaatOR.Biller_subbiller_srch,testdatamap.get("BillerName").toString());
		Thread.sleep(1000);
		WebEdit(EdaatOR.Biller_subbiller_crsrch,testdatamap.get("CRNumber").toString());
		Thread.sleep(1000);
		WebClick(EdaatOR.Biller_subbiller_srcclick);
		
	}
	  //Function Summary:Method to add Corporate subbiller.
	  //Function Parameters:BillerName.
	public void AddCorporateSubBiller(Map<Object, Object> testdatamap,Log Log) throws InterruptedException
	{
		ClickOnAddSubbiller();
		try
		{
		if(CheckElementExists(EdaatOR.Biller_subbiller_Corpverify)==true)
		{
		   EnterGeneralinfo(testdatamap);
//		   EnterIBANImg();
//		   EnterCRattach();
		   EnterOperationalFeesInfo(testdatamap);
		   EnterNationalAddressinfo(testdatamap);
		   EnterContactInfo(testdatamap);
		   ClickOnAddBtn();
		   EnterSearchitem(testdatamap);
		   VerifyValue1(getText("//table[@id='tblSubBillers']//a[contains(text(),'"+testdatamap.get("BillerName").toString()+"')]"), testdatamap.get("BillerName").toString());
		   VerifyValue1(getText("//a[contains(text(),'"+testdatamap.get("BillerName").toString()+"')]/../..//td[2]"),testdatamap.get("CRNumber").toString());
		   VerifyValue1(getText("//a[contains(text(),'"+testdatamap.get("BillerName").toString()+"')]/../..//td[6]"),testdatamap.get("Status").toString());
		   this.takeScreenShot();
		   test.log(Status.PASS,"#FUNC-Add Corporate SubBiller" + driver.getTitle() +" * Add Corporate SubBiller PASS * " );
		   Log.ReportEvent("PASS", " Verify Add Corporate Subbiller functionality is Suceessfull");
		}
		else
		{
			test.log(Status.FAIL,"#FUNC-Add Corporate SubBiller" + driver.getTitle() +" * Add Corporate SubBiller FAIL * " );
		}
		}
		catch (Exception e) {
			test.log(Status.FAIL,"#FUNC-Add Corporate SubBiller" + driver.getTitle() +" * Add Corporate SubBiller FAIL * " );
		}
	}

	
 	//Function Summary   : Method to view table	
	//Parameter Summary   : BillerName.	
	public void TableGridview(Map<Object,Object> testdatamap,Log Log){
	    try{
	    	String BillerName=testdatamap.get("BillerName").toString();
	    	WebClickUsingJS(EdaatOR.Biller_CorporateSubBillerPage);
	    	Thread.sleep(2000);	    
	    	if(CheckElementExists(EdaatOR.Biller_CorporateSubBillerGrid)==true) {
    			Thread.sleep(2000);
    			WebClear(EdaatOR.Biller_CorporateSubBiller_BillerName);
    			Thread.sleep(2000);
    			WebEdit(EdaatOR.Biller_CorporateSubBiller_BillerName, BillerName); 
    			Thread.sleep(2000);
    			WebClick(EdaatOR.Biller_CorporateSubBiller_searchBtn);
    			Thread.sleep(2000);
    			WebClick("//a[contains(text(),'"+BillerName+"')]");
    			Thread.sleep(2000);
    			switchTonextwindow();
    			scrollDowntillend(driver);
    			this.takeScreenShot();
    			WebClick(EdaatOR.Biller_CorporateSubBiller_Back);
    			test.log(Status.PASS,"#FUNC-Corporate SubBiller Table Exists" + driver.getTitle() +" * Corporate SubBiller Table Exists PASS * " );
    			Log.ReportEvent("PASS", " Verify Table view Corporate sub biller is Suceessfull");
	    		}
	    	else {
	    		test.log(Status.FAIL,"#FUNC-Corporate SubBiller Table Not Exists" + driver.getTitle() +" *Corporate SubBiller Table Not Exists FAIL * " );
	    	}
	    }catch(Exception e){
	    	test.log(Status.FAIL,"#FUNC-Table View Corporate SubBiller" + driver.getTitle() +" * Table View Corporate SubBiller FAIL * " );
	        this.takeScreenShot();
	    }
}
 //Function Summary:Verify sub biller Individual Grid View details
	  //Function Parameters:N/A.
	  	    public void SubBillerIndividualGridView(String view,String table,Log Log)
	  		{
	  			try {

	  				boolean Ele = GridViewtable(view,table);
	  				if (Ele == true)
	  				{
	  					test.log(Status.PASS,"#FUNC-Grid View" + driver.getTitle() + " * Grid View PASS * ");
	  				    Log.ReportEvent("PASS", " Verify Grid details view is Loaded Suceessfully");
	  				}
	  				else {
	  					test.log(Status.FAIL,"#FUNC-Grid View" + driver.getTitle() + " * Grid View FAIL * ");
	  				}
	  			} catch (Exception e) {
	  				test.log(Status.FAIL, "#FUNC-Grid View" + driver.getTitle() + " * Grid View FAIL * ");
	  				this.takeScreenShot();
	  			}
	  		}
	  	//Function Summary:Verify sub biller Individual Grid View details
	  	//Function Parameters:N/A.
	  		public boolean GridViewtable(String view,String table) {
	  			boolean existsNID = false;
	  			try {
	  				WebClickUsingJS(EdaatOR.Biller_subBiller);
	  				Thread.sleep(2000);
	  				WebClickUsingJS(view);
	  				Thread.sleep(2000);
	  				this.takeScreenShot();
	  				if (ExistsCheck(table) == true) {
	  					existsNID = true;
	  				}
	  				existsNID = true;
	  			}

	  			catch (Exception e) {
	  				e.printStackTrace();
	  				this.takeScreenShot();
	  			}
	  			return existsNID;
	  		}
	  		
	  //Function Summary:Verify sub biller Individual Grid View details
	  //Function Parameters:N/A.
	  		public void SubBillerIndividual(Map<Object, Object> testdatamap,Log Log) throws Exception
	  		{
	  			WebClickUsingJS(EdaatOR.Biller_subBiller_individual_link);
	  			addSubBiller(testdatamap);
	  			SearchBiller(testdatamap, Log);
	  		}
	  		
	  //Function Summary:Search sub biller 
	  //Function Parameters:SubBillerName and NationalID.
	  		public void SearchBiller(Map<Object, Object> testdatamap,Log Log)
	  		{
	  		    try {
	  			        WebClear(EdaatOR.Biller_AddsubBiller_SeaName);
	  			        WebEdit(EdaatOR.Biller_AddsubBiller_SeaName,testdatamap.get("SubBillerName").toString());
	  			        Thread.sleep(2000);
	  			        WebClear(EdaatOR.Biller_AddsubBiller_SeaNation);
	  			        WebEdit(EdaatOR.Biller_AddsubBiller_SeaNation,testdatamap.get("NationalID").toString());
	  		         	Thread.sleep(2000);
	  			        WebClickUsingJS(EdaatOR.Biller_AddsubBiller_Search);
	  			        Thread.sleep(2000);
	  		        	VerifyValue1(getText(EdaatOR.Biller_AddsubBiller_verify), testdatamap.get("NationalID").toString());
	  			        this.takeScreenShot();
	  			        test.log(Status.PASS,"#FUNC-SearchBiller" + driver.getTitle() +" * SearchBiller PASS* " );
	  		        	Log.ReportEvent("PASS", " Verify to add sub Biller with Fees Deduction Based on Product is successfull");
	  		        
	  		       }
	  		   catch(Exception e){
	  		    	test.log(Status.FAIL,"#FUNC-SearchBiller" + driver.getTitle() +" * SearchBillerFAIL * " );
	  		            this.takeScreenShot();
	  		        	}

	  		}
	  		
	  //Function Summary:To add product.
	  //Function Parameters:Product,Fixed Value,Percentage,IBAN and Beneficiary Name.
	  		public void addproduct(Map<Object, Object> testdatamap) throws Exception
	  		{
	  		 try {	   
	  			WebClickUsingJS(EdaatOR.Biller_AddsubBiller_addprod);
	  			WebSelect(EdaatOR.Biller_AddsubBiller_prodname,testdatamap.get("Product").toString());
	  			Thread.sleep(2000);
	  			WebClear(EdaatOR.Biller_AddsubBiller_fixed);
	  			WebEdit(EdaatOR.Biller_AddsubBiller_fixed,testdatamap.get("Fixed Value").toString());
	  			Thread.sleep(2000);
	  			WebClear(EdaatOR.Biller_AddsubBiller_per);
	  			WebEdit(EdaatOR.Biller_AddsubBiller_per,testdatamap.get("Percentage").toString());
	  			Thread.sleep(2000);
	  			WebClear(EdaatOR.Biller_AddsubBiller_prodiban);
	  			WebEdit(EdaatOR.Biller_AddsubBiller_prodiban,testdatamap.get("IBAN").toString());
	  			Thread.sleep(2000);
	  			WebClear(EdaatOR.Biller_AddsubBiller_prodbene);
	  			WebEdit(EdaatOR.Biller_AddsubBiller_prodbene,testdatamap.get("Beneficiary Name").toString());
	  			Thread.sleep(2000);
	  			EnterIbanAttachment();
	  			Thread.sleep(2000);
	  			WebClickUsingJS(EdaatOR.Biller_AddsubBiller_prodaddbt);
	  			Thread.sleep(2000);
	  			this.takeScreenShot();
	  			test.log(Status.PASS,"#FUNC-addproduct" + driver.getTitle() +" * addproduct PASS* " );
	  		   }
	  		   catch(Exception e){
	  		    	test.log(Status.FAIL,"#FUNC-addproduct" + driver.getTitle() +" * addproduct FAIL * " );
	  		            this.takeScreenShot();
	  		        	}

	  		}
	  		public void EnterIbanAttach() throws Exception {
	  			WebClickUsingActions(EdaatOR.Biller_AddsubBiller_Iban);
	  			getAutoItImagePathFile();
	  		}
	  		public void EnterIbanAttachment() throws Exception {
	  				WebClickUsingActions(EdaatOR.Biller_AddsubBiller_prodatch);
	  				getAutoItImagePathFile();
	  			}
	  		public void  getAutoItImagePathFile() throws Exception {
	  				File classpathRoot = new File(System.getProperty("user.dir"));
	  				Thread.sleep(1000);
	  				File app = new File(classpathRoot.getAbsolutePath() + "//SeleniumGrid//attachment//ImageUpload.exe");
	  				String sFilename = app.toString();
	  				Thread.sleep(1000);
	  				Runtime.getRuntime().exec(sFilename);
	  				Thread.sleep(800);
	  			}

	  //Function Summary:To Add sub biller 
	  //Function Parameters:SubBillerName,IBAN Number,Beneficiary,Mobile,Emails and NationalID.
	  	public void addSubBiller(Map<Object, Object> testdatamap) throws Exception 
	  	{
	  	 try {
	  			WebClickUsingJS(EdaatOR.Biller_AddsubBiller_btn);
	  			WebClear(EdaatOR.Biller_AddsubBiller_name);
	  			WebEdit(EdaatOR.Biller_AddsubBiller_name,testdatamap.get("SubBillerName").toString());
	  			Thread.sleep(2000);
	  			WebClear(EdaatOR.Biller_AddsubBiller_National);
	  			WebEdit(EdaatOR.Biller_AddsubBiller_National,testdatamap.get("NationalID").toString());
	  			Thread.sleep(2000);
	  			WebClear(EdaatOR.Biller_AddsubBiller_IBAN);
	  			WebEdit(EdaatOR.Biller_AddsubBiller_IBAN,testdatamap.get("IBAN Number").toString());
	  			Thread.sleep(2000);
	  			WebClear(EdaatOR.Biller_AddsubBiller_Beneficiary);
	  			WebEdit(EdaatOR.Biller_AddsubBiller_Beneficiary,testdatamap.get("Beneficiary").toString());
	  			Thread.sleep(2000);
	  			EnterIbanAttach();
	              WebClickUsingJS(EdaatOR.Biller_AddsubBiller_Fees);
	  			Thread.sleep(2000);
	  			addproduct(testdatamap);
	  			WebClear(EdaatOR.Biller_AddsubBiller_mbl);
	  			WebEdit(EdaatOR.Biller_AddsubBiller_mbl,testdatamap.get("Mobile").toString());
	  			Thread.sleep(2000);
	  			WebClear(EdaatOR.Biller_AddsubBiller_Email);
	  			WebEdit(EdaatOR.Biller_AddsubBiller_Email,testdatamap.get("Email").toString());
	  			Thread.sleep(2000);
	  			WebClickUsingJS(EdaatOR.Biller_AddsubBiller_check);
	  			Thread.sleep(2000);
	              WebClickUsingJS(EdaatOR.Biller_AddsubBiller_addbtn);  
	      		test.log(Status.PASS,"#FUNC-addbiller" + driver.getTitle() +" * Create Individual Client Invoice Pass * " );
	              this.takeScreenShot();
	  		}
	  		catch(Exception e){
	  		test.log(Status.FAIL,"#FUNC-addbiller" + driver.getTitle() +" * Create Individual Client Invoice FAIL * " );
	  		this.takeScreenShot();
	  		}
	  }
	    //Function Summary: Method to verify Individual subbiller search
		  //Function Parameters:BillerName,National ID.
		public void IndividualSearch(Map<Object, Object> testdatamap,Log Log) {
			// TODO Auto-generated method stub
			try{
				  
		    	WebEdit(EdaatOR.Biller_Individualclient_Name,testdatamap.get("BillerName").toString());
				Thread.sleep(2000);
				WebEdit(EdaatOR.Biller_Subbiller_NId,testdatamap.get("National ID").toString());
				Thread.sleep(2000);
				WebClickUsingJS(EdaatOR.Biller_Subbiller_Search);
				this.takeScreenShot();
		    	existsElement=ExistsCheck("//td[text()='+National ID+']");
				Thread.sleep(2000); 
				Log.ReportEvent("PASS", " Verify to view individual subbiller is Suceessfull");
				
		}catch(Exception e){
		//test.log(Status.FAIL,"#FUNC-Add Individual client" + driver.getTitle() +" * Add Individual client PASS * " );
		    this.takeScreenShot();
	}	}
	    public void corporatesubbillersearch(Map<Object, Object> testdatamap) throws InterruptedException {
          WebEdit(EdaatOR.Biller_subbiller_srch,testdatamap.get("BillerName").toString());
          Thread.sleep(2000);
          WebEdit(EdaatOR.Biller_subbiller_crsrch,testdatamap.get("CRNumber").toString());
          Thread.sleep(2000);
          WebClick(EdaatOR.Biller_subbiller_srcclick);
          Thread.sleep(2000);
          this.takeScreenShot();
        }
		//Function Summary: Method to Add sub biller and search added sub biller.

        //Function Parameters: BillerName

        public void CorporateSubBillerSearch(Map<Object, Object> testdatamap,Log Log) throws InterruptedException {           

            try
            {
                corporatesubbillersearch(testdatamap);
                if (CheckElementExists(EdaatOR.Biller_subbiller_Nodata)==true) {
                    ClickOnAddSubbiller();
                    Thread.sleep(1000);
                    EnterGeneralinfo(testdatamap);                    
                    EnterOperationalFeesInfo(testdatamap);
                    EnterNationalAddressinfo(testdatamap);
                    EnterContactInfo(testdatamap);
                    ClickOnAddBtn();
                    Thread.sleep(2000);
                    corporatesubbillersearch(testdatamap); 

                }

                  verifyElementIsPresent("//a[contains(text(),'"+    testdatamap.get("BillerName").toString()+"')]");

                  test.log(Status.PASS,"#FUNC-Corporate SubBiller Search" + driver.getTitle() +" * Corporate SubBiller Search PASS * " );
                  Log.ReportEvent("PASS", " Verify Corporate Subbiller Search functionality is Suceessfull");
            }

            catch (Exception e) {

                test.log(Status.FAIL,"#FUNC-Corporate SubBiller Search" + driver.getTitle() +" * Corporate SubBiller Search FAIL * " );

            }

        }
        
	    //Function Summary: Method to Add sub biller Product details. 
		//Function Parameters: ProductPercentage,ProductIBANNumber,ProductIBANNumber
		public void addProductDetails(Map<Object,Object> testdatamap) throws Exception {
			SelectProduct(testdatamap);
			WebClear(EdaatOR.Biller_AddsubBiller_ProductPer);
  			WebEdit(EdaatOR.Biller_AddsubBiller_ProductPer,testdatamap.get("ProductPercentage").toString());
  			Thread.sleep(1000);
			WebEdit(EdaatOR.Billersubbiller_productIBAN, testdatamap.get("ProductIBANNumber").toString());
			WebEdit(EdaatOR.Billersubbiller_product_BenName, testdatamap.get("ProductIBANNumber").toString());
			EnterProductCRattach();
			Thread.sleep(2000);
			ClickOnProductAddBtn();
			Thread.sleep(2000);
		}
		
		//Function Summary : Method to click on "Transfer Fees Deduction from Sub Biller Share"checkbox .  
		//Parameter Summary: N/A
		private void transferCheckbox() throws InterruptedException {
			WebClick(EdaatOR.Biller_Subbiller_transferfrmsubiller);
			Thread.sleep(2000);
		}
		//Function Summary : Method to select "product" from dropdown.  
		//Parameter Summary: N/A
		public void SelectProduct(Map<Object,Object> testdatamap) { 
			WebSelect(EdaatOR.Biller_subbiller_corpaddProduct_ProductID,testdatamap.get("ProductName").toString());
			waitForPageToLoad();
		}
		//Function Summary : Method to click on "add" button in "add product"popup.  
		//Parameter Summary: N/A
		public void ClickOnProductAddBtn() {
			WebClick(EdaatOR.Biller_Subbiller_ProductAddBtn);
			waitForPageToLoad();
		}
		
		public void EnterProductCRattach() throws InterruptedException, IOException {
			WebClickUsingActions(EdaatOR.Biller_subbiller_Productcrattach);
			getAutoITFile();
		}
		//Function Summary: Method to enter "Fees deduction based on Product" details. 
	    //Function Parameters: BillerName,CRNumber,Status
		private void EnterFeesDeductionBasedonProduct(Map<Object, Object> testdatamap) throws InterruptedException {
			WebClick(EdaatOR.Biller_subbiller_Product);
			Thread.sleep(800);
			WebClick(EdaatOR.Biller_subbiller_corpaddProduct);
			Thread.sleep(800);
			scrollDowntillend(driver);
			this.takeScreenShot();
		}
		  //Function Summary: Method to Add sub biller Based on Product. 
		  //Function Parameters: BillerName,CRNumber,Status
		public void AddCorporateSubBillerwithProduct(Map<Object, Object> testdatamap,Log Log) throws InterruptedException {
			ClickOnAddSubbiller();
			try {
			if(CheckElementExists(EdaatOR.Biller_subbiller_Corpverify)==true)
			{
			   EnterGeneralinfo(testdatamap);
			   EnterFeesDeductionBasedonProduct(testdatamap);
			   addProductDetails(testdatamap);
			   transferCheckbox();
			   EnterNationalAddressinfo(testdatamap);
			   EnterContactInfo(testdatamap);
			   ClickOnAddBtn();
			   EnterSearchitem(testdatamap);
			   VerifyValue1(getText("//table[@id='tblSubBillers']//a[contains(text(),'"+testdatamap.get("BillerName").toString()+"')]"), testdatamap.get("BillerName").toString());
			   VerifyValue1(getText("//a[contains(text(),'"+testdatamap.get("BillerName").toString()+"')]/parent::td/following-sibling::td[1]"),testdatamap.get("CRNumber").toString());
			   VerifyValue1(getText("//a[contains(text(),'"+testdatamap.get("BillerName").toString()+"')]/parent::td/following-sibling::td[5]"),testdatamap.get("Status").toString());
			   this.takeScreenShot();
			   test.log(Status.PASS,"#FUNC-Add Corporate SubBiller Based on Product" + driver.getTitle() +" *Add Corporate SubBiller Based on Product PASS * " );
				Log.ReportEvent("PASS", " Verify Add Corporate Subbiller functionality is Suceessfull");
			}
			else
			{
				test.log(Status.FAIL,"#FUNC-Add Corporate SubBiller Based on Product" + driver.getTitle() +" * Add Corporate SubBiller Based on Product FAIL * " );
			}
			}
			catch (Exception e) {
				test.log(Status.FAIL,"#FUNC-Add Corporate SubBiller Based on Product" + driver.getTitle() +" * Add Corporate SubBiller Based on Product * " );
			}
		}
		 //Function Summary:Verify sub biller Individual Grid View details
		  //Function Parameters:N/A.
		  		public void SubBillerIndividualUi(Map<Object, Object> testdatamap) throws Exception
		  		{
		  			WebClickUsingJS(EdaatOR.Biller_subBiller_individual_link);
		  			addSubBillerUi(testdatamap);
		  		
		  		}
		  		 //Function Summary:To Add sub biller 
		  	  //Function Parameters:SubBillerName,IBAN Number,Beneficiary,Mobile,Emails and NationalID.
		  	  	public void addSubBillerUi(Map<Object, Object> testdatamap) throws Exception 
		  	  	{
		  	  	 try {
		  	  			WebClickUsingJS(EdaatOR.Biller_AddsubBiller_btn);
		  	  			WebClear(EdaatOR.Biller_AddsubBiller_name);
		  	  			WebEdit(EdaatOR.Biller_AddsubBiller_name,testdatamap.get("SubBillerName").toString());
		  	  			Thread.sleep(2000);
		  	  			WebClear(EdaatOR.Biller_AddsubBiller_National);
		  	  			WebEdit(EdaatOR.Biller_AddsubBiller_National,testdatamap.get("NationalID").toString());
		  	  			Thread.sleep(2000);
		  	  			WebClear(EdaatOR.Biller_AddsubBiller_IBAN);
		  	  			WebEdit(EdaatOR.Biller_AddsubBiller_IBAN,testdatamap.get("IBAN Number").toString());
		  	  			Thread.sleep(2000);
		  	  			WebClear(EdaatOR.Biller_AddsubBiller_Beneficiary);
		  	  			WebEdit(EdaatOR.Biller_AddsubBiller_Beneficiary,testdatamap.get("Beneficiary").toString());
		  	  			Thread.sleep(2000);
		  	  			EnterIbanAttach();
		  	  		    WebClear(EdaatOR.Biller_AddsubBiller_mbl);
	  	  			    WebEdit(EdaatOR.Biller_AddsubBiller_mbl,testdatamap.get("Mobile").toString());
	  	  			    Thread.sleep(2000);
		  	            WebClickUsingJS(EdaatOR.Biller_AddsubBiller_Fees);
		  	  			Thread.sleep(2000);
		  	  		    addproductUi(testdatamap);		  	  			
		  	  			//WebClear(EdaatOR.Biller_AddsubBiller_Email);
		  	  			//WebEdit(EdaatOR.Biller_AddsubBiller_Email,testdatamap.get("Email").toString());
		  	  			//Thread.sleep(2000);
		  	  			WebClickUsingJS(EdaatOR.Biller_AddsubBiller_check);
		  	  			Thread.sleep(2000);
		  	            WebClickUsingJS(EdaatOR.Biller_AddsubBiller_addbtn); 
		  	          Thread.sleep(2000);
		  	          // driver.findElement(By.xpath(EdaatOR.Biller_AddsubBiller_National)).sendKeys(Keys.PAGE_DOWN);
		  	            IndividualSubbillerErrormeaasgaeValidation(testdatamap);   
		  	      		test.log(Status.PASS,"#FUNC-addbiller" + driver.getTitle() +" * Create Individual Client Invoice Pass * " );
		  	              this.takeScreenShot();
		  	  		}
		  	  		catch(Exception e){
		  	  		test.log(Status.FAIL,"#FUNC-addbiller" + driver.getTitle() +" * Create Individual Client Invoice FAIL * " );
		  	  		this.takeScreenShot();
		  	  		}
		  	  }
		  	  public void IndividualSubbillerErrormeaasgaeValidation(Map<Object,Object> testdatamap) throws InterruptedException {
		  		this.takeScreenShot();
		  		String Expected=testdatamap.get("ExpectedMessage").toString();
		  		try {
		  			if (ExistsCheck(EdaatOR.Biller_MobileNovalidation)&&(ExistsCheck(EdaatOR.Biller_Nameerror)&&(ExistsCheck(EdaatOR.Biller_Ibanreqerror)&&(ExistsCheck(EdaatOR.Biller_Benfreqerror)&&(ExistsCheck(EdaatOR.Biller_Nationalreqerror)))) )){
		  				VerifyValue(Expected,EdaatOR.Biller_MobileNovalidation);
		  				test.log(Status.PASS, "#FUNC-SubbillerMobileNo and Name ErrorMessage Exists" + driver.getTitle() + " * SubbillerMobileNo and Name ErrorMessage Exists * ");
		  			}
		  			else if	(ExistsCheck(EdaatOR.Biller_Nationalid)) {
		  				VerifyValue(Expected,EdaatOR.Biller_Nationalid);
		  				test.log(Status.PASS, "#FUNC-Subbiller Nationalid ErrorMessage Exists" + driver.getTitle() + " * Subbiller Nationalid ErrorMessage Exists * ");	
		     }
		  			else if	(ExistsCheck(EdaatOR.Biller_Invalidmobileno)) {
		  				VerifyValue(Expected,EdaatOR.Biller_Invalidmobileno);
		  				test.log(Status.PASS, "#FUNC-Subbiller invalidMobileno ErrorMessage Exists" + driver.getTitle() + " * Subbiller invalidMobileno ErrorMessage Exists * ");	
		     }
		  			else if	(ExistsCheck(EdaatOR.Biller_Ibanerror)) {
		  				VerifyValue(Expected,EdaatOR.Biller_Ibanerror);
		  				test.log(Status.PASS, "#FUNC-Subbiller Iban ErrorMessage Exists" + driver.getTitle() + " * Subbiller Iban ErrorMessage Exists * ");	
		  			}
		  			else if	(ExistsCheck(EdaatOR.Biller_InvalidNationalid)) {
		  				VerifyValue(Expected,EdaatOR.Biller_InvalidNationalid);
		  				test.log(Status.PASS, "#FUNC-Subbiller InvalidNationalid ErrorMessage Exists" + driver.getTitle() + " * Subbiller InvalidNationalid ErrorMessage Exists * ");	
		  			}
		  			else if	(ExistsCheck(EdaatOR.Biller_Invalidiban)) {
		  				VerifyValue(Expected,EdaatOR.Biller_Invalidiban);
		  				test.log(Status.PASS, "#FUNC-Subbiller invalidIban ErrorMessage Exists" + driver.getTitle() + " * Subbiller invalidIban ErrorMessage Exists * ");	
		  			}
		  			else if	(ExistsCheck(EdaatOR.Biller_Invalidname)) {
		  				VerifyValue(Expected,EdaatOR.Biller_Invalidname);
		  				test.log(Status.PASS, "#FUNC-Subbiller invalidName ErrorMessage Exists" + driver.getTitle() + " * Subbiller invalidName ErrorMessage Exists * ");	
		  			}
		  		
		  		}
		  		   catch(Exception e)
		  		   {
		  			   this.takeScreenShot();
		  			test.log(Status.FAIL, "#FUNC-Invalid Error message" + driver.getTitle() + " * Invalid login error message is Fail* "); 	   
		  	 }

		  }
		  		
			  //Function Summary:To add product.
			  //Function Parameters:Product,Fixed Value,Percentage,IBAN and Beneficiary Name.
			  		public void addproductUi(Map<Object, Object> testdatamap) throws Exception
			  		{
			  		 try {	   
			  			WebClickUsingJS(EdaatOR.Biller_AddsubBiller_addprod);
			  			WebSelect(EdaatOR.Biller_AddsubBiller_prodname,testdatamap.get("Product").toString());
			  			Thread.sleep(2000);
			  			WebClear(EdaatOR.Biller_AddsubBiller_fixed);
			  			WebEdit(EdaatOR.Biller_AddsubBiller_fixed,testdatamap.get("Fixed Value").toString());
			  			Thread.sleep(2000);
			  			WebClear(EdaatOR.Biller_AddsubBiller_per);
			  			WebEdit(EdaatOR.Biller_AddsubBiller_per,testdatamap.get("Percentage").toString());
			  			Thread.sleep(2000);
			  			WebClear(EdaatOR.Biller_AddsubBiller_prodiban);
			  			WebEdit(EdaatOR.Biller_AddsubBiller_prodiban,testdatamap.get("IBAN").toString());
			  			Thread.sleep(2000);
			  			WebClear(EdaatOR.Biller_AddsubBiller_prodbene);
			  			WebEdit(EdaatOR.Biller_AddsubBiller_prodbene,testdatamap.get("Beneficiary Name").toString());
			  			Thread.sleep(2000);
			  			EnterIbanAttachment();
			  			Thread.sleep(2000);
			  			WebClickUsingJS(EdaatOR.Biller_AddsubBiller_prodaddbt);
			  			Thread.sleep(2000);
			  			IndividualaddSubbillerErrormeaasgaeValidation(testdatamap);
			  			this.takeScreenShot();
			  			test.log(Status.PASS,"#FUNC-addproduct" + driver.getTitle() +" * addproduct PASS* " );
			  		   }
			  		   catch(Exception e){
			  		    	test.log(Status.FAIL,"#FUNC-addproduct" + driver.getTitle() +" * addproduct FAIL * " );
			  		            this.takeScreenShot();
			  		        	}

			  		}
			  	  public void IndividualaddSubbillerErrormeaasgaeValidation(Map<Object,Object> testdatamap) throws InterruptedException {
				  		
				  		String Expected=testdatamap.get("ExpectedMessage").toString();
				  	
				  		if(ExistsCheck(EdaatOR.Biller_entervalueerrormsg)) {
			  				VerifyValue(Expected,EdaatOR.Biller_entervalueerrormsg);
			  				test.log(Status.PASS, "#FUNC-Subbiller entervalue ErrorMessage Exists" + driver.getTitle() + " * Subbiller entervalue ErrorMessage Exists * ");
				  			}
				  		else if	(ExistsCheck(EdaatOR.Biller_SelectProductvalidation)) {
			  				VerifyValue(Expected,EdaatOR.Biller_SelectProductvalidation);
			  				test.log(Status.PASS, "#FUNC-Subbiller selectproduct ErrorMessage Exists" + driver.getTitle() + " * Subbiller selectproduct ErrorMessage Exists * ");	
			     }
				  		else if	(ExistsCheck(EdaatOR.Biller_Onlyentervalueerrormsg)) {
			  				VerifyValue(Expected,EdaatOR.Biller_Onlyentervalueerrormsg);
			  				test.log(Status.PASS, "#FUNC-Subbiller entervalue ErrorMessage Exists" + driver.getTitle() + " * Subbiller entervalue ErrorMessage Exists * ");
				  		}
				  		else if	(ExistsCheck(EdaatOR.Biller_Onlyenterpercentageerrormsg)) {
			  				VerifyValue(Expected,EdaatOR.Biller_Onlyenterpercentageerrormsg);
			  				test.log(Status.PASS, "#FUNC-Subbiller entervalue percentage ErrorMessage Exists" + driver.getTitle() + " * Subbiller entervalue percentage ErrorMessage Exists * ");
				  		}
			  	  }
			  	//Function Summary : Method to add Individual Subbiller. 
					//Parameter Summary: BillerName,National ID,IBanNumber,BeneficaryName,FixedValueAmount,Percentage Value,MobileNumber,Email.
				    public boolean AddIndSubBillerUi(Map<Object, Object> testdatamap){
					//	boolean existsElement = false;
						try{
							WebClickUsingJS(EdaatOR.Biller_Sub_Individualclient);
				        	Thread.sleep(2000);
				        	WebClickUsingJS(EdaatOR.Biller_Sub_IndividualsubBiller);
				        	Thread.sleep(2000);
							WebClick(EdaatOR.Biller_AddSubBilleer);
							WebClear(EdaatOR.Biller_AddsubBiller_name);
			  	  			WebEdit(EdaatOR.Biller_AddsubBiller_name,testdatamap.get("SubBillerName").toString());
			  	  			Thread.sleep(2000);
			  	  			WebClear(EdaatOR.Biller_AddsubBiller_National);
			  	  			WebEdit(EdaatOR.Biller_AddsubBiller_National,testdatamap.get("NationalID").toString());
			  	  			Thread.sleep(2000);
			  	  			WebClear(EdaatOR.Biller_AddsubBiller_IBAN);
			  	  			WebEdit(EdaatOR.Biller_AddsubBiller_IBAN,testdatamap.get("IBAN Number").toString());
			  	  			Thread.sleep(2000);
			  	  			WebClear(EdaatOR.Biller_AddsubBiller_Beneficiary);
			  	  			WebEdit(EdaatOR.Biller_AddsubBiller_Beneficiary,testdatamap.get("Beneficiary").toString());
			  	  			Thread.sleep(2000);
			  	  			EnterIbanAttach();
			  	  		    WebClear(EdaatOR.Biller_AddsubBiller_mbl);
		  	  			    WebEdit(EdaatOR.Biller_AddsubBiller_mbl,testdatamap.get("Mobile").toString());
		  	  			    Thread.sleep(2000);
			  	          //  WebClickUsingJS(EdaatOR.Biller_AddsubBiller_Fees);
			  	  			//Thread.sleep(2000);
							WebClickUsingJS(EdaatOR.Biller_SubBiller_Invoice_Total_AMT_ChkBox);
							Thread.sleep(3000);
							WebClickUsingJS(EdaatOR.Biller_SubBiller_FixedValue_ChkBox);
							Thread.sleep(3000);
							WebEdit(EdaatOR.Biller_SubBiller_FixedValue_Amt,testdatamap.get("FixedValueAmount").toString());
							WebClickUsingJS(EdaatOR.Biller_SubBiller_Percentage_ChkBox);
							Thread.sleep(3000);
							WebEdit(EdaatOR.Biller_SubBiller_Percentage_Val,testdatamap.get("Percentage Value").toString());
							Thread.sleep(3000);
							WebClickUsingJS(EdaatOR.Biller_SubBiller_Trans_Fee_Deduct_ChxBox);
							Thread.sleep(3000);							
							WebEdit(EdaatOR.Biller_SubBiller_Email,testdatamap.get("Email").toString());
							Thread.sleep(3000);
							WebClick(EdaatOR.Biller_SubBillerAddButton);
							//Thread.sleep(3000);
							 driver.findElement(By.xpath(EdaatOR.Biller_SubBillerName)).sendKeys(Keys.PAGE_UP);
							IndividualSubbillerErrormeaasgaeValidationbasedonInvoice(testdatamap);
							Thread.sleep(3000);
				           	
				        }catch(Exception e){
			      test.log(Status.FAIL,"#FUNC-Add Individual client" + driver.getTitle() +" * Add Individual client PASS * " );
				            this.takeScreenShot();
				        }
				        return existsElement;
				    }
			
				    public void IndividualSubbillerErrormeaasgaeValidationbasedonInvoice(Map<Object,Object> testdatamap) throws InterruptedException {
				  		this.takeScreenShot();
				  		String Expected=testdatamap.get("ExpectedMessage").toString();
				  		try {
				  			 if	(ExistsCheck(EdaatOR.Biller_Fixedvaluereqerror)) {				  				
				  				 
				  			    verifyElementIsPresent(EdaatOR.Biller_Fixedvaluereqerror);
				  				test.log(Status.PASS, "#FUNC-Subbiller FixedValue ErrorMessage Exists" + driver.getTitle() + " * Subbiller FixedValue ErrorMessage Exists * ");
				  			 }		  				
				  					
				     
				  			 else if (ExistsCheck(EdaatOR.Biller_MobileNovalidation)&&(ExistsCheck(EdaatOR.Biller_Nameerror)&&(ExistsCheck(EdaatOR.Biller_Ibanreqerror)&&(ExistsCheck(EdaatOR.Biller_Benfreqerror)&&(ExistsCheck(EdaatOR.Biller_Nationalreqerror)))) )){
				  				VerifyValue(Expected,EdaatOR.Biller_MobileNovalidation);
				  				test.log(Status.PASS, "#FUNC-SubbillerMobileNo and Name ErrorMessage Exists" + driver.getTitle() + " * SubbillerMobileNo and Name ErrorMessage Exists * ");
				  			}
				  			else if	(ExistsCheck(EdaatOR.Biller_Nationalid)) {
				  				VerifyValue(Expected,EdaatOR.Biller_Nationalid);
				  				test.log(Status.PASS, "#FUNC-Subbiller Nationalid ErrorMessage Exists" + driver.getTitle() + " * Subbiller Nationalid ErrorMessage Exists * ");	
				     }
				  			else if	(ExistsCheck(EdaatOR.Biller_Invalidmobileno)) {
				  				VerifyValue(Expected,EdaatOR.Biller_Invalidmobileno);
				  				test.log(Status.PASS, "#FUNC-Subbiller invalidMobileno ErrorMessage Exists" + driver.getTitle() + " * Subbiller invalidMobileno ErrorMessage Exists * ");	
				     }
				  			else if	(ExistsCheck(EdaatOR.Biller_Ibanerror)) {
				  				VerifyValue(Expected,EdaatOR.Biller_Ibanerror);
				  				test.log(Status.PASS, "#FUNC-Subbiller Iban ErrorMessage Exists" + driver.getTitle() + " * Subbiller Iban ErrorMessage Exists * ");	
				  			}
				  			else if	(ExistsCheck(EdaatOR.Biller_InvalidNationalid)) {
				  				VerifyValue(Expected,EdaatOR.Biller_InvalidNationalid);
				  				test.log(Status.PASS, "#FUNC-Subbiller InvalidNationalid ErrorMessage Exists" + driver.getTitle() + " * Subbiller InvalidNationalid ErrorMessage Exists * ");	
				  			}
				  			else if	(ExistsCheck(EdaatOR.Biller_Invalidiban)) {
				  				VerifyValue(Expected,EdaatOR.Biller_Invalidiban);
				  				test.log(Status.PASS, "#FUNC-Subbiller invalidIban ErrorMessage Exists" + driver.getTitle() + " * Subbiller invalidIban ErrorMessage Exists * ");	
				  			}
				  			else if	(ExistsCheck(EdaatOR.Biller_Invalidname)) {
				  				VerifyValue(Expected,EdaatOR.Biller_Invalidname);
				  				test.log(Status.PASS, "#FUNC-Subbiller invalidName ErrorMessage Exists" + driver.getTitle() + " * Subbiller invalidName ErrorMessage Exists * ");	
				  			}
				  			else if	(ExistsCheck(EdaatOR.Biller_percentagereqerror)) {
				  				VerifyValue(Expected,EdaatOR.Biller_percentagereqerror);
				  				test.log(Status.PASS, "#FUNC-Subbiller Percentage ErrorMessage Exists" + driver.getTitle() + " * Subbiller Percentage ErrorMessage Exists * ");	
				  			}
				  		
				  		}
				  		   catch(Exception e)
				  		   {
				  			   this.takeScreenShot();
				  			test.log(Status.FAIL, "#FUNC-Invalid Error message" + driver.getTitle() + " * Invalid login error message is Fail* "); 	   
				  	 }

				  }
				    public void AddIndivSubbillerInvoicetotal() throws InterruptedException
				    {try
				    {
				    	WebClickUsingJS(EdaatOR.Biller_Sub_Individualclient);
			        	Thread.sleep(2000);
			        	WebClickUsingJS(EdaatOR.Biller_Sub_IndividualsubBiller);
			        	Thread.sleep(2000);
						WebClick(EdaatOR.Biller_AddSubBilleer);
						Thread.sleep(2000);
						WebClick(EdaatOR.Biller_SubBillerAddButton);
						driver.findElement(By.xpath(EdaatOR.Biller_SubBillerName)).sendKeys(Keys.PAGE_UP);
						this.takeScreenShot();
						verifyElementIsPresent(EdaatOR.Biller_Totalamount);						
						test.log(Status.PASS, "#FUNC-Subbiller Total Invoice Amount Error message" + driver.getTitle() + " * Subbiller Total Invoice Amount error message is Pass* ");
						Thread.sleep(15000);
						WebClickUsingJS(EdaatOR.Biller_SubBiller_Invoice_Total_AMT_ChkBox);
						WebClick(EdaatOR.Biller_SubBillerAddButton);
						driver.findElement(By.xpath(EdaatOR.Biller_SubBillerName)).sendKeys(Keys.PAGE_UP);
						this.takeScreenShot();
						verifyElementIsPresent(EdaatOR.Biller_Invoicefees);						
						test.log(Status.PASS, "#FUNC-Subbiller Invoice Fees Error message" + driver.getTitle() + " * Subbiller  Invoice Fees error message is Pass* ");
						Thread.sleep(15000);
						WebClickUsingJS(EdaatOR.Biller_SubBiller_FixedValue_ChkBox);
						WebClick(EdaatOR.Biller_SubBillerAddButton);
						driver.findElement(By.xpath(EdaatOR.Biller_SubBillerName)).sendKeys(Keys.PAGE_UP);
						this.takeScreenShot();
						verifyElementIsPresent(EdaatOR.Biller_Fixedvaluereqerror);						
						test.log(Status.PASS, "#FUNC-Subbiller Invoice fixed Fees Error message" + driver.getTitle() + " * Subbiller  Invoice Fixed Fees error message is Pass* ");
						Thread.sleep(15000);
						WebClickUsingJS(EdaatOR.Biller_SubBiller_FixedValue_ChkBox);
						WebClickUsingJS(EdaatOR.Biller_SubBiller_Percentage_ChkBox);
						WebClick(EdaatOR.Biller_SubBillerAddButton);
						driver.findElement(By.xpath(EdaatOR.Biller_SubBillerName)).sendKeys(Keys.PAGE_UP);
						this.takeScreenShot();
						verifyElementIsPresent(EdaatOR.Biller_Percentagereqerror);					
						test.log(Status.PASS, "#FUNC-Subbiller Invoice Percentage Fees Error message" + driver.getTitle() + " * Subbiller  Invoice Percentage Fees error message is Pass* ");
						Thread.sleep(15000);
						WebClickUsingJS(EdaatOR.Biller_SubBiller_Percentage_ChkBox);
						WebClickUsingJS(EdaatOR.Biller_SubBiller_Invoice_Total_AMT_ChkBox);
						WebClickUsingJS(EdaatOR.Biller_AddsubBiller_Fees);
						WebClick(EdaatOR.Biller_SubBillerAddButton);
						driver.findElement(By.xpath(EdaatOR.Biller_SubBillerName)).sendKeys(Keys.PAGE_UP);
						this.takeScreenShot();						
						verifyElementIsPresent(EdaatOR.Biller_SelectProducterrormsg);					
						test.log(Status.PASS, "#FUNC-Subbiller Product with Fees Error message" + driver.getTitle() + " * Subbiller  Product with Fees error message is Pass* ");
		}
				    catch(Exception e)
			  		   {
			  			   this.takeScreenShot();
			  			test.log(Status.FAIL, "#FUNC-Invalid Error message" + driver.getTitle() + " * Invalid login error message is Fail* "); 	   
			  	 }
				    }

				    public void AddCarpoSubbillerInvoicetotal() throws InterruptedException
				    {try
				    {
				    	//NavigateCorporateSubBiller();
						WebClick(EdaatOR.Biller_AddSubBilleer);
						Thread.sleep(2000);
						WebClick(EdaatOR.Biller_SubBillerAddButton);
						driver.findElement(By.xpath(EdaatOR.Biller_Carporatesym)).sendKeys(Keys.PAGE_UP);
						this.takeScreenShot();
						verifyElementIsPresent(EdaatOR.Biller_Totalamount);						
						test.log(Status.PASS, "#FUNC-Subbiller Total Invoice Amount Error message" + driver.getTitle() + " * Subbiller Total Invoice Amount error message is Pass* ");
						Thread.sleep(15000);
						WebClickUsingJS(EdaatOR.Biller_SubBiller_Invoice_Total_AMT_ChkBox);
						WebClick(EdaatOR.Biller_SubBillerAddButton);
						driver.findElement(By.xpath(EdaatOR.Biller_Carporatesym)).sendKeys(Keys.PAGE_UP);
						this.takeScreenShot();
						verifyElementIsPresent(EdaatOR.Biller_Invoicefees);						
						test.log(Status.PASS, "#FUNC-Subbiller Invoice Fees Error message" + driver.getTitle() + " * Subbiller  Invoice Fees error message is Pass* ");
						Thread.sleep(15000);
						WebClickUsingJS(EdaatOR.Biller_SubBiller_FixedValue_ChkBox);
						WebClick(EdaatOR.Biller_SubBillerAddButton);
						driver.findElement(By.xpath(EdaatOR.Biller_Carporatesym)).sendKeys(Keys.PAGE_UP);
						this.takeScreenShot();
						verifyElementIsPresent(EdaatOR.Biller_Fixedvaluereqerror);						
						test.log(Status.PASS, "#FUNC-Subbiller Invoice fixed Fees Error message" + driver.getTitle() + " * Subbiller  Invoice Fixed Fees error message is Pass* ");
						Thread.sleep(15000);
						WebClickUsingJS(EdaatOR.Biller_SubBiller_FixedValue_ChkBox);
						WebClickUsingJS(EdaatOR.Biller_SubBiller_Percentage_ChkBox);
						WebClick(EdaatOR.Biller_SubBillerAddButton);
						driver.findElement(By.xpath(EdaatOR.Biller_Carporatesym)).sendKeys(Keys.PAGE_UP);
						this.takeScreenShot();
						verifyElementIsPresent(EdaatOR.Biller_Percentagereqerror);					
						test.log(Status.PASS, "#FUNC-Subbiller Invoice Percentage Fees Error message" + driver.getTitle() + " * Subbiller  Invoice Percentage Fees error message is Pass* ");
						Thread.sleep(15000);
						WebClickUsingJS(EdaatOR.Biller_SubBiller_Percentage_ChkBox);
						WebClickUsingJS(EdaatOR.Biller_SubBiller_Invoice_Total_AMT_ChkBox);
						WebClickUsingJS(EdaatOR.Biller_AddsubBiller_Fees);
						WebClick(EdaatOR.Biller_SubBillerAddButton);
						driver.findElement(By.xpath(EdaatOR.Biller_Carporatesym)).sendKeys(Keys.PAGE_UP);
						this.takeScreenShot();						
						verifyElementIsPresent(EdaatOR.Biller_SelectProducterrormsg);					
						test.log(Status.PASS, "#FUNC-Subbiller Product with Fees Error message" + driver.getTitle() + " * Subbiller  Product with Fees error message is Pass* ");
		}
				    catch(Exception e)
			  		   {
			  			   this.takeScreenShot();
			  			test.log(Status.FAIL, "#FUNC-Invalid Error message" + driver.getTitle() + " * Invalid login error message is Fail* "); 	   
			  	 }
				    }
					  //Function Summary: Method to Add sub biller Based on Product. 
					  //Function Parameters: BillerName,CRNumber,Status
					public void AddCorporateSubBillerwithProductUi(Map<Object, Object> testdatamap) throws Exception {
						String Expected=testdatamap.get("Methods").toString();
						
					
						try {
							
							
													
							if(Expected.equalsIgnoreCase("General Info"))
						{
							 WebClickUsingJS(EdaatOR.Biller_AddSubBilleer);
							 EnterFeesDeductionBasedonProduct(testdatamap);
							 addProductDetails(testdatamap);							
							 Thread.sleep(2000);	
							 EnterGeneralinfo(testdatamap);							
							 WebClick(EdaatOR.Biller_SubBillerAddButton);
							 driver.findElement(By.xpath(EdaatOR.Biller_Carporatesym)).sendKeys(Keys.PAGE_UP);
							 Thread.sleep(2000);
							 this.takeScreenShot();
							 verifyElementIsPresent(EdaatOR.Biller_CarpNameerror);						
							 verifyElementIsPresent(EdaatOR.Biller_CarpCrNameerror);						
							 verifyElementIsPresent(EdaatOR.Biller_CarpIbanerror);						
							 verifyElementIsPresent(EdaatOR.Biller_CarpBenNameerror);						
							 verifyElementIsPresent(EdaatOR.Biller_CarpTaxNoerror);						
							 test.log(Status.PASS, "#FUNC-Subbiller National Address Error message" + driver.getTitle() + " * Subbiller National Address  error message is Pass* ");
						}
						else if(Expected.equalsIgnoreCase("National address"))
						{
							 WebClickUsingJS(EdaatOR.Biller_AddSubBilleer);
							 EnterFeesDeductionBasedonProduct(testdatamap);
							 addProductDetails(testdatamap);							
							 Thread.sleep(2000);
							 driver.findElement(By.xpath(EdaatOR.Biller_subbiller_Corpbuildno)).sendKeys(Keys.PAGE_DOWN);
							 EnterNationalAddressinfo(testdatamap);
							 WebClick(EdaatOR.Biller_SubBillerAddButton);							
							 Thread.sleep(1000);
							 this.takeScreenShot();
							 verifyElementIsPresent(EdaatOR.Biller_CarpCityerror);						
							 verifyElementIsPresent(EdaatOR.Biller_CarpDisterror);						
							 verifyElementIsPresent(EdaatOR.Biller_CarpStreeterror);						
							 verifyElementIsPresent(EdaatOR.Biller_CarpPoatalerror);						
							 verifyElementIsPresent(EdaatOR.Biller_CarpBuildNoerror);						
							 test.log(Status.PASS, "#FUNC-Subbiller General Info Error message" + driver.getTitle() + " * Subbiller General Info error message is Pass* ");
						  
						}	
						else if(Expected.equalsIgnoreCase("Contact Info"))
						{
							 WebClickUsingJS(EdaatOR.Biller_AddSubBilleer);
							 EnterFeesDeductionBasedonProduct(testdatamap);
							 addProductDetails(testdatamap);							
							 Thread.sleep(2000);
							 EnterContactInfo(testdatamap);
							 WebClick(EdaatOR.Biller_SubBillerAddButton);							
							 Thread.sleep(1000);
							 driver.findElement(By.xpath(EdaatOR.Biller_subbiller_Corpbuildno)).sendKeys(Keys.PAGE_DOWN);
							 this.takeScreenShot();
							 verifyElementIsPresent(EdaatOR.Biller_CarpEmpNameerror);						
							 verifyElementIsPresent(EdaatOR.Biller_CarpEmpEmailerror);						
							 verifyElementIsPresent(EdaatOR.Biller_CarpEmpMobNoerror);
												
							 test.log(Status.PASS, "#FUNC-Subbiller Contact Info Error message" + driver.getTitle() + " * Subbiller Contact Info error message is Pass* ");
						}
						else if(Expected.equalsIgnoreCase("Invalid Contact Info"))
						{
							 WebClickUsingJS(EdaatOR.Biller_AddSubBilleer);
							 EnterFeesDeductionBasedonProduct(testdatamap);
							 addProductDetails(testdatamap);							
							 Thread.sleep(2000);
							 EnterContactInfo(testdatamap);
							 WebClick(EdaatOR.Biller_SubBillerAddButton);							
							 Thread.sleep(1000);
							 driver.findElement(By.xpath(EdaatOR.Biller_subbiller_Corpbuildno)).sendKeys(Keys.PAGE_DOWN);
							 this.takeScreenShot();
							 verifyElementIsPresent(EdaatOR.Biller_CarpEmpinvNameerror);						
							 verifyElementIsPresent(EdaatOR.Biller_CarpEmpinvEmailerror);						
							 verifyElementIsPresent(EdaatOR.Biller_CarpEmpinvMobNoerror);
												
							 test.log(Status.PASS, "#FUNC-Subbiller invalid Contact Info Error message" + driver.getTitle() + " * Subbiller invalid Contact Info error message is Pass* ");
						}
						else if(Expected.equalsIgnoreCase("Invalid National address"))
						{
							 WebClickUsingJS(EdaatOR.Biller_AddSubBilleer);
							 EnterFeesDeductionBasedonProduct(testdatamap);
							 addProductDetails(testdatamap);							
							 Thread.sleep(2000);
							 EnterNationalAddressinfo(testdatamap);
							 WebClick(EdaatOR.Biller_SubBillerAddButton);							
							 Thread.sleep(1000);
							 driver.findElement(By.xpath(EdaatOR.Biller_subbiller_Corpbuildno)).sendKeys(Keys.PAGE_DOWN);
							 this.takeScreenShot();
							 verifyElementIsPresent(EdaatOR.Biller_CarpInvDisterror);						
							 verifyElementIsPresent(EdaatOR.Biller_CarpInvStreeterror);				
													
							 test.log(Status.PASS, "#FUNC-Subbiller Invalid General Info Error message" + driver.getTitle() + " * Subbiller Invalid General Info error message is Pass* ");
						  
						}
						else if(Expected.equalsIgnoreCase("Invalid General Info"))
						{
							
							 WebClickUsingJS(EdaatOR.Biller_AddSubBilleer);
							 EnterFeesDeductionBasedonProduct(testdatamap);
							 addProductDetails(testdatamap);							
							 Thread.sleep(2000);
							 EnterGeneralinfo(testdatamap);							
							 WebClick(EdaatOR.Biller_SubBillerAddButton);
							 driver.findElement(By.xpath(EdaatOR.Biller_Carporatesym)).sendKeys(Keys.PAGE_UP);
							 Thread.sleep(2000);
							 this.takeScreenShot();												
							 verifyElementIsPresent(EdaatOR.Biller_CarpInvNameerror);						
							 verifyElementIsPresent(EdaatOR.Biller_CarpInvCrNameerror);						
							 verifyElementIsPresent(EdaatOR.Biller_CarpInvIbanerror);						
							 verifyElementIsPresent(EdaatOR.Biller_CarpInvTaxNoerror);						
							 test.log(Status.PASS, "#FUNC-Subbiller Invalid National Address Error message" + driver.getTitle() + " * Subbiller Invalid National Address  error message is Pass* ");
						}
						else if(Expected.equalsIgnoreCase("Attachments"))
						{
							
							 WebClickUsingJS(EdaatOR.Biller_AddSubBilleer);
							 EnterFeesDeductionBasedonProduct(testdatamap);
							 addProductDetails(testdatamap);							
							 Thread.sleep(2000);
							 WebEdit(EdaatOR.Biller_subbiller_Corpname, testdatamap.get("BillerName").toString());
							 Thread.sleep(2000);
							 WebEdit(EdaatOR.Biller_subbiller_Corpcrnum, testdatamap.get("CRNumber").toString());
							 Thread.sleep(2000);
					       // EnterCRattach();
					      //  Thread.sleep(2000);
					    //    EnterIBANImg();
							 WebEdit(EdaatOR.Biller_subbiller_Corpiban, testdatamap.get("IBANNumber").toString());
							 Thread.sleep(2000);
							 WebEdit(EdaatOR.Biller_subbiller_Corpbenfname, testdatamap.get("BeneficiaryName").toString());
							 Thread.sleep(2000);
							 WebEdit(EdaatOR.Biller_subbiller_Corptaxnum, testdatamap.get("Taxnumber").toString());
							 this.takeScreenShot();
							 EnterNationalAddressinfo(testdatamap);
							 EnterContactInfo(testdatamap);
							 WebClick(EdaatOR.Biller_SubBillerAddButton);							
							 Thread.sleep(1000);							
							 this.takeScreenShot();
							 verifyElementIsPresent(EdaatOR.Biller_CarpEmpinvIbanatcerror);					
							
												
							 test.log(Status.PASS, "#FUNC-Subbiller Attachment Error message" + driver.getTitle() + " * Subbiller Attachment error message is Pass* ");
						}
						else if(Expected.equalsIgnoreCase("Product"))
							{
							WebClickUsingJS(EdaatOR.Biller_AddSubBilleer);							
							EnterFeesDeductionBasedonProduct(testdatamap);
							WebSelect(EdaatOR.Biller_subbiller_corpaddProduct_ProductID,testdatamap.get("ProductName").toString());
							ClickOnProductAddBtn();
							verifyElementIsPresent(EdaatOR.Biller_Carpselectproduct);
							this.takeScreenShot();	
							Thread.sleep(10000);
							WebSelect(EdaatOR.Biller_subbiller_corpaddProduct_ProductID,"product3");
							ClickOnProductAddBtn();
							verifyElementIsPresent(EdaatOR.Biller_Onlyentervalueerrormsg);
							this.takeScreenShot();	
							Thread.sleep(10000);
							WebClear(EdaatOR.Biller_AddsubBiller_ProductPer);
				  			WebEdit(EdaatOR.Biller_AddsubBiller_ProductPer,testdatamap.get("ProductPercentage").toString());
				  			Thread.sleep(1000);
				  			ClickOnProductAddBtn();
							verifyElementIsPresent(EdaatOR.Biller_Onlyenterpercentageerrormsg);
							this.takeScreenShot();	
							Thread.sleep(10000);
							WebEdit(EdaatOR.Biller_AddsubBiller_ProductPer,"20");
							ClickOnProductAddBtn();
							verifyElementIsPresent(EdaatOR.Biller_Ibanerrormsg);
							this.takeScreenShot();	
							Thread.sleep(10000);
							WebEdit(EdaatOR.Billersubbiller_productIBAN, testdatamap.get("ProductIBANNumber").toString());
							ClickOnProductAddBtn();
							verifyElementIsPresent(EdaatOR.Biller_InvalidIbanerrormsg);
							this.takeScreenShot();	
							Thread.sleep(10000);
							WebEdit(EdaatOR.Billersubbiller_productIBAN,"SA21 1234 7718 7600 4014");
							ClickOnProductAddBtn();
							verifyElementIsPresent(EdaatOR.Biller_BenfNameerrormsg);
							this.takeScreenShot();	
							Thread.sleep(10000);
							WebEdit(EdaatOR.Billersubbiller_product_BenName, testdatamap.get("ProductIBANNumber").toString());
							ClickOnProductAddBtn();
							verifyElementIsPresent(EdaatOR.Biller_BenfAtachNameerrormsg);
							this.takeScreenShot();	
							Thread.sleep(10000);
							EnterProductCRattach();
							Thread.sleep(2000);
							ClickOnProductAddBtn();
							this.takeScreenShot();	
							Thread.sleep(2000);
							 test.log(Status.PASS, "#FUNC-Subbiller Product Error message" + driver.getTitle() + " * Subbiller Product  error message is Pass* ");
							}
							
						}
					  catch (Exception e) {
							test.log(Status.FAIL,"#FUNC-Add Corporate SubBiller Based on Product" + driver.getTitle() +" * Add Corporate SubBiller Based on Product * " );
						}
					}
					//Function Summary: Method to Add sub biller Based on Product. 
					  //Function Parameters: BillerName,CRNumber,Status
					public void addCorporateSubBillerwithInvoiceUi(Map<Object, Object> testdatamap) throws Exception {
						String Expected=testdatamap.get("Methods").toString();
						
					
						try {						
																				
							if(Expected.equalsIgnoreCase("General Info"))
						{
						     WebClickUsingJS(EdaatOR.Biller_AddSubBilleer);
						     EnterOperationalFeesInfo(testdatamap);						
							 EnterGeneralinfo(testdatamap);							
							 WebClick(EdaatOR.Biller_SubBillerAddButton);
							 driver.findElement(By.xpath(EdaatOR.Biller_Carporatesym)).sendKeys(Keys.PAGE_UP);
							 Thread.sleep(2000);
							 this.takeScreenShot();
							 verifyElementIsPresent(EdaatOR.Biller_CarpNameerror);						
							 verifyElementIsPresent(EdaatOR.Biller_CarpCrNameerror);						
							 verifyElementIsPresent(EdaatOR.Biller_CarpIbanerror);						
							 verifyElementIsPresent(EdaatOR.Biller_CarpBenNameerror);						
							 verifyElementIsPresent(EdaatOR.Biller_CarpTaxNoerror);						
							 test.log(Status.PASS, "#FUNC-Subbiller National Address Error message" + driver.getTitle() + " * Subbiller National Address  error message is Pass* ");
						}
						else if(Expected.equalsIgnoreCase("National address"))
						{
							 WebClickUsingJS(EdaatOR.Biller_AddSubBilleer);
							 EnterOperationalFeesInfo(testdatamap);					
							 Thread.sleep(2000);
							 driver.findElement(By.xpath(EdaatOR.Biller_subbiller_Corpbuildno)).sendKeys(Keys.PAGE_DOWN);
							 EnterNationalAddressinfo(testdatamap);
							 WebClick(EdaatOR.Biller_SubBillerAddButton);							
							 Thread.sleep(1000);
							 this.takeScreenShot();
							 verifyElementIsPresent(EdaatOR.Biller_CarpCityerror);						
							 verifyElementIsPresent(EdaatOR.Biller_CarpDisterror);						
							 verifyElementIsPresent(EdaatOR.Biller_CarpStreeterror);						
							 verifyElementIsPresent(EdaatOR.Biller_CarpPoatalerror);						
							 verifyElementIsPresent(EdaatOR.Biller_CarpBuildNoerror);						
							 test.log(Status.PASS, "#FUNC-Subbiller General Info Error message" + driver.getTitle() + " * Subbiller General Info error message is Pass* ");
						  
						}	
						else if(Expected.equalsIgnoreCase("Contact Info"))
						{
													
							 WebClickUsingJS(EdaatOR.Biller_AddSubBilleer);
							 EnterOperationalFeesInfo(testdatamap);	
							 Thread.sleep(3000);
							 EnterContactInfo(testdatamap);
							 WebClick(EdaatOR.Biller_SubBillerAddButton);							
							 Thread.sleep(1000);
							 driver.findElement(By.xpath(EdaatOR.Biller_subbiller_Corpbuildno)).sendKeys(Keys.PAGE_DOWN);
							 this.takeScreenShot();
							 verifyElementIsPresent(EdaatOR.Biller_CarpEmpNameerror);						
							 verifyElementIsPresent(EdaatOR.Biller_CarpEmpEmailerror);						
							 verifyElementIsPresent(EdaatOR.Biller_CarpEmpMobNoerror);
												
							 test.log(Status.PASS, "#FUNC-Subbiller Contact Info Error message" + driver.getTitle() + " * Subbiller Contact Info error message is Pass* ");
						}
						else if(Expected.equalsIgnoreCase("Invalid Contact Info"))
						{
							 WebClickUsingJS(EdaatOR.Biller_AddSubBilleer);
							 EnterOperationalFeesInfo(testdatamap);	
							 EnterContactInfo(testdatamap);
							 WebClick(EdaatOR.Biller_SubBillerAddButton);							
							 Thread.sleep(1000);
							 driver.findElement(By.xpath(EdaatOR.Biller_subbiller_Corpbuildno)).sendKeys(Keys.PAGE_DOWN);
							 this.takeScreenShot();
							 verifyElementIsPresent(EdaatOR.Biller_CarpEmpinvNameerror);						
							 verifyElementIsPresent(EdaatOR.Biller_CarpEmpinvEmailerror);						
							 verifyElementIsPresent(EdaatOR.Biller_CarpEmpinvMobNoerror);
												
							 test.log(Status.PASS, "#FUNC-Subbiller invalid Contact Info Error message" + driver.getTitle() + " * Subbiller invalid Contact Info error message is Pass* ");
						}
						else if(Expected.equalsIgnoreCase("Invalid National address"))
						{
							 WebClickUsingJS(EdaatOR.Biller_AddSubBilleer);
							 EnterOperationalFeesInfo(testdatamap);							
							 Thread.sleep(2000);
							 EnterNationalAddressinfo(testdatamap);
							 WebClick(EdaatOR.Biller_SubBillerAddButton);							
							 Thread.sleep(1000);
							 driver.findElement(By.xpath(EdaatOR.Biller_subbiller_Corpbuildno)).sendKeys(Keys.PAGE_DOWN);
							 this.takeScreenShot();
							 verifyElementIsPresent(EdaatOR.Biller_CarpInvDisterror);						
							 verifyElementIsPresent(EdaatOR.Biller_CarpInvStreeterror);				
													
							 test.log(Status.PASS, "#FUNC-Subbiller Invalid General Info Error message" + driver.getTitle() + " * Subbiller Invalid General Info error message is Pass* ");
						  
						}
						else if(Expected.equalsIgnoreCase("Invalid General Info"))
						{
							
							 WebClickUsingJS(EdaatOR.Biller_AddSubBilleer);
							 EnterOperationalFeesInfo(testdatamap);	
							 EnterGeneralinfo(testdatamap);							
							 WebClick(EdaatOR.Biller_SubBillerAddButton);
							 driver.findElement(By.xpath(EdaatOR.Biller_Carporatesym)).sendKeys(Keys.PAGE_UP);
							 Thread.sleep(2000);
							 this.takeScreenShot();												
							 verifyElementIsPresent(EdaatOR.Biller_CarpInvNameerror);						
							 verifyElementIsPresent(EdaatOR.Biller_CarpInvCrNameerror);						
							 verifyElementIsPresent(EdaatOR.Biller_CarpInvIbanerror);						
							 verifyElementIsPresent(EdaatOR.Biller_CarpInvTaxNoerror);						
							 test.log(Status.PASS, "#FUNC-Subbiller Invalid National Address Error message" + driver.getTitle() + " * Subbiller Invalid National Address  error message is Pass* ");
						}
						else if(Expected.equalsIgnoreCase("Invoice Total"))
						{
							
							 WebClickUsingJS(EdaatOR.Biller_AddSubBilleer);
							 WebClick(EdaatOR.Biller_subbiller_Corpfees);
							 WebClick(EdaatOR.Biller_SubBillerAddButton);
							 Thread.sleep(500);
							 this.takeScreenShot();	
							 verifyElementIsPresent(EdaatOR.Biller_Invoicefees);
							 Thread.sleep(15000);
							 WebClickUsingJS(EdaatOR.Biller_subbiller_Corpfixedvalue);
							 Thread.sleep(500);
							 WebClick(EdaatOR.Biller_SubBillerAddButton);							
							 this.takeScreenShot();	
							 verifyElementIsPresent(EdaatOR.Biller_Fixedvaluereqerror);
							 Thread.sleep(20000);
							 WebClickUsingJS(EdaatOR.Biller_subbiller_Corpfixedvalue);
							 Thread.sleep(500);
							 WebClick(EdaatOR.Biller_subbiller_Corpperc);
							 Thread.sleep(500);
							 WebClick(EdaatOR.Biller_SubBillerAddButton);
							 Thread.sleep(500);
							 this.takeScreenShot();	
							 verifyElementIsPresent(EdaatOR.Biller_Percentagereqerror);
							 Thread.sleep(15000);								
							 WebClearandEdit(EdaatOR.Biller_subbiller_Corpperefield,testdatamap.get("Percentage").toString());						
							 WebClick(EdaatOR.Biller_SubBillerAddButton);
							 Thread.sleep(500);
							 this.takeScreenShot();	
							 verifyElementIsPresent(EdaatOR.Biller_OnlyEnterpercentageerrormsg);
							 Thread.sleep(15000);
							 driver.findElement(By.xpath(EdaatOR.Biller_Carporatesym)).sendKeys(Keys.PAGE_UP);
							 Thread.sleep(2000);
							 this.takeScreenShot();										
											
							 			
											
							 test.log(Status.PASS, "#FUNC-Subbiller Invoice Error message" + driver.getTitle() + " * Subbiller Invoice  error message is Pass* ");
						}
						else if(Expected.equalsIgnoreCase("Attachments"))
						{
							 WebClickUsingJS(EdaatOR.Biller_AddSubBilleer);
							 EnterOperationalFeesInfo(testdatamap);	
							 WebEdit(EdaatOR.Biller_subbiller_Corpname, testdatamap.get("BillerName").toString());
							 Thread.sleep(2000);
							 WebEdit(EdaatOR.Biller_subbiller_Corpcrnum, testdatamap.get("CRNumber").toString());
							 Thread.sleep(2000);
					       // EnterCRattach();
					      //  Thread.sleep(2000);
					    //    EnterIBANImg();
							 WebEdit(EdaatOR.Biller_subbiller_Corpiban, testdatamap.get("IBANNumber").toString());
							 Thread.sleep(2000);
							 WebEdit(EdaatOR.Biller_subbiller_Corpbenfname, testdatamap.get("BeneficiaryName").toString());
							 Thread.sleep(2000);
							 WebEdit(EdaatOR.Biller_subbiller_Corptaxnum, testdatamap.get("Taxnumber").toString());
							 this.takeScreenShot();
							 EnterNationalAddressinfo(testdatamap);
							 EnterContactInfo(testdatamap);
							 WebClick(EdaatOR.Biller_SubBillerAddButton);							
							 Thread.sleep(1000);							
							 this.takeScreenShot();
							 verifyElementIsPresent(EdaatOR.Biller_CarpEmpinvIbanatcerror);					
							
												
							 test.log(Status.PASS, "#FUNC-Subbiller Attachment Error message" + driver.getTitle() + " * Subbiller Attachment error message is Pass* ");
						}
						
							
						}
					  catch (Exception e) {
							test.log(Status.FAIL,"#FUNC-Add Corporate SubBiller Based on Invoice" + driver.getTitle() +" * Add Corporate SubBiller Based on Invoice * " );
						}
					}
			
			
		}



	
	
	
  
	
	
    

