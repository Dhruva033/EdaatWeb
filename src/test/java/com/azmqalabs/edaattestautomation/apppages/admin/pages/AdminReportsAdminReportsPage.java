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
import com.azmqalabs.edaattestautomation.common.Log;
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
import com.azmqalabs.edaattestautomation.testscripts.admin.AdminTrackerMgmToggleStatus;



public class AdminReportsAdminReportsPage extends BasePage
{

	public AdminReportsAdminReportsPage(WebDriver driver,ExtentTest test)
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

	//Function Summary   : Method to  Navigate to Admin reports.
	//Parameter Summary  : N/A
	public void NavigateTOAdminReports(Log Log) throws InterruptedException {
		Thread.sleep(3000);
		WebClickUsingJS(EdaatOR.Admin_Reports);
		Thread.sleep(800);
		WebClickUsingJS(EdaatOR.Admin_ReportsAdmin);
    	Log.ReportEvent("PASS", " Verify naviagted Suceessfull to Admin Reports Page");
		
	}
	//Function Summary   : Method to  Verify SuperBiller Report
	//Parameter Summary  : BillerName, TrackedBillerName
	public void VerifySuperBillerReport(Map<Object,Object> testdatamap,Log Log) throws Exception {
		try {
			Thread.sleep(3000);
			boolean existsElement;
			WebClickUsingJS(EdaatOR.Admin_ReportsSuperbiller);
			Thread.sleep(1000);
			selectDropdownValue_PartialText(EdaatOR.Admin_BillerNameDropdwn, testdatamap.get("BillerName").toString());
			Thread.sleep(1000);
			WebClick(EdaatOR.Admin_TrackedBillerDropdwn);
			Thread.sleep(1000);
			WebClick("//li[text()='"+testdatamap.get("TrackedBillerName").toString()+"']");
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Admin_GenerateReportBtn);
			switchToWindow();
			swithchToFrame(EdaatOR.Admin_Corporate_Report);
			Thread.sleep(3000);
			verifyElementIsPresent(EdaatOR.Admin_SuperBillerReport);
			this.takeScreenShot();
			switchBacktoParentwindow();
			takeScreenShot();
			test.log(Status.PASS,"Verify super biller report" + driver.getTitle() +" * Sub biller report PASS * " );
        	Log.ReportEvent("PASS", " Verify Super biller report is succesfull");

		}
		catch(Exception e){
			test.log(Status.FAIL,"Sub biller report FAIL" + driver.getTitle() +" * Sub biller report FAIL * " );
			this.takeScreenShot();
		}
	}
	//Function Summary   : Method to  Verify Outside Edaat Payment Report
	//Parameter Summary  : FromYear, FromMonth,FromDate,ToYear,ToMonth,ToDate,BillerName,
	public void VerifyOutsideEdaatPaymentReports(Map<Object,Object> testdatamap,Log Log) throws Exception {
		try {
			Thread.sleep(2000);
			boolean existsElement;
			WebClickUsingJS(EdaatOR.Admin_ReportsOutsidePaid);
			Thread.sleep(1000);
			WebClick(EdaatOR.Admin_ReportsFromCalender);
			selectDropdownValue_PartialText(EdaatOR.Admin_ReportsFromYear, testdatamap.get("FromYear").toString());
			selectDropdownValue_PartialText(EdaatOR.Admin_ReportsFromMonth, testdatamap.get("FromMonth").toString());
			WebClick("//a[text()='"+testdatamap.get("FromDate").toString()+"']");
			Thread.sleep(800);
			WebClick(EdaatOR.Admin_ReportsToCalender);
			selectDropdownValue_PartialText(EdaatOR.Admin_ReportsFromYear, testdatamap.get("ToYear").toString());
			selectDropdownValue_PartialText(EdaatOR.Admin_ReportsFromMonth, testdatamap.get("ToMonth").toString());
			WebClick("//a[text()='"+testdatamap.get("ToDate").toString()+"']");
			Thread.sleep(800);
			selectDropdownValue_PartialText(EdaatOR.Admin_ReportBillerName, testdatamap.get("BillerName").toString());
			Thread.sleep(800);
			WebClick(EdaatOR.Admin_GenerateReport);
			switchToWindow();
			swithchToFrame(EdaatOR.Admin_Corporate_Report);
			Thread.sleep(3000);
			verifyElementIsPresent(EdaatOR.Admin_Reports_PaymntTransaction_report);
			this.takeScreenShot();
			switchBacktoParentwindow();
			takeScreenShot();
			test.log(Status.PASS,"Verify Outside edaat payments report" + driver.getTitle() +" * Outside edaat payments report PASS * " );
        	Log.ReportEvent("PASS", " Verify Outside paid edaat paymnets report is Suceessfull");

		}
		catch(Exception e){
			test.log(Status.FAIL,"Outside edaat payments report FAIL" + driver.getTitle() +" *Outside edaat payments report FAIL * " );
			this.takeScreenShot();
		}
	}

	//Function Summary   : Method to  Verify Biller Transaction Report
	//Parameter Summary  : FromYear, FromMonth,ToYear,ToMonth,MainBiller,BillStatus,
	public void VerifyBillerTransactionReport(Map<Object,Object> testdatamap,Log Log) throws Exception {
		try {
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Admin_BillerTransaction);
			Thread.sleep(1000);
			selectDropdownValue_PartialText(EdaatOR.Admin_FromMonth, testdatamap.get("FromMonth").toString());
			selectDropdownValue_PartialText(EdaatOR.Admin_FromYear, testdatamap.get("FromYear").toString());
			WebClick(EdaatOR.Admin_ToMonth);
			WebSelect1(EdaatOR.Admin_ToMonth, testdatamap.get("ToMonth").toString());
			WebClick(EdaatOR.Admin_ToYear);
			WebSelect1(EdaatOR.Admin_ToYear, testdatamap.get("ToYear").toString());
			WebClick(EdaatOR.Admin_MainBiller);
			WebClick("//li[text()='"+testdatamap.get("MainBiller").toString()+"']");
			WebClick("//label[text()='"+testdatamap.get("BillStatus").toString()+"']");
			Thread.sleep(800);
			WebClick(EdaatOR.Admin_ReportPaymentMethod);
			WebClick("//li[text()='"+testdatamap.get("PaymentMethod").toString()+"']");
			WebClick(EdaatOR.Admin_Generatereport);
//			switchToWindow();
//			swithchToFrame(EdaatOR.Admin_Corporate_Report);
//			Thread.sleep(800);
//			WebEdit(EdaatOR.Admin_Report_PaymentID, testdatamap.get("PaymentID").toString());
//			Thread.sleep(800);
//			WebClick(EdaatOR.Admin_Report_VerifyPID);
			Thread.sleep(3000);
			waitForPageToLoad();
			switchToWindow();
			swithchToFrame(EdaatOR.Admin_Corporate_Report);
			Thread.sleep(2000);
			verifyElementIsPresent(EdaatOR.Admin_ReportVerify);
			this.takeScreenShot();
			switchBacktoParentwindow();
			takeScreenShot();
			test.log(Status.PASS,"Verify Biller Transaction Report" + driver.getTitle() +" * Biller Transaction Report PASS * " );
        	Log.ReportEvent("PASS", " Verify Billers Transactions Report");

		}
		catch(Exception e){
			test.log(Status.FAIL,"Biller Transaction Report FAIL" + driver.getTitle() +" *Biller Transaction Report FAIL * " );
			this.takeScreenShot();
		}
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

	//Function Summary  : Method to SelectDate
	//Parameter Summary : FromYear,FromMonth,FromDate,ToYear,ToMonth,ToDate
	public void SelectDate1(Map<Object,Object>testdatamap)
	{
		try {
			WebClick(EdaatOR.Admin_Reorts_monitor_Fromd);
			selectDropdownValue_PartialText(EdaatOR.Admin_Reorts_monitor_Fromyear,testdatamap.get("FromYear").toString());
			selectDropdownValue_PartialText(EdaatOR.Admin_Reorts_monitor_Fromon,testdatamap.get("FromMonth").toString());
			WebClick("//a[text()='"+testdatamap.get("FromDate").toString()+"']");
			WebClick(EdaatOR.Admin_Reorts_monitor_Tod);
			selectDropdownValue_PartialText(EdaatOR.Admin_Reorts_monitor_Toyear,testdatamap.get("ToYear").toString());
			selectDropdownValue_PartialText(EdaatOR.Admin_Reorts_monitor_omon,testdatamap.get("ToMonth").toString());
			WebClick("//a[text()='"+testdatamap.get("ToDate").toString()+"']");
		}
		catch (Exception e) {
			e.printStackTrace();
			this.takeScreenShot();
		}

	}
	//Function Summary  : Method to EnterSearchitem
	//Parameter Summary : MainBiller
	public void EnterSearchitem(Map<Object, Object> testdatamap) throws InterruptedException {

		WebClick(EdaatOR.Admin_Reorts_monitor_BillerName);
		Thread.sleep(1000);
		WebClickUsingActions("//li[text()='"+testdatamap.get("MainBiller").toString()+"']");
		Thread.sleep(1000);
		WebClick(EdaatOR.Admin_Reorts_monitor_srcbtn);
	}
	//Function Summary  : Method to Verify Corporate Clients Reports
	//Parameter Summary : BillerName
	public void VerifyCorporateClientsReport(Map<Object,Object> testdatamap,Log Log) throws Exception {
		try {
			Thread.sleep(2000);
			NavigateTOAdminReports(Log);
			WebClickUsingJS(EdaatOR.Admin_CorporateClientReportBTN);
			Thread.sleep(1000);
			WebClick(EdaatOR.Admin_CorporateClientBillerNameDropDown);
			WebClick("//li[text()='"+testdatamap.get("BillerName").toString()+"']");
			WebClick(EdaatOR.Admin_CorporateClientGenerateReportBTN);
			switchToWindow();
			swithchToFrame(EdaatOR.Admin_Corporate_Report);
			Thread.sleep(3000);
			verifyElementIsPresent(EdaatOR.Admin_CorporateClientReport);
			this.takeScreenShot();
			switchBacktoParentwindow();
			test.log(Status.PASS,"VerifyCorporateClientsReport is Pass" + driver.getTitle() +" *VerifyCorporateClientsReport FAIL * " );
        	Log.ReportEvent("PASS", " Verify Corporate Client Report is Suceessful");
		}
		catch(Exception e){
			test.log(Status.FAIL,"VerifyCorporateClientsReport is FAIL" + driver.getTitle() +" *VerifyCorporateClientsReport * " );
			this.takeScreenShot();
		}
	}

	//Function Summary  : Method to EnterSearchitem
	//Parameter Summary : MainBiller
	public void VerifyBillerMonitoringReport(Map<Object, Object> testdatamap,Log Log)
	{
		try {
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Admin_BillerMonitoring);
			Thread.sleep(1000);
			SelectDate1(testdatamap);
			WebClick(EdaatOR.Admin_ReportPaymentMethod);
			WebClick("//li[text()='"+testdatamap.get("PaymentMethod").toString()+"']");
			EnterSearchitem(testdatamap);
//			Thread.sleep(800);
//			switchToWindow();
//			swithchToFrame(EdaatOR.Admin_Corporate_Report);
//			Thread.sleep(800);
//			WebEdit(EdaatOR.Admin_Report_PaymentID, testdatamap.get("PaymentID").toString());
//			Thread.sleep(800);
//			WebClick(EdaatOR.Admin_Report_VerifyPID);
			Thread.sleep(3000);
			waitForPageToLoad();
			switchToWindow();
			swithchToFrame(EdaatOR.Admin_Corporate_Report);
			Thread.sleep(2000);
			verifyElementIsPresent(EdaatOR.Admin_Report_VerifyBillerMonitoringReport);
			this.takeScreenShot();
			switchBacktoParentwindow();
			test.log(Status.PASS,"Verify Biller Monitoring Report" + driver.getTitle() +" * Biller Monitoring Report PASS * " );
        	Log.ReportEvent("PASS", " Verify Biller Monitoring Report is successful");

		}
		catch (Exception e) {

			test.log(Status.FAIL,"Verify Biller Monitoring Report" + driver.getTitle() +" * Biller Monitoring Report FAIL * " );
		}

	}

	//Function Summary   : Method to  Verify Sub Billers Report
	//Parameter Summary  : BillerName,CRNumber
	public void VerifySubBillersReport(Map<Object, Object> testdatamap,Log Log) {
		try {
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Admin_Reports_SubbillerReportMenu);
			Thread.sleep(1000);
			selectDropdownValue_PartialText(EdaatOR.Admin_SubbillerReport_BillerNameDropdwn, testdatamap.get("BillerName").toString());
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_SubbillerReport_CRNumberfield, testdatamap.get("CRNumber").toString());
			WebClickUsingJS(EdaatOR.Admin_SubbillerReport_GenerateReportBtn);
			switchToWindow();
			swithchToFrame(EdaatOR.Admin_Corporate_Report);
			Thread.sleep(3000);
			verifyElementIsPresent(EdaatOR.Admin_SubbillerReportverify);
			this.takeScreenShot();
			switchBacktoParentwindow();
			takeScreenShot();
			test.log(Status.PASS,"Verify Sub biller report" + driver.getTitle() +" * Sub biller report PASS * " );
        	Log.ReportEvent("PASS", " Verify Sub billers report is succesfull");

		}
		catch(Exception e){
			test.log(Status.FAIL,"Sub biller report FAIL" + driver.getTitle() +" * Sub biller report FAIL * " );
			this.takeScreenShot();
		}
	}
	//Function Summary   : Method to  Verify ClientType Reports
	//Parameter Summary  : FromMonth,FromYear,ToMonth,ToYear,ClientType,MainBiller,BillStatus
	public void VerifyClientsTypersReport(Map<Object, Object> testdatamap,Log Log) throws InterruptedException {
		try {
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Admin_Reports_ClientsTypeReportMenu);
			Thread.sleep(1000);
			selectDropdownValue_PartialText(EdaatOR.Admin_FromMonth, testdatamap.get("FromMonth").toString());
			selectDropdownValue_PartialText(EdaatOR.Admin_FromYear, testdatamap.get("FromYear").toString());
			WebClick(EdaatOR.Admin_ToMonth);
			WebSelect1(EdaatOR.Admin_ToMonth, testdatamap.get("ToMonth").toString());
			WebClick(EdaatOR.Admin_ToYear);
			WebSelect1(EdaatOR.Admin_ToYear, testdatamap.get("ToYear").toString());
			WebClick(EdaatOR.Admin_clientType);
			WebSelect1(EdaatOR.Admin_clientType, testdatamap.get("ClientType").toString());
			WebSelect1(EdaatOR.ClientsPayablesBillerNameDropdown,testdatamap.get("MainBiller").toString());
			Thread.sleep(800);
			WebClick("//label[text()='"+testdatamap.get("BillStatus").toString()+"']");
			Thread.sleep(800);
			WebClick(EdaatOR.Admin_ReportClientTypePaymentMethod);
			WebClick("//option[text()='"+testdatamap.get("PaymentMethod").toString()+"']");
			Thread.sleep(800);
			WebClick(EdaatOR.Admin_Generatereport);
//			switchToWindow();
//			swithchToFrame(EdaatOR.Admin_Corporate_Report);
//			Thread.sleep(800);
//			WebEdit(EdaatOR.Admin_Report_PaymentID, testdatamap.get("PaymentID").toString());
//			Thread.sleep(800);
//			WebClick(EdaatOR.Admin_Report_VerifyPID);
			waitForPageToLoad();
			Thread.sleep(3000);
			switchToWindow();
			swithchToFrame(EdaatOR.Admin_Corporate_Report);
			Thread.sleep(2000);
			verifyElementIsPresent(EdaatOR.Admin_ClientTypeReporttext);
			this.takeScreenShot();
			switchBacktoParentwindow();
			test.log(Status.PASS,"Verify Clients Type Report" + driver.getTitle() +" * Clients Type Report is Pass * " );
        	Log.ReportEvent("PASS", " Verify ClientsType Report is succesfull");

		}
		catch(Exception e){
			test.log(Status.FAIL,"Verify Clients Type Report" + driver.getTitle() +" *Clients Type Report is Fail* " );
			this.takeScreenShot();
		}
	}

	//Function Summary   : Method to  Verify Payment Transactions Report
	//Parameter Summary  :MainBiller.
	public void VerifyPaymentTransactionsReport(Map<Object,Object> testdatamap,Log Log) throws InterruptedException
	{
		try {
			Thread.sleep(2000);
			NavigateTOAdminReports(Log);
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Admin_Reports_PaymntTransactionlink);
			SelectDate(testdatamap);
			Thread.sleep(2000);
			WebClick(EdaatOR.Admin_Reports_PaymntTransaction_MainBlr);
			WebClick("//li[text()='"+testdatamap.get("Main Biller").toString()+"']");
			WebClick(EdaatOR.Admin_ReportPaymentMethod);
			WebClick("//li[text()='"+testdatamap.get("PaymentMethod").toString()+"']");
			WebClickUsingJS(EdaatOR.Admin_Reports_PaymntTransaction_generate);
//			switchToWindow();
//			swithchToFrame(EdaatOR.Admin_Corporate_Report);
//			Thread.sleep(800);
//			WebEdit(EdaatOR.Admin_Report_PaymentID, testdatamap.get("PaymentID").toString());
//			Thread.sleep(800);
//			WebClick(EdaatOR.Admin_Report_VerifyPID);
			waitForPageToLoad();
			Thread.sleep(3000);
			switchToWindow();
			swithchToFrame(EdaatOR.Admin_Corporate_Report);
			Thread.sleep(2000);
			verifyElementIsPresent(EdaatOR.Admin_Reports_PaymntTransactionReport);
			this.takeScreenShot();
			switchBacktoParentwindow();
			test.log(Status.PASS,"Verify Payment Transactions Report PASS" + driver.getTitle() +" *Verify PaymentTransactions Report is pass * " );
			Log.ReportEvent("PASS", "Verify Payment Transactions & Operation Fees Report is Suceessful");

		}
		catch(Exception e){
			test.log(Status.FAIL,"Verify Payment Transactions Report FAIL" + driver.getTitle() +" *Verify PaymentTransactions Report FAIL * " );
			this.takeScreenShot();

		}	
	}
	//Function Summary   : Method to  Verify Blocked Corporate Client Report
	//Parameter Summary  :NA
	public void VerifyBlockedCorporateClientReport(Log Log) throws InterruptedException
	{
		try {
			Thread.sleep(2000);
			NavigateTOAdminReports(Log);
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Admin_Reports_Blockedcorporatelnk);
			switchToWindow();
			swithchToFrame(EdaatOR.Admin_Corporate_Report);
			Thread.sleep(3000);
			verifyElementIsPresent(EdaatOR.Admin_Reports_BlockedcorporateVerify);
			this.takeScreenShot();
			switchBacktoParentwindow();
			test.log(Status.PASS,"Verify Blocked Corporate Client Report Pass" + driver.getTitle() +" *Verify Blocked Corporate Client Report Pass * " );
			Log.ReportEvent("PASS", "Verify  Blocked Corporate Clients Report is Suceessful");

		}
		catch(Exception e){
			test.log(Status.FAIL,"Verify Blocked Corporate Client Report FAIL" + driver.getTitle() +" *Verify Blocked Corporate Client Report FAIL * " );
			this.takeScreenShot();	  
		}
	}

	//Function Summary  : Method to VerifyBlockedIndividualClientReport
	//Parameter Summary : N/A
	public void VerifyBlockedIndividualClientReport(Map<Object, Object> testdatamap,Log Log) {

		try
		{Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Admin_Rport_Blocked_IndivReport);
			Thread.sleep(1000);
			switchTonextwindow();
			Thread.sleep(1000);
			swithchToFrame(EdaatOR.Admin_Rport_Blocked_IndivReportframe);
			Thread.sleep(3000);
			verifyElementIsPresent(EdaatOR.Admin_Rport_Blocked_IndivReportverify);
			this.takeScreenShot();
			switchBacktoParentwindow();
			Thread.sleep(1000);
	
			test.log(Status.PASS,"Verify Blocked Individual Clients Report" + driver.getTitle() +" * Blocked Individual Clients Report PASS * " );
        	Log.ReportEvent("PASS", " Verify Blocked Individual Clients Report functionality is successful");

		}
		catch (Exception e) {

			test.log(Status.FAIL,"Verify Blocked Individual Clients Report" + driver.getTitle() +" * Blocked Individual Clients Report FAIL * " );
		}
	}

	//Function Summary  : Method to VerifyIndividualClientReport
	//Parameter Summary : MainBiller,NationalityName
	public void VerifyIndividualClientReport(Map<Object, Object> testdatamap) {

		try
		{Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Admin_IndivReport);
			Thread.sleep(1000);
			WebClick(EdaatOR.Admin_Reorts_Indiv_BillerName);
			Thread.sleep(1000);
			WebClick("//li[text()='"+testdatamap.get("MainBiller").toString()+"']");
			Thread.sleep(1000);
			selectDropdownValue_PartialText(EdaatOR.Admin_Reorts_Indiv_NationalityName,testdatamap.get("NationalityName").toString());
			Thread.sleep(1000);
			WebClick(EdaatOR.Admin_Reorts_Indiv_srcbtn);
			switchToWindow();
			swithchToFrame(EdaatOR.Admin_Corporate_Report);
			Thread.sleep(3000);
			verifyElementIsPresent(EdaatOR.Admin_Reorts_monitor_verify);
			this.takeScreenShot();
			switchBacktoParentwindow();
			test.log(Status.PASS,"Verify  Individual Clients Report" + driver.getTitle() +" *  Individual Clients Report PASS * " );

		}
		catch (Exception e) {

			test.log(Status.FAIL,"Verify Blocked Individual Clients Report" + driver.getTitle() +" * Blocked Individual Clients Report FAIL * " );
		}
	}
	//Function Summary   : Method to generate Individual Client Report.
	//Parameter Summary  : BillerName, NationalityName.
	public void IndividualClientReport(Map<Object, Object> testdatamap,Log Log) {
		// TODO Auto-generated method stub
		try {	
			Thread.sleep(3000);
			WebClickUsingJS(EdaatOR.Admin_IndivClientReport);
			Thread.sleep(1000);
			WebClick(EdaatOR.Admin_ClickBillerName);	
			WebClick("//ul/li[text()='"+testdatamap.get("BillerName").toString()+"']");
			Thread.sleep(1000);
			WebClick(EdaatOR.Admin_ClickNationalityName);
			Thread.sleep(1000);
			WebClick("//option[text()='"+testdatamap.get("NationalityName").toString()+"']");
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Admin_GenerateReportBtn);
			switchToWindow();
			swithchToFrame(EdaatOR.Admin_Corporate_Report);
			Thread.sleep(3000);
			verifyElementIsPresent(EdaatOR.Admin_IndClientReport);
			this.takeScreenShot();
			switchBacktoParentwindow();
			Thread.sleep(1000);
			test.log(Status.PASS,"Verify Individual client report PASS" + driver.getTitle() +" * Verify Individual client report PASS * " );
        	Log.ReportEvent("PASS", " Verify Super biller report is succesfull");

		}
		catch(Exception e){
			test.log(Status.FAIL,"Verify Individual client report FAIL" + driver.getTitle() +" * Verify Individual client report FAIL * " );
			this.takeScreenShot();
		}
	}
	//Function Summary   : Method to generate Ticket Size report under Admin Reports.
	//Parameter Summary  : FromYear, FromMonth,ToYear,ToMonth,MainBiller,BillStatus,Ticket Size.
	public void TicketSizeReport(Map<Object, Object> testdatamap,Log Log) {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Admin_Ticketsize);
			Thread.sleep(1000);			
			selectDropdownValue_PartialText(EdaatOR.Admin_FromMonth, testdatamap.get("FromMonth").toString());
			selectDropdownValue_PartialText(EdaatOR.Admin_FromYear, testdatamap.get("FromYear").toString());
			WebClick(EdaatOR.Admin_ToMonth);
			WebSelect1(EdaatOR.Admin_ToMonth, testdatamap.get("ToMonth").toString());
			WebClick(EdaatOR.Admin_ToYear);
			WebSelect1(EdaatOR.Admin_ToYear, testdatamap.get("ToYear").toString());
			WebClick(EdaatOR.Admin_ClickTicketsize);
			WebClick("//option[text()='"+ testdatamap.get("Ticket Size").toString()+"']");
			WebClick(EdaatOR.Client_ClientAccountStatement_BillerName);
			WebClick("//option[text()='"+testdatamap.get("MainBiller").toString()+"']");
			WebClick("//label[text()='"+testdatamap.get("BillStatus").toString()+"']");
			Thread.sleep(2000);
			WebClick(EdaatOR.Admin_ReportClientTypePaymentMethod);
			WebClick("//option[text()='"+testdatamap.get("PaymentMethod").toString()+"']");
			Thread.sleep(1000);
			WebClick(EdaatOR.Admin_Generatereport);
