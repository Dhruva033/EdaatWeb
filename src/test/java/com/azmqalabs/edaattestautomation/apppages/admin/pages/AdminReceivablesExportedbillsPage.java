/**
* Test Script Name                   : N/A
* Objective                          : Admin Receivables related functions
* Version                            : 1.0
* Author                             : Kathirvelu M
* Created Date                       : 
* Last Updated on                    : N/A
* Updated By                         : Basavaraj Mudnur
* Pre-Conditions                     : N/A
* Manual Testcase Name               : N/A
* Epic Details                       : N/A
* User Story Details                 : N/A
**/
package com.azmqalabs.edaattestautomation.apppages.admin.pages;

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



public class AdminReceivablesExportedbillsPage extends BasePage
{

	public AdminReceivablesExportedbillsPage(WebDriver driver,ExtentTest test)
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
	//Function Summary  : Method to Click On Receivable Link
	//Parameter Summary : N/A

	public void ClickOnBReceivableLink() {
		WebClickUsingJS(EdaatOR.Admin_Receivable_Link);
		waitForPageToLoad();
	}
	//Function Summary   : Method to Click On Admin ExportBill Link
	//Parameter Summary  : N/A

	public void ClickOnAdminExportBillLink() {
		WebClickUsingJS(EdaatOR.Admin_ExportBill_Link);
		waitForPageToLoad();
	}
	//Function Summary   : Method to Click On Admin ExportBill Link
	//Parameter Summary  : N/A
	public void ClickOnExportInvoiceBtn() {
		WebClickUsingJS(EdaatOR.Admin_AddInvoice_btn);
		waitForPageToLoad();
	}
	//Function Summary  : Method to ClickOnCoporateRadBtn
	//Parameter Summary : N/A
	public void ClickOnCoporateRadBtn() {
		WebClickUsingJS(EdaatOR.Admin_Invoice_CopoRdv);
		waitForPageToLoad();
	}
//Function Summary  : Methodclick on individual radio button.
//Parameter Summary :N/A
	public void ClickOnIndividualRadBtn() {
		WebClickUsingJS(EdaatOR.Admin_Invoice_IndividualRdv);
		waitForPageToLoad();
	}

//Function Summary  : To select Client name.
//Parameter Summary : N/A
	public void SelectIndCustomerID(String Cust) throws Exception {
		WebClick(EdaatOR.Admin_Invoice_CustIDList);
		Thread.sleep(2000);
		WebClick(EdaatOR.Admin_Invoice_ClientRoleId+"["+Cust+"]");
		waitForPageToLoad();
	    Thread.sleep(1000);


	}
//Function Summary  : To select Client name.
//Parameter Summary : N/A
	public void SelectCopCustomerID(String Cust) throws Exception {
		WebClick(EdaatOR.Admin_Invoice_ComCustIDList);
		Thread.sleep(2000);
		WebClick(EdaatOR.Admin_Invoice_ClientRoleId+"["+Cust+"]");
		waitForPageToLoad();
		Thread.sleep(1000);
	}
//Function Summary  : To select sub biller name.
//Parameter Summary : N/A
	public void SelectSubAdmin(String SubAdmin) throws InterruptedException {
		//WebSelect1(EdaatOR.Admin_Invoice_SBilIdList,SubAdmin);
		WebClick(EdaatOR.Admin_Invoice_SBilIdList);
		Thread.sleep(1500);
		WebClick(EdaatOR.Admin_Invoice_ClientRoleId+"["+SubAdmin+"]");
		Thread.sleep(2000);
		waitForPageToLoad();
	}
	//Function Summary   : Method to  SelectInvoiceTemplate
	//Parameter Summary  : N/A
	public void SelectInvoiceTemplate(String Tem) throws InterruptedException{
		WebSelect(EdaatOR.Admin_Invoice_TemplateList,Tem);
		Thread.sleep(2000);
		waitForPageToLoad();
	}

//Function Summary  : To click on add product button.
//Parameter Summary : N/A
	public void ClickOnProductBtn() {
		WebClickUsingJS(EdaatOR.Admin_Invoice_AddProductBtn);
		waitForPageToLoad();
	}
//Function Summary  :To select product.
//Parameter Summary : Product name
	public void SelectProduct(String Cust) throws InterruptedException {
		Thread.sleep(2000);
		WebSelect(EdaatOR.Admin_Invoice_ProductID,Cust);
		waitForPageToLoad();
		Thread.sleep(2000);
	}
//Function Summary  :To enter product price
//Parameter Summary : price
	public void EnterProductPrice(String Price) throws Exception {
		Thread.sleep(1000);
		WebClearUsingKeys(EdaatOR.Admin_Invoice_TaxPric);
		WebEdit(EdaatOR.Admin_Invoice_TaxPric,Price);
		waitForPageToLoad();
	}
//Function Summary  :To click on add button
//Parameter Summary :N/A.
	public void ClickOnProductAddBtn() throws InterruptedException {
		Thread.sleep(1000);
		WebClickUsingJS(EdaatOR.Admin_Invoice_AddBtn);
		waitForPageToLoad();
		Thread.sleep(1000);
	}
//Function Summary  :To click on date.
//Parameter Summary :N/A.
	public void EnterIssuedDate() throws Exception {
		Thread.sleep(800);
		WebClick(EdaatOR.Admin_Invoice_DateInvoc);
		Thread.sleep(1000);
		WebClickUsingJS(EdaatOR.Admin_RegistDate_exprDate);
		Thread.sleep(1000);
	}
//Function Summary  :To Select duration.
//Parameter Summary :Duration
	public void SelectDuration(String dur) throws InterruptedException {
		Thread.sleep(1000);
		WebSelect1(EdaatOR.Admin_Invoice_DurationID,dur);
		waitForPageToLoad();
	}
	//Function Summary   : Method to EnterMinPrice
	//Parameter Summary  : N/A
	public void EnterMinPrice(String Price) {
		WebEdit(EdaatOR.Admin_Invoice_MinTax,Price);
		waitForPageToLoad();
	}
//Function Summary  :To Enter condition.
//Parameter Summary :N/A.
	public void EnterCondition() {
		WebClickUsingJS(EdaatOR.Admin_Invoice_Conditonbtn);
		waitForPageToLoad();
	}
//Function Summary  :To Click on create installments button
//Parameter Summary :N/A.
	public void ClickOnCreateInvoiceBtn() {
		WebClickUsingJS(EdaatOR.Admin_Invoice_CreateReapeat);
		waitForPageToLoad();
	}
	//Function Summary   : Method to EnterDescriptionSaved
	//Parameter Summary  : N/A
	public void EnterDescriptionSaved(String Price) {
		WebEdit(EdaatOR.Admin_Invoice_Descript,Price);
		waitForPageToLoad();
	}
	//Function Summary   : Method to nterDescriptionOne
	//Parameter Summary  : N/A
	public void EnterDescriptionOne(String Price) {
		WebEdit(EdaatOR.Admin_Invoice_Descript1,Price);
		waitForPageToLoad();
	}
//Function Summary  : To click on save button.
//Parameter Summary : N/A.
	public void ClickOnSaveBtn() {
		WebClickUsingJS(EdaatOR.Admin_Invoice_SaveButton);
		waitForPageToLoad();
	}
	//Function Summary   : Method to ClickOnExportBtn
	//Parameter Summary  : N/A
	public void ClickOnExportBtn() {
WebClick(EdaatOR.Admin_Invoice_SaveButton);
		waitForPageToLoad();
	}
	//Function Summary   : Method to  ClickOnLastCheckBoxBtn
	//Parameter Summary  : N/A
	public void ClickOnLastCheckBoxBtn() throws InterruptedException {
        Thread.sleep(1000);   
		WebClickUsingJS(EdaatOR.Admin_InvoiceLastCheckBox);
		waitForPageToLoad();
	}

