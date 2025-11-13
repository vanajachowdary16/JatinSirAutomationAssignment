package com.utility;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.constants.Browser;


public abstract class BrowserUtility {
    // ThreadLocal to support parallel threads
    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();
     Logger logger = loggerUtility.getLogger(BrowserUtility.class);

    // Return the actual WebDriver for the current thread
    public WebDriver getDriver() {
        return driver.get();
    }

    // Set the actual WebDriver for the current thread
    @SuppressWarnings("unchecked")
	public void setDriver(WebDriver driver) {
        ((ThreadLocal<WebDriver>) driver).set(driver);
    }

    // Constructor when a WebDriver instance is provided
    public BrowserUtility(WebDriver driver) {
        super();
        this.driver.set(driver);// Initialize the ThreadLocal value
    }
	public BrowserUtility(String browserName){
		if (browserName.equalsIgnoreCase("chrome")) {
			driver.set(new ChromeDriver());
		}
		else if (browserName.equalsIgnoreCase("edge")) {
			driver.set(new EdgeDriver());
			
		}
		else {
            System.err.println("Invalid browser name .... please select chrome or edge only");
        }

	}


    // Constructor that initializes by browser name
    public BrowserUtility(String browserName, boolean isHeadless) {
        logger.info("initializing the browser: " + browserName);
        if (browserName.equalsIgnoreCase("chrome")) {
			if(isHeadless){
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless=new");
			options.addArguments("--window-size=1920,1080");
            logger.info("initializing the chrome browser");
            driver.set(new ChromeDriver(options));
			}
			else{
				driver.set(new ChromeDriver());
			}
        } else if (browserName.equalsIgnoreCase("edge")) {
			if(isHeadless){
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--headless=old");
				options.addArguments("disable-gpu");
			    options.addArguments("--window-size=1920,1080");
            logger.info("initializing the edge browser");
			driver.set(new EdgeDriver(options));
			}
			else{
				driver.set(new EdgeDriver());
			}
        } else {
            System.err.println("Invalid browser name .... please select chrome or edge only");
        }
    }
   
    // enum-based constructor
    public BrowserUtility(Browser browserName, boolean isHeadless) {
        if (browserName == Browser.CHROME) {
			if(isHeadless){
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless=new");
				options.addArguments("--window-size=1920,1080");
				logger.info("initializing the chrome browser");
				driver.set(new ChromeDriver(options));
				}
				else{
					driver.set(new ChromeDriver());
				}
        } else if (browserName == Browser.EDGE) {
			if(isHeadless){
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--headless=old");
				options.addArguments("disable-gpu");
			    options.addArguments("--window-size=1920,1080");
            logger.info("initializing the edge browser");
			driver.set(new EdgeDriver(options));
			}
			else{
				driver.set(new EdgeDriver());
			}
        } else {
            System.err.println("Invalid browser name .... please select chrome or edge only");
        }
    }

    public void goToWebSite(String url) {
        logger.info("navigating to the website: " + url);
        driver.get().get(url);
    }

    public void maximizeWindow() {
        logger.info("maximizing the window");
		driver.get().manage().window().maximize();
    }

    public void clickOn(By locator) {
        logger.info("clicking on the element: " + locator);
        WebElement element =  driver.get().findElement(locator);
        element.click();
    }
    public void clickOn(WebElement element) {
        logger.info("clicking on the element: " +element);
       
        element.click();
    }

    public void enterText(By locator, String text) {
    	logger.info("finding element with the locator" +locator);
        
        WebElement element = driver.get().findElement(locator);
        logger.info("entering text: " + text + " into the element: " + locator);
        element.sendKeys(text);
    }
    
    public void clearText(By locator) {
    	logger.info("finding element with the locator" +locator);
        
        WebElement element = driver.get().findElement(locator);
        logger.info("clear the text box field: " + locator);
        element.clear();
    }
    public void selectFromDropDown(By dropDownLocator, String optionToSelect) {
    	logger.info("finding element with the locator" +dropDownLocator);
    	WebElement element = driver.get().findElement(dropDownLocator);
    	Select select = new Select(element);
    	logger.info("Selecting the option "+optionToSelect);
    	select.selectByVisibleText(optionToSelect);
    	
    }
    
    public void enterSpecialKey(By locator,  Keys keyToEnter) {
        logger.info("entering text into the element: " + locator);
        WebElement element = driver.get().findElement(locator);
        logger.info("element found and now enter special key"+keyToEnter);
        element.sendKeys(keyToEnter);
    }

    public String getVisibleText(By locator) {
        logger.info("Getting the visible text from the element: " + locator);
        WebDriver webDriver = driver.get();

        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));

        // Wait until the element is visible and contains non-empty text
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        WebElement element = webDriver.findElement(locator);

        String text = element.getText();

        // If the element text is empty, try alternative attributes (innerText/textContent)
        if (text == null || text.trim().isEmpty()) {
            text = element.getAttribute("innerText");
            if (text == null || text.trim().isEmpty()) {
                text = element.getAttribute("textContent");
            }
        }

        text = text == null ? "" : text.trim();
        logger.info("Visible text retrieved: [" + text + "]");
        return text;
    }
    
    public String getVisibleText(WebElement element) {
    	
    	  logger.info("Visible text retrieved: "+element.getText());
		return element.getText();
    	
    }
    
    public List<String> getAllVisibleText(By locator) {
    	  logger.info("find all the elements with the locator" +locator);
        WebDriver webDriver = driver.get();

        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));

        // Wait until the element is visible and contains non-empty text
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

       List <WebElement> elementList = webDriver.findElements(locator);
       logger.info("elements found and now printing the lsit of elements");
       
       List<String> visibleTextList= new ArrayList<>();
       for(WebElement element : elementList) {
    	 System.out.println(getVisibleText(element));
    	 visibleTextList.add(getVisibleText(element));
       }
       return visibleTextList;
    }
    
    public List<WebElement> getAllElements(By locator) {
  	  logger.info("find all the elements with the locator" +locator);
      WebDriver webDriver = driver.get();

      WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));

      // Wait until the element is visible and contains non-empty text
      wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

     List <WebElement> elementList = webDriver.findElements(locator);
     logger.info("elements found and now printing the lsit of elements");
     
    return elementList;
    
  }


    public String takeScreenshot(String name) { 
		
	TakesScreenshot screenshot = (TakesScreenshot) driver.get(); 

	Date date= new Date();
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH-mm-ss");
    String timeStamp=simpleDateFormat.format(date);
	String filePath="./screenshots/"+name +"-"+ timeStamp+ "png";
	File screenShotData =screenshot.getScreenshotAs(OutputType.FILE); 
	File screenshotFile = new File(filePath);
	 try { FileUtils.copyFile(screenShotData, screenshotFile); 
	} catch (IOException e) { // TODO Auto-generated catch block e.printStackTrace(); } return filePath; }  
}
	 return filePath;
	}
}
