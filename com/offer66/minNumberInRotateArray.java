package com.offer66;

import java.util.Scanner;

public class minNumberInRotateArray {
 public static void main(String [] args){
     Scanner sc = new Scanner(System.in);
     System.out.println("请输入数组长度");
     int x=sc.nextInt();
     int[] array = new int[x];
     System.out.print("请输入数组的元素");
     for (int i=0;i<x;i++){
         array[i]=sc.nextInt();
         System.out.print(array[i]+" ");
         System.out.println();
     }
     System.out.println(minNumberInRotationArray(array));


 }
    public static int minNumberInRotationArray(int[] array){
    int low=0;
    int high=array.length-1;
    while(low<high){
        int mid = (low+high)/2;
        if (array[mid]>array[high]){
            low=mid+1;
        } else if (array[mid]==array[high]){
            high=high-1;
        }else{
            high=mid;
        }
    }
    return array[low];
    }
}
