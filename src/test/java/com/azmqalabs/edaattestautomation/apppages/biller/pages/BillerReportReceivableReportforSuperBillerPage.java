package com.azmqalabs.edaattestautomation.apppages.biller.pages;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.SwitchToFrame;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.azmqalabs.edaattestautomation.apppages.GlobalConstant;
import com.azmqalabs.edaattestautomation.apppages.masterpages.BasePage;
import com.azmqalabs.edaattestautomation.common.uielement.fieldDecorator;
import com.azmqalabs.edaattestautomation.objectrepository.EdaatOR;
import com.azmqalabs.edaattestautomation.common.Log;



public class BillerReportReceivableReportforSuperBillerPage extends BasePage
{

	public BillerReportReceivableReportforSuperBillerPage(WebDriver driver,ExtentTest test)
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
	    //Function Summary   : Method to Navigate Receivable Reports SuperBiller
	    //Parameter Summary :  N/A.
	    public void NavigatetoReceivableReportSuperBiller(Log Log) throws InterruptedException
	    {
	    	WebClick(EdaatOR.Biller_ReportsMenu);
			 Thread.sleep(1000);
			 WebClick(EdaatOR.Biller_Recevible_ReportSuperBiller);
			 Log.ReportEvent("PASS", " Navigate to Receivable Report Super Biller");
	    }
	  //Function Summary  : Method to Verify Corporate Client Report
	  //Parameter Summary : TrackedBillerName .
	 public void VerifyCorportaeClientsReport(Map<Object, Object> testdatamap,Log Log) throws Exception {
		 try{
			 NavigatetoReceivableReportSuperBiller(Log);
			 this.takeScreenShot();
			 WebClick(EdaatOR.Biller_Recevible_ReportSuperBillerCorporateClient);
			 Thread.sleep(1000);
			 WebClickUsingJS(EdaatOR.Biller_Rece_ReportSupBillerCorpoTrackBillName);
			 Thread.sleep(2000);
			 WebEdit(EdaatOR.Biller_Rece_ReportSupBillerCorpoTrackBillName, testdatamap.get("TrackedBillerName").toString());
			 Thread.sleep(2000);
			 WebClick(EdaatOR.Biller_Rece_ReportSupBillerGenerateReportBTN);
			 Thread.sleep(1000);
			 switchToWindow();
			 waitForPageToLoad();
			 this.takeScreenShot();
			 swithchToFrame(EdaatOR.Biller_SuperBillerCorporateClientframe);
			 Thread.sleep(2000);
			 verifyElementIsPresent(EdaatOR.Biller_SuperBillerCorporateReportClientText);
			 switchBacktoParentwindow();
			 test.log(Status.PASS,"#FUNC- Verify Corporate Client Report" + driver.getTitle() +" * Verify Corporate Client Report is PASS * " );	
				Log.ReportEvent("PASS", " Verify Supper Biller Corporate Client Report is Suceessful");
     }catch(Exception e){
      test.log(Status.FAIL, "#FUNC-Verify Corporate Client Report " + driver.getTitle() + " * Verify Corporate Client Report is FAIL * ");
 		this.takeScreenShot();
     }
				 
	 
	 }
	 
	 	//Function Summary  : Method to Enter FromDate 
			//Parameter Summary : FromYear,FromMonth,FromDate
			private void EnterFromdate(Map<Object, Object> testdatamap) throws InterruptedException {
				WebClick(EdaatOR.Biller_Clientreport_FromDate);
				selectDropdownValue_PartialText(EdaatOR.Biller_Clientreport_Fromyear,testdatamap.get("FromYear").toString());
				selectDropdownValue_PartialText(EdaatOR.Biller_Clientreport_FromMonth,testdatamap.get("FromMonth").toString());
	            WebClick("//a[text()='"+testdatamap.get("FromDate").toString()+"']");
				Thread.sleep(1000);
			}
			
