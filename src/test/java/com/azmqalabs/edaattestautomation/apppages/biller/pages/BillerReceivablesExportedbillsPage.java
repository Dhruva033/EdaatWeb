/**
*
* Test Script Name                      : N/A.
* Objective                             : Verify biller Receviable functionality.
* Version                               : 1.0
* Author                                : Kathirvelu M
* Created Date                          : 08/05/2023
* Last Updated on                       : N/A
* Updated By                            : Arun Kumar MS.
* Pre-Conditions                        : N/A
* Manual Testcase Name                  : N/A
* Epic Details                          : N/A
* User Story Details                    : N/A
* Defects affecting this test script    : None
* Work Arounds/Known Issues             : None
**/
package com.azmqalabs.edaattestautomation.apppages.biller.pages;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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



public class BillerReceivablesExportedbillsPage extends BasePage
{

	public BillerReceivablesExportedbillsPage(WebDriver driver,ExtentTest test)
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


	public void ClickOnBReceivableLink() {
		WebClickUsingJS(EdaatOR.Biller_Receivable_Link);
		waitForPageToLoad();
	}
	//Function Summary   : Method to Click on Exported bills.
	//Parameter Summary :  N/A.
	public void ClickOnBillerExportBillLink() {
		WebClickUsingJS(EdaatOR.Biller_ExportBill_Link);
		waitForPageToLoad();
	}
	//Function Summary   : Method to Click on Add Invoice button.
	//Parameter Summary :  N/A.
	public void ClickOnExportInvoiceBtn() {
		WebClickUsingJS(EdaatOR.Biller_AddInvoice_btn);
		waitForPageToLoad();
	}
	//Function Summary   : Method to Check Corporate radio button.
	//Parameter Summary :  N/A.

	public void ClickOnCoporateRadBtn() {
		WebClickUsingJS(EdaatOR.Biller_Invoice_CopoRdv);
		waitForPageToLoad();
	}
	//Function Summary   : Method to Check Individual radio button.
	//Parameter Summary :  N/A.
	public void ClickOnIndividualRadBtn() {
		WebClickUsingJS(EdaatOR.Biller_Invoice_IndividualRdv);
		waitForPageToLoad();
	}
	//Function Summary   : Method to Check Subbiller Individual radio button.
		//Parameter Summary :  N/A.
	public void ClickOnSubIndividualRadBtn() {
		WebClickUsingJS(EdaatOR.Biller_Invoice_subIndividualRdv);
		waitForPageToLoad();
	}


	//Function Summary   : Method to Select the Individual ClientName/id in Create Invoice page.
	//Parameter Summary :  N/A.
	public void SelectIndCustomerID(String Cust) throws Exception {

		WebClick(EdaatOR.Biller_Invoice_CustIDList);
		Thread.sleep(2000);
		WebClick(EdaatOR.Biller_Invoice_ClientRoleId+"["+Cust+"]");
		waitForPageToLoad();
	}

	public void SelectCopCustomerID(String Cust) throws Exception {

		WebClick(EdaatOR.Biller_Invoice_ComCustIDList);
		Thread.sleep(2000);
		WebClick(EdaatOR.Biller_Invoice_ClientRoleId+"["+Cust+"]");
		waitForPageToLoad();
	}

	public void SelectSubBiller(String SubBiller) throws InterruptedException {
		//WebSelect1(EdaatOR.Biller_Invoice_SBilIdList,SubBiller);
		WebClick(EdaatOR.Biller_Invoice_SBilIdList);
		Thread.sleep(2000);
		WebClick(EdaatOR.Biller_Invoice_ClientRoleId+"["+SubBiller+"]");
		
		waitForPageToLoad();
        Thread.sleep(2000);
	}

	public void SelectInvoiceTemplate(String Tem) {
		WebSelect(EdaatOR.Biller_Invoice_TemplateList,Tem);
		waitForPageToLoad();
	}
	//Function Summary   : Method to Click add product.
	//Parameter Summary :  N/A.

	public void ClickOnProductBtn() {
		WebClickUsingJS(EdaatOR.Biller_Invoice_AddProductBtn);
		waitForPageToLoad();
	}
	//Function Summary   : Method to Select product.
	//Parameter Summary :  N/A.

	public void SelectProduct(String Cust) {
		WebClick(EdaatOR.Biller_Invoice_ProductID);
		WebSelect(EdaatOR.Biller_Invoice_ProductID,Cust);
		waitForPageToLoad();
	}
	//Function Summary   : Method to Enter product price.
	//Parameter Summary :  Price.

	public void EnterProductPrice(String Price) throws Exception {
		Thread.sleep(1000);
		WebClearUsingKeys(EdaatOR.Biller_Invoice_TaxPric);
		Thread.sleep(1000);
		WebEdit(EdaatOR.Biller_Invoice_TaxPric,Price);
		waitForPageToLoad();
	}
	//Function Summary   : Method to Click on Add product button.
	//Parameter Summary :  N/A.

	public void ClickOnProductAddBtn() {
		WebClick(EdaatOR.Biller_Invoice_AddBtn);
		waitForPageToLoad();
	}
	//Function Summary   : Method to Enter Issued date in invoice page.
	//Parameter Summary :  N/A.

	public void EnterIssuedDate() throws Exception {
		Thread.sleep(2000);
		WebClick(EdaatOR.Biller_Invoice_DateInvoc);
		Thread.sleep(800);
		WebClick(EdaatOR.Biller_RegistDate_exprDate);
	}
	//Function Summary   : Method to Select duration in invoice page.
	//Parameter Summary :  N/A.

