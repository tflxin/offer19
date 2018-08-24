package com.offer66;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PrintCenci {
    public ArrayList<ArrayList<Integer>> print(TreeNode head) {
        ArrayList<ArrayList<Integer>> arrs = new ArrayList<ArrayList<Integer>>();
        if (head == null) {
            return arrs;
        }
        ArrayList<Integer> arr = new ArrayList<Integer>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(head);
        TreeNode last = head;
        TreeNode nlast = null;
        while (q.size() != 0) {
            TreeNode tn = q.poll();
            if (tn.left != null) {
                q.add(tn.left);
                nlast = tn.left;
            }
            if (tn.right != null) {
                q.add(tn.right);
                nlast = tn.right;
            }

            arr.add(tn.val);
            if (tn == last) {
                last = nlast;
                arrs.add(arr);
                //把tn这一行一次加入，新建一个存储
                arr = new ArrayList<Integer>();
            }
        }
        return arrs;
    }
}
