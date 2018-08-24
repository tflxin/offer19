package com.offer66;

public class Serialize {
    String Serilize(TreeNode root){
        StringBuilder str = new StringBuilder();

        if (root==null){
            str.append("#"+" ");
            return str.toString();
        }
        //先遍历根节点
        str.append(root.val+ "!");
        str.append(Serilize(root.left));
        str.append(Serilize(root.right));
        return str.toString();
    }

    int index = -1;
    public TreeNode Deserialize(String str){
        String[] strArray = str.split(" ");
        TreeNode headNode = construcTree(strArray,strArray.length);
        return headNode;
    }

    private TreeNode construcTree(String[] strArray, int len) {
      index++;
      if(index>=len){
          return null;
      }
      TreeNode newNode = null;
      if (strArray[index].equals("#")){
          newNode = new TreeNode(Integer.valueOf(strArray[index]));
          newNode.left = construcTree(strArray,len);
          newNode.right = construcTree(strArray,len);
      }
        return newNode;
    }
}
