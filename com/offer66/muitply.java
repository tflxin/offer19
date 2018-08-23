package com.offer66;

import java.util.Scanner;

public class muitply {
    public static int[] multiply(int[] A) {
        if (A == null) return null;
        int length = A.length;
        int[] B = new int[length];
        B[0] = 1;
        //计算左三角
        for (int i = 1; i < length; i++) {
            B[i] = B[i - 1] * A[i - 1];
        }
        //计算右三角   temp用来记录右三角每一行的值
        int temp = 1;
        for (int i = length - 2; i >= 0; i--) {
            temp *= A[i + 1];
            B[i] *= temp;
        }
        return B;
    }

    public static void main(String[] agrs) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入数组长度");
        int n = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }

        int[] result = multiply(A);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
    }
}

