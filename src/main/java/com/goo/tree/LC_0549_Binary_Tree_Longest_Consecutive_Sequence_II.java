package com.goo.tree;

import com.goo.tree.TreeNode;

/**
 * Order not has to from parent to child, reverse direction is so -1 is accepted
 * <p>
 * Time Complexity: O(N) - N is the number of TreeNodes, need to traverse
 * <p>
 * Space Complexity: O(N) - use int[] to keep track both increasing and decreasing max length
 */
public class LC_0549_Binary_Tree_Longest_Consecutive_Sequence_II {
  int max;
  public int longestConsecutive(TreeNode root) {
    dfs(root);
    return max;
  }

  private int[] dfs(TreeNode cur) {
    if (cur == null) {
      return new int[] {0,0}; // {inc, dec}
    }
    int inc = 1, dec = 1;
    if (cur.left != null) {
      int[] left = dfs (cur.left);
      // parent -> child: increasing
      if (cur.left.val - 1 == cur.val) {
        inc = left[0] +1;
      } else if (cur.left.val + 1 == cur.val) {
        dec = left[1] +1;
      }
    }

    if (cur.right !=null) {
      int[] right = dfs (cur.right);
      // parent -> child: increasing
      if (cur.right.val - 1 == cur.val) {
        inc = Math.max(inc, right[0] +1);
      } else if (cur.right.val + 1 == cur.val) {
        dec = Math.max(dec, right[1] +1);
      }
    }

    max = Math.max(max, inc + dec -1);
    return new int[] {inc, dec};
  }
}
