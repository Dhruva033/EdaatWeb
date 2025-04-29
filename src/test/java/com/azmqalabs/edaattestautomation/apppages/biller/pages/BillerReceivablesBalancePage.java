/**
*
* Test Script Name                      : N/A.
* Objective                             : Balance details functionality.
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
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.interactions.touch.Scroll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.azmqalabs.edaattestautomation.apppages.GlobalConstant;
import com.azmqalabs.edaattestautomation.apppages.masterpages.BasePage;
import com.azmqalabs.edaattestautomation.common.Config;
import com.azmqalabs.edaattestautomation.common.uielement.fieldDecorator;
import com.azmqalabs.edaattestautomation.objectrepository.EdaatOR;
import com.azmqalabs.edaattestautomation.common.Log;



public class BillerReceivablesBalancePage extends BasePage
{

	public BillerReceivablesBalancePage(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;

		PageFactory.initElements(new fieldDecorator(driver,test), this);
	}  


	@FindBy(xpath = EdaatOR.Biller_Receivables_balance)
	public WebElement Balance;


	public boolean Exists(){
		return super.Exists(Balance); 
	}
	public void NavgateReceivable(Log Log)
	{
		WebClickUsingJS(EdaatOR.Biller_Rcv_balancelink);
		this.takeScreenShot();
		Log.ReportEvent("PASS", "Verify to Naviagte Balance details  is Suceessfull");
	}

//Function Summary:to perform search functionality.
//Function Summary:contract number.
	public void BalanceSearch(Map<Object, Object> testdatamap,Log Log) throws InterruptedException, IOException
	{
		SelectDate(testdatamap);
		Search(testdatamap, Log);
	}
	//Function Summary:Method to do Search.
//Function Summary:contract number.
	public void Search(Map<Object, Object> testdatamap,Log Log) throws InterruptedException, IOException
	{
		try {
			WebClear(EdaatOR.Biller_Rcv_balContract);
			WebEdit(EdaatOR.Biller_Rcv_balContract,testdatamap.get("contract number").toString());
			Thread.sleep(2000);		
			 WebClickUsingJS(EdaatOR.Biller_Rcv_balSearch);
			 Thread.sleep(2000);
			// JavascriptExecutor js = (JavascriptExecutor) driver;
		    //js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
			// js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
			 driver.findElement(By.xpath(EdaatOR.Biller_Rcv_balContract)).sendKeys(Keys.PAGE_DOWN);
			 Thread.sleep(2000);
	         VerifyValue1(getText(EdaatOR.Biller_Rcv_balverifyContract),testdatamap.get("contract number").toString());
			 Thread.sleep(2000);
 		     test.log(Status.PASS,"#FUNC-Search" + driver.getTitle() +" * Search is successfull Pass * ");
 			Log.ReportEvent("PASS", " Verify Search functionality is Suceessfull");
 			 this.takeScreenShot();	
		    }
	   catch(Exception e){
			test.log(Status.FAIL,"#FUNC-Search" + driver.getTitle() +" * Search is FAIL * " );
			this.takeScreenShot();
		} 
	   
	}
	//Function Summary   : Method to navigate on Balance details Page.
	//Parameter Summary :  N/A.
	public void naviagteBalanceDetails(Log Log) {
		WebClickUsingJS(EdaatOR.Biller_Receivable_Link);
		WebClickUsingJS(EdaatOR.Biller_BalanceDetailsPage);
		waitForPageToLoad();
		Log.ReportEvent("PASS", "Verify naviagted Suceessfull to Balance details Page");
	}
	
	//Function Summary   : Method to verify Veiw invoice details button is clickable.
	//Parameter Summary :  N/A
	public void verifyViewInvoiceBtn(Map<Object,Object> testdatamap,Log Log) throws Exception {
		try {
			
			WebClick(EdaatOR.Biller_BalanceDetailsViewBtn);
			waitForPageToLoad();
			switchToWindow();
			if(CheckElementExists(EdaatOR.Biller_InvoiceDetails)==true) {
				test.log(Status.PASS,"#FUNC-Invoice details button is Clickable" + driver.getTitle() +" * Invoice details button is Clickable PASS * " );
				Log.ReportEvent("PASS", " Verify Veiw invoice details button is clickable.");
			}else {
			
			test.log(Status.FAIL,"#FUNC-Invoice details button is not Clickable" + driver.getTitle() +" * Invoice details button is not Clickable FAIL* " );
			}
		}
		
			
		catch(Exception e){
			test.log(Status.FAIL,"#FUNC-Verify Invoice details  button" + driver.getTitle() +" * Invoice details button is not Clickable FAIL * " );
			this.takeScreenShot();
		}
	}
	//Function Summary:To select date from drop down.
//Function Summary:Fromyear,From month,Toyear,Tomonth,Fromdate and ToDate.
public void SelectDate(Map<Object, Object> testdatamap)
{
     try {
		Thread.sleep(5000);
    	WebClick(EdaatOR.Biller_Rcv_balFromd);
        Thread.sleep(2000);
		selectDropdownValue_PartialText(EdaatOR.Biller_Rcv_balFromyear,testdatamap.get("Fromyear").toString());
        Thread.sleep(2000);
        selectDropdownValue_PartialText(EdaatOR.Biller_Rcv_balFromon,testdatamap.get("From month").toString());
        Thread.sleep(2000);
        WebClick("//a[text()='"+testdatamap.get("Fromdate").toString()+"']");
        Thread.sleep(5000);
        WebClick(EdaatOR.Biller_Rcv_balTod);
        Thread.sleep(2000);
        selectDropdownValue_PartialText(EdaatOR.Biller_Rcv_balToyear,testdatamap.get("Toyear").toString());
        Thread.sleep(2000);
        selectDropdownValue_PartialText(EdaatOR.Biller_Rcv_balTomon,testdatamap.get("Tomonth").toString());
        Thread.sleep(2000);
        WebClick("//a[text()='"+testdatamap.get("ToDate").toString()+"']");
		test.log(Status.PASS,"#FUNC-SelectDate" + driver.getTitle() +" * SelectDate pass * " );
		this.takeScreenShot();

		}
		catch(Exception e){
			test.log(Status.FAIL,"#FUNC-SelectDate" + driver.getTitle() +" * Date is not selected FAIL * " );
			this.takeScreenShot();
		}
	}
		
	 //Function Summary : Method to ClickOnReceievablelink
	 //Parameter Summary: N/A
	public void ClickOnReceievablelink() {
		WebClickUsingJS(EdaatOR.Biller_Receivable_Link);
		waitForPageToLoad();	
		}
	//Function Summary : Method to ClickOnBillerBalancelink
	//Parameter Summary: N/A
	public void ClickOnBillerBalancelink() {
		WebClickUsingJS(EdaatOR.Biller_Balance_Link);
		waitForPageToLoad();
		}
	//Function Summary : Method to NavigateReceievableMyBalance
	//Parameter Summary: N/A
	public void NavigateReceievableMyBalance(Log Log) {
		
		ClickOnReceievablelink();
		ClickOnBillerBalancelink();
		Log.ReportEvent("PASS", "Navigate to Balance Details");
	}
	//Function Summary : Method to UpdateClientInfo
	//Parameter Summary: WalletName
	public void UpdateClientInfo(Map<Object, Object> testdatamap,Log Log){
		try
		{
			WebClick(EdaatOR.Biller_Update_btn);
			Thread.sleep(2000);
			WebClearandEdit(EdaatOR.Biller_Wallet_efield,testdatamap.get("WalletName").toString());
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Biller_Wallet_yesbtn);
			Thread.sleep(2000);
			this.takeScreenShot();
			VerifyValue1(getText(EdaatOR.Biller_updated_Wallet),testdatamap.get("WalletName").toString());
			this.takeScreenShot();
			test.log(Status.PASS,"#FUNC-Verify Update Client Information functionality" + driver.getTitle() +" * Update Client Information PASS * " );
			Log.ReportEvent("PASS", " Verify Update Client Information is Suceessfull");
		}
	catch(Exception e){
		test.log(Status.FAIL,"#FUNC-Verify Update Client Information functionality" + driver.getTitle() +" * Update Client Information FAIL * " );
		this.takeScreenShot();
		}
	}	
	//Function Summary:to perform search functionality.
	//Function Summary:contract number.
		public void BalanceSearchUi(Map<Object, Object> testdatamap) throws InterruptedException, IOException
		{
	     	String ValType=testdatamap.get("Type").toString();
	     	try
	     	{
	     	if (ValType.equalsIgnoreCase("Todate"))
	     	{
			Fromdate(testdatamap);
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Biller_Rcv_balSearch);
			this.takeScreenShot();
			verifyElementIsPresent(EdaatOR.Biller_balanceTodate);
			Thread.sleep(2000);
			test.log(Status.PASS,"#FUNC-Verify Balance search Fromdate Error message functionality" + driver.getTitle() +" * Balance search Fromdate Error message functionality is PASS * " );
    		
	     	}
	     	else if(ValType.equalsIgnoreCase("Fromdate"))
	     	{
	     	Todate(testdatamap);
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Biller_Rcv_balSearch);
			this.takeScreenShot();
			verifyElementIsPresent(EdaatOR.Biller_balanceFromdate);
			Thread.sleep(2000);
			test.log(Status.PASS,"#FUNC-Verify Balance search Todate Error message functionality" + driver.getTitle() +" * Balance search Todate Error message functionality is PASS * " );
    		
	     	}
	     	else if(ValType.equalsIgnoreCase("Invalid"))
	     	{
	     	Todate(testdatamap);
			Thread.sleep(2000);
			Fromdate(testdatamap);
			Thread.sleep(2000);
			WebEdit(EdaatOR.Biller_Rcv_balContract,testdatamap.get("contract number").toString());
			Thread.sleep(2000);	
			WebClickUsingJS(EdaatOR.Biller_Rcv_balSearch);
			this.takeScreenShot();
			Thread.sleep(2000);
			verifyElementIsPresent(EdaatOR.Biller_conctact);
			Thread.sleep(2000);
			test.log(Status.PASS,"#FUNC-Verify Balance search Nodata Error message functionality" + driver.getTitle() +" * Balance search Nodata Error message functionality is PASS * " );
    		
	     	}
	     	}
	     	catch(Exception e)
	     	{
	     		test.log(Status.FAIL,"#FUNC-Verify Balance search functionality" + driver.getTitle() +" * Balance Search FAIL * " );
	    		this.takeScreenShot();
	     		
	     	}
		
		}
		public void Fromdate(Map<Object, Object> testdatamap) throws InterruptedException
		{
			WebClick(EdaatOR.Biller_Rcv_balFromd);
	        Thread.sleep(2000);
			selectDropdownValue_PartialText(EdaatOR.Biller_Rcv_balFromyear,testdatamap.get("Fromyear").toString());
	        Thread.sleep(2000);
	        selectDropdownValue_PartialText(EdaatOR.Biller_Rcv_balFromon,testdatamap.get("From month").toString());
	        Thread.sleep(2000);
	        WebClick("//a[text()='"+testdatamap.get("Fromdate").toString()+"']");
	        Thread.sleep(2000);
			
		}
		public void Todate(Map<Object, Object> testdatamap) throws InterruptedException
		{
			  WebClick(EdaatOR.Biller_Rcv_balTod);
		      Thread.sleep(2000);
		      selectDropdownValue_PartialText(EdaatOR.Biller_Rcv_balToyear,testdatamap.get("Toyear").toString());
		      Thread.sleep(2000);
		      selectDropdownValue_PartialText(EdaatOR.Biller_Rcv_balTomon,testdatamap.get("Tomonth").toString());
		      Thread.sleep(2000);
		      WebClick("//a[text()='"+testdatamap.get("ToDate").toString()+"']");
			
		}
		
		//Function Summary:Method to searchBasedOnContractNumber
		//Parameter Summary:contract number
	      public void searchBasedOnContractNumber(Map<Object, Object> testdatamap) throws InterruptedException {
	    	  try {
	    		  WebClear(EdaatOR.Biller_Rcv_balContract);
					WebEdit(EdaatOR.Biller_Rcv_balContract,testdatamap.get("contract number").toString());
					Thread.sleep(2000);		
					WebClickUsingJS(EdaatOR.Biller_Rcv_balSearch);
					Thread.sleep(2000);
					WebElement element=driver.findElement(By.xpath(EdaatOR.Biller_Rcv_balContract));
				    scrollToElement(driver, element);
			} catch (Exception e) {
			e.printStackTrace();
			}
	      }
	      //Function Summary: validate Paid InvoiceAmount And OperationalFees Of Daily Reconciliation Report sadad.
		//Function Summary:
			public void validatePaidInvoiceAmountAndOperationalFeesOfDailyReconciliationReportsadad(Map<Object, Object> testdatamap,Log Log,String TotalInvoiceAmount,String OperationalFees) throws InterruptedException, IOException
			{
				try {
					SelectDate(testdatamap);				
					Thread.sleep(900);		
					WebClickUsingJS(EdaatOR.Biller_Rcv_balSearch);
					Thread.sleep(900);
					WebElement element=driver.findElement(By.xpath(EdaatOR.Biller_Rcv_balContract));
					scrollToElement(driver, element);
					Thread.sleep(900);					
					VerifyValue1(getText(EdaatOR.Biller_Rcv_BalanceTotalAmountPaid),TotalInvoiceAmount);
					Thread.sleep(1000);
					VerifyValue1(getText(EdaatOR.Biller_Rcv_BalanceTotalOperationFees),OperationalFees);
					Thread.sleep(2000);
					test.log(Status.PASS,"#FUNC-verify paid invoice amount and operational fees in balance details" + driver.getTitle() +" * Receviables balance details Pass * ");
					Log.ReportEvent("PASS", " verify paid invoice amount and operational fees in balance details is Successfull");
					this.takeScreenShot();	
				    }
			   catch(Exception e){
					test.log(Status.FAIL,"#FUNC-verify paid invoice amount and operational fees in balance details" + driver.getTitle() +" * Receviables balance details FAIL * " );
					this.takeScreenShot();
				} 
			   
			}
		//Function Summary:Method to calculateTheOperationalFees
		//Parameter Summary:InvoiceAmount,AZMFeesFixed,AZMFeesPercentage,MadaFeesFixed,MadaFeesPercentage
		public String calculateTheOperationalFees(Map<Object, Object> testdatamap) throws InterruptedException {
				double percent=100.00;
				String invoiceAmount = testdatamap.get("InvoiceAmount").toString();
				String azmFeesFixed = testdatamap.get("AZMFeesFixed").toString();
				String azmFeesPercentage = testdatamap.get("AZMFeesPercentage").toString();
				String paymentMethodFeesFixed = testdatamap.get("PaymentMethodFeesFixed").toString();
				String paymentMethodFeesPercentage = testdatamap.get("PaymentMethodFeesPercentage").toString();			
				double azmFeesPercentageAmount=Double.parseDouble(invoiceAmount)*Double.parseDouble(azmFeesPercentage)/percent;
				double paymentMethodFeesPercentageAmount=Double.parseDouble(invoiceAmount)*Double.parseDouble(paymentMethodFeesPercentage)/percent;
				double operationFees = Double.parseDouble(azmFeesFixed)+Double.parseDouble(paymentMethodFeesFixed)+azmFeesPercentageAmount+paymentMethodFeesPercentageAmount;
			    String expectedOperationalFees = String.format("%.2f", operationFees);	
			    return expectedOperationalFees;			
		}
	
		//Function Summary:Method to calculateTheOperationalFees
		//Parameter Summary:InvoiceAmount
		public void verifyTheAmountPaidAndOperationalFees(Map<Object, Object> testdatamap,Log Log) throws InterruptedException {	
			try {
				VerifyValue1(getText(EdaatOR.Biller_Rcv_balverifyAmountPaid),testdatamap.get("InvoiceAmount").toString());
				VerifyValue1(getText(EdaatOR.Biller_Rcv_balverifyOperationalFees),calculateTheOperationalFees(testdatamap));
				this.takeScreenShot();
				test.log(Status.PASS,"#FUNC-Verify the fees deduction correctly in Balance details page functionality is Suceessfull" + driver.getTitle() +" * Verify the fees deduction correctly in Balance details page functionality is Suceessfull PASS * " );
				Log.ReportEvent("PASS", "Verify the fees deduction correctly in Balance details page is Suceessfull");
			} catch (Exception e) {
				e.printStackTrace();
				this.takeScreenShot();
				test.log(Status.FAIL,"#FUNC-Verify the fees deduction correctly in Balance details page functionality is Unsuceessfull" + driver.getTitle() +" * Verify the fees deduction correctly in Balance details page functionality is Unsuceessfull FAIL * " );				
			}			
		}
		
		//Function Summary :Method to verifyThePaymentMethodInThePaymentMethodColumn
		//Parameter Summary:ExpectedPaymentMethod
		public void verifyThePaymentMethodInThePaymentMethodColumn(Map<Object, Object> testdatamap,Log Log) throws InterruptedException {	
			try {
				VerifyValue1(getText(EdaatOR.Biller_Rcv_balverifyPaymentMethod),testdatamap.get("ExpectedPaymentMethod").toString());
				this.takeScreenShot();
				test.log(Status.PASS,"#FUNC-Verify that the payment method used to pay invoice appears in payment method column functionality is Suceessfull" + driver.getTitle() +" * Verify that the payment method used to pay invoice appears in payment method column functionality is Suceessfull PASS * " );
				Log.ReportEvent("PASS", "Verify the fees deduction correctly in Balance details page is Suceessfull");
			} catch (Exception e) {
				e.printStackTrace();
				this.takeScreenShot();
				test.log(Status.FAIL,"#FUNC-Verify that the payment method used to pay invoice appears in payment method column functionality is Unsuceessfull" + driver.getTitle() +" * Verify that the payment method used to pay invoice appears in payment method column functionality is Unsuceessfull FAIL * " );				
			}			
		}

}
