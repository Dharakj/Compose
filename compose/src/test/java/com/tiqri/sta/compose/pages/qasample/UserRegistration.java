package com.tiqri.sta.compose.pages.qasample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserRegistration {
    WebDriver driver;

    @FindBy(how = How.ID, using = "Q1_field1")
    WebElement applicantTypeApplicant;

    @FindBy(how = How.ID, using = "Q1_field2")
    WebElement applicantTypeGuardian;

    @FindBy(how = How.ID, using = "Q1_field3")
    WebElement applicantTypeLawyer;

    @FindBy(how = How.ID, using = "Q2_Field")
    WebElement applicantFirstName;

    @FindBy(how = How.ID, using = "Q3_Field")
    WebElement applicantLastName;

    @FindBy(how = How.ID, using = "Q4_Field")
    WebElement guardianName;

    @FindBy(how = How.ID, using = "Q5_Field")
    WebElement lawyerName;

    @FindBy(how = How.ID, using = "Q6_Field")
    WebElement organizationName;

    @FindBy(how = How.ID, using = "nextButtonSubmit_Id")
    WebElement next;

    @FindBy(how = How.XPATH, using = "//*[@id=\"El_4\"]/div/div[1]/div/div/h4")
    WebElement questionPanelHeader;

    public UserRegistration(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitForPageLoad(int timeOut) {
        WebElement myDynamicElement = (new WebDriverWait(driver, timeOut))
                .until(ExpectedConditions.elementToBeClickable(applicantTypeApplicant));
    }

    public String getQuestionPanelHeader() {
        return questionPanelHeader.getText();
    }

    public void selectApplicant() {
        applicantTypeApplicant.click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void selectGuardian() {
        applicantTypeGuardian.click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void selectLawyer() {
        applicantTypeLawyer.click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickOnNext() {
        next.click();
    }

    public void fillApplicantFirstName(String firstName) {
        applicantFirstName.sendKeys(firstName);
    }

    public void fillApplicantLastName(String lastName) {
        applicantLastName.sendKeys(lastName);
    }

    public void fillGuardianName(String guardian) {
        guardianName.sendKeys(guardian);
    }

    public void fillLawyerName(String lawyer) {
        lawyerName.sendKeys(lawyer);
    }

    public void fillOrganizationName(String organization) {
        organizationName.sendKeys(organization);
    }

    public boolean isVisibleApplicantFirstName() {
        try {
            applicantFirstName.click();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean isVisibleApplicantLastName() {
        try {
            applicantLastName.click();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean isVisibleGuardianName() {
        try {
            guardianName.click();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean isVisibleLawyerName() {
        try {
            lawyerName.click();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean isVisibleOrganizationName() {
        try {
            organizationName.click();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