	public String getAdminID() {
		String ID=getText(EdaatOR.Admin_Invoice_GetBilId);
		waitForPageToLoad();
		return ID;
	}

	public String getAdminContactID() {
		String ID=getText(EdaatOR.Admin_Invoice_GetContactId);
		waitForPageToLoad();
		return ID;
	}


	public void ClickOnAdminExportContactLink() {
		WebClickUsingJS(EdaatOR.Admin_ExportContact_Link);
		waitForPageToLoad();
	}


//Function Summary  :Navigate to Exported contract.
//Parameter Summary :N/A
	public void naviagteReveiableExportContact() {
		ClickOnBReceivableLink();
		ClickOnAdminExportContactLink();
		waitForPageToLoad();
	}


	public int getInvoiceCount() {
		List<WebElement> invoice = driver.findElements(By.xpath(EdaatOR.Admin_Invoice_Count));
		waitForPageToLoad();
		int count =invoice.size();
		System.out.println(count);
		return count;
	}


	public int getInvoiceCountNext() throws Exception {
		int intiCount=0;
		boolean countRow=false;
		while (CheckElementExists(EdaatOR.Admin_Invoice_Next)==false){  
			WebClick(EdaatOR.Admin_Invoice_NextPrevLink);
			int count=getInvoiceCount();
			String pageNum=getText(EdaatOR.Admin_Invoice_NextPrevLink);
			Thread.sleep(1000);
			intiCount=intiCount+getInvoiceCount()+((Integer.valueOf(pageNum)-1)*10);
			countRow=true;
		}

		if(countRow==false) {
			intiCount=10;
		}
		return intiCount;
	}


