package com.algo;

/**
 * Created by Subramanyam on 03-Dec-2016.
 */
public class StringUtil {

    public static String reverse (String string) {

        char[] chars = string.toCharArray();

        for (int i = 0 ; i < chars.length / 2 ; i++) {
            char t = chars[i];
            chars[i] = chars[chars.length-1-i];
            chars[chars.length-1-i] = t;
        }

        return new String(chars);
    }
}
