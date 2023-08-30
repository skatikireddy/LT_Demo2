package com.lambdatestDemo;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
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
import java.time.LocalDate;

public class BottomWidgetTest {

    private RemoteWebDriver driver;
    private String Status = "failed";

    @BeforeMethod
    public void setup(Method m, ITestContext ctx) throws MalformedURLException {
        
        String username = "srinivas.kishafoundation";
        String authkey = "MCtpqmcJj7B6NJfj38NAtD5eYW6UUgwXgF77zqNAMhY1mkbEEI";
        String hub = "@hub.lambdatest.com/wd/hub";
        
        
        
        
        DesiredCapabilities capabilities = new DesiredCapabilities();
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("w3c", true);
        ltOptions.put("platform", "Windows 11");
        ltOptions.put("browserName", "Chrome");
        ltOptions.put("browserVersion", "114");
        ltOptions.put("autoHeal",true);
        //ltOptions.put("build", "12:40");
        ltOptions.put("build", "VisualUI"+ LocalDate.now());
        ltOptions.put("console", true);
        capabilities.setCapability("lt:options", ltOptions);
        
		/*
		 * //ChromeOptions browserOptions = new ChromeOptions();
		 * browserOptions.setPlatformName("Windows 8.1");
		 * browserOptions.setBrowserVersion("100.0"); 
		 * HashMap<String, Object> ltOptions
		 * = new HashMap<String, Object>(); ltOptions.put("username",
		 * "srinivas.kishafoundation"); ltOptions.put("accessKey",
		 * "MCtpqmcJj7B6NJfj38NAtD5eYW6UUgwXgF77zqNAMhY1mkbEEI");
		 * ltOptions.put("project", "Untitled"); ltOptions.put("selenium_version",
		 * "3.13.0"); ltOptions.put("w3c", true);
		 * browserOptions.setCapability("LT:Options", ltOptions);
		 */

        
        
		/*
		 * DesiredCapabilities caps = new DesiredCapabilities();
		 * caps.setCapability("platform", "Windows 11");
		 * caps.setCapability("browserName", "Chrome"); caps.setCapability("version",
		 * "latest"); caps.setCapability("build", "TestNG With Java_Jenkins126");
		 * caps.setCapability("name", m.getName() + " - " + this.getClass().getName());
		 * caps.setCapability("plugin", "git-testng"); caps.setCapability("geoLocation",
		 * "IN"); caps.setCapability("console", true); caps.setCapability("terminal",
		 * true); String[] Tags = new String[] { "Feature", "Falcon", "Severe" };
		 * caps.setCapability("tags", Tags);
		 */

        driver = new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), capabilities);

    }
    

    @Test
	public void verifyBottomWidget() throws InterruptedException {
	// declaration and instantiation of objects/variables  
        //System.setProperty("webdriver.chrome.driver", "/home/isha/Selenium/chromedriver-linux64/chromedriver");  
        //WebDriver driver=new ChromeDriver();
        //WebDriver driver=new FirefoxDriver();
        //Open ISO web site
    	driver.get("https://isha.sadhguru.org/");
    	//Maximize the browser window
    	driver.manage().window().maximize();
    	
    	
    	/*
    	//#####################################################
    	//Click on Globe icon to select a country.
        driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/header/div[1]/div/div/div[3]/div[1]/div")).click();
        {
          WebElement element = driver.findElement(By.cssSelector(".css-12tysol .css-15lwwv6:nth-child(1) .css-nlkjvw"));
          Actions builder = new Actions(driver);
          builder.moveToElement(element).perform();
        }
                
        //Click on 'Australia' option.
        driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/header/div[1]/div/div/div[3]/div[2]/div/ul/li[1]/a/div")).click();
        
        //driver.findElement(By.cssSelector(".css-12tysol .css-15lwwv6:nth-child(1) .css-nlkjvw")).click();
        //vars.put("aus", js.executeScript("return window.location.href"));
        //assertEquals(vars.get("aus").toString(), "https://isha.sadhguru.org/au/en");
      
        //Verify the url updated according to the country selected.
        String compare = "https://isha.sadhguru.org/au/en";
        String url = driver.getCurrentUrl();
        url.equals(compare);
        
      
        //######################################################*/
    //Scroll down to bottom of the page.
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("window.scrollBy(0,document.body.scrollHeight);");
        
        
    	  
          {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".css-1fdja0t")));
          }

          {
            List<WebElement> elements = driver.findElements(By.cssSelector(".css-1fdja0t"));
            assert(elements.size() > 0);
          }

          driver.findElement(By.linkText("Close")).click();
          
          
          //#####################################################################################
          //################################################################################
          //Navigate to some marketing page and ensure the bottom widget not present there.
          driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/header/div[1]/div/div/div[2]/a/div")).click();
          
          try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
          try {
              //List<WebElement> elements = driver.findElements(By.xpath("/html/body/div[1]/div/div[1]/header/div[1]/div/div/div[2]/a/div"));
              //boolean isPresent = 
            	driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/header/div[1]/div/div/div[2]/a/div")).isDisplayed();
              System.out.println("Unsuccessful, Bottom Widget is Present under Marketing Page");
              
             }
          catch (org.openqa.selenium.NoSuchElementException e) {
        	  System.out.println("Successfull, Bottom Widget not Present under Marketing Page");
             }
        	        
        
          //Navigate back to Home page and ensure the bottom widget present there.
          driver.findElement(By.linkText("Back to Home Page")).click();
          
          try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
		/*
		 * // To check alternate case driver.get(
		 * "https://isha.sadhguru.org/in/en/sadhguru-exclusive?utm_campaign=sg-ex&utm_medium=website&utm_source=website-header1"
		 * ); try { Thread.sleep(3000); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
          
        	  try {
              //List<WebElement> elements = driver.findElements(By.xpath("/html/body/div[1]/div/div[1]/header/div[1]/div/div/div[2]/a/div"));
        	  boolean isPresent = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/header/div[1]/div/div/div[2]/a/div")).isDisplayed();
        	  System.out.println("Successfull, Bottom Widget is Present under Home Page");
        	  System.out.println("Bottom Widget Test PASSED");
        	  }catch (org.openqa.selenium.NoSuchElementException e) {
        		  System.out.println("Unsuccessful, Bottom Widget not Present under Home Page");
        	  }
        	  driver.close();
        	  //driver.quit();
                         
      //Verify the bottom Widget is visible.
    	//driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div")).isDisplayed();
    	
    	
    	//This can be used to ensure that the bottom widget is not present.
    	//driver.findElement(By.linkText("Close")).click();
    	
    	//ensure it's not visible now.
    	//driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div")).
    	
    	//refresh the web page and make sure it's not visible.
        	  Status = "passed";
              Thread.sleep(150);

              System.out.println("TestFinished");
    	
	}

    @AfterMethod
    public void tearDown() {
        driver.executeScript("lambda-status=" + Status);
        driver.quit();
    }

}