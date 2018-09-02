package com.offer66;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，
 * 使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 */
public class FindNumbersWithSum {
    public static ArrayList<Integer> FindNumberWithSum(int[] array,int sum) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        ArrayList<Integer> numbers = new ArrayList<Integer>();
       if(array == null || array.length==0){
           return result;
       }

       int minIndex = 0;
       int maxIndex = array.length-1;
       while(maxIndex>minIndex){
           int sumTemp = array[minIndex]+array[maxIndex];
           if(sumTemp==sum){
               numbers.add(array[minIndex]);
               numbers.add(array[maxIndex]);
               minIndex++;
               maxIndex--;
           } else if (sumTemp<sum){
               minIndex++;
           } else if (sumTemp>sum){
               maxIndex--;
           }
       }
       //打印出两个数字的乘积
        if (numbers.size()>=2){
            result.add(numbers.get(0));
            result.add(numbers.get(1));
        }
        return result;

    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入数组长度和目标");

        int len = sc.nextInt();
        int sum = sc.nextInt();
        int[] array =new int[len];
        System.out.println("请输入数组元素");
        for (int i=0;i<array.length;i++){
           array[i] =sc.nextInt();
        }
        System.out.println("输出数组");
        for (int i=0;i<array.length;i++){
            System.out.print(array[i] + " ");
        }

        System.out.println(FindNumberWithSum(array,sum));

    }
}
