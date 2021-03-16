package com.cybertek.library.pages;

import com.cybertek.library.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class Base_page {
    public Base_page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(linkText = "Users")
    public WebElement usersLink;

    @FindBy(linkText = "Books")
    public WebElement booksLink;

    @FindBy(linkText = "Dashboard")
    public WebElement dashboardLink;

    @FindBy(xpath = "//a[@id='navbarDropdown']//span")
    public WebElement accountName;

    @FindBy(xpath = "//a[.='Log Out']")
    public WebElement logOutButton;

    @FindBy(xpath = "//a[@href='#borrowing-books']")
    public WebElement borrowingBooksLink;

}
