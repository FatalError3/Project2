package sample.Test;

import sample.PrimeNumber;
import org.junit.Test;
import static junit.framework.Assert.*;


public class PrimeNumberTest {
    @Test
    public void test_isPprime_0_resFalse() throws Exception {
        Boolean t = PrimeNumber.isPprime(0);
        assertFalse(t);
    }

    @Test
    public void test_isPprime_1_resFalse() throws Exception {
        Boolean t = PrimeNumber.isPprime(1);
        assertFalse(t);
    }

    @Test
    public void test_isPprime_5_resTrue() throws Exception {
        Boolean t = PrimeNumber.isPprime(5);
        assertTrue(t);
    }

    @Test
    public void test_isPprime_9199_resTrue() throws Exception {
        Boolean t = PrimeNumber.isPprime(9199);
        assertTrue(t);
    }

    @Test
    public void test_isPprime_9299_resFalse() throws Exception {
        Boolean t = PrimeNumber.isPprime(9299);
        assertFalse(t);
    }

    @Test
    public void test_isPprime_minus9199_resFalse() throws Exception {
        Boolean t = PrimeNumber.isPprime(-9199);    //todo Negative numbers are not simple. Do this, mudila!
        assertFalse(t);
    }
}
