package com.azmqalabs.edaattestautomation.apppages.biller.pages;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.azmqalabs.edaattestautomation.apppages.masterpages.BasePage;
import com.azmqalabs.edaattestautomation.common.uielement.fieldDecorator;
import com.azmqalabs.edaattestautomation.objectrepository.EdaatOR;

import junit.framework.Assert;

import com.azmqalabs.edaattestautomation.common.Log;


public class BillerReportsCustomReconciliationReportPage extends BasePage
{

	public BillerReportsCustomReconciliationReportPage(WebDriver driver,ExtentTest test)
	{
		 this.driver=driver;
		 this.test=test;
		 
		 PageFactory.initElements(new fieldDecorator(driver,test), this);
	}  
	

	@FindBy(xpath = EdaatOR.Biller_CustomReconciliationReport)
	public WebElement CustomReconciliationReportPage;
		
	    
	    public boolean Exists(){
	    	return super.Exists(CustomReconciliationReportPage); 
		}
	    
	   //Function Summary  : Method to Navigate Custom reconciliation Report page.  
	  		//Parameter Summary : NA
	  		public void navigateToCustomReconciliationReportPage(Log Log)throws InterruptedException
	  		{
	  			try{
	  			WebClickUsingJS(EdaatOR.Biller_ReportMenu);
	  			Thread.sleep(1000);
	  			WebClickUsingJS(EdaatOR.Biller_ReceivablesReportsbtn);
	  			Thread.sleep(1000);
	  			WebClickUsingJS(EdaatOR.Biller_CustomReconciliationReport);
	  			Thread.sleep(1000);
	  			this.takeScreenShot();
	  			Log.ReportEvent("PASS", " Verify Custom Reconciliation Report is Suceessful");
	  			}
	  			catch (Exception e) {
	  				test.log(Status.FAIL,"Navigate to Custom Reconciliation Report Page is FAIL" );
	  				this.takeScreenShot();
	  			}
	  		} 
	  		public void verifySearchButton(Map<Object, Object> testdatamap, Log log) {
				try {
					
					WebClick(EdaatOR.Biller_CustomReconciliationReport_FromDateField);
					selectDropdownValue_PartialText(EdaatOR.Biller_CustomReconciliationReport_FromYearField,
							testdatamap.get("FromYear").toString());
					selectDropdownValue_PartialText(EdaatOR.Biller_CustomReconciliationReport_FromMonthField,
							testdatamap.get("FromMonth").toString());
					WebClickUsingJS("//a[text()='" + testdatamap.get("FromDate") + "']");
					
					WebClick(EdaatOR.Biller_CustomReconciliationReport_ToDateField);
					selectDropdownValue_PartialText(EdaatOR.Biller_CustomReconciliationReport_ToYearField,
							testdatamap.get("ToYear").toString());
					selectDropdownValue_PartialText(EdaatOR.Biller_CustomReconciliationReport_ToMonthField,
							testdatamap.get("ToMonth").toString());
					WebClickUsingJS("//a[text()='" + testdatamap.get("ToDate") + "']");
					WebClick(EdaatOR.Biller_CustomReconciliationReport_SearchButon);
					this.takeScreenShot();
					test.log(Status.PASS, "Verify that the search button is clickable");
					log.ReportEvent("PASS", "Verify that the search button is clickable pass");
				} catch (Exception e) {
					test.log(Status.FAIL, "Verify that the search button is clickable fail");
					this.takeScreenShot();
				}
	  		}
	    