			//Function Summary  : Method to Enter FromDate 
			//Parameter Summary : ToYear,ToMonth,ToDate
			private void EnterTodate(Map<Object, Object> testdatamap) throws InterruptedException {
				WebClick(EdaatOR.Biller_Clientreport_TODate);
				selectDropdownValue_PartialText(EdaatOR.Biller_Clientreport_Toyear,testdatamap.get("ToYear").toString());
				selectDropdownValue_PartialText(EdaatOR.Biller_Clientreport_ToMonth,testdatamap.get("ToMonth").toString());
	            WebClick("//a[text()='"+testdatamap.get("ToDate").toString()+"']");
				Thread.sleep(1000);

			}
	public void GenerateReport(Map<Object, Object> testdatamap,Log Log) {
		// TODO Auto-generated method stub
		try{
			NavigatetoReceivableReportSuperBiller(Log);
			WebClick(EdaatOR.Biller_clientinvoicebtn);
			WebClick(EdaatOR.Biller_Trackedbiller);
			WebClick("//li[text()='"+testdatamap.get("TrackedBiller").toString()+"']");
			EnterFromdate(testdatamap);
			EnterTodate(testdatamap);
			selectDropdownValue_PartialText(EdaatOR.Biller_ClientType,testdatamap.get("ClientType").toString());
			Thread.sleep(500);
			WebClick(EdaatOR.Biller_ClientNamearro);
			Thread.sleep(500);
			WebClick("//li[text()='"+testdatamap.get("ClientName").toString()+"']");
			Thread.sleep(1000);
			WebClick(EdaatOR.Biller_Clientstatus);
			Thread.sleep(1000);
			WebClick("//li[text()='"+testdatamap.get("BillStatus").toString()+"']");			
			Thread.sleep(500);
			WebEdit(EdaatOR.Biller_IdorCR,testdatamap.get("IdorCR").toString());
			Thread.sleep(2000);
			WebSelect(EdaatOR.Biller_SubBillerType,testdatamap.get("SubBillerType").toString());
			Thread.sleep(2000);	     
        	WebClick(EdaatOR.Biller_clientSubBillerName);
     		Thread.sleep(2000);
     		WebClick("//li[text()='"+testdatamap.get("SubBillerName").toString()+"']");
     		Thread.sleep(2000);
			WebClickUsingActions(EdaatOR.Biller_Generatebtn);
			Thread.sleep(3000);
			switchToWindow();
			Thread.sleep(3000);
			swithchToFrame(EdaatOR.Biller_reportframe);
			verifyElementIsPresent(EdaatOR.Biller_clientinvoice);
			Thread.sleep(2000);
			waitForPageToLoad();
    		this.takeScreenShot();
			switchToDefault();
			//Thread.sleep(2000);
			//WebClick(EdaatOR.Biller_Exporttoexcelbtn);
			//scrollDowntillend(driver);
			//VerifyValue1(WebGetText(EdaatOR.Biller_exportedmsg), testdatamap.get("exportmsg").toString());
			//waitForPageToLoad();
			Thread.sleep(1000);
    		test.log(Status.PASS,"#FUNC-Generate Report and export " + driver.getTitle() +" * Generate Report and export PASS * " );
    		Log.ReportEvent("PASS", " Verify Clients Invoices Report Generate Report is Suceessful");
    		this.takeScreenShot();
			}
		catch(Exception e){
	test.log(Status.FAIL,"#FUNC-Generate Report and export" + driver.getTitle() +" * Generate Report and export FAIL * " );
	this.takeScreenShot();
	}
		
	}
		
		
	//Function Summary  : Method to SelectRadioBtn
	//Parameter Summary : 
	 public void SelectRadioBtn(Map<Object, Object> testdatamap) throws InterruptedException {
		 String type = testdatamap.get("Radiobtn").toString();
		 if(type.equalsIgnoreCase("individual"))
		 {
			 WebClickRadiobutton(EdaatOR.Biller_SuperBiller_SubBiller_selectInd);
			 Thread.sleep(1000);
			 WebEdit(EdaatOR.Biller_SuperBiller_SubBiller_Nationalefield, testdatamap.get("NationalId").toString());
			 Thread.sleep(1000);
		 }
		 else
		 {
			 WebClick(EdaatOR.Biller_SuperBiller_SubBiller_selectCorp);
			 Thread.sleep(1000);
			 WebEdit(EdaatOR.Biller_SuperBiller_SubBiller_Crnumberefield, testdatamap.get("CRNumber").toString());
			 Thread.sleep(1000);
		 }
			
		}
	//Function Summary  : Method to Verify Corporate Client Report
	//Parameter Summary : TrackedBillerName .
	public void VerifySubBillersReport(Map<Object, Object> testdatamap,Log Log) {
		try
		{
			String type = testdatamap.get("Radiobtn").toString();
			WebClickUsingJS(EdaatOR.Biller_SuperBiller_subBillerbtn);
			SelectRadioBtn(testdatamap);
			Thread.sleep(1000);
			WebClick(EdaatOR.Biller_SuperBiller_SubBiller_trackbill);
			Thread.sleep(1000);
			WebClickUsingActions("//li[text()='"+testdatamap.get("TrackedBillerName").toString()+"']");
			Thread.sleep(5000);
			this.takeScreenShot();
			WebClick(EdaatOR.Biller_SuperBiller_SubBiller_generatebtn);
			switchToWindow();
			Thread.sleep(1000);
			swithchToFrame(EdaatOR.Biller_SuperBiller_SubBiller_frame);
			Thread.sleep(1000);
			this.takeScreenShot();
			 if(type.equalsIgnoreCase("individual"))
			 {
				 verifyElementIsPresent(EdaatOR.Biller_SuperBiller_SubBiller_indVerify);
				 Thread.sleep(1000);
			 }
			 else
			 {
				 verifyElementIsPresent(EdaatOR.Biller_SuperBiller_SubBiller_CorpVerify);
				 Thread.sleep(1000);
			 }
			 switchBacktoParentwindow();
			 Thread.sleep(1000);
			 this.takeScreenShot();	
		test.log(Status.PASS,"#FUNC- Verify Sub Billers Report " + driver.getTitle() +" * Sub Billers Report PASS * " );
		Log.ReportEvent("PASS", " Verify Sub Biller Generate Report is Suceessful");

		}
		catch (Exception e) {
			test.log(Status.FAIL,"#FUNC- Verify Sub Billers Report " + driver.getTitle() +" * Sub Billers Report FAIL * " );	
			this.takeScreenShot();
		}
	}
		 
