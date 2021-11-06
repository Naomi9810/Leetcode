package com.goo.dfs;

/**
 * Order has to from parent to child
 * <p>
 * A top down approach is similar to an in-order traversal. We use a variable length to store the
 * current consecutive path length and pass it down the tree. As we traverse, we compare the current
 * node with its parent node to determine if it is consecutive. If not, we reset the length.
 * <p>
 * Time Complexity: O(N) - N is the number of TreeNodes, need to traverse
 * <p>
 * Space complexity : O(n). The extra space comes from implicit stack space due to recursion. For a
 * skewed binary tree, the recursion could go up to n levels deep.
 */
public class LC_0298_Binary_Tree_Longest_Consecutive_Sequence {

  public int longestConsecutive(TreeNode root) {
    return dfs(root, null, 0);

  }

  private int dfs(TreeNode cur, TreeNode parent, int length) {
    if (cur == null) {
      return length;
    }
    length = (parent != null && cur.val == parent.val + 1) ? length + 1 : 1; // reset
    return Math.max(length, Math.max(dfs(cur.left, cur, length), dfs(cur.right, cur, length)));
  }
}
