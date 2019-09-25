package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

	WebDriver driver;
	Actions action;
	/*
	 * Initialize constructor
	 * */
	public BaseClass(WebDriver driver) {
		this.driver=driver;
		action=new Actions(driver);
	}

	/*
	 * Initialize constructor
	 * */
	public void waitCondition(WaitExpectedConditions conditions,WebElement element,int timeOut) {
		WebDriverWait wait=new WebDriverWait(driver,timeOut);

		switch (conditions)
		{
		case PRESENCE_OF_ELEMENT:
			wait.until(ExpectedConditions.visibilityOf(element));
			break;
		case ELEMENT_TO_BE_CLICKABLE: 
			wait.until(ExpectedConditions.elementToBeClickable(element));
			break;	
		}
	}


	public boolean elementIsDisplayed(WebElement element, int timeInSeconds) {
		try {
			new WebDriverWait(driver, timeInSeconds).until(ExpectedConditions.visibilityOf(element));
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	public boolean elementIsDisplayed(WebElement element,By by, int timeInSeconds) {
		try {
			element.findElement(by);
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	public void clickBtn(WebElement button) {
		waitCondition(WaitExpectedConditions.ELEMENT_TO_BE_CLICKABLE,button,10);
		button.click();
	}
	public void enterInput(WebElement inputField,String inputValue) {
		waitCondition(WaitExpectedConditions.PRESENCE_OF_ELEMENT, inputField, 30);
		inputField.sendKeys(inputValue);
	}
	public void clearText(WebElement inputField) {
		waitCondition(WaitExpectedConditions.PRESENCE_OF_ELEMENT, inputField, 30);
		inputField.clear();
	}

	public void Scroll(WebElement e) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",e);
	}

	public void hoverAndClick(WebElement hoverTo) {
		Action set1=action
				.moveToElement(hoverTo)
				.build();
		set1.perform();

	}

}
