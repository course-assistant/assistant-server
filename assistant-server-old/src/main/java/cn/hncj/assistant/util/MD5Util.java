package cn.hncj.assistant.util;


import org.junit.jupiter.api.Test;

import java.security.MessageDigest;


@SuppressWarnings("unused")
public class MD5Util {

    private static String byteArrayToHexString(byte[] b) {
        StringBuilder resultSb = new StringBuilder();
        for (byte value : b) {
            resultSb.append(byteToHexString(value));
        }
        return resultSb.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0)
            n += 256;
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    // 默认小写
    public static String MD5Encode(String origin, String charset) {
        String resultString = null;
        try {
            resultString = origin;
            MessageDigest md = MessageDigest.getInstance("MD5");
            if (charset == null || "".equals(charset))
                resultString = byteArrayToHexString(md.digest(resultString
                        .getBytes()));
            else
                resultString = byteArrayToHexString(md.digest(resultString
                        .getBytes(charset)));
        } catch (Exception ignored) {
        }
        assert resultString != null;
        return resultString.toLowerCase();
    }

    // 小写
    public static String MD5EncodeLower(String origin, String charset) {
        return MD5Util.MD5Encode(origin, charset).toLowerCase();
    }

    // 小写
    public static String MD5EncodeLower(String origin) {
        String charset = "utf8";
        return MD5Util.MD5Encode(origin, charset).toLowerCase();
    }


    // 大写
    public static String MD5EncodeUpper(String origin, String charset) {
        return MD5Util.MD5Encode(origin, charset).toUpperCase();
    }

    // 大写
    public static String MD5EncodeUpper(String origin) {
        String charset = "utf8";
        return MD5Util.MD5Encode(origin, charset).toUpperCase();
    }

    private static final String[] hexDigits = {"0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};


    @Test
    public void test() {
        String encode = MD5Util.MD5EncodeUpper("MD5加密", "utf8");
        System.out.println(encode);
    }
}
