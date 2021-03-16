package com.cybertek.library.pages;

import com.cybertek.library.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Users_page {
    public Users_page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(name = "tbl_users_length")
    public WebElement recordsDropdown;

    @FindBy(xpath = "//option[@value='10']")
    public WebElement defaultValue;

    @FindBy(xpath = "//th")         //tagName = "th";
    public List<WebElement> tableHeaders;

}
