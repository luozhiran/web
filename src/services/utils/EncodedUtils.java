package services.utils;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class EncodedUtils {

    /**
     * 对字符串进行编码
     *
     * @param value
     * @param charset
     * @return
     */
    public static byte[] encoded(String value, Charset charset) {
        if (value == null||value.length() == 0)return new byte[1];
        byte[] bytes = value.getBytes(StandardCharsets.ISO_8859_1);
        return bytes;
    }

    /**
     * 对byte进行解码
     * @param bytes
     * @param charset
     * @return
     */
    public static String decode(byte[] bytes, Charset charset) {
        return new String(bytes, StandardCharsets.UTF_8);
    }
}
