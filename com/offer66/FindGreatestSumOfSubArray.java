package com.offer66;

public class FindGreatestSumOfSubArray {
      public int FindGreatSumOfSubArray(int[] array){
          if (array==null||array.length==0){
              return -1;
          }
          int result = array[0];
          int sum = array[0];
          for(int i=1;i<array.length;i++){
              if (sum>0){
                  sum+=array[i];
              }else{
                  sum=array[i];
              }
              if(sum>result){
                  result = sum;
              }
          }
          return result;
      }
}
