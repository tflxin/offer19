package com.offer66;


public class deleteDuplication {
   //递归算法
    public ListNode deleteDuplication1(ListNode pHead) {
        if (pHead == null || pHead.next ==null) {
            return pHead;
        }
        ListNode cur;
        //对重复节点进行处理：直到找到不重复的点作为当前点地柜
        if(pHead.val ==pHead.next.val){
            cur = pHead.next;
           //cur指的是当前节点
            while (cur!=null&&cur.val == pHead.val){
                cur = cur.next;
            }
           //只要是cur不满足于pHead相等，那么从当前节点开始判断
            return deleteDuplication1(cur);
        } else{
            //该结点不重复，保留当前节点，从下一个节点开始递归
            pHead.next = deleteDuplication1(pHead.next);
            return pHead;
        }
    }
    /**
     * 1.新建一个头节点，以防第一个节点被删除。
     * 2.保存当前节点上个节点，循环遍历整个链表，如果当前节点的值与下一个节点的值相等，
     * 则将当前节点的值与next.next节点的值比较，直到不相等或者null为止，
     * 最后将当前节点的上个节点pre指向最后比较不相等的节点。
     * 3.如果当前节点与next节点不相等，则直接节点指针全部向后移动一位。
     */
    //循环算法
    public ListNode deleteDuplication2(ListNode pHead) {
      if (pHead == null){
          return null;
      }
      ListNode preNode = null;
      ListNode node = pHead;
      while (node!=null){
          if(node.next!=null && node.val == node.next.val){
              int value = node.val;
              while(node.next!=null&&node.next.val == value){
                  node= node.next;
              }
              if (preNode == null){
                  pHead = node.next;
              } else {
                  preNode.next = node.next;
              }
          } else{
              preNode = node;
          }
          node = node.next;
      }
    return pHead;
    }
}
