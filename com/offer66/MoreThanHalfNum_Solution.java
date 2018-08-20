package com.offer66;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 思路二：如果有符合条件的数字，则它出现的次数比其他所有数字出现的次数和还要多。
 在遍历数组时保存两个值：一是数组中一个数字，一是次数。遍历下一个数字时，
 若它与之前保存的数字相同，则次数加1，否则次数减1；若次数为0，则保存下一个数字，
 并将次数置为1。遍历结束后，所保存的数字即为所求。然后再判断它是否符合条件即可。
 想明白了，如果这个数出现的次数超过数组长度的一半时，一定会有两个相同的数相邻，或者最后一个数是出现最多的那个数。{1，3，1，4}，
 此时出现最多的是1但没超过一半，如果要加一个1，必定会与1相邻，或者最后一个数是1.
 */
public class MoreThanHalfNum_Solution {
  public int  MoreThanHalfNum(int[] array){
   if(array==null||array.length==0){
       return 0;
   }
   int result = array[0];
   int count = 1;
   for (int i = 1;i<array.length;i++){
       if (result==array[i]){
           count++;
       } else {
           count--;
           if(count<0){
               result = array[i];
               count = 1;
           }
       }
   }
   count = 0;
   for(int i=0;i<array.length;i++){
       if (array[i]==result)
           count++;
   }
   if(count*2>array.length){
       return result;
   }
   return 0;
  }

}
