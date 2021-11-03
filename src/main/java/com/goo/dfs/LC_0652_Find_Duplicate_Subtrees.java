package com.goo.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class LC_0652_Find_Duplicate_Subtrees {

  public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
    // first traverse the whole tree to build the map and find the same value treeNode
    Map<Integer, TreeNode> treeNodeMap = new HashMap<>();
    Queue<TreeNode> queue = new LinkedList<>();
    List<TreeNode> res = new ArrayList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      TreeNode cur = queue.poll();
      if (treeNodeMap.containsKey(cur.val) && isDupTrees(cur, treeNodeMap.get(cur.val))) {
        res.add(cur);
        treeNodeMap.remove(cur.val);
      } else {
        treeNodeMap.put(cur.val, cur);
      }
      if (cur.left != null) {
        queue.add(cur.left);
      }
      if (cur.right != null) {
        queue.add(cur.right);
      }
    }
    return res;
  }

  private boolean isDupTrees(TreeNode root1, TreeNode root2) {
    if (root1 == null && root2 == null) {
      return true;
    }
    if (root1 == null || root2 == null) {
      return false;
    }
    if (root1.val != root2.val) {
      return false;
    } else {
      return isDupTrees(root1.left, root2.left) && isDupTrees(root1.right, root2.right);
    }
  }

}
