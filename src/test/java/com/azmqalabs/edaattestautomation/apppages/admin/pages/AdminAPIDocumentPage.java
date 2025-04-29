/**
* Test Script Name                   : NA
* TestData Sheet Name                : NA
* Objective                          : Wathiq Integration Functionality.
* Version                            : 1.0
* Author                             : Kathirvelu M
* Created Date                       : 14/06/2023
* Last Updated on                    : N/A
* Updated By                         : Kalpana I R
* Pre-Conditions                     : NA
* Epic Details                       : N/A
* User Story Details                 : N/A
**/
package com.azmqalabs.edaattestautomation.apppages.admin.pages;

import java.io.IOException;
import java.util.Map;

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

public class AdminAPIDocumentPage extends BasePage {

	public AdminAPIDocumentPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

		PageFactory.initElements(new fieldDecorator(driver, test), this);
	}

	@FindBy(xpath = EdaatOR.Admin_API_Document)
	public WebElement Admin_API_Document;


	public boolean Exists(){
		return super.Exists(Admin_API_Document); 
	}
//Function summary:Verify to API Document
//Parameter summary: NA
	public void APIDocument(Log Log)
	{
		try
		{
		WebClickUsingJS(EdaatOR.Admin_API_lnk);
		WebClickUsingJS(EdaatOR.Admin_API_Download);
		this.takeScreenShot();
		test.log(Status.PASS,"API Document"+driver.getTitle()+" * Verify API Document is pass * ");
    	Log.ReportEvent("PASS", "Verify to Export API Document sheet is Suceessful");

		}
		catch(Exception e)
		{
			this.takeScreenShot();
			test.log(Status.FAIL,"API Document"+driver.getTitle()+" * Verify API Document is pass * ");
		}
	}
}
