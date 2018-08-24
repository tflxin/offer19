package com.offer66;
/**
 * 分析二叉树的下一个节点，一共有以下情况：
 1.二叉树为空，则返回空；
 2.节点右孩子存在，则设置一个指针从该节点的右孩子出发，一直沿着指向左子结点的指针找到的叶子节点即为下一个节点；
 3.节点不是根节点。如果该节点是其父节点的左孩子，则返回父节点；否则继续向上遍历其父节点的父节点，重复之前的判断，返回结果。代码如下：
 27s*/
public class GetNext {
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        TreeLinkNode temp = null;
        if(pNode.next==null){
            //此节点是父节点
            //如果是根节点,返回最左的左叶子节点，如果左叶子节点为空，返回它的父节点
            if(pNode.right!=null){
                temp = pNode.right;
                while(temp.left!=null){
                    temp = temp.left;
                }
                return temp;
            }else{
                return null;
            }
        }
        //第一步判断此节点是父节点的左子节点还是右子节点,还是根节点
        if(pNode.next.left==pNode){
            //如果是父节点的左子节点，判断此节点有没有右儿子
            if(pNode.right!=null) {
                temp = pNode.right;
                while(temp.left!=null){
                    temp = temp.left;
                }
                return temp;
            }else{
                //如果没有右儿子，则返回父节点
                return pNode.next;
            }
        }else{
            //如果是父节点的右儿子，在没有右儿子的情况下，需要判断是在整个树的左边还是在右边
            //判断有没有右儿子,
            if(pNode.right!=null) {
                temp = pNode.right;
                while(temp.left!=null){
                    temp = temp.left;
                }
                return temp;
            }else{
                //在没有右儿子的情况下，需要判断是在整个树的左边还是在右边
                TreeLinkNode node=null;
                TreeLinkNode mark = pNode;
                while(pNode.next!=null){
                    node = pNode;
                    pNode = pNode.next;
                }
                if(node==pNode.left){
                    //如果是左子树
                    return mark.next.next;
                }else{
                    //如果是右子树，则该节点是最后一个叶子节点，则返回null
                    return null;
                }

            }
        }
    }
}