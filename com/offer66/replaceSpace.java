package com.offer66;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.lang.StringBuffer;

public class replaceSpace {
    public static void main(String[] args){


        StringBuffer str = new StringBuffer();
        BufferedInputStream buff = new BufferedInputStream(System.in);
        //BufferedReader buff = new BufferedReader(new InputStreamReader(SystemInt.in));
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
        System.out.println(replaceSpace(str));

    }

    public static String replaceSpace(StringBuffer str){
        int spacenum = 0;
        for (int i=0;i<str.length();i++){
            if (str.charAt(i)==' '){
                spacenum++;
            }
        }
        int newlength = str.length()+spacenum*2;
        int olderIndex = str.length()-1;
        int newIndex = newlength-1;
        str.setLength(newlength);
        for(;olderIndex<newIndex&&olderIndex>=0;olderIndex--){
            if(str.charAt(olderIndex)==' '){
                str.setCharAt(newIndex--,'0');
                str.setCharAt(newIndex--,'2');
                str.setCharAt(newIndex--,'%');
            } else {
                str.setCharAt(newIndex--,str.charAt(olderIndex));
            }
        }
        return  str.toString();

    }
 }
