package org.action;

import java.time.Duration;
import java.util.List;

import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.ImmutableMap;

public class ActionClass {

	public WebDriver driver;

	public ActionClass(WebDriver driver) {
		this.driver = driver;
	}


	public void scrollToEndAction() {
		boolean canScrollMore;
		do {
			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture",
					ImmutableMap.of("left", 100, "top", 100, "width", 200, "height", 200, "percent", 3.0));

		} while (canScrollMore);
	}


	public static void explicitWait(WebDriver driver, int wt, WebElement ele) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(wt));

		wait.until(ExpectedConditions.visibilityOf(ele));

	}

	public static void explicitWait(WebDriver driver, int wt, List<WebElement> ele) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(wt));

		wait.until(ExpectedConditions.visibilityOf((WebElement) ele));

	}

	public static void explicitWaitForVisibility(WebDriver driver, int wt, WebElement ele) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(wt));

		wait.until(ExpectedConditions.visibilityOfElementLocated((By) ele));
	}

	public static void waitForCliockableEle(WebDriver driver, int wt, WebElement ele) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(wt));

		wait.until(ExpectedConditions.elementToBeClickable(ele));
		// wait.until(ExpectedConditions.
	}

	public static void scrollByVisibilityOfElement(WebDriver driver, WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", ele);

	}

	public static void scrollByVisibilityOfElement1(WebDriver driver, List<WebElement> ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", ele);

	}

	public static void click(WebDriver driver, WebElement ele) {

		Actions act = new Actions(driver);
		act.moveToElement(ele).click().build().perform();

	}

	public static boolean selectByValue(WebElement element, String value) {
		boolean flag = false;
		try {
			Select s = new Select(element);
			s.selectByValue(value);
			flag = true;
			return true;
		} catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				System.out.println("Option selected by Value");
			} else {
				System.out.println("Option not selected by Value");
			}
		}
	}

	public static boolean selectByVisibleText(String visibletext, WebElement ele) {
		boolean flag = false;
		try {
			Select s = new Select(ele);
			s.selectByVisibleText(visibletext);
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if (flag) {
				System.out.println("Option selected by VisibleText");
			} else {
				System.out.println("Option not selected by VisibleText");
			}
		}
	}

	public static boolean moveToElement(WebDriver driver, WebElement ele) {
		boolean flag = false;
		try {

			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].scrollIntoView(true);", ele);
			Actions actions = new Actions(driver);

			actions.moveToElement(ele).build().perform();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}


	public void PageResponse(WebDriver driver, int wt, WebElement ele) {

		StopWatch pageLoad = new StopWatch();
		pageLoad.start();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(wt));
		// wait.until(ExpectedConditions.presenceOfElementLocated((By) ele));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
		pageLoad.stop();
		long pageLoadTime_ms = pageLoad.getTime();
		long pageLoadTime_Seconds = pageLoadTime_ms / 1000;



	}
}