	public int getInvoiceCountAdd() {
		List<WebElement> invoice = driver.findElements(By.xpath(EdaatOR.Admin_Invoice_AfteraddInvoice));
		waitForPageToLoad();
		int count =invoice.size();
		return count;
	}

	public int getInvoiceCountNextAfteradd() throws Exception {
		int aftCount=0;
		boolean countRow=false;
		while (CheckElementExists(EdaatOR.Admin_Invoice_Next)==false){  
			WebClick(EdaatOR.Admin_Invoice_NextPrevLink);
			int count=getInvoiceCount();
			String pageNum=getText(EdaatOR.Admin_Invoice_NextPrevLink);
			Thread.sleep(1000);
			aftCount=aftCount+getInvoiceCount()+((Integer.valueOf(pageNum)-1)*10);
			countRow=true;
		}

		if(countRow==false) {
			aftCount=10;
		}
		return aftCount;
	}

//Function Summary  :Navigate to Receivables and Exported Bills.
//Parameter Summary :N/A 
	public void naviagteReveiableExportAdmin(Log Log) {
		ClickOnBReceivableLink();
		ClickOnAdminExportBillLink();
		waitForPageToLoad();
		this.takeScreenShot();
    	Log.ReportEvent("PASS", "Verify naviagted Suceessfull Export Bill Page");

	}
//Function Summary  :click on create invoice button
//Parameter Summary : N/A
	public void naviagteCreateInvoicePage() {
		ClickOnExportInvoiceBtn();
		waitForPageToLoad();

	}

//Function Summary  :click on individual or corporate radio button 
//Parameter Summary : Client Name.
	public void enterClientNameOrNationalID(Map<Object,Object> testdatamap) throws Exception {
		String client=testdatamap.get("ClientID").toString();
		if(client.equalsIgnoreCase("Individual")) {
           Thread.sleep(1000);
			ClickOnIndividualRadBtn();
            Thread.sleep(2000);
			SelectIndCustomerID(testdatamap.get("ClientName").toString());
            Thread.sleep(2000);
		}
		else if(client.equalsIgnoreCase("Corporate")){
			ClickOnCoporateRadBtn();
            Thread.sleep(1000);
			SelectCopCustomerID(testdatamap.get("ClientName").toString());
		}
		String sBill=testdatamap.get("SubAdmin").toString();
		if(!sBill.equalsIgnoreCase("")) {
            Thread.sleep(1000);
			SelectSubAdmin(sBill);
           Thread.sleep(500);
		}

	}
//Function Summary  :To select template
//Parameter Summary :TemplateName
	public void selectTemplate(Map<Object,Object> testdatamap) throws Exception {
		Thread.sleep(1000);
		SelectInvoiceTemplate(testdatamap.get("TemplateName").toString());
	}
//Function Summary  :To add product details
//Parameter Summary :ProductName and ProductPrice.
	public void addProductDetails(Map<Object,Object> testdatamap) throws Exception {
		ClickOnProductBtn();
		Thread.sleep(1500);
		SelectProduct(testdatamap.get("ProductName").toString());
		Thread.sleep(2000);
		waitForPageToLoad();
	//	EnterProductPrice(testdatamap.get("ProductPrice").toString());
		ClickOnProductAddBtn();
		Thread.sleep(1000);

	}
	//Function Summary  :To Enter invoice details.
	//Parameter Summary :Enter invoice due date ,select duration,enter condition and click on create invoice button
		public void ExportInvoicedetails(Map<Object,Object> testdatamap) throws Exception {
			EnterIssuedDate();
			//SelectDuration(testdatamap.get("Duration").toString());
			//EnterMinPrice(testdatamap.get("MinPrice").toString());
			EnterCondition();
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Admin_Invoice_ExportButton1);
			//ClickOnCreateInvoiceBtn();
			Thread.sleep(1000);
		}
		
		public void ClickOnExportandcreatBtn()throws InterruptedException {
			WebClickUsingJS(EdaatOR.Admin_Invoice_Exportandcreatebtn1);
            Thread.sleep(1000);
			waitForPageToLoad();
		}
		
		public void ClickOninstallmentBtn() throws InterruptedException {
            Thread.sleep(500);
			WebClickUsingJS(EdaatOR.Admin_Invoice_installmentButton);
			waitForPageToLoad();
		}
