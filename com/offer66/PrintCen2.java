package com.offer66;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PrintCen2 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        PrintCen2 solution8 = new PrintCen2();
        TreeNode treeNode = solution8.createBinaryTreeByArray(array, 0);
        for (ArrayList list :
                solution8.Print(treeNode)) {
            System.out.println(list);
        }
    }


    /**
     * 层次遍历
     *
     * @param pRoot 根节点
     * @return arrayLists
     */
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        //存放结果
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<ArrayList<Integer>>();
        if (pRoot == null) {
            return arrayLists;
        }
        //使用队列，先进先出
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        //存放每行的列表
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        //记录本层打印了多少个
        int start = 0;
        //记录下层打几个
        int end = 1;
        queue.add(pRoot);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.remove();
            //添加到本行的arrayList
            arrayList.add(temp.val);
            start++;
            //每打印一个节点，就把此节点的下一层的左右节点加入队列，并记录下一层要打印的个数
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
            //判断本层打印是否完成
            if (start == end) {
                //此时的queue中存储的都是下一层的节点，则end即为queue大小
                end = queue.size();
                start = 0;
                //把arrayList添加到结果列表arrayLists中
                arrayLists.add(arrayList);
                //重置arrayList
                arrayList = new ArrayList<Integer>();
            }
        }

        return arrayLists;
    }
    private TreeNode createBinaryTreeByArray(int[] array, int index) {
        TreeNode tn = null;
        if (index < array.length) {
            int value = array[index];
            tn = new TreeNode(value);
            tn.left = createBinaryTreeByArray(array, 2 * index + 1);
            tn.right = createBinaryTreeByArray(array, 2 * index + 2);
            return tn;
        }
        return tn;
    }


    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}

