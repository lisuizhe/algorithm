package Q0081_Find_Median_from_Data_Stream;

import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    /**
     * @param nums: A list of integers
     * @return: the median of numbers
     */
    public int[] medianII(int[] nums) {
        // write your code here
        Queue<Integer> small = new PriorityQueue<Integer>();
        Queue<Integer> large = new PriorityQueue<Integer>();
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++){
            addNum(nums[i], small, large);
            result[i] = findMedian(small, large);
        }
        return result;
    }
    
    private void addNum(int num, Queue<Integer> small, Queue<Integer> large) {
        large.add(num);
        small.add(-large.poll());
        if (large.size() < small.size()) {
            large.add(-small.poll());
        }
    }
    
    private int findMedian(Queue<Integer> small, Queue<Integer> large) {
        if (large.size() > small.size()) {
            return large.peek();
        } else {
            return -small.peek();
        }
    }
}