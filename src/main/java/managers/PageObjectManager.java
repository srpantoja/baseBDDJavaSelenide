package managers;

import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class PageObjectManager {
    private LoginPage loginPage;
    public PageObjectManager() {

        this.loginPage = new LoginPage();
    }

    public LoginPage getLoginPage(){
        return loginPage != null? loginPage: (loginPage = new LoginPage());
    }

}
