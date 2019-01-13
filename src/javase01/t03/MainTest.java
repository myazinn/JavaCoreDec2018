package javase01.t03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private Main myMain;

    @BeforeEach
    void setUp() {
        myMain = new Main();
    }

    @Test
    void testTanFunc() {
        double x = 1.33;
        double result = Math.tan(2 * x) - 3;
        assertEquals(result, Main.tanFunc(x));
    }
}