	public void SelectDuration(String dur) {
		if(CheckElementExists(EdaatOR.Biller_Invoice_DurationID)) {
			WebClickUsingJS(EdaatOR.Biller_Invoice_DurationID);
			WebSelect1(EdaatOR.Biller_Invoice_DurationID,dur);
			waitForPageToLoad();
		}
	}
	public void SelectDurationinstall(String dur) {
		if(CheckElementExists(EdaatOR.Biller_Invoice_DurationID)) {
			WebClick(EdaatOR.Biller_Invoice_DurationID);
			WebClick(dur);
			waitForPageToLoad();
		}
	}
	//Function Summary   : Method to Enter Minimum price.
	//Parameter Summary :  N/A.
	public void EnterMinPrice(String Price) {
		if(CheckElementExists(EdaatOR.Biller_Invoice_MinTax)) {
			WebEdit(EdaatOR.Biller_Invoice_MinTax,Price);
			waitForPageToLoad();
		}
	}
	//Function Summary   : Method to Check Condition Checkbox.
	//Parameter Summary :  N/A.
	public void EnterCondition() {
		WebClickUsingJS(EdaatOR.Biller_Invoice_Conditonbtn);
		waitForPageToLoad();
	}
	//Function Summary   : Method to Click on Create and Save Button.
	//Parameter Summary :  N/A.
		public void ClickOnCreateInvoiceBtn() {
		WebClickUsingJS(EdaatOR.Biller_Invoice_Createandsave);
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
	//Function Summary   : Method to Click on Save button.
	//Parameter Summary :  N/A.
	public void ClickOnSaveBtn() {
		WebClickUsingJS(EdaatOR.Biller_Invoice_SaveButton);
		waitForPageToLoad();
	}
	//Function Summary   : Method to Click on Installment button.
	//Parameter Summary :  N/A.
	public void ClickOninstallmentBtn() {
		WebClickUsingJS(EdaatOR.Biller_Invoice_installmentButton);
		waitForPageToLoad();
	}
	//Function Summary   : Method to Click on Save button in after click on Installment button.
	//Parameter Summary :  N/A.
	public void ClickOninstallmentSAVEBtn() {
		WebClickUsingJS(EdaatOR.Biller_Invoice_SaveINSTALButton);
		waitForPageToLoad();
	}
	//Function Summary   : Method to Click on Export button.
	//Parameter Summary :  N/A.

	public void ClickOnExportBtn() {
		WebClickUsingJS(EdaatOR.Biller_Invoice_ExportButton);
		waitForPageToLoad();
	}
	public void ClickOnExportandcreatBtn() {
		WebClickUsingJS(EdaatOR.Biller_Invoice_Exportandcreatebtn);
		waitForPageToLoad();
	}
	//Function Summary   : Method to Click on Export button in after click on Installment button.
	//Parameter Summary :  N/A.
	public void ClickOnExportinstallBtn() {
		WebClickUsingJS(EdaatOR.Biller_Invoice_ExportinastallButton);
		waitForPageToLoad();
	}
	//Function Summary   : Method to Check the Checkbox of last record in a table.
	//Parameter Summary :  N/A.

	public void ClickOnLastCheckBoxBtn() {
		WebClickUsingJS(EdaatOR.Biller_InvoiceLastCheckBox);
		waitForPageToLoad();
	}

	public String getBillerID() {
		String ID=getText(EdaatOR.Biller_Invoice_GetBilId);
		waitForPageToLoad();
		return ID;
	}

	public String getBillerContactID() {
		String ID=getText(EdaatOR.Biller_Invoice_GetContactId);
		waitForPageToLoad();
		return ID;
	}


	public void ClickOnBillerExportContactLink() {
		WebClickUsingJS(EdaatOR.Biller_ExportContact_Link);
		waitForPageToLoad();
	}
	//Function Summary   : Method to Click on Exported Contracts.
	//Parameter Summary :  N/A.

	public void naviagteReveiableExportContact(Log Log) {
		ClickOnBReceivableLink();
		ClickOnBillerExportContactLink();
		waitForPageToLoad();
		Log.ReportEvent("PASS", "Verify naviagted Suceessfull Export contracts Page");

	}



	public int getInvoiceCount() {
		List<WebElement> invoice = driver.findElements(By.xpath(EdaatOR.Biller_Invoice_Count));
		waitForPageToLoad();
		int count =invoice.size();
		return count;
	}


	public int getInvoiceCountNext() throws Exception {
		int intiCount=0;
		boolean countRow=false;
		while (CheckElementExists(EdaatOR.Biller_Invoice_Next)==false){  
			WebClick(EdaatOR.Biller_Invoice_NextPrevLink);
			int count=getInvoiceCount();
			String pageNum=getText(EdaatOR.Biller_Invoice_NextPrevLink);
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
		List<WebElement> invoice = driver.findElements(By.xpath(EdaatOR.Biller_Invoice_AfteraddInvoice));
		waitForPageToLoad();
		int count =invoice.size();
		return count;
	}

	public int getInvoiceCountNextAfteradd() throws Exception {
		int aftCount=0;
		boolean countRow=false;
		while (CheckElementExists(EdaatOR.Biller_Invoice_Next)==false){  
			Thread.sleep(400);
			WebClick(EdaatOR.Biller_Invoice_NextPrevLink);
			int count=getInvoiceCount();
			String pageNum=getText(EdaatOR.Biller_Invoice_NextPrevLink);
			Thread.sleep(1000);
			aftCount=aftCount+getInvoiceCount()+((Integer.valueOf(pageNum)-1)*10);
			countRow=true;
		}

		if(countRow==false) {
			aftCount=10;
		}
		return aftCount;
	}
	//Function Summary   : Method to Navigate Biller Exported Bills.
	//Parameter Summary :  N/A.

	public void naviagteReveiableExportBiller(Log Log) {
		ClickOnBReceivableLink();
		ClickOnBillerExportBillLink();
		waitForPageToLoad();
		Log.ReportEvent("PASS", "Verify naviagted Suceessfull Export Bill Page");

	}
	
	//Function Summary   : Method to Navigate Biller Exported Bills.
			//Parameter Summary :  N/A.
			public void navigateToReceivableExportBiller(Log Log) {
				try {
					WebClickUsingJS(EdaatOR.Biller_Receivable_Link);
					waitForPageToLoad();
					WebClickUsingJS(EdaatOR.Biller_ExportBill_Link);
					if(CheckElementExists(EdaatOR.Biller_ExportBill_Header)) {						
						waitForPageToLoad();
						Log.ReportEvent("PASS","Bills List Page Loaded Successfully");
					}
					else {
						Log.ReportEvent("FAIL","Bills List Page Not Loaded Successfully");
						this.takeScreenShot();
						driver.quit();
						Assert.fail(); 
					}
				}
				catch (Exception e) {
					Log.ReportEvent("FAIL","Bills List Page Not Loaded Successfully");
					this.takeScreenShot();
					driver.quit();
					Assert.fail();
				}
			}
	//Function Summary   : Method to Navigate Create Invoice page.
	//Parameter Summary :  N/A.

	public void naviagteCreateInvoicePage() {
		ClickOnExportInvoiceBtn();
		waitForPageToLoad();

	}
	//Function Summary   : Method to Check Individual/Corporate biller/Subbiller radio button.
	//Parameter Summary :  N/A.

	public void enterClientNameOrNationalID(Map<Object,Object> testdatamap) throws Exception {
		String client=testdatamap.get("ClientID").toString();
		if(client.equalsIgnoreCase("Individual")) {
			Thread.sleep(100);
			ClickOnIndividualRadBtn();
			Thread.sleep(100);
			SelectIndCustomerID(testdatamap.get("ClientName").toString());
		}
		else if(client.equalsIgnoreCase("Corporate")){
			Thread.sleep(100);
			ClickOnCoporateRadBtn();
			Thread.sleep(100);
			SelectCopCustomerID(testdatamap.get("ClientName").toString());
		}
		String sBill=testdatamap.get("SubBiller").toString();
		if(!sBill.equalsIgnoreCase(""))
		{
			Thread.sleep(100);
			ClickOnSubIndividualRadBtn();
			Thread.sleep(100);
			SelectSubBiller(sBill);
		}

	}

	//Function Summary   : Method to Select template.
	//Parameter Summary :  TemplateName.

	public void selectTemplate(Map<Object,Object> testdatamap) throws Exception {
		Thread.sleep(100);
		SelectInvoiceTemplate(testdatamap.get("TemplateName").toString());
	}
	//Function Summary   : Method to Add product in Create Invoice page.
	//Parameter Summary :  ProductName,ProductPrice.

	public void addProductDetails(Map<Object,Object> testdatamap) throws Exception {
		ClickOnProductBtn();
		Thread.sleep(300);
		SelectProduct(testdatamap.get("ProductName").toString());
		Thread.sleep(300);
		waitForPageToLoad();
		EnterProductPrice(testdatamap.get("ProductPrice").toString());
        Thread.sleep(500);
		ClickOnProductAddBtn();
		Thread.sleep(100);

	}
	//Function Summary   : Method to Enter invoice details in Create invoice page.
    //Parameter Summary :  ProductName,ProductPrice.

	public void enterInvoicDetails(Map<Object,Object> testdatamap) throws Exception {
//		EnterIssuedDate();
//		Thread.sleep(1000);
//		ClickOnCreateInvoiceBtn();
		Thread.sleep(300);
			if(testdatamap.get("TemplateName").toString().equalsIgnoreCase("One Time")) {
				
				EnterIssuedDate();
				if(testdatamap.get("InvoiceType").toString().equalsIgnoreCase("Save")) {

				ClickOnCreateInvoiceBtn();
			}
				else {
					ClickOnExportandcreatBtn();
				}
			}
			else {
				//String iType=testdatamap.get("InvoiceType").toString();
				//if(testdatamap.get("iType").toString().equals("Export")) {
					EnterIssuedDate();
					Thread.sleep(300);
					SelectDuration(testdatamap.get("Duration").toString());
					Thread.sleep(300);
				//	EnterMinPrice(testdatamap.get("MinPrice").toString());
					EnterCondition();
					ClickOninstallmentBtn();
				//}
				}
			Thread.sleep(500);
	}
			
	//Function Summary   : Method to Enter invoice Description details.
    //Parameter Summary :  Description,InvoiceType.
	public void enterInvoiceCaseSaveType(Map<Object,Object> testdatamap) throws Exception {
		if(CheckElementExists(EdaatOR.Biller_Invoice_Descript)==true) {
		EnterDescriptionSaved(testdatamap.get("Description").toString());
		EnterDescriptionOne(testdatamap.get("Description").toString());
		Thread.sleep(800);
		if(testdatamap.get("InvoiceType").toString().equalsIgnoreCase("Save")) {
			ClickOninstallmentSAVEBtn();
			Thread.sleep(800);
		}
		else {
			ClickOnExportinstallBtn();
			Thread.sleep(800);

		}
		}
	
//		String iType=testdatamap.get("InvoiceType").toString();
//		if(testdatamap.get("iType").toString().equalsIgnoreCase("Save")) {
//			ClickOninstallmentSAVEBtn();
//			Thread.sleep(2000);
//		}
//		else//(testdatamap.get("iType").toString().equalsIgnoreCase("Export")) 
//			{
//			ClickOnExportinstallBtn();
//		}
		
		
	
		Thread.sleep(1000);
	}

	//Function Summary   : Method to Enter invoice Description details.
    //Parameter Summary :  Description,saveorexport.
	public void enterInvoiceCaseExportType(Map<Object,Object> testdatamap) throws Exception {
		if(CheckElementExists(EdaatOR.Biller_Invoice_Descript)==true) {
		EnterDescriptionSaved(testdatamap.get("Description").toString());
		Thread.sleep(300);
		EnterDescriptionOne(testdatamap.get("Description").toString());
		Thread.sleep(300);
//		String iType=testdatamap.get("InvoiceType").toString();
//		Thread.sleep(300);
//		ClickOnExportinstallBtn();
	if(testdatamap.get("saveorexport").toString().equalsIgnoreCase("Save")) {
			ClickOninstallmentSAVEBtn();
			Thread.sleep(100);
		}
		else {
			ClickOnExportinstallBtn();
			Thread.sleep(100);

		}
//	ClickOnExportBtn();
		}
		}

	//Function Summary   : Method to create and Save onetime/Recurring invoice.
	//Parameter Summary :  InvoiceType,Save.
	public void createSaveInvoiceData(Map<Object,Object> testdatamap,Log Log) throws Exception {
		//
		try {
			String iType=testdatamap.get("InvoiceType").toString();
			if(iType.equalsIgnoreCase("Save")) {
				//int intiCount=getInvoiceCountNext();
				naviagteCreateInvoicePage();
				enterClientNameOrNationalID(testdatamap);
				Thread.sleep(100);
				selectTemplate(testdatamap);
				Thread.sleep(100);
				addProductDetails(testdatamap);
					Thread.sleep(400);
				verifyElementIsPresent(EdaatOR.Biller_ExportBills_PayedOutSideEdaatPaymentMethod);
				Thread.sleep(400);
				verifyElementIsPresent(EdaatOR.Biller_ExportBills_SadadPaymentMethod);			
				Thread.sleep(100);
				enterInvoicDetails(testdatamap);
				Thread.sleep(100);
				enterInvoiceCaseSaveType(testdatamap);
				Thread.sleep(100);
				waitForPageToLoad();
				ClickOnBillerExportBillLink();
			Thread.sleep(100);				
				WebElement element=driver.findElement(By.xpath(EdaatOR.Biller_ExportExcel));
				scrollToElement(driver, element);
				waitForPageToLoad();				
//	takeScreenShot();
//				int val=getInvoiceCountAdd();
				takeScreenShot();
			    int val=1;
				ValidateTwoValue(getText(EdaatOR.Biller_Invoice_AfteraddInvoice+"["+val+"]/td[6]"), testdatamap.get("BilStatus").toString());
//				Thread.sleep(5000);
//				int afterSave=getInvoiceCountNextAfteradd();
//				VerifyTwoIntValue(intiCount+1, afterSave);
				test.log(Status.PASS,"#FUNC-Save Revieviable Invoice Bill" + driver.getTitle() +" * Save invoice details PASS * " );
				takeScreenShot();
				Log.ReportEvent("PASS", " Verify Create and save bills is sucessfull");
			}

		}
		catch(Exception e){
			test.log(Status.FAIL,"#FUNC-Revieviable Invoice Bill" + driver.getTitle() +" * Save Invoice details FAIL * " );
			this.takeScreenShot();
		}
	}

	//Function Summary   : Method to create and Export onetime/Recurring invoice.
	//Parameter Summary :  InvoiceType,Save.

	public void createExportInvoiceData(Map<Object,Object> testdatamap,Log Log) throws Exception {
		try {
			String iType=testdatamap.get("InvoiceType").toString();
			if(iType.equalsIgnoreCase("Export")) {
			//	int intiCount=getInvoiceCountNext();
				naviagteCreateInvoicePage();
				enterClientNameOrNationalID(testdatamap);
				Thread.sleep(100);
				selectTemplate(testdatamap);
				Thread.sleep(100);
				addProductDetails(testdatamap);
				Thread.sleep(100);
				enterInvoicDetails(testdatamap);
				Thread.sleep(100);
				this.takeScreenShot();
				enterInvoiceCaseExportType(testdatamap);
				Thread.sleep(400);
				ClickOnBillerExportBillLink();
				Thread.sleep(400);
				WebElement element=driver.findElement(By.xpath(EdaatOR.Biller_ExportExcel));
				scrollToElement(driver, element);
				waitForPageToLoad();
//				Thread.sleep(100);
//				int val=getInvoiceCountAdd();
				int val=1;
				ValidateTwoValue(getText(EdaatOR.Biller_Invoice_AfteraddInvoice+"["+val+"]/td[6]"), testdatamap.get("BilStatus").toString());
				//VerifyObjectEnabled(driver.findElement(By.xpath(EdaatOR.Biller_ExportExcel)));
				Thread.sleep(100);
				WebClickUsingJS(EdaatOR.Biller_ExportExcel);
				Thread.sleep(100);
				this.takeScreenShot();
				verifyElementIsPresent(EdaatOR.Biller_ConformExportExcel);				
				Thread.sleep(8000);
				ClickOnLastCheckBoxBtn();
				ValidateTwoValue(getText(EdaatOR.Biller_Export_CancellationBtn), testdatamap.get("Cancel").toString());		
				ValidateTwoValue(getText(EdaatOR.Biller_Export_PayOutsideBtn), testdatamap.get("Conform").toString());				
				verifyElementIsPresent(EdaatOR.Biller_Export_ViewContactBtn);
//				Thread.sleep(5000);
//				int afterSave=getInvoiceCountNextAfteradd();
//				VerifyTwoIntValue(intiCount+1, afterSave);
				test.log(Status.PASS,"#FUNC-Verify able to export invoice" + driver.getTitle() +" * Export invoice details PASS * " );
				Log.ReportEvent("PASS", " Verify Export Created");
				this.takeScreenShot();
			}

		}
		catch(Exception e){
			//Log.ReportEvent("FAIL", " Verify Export Created is Failed");
			test.log(Status.FAIL,"#FUNC-Verify able to export invoice" + driver.getTitle() +" * Export Invoice details FAIL * " );
			this.takeScreenShot();
		}
	}

	//Function Summary   : Method to Navigate Exported contract and Print invoice details.
	//Parameter Summary :  InvoiceType,BIlID.
	public void verifyInvoiceIDandPrint(Map<Object,Object> testdatamap,Log Log) throws Exception {
		try {
			String ID=null;
			Thread.sleep(1000);
			String iType=testdatamap.get("InvoiceType").toString();
			if(iType.equalsIgnoreCase("BIlID")) {
				Thread.sleep(3000);
				scrollDowntillend(driver);
				if(CheckElementExists(EdaatOR.Biller_Invoice_BillNo)==false){
					naviagteCreateInvoicePage();
					enterClientNameOrNationalID(testdatamap);
					selectTemplate(testdatamap);
					addProductDetails(testdatamap);
					enterInvoicDetails(testdatamap);
					ID=getBillerID();
					enterInvoiceCaseSaveType(testdatamap);
					int afterSave=getInvoiceCountNextAfteradd();
					WebClick(EdaatOR.Biller_Invoice_BillNo+"/span[text(),'"+ID+"']");
				}
				else {
					ID=getText("("+EdaatOR.Biller_Invoice_BillNo+"/span)[2]");
					WebClickUsingJS("("+EdaatOR.Biller_Invoice_BillNo+"/span)[2]");
				}
				switchToWindow();
				Thread.sleep(1000);
				takeScreenShot();
				VerifyValue1(getText(EdaatOR.Biller_Invoice_BillerNumber), ID);
				WebClick(EdaatOR.Biller_Invoice_PrintButton);
				takeScreenShot();
				test.log(Status.PASS,"#FUNC-Verify Bill Number Clickable and Print" + driver.getTitle() +" * Export Bill details PASS * " );
				Log.ReportEvent("PASS", " Verify Invoice ID and Printd");
			}
		}
		catch(Exception e){
			test.log(Status.FAIL,"#FUNC-Verify Bill Number Clickable and Print" + driver.getTitle() +" * Export Invoice details FAIL * " );
			this.takeScreenShot();
		}
	}



	//Function Summary   : Method to Navigate Exported contract and Print invoice details.
	//Parameter Summary :  InvoiceType,ExportContact.

	public void verifyExportContact(Map<Object,Object> testdatamap,Log Log) throws Exception {
		try {
			String ID=null;
			String iType=testdatamap.get("InvoiceType").toString();
			if(iType.equalsIgnoreCase("ExportContact")) {
				naviagteReveiableExportContact(Log);
				Thread.sleep(1000);
				if(CheckElementExists(EdaatOR.Biller_ExportContact_InvID)==false){
					naviagteCreateInvoicePage();
					enterClientNameOrNationalID(testdatamap);
					selectTemplate(testdatamap);
					addProductDetails(testdatamap);
					enterInvoicDetails(testdatamap);
					ID=getBillerContactID();
					enterInvoiceCaseSaveType(testdatamap);
					int afterSave=getInvoiceCountNextAfteradd();
					WebClick(EdaatOR.Biller_Invoice_BillNo+"/span[text(),'"+ID+"']");
				}
				else {
					ID=getText(EdaatOR.Biller_ExportContact_InvID+"/span");
					WebClick(EdaatOR.Biller_ExportContact_InvID+"/span");
				}
				switchToWindow();
				Thread.sleep(1000);
				this.takeScreenShot();
				VerifyValue1(getText(EdaatOR.Biller_ExportContact_ContactHeader), ID);
				verifyElementIsPresent(EdaatOR.Biller_ExportContact_InvoiceDetails);
				WebClick(EdaatOR.Biller_Invoice_PrintButton);
				Thread.sleep(3000);
//				verifyElementIsPresent(EdaatOR.Biller_Invoice_ViewInsButton);
//				Thread.sleep(3000);
//				WebClick(EdaatOR.Biller_Invoice_ViewInsButton);
//				Thread.sleep(5000);
//				switchToWindow();
//				verifyElementIsPresent(EdaatOR.Biller_Invoice_ContractNumber);
				test.log(Status.PASS,"#FUNC-Verify Export Contact Clickable and Print" + driver.getTitle() +" * Export Bill details PASS * " );
				Log.ReportEvent("PASS", " Verify Export Contact");
			}
		}
		catch(Exception e){
			test.log(Status.FAIL,"#FUNC-Verify Export Contact Clickable and Print" + driver.getTitle() +" * Export Invoice details FAIL * " );
			this.takeScreenShot();
		}
	}

	public void getInvoiceDetails(Map<Object,Object> testdatamap) throws Exception {
		testdatamap.put("InvoiceID",getText(EdaatOR.Biller_ExportBille_InvoiceID));
	}

	//Function Summary   : Method to enterClientName
	//Parameter Summary :  ClientID,ClientName
	public void enterClientName(Map<Object, Object> testdatamap) throws Exception {

		String client=testdatamap.get("ClientID").toString();
		if(client.equalsIgnoreCase("Individual")) {
			ClickOnIndividualRadBtn();
			SelectIndCustomerID(testdatamap.get("ClientName").toString());
		}
		else{
			ClickOnCoporateRadBtn();
			SelectCopCustomerID(testdatamap.get("ClientName").toString());
		}
	}
	//Function Summary   : Method to CreateNewInvoice
	//Parameter Summary :  TemplateName,Month,Year,Date,BilNumber
	public void CreateNewInvoice(Map<Object, Object> testdatamap,Log Log) {
		try
		{
			naviagteCreateInvoicePage();
			enterClientName(testdatamap);
			Thread.sleep(2000);
			selectDropdownValue_PartialText(EdaatOR.Biller_Receivables_Template,testdatamap.get("TemplateName").toString());
			Thread.sleep(2000);
			addProductDetails(testdatamap);
			this.takeScreenShot();
			Thread.sleep(2000);
			WebClick(EdaatOR.Biller_Receivables_Invoiceduedate);
			Thread.sleep(2000);
			selectDropdownValue_PartialText(EdaatOR.Biller_Receivables_Invoiceduedate_month,testdatamap.get("Month").toString());
			Thread.sleep(1000);
			selectDropdownValue_PartialText(EdaatOR.Biller_Receivables_Invoiceduedate_year,testdatamap.get("Year").toString());
			Thread.sleep(1000);
			WebClick("//a[text()='"+testdatamap.get("Date").toString()+"']");
			this.takeScreenShot();
			Thread.sleep(1000);
			WebClick(EdaatOR.Biller_Receivables_CreateExport);
			Thread.sleep(30000);
			WebClick(EdaatOR.Biller_Invoice_NextPrevLink);
			Thread.sleep(40000);
			testdatamap.put("BilNumber",getText(EdaatOR.Biller_Receivables_billnumber));
			Thread.sleep(40000);
			this.takeScreenShot();
			Thread.sleep(1000);		
        	Log.ReportEvent("PASS", "Step4 : Verify To Create a New Invoice and Capture the Bill Number is successfull");

		}
		catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	public void Onetimeerrorvalidation(Map<Object,Object> testdatamap) {
		try
		{
			
			String Testfield= testdatamap.get("Type").toString();		
						
				naviagteCreateInvoicePage();
				//enterClientNameOrNationalID(testdatamap);
	        	Thread.sleep(2000);
				selectDropdownValue_PartialText(EdaatOR.Biller_Receivables_Template,testdatamap.get("TemplateName").toString());
			
			if(Testfield.equalsIgnoreCase("Invoiceduedate"))
			{
			WebClick(EdaatOR.Biller_CreateandSaveUi);
			verifyElementIsPresent(EdaatOR.Biller_InvoiceduedateUi);
			Thread.sleep(1000);
			driver.findElement(By.xpath(EdaatOR.BillerInternalcode)).sendKeys(Keys.PAGE_DOWN);
			Thread.sleep(1000);
			test.log(Status.PASS,"#FUNC-Verify Receviables Invoicedue date error message" + driver.getTitle() +" * Receviables Invoicedue date error message is Pass * " );
			this.takeScreenShot();			
		}
			else if(Testfield.equalsIgnoreCase("InvoiceExpiredate"))
			{
				    duedate(testdatamap);
		        	Thread.sleep(2000);
		        	WebClick(EdaatOR.Biller_CreateandSaveUi);
					verifyElementIsPresent(EdaatOR.Biller_InvoiceExpiredateUi);
					Thread.sleep(1000);
					driver.findElement(By.xpath(EdaatOR.Biller_Invoice_DueDate)).sendKeys(Keys.PAGE_UP);
					Thread.sleep(1000);
					test.log(Status.PASS,"#FUNC-Verify Receviables InvoiceExpire date error message" + driver.getTitle() +" * Receviables InvoiceExpire date error message is Pass * " );
					this.takeScreenShot();
			}
			else if(Testfield.equalsIgnoreCase("Invoiceduedate1"))
			{
				 
				    Expiredate(testdatamap);
		        	Thread.sleep(2000);
		        	WebClick(EdaatOR.Biller_CreateandSaveUi);
					verifyElementIsPresent(EdaatOR.Biller_InvoiceduedateUi);
					Thread.sleep(1000);
					driver.findElement(By.xpath(EdaatOR.BillerInternalcode)).sendKeys(Keys.PAGE_UP);
					Thread.sleep(1000);
					test.log(Status.PASS,"#FUNC-Verify Receviables Invoicedue date error message" + driver.getTitle() +" * Receviables Invoicedue date error message is Pass * " );
					this.takeScreenShot();
			}
			else if(Testfield.equalsIgnoreCase("Fromhour"))
			{
				    duedate(testdatamap);
		        	Thread.sleep(2000);
				    Expiredate(testdatamap);
		        	Thread.sleep(2000);
		        	WebClick(EdaatOR.Biller_CreateandSaveUi);
					verifyElementIsPresent(EdaatOR.Biller_InvoiceFromhourUi);
					Thread.sleep(1000);
					driver.findElement(By.xpath(EdaatOR.BillerInternalcode)).sendKeys(Keys.PAGE_UP);
					Thread.sleep(1000);
					test.log(Status.PASS,"#FUNC-Verify Receviables Invoice Fromhour error message" + driver.getTitle() +" * Receviables Invoice Fromhour error message is Pass * " );
					this.takeScreenShot();
			}
			else if(Testfield.equalsIgnoreCase("ToTime"))
			{
				    duedate(testdatamap);
		        	Thread.sleep(2000);
				    Expiredate(testdatamap);
		        	Thread.sleep(2000);
		        	WebEdit(EdaatOR.Biller_Fromhour,testdatamap.get("FromHour").toString());
		        	Thread.sleep(2000);
		        	WebClick(EdaatOR.Biller_CreateandSaveUi);
					verifyElementIsPresent(EdaatOR.Biller_InvoiceTotimeUi);
					Thread.sleep(1000);
					driver.findElement(By.xpath(EdaatOR.BillerInternalcode)).sendKeys(Keys.PAGE_UP);
					Thread.sleep(1000);
					test.log(Status.PASS,"#FUNC-Verify Receviables Invoice Totime error message" + driver.getTitle() +" * Receviables Invoice Totime error message is Pass * " );
					this.takeScreenShot();
			}
			else if(Testfield.equalsIgnoreCase("Fromhour1"))
			{
				    duedate(testdatamap);
		        	Thread.sleep(2000);
				    Expiredate(testdatamap);
		        	Thread.sleep(2000);
		        	WebEdit(EdaatOR.Biller_Totime,testdatamap.get("ToTime").toString());
		        	Thread.sleep(2000);
		        	WebClick(EdaatOR.Biller_CreateandSaveUi);
					verifyElementIsPresent(EdaatOR.Biller_InvoiceFromhourUi);
					Thread.sleep(1000);
					driver.findElement(By.xpath(EdaatOR.BillerInternalcode)).sendKeys(Keys.PAGE_UP);
					Thread.sleep(1000);
					test.log(Status.PASS,"#FUNC-Verify Receviables Invoice Totime error message" + driver.getTitle() +" * Receviables Invoice Totime error message is Pass * " );
					this.takeScreenShot();
			}
			else if(Testfield.equalsIgnoreCase("Condition"))
			{
				    duedate(testdatamap);
		        	Thread.sleep(2000);
				    Expiredate(testdatamap);
		        	Thread.sleep(2000);
		        	WebEdit(EdaatOR.Biller_Fromhour,testdatamap.get("FromHour").toString());
		        	Thread.sleep(2000);
		        	WebEdit(EdaatOR.Biller_Totime,testdatamap.get("ToTime").toString());
		        	Thread.sleep(2000);
		        	WebClick(EdaatOR.Biller_CreateandSaveUi);
					verifyElementIsPresent(EdaatOR.Biller_InvoiceConditionUi);
					Thread.sleep(1000);
					driver.findElement(By.xpath(EdaatOR.BillerInternalcode)).sendKeys(Keys.PAGE_UP);
					Thread.sleep(1000);
					test.log(Status.PASS,"#FUNC-Verify Receviables Invoice Totime error message" + driver.getTitle() +" * Receviables Invoice Totime error message is Pass * " );
					this.takeScreenShot();
			}
			else if(Testfield.equalsIgnoreCase("Clienttype"))
			{
				    duedate(testdatamap);
		        	Thread.sleep(2000);
				    Expiredate(testdatamap);
		        	Thread.sleep(2000);
		        	WebEdit(EdaatOR.Biller_Fromhour,testdatamap.get("FromHour").toString());
		        	Thread.sleep(2000);
		        	WebEdit(EdaatOR.Biller_Totime,testdatamap.get("ToTime").toString());
		        	Thread.sleep(2000);
		        	WebEdit(EdaatOR.Biller_Condition,testdatamap.get("Condition").toString());
		        	WebClick(EdaatOR.Biller_CreateandSaveUi);
					verifyElementIsPresent(EdaatOR.Biller_Selecttype);
					Thread.sleep(2000);
					driver.findElement(By.xpath(EdaatOR.BillerInternalcode)).sendKeys(Keys.PAGE_UP);
					Thread.sleep(1000);
					test.log(Status.PASS,"#FUNC-Verify Receviables Invoice Clienttype error message" + driver.getTitle() +" * Receviables Invoice Clienttype error message is Pass * " );
					this.takeScreenShot();
			}
			else if(Testfield.equalsIgnoreCase("Product"))
			{		   
	        	          	  
	        	  
				    duedate(testdatamap);	        	   
		        	Thread.sleep(2000);
				    Expiredate(testdatamap);
		        	Thread.sleep(2000);
		        	WebClickUsingJS(EdaatOR.Biller_Indivbtn);
		        	Thread.sleep(2000);
		        	SelectIndCustomerID(testdatamap.get("ClientName").toString());
		        	//enterClientNameOrNationalID(testdatamap);
		        	Thread.sleep(5000);
		        	WebEdit(EdaatOR.Biller_Fromhour,testdatamap.get("FromHour").toString());
		        	Thread.sleep(2000);
		        	WebEdit(EdaatOR.Biller_Totime,testdatamap.get("ToTime").toString());
		        	Thread.sleep(2000);
		        	WebEdit(EdaatOR.Biller_Condition,testdatamap.get("Condition").toString());
		        	Thread.sleep(2000);		        	
		        	WebClick(EdaatOR.Biller_CreateandSaveUi);
					verifyElementIsPresent(EdaatOR.Biller_Product);
					Thread.sleep(2000);
					driver.findElement(By.xpath(EdaatOR.BillerInternalcode)).sendKeys(Keys.PAGE_UP);
					Thread.sleep(1000);
					test.log(Status.PASS,"#FUNC-Verify Receviables Invoice Clienttype error message" + driver.getTitle() +" * Receviables Invoice Clienttype error message is Pass * " );
					this.takeScreenShot();
			}
			else if(Testfield.equalsIgnoreCase("Invoice Due Date"))
			{
			WebClickUsingJS(EdaatOR.Biller_CreateIns);
			verifyElementIsPresent(EdaatOR.Biller_Invoiceduedateerrormsg);
			Thread.sleep(2000);
			driver.findElement(By.xpath(EdaatOR.Biller_Invoiceduration)).sendKeys(Keys.PAGE_UP);
			Thread.sleep(1000);
			test.log(Status.PASS,"#FUNC-Verify Receviables Invoicedue date error message" + driver.getTitle() +" * Receviables Invoicedue date error message is Pass * " );
			this.takeScreenShot();			
		}
			else if(Testfield.equalsIgnoreCase("Duration type"))
			{
			duedate(testdatamap);
			Thread.sleep(2000);
			addProductDetails(testdatamap);
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Biller_CreateIns);
			verifyElementIsPresent(EdaatOR.Biller_InvoiceDurationUi);
			Thread.sleep(2000);
			driver.findElement(By.xpath(EdaatOR.Biller_Invoiceduration)).sendKeys(Keys.PAGE_UP);
			Thread.sleep(1000);
			test.log(Status.PASS,"#FUNC-Verify Receviables Duration type error message" + driver.getTitle() +" * Receviables Duration type error message is Pass * " );
			this.takeScreenShot();			
		}
			else if(Testfield.equalsIgnoreCase("Client Type"))
			{
			duedate(testdatamap);
			Thread.sleep(2000);
			addProductDetails(testdatamap);
			Thread.sleep(2000);
			SelectDuration(testdatamap.get("Duration").toString());
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Biller_CreateIns);
			verifyElementIsPresent(EdaatOR.Biller_Selecttype);
			Thread.sleep(2000);
			driver.findElement(By.xpath(EdaatOR.Biller_Invoiceduration)).sendKeys(Keys.PAGE_UP);
			Thread.sleep(1000);
			test.log(Status.PASS,"#FUNC-Verify Receviables Client type error message" + driver.getTitle() +" * Receviables Client type error message is Pass * " );
			this.takeScreenShot();			
		}
			else if(Testfield.equalsIgnoreCase("Description"))
			{
			duedate(testdatamap);
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Biller_Indivbtn);
        	Thread.sleep(2000);
        	SelectIndCustomerID(testdatamap.get("ClientName").toString());
        	Thread.sleep(2000);
			addProductDetails(testdatamap);
			Thread.sleep(2000);
			SelectDuration(testdatamap.get("Duration").toString());
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Biller_CreateIns);
			Thread.sleep(4000);
			WebClickUsingJS(EdaatOR.Biller_Invoiceexportbtn);
			verifyElementIsPresent(EdaatOR.Biller_Descriptiondetails);
			Thread.sleep(2000);		
			test.log(Status.PASS,"#FUNC-Verify Receviables Description error message" + driver.getTitle() +" * Receviables Description error message is Pass * " );
			this.takeScreenShot();			
		}
			else if(Testfield.equalsIgnoreCase("Select Client"))
			{
			duedate(testdatamap);
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Biller_Indivbtn);
        	Thread.sleep(2000);
        	SelectIndCustomerID(testdatamap.get("ClientName").toString());
        	Thread.sleep(2000);
			addProductDetails(testdatamap);
			Thread.sleep(2000);
			SelectDuration(testdatamap.get("Duration").toString());
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Biller_CreateIns);
			verifyElementIsPresent(EdaatOR.Biller_Selectclienttype);
			Thread.sleep(4000);							
			test.log(Status.PASS,"#FUNC-Verify Receviables Select client error message" + driver.getTitle() +" * Receviables Select Client error message is Pass * " );
			this.takeScreenShot();			
		}
			else if(Testfield.equalsIgnoreCase("Tax"))
			{
			WebClickUsingJS(EdaatOR.Biller_addtax);			
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Biller_addbutton);
			this.takeScreenShot();
			verifyElementIsPresent(EdaatOR.Biller_taxerrormsg);
			Thread.sleep(2000);
			test.log(Status.PASS,"#FUNC-Verify Receviables Tax error message" + driver.getTitle() +" * Receviables Tax error message is Pass * " );
					
		}
			else if(Testfield.equalsIgnoreCase("Discount"))
			{
			WebClickUsingJS(EdaatOR.Biller_adddiscount);
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Biller_adddisbutton);
			this.takeScreenShot();	
			verifyElementIsPresent(EdaatOR.Biller_discounterrormsg);
			Thread.sleep(1000);
			test.log(Status.PASS,"#FUNC-Verify Receviables Discount error message" + driver.getTitle() +" * Receviables Discount error message is Pass * " );
					
		}
		}
		catch(Exception e)
		{
			test.log(Status.FAIL,"#FUNC-Verify Receviables error message" + driver.getTitle() +" * Receviables error message is FAIL * " );
			this.takeScreenShot();
		}
	}
	public void duedate(Map<Object,Object> testdatamap) throws InterruptedException
	{
		    WebClick(EdaatOR.Biller_Invoice_DueDate);
	        Thread.sleep(1000);
	    	selectDropdownValue_PartialText(EdaatOR.Biller_Invoice_Fromyear,testdatamap.get("FromYear").toString());
	    	Thread.sleep(1000);
	    	selectDropdownValue_PartialText(EdaatOR.Biller_Invoice_FromMonth,testdatamap.get("FromMonth").toString());
	    	Thread.sleep(1000);
      	    WebClick("//a[text()='"+testdatamap.get("FromDate").toString()+"']");
		
	}
	
	public void Expiredate(Map<Object,Object> testdatamap) throws InterruptedException
	{
		WebClick(EdaatOR.Biller_Invoice_TODate);
    	Thread.sleep(1000);
    	selectDropdownValue_PartialText(EdaatOR.Biller_Invoice_Toyear,testdatamap.get("ToYear").toString());
    	Thread.sleep(1000);
    	selectDropdownValue_PartialText(EdaatOR.Biller_Invoice_ToMonth,testdatamap.get("ToMonth").toString());
    	Thread.sleep(1000);
    	WebClick("//a[text()='"+testdatamap.get("ToDate").toString()+"']");
		
	}
		//Function Summary   : Method to verify Newly Added PaymentMethod Column In Grid	
	public void verifyNewlyAddedPaymentMethodColumnInGrid(Log Log) throws Exception
	{
		Thread.sleep(500);
		WebElement element=driver.findElement(By.xpath(EdaatOR.Biller_ExportedContract_Searchbtn));
		scrollToElement(driver, element);
		this.takeScreenShot();
		verifyElementIsPresent(EdaatOR.Biller_ExportedBills_PaymentMethod);
		Thread.sleep(500);
		this.takeScreenShot();
		test.log(Status.PASS,"#FUNC-verify Newly Added PaymentMethod Column In Grid" + driver.getTitle() +" * verify Newly Added PaymentMethod is Pass * " );
		Log.ReportEvent("PASS", " verified Newly Added PaymentMethod Column In Grid");
		
	}
	//Function Summary  : Method to select payment method
	//Parameter Summary : PaymentMethod	
		public void selectPaymentMethod(Map<Object,Object> testdatamap) throws InterruptedException
	{
    	Thread.sleep(1000);
    	WebSelect(EdaatOR.Biller_PaymentMethod,testdatamap.get("PaymentMethod").toString());
    	Thread.sleep(1000);
		
	}
		
	//Function Summary  : Method to click on search button
	//Parameter Summary : N/A	
	public void clickOnSearchButton() throws InterruptedException
	{
		WebClick(EdaatOR.Admin_Button);
    	Thread.sleep(2000);
		
	}
	//Function Summary  : Method to enter contract number
	//Parameter Summary : ContractNumber	
	public void enterContractNumber(Map<Object,Object> testdatamap) throws InterruptedException
	{
    	Thread.sleep(1000);
		WebEdit(EdaatOR.Biller_Receivables_ContractNumber_Textfeild,testdatamap.get("ContractNumber").toString());
		
	}
	
	//Function Summary  : Method to verify new search criteria in Exported contracts page for the payment method
	//Parameter Summary : PaymentMethod	
	public void verifyPaymentMethodInExportContactSearch(Map<Object,Object> testdatamap,Log Log) {
		try {

			Thread.sleep(2000);
			verifyElementIsPresent(EdaatOR.Biller_PaymentMethod, "Payment method dropdown");
			WebClick(EdaatOR.Biller_PaymentMethod);
	    	Thread.sleep(1000);
	    	List<WebElement> options=getElements(EdaatOR.Biller_ExportContact_PaymentMethodOptions);
	    	if(options.size()==7) {	    	
	    		for (Object option:options){
	    			CheckElementExists(option.toString());
	    	    	this.takeScreenShot();
	    			test.log(Status.PASS,"#FUNC-verify new search criteria in Exported contracts page for the payment method" + driver.getTitle() +" *  verify new search criteria in Exported contracts page for the payment method is successfull PASS * " );
	            	Log.ReportEvent("PASS", " verify new search criteria in Exported contracts page for the payment method is Successful");
	    	}

	    		}
    		else {
    			test.log(Status.FAIL,"verify new search criteria in Exported contracts page for the payment method" + driver.getTitle() +" * verify new search criteria in Exported contracts page for the payment method is unsuccessfull FAIL * " );

    		}

		}
		catch (Exception e) {
			test.log(Status.FAIL,"verify new search criteria in Exported contracts page for the payment method" + driver.getTitle() +" * verify new search criteria in Exported contracts page for the payment method is unsuccessfull FAIL * " );
		}
				
	}
