/**
* Test Script Name  				 : N/A
* Objective                          : Verify incoming bills Functionality.
* Version      						 : 1.0
* Author       						 : Kathirvelu Mohan
* Created Date 			      		 : 15/08/2023
* Last Updated on					 : N/A
* Updated By   			 			 : 
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

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.azmqalabs.edaattestautomation.apppages.GlobalConstant;
import com.azmqalabs.edaattestautomation.apppages.masterpages.BasePage;
import com.azmqalabs.edaattestautomation.common.uielement.fieldDecorator;
import com.azmqalabs.edaattestautomation.objectrepository.EdaatOR;
import com.azmqalabs.edaattestautomation.common.Log;



public class BillerPayablesPage extends BasePage
{

	public BillerPayablesPage(WebDriver driver,ExtentTest test)
	{
		 this.driver=driver;
		 this.test=test;
		 
		 PageFactory.initElements(new fieldDecorator(driver,test), this);
	}  
	

	@FindBy(xpath = EdaatOR.Biller_Incomingbills)
	public WebElement IncomingBills;
		
	    
	    public boolean Exists(){
	    	return super.Exists(IncomingBills); 
		}
	   public void navigate(Log Log) throws InterruptedException
	    {
	    	WebClick(EdaatOR.Biller_Payables);
	        Thread.sleep(1000);
	        WebClick(EdaatOR.Biller_IncomingbillsBtn);
	        Thread.sleep(2000);
	       	Log.ReportEvent("PASS", " Navigation to incoming bill is Suceessfull");

	    }
	  //Function Summary : Method to Search IncomingBills. 
	//Parameter Summary: BillNumber,ContractNumber,Status,ToYear.

		public void IncomingBillsSearch(Map<Object, Object> testdatamap,Log Log) {
			// TODO Auto-generated method stub
			try {	
				navigate(Log);
		        WebEdit(EdaatOR.Biller_BillNumber,testdatamap.get("BillNumber").toString());
		       // WebEdit(EdaatOR.Biller_BillerName,testdatamap.get("BillName").toString());
		      //WebClick(EdaatOR.Biller_Status);
		      //selectDropdownValue_PartialText(EdaatOR.Biller_Status,testdatamap.get("Status").toString());
		        WebEdit(EdaatOR.Biller_ContractNo,testdatamap.get("ContractNumber").toString());
		        WebClick(EdaatOR.Biller_Searchbtn);
		        Thread.sleep(3000);
		        verifyElementIsPresent(EdaatOR.Biller_Incomingbills);
		        verifyElementIsPresent(EdaatOR.Biller_BillsGrid);
		        VerifyValue1(getText(EdaatOR.Biller_BillsVerify),testdatamap.get("BillNumber").toString());
		        
	        	this.takeScreenShot();
				test.log(Status.PASS,"#FUNC-Search IncomingBills is successful" + driver.getTitle() +" * Payables PASS * " );	
		       	Log.ReportEvent("PASS", " Verify View Individual Client Invoice is Suceessfull");
			}
			catch(Exception e){
				test.log(Status.FAIL,"#FUNC-Search IncomingBills is Failed" + driver.getTitle() +" * Payables FAIL * " );
				this.takeScreenShot();
			}	
		}
		//Function Summary : Method to validate payment method column in grid. 
		//Parameter Summary: PaymentMethod

		public void validatePaymentMethodInGrid(Map<Object, Object> testdatamap,Log Log) {
			try {	
		        Thread.sleep(2000);
				verifyElementIsPresent("(//tr//td[text()='"+testdatamap.get("PaymentMethod").toString()+"'])[1]");
				this.takeScreenShot();
				test.log(Status.PASS,"#FUNC-validate payment method column in grid is successful" + driver.getTitle() +" * PASS * " );	
				Log.ReportEvent("PASS", " validate payment method column in grid is Suceessfull");
			}
			catch(Exception e){
				test.log(Status.FAIL,"#FUNC-validate payment method column in grid is Failed" + driver.getTitle() +" * FAIL * " );
				this.takeScreenShot();
			}

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
		//Function Summary : Method to search payment method 
		//Parameter Summary: PaymentMethod

		public void searchPaymentMethod(Map<Object, Object> testdatamap,Log Log) {
			try {	
				selectPaymentMethod(testdatamap);
				clickOnSearchButton();
				validatePaymentMethodInGrid(testdatamap,Log);
				this.takeScreenShot();
				test.log(Status.PASS,"#FUNC- Verify that they can search by payment method is successful" + driver.getTitle() +" * PASS * " );	
				Log.ReportEvent("PASS", "  Verify that they can search by payment method is Suceessfull");
			}
			catch(Exception e){
				test.log(Status.FAIL,"#FUNC- Verify that they can search by payment method is Failed" + driver.getTitle() +" * FAIL * " );
				this.takeScreenShot();
			}
		}
		//Function Summary   : Method to verifyPaymentMethodsAppearAfterClickingOnBillNumebr 
		//Parameter Summary  : BillNumber
		public void verifyPaymentMethodsAppearAfterClickingOnBillNumebr(Map<Object, Object> testdatamap,Log Log) throws Exception {
			try {
				navigate(Log);
			    WebEdit(EdaatOR.Biller_BillNumber,testdatamap.get("BillNumber").toString());
			    WebClick(EdaatOR.Biller_Searchbtn);
			    WebClickUsingJS("//span[text()='"+testdatamap.get("BillNumber").toString()+"']");
				this.takeScreenShot();
				switchToWindow();
				WebElement element1 = driver.findElement(By.xpath(EdaatOR.Biller_Incomingbills_PaymentMethod_Sadad));
				scrollToElement(driver, element1);
				verifyElementIsPresent(EdaatOR.Biller_Incomingbills_PaymentMethod_Sadad);
				verifyElementIsPresent(EdaatOR.Biller_Incomingbills_PaymentMethod_Mada);
				verifyElementIsPresent(EdaatOR.Biller_Incomingbills_PaymentMethod_Visa);
				verifyElementIsPresent(EdaatOR.Biller_Incomingbills_PaymentMethod_MasterCard);
				this.takeScreenShot();
		       	Log.ReportEvent("PASS", " Verify that the available payment method appears when clicking on bill number -contract number is Suceessfull");
				test.log(Status.PASS,"#FUNC-Verify that the available payment method appears when clicking on bill number -contract number is Suceessfull" + driver.getTitle() +" * Verify that the available payment method appears when clicking on bill number -contract number is Suceessfull PASS * " );					
			} catch (Exception e) {
				e.printStackTrace();
				test.log(Status.FAIL,"#FUNC-Verify that the available payment method appears when clicking on bill number -contract number is Unsuceessfull" + driver.getTitle() +" * Verify that the available payment method appears when clicking on bill number -contract number is Unsuceessfull FAIL * " );
				this.takeScreenShot();
			}	
		}
		public void clickOnPayButton()
		{
			  WebClick(EdaatOR.Biller_Payables_IncomingBills_PayBtn);
		}
		public void selectPaymentMethodVisa()
		{
			  WebClickUsingJS(EdaatOR.Biller_Payables_IncomingBills_Paymentmethod_Visa);
		}
		public void selectPaymentMethodSadad()
		{
			  WebClick(EdaatOR.Biller_Payables_IncomingBills_Paymentmethod_Sadad);
		}
		public void finalPayInSadad()
		{
			  WebClick(EdaatOR.Biller_Payables_PayBtn_Sadad);
		}
		public void clickOnPayNowButton()
		{
			  WebClick(EdaatOR.Biller_Payables_PayNowbtn);
		}
		public void clickOnInvoicePayNowButton()
		{
			  WebClick(EdaatOR.Biller_Payables_InvoicePayNowBtn);
		}
		public void clickOnFinalPayButton() throws InterruptedException
		{
			  WebClickUsingJS(EdaatOR.Biller_Payables_FinalPayBtn);
			  Thread.sleep(4000);
		}
		public void clickOnFinishButton()
		{
			  WebClick(EdaatOR.Biller_Payables_FinishBtn);
		}
		
		//Function Summary : Method to verifyPaymentMethodSearchField 
		//Parameter Summary : N/A
		public void verifyPaymentMethodSearchField(Log Log) throws Exception {
			try {
				navigate(Log);
				this.takeScreenShot();
				verifyElementIsPresent(EdaatOR.Biller_Incomingbills_PaymentMethod);
				this.takeScreenShot();
		       	Log.ReportEvent("PASS", " Verify the new Payment Method Search Field is Suceessfull");
				test.log(Status.PASS,"#FUNC-Verify the new Payment Method Search Field is Suceessfull" + driver.getTitle() +" * Verify the new Payment Method Search Field is Suceessfull PASS * " );	
				
			} catch (Exception e) {
				e.printStackTrace();
				test.log(Status.FAIL,"#FUNC-Verify the new Payment Method Search Field is Unsuceessfull" + driver.getTitle() +" * Verify the new Payment Method Search Field is Unsuceessfull FAIL * " );
				this.takeScreenShot();
			}	
		}
		  //Function Summary : Method to verifyPayablesIncomingBillsPrintInvoice. 
		  //Parameter Summary: BillerName
			public void verifyPayablesIncomingBillsPrintInvoice(Map<Object, Object> testdatamap,Log Log) {
				// TODO Auto-generated method stub
				try {	
					navigate(Log);
					WebClickUsingJS("//table//tbody//td[text()='"+testdatamap.get("BillerName").toString()+"']/parent::tr//a[contains(@href,'IncomingBill')]");
			        Thread.sleep(1000);
			        switchToWindow();
			        verifyElementIsPresent(EdaatOR.Biller_Incomingbills_PaymentMethod_Type);
			        WebClick(EdaatOR.Biller_Incomingbills_PrintButton);			        
		        	this.takeScreenShot(); 
					test.log(Status.PASS,"#FUNC-verify payables incoming bills print invoice is successful" + driver.getTitle() +" * verify payables incoming bills print invoice is successful PASS * " );	
			       	Log.ReportEvent("PASS", "verify payables incoming bills print invoice is Suceessfull");
				}
				catch(Exception e){
					e.printStackTrace();
					test.log(Status.FAIL,"#FUNC-verify payables incoming bills print invoice is Unsuccessful" + driver.getTitle() +" * verify payables incoming bills print invoice is Unsuccessful FAIL * " );
					this.takeScreenShot();
				}	
			}
			 //Function Summary : Method to validate Multi-pay Payment Method Status In Incoming Bills. 
		//Parameter Summary: DueAmount,CardNumber,ExpireDate,CVV,CardHolderNumber

			public void validateMultiPaymentMethodStatusInIncomingBills(Map<Object, Object> testdatamap,Log Log) {
				
				try {	
					navigate(Log);
					Thread.sleep(800);
					WebEdit(EdaatOR.Biller_ContractNo,testdatamap.get("ContractNumber").toString());					
					Thread.sleep(500);
					WebClick(EdaatOR.Biller_Searchbtn);
					Thread.sleep(500);
//					clickOnPayButton();
//					Thread.sleep(500);
//					selectPaymentMethodVisa();
//					Thread.sleep(500);
//					WebClearandEdit(EdaatOR.Biller_Payables_EnterDueAmount,testdatamap.get("DueAmount").toString());
//					Thread.sleep(500);
//					clickOnPayNowButton();
//					Thread.sleep(1000);					
//					swithchToFrame(EdaatOR.Admin_Corporate_Report);
//					WebEdit(EdaatOR.Biller_Payables_EnterCardNumber,testdatamap.get("CardNumber").toString());
//					Thread.sleep(500);	
//					switchBacktoParentwindow();
//					Thread.sleep(500);
//					swithchToFrame(EdaatOR.Biller_SwitchToFrame);
//					Thread.sleep(500);
//					WebEdit(EdaatOR.Biller_Payables_EnterCvvNumber,testdatamap.get("CVV").toString());
//					Thread.sleep(500);
//					switchBacktoParentwindow();
//					Thread.sleep(500);
//					WebEdit(EdaatOR.Biller_Payables_EnterExpireDate,testdatamap.get("ExpireDate").toString());					
//					Thread.sleep(500);
//					WebEdit(EdaatOR.Biller_Payables_EnterCardHolderName,testdatamap.get("CardHolderNumber").toString());
//					Thread.sleep(500);
//					clickOnInvoicePayNowButton();
//					Thread.sleep(2000);					
//					swithchToFrame(EdaatOR.Admin_Corporate_Report);
//					Thread.sleep(4000);
//					driver.findElement(By.xpath(EdaatOR.Biller_Payables_FinalPayBtn)).click();
////					clickOnFinalPayButton();				
//					Thread.sleep(500);
////					switchBacktoParentwindow();
//					Thread.sleep(500);
//					clickOnFinishButton();
//					navigate();
//					clickOnPayButton();
//					Thread.sleep(500);
//					selectPaymentMethodSadad();
//					Thread.sleep(500);
//					finalPayInSadad();
				    verifyElementIsPresent(EdaatOR.Biller_Payables_PaymentMethodStatus_Multipay);
		        	this.takeScreenShot();
					test.log(Status.PASS,"#FUNC-Validate Multi-payment status in payment methods in Incoming Bills" + driver.getTitle() +" * Payables PASS * " );	
			       	Log.ReportEvent("PASS", " Validate Multi-payment status in payment methods in Incoming Bills is Suceessfull");
				}
				catch(Exception e){
					test.log(Status.FAIL,"#FUNC-Validate Multi-payment status in payment methods in Incoming Bills" + driver.getTitle() +" * Payables FAIL * " );
					this.takeScreenShot();
				}
			
		}

			
		//Function Summary : Method to Verify Hyper Pay Logo For Payment Methods. 
		//Parameter Summary: BillNumber
		public void VerifyHyperPayLogoForPaymentMethods(Map<Object, Object> testdatamap,Log Log) {
			try {	
				navigate(Log);
				WebEdit(EdaatOR.Biller_BillNumber,testdatamap.get("BillNumber").toString());
				WebClick(EdaatOR.Biller_Searchbtn);
		        Thread.sleep(3000);
				WebClick(EdaatOR.Biller_Payables_IncomingBills_PayButton);
				verifyElementIsPresent(EdaatOR.Biller_Payables_IncomingBills_SadadLogo);
			    verifyElementIsPresent(EdaatOR.Biller_Payables_IncomingBills_MadaLogo);
			    verifyElementIsPresent(EdaatOR.Biller_Payables_IncomingBills_VisaLogo);
			    verifyElementIsPresent(EdaatOR.Biller_Payables_IncomingBills_MasterCardLogo);
			    this.takeScreenShot();
				test.log(Status.PASS,"#FUNC-Verify Hyper Pay Logo For Payment Methods is successful" + driver.getTitle() +" * Verify Hyper Pay Logo For Payment Methods PASS * " );	
		       	Log.ReportEvent("PASS", " Verify Hyper Pay Logo For Payment Methods is Suceessfull");
			}
			catch(Exception e){
				test.log(Status.FAIL,"#FUNC-Verify Hyper Pay Logo For Payment Methods is Failed" + driver.getTitle() +" * Verify Hyper Pay Logo For Payment Methods FAIL * " );
				this.takeScreenShot();
			}
	}	
}

