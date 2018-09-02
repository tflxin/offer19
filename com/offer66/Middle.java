package com.offer66;

import java.util.LinkedList;

public class Middle {
    LinkedList<Integer> list = new LinkedList<Integer>();
    public void Inser(Integer num){
        if (list.size()==0|| num<list.getFirst()){
            list.addFirst(num);
        } else {
            boolean insertFlag = false;
            for (Integer e:list){
                if (num<e){
                    int index = list.indexOf(e);
                    list.add(index,num);
                    insertFlag = true;
                    break;
                }
            }
            if (!insertFlag){
                list.addLast(num);
            }
        }
    }

   public Double GetMedian(){
        if (list.size()==0){
            return null;
        }
        if (list.size()%2==0){
            int i = list.size()/2;
            Double a = Double.valueOf(list.get(i-1)+list.get(i));
            return a/2;
        }
       list.get(0);
       Double b = Double.valueOf(list.get((list.size() + 1) / 2 - 1));
       return Double.valueOf(list.get((list.size() + 1) / 2 - 1));

   }
    /**
     * 插入有两种思路：
     * 1：直接插入大堆中，之后若两堆尺寸之差大于1(也就是2)，则从大堆中弹出堆顶元素并插入到小堆中
     * 若两队之差不大于1，则直接插入大堆中即可。
     * 2：奇数个数插入到大堆中，偶数个数插入到小堆中，
     * 但是 可能会出现当前待插入的数比小堆堆顶元素大，此时需要将元素先插入到小堆，然后将小堆堆顶元素弹出并插入到大堆中
     * 对于偶数时插入小堆的情况，一样的道理。why?
     * 因为要保证最大堆的元素要比最小堆的元素都要小。
     * @param num
     */
/** import java.util.PriorityQueue;
     import java.util.Comparator;
     public class Solution {
     private int count = 0;  // 数据流中的数据个数
 // 优先队列集合实现了堆，默认实现的小根堆
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
 // 定义大根堆，更改比较方式
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(15, new Comparator<Integer>() {
    @Override
public int compare(Integer o1, Integer o2) {
return o2 - o1;     // o1 - o2 则是小根堆
}
});
 public void Insert(Integer num) {
 if ((count & 1) == 0) {
 // 当数据总数为偶数时，新加入的元素，应当进入小根堆
 // （注意不是直接进入小根堆，而是经大根堆筛选后取大根堆中最大元素进入小根堆）
 // 1.新加入的元素先入到大根堆，由大根堆筛选出堆中最大的元素
 maxHeap.offer(num);
 int filteredMaxNum = maxHeap.poll();
 // 2.筛选后的【大根堆中的最大元素】进入小根堆
 minHeap.offer(filteredMaxNum);
 } else {
 // 当数据总数为奇数时，新加入的元素，应当进入大根堆
 // （注意不是直接进入大根堆，而是经小根堆筛选后取小根堆中最大元素进入大根堆）
 // 1.新加入的元素先入到小根堆，由小根堆筛选出堆中最小的元素
 minHeap.offer(num);
 int filteredMinNum = minHeap.poll();
 // 2.筛选后的【小根堆中的最小元素】进入小根堆
 maxHeap.offer(filteredMinNum);
 }
 count++;
 }
 public Double GetMedian() {
 // 数目为偶数时，中位数为小根堆堆顶元素与大根堆堆顶元素和的一半
 if ((count & 1) == 0) {
 return new Double((minHeap.peek() + maxHeap.peek())) / 2;
 } else {
 return new Double(minHeap.peek());
 }
 }

 }
 */

}