package apoio;

import java.math.BigInteger;
import java.security.MessageDigest;

/*
 * @author fritzzin
 */
public class Encriptar {

    public static String md5(String s) {
        try {
            String senha = "";

            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(s.getBytes(), 0, s.length());

            senha = String.valueOf(new BigInteger(1, m.digest()).toString(16));

            return senha;
        } catch (Exception e) {
            return null;
        }
    }
}