	    //Function Summary    : Method to Navigate "Over Due Bills Report" Page
	    //Parameter Summary   :  N/A.
	    public void NavigatetoReceivableReportSuperBillerOverDue(Log Log) throws InterruptedException
	    {
	    	WebClick(EdaatOR.Biller_ReportsMenu);
			 Thread.sleep(1000);
			 WebClick(EdaatOR.Biller_Recevible_ReportSuperBiller);
			 WebClick(EdaatOR.Biller_SuperBillerOverDueBillsReportPage);
			 Thread.sleep(1000);
			 Log.ReportEvent("PASS", " Verify Navigate to Over Due Bills Report Page is Suceessful");
	    }
	    
	  //Function Summary  : Method to Verify Overdue Bills Report Client Report
	  //Parameter Summary : ClientType,TrackedBillerName,ClientName,SubBillerType,SubBillerName,Report
	 public void VerifyOverdueBillsReport(Map<Object, Object> testdatamap,Log Log)
     {
		 try{
			 WebClick(EdaatOR.Biller_SuperBillerOverDueBillsReportClientType);
             WebSelect(EdaatOR.Biller_SuperBillerOverDueBillsReportClientType, testdatamap.get("ClientType").toString());
             Thread.sleep(2000);
             selectDropdownValue_PartialText(EdaatOR.Biller_SuperBillerOverDueBillesTrackedBiller, testdatamap.get("TrackedBillerName").toString() );
             Thread.sleep(2000);
             WebClick(EdaatOR.Biller_SuperBillerOverDueBillsReportclientNameTxtField);
             WebClick("//li[contains(text(),'"+testdatamap.get("ClientName").toString()+"')]");
             Thread.sleep(2000);
             WebSelect(EdaatOR.Biller_SuperBillerOverDueBillsReportSubBillerType, testdatamap.get("SubBillerType").toString());
             Thread.sleep(1000);
             WebClick(EdaatOR.Biller_SuperBillerOverDueBillsReportSubBillerName);
             Thread.sleep(1000);
             WebClick("//li[text()='"+testdatamap.get("SubBillerName").toString()+"']");
             Thread.sleep(3000);
             WebClick(EdaatOR.Biller_SuperBillerOverDueBillsGenerateReportBTN);
             waitForPageToLoad();
             switchToWindow();
             swithchToFrame(EdaatOR.Biller_SuperBillerOverDueBillsReportFrame);
             Thread.sleep(1000);
             VerifyValue1(WebGetText("//div[text()='"+testdatamap.get("Report").toString()+"']"), testdatamap.get("Report").toString());
             Thread.sleep(2000);
             this.takeScreenShot();
             switchBacktoParentwindow();
             test.log(Status.PASS,"#FUNC-Verify Overdue Bills Report " + driver.getTitle() +" * Verify Overdue Bills Report is PASS * " );
             Log.ReportEvent("PASS", " Verify Receivables Reports for Super Biller Overdue Bills Report is Suceessful");
             this.takeScreenShot();
             }

         catch(Exception e){
        	 test.log(Status.FAIL,"#FUNC-Verify Overdue Bills Report " + driver.getTitle() +" * Verify Overdue Bills Report is FAIL * " );
        	 this.takeScreenShot();
     }
	 }
	 
