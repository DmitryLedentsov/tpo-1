package function;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import tpo.lab1.function.Calculable;
//import tpo.lab1.function.Sec;
import tpo.lab1.function.Tg;

import static java.lang.Math.PI;
import static java.lang.Math.cos;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TgFunctionTest {
   /* private Calculable sec;

    @BeforeEach
    void init() {
        sec = new Sec();
    }
*/
    @ParameterizedTest(name = "{index}. Test tg({0}) on null ")
    @ValueSource(doubles = {
            (PI / 2), (3 * PI) / 2, (PI / 2) + 2 * PI, ((3 * PI) / 2) + (2 * PI),
            -(PI / 2), -(3 * PI) / 2, -(PI / 2) - 2 * PI, -((3 * PI) / 2) - (2 * PI)
    })
    @DisplayName("Test function in not satisfying function scope")
    void checkPiValues(double x) {
        assertTrue(Double.isNaN(Tg.calculate(x)));
    }
    /*
    @ParameterizedTest(name = "{index}. Test sec({0}) in peaks ")
    @ValueSource(doubles = {-2 * PI, -PI, 0, PI, 2 * PI})
    @DisplayName("Test function in peaks")
    void checkPeaks(double x) {
        assertEquals(sec.calculate(x).doubleValue(), 1 / cos(x), 0.00001);
    }

    @ParameterizedTest(name = "{index}. Test sec({0}) in small derivative areas ")
    @ValueSource(doubles = {-5 * PI / 4, -3 * PI / 4, -PI / 4, 3 * PI / 4, 5 * PI / 4})
    @DisplayName("Test function in small derivative areas")
    void checkIntervalsWithSmoothDerivativeChange(double x) {
        assertEquals(sec.calculate(x).doubleValue(), 1 / cos(x), 0.00001);
    }

    @ParameterizedTest(name = "{index}. Test sec({0}) in large derivative areas ")
    @ValueSource(doubles = {-3 * PI / 2 - 10e-10, -3 * PI / 2 + 10e-10,
            -PI / 2 - 10e-10, -PI / 2 + 10e-10,
            PI / 2 - 10e-10, PI / 2 + 10e-10,
            3 * PI / 2 - 10e-10, 3 * PI / 2 + 10e-10,
    })
    @DisplayName("Test function in large derivative areas")
    void checkIntervalsWithSignificantDerivativeChange(double x) {
        assertEquals(sec.calculate(x).doubleValue(), 1 / cos(x), 0.00001);
    }

    /*
        This test will fail due to the small number of harmonics in the series.
        With increasing harmonics (iteration number) to a curtain amount,
        these values can be passed, but the execution time will be too long.
     */
   /* @Disabled
    @ParameterizedTest(name = "{index}. Test sec({0}) in big X values")
    @ValueSource(doubles = {-10e15, 10e15})
    @DisplayName("Test function in big X values")
    void checkBigX(double x) {
        assertEquals(sec.calculate(x).doubleValue(), 1 / cos(x), 0.00001);
    }

    @ParameterizedTest(name = "{index}. Test sec({0}) in small X values")
    @ValueSource(doubles = {-10e-15, 10e-15})
    @DisplayName("Test function in small X values")
    void checkSmallX(double x) {
        assertEquals(sec.calculate(x).doubleValue(), 1 / cos(x), 0.00001);
    }*/
}
