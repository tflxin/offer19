package com.offer66;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.lang.StringBuffer;
import java.util.Scanner;

public class LeftRotateString {
    public static String LeftRotateString(String str,int n) {

        int length = str.length();
        if(length<=0){
            return "";
        }
        StringBuffer sb = new StringBuffer(str.substring(0, n));
        StringBuffer sb1 = new StringBuffer(str.substring(n, str.length()));
        sb1.append(sb);
        return sb1.toString();
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入数字n");
        int n =sc.nextInt();
        StringBuffer str = new StringBuffer();
        BufferedInputStream buff = new BufferedInputStream(System.in);

        //BufferedReader buff = new BufferedReader(new InputStreamReader(SystemInt.in));
        System.out.println("请输入字符");

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

        System.out.println(str.toString());

        System.out.println(LeftRotateString(str.toString(),n));

    }
    }

