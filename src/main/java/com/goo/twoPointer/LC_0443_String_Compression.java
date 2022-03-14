/**
 * Created by Sijia on 3/12/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.goo.twoPointer;

public class LC_0443_String_Compression {
    public int compress(char[] chars) {
        int j = 0, count = 1, len = chars.length;
        for (int i = 1; i <= len; i++) {
            if (i < len && chars[i-1] == chars[i]) {
                count++;
            } else {
                chars[j++] = chars[i-1];
                if (count > 1) {
                    for (char c: String.valueOf(count).toCharArray()) {
                        chars[j++] = c;
                    }
                }
                count = 1;
            }
        }
        return j;

    }
}
