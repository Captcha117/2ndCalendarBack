package io.oken1.common.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;

import java.util.*;

public class MyUtils {
    public static String myUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
    }

    public static String myShortUUID() {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 7);
        if (Math.random() > 0.5) {
            uuid = uuid.toUpperCase();
        }
        return uuid;
    }

    public static String nvl(String str1, String str2) {
        return str1 == null ? str2 : str1;
    }

    public static String nvl(String str1, String str2, String str3) {
        return str1 == null ? str3 : str2;
    }

    private static final String API_SALT = "xV8v4Qu54lUKrEYFZkJhB8cuOh9Asafs";

    public static String GetDS(Map<String, String> query, String body) {
        String i = "" + System.currentTimeMillis() / 1000;
        String r = MyRandom(6);
        String q = "";
        if (query != null) {
            Set<String> queryKeys = query.keySet();
            List<String> que = new ArrayList<>();
            for (String queryKey : queryKeys) {
                que.add(queryKey + "=" + query.get(queryKey));
            }
            q = StringUtils.join(que, "&");
        }
        String c = DigestUtils.md5Hex("salt=" + API_SALT + "&t=" + i + "&r=" + r + "&b=" + body + "&q=" + q);
        return i + "," + r + "," + c;
    }

    public static String MyRandom(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }

        return sb.toString();
    }

}
