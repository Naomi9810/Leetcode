/**
 * Created by Sijia on 2/15/22
 * Time Complexity:
 * <p>    O(log n)
 *
 * Using link-by-size, any UNION or FIND operation takes O(log n) time in the worst case,
 * where n is the number of elements. Pf. ・The running time of each operation is bounded by the tree height
 * Space Complexity:
 * <p>
 * Hints: UnionFind class for LC_0839
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.goo.unionFind;

public class UnionFind {
    int [] uf, size;
    int count;
    public UnionFind(int len) {
        uf = new int[len];
        size = new int[len];
        for (int i = 0; i < len; i++) {
            uf[i] = i;
            size[i] = 1;
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

        if (size[rx] > size[ry]) {
            uf[ry] = rx;
            size[rx] += size[ry];
        } else {
            uf[rx] = ry;
            size[ry] += size[rx];
        }
        count --;
    }

    public int getCount() {
        return this.count;
    }

}
