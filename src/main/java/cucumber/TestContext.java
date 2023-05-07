package cucumber;

import data.Login;
import managers.FileReaderManager;
import managers.PageObjectManager;
import managers.DriverManager;
import pages.LoginPage;

public class TestContext {
    private DriverManager webDriverManager;
    private PageObjectManager pageObjectManager;

    private Login loginContext;

    public TestContext(){
        webDriverManager = new DriverManager();
        pageObjectManager = new PageObjectManager();
        loginContext = new Login();
    }

    public DriverManager getWebDriverManager() {
        return webDriverManager;
    }

    public PageObjectManager getPageObjectManager() {
        return pageObjectManager;
    }

    public Login getLoginContext(){
        return loginContext;
    }

}