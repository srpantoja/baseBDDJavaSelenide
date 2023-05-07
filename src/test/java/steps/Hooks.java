package steps;

import com.codeborne.selenide.WebDriverRunner;
import cucumber.TestContext;
import io.cucumber.java.*;

public class Hooks {

    static TestContext testContext;
    public Hooks(TestContext context) {
        testContext = context;
    }

    @Before
    public void BeforeSteps() {
		testContext.getWebDriverManager().getDriver();
    }

    @After
    public void AfterSteps() {
        testContext.getWebDriverManager().clearDriver();
    }

    @AfterAll
    public static void AfterAll(){
        WebDriverRunner.closeWebDriver();
    }

}