package com.offer66;
/**
 * 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，要求不能使用字符串转换整数的库函数。
 * 数值为0或者字符串不是一个合法的数值则返回0。
 */

import java.util.Scanner;

import static com.offer66.main.stringToInt;

/**
 这一题的坑比较多，主要考虑以下几点
 1.字符串的前缀空格需要省略
 2.数字前面出现多个正负号，则判错，返回0，如“++123”，“--123”，“+-123”，“-+123”
 3.连续的数字被其他符号隔开，则返回0，如“   123a321”,"   123    123"，都是返回0
 4.如果超出了int范围（-2147483648--2147483647),返回临界最大值，也就是说如果是负数返回-2147483648，整数则返回2147483647

 *要点： 1. 异常输入和0输入的区分，设置一个全局变量
 2. 正负号的处理
 3. 溢出处理*/


public class StrToInt {
    public static int StrToInt(String str) {
        //对结果的保存
        int result = 0;
        //对符号的标志   1  0 -1    默认为正
        int symbol = 1;
        //判断输入的值是否为0
        boolean isValid = false;
        //对传入的字符串进行转换成数组
        char[] array = str.toCharArray();
        if (array == null || array.length <= 0) {
            return 0;
        }
        //如果输入第一个位为- 则更改标志为-1
        if (array[0] == '-' ) {
            symbol = -1;
        }
        //对正负号的处理需要过滤掉第一位为正负号   直接对符号进行循环前过滤
        for(int i =  (array[0] == '+' || array[0] == '-') ? 1 : 0; i < array.length; i++){
            //对输入内容进行校验输入值不再0-9范围
            if (!('0' <= array[i] && array[i] <= '9') ){
                isValid = true;
                return 0;
            }
            //对得到结果结果处理   //res=res*10+arr[i]-'0'
            result = result * 10  + array[i] - '0';
            //result = (result << 1) + (result  <<3) + (array[i] & 0xf);
            //对溢出进行判断
            if ((symbol == 1 && result > Integer.MAX_VALUE) || (symbol == -1 && result < Integer.MIN_VALUE)) {
                isValid = true;
                return 0;
            }
        }
        return result * symbol;
    }

    public static void main(String[] args) {
       /**
        * 这样输出对于异常有错误
        * try {
             Scanner sc = new Scanner(System.in);
             System.out.println("请输入字符串");
             String str = sc.nextLine();
             sc.close();
             System.out.println(stringToInt(str));
        } catch (Exception e) {
                      e.printStackTrace();
                 }
*/


        // System.out.println(stringToInt("123"));
        // System.out.println(stringToInt("+123"));
        // System.out.println(stringToInt("-123"));
        System.out.println(StrToInt("2a123"));
       // System.out.println(StrToInt("+2147483647"));
        // System.out.println(stringToInt("-2147483647"));
        // System.out.println(stringToInt("+2147483648"));
        // System.out.println(stringToInt("-21474836489999"));

    }
}

