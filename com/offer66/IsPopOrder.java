package com.offer66;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 */
public class IsPopOrder {


    /**
     * 判断出栈序列是否符合指定入栈序列的某一种出栈顺序
     * @param pushA 入栈序列
     * @param popA 出栈序列
     * @return 返回执行结果
     */
     public static  boolean IsPopOrder1(int[] pushA,int[] popA){
       if (pushA==null||popA==null||pushA.length==0||popA.length==0||pushA.length!=pushA.length){
           return false;
       }
       Stack<Integer> stack = new Stack<Integer>();
       int i=0;
       int j=0;
       stack.push(pushA[i++]);
       while (j<popA.length){
           while(stack.peek()!=popA[j]){//当两者不相等时
               if (i==pushA.length){ //如果A已经到末尾，则不匹配
                   return false;
               }
               stack.push(pushA[i++]);//pushA继续入。直到找到与popA【j】相等的
           }
           j++;//将j++,匹配popA下一个
           stack.pop();//抛出匹配的这个值
       }
       //全部匹配完成后，返回stack
       return stack.empty();
    }

   public static  boolean IsPopOrder(int [] pushA,int [] popA) {
       Stack<Integer> stack = new Stack<Integer>();
       int index = 0;
       for(int i=0;i<pushA.length;i++){
           stack.push(pushA[i]);
           while(!stack.empty() && stack.peek() == popA[index] ){
               stack.pop();
               index++;
           }
       }
       return stack.empty();
   }

    public static void main(String[] args){
        //入栈序列
        int[] a = {1,2,3,4,5};
        //出栈序列
        int[] b = {5,4,3,2,1};
       // System.out.println(a);
       // System.out.println(b);
     System.out.println(IsPopOrder(a,b));
        System.out.println(IsPopOrder1(a,b));
    }
}

