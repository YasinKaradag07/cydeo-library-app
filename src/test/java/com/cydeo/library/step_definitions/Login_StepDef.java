package com.cydeo.library.step_definitions;


import com.cydeo.library.pages.DashboardPage;
import com.cydeo.library.pages.LoginPage;
import com.cydeo.library.pages.UsersPage;
import com.cydeo.library.utilities.BrowserUtils;
import com.cydeo.library.utilities.ConfigurationReader;
import com.cydeo.library.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Login_StepDef {

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();
    UsersPage usersPage = new UsersPage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("library.url"));
    }

    @When("user enters librarian username")
    public void user_enters_librarian_username() {
        loginPage.emailBox.sendKeys("librarian1@library");
    }

    @When("user enters librarian password")
    public void user_enters_librarian_password() {
        loginPage.passwordBox.sendKeys("qU9mrvur"+ Keys.ENTER);
    }

    @Then("user should see the dashboard")
    public void user_should_see_the_dashboard() {
        Assert.assertTrue(dashboardPage.userAvatar.isDisplayed());
    }

    @When("user enters student username")
    public void user_enters_student_username() {
        loginPage.emailBox.sendKeys("student1@library");
    }

    @When("user enters student password")
    public void user_enters_student_password() {
        loginPage.passwordBox.sendKeys("d5fv9BtX"+ Keys.ENTER);
    }

    @When("user enters librarian username {string}")
    public void user_enters_librarian_username(String userName) {
        loginPage.emailBox.sendKeys(userName);
    }

    @When("user enters librarian password {string}")
    public void user_enters_librarian_password(String password) {
        loginPage.passwordBox.sendKeys(password+Keys.ENTER);
    }

    @When("user enters student username {string}")
    public void user_enters_student_username(String userName) {
        loginPage.emailBox.sendKeys(userName);
    }

    @When("user enters student password {string}")
    public void user_enters_student_password(String password) {
        loginPage.passwordBox.sendKeys(password+Keys.ENTER);
    }

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        user_is_on_the_login_page();
    }

    @When("I login using {string} and {string}")
    public void i_login_using_and(String userName, String password) {
        loginPage.emailBox.sendKeys(userName);
        loginPage.passwordBox.sendKeys(password+Keys.ENTER);
    }

    @Then("dashboard should be displayed")
    public void dashboard_should_be_displayed() {
        user_should_see_the_dashboard();
    }

    @Then("there should be {int} {string}")
    public void there_should_be(Integer int1, String string) {
        BrowserUtils.sleep(2);
        String userNumberText = dashboardPage.userCount.getText();
        Assert.assertTrue(Integer.parseInt(userNumberText)==int1);
    }

    @Given("I login as a librarian")
    public void i_login_as_a_librarian() {
        user_enters_librarian_username();
        user_enters_librarian_password();
    }

    @Given("I click on {string} link")
    public void i_click_on_link(String string) {
        dashboardPage.usersButton.click();
    }

    @Then("table should have following column names:")
    public void table_should_have_following_column_names(List<String> expectedColumnNames) {
        List<String> actualColumnNames = BrowserUtils.getElementsText(usersPage.columnNames);
        Assert.assertEquals(actualColumnNames,expectedColumnNames);
    }




}
