package com.offer66;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Heap {
    private int count =0;
    private PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(15, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-01;
        }
    });
    public void Insert(Integer num){
        if ((count & 1)==0){
            maxHeap.offer(num);
            int filteredMaxHeap = maxHeap.poll();
            minHeap.offer(filteredMaxHeap);
        } else {
            minHeap.offer(num);
            int filteredMaxHeap = minHeap.poll();
            maxHeap.offer(filteredMaxHeap);
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