	 	 public void NavigateReceivableReportsforSuperBiller(Log Log) throws InterruptedException
	    {
	    	 WebClick(EdaatOR.Biller_ReportsMenu);
             Thread.sleep(1000);
			 WebClick(EdaatOR.Biller_Recevible_ReportSuperBiller);
			 Log.ReportEvent("PASS", " Navigate to Receivable reports for super biller page");
	    }
	 	  //Function Summary  : Method to SelectDate
		  //Parameter Summary : FromYear,FromMonth,FromDate,ToYear,ToMonth,ToDate.
	 public void ClientAccountSelectDate(Map<Object, Object> testdatamap)
	 {
		 try {
			  WebClick(EdaatOR.Biller_Rcv_superbilr_ClientAccount_Fromdate);
			  selectDropdownValue_PartialText(EdaatOR.Biller_Rcv_superbilr_ClientAccount_Fromyear,testdatamap.get("FromYear").toString());
			  selectDropdownValue_PartialText(EdaatOR.Biller_Rcv_superbilr_ClientAccount_FromMon,testdatamap.get("FromMonth").toString());
			  WebClick("//a[text()='"+testdatamap.get("FromDate").toString()+"']");
			  WebClick(EdaatOR.Biller_Rcv_superbilr_ClientAccount_Todate);
			  selectDropdownValue_PartialText(EdaatOR.Biller_Rcv_superbilr_ClientAccount_Toyear,testdatamap.get("ToYear").toString());
			  selectDropdownValue_PartialText(EdaatOR.Biller_Rcv_superbilr_ClientAccount_Tomon,testdatamap.get("ToMonth").toString());
			  WebClick("//a[text()='"+testdatamap.get("ToDate").toString()+"']");
			  	}
			  catch (Exception e) {
			  	e.printStackTrace();
			  	this.takeScreenShot();
			  	}
			  		
	 }
//Function Summary  : Method to Select Client type. 
		//Parameter Summary : ClientType,Individual.
		public void ClientType(Map<Object, Object> testdatamap) { 
			
			try{
				WebClick(EdaatOR.Biller_ClientType);
				String ele=testdatamap.get("ClientType").toString();
				if(ele.equalsIgnoreCase("Individual")) {
				selectDropdownValue_PartialText(EdaatOR.Biller_ClientTypeindvidutial, ele);
				}
				else {
					selectDropdownValue_PartialText(EdaatOR.Biller_ClientTypeCorporate, ele);
				}			
				
			}
			catch(Exception e){
		test.log(Status.FAIL,"#FUNC-Generate Report and export" + driver.getTitle() +" * Generate Report and export FAIL * " );
		this.takeScreenShot();
		}			
		}
		
