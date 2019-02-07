
package com.tiqri.sta.compose.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstForm {

 	WebDriver driver;
 	By startBtn = By.name("byPassFrontPage");
 	
 	
 	
 	
 	public FirstForm(WebDriver driver){
 	this.driver = driver;
  	}
  	
  	public FirstForm ClickStart() {
  	driver.findElement(startBtn).click();
  	return this;
  	
  	}


}
