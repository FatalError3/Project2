package sample.Test;

import sample.Keygen;
import org.junit.Test;
import sample.PrimeNumber;

import static junit.framework.Assert.*;
import static org.mockito.Mockito.*;


public class KeygenTest {
    @Test
    public void test_gsd_5and7res1() throws Exception {
        int t = Keygen.gcd(5, 7);
        assertEquals(1, t);
    }

    @Test
    public void test_gsd_500and625res125() throws Exception {
        int t = Keygen.gcd(500, 625);
        assertEquals(125, t);
    }

    @Test
    public void test_gsd_minus500and625res125() throws Exception {
        int t = Keygen.gcd(-500, 625);
        assertEquals(125, t);
    }

    @Test
    public void test_gsd_625and0res625() throws Exception {
        int t = Keygen.gcd(625, 0);
        assertEquals(625, t);
    }

    @Test
    public void test_InitialiseKeygen() throws Exception {
    }

}