		  //Function Summary  : Method to Select Client type. 
		 //Parameter Summary : ClientName.
		public void SelectClient(Map<Object, Object> testdatamap) throws InterruptedException {
			
			WebClick(EdaatOR.Biller_ReportSuper_ClientAccount_Client);
		   Thread.sleep(2000);
		   WebClick("//li[text()='"+testdatamap.get("ClientName").toString()+"']");
		}
		//Function Summary  : Method to Navigate to Client account statement.  
		//Parameter Summary : N/A
		public void navigatetoclientAccountStatement() {
			try{
				WebClickUsingJS(EdaatOR.Biller_ReportMenu); 
				Thread.sleep(1000);
				WebClickUsingJS(EdaatOR.Biller_Recevible_ReportSuperBiller); 
				Thread.sleep(1000);
				WebClickUsingJS(EdaatOR.Biller_Recevible_ReportSprBiler_ClientAccount); 
				Thread.sleep(1000);
				
	    		test.log(Status.PASS,"#FUNC-ClientAccountPage " + driver.getTitle() +" * ClientAccountReportPage PASS * " );
	    		this.takeScreenShot();
				}
			catch(Exception e){
		test.log(Status.FAIL,"#FUNC-ClientAccountPage" + driver.getTitle() +" * ClientAccountReportPage FAIL * " );
		this.takeScreenShot();
		}

		}
//Function Summary  : Method to VerifyvClientvAccountvStatementvReport
//Parameter Summary : 	TrackedBiller,SubBiller,SubbillerName,FromYear,FromMonth,FromDate,ToYear,ToMonth,ToDate
	 public void VerifyClientAccountStatementReport(Map<Object, Object> testdatamap,Log Log)
	 {
	   try {
		    navigatetoclientAccountStatement();
			ClientType(testdatamap);
			WebClick(EdaatOR.Biller_ReportSuper_ClientAccount_TrackedBiller);
			WebClick("//li[text()='"+testdatamap.get("TrackedBiller").toString()+"']");
			Thread.sleep(1000);
			SelectClient(testdatamap);	
			//WebClick(EdaatOR.Biller_ReportSuper_ClientAccount_subBiller_type);
			Thread.sleep(1000);	
			WebSelect1(EdaatOR.Biller_ReportSuper_ClientAccount_subBiller_type, testdatamap.get("SubBiller").toString());    
		    Thread.sleep(2000);
		    WebClick(EdaatOR.Biller_ReportSuper_ClientAccount_subBiller_name);
		    Thread.sleep(2000);
		    WebClick("//li[text()='"+(testdatamap.get("SubbillerName").toString())+"']");					
		//	WebEdit(EdaatOR.Biller_Invoicecontract,testdatamap.get("Invoice Contract").toString());
		    WebClick(EdaatOR.Biller_ReportFromdate);
			Thread.sleep(1000);
	        selectDropdownValue_PartialText(EdaatOR.Biller_reportFromYear,testdatamap.get("FromYear").toString());
	    	Thread.sleep(1000);
	        selectDropdownValue_PartialText(EdaatOR.Biller_reportFromMonth,testdatamap.get("FromMonth").toString());
	    	Thread.sleep(1000);
	        WebClick("//a[text()='"+testdatamap.get("FromDate").toString()+"']");
	    	Thread.sleep(1000);
	        WebClick(EdaatOR.Biller_ReportTodate);
	    	Thread.sleep(1000);
	        selectDropdownValue_PartialText(EdaatOR.Biller_reportToyear,testdatamap.get("ToYear").toString());
	    	Thread.sleep(1000);
	        selectDropdownValue_PartialText(EdaatOR.Biller_reportToMonth,testdatamap.get("ToMonth").toString());
	    	Thread.sleep(1000);
	        WebClick("//a[text()='"+testdatamap.get("ToDate").toString()+"']");	
	    	Thread.sleep(1000);
	        WebClick(EdaatOR.Biller_ReportSuper_ClientAccount_search);
	        waitForPageToLoad();
	        Thread.sleep(5000);			    
	        this.takeScreenShot();			       
	        switchToWindow();			      
	        swithchToFrame(EdaatOR.Biller_reportframe);
	        verifyElementIsPresent(EdaatOR.Biller_Rcv_superbilr_ClientAccount_verify);
	        Thread.sleep(1000);
		    test.log(Status.PASS,"#FUNC-Verify Client Account Statement Report" + driver.getTitle() +" * Verify Client Account Statement Report Pass * " );
		   	Log.ReportEvent("PASS", "  Verify Client Account Statement is successful");
		    switchBacktoParentwindow();
	    	Thread.sleep(1000); 
		 }
		 catch(Exception e)
		 {
			 test.log(Status.FAIL,"#FUNC-Verify Client Account Statement Report" + driver.getTitle() +" * Verify Client Account Statement Report FAIL * " );
				this.takeScreenShot();
		 }
		 
	 }

