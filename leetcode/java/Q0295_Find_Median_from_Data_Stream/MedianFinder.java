package Q0295_Find_Median_from_Data_Stream;

import java.util.PriorityQueue;
import java.util.Queue;

class MedianFinder {
    private Queue<Integer> small = new PriorityQueue<Integer>();
    private Queue<Integer> large = new PriorityQueue<Integer>();

    /** initialize your data structure here. */
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        large.add(num);
        small.add(-large.poll());
        if (large.size() < small.size()) {
            large.add(-small.poll());
        }
    }
    
    public double findMedian() {
        if (large.size() > small.size()) {
            return large.peek();
        } else {
            return (large.peek() - small.peek()) / 2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */