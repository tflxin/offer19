package com.offer66;

import  java.util.Scanner;
/**
 * 每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序
* */
public class Find {

    public static void main(String[] args) {
	// write your code here
        Scanner s=new Scanner(System.in);
        System.out.println("请输入数组行数,列数");
        int target=s.nextInt();
        int x=s.nextInt();
        int y=s.nextInt();
        int [][]array=new int[x][y];//初始化数组
        System.out.println("请输入数组元素");
        for(int i=0;i<x;i++)//循环输入
            for(int j=0;j<y;j++)
               array[i][j]=s.nextInt();
        System.out.println("你输入的数组为");
        for(int i=0;i<x;i++){//循环输出
            for(int j=0;j<y;j++)
                System.out.print(array[i][j]+"\t");
            System.out.println();
        }
         System.out.print(Find(target,array));

    }


    public  static boolean Find(int target,int[][] array){
        int rows = array.length;
        int cols = array[0].length;
        //选择左下角
       int i = rows-1,j = 0;
        while (i>=0&&j<cols){
            if (target<array[i][j]){
                i--;
            } else if (target>array[i][j]){
                j++;
            } else {
                return true;
            }

        }
        return false;
    }
}
