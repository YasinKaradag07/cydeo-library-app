package com.cydeo.library.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class UsersPage extends BasePage{

    @FindBy(xpath = "//thead/tr/th")
    public List<WebElement> columnNames;

}
