package homeWork.faculty;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by mi on 09.10.2016.
 */
public class JunitTest {

    public class Calculate {
        public int calA(int a, int b) {
            return a * b;
        }
    }


    @Test
    public void testCalc() {
        // Тестируемый класс
        Calculate tester = new Calculate();

        // Проверяемый метод
        assertEquals("10 x 5 must be 50", 50, tester.calA(10, 5));
    }
}