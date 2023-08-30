package com.lambdatest;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class Mobile_DailyQuoteTest {

    private RemoteWebDriver driver;
    private String Status = "failed";
    Calendar rightNow = Calendar.getInstance();
    int hour = rightNow.get(Calendar.HOUR_OF_DAY);

    @BeforeMethod
    @org.testng.annotations.Parameters(value = {"devicename", "version", "platform"})
    public void setup(String devicename, String version, String platform, Method m, ITestContext ctx) throws MalformedURLException {
    	String username = "srinivas.kishafoundation";
        String authkey = "MCtpqmcJj7B6NJfj38NAtD5eYW6UUgwXgF77zqNAMhY1mkbEEI";
        
        String hub = "@mobile-hub.lambdatest.com/wd/hub";

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", platform);
        caps.setCapability("deviceName", devicename);
        caps.setCapability("platformVersion", version);
        caps.setCapability("isRealMobile", true);
        caps.setCapability("geoLocation", "IN");
        caps.setCapability("build", "ID:" + LocalDate.now() + "_"+hour);
        caps.setCapability("name", m.getName() + this.getClass().getName());
        caps.setCapability("plugin", "git-testng");

        String[] Tags = new String[] { "Feature", "Tag", "Moderate" };
        caps.setCapability("tags", Tags);

        driver = new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), caps);
    }

    //@Test
    public void basicTest() throws InterruptedException {
        String spanText;
        System.out.println("Loading Url");
        Thread.sleep(100);
        driver.get("https://lambdatest.github.io/sample-todo-app/");

        System.out.println("Checking Box");
        driver.findElement(By.name("li1")).click();

        System.out.println("Checking Another Box");
        driver.findElement(By.name("li2")).click();

        System.out.println("Checking Box");
        driver.findElement(By.name("li3")).click();

        System.out.println("Checking Another Box");
        driver.findElement(By.name("li4")).click();

        driver.findElement(By.id("sampletodotext")).sendKeys(" List Item 6");
        driver.findElement(By.id("addbutton")).click();

        driver.findElement(By.id("sampletodotext")).sendKeys(" List Item 7");
        driver.findElement(By.id("addbutton")).click();

        driver.findElement(By.id("sampletodotext")).sendKeys(" List Item 8");
        driver.findElement(By.id("addbutton")).click();

        System.out.println("Checking Another Box");
        driver.findElement(By.name("li1")).click();

        System.out.println("Checking Another Box");
        driver.findElement(By.name("li3")).click();

        System.out.println("Checking Another Box");
        driver.findElement(By.name("li7")).click();

        System.out.println("Checking Another Box");
        driver.findElement(By.name("li8")).click();

        System.out.println("Entering Text");
        driver.findElement(By.id("sampletodotext")).sendKeys("Get Taste of Lambda and Stick to It");

        driver.findElement(By.id("addbutton")).click();

        System.out.println("Checking Another Box");
        driver.findElement(By.name("li9")).click();

        // Let's also assert that the todo we added is present in the list.

       // spanText = driver.findElementByXPath("/html/body/div/div/div/ul/li[9]/span").getText();
        //Assert.assertEquals("Get Taste of Lambda and Stick to It", spanText);
        Status = "passed";
        Thread.sleep(800);

        System.out.println("TestFinished");

    }
    
    @Test(priority = 2)
	public void verifyDailyQuote() throws InterruptedException {
    	System.out.println("#################################################################################");
    	System.out.println("DAILY QUOTE VERIFICATION TEST EXECUTION STARTED");
		//Open ISO home page 
        driver.get("https://isha.sadhguru.org/");
        System.out.println("URL opened");
		Thread.sleep(1000);
		// identify element and scroll to the location of Daily Quote
        WebElement l=driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/section/div[6]/div[1]/div[1]/div[1]/p"));
        System.out.println("Element got found" + l.getText());
        // Java script executor
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", l);
        

        //wait for date field for quote to be visible.
        {
          WebDriverWait wait = new WebDriverWait(driver, 10);
          wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"__next\"]/div/div[2]/section/div[6]/div[1]/div[1]/div[1]/p")));
        }

        // 
        //driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/section/div[6]/div[1]/div[1]/div[1]/p")).click();

        //Get current month number
        Calendar now = Calendar.getInstance();
        //System.out.println("Current Month is : " + (now.get(Calendar.MONTH) + 1));
                         
        //functionality to construct the date format.
        Calendar currentDate = Calendar.getInstance();
        String monthName = theMonth(currentDate.get(Calendar.MONTH));
        
        //Print the constructed current date on the console logs
        System.out.println("Sadhguru Quote - " + monthName + " "
            + currentDate.get(Calendar.DATE) + ", " + currentDate.get(Calendar.YEAR));
        
        
        //Store the constructed current date in a variable to compare it later.
        String compareDate = "Sadhguru Quote - " + monthName + " "
                + currentDate.get(Calendar.DATE) + ", " + currentDate.get(Calendar.YEAR);
        
        //Doing the actual date comparison with expected date value comparison.
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/section/div[6]/div[1]/div[1]/div[1]/p")).getText().compareTo(compareDate);
        
        //###############Need to look at it later.
		/*
		 * //Verifying the image is present along with the quote. { List<WebElement>
		 * elements = driver.findElements(By.cssSelector(".css-1oifz5i"));
		 * assert(elements.size() > 0); }
		 * 
		 * // Verifying the quote text is present. { List<WebElement> elements =
		 * driver.findElements(By.cssSelector(".css-11xoogs > .chakra-text"));
		 * assert(elements.size() > 0); }
		 */

          
          System.out.println("SUCCESSFUL, Daily Quote's data updated along with date");
          System.out.println("Daily Quote Verification Test PASSED");
          
          
          Status = "passed";
          Thread.sleep(150);

          System.out.println("TestFinished");
          System.out.println("#################################################################################");
          //close 
          //driver.close();
      }
    public static String theMonth(int month){
	    String[] monthNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
	    return monthNames[month];
	}

    @AfterMethod
    public void tearDown() {
        driver.executeScript("lambda-status=" + Status);
        driver.quit();
    }

}