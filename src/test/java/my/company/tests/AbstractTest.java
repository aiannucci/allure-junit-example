package my.company.tests;

import java.util.concurrent.TimeUnit;

import org.junit.Rule;
import org.junit.rules.Timeout;

/**
 * Created by alejandroiannucci on 7/15/17.
 */
public abstract class AbstractTest {

    protected int timeout = 30000;

    @Rule
    public Timeout globalTimeout = new Timeout(timeout, TimeUnit.MILLISECONDS);

}
