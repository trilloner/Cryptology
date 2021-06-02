import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Random;

public class MillerRabin {
    private static final BigInteger ZERO = BigInteger.ZERO;
    private static final BigInteger ONE = BigInteger.ONE;
    private static final BigInteger TWO = new BigInteger("2");
    private static final BigInteger THREE = new BigInteger("3");

    public static boolean isProbablePrime(BigInteger n, int maxIterations) {
        if (n.compareTo(THREE) < 0)            // n > 2
            return true;

        int s = 0;
        BigInteger d = n.subtract(ONE);        // n - 1 = 2^s * d, where d % 2 = 1

        while (d.mod(TWO).equals(ZERO)) {
            s++;
            d = d.divide(TWO);
        }

        for (int i = 0; i < maxIterations; i++) {
            BigInteger a = uniformRandom(TWO, n.subtract(ONE));
            BigInteger x = a.modPow(d, n);    // x = a^d mod n

            if (x.equals(ONE) || x.equals(n.subtract(ONE)))
                continue;

            int r = 0;
            for (; r < s; r++) {
                x = x.modPow(TWO, n);    // x = x^2 mod n

                if (x.equals(ONE))
                    return false;

                if (x.equals(n.subtract(ONE)))
                    break;
            }

            if (r == s)
                return false;
        }
        return true;
    }

    private static BigInteger uniformRandom(BigInteger bottom, BigInteger top) {
        Random rnd = new Random();

        BigInteger res;
        do {
            res = new BigInteger(top.bitLength(), rnd);
        } while (res.compareTo(bottom) < 0 || res.compareTo(top) > 0);
        return res;
    }
}
