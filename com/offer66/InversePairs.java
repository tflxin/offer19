package com.offer66;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,
 * 求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。
 * 即输出P%1000000007
 思路1：暴力解法，顺序扫描整个数组，每扫描到一个数字的时候，逐个比较该数字和它后面的数字的大小。如果后面的数字比它小，则这两个数字就组成一个逆序对。
 假设数组中含有n个数字，由于每个数字都要和O(n)个数字作比较，因此这个算法的时间复杂度是O(n2)。
 思路2：分治思想，采用归并排序的思路来处理，如下图，先分后治：
 逆序对的总数=左边数组中的逆序对的数量+右边数组中逆序对的数量+左右结合成新的顺序数组时中出现的逆序对的数量；
 总结统计数组逆序对的过程：先把数组分隔成子数组，先统计出子数组内部的逆序对的数目，然后再统计出两个相邻子数组之间的逆序对的数目。
 在统计逆序对的过程中，还需要对数组进行排序，其实这个排序过程就是归并排序的思路。
 */
public class InversePairs {
    public int InversePairs_Solution(int[] array){
    //参考归并排序，在merge过程中计算两个数组中的左数组和右数组之间的逆序对数
    if(array==null||array.length==0){
        return 0;
    }
    int[] helper = new int[array.length];
    int count =InversePairsHelper(array,helper,0, array.length-1);
         return count;
    }

    private int InversePairsHelper(int[] array, int[] helper, int leftIndex, int rightIndex) {
      if(leftIndex==rightIndex){
          return 0;
      }
      int midIndex = leftIndex/2+rightIndex/2;
      int leftCount = InversePairsHelper(array,helper,leftIndex,midIndex);
      int rightCount = InversePairsHelper(array,helper,midIndex+1,rightIndex);
      int minCount = 0;
      int i = midIndex;
      int j = rightIndex;
      int k = rightIndex;
      while(i>=leftIndex&&j>=midIndex){
         if (array[i]>array[j]) {
             helper[k--] = array[i--];
             minCount += j - midIndex;
             if (minCount > 1000000007) {
                 minCount %= 1000000007;
             }
         } else{
                 helper[k--]=array[j--];
             }
         }
         while(j> midIndex){
             helper[k--]= array[j--];
         }
         while(i>=leftIndex){
             helper[k--] = array[j--];
         }
         for (int s = leftIndex;s<rightIndex+1;s++){
             array[s] = helper[s];
         }
         return (leftCount + minCount + rightCount)%1000000007;

    }
}