//Function Summary  :To Enter invoice details.
//Parameter Summary :Enter invoice due date ,select duration,enter condition and click on create invoice button
	public void enterInvoicDetails(Map<Object,Object> testdatamap) throws Exception {
	/*	EnterIssuedDate();
		SelectDuration(testdatamap.get("Duration").toString());
		//EnterMinPrice(testdatamap.get("MinPrice").toString());
		EnterCondition();
		Thread.sleep(1000);
		ClickOnCreateInvoiceBtn();
		Thread.sleep(1000);*/
		EnterMinPrice(testdatamap.get("MinPrice").toString());
		if(testdatamap.get("TemplateName").toString().equalsIgnoreCase("SaveTemplate")) {
			
			   Thread.sleep(1000);
				EnterIssuedDate();
			    Thread.sleep(1500); 
				if(testdatamap.get("InvoiceType").toString().equalsIgnoreCase("Save")) 
				   {
                	 ClickOnCreateInvoiceBtn();
			       }
				else 
				{
					ClickOnExportandcreatBtn();
				}
			}
			else {
				//String iType=testdatamap.get("InvoiceType").toString();
				//if(testdatamap.get("iType").toString().equals("Export")) 
				    Thread.sleep(1000);
					EnterIssuedDate();
					Thread.sleep(1000);
					SelectDuration(testdatamap.get("Duration").toString());
					//Thread.sleep(2000);
				//	EnterMinPrice(testdatamap.get("MinPrice").toString());
					//EnterCondition();
					ClickOninstallmentBtn();
				
				}
			Thread.sleep(500);
	}
//Function Summary  :To write description and click on save button
//Parameter Summary : Enter Description
	public void enterInvoiceCaseSaveType(Map<Object,Object> testdatamap) throws Exception {
		EnterDescriptionSaved(testdatamap.get("Description").toString());
		EnterDescriptionOne(testdatamap.get("Description").toString());
		String iType=testdatamap.get("InvoiceType").toString();
		ClickOnSaveBtn();

		Thread.sleep(1000);
	}

	//Function Summary   : Method to  enterInvoiceCaseExportType
	//Parameter Summary : Description,Description,InvoiceType
	public void enterInvoiceCaseExportType(Map<Object,Object> testdatamap) throws Exception {
		EnterDescriptionSaved(testdatamap.get("Description").toString());
        Thread.sleep(1000);
		EnterDescriptionOne(testdatamap.get("Description").toString());
	//	String iType=testdatamap.get("InvoiceType").toString();
		Thread.sleep(1000);
	//	ClickOnExportBtn();
	}

//Function Summary  : To create one invoice and save.
//Parameter Summary : NA
	public void createSaveInvoiceData(Map<Object,Object> testdatamap,Log Log) throws Exception {
		try {
			String iType=testdatamap.get("InvoiceType").toString();
			if(iType.equalsIgnoreCase("Save")) {
				//int intiCount=getInvoiceCountNext();
				naviagteCreateInvoicePage();
                Thread.sleep(2000);
				enterClientNameOrNationalID(testdatamap);
                Thread.sleep(2000);
				selectTemplate(testdatamap);
				Thread.sleep(1000);
				addProductDetails(testdatamap);
                Thread.sleep(2000);
				enterInvoicDetails(testdatamap);
                Thread.sleep(2000);
				enterInvoiceCaseSaveType(testdatamap);
				Thread.sleep(2000);
				waitForPageToLoad();
				ClickOnAdminExportBillLink();
				Thread.sleep(2000);
				waitForPageToLoad();
				ValidateTwoValue(getText(EdaatOR.Admin_ExportBills_Date), testdatamap.get("Date").toString());
				ValidateTwoValue(getText(EdaatOR.Admin_ExportBills_Status), testdatamap.get("BilStatus").toString());
//				int afterSave=getInvoiceCountNextAfteradd();
//				VerifyTwoIntValue(intiCount+1, afterSave);
//				int val=getInvoiceCountAdd();
				test.log(Status.PASS,"Save Revieviable Invoice Bill" + driver.getTitle() +" * Save invoice details PASS * " );
	        	Log.ReportEvent("PASS", "Verify create and save one time invoice and create  installments invoice Functionality is Succesfull");	        	
				takeScreenShot();
			}

		}
		catch(Exception e){
			test.log(Status.FAIL,"Revieviable Invoice Bill" + driver.getTitle() +" * Save Invoice details FAIL * " );
			this.takeScreenShot();
		}
	}

	//Function Summary   : Method to create Export Invoice Data
	//Parameter Summary : InvoiceType,BilStatus
	public void createExportInvoiceData(Map<Object,Object> testdatamap,Log Log) throws Exception {
		try {
			String iType=testdatamap.get("InvoiceType").toString();
			if(iType.equalsIgnoreCase("Export")) {
				int intiCount=getInvoiceCountNext();
				naviagteCreateInvoicePage();
				Thread.sleep(100);
				enterClientNameOrNationalID(testdatamap);
				Thread.sleep(1500);
				selectTemplate(testdatamap);
				Thread.sleep(2000);
				addProductDetails(testdatamap);
				Thread.sleep(1000);
				enterInvoicDetails(testdatamap);
				Thread.sleep(1000);
				enterInvoiceCaseExportType(testdatamap);
				WebClickUsingJS(EdaatOR.Admin_Invoice_ExportButton1);
				Thread.sleep(1000);
				ClickOnAdminExportBillLink();
				Thread.sleep(1000);
				waitForPageToLoad();
				ValidateTwoValue(getText(EdaatOR.Admin_ExportBills_Date), testdatamap.get("Date").toString());
				ValidateTwoValue(getText(EdaatOR.Admin_ExportBills_Status), testdatamap.get("BilStatus").toString());
				WebClickUsingJS(EdaatOR.Admin_ExportExcel);
				Thread.sleep(1000);
				verifyElementIsPresent(EdaatOR.Admin_ExportExcel_Verify);
				Thread.sleep(1000);
				ClickOnLastCheckBoxBtn();
				Thread.sleep(1000);
				verifyElementIsPresent(EdaatOR.Admin_Export_CancellationBtn);
				verifyElementIsPresent(EdaatOR.Admin_Export_PayOutsideBtn);
				verifyElementIsPresent(EdaatOR.Admin_Export_ViewContactBtn);
				ClickOnLastCheckBoxBtn();
				Thread.sleep(1000);
//				int afterSave=getInvoiceCountNextAfteradd();
//				VerifyTwoIntValue(intiCount+1, afterSave);
//				int val=getInvoiceCountAdd();
				test.log(Status.PASS,"Verify able to export invoice" + driver.getTitle() +" * Export invoice details PASS * " );
	           	Log.ReportEvent("PASS", "Verify Create Invoice Exported is Succesfull");
				this.takeScreenShot();
			}

		}
		catch(Exception e){
			test.log(Status.FAIL,"Verify able to export invoice" + driver.getTitle() +" * Export Invoice details FAIL * " );
			this.takeScreenShot();
		}
	}

