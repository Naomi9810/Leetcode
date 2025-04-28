/**
 * Created by Sijia on 3/10/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.leetcode.dfs;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC_0139_Word_Break {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        if (set.contains(s)) return true;

        Boolean[] mem = new Boolean[s.length()];

        for (int i = 0; i < s.length(); i++) {
            String sub = s.substring(0, i);
            if (wordDict.contains(sub) && dfs (i, s, set, mem)) {
                return true;
            }
        }
        return false;
    }

    private boolean dfs(int i, String s, Set<String> set, Boolean[] mem) {
        // need to find substring from i -> end;
        // base case
        if (i == s.length()) return true;

        // add mem
        if (mem[i] != null) {
            return mem[i];
        }

        for (int j = s.length(); j > i; j--) {
            String sub = s.substring(i, j);
            if (set.contains(sub) && dfs(j, s, set, mem)) {
                mem[i] = true;
                return mem[i];
            }
        }
        mem[i] = false;
        return mem[i];
    }

}
