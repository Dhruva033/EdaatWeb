/**
 *
 * Test Script Name                   : N/A
 * Objective                          : Admin reports functionality.
 * Version                            : 1.0
 * Author                             : Kathirvelu M
 * Created Date                       : 23/05/2023
 * Last Updated on                    : N/A
 * Updated By                         : Radhika K R
 * Pre-Conditions                     : N/A
 * Epic Details                       : N/A
 * User Story Details                 : N/A
 **/
package com.azmqalabs.edaattestautomation.apppages.admin.pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.SwitchToFrame;
import org.openqa.selenium.remote.server.handler.SwitchToWindow;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.azmqalabs.edaattestautomation.apppages.GlobalConstant;
import com.azmqalabs.edaattestautomation.apppages.masterpages.BasePage;
import com.azmqalabs.edaattestautomation.common.Log;
import com.azmqalabs.edaattestautomation.common.uielement.fieldDecorator;
import com.azmqalabs.edaattestautomation.objectrepository.EdaatOR;
import com.azmqalabs.edaattestautomation.testscripts.admin.AdminTrackerMgmToggleStatus;



public class AdminReportsReceivablesReportsPage extends BasePage
{

	public AdminReportsReceivablesReportsPage(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;

		PageFactory.initElements(new fieldDecorator(driver,test), this);
	}  


	@FindBy(xpath = EdaatOR.Admin_Reports_superbiller)
	public WebElement Client;


	public boolean Exists(){
		return super.Exists(Client); 
	}
	//Function Summary   : Method to  Navigate to Receivables reports.
	//Parameter Summary  : N/A
	public void NavigateTOReceivablesReports(Log Log) throws InterruptedException {
		Thread.sleep(2000);
		WebClickUsingJS(EdaatOR.Admin_Reports);
		Thread.sleep(800);
		WebClickUsingJS(EdaatOR.Admin_Receivables_Reports);
		Thread.sleep(800);
		this.takeScreenShot();
    	Log.ReportEvent("PASS", " Verify Navigate to Receivables Reports is Sucessfull");

	}
	//Function Summary   : Method to  Verify Receivables Corporate Client reports.
	//Parameter Summary  : N/A
	public void VerifyCorporateClientReport(Log Log) throws Exception {
		try{
			WebClickUsingJS(EdaatOR.Admin_Receivables_Corpo_ClientReports);
			Thread.sleep(1000);
			switchToWindow();
			waitForPageToLoad();
			this.takeScreenShot();
			swithchToFrame(EdaatOR.Admin_Receivables_CorpoClientFrame);
			Thread.sleep(2000);
			verifyElementIsPresent(EdaatOR.Admin_Receivables_CorpoClientListTXT);
			Thread.sleep(2000);
			switchBacktoParentwindow();
			this.takeScreenShot();
			Thread.sleep(1000);
			test.log(Status.PASS,"Verify Corporate Client report" + driver.getTitle() +" * Verify Corporate Client report PASS * " );
        	Log.ReportEvent("PASS", "Verify Corporate Client Report is successful");

		}
		catch(Exception e){
			test.log(Status.FAIL,"Verify Corporate Client report FAIL" + driver.getTitle() +" * Verify Corporate Client report FAIL * " );
			this.takeScreenShot();
		}
	}

	//Function Summary  : Method to Enter FromDate 
	//Parameter Summary : FromYear,FromMonth,FromDate
	private void EnterFromdate(Map<Object, Object> testdatamap) throws InterruptedException
	{
		WebClick(EdaatOR.Admin_ReceivablesReports_ClientInvoice_Fromdate);
		selectDropdownValue_PartialText(EdaatOR.Admin_ReceivablesReports_ClientInvoice_Fromyear,testdatamap.get("FromYear").toString());
		selectDropdownValue_PartialText(EdaatOR.Admin_ReceivablesReports_ClientInvoice_FromMon,testdatamap.get("FromMonth").toString());
		WebClick("//a[text()='"+testdatamap.get("FromDate").toString()+"']");
		Thread.sleep(1000);
	}

	//Function Summary  : Method to Enter Todate 
	//Parameter Summary : ToYear,ToMonth,ToDate
	private void EnterTodate(Map<Object, Object> testdatamap) throws InterruptedException {
		WebClick(EdaatOR.Admin_ReceivablesReports_ClientInvoice_Todate);
		selectDropdownValue_PartialText(EdaatOR.Admin_ReceivablesReports_ClientInvoice_Toyear,testdatamap.get("ToYear").toString());
		selectDropdownValue_PartialText(EdaatOR.Admin_ReceivablesReports_ClientInvoice_Tomon,testdatamap.get("ToMonth").toString());
		WebClick("//a[text()='"+testdatamap.get("ToDate").toString()+"']");
		Thread.sleep(1000);
	}