//Function Summary  : To Print Invoice.
//Parameter Summary : NA
	public void verifyInvoiceIDandPrint(Map<Object,Object> testdatamap,Log Log) throws Exception {
		try {
			String ID=null;
			Thread.sleep(1000);
			String iType=testdatamap.get("InvoiceType").toString();
			if(iType.equalsIgnoreCase("BIlID")) {
				Thread.sleep(3000);
				scrollDowntillend(driver);
				if(CheckElementExists(EdaatOR.Admin_Invoice_BillNo)==false){
					naviagteCreateInvoicePage();
					enterClientNameOrNationalID(testdatamap);
					selectTemplate(testdatamap);
					addProductDetails(testdatamap);
					enterInvoicDetails(testdatamap);
					ID=getAdminID();
					enterInvoiceCaseSaveType(testdatamap);
					int afterSave=getInvoiceCountNextAfteradd();
					WebClick(EdaatOR.Admin_Invoice_BillNo+"/span[text(),'"+ID+"']");
				}
				else {
					ID=getText(EdaatOR.Admin_Invoice_BillNo+"/span");
					WebClick(EdaatOR.Admin_Invoice_BillNo+"/span");
				}
				switchToWindow();
				Thread.sleep(1000);
				VerifyValue1(getText(EdaatOR.Admin_Invoice_BillerNumber), ID);
				WebClick(EdaatOR.Admin_Invoice_PrintButton);
				takeScreenShot();
				test.log(Status.PASS,"Verify Bill Number Clickable and Print" + driver.getTitle() +" * Export Bill details PASS * " );
	         	Log.ReportEvent("PASS", "Verify Invoice ID and Print is Successfull");

			}
		}
		catch(Exception e){
			test.log(Status.FAIL,"Verify Bill Number Clickable and Print" + driver.getTitle() +" * Export Invoice details FAIL * " );
			this.takeScreenShot();
		}
	}

