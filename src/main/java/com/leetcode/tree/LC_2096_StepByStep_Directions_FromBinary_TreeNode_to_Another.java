/**
 * Created by Sijia on 1/23/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * Question：
 * https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another/
 * can't use bfs, because we can't do the search by go back to the parent node. so have to use lca
 * find start Path to LCA and find destPath to LCA, then combine those two.
 * <p>
 * https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another/discuss/1737505/Java-simple-implementation-without-any-weird-tricks.-Beats-82
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.leetcode.tree;


import com.leetcode.util.TreeNode;

public class LC_2096_StepByStep_Directions_FromBinary_TreeNode_to_Another {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        // 不用找到node 直接找lca Node
        StringBuilder startPath = new StringBuilder(), destPath = new StringBuilder(), res = new StringBuilder();
        TreeNode lca = findLCA(root, startValue, destValue);
        findPath(lca, startValue, startPath);
        findPath(lca, destValue, destPath);

        // because for start path. this is actually reverse direction
        for (int i = 0; i < startPath.length(); i++) {
            res.append('U');
        }
        res.append(destPath);
        return res.toString();
    }

    private TreeNode findLCA(TreeNode root, int startValue, int destValue) {
        if (root == null || root.val == startValue || root.val == destValue) return root;
        TreeNode left = findLCA(root.left, startValue, destValue);
        TreeNode right = findLCA(root.right, startValue, destValue);
        return left == null ? right : right == null ? left : root;
    }

    private boolean findPath(TreeNode node, int target, StringBuilder sb) {
        // return false when node == null, true when target is found
        if (node == null) return false;
        if (node.val == target) return true;

        // go left:
        sb.append('L');
        boolean goLeft = findPath(node.left, target, sb);
        if (!goLeft) {
            sb.setLength(sb.length() - 1);
        }

        //go right:
        sb.append('R');
        boolean goRight = findPath(node.right, target, sb);
        if (!goRight) {
            sb.setLength(sb.length() - 1);
        }
        return goLeft || goRight;
    }
}