	//Function Summary  : Method to verify Sub Biller report 
	//Parameter Summary : CRNumber,SubBillerName
	public void SubBillerReport(Map<Object, Object> testdatamap,Log Log) { 

		try{

			NavigateTOReceivablesReports(Log);
			WebClickUsingJS(EdaatOR.Admin_Receivables_SubBillerReportLink); 
			Thread.sleep(800);
			switchToWindow();
			WebEdit(EdaatOR.Admin_Receivables_SubBillerCRNumber, testdatamap.get("CRNumber").toString());
			Thread.sleep(800);	
			WebClickUsingJS(EdaatOR.Admin_Receivables_SubBillerGenerateReport);
			Thread.sleep(800);
			switchToWindow();
			swithchToFrame(EdaatOR.Admin_Receivables_Corporate_Report);
			verifyElementIsPresent("//div[contains(text(),'"+testdatamap.get("SubBillerName").toString()+"')]");
			this.takeScreenShot();
			switchBacktoParentwindow();
			test.log(Status.PASS,"Sub biller report " + driver.getTitle() +" * Sub biller report FAIL * " );
            Log.ReportEvent("PASS", " Verify Sub Biller Report is Successful");

		}

		catch(Exception e){
			test.log(Status.FAIL,"Sub biller report " + driver.getTitle() +" * Sub biller report  FAIL * " );
			this.takeScreenShot();
		}			
	}



	//Function Summary  : Navigate to  Receivable Reports
	//Parameter Summary : NA
	public void NavigateReceivableReports() {
		WebClickUsingJS(EdaatOR.Admin_Receivables_Reports);
	}

	//Function Summary  : Method to Verify Client Invoice Report Generate Functionality  
	//Parameter Summary : ClientType,ClientName,BillStatus,IdorCR,
	public void ReceivableReportsClientInvoice(Map<Object, Object> testdatamap,Log Log) { 
		try{
			NavigateReceivableReports();
			WebClickUsingJS(EdaatOR.Admin_ReceivablesReports_ClientInvoice_reportbtn);
			EnterFromdate(testdatamap);
			EnterTodate(testdatamap);
			selectDropdownValue_PartialText(EdaatOR.Admin_ReceivablesReports_ClientInvoice_ClientType,testdatamap.get("ClientType").toString());
			Thread.sleep(500);
			WebClick(EdaatOR.Admin_ClientNamearro);
			WebEdit(EdaatOR.Admin_ClientNametextbox, testdatamap.get("ClientName").toString());
			Thread.sleep(1000);
			WebClick(EdaatOR.Admin_ClientNameoption);
			Thread.sleep(1000);
			selectDropdownValue_PartialText(EdaatOR.Admin_ReceivablesReports_ClientInvoice_Billstatus,testdatamap.get("BillStatus").toString());
			Thread.sleep(500);
			WebEdit(EdaatOR.Admin_ReceivablesReports_ClientInvoice_ID_CR,testdatamap.get("IdorCR").toString());
			Thread.sleep(2000);
			WebClick(EdaatOR.Admin_ReceivablesReports_ClientInvoice_Generate);
			Thread.sleep(2000);
			switchTonextwindow();
			waitForPageToLoad();
			this.takeScreenShot();
			switchBacktoParentwindow();
			Thread.sleep(2000);
			WebClick(EdaatOR.Admin_ReceivablesReports_ClientInvoice_ExportExcel);
			scrollDowntillend(driver);
			verifyElementIsPresent(EdaatOR.Admin_ReceivablesReports_ClientInvoice_Exportverify);
			waitForPageToLoad();
			Thread.sleep(1000);
			test.log(Status.PASS,"Receivable Reports Client Invoice " + driver.getTitle() +" * Receivable Reports Client Invoice PASS * " );
			this.takeScreenShot();
        	Log.ReportEvent("PASS", "Verify Clients Invoices Report is Suceessful");

		}
		catch(Exception e){
			test.log(Status.FAIL,"Receivable Reports Client Invoice" + driver.getTitle() +" * Receivable Reports Client Invoice FAIL * " );
			this.takeScreenShot();
		}

	}