//			switchToWindow();
//			swithchToFrame(EdaatOR.Admin_Corporate_Report);
//			Thread.sleep(800);
//			WebEdit(EdaatOR.Admin_Report_PaymentID, testdatamap.get("PaymentID").toString());
//			Thread.sleep(800);
//			WebClick(EdaatOR.Admin_Report_VerifyPID);
			waitForPageToLoad();
			Thread.sleep(2000);
			switchToWindow();
			swithchToFrame(EdaatOR.Admin_Corporate_Report);
			Thread.sleep(3000);
			verifyElementIsPresent(EdaatOR.Admin_TicketReportVerify);
			this.takeScreenShot();
			switchBacktoParentwindow();
			Thread.sleep(1000);
			test.log(Status.PASS,"Verify Ticket Size Report" + driver.getTitle() +" * Ticket Size Report PASS * " );
        	Log.ReportEvent("PASS", " Verify Super biller report is succesfull");

		}
		catch(Exception e){
			test.log(Status.FAIL,"Ticket Size Report FAIL" + driver.getTitle() +" *Ticket Size Report FAIL * " );
			this.takeScreenShot();
		}
	}

	//Function Summary  : Method to VerifyIndividualClientReport
	//Parameter Summary : N/A
	public void VerifyCorporateBilllersReport(Log Log) throws InterruptedException {
		try {
			Thread.sleep(2000);
			WebClick(EdaatOR.Admin_Corporate_Billers_Report);
			switchToWindow();
			swithchToFrame(EdaatOR.Admin_Corporate_Report);
			Thread.sleep(3000);
			verifyElementIsPresent(EdaatOR.Admin_Corporate_verifyReport);
			this.takeScreenShot();
			switchBacktoParentwindow();
			Thread.sleep(1000);
			test.log(Status.PASS,"Verify Corporate Billers Report" + driver.getTitle() +" * Corporate Billers Report PASS * " );
        	Log.ReportEvent("PASS", " Verify Corporate Billers Report is successful");

		}
		catch (Exception e) {

			test.log(Status.FAIL,"Verify Corporate Billers Report" + driver.getTitle() +" * Corporate Billers Report FAIL * " );

		}		
	}	

	//Function Summary  : method to verify Error messages in Sub Biller Report page
	//Parameter Summary : ExpectedResult
	public void VerifySubBillesrReportErrorMsg(Map<Object,Object>testdatamap,Log Log) throws InterruptedException{
		{
			try {
				NavigateTOAdminReports(Log);
				Thread.sleep(500);
				WebClick(EdaatOR.Admin_SubBiller_Report);
				Thread.sleep(500);
				WebClick(EdaatOR.Admin_Generate_ReportBTn);
				this.takeScreenShot();
				if (ExistsCheck(EdaatOR.Admin_MandatoryErrorMsg)){	

					VerifyValue1(testdatamap.get("ExpectedResult").toString(), getText(EdaatOR.Admin_MandatoryFeild_ReportErrMsg));
					test.log(Status.PASS, "Sub biller report ErrorMessage Exists" + driver.getTitle() + " *Sub biller report  Error Message Exists * ");
				}
				else {
					test.log(Status.FAIL, "No error Exists" + driver.getTitle() + " * No error Exists * ");
				}

			} catch (Exception e) {
				throw new NoSuchElementException("Sub biller report "+ "Page - Not Loaded");
			}

		}
	}


	//Function Summary  : method to verify Error messages in Individual client Report page
	//Parameter Summary : ExpectedResult
	public void VerifyIndividualClientReportErrorMsg(Map<Object,Object>testdatamap,Log Log) throws InterruptedException{
		{
			try {
				NavigateTOAdminReports(Log);
				Thread.sleep(500);
				WebClickUsingJS(EdaatOR.Admin_IndividualClient_Report);
				Thread.sleep(500);
				WebClick(EdaatOR.Admin_Generate_ReportBTn);
				this.takeScreenShot();
				if (ExistsCheck(EdaatOR.Admin_MandatoryErrorMsg)){	

					VerifyValue1(testdatamap.get("ExpectedResult").toString(), getText(EdaatOR.Admin_MandatoryFeild_ReportErrMsg));
					test.log(Status.PASS, "Individual Client report ErrorMessage Exists" + driver.getTitle() + " *Individual Client report  Error Message Exists * ");
				}
				else {
					test.log(Status.FAIL, "No error Exists" + driver.getTitle() + " * No error Exists * ");
				}

			} catch (Exception e) {
				throw new NoSuchElementException("Individual Client report "+ "Page - Not Loaded");
			}

		}
	}
	//Function Summary  : method to verify Error messages in Corporate client Report page
	//Parameter Summary : ExpectedResult
	public void VerifyCorporateClientReportErrorMsg(Map<Object,Object>testdatamap,Log Log) throws InterruptedException{
		{
			try {
				NavigateTOAdminReports(Log);
				Thread.sleep(500);
				WebClickUsingJS(EdaatOR.Admin_CorporateClient_Report);
				Thread.sleep(500);
				WebClick(EdaatOR.Admin_Generate_ReportBTn);
				this.takeScreenShot();
				if (ExistsCheck(EdaatOR.Admin_MandatoryErrorMsg)){	

					VerifyValue1(testdatamap.get("ExpectedResult").toString(), getText(EdaatOR.Admin_MandatoryFeild_ReportErrMsg));
					test.log(Status.PASS, "Corporate Client report ErrorMessage Exists" + driver.getTitle() + " *Corporate Client report  Error Message Exists * ");
				}
				else {
					test.log(Status.FAIL, "No error Exists" + driver.getTitle() + " * No error Exists * ");
				}

			} catch (Exception e) {
				throw new NoSuchElementException("Corporate Client report "+ "Page - Not Loaded");
			}

		}
	}

	//Function Summary  : method to verify Error messages in Outside Edaat Payments Report page
	//Parameter Summary : ExpectedResult
	public void VerifyOutsideEdaatPaymentsReportErrorMsg(Map<Object,Object>testdatamap,Log Log) throws InterruptedException{
		{
			try {
				NavigateTOAdminReports(Log);
				Thread.sleep(500);
				WebClickUsingJS(EdaatOR.Admin_OutsideEdaatPayment_Report);
				Thread.sleep(500);
				WebClick(EdaatOR.Admin_Generate_ReportBTn);
				this.takeScreenShot();
				if (ExistsCheck(EdaatOR.Admin_MandatoryErrorMsg)){	

					VerifyValue1(testdatamap.get("ExpectedResult").toString(), getText(EdaatOR.Admin_MandatoryFeild_ReportErrMsg));
					test.log(Status.PASS, "Outside Edaat Payments report ErrorMessage Exists" + driver.getTitle() + " *Outside Edaat Payments report  Error Message Exists * ");
				}
				else {
					test.log(Status.FAIL, "No error Exists" + driver.getTitle() + " * No error Exists * ");
				}

			} catch (Exception e) {
				throw new NoSuchElementException("Outside Edaat Payments report "+ "Page - Not Loaded");
			}

		}
	}

	//Function Summary  : method to verify Error messages in Biller Transaction Report page
	//Parameter Summary : ExpectedResult
	public void VerifyBillerTransactionReportErrorMsg(Map<Object,Object>testdatamap,Log Log) throws InterruptedException{
		{
			try {
				NavigateTOAdminReports(Log);
				Thread.sleep(500);
				WebClickUsingJS(EdaatOR.Admin_BillerTransaction_Report);
				Thread.sleep(500);
				WebClick(EdaatOR.Admin_Generate_ReportBTn);
				this.takeScreenShot();
				if (ExistsCheck(EdaatOR.Admin_MandatoryErrorMsg)){	

					VerifyValue1(testdatamap.get("ExpectedResult").toString(), getText(EdaatOR.Admin_Report_FromMonthErrMsg));
					Thread.sleep(500);
					VerifyValue1(testdatamap.get("ExpectedResult").toString(), getText(EdaatOR.Admin_Report_FromYearErrMsg));
					Thread.sleep(500);
					VerifyValue1(testdatamap.get("ExpectedResult").toString(), getText(EdaatOR.Admin_Report_ToMonthErrMsg));
					Thread.sleep(500);
					VerifyValue1(testdatamap.get("ExpectedResult").toString(), getText(EdaatOR.Admin_Report_ToYearErrMsg));
					test.log(Status.PASS, "Biller Transaction report ErrorMessage Exists" + driver.getTitle() + " *Biller Transaction report  Error Message Exists * ");
				}
				else {
					test.log(Status.FAIL, "No error Exists" + driver.getTitle() + " * No error Exists * ");
				}

			} catch (Exception e) {
				throw new NoSuchElementException("Biller Transaction report "+ "Page - Not Loaded");
			}

		}
	}

	//Function Summary  : method to verify Error messages in Clients Type Report page
	//Parameter Summary : ExpectedResult
	public void VerifyClientsTypeReportErrorMsg(Map<Object,Object>testdatamap,Log Log) throws InterruptedException{
		{
			try {
				NavigateTOAdminReports(Log);
				Thread.sleep(500);
				WebClickUsingJS(EdaatOR.Admin_ClientType_Report);
				Thread.sleep(500);
				WebClick(EdaatOR.Admin_Generate_ReportBTn);
				this.takeScreenShot();
				if (ExistsCheck(EdaatOR.Admin_MandatoryErrorMsg)){	

					VerifyValue1(testdatamap.get("ExpectedResult").toString(), getText(EdaatOR.Admin_Report_FromMonthErrMsg));
					Thread.sleep(500);
					VerifyValue1(testdatamap.get("ExpectedResult").toString(), getText(EdaatOR.Admin_Report_FromYearErrMsg));
					Thread.sleep(500);
					VerifyValue1(testdatamap.get("ExpectedResult").toString(), getText(EdaatOR.Admin_Report_ToMonthErrMsg));
					Thread.sleep(500);
					VerifyValue1(testdatamap.get("ExpectedResult").toString(), getText(EdaatOR.Admin_Report_ToYearErrMsg));
					Thread.sleep(500);
					VerifyValue1(testdatamap.get("ExpectedResult").toString(), getText(EdaatOR.Admin_Report_ClientTypeErrMsg));
					test.log(Status.PASS, "Clients Type report ErrorMessage Exists" + driver.getTitle() + " *Clients Type report  Error Message Exists * ");
				}
				else {
					test.log(Status.FAIL, "No error Exists" + driver.getTitle() + " * No error Exists * ");
				}

			} catch (Exception e) {
				throw new NoSuchElementException("Clients Type report "+ "Page - Not Loaded");
			}

		}
	}

	//Function Summary  : method to verify Error messages in Ticket Size Report page
	//Parameter Summary : ExpectedResult
	public void VerifyTicketSizeReportErrorMsg(Map<Object,Object>testdatamap,Log Log) throws InterruptedException{
		{
			try {
				NavigateTOAdminReports(Log);
				Thread.sleep(500);
				WebClickUsingJS(EdaatOR.Admin_TicketSize_Report);
				Thread.sleep(500);
				WebClick(EdaatOR.Admin_Generate_ReportBTn);
				this.takeScreenShot();
				if (ExistsCheck(EdaatOR.Admin_MandatoryErrorMsg)){	

					VerifyValue1(testdatamap.get("ExpectedResult").toString(), getText(EdaatOR.Admin_Report_FromMonthErrMsg));
					Thread.sleep(500);
					VerifyValue1(testdatamap.get("ExpectedResult").toString(), getText(EdaatOR.Admin_Report_FromYearErrMsg));
					Thread.sleep(500);
					VerifyValue1(testdatamap.get("ExpectedResult").toString(), getText(EdaatOR.Admin_Report_ToMonthErrMsg));
					Thread.sleep(500);
					VerifyValue1(testdatamap.get("ExpectedResult").toString(), getText(EdaatOR.Admin_Report_ToYearErrMsg));
					Thread.sleep(500);
					VerifyValue1(testdatamap.get("ExpectedResult").toString(), getText(EdaatOR.Admin_Report_TicketSizeErrMsg));
					test.log(Status.PASS, "Ticket Size  report ErrorMessage Exists" + driver.getTitle() + " *Ticket Size  report  Error Message Exists * ");
				}
				else {
					test.log(Status.FAIL, "No error Exists" + driver.getTitle() + " * No error Exists * ");
				}

			} catch (Exception e) {
				throw new NoSuchElementException("Ticket Size  report "+ "Page - Not Loaded");
			}

		}
	}
	
	//Function Summary  : method to verify Error messages in Payment Transactions & Operation Fees Report page
	//Parameter Summary : ExpectedResult
	public void VerifyPaymentTransactionReportErrorMsg(Map<Object,Object>testdatamap,Log Log) throws InterruptedException{
		{
			try {
				NavigateTOAdminReports(Log);
				Thread.sleep(500);
				WebClickUsingJS(EdaatOR.Admin_PaymentTransaction_Report);
				Thread.sleep(500);
				WebClick(EdaatOR.Admin_Generate_ReportBTn);
				this.takeScreenShot();
				if (ExistsCheck(EdaatOR.Admin_MandatoryErrorMsg)){	

					VerifyValue1(testdatamap.get("ExpectedResult").toString(), getText(EdaatOR.Admin_Report_PaymentTransactionErrMsg));
					Thread.sleep(500);
     				test.log(Status.PASS, "Payment Transactions & Operation Fees report ErrorMessage Exists" + driver.getTitle() + " *Payment Transactions & Operation Fees report  Error Message Exists * ");
				}
				else {
					test.log(Status.FAIL, "No error Exists" + driver.getTitle() + " * No error Exists * ");
				}

			} catch (Exception e) {
				throw new NoSuchElementException("Payment Transactions & Operation Fees report "+ "Page - Not Loaded");
			}

		}
	}	

	//Function Summary  : method to verify Error messages in Biller Monitoring Report page
	//Parameter Summary : ExpectedResult
	public void VerifyBillerMonitoringReportErrorMsg(Map<Object,Object>testdatamap,Log Log) throws InterruptedException{
		{
			try {
				NavigateTOAdminReports(Log);
				Thread.sleep(500);
				WebClickUsingJS(EdaatOR.Admin_BillerMonitoring_Report);
				Thread.sleep(500);
				WebClick(EdaatOR.Admin_Generate_ReportBTn);
				this.takeScreenShot();
				if (ExistsCheck(EdaatOR.Admin_MandatoryErrorMsg)){	

					VerifyValue1(testdatamap.get("ExpectedResult").toString(), getText(EdaatOR.Admin_Report_PaymentTransactionErrMsg));
					Thread.sleep(500);
     				test.log(Status.PASS, "Biller Monitoring Report ErrorMessage Exists" + driver.getTitle() + " *Biller Monitoring Report Error Message Exists * ");
				}
				else {
					test.log(Status.FAIL, "No error Exists" + driver.getTitle() + " * No error Exists * ");
				}

			} catch (Exception e) {
				throw new NoSuchElementException("Biller Monitoring Report "+ "Page - Not Loaded");
			}

		}
	}	
}
