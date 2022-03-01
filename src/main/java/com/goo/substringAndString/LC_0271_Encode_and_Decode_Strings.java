/**
 * Created by Sijia on 2/27/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.goo.substringAndString;

import java.util.ArrayList;
import java.util.List;

public class LC_0271_Encode_and_Decode_Strings {
    private static final String DIVIDER = "/";

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String str: strs) {
            sb.append(str.length()).append(DIVIDER).append(str); // append 一个长度
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            int slash = s.indexOf(DIVIDER, i);
            int len = Integer.parseInt(s.substring(i, slash));
            res.add(s.substring(slash + 1, slash + 1 + len));
            i = slash + 1 + len;
        }
        return res;
    }
}
