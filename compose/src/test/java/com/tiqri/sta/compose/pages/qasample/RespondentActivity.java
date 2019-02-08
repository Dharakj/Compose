package com.tiqri.sta.compose.pages.qasample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RespondentActivity {

    WebDriver driver;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/h2")
    WebElement completeConfirmation;

    public RespondentActivity(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getConfirmationMessage() {
        return completeConfirmation.getText();
    }

    public boolean isWorkFlowCompleted() {
        if (getConfirmationMessage().equals("Workflow Completed")) ;
        return true;
    }


}
