package my.company.tests;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.Issue;
import io.qameta.allure.Owner;
import io.qameta.allure.Step;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;

public class SimpleTest {

    @Test
    public void simpleTest() throws Exception {
        assertThat(2, is(2));
    }

    @Test
    public void simpleTest2() throws Exception {
        assertThat(2, is(3));
    }

    @Test
    @Ignore("Fails on our CI environment")
    @Issue("JIRA-001")
    public void simpleTest3() throws Exception {
        assertThat("this test", is("accomplishes nothing"));
    }

    @Test
    @Owner("Unscrupulous dev")
    public void simpleTest4() throws Exception {
        throw new RuntimeException("There was a problem building the environment for the test.");
    }

    @Step
    private void checkThat2is2() {
        assertThat(2, is(2));
    }

    @Test
    public void simpleTestWithSteps() throws Exception {
        checkThat2is2();
        Allure.addAttachment("Dynamic attachment", "This is a dynamic attachment");
    }

    @Attachment
    private String makeAttach() {
        return "yeah, 2 is 2";
    }

    @Test
    public void simpleTestWithAttachments() throws Exception {
        assertThat(2, is(2));
        makeAttach();
    }

    @Test
    public void csvAttachmentTest() throws Exception {
        saveCsvAttachment();
    }

    @Attachment(value = "Sample csv attachment", type = "text/csv")
    private byte[] saveCsvAttachment() throws URISyntaxException, IOException {
        URL resource = getClass().getClassLoader().getResource("sample.csv");
        if (resource == null) {
            fail("Couldn't find resource 'sample.csv'");
        }
        return Files.readAllBytes(Paths.get(resource.toURI()));
    }
}
