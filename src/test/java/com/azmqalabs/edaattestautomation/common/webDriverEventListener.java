package com.azmqalabs.edaattestautomation.common;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class webDriverEventListener extends AbstractWebDriverEventListener {
	public ExtentTest test;
	private RemoteWebDriver WebDriver;
	private ExtentReports extent;
	private By lastFindBy;
	private WebElement lastElement;
	private String originalValue;
	public String InfoFontColorPrefix = "<span ><font color='gold';font-size:10%; line-height:20px>";
	public String InfoFontColorSuffix = "</font></span>";
	public String ErrorFontColorPrefix = "<span><font color='red';font-size:16px; line-height:20px>";
	public String ErrorFontColorSuffix = "</font></span>";

	public webDriverEventListener(ExtentTest test) {
		this.test = test;
	}

	// @Override
	public void afterChangeValueOf(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		System.out.println("*-After Change Value of " + arg0 + " " + arg1.getCurrentUrl());
		test.log(Status.INFO, InfoFontColorPrefix + "*afterChangeValueOf: After Change Value of " + arg0 + " "+ arg1.getCurrentUrl() + InfoFontColorSuffix);
		test.log(Status.INFO, InfoFontColorPrefix + "Even Handler" + InfoFontColorSuffix);
	}

	@Override
	public void afterClickOn(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		System.out.println("Clicked Element with: '" + arg0 + "'");
		test.log(Status.INFO,InfoFontColorPrefix + "*afterClickOn: Clicked Element with: '" + arg0 + "'" + InfoFontColorSuffix);

	}

	@Override
	public void afterFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		// TODO Auto-generated method stub
		lastFindBy = arg0;
		System.out.println("Found: '" + lastFindBy + "'.");
		System.out.println("Found: " + arg0.toString() + "'."); // This is optional and an alternate way
		test.log(Status.INFO, InfoFontColorPrefix + "*afterFindBy: Found: '" + lastFindBy + "'." + InfoFontColorSuffix);
		test.log(Status.INFO,InfoFontColorPrefix + "*afterFindBy: Found: " + arg0.toString() + "'." + InfoFontColorSuffix);
	}

	@Override
	public void afterNavigateBack(WebDriver arg0) {
		// TODO Auto-generated method stub
		System.out.println("After Navigating Back. I'm at " + arg0.getCurrentUrl());

		test.log(Status.INFO, InfoFontColorPrefix + "*afterNavigateBack: After Navigating Back. I'm at "+ arg0.getCurrentUrl() + InfoFontColorSuffix);
	}

	@Override
	public void afterNavigateForward(WebDriver arg0) {
		// TODO Auto-generated method stub
		System.out.println("After Navigating Forward. I'm at " + arg0.getCurrentUrl());
		test.log(Status.INFO, InfoFontColorPrefix + "*afterNavigateForward: After Navigating Forward. I'm at "+ arg0.getCurrentUrl() + InfoFontColorSuffix);

	}

	@Override
	public void afterNavigateTo(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		System.out.println("After Navigating To: " + arg0 + ", my url is: " + arg1.getCurrentUrl());
		test.log(Status.INFO, InfoFontColorPrefix + "*afterNavigateTo: After Navigating To: " + arg0 + ", my url is: "+ arg1.getCurrentUrl() + InfoFontColorSuffix);
	}

	@Override
	public void afterScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		System.out.println("afterScript: " + arg0 + ":" + arg1);
		test.log(Status.INFO,InfoFontColorPrefix + "*afterScript: afterScript: " + arg0 + ":" + arg1 + InfoFontColorSuffix);

	}

	// @Override
	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		lastElement = arg0;
		originalValue = arg0.getText();

		// What if the element is not visible anymore?
		if (originalValue.isEmpty()) {
			originalValue = arg0.getAttribute("value");
		}
		System.out.println("beforeChangeValueOf: " + arg0 + ":" + arg1);
		test.log(Status.INFO, InfoFontColorPrefix + "*beforeChangeValueOf: beforeChangeValueOf: " + arg0 + ":" + arg1+ InfoFontColorSuffix);
	}

	@Override
	public void beforeClickOn(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		System.out.println("Trying to click: '" + arg0 + "'");
		// Highlight Elements before clicking
		for (int i = 0; i < 1; i++) {
			JavascriptExecutor js = (JavascriptExecutor) arg1;
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);", arg0,
					"color: black; border: 3px solid black;");
		}
		test.log(Status.INFO, InfoFontColorPrefix + "*beforeClickOn: beforeClickOn" + InfoFontColorSuffix);
	}

	@Override
	public void beforeFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		// TODO Auto-generated method stub
		lastFindBy = arg0;
		System.out.println("Trying to find: '" + lastFindBy + "'.");
		System.out.println("Trying to find: " + arg0.toString()); // This is optional and an alternate way
		test.log(Status.INFO,InfoFontColorPrefix + "*beforeFindBy: Trying to find: '" + lastFindBy + "'." + InfoFontColorSuffix);
		test.log(Status.INFO,InfoFontColorPrefix + "*beforeFindBy: Trying to find: " + arg0.toString() + InfoFontColorSuffix);

	}

	@Override
	public void beforeNavigateBack(WebDriver arg0) {
		// TODO Auto-generated method stub
		System.out.println("Before Navigating Back. I was at " + arg0.getCurrentUrl());
		test.log(Status.INFO, InfoFontColorPrefix + "*beforeNavigateBack: Before Navigating Back. I was at "+ arg0.getCurrentUrl() + InfoFontColorSuffix);
	}

	@Override
	public void beforeNavigateForward(WebDriver arg0) {
		// TODO Auto-generated method stub
		System.out.println("Before Navigating Forward. I was at " + arg0.getCurrentUrl());
		test.log(Status.INFO, InfoFontColorPrefix + "*beforeNavigateForward: Before Navigating Forward. I was at "+ arg0.getCurrentUrl() + InfoFontColorSuffix);

	}

	@Override
	public void beforeNavigateTo(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		System.out.println("Before Navigating To : " + arg0 + ", my url was: " + arg1.getCurrentUrl());
		test.log(Status.INFO, InfoFontColorPrefix + "*beforeNavigateTo: Even Handler" + "Before Navigating To : " + arg0+ ", my url was: " + arg1.getCurrentUrl() + InfoFontColorSuffix);
		test.log(Status.INFO, InfoFontColorPrefix + "*beforeNavigateTo: Before Navigating To : " + arg0+ ", my url was: " + arg1.getCurrentUrl() + InfoFontColorSuffix);
		test.log(Status.INFO, InfoFontColorPrefix + "*beforeNavigateTo: Even Handler" + "Before Navigating To : " + arg0+ ", my url was: " + arg1.getCurrentUrl() + InfoFontColorSuffix);
		driverLog("InfoFontColorPrefix+*beforeNavigateTo: Even Handler" + "Before Navigating To : " + arg0
				+ ", my url was: " + arg1.getCurrentUrl() + InfoFontColorSuffix);
	}

	@Override
	public void beforeScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		System.out.println("beforeScript");
		test.log(Status.INFO, InfoFontColorPrefix + "*beforeScript: beforeScript" + InfoFontColorSuffix);
	}

	public void onException(Throwable arg0, WebDriver arg1) {

	}

	public void driverLog(String reportDesc) {
		test.log(Status.INFO, reportDesc);
	}

}
