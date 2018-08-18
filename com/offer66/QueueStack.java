package com.offer66;

import java.util.Stack;

public class QueueStack {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node){
        stack1.push(node);
    }
     public int pop(){
        if (stack1.isEmpty()&&stack2.isEmpty()){
            throw new RuntimeException("Queue is Empty");
        }
        if (stack2.isEmpty()){
            if(!stack1.isEmpty()){//当stack2为空，立马从stack1中进去
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();//进一个出一个，先进先出
     }

}
