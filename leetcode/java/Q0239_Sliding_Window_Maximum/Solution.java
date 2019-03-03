package Q0239_Sliding_Window_Maximum;

import java.util.ArrayDeque;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = k-1; i >=0; i--) {
            if (deque.isEmpty() || deque.peekFirst() < nums[i]) {
                deque.offerFirst(nums[i]);
            }   
        }
        int[] results = new int[nums.length-k+1];
        results[0] = deque.peekFirst();
        for (int i = 1; i < nums.length-k+1; i++) {
            if (nums[i-1] == results[i-1]) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && deque.peekLast() < nums[i+k-1]) {
                deque.pollLast();
            }
            deque.offerLast(nums[i+k-1]);
            results[i] = deque.peekFirst();
        }
        return results;
    }
}