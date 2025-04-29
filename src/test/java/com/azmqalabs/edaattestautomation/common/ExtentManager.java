package com.azmqalabs.edaattestautomation.common;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.mail.MessagingException;

import org.eclipse.jetty.server.Authentication.User;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.Capabilities;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.azmqalabs.edaattestautomation.apppages.GlobalConstant;
import com.codoid.products.fillo.Recordset;

public class ExtentManager{
	private static ExtentReports extent;
	private static String extentReportLocation = "ReportsConfig.xml";
	private static String filePath;
	private static ExtentSparkReporter htmlReporter;
	private static ExtentTest test;
	private static String browserNames = "";
	

	public static ExtentReports GetExtent(String browserName) throws IOException, MessagingException {
	    // Initialize ExtentReports only once
	    if (extent == null) {
	        extent = new ExtentReports();
	        extent.attachReporter(getHtmlReporter());
	        String os = System.getProperty("os.name");  // Get OS name
	        InetAddress localHost = InetAddress.getLocalHost();
	        String machineName = localHost.getHostName();

	        extent.setSystemInfo("Machine Name", machineName);
	        extent.setSystemInfo("OS", os);
	        extent.setSystemInfo("Test URL", GlobalConstant.GLOBALTESTDATALOGINMAP.get("URL").toString());
	        // Initialize the browser names variable as empty
	        browserNames = "";
	    }

	    // Check if the new browser name is already in the browserNames string
	    if (!browserNames.contains(browserName)) {
	        // If browserNames is not empty, append a comma
	        if (!browserNames.isEmpty()) {
	            browserNames += ", "; 
	        }
	        // Add the new browser name
	        browserNames += browserName; 
	    }

	    // Update the "Browser Name" in the system info
	    extent.setSystemInfo("Browser Name", browserNames);

	    return extent;
	}
	public static ExtentReports GetExtent() throws IOException, MessagingException {
		// Initialize ExtentReports only once
		if (extent == null) {
			extent = new ExtentReports();
			extent.attachReporter(getHtmlReporter());
		}
		return extent;
	}
	private static ExtentSparkReporter getHtmlReporter() throws IOException, MessagingException {
		String sProjectName = "";
		sProjectName = System.getProperty("projectname");
		if (sProjectName == null) {
			sProjectName = Config.Get("PROJECT.NAME");
		}
		File classpathRoot = new File(System.getProperty("user.dir"));
		File app = new File(classpathRoot.getAbsolutePath() + "//src//test//resources//testConfig//extentreport//",
				extentReportLocation);
		File app1 = new File(classpathRoot.getPath() + "//",
				"src//test//resources//testReport//" + sProjectName);
		
		LocalDate today = LocalDate.now();
        LocalTime time=LocalTime.now();
    //    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH_mm_ss");
    //    String formatDateTime = now.format(format);  

        filePath = app1.toString() + "//" + Config.Get("TESTCYCLE.NAME")+"_"+today+"_"+time.toString().replace(".", "").replace(":", "-")+".html";
        System.out.println(filePath);
		
		htmlReporter = new ExtentSparkReporter(filePath.toString());
		htmlReporter.loadXMLConfig(app.toString());
		
		String customJavaScript = 
			    "document.addEventListener('DOMContentLoaded', function() {" +

			        // Change Started label and make it bold
			        "var startedLabel = document.querySelector('.col-md-3 .card-body p');" + 
			        "if (startedLabel && startedLabel.textContent.trim() === 'Started') {" +
			        "   startedLabel.textContent = 'Test Start Time';" +
			        "   startedLabel.style.fontWeight = 'bold';" +
			        "}" +

			        // Change Ended label and make it bold
			        "var endedLabel = document.querySelectorAll('.col-md-3 .card-body p');" + 
			        "if (endedLabel[1] && endedLabel[1].textContent.trim() === 'Ended') {" +
			        "   endedLabel[1].textContent = 'Test End Time';" +
			        "   endedLabel[1].style.fontWeight = 'bold';" +
			        "}" +

			        // Change Tests Passed label and make it bold
			        "var testsPassedLabel = document.querySelector('.col-md-3 .card-body p.text-pass');" + 
			        "if (testsPassedLabel) {" +
			        "   testsPassedLabel.textContent = 'Successful Tests';" +
			        "   testsPassedLabel.style.fontWeight = 'bold';" +
			        "}" +

			        // Change Tests Failed label and make it bold
			        "var testsFailedLabel = document.querySelector('.col-md-3 .card-body p.text-fail');" + 
			        "if (testsFailedLabel) {" +
			        "   testsFailedLabel.textContent = 'Failed Tests';" +
			        "   testsFailedLabel.style.fontWeight = 'bold';" +
			        "}" + 

			        // Change Tests label and make it bold
			        "var testsLabel = document.querySelector('.card-header h6.card-title');" + 
			        "if (testsLabel && testsLabel.textContent.trim() === 'Tests') {" +
			        "   testsLabel.textContent = 'Test Cases';" +
			        "   testsLabel.style.fontWeight = 'bold';" +
			        "}" +

			        // Change Timeline label and make it bold
			        "var timelineLabel = document.querySelector('.card-header p');" + 
			        "if (timelineLabel && timelineLabel.textContent.trim() === 'Timeline') {" +
			        "   timelineLabel.textContent = 'Execution Timeline';" +
			        "   timelineLabel.style.fontWeight = 'bold';" +
			        "}" +

			        // Change Log events label and make it bold
			        "var logEventsLabels = document.querySelectorAll('.card-header .card-title');" + 
			        "if (logEventsLabels.length > 1 && logEventsLabels[1].textContent.trim() === 'Log events') {" +
			        "   logEventsLabels[1].textContent = 'Test Steps';" +
			        "   logEventsLabels[1].style.fontWeight = 'bold';" +
			        "}" +

			        // Change Environment label and make it bold
			        "var envLabel = document.querySelector('.sysenv-container .card-header p');" + 
			        "if (envLabel) {" +
			        "   envLabel.textContent = 'Environment Details';" +
			        "   envLabel.style.fontWeight = 'bold';" +
			        "}" +

					 // Change 'events passed' to 'test steps passed' in the card footer
					 "var footerElements = document.querySelectorAll('.card-footer small');" +
					 "footerElements.forEach(function(element) {" +
					 "   if (element && element.innerHTML.includes('events passed')) {" +
					 "       element.innerHTML = element.innerHTML.replace(/(<b>\\d+<\\/b>) events passed/, '$1 test steps passed');" +
					 "   }" +
					 "});" +
					
					 // Change 'events failed' to 'test steps failed' in the card footer
					 "footerElements.forEach(function(element) {" +
					 "   if (element && element.innerHTML.includes('events failed')) {" +
					 "       element.innerHTML = element.innerHTML.replace(/(\\<b>\\d+\\<\\/b\\>) events failed/, '$1 test steps failed');" +
					 "   }" +
					 "});" +
					 
					//Find all rows in the Environment Details section and filter for 'Machine Name' rows
					"var envRows = document.querySelectorAll('.card-body table tbody tr');" +
					"var machineNameRows = Array.from(envRows).filter(function(row) {" +
					"   var cells = row.querySelectorAll('td');" +
					"   return cells.length > 0 && cells[0].textContent.trim() === 'Machine Name';" +
					"});" +
					// Remove all but the last 'Machine Name' row
					"while (machineNameRows.length > 1) {" +
					"   machineNameRows.shift().remove();" +
					"}" +
					
					// Find all rows in the Environment Details section and filter for 'OS' rows
					"var envRows = document.querySelectorAll('.card-body table tbody tr');" +
					"var OSRows = Array.from(envRows).filter(function(row) {" +
					"   var cells = row.querySelectorAll('td');" +
					"   return cells.length > 0 && cells[0].textContent.trim() === 'OS';" +
					"});" +
					// Remove all but the last 'OS' row
					"while (OSRows.length > 1) {" +
					"   OSRows.shift().remove();" +
					"}" +
					
					// Find all rows in the Environment Details section and filter for 'Test URL' rows
					"var envRows = document.querySelectorAll('.card-body table tbody tr');" +
					"var testURLRows = Array.from(envRows).filter(function(row) {" +
					"   var cells = row.querySelectorAll('td');" +
					"   return cells.length > 0 && cells[0].textContent.trim() === 'Test URL';" +
					"});" +
					// Remove all but the last 'OS' row
					"while (testURLRows.length > 1) {" +
					"   testURLRows.shift().remove();" +
					"}" +
					 
					// Find all rows in the Environment Details section and filter for 'Browser Name' rows
					"var envRows = document.querySelectorAll('.card-body table tbody tr');" +
					"var browserNameRows = Array.from(envRows).filter(function(row) {" +
					"   var cells = row.querySelectorAll('td');" +
					"   return cells.length > 0 && cells[0].textContent.trim() === 'Browser Name';" +
					"});" +
					
					// Remove all but the last 'Browser Name' row
					"while (browserNameRows.length > 1) {" +
					"   browserNameRows.shift().remove();" +
					"}" +
					
					// Process the remaining 'Browser Name' row to remove duplicate values within the cell (case-insensitive)
					"if (browserNameRows.length > 0) {" +
					"   var lastBrowserRow = browserNameRows[0];" +
					"   var browserCell = lastBrowserRow.querySelectorAll('td')[1];" +
					"   if (browserCell) {" +
					"       var seenBrowsers = new Set();" + // Track lowercase versions to ensure uniqueness
					"       var uniqueBrowsers = browserCell.textContent.split(',').filter(function(browser) {" +
					"           var lowerBrowser = browser.trim().toLowerCase();" +
					"           if (!seenBrowsers.has(lowerBrowser)) {" +
					"               seenBrowsers.add(lowerBrowser);" +
					"               return true;" + // Keep unique browser names only
					"           }" +
					"           return false;" + // Filter out duplicates
					"       }).map(function(browser) {" +
					"           return browser.trim();" + // Trim whitespace for each browser name
					"       }).join(', ');" +           // Join unique values with ', ' separator
					"       browserCell.textContent = uniqueBrowsers;" +
					"   }" +
					"}" +


					"});";

         htmlReporter.config().setJs(customJavaScript);

		return htmlReporter;
	}
	
