package com.cybertek.library.pages;

import com.cybertek.library.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_page{

    public Login_page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(id = "inputEmail")
    public WebElement emailAddressBox;
    @FindBy(id = "inputPassword")
    public WebElement passwordBox;
    @FindBy(xpath = "//button[.='Sign in']")
    public WebElement signInButton;
}
