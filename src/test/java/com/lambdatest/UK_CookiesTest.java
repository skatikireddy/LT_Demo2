package com.lambdatest;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Calendar;

import org.openqa.selenium.By;
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


public class UK_CookiesTest {

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
    public void verifyukCookies() {
	// declaration and instantiation of objects/variables  
      // System.setProperty("webdriver.chrome.driver", "/home/isha/Selenium/chromedriver-linux64/chromedriver");  
       //WebDriver driver=new ChromeDriver();
       
     //maximize the browser window.
   	driver.manage().window().maximize();
   	
   	driver.get("https://isha.sadhguru.org/");
   	
       //driver.manage().window().setSize(new Dimension(1382, 744));
   	
   	
   	//Ensure cookie acceptance widget is not present in default page.
   	try {
   		driver.findElement(By.xpath("/html/body/div[1]/div/div[6]/div")).isDisplayed();
   		System.out.println("Unsuccessful, By default accept cookies is getting displayed on default home page");
   	}catch(org.openqa.selenium.NoSuchElementException e) {
   		
   		System.out.println("Successful, By default accept cookies widget is not getting displayed on default home page");
   	}
   	
   	//click on globe icon
       driver.findElement(By.cssSelector(".css-1jzfoes")).click();
       
       //select uk region.
       driver.findElement(By.cssSelector(".css-12tysol .css-15lwwv6:nth-child(6) .css-nlkjvw")).click();
       /*{
         WebElement element = driver.findElement(By.cssSelector(".css-36bdiy .css-0"));
         Actions builder = new Actions(driver);
         builder.moveToElement(element).perform();
       }
       
       {
         WebElement element = driver.findElement(By.tagName("body"));
         Actions builder = new Actions(driver);
         builder.moveToElement(element, 0, 0).perform();
       }*/
       
       
       
       
       
     //Ensure cookie acceptance widget is not present in default page.
   	try {
   		//wait for cookie widget to appear at bottom of the screen.
           {
             WebDriverWait wait = new WebDriverWait(driver, 30);
             wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".css-4zredz")));
           }
           
         //wait for the cookie message widget appears on screen.
           {
             WebDriverWait wait = new WebDriverWait(driver, 30);
             wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".css-4zredz")));
           }
           
   		driver.findElement(By.xpath("/html/body/div[1]/div/div[6]/div")).isDisplayed();
   		//verifiy that correct text appear on screen.
           driver.findElement(By.cssSelector(".css-jfezgn")).getText().contains("We use cookies to ensure you get the best experience on our website, including personalisation of ads. By using Isha.Sadhguru.org, you accept our use of cookies.");
         //click on close(x) on cookie widget.
           driver.findElement(By.cssSelector(".css-r8p76m")).click();
   		System.out.println("Successful, By default accept cookies message is getting displayed on uk&Europe home page");
   	}catch(org.openqa.selenium.NoSuchElementException e) {
   		
   		System.out.println("Unsuccessful, By default accept cookies message widget is not getting displayed on uk&Europe page");
   	}
       
       
               
       //click on globe icon.
       driver.findElement(By.cssSelector(".css-3w17oj")).click();
       
       //select australia region.
       driver.findElement(By.cssSelector(".css-12tysol .css-15lwwv6:nth-child(1) .css-nlkjvw")).click();
       
       //click on globe icon.
       driver.findElement(By.cssSelector(".css-3w17oj")).click();
       
       //select uk region again to ensure the cookie accept not prompted again.
       driver.findElement(By.cssSelector(".css-12tysol .css-15lwwv6:nth-child(6) .css-nlkjvw")).click();
      	try {
   		driver.findElement(By.xpath("/html/body/div[1]/div/div[6]/div")).isDisplayed();
   		System.out.println("Unsuccessful, accept cookies message is getting displayed even after it's is closed once under UK&Europe region");
   	}catch(org.openqa.selenium.NoSuchElementException e) {
   		
   		System.out.println("Successful, accept cookies message widget is not getting displayed on UK&Europe region once after it is closed");
   		System.out.println("uk Cookie verification Test PASSED");
   	}
      	
      	driver.close();
      	driver.quit();
   	
       /*{
         WebElement element = driver.findElement(By.cssSelector(".css-36bdiy .css-0"));
         Actions builder = new Actions(driver);
         builder.moveToElement(element).perform();
       }*/
     }
    
    @AfterMethod
    public void tearDown() {
        driver.executeScript("lambda-status=" + Status);
        driver.quit();
    }

}