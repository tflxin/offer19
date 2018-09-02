package com.offer66;

public class Systemin {

   public static void main(String[] args) {
       //一、使用标准 输入串System.in
       //SystemInt.in.read()一次只读入一个字节数据，而我们通常要取得一个字符串或一组数字
       //SystemInt.in.read()返回一个整数
       //必须初始化
       //int read = 0;
       char read = '0';
       System.out.println("输入数据：");
       try {
           //read = SystemInt.in.read();
           read = (char) System.in.read();
       }catch(Exception e){
           e.printStackTrace();
       }
       System.out.println("输入数据："+read);
   }
}
