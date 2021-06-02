import java.math.*;

public class ExtendedEuclid {
    public static BigInteger[] extendedAlgorithm(BigInteger a, BigInteger b) {
        BigInteger[] ans = new BigInteger[3];   // { gcd, x, y }

        if (b.intValue() == 0) {  /*  If b = 0, then GCD is a  */
            ans[0] = a;
            ans[1] = BigInteger.valueOf(1);
            ans[2] = BigInteger.valueOf(0);
        } else {
            BigInteger q = a.divide(b);                             // a / b
            ans = extendedAlgorithm(b, a.remainder(b));             // gcd(b, a % b)

            BigInteger temp = ans[1].subtract(ans[2].multiply(q));  // temp = y1 - x1 * (b / a) = y1 - x1 * q
            ans[1] = ans[2];                                        // y = x1
            ans[2] = temp;                                          // x = temp
        }
        return ans;
    }

    private static void Diofant(BigInteger a, BigInteger b, BigInteger c, BigInteger[] extEuclid) {
        if (!c.remainder(extEuclid[0]).equals(BigInteger.valueOf(0))) {
            System.out.println("None");
            return;
        }

        BigInteger x0 = extEuclid[1].multiply(c).divide(extEuclid[0]); // x0 = X * (c / gcd)
        BigInteger y0 = extEuclid[2].multiply(c).divide(extEuclid[0]); // y0 = Y * (c / gcd)
        System.out.println(c.toString() + " = " + x0.toString() + "*" + a.toString() + " + " + y0.toString() + "*" + b.toString());

        for (BigInteger k = BigInteger.valueOf(2); k.intValue() < 7; k = k.add(BigInteger.valueOf(1)))
            System.out.println(c.toString() + " = " + x0.add(b.multiply(k)).toString() + "*" + a.toString() + " + " + y0.subtract(a.multiply(k)).toString() + "*" + b.toString());
    }

}
