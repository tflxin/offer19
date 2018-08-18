package com.offer66;

public class NumberOf {
    public int NumberOf1(int n){
        int count=0;
        while(n!=0){
            count++;
            n=(n-1)&n;
        }
        return count;
    }
    /**
     * 移位运算
     * public int NumberOf1(int n){
     *         int count=0;
     *        flag =1;
     *        while(flag!=0)}{
     *            if(n&flag!=0){
     *                count++;
     *            }
     *            flag=flag<<1;
     *        }
     *        return count;
     * }
     */
}
