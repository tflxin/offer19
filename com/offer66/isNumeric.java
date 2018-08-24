package com.offer66;

/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */
/** 29s

 以下对正则进行解释:
 [\\+\\-]?            -> 正或负符号出现与否
 \\d*                 -> 整数部分是否出现，如-.34 或 +3.34均符合
 (\\.\\d+)?           -> 如果出现小数点，那么小数点后面必须有数字；否则一起不出现
 ([eE][\\+\\-]?\\d+)? -> 如果存在指数部分，那么e或E肯定出现，+或-可以不出现， 紧接着必须跟着整数；或者整个部分都不出现
 */
/**
 public class Solution {
 public boolean isNumeric(char[] str) {
 String string = String.valueOf(str);
 return string.matches("[\\+-]?[0-9]*(\\.[0-9]*)?([eE][\\+-]?[0-9]+)?");
 }
 }
 */

import java.util.Scanner;

/**
 * 【解题思路】
 * //1. 合法的数值可以表示为A[.[B]][e|EC]或者.B[e|EC].
 * //2. 其中A为整数部分，B为小数部分，C为e|E的指数部分。在纯小数的时候，
 * 可能没有整数部分，如小数.123等于0.123，是合法的。所以A部分不是必须的。
 * //3. A和C都是整数，可以带符号，也可不带。B是一个无符号整数。
 */
//剑指offer 版本 20ms,9288
public class isNumeric {
    public static boolean isNumeric_1(char[] str){
        //标记符号，小数点，e 是否出现过
       if (str==null||str.length==0){
           return false;
       }
        boolean sign = false;
        boolean decimal = false;
        boolean hsE = false;
        for(int i = 0;i<str.length;i++){
           //判断是否含有 e
            if (str[i]=='e'||str[i]=='E'){
                if(i==str.length-1){ return false;}
                if (hsE) {  return false;}
                hsE = true;
            } else if (str[i]=='+'||str[i]=='-'){
                //第二次出现必须在e后面
                if (sign & str[i-1]!='e'&&str[i-1]!='E'){return false;}
                //第一次出现+-而且不在开头
                if (!sign &&i>0&& str[i-1]!='e'&&str[i-1]!='E'){return false;}

                sign = true;
            } else if (str[i]=='.'){
                //e后面是不可以有的(如果hsE或者已有.)
                if (hsE||decimal) {return false;}
                decimal = true;
            } else if (str[i]<'0'||str[i]>'9'){return false; }
              //前面所有均不满足，是的了
               return true;
        }
        //所有的位置都判断完了
        return true;
    }
    public static void main(String[] args) {
      try{
          Scanner in = new Scanner(System.in);
          System.out.println("请输入你的信息：");
          String line = in.nextLine();
          System.out.println("信息："+line);
          in.close();

          System.out.println(isNumeric_1(line.toCharArray()));
      }catch(Exception e){
          e.printStackTrace();
      }

    }

}
