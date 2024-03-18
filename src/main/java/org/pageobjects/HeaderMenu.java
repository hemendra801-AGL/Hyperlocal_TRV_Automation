package org.pageobjects;

import org.action.ActionClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.trvConfigs.ConfigReader;

public class HeaderMenu extends ActionClass {

		public WebDriver driver;
		public ActionClass act;
		ConfigReader config = new ConfigReader();
		public HeaderMenu(WebDriver driver) {
			super(driver);
			this.driver = driver;

			PageFactory.initElements(driver, this);
		}

		@FindBy(xpath = "div[class='col-md-4 col-5 align-self-center'] a")
		//"//div[@class='top-header d-md-flex']//ul/li[2]"
		private WebElement about_us;
		
		@FindBy(xpath = "//a[contains(text(),'Finance')]")
		private WebElement finance;
		
		@FindBy(xpath = "//a[contains(text(),'Insurance')]")
		private WebElement insurance;
		
		@FindBy(xpath = "//a[contains(text(),'Outlet Locator')]")
		private WebElement outlet;
		
		@FindBy(xpath = "//header/div[1]/div[1]/ul[1]/li[6]/a[1]")
		
		private WebElement privacy_policy;

	
		public void AboutUs() {
			try {
				WebElement abtus = driver.findElement(By.xpath("//div[@class='top-header d-md-flex']//ul/li[2]"));
				
	          explicitWait(driver, 20, abtus);
				about_us.click();
		
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public void Finance() {
			try {
				Thread.sleep(2000);

				finance.click();
		
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public void Insurance() {
			try {
				Thread.sleep(2000);
				insurance.click();
		
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public void outlet() {
			try {
				Thread.sleep(2000);
				outlet.click();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public void privacy_policy() {
			try {
				Thread.sleep(2000);
				privacy_policy.click();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		

}
