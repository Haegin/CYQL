package in.haeg.cyql.server;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class MD5Sum {

    public static String hash(String a_Input) {
        MessageDigest md;
        String ret = "";
        try {
            md = MessageDigest.getInstance("MD5");
            md.reset();
            md.update(a_Input.getBytes());
            byte[] messageDigest = md.digest();

            StringBuffer hexString = new StringBuffer();
            for (byte b : messageDigest) {
                hexString.append(Integer.toHexString(0xFF & b));
            }
            ret = hexString.toString();
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        return ret;
    }

}