		public void verifyDefaultFieldsAreChecked(Log Log) throws Exception {
			try {
				WebElement invoiceAmount = driver
						.findElement(By.xpath(EdaatOR.Biller_CustomReconciliationReport_InvoiceAmountField));
				WebElement billNumber = driver
						.findElement(By.xpath(EdaatOR.Biller_CustomReconciliationReport_BillNumberField));
				WebElement paidAmount = driver
						.findElement(By.xpath(EdaatOR.Biller_CustomReconciliationReport_PaidAmountField));
				WebElement contractNumber = driver
						.findElement(By.xpath(EdaatOR.Biller_CustomReconciliationReport_ContractNumberField));
				if (invoiceAmount.isSelected() && billNumber.isSelected() && paidAmount.isSelected()
						&& contractNumber.isSelected() ) {
					System.out.println("Default Checkbox are checked");
					test.log(Status.PASS, "Verify default fields are checked");
					Log.ReportEvent("PASS", "Verify default fields are checked pass");
				}
				 else {
					    System.out.println("Default Checkbox are not checked");
						test.log(Status.FAIL, "Verify default fields are checked");
						Log.ReportEvent("FAIL", "Default fields are checked fail");
			            this.takeScreenShot();
			        }
			} 
			catch (Exception e) {
				test.log(Status.FAIL, "Verify default fields are checked fail");
				this.takeScreenShot();
			}
		}
//Function Summary   : Method to Verify SubBiller Check Boxes in Custom Reconciliation Report
	    //Parameter Summary  : N/A
		
		public void VerifySubBillerCheckBoxesInCustomReconciliationReport(Log Log)
		{
			try {
				scrollDowntillend(driver);
				verifyElementIsNotPresent(EdaatOR.Biller_CustomReconciliationReport_SubBillerName_CheckBx);
				Thread.sleep(1000);
				verifyElementIsNotPresent(EdaatOR.Biller_CustomReconciliationReport_TransferFees_SubBiller_CheckBx);
				Thread.sleep(1000);
				verifyElementIsNotPresent(EdaatOR.Biller_CustomReconciliationReport_SubBillerShare_CheckBx);
				Thread.sleep(1000);
			    test.log(Status.PASS,"#FUNC- Verify SubBiller Check Boxes in Custom Reconciliation Report" + driver.getTitle()+ " * Verify SubBiller Check Boxes in Custom Reconciliation Report PASS * " );
		    	Log.ReportEvent("PASS", " Verify SubBiller Check Boxes in Custom Reconciliation Report ");
			  }
	       catch (Exception e) {
			test.log(Status.FAIL, "Verify SubBiller Check Boxes in Custom Reconciliation Report fail");
			this.takeScreenShot();
		}
	}
	//Function Summary  : Method to click on 'Select All' checkbox
		//Parameter Summary : N/A	
		public void clickOnSelectAllCheckbox() throws InterruptedException
		{
			WebClick(EdaatOR.Admin_RecievableReports_selectAll_checkbox);
	    	Thread.sleep(2000);
			
		}

		//Function Summary   : Method to select from date and To date
		//Parameter Summary  : FromYear, FromMonth,ToYear,ToMonth.
		public void SelectDate(Map<Object,Object> testdatamap) throws InterruptedException
		{
			try {
                Thread.sleep(2000);
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
				test.log(Status.FAIL,"#FUNC-Select Date FAIL" + driver.getTitle() +" *Select Date FAIL * " );
				this.takeScreenShot();
			}
		}
				
				
		//Function Summary   : Method to select payment method
		//Parameter Summary  : paymentMethod.
		public void SelectPaymentMethod(Map<Object,Object> testdatamap) throws InterruptedException
		{
			try {
                    Thread.sleep(1000);
                    WebClick(EdaatOR.Admin_customReconcillation_PaymentMethod);
                    Thread.sleep(1000);
                    WebClick("//li[text()='"+testdatamap.get("PaymentMethod").toString()+"']");
			    	Thread.sleep(1000);
 
 
			  }		catch(Exception e){
				test.log(Status.FAIL,"#FUNC-Select payment method FAIL" + driver.getTitle() +" *Select Payment Method FAIL * " );
				this.takeScreenShot();
			}
		}
	//Function Summary  : Method to click on Export to Excel link
				//Parameter Summary : N/A	
				public void clickOnExportToExcelLink() throws InterruptedException
				{
					WebClick(EdaatOR.Admin_customReconcillation_ExportToExcelLink);
			    	Thread.sleep(1000);
					
				}
				
