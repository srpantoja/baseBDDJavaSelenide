package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import managers.FileReaderManager;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage extends GenericPage {
    private By input_email = By.id("email");
    private By input_password = By.id("senha");
    private By btn_login = By.xpath("//button[text()='Entrar']");

    public void enterEmail(String email) {
        $(input_email)
                .shouldBe(Condition.visible)
                .sendKeys(email);
    }

    public void enterPassword(String password) {
        $(input_password)
                .shouldBe(Condition.visible)
                .sendKeys(password);
    }

    public void clickOnBtnLogin() {
        $(btn_login)
                .shouldBe(Condition.interactable)
                .click();
    }


    public String getValidationMessage() {
        return $(input_email).getAttribute("validationMessage");

    }

    public void navigateToLogin() {
        this.navigate(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
    }
}
