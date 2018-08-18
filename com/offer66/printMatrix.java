package com.offer66;

import java.util.ArrayList;
import java.util.Scanner;

public class printMatrix {
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        System.out.println("请输入数组行数,列数");

        int x=s.nextInt();
        int y=s.nextInt();
        int [][]array=new int[x][y];//初始化数组
        System.out.println("请输入数组元素");
        for(int i=0;i<x;i++)//循环输入
            for(int j=0;j<y;j++)
                array[i][j]=s.nextInt();
            System.out.println(printMatrix(array));
    }


    public  static ArrayList<Integer> printMatrix(int [][] matrix) {
      ArrayList<Integer> arrayList = new ArrayList<Integer>();
      if(matrix==null||matrix.length==0){
          return arrayList;
      }
      int rows = matrix.length-1;
      int cols = matrix[0].length-1;
      return printMatrix(0,0,rows,cols,matrix,arrayList);
    }

    private static ArrayList<Integer>  printMatrix(int startrow, int startcol, int endrow, int endcol, int[][] matrix, ArrayList<Integer> arrayList) {
        if(startrow < endrow && startcol < endcol){
            for(int i = startcol; i <= endcol; i++){
                arrayList.add(matrix[startrow][i]);
            }
            for(int j = startrow + 1; j <= endrow; j++){
                arrayList.add(matrix[j][endcol]);
            }
            for(int k = endcol - 1; k >= startcol; k--){
                arrayList.add(matrix[endrow][k]);
            }
            for(int l = endrow - 1; l >= startrow + 1; l--){
                arrayList.add(matrix[l][startcol]);
            }
            arrayList = printMatrix(startrow + 1, startcol + 1, endrow - 1, endcol - 1, matrix, arrayList);
        }else if(startrow == endrow && startcol < endcol){
            for(int i = startcol; i <= endcol; i++){
                arrayList.add(matrix[startrow][i]);
            }
        }else if(startcol == endcol && startrow < endrow){
            for(int i = startrow; i <= endrow; i++){
                arrayList.add(matrix[i][startcol]);
            }
        }else if(startrow == endrow && startcol == endcol){
            arrayList.add(matrix[startrow][startcol]);
        }else{
        }

        return arrayList;
    }
}