package AdminTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

//package Tests;

//import com.thoughtworks.selenium.SeleniumException;
import org.apache.bcel.generic.Visitor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

/**
 * Created by atinkovan on 30.01.2016.
 */


public class FeeRegistryCreation {
    WebDriver driver;
    private String baseUrl;
    private String feeCode;
    private String feeDescription;

    @Before
    public void  testSetup() throws Exception{
        driver = new FirefoxDriver();
        baseUrl = "http://localhost:8080/ipb-app/login.xhtml";
        feeCode = "FeeCode1";
        feeDescription = feeCode;
        // baseUrl = "http://vnopfapp02.exigengroup.com/ipb-app-int/admin/";
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void testShutDown() throws Exception{
        driver.quit();
    }

    @Test
    public void createFeeRegistry() throws Exception{
        driver.get(baseUrl);
        inputValue(By.id("loginForm:j_username"), "qa");
        inputValue(By.id("loginForm:j_password"), "qa");
        click(By.id("loginForm:submitForm"));
        click(By.id("logoutForm:switchToAdmin"));
        click(By.id("adminTabsForm:adminTopTabsList:11:linkLabel"));
        click(By.id("headSearchForm:searchChoser:0"));
        click(By.id("searchForm:addFeeBtn"));
        inputValue(By.id("feeRegistryForm:feeInfo_code"), "feeCode");
        new Select(driver.findElement(By.id("feeRegistryForm:feeInfo_feeType"))).selectByVisibleText("General");
        inputValue(By.id("feeRegistryForm:feeInfo_feeType"), "General");
        inputValue(By.id("feeRegistryForm:feeInfo_description"), "feeDescription");

    }

    public void inputValue(By by, String value){
        driver.findElement(by).sendKeys(value);
    }

    public void click(By by){
        driver.findElement(by).click();
    }

    public void submit(By by){
        driver.findElement(by).submit();
    }



    private Boolean isElementPresent(By by){
        try {
            driver.findElement(by);
            return true;
        }catch (NoSuchElementException e){
            return false;
        }
    }


}
