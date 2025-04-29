/**
* Test Script Name  				 : N/A
* Objective     					 : To verify Corporate clients related functions.
* Version      						 : 1.0
* Author       						 : Kathirvelu M
* Created Date 			      		 : 16/05/2023
* Last Updated on					 : N/A
* Updated By   			 			 : Basavaraj Mudnur
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
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.azmqalabs.edaattestautomation.apppages.GlobalConstant;
import com.azmqalabs.edaattestautomation.apppages.masterpages.BasePage;
import com.azmqalabs.edaattestautomation.common.uielement.fieldDecorator;
import com.azmqalabs.edaattestautomation.objectrepository.EdaatOR;
import com.azmqalabs.edaattestautomation.common.Log;



public class BillerCorporatePage extends BasePage
{

	public BillerCorporatePage(WebDriver driver,ExtentTest test)
	{
		 this.driver=driver;
		 this.test=test;
		 
		 PageFactory.initElements(new fieldDecorator(driver,test), this);
	}  
	

	@FindBy(xpath = EdaatOR.Biller_Corporate)
	public WebElement Client;
		
	    
	    public boolean Exists(){
	    	return super.Exists(Client); 
		}

	//Function Summary : Method to create Corporate client 
	//Parameter Summary: CorporateName,CRNumber,PersonName,PersonID,MobileNo,Email,ClientRefno.
	public void AddCorporateclient(String CorporateName,String CRNumber,String PersonName,String PersonID,String MobileNo,String Email,String ClientRefno,Log Log){
       try{
        	AddCorpclient(CorporateName,CRNumber,PersonName,PersonID,MobileNo,Email,ClientRefno);
        		boolean Ele=BillerSearchCorporateclient(ClientRefno, CorporateName,CRNumber);
	        	if(Ele==true) {
	        		test.log(Status.PASS,"#FUNC-Add Corporate client" + driver.getTitle() +" * Add Corporate client PASS * " );
	        	Log.ReportEvent("PASS", "Verify Add Corporate Client is Suceessful");
	        	}else {
         	test.log(Status.FAIL,"#FUNC-Add Corporate client" + driver.getTitle() +" * Add Corporate client FAIL * " );
         	}
	        	}
        	catch(Exception e){
        	test.log(Status.FAIL,"#FUNC-Add Corporate client" + driver.getTitle() +" * Add Corporate client FAIL * " );
            this.takeScreenShot();
        	}
    	}
	public void Action(String Action,Log Log){
	    try{
	        WebClickUsingJS(EdaatOR.Biller_Add_Companyclient);
	        Thread.sleep(1000);        
	        if(Action.equalsIgnoreCase("View")) {                
	            if(CheckElementExists(EdaatOR.Biller_Corporateclient_tbl)==true) {
	                Thread.sleep(2000);
	                WebClear(EdaatOR.Biller_Corporateclient_search);
	                WebEdit(EdaatOR.Biller_Corporateclient_search,"corporate");                    
	                WebClick(EdaatOR.Biller_Individualclient_Search);
	                Thread.sleep(1000);
	                WebClick(EdaatOR.Biller_Individualclient_Searchname);
	                Thread.sleep(1000);
	                switchTonextwindow();
	                scrollDowntillend(driver);
	                this.takeScreenShot();
	                WebClick(EdaatOR.Biller_Individualclient_Back);
	                test.log(Status.PASS,"#FUNC-Corporate Client Table Exists" + driver.getTitle() +" * Corporatee Client Table Exists PASS * " );
	                Log.ReportEvent("PASS", "Verify Upadate Individual Client is Suceessfull");
	            }               
	        }else if(Action.equalsIgnoreCase("Deactivate")) {
	            WebEdit(EdaatOR.Biller_Corporateclient_search,"corporate");                    
	            WebClick(EdaatOR.Biller_Corporateclient_search);
	            Thread.sleep(2000);
	            WebClickUsingJS(EdaatOR.Biller_Individualclient_Deactivate);
	            Thread.sleep(2000);
	            WebClick(EdaatOR.Biller_Individualclient_button);
	            Thread.sleep(2000);
	            WebClickUsingJS(EdaatOR.Biller_Individualclient_Deactivate);
	            Thread.sleep(2000);
	            this.takeScreenShot();
	            WebClick(EdaatOR.Biller_Individualclient_button);
	            test.log(Status.PASS,"#FUNC-Corporate Client Deactivate/Activate Done" + driver.getTitle() +" * Corporate Client Deactivate/Activate Done PASS * " );
	            Log.ReportEvent("PASS", "Verify Upadate Individual Client is Suceessfull");
	        }else if(Action.equalsIgnoreCase("Excel")) {
	            WebClick(EdaatOR.Biller_Individualclient_export);
	            Thread.sleep(2000);    
	            this.takeScreenShot();
	            test.log(Status.PASS,"#FUNC-Export Done" + driver.getTitle() +" * Export Done PASS * " );
	            Log.ReportEvent("PASS", "Verify Upadate Individual Client is Suceessfull");
	        }else
	            test.log(Status.FAIL,"#FUNC-Updated Corporate client" + driver.getTitle() +" * Updated Corporate client FAIL * " );
	    }catch(Exception e){
	        test.log(Status.FAIL,"#FUNC-Updated Corporate client" + driver.getTitle() +" * Updated Corporate client FAIL * " );
	        this.takeScreenShot();
	    }
	}
	//Function Summary : Method to Search "corporate client" 
	//Parameter Summary: ClientRefno.
	public boolean BillerSearchCorporateclient(String ClientRefno,String CorporateName, String CRNumber){
		boolean existsElement = false;
		try{
				//added these two
			//	WebEdit(EdaatOR.Biller_Individualclient_Corponame,CorporateName);
			//  WebEdit(EdaatOR.Biller_Individualclient_Customercrnum,CRNumber); 	
				
            	
				WebEdit(EdaatOR.Biller_Individualclient_CustomerRefNumber,ClientRefno);
            	WebClick(EdaatOR.Biller_Individualclient_Search);
            	Thread.sleep(1000);
            	if(CheckElementExists("//td[text()='"+ClientRefno+"']")==true) {
            		existsElement=true;
    		    }
    	    	this.takeScreenShot();	    	
    	    
        }catch(Exception e){
        	e.printStackTrace();
	   	 	this.takeScreenShot();
        }
        return existsElement;
    }
public void TableGridview(String CorporateName){
	    try{
	    	WebClickUsingJS(EdaatOR.Biller_Add_Companyclient);
        	Thread.sleep(1000);    
        	if(CheckElementExists(EdaatOR.Biller_Corporateclient_tbl)==true) {
    			Thread.sleep(2000);
    			WebClear(EdaatOR.Biller_Corporateclient_search);
    			WebEdit(EdaatOR.Biller_Corporateclient_search,CorporateName);        			
    			WebClick(EdaatOR.Biller_Individualclient_Search);
    			Thread.sleep(1000);
    			WebClick(EdaatOR.Biller_Individualclient_Searchname);
    			Thread.sleep(1000);
    			switchTonextwindow();
    			scrollDowntillend(driver);
    			this.takeScreenShot();
    			WebClick(EdaatOR.Biller_Individualclient_Back);
    			test.log(Status.PASS,"#FUNC-Corporate Client Table Exists" + driver.getTitle() +" * Corporatee Client Table Exists PASS * " );
    		}       		
	    	else {
	    		test.log(Status.FAIL,"#FUNC-Corporate Client Table Not Exists" + driver.getTitle() +" * Corporate Client Table Not Exists FAIL * " );
	    	}
	    }catch(Exception e){
	    	test.log(Status.FAIL,"#FUNC-Table View Corporate client" + driver.getTitle() +" * Table View Corporate client FAIL * " );
	        this.takeScreenShot();
	    }
	}

public void ActivateDactivate(String CorporateName){
    try{
    	WebClickUsingJS(EdaatOR.Biller_Add_Companyclient);
    	Thread.sleep(1000);  
    	if(CheckElementClickable(EdaatOR.Biller_Corporateclient_search)==true) {
    		WebEdit(EdaatOR.Biller_Corporateclient_search,CorporateName);        			
			 WebClickUsingJS(EdaatOR.Biller_Product_SeachBtn);
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Biller_Individualclient_Deactivate);
			Thread.sleep(3000);
			WebClick(EdaatOR.Biller_Individualclient_button);
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Biller_Individualclient_Deactivate);
			Thread.sleep(2000);
			this.takeScreenShot();
			WebClick(EdaatOR.Biller_Individualclient_button);
			
			test.log(Status.PASS,"#FUNC-Corporate Client Deactivate/Activate Done" + driver.getTitle() +" * Corporate Client Deactivate/Activate Done PASS * " );
    	}	   		
    	else {
    		test.log(Status.FAIL,"#FUNC-Corporate Client Deactivate/Activate Not Done" + driver.getTitle() +" * Corporate Client Deactivate/Activate Not Done FAIL * " );
    	}
    }catch(Exception e){
    	test.log(Status.FAIL,"#FUNC-Corporate Client Deactivate/Activate Not Done" + driver.getTitle() +" * Table View Corporate client Not Done * " );
        this.takeScreenShot();
    }
}

public void Export(){
    try{
    	WebClickUsingJS(EdaatOR.Biller_Add_Companyclient);
    	Thread.sleep(1000);  
    	if(CheckElementClickable(EdaatOR.Biller_Corporateclient_search)==true) {
    		WebClick(EdaatOR.Biller_Individualclient_export);
			Thread.sleep(2000);    
			this.takeScreenShot();
			test.log(Status.PASS,"#FUNC-Export Done" + driver.getTitle() +" * Export Done PASS * " );
    	}	   		
    	else {
    		test.log(Status.FAIL,"#FUNC-Export Not Done" + driver.getTitle() +" * Export Not Done FAIL * " );
    	}
    }catch(Exception e){
    	test.log(Status.FAIL,"#FUNC-Export Not Done" + driver.getTitle() +" * Export Not Done * " );
        this.takeScreenShot();
    }
}
	
	//Function Summary : Navigate to "Corporate client list" and search for corporate client  
	//Parameter Summary: CorporateName,CRNumber,Corporateno.
	public boolean BillerSearchCorporateclientall(String CRNumber,String CorporateName,String Corporateno,Log Log){
		boolean existsElement = false;
		try{
				WebClickUsingJS(EdaatOR.Biller_Add_Companyclient);
	        	Thread.sleep(2000);
	        	WebEdit(EdaatOR.Biller_Corporateclient_Name,CorporateName);
				Thread.sleep(1000);
				WebEdit(EdaatOR.Biller_Corporateclient_Rno,CRNumber);
				Thread.sleep(1000);
				WebEdit(EdaatOR.Biller_Individualclient_CustomerRefNumber,Corporateno);
				Thread.sleep(2000);
            	WebClick(EdaatOR.Biller_Individualclient_Search);
				Thread.sleep(2000);
            	existsElement=ExistsCheck("//td[text()='"+CRNumber+"']");
            	if(existsElement==true) {
    	        	test.log(Status.PASS,"#FUNC-Search Corporate client" + driver.getTitle() +" * Search Corporate client PASS * " );
    	        	Log.ReportEvent("PASS", "Verify Corporate Client Search is Suceessful");
            	}
            	else {
    	        	test.log(Status.FAIL,"#FUNC-Search Corporate client" + driver.getTitle() +" * Search Corporate client FAIL * " );
            	}
				Thread.sleep(1000);
				this.takeScreenShot();
           	
        }catch(Exception e){
        	test.log(Status.FAIL,"#FUNC-Search Corporate client" + driver.getTitle() +" * Search Corporate client FAIL * " );
            this.takeScreenShot();
        }
        return existsElement;
    }
	
	//Function Summary : "Navigate to  add corporate clients" page and enter all details and Create corporate client 
	//Parameter Summary: CorporateName,CRNumber,PersonName,PersonID,MobileNo,Email,ClientRefno.
	public void AddCorpclient(String CorporateName,String CRNumber,String PersonName,String PersonID,String MobileNo,String Email,String ClientRefno){
        try{
                WebClickUsingJS(EdaatOR.Biller_Add_Companyclient);
            	Thread.sleep(1000);
            	WebClickUsingJS(EdaatOR.Biller_Add_Individualclient_Button);
            	Thread.sleep(1000);
            	WebEdit(EdaatOR.Biller_Corporateclient_name,CorporateName);
            	WebEdit(EdaatOR.Biller_Corporateclient_Rno,CRNumber);
            	WebClick(EdaatOR.Biller_Corporateclient_lang);
            	this.takeScreenShot();
            	WebEdit(EdaatOR.Biller_Corporateclient_commissioner,PersonName);
            	WebEdit(EdaatOR.Biller_Corporateclient_commissionerID,PersonID);
            	WebEdit(EdaatOR.Biller_Corporateclient_commissioner_Email,Email);
            	WebEdit(EdaatOR.Biller_Corporateclient_commissioner_Mobile,MobileNo);
            	WebEdit(EdaatOR.Biller_Corporateclient_commissioner_Crno,ClientRefno);	
            	Thread.sleep(1000);            	
            	this.takeScreenShot();
            	Thread.sleep(2000);   
            	WebClickUsingJS(EdaatOR.Biller_Individualclient_Add);
            	
        }catch(Exception e){
        	 e.printStackTrace();
        	 this.takeScreenShot();
        }
	}
	
	//Function Summary : Method to delete corporate client 
	//Parameter Summary: CorporateName, CRNumber, PersonName, PersonID, MobileNo, Email,ClientRefno,ResonforDelete 
	public void DeleteCorporateClient(String CorporateName,String CRNumber,String PersonName,String PersonID,String MobileNo,String Email,String ClientRefno, String ResonforDelete,Log Log){
	    try{
	    		AddCorpclient(CorporateName, CRNumber, PersonName, PersonID, MobileNo, Email,ClientRefno );
	    		BillerSearchCorporateclient(ClientRefno,CorporateName,CRNumber);
	        	boolean Ele=DeleteCorpClient(ClientRefno,ResonforDelete);
	        	if(Ele==true){
	        	test.log(Status.PASS,"#FUNC-Delete Corporate client" + driver.getTitle() +" * Delete Corporate client PASS * " );
	        	Log.ReportEvent("PASS", "Verify Delete Corporate Client is Suceessfull");
}
	        	else
	    	    	test.log(Status.FAIL,"#FUNC-Delete Corporate client" + driver.getTitle() +" * Delete Corporate client FAIL * " );
	    }catch(Exception e){
	    	test.log(Status.FAIL,"#FUNC-Delete Corporate client" + driver.getTitle() +" * Delete Corporate client FAIL * " );
	        this.takeScreenShot();
	    }
	}
	//Function Summary : Method to delete corporate client and check "deletedcheckbox".
	//Parameter Summary: ClientRefno,ResonforDelete,Delete	
	public boolean DeleteCorpClient(String ClientRefno,String ResonforDelete){
		boolean existsNID = false;
		try{
	    	if(getText("//td[text()='"+ClientRefno+"']").equals(ClientRefno)){
	    	selectDropdownValue_PartialText(EdaatOR.Biller_Invoice_Delete,"Delete");
	    	WebClick(EdaatOR.Biller_Invoice_Reasontxt);
	    	Thread.sleep(1000);
	    	WebClick("//ul/li[contains(text(),'"+ResonforDelete+"')]");
	    	Thread.sleep(1000);
	    	WebClick(EdaatOR.Biller_Invoice_Deletebtn);
	    	Thread.sleep(1000);
	    	WebEdit(EdaatOR.Biller_Individualclient_CustomerRefNumber,ClientRefno);
	    	Thread.sleep(1000);
	    	WebClick(EdaatOR.Biller_Invoice_Deletechkbox);
	    	Thread.sleep(1000);
	    	WebClickUsingJS(EdaatOR.Biller_Individualclient_Search);
	    	Thread.sleep(2000);
	    	if(CheckElementExists("//td[text()='"+ClientRefno+"']")==true) {
		    	existsNID=true;
		    }
	    	this.takeScreenShot();	    	
	    	}
	    	    	
	    }catch (Exception e) {
	    	e.printStackTrace();
	   	 	this.takeScreenShot();
		}
		return existsNID;
	    }
	
	//Function Summary : Method to Update the details of corporate client
	//Parameter Summary: CorporateName,CRNumber,PersonName,PersonID,ClientRefno,MobileNo,Email
	public void UpdateCorporateClient(String CorporateName,String CRNumber,String PersonName,String PersonID,String ClientRefno,String MobileNo,String Email,Log Log){
	    try{
	    		
	        	boolean Ele=UpdateCorpClient(CorporateName, PersonName, PersonID, ClientRefno,MobileNo, Email);
	        	if(Ele==true)
{
	        	test.log(Status.PASS,"#FUNC-Updated  Corporate client" + driver.getTitle() +" * Updated Corporate client PASS * " );
	        	Log.ReportEvent("PASS", "Verify Upadate Corporate Client is successful");
}
	        	else
	    	    	test.log(Status.FAIL,"#FUNC-Updated Corporate client" + driver.getTitle() +" * Updated Corporate client FAIL * " );
	    }catch(Exception e){
	    	test.log(Status.FAIL,"#FUNC-Updated Corporate client" + driver.getTitle() +" * Updated Corporate client FAIL * " );
	        this.takeScreenShot();
	    }
	}
		
	//Function Summary : Navigate to "Edit Corporate Client Data"page and update the details of  corporate client.
	//Parameter Summary: Edit,CorporateName,PersonName,PersonID,MobileNo,Email,ClientRefno
	public boolean UpdateCorpClient(String CorporateName,String PersonName,String PersonID,String ClientRefno,String MobileNo,String Email){
		boolean existsNID = false;
		try{
			WebClickUsingJS(EdaatOR.Biller_Add_Companyclient);
        	Thread.sleep(2000);	    	
	    	selectDropdownValue_PartialText(EdaatOR.Biller_Invoice_Delete,"Edit");
	    	Thread.sleep(2000);
	    	switchTonextwindow();    	
	        Thread.sleep(1000);	
	    	WebClear(EdaatOR.Biller_Corporateclient_name);
	        Thread.sleep(1000);	
	    	WebEdit(EdaatOR.Biller_Corporateclient_name,CorporateName);
	    	WebClear(EdaatOR.Biller_Corporateclient_commissioner);
  	        Thread.sleep(1000);	
        	WebEdit(EdaatOR.Biller_Corporateclient_commissioner,PersonName);
	        Thread.sleep(1000);	
	    	WebClear(EdaatOR.Biller_Corporateclient_commissionerID);
        	WebEdit(EdaatOR.Biller_Corporateclient_commissionerID,PersonID);
        	WebClear(EdaatOR.Biller_Corporateclient_commissioner_Mobile);
        	WebEdit(EdaatOR.Biller_Corporateclient_commissioner_Mobile,MobileNo);
	        Thread.sleep(1000);	
        	WebClear(EdaatOR.Biller_Corporateclient_commissioner_Email);
	        Thread.sleep(1000);	
        	WebEdit(EdaatOR.Biller_Corporateclient_commissioner_Email,Email);
	        Thread.sleep(1000);	
        	WebClear(EdaatOR.Biller_Corporateclient_commissioner_Crno);
	        Thread.sleep(1000);	
        	WebEdit(EdaatOR.Biller_Corporateclient_commissioner_Crno,ClientRefno);
        	Thread.sleep(2000);
        	this.takeScreenShot();	 
        	WebClickUsingJS(EdaatOR.Biller_Corporateclient_Save);
	    	Thread.sleep(2000);
	    	if(CheckElementExists("//span[text()='"+CorporateName+"']")==true) {
		    	existsNID=true;
		    	Thread.sleep(2000);
		    }
	    	  	
	    	    	
	    }catch (Exception e) {
	    	e.printStackTrace();
	   	 	this.takeScreenShot();
		}
		return existsNID;
	    }
	
	//Function Summary : Method to select "subbiller" and select "Name or register number" of subbiller from dropdowns  
	//Parameter Summary: SubBiller,FixedPrice,FixedPercentage.
	public void selectSubbiller(String drop,Map<Object,Object> testdatamap) throws Exception {
		Thread.sleep(500);
		WebClickUsingJS(EdaatOR.Biller_Invoice_Subbill);
		SelectInvoiceTemplate(drop,testdatamap.get("SubBiller").toString());
		waitForPageToLoad();
		EnterFixedPrice(testdatamap.get("FixedPrice").toString());
		EnterPercentage(testdatamap.get("FixedPercentage").toString());
		
	}
	
	//Function Summary : Method to select "Name or Register number" of subbiller from dropdown.  
	//Parameter Summary: N/A
	public void SelectInvoiceTemplate(String sel, String Tem) throws InterruptedException {
		Thread.sleep(500);
		selectDropdownValue_PartialText(sel, Tem);
	}
	
	//Function Summary : Method to click on "add product" button in "create invoice"page  
	//Parameter Summary: N/A
	public void ClickOnProductBtn() {
		WebClick(EdaatOR.Biller_Invoice_AddProductBtn);
		waitForPageToLoad();
	}
	
	//Function Summary : Method to select "product" from dropdown.  
	//Parameter Summary: N/A
	public void SelectProduct(String Cust) { 
		WebSelect(EdaatOR.Biller_Invoice_ProductID,Cust);
		waitForPageToLoad();
	}
	
	//Function Summary : Method to click on "add" button in "add product"popup.  
	//Parameter Summary: N/A
	public void ClickOnProductAddBtn() {
		WebClick(EdaatOR.Biller_Invoice_AddBtn);
		waitForPageToLoad();
	}
	
	//Function Summary : Method to enter"Invoice Due Date" in "Create invoice"page 
	//Parameter Summary: N/A
	public void EnterIssuedDate() throws Exception {
		WebClick(EdaatOR.Biller_Invoice_DateInvoc);
		Thread.sleep(800);
		WebClick(EdaatOR.Biller_RegistDate_exprDate);
	}
	public void SelectDuration(String dur) {
		WebSelect(EdaatOR.Biller_Invoice_DurationID,dur);
		waitForPageToLoad();
	}

	public void EnterMinPrice(String Price) {
		WebEdit(EdaatOR.Biller_Invoice_MinTax,Price);
		waitForPageToLoad();
	}
	public void EnterFixedPrice(String Price) {
		WebEdit(EdaatOR.Biller_Invoice_Fixed,Price);
		waitForPageToLoad();
	}
	
	//Function Summary : Method to click on "Create and save" button in "Create Invoice"page. 
	//Parameter Summary: N/A
	public void ClickOnSaveBtn() {
		WebClickUsingJS(EdaatOR.Biller_Invoice_Create);
		waitForPageToLoad();
	}
	
	//Function Summary : Method to click on "Create and Export" button in "Create Invoice"page. 
	//Parameter Summary: N/A
	public void ClickOnExportBtn() {
		WebClickUsingJS(EdaatOR.Biller_Invoice_ExportButton);
		waitForPageToLoad();
	}

	public void EnterCondition(String Price) {
		WebEdit(EdaatOR.Biller_Invoice_Conditon,Price);
		waitForPageToLoad();
	}
	public void EnterPercentage(String Price) {
		WebEdit(EdaatOR.Biller_Invoice_Percentage,Price);
		waitForPageToLoad();
	}
	public void ClickOnCreateInvoiceBtn() {
		WebClickUsingJS(EdaatOR.Biller_Invoice_CreateReapeat);
		waitForPageToLoad();
	}
	public void EnterDescriptionSaved(String Price) {
		WebEdit(EdaatOR.Biller_Invoice_Descript,Price);
		waitForPageToLoad();
	}

	public void EnterDescriptionOne(String Price) {
		WebEdit(EdaatOR.Biller_Invoice_Descript1,Price);
		waitForPageToLoad();
	}
	//Function Summary : Method to select "Invoice Template" from dropdown. 
	//Parameter Summary: N/A
	public void WebSelectByVisibleText(String sEleXpath, String sText) {
		try {
			Select select = new Select(driver.findElement(By.xpath(sEleXpath)));
			select.selectByVisibleText(sText);
			Thread.sleep(500);	
			waitForPageToLoad();
			
		} catch (Exception e) {
			// Code to reset implicit wait and select value and then reset implicit wait
			Select select1 = new Select(driver.findElement(By.xpath(sEleXpath)));
			select1.selectByVisibleText(sText);
			waitForPageToLoad();
			test.log(Status.INFO, "WebSelectByVisibleText - Not Found");
		}
	}
	public void selectTemplate(String drop,Map<Object,Object> testdatamap) throws Exception {

		Thread.sleep(500);	
		waitForPageToLoad();
		
		waitForPageToLoad();
	}
	
	//Function Summary : Method to add "product" in "add product"popup.
	//Parameter Summary: ProductName.
	public void addProductDetails(Map<Object,Object> testdatamap) throws Exception {
		ClickOnProductBtn();
		Thread.sleep(1000);
		SelectProduct(testdatamap.get("ProductName").toString());
		Thread.sleep(2000);
		//EnterProductPrice(testdatamap.get("ProductPrice").toString());
		ClickOnProductAddBtn();
		Thread.sleep(2000);
	}
	
	//Function Summary : Method enter "Invoice Due Date" in "Create invoice"page
	//Parameter Summary: N/A
	public void enterInvoicDetails(Map<Object,Object> testdatamap) throws Exception {
		EnterIssuedDate();
//		SelectDuration(testdatamap.get("Duration").toString());
//		EnterMinPrice(testdatamap.get("MinPrice").toString());
//		EnterCondition(testdatamap.get("InvoiceCondition").toString());
//		ClickOnCreateInvoiceBtn();
		Thread.sleep(2000);
	}
	//Function Summary : Method to click on "Create and save" or "Create and Export"button in "create invoice" page
	//Parameter Summary: InvoiceType,Save,Export.
	public void enterInvoiceCaseType(Map<Object,Object> testdatamap) throws Exception {
//		EnterDescriptionSaved(testdatamap.get("Description").toString());
//		EnterDescriptionOne(testdatamap.get("Description").toString());
		String iType=testdatamap.get("InvoiceType").toString();
		if(iType.equalsIgnoreCase("Save")) {
			ClickOnSaveBtn();
		}
		else if(iType.equalsIgnoreCase("Export")){
			ClickOnExportBtn();
		}
		Thread.sleep(2000);
	}

	//Function Summary : Method to get the "count of the invoices" in the "Grid view" 
	//Parameter Summary: N/A
	public int getInvoiceCountAdd() {
		List<WebElement> invoice = driver.findElements(By.xpath(EdaatOR.Biller_Invoice_AfteraddInvoice));
		waitForPageToLoad();
		int count =invoice.size();
		return count;
	}
    
	//Function Summary : Method to create Corporate client invoice  
	//Parameter Summary: Create Invoice,InvoiceType,Template Name.
	public void CreateCorporateClientInvoice(Map<Object,Object> testdatamap,Log Log) throws Exception {
		try {
			WebClickUsingJS(EdaatOR.Biller_Add_Companyclient);
        	Thread.sleep(1000);	    	
	    	selectDropdownValue_PartialText(EdaatOR.Biller_Invoice_Delete,"Create Invoice");
        	Thread.sleep(2000);	    	
//	    	WebClick(EdaatOR.Biller_Invoice_Reasontxt);
	    	switchTonextwindow();
        	Thread.sleep(1000);	    	
	    	String iType=testdatamap.get("InvoiceType").toString();
//			if(iType.equalsIgnoreCase("Save")) {
//				int intiCount=getInvoiceCountNext();
//				naviagteCreateInvoicePage();
				//enterClientNameOrNationalID(testdatamap);
				selectSubbiller(EdaatOR.Biller_Invoice_SBilIdList,testdatamap);
				Thread.sleep(2000);
				
				WebClickUsingJS(EdaatOR.Biller_Invoice_TemplateList);
	        	Thread.sleep(1000);	    	
				WebSelectByVisibleText(EdaatOR.Biller_Invoice_TemplateList,testdatamap.get("TemplateName").toString());
	        	Thread.sleep(1000);	    	
//				selectTemplate(EdaatOR.Biller_Invoice_TemplateList,testdatamap);
				addProductDetails(testdatamap);
				enterInvoicDetails(testdatamap);
				enterInvoiceCaseType(testdatamap);
//				int afterSave=getInvoiceCountNextAfteradd();
//				VerifyTwoIntValue(intiCount+1, afterSave);
	        	Thread.sleep(1000);	    	

				int val=getInvoiceCountAdd();
	        	Thread.sleep(1000);	    	
				if(CheckElementExists(EdaatOR.Biller_Invoice_AfteraddInvoice+"["+val+"]/td[10]")==true){
					test.log(Status.PASS,"#FUNC- Create Corporate Client Invoice" + driver.getTitle() +" * Create Corporate Client Invoice PASS * " );
					Log.ReportEvent("PASS", "Verify Create Corporate Client Invoice is Suceessfull");
				}
				else{
					test.log(Status.FAIL,"#FUNC- Create Corporate Client Invoice" + driver.getTitle() +" *Create Corporate Client Invoice FAIL * " );
				}
				this.takeScreenShot();
			

		}
		catch(Exception e){
			test.log(Status.FAIL,"#FUNC-Create Corporate Client Invoice" + driver.getTitle() +" * Create Corporate Client Invoice FAIL * " );
			this.takeScreenShot();
		}
	}
	
 		//Function Summary  : method to verify Add Corporate client page fields error messages
		//Parameter Summary : CorporateName,CRNumber,PersonName,PersonID,MobileNo,Email,ClientRefno,ExpectedResult
		public void VerifyAddCorpClietErrorMsg(String CorporateName,String CRNumber,String PersonName,String PersonID,String MobileNo,String Email,String ClientRefno,String ExpectedResult) throws InterruptedException{
		{
				AddCorpclient( CorporateName, CRNumber, PersonName, PersonID, MobileNo, Email, ClientRefno);					
				Thread.sleep(50);
				this.takeScreenShot();
				try {
					if(ExistsCheck(EdaatOR.Biller_ClientRefExistsAlertMsg)) {
						VerifyValue1(ExpectedResult,getText(EdaatOR.Biller_ClientRefExistsAlertMsg));				
						test.log(Status.PASS, "#FUNC-Corporate Client Reference number Exists alert Message Exists" + driver.getTitle() + " *Client Ref alert Message Exists * ");
						}
					else if (ExistsCheck(EdaatOR.Biller_RequiredFieldsErrMsg)){	
						this.takeScreenShot();
						VerifyValue1(ExpectedResult, getText(EdaatOR.Biller_RequiredCorpNameErrMsg));
						VerifyValue1(ExpectedResult, getText(EdaatOR.Biller_RequiredCRNoErrMsg));
						VerifyValue1(ExpectedResult, getText(EdaatOR.Biller_RequiredAuthNameErrMsg));
						VerifyValue1(ExpectedResult, getText(EdaatOR.Biller_RequiredAuthIDErrMsg));
						VerifyValue1(ExpectedResult, getText(EdaatOR.Biller_RequiredAuthMobileNoErrMsg));	
						test.log(Status.PASS, "#FUNC-Corporate Client Required field ErrorMessage Exists" + driver.getTitle() + " *   Error Message Exists * ");
						}
					else if (ExistsCheck(EdaatOR.Biller_RequiredCRNoErrMsg)) {
						VerifyValue1(ExpectedResult, getText(EdaatOR.Biller_RequiredCRNoErrMsg));
						test.log(Status.PASS, "#FUNC-Corporate Client CR Number ErrorMessage Exists" + driver.getTitle() + " *CR Number ErrorMessage Exists * ");
						}
					else if (ExistsCheck(EdaatOR.Biller_RequiredAuthIDErrMsg)){	
						VerifyValue1(ExpectedResult, getText(EdaatOR.Biller_RequiredAuthIDErrMsg));			
						test.log(Status.PASS, "#FUNC-Corporate Client Authorized person ID ErrorMessage Exists" + driver.getTitle() + " *Authorized person ID ErrorMessage Exists * ");
						}
					else if (ExistsCheck(EdaatOR.Biller_RequiredAuthMobileNoErrMsg)){	
						VerifyValue1(ExpectedResult, getText(EdaatOR.Biller_RequiredAuthMobileNoErrMsg));		
						test.log(Status.PASS, "#FUNC-Corporate Client Mobile No ErrorMessage Exists" + driver.getTitle() + " *Mobile No ErrorMessage Exists * ");
						}
					else {
						test.log(Status.FAIL, "#FUNC-No error Exists" + driver.getTitle() + " * No error Exists * ");
						}
					} 
				catch (Exception e) {
					//test.log(Status.FAIL,ErrorFontColorPrefix + " AdminIndividualClient Page - Add Individual Client failed - unable to Enter" + e+ ErrorFontColorSuffix);
					throw new NoSuchElementException("Add Corporate Client "+ "Page - Not Loaded");
				}
			}
	}
	
		
		//Function Summary  : method to verify Error messages in Edit Corporate client page
		//Parameter Summary : CorporateName,PersonName,PersonID,MobileNo,Email,ClientRefno,ExpectedResult
		public void VerifyEditCorpClietErrorMsg(String CorporateName,String PersonName,String PersonID,String MobileNo,String Email,String ClientRefno,String ExpectedResult) throws InterruptedException{
		{
				UpdateCorpClient( CorporateName, PersonName, PersonID, ClientRefno, MobileNo, Email);										
				this.takeScreenShot();
				try {
					if(ExistsCheck(EdaatOR.Biller_ClientRefExistsAlertMsg)) {
						VerifyValue1(ExpectedResult,getText(EdaatOR.Biller_ClientRefExistsAlertMsg));				
						test.log(Status.PASS, "#FUNC-Corporate Client Reference number Exists alert Message Exists" + driver.getTitle() + " *Client Ref alert Message Exists * ");
					}
					else if (ExistsCheck(EdaatOR.Biller_RequiredFieldsErrMsg)){	
						this.takeScreenShot();
						VerifyValue1(ExpectedResult, getText(EdaatOR.Biller_RequiredCorpNameErrMsg));
						VerifyValue1(ExpectedResult, getText(EdaatOR.Biller_RequiredAuthNameErrMsg));
						VerifyValue1(ExpectedResult, getText(EdaatOR.Biller_RequiredAuthIDErrMsg));
						VerifyValue1(ExpectedResult, getText(EdaatOR.Biller_RequiredAuthMobileNoErrMsg));	
						test.log(Status.PASS, "#FUNC-Corporate Client Required field ErrorMessage Exists" + driver.getTitle() + " *   Error Message Exists * ");
					}
					else if (ExistsCheck(EdaatOR.Biller_RequiredAuthIDErrMsg)){	
						VerifyValue1(ExpectedResult, getText(EdaatOR.Biller_RequiredAuthIDErrMsg));			
						test.log(Status.PASS, "#FUNC-Corporate Client Authorized person ID ErrorMessage Exists" + driver.getTitle() + " *Authorized person ID ErrorMessage Exists * ");
					}
					else if (ExistsCheck(EdaatOR.Biller_RequiredAuthMobileNoErrMsg)){	
						VerifyValue1(ExpectedResult, getText(EdaatOR.Biller_RequiredAuthMobileNoErrMsg));		
						test.log(Status.PASS, "#FUNC-Corporate Client Mobile No ErrorMessage Exists" + driver.getTitle() + " *Mobile No ErrorMessage Exists * ");
					}
					else {
						test.log(Status.FAIL, "#FUNC-No error Exists" + driver.getTitle() + " * No error Exists * ");
						}
	 				} 
					catch (Exception e) {
					//test.log(Status.FAIL,ErrorFontColorPrefix + " AdminIndividualClient Page - Add Individual Client failed - unable to Enter" + e+ ErrorFontColorSuffix);
					throw new NoSuchElementException("Add Corporate Client "+ "Page - Not Loaded");
					}
				}
		}	
	
		
		//Function Summary  : method to verify Error messages in delete Corporate client page
		//Parameter Summary : ExpectedResult
		public void VerifyDeleteCorpClietErrorMsg(String ExpectedResult) throws InterruptedException{
			{
				try {
					WebClickUsingJS(EdaatOR.Biller_Add_Companyclient);	
					Thread.sleep(500);
					selectDropdownValue_PartialText(EdaatOR.Biller_Invoice_Delete,"Delete");
					Thread.sleep(500);
					WebClick(EdaatOR.Biller_Invoice_Deletebtn);
					this.takeScreenShot();
					if (ExistsCheck(EdaatOR.Biller_DeleteClientErrMsg)){	
						VerifyValue1(ExpectedResult, getText(EdaatOR.Biller_DeleteClientErrMsg));			
						test.log(Status.PASS, "#FUNC-Corporate Client delete ErrorMessage Exists" + driver.getTitle() + " *Delete Error Message Exists * ");
					}
	 				else {
						test.log(Status.FAIL, "#FUNC-No error Exists" + driver.getTitle() + " * No error Exists * ");
					}
				}
				catch (Exception e) {
					//test.log(Status.FAIL,ErrorFontColorPrefix + " AdminIndividualClient Page - Add Individual Client failed - unable to Enter" + e+ ErrorFontColorSuffix);
					throw new NoSuchElementException("Delete Corporate Client "+ "Page - Not Loaded");
				}
	 		}
		}   
}
