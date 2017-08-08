package my.company.tests;

import static io.qameta.allure.SeverityLevel.BLOCKER;
import static io.qameta.allure.SeverityLevel.MINOR;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Flaky;
import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import io.qameta.allure.junit4.DisplayName;
import io.qameta.allure.junit4.Tag;
import io.qameta.allure.junit4.Tags;
import my.company.steps.WebDriverSteps;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

@Epic("Search Engine")
@Feature("Web search")
@Story("As a user, I want to perform a Google search")
@Tags({@Tag("search"), @Tag("portal"), @Tag("basic test")})
public class SearchTest {

    private WebDriverSteps steps;

    @Before
    public void setUp() throws Exception {
        ChromeDriverManager.getInstance().setup();
        steps = new WebDriverSteps(new ChromeDriver());
    }

    @Test
    @TmsLink("12059")
    @Issue("MULE-13179")
    @Severity(BLOCKER)
    @Description("This test exercises a simple search")
    public void searchTest() throws Exception {
        steps.openMainPage();
        steps.search("Allure framework");
        steps.takeScreenShot();
        steps.quit();
    }

    @Test
    @TmsLink("12059")
    @Description("This test searches for the answer to life, the universe and everything")
    @Severity(MINOR)
    public void towelTest() throws Exception {
        steps.openMainPage();
        steps.search("answer to life, the universe and everything");
        steps.takeScreenShot();
        steps.quit();
    }
}

