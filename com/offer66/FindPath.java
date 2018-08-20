package com.offer66;

import java.util.ArrayList;

public class FindPath {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
     ArrayList<ArrayList<Integer>> paths = new ArrayList<ArrayList<Integer>>();
    if(root == null){
        return paths;
    }
    ArrayList<Integer> path = new ArrayList<Integer>();
    int sum=0;
        FindPathA(root,target,sum,paths,path);
    return paths;
 }

    private void FindPathA(TreeNode root, int target, int sum, ArrayList<ArrayList<Integer>> paths, ArrayList<Integer> path) {
        if (root==null){
            return;
        }
        sum+=root.val;
        if (root.left==null&&root.right==null){
            if (sum==target){
                path.add(root.val);
                paths.add(new ArrayList<Integer>(path));
                path.remove(path.size()-1);
            }
            return ;
        }
        //如果没到达叶子结点，则继续往下找，找左边，找右边
        path.add(root.val);
        FindPathA(root.left, target, sum, paths, path);
        FindPathA(root.right, target, sum, paths, path);
       //移除最后一个元素啊，深度遍历完一条路径后要回退,
        // 递归到叶子节点如果还没有找到路径，就要回退到父节点继续寻找，依次类推
        path.remove(path.size()-1);
    }
}
