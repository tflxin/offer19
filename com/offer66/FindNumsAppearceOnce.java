package com.offer66;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class FindNumsAppearceOnce {

    /**
     * 数组中只出现一次的数字
     * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
     * num1,num2分别为长度为1的数组。传出参数
     * 将num1[0],num2[0]设置为返回结果
     */

    public static void main(String[] args) {
        FindNumsAppearceOnce solution37 = new FindNumsAppearceOnce();
        int[] array = {1, 2, 2, 3, 4, 4};
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        solution37.FindNumsAppearOnce_3(array, num1, num2);
        System.out.println(num1[0] + " " + num2[0]);
    }

    /**
     * 位运算 异或
     * 两个不相等的元素在位级表示上必定会有一位存在不同。
     * @param array
     * @param num1
     * @param num2
     */
    public void FindNumsAppearOnce_3(int[] array, int num1[], int num2[]) {
        int length = array.length;
        if (length == 2) {
            num1[0] = array[0];
            num2[0] = array[1];
            return;
        }
        int bitResult = 0;
        for (int i = 0; i < length; ++i) {
            bitResult ^= array[i];
        }
        int index = findFirst1(bitResult);
        for (int i = 0; i < length; ++i) {
            if (isBit1(array[i], index)) {
                num1[0] ^= array[i];
            } else {
                num2[0] ^= array[i];
            }
        }
    }

    /**
     * @param bitResult
     * @return
    */
    private int findFirst1(int bitResult) {
        int index = 0;
        while (((bitResult & 1) == 0) && index < 32) {
            bitResult >>= 1;
            index++;
        }
        return index;
    }

    private boolean isBit1(int target, int index) {
        return ((target >> index) & 1) == 1;
    }


        /**
         * 用HashMap<K,V>保存数组的值，key为数组值，value为布尔型表示是否有重复
         *
         * @param array
         * @param num1
         * @param num2
*/
        public void FindNumsAppearOnce_2(int[] array, int num1[], int num2[]) {
            HashMap<Integer, Boolean> map = new HashMap<Integer,Boolean>();
            for (int i = 0; i < array.length; i++) {
                if (!map.containsKey(array[i])) {
                    map.put(array[i], true);
                } else {
                    map.put(array[i], false);
                }
            }
            int index = 0;//区分是第几个不重复的值
            for (int i = 0; i < array.length; i++) {
                if (map.get(array[i])) {
                    index++;
                    if (index == 1) {
                        num1[0] = array[i];
                    } else {
                        num2[0] = array[i];
                    }
                }
            }
        }

        /**
         * 利用HashSet的元素不能重复，如果有重复的元素，则删除重复元素，如果没有则添加，最后剩下的就是只出现一次的元素
         *
         * @param array
         * @param num1
         * @param num2
         */

         public void FindNumsAppearOnce_1(int[] array, int num1[], int num2[]) {
            HashSet<Integer> set = new HashSet<Integer>();
            for (int i = 0; i < array.length; i++) {
                if (!set.add(array[i])) {
                    set.remove(array[i]);
                }
            }
            Iterator<Integer> iterator = set.iterator();
            num1[0] = iterator.next();
            num2[0] = iterator.next();
        }

}
