/**
 * Created by Sijia on 2/11/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.leetcode.unionFind;

public class LC_990_Satisfiability_of_Equality_Equations {
    int[] uf = new int[26];
    public boolean equationsPossible(String[] equations) {

        for (int i = 0; i < 26; i++) {
            uf[i] = i;
        }

        for (String e: equations) {
            if (e.charAt(1) == '=') {
                int left = e.charAt(0) - 'a';
                int right = e.charAt(3) - 'a';
                uf[findRoot(left)] = findRoot(right);
            }
        }

        for (String e: equations) {
            int left = e.charAt(0) - 'a';
            int right = e.charAt(3) - 'a';
            if (e.charAt(1) == '!' && findRoot(left) == findRoot(right)) {
                return false;
            }
        }
        return true;

    }

    private int findRoot(int x) {
        while (uf[x] != x) {
            uf[x] = uf[uf[x]];
            x = uf[x];
        }
        return x;
    }
}
