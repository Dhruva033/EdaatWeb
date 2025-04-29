/**
 *
 * Test Script Name                   :NA
 * Objective                          :Verify System Management Distribution Functionality.
 * Version                            :1.0
 * Author                             :Kathirvelu Mohan
 * Created Date                       :8/09/2023
 * Last Updated on                    :N/A
 * Updated By                         :Arun Kumar MS
 * Pre-Conditions                     :N/A
 * Epic Details                       :N/A
 * User Story Details                 :N/A
 **/
package com.azmqalabs.edaattestautomation.apppages.admin.pages;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.internal.TestMethodWithDataProviderMethodWorker;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.azmqalabs.edaattestautomation.apppages.GlobalConstant;
import com.azmqalabs.edaattestautomation.apppages.masterpages.BasePage;
import com.azmqalabs.edaattestautomation.common.Log;
import com.azmqalabs.edaattestautomation.common.uielement.fieldDecorator;
import com.azmqalabs.edaattestautomation.objectrepository.EdaatOR;

public class AdminSystemMngDistributionPage extends BasePage {

	public AdminSystemMngDistributionPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

		PageFactory.initElements(new fieldDecorator(driver, test), this);
	}

	@FindBy(xpath = EdaatOR.Admin_DistRecordofpostingsym)
	public WebElement RecordofPosting ;

	public boolean Exists() {
		return super.Exists(RecordofPosting);
	}

	//Function Summary  : 	 to navigate to distribution page
	//Parameter Summary : N/A	
	public void NavigateToDistributionEODSettlementReport(Log Log) throws InterruptedException {

		try {
			WebClick(EdaatOR.Admin_SysMng);
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Admin_DistBtn);
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Admin_Dist_EODSettlement);
			if (CheckElementExists(EdaatOR.Admin_DistEODSettlement_Header)) {
				Log.ReportEvent("PASS", "EOD Settlement Report Page is Loaded Successfully");
			} else {
				Log.ReportEvent("Fail", "EOD Settlement Report Page is not Loaded Successfully");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		} catch (Exception e) {
			Log.ReportEvent("Fail", "EOD Settlement Report Page is not Loaded Successfully");
			this.takeScreenShot();
			e.printStackTrace();
			driver.quit();
			Assert.fail();
		}

	}
	//Function Summary  : 	 to navigate to distribution page
	//Parameter Summary : N/A	
	public void NavigateToDistributionDailyTransferRequest(Log Log) throws InterruptedException {

		try {
			WebClick(EdaatOR.Admin_SysMng);
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Admin_DistBtn);
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Admin_DistDailyTransferPage);
			if (CheckElementExists(EdaatOR.Admin_DistDailyTransfer_Header)) {
				Log.ReportEvent("PASS", "Daily Transfer Requests Page is Loaded Successfully");
			} else {
				Log.ReportEvent("Fail", "Daily Transfer Requests Page is Not Loaded Successfully");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		} catch (Exception e) {
			Log.ReportEvent("Fail", "Daily Transfer Requests Page is Not Loaded Successfully");
			this.takeScreenShot();
			e.printStackTrace();
			driver.quit();
			Assert.fail();
		}

	}
	//Function Summary  : 	 to navigate to distribution page
	//Parameter Summary : N/A	
	public void NavigateToDistributionRecordOfPosting(Log Log) throws InterruptedException {

		try {
			WebClick(EdaatOR.Admin_SysMng);
			Thread.sleep(1000);
			WebClick(EdaatOR.Admin_DistBtn);
			Thread.sleep(1000);
			WebClick(EdaatOR.Admin_DistRecordofposting);
			if (CheckElementExists(EdaatOR.Admin_DistRecordofpostingsym)) {
				Log.ReportEvent("PASS", "Record of Posting Page is Loaded Successfully");
			} else {
				Log.ReportEvent("Fail", "Record of Posting Page is Not Loaded Successfully");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		} catch (Exception e) {
			Log.ReportEvent("Fail", "Record of Posting Page is Not Loaded Successfully");
			this.takeScreenShot();
			e.printStackTrace();
			driver.quit();
			Assert.fail();
		}

	}


	//Function Summary  : Method to Verify Distribution Record of Posting View
	//Parameter Summary : N/A	
	public void VerifyRecordofpostingview(Map<Object, Object> testdatamap,Log Log) {
		try {
			SearchRecordOfPosting(testdatamap,Log);
			if(CheckElementExists("//span[text()='"+testdatamap.get("BatchNo").toString()+"']")) {
				Log.ReportEvent("PASS", "Verify Distribution Record of Posting View Functionality is Successful");
			}
			else {
				Log.ReportEvent("Fail", "Verify Distribution Record of Posting View Functionality is UnSuccessful");
				takeScreenShot();
				driver.close();
				Assert.fail();
			}	            
		}
		catch (Exception e) {
			Log.ReportEvent("Fail", "Verify Distribution Record of Posting View Functionality is UnSuccessful");
			takeScreenShot();
			driver.close();
			Assert.fail();
		}
	}

	public void SearchRecordOfPosting(Map<Object, Object> testdatamap,Log log) throws Exception{
		try {
			WebEdit(EdaatOR.Admin_BatchNo,testdatamap.get("BatchNo").toString());
			WebClick(EdaatOR.Admin_ClickFromdate);
			selectDropdownValue_PartialText(EdaatOR.Admin_ClickFromyear,testdatamap.get("Fromyear").toString());
			Thread.sleep(500);
			selectDropdownValue_PartialText(EdaatOR.Admin_ClickFrommonth,testdatamap.get("FromMonth").toString());
			WebClick("//a[text()='"+testdatamap.get("Fromdate").toString()+"']");
			WebClick(EdaatOR.Admin_ClickTodate);
			selectDropdownValue_PartialText(EdaatOR.Admin_ClickToyear,testdatamap.get("Toyear").toString());
			Thread.sleep(500);
			selectDropdownValue_PartialText(EdaatOR.Admin_ClickTomonth,testdatamap.get("ToMonth").toString());
			WebClick("//a[text()='"+testdatamap.get("Todate").toString()+"']");
			WebClick(EdaatOR.Admin_Button);
			Thread.sleep(2000);
			List<WebElement> elements=getElements(EdaatOR.Admin_RecordOfPostingTbleBtchNo);
			for( WebElement element:elements) {
				boolean value=element.getText().equals(testdatamap.get("BatchNo").toString());
				if(value) {
					log.ReportEvent("PASS", "Record of Posting Search Functionality is Successful");
				}
				else {
					log.ReportEvent("FAIL", "Record of Posting Search Functionality is UnSuccessful");
					takeScreenShot();
					driver.quit();
					Assert.fail();
				}
			}
		}
		catch (Exception e) {
			log.ReportEvent("FAIL", "Record of Posting Search Functionality is UnSuccessful");
			takeScreenShot();
			driver.quit();
			Assert.fail();
		}
	}


	public void NavigateDailytransferRecord(Log log) throws Exception
	{
		try {
			WebClick(EdaatOR.Admin_SysMng);
			Thread.sleep(1000);
			WebClick(EdaatOR.Admin_DistBtn);
			Thread.sleep(1000);
			WebClick(EdaatOR.Admin_DistRecordoftransferlink);
			Thread.sleep(1000);
			if (CheckElementExists(EdaatOR.Admin_DistRecordoftransferPageHeader)) {
				log.ReportEvent("Pass", "Daily Transfer Record Page is Loaded Successfully");
			}
			else {
				log.ReportEvent("FAIL", "Daily Transfer Record Page is Not Loaded Successfully");
				takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		}
		catch (Exception e) {
			log.ReportEvent("FAIL", "Daily Transfer Record Page is Not Loaded Successfully");
			takeScreenShot();
			driver.quit();
			Assert.fail();		
		}
	}


	//Function Summary  : Method to Verify Daiy transfered Record
	//Parameter Summary : RequestNumber,RequestStatus,TransferStatus
	public void verifyDaiytransferedRecord(Map<Object, Object> testdatamap,Log Log) throws InterruptedException
	{
		try {
			WebEdit(EdaatOR.AdminSys_Distri_record_Recnum,testdatamap.get("RequestNumber").toString());
			SelectDate1( testdatamap,Log);
			WebClick(EdaatOR.AdminSys_Distri_Requeststatus);
			Thread.sleep(1000);
			WebClick("//select[@id='BulkTransferRequestStatuses']//option[text()='"+testdatamap.get("RequestStatus").toString()+"']");
			Thread.sleep(1000);
			WebClick(EdaatOR.AdminSys_Distri_Transferstatus);
			Thread.sleep(1000);
			WebClick("//select[@id='BulkTransferRequestBillerStatuses']//option[text()='"+testdatamap.get("TransferStatus").toString()+"']");
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.AdminSys_Distri_recordsearchbtn);
			Thread.sleep(1000);
			if (getText(EdaatOR.AdminSys_Distri_recordsearchtbRnoData).equals(testdatamap.get("RequestNumber").toString())) {
				Log.ReportEvent("PASS", "Verify Daily Transfer Record Functionality is Successful");
			} else {
				Log.ReportEvent("FAIL", "Verify Daily Transfer Record Functionality is UnSuccessful");
				takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		}
		catch(Exception e){
			Log.ReportEvent("FAIL", "Verify Daily Transfer Record Functionality is UnSuccessful");
			takeScreenShot();
			driver.quit();
			Assert.fail();
		}

	}

	public void verifyDailyFileExportingSADADPage(Map<Object, Object> testdatamap,Log Log)
	{
		try
		{			
			Thread.sleep(1000);
			String actualHeader=getText("//h6[text()='"+testdatamap.get("LabelName").toString()+"']");
			String expectedValue = testdatamap.get("LabelName").toString();
			if(actualHeader.equals(expectedValue)) {
				Log.ReportEvent("PASS", "Verify Change the Label of Daily File Exporting Functionality is Successful");
			}
			else {
				Log.ReportEvent("FAIL", "Verify Change the Label of Daily File Exporting Functionality is UnSuccessful");
				takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		}
		catch (Exception e) {
			Log.ReportEvent("FAIL", "Verify Change the Label of Daily File Exporting Functionality is UnSuccessful");
			takeScreenShot();
			driver.quit();
			Assert.fail();
		}
	}	


	//Function Summary  : Method to NavigateDailyFileExport
	//Parameter Summary : N/A
	public void NavigateDailyFileExport(Log Log) throws Exception
	{
		try {
			WebClick(EdaatOR.Admin_SysMng);
			Thread.sleep(1000);
			WebClick(EdaatOR.Admin_DistBtn);
			Thread.sleep(1000);
			WebClick(EdaatOR.Admin_Dist_DailyfileExporting);
			Thread.sleep(1000);
			if(CheckElementExists(EdaatOR.Dis_FileExporting_SADAD_Label)) {
				Log.ReportEvent("PASS", "Daily File Exporting (SADAD) Page is Loaded Successfully");
			}
			else {
				Log.ReportEvent("FAIL", "Daily File Exporting (SADAD) Page is Not Loaded Successfully");
				takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		} catch (Exception e) {
			Log.ReportEvent("FAIL", "Daily File Exporting (SADAD) Page is Not Loaded Successfully");
			takeScreenShot();
			driver.quit();
			Assert.fail();
		}
	}

	//Function Summary  : Method to SelectDate
	//Parameter Summary : FromYear,FromMonth,FromDate,ToYear,ToMonth,ToDate
	public void SelectDate(Map<Object,Object>testdatamap)
	{
		try {
			WebClick(EdaatOR.Admin_Dist_ExportFromd);
			selectDropdownValue_PartialText(EdaatOR.Admin_Dist_ExportFromyear,testdatamap.get("FromYear").toString());
			selectDropdownValue_PartialText(EdaatOR.Admin_Dist_ExportFromon,testdatamap.get("FromMonth").toString());
			WebClick("//a[text()='"+testdatamap.get("FromDate").toString()+"']");
			WebClick(EdaatOR.Admin_Dist_ExportTod);
			selectDropdownValue_PartialText(EdaatOR.Admin_Dist_ExportToyear,testdatamap.get("ToYear").toString());
			selectDropdownValue_PartialText(EdaatOR.Admin_Dist_Exportomon,testdatamap.get("ToMonth").toString());
			Thread.sleep(1000);
			WebClick("//a[text()='"+testdatamap.get("ToDate").toString()+"']");
		}
		catch (Exception e) {
			e.printStackTrace();

		}

	}

	//Function Summary  : Method to Select Date
	//Parameter Summary : Reqyear,Reqmonth,Reqdate,Reconcileyear,Reconcilemonth and ReconcileDate.
	public void SelectDate1(Map<Object, Object> testdatamap,Log log)
	{
		try {
			WebClick(EdaatOR.AdminSys_Distri_Reqd);
			selectDropdownValue_PartialText(EdaatOR.AdminSys_Distri_Reqyear,testdatamap.get("Reqyear").toString());
			selectDropdownValue_PartialText(EdaatOR.AdminSys_Distri_ReqMon,testdatamap.get("Reqmonth").toString());
			WebClick("//a[text()='"+testdatamap.get("Reqdate").toString()+"']");
			Thread.sleep(1000);
			WebClick(EdaatOR.AdminSys_Distri_Recond);
			Thread.sleep(1000);
			selectDropdownValue_PartialText(EdaatOR.AdminSys_Distri_Recon_Toyear,testdatamap.get("Reconcileyear").toString());
			Thread.sleep(1000);
			selectDropdownValue_PartialText(EdaatOR.AdminSys_Distri_Recon_Tomon,testdatamap.get("Reconcilelmonth").toString());
			Thread.sleep(1000);
			WebClick("//div[@class='calendars']//a[text()='"+testdatamap.get("ReconcileDate").toString()+"']");
			//WebClick("//a[text()='"+testdatamap.get("ReconcileDate").toString()+"'])[2]");
			List<WebElement> elements=getElements(EdaatOR.Admin_DistribtiontranferRecordTextBoxes);
			for( WebElement element:elements) {
				String value=element.getAttribute("value");
				if(value == null || value.trim().isEmpty()) {
					takeScreenShot();
					driver.quit();
					Assert.fail();
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
			takeScreenShot();
			driver.quit();
			Assert.fail();
		}
	}
	
	//Function Summary  : Method to ReconcilledDateSearch
	//Parameter Summary : Month,Year,Date
	public void ReconcilledDateSearch(Map<Object, Object> testdatamap,Log Log) throws InterruptedException {
		try {
			WebClick(EdaatOR.Admin_DailyTransReconciledCalender);
			selectDropdownValue_PartialText(EdaatOR.Admin_ReconciledMonth, testdatamap.get("Month").toString());
			selectDropdownValue_PartialText(EdaatOR.Admin_ReconciledYear, testdatamap.get("Year").toString());
			WebClick("//a[text()='"+testdatamap.get("Date").toString()+"']");
			Thread.sleep(1000);
			WebClick(EdaatOR.Admin_ReconciledSearchBtn);
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//Function Summary  : Method to Verify Distribution Record of Posting View
	//Parameter Summary : N/A	
	public void VerifyDailyTransfer(Map<Object, Object> testdatamap,Log Log) {
		try {
			//AddTransferRequest(testdatamap);
			ReconcilledDateSearch(testdatamap,Log);
			Thread.sleep(3000);
			WebClick(EdaatOR.Admin_viewRequest);
			Thread.sleep(1000);
			if (!getElement(EdaatOR.Admin_CloseRequest).isDisplayed()) {
				Log.ReportEvent("FAIL", "View Daily Transfer Request Page is Not Loaded Successfully");
				takeScreenShot();
				driver.quit();
				Assert.fail();
			}
			else {
				Log.ReportEvent("PASS", "View Daily Transfer Request Page is Loaded Successfully");
			}
			WebClick(EdaatOR.Admin_CloseRequest);
			Thread.sleep(1000);
			if(!CheckElementExists(EdaatOR.Admin_DistDailyTransfer_Header)) {
				Log.ReportEvent("FAIL", "Verify Daily Transfer Requests Functionality is UnSuccessful");
				takeScreenShot();
				driver.quit();
				Assert.fail();
			} 
			else {
				Log.ReportEvent("PASS", "Verify Daily Transfer Requests Functionality is Successful");	
			}  	
		}
		catch (Exception e) {
			Log.ReportEvent("Fail", "Verify Daily Transfer Requests Functionality is UnSuccessful");
			takeScreenShot();
			driver.quit();
			Assert.fail();
		}	



	}
	//Function Summary  : Method to EnterSearchitem
	//Parameter Summary : MainBiller,TransferStatus
	public void EnterSearchitem(Map<Object, Object> testdatamap) throws InterruptedException {

		try {
			WebClick(EdaatOR.Admin_Dist_BillerName);
			Thread.sleep(1000);
			WebClickUsingActions("//li[text()='"+testdatamap.get("MainBiller").toString()+"']");
			Thread.sleep(1000);
			selectDropdownValue_PartialText(EdaatOR.Admin_Dist_TransferStatus,testdatamap.get("TransferStatus").toString());
			Thread.sleep(1000);
			WebClick(EdaatOR.Admin_Dist_Export_srcbtn);
			Thread.sleep(2000);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	//Function Summary  : Method to VerifyDailyFileExporting
	//Parameter Summary : N/A	
	public void VerifyDailyFileExporting(Map<Object, Object> testdatamap,Log Log)
	{
		try
		{
			SelectDate(testdatamap);
			Thread.sleep(2000);
			EnterSearchitem(testdatamap);
			Thread.sleep(1000);
			String actualValue=getText("//td[text()='"+testdatamap.get("MainBiller").toString()+"']");
			if(actualValue.equals(testdatamap.get("MainBiller").toString())) {
				Log.ReportEvent("PASS", "Verify Daily File Exporting Functionality is Successful");
			}
			else {
				Log.ReportEvent("FAIL", "Verify Daily File Exporting Functionality is UnSuccessful");
				takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		}
		catch (Exception e) {
			Log.ReportEvent("FAIL", "Verify Daily File Exporting Functionality is UnSuccessful");
			takeScreenShot();
			driver.quit();
			Assert.fail();
		}
	}	

	//Function Summary  : Method to VerifyDailyTransferErrorMsg
	//Parameter Summary : Expected	
	public void VerifyDailyTransferErrorMsg(Map<Object, Object> testdatamap, Log Log) {
		try {
			WebClick(EdaatOR.Admin_AddTransferRequest);
			switchToWindow();
			String Expected = testdatamap.get("Expected").toString();
			ReconcilledDateSearch(testdatamap,Log);
			WebClick(EdaatOR.Admin_ManualCheckbox);
			WebClick(EdaatOR.Admin_SaveButton);				
			if(getText(EdaatOR.Admin_DistReason).equals(Expected)&&getText(EdaatOR.Admin_DistAttachment).equals(Expected)
					&&getText(EdaatOR.Admin_DistDate).equals(testdatamap.get("DateError").toString()))
			{
				Log.ReportEvent("PASS", "Verify the Error Message for all the Required Fields is Successful");
			}
			else
			{
				Log.ReportEvent("FAIL", "Verify the Error Message for Daily Transfer Requests is UnSuccessful");
				takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		}
		catch (Exception e) {
			Log.ReportEvent("FAIL", "Verify the Error Message Daily Transfer Requests is UnSuccessful");
			takeScreenShot();
			driver.quit();
			Assert.fail();
		}	
	}
	//Function Summary  : Method to VerifyEODSettlementReportErrorMsg
	//Parameter Summary : Expected	
	public void VerifyEODSettlementReportErrorMsg(Map<Object, Object> testdatamap,Log Log) {

		try {
			Thread.sleep(1000);
			WebClick(EdaatOR.Admin_Dist_EODSettlementSearchbtn);
			Thread.sleep(1000);
			if(getText(EdaatOR.Admin_Dist_EODSettlementErrorMsg).equals(testdatamap.get("Expected").toString()))
			{
				Log.ReportEvent("PASS", "Verify Error Msg for Search Field is Successful");
			}
			else
			{
				Log.ReportEvent("FAIL", "Verify Error Msg for Distribution EOD Settlement Report is UnSuccessful");
				takeScreenShot();
				driver.quit();
				Assert.fail();
			}

		} catch (Exception e) {

			Log.ReportEvent("FAIL", "Verify Error Msg for Distribution EOD Settlement Report is UnSuccessful");
			takeScreenShot();
			driver.quit();
			Assert.fail();
		}

	}
	//Function Summary  : Method to Verify Daily file exporting [Hyper pay]
	//Parameter Summary : N/A	
	public void VerifyDailyFileExportingHyperPay(Log Log) {
		try {
			WebClick(EdaatOR.Admin_SysMng);
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Admin_DistBtn);
			Thread.sleep(1000);
			Thread.sleep(2000);
			WebClick(EdaatOR.Admin_DistDailyfileExportingHyper);
			Thread.sleep(1000);
			if(CheckElementExists(EdaatOR.Admin_DailyFileExportingHyperPayHeader)) {
				Log.ReportEvent("PASS","Verify Add New Page Daily File Exporting [Hyper pay] Fnctionality is Successful");
			}
			else {
				Log.ReportEvent("FAIL","Verify Add New Page Daily File Exporting [Hyper pay] Fnctionality is UnSuccessful");
				takeScreenShot();
				driver.quit();
				Assert.fail();
			}			
		}
		catch (Exception e) {
			Log.ReportEvent("FAIL","Verify Add New Page Daily File Exporting [Hyper pay] Fnctionality is UnSuccessful");
			takeScreenShot();
			driver.quit();
			Assert.fail();
		}
	}
}
