package com.offer66;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 虑用两个数 small 和 big 分别表示序列的最小值和最大值。
 * 首先把 small 初始化为 1，big 初始化为 2。
 * 如果从 small 到 big 的序列的和大于 s，
 * 我们可以从序列中去掉较小的值，也就是增大 small 的值。
 * 如果从 small 到 big 的序列的和小于 s，我们可以增大 big，
 * 让这个序列包含更多的数字。因为这个序列至少要有两个数字，我们一直增加 small 到(1+s)/2 为止。
 */
public class FindContinuousSequence {
   public ArrayList<ArrayList<Integer>> FindCount(int sum){

           ArrayList<ArrayList<Integer>> aList=new ArrayList<ArrayList<Integer>>();
           if(sum<2)
               return aList;
           for(int i=1;i<=sum/2;i++){
               ArrayList<Integer> aList2=new ArrayList<Integer>();
               int count=0;
               for(int j=i;j<sum;j++){
                   count+=j;
                   aList2.add(j);
                   if(count>sum)
                       break;
                   else if(count==sum){
                       aList.add(aList2);
                       break;
                   }
               }
           }

           return aList;

       }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入目标数字");
       int sum = sc.nextInt();
        FindContinuousSequence test = new  FindContinuousSequence();

        System.out.println(test.FindCount(sum));
    }
}

