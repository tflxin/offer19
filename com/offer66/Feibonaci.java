package com.offer66;

import java.util.Scanner;

/**
 *
 * 这个题可以说是迭代（Iteration） VS 递归（Recursion），
 * f(n) = f(n-1) + f(n-2)，第一眼看就是递归啊，
 * 简直完美的递归环境，递归肯定很爽，这样想着关键代码两三行就搞定了，
 * 注意这题的n是从0开始的：
 *return Fibonacci(n-1)+Fibonacci(n-2);
 * 然而并没有什么用，测试用例里肯定准备着一个超大的n来让Stack
 * Overflow，为什么会溢出？因为重复计算，而且重复的情况还很严重，
 */
public class Feibonaci {
  public static void main(String[] agrs){
      Scanner sc=new Scanner(System.in);
      System.out.println("请输入n");
      int n= sc.nextInt();
      System.out.println(Fibonacci( n));

  }
    public static int Fibonacci(int n){
    int preNum = 1;
    int prepreNum = 0;
    int result = 0;
      if (n==0){
        return  0;
    }
    if (n==1){
        return 1;
    }
    for (int i=2;i<n;i++){
        result = preNum+prepreNum;
        prepreNum = preNum;
        preNum = result;
    }
    return result;
  }
}
