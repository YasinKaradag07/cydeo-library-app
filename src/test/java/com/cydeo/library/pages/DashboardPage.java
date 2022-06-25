package com.cydeo.library.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage{

    @FindBy(id = "user_avatar")
    public WebElement userAvatar;

    @FindBy(id = "user_count")
    public WebElement userCount;

    @FindBy(xpath = "//span[.='Users']")
    public WebElement usersButton;

    @FindBy(xpath = "//a[@id='navbarDropdown']/span")
    public WebElement accountHolderName;
}
