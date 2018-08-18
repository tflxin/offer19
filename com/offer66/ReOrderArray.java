package com.offer66;

public class ReOrderArray {
  public void reOrderArray(int[] array) {
      int[] result = new int[array.length];
      int numOdd=0;
      int numEven=0;
      for(int i=0;i<array.length;i++){
          if (array[i]%2==1){
              numOdd++;
          }
      }
      int indexOdd=0;
      int indexEven =numOdd;
      for (int i=0;i<array.length;i++){
          if(array[i]%2==1){
              result[indexOdd++]=array[i];
          } else {
              result[indexEven++]=array[i];
          }
      }
      for (int i=0;i<array.length;i++){
          array[i]=result[i];
      }
  }
}
