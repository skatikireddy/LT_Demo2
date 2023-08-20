package com.lambdatest;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Calendar;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;


public class SampleCookieTest {

    private RemoteWebDriver driver;
    private String Status = "failed";

    @BeforeMethod
    public void setup(Method m, ITestContext ctx) throws MalformedURLException {
        
        String username = "srinivas.kishafoundation";
        String authkey = "MCtpqmcJj7B6NJfj38NAtD5eYW6UUgwXgF77zqNAMhY1mkbEEI";
        String hub = "@hub.lambdatest.com/wd/hub";

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platform", "Windows 11");
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("version", "latest");
        caps.setCapability("build", "TestNG With Java_Jenkins126");
        caps.setCapability("name", m.getName() + " - " + this.getClass().getName());
        caps.setCapability("plugin", "git-testng");
        caps.setCapability("console", true);
        caps.setCapability("terminal", true);
        String[] Tags = new String[] { "Feature", "Falcon", "Severe" };
        caps.setCapability("tags", Tags);

        driver = new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), caps);

    }
    
   @Test
    public void sampleCookieVerification() throws InterruptedException {
    	// declaration and instantiation of objects/variables  
            //System.setProperty("webdriver.chrome.driver", "/home/isha/Selenium/chromedriver-linux64/chromedriver");  
            //WebDriver driver=new ChromeDriver();
            driver.manage().window().maximize();
            
            driver.get("https://isha.sadhguru.org/uk/en");
          //get all the cookies
        	Set <Cookie> cookies = null;
        	try {
    			Thread.sleep(3000);
    		} catch (InterruptedException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
        	//cookies.clear();
        	cookies = driver.manage().getCookies();
        	
        	try {
    			Thread.sleep(5000);
    		} catch (InterruptedException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
        		
        	//print the size of the cookies
        	System.out.println("Total number of cookies Before deletion is " + cookies.size());
        	
        	/*for(Cookie cookie : cookies) {
        		System.out.println(cookie.getName() + ":" + cookie.getValue());
        	}*/
        	
        	if(driver.manage().getCookieNamed("bottom_widget") != null)
        	{
        		System.out.println("Cookie Bottom Widget is Present");
        	}
        	else
        		System.out.println("Cookie Bottom Widget does not Exists");
        	
            driver.manage().deleteCookieNamed("bottom_widget");
            try {
    			Thread.sleep(3000);
    		} catch (InterruptedException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
          //cookies.clear();
        	cookies = driver.manage().getCookies();
        		
        	//print the size of the cookies
        	System.out.println("Total number of cookies After deletion is " + cookies.size());
        	
        	/*for(Cookie cookie : cookies) {
        		System.out.println(cookie.getName() + ":" + cookie.getValue());
        	}*/
        	
        	if(driver.manage().getCookieNamed("bottom_widget") != null)
        	{
        		System.out.println("Cookie 'Bottom Widget' not Deleted");
        	}
        	else {
        		System.out.println("SUCCESSFULLY, Cookie 'Bottom Widget' got deleted.");
        	System.out.println("Cookie Deletion test passed");
        	}
        	
        	Status = "passed";
            Thread.sleep(150);

            System.out.println("TestFinished");
        	//driver.close();
        	//driver.quit();
        }

    @AfterMethod
    public void tearDown() {
        driver.executeScript("lambda-status=" + Status);
        driver.quit();
    }

}