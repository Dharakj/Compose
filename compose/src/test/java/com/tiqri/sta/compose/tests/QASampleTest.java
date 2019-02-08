package com.tiqri.sta.compose.tests;

import com.tiqri.sta.compose.pages.qasample.RespondentActivity;
import com.tiqri.sta.compose.pages.qasample.UserRegistration;
import com.tiqri.sta.compose.util.WebDriverUtil;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test
public class QASampleTest {

    WebDriver driver;
    UserRegistration userRegistration;
    RespondentActivity respondentActivity;

    @BeforeClass
    public void beforeClass() {
        driver = WebDriverUtil.getDriver();
        driver.navigate().to("https://beta.onctg.com/cng/QA/qa-sample");
        userRegistration = new UserRegistration(driver);
        userRegistration.waitForPageLoad(5);
    }

    @AfterClass
    public void afterClass() {
        driver.close();
    }

    @Test(priority = 1)
    public void testConditionalControls_InitialLoad() {

        Assert.assertFalse(userRegistration.isVisibleApplicantFirstName());
        Assert.assertFalse(userRegistration.isVisibleApplicantLastName());
        Assert.assertFalse(userRegistration.isVisibleGuardianName());
        Assert.assertFalse(userRegistration.isVisibleLawyerName());
        Assert.assertFalse(userRegistration.isVisibleOrganizationName());
    }

    @Test(priority = 2)
    public void testConditionalControls_Applicant() {

        userRegistration.selectApplicant();
        Assert.assertTrue(userRegistration.isVisibleApplicantFirstName());
        Assert.assertTrue(userRegistration.isVisibleApplicantLastName());
        Assert.assertFalse(userRegistration.isVisibleGuardianName());
        Assert.assertFalse(userRegistration.isVisibleLawyerName());
        Assert.assertFalse(userRegistration.isVisibleOrganizationName());
        // TODO check question panel header change as well

    }

    @Test(priority = 3)
    public void testConditionalControls_Guardian() {

        userRegistration.selectGuardian();
        Assert.assertFalse(userRegistration.isVisibleApplicantFirstName());
        Assert.assertFalse(userRegistration.isVisibleApplicantLastName());
        Assert.assertTrue(userRegistration.isVisibleGuardianName());
        Assert.assertFalse(userRegistration.isVisibleLawyerName());
        Assert.assertFalse(userRegistration.isVisibleOrganizationName());
        // TODO check question panel header change as well

    }

    @Test(priority = 4)
    public void testConditionalControls_Lawyer() {

        userRegistration.selectLawyer();
        Assert.assertFalse(userRegistration.isVisibleApplicantFirstName());
        Assert.assertFalse(userRegistration.isVisibleApplicantLastName());
        Assert.assertFalse(userRegistration.isVisibleGuardianName());
        Assert.assertTrue(userRegistration.isVisibleLawyerName());
        Assert.assertTrue(userRegistration.isVisibleOrganizationName());
        // TODO check question panel header change as well

    }

    @Test(priority = 5)
    public void testFillFormAsLawyer() {

        userRegistration.selectLawyer();
        userRegistration.fillLawyerName("Lawyer Name");
        userRegistration.fillOrganizationName("Lawyer Org Name");
        userRegistration.clickOnNext();
        respondentActivity = new RespondentActivity(driver);
        Assert.assertTrue(respondentActivity.isWorkFlowCompleted());
    }


}
