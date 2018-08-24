package com.offer66;

public class isSymmetrical {
   public boolean isSymmetrical(TreeNode pRoot){
       if (pRoot == null){
           return true;
       }
       return isSymmertricalHelper(pRoot.left,pRoot.right);
   }

    private boolean isSymmertricalHelper(TreeNode leftNode, TreeNode rightNode) {
     if(leftNode == null){
         return rightNode==null;
     }
     if (rightNode==null){
         return false;
     }
     if (leftNode.val == rightNode.val){
         return isSymmertricalHelper(leftNode.left,rightNode.right)
                 && isSymmertricalHelper(leftNode.right,rightNode.left);
     }
     return false;
   }

}
