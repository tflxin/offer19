package com.offer66;

public class LastRemaining {
    public static int LastRemaining_Solution(int n, int m) {
        if (n == 0 || m == 0) {
            return -1;
        }
        if (n == 1) {
            return 0;
        }
        return (LastRemaining_Solution(n - 1, m) + m) % n;
    }

    public static int LastRemaining_Solution2(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        int[] array = new int[n];
        int i = -1, step = 0, count = n;
        while (count > 0) {
            i++;
            if (array[i % n] == -1) {
                continue;
            }
            step++;
            if (step == m) {
                array[i % n] = -1;//将标志位设为-1 接着走
                step = 0;
                count--;
            }
        }
        //count=0 时候返回最后一个是
        return i % n;
    }

    private static void test01() {
        System.out.println(LastRemaining_Solution2(5, 3));
        System.out.println(LastRemaining_Solution(5, 3));
    }
}