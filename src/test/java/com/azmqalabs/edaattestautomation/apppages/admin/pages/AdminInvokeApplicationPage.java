package com.azmqalabs.edaattestautomation.apppages.admin.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.azmqalabs.edaattestautomation.apppages.masterpages.BasePage;
import com.azmqalabs.edaattestautomation.common.uielement.fieldDecorator;
import com.azmqalabs.edaattestautomation.objectrepository.EdaatOR;

public class AdminInvokeApplicationPage extends BasePage {

	public AdminInvokeApplicationPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

		PageFactory.initElements(new fieldDecorator(driver, test), this);
	}

	public void Chooseoptions() {
		try {
			WebClickUsingJS(EdaatOR.LoginPage_Changelanguage);
			Thread.sleep(1000);
			this.takeScreenShot();
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Biller_Link);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