		//Function Summary  : Method to click on search button
		//Parameter Summary : N/A	
		public void clickOnSearchButton() throws InterruptedException
		{
			WebClick(EdaatOR.Admin_Button);
	    	Thread.sleep(2000);
			
		}
			//Function Summary   : Method to validate Export To Excel Functionality			
				public void validateExportToExcelFunctionality(Map<Object,Object> testdatamap,Log Log) throws InterruptedException
				{
					try {
						
						SelectDate(testdatamap);
						SelectPaymentMethod(testdatamap);
						Thread.sleep(1000);
						clickOnSearchButton();
						Thread.sleep(2000);
						WebElement element=driver.findElement(By.xpath(EdaatOR.Admin_customReconcillation_ExportToExcelLink));
						scrollToElement(driver, element);
						Thread.sleep(1000);
						clickOnExportToExcelLink();
						Thread.sleep(2000);
						verifyElementIsPresent(EdaatOR.Admin_customReconcillation_ExportedToExcelConMessage);
						Thread.sleep(500);
						this.takeScreenShot();
						test.log(Status.PASS,"#FUNC-validate Export To Excel Functionality" + driver.getTitle() +" *Export to Excel PASS * " );
						Log.ReportEvent("PASS", " validate Export To Excel Functionality is sucessfull");

					  }		catch(Exception e){
						  
						test.log(Status.FAIL,"#FUNC-validate Export To Excel Functionality " + driver.getTitle() +" *Export to Excel FAIL * " );
						this.takeScreenShot();
					}
				}

			//Function Summary   : Method to Verify The Report To Retrieved Data Without Select PaymentMethod
		//Parameter Summary  : N/A
		public void VerifyTheReportToRetrievedDataWithoutSelectPaymentMethod(Map<Object,Object> testdatamap,Log Log)
		{
			try {
				 SelectDate(testdatamap);
	             Thread.sleep(2000);
	             clickOnSearchButton();
	             Thread.sleep(2000);
				 VerifyValue1(getText(EdaatOR.Biller_CustomReconciliationReport_BillNo),testdatamap.get("BillNumber").toString());
	             Thread.sleep(2000);
				 VerifyValue1(getText(EdaatOR.Biller_CustomReconciliationReport_CRNo),testdatamap.get("CRNumber").toString());
	             Thread.sleep(2000);
				 VerifyValue1(getText(EdaatOR.Biller_CustomReconciliationReport_InvoicrAmt),testdatamap.get("InvoiceAmount").toString());
	             Thread.sleep(2000);
				 VerifyValue1(getText(EdaatOR.Biller_CustomReconciliationReport_PaidAmt),testdatamap.get("PaidAmount").toString());
				 test.log(Status.PASS,"#FUNC- Verify SubBiller Check Boxes in Custom Reconciliation Report" + driver.getTitle()+ " * Verify SubBiller Check Boxes in Custom Reconciliation Report PASS * " );
			     Log.ReportEvent("PASS", " Verify SubBiller Check Boxes in Custom Reconciliation Report ");
			}
			catch(Exception e){
				test.log(Status.FAIL,"#FUNC-Select Date FAIL" + driver.getTitle() +" *Select Date FAIL * " );
				this.takeScreenShot();
			}
			}
		
