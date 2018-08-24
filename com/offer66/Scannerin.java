package com.offer66;

import java.util.Scanner;

public class Scannerin {

    public static void main(String[] args){
        // 二、使用Scanner取得一个字符串或一组数字
        System.out.print("输入");
        Scanner scan = new Scanner(System.in);
        String read = scan.nextLine();
        System.out.println("输入数据："+read);

  /*在新增一个Scanner对象时需要一个System.in对象，
    因为实际上还是System.in在取得用户输入。
    Scanner的next()方法用以取得用户输入的字符串；
    nextInt()将取得的输入字符串转换为整数类型；
    同样，nextFloat()转换成浮点型；nextBoolean()转换成布尔型。*/
    }
}
