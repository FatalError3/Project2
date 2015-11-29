package sample.Test;

import sample.Keygen;
import org.junit.Test;
import static junit.framework.Assert.*;


public class KeygenTest {
    @Test
    public void test_gsd_5and7res1() throws Exception {
        int t = Keygen.gcd(5, 7);
        assertEquals(1, t);
    }
}
