/**
 * Created by Sijia on 3/13/22
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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC_0187_Repeated_DNA_Sequences {
    public List<String> findRepeatedDnaSequences(String s) {
        if (s == null || s.length() == 0) return new ArrayList<>(); // input validation
        char[] charArr = s.toCharArray();
        Set<String> set = new HashSet<>();
        Set<String> res = new HashSet<>(); // dedup

        for (int i = 0; i + 10 <= s.length(); i++) {
            String sub = s.substring(i, i + 10);
            if (set.contains(sub)) {
                res.add(sub);
            } else {
                set.add(sub);
            }
        }
        return new ArrayList<>(res);
    }
}
