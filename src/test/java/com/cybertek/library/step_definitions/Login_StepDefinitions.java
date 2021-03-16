package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.Base_page;
import com.cybertek.library.pages.Dashboard_page;
import com.cybertek.library.pages.Login_page;
import com.cybertek.library.utilities.ConfigurationReader;
import com.cybertek.library.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login_StepDefinitions extends Base_page {
    Login_page loginPage = new Login_page(); //create an object of Login_Page where my Web Elements are stored
    Dashboard_page dashboard_page = new Dashboard_page();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

    @Given("I am on the login page") //1
    public void i_m_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("qa2_url"));
    }

    @When("I login as a librarian")//2
    public void i_login_as_a_librarian() {
        loginPage.emailAddressBox.sendKeys(ConfigurationReader.getProperty("email_Librarian49"));
        loginPage.passwordBox.sendKeys(ConfigurationReader.getProperty("password_Librarian49"));
        loginPage.signInButton.click();
    }

    @When("I login as a student")
    public void i_login_as_a_student() {
        loginPage.emailAddressBox.sendKeys(ConfigurationReader.getProperty("email_Student51"));
        loginPage.passwordBox.sendKeys(ConfigurationReader.getProperty("password_Student51"));
        loginPage.signInButton.click();
    }

    @When("I login using {string} and {string}")
    public void iLoginUsingAnd(String username, String password) {
        loginPage.emailAddressBox.sendKeys(ConfigurationReader.getProperty(username));
        loginPage.passwordBox.sendKeys(ConfigurationReader.getProperty(password));
        loginPage.signInButton.click();
    }

    @When("I enter username {string}")
    public void i_enter_username(String username) {
        loginPage.emailAddressBox.sendKeys(ConfigurationReader.getProperty(username));
    }

    @When("I enter password {string}")
    public void i_enter_password(String password) {
        loginPage.passwordBox.sendKeys(ConfigurationReader.getProperty(password));
    }

    @When("click the sign in button")
    public void click_the_sign_in_button() {
        loginPage.signInButton.click();
    }

    @Then("dashboard should be displayed")
    public void dashboard_should_be_displayed() {
        String expected = "Library";
        wait.until(ExpectedConditions.titleIs(expected));
        String actual = Driver.getDriver().getTitle();
        Assert.assertEquals(expected, actual);
        accountName.click();
        logOutButton.click();
    }
//for scenarios with the next step
    @Then("Dashboard should be displayed")
    public void Dashboard_should_be_displayed() {
        String expected = "Library";
        wait.until(ExpectedConditions.titleIs(expected));
        String actual = Driver.getDriver().getTitle();
        Assert.assertEquals(expected, actual);
    }

    @Then("there should be {int} users")
    public void there_should_be_users(Integer int1) {
        String expected = String.valueOf(int1);
        wait.until(ExpectedConditions.urlContains("dashboard"));
        String actual = dashboard_page.userCount.getText();
        Assert.assertEquals(actual, expected);
        accountName.click();
        logOutButton.click();
    }



}
