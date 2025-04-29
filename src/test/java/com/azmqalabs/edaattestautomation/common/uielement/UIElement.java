package com.azmqalabs.edaattestautomation.common.uielement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

public abstract class UIElement implements WebElement {

	public WebElement element;

	public WebDriver webDriver;
	public ExtentTest testReport;

	public void setRootElement(WebElement rootElement) {
		this.element = rootElement;
	}

	public void setWebDriver(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	public void setTest(ExtentTest testReport) {
		this.testReport = testReport;
	}

}
