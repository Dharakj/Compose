package com.tiqri.sta.compose.tests;

import com.tiqri.sta.compose.pages.FirstForm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test
public class FormTest {

    WebDriver driver;
    FirstForm firstForm;
    

    @BeforeClass
    public void beforeClass() {

        System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://performance-ctg.onctg.com/cng/enterWorkFlow.action;jsessionid=C4EAD11C26E2F2FBE1101594D8756A6E");
        firstForm = new FirstForm(driver);

    }

	@Test
	public void firstForm(){
		firstForm.ClickStart();
		}

}
