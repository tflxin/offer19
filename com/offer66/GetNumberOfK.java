package com.offer66;


  /**
   * 统计一个数字在排序数组中出现的次数。
 * 假设我们需要找的数字是k，那么就需要找到数组中的第一个k和最后一个k出现的位置。
 * 如何通过二分查找得到第一个k的位置呢
 * 取数组中间的数字与k作比较，
 * 如果该数字比k大，那么k只能出现在前半部分，那么下一轮只能在前半部分找；
 * 如果该数字比k小，那么k只能出现在后半部分，那么下一轮只能在后半部分找；
 * 如果该数字等于k，需要判断这是不是第一个k，如果该数字的前一个数字不是k，那么该数字就是第一个k，否则需要在前半部分继续寻找第一个k；
 * 寻找最后一个k的方法与寻找第一个k的方法一样。*/

public class GetNumberOfK {
    public int GetNumberOfK(int [] array,int k){
        int length = array.length;
        if(length==0){
            return 0;
        }
        int firstK = getFirstK(array,k,0,length-1);
        int lastK = getLastK(array,k,0,length-1);
        if(firstK!=-1&&lastK!=-1){
            return lastK-firstK+1;
        }
        return 0;
    }

      private int getFirstK(int[] array, int k, int leftIndex, int rightIndex) {
            int mid = (leftIndex+rightIndex)/2;
            if(array[mid] > k){
                return getFirstK(array,k,leftIndex,mid-1);
            } else if(array[mid]<k){
                return getFirstK(array,k,mid,rightIndex);
            }else if(mid-1>=0&&array[mid-1]==k){
                return getFirstK(array,k,leftIndex,mid-1);
            } else {
                return mid;
            }
      }
      private int getLastK(int[] array,int k,int leftIndex,int rightIndex){
        int length = array.length;
        int mid = (leftIndex+rightIndex)>>1;
        while(leftIndex<=rightIndex){
            if(array[mid]>k){
                rightIndex = rightIndex-1;
            } else if (array[mid]<k){
                leftIndex = leftIndex+1;
            } else if(mid+1<=rightIndex&&array[mid+1]==k){
                leftIndex=leftIndex+1;
            } else {
                return mid;
            }
            mid = (leftIndex+rightIndex)>>1;
        }
       return -1;}
  }
