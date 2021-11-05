package com.goo.unionFind;

import java.util.Arrays;

public class UnionFind {

  private int row, col, count;
  // count is # of the unique root
  private int[] size;
  private int[] roots;

  UnionFind(int row, int col) {
    this.count = 0;
    this.row = row;
    this.col = col;
    this.size = new int[row * col];
    Arrays.fill(size, 1);
    this.roots = new int[row * col];
    Arrays.fill(roots, -1);
  }

  public int index(int i, int j) {
    return i * col + j;
  }

  public int getCount() {
    return count;
  }

  public boolean find(int idx1, int idx2) {
    return getRoot(idx1) == getRoot(idx2);
    // see if to idx is the same Root
  }

  public void union(int idx1, int idx2) {
    int r1 = getRoot(idx1);
    int r2 = getRoot(idx2);
    if (size[r1] < size[r2]) {
      roots[r1] = r2;
      size[r2] += size[r1];
    } else {
      roots[r2] = r1;
      size[r1] += size[r2];

    }
    this.count--;
    // combine two group
  }

  public int getRoot(int idx) {
    // path compression
    int cur = idx;
    while (roots[cur] != cur) {
      // cur's parent's root is cur's root
      roots[cur] = roots[roots[cur]];
      // move to its parent
      cur = roots[cur];
    }
    // only cur is a root, it's root its itself hence at this point roots[cur] == cur,
    roots[idx] = cur;
    return cur;
  }

  public void create(int idx) {
    if (roots[idx] == -1) {
      roots[idx] = idx;
      size[idx] = 1;
    }
    this.count++;

  }

  public boolean isMember(int idx) {
    return (roots[idx] != -1);
  }
}
