import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class BinaryPower {
    private static final BigInteger ZERO = BigInteger.valueOf(0);
    private static final BigInteger ONE = BigInteger.valueOf(1);
    private static final BigInteger TWO = BigInteger.valueOf(2);

    public static BigInteger binpow(BigInteger a, BigInteger n) {
        if (n.equals(ZERO)) {
            return BigInteger.ONE;
        }
        if (n.equals(ONE)) {
            return a;
        }
        if (n.mod(TWO).equals(ONE)) {
            return a.multiply(binpow(a, n.subtract(ONE)));
        }

        // n парне
        else {
            BigInteger b = binpow(a, n.divide(TWO));
            return b.multiply(b);
        }
    }
}
