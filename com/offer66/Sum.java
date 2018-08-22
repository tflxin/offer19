package com.offer66;

import java.util.Scanner;

public class Sum {
    public static int Sum_Solution(int n){
        int result = n;
        boolean flag = (n > 0) && (result +=Sum_Solution(n - 1)) > 0;
        return result;
    }
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        System.out.println("请输入 n");
        int n = sc.nextInt();
        System.out.println(Sum_Solution(n));
    }
}
