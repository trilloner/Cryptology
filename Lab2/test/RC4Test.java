import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class RC4Test {

    @Test
    void RPGA() {
        String key = "key";
        String stringToEncrypt = "Hello";
        RC4 rc4 = new RC4(key.getBytes());
        byte[] encrypt = rc4.encrypt(stringToEncrypt.getBytes());
        byte[] result = new byte[]{67, 9 ,88 , -127, 75};
        assertEquals(Arrays.toString(result), Arrays.toString(encrypt));
    }
}
