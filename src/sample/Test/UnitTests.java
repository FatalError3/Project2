package sample.Test;

import org.junit.Before;
import sample.Keygen;
import org.junit.Test;
import sample.PrimeNumber;

import static junit.framework.Assert.*;
import static org.mockito.Mockito.*;

public class UnitTests {
    public Keygen keygen;
    public Keygen spyKeygen;

    public PrimeNumber pn;
    public PrimeNumber spyPN;

    @Before
    public void before () throws Exception{
        keygen  = new Keygen();
        spyKeygen = spy(keygen);
        pn = new PrimeNumber();
        spyPN = spy(pn);
    }

    @Test
    public void test_gsd_500and625res125() throws Exception {
        int t = spyKeygen.gcd(500, 625);
        assertEquals(125, t);
        Boolean t1 = spyPN.isPprime(1);
        assertFalse(t1);
        testGsd();
        testPrime();
    }

    public void testGsd (){
        verify(spyKeygen).gcd(500, 625);
    }

    public void testPrime () {
        verify(spyPN).isPprime(1);
    }
}
