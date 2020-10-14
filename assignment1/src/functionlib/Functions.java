package functionlib;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import constants.Browserlaunch;
// comments on 14 oct 2020 to check the conflicts

public class Functions extends Browserlaunch {
	// code to click
	public void clickAction(WebDriver driver, String attType, String attValue) throws Exception {
		if (attType.equalsIgnoreCase("xpath")) {
			driver.findElement(By.xpath(attValue)).click();
		} else if (attType.equalsIgnoreCase("id")) {
			driver.findElement(By.id(attValue)).click();
		} else if (attType.equalsIgnoreCase("class")) {
			driver.findElement(By.className(attValue)).click();
		} else if (attType.equalsIgnoreCase("name")) {
			driver.findElement(By.name(attValue)).click();
		} else if (attType.equalsIgnoreCase("css")) {
			driver.findElement(By.cssSelector((attValue))).click();
		} else {
			throw new Exception();
		}
	}

	// code to wait for element explicitly wait for particular element
	public void waitForElement(WebDriver driver, String attType, String attValue, String data) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Integer.parseInt(data));
		if (attType.equalsIgnoreCase("xpath")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(attValue)));
		} else if (attType.equalsIgnoreCase("id")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id(attValue)));
		} else if (attType.equalsIgnoreCase("class")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.className(attValue)));
		} else if (attType.equalsIgnoreCase("name")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.name(attValue)));
		} else if (attType.equalsIgnoreCase("css")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector((attValue))));
		} else {
			throw new Exception();
		}
	}

	// Code to Type text
	public void typeAction(WebDriver driver, String attType, String attValue, String data) throws Exception {

		if (attType.equalsIgnoreCase("xpath")) {
			driver.findElement(By.xpath(attValue)).sendKeys(data);
		} else if (attType.equalsIgnoreCase("id")) {
			driver.findElement(By.id(attValue)).sendKeys(data);
		} else if (attType.equalsIgnoreCase("class")) {
			driver.findElement(By.className(attValue)).sendKeys(data);
		} else if (attType.equalsIgnoreCase("name")) {
	
			driver.findElement(By.name(attValue)).sendKeys(data);
		} else if (attType.equalsIgnoreCase("css")) {
			driver.findElement(By.cssSelector((attValue))).sendKeys(data);
		} else {
			throw new Exception();
		}
	}

	// code to validate product
	public void validation(WebDriver driver, String attType, String attValue) throws Exception {
		if (attType.equalsIgnoreCase("xpath")) {
			driver.findElement(By.xpath(attValue));

		} else {
			throw new Exception();
		}
	}

	// code to perform mouse over action
	public void mouseaction(WebDriver driver, String attType, String attValue) throws Exception {
    if(attType.equalsIgnoreCase("Xpath")) {
    	Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath(attValue)));			
		act.build().perform();		
			} else {
		throw new Exception();
	}
	}
	
	//to perform Scroll on application using  Selenium
	public void scrollDown(WebDriver driver) throws Exception{		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600)", "");
		}
	
	
	
	

}
