package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.Base_page;
import com.cybertek.library.pages.Dashboard_page;
import com.cybertek.library.pages.Login_page;
import com.cybertek.library.utilities.BrowserUtils;
import com.cybertek.library.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginWithDifferentUsers_StepDefinitions extends Base_page {
    Login_page loginPage = new Login_page();
    Dashboard_page dashboard_page = new Dashboard_page();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
    @When("I log in using {string} and {string}")
    public void iLoginUsingAnd(String email, String password) {
        loginPage.emailAddressBox.sendKeys(email);
        loginPage.passwordBox.sendKeys(password);
        loginPage.signInButton.click();
        wait.until(ExpectedConditions.titleIs("Library"));
    }

    @Then("account holder name should be {string}")
    public void account_holder_name_should_be(String string) {
        BrowserUtils.waitForVisibility(accountName,5);
        Assert.assertEquals(string, accountName.getText());
        accountName.click();
        logOutButton.click();
    }
}
