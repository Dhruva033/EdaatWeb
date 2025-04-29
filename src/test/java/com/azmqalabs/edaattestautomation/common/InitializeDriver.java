package com.azmqalabs.edaattestautomation.common;
import java.io.File;
import java.net.Inet4Address;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.openqa.selenium.Platform;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.appium.java_client.android.*;
//import io.appium.java_client.AppiumDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import com.azmqalabs.edaattestautomation.apppages.GlobalConstant;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.core.har.HarEntry;
import net.lightbody.bmp.proxy.CaptureType;
import net.lightbody.bmp.proxy.ProxyServer;

public class InitializeDriver {

	private WebDriver driver;
	
	public WebDriver initDriver(String browser) throws Exception
	 {		
		String sDriverType=Config.Get("DRIVER.TYPE");
		if (sDriverType.equalsIgnoreCase("remotedriver"))
	  		driver=initRemoteWebDriver(browser);
	  	else if (sDriverType.equalsIgnoreCase("webdriver"))
	  		driver=initWebDriver(browser);
	  	else if(sDriverType.equalsIgnoreCase("APPIUMDRIVER"))
	  		driver=initAppiumDriver(browser);
		return(driver);
	 }
	
public WebDriver initAppiumDriver(String browser) throws MalformedURLException {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		if(Config.Get("MOB.deviceType").equalsIgnoreCase("Emulator")){
		
		//Emulator:.
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.1.1");
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
			capabilities.setCapability(MobileCapabilityType.CLEAR_SYSTEM_FILES, true);
			capabilities.setCapability(MobileCapabilityType.APPIUM_VERSION,"1.13.0");
			ChromeOptions options=new ChromeOptions();
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		}
		if(Config.Get("MOB.deviceType").equalsIgnoreCase("MOBILE")){
		  if(Config.Get("MOB.platformName").equalsIgnoreCase("Android")){
			  
			  	capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
				capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
				capabilities.setCapability(MobileCapabilityType.CLEAR_SYSTEM_FILES, true);
				capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "RZ8M31KCQ1Y");
				capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "CHROME");
				
		  }
		  if(Config.Get("MOB.platformName").equalsIgnoreCase("iOS")){
			
		}
		}
		driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		
		return (driver);
		
	}
	
    public WebDriver initRemoteWebDriver(String browser) throws Exception
		 {
			  DesiredCapabilities cap = null;
			  int objSyncTime=Integer.parseInt(Config.Get("DRIVER.OBJ.SYNCTIME"));
			  String testMachine=Config.Get("TEST.MACHINE");
			  
			 if (browser.equals("firefox")) {
				   cap = DesiredCapabilities.firefox();
				   cap.setBrowserName("firefox");
				   cap.setPlatform(Platform.WINDOWS);
				  } else if (browser.equals("chrome")) {
				   cap = DesiredCapabilities.chrome();
				   cap.setBrowserName("chrome");
				   cap.setPlatform(Platform.WINDOWS);
				  }  else if (browser.equals("Edge")){
					  cap=DesiredCapabilities.edge();
					  cap.setBrowserName("MicrosoftEdge");
				  }
				  else if (browser.equals("ie")) {
					  cap = DesiredCapabilities.internetExplorer();
					  cap.setCapability("ie.ensureCleanSession", true);
					  cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				  }
			  
			 RemoteWebDriver driver = new RemoteWebDriver(new URL(testMachine), cap);
			  driver.manage().window().maximize();
			  driver.manage().timeouts().implicitlyWait(objSyncTime, TimeUnit.SECONDS);
			 return(driver);
		}
	
	
    
    public WebDriver initWebDriver(String browser) throws Exception
 		 {
    	int objSyncTime=Integer.parseInt(Config.Get("DRIVER.OBJ.SYNCTIME"));
    	
  	  if (browser.equalsIgnoreCase("firefox"))
	  {
	  	WebDriverManager.firefoxdriver().setup();
		DesiredCapabilities caps = DesiredCapabilities.firefox();
		caps.setPlatform(Platform.WINDOWS);
		caps.setCapability("marionette", true);
		driver = new FirefoxDriver(caps);
		driver.manage().window().maximize();
	  }
	  else if (browser.equalsIgnoreCase("chrome")){
	  
	  		if (Config.Get("CHROME.RESPONSIVE").equalsIgnoreCase("yes"))
	  		{
			  	WebDriverManager.chromedriver().setup();
		  		
		  		HashMap<String, String> mobileEmulation = new HashMap<String, String>(); 
		  		mobileEmulation.put("deviceName", "iPad Pro");    //Galaxy S5, Pixel 2, Pixel 2 XL, iPhone 5/SE, iPhone 6/7/8. iPhone 6, iPhone X, iPad, iPad Pro
				HashMap<String, Object> chromeOptions = new HashMap<String, Object>(); 
				chromeOptions.put("mobileEmulation", mobileEmulation); 
				DesiredCapabilities caps = DesiredCapabilities.chrome();
				caps.setCapability(ChromeOptions.CAPABILITY, chromeOptions); 
				
				if (Config.Get("CHROME.HEADLESS").equalsIgnoreCase("yes")){
					chromeOptions.put("args", Arrays.asList("headless",
							"--no-sandbox", "--window-size=1325,744", "ignore-certificate-errors"));
				
					caps.setCapability("acceptInsecureCerts", true);
		  			caps.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
	  			}
				
				driver = new ChromeDriver(caps);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(objSyncTime, TimeUnit.SECONDS);
	  		}
	  		else if (Config.Get("CHROME.NETWORK.TRAFFIC").equalsIgnoreCase("yes"))
	  		{

	  			BrowserMobProxyServer server;
	  			server = new BrowserMobProxyServer();
	  			server.setTrustAllServers(true);
	  			 server.start(0);
	  			server.newHar("Edaat");

	  			 int port = server.getPort();
	  			 Proxy proxy = ClientUtil.createSeleniumProxy(server);
	  			WebDriverManager.chromedriver().setup();
	  			 DesiredCapabilities seleniumCapabilities = new DesiredCapabilities();
	  			seleniumCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
	  			 seleniumCapabilities.setCapability(CapabilityType.PROXY, proxy);
	  			 
	  			
	  			this.driver = new ChromeDriver(seleniumCapabilities);
	  			 
	  			 System.out.println("Port started:" + port);
	  			 
	  			server.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);
  			server.newHar("Edaat");
	  			 
	  			 driver.get("http://www.Edaat.com/");
  			 
	
	  			server.stop();
	  			

	  		}
	  		else
	  		{
				/*
				 * File classpathRoot = new File(System.getProperty("user.dir")); File app = new
				 * File(classpathRoot, "SeleniumGrid//chromedriver.exe"); String PROP_FILE =
				 * app.getAbsolutePath(); System.setProperty("webdriver.chrome.driver",
				 * PROP_FILE);
				 */
	  			WebDriverManager.chromedriver().setup();
	  			DesiredCapabilities caps = DesiredCapabilities.chrome();
	  			
	  			String MavenCmdLineheadless="";
	  			MavenCmdLineheadless=System.getProperty("headlesstest");
				System.out.println("Maven externalized parameter: "+MavenCmdLineheadless);	
				if (MavenCmdLineheadless==null)
					MavenCmdLineheadless=Config.Get("CHROME.HEADLESS");
				else
				{
					if (MavenCmdLineheadless.equalsIgnoreCase("yes"))
						MavenCmdLineheadless="yes";
					else if(MavenCmdLineheadless.equalsIgnoreCase("no"))
						MavenCmdLineheadless="no";
				}
	  			
	  			ChromeOptions options=new ChromeOptions();
	  			if (MavenCmdLineheadless.equalsIgnoreCase("yes")){
		  			options.addArguments("headless");
		  			options.addArguments("--no-sandbox");
		  			options.addArguments("--window-size=1325,744");
		  			options.merge(caps);
		  			caps.setCapability(ChromeOptions.CAPABILITY, options);
		  			caps.setCapability("acceptInsecureCerts", true);	
	  			}
	  			
	  			this.driver = new ChromeDriver(caps);
	  			driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(objSyncTime, TimeUnit.SECONDS);
				
			}
	  }
	  else if (browser.equalsIgnoreCase("ie")){
		  	WebDriverManager.iedriver().setup();
		  	DesiredCapabilities dcie = DesiredCapabilities.internetExplorer();
			dcie.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);							
			driver = new InternetExplorerDriver(dcie);
			driver.manage().window().maximize();
			 driver.manage().timeouts().implicitlyWait(objSyncTime, TimeUnit.SECONDS);
	  }
	  else if (browser.equalsIgnoreCase("Edge")){
		    WebDriverManager.edgedriver().setup();         
            driver = new EdgeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(objSyncTime, TimeUnit.SECONDS);
      }
 		
  	 return(driver);
 }
    
    
    public Proxy getSeleniumProxy(BrowserMobProxy proxyServer) {
    	Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxyServer);
    	try {
    	String hostIp = Inet4Address.getLocalHost().getHostAddress();
    	seleniumProxy.setHttpProxy(hostIp + ":" + proxyServer.getPort());
    	seleniumProxy.setSslProxy(hostIp + ":" + proxyServer.getPort());
    	} catch (UnknownHostException e) {
    	e.printStackTrace();
    	Assert.fail("invalid Host Address");
    	}
    	return seleniumProxy;
    	}
    	public BrowserMobProxy getProxyServer() {
    	BrowserMobProxy proxy = new BrowserMobProxyServer();
    	proxy.setTrustAllServers(true);
    	proxy.start();
    	return proxy;
    	}  
    
}



