package com.offer66;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 有一个整型数组 arr 和一个大小为 w 的窗口从数组的最左边滑到最右边,
 * 窗口每次向右边滑一个位置。 返回一个长度为n-w+1的数组res，res[i]表示每一种窗口状态下的最大值。
 * 以数组为[4,3,5,4,3,3,6,7]，w=3为例。因为第一个窗口[4,3,5]的最大值为5，第二个窗口[3,5,4]的最大值为5，第三个窗口[5,4,3]的最大值为5。第四个窗口[4,3,3]的最大值为4。第五个窗口[3,3,6]的最大值为6。
 * 第六个窗口[3,6,7]的最大值为7。所以最终返回[5,5,5,4,6,7]。
 * 给定整形数组arr及它的大小n，同时给定w，请返回res数组。保证w小于等于n，同时保证数组大小小于等于500。
 * 测试样例：
 */
public class HuaDongWindows {
    public static int[] slideWindows(int[] arr,int n,int w){
        if (arr==null||w<1||n<w){
            return null;
        }
        LinkedList<Integer> qmax = new LinkedList<Integer>();
        int[] res = new int[n-w+1];
        int index = 0;
        for(int i=0;i<n;i++){
            while(!qmax.isEmpty() && arr[qmax.peekLast()]<=arr[i]){
                qmax.pollLast();
            }
            qmax.addLast(i);//放入的只是下标
            //如果不满足则把前面删了
            if (qmax.peekFirst()==i-w){
                qmax.pollFirst();
            }
            if (i>=w-1){
                res[index++]=arr[qmax.peekFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入数组长度n以及滑动窗口长度w");
        int n = sc.nextInt();
        int w = sc.nextInt();

        int[] array = new int[n];
        System.out.println("请输入数组");
        String str = sc.nextLine();
       for (int i = 0;i<n;i++){
           array[i] = sc.nextInt();
       }
       int[] res = slideWindows(array,n,w);
        for (int i = 0;i<res.length;i++) {
            System.out.print(res[i] + ",");
        }
    }
}
