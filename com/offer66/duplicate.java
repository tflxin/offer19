package com.offer66;

import java.util.Scanner;

/**
   题目要求在O(1)的空间。因此采用哈希表这种解法肯定在空间复杂度上是不符合要求的。
   题目中数组中所以数字都在[0, n-1]区间范围内，因此哈希表的大小为n。
   因此我们实际要做的就是对n个范围为0到n-1的数进行哈希，而哈希表的大小刚好为n。
   对排序算法比较熟悉的同学不难发现这与一种经典的排序算法（基数排序）非常类似。
   而基数排序的时间空间复杂度刚好符合题目要求。因此尝试使用基数排序来解这道面试题。
   */
public class duplicate {
    public static boolean duplicate(int numbers[],int length,int[] duplication){
        if (numbers==null||length==0){
            return false;
        }
        for(int i=0;i<numbers.length;i++){ //判断输入数组的合法性
            if(numbers[i] < 0 || numbers[i] >= numbers.length){
                return false;
            }
        }
        boolean[] flag = new boolean[length];
        for (int i = 0;i<flag.length;i++){
           if(flag[numbers[i]]==true){
               duplication[0] = numbers[i];
               return true;
           }
           flag[numbers[i]] = true;
        }
        return false;
    }


    public static void main(String[] args){
        int[] duplication = new int[1];
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入数组长度");
        int length=sc.nextInt();
        int[] numbers = new int[length];
        for (int i = 0;i<length;i++){
            numbers[i] = sc.nextInt();
        }

        System.out.println(duplicate(numbers,length,duplication));
        System.out.println(duplication[0]);
    }
}
