package p000;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class AbstractCryptoUtils {

    /**
     * Inverts all bytes in the array (XOR with 0xFF).
     */
    public static void invertBytes(byte[] bytes) {
        if (bytes == null) return;
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] ^= 0xFF;
        }
    }

    /**
     * Alias for invertBytes for backward compatibility.
     */
    public static void toggleBytes(byte[] bytes) {
        invertBytes(bytes);
    }

    /**
     * Generates the MD5 hash of the given string.
     *
     * @param input Input string.
     * @return MD5 hash as a lowercase hexadecimal string.
     */
    public static String toMd5(String input) {
        if (input == null) return "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(input.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder(digest.length * 2);
            for (byte b : digest) {
                sb.append(String.format("%02x", b & 0xff));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }
}
