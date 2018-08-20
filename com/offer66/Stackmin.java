package com.offer66;
import java.util.Stack;
public class Stackmin {
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> min = new Stack<Integer>();

    public void push(int node){
        stack.push(node);
        if (min.isEmpty()){
            min.push(node);
        } else {
            min.push((min.peek())>node?node:min.peek());
        }
    }
    public void pop(){
        stack.pop();
        min.pop();
    }

    public int top(){
        return stack.peek();
    }

    public int min(){
        return min.peek();
    }
}
