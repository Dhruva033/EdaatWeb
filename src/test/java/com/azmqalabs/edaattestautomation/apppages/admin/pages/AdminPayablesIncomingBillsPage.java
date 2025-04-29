/**
*
* Test Script Name                   : N/A
* Objective                          : Incoming bills functionality.
* Version                            : 1.0
* Author                             : Kathirvelu M
* Created Date                       : 14/09/2023
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



public class AdminPayablesIncomingBillsPage extends BasePage
{

	public AdminPayablesIncomingBillsPage(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;

		PageFactory.initElements(new fieldDecorator(driver,test), this);
	}  


	@FindBy(xpath = EdaatOR.Admin_IncomingBillsPage)
	public WebElement Client;


	public boolean Exists(){
		return super.Exists(Client); 
	}
	//Function Summary   : Method to  Navigate to Incoming bills page
	//Parameter Summary  : N/A
	public void NavigatetoIncomingBillsPage() throws InterruptedException {
	
		WebClickUsingJS(EdaatOR.Admin_PayablesMenu);
		Thread.sleep(1000);
		WebClickUsingJS(EdaatOR.Admin_IncomingBillsLink);
		Thread.sleep(1000);
		this.takeScreenShot();
	}
//Function Summary   : Method to Verify grid view 
//Parameter Summary  : N/A
	public void  VerifyIncomingbillsGridView(Log Log)
	{
		try{
			NavigatetoIncomingBillsPage();
			Thread.sleep(1000);
            verifyElementIsPresent(EdaatOR.Admin_IncomingBillsBillerName);
            verifyElementIsPresent(EdaatOR.Admin_IncomingBillsBillerID);
            verifyElementIsPresent(EdaatOR.Admin_IncomingBillsInvoiceStatus);
            this.takeScreenShot();
			 test.log(Status.PASS,"Verify grid view " + driver.getTitle() +" * Incoming bills PASS * " );
	        	Log.ReportEvent("PASS", " Verify Add Corporate Client is Sucessful");
	
		}
			catch(Exception e){
				test.log(Status.FAIL,"Verify grid view FAIL" + driver.getTitle() +" * Incoming bills FAIL * " );
				this.takeScreenShot();
			}
	}
//Function Summary   : Method to Verify Incoming Bills Search
//Parameter Summary  : BillNumber,ContractNumber
	public void IncomingBillsSearch(Map<Object, Object> testdatamap,Log Log)

	{

		try {	

			NavigatetoIncomingBillsPage();

	        WebEdit(EdaatOR.Admin_Payables_IncomingBillNumber,testdatamap.get("BillNumber").toString());

	        WebEdit(EdaatOR.Admin_Payables_IncomingBillerName,testdatamap.get("BillerName").toString());

	      //WebClick(EdaatOR.Biller_Status);

	      //selectDropdownValue_PartialText(EdaatOR.Biller_Status,testdatamap.get("Status").toString());

	        WebEdit(EdaatOR.Admin_Payables_IncomingContractNumber,testdatamap.get("ContractNumber").toString());

	        WebClick(EdaatOR.Admin_Payables_IncomingBillsearch);

	        Thread.sleep(3000);

	        VerifyValue1(getText(EdaatOR.Admin_Payables_IncomingBillsVerify),testdatamap.get("BillNumber").toString());     

        	this.takeScreenShot();

			test.log(Status.PASS,"Search IncomingBills is successful" + driver.getTitle() +" * Payables PASS * " );	
        	Log.ReportEvent("PASS", "Verify Search functionality is Suceessfull");

		}

		catch(Exception e){

			test.log(Status.FAIL,"Search IncomingBills is Failed" + driver.getTitle() +" * Payables FAIL * " );

			this.takeScreenShot();

		}

	}
}
