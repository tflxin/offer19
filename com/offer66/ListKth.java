package com.offer66;
  class ListNode {
      int val;
      ListNode next = null;
      ListNode(int val){
          this.val = val;
      }
  }
public class ListKth {
    public ListNode FindKthToTail(ListNode head,int k){
       if(head==null||k<=0){
           return null;
       }
        ListNode p1=head;
        ListNode p2=head;
       int count = 0;
       int num=k;

        while(p1!=null){
            p1=p1.next;
           count++;//用来记录链表的长度
            if(k--<1){ //前一个走k步之后，p2开始走
                p2=p2.next;
            }
        }
        if(count<num){
            return null;
        }
        return p2;
    }
}
