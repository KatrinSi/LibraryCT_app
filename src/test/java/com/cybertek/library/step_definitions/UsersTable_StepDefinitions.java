package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.Base_page;
import com.cybertek.library.pages.Users_page;
import com.cybertek.library.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class UsersTable_StepDefinitions extends Base_page {
    Users_page users_page = new Users_page();

    @Then("table should have following column names:")
    public void table_should_have_following_column_names(List<String> expectedColumnNames) {
        List<String> actualColumnNames = BrowserUtils.getElementsText(users_page.tableHeaders);
        Assert.assertEquals(expectedColumnNames, actualColumnNames);
        System.out.println("actualColumnNames = " + actualColumnNames);
        accountName.click();
        logOutButton.click();
    }
}
