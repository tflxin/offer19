package com.offer66;

public class IsBalanced {
    private boolean isBalanced = true;
    public boolean isBalanced(TreeNode root){
        getDepth(root);
        return isBalanced;
    }

    private int  getDepth(TreeNode root) {
        if (root==null){
            return 0;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        if (Math.abs(left - right)>1){
            isBalanced = false ;
        }
        return right > left? right+1:left+1;
    }
}
