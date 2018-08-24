package com.offer66;

import java.util.ArrayList;
import java.util.Stack;

/**
 public class TreeNode {
 int val = 0;
 TreeNode left = null;
 TreeNode right = null;
 public TreeNode(int val) {
 this.val = val;
 }
 }
 打印之字形的二叉树，需要两个栈，一个栈从左到右存放节点，一个栈从右到左存放节点，
 一开始先把根节点放到一个ArrayList中，当遍历的顺序是从右到左的时候，
 就按照从右到左的顺序存放到ArrayList中（即先存放右子树，再存放左子树），
 当遍历顺序是从左到右时，存放的顺序是先左子树再右子树，操作结束后该节点出栈
 */
public class PrintZhiZi {
    public ArrayList<ArrayList<Integer>> print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (pRoot == null) {
            return result;
        }
        Stack<TreeNode> oddStack = new Stack<TreeNode>();
        Stack<TreeNode> evenStack = new Stack<TreeNode>();
        int level = 1;
        oddStack.add(pRoot);
        while (!oddStack.empty() || !evenStack.empty()) {
            if (level % 2 == 0) {
                ArrayList<Integer> evenResult = new ArrayList<Integer>();
                while (!evenStack.empty()) {
                    TreeNode node = evenStack.pop();
                    if (node != null) {
                        evenResult.add(node.val);
                        oddStack.push(node.right);
                        oddStack.push(node.left);
                    }
                }
                if (!evenResult.isEmpty()) {
                    result.add(evenResult);
                    level++;
                }
            } else { // 奇数层
                ArrayList<Integer> oddResult = new ArrayList<Integer>();
                while (!oddStack.empty()) {
                    TreeNode node = oddStack.pop();
                    if (node != null) {
                        oddResult.add(node.val);
                        evenStack.push(node.left);
                        evenStack.push(node.right);
                    }
                }
                if (!oddResult.isEmpty()) {
                    result.add(oddResult);
                    level++;
                }
            }
        }

        return result;
    }

}






