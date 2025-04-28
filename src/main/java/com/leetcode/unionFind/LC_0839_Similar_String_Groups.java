/**
 * Created by Sijia on 2/15/22
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

public class LC_0839_Similar_String_Groups {
    public int numSimilarGroups(String[] A) {
        int len = A.length;
        UnionFind uf = new UnionFind(len);
        for (int i = 0;i < len; i++) {
            for (int j = i+1; j < len; j++) {
                if (isSimilar(A[i], A[j])) {
                    uf.union(i, j);
                }
            }
        }

        return uf.count;
    }

    public boolean isSimilar(String a, String b) {
        int res = 0, len = a.length();
        for (int i = 0; i < len; i++)
            if (a.charAt(i) != b.charAt(i) && ++res > 2)
                return false;
        return true;
    }

}


