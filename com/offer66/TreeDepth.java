package com.offer66;

import java.util.LinkedList;
import java.util.Queue;

/**
 * //poll 移除并返问队列头部的元素   如果队列为空，则返回null
 * //peek  返回队列头部的元素   如果队列为空，则返回null
 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点
 （含根、叶结点）形成树的一条路径，最长路径的长度为树的深度
 */
public class TreeDepth {
    public int TreeDepth(TreeNode pRoot){
        if (pRoot==null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(pRoot);
        int depth = 0,count = 0, nextcount = 1;
        while(queue.size()!=0){
            TreeNode top = queue.poll();//移除这个点
            count++;
            if(top.left!=null){
                queue.add(top.left);
            }
            if(top.right!=null){
                queue.add(top.right);
            }
            //nextcount记录当前层数子节点
            //count标志当前是否遍历完该层次
            if (count==nextcount){
                nextcount = queue.size();
                count = 0;
                depth++;
            }
        }
        return depth;
    }
}
