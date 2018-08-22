package com.offer66;

import com.sun.org.apache.xalan.internal.xsltc.compiler.Template;

/**
 * isContinuous
 * 首先把数组排序，再统计数组中0 的个数，最后统计排序之后的数组中相邻数字之间的空缺总数。
 * 如果空缺的总数小于或者等于0 的个数，那么这个数组就是连续的：反之则不连续。
 *最后，我们还需要注意一点： 如果数组中的非0 数字重复出现，则该数组不是连续的。
 *换成扑克牌的描述方式就是如果一副牌里含有对子，则不可能是顺子。
 */
public class isContinuous {
    public static boolean isContinuous(int[] numbers) {
        boolean flag = false;
        //选出5张牌
        if (numbers == null || numbers.length != 5) {
            return false;
        }
        int[] temp = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            temp[i] = numbers[i];
        }
        //对数组进行排序 Arrays.sort(numbers);
        for (int i = 0; i < temp.length; i++) {
            int min = temp[i];
            int index = i;
            for (int j = i + 1; j < temp.length; j++) {
                if (temp[j] < min) {
                    min = temp[i];
                    index = j;
                }
            }
            temp[index] = temp[i];
            temp[i] = min;
        }

        int zeroNum = 0;
        //找出大王
        for (int i = 0; i < temp.length && temp[i] == 0; i++) {
            zeroNum++;
        }
        int count = 0;
        //从非零的地方开始统计数值差
        for (int i = zeroNum; i < temp.length; i++) {
            if (temp[i] == temp[i + 1]) {
                return false;
            }
            count += temp[i + 1] - temp[i] - 1;
        }
        if (count <= zeroNum) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] numbers1 = {1, 3, 2, 5, 4};
        System.out.println(isContinuous(numbers1));
        int[] numbers2 = {1, 3, 2, 6, 4};
        System.out.println(isContinuous(numbers2));
        int[] numbers3 = {0, 3, 2, 6, 4};
        System.out.println(isContinuous(numbers3));
        int[] numbers4 = {0, 3, 1, 6, 4};

    }
}
