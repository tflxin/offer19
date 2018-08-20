package com.offer66;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。

 add       增加一个元索            如果队列已满，则抛出一个IIIegaISlabEepeplian异常
 remove    移除并返回队列头部的元素     如果队列为空，则抛出一个NoSuchElementException异常
 element   返回队列头部的元素          如果队列为空，则抛出一个NoSuchElementException异常
 offer     添加一个元素并返回true   如果队列已满，则返回false
 poll      移除并返问队列头部的元素  如果队列为空，则返回null
 peek      返回队列头部的元素         如果队列为空，则返回null
 put       添加一个元素              如果队列满，则阻塞
 take      移除并返回队列头部的元素
 */
public class PrintFromTopToBottom {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        if(root==null)
            return arrayList;
        //区别：两者都是往队列尾部插入元素，不同的时候，当超出队列界限的时候
        // ，add（）方法是抛出异常让你处理，而offer（）方法是直接返回false
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node =queue.poll();
            if(node.left!=null) {
                queue.offer(node.left);
            }
            if (node.right!=null){
                queue.offer(node.right);
            }
            arrayList.add(node.val);
        }
        return arrayList;
    }
}