	  //Function Summary  : Method to SelectDate
	  //Parameter Summary : FromYear,FromMonth,FromDate,ToYear,ToMonth,ToDate.
public void SelectDate(Map<Object, Object> testdatamap)
{
	 try {
		  WebClick(EdaatOR.Biller_FromDateCalendar);
		  selectDropdownValue_PartialText(EdaatOR.Biller_Rcv_superbilr_ClientAccount_Fromyear,testdatamap.get("FromYear").toString());
		  selectDropdownValue_PartialText(EdaatOR.Biller_Rcv_superbilr_ClientAccount_FromMon,testdatamap.get("FromMonth").toString());
		  WebClick("//a[text()='"+testdatamap.get("FromDate").toString()+"']");
		  WebClick(EdaatOR.Biller_ToDateCalendar);
		  selectDropdownValue_PartialText(EdaatOR.Biller_Rcv_superbilr_ClientAccount_Toyear,testdatamap.get("ToYear").toString());
		  selectDropdownValue_PartialText(EdaatOR.Biller_Rcv_superbilr_ClientAccount_Tomon,testdatamap.get("ToMonth").toString());
		  WebClick("//a[text()='"+testdatamap.get("ToDate").toString()+"']");
		  	}
		  catch (Exception e) {
		  	e.printStackTrace();
		  	this.takeScreenShot();
		  	}
		  		
}
	 
	  //Function Summary  : Method to Verify Sadad Payment Transactions report
	  //Parameter Summary : InvoiceType,InvoiceNumber,ClientType,TrackedBillerName,ClientName.
	 public void VerifySadadPaymentsTransactions(Map<Object, Object> testdatamap,Log Log)
    {
		 try{
			 WebClickUsingJS(EdaatOR.Biller_SadadPaymentsReportLink);
			 selectDropdownValue_PartialText(EdaatOR.Biller_SadadReportInvoiceType, testdatamap.get("InvoiceType").toString());
            Thread.sleep(1000);
            WebEdit(EdaatOR.Biller_SadadReportInvoiceNo, testdatamap.get("InvoiceNumber").toString());
            selectDropdownValue_PartialText(EdaatOR.Biller_SadadReportClientType, testdatamap.get("ClientType").toString() );
            Thread.sleep(1000);
             WebClickUsingJS(EdaatOR.Biller_SadadReportTrackerBiller);
             WebClick("//li[contains(text(),'"+testdatamap.get("TrackedBillerName").toString()+"')]");
            //WebEdit(EdaatOR.Biller_SadadReportTrackerBiller,testdatamap.get("TrackedBillerName").toString());
            Thread.sleep(1000);
            WebClick(EdaatOR.Biller_SadadReportClientName);
            WebClick("//li[contains(text(),'"+testdatamap.get("ClientName").toString()+"')]");
            Thread.sleep(1000);
            SelectDate(testdatamap);
            Thread.sleep(1000);
            WebClick(EdaatOR.Biller_Products);
            WebClick("//li[contains(text(),'"+testdatamap.get("ProductName").toString()+"')]");
            WebClick(EdaatOR.Biller_SadadReportSearchBtn);
            waitForPageToLoad();
            switchToWindow();
            swithchToFrame(EdaatOR.Biller_CorporateReport);
            Thread.sleep(1000);
            verifyElementIsPresent(EdaatOR.Biller_SadadReportVerify);
            this.takeScreenShot();
            switchBacktoParentwindow();
            test.log(Status.PASS,"#FUNC-Verify Sadad Payments Report " + driver.getTitle() +" * Sadad Payments Report  is PASS * " );
          	Log.ReportEvent("PASS", " Verify Sadad Payment Transaction  Generate Report is Suceessful");
            this.takeScreenShot();
            }

        catch(Exception e){
       	 test.log(Status.FAIL,"#FUNC-Sadad Payments Report  Report " + driver.getTitle() +" * Sadad Payments Report  is FAIL * " );
       	 this.takeScreenShot();
    }
	 }
	 //Function Summary  : Method to Select Client type. 
	 //Parameter Summary : ClientName.
	public void SelectClient(String client) throws InterruptedException {
		
		WebClick(EdaatOR.Biller_ClientName);
		Thread.sleep(1000);
		WebClickUsingActions(EdaatOR.Biller_SelectClientName+"["+client+"]");
		//WebClick(EdaatOR.Biller_SelectClientName);
	}
	//Function Summary  : Method to Generate Client account Statement Report.  
		//Parameter Summary : Invoice Contract,FromYear,FromMonth,ToYear,ToMonth,ToDate.
		public void ClientAccountStatementReportUI(Map<Object, Object> testdatamap)
		{
			try{
				navigatetoclientAccountStatement();
				String ClientType=testdatamap.get("Client").toString();
				if(ClientType.equals("Valid")) {
				ClientType(testdatamap);
				Thread.sleep(1000);
				SelectClient(testdatamap.get("ClientName").toString());
				}
				WebClick(EdaatOR.Biller_SelectSubbillertype);
				Thread.sleep(1000);	
				WebSelect(EdaatOR.Biller_SubbillerTypeindvidutial, testdatamap.get("SubBiller").toString());    
			    Thread.sleep(2000);
			    //WebClickUsingActions(EdaatOR.Biller_SelectSubbillerName);
			    //Thread.sleep(2000);
		      // WebClick("//li[text()='"+(testdatamap.get("SubbillerName").toString())+"']");
			//	WebEdit(EdaatOR.Biller_Invoicecontract,testdatamap.get("Invoice Contract").toString());
		       String Date = testdatamap.get("ValidDate").toString();
		       if(Date.equalsIgnoreCase("Valid")){
				WebClick(EdaatOR.Biller_ReportFromdate);
				Thread.sleep(1000);
		        selectDropdownValue_PartialText(EdaatOR.Biller_reportFromYear,testdatamap.get("FromYear").toString());
		    	Thread.sleep(1000);
		        selectDropdownValue_PartialText(EdaatOR.Biller_reportFromMonth,testdatamap.get("FromMonth").toString());
		    	Thread.sleep(1000);
		        WebClick("//a[text()='"+testdatamap.get("FromDate").toString()+"']");
		    	Thread.sleep(1000);
		        WebClick(EdaatOR.Biller_ReportTodate);
		    	Thread.sleep(1000);
		        selectDropdownValue_PartialText(EdaatOR.Biller_reportToyear,testdatamap.get("ToYear").toString());
		    	Thread.sleep(1000);
		        selectDropdownValue_PartialText(EdaatOR.Biller_reportToMonth,testdatamap.get("ToMonth").toString());
		    	Thread.sleep(1000);
		        WebClick("//a[text()='"+testdatamap.get("ToDate").toString()+"']");	
		    	Thread.sleep(1000);
		       }
		        WebClickUsingJS(EdaatOR.Biller_reportsearchbutton);
		        Thread.sleep(2000);
		       
		        }
			catch(Exception e){
		test.log(Status.FAIL,"#FUNC-Generate Report and export" + driver.getTitle() +" * Generate Report and export FAIL * " );
		this.takeScreenShot();
			}
		}
		