//Function Summary   : Method to verify available payment method appear as logo when click on contract number
	//Parameter Summary :  InvoiceType,ExportContact.

	public void verifyPaymentMethodLogoInContractNumber(Map<Object,Object> testdatamap,Log Log) throws Exception {
		try {
			String ID=null;
			String iType=testdatamap.get("InvoiceType").toString();
			if(iType.equalsIgnoreCase("ExportContact")) {
				naviagteReveiableExportContact(Log);
				Thread.sleep(1000);
				if(CheckElementExists(EdaatOR.Biller_ExportContact_InvID)==false){
					naviagteCreateInvoicePage();
					enterClientNameOrNationalID(testdatamap);
					selectTemplate(testdatamap);
					addProductDetails(testdatamap);
					enterInvoicDetails(testdatamap);
					ID=getBillerContactID();
					enterInvoiceCaseSaveType(testdatamap);
					int afterSave=getInvoiceCountNextAfteradd();
					WebClick(EdaatOR.Biller_Invoice_BillNo+"/span[text(),'"+ID+"']");

				}
				else {
					ID=getText(EdaatOR.Biller_ExportContact_InvID+"/span");
					WebClick(EdaatOR.Biller_ExportContact_InvID+"/span");
				}
				switchToWindow();
				Thread.sleep(2000);
				scrollDowntillend(driver);
				this.takeScreenShot();
				verifyElementIsPresent(EdaatOR.Biller_ExportContact_PaymentMethodLogo_Sadad);
				verifyElementIsPresent(EdaatOR.Biller_ExportContact_PaymentMethodLogo_Mada);
				verifyElementIsPresent(EdaatOR.Biller_ExportContact_PaymentMethodLogo_MasterCard);
				verifyElementIsPresent(EdaatOR.Biller_ExportContact_PaymentMethodLogo_Visa);
				test.log(Status.PASS,"#FUNC-verify available payment method appear as logo when click on contract number" + driver.getTitle() +" * verify available payment method appear as logo when click on contract number PASS * " );
				Log.ReportEvent("PASS", " verify available payment method appear as logo when click on contract number");
			}
		}
		catch(Exception e){
			test.log(Status.FAIL,"#FUNC-verify available payment method appear as logo when click on contract number" + driver.getTitle() +" * verify available payment method appear as logo when click on contract number * " );
			this.takeScreenShot();
		}
	}
	//Function Summary   : Method to verify that the available payment method appears when click on view button of an invoice
		//Parameter Summary :  InvoiceType,ExportContact.
	 
		public void verifyPaymentMethodLogoInBillNumber(Map<Object,Object> testdatamap,Log Log) throws Exception {
			try {
				String ID=null;
				String iType=testdatamap.get("InvoiceType").toString();
				if(iType.equalsIgnoreCase("ExportContact")) {
					naviagteReveiableExportBiller(Log);
					Thread.sleep(1000);
					if(CheckElementExists(EdaatOR.Biller_Invoice_BillNo)==false){
						naviagteCreateInvoicePage();
						enterClientNameOrNationalID(testdatamap);
						selectTemplate(testdatamap);
						addProductDetails(testdatamap);
						enterInvoicDetails(testdatamap);
						ID=getBillerContactID();
						enterInvoiceCaseSaveType(testdatamap);
						int afterSave=getInvoiceCountNextAfteradd();
						WebClick(EdaatOR.Biller_Invoice_BillNo+"/span[text(),'"+ID+"']");
	 
					}
					else {
						ID=getText(EdaatOR.Biller_Invoice_BillNo+"/span");
						WebClick(EdaatOR.Biller_Invoice_BillNo+"/span");
					}
					switchToWindow();
					Thread.sleep(2000);
					scrollDowntillend(driver);
					this.takeScreenShot();
					verifyElementIsPresent(EdaatOR.Biller_ExportContact_PaymentMethodLogo_Sadad);
					verifyElementIsPresent(EdaatOR.Biller_ExportContact_PaymentMethodLogo_Mada);
					verifyElementIsPresent(EdaatOR.Biller_ExportContact_PaymentMethodLogo_Visa);
					verifyElementIsPresent(EdaatOR.Biller_ExportContact_PaymentMethodLogo_MasterCard);
					test.log(Status.PASS,"#FUNC-verify that the available payment method appears when click on view button of an invoice" + driver.getTitle() +" * verify that the available payment method appears when click on view button of an invoice PASS * " );
					Log.ReportEvent("PASS", " verify that the available payment method appears when click on view button of an invoice");
				}
			}
			catch(Exception e){
				test.log(Status.FAIL,"#FUNC-verify that the available payment method appears when click on view button of an invoice" + driver.getTitle() +" * verify that the available payment method appears when click on view button of an invoice FAIL * " );
				this.takeScreenShot();
			}
		}
		//Function Summary  : Method to uncheck payment methods checkbox
	//Parameter Summary : N/A	
	public void uncheckOrCheckPaymentMethods() throws InterruptedException
	{
		WebClick(EdaatOR.Biller_ExportBills_SadadPaymentMethod);
		Thread.sleep(100);
		WebClick(EdaatOR.Biller_ExportBills_MadaPaymentMethod);			
		Thread.sleep(100);
		WebClick(EdaatOR.Biller_ExportBills_VisaPaymentMethod);
		Thread.sleep(100);
		WebClick(EdaatOR.Biller_ExportBills_MasterCardPaymentMethod);			
		Thread.sleep(100);
		WebClick(EdaatOR.Biller_ExportBills_ApplePaydPaymentMethod);			
		Thread.sleep(100);
		
	}
		//Function Summary   : Method to create invoice with only paid outside edaat payment method.
	//Parameter Summary :  InvoiceType,Export.
	public void verifyToCreateInvoiceOnlyForPaidOutsideEdaat(Map<Object,Object> testdatamap,Log Log) throws Exception {
		try {
				naviagteCreateInvoicePage();
				enterClientNameOrNationalID(testdatamap);
				Thread.sleep(100);
				selectTemplate(testdatamap);
				Thread.sleep(100);
				addProductDetails(testdatamap);
				Thread.sleep(400);
				uncheckOrCheckPaymentMethods();
				enterInvoicDetails(testdatamap);
				Thread.sleep(100);
				enterInvoiceCaseSaveType(testdatamap);
				Thread.sleep(100);
				waitForPageToLoad();
				WebClickUsingJS(EdaatOR.Biller_ExportBill_Link);
				CheckElementExists1(EdaatOR.Biller_ExportBills_error);
//				VerifyValue1(getText(EdaatOR.Biller_ExportBills_error),testdatamap.get("Error").toString());
				test.log(Status.PASS,"#FUNC-create invoice with only paid outside edaat payment method" + driver.getTitle() +" * PASS * " );				
				takeScreenShot();
				Log.ReportEvent("PASS", "Verify to create invoice with only paid outside edaat payment method");
			

		}
		catch(Exception e){
			test.log(Status.FAIL,"#FUNC-create invoice with only paid outside edaat payment method" + driver.getTitle() +" *FAIL * " );
			this.takeScreenShot();
		}
	}
	//Function Summary  : Method to enter transfer notes text area
	//Parameter Summary : N/A	
	public void enterTransferNotesTextArea(int length) throws InterruptedException
	{
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append('a'); 
        }
		Thread.sleep(200);
        WebEdit(EdaatOR.Biller_ExportBills_TransferRemarkTextArea, sb.toString());
		Thread.sleep(100);

	}
		//Function Summary   : Method to verify max length of Transfer Notes textarea
	//Parameter Summary :  InvoiceType,Save.
	public void verifyMaxLengthOfTransferRemarkField(Map<Object,Object> testdatamap,Log Log) throws Exception {
		try {
				naviagteCreateInvoicePage();
				enterClientNameOrNationalID(testdatamap);
				Thread.sleep(100);
				selectTemplate(testdatamap);
				Thread.sleep(100);
				addProductDetails(testdatamap);
				Thread.sleep(300);
				EnterIssuedDate();
				Thread.sleep(500);
				enterTransferNotesTextArea(280);
				Thread.sleep(500);
				ClickOnCreateInvoiceBtn();
				test.log(Status.PASS,"#FUNC-verify that text length is free text with max length 280 char" + driver.getTitle() +" * PASS * " );				
				takeScreenShot();
				Log.ReportEvent("PASS", "verify that text length is free text with max length 280 char");
			
		}
		catch(Exception e){
			test.log(Status.FAIL,"#FUNC-verify that text length is free text with max length 280 char" + driver.getTitle() +" *FAIL * " );
			this.takeScreenShot();
		}
	}
	//Function Summary   : Method to verify Payment Method Is Editable For Exported Contracts
	//Parameter Summary  : ContractNumber,Status
	public void verifyPaymentMethodIsEditableForExportedContracts(Map<Object, Object> testdatamap, Log Log) throws Exception {

		try {
			enterContractNumber(testdatamap);
			Thread.sleep(500);
			clickOnSearchButton();
			Thread.sleep(2000);
			VerifyValue1(getText(EdaatOR.Biller_Receivables_exportedContracts_StatusInGrid),testdatamap.get("Status").toString());
			WebClick(EdaatOR.Biller_ExportContact_InvID+"/span");
			switchToWindow();
			uncheckOrCheckPaymentMethods();
			this.takeScreenShot();
			WebClickUsingJS(EdaatOR.Biller_Receivables_exportedContracts_SaveButton);
			Thread.sleep(500);
			if(CheckElementExists(EdaatOR.Biller_Receievables_PaymentMethod_Update_PopupHeader)) {
				verifyElementIsPresent(EdaatOR.Biller_Receievables_PaymentMethod_Update_PopupHeader);
				this.takeScreenShot();
				WebClickUsingJS(EdaatOR.Biller_Receievables_PaymentMethod_Add_Btn);
				Thread.sleep(2000);
				test.log(Status.PASS,"#FUNC-verify that the payment methods is editable after the invoice partial paid is successfull" + driver.getTitle() +" * PASS * " );	
				Log.ReportEvent("PASS", " verify that the payment methods is editable after the invoice partial paid is successfull");
			}
			else
			{
				test.log(Status.FAIL,"#FUNC-verify that the payment methods is editable after the invoice partial paid is Unsuccessfull" + driver.getTitle() +" * FAIL * " );	
			}

		} catch (Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL,"#FUNC-verify that the payment methods is editable after the invoice partial paid is Unsuccessfull" + driver.getTitle() +" *FAIL * " );
		}
	}
	//Function Summary   : Method to verify Default Payment Method Is Selected And Disabled
		//Parameter Summary :  TemplateName
		public void verifyDefaultPaymentMethodIsSelectedAndDisabled(Map<Object,Object> testdatamap,Log Log)
		{
			try {
				this.takeScreenShot();
				naviagteCreateInvoicePage();
				Thread.sleep(2000);
				selectTemplate(testdatamap);
				Thread.sleep(2000);
				this.takeScreenShot();
				WebElement paymentField = driver.findElement(By.xpath(EdaatOR.Biller_ExportBills_DefaultPaymentMethod));
				if(paymentField.isSelected()&& !paymentField.isEnabled()==true)
				{
					test.log(Status.PASS,"#FUNC-verify Default Payment Method Is Selected And Disabled" + driver.getTitle() +" * verify Default Payment Method Is Selected And Disabled PASS * " );
					Log.ReportEvent("PASS", " Verify Default Payment Method Is Selected And Disabled is successfull ");
					
				}
			else
			{
				test.log(Status.FAIL,"#FUNC-Verify Default Payment Method Is Selected And Disabled" + driver.getTitle() +" * verify Default Payment Method Is Selected And Disabled FAIL * " );

			}
		}
			catch(Exception e){
				test.log(Status.FAIL,"#FUNC-Verify Default Payment Method Is Selected And Disabled" + driver.getTitle() +" * verify Default Payment Method Is Selected And Disabled FAIL * " );
				this.takeScreenShot();
			}
			
	}
	//Function Summary   : Method to verifyNewPaymentMethodColumnIsAdded
	//Parameter Summary  : N/A 
	public void verifyNewPaymentMethodColumnIsAdded(Log Log) throws Exception {
		try {
			verifyElementIsPresent(EdaatOR.Biller_Receievables_PaymentMethod);
			test.log(Status.PASS,"#FUNC-Verify new payment method column is added Functionality is successfull" + driver.getTitle() +" * Verify new payment method column is added Functionality is successfull PASS * " );	
	    	Log.ReportEvent("PASS", " Verify new payment method column is added Functionality is successfull");
		} catch (Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL,"#FUNC-Verify new payment method column is added Functionality is Failed" + driver.getTitle() +" * Verify new payment method column is added Functionality is Failed FAIL * " );	
		}
		
	}

	//Function Summary   : Method to verifyPaymentMethodIsEditable
	//Parameter Summary  : BillNumber,Status
	public void verifyPaymentMethodIsEditable(Map<Object, Object> testdatamap, Log Log) throws Exception {
		
		try {
			WebEdit(EdaatOR.Biller_receivables_BillNumber,testdatamap.get("BillNumber").toString());
			Thread.sleep(2000);
			WebClick(EdaatOR.Biller_receivables_SrchBtn);
			Thread.sleep(2000);
			VerifyValue1(getText(EdaatOR.Biller_Receivables_Bill_Status),testdatamap.get("Status").toString());
			WebClickUsingJS(EdaatOR.Biller_Export_ViewContactBtn);
			switchToWindow();
			WebClickUsingJS(EdaatOR.Biller_Receievables_PaymentMethod_Mada);
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Biller_Receievables_PaymentMethod_Visa);
			WebClickUsingJS(EdaatOR.Biller_Receievables_PaymentMethod_MasterCard);
			WebClickUsingJS(EdaatOR.Biller_Receievables_PaymentMethod_Savebtn);
			if(CheckElementExists(EdaatOR.Biller_Receievables_PaymentMethod_Update_PopupHeader)) {
				verifyElementIsPresent(EdaatOR.Biller_Receievables_PaymentMethod_Update_PopupHeader);
				this.takeScreenShot();
				WebClickUsingJS(EdaatOR.Biller_Receievables_PaymentMethod_Add_Btn);
				Thread.sleep(2000);
				this.takeScreenShot();
				test.log(Status.PASS,"#FUNC-verify that the available payment methods is editable after the invoice partially paid Functionality is successfull" + driver.getTitle() +" * verify that the available payment methods is editable after the invoice partially paid  Functionality is successfull PASS * " );	
		    	Log.ReportEvent("PASS", " verify that the available payment methods is editable after the invoice partially paid Functionality is successfull");
			}
			else
			{
				test.log(Status.FAIL,"#FUNC-verify that the available payment methods is editable after the invoice partially paid Functionality is Unsuccessfull" + driver.getTitle() +" * verify that the available payment methods is editable after the invoice partially paid  Functionality is Unsuccessfull FAIL * " );	
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL,"#FUNC-verify that the available payment methods is editable after the invoice partially paid Functionality is Unsuccessfull" + driver.getTitle() +" * verify that the available payment methods is editable after the invoice partially paid  Functionality is Unsuccessfull FAIL * " );	
		}
		
	
	}
	//Function Summary   : Method to search exported bills
	//Parameter Summary  : BillNumber
	public void searchExportedBillsUsingBillNUmber(Map<Object, Object> testdatamap, Log Log) throws Exception {
		try {
			WebEdit(EdaatOR.Biller_receivables_BillNumber,testdatamap.get("BillNumber").toString());
			Thread.sleep(800);
			WebClick(EdaatOR.Biller_receivables_SrchBtn);
			Thread.sleep(2000);
			VerifyValue1(getText(EdaatOR.Biller_ReceivableExportedBills_BillNumber),testdatamap.get("BillNumber").toString());
		}
		 catch (Exception e) {
				e.printStackTrace();
				test.log(Status.FAIL,"#FUNC-search exported bills is Unsuccessfull" + driver.getTitle() +" *FAIL * " );
			}
	}


	//Function Summary   : Method to VerifyTransferRemarkFieldAppearsAfterSelectingSubBiller
	//Parameter Summary  : N/A 
	public void VerifyTransferRemarkFieldAppearsAfterSelectingSubBiller(Map<Object, Object> testdatamap, Log Log) throws Exception {
		try {
			naviagteCreateInvoicePage();
			this.takeScreenShot();
			enterClientNameOrNationalID(testdatamap);
			selectTemplate(testdatamap);
			this.takeScreenShot();
			addProductDetails(testdatamap);
			driver.findElement(By.xpath(EdaatOR.Biller_Rece_Transfer_Remark_TestArea)).sendKeys(Keys.PAGE_DOWN);
			this.takeScreenShot();
			verifyElementIsPresent(EdaatOR.Biller_receivables_SubbillerTransferNotes);
			if (IsDispalyed(EdaatOR.Biller_Rece_Transfer_Remark_TestArea)) {
				this.takeScreenShot();
				test.log(Status.PASS,"#FUNC-Verify Transfer Remark Field Appears After Selecting Sub Biller Functionality is successfull" + driver.getTitle() +" * Verify Transfer Remark Field Appears After Selecting Sub Biller Functionality is successfull PASS * " );	
		    	Log.ReportEvent("PASS", "Verify Transfer Remark Field Appears After Selecting Sub Biller Functionality is successfull");	
			}
			else {
				this.takeScreenShot();
				test.log(Status.FAIL,"#FUNC-Verify Transfer Remark Field Appears After Selecting Sub Biller Functionality is Unsuccessfull" + driver.getTitle() +" * Verify new payment method column is added Functionality is Unsuccessfull FAIL * " );	
			}
		  }
	catch (Exception e) {
			e.printStackTrace();
			this.takeScreenShot();
			test.log(Status.FAIL,"#FUNC-Verify Transfer Remark Field Appears After Selecting Sub Biller Functionality is Unsuccessfull" + driver.getTitle() +" * Verify new payment method column is added Functionality is Unsuccessfull FAIL * " );	

		}
	}
	//Function Summary   : Method to Verify Transfer Remark in invoice details page
	   //Parameter Summary :  InvoiceType,Save,TransferRemarkMessage,BilStatus
		public void createSaveInvoiceDataWithTransferRemark(Map<Object,Object> testdatamap,Log Log) throws Exception {
			
			try {
				String iType=testdatamap.get("InvoiceType").toString();
				if(iType.equalsIgnoreCase("Save")) {
					naviagteCreateInvoicePage();
					enterClientNameOrNationalID(testdatamap);
					Thread.sleep(100);
					selectTemplate(testdatamap);
					Thread.sleep(100);
					addProductDetails(testdatamap);
					Thread.sleep(400);
					verifyElementIsPresent(EdaatOR.Biller_ExportBills_PayedOutSideEdaatPaymentMethod);
					Thread.sleep(400);
					verifyElementIsPresent(EdaatOR.Biller_ExportBills_SadadPaymentMethod);			
					Thread.sleep(100);					
					EnterIssuedDate();
					Thread.sleep(100);
					WebEdit(EdaatOR.Biller_Rece_Transfer_Remark_TestArea,testdatamap.get("TransferRemarkMessage").toString());
					Thread.sleep(100);
					WebClick(EdaatOR.Biller_Rece_CreateandExportButton);					
					waitForPageToLoad();
					Thread.sleep(2000);
					driver.findElement(By.xpath(EdaatOR.Biller_ExportExcel)).sendKeys(Keys.PAGE_DOWN);
					takeScreenShot();
				    int val=1;
					ValidateTwoValue(getText(EdaatOR.Biller_Invoice_AfteraddInvoice+"["+val+"]/td[6]"), testdatamap.get("BilStatus").toString());
					Thread.sleep(100);	
					WebClickUsingJS("("+EdaatOR.Biller_Invoice_BillNo+"/span)[2]");
					Thread.sleep(100);
					switchToWindow();
					VerifyValue1(getText(EdaatOR.Biller_Rece_SubillerTransferNotes), testdatamap.get("TransferRemarkMessage").toString());
					Thread.sleep(100);
					test.log(Status.PASS,"#FUNC-Verify Transfer Remark in invoice details page" + driver.getTitle() +" * Trasfer Remark in invoice details page PASS * " );				
					takeScreenShot();
					Log.ReportEvent("PASS", " Verify Transfer Remark in invoice details page is sucessfull");								
								
				}
 
			}
			catch(Exception e){
				test.log(Status.FAIL,"#FUNC-Verify Transfer Remark in invoice details page" + driver.getTitle() +" * Trasfer Remark in invoice details page Fail * " );				
				this.takeScreenShot();
			}
		}
	
		//Function Summary   : Method to VerifyTransferRemarkFieldDoesntAppearAfterSelectingTemplateOtherThanOneTime
	    //Parameter Summary  : N/A 
		public void VerifyTransferRemarkFieldDoesntAppearAfterSelectingTemplateOtherThanOneTime(
				Map<Object, Object> testdatamap, Log Log) {
			try {
				naviagteCreateInvoicePage();
				this.takeScreenShot();
				enterClientNameOrNationalID(testdatamap);
				selectTemplate(testdatamap);
				Thread.sleep(2000);
				this.takeScreenShot();
				verifyElementIsNotPresent(EdaatOR.Biller_Rece_Transfer_Remark_TestArea);
				this.takeScreenShot();
				test.log(Status.PASS,"#FUNC-Verify Transfer Remark Field Doesnt Appear After Selecting Template Other Than One Time Functionality is successfull" + driver.getTitle() +" * Verify Transfer Remark Field Doesnt Appear After Selecting Template Other Than One Time Functionality is successfull PASS * " );	
		    	Log.ReportEvent("PASS", "Verify Transfer Remark Field Doesnt Appear After Selecting Template Other Than One Time Functionality is successfull");	
			  }
		     catch (Exception e) {
				e.printStackTrace();
				this.takeScreenShot();
				test.log(Status.FAIL,"#FUNC-Verify Transfer Remark Field Doesnt Appear After Selecting Template Other Than One Time Functionality is Unsuccessfull" + driver.getTitle() +" * Verify Transfer Remark Field Doesnt Appear After Selecting Template Other Than One Time Functionality is Unsuccessfull FAIL * " );	
			}
		}	
	public void naviagteReceviableExportedContracts(Log Log) throws InterruptedException {
		ClickOnBReceivableLink();
		ClickOnBillerExportBillLink();
		Thread.sleep(500);
		WebClickUsingJS(EdaatOR.Biller_ExportedContract_Page);
		waitForPageToLoad();
		Log.ReportEvent("PASS", "Verify naviagted Suceessfull Export contract Page");

	}
	
	//Function Summary  : Method to verify Payment Methods List In Export Bills
	
		public void verifyPaymentMethodsListInPaymentMethodDropdownInExportedBills(Log Log) {
			try {	 
				Thread.sleep(2000);
				verifyElementIsPresent(EdaatOR.Biller_PaymentMethod, "Payment method dropdown");
				this.takeScreenShot();
				WebClick(EdaatOR.Biller_PaymentMethod);
		    	Thread.sleep(1000);
		    	List<WebElement> options=getElements(EdaatOR.Biller_ExportContact_PaymentMethodOptions);
		    	if(options.size()==7) {	    	
		    		for (Object option:options){
		    			CheckElementExists(option.toString());
		    	    	this.takeScreenShot();
		    			test.log(Status.PASS,"#FUNC-verify Payment Methods List In Export Bills" + driver.getTitle() +" *  verify Payment Methods List PASS * " );
		            	Log.ReportEvent("PASS", " verify Payment Methods List In Export Bills is Successful");
		    	}}}
			catch (Exception e) {
				test.log(Status.FAIL,"verify Payment Methods List In Export Bills" + driver.getTitle() +" * verify Payment Methods List In Export Bills is unsuccessfull FAIL * " );
			}
					
		}	
		//Function Summary   : Method to verify Transfer Remark Field Not Appears
		public void verifyTransferRemarkFieldNotAppears(Map<Object,Object> testdatamap,Log Log) throws Exception {
			try {
				naviagteCreateInvoicePage();
				if(CheckElementExists(EdaatOR.Biller_AddInvoice_Header))
				{
				enterClientNameOrNationalID(testdatamap);
				Thread.sleep(100);
				selectTemplate(testdatamap);
				Thread.sleep(100);
				addProductDetails(testdatamap);
				Thread.sleep(400);
				}
				if(testdatamap.get("TemplateName").toString().equals("One Time"))
				{
					WebElement element1=driver.findElement(By.xpath(EdaatOR.Biller_Rece_CreateandExportButton));
					scrollToElement(driver, element1);
				}else {
					WebElement element=driver.findElement(By.xpath(EdaatOR.Biller_Invoice_installmentButton));
					scrollToElement(driver, element);
				}
				Thread.sleep(400);
				if(!CheckElementExists(EdaatOR.Biller_Rece_Transfer_Remark_TestArea))
				{
					Thread.sleep(400);
					Log.ReportEvent("PASS", "Verify the field will not appear when there is no sub-biller selected Functionality is successful");							
				}
				else {
					Log.ReportEvent("FAIL", "Verify the field will not appear when there is no sub-biller selected Functionality is Unsuccessful");	
					this.takeScreenShot();
					driver.quit();
					Assert.fail();
				}
			}
			catch(Exception e){
				Log.ReportEvent("FAIL", "Verify the field will not appear when there is no sub-biller selected Functionality is Unsuccessful");	
				this.takeScreenShot();
				driver.quit();
				Assert.fail();		}
		}
		        //Function Summary   : Method to Verify payment methods editable in invoice details page	
				public void verifyInvoiceDetailsPaymentMethodsEditable(Log Log) throws Exception {
					
					try {								
							WebClickUsingJS("("+EdaatOR.Biller_Invoice_BillNo+"/span)[2]");
							Thread.sleep(100);
							switchToWindow();
							Thread.sleep(100);
							uncheckPaymentMethods();
							Thread.sleep(100);
							this.takeScreenShot();
							Thread.sleep(100);
							uncheckPaymentMethods();
							Thread.sleep(100);
							this.takeScreenShot();
							Thread.sleep(100);
							test.log(Status.PASS,"#FUNC-Verify Payment Methods are Editable invoice details page" + driver.getTitle() +" * Payment methods editable PASS * " );				
							this.takeScreenShot();
							Log.ReportEvent("PASS", " Verify Payment Methods are Editable invoice details page is sucessfull");								
							
						
					}
					catch(Exception e){
						test.log(Status.FAIL,"#FUNC-Verify Transfer Remark in invoice details page" + driver.getTitle() +" * Trasfer Remark in invoice details page Fail * " );				
						this.takeScreenShot();
					}
				}
				
				//Function Summary  : Method to Verify payment methods editable in invoice details page			
				public void verifyExportedContractsInvoiceDetailsPaymentMethodsEditable(Log Log) throws Exception {
			
					try {								
						    WebClick(EdaatOR.Biller_ExportContact_InvID+"/span");
							Thread.sleep(100);
							switchToWindow();
							Thread.sleep(100);
							uncheckPaymentMethods();
							Thread.sleep(100);
							this.takeScreenShot();
							Thread.sleep(100);
							uncheckPaymentMethods();
							Thread.sleep(100);
							this.takeScreenShot();
							Thread.sleep(100);
							test.log(Status.PASS,"#FUNC-Verify Payment Methods are Editable invoice details page" + driver.getTitle() +" * Payment methods editable PASS * " );				
							takeScreenShot();
							Log.ReportEvent("PASS", " Verify Payment Methods are Editable invoice details page is sucessfull");								
							
						
					}
					catch(Exception e){
						test.log(Status.FAIL,"#FUNC-Verify Payment Methods are Editable invoice details page" + driver.getTitle() +" * Payment methods editable Fail * " );				
						this.takeScreenShot();
					}
				}
				
				
				//Function Summary   : Method to Verify Transfer Remark in invoice details page
				//Parameter Summary :  InvoiceType,Save,TransferRemarkMessage,BilStatus
				public void createSaveInvoiceDataWithTransferRemarkField(Map<Object,Object> testdatamap,Log Log) throws Exception {
					//
					try {
						String iType=testdatamap.get("InvoiceType").toString();
						if(iType.equalsIgnoreCase("Save")) {
							naviagteCreateInvoicePage();
							enterClientNameOrNationalID(testdatamap);
							Thread.sleep(100);
							selectTemplate(testdatamap);
							Thread.sleep(100);
							addProductDetails(testdatamap);
							Thread.sleep(400);
							verifyElementIsPresent(EdaatOR.Biller_ExportBills_PayedOutSideEdaatPaymentMethod);
							Thread.sleep(400);
							verifyElementIsPresent(EdaatOR.Biller_ExportBills_SadadPaymentMethod);			
							Thread.sleep(100);					
							EnterIssuedDate();
							Thread.sleep(100);
							WebEdit(EdaatOR.Biller_Rece_Transfer_Remark_TestArea,testdatamap.get("TransferRemarkMessage").toString());
							Thread.sleep(100);
							WebClick(EdaatOR.Biller_Rece_CreateandExportButton);					
							waitForPageToLoad();
							Thread.sleep(2000);
							WebElement element=driver.findElement(By.xpath(EdaatOR.Biller_ExportExcel));
							scrollToElement(driver, element);							
							takeScreenShot();
						    int val=1;
							ValidateTwoValue(getText(EdaatOR.Biller_Invoice_AfteraddInvoice+"["+val+"]/td[6]"), testdatamap.get("BilStatus").toString());
							Thread.sleep(100);	
							WebClickUsingJS("("+EdaatOR.Biller_Invoice_BillNo+"/span)[2]");
							Thread.sleep(100);
							switchToWindow();
							Thread.sleep(500);
							WebElement element1=driver.findElement(By.xpath(EdaatOR.Biller_Rece_SubBiller));
							scrollToElement(driver, element1);
							Thread.sleep(500);
							VerifyValue1(getText(EdaatOR.Biller_Rece_SubillerTransferNotes), testdatamap.get("TransferRemarkMessage").toString());
							Thread.sleep(100);
							test.log(Status.PASS,"#FUNC-Verify Transfer Remark in invoice details page" + driver.getTitle() +" * Trasfer Remark Field in invoice details page PASS * " );				
							takeScreenShot();
							Log.ReportEvent("PASS", " Verify Transfer Remark in invoice details page is sucessfull");								
										
						}

					}
					catch(Exception e){
						test.log(Status.FAIL,"#FUNC-Verify Transfer Remark in invoice details page" + driver.getTitle() +" * Trasfer Remark Field in invoice details page Fail * " );				
						this.takeScreenShot();
					}
				}
				//Function Summary  : Method to uncheck payment methods checkbox
				//Parameter Summary : N/A	
				public void uncheckPaymentMethods() throws InterruptedException
				{
					WebClick(EdaatOR.Biller_ExportBills_SadadPaymentMethod);
					Thread.sleep(400);
					WebClick(EdaatOR.Biller_ExportBills_MadaPaymentMethod);			
					Thread.sleep(100);
					WebClick(EdaatOR.Biller_ExportBills_VisaPaymentMethod);
					Thread.sleep(400);
					WebClick(EdaatOR.Biller_ExportBills_MasterCardPaymentMethod);			
					Thread.sleep(100);
					
				}
				
				 
				//Function Summary   : Method to verify Payment Methods Logo In Invoice Details Page
				public void verifyPaymentMethodsLogoInInvoiceDetailsPage(Log Log) throws Exception {
					//
					try {
						WebClickUsingJS("("+EdaatOR.Biller_Invoice_BillNo+"/span)[2]");
						Thread.sleep(100);
						switchToWindow();	
						Thread.sleep(100);						
						WebElement element=driver.findElement(By.xpath(EdaatOR.Biller_ExportBills_SadadLogo));
						scrollToElement(driver, element);
						Thread.sleep(100);
						verifyElementIsPresent(EdaatOR.Biller_ExportBills_SadadLogo);
						Thread.sleep(100);	
						verifyElementIsPresent(EdaatOR.Biller_ExportBills_MadaLogo);
						Thread.sleep(100);
						verifyElementIsPresent(EdaatOR.Biller_ExportBills_VisaLogo);
						Thread.sleep(100);
						verifyElementIsPresent(EdaatOR.Biller_ExportBills_MasterCardLogo);
						Thread.sleep(100);
						test.log(Status.PASS,"#FUNC-Method to verify Payment Methods Logo In Invoice Details Page" + driver.getTitle() +" * Method to verify Payment Methods Logo PASS * " );				
						takeScreenShot();
						Log.ReportEvent("PASS", " Method to verify Payment Methods Logo In Invoice Details Page is sucessfull");							
								
						}
					catch(Exception e){
						test.log(Status.FAIL,"#FUNC-Method to verify Payment Methods Logo In Invoice Details Page" + driver.getTitle() +" * Method to verify Payment Methods Logo Fail * " );				
						this.takeScreenShot();
					}
				}
}
