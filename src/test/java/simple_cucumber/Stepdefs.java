package simple_cucumber;

import business.users.User;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageobjects.MailBoxPage;
import pageobjects.MainPage;
import webdriver.DriverFactory;

public class Stepdefs {

    private DriverFactory driverFactory;
    private WebDriver webDriver;
    private static final String MAIL_RU = "http://www.mail.ru";
    private static final String USER_NAME = "test1";
    private static final User USER = BaseTest.getTestUser(USER_NAME);

    @Before
    public void initDriver() {
        driverFactory = DriverFactory.getInstance("firefox", false);
        webDriver = driverFactory.getDriver();
    }

    @Given("^I navigate to mail page$")
    public void iNavigateToPage() {
        System.out.println("OPEN MAIL PAGE");
        webDriver.get(MAIL_RU);
        MainPage mainPage = new MainPage(webDriver);
        Assert.assertTrue(mainPage.isPageLoaded());
        System.out.println("OPENED SUCCESSFULLY");
    }

    @When("^I fill in credentials and submit$")
    public void iFillInCredentialsAndSubmit() {
        System.out.println("LOGIN TO MAIL");
        MainPage mainPage = new MainPage(webDriver);
        mainPage.loginToMailbox(USER.login, USER.password);
    }

    @Then("^I should login to mailbox$")
    public void i_should_login_to_mailbox() throws InterruptedException {
        System.out.println("VERIFY MAIL PAGE");
        MailBoxPage mailBoxPage = new MailBoxPage(webDriver);
        Assert.assertTrue(mailBoxPage.isPageLoaded(), "Mail page didn't open");
    }

    @After
    public void tearDown() {
        driverFactory.close();
        driverFactory.tearDown();
    }
}