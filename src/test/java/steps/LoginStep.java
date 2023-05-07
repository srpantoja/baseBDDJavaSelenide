package steps;

import cucumber.TestContext;
import data.Login;
import dataProviders.Constants;
import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.LoginPage;

import java.util.ArrayList;
import java.util.List;

public class LoginStep {

    TestContext testContext;
    LoginPage loginPage;
    Login loginContext;
    String locator;


    public LoginStep(TestContext context) {
        locator = "";
        testContext = context;
        loginContext = testContext.getLoginContext();
        loginPage = testContext.getPageObjectManager().getLoginPage();
    }

    @Given("that the user is on the login page")
    public void thatTheUserIsOnTheLoginPage() {
        loginPage.navigateToLogin();
    }

    @When("the user enters a {string} and a {string}")
    public void theUserEntersAValidAndAValid(String email, String password) {
        loginContext.setEmail(email);
        loginContext.setPassword(password);

        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
    }

    @And("clicks on the login button")
    public void clicksOnTheLoginButton() {
        loginPage.clickOnBtnLogin();
    }

    @Then("the system redirects to the main page")
    public void theSystemRedirectsToTheMainPage() {

        Assert.assertEquals(
                Constants.BASE_URL + Constants.LOGGED_URL,
                loginPage.getCurrentUrl()
        );
    }

    @And("displays a welcome message to the user {string}")
    public void displaysAWelcomeMessageToTheUser(String name) {

        loginContext.setName(name);

        List<String> listToastMessage = new ArrayList<String>();
        listToastMessage.add(Constants.TOAST_MESSAGE_LOGIN.replace("?", name));

        int index = 0;

        for (String msg : listToastMessage) {
            Assert.assertEquals(msg, loginPage.getToastMessage().get(index));
            index++;
        }
    }

    @Then("the system displays an error message {string}")
    public void theSystemDisplaysAnErrorMessage(String scenario) {

        List<String> errorMsg = new ArrayList<String>();
        switch (scenario) {
            case "Invalid email":
                errorMsg.add(Constants.TOOLTIP_MESSAGE_INVALID_EMAIL.replace("?", loginContext.getEmail()));
                locator = "TOOLTIP";
                break;
            case "Incomplete email":
                errorMsg.add(Constants.TOOLTIP_MESSAGE_INCOMPLETE_EMAIL.replace("?", loginContext.getEmail()));
                locator = "TOOLTIP";
                break;
            case "Email not registered", "Incorrect password":
                errorMsg.add(Constants.TOAST_MESSAGE_INCORRECT_CREDENTIALS);
                locator = "TOAST";
                break;
            case "Blank email and password":
                errorMsg.add(Constants.TOAST_MESSAGE_MANDATORY_EMAIL);
                errorMsg.add(Constants.TOAST_MESSAGE_MANDATORY_PASSWORD);
                locator = "TOAST";
                break;
            default:
                Assert.fail("scenario is not implemented");
        }

        int index = 0;
        for (String msg : errorMsg) {
            Assert.assertEquals(msg, locator.equals("TOAST") ?
                    loginPage.getToastMessage().get(index) :
                    loginPage.getValidationMessage());
            index++;
        }


    }

    @And("remains on the login page")
    public void remainsOnTheLoginPage() {
        Assert.assertEquals(
                Constants.BASE_URL + Constants.LOGIN_URL,
                loginPage.getCurrentUrl()
        );
    }
}
