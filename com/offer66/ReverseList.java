package com.offer66;

import java.util.Stack;

public class ReverseList {
    public ListNode ReverseList2(ListNode head) {
        if(head==null){
            return null;
        }

        Stack<ListNode> sta = new Stack<ListNode>();
        while(head!=null){
            sta.push(head);
            head = head.next;
        }

        ListNode newhead = sta.pop();       //指针node
        ListNode resulthead = newhead;
        while(!sta.isEmpty()){
            newhead.next = sta.pop();
            newhead = newhead.next;
        }
        newhead.next = null;

        return resulthead;
    }


    public ListNode ReverseList(ListNode head) {

        if(head==null)
            return null;

        ListNode pre = null;
        ListNode next = null;

        while(head!=null){
            next = head.next;
          if (next==null){
              next=head;
          }
            head.next = pre;
            pre = head;
            head = next;
        }

        return pre;
    }

}
