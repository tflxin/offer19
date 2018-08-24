package com.offer66;

import java.io.BufferedInputStream;
import java.io.IOException;

/**
 *第一步翻转句子中所有的字符。比如翻转“I am a student. ”中所有的字符得到”.tneduts a m a I”，
 *此时不但翻转了句子中单词的顺序，连单词内的字符顺序也被翻转了。
 *第二步再翻转每个单词中字符的顺序，就得到了”student. a am I”。这正是符合题目要求的输出。
 */
public class ReverseSentence {
    public static String ReverseSentence(String str){
        if (str==null|| str.length()<2){
            return str;
        }
       char[] array=str.toCharArray();
        reverse(array,0,array.length-1);//逆序后的字符转
       //翻转每个单词中的顺序
        int start = 0;
        int end = 0;
        while(start<end){
             if(array[end]!=' '){
                 if (end==array.length){
                     reverse(array,start,end);
                 }
                 end++;
             } else if (array[end]==' '){
                 reverse(array,start,end-1);
                 end++;
                 start = end;
             }
        }
        return String.valueOf(array);//将其转为字符串类型
    }
      //把尾部的值复古头部，头部的值付给尾部，无返回类型
    private static void  reverse(char[] array, int start, int end) {
      if(array==null||array.length<1|| start<0||end>array.length||start>end){
          return ;
      }
      char temp = ' ';
      while(start < end){
          temp = array[start];
          array[start++] = array[end];
          array[end--] = temp;
      }
    }

    public static void main(String[] args){


        StringBuffer str = new StringBuffer();
        BufferedInputStream buff = new BufferedInputStream(System.in);
        //BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入");
        char inChar;
        try {
            int in = buff.read();
            while (in != -1 && in != '\n') {
                inChar = (char)in;
                str.append(inChar);
                in = buff.read();
            }
            buff.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(str);
        System.out.println(ReverseSentence(str.toString()));

    }

}
