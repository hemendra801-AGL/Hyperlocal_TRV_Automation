package org.testcases;

import org.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.pageobjects.HeaderMenu;
import org.testng.annotations.Test;

public class TestCase_HeaderMenu extends BaseClass{
	
	HeaderMenu header= new HeaderMenu(driver); // headermen
		@Test
		
		public void header() throws InterruptedException {
	            header.AboutUs();		
				header.Insurance();
				header.outlet();
				header.privacy_policy();
		}
		public void finance() {
		header.Finance();
	}
		public void outlet() throws InterruptedException {
	         
				header.outlet();
		}
				public void p_policy() throws InterruptedException {
			          
						header.privacy_policy(); 
						
						
				}}