		     //Function Summary   : Method to Verify Client Account Statement Report ErrorMsg
		   //Parameter Summary  : Expected.
			public void ClientAccountStatementErrorMsgValidation(Map<Object, Object> testdatamap) {
				try
				{
					ClientAccountStatementReportUI(testdatamap);
					String Expected=testdatamap.get("ExpectedResult").toString();
					if(ExistsCheck(EdaatOR.Biller_Reports_Receiv_ClientAccStm_ClientTypeError))
					{
						VerifyValue1(getText(EdaatOR.Biller_Reports_Receiv_ClientAccStm_ClientTypeError), testdatamap.get("ExpectedResult").toString());
						test.log(Status.PASS, "#FUNC-This Field Is Required ErrorMessage Exists" + driver.getTitle() + " * This Field Is Required ErrorMessage Exists * ");
					}
					else if (ExistsCheck(EdaatOR.Biller_Reports_Receiv_ClientAccStm_ClientError)) {
					    VerifyValue1(getText(EdaatOR.Biller_Reports_Receiv_ClientAccStm_ClientError), testdatamap.get("ExpectedResult").toString());
						test.log(Status.PASS, "#FUNC-This Field Is Required ErrorMessage Exists" + driver.getTitle() + " *This Field Is Required ErrorMessage Exists * ");
					}
					else if (ExistsCheck(EdaatOR.Biller_Reports_Receiv_ClientAccStm_FromDateError)) {
					    VerifyValue1(getText(EdaatOR.Biller_Reports_Receiv_ClientAccStm_FromDateError), testdatamap.get("ExpectedResult").toString());
						test.log(Status.PASS, "#FUNC-This Field Is Required ErrorMessage Exists" + driver.getTitle() + " *This Field Is Required ErrorMessage Exists * ");
					}
		            else {
		            	test.log(Status.FAIL, "#FUNC-Element Not Exists" + driver.getTitle() + " * Element Not Exists * ");
		            }
				}
				catch (Exception e) {
					test.log(Status.FAIL,"#FUNC-Receivable Reports Client Account Stataement Fail" + driver.getTitle() +" * Receivable Reports Client Account Stataement FAIL * " );
					this.takeScreenShot();
				}
		 }
	 }
	 

