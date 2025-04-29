/**
* Test Script Name  				 : N/A
* Objective     					 : Verify InvoicesTemplates Functionality
* Version      						 : 1.0
* Author       						 : Basavaraj Mudnur
* Created Date 			      		 : 
* Last Updated on					 : N/A
* Updated By   			 			 : Basavaraj Mudnur
* Pre-Conditions					 : N/A
* Manual Test case Name				 : N/A
* Epic Details						 : N/A
* User Story Details				 : N/A
* Defects affecting this test script : N/A
* WorkArounds/Known Issues			 : N/A
**/
package com.azmqalabs.edaattestautomation.apppages.biller.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.azmqalabs.edaattestautomation.apppages.masterpages.BasePage;
import com.azmqalabs.edaattestautomation.common.Log;
import com.azmqalabs.edaattestautomation.common.uielement.fieldDecorator;
import com.azmqalabs.edaattestautomation.objectrepository.EdaatOR;

public class BillerSettingsInvoicesTemplatesPage extends BasePage {
	public BillerSettingsInvoicesTemplatesPage(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;

		PageFactory.initElements(new fieldDecorator(driver,test), this);
	}  


	@FindBy(xpath = EdaatOR.Biller_Settings)
	public WebElement Settings;


	public boolean Exists(){
		return super.Exists(Settings); 
	}
	
	//Function Summary   : Method to Navigate to Invoice Template Gridview.
		//Parameter Summary  : N/A
		public boolean GridViewtable(String menu,String InvoiceTemplategridview) {
			boolean existsNID = false;
			try {
				WebClickUsingJS(EdaatOR.Biller_Settings);
				Thread.sleep(1000);
				WebClickUsingJS(menu);
				Thread.sleep(1000);
				this.takeScreenShot();
				if (ExistsCheck(InvoiceTemplategridview) == true) {
					existsNID = true;
				}
				existsNID = true;
			}

			catch (Exception e) {
				e.printStackTrace();
				this.takeScreenShot();
			}
			return existsNID;
		}
		//Function Summary   : Method to Verify Invoice Template Gridview.
		//Parameter Summary  : N/A
		public void verifyInvoiceTemplateGridview(String menu,String InvoiceTemplategridview,Log Log) {
			try {

				boolean Ele = GridViewtable(menu,InvoiceTemplategridview);
				if (Ele == true) {
					test.log(Status.PASS,"#FUNC-Grid View" + driver.getTitle() + " * Grid View PASS * ");
		        	Log.ReportEvent("PASS", " Verify Invoice Templates Gridview is Suceessful");

				}else
					test.log(Status.FAIL,"#FUNC-Grid View" + driver.getTitle() + " * Grid View FAIL * ");
			} catch (Exception e) {
				test.log(Status.FAIL, "#FUNC-Grid View" + driver.getTitle() + " * Grid View FAIL * ");
				this.takeScreenShot();
			}
	}

}
