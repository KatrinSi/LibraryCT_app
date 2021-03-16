package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.Base_page;
import com.cybertek.library.pages.BorrowingBooks_page;
import com.cybertek.library.pages.Login_page;
import com.cybertek.library.utilities.BrowserUtils;
import com.cybertek.library.utilities.ConfigurationReader;
import com.cybertek.library.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BorrowingBooks_StepDefinitions extends Base_page {
    BorrowingBooks_page borrowingBooks_page = new BorrowingBooks_page();
    Login_page loginPage = new Login_page();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

    @Given("User is on the login page") //1
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("qa2_url"));
    }

    @When("User logs in using {string} and {string}")
    public void userLogsInUsing(String email, String password) {
        loginPage.emailAddressBox.sendKeys(email);
        loginPage.passwordBox.sendKeys(password);
        loginPage.signInButton.click();
        wait.until(ExpectedConditions.titleIs("Library"));
    }

    @Then("User's name is {string}")
    public void users_name_is(String string) {
        BrowserUtils.waitForVisibility(accountName, 5);
        Assert.assertEquals(string, borrowingBooks_page.userNameInUsers.getText());
//        accountName.click();
//        logOutButton.click();
    }

    @When("User goes to the Borrowing Book page")
    public void i_go_to_borrowing_book_page() {
        borrowingBooksLink.click();
    }

    @Then("User can see the list of his borrowed books")
    public void user_can_see_the_list_of_his_borrowed_books() {
        Assert.assertTrue(borrowingBooks_page.tableCardHeader.isDisplayed());
        String actualTableHeaderNames = "";
        for (WebElement eachName : borrowingBooks_page.tableHeaderNames) {
            actualTableHeaderNames += eachName.getText()+", ";
        }
        actualTableHeaderNames = actualTableHeaderNames.substring(0,actualTableHeaderNames.length()-2);
        String expectedTableHeaderNames = "Action, Book Name, Borrowed Date, Planned Return Date, Return Date, Is Returned ?";

        Assert.assertEquals(actualTableHeaderNames, expectedTableHeaderNames);
        accountName.click();
        logOutButton.click();
    }
}