		 //Function Summary   : Method to verifyAvailablePaymentMethodAssignedToBillerAccount
	   	 //Parameter Summary  : PaymentMethod1,PaymentMethod2,PaymentMethod3,PaymentMethod4
		public void verifyAvailablePaymentMethodAssignedToBillerAccount(Map<Object, Object> testdatamap,Log Log) {
			try {
				 WebClick(EdaatOR.Admin_customReconcillation_PaymentMethod);
				 this.takeScreenShot();
				 List<WebElement> paymentMethodValues = getElements(EdaatOR.Admin_customReconcillation_PaymentMethodValues);
				 String [] expectedPaymentText= {testdatamap.get("PaymentMethod1").toString(),
				 testdatamap.get("PaymentMethod2").toString(),testdatamap.get("PaymentMethod3").toString()
				 ,testdatamap.get("PaymentMethod4").toString()};
				for(int i=0;i<paymentMethodValues.size();i++) {
					String actualPaymentText = paymentMethodValues.get(i).getText();
					if (actualPaymentText.equals(expectedPaymentText[i])) {
						test.log(Status.PASS, "verify that the Payment Method appears depends on the payment method checked in the biller account Functionality is successfull"+ driver.getTitle() +"verify that the Payment Method appears depends on the payment method checked in the biller account Functionality is successfull PASS");
						this.takeScreenShot();
						Log.ReportEvent("PASS", "verify that the Payment Method appears depends on the payment method checked in the biller account Functionality is successfull");
					}
					else
					{
						test.log(Status.FAIL, "verify that the Payment Method appears depends on the payment method checked in the biller account Functionality is Unsuccessfull"+ driver.getTitle() +"verify that the Payment Method appears depends on the payment method checked in the biller account Functionality is Unsuccessfull FAIL");
					}
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				test.log(Status.FAIL, "verify that the Payment Method appears depends on the payment method checked in the biller account Functionality is Unsuccessfull"+ driver.getTitle() +"verify that the Payment Method appears depends on the payment method checked in the biller account Functionality is Unsuccessfull FAIL");
			}
			
		}

		//Function Summary  : Method to verifyToObserveTheRetrievedData
		//Parameter Summary : BillerName
		public void verifyToObserveTheRetrievedData(Map<Object, Object> testdatamap, Log Log) throws InterruptedException, IOException {
			try {
			SelectDate(testdatamap);
			SelectPaymentMethod(testdatamap);
			clickOnSelectAllCheckbox();
			clickOnSearchButton();
			this.takeScreenShot();
			VerifyValue1(getText(EdaatOR.Admin_customReconcillation_BillerName),testdatamap.get("BillerName").toString());
			this.takeScreenShot();
			test.log(Status.PASS, "Verify the fields name Functionality is successfull"+ driver.getTitle() +"Verify the fields name Functionality is successfull PASS");
			this.takeScreenShot();
			Log.ReportEvent("PASS", "Verify the fields name Functionality is successfull");
			}
			catch (Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, "Verify the fields name Functionality is Unsuccessfull"+ driver.getTitle() +"Verify the fields name Functionality is Unsuccessfull FAIL");
			}
		}
		//Function Summary  : Method to Verify the pagination in the report
		//Parameter Summary : N/A	
		public void verifyPaginationInTheReport(Map<Object,Object> testdatamap,Log Log) {
			try {
				SelectDate(testdatamap);
				SelectPaymentMethod(testdatamap);
				clickOnSelectAllCheckbox();
				clickOnSearchButton();
                Thread.sleep(1000);
                verifyElementIsPresent(EdaatOR.Admin_RecievableReports_pagination_dropdown);
				WebClick(EdaatOR.Admin_RecievableReports_pagination_dropdown);
                Thread.sleep(1000);
		    	List<WebElement> options=getElements(EdaatOR.Admin_RecievableReports_pagination_options);
		    	if(options.size()==4) {	    	
		    		for (Object option:options){
		    			CheckElementExists(option.toString());
 
		    	}
	    	    	this.takeScreenShot();
	    			test.log(Status.PASS,"#FUNC-Verify the pagination in the report" + driver.getTitle() +" * Verify the pagination in the report is successfull PASS * " );
	            	Log.ReportEvent("PASS", " Verify the pagination in the report is Successful");
 
		    		}
	    		else {
	    			test.log(Status.FAIL,"Verify the pagination in the report" + driver.getTitle() +" * Verify the pagination in the report is unsuccessfull FAIL * " );
	    		}
			}
			catch (Exception e) {
				test.log(Status.FAIL,"Verify the pagination in the report" + driver.getTitle() +" *Verify the pagination in the report is unsuccessfull FAIL * " );
			}
					
		}
		//Function Summary   : Method to validate Search Button Is clickable Functionality			
				public void validateSearchButtonIsClickableFunctionality(Map<Object,Object> testdatamap,Log Log) throws InterruptedException
				{
					try {
						
						SelectDate(testdatamap);
						Thread.sleep(800);
						SelectPaymentMethod(testdatamap);
						Thread.sleep(800);
						clickOnSearchButton();
						Thread.sleep(800);
						WebElement element=driver.findElement(By.xpath(EdaatOR.Admin_customReconcillation_ExportToExcelLink));
						scrollToElement(driver, element);
						this.takeScreenShot();
						Thread.sleep(1000);			
						verifyElementIsPresent(EdaatOR.Biller_Rece_Reports_Custom_Rec_Report);
						Thread.sleep(500);
						this.takeScreenShot();
						test.log(Status.PASS,"#FUNC-verify Search button is clickable " + driver.getTitle() +" *Search button clickable PASS * " );
						Log.ReportEvent("PASS", "verify Search button is clickable is sucessfull");

					  }		catch(Exception e){
						  
						test.log(Status.FAIL,"#FUNC-verify Search button is clickable " + driver.getTitle() +" *Search button clickable FAIL * " );
						this.takeScreenShot();
					}
				}
				//Function Summary   : Method to validate CheckingAndUnchecking Reports checkbox Changes In GridData		
				public void validateCheckingAndUncheckingReportsCheckboxChangesInGridData(Map<Object,Object> testdatamap,Log Log) throws InterruptedException
				{
					try {
						
						SelectDate(testdatamap);
						Thread.sleep(900);
						SelectPaymentMethod(testdatamap);
						Thread.sleep(900);
						clickOnReportsFieldsCheckbox(testdatamap);
						Thread.sleep(900);
						clickOnSearchButton();					
						Thread.sleep(2000);	
						WebElement element=driver.findElement(By.xpath(EdaatOR.Admin_customReconcillation_ExportToExcelLink));
						scrollToElement(driver, element);
						this.takeScreenShot();
						Thread.sleep(900);	
						verifyElementIsPresent(EdaatOR.Biller_Rece_Cus_Rec_Reports_BillerName_GridColumn);
						Thread.sleep(1000);
						clickOnReportsFieldsCheckbox(testdatamap);						
						Thread.sleep(900);
						clickOnSearchButton();			
						Thread.sleep(2000);
						WebElement element1=driver.findElement(By.xpath(EdaatOR.Admin_customReconcillation_ExportToExcelLink));
						scrollToElement(driver, element1);
						this.takeScreenShot();
						Thread.sleep(900);
						verifyElementIsNotPresent(EdaatOR.Biller_Rece_Cus_Rec_Reports_BillerName_GridColumn);
						Thread.sleep(1000);
						this.takeScreenShot();
						test.log(Status.PASS,"#FUNC-validate CheckingAndUnchecking Reports checkbox Changes In GridData " + driver.getTitle() +" *validate CheckingAndUnchecking Reports Fields PASS * " );
						Log.ReportEvent("PASS", "validate CheckingAndUnchecking Reports checkbox Changes In GridData is sucessfull");

					  }		catch(Exception e){
						  
						test.log(Status.FAIL,"#FUNC-validate CheckingAndUnchecking Reports checkbox Changes In GridData " + driver.getTitle() +" *validate CheckingAndUnchecking Reports Fields FAIL * " );
						this.takeScreenShot();
					}
				}
				//Function Summary  : Method to click On Reports Fields Checkbox
				//Parameter Summary : N/A	
				public void clickOnReportsFieldsCheckbox(Map<Object,Object> testdatamap) throws InterruptedException
				{
                    WebClickUsingJS("//label[text()='"+testdatamap.get("ReportFieldsCheckboxes").toString()+"']");
			    	Thread.sleep(1000);
			    	this.takeScreenShot();
			    	
				}


	  
}

	 

