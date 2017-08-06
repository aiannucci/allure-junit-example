package my.company.tests.api;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class SubpackageTest {

    @Test
    public void apiTest() {
        assertThat("true", is("true"));
    }
}
