package com.leetcode.tree;

import com.leetcode.util.TreeNode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Time Complexity O(N) - N is # the TreeNode
 * <p>
 * Space Complexity O(H + N) - H is the Height of Tree
 * <p>
 * Hints: Top - down dfs return the new shaped tree root
 */
public class LC_1110_Delete_Nodes_Return_Forest {

  public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
    if (root == null) {
      return null;
    }
    // convert the int[] to Set<Integer>
    Set<Integer> deleteSet = new HashSet<Integer>();
    for (Integer i : to_delete) {
      deleteSet.add(i);
    }
    List<TreeNode> res = new ArrayList<>();
    if (!deleteSet.contains(root.val)) {
      res.add(root);
    }
    dfs(root, deleteSet, res);
    return res;
  }

  private TreeNode dfs(TreeNode root, Set<Integer> deleteSet, List<TreeNode> res) {
    // base case:
    if (root == null) {
      return null;
    }
    // reshape: go left and right
    root.left = dfs(root.left, deleteSet, res);
    root.right = dfs(root.right, deleteSet, res);

    // determine current, only root need to be deleted and left right not null we add to res
    int val = root.val;
    // root need to be deleted
    if (deleteSet.contains(val)) {
      if (root.left != null) {
        res.add(root.left);
      }
      if (root.right != null) {
        res.add(root.right);
      }
      // root deleted, root is null
      return null;
    }
    return root;
  }
}
