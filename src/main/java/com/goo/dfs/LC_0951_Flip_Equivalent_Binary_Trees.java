package com.goo.dfs;

/**
 * Time Complexity O(min(N1, N2)) - N is the # of TreeNode, need to go through each
 * <p>
 * Space Complexity O(min(N1, N2)) - N is the # of TreeNode, need to go through each
 * <p>
 * Hints: Two cases: flip or not flip
 */
public class LC_0951_Flip_Equivalent_Binary_Trees {

  public boolean flipEquiv(TreeNode root1, TreeNode root2) {
    // base case:
    if (root1 == null && root2 == null) {
      return true;
    }
    if (root1 == null || root2 == null) {
      return false;
    }
    if (root1.val != root2.val) {
      return false;
    }

    return flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right) ||
        flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);
  }
}
