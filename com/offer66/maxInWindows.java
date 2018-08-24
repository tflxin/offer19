package com.offer66;

/**
 假设窗口大小为w，
 1、简单的方法：
 遍历数组，从数组第w-1位开始，每次移动一位，并计算窗口w的最大值。
 时间复杂度：
 计算窗口的最大值需O(w)，移动n-w+1次，时间复杂度为O(nw)
 2、最大堆方法:
 构建一个窗口w大小的最大堆，每次从堆中取出窗口的最大值，随着窗口往右滑动，需要将堆中不属于窗口的堆顶元素删除。
 时间复杂度：正常情况下，往堆中插入数据为O(lgw)，如果数组有序，则为O(lgn),因为滑动过程中没有元素从堆中被删除，滑动n-w+1次，复杂度为O(nlgn).
 3、双队列方法：
 最大堆解法在堆中保存有冗余的元素，比如原来堆中元素为[10 5 3]，新的元素为11，则此时堆中会保存有[11 5 3]。其实此时可以清空整个队列，然后再将11加入到队列即可，即只在队列中保持[11]。使用双向队列可以满足要求，滑动窗口的最大值总是保存在队列首部，队列里面的数据总是从大到小排列。当遇到比当前滑动窗口最大值更大的值时，则将队列清空，并将新的最大值插入到队列中。如果遇到的值比当前最大值小，则直接插入到队列尾部。
 每次移动的时候需要判断当前的最大值是否在有效范围，如果不在，则需要将其从队列中删除。由于每个元素最多进队和出队各一次，因此该算法时间复杂度为O(N)。
 */
/**
 解题思路1】暴力法
 //1. 遍历求出每个滑动窗口
 //2. 在每个滑动窗口中求出最大值，记录下来。
 //3. 注意边界情况的处理，如：输入的数组为null，或者为空；滑动窗口的大小为零，或者大于数组长度等。
 */
/**
 import java.util.ArrayList;

 public class Solution {
 public ArrayList<Integer> maxInWindows(int [] num, int size)
 {
 ArrayList<Integer> arr = new ArrayList<Integer>();
 if(num==null || num.length==0 || size==0){
 return arr;
 }
 int len=num.length, inx=0, end=len-1;
 if(size>len){
 return arr;
 }else if(size==len){
 arr.add(maxNum(num, 0, len-1));
 }else{
 for(int i=0; i<len; i++){
 inx = i;
 end = inx+size-1;
 if(end >= len){
 break;
 }else{
 arr.add(maxNum(num, inx, end));
 }
 }
 }
 return arr;
 }

 //求几个值中的最大值
 public int maxNum(int[] num, int inx, int end){
 int max = num[inx];
 for(int i=inx; i<=end; i++){
 if(num[i]>max){
 max = num[i];
 }
 }
 return max;
 }
 }
 */
/**
 【解题思路2】
 //1. 滑动窗口应当是队列，但为了得到滑动窗口的最大值，队列序可以从两端删除元素，因此使用双端队列。
 //2. 对新来的元素k，将其与双端队列中的元素相比较, 前面比k小的，直接移出队列（因为不再可能成为后面滑动窗口的最大值了!
 //3. 前面比k大的X，比较两者下标，判断X是否已不在窗口之内，不在了，直接移出队列。队列的第一个元素是当前滑动窗口中的最大值
 */
import java.util.*;

////法一：借助辅助数组，然后排序找出最大值25
public class maxInWindows {
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(size <= 0 || num.length <= 0)	return list;

        int[] temp = new int[size];
        for(int i = 0;i <= num.length - size;i ++) {
            int j = i;
            int count = 0;	//计数器
            while(count < size) {
                temp[count ++] = num[j ++];
            }

            Arrays.sort(temp);
            list.add(temp[temp.length - 1]);
        }

        return list;
    }
}
/**

 //用一个双端队列，队列第一个位置保存当前窗口的最大值，当窗口滑动一次
 //1.判断当前最大值是否过期
 //2.新增加的值从队尾开始比较，把所有比他小的值丢掉
 //16s 效果分厂好
 public class Solution {
 public ArrayList<Integer> maxInWindows(int [] num, int size)
 {
 ArrayList<Integer> arr = new ArrayList<Integer>();
 if (num == null || size <= 0 || num.length < size)
 return arr;

 Deque<Integer> queue = new LinkedList<>();
 for (int i = 0;i < num.length;i ++){
 while(!queue.isEmpty() && num[i] >= num[queue.getLast()])  //下一个元素大于队尾元素，则移除队尾元素
 queue.pollLast();
 while(!queue.isEmpty() && queue.getFirst() < i - size + 1)	// 队首元素不在滑动窗范围内，则移除队首元素
 queue.pollFirst();
 queue.offerLast(i);   //将元素添加到队尾
 if(i + 1 >= size)  //下一个元素超过滑动窗的范围，则取出滑动窗元素的最大值（队首元素）
 arr.add(num[queue.getFirst()]);
 }

 return arr;
 }
 }*/
