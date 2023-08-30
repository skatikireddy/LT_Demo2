package com.lambdatest;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGTodoMobile1 {

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
    
    @Test
	public void verifyPageTitleonDevice() throws InterruptedException {
		
		//Open ISO home page 
        driver.get("https://isha.sadhguru.org/");
        System.out.println(driver.getTitle());
        
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Page Title verification Successful");
		
		driver.findElement(By.className("css-15nocqh")).click();
		System.out.println("click1 Done");
		driver.findElement(By.className("css-1g4xys3")).click();
		System.out.println("click2 Done");
		Thread.sleep(1000);
		//driver.findElement(By.xpath("Australia")).click();
		//driver.findElement(By.linkText("Australia")).click();
		//driver.findElement(By.className("css-nlkjvw")).click();
		System.out.println("click3 Done");
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[1]/header/div[3]/div[3]/div[1]/div[2]/div[1]/div/div[2]/div/ul/li[1]/a/div")).click();
		System.out.println("#########################################################");
		
		Status = "passed";
        Thread.sleep(1000);

        System.out.println("TestFinished");
      }

    @AfterMethod
    public void tearDown() {
        driver.executeScript("lambda-status=" + Status);
        driver.quit();
    }

}