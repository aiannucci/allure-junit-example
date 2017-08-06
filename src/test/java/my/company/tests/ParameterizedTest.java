package my.company.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Parameterized.class)
public class ParameterizedTest {

    @Parameter
    public int first;

    @Parameter(1)
    public int second;

    @Parameter(2)
    public long result;

    @Parameters
    public static List<Object[]> getData() {
        return Arrays.asList(new Object[]{1, 2, 2}, new Object[]{2, 4, 8});
    }

    @Test
    public void testMultiplication() {
        assertThat((long) first * second, equalTo(result));
    }

}
