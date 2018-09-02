package com.offer66;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 请编写一个程序，按升序对栈进行排序（即最大元素位于栈顶），要求最多只能使用一个额外的栈存放临时数据，
 * 但不得将元素复制到别的数据结构中。
 * 给定一个int[] numbers(C++中为vector&ltint>)，
 * 其中第一个元素为栈顶，请返回排序后的栈。请注意这是一个栈，意味着排序过程中你只能访问到第一个元素。
 */
public class TwoStacksSort {
    public static ArrayList<Integer> twoStacksSort(int[] numbers) {
        int[] helper = new int[numbers.length];
        int n = numbers.length;
        int i = 0, j = n;
        int current;
        while (i < n) {
            current = numbers[i++];
            if (j == n) {
                helper[j--] = current;
            } else if (current <= helper[j]) {
                while (j < n && current > helper[j]) {
                    numbers[i--] = helper[j--];
                }
                helper[--j] = current;
            }
        }
        numbers[0] = helper[n - 1];
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int m = 0; m < n; m++) {
            list.add(helper[n - m - 1]);
        }
        return list;
    }

    public static void main(String[] args) {


            Scanner sc = new Scanner(System.in);

            String[] nums = null;
            nums = sc.nextLine().split(" ");
            int num[] = new int[nums.length];
            for (int i = 0; i < num.length; i++) {
                num[i] = Integer.valueOf(nums[i]);
            }


            System.out.println(twoStacksSort(num));
        }
    }
