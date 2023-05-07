package dataProviders;

import managers.FileReaderManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitProviders {

    private WebDriver driver;
    private WebDriverWait wait;
    public WaitProviders(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait()));

    }

    public void waitElementIsVisible(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitElementIsClickable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitPageIsLoaded(String url){
        wait.until(ExpectedConditions.urlToBe(url));
    }


}
