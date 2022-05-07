package com.ncu.pieinfo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ncu.constants.Constants;

/**
 * 
 * @author anishgogia
 * 
 * class App creates a connection with chrome using selenium and navigates to the url to get the html source.
 * 
 */

public class App  {

  public static void main(String[] args) {
	  WebDriver driver = null;
      try {
    	  	System.setProperty("webdriver.chrome.driver", Constants.DRIVERPATH);
    	  	driver = new ChromeDriver();
      }
      catch(IllegalStateException ex){
    	  	System.out.println("Error occured while creaing driver please check path aswell");
    	  	System.out.println(ex.getStackTrace());
            throw ex;
      }
      
      // Get login page
      driver.get(Constants.LOGINURL);

      // find username and password element
      WebElement userNameElement = driver.findElement(By.name("userName"));
      WebElement passwordElement = driver.findElement(By.name("password"));

      // credentials for login
      userNameElement.sendKeys(Constants.USERNAME);
      passwordElement.sendKeys(Constants.PASSWORD);

      // Now submit the form
      userNameElement.submit();
      
      // html code 
      System.out.println(driver.getPageSource());
     

      driver.quit();
  }
}
