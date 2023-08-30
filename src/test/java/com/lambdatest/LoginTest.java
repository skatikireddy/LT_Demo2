package com.lambdatest;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

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


public class LoginTest {

    private RemoteWebDriver driver;
    private String Status = "failed";
    //String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
    Calendar rightNow = Calendar.getInstance();
    int hour = rightNow.get(Calendar.HOUR_OF_DAY);

    @BeforeMethod
    @org.testng.annotations.Parameters(value = {"browser", "version", "platform"})
    public void setup(String browser, String version, String platform, Method m, ITestContext ctx) throws MalformedURLException {
        
        String username = "srinivas.kishafoundation";
        String authkey = "MCtpqmcJj7B6NJfj38NAtD5eYW6UUgwXgF77zqNAMhY1mkbEEI";
        String hub = "@hub.lambdatest.com/wd/hub";

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platform", platform);
        caps.setCapability("browserName", browser);
        caps.setCapability("version", version);
        caps.setCapability("build", "ID:" + LocalDate.now() + "_"+hour);
        caps.setCapability("name", m.getName() + " - " + this.getClass().getName());
        caps.setCapability("plugin", "git-testng");
        caps.setCapability("console", true);
        caps.setCapability("terminal", true);
        String[] Tags = new String[] { "Feature", "Falcon", "Severe" };
        caps.setCapability("tags", Tags);

        driver = new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), caps);

    }
    

    @Test
	public void verifyLogin() throws InterruptedException {
	// declaration and instantiation of objects/variables  
        //System.setProperty("webdriver.chrome.driver", "/home/isha/Selenium/chromedriver-linux64/chromedriver");  
        //WebDriver driver=new ChromeDriver();
        
     // 2 | setWindowSize | 1366x729 |  | 
        //driver.manage().window().setSize(new Dimension(1366, 729));
        driver.manage().window().maximize();
        System.out.println("#################################################################################");
        System.out.println("LOGIN TEST EXECUTION STARTED");
    	// Test name: Login_Testcase
        // Step # | name | target | value | comment
        // 1 | open | / |  | 
        driver.get("https://isha.sadhguru.org/");
        
        // 3 | assertElementPresent | css=.css-131wcj4 > .chakra-image |  | 
        {
          List<WebElement> elements = driver.findElements(By.cssSelector(".css-131wcj4 > .chakra-image"));
          assert(elements.size() > 0);
        }
        // 4 | clickAt | xpath=//*[@id="__next"]/div/div[1]/header/div[2]/div/div[1]/img |  | 
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[1]/header/div[2]/div/div[1]/img")).click();
        // 5 | click | linkText=Login |  | 
        driver.findElement(By.linkText("Login")).click();
        // 6 | click | css=#withEmail > .head |  | 
        
        WebElement firstResult = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[4]/div[3]/section/div/div/div/div/div/div[1]/div/div[9]/div/div/div/div/a/div[2]")));
        // Print the first result
        System.out.println(firstResult.getText());
        
        
        /*if(driver.findElement(By.xpath("//*[@id=\\\"withEmail\\\"]/div[2]")).isDisplayed())
        {
        driver.findElement(By.xpath("//*[@id=\"withEmail\"]/div[2]")).click();
        }
        else
        	System.out.println("'Login with Email ID' field not present");*/
        // 7 | click | id=txtEmail |  | 
        driver.findElement(By.xpath("/html/body/div[4]/div[3]/section/div/div/div/div/div/div[1]/div/div[9]/div/div/div/div/a/div[2]")).click();
        // 8 | type | id=txtEmail | vasu.0018@gmail.com | 
        driver.findElement(By.id("txtEmail")).sendKeys("email@gmail.com");
        // 9 | click | id=txtPassword |  | 
        driver.findElement(By.id("txtPassword")).click();
        // 10 | type | id=txtPassword | r3st@rtl!f3 | 
        driver.findElement(By.id("txtPassword")).sendKeys("password");
        // 11 | click | id=btnLogin |  | 
        driver.findElement(By.id("btnLogin")).click();
        
			System.out.println("User Loged out SUCCESSFULL");
			System.out.println("Login Test SUCCESSFUL");
			Status = "passed";
	        Thread.sleep(150);

	        System.out.println("TestFinished");
	        System.out.println("#################################################################################");
       // driver.close();
        //driver.quit();
    }

    @AfterMethod
    public void tearDown() {
        driver.executeScript("lambda-status=" + Status);
        driver.quit();
    }

}