package my.company.steps;

import static org.openqa.selenium.OutputType.BYTES;

import java.util.function.Function;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * The content of the following class is for demonstration purposes only.
 * In your project you should organize your code in the different way, an
 * example move all the selectors to separate place. Usually better to use
 * some other library to organize access to your service pages such as
 * Yandex HTMLElements.
 *
 * @author Dmitry Baev charlie@yandex-team.ru
 *         Date: 28.10.13
 */
public class WebDriverSteps {

    private WebDriver driver;

    public WebDriverSteps(WebDriver driver) {
        this.driver = driver;
    }

    @Step
    public void openMainPage() {
        driver.get("http://www.google.com");
    }

    @Step
    public void search(String text) {
        driver.findElement(By.id("lst-ib")).sendKeys(text);
        driver.findElement(By.name("btnK")).submit();
        new WebDriverWait(driver, 10)
                .withMessage("Could not load results page")
                .until(mainContainLoaded());
    }

    @Attachment
    @Step("Make screen shot of results page")
    public byte[] takeScreenShot() {
        return ((TakesScreenshot) driver).getScreenshotAs(BYTES);
    }

    public void quit() {
        driver.quit();
    }

    private Function<WebDriver, Boolean> mainContainLoaded() {
        return input -> driver.findElement(By.className("tsf-p")).isDisplayed();
    }

}
