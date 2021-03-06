package com.offer66;

public class main {

    /**
     * 题目：实现一个函数stringToInt,实现把字符串转换成整数这个功能，
     * 不能使用atoi或者其他类似的库函数。
     * @param num
     * @return
     */
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
            return 0;
        }
    }
    /**
     * 判断字符是否是数字
     *
     * @param c 字符
     * @return true是，false否
     */
    private static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }
    /**
     * 对字符串进行解析
     *
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
//        SystemInt.out.println(Integer.parseInt(Integer.MIN_VALUE + ""));
//        SystemInt.out.println(0x8000_0000L);
//        SystemInt.out.println(stringToInt(""));
        System.out.println(stringToInt("2a123"));
       /** try {
            Scanner sc = new Scanner(SystemInt.in);
            SystemInt.out.println("请输入字符串");
            String str = sc.nextLine();
            sc.close();
            SystemInt.out.println(stringToInt(str));
        } catch (Exception e) {
            e.printStackTrace();
        }
        */
    }

}

