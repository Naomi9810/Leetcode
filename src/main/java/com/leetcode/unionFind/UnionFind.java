/**
 * Created by Sijia on 2/15/22
 * Time Complexity:
 * <p>    O(log n)
 *
 * Using link-by-weight, any UNION or FIND operation takes O(log n) time in the worst case,
 * where n is the number of elements. Pf. ・The running time of each operation is bounded by the tree height
 * Space Complexity:
 * <p>
 * Hints: UnionFind class for LC_0839
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.leetcode.unionFind;

public class UnionFind {
    int [] uf, weight;
    int count;
    public UnionFind(int len) {
        uf = new int[len];
        weight = new int[len];
        for (int i = 0; i < len; i++) {
            uf[i] = i;
            weight[i] = 1;
        }
        count = len;
    }

    public int findRoot(int x) {
        while (x != uf[x]) {
            uf[x] = uf[uf[x]];
            x = uf[x];
        }
        return x;
    }

    public void union(int x, int y) {
        int rx = findRoot(x);
        int ry = findRoot(y);

        if (rx == ry) return;

        if (weight[rx] > weight[ry]) {
            uf[ry] = rx;
            weight[rx] += weight[ry];
        } else {
            uf[rx] = ry;
            weight[ry] += weight[rx];
        }
        count --;
    }

    public int getCount() {
        return this.count;
    }

}
