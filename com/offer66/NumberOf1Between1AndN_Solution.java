package com.offer66;

/**
 * //check the input
 *   1增长到n的过程中，534的个位从0-9变化了53次，记为round
 *   若个位大于0，1出现的次数为round*1+1
 *   若个位等于0，1出现的次数为round*1
 *   对其它位来说，记每一位的权值为base，位值为weight，该位之前的数是former，
 *   若weight为0，则1出现次数为round*base
 *    若weight为1，则1出现次数为round*base+former+1
 *   若weight大于1，则1出现次数为rount*base+base
 *  */

public class NumberOf1Between1AndN_Solution {
  public static  int NumberOfBetween1AndN(int n){
      if(n<1){
          return 0;
      }
      int count = 0;
      int base = 1;//当前位权值，个位
      int round = n;
      while(round>0){
          int weight = round%10;// 每个数位的基数，个位1,十位10...
          round/=10;// 高位，决定当前位置0-9 出现的次数
          count += round*base;
          //判断当前位1出现的次数
          if(weight==1){
              count+=(n%base)+1;
          } else if (weight>1){
              count+=base;
          }

          base*=10;
      }
      return count;
  }

  public static void main(String[] args){
      int n=678;
      System.out.println(NumberOfBetween1AndN(n));
  }
}