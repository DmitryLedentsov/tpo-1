package tpo.lab1.function;
import java.lang.Math;
import java.math.BigDecimal;
import java.math.RoundingMode;
public class Tg{
    static final int MAX_ITERATIONS = 100;
    public static double calculate(double x) {
        if (Double.isNaN(x) || Double.isInfinite(x))
            return Double.NaN;
        if ((x % (Math.PI / 2) == 0 || x % ((3 * Math.PI) / 2) == 0) && x % Math.PI != 0) return Double.NaN;
        x %= Math.PI;
        BigDecimal cos = new BigDecimal(1);
        BigDecimal sin = new BigDecimal(x);
        BigDecimal nextCos = new BigDecimal(1);
        BigDecimal nextSin = new BigDecimal(x);
        int i = 1;

        while (
                nextCos.doubleValue()!=0 &&
                nextSin.doubleValue()!=0 &&
                i<MAX_ITERATIONS
            ) {
            nextCos = nextCos.multiply(new BigDecimal(x).pow(2).divide(new BigDecimal(2 * i * (2 * i - 1)), 1000 , RoundingMode.HALF_UP)).negate();
            nextSin = nextSin.multiply(new BigDecimal(x).pow(2).divide(new BigDecimal(2 * i * (2 * i + 1)), 1000 , RoundingMode.HALF_UP)).negate();

            cos = cos.add(nextCos);
            sin = sin.add(nextSin);
            i++;
        }

        return sin.divide(cos,1000, RoundingMode.HALF_UP).doubleValue();
    }
}
