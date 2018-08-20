package com.offer66;

import java.util.Arrays;
import java.util.Comparator;

/**
 * public interface Comparable<T>
 * 此接口强行对实现它的每个类的对象进行整体排序。这种排序被称为类的自然排序，
 * 类的 compareTo 方法被称为它的自然比较方法。
 *
 * 实现此接口的对象列表（和数组）可以通过 Collections.sort
 * （和 Arrays.sort）进行自动排序。实现此接口的对象可以用作
 * 有序映射中的键或有序集合中的元素，无需指定比较器。
 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，
 则打印出这三个数字能排成的最小数字为321323
 */
public class PrintMinNumber {
    public String PrintMinNumber(int[] number){
        if (number == null||number.length==0){
          return "";
        }
        String[] stringNum = new String[number.length];
        for (int i=0;i<number.length;i++){
            stringNum[i] = String.valueOf(number[i]);
        }

        StringBuilder  builder = new StringBuilder();
       //Collections.sort()
        Arrays.sort(stringNum,new Comparator<String>(){
            public int compare(String s1,String s2){
                String strTemp1 = s1+s2;
                String strTemp2 = s2+s1;
                return strTemp1.compareTo(strTemp2);
            }
        });
        for (int j=0;j<stringNum.length;j++){
            builder.append(stringNum[j]);
        }
        return builder.toString();

    }
}
