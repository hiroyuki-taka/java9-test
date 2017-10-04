package private_method;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PrivateMethodTest {

    @Test
    void implTest() {
        Sample s1 = new SampleImpl1();
        assertEquals(s1.getId(), 8263L);
        assertEquals(s1.s(), "999");

        Sample s2 = new SampleImpl2();
        assertEquals(s2.getId(), 0L);
        assertEquals(s2.s(), "999");
    }
}
