package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import dataProviders.WaitProviders;
import managers.FileReaderManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.*;

import static com.codeborne.selenide.Selenide.*;

public class GenericPage {

    private By toast_message = By.cssSelector(".alert");

    public List<String> getToastMessage(){
        List<String> listToastMessages = new ArrayList<String>();
        for (SelenideElement msg: $$(toast_message)) {
            listToastMessages.add(msg.getText());
        }
        return listToastMessages;
    }

    public String getCurrentUrl(){
        return WebDriverRunner.getWebDriver().getCurrentUrl();
    }

    public void navigate(String url){
        open(url);
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }


}
