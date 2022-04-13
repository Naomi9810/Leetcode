package com.goo.substringAndString;

import java.util.*;

/**
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1. First need sort to make sure the indices is sorted
 * <p> 2. No need to think about the stringbuilder add one by one, just repeat the idx i and use
 * substring
 * <p> 3.
 */
public class LC_0833_Find_And_Replace_in_String {

    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int len = s.length();
        int[] bucket = new int[len];
        Arrays.fill(bucket, -1); // bucket

        for (int i = 0; i < indices.length; i++) {
            bucket[indices[i]] = i;
        }
        StringBuilder sb = new StringBuilder(s);

        for (int i = len-1; i >=0; i--) {
            int j = bucket[i];
            if (j >= 0) {
                String sub = sources[j];
                if (s.substring(i).startsWith(sub)) {
                    sb.replace(i, i + sub.length(), targets[j]);
                }
            }
        }
        return sb.toString();
    }
}
