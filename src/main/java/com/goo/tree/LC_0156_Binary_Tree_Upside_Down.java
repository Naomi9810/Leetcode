/**
 * Created by Sijia on 3/16/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1.
 * <p> 2.
 *
 * https://assets.leetcode.com/uploads/2020/08/29/updown.jpg
 * 在原来的left上面操作 而不在新的new_root 上面 因为原来的铁三角三个值只是交换了位置 val不会改变
 *  原题右tree没有孩子 所以不用换
 * <p> 3.
 */

package com.goo.tree;

public class LC_0156_Binary_Tree_Upside_Down {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        /* left -> root, root -> right, right-> left*/
        if (root == null) return null;
        if (root.left == null && root.right == null) return root;
        TreeNode pre_left = root.left;
        TreeNode new_root = upsideDownBinaryTree(pre_left);

        pre_left.left = root.right;
        pre_left.right = root;
        root.left = null;
        root.right = null;

        return new_root;

    }
}
