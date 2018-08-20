package com.offer66;

/**
 *
 求按从小到大的顺序的第N个丑数。
 //要注意，后面的丑数是有前一个丑数乘以2，3，5中的一个得来。因此可以用动态规划去解
 //同时注意一下，题目意思应该是质数因此，而不是因子，因为8的因子有1，2，4，8
 */
public class GetUglyNumber {
    public int GetUrglyNumber_Solution(int index){
        if (index<1){
            return 0;
        }
        if (index==1){
            return 1;
        }
        int[] minIndex = {0,0,0};
        int[] result = new int[index];
        result[0]=1;
        for (int i=1;i<index;i++){
            result[i] = findMin(result[minIndex[0]]*2,result[minIndex[1]]*3,
                    result[minIndex[2]]*5);
            if (result[i]==result[minIndex[0]]*2) minIndex[0]++;
            if (result[i]==result[minIndex[1]]*3 ) minIndex[1]++;
            if (result[i] ==result[minIndex[2]*5] ) minIndex[2]++;
        }
        return result[index-1];
    }
       private  int findMin(int a,int b,int c){
        if(b<a) a=b;
        if (c<a) a=c;
        return a;
       }
}
