package com.goo.tree;

/**
 * TreeNode structure.
 */
public class TreeNode {

  int val;
  TreeNode left;
  TreeNode right;
  TreeNode parent;

  TreeNode() {
  }

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right, TreeNode parent) {
    this.val = val;
    this.left = left;
    this.right = right;
    this.parent = parent;
  }
}
