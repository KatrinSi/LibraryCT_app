package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.Base_page;
import com.cybertek.library.pages.Dashboard_page;
import com.cybertek.library.pages.Users_page;
import com.cybertek.library.utilities.BrowserUtils;
import com.cybertek.library.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class PageNavigation_StepDefinitions extends Base_page {
    Dashboard_page dashboard_page = new Dashboard_page();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
    Users_page users_page = new Users_page();
    Select select;

    @When("I click on {string} link")
    public void iClickOnLink(String linkName) {
        switch (linkName.toLowerCase()) {
            case "dashboard":
                dashboard_page.dashboardLink.click();
                break;
            case "users":
                dashboard_page.usersLink.click();
                break;
            case "books":
                dashboard_page.booksLink.click();
                break;
        }
    }

    @Then("show records default value should be {int}")
    public void showRecordsDefaultValueShouldBe(int recordsValue) {
        select = new Select(users_page.recordsDropdown);
        String actual = select.getFirstSelectedOption().getText();
        String expected = String.valueOf(recordsValue);
        Assert.assertEquals(expected, actual);
    }

    @And("show records should have following options:")
    public void showRecordsShouldHaveFollowingOptions(List<String> options) {
        select = new Select(users_page.recordsDropdown);
        List<WebElement> webElements = select.getOptions();
        List<String> allElementsText = BrowserUtils.getElementsText(webElements);
        Assert.assertEquals(options, allElementsText);
        accountName.click();
        logOutButton.click();
    }
}
