package com.offer66;
/**
 * 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，要求不能使用字符串转换整数的库函数。
 * 数值为0或者字符串不是一个合法的数值则返回0。
 */

/**
 这一题的坑比较多，主要考虑以下几点
 1.字符串的前缀空格需要省略
 2.数字前面出现多个正负号，则判错，返回0，如“++123”，“--123”，“+-123”，“-+123”
 3.连续的数字被其他符号隔开，则返回0，如“   123a321”,"   123    123"，都是返回0
 4.如果超出了int范围（-2147483648--2147483647),返回临界最大值，也就是说如果是负数返回-2147483648，整数则返回2147483647

 边界条件：
 数据上下 溢出
 空字符串
 只有正负号
 有无正负号
 错误标志输出*/

public class StrToInt {
    public static int stringToInt(String num) {
        if (num == null || num.length() < 1) {
            throw new NumberFormatException(num);
        }
        char first = num.charAt(0);
        if (first == '-') {
            return parseString(num, 1, false);
        } else if (first == '+') {
            return parseString(num, 1, true);
        } else if (first <= '9' && first >= '0') {
            return parseString(num, 0, true);
        } else {
            throw new NumberFormatException(num);
        }
    }
    /**
     * 判断字符是否是数字
     * @param c 字符
     * @return true是，false否
     */
    private static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }
    /**
     * 对字符串进行解析
     * @param num      数字串
     * @param index    开始解析的索引
     * @param positive 是正数还是负数
     * @return 返回结果
     */
    private static int parseString(String num, int index, boolean positive) {
        if (index >= num.length()) {
            throw new NumberFormatException(num);
        }
        int result;
        long tmp = 0;
        while (index < num.length() && isDigit(num.charAt(index))) {
            tmp = tmp * 10 + num.charAt(index) - '0';
            // 保证求的得的值不超出整数的最大绝对值
            if (tmp > 0x80000000L) {
                throw new NumberFormatException(num);
            }
            index++;
        }
        if (positive) {
            if (tmp >= 0x80000000L) {
                throw new NumberFormatException(num);
            } else {
                result = (int) tmp;
            }
        } else {
            if (tmp == 0x80000000L) {
                result = 0x80000000;
            } else {
                result = (int) -tmp;
            }
        }
        return result;
    }
    public static void main(String[] args) {

        System.out.println(stringToInt("123"));
       // System.out.println(stringToInt("+123"));
       // System.out.println(stringToInt("-123"));
        //System.out.println(stringToInt("1a123"));
       // System.out.println(stringToInt("+2147483647"));
       // System.out.println(stringToInt("-2147483647"));
       // System.out.println(stringToInt("+2147483648"));
        System.out.println(stringToInt("-21474836489999"));

    }
}

