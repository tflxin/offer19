package com.offer66;

import java.util.ArrayList;
import java.util.Stack;

/**
 * public class ListNode{
 *     int val;
 *     ListNode next = null;
 *     ListNode(int val){
 *         this.val=val;
 *     }
 * }
*/
public class printListFromTail {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode){
        Stack<Integer> stack = new Stack<Integer>();
        if (listNode!=null){
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        while(!stack.isEmpty()){
            arrayList.add(stack.pop());
        }
       return arrayList;
    }
}