	public static String getReportPath() {
		
		return filePath;
	}

	public static ExtentReports CreateExtentReportExtent(String browserName) throws IOException, MessagingException {
		String sModuleName = "";
		extent = ExtentManager.GetExtent(browserName);
		return (extent);
	}

	public static ExtentTest CreateExtentReportTest(ExtentReports extent, String browserName, String sTestID) {
		String sModuleName = "";
		test = ExtentManager.createTestNew(sModuleName, "TEST RESULTS", "_" + sTestID + "_" + browserName);
		return (test);
	}
	

	public static ExtentTest createTestNew(String name, String description, String sTestIDBrowserName) {
		name =  sTestIDBrowserName;
		test = extent.createTest(name, description);
		return test;
	}
	public static ExtentTest CreateExtentReportTest(ExtentReports extent, String cName, String scName, String browserName, String sTestID) throws IOException {
        String sModuleName = "";
        String testDescription = scName.replaceAll("(?s)(.*)", "<b>$1</b>").replaceAll("(?i)Prerequisites\\s*:", "<b><span style='color:green;'>Prerequisites:</span></b><br>")
		        .replaceAll("(?m)^\\*\\s+([^*]+)", "<span style='color:blue;'>* $1</span><br>")
		        .replaceAll("(?<=</span><br>)\\s*(?=Test Steps\\s*:)", "<br>")
		        .replaceAll("(?i)Test Steps\\s*:", "<br><b><span style='color:green;'>Test Steps:</span></b><br>")
		        .replaceAll("(?m)^(\\d+\\.)", "<br><span style='color:blue;'>$1</span>")
		        .replaceAll("(<br>\\s*){2,}", "<br>")
		        .replaceAll("(?m)^[\\s&&[^<]]*$", "");
//        GetExtent(browserName);
        test = ExtentManager.createTestNew(sModuleName, ""+testDescription, sTestID + "_" + browserName);
        

//        test = ExtentManager.createTestNew(sModuleName, "Test Steps : "+scName, "_" + sTestID + "_" + browserName);
        return (test);
    }

}