//Function Summary  :Printout functionality for the contracts
//Parameter Summary :N/A
	public void verifyExportContact(Map<Object,Object> testdatamap,Log Log) throws Exception {
		try {
			String ID=null;
			String iType=testdatamap.get("InvoiceType").toString();
			if(iType.equalsIgnoreCase("ExportContact")) {
				naviagteReveiableExportContact();
				Thread.sleep(1000);
				if(CheckElementExists(EdaatOR.Admin_ExportContact_InvID)==false){
					naviagteCreateInvoicePage();
					enterClientNameOrNationalID(testdatamap);
					selectTemplate(testdatamap);
					addProductDetails(testdatamap);
					enterInvoicDetails(testdatamap);
					ID=getAdminContactID();
					enterInvoiceCaseSaveType(testdatamap);
					int afterSave=getInvoiceCountNextAfteradd();
					WebClick(EdaatOR.Admin_Invoice_BillNo+"/span[text(),'"+ID+"']");
				}
				else {
					ID=getText(EdaatOR.Admin_ExportContact_InvID+"/span");
					WebClick(EdaatOR.Admin_ExportContact_InvID+"/span");
				}
				switchToWindow();
				Thread.sleep(1000);
				VerifyValue1(getText(EdaatOR.Admin_ExportContact_ContactHeader), ID);
                Thread.sleep(1000);
				verifyElementIsPresent(EdaatOR.Admin_ExportContact_InvoiceDetails);
                Thread.sleep(1000);
				WebClick(EdaatOR.Admin_Invoice_PrintButton);
				test.log(Status.PASS,"Verify Export Contact Clickable and Print" + driver.getTitle() +" * Export Bill details PASS * " );
	        	Log.ReportEvent("PASS", "Verify Export Contact Functionality is Successfull");

			}
		}
		catch(Exception e){
			test.log(Status.FAIL,"Verify Export Contact Clickable and Print" + driver.getTitle() +" * Export Invoice details FAIL * " );
			this.takeScreenShot();
		}
	}
	//Function Summary   : Method to  getInvoiceDetails
	//Parameter Summary  : N/A
	public void getInvoiceDetails(Map<Object,Object> testdatamap,Log Log) throws Exception {
		testdatamap.put("InvoiceID",getText(EdaatOR.Admin_ExportBille_InvoiceID));
		Thread.sleep(1000);
		this.takeScreenShot();
       	Log.ReportEvent("PASS", "Get valid invoic ID");
	}
	//Function Summary   : Method to  Navigate to "Paid outside Edaat" Page
	//Parameter Summary  : N/A
	public void navigatetoReceivablesPaidOutsideEdaat() throws InterruptedException {
	WebClick(EdaatOR.Admin_Receivables_Menu);
	clickOnPaidOutsideEdaatManu();
	Thread.sleep(2000);
	}
	//Function Summary   : Method to  click on "Paid outside Edaat" Menu
	//Parameter Summary  : N/A
	private void clickOnPaidOutsideEdaatManu() {
		WebClickUsingJS(EdaatOR.Admin_Receivables_PaidoutsideMenu);
		waitForPageToLoad();
	}
	
	//Function Summary   : Method to "Paid outside Edaat" Search
	//Parameter Summary  : BillNumber,DocumentNo
	/*public void paidOutsideEdaatSearch(Map<Object, Object> testdatamap) {
		try {
				navigatetoReceivablesPaidOutsideEdaat();
				WebEdit(EdaatOR.Admin_PaidoutsideEdaat_BillNo,testdatamap.get("BillNumber").toString());
				Thread.sleep(2000);
				WebEdit(EdaatOR.Admin_PaidOutsideEdaat_DocumentNo, testdatamap.get("DocumentNo").toString());
				Thread.sleep(1000);
				WebClick(EdaatOR.Admin_PaidoutsideEdaat_SubBillerName);
				WebClick("//li[text()='"+testdatamap.get("SubBillerName").toString()+"']");
				Thread.sleep(1000);
				Thread.sleep(1000);
				WebClick(EdaatOR.Admin_PaidoutsideEdaat_Searchbtn);
				Thread.sleep(1000);
				VerifyValue1(WebGetText("//tr/td[text()='"+testdatamap.get("BillNumber").toString()+"']"), testdatamap.get("BillNumber").toString());
				this.takeScreenShot();
				test.log(Status.PASS,"Verify PaidOutsideEdaat Search" + driver.getTitle() +" * PaidOutsideEdaat Search is PASS * " );
			}
		
		catch(Exception e){
			test.log(Status.FAIL,"Verify PaidOutsideEdaat Search" + driver.getTitle() +" * PaidOutsideEdaat Search is FAIL * " );
			this.takeScreenShot();
		}
	}*/
	
	public void ClickOnExportinstallBtn() {
		WebClickUsingJS(EdaatOR.Biller_Invoice_ExportinastallButton);
		waitForPageToLoad();
	}
	
	public void InvoiceError(Map<Object,Object> testdatamap) throws Exception
	{
		 naviagteCreateInvoicePage();
		 selectTemplate(testdatamap);
		 String Date = testdatamap.get("Date").toString();
		 if(Date.equalsIgnoreCase("Yes"))
		 {
	     WebClick(EdaatOR.Admin_Invoice_DateInvoc);
		 WebClick("//a[text()='"+testdatamap.get("Invoice Due Date").toString()+"']");
		 WebClick(EdaatOR.Admin_RCV_Expiredate);
		 WebClick("//a[text()='"+testdatamap.get("Invoice Expiry Date").toString()+"']");
		 }
		 else if(Date.equalsIgnoreCase("No"))
		 {
			 WebClick(EdaatOR.Admin_RCV_Expiredate);
			 WebClick("//a[text()='"+testdatamap.get("Invoice Expiry Date").toString()+"']");
		 }
		 else {
			 WebClick(EdaatOR.Admin_Invoice_DateInvoc);
			 WebClick("//a[text()='"+testdatamap.get("Invoice Due Date").toString()+"']"); 
		 }
		 WebClick(EdaatOR.Admin_RCV_FromHour);
		 WebEdit(EdaatOR.Admin_RCV_FromHour,testdatamap.get("From Hour").toString());
		 WebEdit(EdaatOR.Admin_RCV_FromHour,testdatamap.get("Fminute").toString());
		 WebEdit(EdaatOR.Admin_RCV_FromHour,testdatamap.get("AM").toString());
		 WebClick(EdaatOR.Admin_RCV_ToTime);
		 WebEdit(EdaatOR.Admin_RCV_ToTime,testdatamap.get("From Hour").toString());
		 WebEdit(EdaatOR.Admin_RCV_ToTime,testdatamap.get("Fminute").toString());
		 WebEdit(EdaatOR.Admin_RCV_ToTime,testdatamap.get("PM").toString());
		 WebEdit(EdaatOR.Admin_Invoice_Condition, testdatamap.get("Condition").toString());
		 WebClickUsingJS(EdaatOR.Admin_Invoice_CreateExport);
			 
		 if(ExistsCheck(EdaatOR.Admin_RCV_IssuedateError)) {
              VerifyValue1(getText(EdaatOR.Admin_RCV_IssuedateError),testdatamap.get("Expected").toString());
              test.log(Status.PASS,"Verify Error message" + driver.getTitle() +" * Verify Error message is PASS * " );
			  this.takeScreenShot();
			 }
			 else if(ExistsCheck(EdaatOR.Admin_RCV_ExpiredateError))
			 {
              VerifyValue1(getText(EdaatOR.Admin_RCV_ExpiredateError),testdatamap.get("Expected").toString());
              test.log(Status.PASS,"Verify Error message" + driver.getTitle() +" * Verify Error message is PASS * " );
				  this.takeScreenShot();
			 }				
			 else if(ExistsCheck(EdaatOR.Admin_RCV_FromHourError))
			 {
             VerifyValue1(getText(EdaatOR.Admin_RCV_FromHourError),testdatamap.get("Expected").toString());
				  this.takeScreenShot();
			 }
		    
			 else if(CheckElementExists(EdaatOR.Admin_RCV_ToTimeError))
           {
               VerifyValue1(getText(EdaatOR.Admin_RCV_ToTimeError),testdatamap.get("Expected").toString()); 	   
             test.log(Status.PASS,"Verify Error message" + driver.getTitle() +" * Verify Error message is PASS * " );
				  this.takeScreenShot();
           }
			 else if(CheckElementExists(EdaatOR.Admin_Invoice_ConditionError))
               {
                   VerifyValue1(getText(EdaatOR.Admin_Invoice_ConditionError),testdatamap.get("Expected").toString()); 	   
                 test.log(Status.PASS,"Verify Error message" + driver.getTitle() +" * Verify Error message is PASS * " );
					 this.takeScreenShot();
               }
	 }
		
	
	//Function Summary   : Method to verify Error message in Export Bills page
	//Parameter Summary : TemplateName,Expected
		public void ReceivablesExportBillsCreate(Map<Object,Object> testdatamap) throws Exception {
			try {
				    ClickOnAdminExportBillLink();
					naviagteCreateInvoicePage();
					selectTemplate(testdatamap);
					String Date= testdatamap.get("Date").toString();
					Thread.sleep(2000);
					if(Date.equalsIgnoreCase("No"))
					{
						WebClickUsingJS(EdaatOR.Admin_Invoice_CreateExport);
					}
					else {
					WebClick(EdaatOR.Admin_Invoice_DateInvoc);
					WebClick("//a[text()='"+testdatamap.get("Invoice Due Date").toString()+"']");
					Thread.sleep(2000);
					WebClickUsingJS(EdaatOR.Admin_Invoice_CreateExport);
					Thread.sleep(2000);
					}
					if(CheckElementExists(EdaatOR.Admin_RCV_IssuedateError))
					{
				    VerifyValue1(getText(EdaatOR.Admin_RCV_IssuedateError),testdatamap.get("Expected").toString());
					test.log(Status.PASS,"Verify Error message of issue date text filed" + driver.getTitle() +" * Verify Error message is PASS * " );
					this.takeScreenShot();
					Thread.sleep(2000);
					}
					else
					{
					 VerifyValue1(getText(EdaatOR.Admin_RCV_ClientType),testdatamap.get("Expected").toString());
					 test.log(Status.PASS,"Verify Error message" + driver.getTitle() +" * Verify Error message is PASS * " ); 
					 this.takeScreenShot();
					}
					
			}
			catch(Exception e){
				test.log(Status.FAIL,"Verify Error message" + driver.getTitle() +" * Verify Error message is PASS * " );
				this.takeScreenShot();
			}
		}

		//Function Summary   : Method to verify Error message in Export Bills page
		//Parameter Summary : TemplateName,Expected
		public void TaxDiscountDetails(Map<Object,Object> testdatamap) throws Exception
		{
		 try {
			String TaxDis = testdatamap.get("TaxDis").toString();
			if(TaxDis.equalsIgnoreCase("No"))
			{
			ClickOnAdminExportBillLink();
			naviagteCreateInvoicePage();
			selectTemplate(testdatamap);
			String CName = testdatamap.get("CName").toString();
			if(CName.equalsIgnoreCase("Yes"))
			{
			enterClientNameOrNationalID(testdatamap);
			}
			ClickOnIndividualRadBtn();
			String Pname = testdatamap.get("Pname").toString();
			if(Pname.equalsIgnoreCase("Yes"))
			{
			addProductDetails(testdatamap);
			}
			Thread.sleep(2000);
			EnterIssuedDate();
			WebSelect1(EdaatOR.Admin_Invoice_DurationID,testdatamap.get("Duration").toString());
		    WebClickUsingJS(EdaatOR.Admin_RCV_Create_install);
		    if(CheckElementExists(EdaatOR.Admin_Invoice_MinLimitError))
		    {
		    	VerifyValue1(getText(EdaatOR.Admin_Invoice_MinLimitError), testdatamap.get("Expected").toString());
                test.log(Status.PASS,"Verify Error message" + driver.getTitle() +" * Verify Error message of Minimum and max limit text field is PASS * " );
				this.takeScreenShot();
		    }
		    else if(CheckElementExists(EdaatOR.Admin_RCV_DurationError))
		    {
		    	VerifyValue1(getText(EdaatOR.Admin_RCV_DurationError), testdatamap.get("Expected").toString());
                test.log(Status.PASS,"Verify Error message" + driver.getTitle() +" * Verify Error message of duration type dropdown is PASS * " );
				this.takeScreenShot();
		    }
		    else if(CheckElementExists(EdaatOR.Admin_Invoice_ClientNameError))
		    {
		    	VerifyValue1(getText(EdaatOR.Admin_Invoice_ClientNameError), testdatamap.get("Expected").toString());
                test.log(Status.PASS,"Verify Error message" + driver.getTitle() +" * Verify Error message of Client Name dropdown is PASS * " );
				this.takeScreenShot();
		    }
		}
		
			 else if(TaxDis.equalsIgnoreCase("Yes"))
			{
				    ClickOnAdminExportBillLink();
					naviagteCreateInvoicePage();
					selectTemplate(testdatamap);
				    WebClickUsingJS(EdaatOR.Admin_RCV_Addtaxbtn);
				    WebClick(EdaatOR.Admin_RCV_Addtax);
					VerifyValue1(getText(EdaatOR.Admin_RCV_Addtaxerror), testdatamap.get("Expected").toString());
					this.takeScreenShot();
					test.log(Status.PASS,"Verify Error message" + driver.getTitle() +" * Verify Error message of Tax dropdown is PASS * " );
				    WebClickUsingJS(EdaatOR.Admin_RCV_Addtaxcancel);
				    WebClickUsingJS(EdaatOR.Admin_RCV_Discountbtn);
				    WebClick(EdaatOR.Admin_RCV_DiscountAdd);
					VerifyValue1(getText(EdaatOR.Admin_RCV_Discounterror), testdatamap.get("Expected").toString());
					this.takeScreenShot();
					test.log(Status.PASS,"Verify Error message" + driver.getTitle() +" * Verify Error message of discount dropdown is PASS * " );
			 }
		}
		
		   
		    catch(Exception e)
		    {
				test.log(Status.FAIL,"Verify Error message" + driver.getTitle() +" * Verify Error message is fail* " );
				this.takeScreenShot();
		}
	}
		
		
	     //Function Summary   : Method to validate minimum invoice amount in create invoice page
		//Parameter Summary : InvoiceType,BilStatus
		public void validateMinimumInvoiceAmount(Map<Object,Object> testdatamap,Log Log) throws Exception {
			try {
					naviagteCreateInvoicePage();
					Thread.sleep(100);
					enterClientNameOrNationalID(testdatamap);
					Thread.sleep(1500);
					selectTemplate(testdatamap);
					Thread.sleep(1000);
					VerifyValue1(getAttributeValue(EdaatOR.Admin_Invoice_MinTax, "value"), testdatamap.get("MinimumPrice").toString());
					test.log(Status.PASS,"validate minimum invoice amount in create invoice page" + driver.getTitle() +" * validate minimum invoice amount in create invoice page PASS * " );
		           	Log.ReportEvent("PASS", " validate minimum invoice amount in create invoice page");
					this.takeScreenShot();
				

			}
			catch(Exception e){
				test.log(Status.FAIL,"validate minimum invoice amount in create invoice page" + driver.getTitle() +" * validate minimum invoice amount in create invoice page FAIL * " );
				this.takeScreenShot();
			}
		}		
		
		
	

}


