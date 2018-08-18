package com.offer66;



/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构
 */
public class HasSubTree {
    public boolean HasSubree(TreeNode root1,TreeNode root2){
        if (root1==null){
            return false;
        }
        if (root2==null){
            return false;
        }
        boolean flag=false;
       //如果根节点相等，那判断其是否为二叉树
        if(root1.val==root2.val){
           //定义的新方法
            flag = isSubTree(root1,root2);//这个当前节点不是的，那么判断其左右
        }
        //如果不是，看左侧（调用主方法）---若不是看右侧是不是--返回flage；
        if(!flag){
            flag = HasSubree(root1.right,root2);
            if(!flag){
                flag = HasSubree(root2.left,root2);
            }
        }
        return flag;

    }
     //根节点相等，那么接着判断其左右子节点是否也是相等的。递归的方法
    private boolean isSubTree(TreeNode root1, TreeNode root2) {
     if(root2==null) return true;
     if(root1==null&&root2!=null){return false;}
     if (root1.val==root2.val){
         return isSubTree(root1.left,root2.left)
                 &&isSubTree(root1.right,root2.right);
       }else {
         return false;
     }
    }
}
