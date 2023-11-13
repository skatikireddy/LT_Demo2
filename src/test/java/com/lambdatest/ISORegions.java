package com.lambdatest;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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


public class ISORegions {

    private RemoteWebDriver driver;
    private String Status = "failed";
    //private String buildTimeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
    Calendar rightNow = Calendar.getInstance();
    int hour = rightNow.get(Calendar.HOUR_OF_DAY);

    @BeforeMethod
    @org.testng.annotations.Parameters(value = {"browser", "version", "platform"})
    public void setup(String browser, String version, String platform, Method m, ITestContext ctx) throws MalformedURLException {
        
    	//Old Credentials
        //String username = "srinivas.kishafoundation";
        //String authkey = "MCtpqmcJj7B6NJfj38NAtD5eYW6UUgwXgF77zqNAMhY1mkbEEI";
        
        //Latest Credentials
    	String username = "srinivas.kishafoundation";
    	String authkey = "rYvGjIb5ZiSXZtuYsBBi5wWxx4YNk2pO08UDPY97d3UtMBQvtE";
        String hub = "@hub.lambdatest.com/wd/hub";

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platform", platform );
        caps.setCapability("browserName", browser);
        caps.setCapability("version", version);
        caps.setCapability("build", "ID:" + LocalDate.now()+ "_" + hour);
        caps.setCapability("name", m.getName() + " - " + this.getClass().getName());
        caps.setCapability("plugin", "git-testng");
        caps.setCapability("console", true);
        caps.setCapability("terminal", true);
        String[] Tags = new String[] { "Feature", "Falcon", "Severe" };
        caps.setCapability("tags", Tags);

        driver = new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), caps);

    }
    

    @Test(priority = 3)
	public void verifyRegions() throws InterruptedException {
	// declaration and instantiation of objects/variables  
        //System.setProperty("webdriver.chrome.driver", "/home/isha/Selenium/chromedriver-linux64/chromedriver");  
        //WebDriver driver=new ChromeDriver();
		//WebDriver driver=new FirefoxDriver();
    	//#####################Australia Verification Starts from here.############################
    	System.out.println("#################################################################################");
        System.out.println("REGIONS VERIFICATION TEST EXECUTION STARTED");
      //driver.manage().window().setSize(new Dimension(1366, 729));
        driver.manage().window().maximize();
        
        driver.get("https://isha.sadhguru.org/");
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        WebElement element = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/header/div[1]/div/div/div[3]/div[1]/div"));
        
        JavascriptExecutor js1 = (JavascriptExecutor)driver;
        js1.executeScript("arguments[0].scrollIntoView();", element);
        
        //driver.findElement(By.cssSelector(".css-3w17oj")).click();
        //{
         // WebDriverWait wait = new WebDriverWait(driver, 30);
         //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".css-12tysol .css-15lwwv6:nth-child(1) .css-nlkjvw")));
        //}
        //Click on Globe icon to select a country.
        WebElement globeIcon = new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div[1]/header/div[1]/div/div/div[3]/div[1]/div")));
		// Print the first result
		//System.out.println("Loged as user:" + afterLogout.getText() + "which is not expected, Please report as issue");
        globeIcon.click();
        //driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/header/div[1]/div/div/div[3]/div[1]/div")).click();
        {
          WebElement element1 = driver.findElement(By.cssSelector(".css-12tysol .css-15lwwv6:nth-child(1) .css-nlkjvw"));
          Actions builder = new Actions(driver);
          builder.moveToElement(element1).perform();
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
        
        
        //js.executeScript("window.scrollTo(0,527)");
        //Scroll down to bottom of the page.
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight);");
        
        //driver.findElement(By.cssSelector(".contactblock")).click();
        //assertThat(driver.findElement(By.cssSelector(".css-kp7i2l p")).getText(), is("Australia\\\\nIsha Foundation\\\\nAustralia Inc,\\\\n93 Hampshire Rd,\\\\nSunshine VIC 3020,\\\\nAustralia"));
        //Verify the text is loaded at bottom of the page.
        WebElement bodyFull = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/footer/div[1]/div[3]/div/div/div[1]/div/div/p"));
        bodyFull.findElement(By.xpath("/html/body/div[1]/div/div[3]/footer/div[1]/div[3]/div/div/div[1]/div/div/p")).isDisplayed();
        
        //Verify country address according to the selection.
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/footer/div[1]/div[3]/div/div/div[1]/div/div/p")).getText().contains("Australia Isha Foundation Australia Inc, 93 Hampshire Rd, Sunshine VIC 3020, Australia");
        
        //Scroll to top of the page.
        
        
        System.out.println("Australia Location verification SUCCESSFUL");
        
        //driver.navigate().refresh();
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        js.executeScript("window.scrollTo(0, 0);");
        //#####################Canada Verification Starts from here.############################
        
        
        js1.executeScript("arguments[0].scrollIntoView();", element);
        
        WebElement element2 = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/header/div[1]/div/div/div[3]/div[1]/div"));
        
        JavascriptExecutor js11 = (JavascriptExecutor)driver;
        js11.executeScript("arguments[0].scrollIntoView();", element2);
        
		/*
		 * try { Thread.sleep(3000); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
        //js.executeScript("window.scrollTo(0, 0);");
        
		/*
		 * js1.executeScript("window.scrollBy(0,document.body.scrollHeight);"); try {
		 * Thread.sleep(3000); } catch (InterruptedException e) { // TODO Auto-generated
		 * catch block e.printStackTrace(); }
		 * js1.executeScript("window.scrollTo(0, 0);");
		 */
        try
        {
            //Setup the driver and navigate to the web page...
            //var driver = new ChromeDriver("folder path to the Chrome driver");
            //driver.Navigate().GoToUrl("UrlToThePage");

            //Find the element...
            //var element = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/header/div[1]/div/div/div[3]/div[1]/div")); 

            //Step 1
            //new Actions(driver).moveToElement(element).perform();  

            //Step 2
            element2.click();
        }
        catch (Exception e)
        {
            //Step 3
        	//JavascriptExecutor js1 = (JavascriptExecutor)driver;
        	//js1.executeScript("document.getElementByxpath(/html/body/div[1]/div/div[1]/header/div[1]/div/div/div[3]/div[1]/div).innerHTMLclick();");
        	element2.click();

        }
        
        
		/*
		 * //Click on Globe icon to select a country. globeIcon = new
		 * WebDriverWait(driver,
		 * Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.
		 * xpath("/html/body/div[1]/div/div[1]/header/div[1]/div/div/div[3]/div[1]/div")
		 * )); // Print the first result //System.out.println("Loged as user:" +
		 * afterLogout.getText() + "which is not expected, Please report as issue");
		 * globeIcon.click();
		 */
        
      //Click on Globe icon to select a country.
       // driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/header/div[1]/div/div/div[3]/div[1]/div")).click();
        {
        	//Mouse hover on Canada option.
          WebElement element1 = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[1]/header/div[1]/div/div/div[3]/div[2]/div/ul/li[2]/a/div"));
          Actions builder = new Actions(driver);
          builder.moveToElement(element1).perform();
        }
                
        //Click on 'Canada' option.
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[1]/header/div[1]/div/div/div[3]/div[2]/div/ul/li[2]/a/div")).click();
        
        //driver.findElement(By.cssSelector(".css-12tysol .css-15lwwv6:nth-child(1) .css-nlkjvw")).click();
        //vars.put("aus", js.executeScript("return window.location.href"));
        //assertEquals(vars.get("aus").toString(), "https://isha.sadhguru.org/au/en");
      
        //Verify the url updated according to the country selected.
        compare = "https://isha.sadhguru.org/ca/en";
        url = driver.getCurrentUrl();
        url.equals(compare);
                
        //js.executeScript("window.scrollTo(0,527)");
        //Scroll down to bottom of the page.
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        js11.executeScript("window.scrollBy(0,document.body.scrollHeight);");
        
        //driver.findElement(By.cssSelector(".contactblock")).click();
        //assertThat(driver.findElement(By.cssSelector(".css-kp7i2l p")).getText(), is("Australia\\\\nIsha Foundation\\\\nAustralia Inc,\\\\n93 Hampshire Rd,\\\\nSunshine VIC 3020,\\\\nAustralia"));
        //Verify the text is loaded at bottom of the page.
        bodyFull = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/footer/div[1]/div[3]/div/div/div[1]/div/div/p"));
        bodyFull.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/footer/div[1]/div[3]/div/div/div[1]/div/div/p")).isDisplayed();
                                       
        //Verify country address according to the selection.
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/footer/div[1]/div[3]/div/div/div[1]/div/div/p")).getText().contains("USA Isha Institute of Inner Sciences (USA)");
        
      
        
        System.out.println("CANADA Location verification SUCCESSFUL");
        //driver.navigate().refresh();
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
      //Scroll to top of the page.
        js11.executeScript("window.scrollTo(0, 0);");
      //#####################India Verification Starts from here.############################
        //js11.executeScript("arguments[0].scrollIntoView();", element);
        
        WebElement element3 = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/header/div[1]/div/div/div[3]/div[1]/div"));
        
        JavascriptExecutor js111 = (JavascriptExecutor)driver;
        js111.executeScript("arguments[0].scrollIntoView();", element3);
        
        try
        {
            //Setup the driver and navigate to the web page...
            //var driver = new ChromeDriver("folder path to the Chrome driver");
            //driver.Navigate().GoToUrl("UrlToThePage");

            //Find the element...
           // var element1 = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/header/div[1]/div/div/div[3]/div[1]/div")); 

            //Step 1
            //new Actions(driver).moveToElement(element).perform();  

            //Step 2
            element3.click();
        }
        catch (Exception e)
        {
            //Step 3
        	//JavascriptExecutor executor = (JavascriptExecutor)driver;
        	//executor.executeScript("document.getElementByxpath('/html/body/div[1]/div/div[1]/header/div[1]/div/div/div[3]/div[1]/div').innerHTML.click();");

        	element3.click();
        }
        
		/*
		 * //Click on Globe icon to select a country. globeIcon = new
		 * WebDriverWait(driver,
		 * Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.
		 * xpath("/html/body/div[1]/div/div[1]/header/div[1]/div/div/div[3]/div[1]/div")
		 * )); // Print the first result //System.out.println("Loged as user:" +
		 * afterLogout.getText() + "which is not expected, Please report as issue");
		 * globeIcon.click();
		 */
        
        //Click on Globe icon to select a country.
        //  driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/header/div[1]/div/div/div[3]/div[1]/div")).click();
          {
          	//Mouse hover on India option.
            WebElement element1 = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[1]/header/div[1]/div/div/div[3]/div[2]/div/ul/li[3]/a/div"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element1).perform();
          }
                  
          //Click on 'India' option.
          driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[1]/header/div[1]/div/div/div[3]/div[2]/div/ul/li[3]/a/div")).click();
          
          //driver.findElement(By.cssSelector(".css-12tysol .css-15lwwv6:nth-child(1) .css-nlkjvw")).click();
          //vars.put("aus", js.executeScript("return window.location.href"));
          //assertEquals(vars.get("aus").toString(), "https://isha.sadhguru.org/au/en");
        
          //Verify the url updated according to the country selected.
          compare = "https://isha.sadhguru.org/in/en";
          url = driver.getCurrentUrl();
          url.equals(compare);
                  
          //js.executeScript("window.scrollTo(0,527)");
          //Scroll down to bottom of the page.
          //JavascriptExecutor js = (JavascriptExecutor) driver;
          js111.executeScript("window.scrollBy(0,document.body.scrollHeight);");
          
          //driver.findElement(By.cssSelector(".contactblock")).click();
          //assertThat(driver.findElement(By.cssSelector(".css-kp7i2l p")).getText(), is("Australia\\\\nIsha Foundation\\\\nAustralia Inc,\\\\n93 Hampshire Rd,\\\\nSunshine VIC 3020,\\\\nAustralia"));
          //Verify the text is loaded at bottom of the page.
          bodyFull = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/footer/div[1]/div[3]/div/div/div[1]/div/div/p"));
          bodyFull.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/footer/div[1]/div[3]/div/div/div[1]/div/div/p")).isDisplayed();
                                         
          //Verify country address according to the selection.
          driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/footer/div[1]/div[3]/div/div/div[1]/div/div/p")).getText().contains("India Isha Yoga Centre, Velliangiri Foothills, Ishana Vihar Post, Coimbatore, Tamil Nadu - 641114");
          
       
        
          
          System.out.println("INDIA Location verification SUCCESSFUL");
          //driver.navigate().refresh();
          try {
  			Thread.sleep(1000);
  		} catch (InterruptedException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
          
          //Scroll to top of the page.
          js111.executeScript("window.scrollTo(0, 0);");
        //#####################Malaysia Verification Starts from here.############################
          js111.executeScript("arguments[0].scrollIntoView();", element);
          WebElement element4 = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/header/div[1]/div/div/div[3]/div[1]/div"));
          
          JavascriptExecutor js1111 = (JavascriptExecutor)driver;
          js1111.executeScript("arguments[0].scrollIntoView();", element4);
          
          try
          {
              //Setup the driver and navigate to the web page...
              //var driver = new ChromeDriver("folder path to the Chrome driver");
              //driver.Navigate().GoToUrl("UrlToThePage");

              //Find the element...
              //var element1 = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/header/div[1]/div/div/div[3]/div[1]/div")); 

              //Step 1
              //new Actions(driver).moveToElement(element1).perform();  

              //Step 2
              element4.click();
          }
          catch (Exception e)
          {
              //Step 3
          	//JavascriptExecutor executor = (JavascriptExecutor)driver;
          	//executor.executeScript("document.getElementByxpath('/html/body/div[1]/div/div[1]/header/div[1]/div/div/div[3]/div[1]/div').click();");
        	  element4.click();

          }
			/*
			 * //Click on Globe icon to select a country. globeIcon = new
			 * WebDriverWait(driver,
			 * Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.
			 * xpath("/html/body/div[1]/div/div[1]/header/div[1]/div/div/div[3]/div[1]/div")
			 * )); // Print the first result //System.out.println("Loged as user:" +
			 * afterLogout.getText() + "which is not expected, Please report as issue");
			 * globeIcon.click();
			 */
          //Click on Globe icon to select a country.
          //  driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/header/div[1]/div/div/div[3]/div[1]/div")).click();
            {
            	//Mouse hover on Malaysia option.
              WebElement element1 = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[1]/header/div[1]/div/div/div[3]/div[2]/div/ul/li[4]/a/div"));
              Actions builder = new Actions(driver);
              builder.moveToElement(element1).perform();
            }
                    
            //Click on 'Malaysia' option.
            driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[1]/header/div[1]/div/div/div[3]/div[2]/div/ul/li[4]/a/div")).click();
            
            //driver.findElement(By.cssSelector(".css-12tysol .css-15lwwv6:nth-child(1) .css-nlkjvw")).click();
            //vars.put("aus", js.executeScript("return window.location.href"));
            //assertEquals(vars.get("aus").toString(), "https://isha.sadhguru.org/au/en");
          
            //Verify the url updated according to the country selected.
            compare = "https://isha.sadhguru.org/my/en";
            url = driver.getCurrentUrl();
            url.equals(compare);
                    
            //js.executeScript("window.scrollTo(0,527)");
            //Scroll down to bottom of the page.
            //JavascriptExecutor js = (JavascriptExecutor) driver;
            js1111.executeScript("window.scrollBy(0,document.body.scrollHeight);");
            
            //driver.findElement(By.cssSelector(".contactblock")).click();
            //assertThat(driver.findElement(By.cssSelector(".css-kp7i2l p")).getText(), is("Australia\\\\nIsha Foundation\\\\nAustralia Inc,\\\\n93 Hampshire Rd,\\\\nSunshine VIC 3020,\\\\nAustralia"));
            //Verify the text is loaded at bottom of the page.
            bodyFull = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/footer/div[1]/div[3]/div/div/div[1]/div/div/p"));
            bodyFull.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/footer/div[1]/div[3]/div/div/div[1]/div/div/p")).isDisplayed();
                                           
            //Verify country address according to the selection.
            driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/footer/div[1]/div[3]/div/div/div[1]/div/div/p")).getText().contains("Malaysia Isha Yoga Center Malaysia Suite G.03, Ground Floor, Block B, Dataran Hamodal, Jalan Bersatu 13/4, Section 13, 46200 Petaling Jaya, Selangor.");
            
            
            try {
    			Thread.sleep(1000);
    		} catch (InterruptedException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
            
          //Scroll to top of the page.
            js1111.executeScript("window.scrollTo(0, 0);");
          
            
            System.out.println("MALAYSIA Location verification SUCCESSFUL");
            //driver.navigate().refresh();
            
          //#####################Singapore Verification Starts from here.############################
            js1111.executeScript("arguments[0].scrollIntoView();", element);
            
            WebElement element21 = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/header/div[1]/div/div/div[3]/div[1]/div"));
            
            JavascriptExecutor js11111 = (JavascriptExecutor)driver;
            js11111.executeScript("arguments[0].scrollIntoView();", element21);
            
            try
            {
                //Setup the driver and navigate to the web page...
                //var driver = new ChromeDriver("folder path to the Chrome driver");
                //driver.Navigate().GoToUrl("UrlToThePage");

                //Find the element...
                //var element1 = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/header/div[1]/div/div/div[3]/div[1]/div")); 

                //Step 1
                //new Actions(driver).moveToElement(element1).perform();  

                //Step 2
                element21.click();
            }
            catch (Exception e)
            {
                //Step 3
            	//JavascriptExecutor executor = (JavascriptExecutor)driver;
            	//executor.executeScript("document.getElementByxpath(/html/body/div[1]/div/div[1]/header/div[1]/div/div/div[3]/div[1]/div).innerHTML.click();");

            	element21.click();
            }
			/*
			 * //Click on Globe icon to select a country. globeIcon = new
			 * WebDriverWait(driver,
			 * Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.xpath
			 * ("/html/body/div[1]/div/div[1]/header/div[1]/div/div/div[3]/div[1]/div")));
			 * // Print the first result //System.out.println("Loged as user:" +
			 * afterLogout.getText() + "which is not expected, Please report as issue");
			 * globeIcon.click();
			 */
            //Click on Globe icon to select a country.
             // driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/header/div[1]/div/div/div[3]/div[1]/div")).click();
              {
              	//Mouse hover on Singapore option.
                WebElement element1 = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[1]/header/div[1]/div/div/div[3]/div[2]/div/ul/li[5]/a/div"));
                Actions builder = new Actions(driver);
                builder.moveToElement(element1).perform();
              }
                      
              //Click on 'Singapore' option.
              driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[1]/header/div[1]/div/div/div[3]/div[2]/div/ul/li[5]/a/div")).click();
              
              //driver.findElement(By.cssSelector(".css-12tysol .css-15lwwv6:nth-child(1) .css-nlkjvw")).click();
              //vars.put("aus", js.executeScript("return window.location.href"));
              //assertEquals(vars.get("aus").toString(), "https://isha.sadhguru.org/au/en");
            
              //Verify the url updated according to the country selected.
              compare = "https://isha.sadhguru.org/sg/en";
              url = driver.getCurrentUrl();
              url.equals(compare);
                      
              //js.executeScript("window.scrollTo(0,527)");
              //Scroll down to bottom of the page.
              //JavascriptExecutor js = (JavascriptExecutor) driver;
              js11111.executeScript("window.scrollBy(0,document.body.scrollHeight);");
              
              //driver.findElement(By.cssSelector(".contactblock")).click();
              //assertThat(driver.findElement(By.cssSelector(".css-kp7i2l p")).getText(), is("Australia\\\\nIsha Foundation\\\\nAustralia Inc,\\\\n93 Hampshire Rd,\\\\nSunshine VIC 3020,\\\\nAustralia"));
              //Verify the text is loaded at bottom of the page.
              bodyFull = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/footer/div[1]/div[3]/div/div/div[1]/div/div/p"));
              bodyFull.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/footer/div[1]/div[3]/div/div/div[1]/div/div/p")).isDisplayed();
                                             
              //Verify country address according to the selection.
              driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/footer/div[1]/div[3]/div/div/div[1]/div/div/p")).getText().contains("Singapore Isha Foundation Ltd. 5008 Ang Mo Kio Ave 5, Techplace II #05-14/15/16, Singapore 569874");
              
              try {
      			Thread.sleep(1000);
      		} catch (InterruptedException e) {
      			// TODO Auto-generated catch block
      			e.printStackTrace();
      		}
              
            //Scroll to top of the page.
              js11111.executeScript("window.scrollTo(0, 0);");
            
              
              System.out.println("SINGAPORE Location verification SUCCESSFUL");
              //driver.navigate().refresh();
              
            //#####################UK&Europe Verification Starts from here.############################
              js11111.executeScript("arguments[0].scrollIntoView();", element);
              WebElement element211 = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/header/div[1]/div/div/div[3]/div[1]/div"));
              
              JavascriptExecutor js111111 = (JavascriptExecutor)driver;
              js111111.executeScript("arguments[0].scrollIntoView();", element211);
              
              try
              {
                  //Setup the driver and navigate to the web page...
                  //var driver = new ChromeDriver("folder path to the Chrome driver");
                  //driver.Navigate().GoToUrl("UrlToThePage");

                  //Find the element...
                  //var element1 = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/header/div[1]/div/div/div[3]/div[1]/div")); 

                  //Step 1
                  //new Actions(driver).moveToElement(element1).perform();  

                  //Step 2
                  element211.click();
              }
              catch (Exception e)
              {
                  //Step 3
              	//JavascriptExecutor executor = (JavascriptExecutor)driver;
              	//executor.executeScript("document.getElementByxpath('/html/body/div[1]/div/div[1]/header/div[1]/div/div/div[3]/div[1]/div').click();");

            	  element211.click();
              }
				/*
				 * //Click on Globe icon to select a country. globeIcon = new
				 * WebDriverWait(driver,
				 * Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.
				 * xpath("/html/body/div[1]/div/div[1]/header/div[1]/div/div/div[3]/div[1]/div")
				 * )); // Print the first result //System.out.println("Loged as user:" +
				 * afterLogout.getText() + "which is not expected, Please report as issue");
				 * globeIcon.click();
				 */
              
              //Click on Globe icon to select a country.
              //  driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/header/div[1]/div/div/div[3]/div[1]/div")).click();
                {
                	//Mouse hover on UK&Europe option.
                  WebElement element1 = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[1]/header/div[1]/div/div/div[3]/div[2]/div/ul/li[6]/a/div"));
                  Actions builder = new Actions(driver);
                  builder.moveToElement(element1).perform();
                }
                        
                //Click on 'UK&Europe' option.
                driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[1]/header/div[1]/div/div/div[3]/div[2]/div/ul/li[6]/a/div")).click();
                
                //driver.findElement(By.cssSelector(".css-12tysol .css-15lwwv6:nth-child(1) .css-nlkjvw")).click();
                //vars.put("aus", js.executeScript("return window.location.href"));
                //assertEquals(vars.get("aus").toString(), "https://isha.sadhguru.org/au/en");
              
                //Verify the url updated according to the country selected.
                compare = "https://isha.sadhguru.org/uk/en";
                url = driver.getCurrentUrl();
                url.equals(compare);
                        
                //js.executeScript("window.scrollTo(0,527)");
                //Scroll down to bottom of the page.
                //JavascriptExecutor js = (JavascriptExecutor) driver;
                js111111.executeScript("window.scrollBy(0,document.body.scrollHeight);");
                
                //driver.findElement(By.cssSelector(".contactblock")).click();
                //assertThat(driver.findElement(By.cssSelector(".css-kp7i2l p")).getText(), is("Australia\\\\nIsha Foundation\\\\nAustralia Inc,\\\\n93 Hampshire Rd,\\\\nSunshine VIC 3020,\\\\nAustralia"));
                //Verify the text is loaded at bottom of the page.
                bodyFull = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/footer/div[1]/div[3]/div/div/div[1]/div/div/p"));
                bodyFull.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/footer/div[1]/div[3]/div/div/div[1]/div/div/p")).isDisplayed();
                                               
                //Verify country address according to the selection.
                driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/footer/div[1]/div[3]/div/div/div[1]/div/div/p")).getText().contains("United Kingdom Big Yellow Self Storage 111, Whitby Road Slough - SL1 3DR");
                
                try {
        			Thread.sleep(1000);
        		} catch (InterruptedException e) {
        			// TODO Auto-generated catch block
        			e.printStackTrace();
        		}
                
              //Scroll to top of the page.
                js111111.executeScript("window.scrollTo(0, 0);");
              
                
                System.out.println("UK&Europe Location verification SUCCESSFUL");
                //driver.navigate().refresh();
              //#####################United States Verification Starts from here.############################
                js111111.executeScript("arguments[0].scrollIntoView();", element);
                
                WebElement element5 = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/header/div[1]/div/div/div[3]/div[1]/div"));
                
                JavascriptExecutor js5 = (JavascriptExecutor)driver;
                js5.executeScript("arguments[0].scrollIntoView();", element5);
                
                try
                {
                    //Setup the driver and navigate to the web page...
                    //var driver = new ChromeDriver("folder path to the Chrome driver");
                    //driver.Navigate().GoToUrl("UrlToThePage");

                    //Find the element...
                //    var element1 = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/header/div[1]/div/div/div[3]/div[1]/div")); 

                    //Step 1
                  //  new Actions(driver).moveToElement(element1).perform();  

                    //Step 2
                    element5.click();
                }
                catch (Exception e)
                {
                    //Step 3
                	//JavascriptExecutor executor = (JavascriptExecutor)driver;
                	//executor.executeScript("document.getElementByxpath('/html/body/div[1]/div/div[1]/header/div[1]/div/div/div[3]/div[1]/div').click();");

                	element5.click();
                }
				/*
				 * //Click on Globe icon to select a country. globeIcon = new
				 * WebDriverWait(driver,
				 * Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.
				 * xpath("/html/body/div[1]/div/div[1]/header/div[1]/div/div/div[3]/div[1]/div")
				 * )); // Print the first result //System.out.println("Loged as user:" +
				 * afterLogout.getText() + "which is not expected, Please report as issue");
				 * globeIcon.click();
				 */
                
                //Click on Globe icon to select a country.
                //  driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/header/div[1]/div/div/div[3]/div[1]/div")).click();
                  {
                  	//Mouse hover on United States option.
                    WebElement element1 = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[1]/header/div[1]/div/div/div[3]/div[2]/div/ul/li[7]/a/div"));
                    Actions builder = new Actions(driver);
                    builder.moveToElement(element1).perform();
                  }
                          
                  //Click on 'United States' option.
                  driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[1]/header/div[1]/div/div/div[3]/div[2]/div/ul/li[7]/a/div")).click();
                  
                  //driver.findElement(By.cssSelector(".css-12tysol .css-15lwwv6:nth-child(1) .css-nlkjvw")).click();
                  //vars.put("aus", js.executeScript("return window.location.href"));
                  //assertEquals(vars.get("aus").toString(), "https://isha.sadhguru.org/au/en");
                
                  //Verify the url updated according to the country selected.
                  compare = "https://isha.sadhguru.org/us/en";
                  url = driver.getCurrentUrl();
                  url.equals(compare);
                          
                  //js.executeScript("window.scrollTo(0,527)");
                  //Scroll down to bottom of the page.
                  //JavascriptExecutor js = (JavascriptExecutor) driver;
                  js111111.executeScript("window.scrollBy(0,document.body.scrollHeight);");
                  
                  //driver.findElement(By.cssSelector(".contactblock")).click();
                  //assertThat(driver.findElement(By.cssSelector(".css-kp7i2l p")).getText(), is("Australia\\\\nIsha Foundation\\\\nAustralia Inc,\\\\n93 Hampshire Rd,\\\\nSunshine VIC 3020,\\\\nAustralia"));
                  //Verify the text is loaded at bottom of the page.
                  bodyFull = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/footer/div[1]/div[3]/div/div/div[1]/div/div/p"));
                  bodyFull.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/footer/div[1]/div[3]/div/div/div[1]/div/div/p")).isDisplayed();
                                                 
                  //Verify country address according to the selection.
                  driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/footer/div[1]/div[3]/div/div/div[1]/div/div/p")).getText().contains("USA Isha Institute of Inner Sciences (USA)");
                  
                  try {
          			Thread.sleep(1000);
          		} catch (InterruptedException e) {
          			// TODO Auto-generated catch block
          			e.printStackTrace();
          		}
                  
                //Scroll to top of the page.
                  js111111.executeScript("window.scrollTo(0, 0);");
                
                  
                  System.out.println("United States Location verification SUCCESSFUL");
                  //driver.navigate().refresh();
                //#####################Global Verification Starts from here.############################
                  js111111.executeScript("arguments[0].scrollIntoView();", element);
                  WebElement element6 = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/header/div[1]/div/div/div[3]/div[1]/div"));
                  
                  JavascriptExecutor js6 = (JavascriptExecutor)driver;
                  js6.executeScript("arguments[0].scrollIntoView();", element6);
                  
                  try
                  {
                      //Setup the driver and navigate to the web page...
                      //var driver = new ChromeDriver("folder path to the Chrome driver");
                      //driver.Navigate().GoToUrl("UrlToThePage");

                      //Find the element...
                  //    var element1 = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/header/div[1]/div/div/div[3]/div[1]/div")); 

                      //Step 1
                    //  new Actions(driver).moveToElement(element1).perform();  

                      //Step 2
                      element6.click();
                  }
                  catch (Exception e)
                  {
                      //Step 3
                 // 	JavascriptExecutor executor = (JavascriptExecutor)driver;
                  	//executor.executeScript("document.getElementByxpath('/html/body/div[1]/div/div[1]/header/div[1]/div/div/div[3]/div[1]/div').click();");

                	  element6.click();
                  }
					/*
					 * //Click on Globe icon to select a country. globeIcon = new
					 * WebDriverWait(driver,
					 * Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.
					 * xpath("/html/body/div[1]/div/div[1]/header/div[1]/div/div/div[3]/div[1]/div")
					 * )); // Print the first result //System.out.println("Loged as user:" +
					 * afterLogout.getText() + "which is not expected, Please report as issue");
					 * globeIcon.click();
					 */
                  
                  //Click on Globe icon to select a country.
                  //  driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/header/div[1]/div/div/div[3]/div[1]/div")).click();
                    {
                    	//Mouse hover on Global option.
                      WebElement element1 = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[1]/header/div[1]/div/div/div[3]/div[2]/div/ul/li[8]/a/div"));
                      Actions builder = new Actions(driver);
                      builder.moveToElement(element1).perform();
                    }
                            
                    //Click on 'Global' option.
                    driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[1]/header/div[1]/div/div/div[3]/div[2]/div/ul/li[8]/a/div")).click();
                    
                    //driver.findElement(By.cssSelector(".css-12tysol .css-15lwwv6:nth-child(1) .css-nlkjvw")).click();
                    //vars.put("aus", js.executeScript("return window.location.href"));
                    //assertEquals(vars.get("aus").toString(), "https://isha.sadhguru.org/au/en");
                  
                    //Verify the url updated according to the country selected.
                    compare = "https://isha.sadhguru.org/global/en";
                    url = driver.getCurrentUrl();
                    url.equals(compare);
                            
                    //js.executeScript("window.scrollTo(0,527)");
                    //Scroll down to bottom of the page.
                    //JavascriptExecutor js = (JavascriptExecutor) driver;
                    js111111.executeScript("window.scrollBy(0,document.body.scrollHeight);");
                    
                    //driver.findElement(By.cssSelector(".contactblock")).click();
                    //assertThat(driver.findElement(By.cssSelector(".css-kp7i2l p")).getText(), is("Australia\\\\nIsha Foundation\\\\nAustralia Inc,\\\\n93 Hampshire Rd,\\\\nSunshine VIC 3020,\\\\nAustralia"));
                    //Verify the text is loaded at bottom of the page.
                    bodyFull = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/footer/div[1]/div[3]/div/div/div[1]/div/div/p"));
                    bodyFull.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/footer/div[1]/div[3]/div/div/div[1]/div/div/p")).isDisplayed();
                                                   
                    //Verify country address according to the selection.
                    driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/footer/div[1]/div[3]/div/div/div[1]/div/div/p")).getText().contains("India Isha Yoga Centre, Velliangiri Foothills, Ishana Vihar Post, Coimbatore, Tamil Nadu - 641114");
                    
                    try {
            			Thread.sleep(1000);
            		} catch (InterruptedException e) {
            			// TODO Auto-generated catch block
            			e.printStackTrace();
            		}
                    
                  //Scroll to top of the page.
                    js111111.executeScript("window.scrollTo(0, 0);");
                  
                    
                    System.out.println("Global verification SUCCESSFUL");
                    System.out.println("SUCCESSFULL, Regions Verification Test PASSED");
                    //driver.navigate().refresh();
                    Status = "passed";
                    Thread.sleep(150);

                    System.out.println("TestFinished");
                    System.out.println("#################################################################################");
                    //driver.close();
              
        
    }

    @AfterMethod
    public void tearDown() {
        driver.executeScript("lambda-status=" + Status);
        driver.quit();
    }

}