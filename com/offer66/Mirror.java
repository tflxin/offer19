package com.offer66;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像
 */
public class Mirror {
    public void Mirror(TreeNode root){
        if (root!=null){
            swap(root);
            Mirror(root.left);
            Mirror(root.right);
        }
    }

    private void swap(TreeNode root) {
    TreeNode node = root.left;
    root.left = root.right;
    root.right = node;
    }
}
