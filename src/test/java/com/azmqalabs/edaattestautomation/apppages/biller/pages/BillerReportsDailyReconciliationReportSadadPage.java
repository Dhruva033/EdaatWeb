package com.azmqalabs.edaattestautomation.apppages.biller.pages;

import java.util.Map;

import org.openqa.selenium.By;
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
import com.azmqalabs.edaattestautomation.common.Log;


public class BillerReportsDailyReconciliationReportSadadPage extends BasePage
{

	public BillerReportsDailyReconciliationReportSadadPage(WebDriver driver,ExtentTest test)
	{
		 this.driver=driver;
		 this.test=test;
		 
		 PageFactory.initElements(new fieldDecorator(driver,test), this);
	}  
	

	@FindBy(xpath = EdaatOR.Biller_DailyReconciliationReportSadad)
	public WebElement DailyReconciliationReportPage;
		
	    
	    public boolean Exists(){
	    	return super.Exists(DailyReconciliationReportPage); 
		}
	    
	  //Function Summary  : Method to Navigate Daily reconciliation Report sadad.  
	  		//Parameter Summary : NA
	  		public void navigateToDailyReconciliationReportSadadPage(Log Log)throws InterruptedException
	  		{
	  			try{
	  			WebClickUsingJS(EdaatOR.Biller_ReportMenu);
	  			Thread.sleep(1000);
	  			WebClickUsingJS(EdaatOR.Biller_ReceivablesReportsbtn);
	  			Thread.sleep(1000);
	  			WebClickUsingJS(EdaatOR.Biller_DailyReconciliationReportSadad);
	  			Thread.sleep(1000);
	  			this.takeScreenShot();
	  			Log.ReportEvent("PASS", " Navigate to Daily Reconciliation sadad Report Page is Suceessful");
	  			}
	  			catch (Exception e) {
	  				test.log(Status.FAIL,"Navigate to Daily Reconciliation sadad Report Page is FAIL" );
	  				this.takeScreenShot();
	  			}
	  		} 
		//Function Summary   : Method to select Reconcilied date
		//Parameter Summary  : Date,Month,Year.
		public void SelectReconciliedDate(Map<Object,Object> testdatamap) throws InterruptedException
		{
			try {
                Thread.sleep(2000);
				WebClick(EdaatOR.Biller_DailyReconciliationReport_ReconciledDate);			
				selectDropdownValue_PartialText(EdaatOR.Admin_ReportsFromYear, testdatamap.get("Year").toString());
				selectDropdownValue_PartialText(EdaatOR.Admin_ReportsFromMonth, testdatamap.get("Month").toString());
				WebClick("//a[text()='"+testdatamap.get("Date").toString()+"']");
				Thread.sleep(800);
 
			}		catch(Exception e){
				test.log(Status.FAIL,"#FUNC-Select Date FAIL" + driver.getTitle() +" *Select Date FAIL * " );
				this.takeScreenShot();
			}
		}
		
		
		//Function Summary   : Method to select Transfer Status
		//Parameter Summary  : Status.
		public void SelectTransferStatus(Map<Object,Object> testdatamap) throws InterruptedException
		{
			try {
				selectDropdownValue_PartialText(EdaatOR.Biller_DailyReconciliationReport_TransferStatus, testdatamap.get("Status").toString());
 
			  }		catch(Exception e){
				test.log(Status.FAIL,"#FUNC-Select payment method FAIL" + driver.getTitle() +" *Select Payment Method FAIL * " );
				this.takeScreenShot();
			}
		}
		
		//Function Summary  : Method to click on Generate report button
		//Parameter Summary : N/A	
		public void clickOnGenerateReport() throws InterruptedException
		{
			WebClick(EdaatOR.Admin_Button);
	    	Thread.sleep(2000);
			
		}
		
		//Function Summary  : Method to Verify Daily Reconciliation Report (SADAD)
		//Parameter Summary : N/A	
		public void verifyDailyReconciliationReportSADAD(Map<Object,Object> testdatamap,Log Log) {
			try {
				SelectReconciliedDate(testdatamap);
				Thread.sleep(400);
				SelectTransferStatus(testdatamap);
				Thread.sleep(100);
				clickOnGenerateReport();
				switchToWindow();
				swithchToFrame(EdaatOR.Admin_Corporate_Report);
				Thread.sleep(3000);
				verifyElementIsPresent("//div[text()='"+testdatamap.get("BillNumber").toString()+"']");
				switchBacktoParentwindow();
				this.takeScreenShot();
				test.log(Status.PASS,"#FUNC-]verify that the data appears correctly in columns by  the Daily Reconciliation Report (sadad)" + driver.getTitle() +" * PASS * " );
				Log.ReportEvent("PASS", " Verify the pagination in the report is Successful");

			}
			catch (Exception e) {
				test.log(Status.FAIL,"]verify that the data appears correctly in columns by  the Daily Reconciliation Report (sadad)" + driver.getTitle() +" * FAIL * " );
			}

		}
	  
	            //Function Summary  : Method to verify Daily Reconciliation Report(SADAD) And Get Invoice Paid Amount and Operational fees amount
				//Parameter Summary : N/A	
				public void verifyDailyReconciliationReportSADADAndGetInvoicePaidAmount(Map<Object,Object> testdatamap,Log Log) {
					try {
						SelectReconciliedDate(testdatamap);
						Thread.sleep(400);
						SelectTransferStatus(testdatamap);
						Thread.sleep(100);
						clickOnGenerateReport();
						switchToWindow();
						swithchToFrame(EdaatOR.Admin_Corporate_Report);
						Thread.sleep(2000);			   			  					  			
						this.takeScreenShot();
						test.log(Status.PASS,"#FUNC-]verify Daily Reconciliation Report(SADAD) And Get Invoice Paid Amount and Operational fees amount" + driver.getTitle() +" * PASS * " );
						Log.ReportEvent("PASS", " Verifed Invoice paid amount and operational fees is Successful");

					}
					catch (Exception e) {
						test.log(Status.FAIL,"verify Daily Reconciliation Report(SADAD) And Get Invoice Paid Amount and Operational fees amount" + driver.getTitle() +" * FAIL * " );
					}
					 

				}
	  public String getTotalInvoiceAmount()
	  {
			WebElement element=driver.findElement(By.xpath(EdaatOR.Admin_Reports_TotalInvoicePaid));
			return element.getText();	
	  }
	  public String getAmountOperationFees()
	  {
			WebElement element=driver.findElement(By.xpath(EdaatOR.Admin_Reports_OperationFees));
			return element.getText();	
	  }

	  public void switchToParentwindow()
	  {
		  switchBacktoParentwindow();
	  }

}
	 

