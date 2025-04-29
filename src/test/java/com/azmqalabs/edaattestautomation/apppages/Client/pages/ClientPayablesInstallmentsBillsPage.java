package com.azmqalabs.edaattestautomation.apppages.Client.pages;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.azmqalabs.edaattestautomation.apppages.masterpages.BasePage;
import com.azmqalabs.edaattestautomation.common.ReadData;
import com.azmqalabs.edaattestautomation.common.uielement.fieldDecorator;
import com.azmqalabs.edaattestautomation.objectrepository.EdaatOR;
import com.codoid.products.fillo.Recordset;
import com.azmqalabs.edaattestautomation.common.Log;

public class ClientPayablesInstallmentsBillsPage extends BasePage {

	public ClientPayablesInstallmentsBillsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

		PageFactory.initElements(new fieldDecorator(driver, test), this);
	}

	@FindBy(xpath = EdaatOR.Client_Payables_InstallmentsPage_verify)
	public WebElement Installments;

	public boolean Exists() {
		return super.Exists(Installments);
	}
	public void InstallmentBillSearch(Map<Object, Object> testdatamap,Log Log) throws IOException
	{
		try {
		WebClickUsingJS(EdaatOR.Client_Payables_InstallmentsPage_lnk);
		WebEdit(EdaatOR.Client_Payables_Installments_Contractnum,testdatamap.get("Contract Number").toString());
		WebEdit(EdaatOR.Client_Payables_Installments_billername,testdatamap.get("Biller Name").toString());
		WebClickUsingJS(EdaatOR.Client_Payables_Installments_Search);
        this.takeScreenShot();
		VerifyValue1(getText(EdaatOR.Client_Payables_Installments_Contract_Verify), testdatamap.get("Contract Number").toString());
        this.takeScreenShot();
		test.log(Status.PASS,"Installment Bill Search" + driver.getTitle() +" * Installment Bill Search is PASS * ");
	    	Log.ReportEvent("PASS", "Verify Search functionality");
	
		}
		catch(Exception e){
	      test.log(Status.FAIL,"Installment Bill Search" + driver.getTitle() +" * Installment Bill Search is FAIL * ");
          this.takeScreenShot();
		}
	}
		public void InstallmentBillSContractclick(Map<Object, Object> testdatamap,Log Log) throws IOException
	{
		try {
	    InstallmentBillSearch(testdatamap, Log);
	    WebClick(EdaatOR.Client_Payables_Installments_Contract_Click);
	    Thread.sleep(3000);
	    switchTonextwindow();
	    verifyElementIsPresent("//label[text()='"+testdatamap.get("Contract Number").toString()+"']");
	    Thread.sleep(3000);
	    switchToDefault();
		test.log(Status.PASS,"Contract number is Clickable" + driver.getTitle() +" * Contract number is Clickable is PASS * ");
    	Log.ReportEvent("PASS", "Verify Search functionality");
		this.takeScreenShot();
		}
		catch(Exception e){
	      test.log(Status.FAIL,"Contract number is Clickable" + driver.getTitle() +" *  Contract number is Clickable is FAIL * ");
		}
	}
	public void VerifyInstallmentgridView(Log Log)
	{
		try
		{
			WebClickUsingJS(EdaatOR.Client_Payables_InstallmentsPage_lnk);
			Thread.sleep(2000);
			if(CheckElementExists(EdaatOR.ClientsPayables_InstallmentsGrid)==true)
			{
			test.log(Status.PASS,"Installment Bill Grid View" + driver.getTitle() +" * Installment Bill Grid View PASS * ");
		 	Log.ReportEvent("PASS", "  Verify Grid view details is successfull");
			}
			else
			{
			test.log(Status.FAIL,"Installment Bill Grid View" + driver.getTitle() +" * Installment Bill Grid View FAIL * ");	
			}

		}
		catch (Exception e) {			
			test.log(Status.FAIL,"Installment Bill Grid View" + driver.getTitle() +" * Installment Bill Grid View FAIL * ");	
		}
	}
}


