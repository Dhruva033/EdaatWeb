package com.azmqalabs.edaattestautomation.apppages.biller.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.azmqalabs.edaattestautomation.apppages.masterpages.BasePage;
import com.azmqalabs.edaattestautomation.common.uielement.fieldDecorator;
import com.azmqalabs.edaattestautomation.objectrepository.EdaatOR;
import com.azmqalabs.edaattestautomation.common.Log;

public class InvokeApplicationPage extends BasePage {

	public InvokeApplicationPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

		PageFactory.initElements(new fieldDecorator(driver, test), this);
	}

	public void Chooseoptions(Log Log) {
		try {
			WebClickUsingJS(EdaatOR.LoginPage_Changelanguage);
			Thread.sleep(1000);
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Biller_Link);

			Log.ReportEvent("PASS", " Biller Application Launched Successfully");

		} catch (Exception e) {
//			e.printStackTrace();
			Log.ReportEvent("FAIL", "Biller Application is not Launched Successfully");
			this.takeScreenShot();
		}
	}

	public void Chooseoptions1(Log Log) {
		
		try {
			WebClickUsingJS(EdaatOR.LoginPage_Changelanguage);
			Thread.sleep(1000);
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Client_Link);
        	Log.ReportEvent("PASS", " Biller Application Launched Successfully");

		} catch (Exception e) {
			Log.ReportEvent("FAIL", " Biller Application is not Launched Successfully");
			this.takeScreenShot();
		}
		
	}

	public void Chooseoptions2(Log Log) {

		// TODO Auto-generated method stub

		try {			

			WebClickUsingJS(EdaatOR.ArabicClient_Link);
        	Log.ReportEvent("PASS", " Verify Biller Application Launched Successfully");


		} catch (Exception e) {
//			e.printStackTrace();
		}		

	}
}
