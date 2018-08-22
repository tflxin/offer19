package com.offer66;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> resultsList = new ArrayList<ArrayList<Integer>>();
        //check the input
        if(sum < 0){
            return resultsList;
        }
        int min = 1;
        int max = 2;
        int sumTemp = 0;
        while(max <= (sum / 2)+1 && min < max){
            sumTemp = sumOfList(min,max);
            if(sumTemp == sum){
                ArrayList<Integer> result = new ArrayList<Integer>();
                for(int i = min; i <= max; i++){
                    result.add(i);
                }
                resultsList.add(result);
                min++;
                max++;
            }else if(sumTemp < sum){
                max++;
            }else{
                min++;
            }
        }
        return resultsList;
    }
    public static int sumOfList(int head, int leap){        //计算当前序列的和
        int sum=head;
        for(int i=head+1;i<=leap;i++){
            sum+=i;
        }
        return sum;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入目标数字");
        int sum = sc.nextInt();
       System.out.println(FindContinuousSequence(sum));
    }
}