	//Function Summary   : Method to  Verify Receivables Over due bills.
	//Parameter Summary  :Client Type,Client Name,Sub Biller Name,Reportname.
	public void OverDueBills(Map<Object, Object> testdatamap,Log Log) throws InterruptedException {
		// TODO Auto-generated method stub
		try
		{
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Admin_Overduebills);
	        Thread.sleep(1000);
	        WebSelect(EdaatOR.Admin_Clienttypedrop,testdatamap.get("Client Type").toString());
			Thread.sleep(2000);
			selectClientname(testdatamap.get("Client Name").toString());		
			Thread.sleep(2000);
			selectSubiller(testdatamap.get("Sub Biller Name").toString());		
			Thread.sleep(2000);
			WebClick(EdaatOR.Admin_GenerateReportbtn);
			Thread.sleep(2000);
			waitForPageToLoad();
			switchToWindow();
			this.takeScreenShot();
			swithchToFrame(EdaatOR.Admin_Receframe);
			Thread.sleep(1000);
			verifyElementIsPresent(EdaatOR.Admin_ReportsOverDueBills);
			Thread.sleep(2000);
			switchBacktoParentwindow();
			test.log(Status.PASS,"Verify Overdue Bills Report " + driver.getTitle() +" * Verify Overdue Bills Report is PASS * " );
			this.takeScreenShot();
        	Log.ReportEvent("PASS", " Verify Super biller report is succesfull");

		}
		catch(Exception e) {
			test.log(Status.FAIL,"Verify Overdue Bills Report " + driver.getTitle() +" * Verify Overdue Bills Report is Fail * " );
			this.takeScreenShot();
		}
	}
	//Function Summary   : Method to select client name .
	//Parameter Summary  : N/A.
	public void selectClientname(String Cust) throws InterruptedException
	{
		WebClick(EdaatOR.Admin_ClientNamedrop);
		Thread.sleep(2000);
		WebClick(EdaatOR.Admin_ReceClientName+"["+Cust+"]");
	}
	//Function Summary   : Method to select Subbiller name .
	//Parameter Summary  : N/A.
	public void selectSubiller(String Cust) throws InterruptedException
	{
		WebClick(EdaatOR.Admin_Subbillerdrop);
		Thread.sleep(2000);
		WebClick(EdaatOR.Admin_ReceSubbillerName+"["+Cust+"]");
	}
	//Function Summary   : Method to select Subbiller name .
	//Parameter Summary  : N/A.
	public void selectSadedClientname(String Cust) throws InterruptedException
	{
		WebClick(EdaatOR.Admin_ReceviableClientName);
		Thread.sleep(2000);
		WebClick(EdaatOR.Admin_ReceviableClientNameclick+"["+Cust+"]");
	}
	//Function Summary   : Method to select product name .
	//Parameter Summary  : N/A.
	public void selectSadedproductname(String Custm) throws InterruptedException
	{
		WebClick(EdaatOR.Admin_Receviableproducts);
		Thread.sleep(3000);
		WebClickUsingActions(EdaatOR.Admin_Receviableproductsclick+"["+Custm+"]");
	}
	//Function Summary   : Method to  Verify Payment Transactions Report
	//Parameter Summary  : FromYear, FromMonth,ToYear,ToMonth.
	public void SelectDate(Map<Object,Object> testdatamap) throws InterruptedException
	{
		try {
			WebClick(EdaatOR.Admin_ReportsFromCalender);			
			selectDropdownValue_PartialText(EdaatOR.Admin_ReportsFromYear, testdatamap.get("FromYear").toString());
			selectDropdownValue_PartialText(EdaatOR.Admin_ReportsFromMonth, testdatamap.get("FromMonth").toString());
			WebClick("//a[text()='"+testdatamap.get("FromDate").toString()+"']");
			Thread.sleep(800);
			WebClick(EdaatOR.Admin_ReportsToCalender);
			selectDropdownValue_PartialText(EdaatOR.Admin_ReportsFromYear, testdatamap.get("ToYear").toString());
			selectDropdownValue_PartialText(EdaatOR.Admin_ReportsFromMonth, testdatamap.get("ToMonth").toString());
			WebClick("//a[text()='"+testdatamap.get("ToDate").toString()+"']");

		}		catch(Exception e){
			test.log(Status.FAIL,"Select Date FAIL" + driver.getTitle() +" *Select Date FAIL * " );
			this.takeScreenShot();
		}
	}
	//Function Summary   : Method to  Verify Receivables Corporate Client reports.
	//Parameter Summary  : N/A
	public void VerifySadedPaymentsReport(Map<Object, Object> testdatamap,Log Log) throws Exception {
		try{
			WebClickUsingJS(EdaatOR.Admin_ReceSadedPaymentRpt);
			Thread.sleep(2000);
			WebSelect(EdaatOR.Admin_ReceInvoiceType,testdatamap.get("Invoice Type").toString());
			Thread.sleep(2000);
			WebEdit(EdaatOR.Admin_ReceInvoiceNumber,testdatamap.get("InvoiceNumber").toString());
			Thread.sleep(2000);
			WebEdit(EdaatOR.Admin_ReceInviceinternalcode,testdatamap.get("InvoiceInternal Type").toString());
			Thread.sleep(2000);
			WebSelect(EdaatOR.Admin_ReceClienttype,testdatamap.get("Client Type").toString());
			Thread.sleep(2000);
			selectSadedClientname(testdatamap.get("Client Name").toString());
			Thread.sleep(2000);
			SelectDate(testdatamap);
			Thread.sleep(2000);
			selectSadedproductname(testdatamap.get("Product Name").toString());
			Thread.sleep(2000);
			WebClick(EdaatOR.Admin_ReceSabGenBtn);
			waitForPageToLoad();
			switchToWindow();
			this.takeScreenShot();
			swithchToFrame(EdaatOR.Admin_Receframe);
			Thread.sleep(1000);
			VerifyValue1(getText("//div[text()='"+testdatamap.get("SadedPayment").toString()+"']"), testdatamap.get("SadedPayment").toString());
			Thread.sleep(2000);
			switchBacktoParentwindow();
			test.log(Status.PASS,"Verify Saded Payment report" + driver.getTitle() +" * Verify Saded Payment report PASS * " );
        	Log.ReportEvent("PASS", " Verify Super biller report is succesfull");

		}
		catch(Exception e){
			test.log(Status.FAIL,"Verify Saded Payment report FAIL" + driver.getTitle() +" * Verify Saded Payment report FAIL * " );
			this.takeScreenShot();
		}
	}



	//Function Summary  : Method to Navigate to Client account statement.  
	//Parameter Summary : N/A
	public void navigatetoclientAccountStatement(Log Log) {
		try{
			WebClickUsingJS(EdaatOR.Biller_ReportMenu); 
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Biller_ReceivablesReportsbtn); 
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Biller_ReportClientaccountbtn); 
			Thread.sleep(1000);

			test.log(Status.PASS,"ClientAccountPage " + driver.getTitle() +" * ClientAccountReportPage PASS * " );
        	Log.ReportEvent("PASS", " Navigate to Client Account Statement page");

			this.takeScreenShot();
		}
		catch(Exception e){
			test.log(Status.FAIL,"ClientAccountPage" + driver.getTitle() +" * ClientAccountReportPage FAIL * " );
			this.takeScreenShot();
		}
	}
	//Function Summary  : Method to Select Client type
	//Parameter Summary : ClientType,Individual
	public void ClientType(Map<Object, Object> testdatamap) { 

		try{
			WebClick(EdaatOR.Admin_ClientType);
			String ele=testdatamap.get("ClientType").toString();
			if(ele.equalsIgnoreCase("Individual")) {
				selectDropdownValue_PartialText(EdaatOR.Admin_ClientTypeindvidutial,ele);
			}
			else {
				selectDropdownValue_PartialText(EdaatOR.Admin_ClientTypeCorporate,ele);
			}			

		}
		catch(Exception e){
			test.log(Status.FAIL,"Generate Report and export" + driver.getTitle() +" * Generate Report and export FAIL * " );
			this.takeScreenShot();
		}			
	}
	//Function Summary  : Method to Generate Client account Statement Report 
	//Parameter Summary : InvoiceContract,FromYear,FromMonth,ToYear,ToMonth,ToDate
	public void ClientAccountReports(Map<Object, Object> testdatamap,Log Log)
	{
		try{
			ClientType(testdatamap);
			Thread.sleep(2000);
			WebClick(EdaatOR.Admin_Client_name);
			Thread.sleep(1000);
			WebClickUsingActions(EdaatOR.Admin_Client_name_Option);
//			WebClickUsingActions("//li[text()='"+testdatamap.get("ClientName").toString()+"']");
			WebClick(EdaatOR.Admin_Reports_SubBiller_name);
			Thread.sleep(1000);
			WebClickUsingActions("//li[text()='"+testdatamap.get("SubbillerName").toString()+"']");
			Thread.sleep(1000);
			//		WebEdit(EdaatOR.Admin_Invoicecontract,testdatamap.get("InvoiceContract").toString());
			//		Thread.sleep(1000);
			WebClick(EdaatOR.Admin_ReportFromdate);
			Thread.sleep(1000);
			selectDropdownValue_PartialText(EdaatOR.Admin_reportFromYear,testdatamap.get("FromYear").toString());
			Thread.sleep(1000);
			selectDropdownValue_PartialText(EdaatOR.Admin_reportFromMonth,testdatamap.get("FromMonth").toString());
			Thread.sleep(1000);
			WebClick("//a[text()='"+testdatamap.get("FromDate").toString()+"']");
			Thread.sleep(1000);
			WebClick(EdaatOR.Admin_ReportTodate);
			Thread.sleep(1000);
			selectDropdownValue_PartialText(EdaatOR.Admin_reportToyear,testdatamap.get("ToYear").toString());
			Thread.sleep(1000);
			selectDropdownValue_PartialText(EdaatOR.Admin_reportToMonth,testdatamap.get("ToMonth").toString());
			Thread.sleep(1000);
			WebClick("//a[text()='"+testdatamap.get("ToDate").toString()+"']");	
			Thread.sleep(1000);
			this.takeScreenShot();
			WebClick(EdaatOR.Admin_reportsearchbutton);
			waitForPageToLoad();			       
			switchToWindow();
			this.takeScreenShot();
			swithchToFrame(EdaatOR.Admin_reportframe);
			verifyElementIsPresent(EdaatOR.Admin_report);
			Thread.sleep(1000);
			switchBacktoParentwindow();
			Thread.sleep(1000);
			test.log(Status.PASS,"Verify Client Account Statement" + driver.getTitle() +" * Client Account Statement PASS * " );
            Log.ReportEvent("PASS", " Verify Generate Client account statement is Successfull");

		}

		catch(Exception e){
			test.log(Status.FAIL,"Verify Client Account Statement" + driver.getTitle() +" * Generate Report and export FAIL * " );
			this.takeScreenShot();
		}			
	}

	//Function Summary  : Method to VerifyIndividualClientsReport
	//Parameter Summary : N/A
	public void VerifyIndividualClientsReport(Map<Object, Object> testdatamap,Log Log) throws Exception {
		try{
			Thread.sleep(1000);
			WebClick(EdaatOR.Admin_ReportsMenu);
			Thread.sleep(1000);
			WebClick(EdaatOR.Admin_Recevible_ReportMenu);
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Admin_individual_Report);
			waitForPageToLoad();			       
			switchToWindow();
			Thread.sleep(2000);
			swithchToFrame(EdaatOR.Admin_Recevible_Reportframe);
			Thread.sleep(2000);
			verifyElementIsPresent(EdaatOR.Admin_Recevible_Report_IndVerify);
			this.takeScreenShot();
			Thread.sleep(2000);
			switchBacktoParentwindow();
			test.log(Status.PASS,"Verify Individual Clients Report" + driver.getTitle() +" * Individual Clients Report PASS * " );		        	
        	Log.ReportEvent("PASS", " Verify IndividualClientReport is successfll");

		}catch(Exception e){
			test.log(Status.FAIL, "Verify Individual Clients Report" + driver.getTitle() + " * Individual Clients Report FAIL * ");
			this.takeScreenShot();
		}

	}

	//Function Summary  : method to verify Error messages in Client Account Statement Report page
	//Parameter Summary : ExpectedResult
	public void VerifyClientAccountStatementReportErrorMsg(Map<Object,Object>testdatamap,Log Log) throws InterruptedException{
		{
			try {
				NavigateTOReceivablesReports(Log);
				Thread.sleep(500);
				WebClickUsingJS(EdaatOR.Admin_ClientAccount_Report);
				Thread.sleep(500);
				WebClick(EdaatOR.Admin_Search_ReportBTn);
				this.takeScreenShot();
				if (ExistsCheck(EdaatOR.Admin_MandatoryErrorMsg)){	
					VerifyValue1(testdatamap.get("ExpectedResult").toString(), getText(EdaatOR.Admin_Report_FromDateErrMsg));
					Thread.sleep(500);
					VerifyValue1(testdatamap.get("ExpectedResult").toString(), getText(EdaatOR.Admin_Report_ClientIDErrMsg));
					Thread.sleep(500);
					VerifyValue1(testdatamap.get("ExpectedResult").toString(), getText(EdaatOR.Admin_Report_ClientTypeErrMsg));
					test.log(Status.PASS, "Client Account Statement report ErrorMessage Exists" + driver.getTitle() + " *Client Account Statement report  Error Message Exists * ");
				}
				else {
					test.log(Status.FAIL, "No error Exists" + driver.getTitle() + " * No error Exists * ");
				}

			} catch (Exception e) {
				throw new NoSuchElementException("Client Account Statement report "+ "Page - Not Loaded");
			}

		}
	}		 
}
