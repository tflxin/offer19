package com.offer66;

import java.util.LinkedList;
import java.util.List;

public class LastRemaining {
    /**
     思路1:用环形链表.普通链表模拟环形链表，当走到end时，跳到begin。时间复杂度是O(mn),空间复杂度O（n）

     */
    public static int LastRemaining_Solution3(int n, int m) {
        if (n<1||m<1){
            return -1;
        }
        List<Integer> list = new LinkedList<Integer>();
        for (int i = 0;i<n;i++){
            list.add(i);
        }
        // 要删除元素的位置
            int idx = 0;
            // 开始计数的位置
            int start = 0;

            while (list.size() > 1) {

                // 只要移动m-1次就可以移动到下一个要删除的元素上
                for (int i = 1; i < m; i++) {
                    idx = (idx + 1) % list.size(); //
                }
                list.remove(idx);
            }
            return list.get(0);
        }

    /**
     * 思路2：找到递归公式。核心在，第一，序列重排，第二，找到映射函数。这个纯考数学。
     我们知道第一个人(编号一定是m%n-1) 出列之后，剩下的n-1个人组成了一个新的约瑟夫环（以编号为k=m%n的人开始）:
     k  k+1  k+2  ... n-2, n-1, 0, 1, 2, ... k-2并且从k开始报0。
     现在我们把他们的编号做一下转换：
     k     --> 0 k+1   --> 1 k+2   --> 2
     ... k-2   --> n-2 k-1   --> n-1
     变换后就完完全全成为了(n-1)个人报数的子问题，假如我们知道这个子问题的解：
     递推公式
     f[1]=0;
     f[i]=(f[i-1]+m)%i;  (i>1)
     */
    public static int LastRemaining_Solution(int n, int m) {
        if (n == 0 || m == 0) {
            return -1;
        }
        if (n == 1) {
            return 0;
        }
        return (LastRemaining_Solution(n - 1, m) + m) % n;
    }
   /**解题思路1】
    1. 用一个数组标志，记录该位置的小朋友是否不再回到圈中。
    2. 每挑出一位小朋友，就将count–，直到count==0。此时的小朋友就是最后一位。
    */
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

    public static void main(String[] args) {
        int n=5,m=3;
        System.out.println(LastRemaining_Solution2(n, m));
        System.out.println(LastRemaining_Solution(n, m));
        System.out.println(LastRemaining_Solution3(n, m));
    }
}