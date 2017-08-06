package my.company.tests;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.qameta.allure.Issue;
import my.company.steps.WebDriverSteps;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchTest {

    private WebDriverSteps steps;

    @Before
    public void setUp() throws Exception {
        ChromeDriverManager.getInstance().setup();
        steps = new WebDriverSteps(new ChromeDriver());
    }

    @Test
    @Issue("ISSUE-1")
    public void searchTest() throws Exception {
        steps.openMainPage();
        steps.search("Allure framework");
        steps.takeScreenShot();
        steps.quit();
    }
}

